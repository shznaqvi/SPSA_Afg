package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection10Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section10Activity extends AppCompatActivity {

    ActivitySection10Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section10);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        bi.s10q1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s10q101.getId()) {
                Clear.clearAllFields(bi.Sec10fld);
            }
        }));

        bi.s10q3.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s10q302.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs10q4);
            }
        }));

        bi.s10q5.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s10q502.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs10q6);
            }
        }));

        bi.s10q699.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.s10q6check, false);
            } else {
                Clear.clearAllFields(bi.s10q6check, true);
            }
        });

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S10, form.s10toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
        /*return true;*/
    }


    private void SaveDraft() throws JSONException {

        form.setS10q1(bi.s10q101.isChecked() ? "1"
                : bi.s10q102.isChecked() ? "2"
                : bi.s10q198.isChecked() ? "98"
                : "-1");

        form.setS10q2(bi.s10q201.isChecked() ? "1"
                : bi.s10q202.isChecked() ? "2"
                : bi.s10q2666.isChecked() ? "666"
                : "-1");

        form.setS10q201x(bi.s10q201x.getText().toString());
        form.setS10q202x(bi.s10q202x.getText().toString());
        form.setS10q3(bi.s10q301.isChecked() ? "1"
                : bi.s10q302.isChecked() ? "2"
                : bi.s10q398.isChecked() ? "98"
                : "-1");

        form.setS10q4(bi.s10q401.isChecked() ? "1"
                : bi.s10q402.isChecked() ? "2"
                : bi.s10q403.isChecked() ? "3"
                : bi.s10q496.isChecked() ? "96"
                : "-1");

        form.setS10q496x(bi.s10q496x.getText().toString());
        form.setS10q5(bi.s10q501.isChecked() ? "1"
                : bi.s10q502.isChecked() ? "2"
                : "-1");

        form.setS10q601(bi.s10q601.isChecked() ? "1" : "-1");

        form.setS10q602(bi.s10q602.isChecked() ? "2" : "-1");

        form.setS10q603(bi.s10q603.isChecked() ? "3" : "-1");

        form.setS10q604(bi.s10q604.isChecked() ? "4" : "-1");

        form.setS10q605(bi.s10q605.isChecked() ? "5" : "-1");

        form.setS10q606(bi.s10q606.isChecked() ? "6" : "-1");

        form.setS10q607(bi.s10q607.isChecked() ? "7" : "-1");

        form.setS10q608(bi.s10q608.isChecked() ? "8" : "-1");

        form.setS10q609(bi.s10q609.isChecked() ? "9" : "-1");

        form.setS10q610(bi.s10q610.isChecked() ? "10" : "-1");

        form.setS10q696(bi.s10q696.isChecked() ? "96" : "-1");

        form.setS10q696x(bi.s10q696x.getText().toString());
        form.setS10q699(bi.s10q699.isChecked() ? "99" : "-1");

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
            startActivity(new Intent(this, Section1101Activity.class));
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