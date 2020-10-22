package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection1101Binding;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section1101Activity extends AppCompatActivity {

    ActivitySection1101Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section1101);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.s11q7.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s11q701.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs11q8);
            }
        }));

    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S11, form.s11toString(true));
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;

    }


    private void SaveDraft() throws JSONException {

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        form.setUsername(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());
        form.setFormdate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));

        form.setS11q7(bi.s11q701.isChecked() ? "1"
                : bi.s11q702.isChecked() ? "2"
                : bi.s11q798.isChecked() ? "98"
                : "-1");

        form.setS11q7a(bi.s11q7a01.isChecked() ? "1"
                : bi.s11q7a02.isChecked() ? "2"
                : bi.s11q7a98.isChecked() ? "98"
                : "-1");

        form.setS11q8(bi.s11q801.isChecked() ? "1"
                : bi.s11q802.isChecked() ? "2"
                : bi.s11q898.isChecked() ? "98"
                : "-1");

        form.setS11q9(bi.s11q901.isChecked() ? "1"
                : bi.s11q902.isChecked() ? "2"
                : bi.s11q998.isChecked() ? "98"
                : "-1");

        form.setS11q10a(bi.s11q10a01.isChecked() ? "1"
                : bi.s11q10a02.isChecked() ? "2"
                : bi.s11q10a98.isChecked() ? "98"
                : "-1");
        form.setS11q10b(bi.s11q10b01.isChecked() ? "1"
                : bi.s11q10b02.isChecked() ? "2"
                : bi.s11q10b98.isChecked() ? "98"
                : "-1");


        form.setS11q10b01x(bi.s11q10b01x.getText().toString());

        form.setS11q10c(bi.s11q10c01.isChecked() ? "1"
                : bi.s11q10c02.isChecked() ? "2"
                : bi.s11q10c98.isChecked() ? "98"
                : "-1");

        form.setS11q10c01x(bi.s11q10c01x.getText().toString());
        form.setS11q10d(bi.s11q10d01.isChecked() ? "1"
                : bi.s11q10d02.isChecked() ? "2"
                : bi.s11q10d98.isChecked() ? "98"
                : "-1");

        form.setS11q10e(bi.s11q10e01.isChecked() ? "1"
                : bi.s11q10e02.isChecked() ? "2"
                : bi.s11q10e98.isChecked() ? "98"
                : "-1");

        form.setS11q10f(bi.s11q10f01.isChecked() ? "1"
                : bi.s11q10f02.isChecked() ? "2"
                : bi.s11q10f98.isChecked() ? "98"
                : "-1");

        form.setS11q10f01x(bi.s11q10f01x.getText().toString());
        form.setS11q10g(bi.s11q10g01.isChecked() ? "1"
                : bi.s11q10g02.isChecked() ? "2"
                : bi.s11q10g98.isChecked() ? "98"
                : "-1");

        form.setS11q10h(bi.s11q10h01.isChecked() ? "1"
                : bi.s11q10h02.isChecked() ? "2"
                : bi.s11q10h98.isChecked() ? "98"
                : "-1");

        form.setS11q10i(bi.s11q10i01.isChecked() ? "1"
                : bi.s11q10i02.isChecked() ? "2"
                : bi.s11q10i98.isChecked() ? "98"
                : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, Section1102Activity.class));
        }
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}

