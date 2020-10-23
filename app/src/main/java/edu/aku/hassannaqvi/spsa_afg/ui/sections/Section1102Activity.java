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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection1102Binding;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section1102Activity extends AppCompatActivity {

    ActivitySection1102Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section1102);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkips();
    }


    private void setupSkips() {

        bi.s11q13.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s11q1301.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs11q14);
            }
        }));

        bi.s11q15.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s11q1501.getId()) {
                Clear.clearAllFields(bi.llgrpsec1101);
            }
        }));

    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S11, form.s11toString(true));
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;

    }


    private void SaveDraft() throws JSONException {

        form.setS11q12a( bi.s11q12a01.isChecked() ? "1"
                : bi.s11q12a02.isChecked() ? "2"
                : bi.s11q12a98.isChecked() ? "98"
                :  "-1");

        form.setS11q12b( bi.s11q12b01.isChecked() ? "1"
                : bi.s11q12b02.isChecked() ? "2"
                : bi.s11q12b98.isChecked() ? "98"
                :  "-1");

        form.setS11q12c( bi.s11q12c01.isChecked() ? "1"
                : bi.s11q12c02.isChecked() ? "2"
                : bi.s11q12c98.isChecked() ? "98"
                :  "-1");

        form.setS11q12d( bi.s11q12d01.isChecked() ? "1"
                : bi.s11q12d02.isChecked() ? "2"
                : bi.s11q12d98.isChecked() ? "98"
                :  "-1");

        form.setS11q12e( bi.s11q12e01.isChecked() ? "1"
                : bi.s11q12e02.isChecked() ? "2"
                : bi.s11q12e98.isChecked() ? "98"
                :  "-1");

        form.setS11q12f( bi.s11q12f01.isChecked() ? "1"
                : bi.s11q12f02.isChecked() ? "2"
                : bi.s11q12f98.isChecked() ? "98"
                :  "-1");

        form.setS11q12g( bi.s11q12g01.isChecked() ? "1"
                : bi.s11q12g02.isChecked() ? "2"
                : bi.s11q12g98.isChecked() ? "98"
                :  "-1");

        form.setS11q12h( bi.s11q12h01.isChecked() ? "1"
                : bi.s11q12h02.isChecked() ? "2"
                : bi.s11q12h98.isChecked() ? "98"
                :  "-1");

        form.setS11q12i( bi.s11q12i01.isChecked() ? "1"
                : bi.s11q12i02.isChecked() ? "2"
                : bi.s11q12i98.isChecked() ? "98"
                :  "-1");

        form.setS11q12j( bi.s11q12j01.isChecked() ? "1"
                : bi.s11q12j02.isChecked() ? "2"
                : bi.s11q12j98.isChecked() ? "98"
                :  "-1");

        form.setS11q12k( bi.s11q12k01.isChecked() ? "1"
                : bi.s11q12k02.isChecked() ? "2"
                : bi.s11q12k98.isChecked() ? "98"
                :  "-1");

        form.setS11q12l( bi.s11q12l01.isChecked() ? "1"
                : bi.s11q12l02.isChecked() ? "2"
                : bi.s11q12l98.isChecked() ? "98"
                :  "-1");

        form.setS11q12m( bi.s11q12m01.isChecked() ? "1"
                : bi.s11q12m02.isChecked() ? "2"
                : bi.s11q12m98.isChecked() ? "98"
                :  "-1");

        form.setS11q12n( bi.s11q12n01.isChecked() ? "1"
                : bi.s11q12n02.isChecked() ? "2"
                : bi.s11q12n98.isChecked() ? "98"
                :  "-1");

        form.setS11q12o( bi.s11q12o01.isChecked() ? "1"
                : bi.s11q12o02.isChecked() ? "2"
                : bi.s11q12o98.isChecked() ? "98"
                :  "-1");

        form.setS11q12p( bi.s11q12p01.isChecked() ? "1"
                : bi.s11q12p02.isChecked() ? "2"
                : bi.s11q12p98.isChecked() ? "98"
                :  "-1");

        form.setS11q12q( bi.s11q12q01.isChecked() ? "1"
                : bi.s11q12q02.isChecked() ? "2"
                : bi.s11q12q98.isChecked() ? "98"
                :  "-1");

        form.setS11q13( bi.s11q1301.isChecked() ? "1"
                : bi.s11q1302.isChecked() ? "2"
                : bi.s11q1398.isChecked() ? "98"
                :  "-1");

        form.setS11q14( bi.s11q1401.isChecked() ? ""
                : bi.s11q1402.isChecked() ? "98"
                :  "-1");

        form.setS11q1401x(bi.s11q1401x.getText().toString());
        form.setS11q15( bi.s11q1501.isChecked() ? "1"
                : bi.s11q1502.isChecked() ? "2"
                : bi.s11q1598.isChecked() ? "98"
                :  "-1");

        form.setS11q16( bi.s11q1601.isChecked() ? "1"
                : bi.s11q1602.isChecked() ? "2"
                : bi.s11q1603.isChecked() ? "3"
                : bi.s11q1696.isChecked() ? "96"
                :  "-1");

        form.setS11q1696x(bi.s11q1696x.getText().toString());
        form.setS11q17( bi.s11q1701.isChecked() ? "1"
                : bi.s11q1702.isChecked() ? "2"
                : bi.s11q1703.isChecked() ? "3"
                : bi.s11q1796.isChecked() ? "96"
                :  "-1");

        form.setS11q1796x(bi.s11q1796x.getText().toString());
        form.setS11q18( bi.s11q1801.isChecked() ? "1"
                : bi.s11q1802.isChecked() ? "2"
                : bi.s11q1898.isChecked() ? "98"
                :  "-1");


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