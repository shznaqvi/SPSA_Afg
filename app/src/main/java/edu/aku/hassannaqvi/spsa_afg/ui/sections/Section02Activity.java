package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection02Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section02Activity extends AppCompatActivity {

    ActivitySection02Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section02);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        /*bi.d0201.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvd0202);
            Clear.clearAllFields(bi.cvd0202);
        }));*/


        bi.s2q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s2q402.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs2q5);
            }
        }));


        bi.s2q6.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s2q608.getId() ||i == bi.s2q609.getId()) {
                Clear.clearAllFields(bi.fldGrpSec2Q6);
            }
        }));
        bi.s2q7.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s2q702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs2q8);
            }
        }));

        bi.s2q16.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s2q1602.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs2q17);
            }
        }));
        bi.s2q18.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s2q1802.getId()) {
                Clear.clearAllFields(bi.fldGrpSec2Q18);
            }
        }));


    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S02, form.s02toString(true));
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {


        form.setS2q1(bi.s2q101.isChecked() ? "1"
                : bi.s2q102.isChecked() ? "2"
                : bi.s2q103.isChecked() ? "3"
                : bi.s2q104.isChecked() ? "4"
                : bi.s2q105.isChecked() ? "5"
                : bi.s2q106.isChecked() ? "6"
                : bi.s2q107.isChecked() ? "7"
                : bi.s2q196.isChecked() ? "96"
                : "-1");

        form.setS2q196x(bi.s2q196x.getText().toString());
        form.setS2q2(bi.s2q201.isChecked() ? "1"
                : bi.s2q202.isChecked() ? "2"
                : bi.s2q296.isChecked() ? "96"
                : "-1");

        form.setS2q296x(bi.s2q296x.getText().toString());
        form.setS2q3(bi.s2q301.isChecked() ? "1"
                : bi.s2q302.isChecked() ? "2"
                : bi.s2q303.isChecked() ? "3"
                : bi.s2q304.isChecked() ? "4"
                : bi.s2q305.isChecked() ? "5"
                : bi.s2q306.isChecked() ? "6"
                : bi.s2q307.isChecked() ? "7"
                : bi.s2q308.isChecked() ? "8"
                : bi.s2q309.isChecked() ? "9"
                : bi.s2q310.isChecked() ? "10"
                : bi.s2q311.isChecked() ? "11"
                : bi.s2q312.isChecked() ? "12"
                : bi.s2q313.isChecked() ? "13"
                : bi.s2q314.isChecked() ? "14"
                : bi.s2q315.isChecked() ? "15"
                : bi.s2q316.isChecked() ? "16"
                : bi.s2q396.isChecked() ? "96"
                : "-1");

        form.setS2q396x(bi.s2q396x.getText().toString());
        form.setS2q4(bi.s2q401.isChecked() ? "1"
                : bi.s2q402.isChecked() ? "2"
                : "-1");

        form.setS2q5(bi.s2q501.isChecked() ? "1"
                : bi.s2q502.isChecked() ? "2"
                : bi.s2q503.isChecked() ? "3"
                : bi.s2q504.isChecked() ? "4"
                : bi.s2q505.isChecked() ? "5"
                : bi.s2q506.isChecked() ? "6"
                : bi.s2q596.isChecked() ? "96"
                : "-1");

        form.setS2q596x(bi.s2q596x.getText().toString());
        form.setS2q6(bi.s2q601.isChecked() ? "1"
                : bi.s2q602.isChecked() ? "2"
                : bi.s2q603.isChecked() ? "3"
                : bi.s2q604.isChecked() ? "4"
                : bi.s2q605.isChecked() ? "5"
                : bi.s2q606.isChecked() ? "6"
                : bi.s2q607.isChecked() ? "7"
                : bi.s2q608.isChecked() ? "8"
                : bi.s2q609.isChecked() ? "9"
                : bi.s2q696.isChecked() ? "96"
                : "-1");

        form.setS2q696x(bi.s2q696x.getText().toString());
        form.setS2q7(bi.s2q701.isChecked() ? "1"
                : bi.s2q702.isChecked() ? "2"
                : "-1");

        form.setS2q8(bi.s2q801.isChecked() ? ""
                : bi.s2q811.isChecked() ? "11"
                : bi.s2q898.isChecked() ? "98"
                : "-1");

        form.setS2q801x(bi.s2q801x.getText().toString());
        form.setS2q9a(bi.s2q9a01.isChecked() ? "1"
                : bi.s2q9a02.isChecked() ? "2"
                : "-1");

        form.setS2q9b(bi.s2q9b01.isChecked() ? "1"
                : bi.s2q9b02.isChecked() ? "2"
                : "-1");

        form.setS2q9c(bi.s2q9c01.isChecked() ? "1"
                : bi.s2q9c02.isChecked() ? "2"
                : "-1");

        form.setS2q9d(bi.s2q9d01.isChecked() ? "1"
                : bi.s2q9d02.isChecked() ? "2"
                : "-1");

        form.setS2q9e(bi.s2q9e01.isChecked() ? "1"
                : bi.s2q9e02.isChecked() ? "2"
                : "-1");

        form.setS2q9f(bi.s2q9f01.isChecked() ? "1"
                : bi.s2q9f02.isChecked() ? "2"
                : "-1");

        form.setS2q9g(bi.s2q9g01.isChecked() ? "1"
                : bi.s2q9g02.isChecked() ? "2"
                : "-1");

        form.setS2q9h(bi.s2q9h01.isChecked() ? "1"
                : bi.s2q9h02.isChecked() ? "2"
                : "-1");

        form.setS2q9i(bi.s2q9i01.isChecked() ? "1"
                : bi.s2q9i02.isChecked() ? "2"
                : "-1");

        form.setS2q9j(bi.s2q9j01.isChecked() ? "1"
                : bi.s2q9j02.isChecked() ? "2"
                : "-1");

        form.setS2q9k(bi.s2q9k01.isChecked() ? "1"
                : bi.s2q9k02.isChecked() ? "2"
                : "-1");

        form.setS2q9l(bi.s2q9l01.isChecked() ? "1"
                : bi.s2q9l02.isChecked() ? "2"
                : "-1");

        form.setS2q9m(bi.s2q9m01.isChecked() ? "1"
                : bi.s2q9m02.isChecked() ? "2"
                : "-1");

        form.setS2q9n(bi.s2q9n01.isChecked() ? "1"
                : bi.s2q9n02.isChecked() ? "2"
                : "-1");

        form.setS2q9o(bi.s2q9o01.isChecked() ? "1"
                : bi.s2q9o02.isChecked() ? "2"
                : "-1");

        form.setS2q9p(bi.s2q9p01.isChecked() ? "1"
                : bi.s2q9p02.isChecked() ? "2"
                : "-1");

        form.setS2q9q(bi.s2q9q01.isChecked() ? "1"
                : bi.s2q9q02.isChecked() ? "2"
                : "-1");

        form.setS2q9r(bi.s2q9r01.isChecked() ? "1"
                : bi.s2q9r02.isChecked() ? "2"
                : "-1");

        form.setS2q9s(bi.s2q9s01.isChecked() ? "1"
                : bi.s2q9s02.isChecked() ? "2"
                : "-1");

        form.setS2q10a(bi.s2q10a01.isChecked() ? "1"
                : bi.s2q10a02.isChecked() ? "2"
                : "-1");

        form.setS2q10b(bi.s2q10b01.isChecked() ? "1"
                : bi.s2q10b02.isChecked() ? "2"
                : "-1");

        form.setS2q10c(bi.s2q10c01.isChecked() ? "1"
                : bi.s2q10c02.isChecked() ? "2"
                : "-1");

        form.setS2q10d(bi.s2q10d01.isChecked() ? "1"
                : bi.s2q10d02.isChecked() ? "2"
                : "-1");

        form.setS2q10e(bi.s2q10e01.isChecked() ? "1"
                : bi.s2q10e02.isChecked() ? "2"
                : "-1");

        form.setS2q10f(bi.s2q10f01.isChecked() ? "1"
                : bi.s2q10f02.isChecked() ? "2"
                : "-1");

        form.setS2q10g(bi.s2q10g01.isChecked() ? "1"
                : bi.s2q10g02.isChecked() ? "2"
                : "-1");

        form.setS2q10h(bi.s2q10h01.isChecked() ? "1"
                : bi.s2q10h02.isChecked() ? "2"
                : "-1");

        form.setS2q10i(bi.s2q10i01.isChecked() ? "1"
                : bi.s2q10i02.isChecked() ? "2"
                : "-1");

        form.setS2q11(bi.s2q1101.isChecked() ? "1"
                : bi.s2q1102.isChecked() ? "2"
                : bi.s2q1103.isChecked() ? "3"
                : bi.s2q1104.isChecked() ? "4"
                : bi.s2q1105.isChecked() ? "5"
                : bi.s2q1106.isChecked() ? "6"
                : bi.s2q1107.isChecked() ? "7"
                : bi.s2q1108.isChecked() ? "8"
                : bi.s2q1109.isChecked() ? "9"
                : bi.s2q1110.isChecked() ? "10"
                : bi.s2q1111.isChecked() ? "11"
                : bi.s2q1196.isChecked() ? "96"
                : "-1");

        form.setS2q1196x(bi.s2q1196x.getText().toString());
        form.setS2q12(bi.s2q1211.isChecked() ? "11"
                : bi.s2q1212.isChecked() ? "12"
                : bi.s2q1221.isChecked() ? "21"
                : bi.s2q1222.isChecked() ? "22"
                : bi.s2q1231.isChecked() ? "31"
                : bi.s2q1232.isChecked() ? "32"
                : bi.s2q1233.isChecked() ? "33"
                : bi.s2q1234.isChecked() ? "34"
                : bi.s2q1235.isChecked() ? "35"
                : bi.s2q1236.isChecked() ? "36"
                : bi.s2q1237.isChecked() ? "37"
                : bi.s2q1296.isChecked() ? "96"
                : "-1");

        form.setS2q1296x(bi.s2q1296x.getText().toString());
        form.setS2q13(bi.s2q1311.isChecked() ? "11"
                : bi.s2q1312.isChecked() ? "12"
                : bi.s2q1313.isChecked() ? "13"
                : bi.s2q1321.isChecked() ? "21"
                : bi.s2q1322.isChecked() ? "22"
                : bi.s2q1323.isChecked() ? "23"
                : bi.s2q1324.isChecked() ? "24"
                : bi.s2q1331.isChecked() ? "31"
                : bi.s2q1332.isChecked() ? "32"
                : bi.s2q1333.isChecked() ? "33"
                : bi.s2q1334.isChecked() ? "34"
                : bi.s2q1335.isChecked() ? "35"
                : bi.s2q1336.isChecked() ? "36"
                : bi.s2q1337.isChecked() ? "37"
                : bi.s2q1396.isChecked() ? "96"
                : "-1");

        form.setS2q1396x(bi.s2q1396x.getText().toString());
        form.setS2q14(bi.s2q1411.isChecked() ? "11"
                : bi.s2q1412.isChecked() ? "12"
                : bi.s2q1413.isChecked() ? "13"
                : bi.s2q1421.isChecked() ? "21"
                : bi.s2q1422.isChecked() ? "22"
                : bi.s2q1423.isChecked() ? "23"
                : bi.s2q1424.isChecked() ? "24"
                : bi.s2q1425.isChecked() ? "25"
                : bi.s2q1426.isChecked() ? "26"
                : bi.s2q1427.isChecked() ? "27"
                : bi.s2q1431.isChecked() ? "31"
                : bi.s2q1432.isChecked() ? "32"
                : bi.s2q1433.isChecked() ? "33"
                : bi.s2q1434.isChecked() ? "34"
                : bi.s2q1435.isChecked() ? "35"
                : bi.s2q1436.isChecked() ? "36"
                : bi.s2q1496.isChecked() ? "96"
                : "-1");

        form.setS2q1496x(bi.s2q1496x.getText().toString());
        form.setS2q15(bi.s2q15.getText().toString());

        form.setS2q16(bi.s2q1601.isChecked() ? "1"
                : bi.s2q1602.isChecked() ? "2"
                : "-1");

        form.setS2q17(bi.s2q1701.isChecked() ? ""
                : bi.s2q1702.isChecked() ? ""
                : bi.s2q1703.isChecked() ? ""
                : bi.s2q1798.isChecked() ? "98"
                : "-1");

        form.setS2q1701x(bi.s2q1701x.getText().toString());
        form.setS2q1702x(bi.s2q1702x.getText().toString());
        form.setS2q1703x(bi.s2q1703x.getText().toString());
        form.setS2q18(bi.s2q1801.isChecked() ? "1"
                : bi.s2q1802.isChecked() ? "2"
                : "-1");

        form.setS2q1901(bi.s2q1901.getText().toString());

        form.setS2q1902(bi.s2q1902.getText().toString());

        form.setS2q1903(bi.s2q1903.getText().toString());

        form.setS2q1904(bi.s2q1904.getText().toString());

        form.setS2q1905(bi.s2q1905.getText().toString());

        form.setS2q1906(bi.s2q1906.getText().toString());

        form.setS2q1907(bi.s2q1907.getText().toString());

        form.setS2q20(bi.s2q2001.isChecked() ? "1"
                : bi.s2q2002.isChecked() ? "2"
                : bi.s2q20098.isChecked() ? "98"
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
            startActivity(new Intent(this, Section03Activity.class));
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