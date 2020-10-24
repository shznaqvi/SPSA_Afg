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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection03Binding;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section03Activity extends AppCompatActivity {

    ActivitySection03Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section03);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        bi.s3q1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s3q102.getId() || i == bi.s3q103.getId() || i == bi.s3q1096.getId()) {
                Clear.clearAllFields(bi.llgrpsecs3q1);
            }
        }));

        bi.s3q301.setOnCheckedChangeListener(((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.llgrpsec206i);
            }
        }));

        bi.s3q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s3q402.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs3q5);
            }
        }));


        bi.s3q305.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.s3q3check, false);
            } else {
                Clear.clearAllFields(bi.s3q3check, true);
            }
        });
        bi.s3q505.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.s3q5check, false);
            } else {
                Clear.clearAllFields(bi.s3q5check, true);
            }
        });
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S03, form.s03toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {


        form.setS3q1( bi.s3q101.isChecked() ? "1"
                : bi.s3q102.isChecked() ? "2"
                : bi.s3q103.isChecked() ? "3"
                : bi.s3q1096.isChecked() ? "4"
                :  "-1");

        form.setS3q1096x(bi.s3q1096x.getText().toString());
        form.setS3q2( bi.s3q201.isChecked() ? "1"
                : bi.s3q202.isChecked() ? "2"
                :  "-1");

        form.setS3q301(bi.s3q301.isChecked() ? "1" : "-1");

        form.setS3q302(bi.s3q302.isChecked() ? "2" : "-1");

        form.setS3q303(bi.s3q303.isChecked() ? "3" : "-1");

        form.setS3q304(bi.s3q304.isChecked() ? "4" : "-1");

        form.setS3q305(bi.s3q305.isChecked() ? "5" : "-1");

        form.setS3q4( bi.s3q401.isChecked() ? "1"
                : bi.s3q402.isChecked() ? "2"
                :  "-1");

        form.setS3q501(bi.s3q501.isChecked() ? "1" : "-1");

        form.setS3q502(bi.s3q502.isChecked() ? "2" : "-1");

        form.setS3q503(bi.s3q503.isChecked() ? "3" : "-1");

        form.setS3q504(bi.s3q504.isChecked() ? "4" : "-1");

        form.setS3q505(bi.s3q505.isChecked() ? "5" : "-1");

        form.setS3q6a(bi.s3q6a.isChecked() ? "1" : "-1");

        form.setS3q6b(bi.s3q6b.isChecked() ? "2" : "-1");

        form.setS3q6c(bi.s3q6c.isChecked() ? "3" : "-1");

        form.setS3q6d(bi.s3q6d.isChecked() ? "4" : "-1");

        form.setS3q6e(bi.s3q6e.isChecked() ? "5" : "-1");

        form.setS3q696(bi.s3q696.isChecked() ? "96" : "-1");

        form.setS3q696x(bi.s3q696x.getText().toString());



        //    MainApp.fc.setsL(String.valueOf(json));

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
            startActivity(new Intent(this, MainActivity.class));
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