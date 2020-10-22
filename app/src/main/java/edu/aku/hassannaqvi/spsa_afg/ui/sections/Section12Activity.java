package edu.aku.hassannaqvi.spsa_afg.ui.sections;

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
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivitySection12Binding;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class Section12Activity extends AppCompatActivity {

    ActivitySection12Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section12);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
        bi.s12q4.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.s12q401.getId()) {
                Clear.clearAllFields(bi.fldGrpCVs12q4);
            }
        }));
        /*bi.d0201.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvd0202);
            Clear.clearAllFields(bi.cvd0203);
        }));*/

    }


    private boolean UpdateDB() {
       /* DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_S12, form.s12toString(true));
        if (updcount > 0) {
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();


        form.setS12q1(bi.s12q101.isChecked() ? "1"
                : bi.s12q102.isChecked() ? "2"
                : bi.s12q103.isChecked() ? "3"
                : "-1");

        form.setS12q2a(bi.s12q2a01.isChecked() ? "1"
                : bi.s12q2a02.isChecked() ? "2"
                : bi.s12q2a98.isChecked() ? "98"
                : bi.s12q2ad.isChecked() ? ""
                : "-1");

        form.setS12q2adx(bi.s12q2adx.getText().toString());
        form.setS12q2b(bi.s12q2b01.isChecked() ? "1"
                : bi.s12q2b02.isChecked() ? "2"
                : bi.s12q2b98.isChecked() ? "98"
                : bi.s12q2bd.isChecked() ? ""
                : "-1");

        form.setS12q2bdx(bi.s12q2bdx.getText().toString());
        form.setS12q2c(bi.s12q2c01.isChecked() ? "1"
                : bi.s12q2c02.isChecked() ? "2"
                : bi.s12q2c98.isChecked() ? "98"
                : bi.s12q2cd.isChecked() ? ""
                : "-1");

        form.setS12q2cdx(bi.s12q2cdx.getText().toString());
        form.setS12q2d(bi.s12q2d01.isChecked() ? "1"
                : bi.s12q2d02.isChecked() ? "2"
                : bi.s12q2d98.isChecked() ? "98"
                : bi.s12q2dd.isChecked() ? ""
                : "-1");

        form.setS12q2ddx(bi.s12q2ddx.getText().toString());
        form.setS12q2e(bi.s12q2e01.isChecked() ? "1"
                : bi.s12q2e02.isChecked() ? "2"
                : bi.s12qe98.isChecked() ? "98"
                : bi.s12q2ed.isChecked() ? ""
                : "-1");

        form.setS12q2edx(bi.s12q2edx.getText().toString());
        form.setS12q2f(bi.s12q2f01.isChecked() ? "1"
                : bi.s12q2f02.isChecked() ? "2"
                : bi.s12q2f98.isChecked() ? "98"
                : bi.s12q2fd.isChecked() ? ""
                : "-1");

        form.setS12q2fdx(bi.s12q2fdx.getText().toString());
        form.setS12q2g(bi.s12q2g01.isChecked() ? "1"
                : bi.s12q2g02.isChecked() ? "2"
                : bi.s12q2g98.isChecked() ? "98"
                : bi.s12q2gd.isChecked() ? ""
                : "-1");

        form.setS12q2gdx(bi.s12q2gdx.getText().toString());
        form.setS12q2h(bi.s12q2h01.isChecked() ? "1"
                : bi.s12q2h02.isChecked() ? "2"
                : bi.s12q2h98.isChecked() ? "98"
                : bi.s12q2hd.isChecked() ? ""
                : "-1");

        form.setS12q2hdx(bi.s12q2hdx.getText().toString());
        form.setS12q2i(bi.s12q2i01.isChecked() ? "1"
                : bi.s12q2i02.isChecked() ? "2"
                : bi.s12q2i98.isChecked() ? "98"
                : bi.s12q2id.isChecked() ? ""
                : "-1");

        form.setS12q2idx(bi.s12q2idx.getText().toString());
        form.setS12q2j(bi.s12q2j01.isChecked() ? "1"
                : bi.s12q2j02.isChecked() ? "2"
                : bi.s12q2j98.isChecked() ? "98"
                : bi.s12q2jd.isChecked() ? ""
                : "-1");

        form.setS12q2jdx(bi.s12q2jdx.getText().toString());
        form.setS12q2k(bi.s12q2k01.isChecked() ? "1"
                : bi.s12q2k02.isChecked() ? "2"
                : bi.s12q2k98.isChecked() ? "98"
                : bi.s12q2kd.isChecked() ? ""
                : "-1");

        form.setS12q2kdx(bi.s12q2kdx.getText().toString());
        form.setS12q2l(bi.s12q2l01.isChecked() ? "1"
                : bi.s12q2l02.isChecked() ? "2"
                : bi.s12q2l98.isChecked() ? "98"
                : bi.s12q2ld.isChecked() ? ""
                : "-1");

        form.setS12q2ldx(bi.s12q2ldx.getText().toString());
        form.setS12q2m(bi.s12q2m01.isChecked() ? "1"
                : bi.s12q2m02.isChecked() ? "2"
                : bi.s12q2m98.isChecked() ? "98"
                : bi.s12q2md.isChecked() ? ""
                : "-1");

        form.setS12q2mdx(bi.s12q2mdx.getText().toString());
        form.setS12q2n(bi.s12q2n01.isChecked() ? "1"
                : bi.s12q2n02.isChecked() ? "2"
                : bi.s12q2n98.isChecked() ? "98"
                : bi.s12q2nd.isChecked() ? ""
                : "-1");

        form.setS12q2ndx(bi.s12q2ndx.getText().toString());
        form.setS12q2o(bi.s12q2o01.isChecked() ? "1"
                : bi.s12q2o02.isChecked() ? "2"
                : bi.s12q2o98.isChecked() ? "98"
                : bi.s12q2od.isChecked() ? ""
                : "-1");

        form.setS12q2odx(bi.s12q2odx.getText().toString());
        form.setS12q301(bi.s12q301a.isChecked() ? "1"
                : bi.s12q301b.isChecked() ? "2"
                : "-1");

        form.setS12q302(bi.s12q302a.isChecked() ? "1"
                : bi.s12q302b.isChecked() ? "2"
                : "-1");

        form.setS12q303(bi.s12q303a.isChecked() ? "1"
                : bi.s12q303b.isChecked() ? "2"
                : "-1");

        form.setS12q304(bi.s12q304a.isChecked() ? "1"
                : bi.s12q304b.isChecked() ? "2"
                : "-1");

        form.setS12q305(bi.s12q305a.isChecked() ? "1"
                : bi.s12q305b.isChecked() ? "2"
                : "-1");

        form.setS12q306(bi.s12q306a.isChecked() ? "1"
                : bi.s12q306b.isChecked() ? "2"
                : "-1");

        form.setS12q307(bi.s12q307a.isChecked() ? "1"
                : bi.s12q307b.isChecked() ? "2"
                : "-1");

        form.setS12q308(bi.s12q308a.isChecked() ? "1"
                : bi.s12q308b.isChecked() ? "2"
                : bi.s12q396.isChecked() ? "96"
                : "-1");

        form.setS12q396x(bi.s12q396x.getText().toString());
        form.setS12q4(bi.s12q401.isChecked() ? "1"
                : bi.s12q402.isChecked() ? "2"
                : bi.s12q498.isChecked() ? "98"
                : "-1");

    //    form.setS12Q5TITLE1(bi.s12q5title1.isChecked() ? "" : "-1");

        form.setS12q501(bi.s12q501.isChecked() ? "1" : "-1");

        form.setS12q502(bi.s12q502.isChecked() ? "2" : "-1");

        form.setS12q503(bi.s12q503.isChecked() ? "3" : "-1");

        //    form.setS12Q5TITLE2(bi.s12q5title2.isChecked() ? "" : "-1");

        form.setS12q504(bi.s12q504.isChecked() ? "4" : "-1");

        form.setS12q505(bi.s12q505.isChecked() ? "5" : "-1");

        form.setS12q596(bi.s12q596.isChecked() ? "96" : "-1");

        form.setS12q596x(bi.s12q596x.getText().toString());
        form.setS12q601(bi.s12q601.isChecked() ? "1" : "-1");

        form.setS12q602(bi.s12q602.isChecked() ? "2" : "-1");

        form.setS12q603(bi.s12q603.isChecked() ? "3" : "-1");

        form.setS12q604(bi.s12q604.isChecked() ? "4" : "-1");

        form.setS12q696(bi.s12q696.isChecked() ? "96" : "-1");


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