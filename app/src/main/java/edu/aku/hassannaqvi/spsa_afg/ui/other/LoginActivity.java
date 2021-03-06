package edu.aku.hassannaqvi.spsa_afg.ui.other;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.core.AppInfo;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.utils.AndroidUtilityKt;
import edu.aku.hassannaqvi.spsa_afg.utils.CreateTable;

import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.MINIMUM_DISTANCE_CHANGE_FOR_UPDATES;
import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.MINIMUM_TIME_BETWEEN_UPDATES;
import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE;
import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.TWO_MINUTES;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "test1234:test1234", "testS12345:testS12345", "bar@example.com:world"
    };
    // District Spinner
    public ArrayList<String> lables;
    public ArrayList<String> values;
    public Map<String, String> valuesnlabels;
    // UI references.
    @BindView(R.id.loginProgress)
    ProgressBar mProgressView;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.email1)
    AutoCompleteTextView mEmailView1;
    @BindView(R.id.password1)
    EditText mPasswordView1;
    @BindView(R.id.email2)
    AutoCompleteTextView mEmailView2;
    @BindView(R.id.password2)
    EditText mPasswordView2;
    @BindView(R.id.txtinstalldate)
    TextView txtinstalldate;
    @BindView(R.id.btnSignin)
    Button mEmailSignInButton;


    @BindView(R.id.showPassword2)
    Button showPassword2;
    @BindView(R.id.showPassword)
    Button showPassword;
    //    @BindView(R.id.spUC)
//    Spinner spUC;
    @BindView(R.id.syncData)
    Button syncClusters;
    @BindView(R.id.loginLayout1)
    RelativeLayout loginLayout1;
    @BindView(R.id.loginLayout2)
    RelativeLayout loginLayout2;

    DatabaseHelper db;
    List<String> clustersCode;
    List<String> clustersName;
    HashMap<String, String> cluster;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String DirectoryName;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;
    private LocationManager locationManager;

    public static String getDeviceId(Context context) {

        String deviceId;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            deviceId = Settings.Secure.getString(
                    context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } else {
            final TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (mTelephony.getDeviceId() != null) {
                deviceId = mTelephony.getDeviceId();
            } else {
                deviceId = Settings.Secure.getString(
                        context.getContentResolver(),
                        Settings.Secure.ANDROID_ID);
            }
        }

        return deviceId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

//        Initialize Login Members string
        MainApp.loginMem = new String[3];
        MainApp.loginMem[0] = "....";    //default value

        try {
            MainApp.installedOn = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.spsa_afg", 0)
                    .lastUpdateTime;
            MainApp.versionCode = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.spsa_afg", 0)
                    .versionCode;
            MainApp.versionName = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.spsa_afg", 0)
                    .versionName;
            txtinstalldate.setText("Ver. " + MainApp.versionName + "." + MainApp.versionCode + " \r\n( Last Updated: " + new SimpleDateFormat("dd MMM. yyyy", Locale.ENGLISH).format(new Date(MainApp.installedOn)) + " )");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // Set up the login form.
        mEmailView1 = findViewById(R.id.email1);
        populateAutoComplete();

        mPasswordView1 = findViewById(R.id.password1);
        mPasswordView1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TextView spUCTxtView = (TextView) spUC.getSelectedView();

//                if (spUC.getSelectedItem() != null) {
//                    spUCTxtView.setText(null);
                if (!mEmailView1.getText().toString().contains(mEmailView2.getText())) {
                    attemptLogin();

                    MainApp.loginMem[1] = mEmailView1.getText().toString();
                    MainApp.loginMem[2] = mEmailView2.getText().toString();
                } else {
                    Toast.makeText(getApplicationContext(), "Both username same", Toast.LENGTH_LONG).show();
                }
                /*} else {
                    Toast.makeText(getApplicationContext(), "Please Sync Clusters!!", Toast.LENGTH_LONG).show();
//                    spUCTxtView.setTextColor(Color.RED);//just to highlight that this is an error
//                    spUCTxtView.setText("Please Sync Clusters");//changes the selected item text to this
                }*/
            }
        });

//        DB backup
        dbBackup();
        MainApp.IMEI = getDeviceId(this);

        MainApp.appInfo = new AppInfo(this);

    }

    public void loadIMEI() {
        // Check if the READ_PHONE_STATE permission is already available.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                // READ_PHONE_STATE permission has not been granted.
                requestReadPhoneStatePermission();
            } else {
                doPermissionGrantedStuffs();
            }
        } else {
            doPermissionGrantedStuffs();
        }
    }

    private void requestReadPhoneStatePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_PHONE_STATE)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            new AlertDialog.Builder(LoginActivity.this)
                    .setTitle("Permission Request")
                    .setMessage("permission read phone state rationale")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //re-request
                            ActivityCompat.requestPermissions(LoginActivity.this,
                                    new String[]{Manifest.permission.READ_PHONE_STATE},
                                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
                        }
                    })
                    .show();
        } else {
            // READ_PHONE_STATE permission has not been granted yet. Request it directly.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        for (int i = 0; i < permissions.length; i++) {
            switch (permissions[i]) {
                case Manifest.permission.READ_CONTACTS:
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        populateAutoComplete();
                    }
                    break;
                case Manifest.permission.GET_ACCOUNTS:
                    break;
                case Manifest.permission.READ_PHONE_STATE:
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        doPermissionGrantedStuffs();
                        //loadIMEI();
                    }
                    break;
                case Manifest.permission.ACCESS_COARSE_LOCATION:
                    break;
                case Manifest.permission.ACCESS_FINE_LOCATION:
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MINIMUM_TIME_BETWEEN_UPDATES,
                                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                                new GPSLocationListener()// Implement this class from code

                        );
                    }
                    break;
                case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                case Manifest.permission.CAMERA:
                    break;
            }
        }
    }

    protected boolean isBetterLocation(Location location, Location currentBestLocation) {
        if (currentBestLocation == null) {
            // A new location is always better than no location
            return true;
        }

        // Check whether the new location fix is newer or older
        long timeDelta = location.getTime() - currentBestLocation.getTime();
        boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
        boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
        boolean isNewer = timeDelta > 0;

        // If it's been more than two minutes since the current location, use the new location
        // because the user has likely moved
        if (isSignificantlyNewer) {
            return true;

            // If the new location is more than two minutes older, it must be worse
        } else if (isSignificantlyOlder) {
            return false;
        }

        // Check whether the new location fix is more or less accurate
        int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;

        // Check if the old and new location are from the same provider
        boolean isFromSameProvider = isSameProvider(location.getProvider(),
                currentBestLocation.getProvider());

        // Determine location quality using a combination of timeliness and accuracy
        if (isMoreAccurate) {
            return true;
        } else if (isNewer && !isLessAccurate) {
            return true;
        } else return isNewer && !isSignificantlyLessAccurate && isFromSameProvider;
    }

    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    private void gettingDeviceIMEI() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //MainApp.IMEI = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        MainApp.IMEI = getDeviceId(this);

    }

    protected void showCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            //Toast.makeText(getApplicationContext(), message,
            //Toast.LENGTH_SHORT).show();
        }

    }

    private void doPermissionGrantedStuffs() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // MainApp.IMEI = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        MainApp.IMEI = getDeviceId(this);

    }

    @OnClick(R.id.showPassword)
    public void onShowPasswordClick() {
        //TODO implement
        if (mPasswordView1.getTransformationMethod() == null) {
            mPasswordView1.setTransformationMethod(new PasswordTransformationMethod());
            mPasswordView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp, 0, 0, 0);
        } else {
            mPasswordView1.setTransformationMethod(null);
            mPasswordView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_open_black_24dp, 0, 0, 0);
        }
    }

    @OnClick(R.id.showPassword2)
    public void onShowPasswordClick1() {
        //TODO implement
        if (mPasswordView2.getTransformationMethod() == null) {
            mPasswordView2.setTransformationMethod(new PasswordTransformationMethod());
            mPasswordView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp, 0, 0, 0);
        } else {
            mPasswordView2.setTransformationMethod(null);
            mPasswordView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_open_black_24dp, 0, 0, 0);
        }
    }

    public void dbBackup() {

        sharedPref = getSharedPreferences("spsa_afg", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", false)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH).format(new Date()));

            if (dt != new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH).format(new Date())) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH).format(new Date()));

                editor.commit();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "DMU-SPSA-AFG");
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {
                        File dbFile = new File(this.getDatabasePath(CreateTable.DATABASE_NAME).getPath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator +
                                CreateTable.DB_NAME;

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();
                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @OnClick(R.id.syncData)
    void onSyncClustersClick() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
/*        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

        //    new syncData(this).execute();
            startActivity(new Intent(this, SyncActivity.class).putExtra(CONSTANTS.SYNC_LOGIN, true));
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }*/

        if (AndroidUtilityKt.isNetworkConnected(this)) {
            /*if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();*/
            startActivity(new Intent(this, SyncActivity.class));
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }


    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView1.setError(null);
        mPasswordView1.setError(null);

        mEmailView2.setError(null);
        mPasswordView2.setError(null);

        // Store values at the time of the login attempt.
        String email1 = mEmailView1.getText().toString();
        String password1 = mPasswordView1.getText().toString();

        String email2 = mEmailView2.getText().toString();
        String password2 = mPasswordView2.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password1) && !isPasswordValid(password1)) {
            mPasswordView1.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView1;
            cancel = true;
        }
        if (!TextUtils.isEmpty(password2) && !isPasswordValid(password2)) {
            mPasswordView1.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView1;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email1)) {
            mEmailView1.setError(getString(R.string.error_field_required));
            focusView = mEmailView1;
            cancel = true;
        }
        if (TextUtils.isEmpty(email2)) {
            mEmailView2.setError(getString(R.string.error_field_required));
            focusView = mEmailView2;
            cancel = true;
        } /*else if (!isEmailValid(email)) {
            mEmailView1.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView1;
            cancel = true;
        }*/

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email1, password1, email2, password2);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 7;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView1.setAdapter(adapter);
    }

    public void gotoMain(View v) {

//        TextView spUCTxtView = (TextView) spUC.getSelectedView();

//        if (spUC.getSelectedItem() != null) {

//            spUCTxtView.setError(null);

        finish();
        Intent im = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(im);
/*        } else {
            Toast.makeText(this, "Please Sync Clusters!!", Toast.LENGTH_LONG).show();
//            spUCTxtView.setTextColor(Color.RED);//just to highlight that this is an error
//            spUCTxtView.setText("Please Sync Clusters");//changes the selected item text to this
        }*/
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail1, mEmail2;
        private final String mPassword1, mPassword2;

        UserLoginTask(String email1, String password1, String email2, String password2) {
            mEmail1 = email1;
            mPassword1 = password1;
            mEmail2 = email2;
            mPassword2 = password2;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail1)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword1);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
                if (db.Login(mEmail1, mPassword1)
                        || (mEmail1.equals("dmu@aku") && mPassword1.equals("aku?dmu"))
                        || (mEmail1.equals("test1234") && mPassword1.equals("test1234"))
                        || (mEmail1.equals("test1235") && mPassword1.equals("test1235"))

                ) {
                    MainApp.userName = mEmail1;
                    MainApp.admin = mEmail1.contains("@");

                    if (db.Login(mEmail2, mPassword1)
                            || (mEmail2.equals("dmu@aku") && mPassword2.equals("aku?dmu"))
                            || (mEmail2.equals("test1234") && mPassword2.equals("test1234"))
                            || (mEmail2.equals("test1235") && mPassword2.equals("test1235"))
                    ) {
                        MainApp.userName = mEmail2;
                        MainApp.admin = mEmail2.contains("@");

                        MainApp.measurers = new ArrayList<>();

                        MainApp.measurers.add(mEmail1);
                        MainApp.measurers.add(mEmail2);


                        finish();

                        Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(iLogin);

                    } else {
                        mPasswordView2.setError(getString(R.string.error_incorrect_password));
                        mPasswordView2.requestFocus();
                        Toast.makeText(LoginActivity.this, mEmail2 + " " + mPassword2, Toast.LENGTH_SHORT).show();

                        Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

                        loginLayout2.startAnimation(shake);
                    }

                } else {
                    mPasswordView1.setError(getString(R.string.error_incorrect_password));
                    mPasswordView1.requestFocus();
                    Toast.makeText(LoginActivity.this, mEmail1 + " " + mPassword1, Toast.LENGTH_SHORT).show();

                    Animation shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);

                    loginLayout1.startAnimation(shake);
                }
            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LoginActivity.this);
                alertDialogBuilder
                        .setMessage("GPS is disabled in your device. Enable it?")
                        .setCancelable(false)
                        .setPositiveButton("Enable GPS",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        Intent callGPSSettingIntent = new Intent(
                                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                        startActivity(callGPSSettingIntent);
                                    }
                                });
                alertDialogBuilder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }

        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    public class syncData extends AsyncTask<String, String, String> {

        private final Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {


                    /*Toast.makeText(getApplicationContext(), "Getting PW's", Toast.LENGTH_SHORT).show();
                    new GetAllData(mContext, "PW").execute();*/

                   /* Toast.makeText(LoginActivity.this, "Sync Users", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "User").execute();

                    Toast.makeText(LoginActivity.this, "Sync App Version", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "VersionApp").execute();

                    Toast.makeText(LoginActivity.this, "Sync Provinces", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Provinces").execute();

                    Toast.makeText(LoginActivity.this, "Sync Districts", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Districts").execute();

                    Toast.makeText(LoginActivity.this, "Sync Villages", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Villages").execute();*/
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    /*db = new DatabaseHelper(mContext);
                    Collection<ClustersContract> clusterCollection = db.getAllClusters();

                    clustersName = new ArrayList<>();

                    cluster = new HashMap<>();

                    if (clusterCollection.size() != 0) {
                        for (ClustersContract c : clusterCollection) {
                            clustersName.add(c.getClusterName());
                            cluster.put(c.getClusterName(), c.getClusterCode());
                        }

                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext,
                                android.R.layout.simple_spinner_item, clustersName);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        // attaching data adapter to spinner
                        spUC.setAdapter(dataAdapter);

                        spUC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                //((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
                                AppMain.curCluster = cluster.get(spUC.getSelectedItem().toString());

                                Log.d("Selected Cluster", AppMain.curCluster);


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }*/

                    editor.putBoolean("flag", true);
                    editor.commit();

                    dbBackup();


                }
            }, 1200);
        }
    }

    public class GPSLocationListener implements LocationListener {
        public void onLocationChanged(Location location) {

            SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            String dt = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(sharedPref.getString("Time", "0"))).toString();

            Location bestLocation = new Location("storedProvider");
            bestLocation.setAccuracy(Float.parseFloat(sharedPref.getString("Accuracy", "0")));
            bestLocation.setTime(Long.parseLong(sharedPref.getString(dt, "0")));
            bestLocation.setLatitude(Float.parseFloat(sharedPref.getString("Latitude", "0")));
            bestLocation.setLongitude(Float.parseFloat(sharedPref.getString("Longitude", "0")));

            if (isBetterLocation(location, bestLocation)) {
                editor.putString("Longitude", String.valueOf(location.getLongitude()));
                editor.putString("Latitude", String.valueOf(location.getLatitude()));
                editor.putString("Accuracy", String.valueOf(location.getAccuracy()));
                editor.putString("Time", String.valueOf(location.getTime()));
                editor.putString("Elevation", String.valueOf(location.getAltitude()));
                String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(String.valueOf(location.getTime()))).toString();
//                Toast.makeText(getApplicationContext(),
//                        "GPS Commit! LAT: " + String.valueOf(location.getLongitude()) +
//                                " LNG: " + String.valueOf(location.getLatitude()) +
//                                " Accuracy: " + String.valueOf(location.getAccuracy()) +
//                                " Time: " + date,
//                        Toast.LENGTH_SHORT).show();

                editor.apply();
            }
        }


        public void onStatusChanged(String s, int i, Bundle b) {
            showCurrentLocation();
        }

        public void onProviderDisabled(String s) {

        }

        public void onProviderEnabled(String s) {

        }
    }
}

