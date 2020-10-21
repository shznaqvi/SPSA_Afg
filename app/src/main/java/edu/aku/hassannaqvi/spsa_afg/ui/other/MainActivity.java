package edu.aku.hassannaqvi.spsa_afg.ui.other;

import android.app.ActivityManager;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.models.VersionApp;
import edu.aku.hassannaqvi.spsa_afg.ui.list_activity.FormsReportDate;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section021Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section03Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section04Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section05Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section06Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section07Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section08Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section09Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section10Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section1101Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section12Activity;
import edu.aku.hassannaqvi.spsa_afg.ui.sections.Section13Activity;
import edu.aku.hassannaqvi.spsa_afg.utils.AndroidUtilityKt;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;
import edu.aku.hassannaqvi.spsa_afg.utils.CreateTable;
import edu.aku.hassannaqvi.spsa_afg.utils.WarningActivityInterface;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.appInfo;

public class MainActivity extends AppCompatActivity implements WarningActivityInterface {

    static File file;
    ActivityMainBinding bi;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime());
    String sysdateToday = new SimpleDateFormat("dd-MM-yy", Locale.getDefault()).format(new Date());
    SharedPreferences sharedPrefDownload;
    SharedPreferences.Editor editorDownload;
    DownloadManager downloadManager;
    String preVer = "", newVer = "";
    VersionApp versionApp;
    Long refID;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())) {

                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(sharedPrefDownload.getLong("refID", 0));

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                assert downloadManager != null;
                Cursor cursor = downloadManager.query(query);
                if (cursor.moveToFirst()) {
                    int colIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                    if (DownloadManager.STATUS_SUCCESSFUL == cursor.getInt(colIndex)) {

                        editorDownload.putBoolean("flag", true);
                        editorDownload.commit();

                        Toast.makeText(context, "New App downloaded!!", Toast.LENGTH_SHORT).show();
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Downloaded"));

                        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);

                        if (Objects.requireNonNull(taskInfo.get(0).topActivity).getClassName().equals(MainActivity.class.getName())) {
                            showDialog(newVer, preVer);
                        }
                    }
                }
            }
        }
    };
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);

        Collection<Form> todaysForms = appInfo.getDbHelper().getTodayForms(sysdateToday);
        Collection<Form> unsyncedForms = appInfo.getDbHelper().getUnsyncedForms(0);
        Collection<Form> unclosedForms = appInfo.getDbHelper().getUnclosedForms();

        StringBuilder rSumText = new StringBuilder()
                .append("TODAY'S RECORDS SUMMARY\r\n")
                .append("=======================\r\n")
                .append("\r\n")
                .append("Total Forms Today" + "(").append(dtToday).append("): ").append(todaysForms.size()).append("\r\n");
        String TAG = "MainActivity";
        if (todaysForms.size() > 0) {
            String iStatus;
            rSumText.append("---------------------------------------------------------\r\n")
                    .append("[  Name  ][Ref. No][Form Type][Form Status][Sync Status]\r\n")
                    .append("---------------------------------------------------------\r\n");

            for (Form form : todaysForms) {
                Log.d(TAG, "onCreate: '" + form.getIstatus() + "'");
                switch (form.getIstatus()) {
                    case "1":
                        iStatus = "Complete   ";
                        break;
                    case "2":
                        iStatus = "Incomplete ";
                        break;
                    case "3":
                        iStatus = "Refused    ";
                        break;
                    case "96":
                        iStatus = "Other    ";
                        break;
                    case "":
                        iStatus = "Open     ";
                        break;
                    default:
                        iStatus = "  -N/A-  " + form.getIstatus();
                }

                String form_type = "NA";
                switch (form.getFormType()) {
                    case "1":
                        form_type = "Screening";
                        break;
                    case "2":
                        form_type = "PreTest";
                        break;
                    case "3":
                        form_type = "FollowUp";
                        break;
                }

                rSumText
                        .append((form.getS1q1() + "          ").substring(0, 10))
                        .append((form.getPid() + "      ").substring(0, 6))
                        .append("  \t\t")
                        .append(form_type)
                        .append("  \t")
                        .append(iStatus)
                        .append("\t\t")
                        .append(form.getSynced() == null ? "Not Synced" : "Synced    ")
                        .append("\r\n")
                        .append("---------------------------------------------------------\r\n");
            }
        }
        SharedPreferences syncPref = getSharedPreferences("src", Context.MODE_PRIVATE);
        rSumText.append("\r\nDEVICE INFORMATION\r\n")
                .append("  ========================================================\r\n")
                .append("\t|| Open Forms: \t\t\t\t\t\t").append(String.format("%02d", unclosedForms.size()))
                .append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t||\r\n")
                .append("\t|| Unsynced Forms: \t\t\t\t").append(String.format("%02d", unsyncedForms.size()))
                .append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t||\r\n")
                .append("\t|| Last Data Download: \t\t").append(syncPref.getString("LastDataDownload", "Never Downloaded   "))
                .append("\t\t\t\t\t\t||\r\n")
                .append("\t|| Last Data Upload: \t\t\t").append(syncPref.getString("LastDataUpload", "Never Uploaded     "))
                .append("\t\t\t\t\t\t||\r\n")
                .append("\t|| Last Photo Upload: \t\t").append(syncPref.getString("LastPhotoUpload", "Never Uploaded     "))
                .append("\t\t\t\t\t\t||\r\n")
                .append("\t========================================================\r\n");
        bi.recordSummary.setText(rSumText);

        // Auto download app
        sharedPrefDownload = getSharedPreferences("appDownload", MODE_PRIVATE);
        editorDownload = sharedPrefDownload.edit();
        versionApp = appInfo.getDbHelper().getVersionApp();
        if (versionApp.getVersioncode() != null) {

            preVer = appInfo.getVersionName() + "." + appInfo.getVersionCode();
            newVer = versionApp.getVersionname() + "." + versionApp.getVersioncode();

            if (appInfo.getVersionCode() < Integer.parseInt(versionApp.getVersioncode())) {
                bi.lblAppVersion.setVisibility(View.VISIBLE);

                String fileName = CreateTable.DATABASE_NAME.replace(".db", "-New-Apps");
                file = new File(Environment.getExternalStorageDirectory() + File.separator + fileName, versionApp.getPathname());

                if (file.exists()) {
                    bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " New Version ").append(newVer).append("  Downloaded"));
                    showDialog(newVer, preVer);
                } else {
                    NetworkInfo networkInfo = ((ConnectivityManager) Objects.requireNonNull(getSystemService(Context.CONNECTIVITY_SERVICE))).getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected()) {
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Downloading.."));
                        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse(MainApp._UPDATE_URL + versionApp.getPathname());
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setDestinationInExternalPublicDir(fileName, versionApp.getPathname())
                                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                                .setTitle("Downloading " + getString(R.string.app_name) + " App new App ver." + newVer);
                        refID = downloadManager.enqueue(request);

                        editorDownload.putLong("refID", refID);
                        editorDownload.putBoolean("flag", false);
                        editorDownload.apply();

                    } else {
                        bi.lblAppVersion.setText(new StringBuilder(getString(R.string.app_name) + " App New Version ").append(newVer).append("  Available..\n(Can't download.. Internet connectivity issue!!)"));
                    }
                }

            } else {
                bi.lblAppVersion.setVisibility(View.GONE);
                bi.lblAppVersion.setText(null);
            }
        }
        registerReceiver(broadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

//        Testing visibility
        if (Integer.parseInt(appInfo.getVersionName().split("\\.")[0]) > 0)
            bi.testing.setVisibility(View.GONE);
        else bi.testing.setVisibility(View.VISIBLE);
        bi.admin.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.onSync:
                intent = new Intent(this, SyncActivity.class);
                break;
            case R.id.formsReportDate:
                intent = new Intent(this, FormsReportDate.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void callWarningActivity() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
            startActivity(new Intent(this, LoginActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(() -> exit = false, 3 * 1000);
        }
    }

    private void showDialog(String newVer, String preVer) {
        AppUtilsKt.openWarningActivity(
                this,
                getString(R.string.app_name) + " APP is available!",
                getString(R.string.app_name) + " App Ver." + newVer + " is now available. Your are currently using older Ver." + preVer + ".\nInstall new version to use this app.",
                "Install",
                "Cancel"
        );
    }

    public void openSpecificActivity(View v) {
        Intent oF = null;
        switch (v.getId()) {
            case R.id.sec02:
                oF = new Intent(this, Section021Activity.class);
                break;
            case R.id.sec03:
                oF = new Intent(this, Section03Activity.class);
                break;
            case R.id.sec04:
                oF = new Intent(this, Section04Activity.class);
                break;
            case R.id.sec05:
                oF = new Intent(this, Section05Activity.class);
                break;
            case R.id.sec06:
                oF = new Intent(this, Section06Activity.class);
                break;
            case R.id.sec07:
                oF = new Intent(this, Section07Activity.class);
                break;
            case R.id.sec08:
                oF = new Intent(this, Section08Activity.class);
                break;
            case R.id.sec09:
                oF = new Intent(this, Section09Activity.class);
                break;
            case R.id.sec10:
                oF = new Intent(this, Section10Activity.class);
                break;
            case R.id.sec11:
                oF = new Intent(this, Section1101Activity.class);
                break;
            case R.id.sec12:
                oF = new Intent(this, Section12Activity.class);
                break;
            case R.id.sec13:
                oF = new Intent(this, Section13Activity.class);
                break;
            case R.id.databaseBtn:
                oF = new Intent(this, AndroidDatabaseManager.class);
                break;
            case R.id.uploadData:
                if (!AndroidUtilityKt.isNetworkConnected(this)) {
                    Toast.makeText(this, "No network connection available!", Toast.LENGTH_SHORT).show();
                    return;
                }
                oF = new Intent(this, SyncActivity.class);
                break;
        }
        if (MainApp.userName.equals("0000")) {
            Toast.makeText(this, "Please re-login app.", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(oF);
    }

    public void toggleSummary(View view) {
        if (bi.recordSummary.getVisibility() == View.VISIBLE) {
            bi.recordSummary.setVisibility(View.GONE);
        } else {
            bi.recordSummary.setVisibility(View.VISIBLE);
        }
    }
}
