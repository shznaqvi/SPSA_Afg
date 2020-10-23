package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection08Binding;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section08Activity extends AppCompatActivity {

    ActivitySection08Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section08);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkip();
    }


    private void setupSkip() {

        bi.s8q1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s8q102.getId() || i == bi.s8q103.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs8q1a);
            }
        }));
        bi.s8q3.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s8q301.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs8q3a);
            }
        }));
        bi.s8q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s8q401.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs8q4a);
            }
        }));
        bi.s8q2.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s8q201.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs8q3);
            }
        }));
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S08, form.s08toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        form.setS8q1( bi.s8q101.isChecked() ? "1"
                : bi.s8q102.isChecked() ? "2"
                : bi.s8q103.isChecked() ? "3"
                :  "-1");

        form.setS8q1a(bi.s8q1a.getText().toString());

        form.setS8q2( bi.s8q201.isChecked() ? "1"
                : bi.s8q202.isChecked() ? "2"
                :  "-1");

        form.setS8q2a(bi.s8q2a.getText().toString());

        form.setS8q2b01(bi.s8q2b01.isChecked() ? "1" : "-1");

        form.setS8q2b02(bi.s8q2b02.isChecked() ? "2" : "-1");

        form.setS8q2b03(bi.s8q2b03.isChecked() ? "3" : "-1");

        form.setS8q2b04(bi.s8q2b04.isChecked() ? "4" : "-1");

        form.setS8q2b05(bi.s8q2b05.isChecked() ? "5" : "-1");

        form.setS8q2b96(bi.s8q2b96.isChecked() ? "96" : "-1");

        form.setS8q2b96x(bi.s8q2b96x.getText().toString());
        form.setS8q2c01(bi.s8q2c01.isChecked() ? "1" : "-1");

        form.setS8q2c02(bi.s8q2c02.isChecked() ? "2" : "-1");

        form.setS8q2c03(bi.s8q2c03.isChecked() ? "3" : "-1");

        form.setS8q2c04(bi.s8q2c04.isChecked() ? "4" : "-1");

        form.setS8q2c96(bi.s8q2c96.isChecked() ? "96" : "-1");

        form.setS8q2c96x(bi.s8q2c96x.getText().toString());
        form.setS8q3( bi.s8q301.isChecked() ? "1"
                : bi.s8q302.isChecked() ? "2"
                :  "-1");

        form.setS8q3a( bi.s8q3a01.isChecked() ? ""
                : bi.s8q3a98.isChecked() ? "98"
                :  "-1");

        form.setS8q3a01x(bi.s8q3a01x.getText().toString());
        form.setS8q4( bi.s8q401.isChecked() ? "1"
                : bi.s8q402.isChecked() ? "2"
                :  "-1");

        form.setS8q4a( bi.s8q4a01.isChecked() ? ""
                : bi.s8q4a98.isChecked() ? "98"
                :  "-1");

        form.setS8q4a01x(bi.s8q4a01x.getText().toString());
        form.setS8q5( bi.s8q501.isChecked() ? "1"
                : bi.s8q502.isChecked() ? "2"
                :  "-1");

        form.setS8q6( bi.s8q601.isChecked() ? "1"
                : bi.s8q602.isChecked() ? "2"
                : bi.s8q603.isChecked() ? "3"
                : bi.s8q604.isChecked() ? "4"
                : bi.s8q605.isChecked() ? "5"
                : bi.s8q698.isChecked() ? "98"
                :  "-1");

        form.setS8q7( bi.s8q701.isChecked() ? "1"
                : bi.s8q702.isChecked() ? "2"
                : bi.s8q798.isChecked() ? "98"
                :  "-1");

        form.setS8q7a( bi.s8q7a01.isChecked() ? ""
                : bi.s8q7a02.isChecked() ? ""
                : bi.s8q7a98.isChecked() ? "98"
                :  "-1");

        form.setS8q7a01x(bi.s8q7a01x.getText().toString());
        form.setS8q7a02x(bi.s8q7a02x.getText().toString());
        form.setS8q801(bi.s8q801.isChecked() ? "1" : "-1");

        form.setS8q802(bi.s8q802.isChecked() ? "2" : "-1");

        form.setS8q803(bi.s8q803.isChecked() ? "3" : "-1");

        form.setS8q804(bi.s8q804.isChecked() ? "4" : "-1");

        form.setS8q805(bi.s8q805.isChecked() ? "5" : "-1");

        form.setS8q806(bi.s8q806.isChecked() ? "6" : "-1");

        form.setS8q896(bi.s8q896.isChecked() ? "96" : "-1");

        form.setS8q896x(bi.s8q896x.getText().toString());
        form.setS8q899(bi.s8q899.isChecked() ? "99" : "-1");

        form.setS8q9( bi.s8q901.isChecked() ? "1"
                : bi.s8q902.isChecked() ? "2"
                : bi.s8q903.isChecked() ? "3"
                : bi.s8q904.isChecked() ? "4"
                : bi.s8q996.isChecked() ? "96"
                :  "-1");

        form.setS8q996x(bi.s8q996x.getText().toString());
        form.setS8q10( bi.s8q1001.isChecked() ? ""
                : bi.s8q1098.isChecked() ? "98"
                :  "-1");

        form.setS8q1001x(bi.s8q1001x.getText().toString());
        form.setS8q11( bi.s8q1101.isChecked() ? ""
                : bi.s8q1102.isChecked() ? ""
                : bi.s8q1103.isChecked() ? ""
                : bi.s8q1198.isChecked() ? "98"
                :  "-1");

        form.setS8q1101x(bi.s8q1101x.getText().toString());
        form.setS8q1102x(bi.s8q1102x.getText().toString());
        form.setS8q1103x(bi.s8q1103x.getText().toString());
        form.setS8q12( bi.s8q1201.isChecked() ? "1"
                : bi.s8q1202.isChecked() ? "2"
                : bi.s8q1203.isChecked() ? "3"
                : bi.s8q1204.isChecked() ? "4"
                : bi.s8q1205.isChecked() ? "5"
                : bi.s8q1296.isChecked() ? "96"
                :  "-1");

        form.setS8q1296x(bi.s8q1296x.getText().toString());
        form.setS8q13( bi.s8q1301.isChecked() ? "1"
                : bi.s8q1302.isChecked() ? "2"
                : bi.s8q1303.isChecked() ? "3"
                : bi.s8q1304.isChecked() ? "4"
                : bi.s8q1396.isChecked() ? "96"
                :  "-1");

        form.setS8q1396x(bi.s8q1396x.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}