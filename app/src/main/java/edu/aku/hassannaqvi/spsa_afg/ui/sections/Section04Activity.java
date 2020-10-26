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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection04Binding;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section04Activity extends AppCompatActivity {

    ActivitySection04Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section04);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        bi.s4q1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s4q1a02.getId()) {
                Clear.clearAllFields(bi.llgrpsec401);
            }
        }));

        bi.s4q2.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s4q2a02.getId()) {
                Clear.clearAllFields(bi.llgrpsec402);
            }
        }));

        bi.s4q3.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s4q3a02.getId()) {
                Clear.clearAllFields(bi.llgrpsec403);
            }
        }));

        bi.s4q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s4q4a02.getId()) {
                Clear.clearAllFields(bi.llgrpsec404);
            }
        }));

    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S04, form.s04toString());
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;*/
        //}
        return true;
    }


    private void SaveDraft() throws JSONException {

        form.setS4q1(bi.s4q1a01.isChecked() ? "1"
                : bi.s4q1a02.isChecked() ? "2"
                : "-1");
        form.setS4q1bx(bi.s4q1b.getText().toString());
        form.setS4q1cx(bi.s4q1c.getText().toString());

        form.setS4q2(bi.s4q2a01.isChecked() ? "1"
                : bi.s4q2a02.isChecked() ? "2"
                : "-1");
        form.setS4q2bx(bi.s4q2b.getText().toString());
        form.setS4q2cx(bi.s4q2c.getText().toString());

        form.setS4q3(bi.s4q3a01.isChecked() ? "1"
                : bi.s4q3a02.isChecked() ? "2"
                : "-1");
        form.setS4q3cx(bi.s4q3b.getText().toString());
        form.setS4q3cx(bi.s4q3c.getText().toString());

        form.setS4q4(bi.s4q4a01.isChecked() ? "1"
                : bi.s4q4a02.isChecked() ? "2"
                : "-1");
        form.setS4q4bx(bi.s4q4b.getText().toString());
        form.setS4q4cx(bi.s4q4c.getText().toString());

        form.setS4q5(bi.s4q5.getText().toString());

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