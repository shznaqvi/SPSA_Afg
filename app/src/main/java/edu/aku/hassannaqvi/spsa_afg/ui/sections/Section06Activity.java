package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection06Binding;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.FSTATUS_END_FLAG;
import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;
import static edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt.contextBackActivity;


public class Section06Activity extends AppCompatActivity {

    ActivitySection06Binding bi;
    Spinner[] userSpinners;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section06);
        bi.setCallback(this);
        bi.setForm(form);
        setupContent();
        setupSkips();
    }

    private void setupContent() {
        db = new DatabaseHelper(this);
        userSpinners = new Spinner[]{bi.s6mea1, bi.s6mea2};
        for (Spinner singleSpinner : userSpinners) {
            singleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MainApp.loginMem));
        }
    }


    private void setupSkips() {

    }


    private void SaveDraft() {

        form.setS6mea1(bi.s6mea1.getSelectedItem().toString());

        form.setS6q1a(bi.s6q1a.getText().toString());
        form.setS6q2a(bi.s6q2a.getText().toString());
        form.setS6q3a(bi.s6q3a.getText().toString());

        form.setS6mea2(bi.s6mea2.getSelectedItem().toString());

        form.setS6q1b(bi.s6q1b.getText().toString());
        form.setS6q2b(bi.s6q2b.getText().toString());
        form.setS6q3b(bi.s6q3b.getText().toString());

    }


    public void onBackPressed() {
        contextBackActivity(this);
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
            startActivity(new Intent(this, Section07Activity.class));
        }
    }


    public void BtnEnd() {
        AppUtilsKt.openFormEndActivity(this, FSTATUS_END_FLAG, 2);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S06, form.s06toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
        /*return true;*/
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }

}