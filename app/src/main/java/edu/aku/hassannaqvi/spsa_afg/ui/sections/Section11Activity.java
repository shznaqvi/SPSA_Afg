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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection11Binding;

public class Section11Activity extends AppCompatActivity {
    ActivitySection11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_11);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_11);
        bi.setCallback(this);
        setupSkips();
    }

    private void setupSkips() {

        bi.s11q7.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s11q701.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs11q8);
            }
        }));

        bi.s11q13.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s11q1301.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs11q14);
            }
        }));

        bi.s11q15.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s11q1501.getId()) {
                Clear.clearAllFields(bi.llgrpsec1101);
            }
        }));

        bi.g3133s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3133sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3133so);
            }
        }));

        bi.g3134s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3134sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3134so);
            }
        }));

        bi.g3135s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3135sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3135so);
            }
        }));

        bi.g3136s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3136sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3136so);
            }
        }));

        bi.g3137s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3137sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3137so);
            }
        }));

        bi.g3138s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3138sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3138so);
            }
        }));

        bi.g3139s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g3139sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg3139so);
            }
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();
        json.put("s11q7", bi.s11q701.isChecked() ? "1"
                : bi.s11q702.isChecked() ? "2"
                : bi.s11q798.isChecked() ? "98"
                : "-1");

        json.put("s11q7a", bi.s11q7a01.isChecked() ? "1"
                : bi.s11q7a02.isChecked() ? "2"
                : bi.s11q7a98.isChecked() ? "98"
                : "-1");

        json.put("s11q8", bi.s11q801.isChecked() ? "1"
                : bi.s11q802.isChecked() ? "2"
                : bi.s11q898.isChecked() ? "98"
                : "-1");

        json.put("s11q9", bi.s11q901.isChecked() ? "1"
                : bi.s11q902.isChecked() ? "2"
                : bi.s11q998.isChecked() ? "98"
                : "-1");

        json.put("s11q10a", bi.s11q10a01.isChecked() ? "1"
                : bi.s11q10a02.isChecked() ? "2"
                : bi.s11q10a98.isChecked() ? "98"
                : "-1");

        json.put("s11q10b", bi.s11q10b01.isChecked() ? "1"
                : bi.s11q10b02.isChecked() ? "2"
                : bi.s11q10b98.isChecked() ? "98"
                : "-1");

        json.put("s11q10b01x", bi.s11q10b01x.getText().toString());
        json.put("s11q10c", bi.s11q10c01.isChecked() ? "1"
                : bi.s11q10c02.isChecked() ? "2"
                : bi.s11q10c98.isChecked() ? "98"
                : "-1");

        json.put("s11q10c01x", bi.s11q10c01x.getText().toString());
        json.put("s11q10d", bi.s11q10d01.isChecked() ? "1"
                : bi.s11q10d02.isChecked() ? "2"
                : bi.s11q10d98.isChecked() ? "98"
                : "-1");

        json.put("s11q10e", bi.s11q10e01.isChecked() ? "1"
                : bi.s11q10e02.isChecked() ? "2"
                : bi.s11q10e98.isChecked() ? "98"
                : "-1");

        json.put("s11q10f", bi.s11q10f01.isChecked() ? "1"
                : bi.s11q10f02.isChecked() ? "2"
                : bi.s11q10f98.isChecked() ? "98"
                : "-1");

        json.put("s11q10f01x", bi.s11q10f01x.getText().toString());
        json.put("s11q10g", bi.s11q10g01.isChecked() ? "1"
                : bi.s11q10g02.isChecked() ? "2"
                : bi.s11q10g98.isChecked() ? "98"
                : "-1");

        json.put("s11q10h", bi.s11q10h01.isChecked() ? "1"
                : bi.s11q10h02.isChecked() ? "2"
                : bi.s11q10h98.isChecked() ? "98"
                : "-1");

        json.put("s11q10i", bi.s11q10i01.isChecked() ? "1"
                : bi.s11q10i02.isChecked() ? "2"
                : bi.s11q10i98.isChecked() ? "98"
                : "-1");

        json.put("s11q12a", bi.s11q12a01.isChecked() ? "1"
                : bi.s11q12a02.isChecked() ? "2"
                : bi.s11q12a98.isChecked() ? "98"
                : "-1");

        json.put("s11q12b", bi.s11q12b01.isChecked() ? "1"
                : bi.s11q12b02.isChecked() ? "2"
                : bi.s11q12b98.isChecked() ? "98"
                : "-1");

        json.put("s11q12c", bi.s11q12c01.isChecked() ? "1"
                : bi.s11q12c02.isChecked() ? "2"
                : bi.s11q12c98.isChecked() ? "98"
                : "-1");

        json.put("s11q12d", bi.s11q12d01.isChecked() ? "1"
                : bi.s11q12d02.isChecked() ? "2"
                : bi.s11q12d98.isChecked() ? "98"
                : "-1");

        json.put("s11q12e", bi.s11q12e01.isChecked() ? "1"
                : bi.s11q12e02.isChecked() ? "2"
                : bi.s11q12e98.isChecked() ? "98"
                : "-1");

        json.put("s11q12f", bi.s11q12f01.isChecked() ? "1"
                : bi.s11q12f02.isChecked() ? "2"
                : bi.s11q12f98.isChecked() ? "98"
                : "-1");

        json.put("s11q12g", bi.s11q12g01.isChecked() ? "1"
                : bi.s11q12g02.isChecked() ? "2"
                : bi.s11q12g98.isChecked() ? "98"
                : "-1");

        json.put("s11q12h", bi.s11q12h01.isChecked() ? "1"
                : bi.s11q12h02.isChecked() ? "2"
                : bi.s11q12h98.isChecked() ? "98"
                : "-1");

        json.put("s11q12i", bi.s11q12i01.isChecked() ? "1"
                : bi.s11q12i02.isChecked() ? "2"
                : bi.s11q12i98.isChecked() ? "98"
                : "-1");

        json.put("s11q12j", bi.s11q12j01.isChecked() ? "1"
                : bi.s11q12j02.isChecked() ? "2"
                : bi.s11q12j98.isChecked() ? "98"
                : "-1");

        json.put("s11q12k", bi.s11q12k01.isChecked() ? "1"
                : bi.s11q12k02.isChecked() ? "2"
                : bi.s11q12k98.isChecked() ? "98"
                : "-1");

        json.put("s11q12l", bi.s11q12l01.isChecked() ? "1"
                : bi.s11q12l02.isChecked() ? "2"
                : bi.s11q12l98.isChecked() ? "98"
                : "-1");

        json.put("s11q12m", bi.s11q12m01.isChecked() ? "1"
                : bi.s11q12m02.isChecked() ? "2"
                : bi.s11q12m98.isChecked() ? "98"
                : "-1");

        json.put("s11q12n", bi.s11q12n01.isChecked() ? "1"
                : bi.s11q12n02.isChecked() ? "2"
                : bi.s11q12n98.isChecked() ? "98"
                : "-1");

        json.put("s11q12o", bi.s11q12o01.isChecked() ? "1"
                : bi.s11q12o02.isChecked() ? "2"
                : bi.s11q12o98.isChecked() ? "98"
                : "-1");

        json.put("s11q12p", "-1");

        json.put("s11q12p01", "-1");

        json.put("s11q12p02", "-1");

        json.put("s11q12p98", "-1");

        json.put("s11q12q", "-1");

        json.put("s11q12q01", "-1");

        json.put("s11q12q02", "-1");

        json.put("s11q12q98", "-1");

        json.put("s11q13", bi.s11q1301.isChecked() ? "1"
                : bi.s11q1302.isChecked() ? "2"
                : bi.s11q1398.isChecked() ? "98"
                : "-1");

        json.put("s11q14", bi.s11q1401.isChecked() ? ""
                : bi.s11q1402.isChecked() ? "98"
                : "-1");

        json.put("s11q1401x", bi.s11q1401x.getText().toString());
        json.put("s11q15", bi.s11q1501.isChecked() ? "1"
                : bi.s11q1502.isChecked() ? "2"
                : bi.s11q1598.isChecked() ? "98"
                : "-1");

        json.put("s11q16", bi.s11q1601.isChecked() ? "1"
                : bi.s11q1602.isChecked() ? "2"
                : bi.s11q1603.isChecked() ? "3"
                : bi.s11q1696.isChecked() ? "96"
                : "-1");

        json.put("s11q1696x", bi.s11q1696x.getText().toString());
        json.put("s11q17", bi.s11q1701.isChecked() ? "1"
                : bi.s11q1702.isChecked() ? "2"
                : bi.s11q1703.isChecked() ? "3"
                : bi.s11q1796.isChecked() ? "96"
                : "-1");

        json.put("s11q1796x", bi.s11q1796x.getText().toString());
        json.put("s11q18", bi.s11q1801.isChecked() ? "1"
                : bi.s11q1802.isChecked() ? "2"
                : bi.s11q1898.isChecked() ? "98"
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
            startActivity(new Intent(this, Section11Activity.class));
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}

}