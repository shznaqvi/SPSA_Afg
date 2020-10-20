package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection09Binding;

import edu.aku.hassannaqvi.spsa_afg.ui.other.EndingActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.FSTATUS_END_FLAG;
import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;
import static edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt.contextBackActivity;


public class Section09Activity extends AppCompatActivity {



    ActivitySection09Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section09);
        bi.setForm(form);
        bi.setCallback(this);

        setupSkips();
    }

    private void setupSkips() {



    }

    private void SaveDraft()  {

        form.setS9q1(bi.s9q1.getText().toString());

        form.setS9q2(bi.s9q2.getText().toString());

        form.setS9q3( bi.s9q301.isChecked() ? "1"
                : bi.s9q302.isChecked() ? "2"
                :  "-1");

        form.setS9q401x(bi.s9q401x.getText().toString());
        form.setS9q402x(bi.s9q402x.getText().toString());
        form.setS9q501x(bi.s9q501x.getText().toString());
        form.setS9q502x(bi.s9q502x.getText().toString());
        form.setS9q6(bi.s9q6.getText().toString());





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
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd() {
        AppUtilsKt.openFormEndActivity(this, FSTATUS_END_FLAG, 2);
    }

    public void onBackPressed() {
        contextBackActivity(this);
    }

    private boolean UpdateDB() {
//        DatabaseHelper db = MainApp.appInfo.getDbHelper();
//        int updcount = db.updatesFormColumn(FormsContract.FormsTable., form.sKtoString());
//        if (updcount > 0) {
//            return true;
//        } else {
//            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


}