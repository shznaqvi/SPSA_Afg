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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection13Binding;

import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;
import edu.aku.hassannaqvi.spsa_afg.ui.other.EndingActivity;
import static edu.aku.hassannaqvi.spsa_afg.CONSTANTS.FSTATUS_END_FLAG;
import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;
import static edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt.contextBackActivity;



public class Section13Activity extends AppCompatActivity {

    ActivitySection13Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section13);
        bi.setCallback(this);

        setupSkips();
    }


    private void setupSkips() {



    }

    private void SaveDraft() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("s13q1", bi.s13q101.isChecked() ? "1"
                : bi.s13q196.isChecked() ? "96"
                : bi.s13q198.isChecked() ? "98"
                :  "-1");

        json.put("s13q196x", bi.s13q196x.getText().toString());
        json.put("s13q2", bi.s13q201.isChecked() ? "666"
                : bi.s13q202.isChecked() ? ""
                : bi.s13q203.isChecked() ? ""
                :  "-1");

        json.put("s13q202x", bi.s13q202x.getText().toString());
        json.put("s13q203x", bi.s13q203x.getText().toString());
        json.put("s13q3", bi.s13q301.isChecked() ? "1"
                : bi.s13q302.isChecked() ? "2"
                : bi.s13q398.isChecked() ? "98"
                :  "-1");

        json.put("s13q4", bi.s13q401.isChecked() ? "1"
                : bi.s13q496.isChecked() ? "96"
                : bi.s13q498.isChecked() ? "98"
                :  "-1");

        json.put("s13q496x", bi.s13q496x.getText().toString());
        json.put("s13q5", bi.s13q501.isChecked() ? "1"
                : bi.s13q596.isChecked() ? "96"
                : bi.s13q598.isChecked() ? "98"
                :  "-1");

        json.put("s13q596x", bi.s13q596x.getText().toString());
        // json.put("s13q601",bi.s13q601.isChecked() ? "1" :"-1");

        json.put("s13q602",bi.s13q602.isChecked() ? "2" :"-1");

        json.put("s13q603",bi.s13q603.isChecked() ? "3" :"-1");

        json.put("s13q696",bi.s13q696.isChecked() ? "96" :"-1");

        json.put("s13q698",bi.s13q698.isChecked() ? "98" :"-1");

        json.put("s13q7", bi.s13q701.isChecked() ? "1"
                : bi.s13q702.isChecked() ? "2"
                : bi.s13q703.isChecked() ? "3"
                : bi.s13q704.isChecked() ? "4"
                : bi.s13q796.isChecked() ? "96"
                : bi.s13q798.isChecked() ? "98"
                :  "-1");

        json.put("s13q796x", bi.s13q796x.getText().toString());
        json.put("s13q8", bi.s13q801.isChecked() ? "1"
                : bi.s13q896.isChecked() ? "96"
                : bi.s13q898.isChecked() ? "98"
                :  "-1");

        json.put("s13q896x", bi.s13q896x.getText().toString());
        json.put("s13q9", bi.s13q901.isChecked() ? "1"
                : bi.s13q902.isChecked() ? "2"
                : bi.s13q903.isChecked() ? "3"
                : bi.s13q996.isChecked() ? "96"
                : bi.s13q998.isChecked() ? "98"
                :  "-1");

        json.put("s13q996x", bi.s13q996x.getText().toString());
        json.put("s13q1001",bi.s13q1001.isChecked() ? "1" :"-1");

        json.put("s13q1002",bi.s13q1002.isChecked() ? "2" :"-1");

        json.put("s13q1003",bi.s13q1003.isChecked() ? "3" :"-1");

        json.put("s13q1004",bi.s13q1004.isChecked() ? "4" :"-1");

        json.put("s13q1005",bi.s13q1005.isChecked() ? "5" :"-1");

        json.put("s13q1006",bi.s13q1006.isChecked() ? "6" :"-1");

        json.put("s13q1007",bi.s13q1007.isChecked() ? "7" :"-1");






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