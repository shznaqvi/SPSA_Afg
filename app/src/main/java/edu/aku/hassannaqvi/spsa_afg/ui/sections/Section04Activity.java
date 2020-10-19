package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection04Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

public class Section04Activity extends AppCompatActivity {

    ActivitySection04Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        /*bi.d0201.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvd0202);
            Clear.clearAllFields(bi.cvd0203);
        }));*/

    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SL, MainApp.fc.getsD());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("s4q1", bi.s4q1a01.isChecked() ? "1"
                : bi.s4q1a02.isChecked() ? "2"
                : bi.s4q1b.isChecked() ? ""
                : bi.s4q1c.isChecked() ? ""
                : "-1");
        json.put("s4q1bx", bi.s4q1bx.getText().toString());
        json.put("s4q1cx", bi.s4q1cx.getText().toString());

        json.put("s4q2", bi.s4q2aa.isChecked() ? "1"
                : bi.s4q2ab.isChecked() ? "2"
                : bi.s4q2b.isChecked() ? ""
                : bi.s4q2c.isChecked() ? ""
                : "-1");
        json.put("s4q2bx", bi.s4q2bx.getText().toString());
        json.put("s4q2cx", bi.s4q2cx.getText().toString());

        json.put("s4q3", bi.s4q3aa.isChecked() ? "1"
                : bi.s4q3ab.isChecked() ? "2"
                : bi.s4q3b.isChecked() ? ""
                : bi.s4q3c.isChecked() ? ""
                : "-1");
        json.put("s4q3bx", bi.s4q3bx.getText().toString());
        json.put("s4q3cx", bi.s4q3cx.getText().toString());

        json.put("s4q4", bi.s4q4aa.isChecked() ? "1"
                : bi.s4q4ab.isChecked() ? "2"
                : bi.s4q4b.isChecked() ? ""
                : bi.s4q4c.isChecked() ? ""
                : "-1");
        json.put("s4q4bx", bi.s4q4bx.getText().toString());
        json.put("s4q4cx", bi.s4q4cx.getText().toString());

        json.put("s4q5", bi.s4q5.getText().toString());

        //    MainApp.fc.setsL(String.valueOf(json));

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
            startActivity(new Intent(this, Section05Activity.class));
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