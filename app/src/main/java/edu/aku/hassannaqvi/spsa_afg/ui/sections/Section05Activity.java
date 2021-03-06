package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection05Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section05Activity extends AppCompatActivity {

    ActivitySection05Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section05);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        bi.s5q1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q102.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q1a);
            }
        }));

        bi.s5q2.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q202.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q2a);
            }
        }));

        bi.s5q3.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q3a);
            }
        }));

        bi.s5q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q402.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q4a);
            }
        }));

        bi.s5q5.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q5a);
            }
        }));

        bi.s5q6.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q602.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q6a);
            }
        }));

        bi.s5q7.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q702.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q7a);
            }
        }));

        bi.s5q8.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q802.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q8a);
            }
        }));

        bi.s5q9.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s5q902.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs5q9a);
            }
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S05, form.s05toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() {

        form.setS5q1(bi.s5q101.isChecked() ? "1"
                : bi.s5q102.isChecked() ? "2"
                : "-1");

        form.setS5q1a(bi.s5q1a01.isChecked() ? "1"
                : bi.s5q1a02.isChecked() ? "2"
                : bi.s5q1a03.isChecked() ? "3"
                : "-1");

        form.setS5q2(bi.s5q201.isChecked() ? "1"
                : bi.s5q202.isChecked() ? "2"
                : "-1");

        form.setS5q2a(bi.s5q2a01.isChecked() ? "1"
                : bi.s5q2a02.isChecked() ? "2"
                : bi.s5q2a03.isChecked() ? "3"
                : "-1");

        form.setS5q3(bi.s5q301.isChecked() ? "1"
                : bi.s5q302.isChecked() ? "2"
                : "-1");

        form.setS5q3a(bi.s5q3a01.isChecked() ? "1"
                : bi.s5q3a02.isChecked() ? "2"
                : bi.s5q3a03.isChecked() ? "3"
                : "-1");

        form.setS5q4(bi.s5q401.isChecked() ? "1"
                : bi.s5q402.isChecked() ? "2"
                : "-1");

        form.setS5q4a(bi.s5q4a01.isChecked() ? "1"
                : bi.s5q4a02.isChecked() ? "2"
                : bi.s5q4a03.isChecked() ? "3"
                : "-1");

        form.setS5q5(bi.s5q501.isChecked() ? "1"
                : bi.s5q502.isChecked() ? "2"
                : "-1");

        form.setS5q5a(bi.s5q5a01.isChecked() ? "1"
                : bi.s5q5a02.isChecked() ? "2"
                : bi.s5q5a03.isChecked() ? "3"
                : "-1");

        form.setS5q6(bi.s5q601.isChecked() ? "1"
                : bi.s5q602.isChecked() ? "2"
                : "-1");

        form.setS5q6a(bi.s5q6a01.isChecked() ? "1"
                : bi.s5q6a02.isChecked() ? "2"
                : bi.s5q6a03.isChecked() ? "3"
                : "-1");

        form.setS5q7(bi.s5q701.isChecked() ? "1"
                : bi.s5q702.isChecked() ? "2"
                : "-1");

        form.setS5q7a(bi.s5q7a01.isChecked() ? "1"
                : bi.s5q7a02.isChecked() ? "2"
                : bi.s5q7a03.isChecked() ? "3"
                : "-1");

        form.setS5q8(bi.s5q801.isChecked() ? "1"
                : bi.s5q802.isChecked() ? "2"
                : "-1");

        form.setS5q8a(bi.s5q8a01.isChecked() ? "1"
                : bi.s5q8a02.isChecked() ? "2"
                : bi.s5q8a03.isChecked() ? "3"
                : "-1");

        form.setS5q9(bi.s5q901.isChecked() ? "1"
                : bi.s5q902.isChecked() ? "2"
                : "-1");

        form.setS5q9a(bi.s5q9a01.isChecked() ? "1"
                : bi.s5q9a02.isChecked() ? "2"
                : bi.s5q9a03.isChecked() ? "3"
                : "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, Section06Activity.class));
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