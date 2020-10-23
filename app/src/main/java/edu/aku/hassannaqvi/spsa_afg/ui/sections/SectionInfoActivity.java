package edu.aku.hassannaqvi.spsa_afg.ui.sections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.threeten.bp.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.spsa_afg.R;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.databinding.ActivityInfoSectionBinding;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.ui.other.MainActivity;
import edu.aku.hassannaqvi.spsa_afg.utils.AppUtilsKt;

import static edu.aku.hassannaqvi.spsa_afg.core.MainApp.form;

public class SectionInfoActivity extends AppCompatActivity {

    /*private static final String TAG = "";
    public static FormsContract fc;
    public List<String> talukaName, ucName, villageName, usersName, teamLeadName, healthFacilityCode;
    public List<String> talukaCode, ucCode, villageCode, usersCode, teamLeadCode, healthFacilityName;*/
    ActivityInfoSectionBinding bi;
    boolean dtFlag = false;
    LocalDate localDate = null;
    LocalDate calculatedDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_info_section);
        bi.setCallback(this);
        bi.setForm(form);
        setupSkip();
    }


    private void setupSkip() {
      /*  bi.a06.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.lla07));
        bi.a07.setOnCheckedChangeListener((radioGroup, i) -> Clear.clearAllFields(bi.lla08));*/
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


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addForm(form);
        form.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            form.set_UID(form.getDeviceID() + form.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() throws JSONException {

        form = new Form();
        form.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        form.setS1q2(MainApp.userName);
        form.setDeviceID(MainApp.appInfo.getDeviceID());
        form.setDevicetagID(MainApp.appInfo.getTagName());
        form.setAppversion(MainApp.appInfo.getAppVersion());


        form.setS1qno(bi.s1qno.getText().toString());

        form.setS1q1(bi.s1q101.isChecked() ? "1"
                : bi.s1q102.isChecked() ? "2"
                : "-1");

        form.setS1q2(bi.s1q2.getText().toString());

        form.setS1q4(bi.s1q4.getText().toString());

        form.setS1q6(bi.s1q6.getText().toString());

        form.setS1q8(bi.s1q8.getText().toString());

        form.setS1q9(bi.s1q9.getText().toString());

        form.setS1q10(bi.s1q10.getText().toString());

        form.setS1q11(bi.s1q11.getText().toString());

        form.setS1q12(bi.s1q12.getText().toString());

        form.setS1q13( bi.s1q1301.isChecked() ? "1"
                : bi.s1q1302.isChecked() ? "2"
                :  "-1");

        form.setS1q14(bi.s1q14.getText().toString());

        form.setS1q15(bi.s1q15.getText().toString());

        form.setS1q16(bi.s1q16.getText().toString());

        form.setS1q17( bi.s1q1701.isChecked() ? "1"
                : bi.s1q1702.isChecked() ? "2"
                :  "-1");

        form.setS1q18( bi.s1q1801.isChecked() ? "1"
                : bi.s1q1802.isChecked() ? "2"
                :  "-1");

        form.setS1_consent( bi.s1consent01.isChecked() ? "1"
                : bi.s1consent02.isChecked() ? "2"
                :  "-1");

        form.setS1q19et(bi.s1q19et.getText().toString());

        form.setS1q20a(bi.s1q20a.getText().toString());

        form.setS1q20b(bi.s1q20b.getText().toString());

        form.setS1q20c(bi.s1q20c.getText().toString());

        form.setS1q20d(bi.s1q20d.getText().toString());

        form.setS1q20e(bi.s1q20e.getText().toString());

    }


    private boolean formValidation() {
       /* if (!Validator.emptyCheckingContainer(this, bi.GrpName)) return false;
        if (!dtFlag) {
//            Toast.makeText(this, "Invalid date!", Toast.LENGTH_SHORT).show();
            return Validator.emptyCustomTextBox(this, bi.a13yy, "Invalid date!");
        }
        if (bi.a0702.isChecked()) return true;
        return Integer.parseInt(bi.a14mm.getText().toString()) != 0 || Integer.parseInt(bi.a14yy.getText().toString()) != 0;*/
       return true;
    }


    public void BtnEnd() {
        AppUtilsKt.openEndActivity(this);
    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        /*talukaName = new ArrayList<>();
        talukaCode = new ArrayList<>();

        talukaName.add("....");
        talukaCode.add("....");

        Collection<TalukasContract> dc = db.getTalukas();
        for (TalukasContract d : dc) {
            talukaName.add(d.getTaluka());
            talukaCode.add(d.getTalukacode());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaName);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        bi.s1q2.setAdapter(dataAdapter);

        bi.s1q2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                healthFacilityCode = new ArrayList<>();
                healthFacilityName = new ArrayList<>();


                healthFacilityCode.add("....");
                healthFacilityName.add("....");

                Collection<HealthFacilitiesContract> pc = db.getHealthFacilities(talukaCode.get(position));
                for (HealthFacilitiesContract p : pc) {
                    healthFacilityCode.add(p.getFacilityCode());
                    healthFacilityName.add(p.getFacilityName());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, healthFacilityName);

                psuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.s1q1.setAdapter(psuAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.s1q1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                villageCode = new ArrayList<>();
                villageName = new ArrayList<>();


                villageCode.add("....");
                villageName.add("....");

                Collection<VillagesContract> pc = db.getVillages(healthFacilityCode.get(position));
                for (VillagesContract p : pc) {
                    villageCode.add(p.getVillagecode());
                    villageName.add(p.getVillagename());
                }
                ArrayAdapter<String> vilAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageName);

                vilAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.s1q3.setAdapter(vilAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }


    public void a01OnTextChanged(CharSequence s, int start, int before, int count) {
        //Setting Date
       /* try {
            Instant instant = org.threeten.bp.Instant.parse(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse(bi.a01.getText().toString())) + "T06:24:01Z");
            localDate = org.threeten.bp.LocalDateTime.ofInstant(instant, org.threeten.bp.ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

   /* public void a13yyOnTextChanged(CharSequence s, int start, int before, int count) {
        bi.a14mm.setEnabled(false);
        bi.a14mm.setText(null);
        bi.a14yy.setEnabled(false);
        bi.a14yy.setText(null);
        calculatedDOB = null;
        dtFlag = true;
        if (TextUtils.isEmpty(bi.a13dd.getText()) || TextUtils.isEmpty(bi.a13mm.getText()) || TextUtils.isEmpty(bi.a13yy.getText()))
            return;
        if (!bi.a13dd.isRangeTextValidate() || !bi.a13mm.isRangeTextValidate() || !bi.a13yy.isRangeTextValidate())
            return;
        if (bi.a13dd.getText().toString().equals("98") && bi.a13mm.getText().toString().equals("98") && bi.a13yy.getText().toString().equals("9998")) {
            bi.a14mm.setEnabled(true);
            bi.a14yy.setEnabled(true);
            dtFlag = true;
            return;
        }
        int day = bi.a13dd.getText().toString().equals("98") ? 15 : Integer.parseInt(bi.a13dd.getText().toString());
        int month = Integer.parseInt(bi.a13mm.getText().toString());
        int year = Integer.parseInt(bi.a13yy.getText().toString());

        AgeModel age;
        if (localDate != null)
            age = DateRepository.Companion.getCalculatedAge(localDate, year, month, day);
        else
            age = DateRepository.Companion.getCalculatedAge(year, month, day);
        if (age == null) {
            bi.a13yy.setError("Invalid date!!");
            dtFlag = false;
            return;
        }
        dtFlag = true;
        bi.a14mm.setText(String.valueOf(age.getMonth()));
        bi.a14yy.setText(String.valueOf(age.getYear()));

        //Setting Date
        try {
            Instant instant = Instant.parse(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse(
                    bi.a13dd.getText().toString() + "-" + bi.a13mm.getText().toString() + "-" + bi.a13yy.getText().toString()
            )) + "T06:24:01Z");
            calculatedDOB = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }*/

    public static class SectionKActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_section1101);
        }
    }

}