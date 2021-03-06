package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.contracts.DistrictContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.ProvinceContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VillageContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivityInfoSectionBinding;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.ui.other.EndingActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class SectionInfoActivity extends AppCompatActivity {

    ActivityInfoSectionBinding bi;
    public List<String> provinceName, districtName, villageName;
    public List<String> provinceCode, districtCode, villageCode;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_info_section);
        bi.setCallback(this);
        bi.setForm(form);
        initializingComponents();
        setupSkip();
        populateSpinner(this);
    }


    private void initializingComponents() {
        // Databinding Edit Mode (only in first activity for every contract)
        db = MainApp.appInfo.getDbHelper();
        populateSpinner(this);
    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        provinceName = new ArrayList<>();
        provinceCode = new ArrayList<>();

        provinceName.add("....");
        provinceCode.add("....");

        Collection<ProvinceContract> dc = db.getAllProvince();
        for (ProvinceContract d : dc) {
            provinceName.add(d.getProv_name());
            provinceCode.add(d.getProv_code());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, provinceName);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        bi.s1q6.setAdapter(dataAdapter);

        bi.s1q6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                districtCode = new ArrayList<>();
                districtName = new ArrayList<>();

                districtCode.add("....");
                districtName.add("....");

                Collection<DistrictContract> dc = db.getAllDistricts(provinceCode.get(position));
                for (DistrictContract d : dc) {
                    districtCode.add(d.getDistrictCode());
                    districtName.add(d.getDistrictName());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, districtName);

                psuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.s1q8.setAdapter(psuAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.s1q8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                villageCode = new ArrayList<>();
                villageName = new ArrayList<>();

                villageCode.add("....");
                villageName.add("....");

                Collection<VillageContract> pc = db.getAllVillages(districtCode.get(position));
                for (VillageContract p : pc) {
                    villageCode.add(p.getVillageCode());
                    villageName.add(p.getVillageName());
                }
                ArrayAdapter<String> vilAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageName);

                vilAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.s1q10.setAdapter(vilAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void setupSkip() {

        bi.s1consent.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.s1consent02.getId()) {
                Clear.clearAllFields(bi.llGrpsec02);
            }
        }));

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
            startActivity(new Intent(this, bi.s1consent02.isChecked() ? EndingActivity.class
                    : Section021Activity.class).putExtra("complete", false));
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            form.set_UID(form.getDeviceID() + form.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SINFO, form.sInfotoString());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() {

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(new Date().getTime()));
        form.setUsername2(MainApp.loginMem[2]);
        form.setUsername1(MainApp.loginMem[1]);
        form.setS1q2(MainApp.loginMem[1]);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());
        form.setS1q19et(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.ENGLISH).format(new Date().getTime()));
        MainApp.setGPS(this);

        form.setS1qno(bi.s1qno.getText().toString().trim().isEmpty() ? "-1" : bi.s1qno.getText().toString());

        form.setS1q1(bi.s1q101.isChecked() ? "1"
                : bi.s1q102.isChecked() ? "2"
                : "-1");

        //    form.setS1q2(bi.s1q2.getText().toString().trim().isEmpty() ? "-1" : bi.s1q2.getText().toString());

        form.setS1q4(bi.s1q4.getText().toString().trim().isEmpty() ? "-1" : bi.s1q4.getText().toString());

        form.setS1q6(bi.s1q6.getSelectedItem().toString());
        form.setS1q8(bi.s1q8.getSelectedItem().toString());

        form.setS1q10(bi.s1q10.getSelectedItem().toString());

        form.setS1q11(bi.s1q11.getText().toString().trim().isEmpty() ? "-1" : bi.s1q11.getText().toString());

        form.setS1q12(bi.s1q12.getText().toString().trim().isEmpty() ? "-1" : bi.s1q12.getText().toString());

        form.setS1q13(bi.s1q1301.isChecked() ? "1"
                : bi.s1q1302.isChecked() ? "2"
                : "-1");

        form.setS1q14(bi.s1q14.getText().toString().trim().isEmpty() ? "-1" : bi.s1q14.getText().toString());

        form.setS1q15(bi.s1q15.getText().toString().trim().isEmpty() ? "-1" : bi.s1q15.getText().toString());

        form.setS1q16(bi.s1q16.getText().toString().trim().isEmpty() ? "-1" : bi.s1q16.getText().toString());

        form.setS1q17(bi.s1q1701.isChecked() ? "1"
                : bi.s1q1702.isChecked() ? "2"
                : "-1");

        form.setS1q18(bi.s1q1801.isChecked() ? "1"
                : bi.s1q1802.isChecked() ? "2"
                : "-1");

        form.setS1_consent(bi.s1consent01.isChecked() ? "1"
                : bi.s1consent02.isChecked() ? "2"
                : "-1");

        //    form.setS1q19et(bi.s1q19et.getText().toString().trim().isEmpty() ? "-1" : bi.s1q19et.getText().toString());

        form.setS1q20a(bi.s1q20a.getText().toString().trim().isEmpty() ? "-1" : bi.s1q20a.getText().toString());

        form.setS1q20b(bi.s1q20b.getText().toString().trim().isEmpty() ? "-1" : bi.s1q20b.getText().toString());

        form.setS1q20c(bi.s1q20c.getText().toString().trim().isEmpty() ? "-1" : bi.s1q20c.getText().toString());

        form.setS1q20d(bi.s1q20d.getText().toString().trim().isEmpty() ? "-1" : bi.s1q20d.getText().toString());

        form.setS1q20e(bi.s1q20e.getText().toString().trim().isEmpty() ? "-1" : bi.s1q20e.getText().toString());

    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        // For Child <6 and 6-23 Months
        int totalchild = (TextUtils.isEmpty(bi.s1q20a.getText()) ? 0 : Integer.parseInt(bi.s1q20a.getText().toString().trim()))
                + (TextUtils.isEmpty(bi.s1q20b.getText()) ? 0 : Integer.parseInt(bi.s1q20b.getText().toString().trim()));

        if ((totalchild == 0 && bi.s1consent01.isChecked())) {
            return Validator.emptyCustomTextBox(this, bi.s1q20a, "Total cont cannot be 0");
        }

        // For Pregnant and Lactating Women
        int totalwomen = (TextUtils.isEmpty(bi.s1q20c.getText()) ? 0 : Integer.parseInt(bi.s1q20c.getText().toString().trim()))
                + (TextUtils.isEmpty(bi.s1q20d.getText()) ? 0 : Integer.parseInt(bi.s1q20d.getText().toString().trim()));

        if ((totalwomen == 0 && bi.s1consent01.isChecked())) {
            return Validator.emptyCustomTextBox(this, bi.s1q20c, "Total cont cannot be 0");
        }

        // For Total Member Sum
        int totalmember = (TextUtils.isEmpty(bi.s1q20a.getText()) ? 0 : Integer.parseInt(bi.s1q20a.getText().toString().trim()))
                + (TextUtils.isEmpty(bi.s1q20b.getText()) ? 0 : Integer.parseInt(bi.s1q20b.getText().toString().trim()))
                + (TextUtils.isEmpty(bi.s1q20c.getText()) ? 0 : Integer.parseInt(bi.s1q20c.getText().toString().trim()))
                + (TextUtils.isEmpty(bi.s1q20d.getText()) ? 0 : Integer.parseInt(bi.s1q20d.getText().toString().trim()));

        if (totalmember == 0 && bi.s1consent01.isChecked()) {
            return Validator.emptyCustomTextBox(this, bi.s1q20e, "Invalid Total Count Please check again");
        } else if (bi.s1consent01.isChecked() && totalmember > Integer.parseInt(bi.s1q20e.getText().toString())) {
            return Validator.emptyCustomTextBox(this, bi.s1q20e, "Total Members is Incorrect");
        }

        return true;

    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }

}