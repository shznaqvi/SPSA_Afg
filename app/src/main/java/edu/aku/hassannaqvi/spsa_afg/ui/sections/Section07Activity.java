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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection07Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

public class Section07Activity extends AppCompatActivity {

    ActivitySection07Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section07);
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

        json.put("s7qa", bi.s7qa01.isChecked() ? "1"
                : bi.s7qa02.isChecked() ? "2"
                : "-1");

        json.put("s7qb", bi.s7qb01.isChecked() ? "1"
                : bi.s7qb02.isChecked() ? "2"
                : "-1");

        json.put("s7qc", bi.s7qc01.isChecked() ? "1"
                : bi.s7qc02.isChecked() ? "2"
                : "-1");

        json.put("s7qd", bi.s7qd01.isChecked() ? "1"
                : bi.s7qd02.isChecked() ? "2"
                : "-1");

        json.put("s7qe", bi.s7qe01.isChecked() ? "1"
                : bi.s7qe02.isChecked() ? "2"
                : "-1");

        json.put("s7qf", bi.s7qf01.isChecked() ? "1"
                : bi.s7qf02.isChecked() ? "2"
                : "-1");

        json.put("s7qg", bi.s7qg01.isChecked() ? "1"
                : bi.s7qg02.isChecked() ? "2"
                : "-1");

        json.put("s7qh", bi.s7qh01.isChecked() ? "1"
                : bi.s7qh02.isChecked() ? "2"
                : "-1");

        json.put("s7qi", bi.s7qi01.isChecked() ? "1"
                : bi.s7qi02.isChecked() ? "2"
                : "-1");

        json.put("s7qj", bi.s7qj01.isChecked() ? "1"
                : bi.s7qj02.isChecked() ? "2"
                : "-1");

        json.put("s7qk", bi.s7qk01.isChecked() ? "1"
                : bi.s7qk02.isChecked() ? "2"
                : "-1");

        json.put("s7ql", bi.s7ql01.isChecked() ? "1"
                : bi.s7ql02.isChecked() ? "2"
                : "-1");

        json.put("s7qm", bi.s7qm01.isChecked() ? "1"
                : bi.s7qm02.isChecked() ? "2"
                : "-1");

        json.put("s7qn", bi.s7qn01.isChecked() ? "1"
                : bi.s7qn02.isChecked() ? "2"
                : "-1");

        json.put("s7qo", bi.s7qo01.isChecked() ? "1"
                : bi.s7qo02.isChecked() ? "2"
                : "-1");

        json.put("s7qp", bi.s7qp01.isChecked() ? "1"
                : bi.s7qp02.isChecked() ? "2"
                : "-1");

        json.put("s7qq", bi.s7qq01.isChecked() ? "1"
                : bi.s7qq02.isChecked() ? "2"
                : "-1");

        json.put("s7qr", bi.s7qr01.isChecked() ? "1"
                : bi.s7qr02.isChecked() ? "2"
                : "-1");

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
            startActivity(new Intent(this, Section12Activity.class));
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