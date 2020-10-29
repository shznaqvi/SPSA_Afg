package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection09Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.FSTATUS_END_FLAG;
import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;
import static edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt.contextBackActivity;


public class Section09Activity extends AppCompatActivity {

    ActivitySection09Binding bi;
    Spinner[] userSpinners;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section09);
        bi.setForm(form);
        bi.setCallback(this);
        setupSkips();
        setupContent();
    }

    private void setupContent() {
        db = new DatabaseHelper(this);
        userSpinners = new Spinner[]{bi.s6q4aab, bi.s6q5aab, bi.s6q6ab, bi.s6q4abb, bi.s6q5abb};
        for (Spinner singleSpinner : userSpinners) {
            singleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MainApp.loginMem));
        }
    }


    private void setupSkips() {


    }


    private void SaveDraft() {

        form.setS9q1(bi.s9q1.getText().toString());

        form.setS9q2(bi.s9q2.getText().toString());

        form.setS9q3(bi.s9q301.isChecked() ? "1"
                : bi.s9q302.isChecked() ? "2"
                : "-1");

        form.setS9q4a(bi.s9q4a.getText().toString());
        form.setS9q4b(bi.s9q4b.getText().toString());
        form.setS9q5a(bi.s9q5a.getText().toString());
        form.setS9q5b(bi.s9q5b.getText().toString());
        form.setS9q6a(bi.s9q6a.getText().toString());

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
            startActivity(new Intent(this, Section10Activity.class));
        }
    }


    public void BtnEnd() {
        AppUtilsKt.openFormEndActivity(this, FSTATUS_END_FLAG, 2);
    }


    public void onBackPressed() {
        contextBackActivity(this);
    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S09, form.s09toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }

}