package edu.aku.hassannaqvi.spsa_afg.models;

import android.database.Cursor;

import androidx.lifecycle.LiveData;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract.FormsTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class Form extends LiveData<Form> {

    private final String projectName = "spsa_afg";
    public String s1qno;
    public String s1q1;
    public String s1q2;
    public String s1q4;
    public String s1q6;
    public String s1q8;
    public String s1q9;
    public String s1q10;
    public String s1q11;
    public String s1q12;
    public String s1q13;
    public String s1q14;
    public String s1q15;
    public String s1q16;
    public String s1q17;
    public String s1q18;
    public String s1_consent;
    public String s1q19et;
    public String s1q20a;
    public String s1q20b;
    public String s1q20c;
    public String s1q20d;
    public String s1q20e;
    public String s2q1;
    public String s2q196x;
    public String s2q2;
    public String s2q296x;
    public String s2q3;
    public String s2q396x;
    public String s2q4;
    public String s2q5;
    public String s2q596x;
    public String s2q6;
    public String s2q696x;
    public String s2q7;
    public String s2q8;
    public String s2q801x;
    public String s2q9a;
    public String s2q9b;
    public String s2q9c;
    public String s2q9d;
    public String s2q9e;
    public String s2q9f;
    public String s2q9g;
    public String s2q9h;
    public String s2q9i;
    public String s2q9j;
    public String s2q9k;
    public String s2q9l;
    public String s2q9m;
    public String s2q9n;
    public String s2q9o;
    public String s2q9p;
    public String s2q9q;
    public String s2q9r;
    public String s2q9s;
    public String s2q10a;
    public String s2q10b;
    public String s2q10c;
    public String s2q10d;
    public String s2q10e;
    public String s2q10f;
    public String s2q10g;
    public String s2q10h;
    public String s2q10i;
    public String s2q11;
    public String s2q1196x;
    public String s2q12;
    public String s2q1296x;
    public String s2q13;
    public String s2q1396x;
    public String s2q14;
    public String s2q1496x;
    public String s2q15;
    public String s2q16;
    public String s2q17;
    public String s2q1701x;
    public String s2q1702x;
    public String s2q1703x;
    public String s2q18;
    public String s2q1901;
    public String s2q1902;
    public String s2q1903;
    public String s2q1904;
    public String s2q1905;
    public String s2q1906;
    public String s2q1907;
    public String s2q20;
    public String s3q1;
    public String s3q1096x;
    public String s3q2;
    public String s3q3;
    public String s3q301;
    public String s3q302;
    public String s3q303;
    public String s3q304;
    public String s3q305;
    public String s3q4;
    public String s3q5;
    public String s3q501;
    public String s3q502;
    public String s3q503;
    public String s3q504;
    public String s3q505;
    public String s3q6;
    public String s3q6a;
    public String s3q6b;
    public String s3q6c;
    public String s3q6d;
    public String s3q6e;
    public String s3q696;
    public String s3q696x;
    public String s4q1;
    public String s4q1b;
    public String s4q1c;
    public String s4q2;
    public String s4q2b;
    public String s4q2c;
    public String s4q3;
    public String s4q3b;
    public String s4q3c;
    public String s4q4;
    public String s4q4b;
    public String s4q4c;
    public String s4q5;
    public String s5q1;
    public String s5q1a;
    public String s5q2;
    public String s5q2a;
    public String s5q3;
    public String s5q3a;
    public String s5q4;
    public String s5q4a;
    public String s5q5;
    public String s5q5a;
    public String s5q6;
    public String s5q6a;
    public String s5q7;
    public String s5q7a;
    public String s5q8;
    public String s5q8a;
    public String s5q9;
    public String s5q9a;
    public String s6mea1;
    public String s6mea2;
    public String s6q1a;
    public String s6q1b;
    public String s6q2a;
    public String s6q2b;
    public String s6q3a;
    public String s6q3b;
    public String s7qa;
    public String s7qb;
    public String s7qc;
    public String s7qd;
    public String s7qe;
    public String s7qf;
    public String s7qg;
    public String s7qh;
    public String s7qi;
    public String s7qj;
    public String s7qk;
    public String s7ql;
    public String s7qm;
    public String s7qn;
    public String s7qo;
    public String s7qp;
    public String s7qq;
    public String s7qr;
    public String s8q1;
    public String s8q1a;
    public String s8q2;
    public String s8q2a;
    public String s8q2b;
    public String s8q2b01;
    public String s8q2b02;
    public String s8q2b03;
    public String s8q2b04;
    public String s8q2b05;
    public String s8q2b96;
    public String s8q2b96x;
    public String s8q2c;
    public String s8q2c01;
    public String s8q2c02;
    public String s8q2c03;
    public String s8q2c04;
    public String s8q2c96;
    public String s8q2c96x;
    public String s8q3;
    public String s8q3a;
    public String s8q3a01x;
    public String s8q4;
    public String s8q4a;
    public String s8q4a01x;
    public String s8q5;
    public String s8q6;
    public String s8q7;
    public String s8q7a;
    public String s8q7a01x;
    public String s8q7a02x;
    public String s8q8;
    public String s8q801;
    public String s8q802;
    public String s8q803;
    public String s8q804;
    public String s8q805;
    public String s8q806;
    public String s8q896;
    public String s8q896x;
    public String s8q899;
    public String s8q9;
    public String s8q996x;
    public String s8q10;
    public String s8q1001x;
    public String s8q1198;
    public String s8q1101;
    public String s8q1102;
    public String s8q1103;
    public String s8q12;
    public String s8q1296x;
    public String s8q13;
    public String s8q1396x;
    public String s9q1;
    public String s9q2;
    public String s9q3;
    public String s9mea1;
    public String s9mea2;
    public String s9q4a;
    public String s9q4b;
    public String s9q5a;
    public String s9q5b;
    public String s9q6a;
    public String s10title;
    public String s10q1;
    public String s10q2;
    public String s10q201x;
    public String s10q202x;
    public String s10q3;
    public String s10q4;
    public String s10q496x;
    public String s10q5;
    public String s10q6;
    public String s10q601;
    public String s10q602;
    public String s10q603;
    public String s10q604;
    public String s10q605;
    public String s10q606;
    public String s10q607;
    public String s10q608;
    public String s10q609;
    public String s10q610;
    public String s10q696;
    public String s10q696x;
    public String s10q699;
    public String s11q7;
    public String s11q7a;
    public String s11q8;
    public String s11q9;
    public String s11q10a;
    public String s11q10b;
    public String s11q10b01x;
    public String s11q10c;
    public String s11q10c01x;
    public String s11q10d;
    public String s11q10e;
    public String s11q10f;
    public String s11q10f01x;
    public String s11q10g;
    public String s11q10h;
    public String s11q10i;
    public String s11q12a;
    public String s11q12b;
    public String s11q12c;
    public String s11q12d;
    public String s11q12e;
    public String s11q12f;
    public String s11q12g;
    public String s11q12h;
    public String s11q12i;
    public String s11q12j;
    public String s11q12k;
    public String s11q12l;
    public String s11q12m;
    public String s11q12n;
    public String s11q12o;
    public String s11q12p;
    public String s11q12q;
    public String s11q13;
    public String s11q14;
    public String s11q1401x;
    public String s11q15;
    public String s11q16;
    public String s11q1696x;
    public String s11q17;
    public String s11q1796x;
    public String s11q18;
    public String s12q1;
    public String s12q2a;
    public String s12q2a01x;
    public String s12q2b;
    public String s12q2b01x;
    public String s12q2c;
    public String s12q2c01x;
    public String s12q2d;
    public String s12q2d01x;
    public String s12q2e;
    public String s12q2e01x;
    public String s12q2f;
    public String s12q2f01x;
    public String s12q2g;
    public String s12q2g01x;
    public String s12q2h;
    public String s12q2h01x;
    public String s12q2i;
    public String s12q2i01x;
    public String s12q2j;
    public String s12q2j01x;
    public String s12q2k;
    public String s12q2k01x;
    public String s12q2l;
    public String s12q2l01x;
    public String s12q2m;
    public String s12q2m01x;
    public String s12q2n;
    public String s12q2n01x;
    public String s12q2o;
    public String s12q2o01x;
    public String s12q301;
    public String s12q302;
    public String s12q303;
    public String s12q304;
    public String s12q305;
    public String s12q306;
    public String s12q307;
    public String s12q308;
    public String s12q396;
    public String s12q4;
    public String s12q5;
    public String s12q501;
    public String s12q502;
    public String s12q503;
    public String s12q504;
    public String s12q505;
    public String s12q596;
    public String s12q596x;
    public String s12q6;
    public String s12q601;
    public String s12q602;
    public String s12q603;
    public String s12q604;
    public String s12q696;
    public String s12q696x;
    public String s13q1;
    public String s13q196x;
    public String s13q2;
    public String s13q201x;
    public String s13q202x;
    public String s13q3;
    public String s13q4;
    public String s13q496x;
    public String s13q5;
    public String s13q596x;
    public String s13q601;
    public String s13q602;
    public String s13q603;
    public String s13q696;
    public String s13q696x;
    public String s13q698;
    public String s13q7;
    public String s13q796x;
    public String s13q8;
    public String s13q896x;
    public String s13q9;
    public String s13q996x;
    public String s13q10;
    public String s13q1001;
    public String s13q1002;
    public String s13q1003;
    public String s13q1004;
    public String s13q1005;
    public String s13q1006;
    public String s13q1007;
    private String _ID = "";
    private String _UID = "";
    private String username = "";
    private String sysdate = "";
    private String formdate = "";
    private String formtype = "";
    private String sInfo = "";
    private String s02 = "";
    private String s03 = "";
    private String s04 = "";
    private String s05 = "";
    private String s06 = "";
    private String s07 = "";
    private String s08 = "";
    private String s09 = "";
    private String s10 = "";
    private String s11 = "";
    private String s12 = "";
    private String s13 = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsdate = "";
    private String gpsacc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String istatus = ""; // Interview Status
    private String istatus96x = ""; // Interview Status
    private String endingdatetime = "";
    private String refno = ""; // Reference Number


    public Form() {
    }


    public String getProjectName() {
        return projectName;
    }


    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }


    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }


    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }


    public String getFormtype() {
        return formtype;
    }

    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }


    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }


    public String getGpsdate() {
        return gpsdate;
    }

    public void setGpsdate(String gpsdate) {
        this.gpsdate = gpsdate;
    }


    public String getGpsacc() {
        return gpsacc;
    }

    public void setGpsacc(String gpsacc) {
        this.gpsacc = gpsacc;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }


    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }


    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }


    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus96x() {
        return istatus96x;
    }

    public void setIstatus96x(String istatus96x) {
        this.istatus96x = istatus96x;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }


    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }


    public String gets02() {
        return s02;
    }

    public void sets02(String s02) {
        this.s02 = s02;
    }


    public String gets03() {
        return s03;
    }

    public void sets03(String s03) {
        this.s03 = s03;
    }


    public String gets04() {
        return s04;
    }

    public void sets04(String s04) {
        this.s04 = s04;
    }


    public String gets05() {
        return s05;
    }

    public void sets05(String s05) {
        this.s05 = s05;
    }


    public String gets06() {
        return s06;
    }

    public void sets06(String s06) {
        this.s06 = s06;
    }


    public String gets07() {
        return s07;
    }

    public void sets07(String s07) {
        this.s07 = s07;
    }


    public String gets08() {
        return s08;
    }

    public void sets08(String s08) {
        this.s08 = s08;
    }


    public String gets09() {
        return s09;
    }

    public void sets09(String s09) {
        this.s09 = s09;
    }


    public String gets10() {
        return s10;
    }

    public void sets10(String s10) {
        this.s10 = s10;
    }


    public String gets11() {
        return s11;
    }

    public void sets11(String s11) {
        this.s11 = s11;
    }


    public String gets12() {
        return s12;
    }

    public void sets12(String s12) {
        this.s12 = s12;
    }


    public String gets13() {
        return s13;
    }

    public void sets13(String s13) {
        this.s13 = s13;
    }


    public String getS2q1() {
        return s2q1;
    }

    public void setS2q1(String s2q1) {
        this.s2q1 = s2q1;
    }

    public String getS2q196x() {
        return s2q196x;
    }

    public void setS2q196x(String s2q196x) {
        this.s2q196x = s2q196x;
    }

    public String getS2q2() {
        return s2q2;
    }

    public void setS2q2(String s2q2) {
        this.s2q2 = s2q2;
    }

    public String getS2q296x() {
        return s2q296x;
    }

    public void setS2q296x(String s2q296x) {
        this.s2q296x = s2q296x;
    }

    public String getS2q3() {
        return s2q3;
    }

    public void setS2q3(String s2q3) {
        this.s2q3 = s2q3;
    }

    public String getS2q396x() {
        return s2q396x;
    }

    public void setS2q396x(String s2q396x) {
        this.s2q396x = s2q396x;
    }

    public String getS2q4() {
        return s2q4;
    }

    public void setS2q4(String s2q4) {
        this.s2q4 = s2q4;
    }

    public String getS2q5() {
        return s2q5;
    }

    public void setS2q5(String s2q5) {
        this.s2q5 = s2q5;
    }

    public String getS2q596x() {
        return s2q596x;
    }

    public void setS2q596x(String s2q596x) {
        this.s2q596x = s2q596x;
    }

    public String getS2q6() {
        return s2q6;
    }

    public void setS2q6(String s2q6) {
        this.s2q6 = s2q6;
    }

    public String getS2q696x() {
        return s2q696x;
    }

    public void setS2q696x(String s2q696x) {
        this.s2q696x = s2q696x;
    }

    public String getS2q7() {
        return s2q7;
    }

    public void setS2q7(String s2q7) {
        this.s2q7 = s2q7;
    }

    public String getS2q8() {
        return s2q8;
    }

    public void setS2q8(String s2q8) {
        this.s2q8 = s2q8;
    }

    public String getS2q801x() {
        return s2q801x;
    }

    public void setS2q801x(String s2q801x) {
        this.s2q801x = s2q801x;
    }

    public String getS2q9a() {
        return s2q9a;
    }

    public void setS2q9a(String s2q9a) {
        this.s2q9a = s2q9a;
    }

    public String getS2q9b() {
        return s2q9b;
    }

    public void setS2q9b(String s2q9b) {
        this.s2q9b = s2q9b;
    }

    public String getS2q9c() {
        return s2q9c;
    }

    public void setS2q9c(String s2q9c) {
        this.s2q9c = s2q9c;
    }

    public String getS2q9d() {
        return s2q9d;
    }

    public void setS2q9d(String s2q9d) {
        this.s2q9d = s2q9d;
    }

    public String getS2q9e() {
        return s2q9e;
    }

    public void setS2q9e(String s2q9e) {
        this.s2q9e = s2q9e;
    }

    public String getS2q9f() {
        return s2q9f;
    }

    public void setS2q9f(String s2q9f) {
        this.s2q9f = s2q9f;
    }

    public String getS2q9g() {
        return s2q9g;
    }

    public void setS2q9g(String s2q9g) {
        this.s2q9g = s2q9g;
    }

    public String getS2q9h() {
        return s2q9h;
    }

    public void setS2q9h(String s2q9h) {
        this.s2q9h = s2q9h;
    }

    public String getS2q9i() {
        return s2q9i;
    }

    public void setS2q9i(String s2q9i) {
        this.s2q9i = s2q9i;
    }

    public String getS2q9j() {
        return s2q9j;
    }

    public void setS2q9j(String s2q9j) {
        this.s2q9j = s2q9j;
    }

    public String getS2q9k() {
        return s2q9k;
    }

    public void setS2q9k(String s2q9k) {
        this.s2q9k = s2q9k;
    }

    public String getS2q9l() {
        return s2q9l;
    }

    public void setS2q9l(String s2q9l) {
        this.s2q9l = s2q9l;
    }

    public String getS2q9m() {
        return s2q9m;
    }

    public void setS2q9m(String s2q9m) {
        this.s2q9m = s2q9m;
    }

    public String getS2q9n() {
        return s2q9n;
    }

    public void setS2q9n(String s2q9n) {
        this.s2q9n = s2q9n;
    }

    public String getS2q9o() {
        return s2q9o;
    }

    public void setS2q9o(String s2q9o) {
        this.s2q9o = s2q9o;
    }

    public String getS2q9p() {
        return s2q9p;
    }

    public void setS2q9p(String s2q9p) {
        this.s2q9p = s2q9p;
    }

    public String getS2q9q() {
        return s2q9q;
    }

    public void setS2q9q(String s2q9q) {
        this.s2q9q = s2q9q;
    }

    public String getS2q9r() {
        return s2q9r;
    }

    public void setS2q9r(String s2q9r) {
        this.s2q9r = s2q9r;
    }

    public String getS2q9s() {
        return s2q9s;
    }

    public void setS2q9s(String s2q9s) {
        this.s2q9s = s2q9s;
    }

    public String getS2q10a() {
        return s2q10a;
    }

    public void setS2q10a(String s2q10a) {
        this.s2q10a = s2q10a;
    }

    public String getS2q10b() {
        return s2q10b;
    }

    public void setS2q10b(String s2q10b) {
        this.s2q10b = s2q10b;
    }

    public String getS2q10c() {
        return s2q10c;
    }

    public void setS2q10c(String s2q10c) {
        this.s2q10c = s2q10c;
    }

    public String getS2q10d() {
        return s2q10d;
    }

    public void setS2q10d(String s2q10d) {
        this.s2q10d = s2q10d;
    }

    public String getS2q10e() {
        return s2q10e;
    }

    public void setS2q10e(String s2q10e) {
        this.s2q10e = s2q10e;
    }

    public String getS2q10f() {
        return s2q10f;
    }

    public void setS2q10f(String s2q10f) {
        this.s2q10f = s2q10f;
    }

    public String getS2q10g() {
        return s2q10g;
    }

    public void setS2q10g(String s2q10g) {
        this.s2q10g = s2q10g;
    }

    public String getS2q10h() {
        return s2q10h;
    }

    public void setS2q10h(String s2q10h) {
        this.s2q10h = s2q10h;
    }

    public String getS2q10i() {
        return s2q10i;
    }

    public void setS2q10i(String s2q10i) {
        this.s2q10i = s2q10i;
    }

    public String getS2q11() {
        return s2q11;
    }

    public void setS2q11(String s2q11) {
        this.s2q11 = s2q11;
    }

    public String getS2q1196x() {
        return s2q1196x;
    }

    public void setS2q1196x(String s2q1196x) {
        this.s2q1196x = s2q1196x;
    }

    public String getS2q12() {
        return s2q12;
    }

    public void setS2q12(String s2q12) {
        this.s2q12 = s2q12;
    }

    public String getS2q1296x() {
        return s2q1296x;
    }

    public void setS2q1296x(String s2q1296x) {
        this.s2q1296x = s2q1296x;
    }

    public String getS2q13() {
        return s2q13;
    }

    public void setS2q13(String s2q13) {
        this.s2q13 = s2q13;
    }

    public String getS2q1396x() {
        return s2q1396x;
    }

    public void setS2q1396x(String s2q1396x) {
        this.s2q1396x = s2q1396x;
    }

    public String getS2q14() {
        return s2q14;
    }

    public void setS2q14(String s2q14) {
        this.s2q14 = s2q14;
    }

    public String getS2q1496x() {
        return s2q1496x;
    }

    public void setS2q1496x(String s2q1496x) {
        this.s2q1496x = s2q1496x;
    }

    public String getS2q15() {
        return s2q15;
    }

    public void setS2q15(String s2q15) {
        this.s2q15 = s2q15;
    }

    public String getS2q16() {
        return s2q16;
    }

    public void setS2q16(String s2q16) {
        this.s2q16 = s2q16;
    }

    public String getS2q17() {
        return s2q17;
    }

    public void setS2q17(String s2q17) {
        this.s2q17 = s2q17;
    }

    public String getS2q1701x() {
        return s2q1701x;
    }

    public void setS2q1701x(String s2q1701x) {
        this.s2q1701x = s2q1701x;
    }

    public String getS2q1702x() {
        return s2q1702x;
    }

    public void setS2q1702x(String s2q1702x) {
        this.s2q1702x = s2q1702x;
    }

    public String getS2q1703x() {
        return s2q1703x;
    }

    public void setS2q1703x(String s2q1703x) {
        this.s2q1703x = s2q1703x;
    }

    public String getS2q18() {
        return s2q18;
    }

    public void setS2q18(String s2q18) {
        this.s2q18 = s2q18;
    }

    public String getS2q1901() {
        return s2q1901;
    }

    public void setS2q1901(String s2q1901) {
        this.s2q1901 = s2q1901;
    }

    public String getS2q1902() {
        return s2q1902;
    }

    public void setS2q1902(String s2q1902) {
        this.s2q1902 = s2q1902;
    }

    public String getS2q1903() {
        return s2q1903;
    }

    public void setS2q1903(String s2q1903) {
        this.s2q1903 = s2q1903;
    }

    public String getS2q1904() {
        return s2q1904;
    }

    public void setS2q1904(String s2q1904) {
        this.s2q1904 = s2q1904;
    }

    public String getS2q1905() {
        return s2q1905;
    }

    public void setS2q1905(String s2q1905) {
        this.s2q1905 = s2q1905;
    }

    public String getS2q1906() {
        return s2q1906;
    }

    public void setS2q1906(String s2q1906) {
        this.s2q1906 = s2q1906;
    }

    public String getS2q1907() {
        return s2q1907;
    }

    public void setS2q1907(String s2q1907) {
        this.s2q1907 = s2q1907;
    }

    public String getS2q20() {
        return s2q20;
    }

    public void setS2q20(String s2q20) {
        this.s2q20 = s2q20;
    }

    public String getS3q1() {
        return s3q1;
    }

    public void setS3q1(String s3q1) {
        this.s3q1 = s3q1;
    }

    public String getS3q1096x() {
        return s3q1096x;
    }

    public void setS3q1096x(String s3q1096x) {
        this.s3q1096x = s3q1096x;
    }

    public String getS3q2() {
        return s3q2;
    }

    public void setS3q2(String s3q2) {
        this.s3q2 = s3q2;
    }

    public String getS3q3() {
        return s3q3;
    }

    public void setS3q3(String s3q3) {
        this.s3q3 = s3q3;
    }

    public String getS3q301() {
        return s3q301;
    }

    public void setS3q301(String s3q301) {
        this.s3q301 = s3q301;
    }

    public String getS3q302() {
        return s3q302;
    }

    public void setS3q302(String s3q302) {
        this.s3q302 = s3q302;
    }

    public String getS3q303() {
        return s3q303;
    }

    public void setS3q303(String s3q303) {
        this.s3q303 = s3q303;
    }

    public String getS3q304() {
        return s3q304;
    }

    public void setS3q304(String s3q304) {
        this.s3q304 = s3q304;
    }

    public String getS3q305() {
        return s3q305;
    }

    public void setS3q305(String s3q305) {
        this.s3q305 = s3q305;
    }

    public String getS3q4() {
        return s3q4;
    }

    public void setS3q4(String s3q4) {
        this.s3q4 = s3q4;
    }

    public String getS3q5() {
        return s3q5;
    }

    public void setS3q5(String s3q5) {
        this.s3q5 = s3q5;
    }

    public String getS3q501() {
        return s3q501;
    }

    public void setS3q501(String s3q501) {
        this.s3q501 = s3q501;
    }

    public String getS3q502() {
        return s3q502;
    }

    public void setS3q502(String s3q502) {
        this.s3q502 = s3q502;
    }

    public String getS3q503() {
        return s3q503;
    }

    public void setS3q503(String s3q503) {
        this.s3q503 = s3q503;
    }

    public String getS3q504() {
        return s3q504;
    }

    public void setS3q504(String s3q504) {
        this.s3q504 = s3q504;
    }

    public String getS3q505() {
        return s3q505;
    }

    public void setS3q505(String s3q505) {
        this.s3q505 = s3q505;
    }

    public String getS3q6() {
        return s3q6;
    }

    public void setS3q6(String s3q6) {
        this.s3q6 = s3q6;
    }

    public String getS3q6a() {
        return s3q6a;
    }

    public void setS3q6a(String s3q6a) {
        this.s3q6a = s3q6a;
    }

    public String getS3q6b() {
        return s3q6b;
    }

    public void setS3q6b(String s3q6b) {
        this.s3q6b = s3q6b;
    }

    public String getS3q6c() {
        return s3q6c;
    }

    public void setS3q6c(String s3q6c) {
        this.s3q6c = s3q6c;
    }

    public String getS3q6d() {
        return s3q6d;
    }

    public void setS3q6d(String s3q6d) {
        this.s3q6d = s3q6d;
    }

    public String getS3q6e() {
        return s3q6e;
    }

    public void setS3q6e(String s3q6e) {
        this.s3q6e = s3q6e;
    }

    public String getS3q696() {
        return s3q696;
    }

    public void setS3q696(String s3q696) {
        this.s3q696 = s3q696;
    }

    public String getS3q696x() {
        return s3q696x;
    }

    public void setS3q696x(String s3q696x) {
        this.s3q696x = s3q696x;
    }

    public String getS4q1() {
        return s4q1;
    }

    public Form setS4q1(String s4q1) {
        this.s4q1 = s4q1;
        return this;
    }

    public String getS4q1b() {
        return s4q1b;
    }

    public Form setS4q1b(String s4q1b) {
        this.s4q1b = s4q1b;
        return this;
    }

    public String getS4q1c() {
        return s4q1c;
    }

    public Form setS4q1c(String s4q1c) {
        this.s4q1c = s4q1c;
        return this;
    }

    public String getS4q2() {
        return s4q2;
    }

    public Form setS4q2(String s4q2) {
        this.s4q2 = s4q2;
        return this;
    }

    public String getS4q2b() {
        return s4q2b;
    }

    public Form setS4q2b(String s4q2b) {
        this.s4q2b = s4q2b;
        return this;
    }

    public String getS4q2c() {
        return s4q2c;
    }

    public Form setS4q2c(String s4q2c) {
        this.s4q2c = s4q2c;
        return this;
    }

    public String getS4q3() {
        return s4q3;
    }

    public Form setS4q3(String s4q3) {
        this.s4q3 = s4q3;
        return this;
    }

    public String getS4q3b() {
        return s4q3b;
    }

    public Form setS4q3b(String s4q3b) {
        this.s4q3b = s4q3b;
        return this;
    }

    public String getS4q3c() {
        return s4q3c;
    }

    public Form setS4q3c(String s4q3c) {
        this.s4q3c = s4q3c;
        return this;
    }

    public String getS4q4() {
        return s4q4;
    }

    public Form setS4q4(String s4q4) {
        this.s4q4 = s4q4;
        return this;
    }

    public String getS4q4b() {
        return s4q4b;
    }

    public Form setS4q4b(String s4q4b) {
        this.s4q4b = s4q4b;
        return this;
    }

    public String getS4q4c() {
        return s4q4c;
    }

    public Form setS4q4c(String s4q4c) {
        this.s4q4c = s4q4c;
        return this;
    }

    public String getS4q5() {
        return s4q5;
    }

    public Form setS4q5(String s4q5) {
        this.s4q5 = s4q5;
        return this;
    }

    public String getS5q1() {
        return s5q1;
    }

    public void setS5q1(String s5q1) {
        this.s5q1 = s5q1;
    }

    public String getS5q1a() {
        return s5q1a;
    }

    public void setS5q1a(String s5q1a) {
        this.s5q1a = s5q1a;
    }

    public String getS5q2() {
        return s5q2;
    }

    public void setS5q2(String s5q2) {
        this.s5q2 = s5q2;
    }

    public String getS5q2a() {
        return s5q2a;
    }

    public void setS5q2a(String s5q2a) {
        this.s5q2a = s5q2a;
    }

    public String getS5q3() {
        return s5q3;
    }

    public void setS5q3(String s5q3) {
        this.s5q3 = s5q3;
    }

    public String getS5q3a() {
        return s5q3a;
    }

    public void setS5q3a(String s5q3a) {
        this.s5q3a = s5q3a;
    }

    public String getS5q4() {
        return s5q4;
    }

    public void setS5q4(String s5q4) {
        this.s5q4 = s5q4;
    }

    public String getS5q4a() {
        return s5q4a;
    }

    public void setS5q4a(String s5q4a) {
        this.s5q4a = s5q4a;
    }

    public String getS5q5() {
        return s5q5;
    }

    public void setS5q5(String s5q5) {
        this.s5q5 = s5q5;
    }

    public String getS5q5a() {
        return s5q5a;
    }

    public void setS5q5a(String s5q5a) {
        this.s5q5a = s5q5a;
    }

    public String getS5q6() {
        return s5q6;
    }

    public void setS5q6(String s5q6) {
        this.s5q6 = s5q6;
    }

    public String getS5q6a() {
        return s5q6a;
    }

    public void setS5q6a(String s5q6a) {
        this.s5q6a = s5q6a;
    }

    public String getS5q7() {
        return s5q7;
    }

    public void setS5q7(String s5q7) {
        this.s5q7 = s5q7;
    }

    public String getS5q7a() {
        return s5q7a;
    }

    public void setS5q7a(String s5q7a) {
        this.s5q7a = s5q7a;
    }

    public String getS5q8() {
        return s5q8;
    }

    public void setS5q8(String s5q8) {
        this.s5q8 = s5q8;
    }

    public String getS5q8a() {
        return s5q8a;
    }

    public void setS5q8a(String s5q8a) {
        this.s5q8a = s5q8a;
    }

    public String getS5q9() {
        return s5q9;
    }

    public void setS5q9(String s5q9) {
        this.s5q9 = s5q9;
    }

    public String getS5q9a() {
        return s5q9a;
    }

    public void setS5q9a(String s5q9a) {
        this.s5q9a = s5q9a;
    }


    public String getS6mea1() {
        return s6mea1;
    }

    public Form setS6mea1(String s6mea1) {
        this.s6mea1 = s6mea1;
        return this;
    }


    public String getS6mea2() {
        return s6mea2;
    }

    public Form setS6mea2(String s6mea2) {
        this.s6mea2 = s6mea2;
        return this;
    }


    public String getS6q1a() {
        return s6q1a;
    }

    public void setS6q1a(String s6q1a) {
        this.s6q1a = s6q1a;
    }


    public String getS6q2a() {
        return s6q2a;
    }

    public void setS6q2a(String s6q2a) {
        this.s6q2a = s6q2a;
    }


    public String getS6q3a() {
        return s6q3a;
    }

    public void setS6q3a(String s6q3a) {
        this.s6q3a = s6q3a;
    }


    public String getS6q1b() {
        return s6q1b;
    }

    public void setS6q1b(String s6q1b) {
        this.s6q1b = s6q1b;
    }


    public String getS6q2b() {
        return s6q2b;
    }

    public void setS6q2b(String s6q2b) {
        this.s6q2b = s6q2b;
    }


    public String getS6q3b() {
        return s6q3b;
    }

    public void setS6q3b(String s6q3b) {
        this.s6q3b = s6q3b;
    }


    public String getS7qa() {
        return s7qa;
    }

    public void setS7qa(String s7qa) {
        this.s7qa = s7qa;
    }

    public String getS7qb() {
        return s7qb;
    }

    public void setS7qb(String s7qb) {
        this.s7qb = s7qb;
    }

    public String getS7qc() {
        return s7qc;
    }

    public void setS7qc(String s7qc) {
        this.s7qc = s7qc;
    }

    public String getS7qd() {
        return s7qd;
    }

    public void setS7qd(String s7qd) {
        this.s7qd = s7qd;
    }

    public String getS7qe() {
        return s7qe;
    }

    public void setS7qe(String s7qe) {
        this.s7qe = s7qe;
    }

    public String getS7qf() {
        return s7qf;
    }

    public void setS7qf(String s7qf) {
        this.s7qf = s7qf;
    }

    public String getS7qg() {
        return s7qg;
    }

    public void setS7qg(String s7qg) {
        this.s7qg = s7qg;
    }

    public String getS7qh() {
        return s7qh;
    }

    public void setS7qh(String s7qh) {
        this.s7qh = s7qh;
    }

    public String getS7qi() {
        return s7qi;
    }

    public void setS7qi(String s7qi) {
        this.s7qi = s7qi;
    }

    public String getS7qj() {
        return s7qj;
    }

    public void setS7qj(String s7qj) {
        this.s7qj = s7qj;
    }

    public String getS7qk() {
        return s7qk;
    }

    public void setS7qk(String s7qk) {
        this.s7qk = s7qk;
    }

    public String getS7ql() {
        return s7ql;
    }

    public void setS7ql(String s7ql) {
        this.s7ql = s7ql;
    }

    public String getS7qm() {
        return s7qm;
    }

    public void setS7qm(String s7qm) {
        this.s7qm = s7qm;
    }

    public String getS7qn() {
        return s7qn;
    }

    public void setS7qn(String s7qn) {
        this.s7qn = s7qn;
    }

    public String getS7qo() {
        return s7qo;
    }

    public void setS7qo(String s7qo) {
        this.s7qo = s7qo;
    }

    public String getS7qp() {
        return s7qp;
    }

    public void setS7qp(String s7qp) {
        this.s7qp = s7qp;
    }

    public String getS7qq() {
        return s7qq;
    }

    public void setS7qq(String s7qq) {
        this.s7qq = s7qq;
    }

    public String getS7qr() {
        return s7qr;
    }

    public void setS7qr(String s7qr) {
        this.s7qr = s7qr;
    }

    public String getS8q1() {
        return s8q1;
    }

    public void setS8q1(String s8q1) {
        this.s8q1 = s8q1;
    }

    public String getS8q1a() {
        return s8q1a;
    }

    public void setS8q1a(String s8q1a) {
        this.s8q1a = s8q1a;
    }

    public String getS8q2() {
        return s8q2;
    }

    public void setS8q2(String s8q2) {
        this.s8q2 = s8q2;
    }

    public String getS8q2a() {
        return s8q2a;
    }

    public void setS8q2a(String s8q2a) {
        this.s8q2a = s8q2a;
    }

    public String getS8q2b() {
        return s8q2b;
    }

    public void setS8q2b(String s8q2b) {
        this.s8q2b = s8q2b;
    }

    public String getS8q2b01() {
        return s8q2b01;
    }

    public void setS8q2b01(String s8q2b01) {
        this.s8q2b01 = s8q2b01;
    }

    public String getS8q2b02() {
        return s8q2b02;
    }

    public void setS8q2b02(String s8q2b02) {
        this.s8q2b02 = s8q2b02;
    }

    public String getS8q2b03() {
        return s8q2b03;
    }

    public void setS8q2b03(String s8q2b03) {
        this.s8q2b03 = s8q2b03;
    }

    public String getS8q2b04() {
        return s8q2b04;
    }

    public void setS8q2b04(String s8q2b04) {
        this.s8q2b04 = s8q2b04;
    }

    public String getS8q2b05() {
        return s8q2b05;
    }

    public void setS8q2b05(String s8q2b05) {
        this.s8q2b05 = s8q2b05;
    }

    public String getS8q2b96() {
        return s8q2b96;
    }

    public void setS8q2b96(String s8q2b96) {
        this.s8q2b96 = s8q2b96;
    }

    public String getS8q2b96x() {
        return s8q2b96x;
    }

    public void setS8q2b96x(String s8q2b96x) {
        this.s8q2b96x = s8q2b96x;
    }

    public String getS8q2c() {
        return s8q2c;
    }

    public void setS8q2c(String s8q2c) {
        this.s8q2c = s8q2c;
    }

    public String getS8q2c01() {
        return s8q2c01;
    }

    public void setS8q2c01(String s8q2c01) {
        this.s8q2c01 = s8q2c01;
    }

    public String getS8q2c02() {
        return s8q2c02;
    }

    public void setS8q2c02(String s8q2c02) {
        this.s8q2c02 = s8q2c02;
    }

    public String getS8q2c03() {
        return s8q2c03;
    }

    public void setS8q2c03(String s8q2c03) {
        this.s8q2c03 = s8q2c03;
    }

    public String getS8q2c04() {
        return s8q2c04;
    }

    public void setS8q2c04(String s8q2c04) {
        this.s8q2c04 = s8q2c04;
    }

    public String getS8q2c96() {
        return s8q2c96;
    }

    public void setS8q2c96(String s8q2c96) {
        this.s8q2c96 = s8q2c96;
    }

    public String getS8q2c96x() {
        return s8q2c96x;
    }

    public void setS8q2c96x(String s8q2c96x) {
        this.s8q2c96x = s8q2c96x;
    }

    public String getS8q3() {
        return s8q3;
    }

    public void setS8q3(String s8q3) {
        this.s8q3 = s8q3;
    }

    public String getS8q3a() {
        return s8q3a;
    }

    public void setS8q3a(String s8q3a) {
        this.s8q3a = s8q3a;
    }

    public String getS8q3a01x() {
        return s8q3a01x;
    }

    public void setS8q3a01x(String s8q3a01x) {
        this.s8q3a01x = s8q3a01x;
    }

    public String getS8q4() {
        return s8q4;
    }

    public void setS8q4(String s8q4) {
        this.s8q4 = s8q4;
    }

    public String getS8q4a() {
        return s8q4a;
    }

    public void setS8q4a(String s8q4a) {
        this.s8q4a = s8q4a;
    }

    public String getS8q4a01x() {
        return s8q4a01x;
    }

    public void setS8q4a01x(String s8q4a01x) {
        this.s8q4a01x = s8q4a01x;
    }

    public String getS8q5() {
        return s8q5;
    }

    public void setS8q5(String s8q5) {
        this.s8q5 = s8q5;
    }

    public String getS8q6() {
        return s8q6;
    }

    public void setS8q6(String s8q6) {
        this.s8q6 = s8q6;
    }

    public String getS8q7() {
        return s8q7;
    }

    public void setS8q7(String s8q7) {
        this.s8q7 = s8q7;
    }

    public String getS8q7a() {
        return s8q7a;
    }

    public void setS8q7a(String s8q7a) {
        this.s8q7a = s8q7a;
    }

    public String getS8q7a01x() {
        return s8q7a01x;
    }

    public void setS8q7a01x(String s8q7a01x) {
        this.s8q7a01x = s8q7a01x;
    }

    public String getS8q7a02x() {
        return s8q7a02x;
    }

    public void setS8q7a02x(String s8q7a02x) {
        this.s8q7a02x = s8q7a02x;
    }

    public String getS8q8() {
        return s8q8;
    }

    public void setS8q8(String s8q8) {
        this.s8q8 = s8q8;
    }

    public String getS8q801() {
        return s8q801;
    }

    public void setS8q801(String s8q801) {
        this.s8q801 = s8q801;
    }

    public String getS8q802() {
        return s8q802;
    }

    public void setS8q802(String s8q802) {
        this.s8q802 = s8q802;
    }

    public String getS8q803() {
        return s8q803;
    }

    public void setS8q803(String s8q803) {
        this.s8q803 = s8q803;
    }

    public String getS8q804() {
        return s8q804;
    }

    public void setS8q804(String s8q804) {
        this.s8q804 = s8q804;
    }

    public String getS8q805() {
        return s8q805;
    }

    public void setS8q805(String s8q805) {
        this.s8q805 = s8q805;
    }

    public String getS8q806() {
        return s8q806;
    }

    public void setS8q806(String s8q806) {
        this.s8q806 = s8q806;
    }

    public String getS8q896() {
        return s8q896;
    }

    public void setS8q896(String s8q896) {
        this.s8q896 = s8q896;
    }

    public String getS8q896x() {
        return s8q896x;
    }

    public void setS8q896x(String s8q896x) {
        this.s8q896x = s8q896x;
    }

    public String getS8q899() {
        return s8q899;
    }

    public void setS8q899(String s8q899) {
        this.s8q899 = s8q899;
    }

    public String getS8q9() {
        return s8q9;
    }

    public void setS8q9(String s8q9) {
        this.s8q9 = s8q9;
    }

    public String getS8q996x() {
        return s8q996x;
    }

    public void setS8q996x(String s8q996x) {
        this.s8q996x = s8q996x;
    }

    public String getS8q10() {
        return s8q10;
    }

    public void setS8q10(String s8q10) {
        this.s8q10 = s8q10;
    }

    public String getS8q1001x() {
        return s8q1001x;
    }

    public void setS8q1001x(String s8q1001x) {
        this.s8q1001x = s8q1001x;
    }

    public String getS8q1198() {
        return s8q1198;
    }

    public void setS8q1198(String s8q1198) {
        this.s8q1198 = s8q1198;
    }

    public String getS8q1101() {
        return s8q1101;
    }

    public void setS8q1101(String s8q1101) {
        this.s8q1101 = s8q1101;
    }

    public String getS8q1102() {
        return s8q1102;
    }

    public void setS8q1102(String s8q1102) {
        this.s8q1102 = s8q1102;
    }

    public String getS8q1103() {
        return s8q1103;
    }

    public void setS8q1103(String s8q1103) {
        this.s8q1103 = s8q1103;
    }

    public String getS8q12() {
        return s8q12;
    }

    public void setS8q12(String s8q12) {
        this.s8q12 = s8q12;
    }

    public String getS8q1296x() {
        return s8q1296x;
    }

    public void setS8q1296x(String s8q1296x) {
        this.s8q1296x = s8q1296x;
    }

    public String getS8q13() {
        return s8q13;
    }

    public void setS8q13(String s8q13) {
        this.s8q13 = s8q13;
    }

    public String getS8q1396x() {
        return s8q1396x;
    }

    public void setS8q1396x(String s8q1396x) {
        this.s8q1396x = s8q1396x;
    }


    public String getS9q1() {
        return s9q1;
    }

    public void setS9q1(String s9q1) {
        this.s9q1 = s9q1;
    }


    public String getS9q2() {
        return s9q2;
    }

    public void setS9q2(String s9q2) {
        this.s9q2 = s9q2;
    }


    public String getS9q3() {
        return s9q3;
    }

    public void setS9q3(String s9q3) {
        this.s9q3 = s9q3;
    }


    public String getS9mea1() {
        return s9mea1;
    }

    public void setS9mea1(String s9mea1) {
        this.s9mea1 = s9mea1;
    }


    public String getS9q4a() {
        return s9q4a;
    }

    public void setS9q4a(String s9q4a) {
        this.s9q4a = s9q4a;
    }


    public String getS9q4b() {
        return s9q4b;
    }

    public void setS9q4b(String s9q4b) {
        this.s9q4b = s9q4b;
    }


    public String getS9mea2() {
        return s9mea2;
    }

    public void setS9mea2(String s9mea2) {
        this.s9mea2 = s9mea2;
    }


    public String getS9q5a() {
        return s9q5a;
    }

    public void setS9q5a(String s9q5a) {
        this.s9q5a = s9q5a;
    }


    public String getS9q5b() {
        return s9q5b;
    }

    public void setS9q5b(String s9q5b) {
        this.s9q5b = s9q5b;
    }


    public String getS9q6a() {
        return s9q6a;
    }

    public void setS9q6a(String s9q6a) {
        this.s9q6a = s9q6a;
    }


    public String getS10title() {
        return s10title;
    }

    public void setS10title(String s10title) {
        this.s10title = s10title;
    }

    public String getS10q1() {
        return s10q1;
    }

    public void setS10q1(String s10q1) {
        this.s10q1 = s10q1;
    }

    public String getS10q2() {
        return s10q2;
    }

    public void setS10q2(String s10q2) {
        this.s10q2 = s10q2;
    }

    public String getS10q202x() {
        return s10q202x;
    }

    public void setS10q202x(String s10q202x) {
        this.s10q202x = s10q202x;
    }

    public String getS10q201x() {
        return s10q201x;
    }

    public void setS10q201x(String s10q201x) {
        this.s10q201x = s10q201x;
    }


    public String getS10q3() {
        return s10q3;
    }

    public void setS10q3(String s10q3) {
        this.s10q3 = s10q3;
    }

    public String getS10q4() {
        return s10q4;
    }

    public void setS10q4(String s10q4) {
        this.s10q4 = s10q4;
    }

    public String getS10q496x() {
        return s10q496x;
    }

    public void setS10q496x(String s10q496x) {
        this.s10q496x = s10q496x;
    }

    public String getS10q5() {
        return s10q5;
    }

    public void setS10q5(String s10q5) {
        this.s10q5 = s10q5;
    }

    public String getS10q6() {
        return s10q6;
    }

    public void setS10q6(String s10q6) {
        this.s10q6 = s10q6;
    }

    public String getS10q601() {
        return s10q601;
    }

    public void setS10q601(String s10q601) {
        this.s10q601 = s10q601;
    }

    public String getS10q602() {
        return s10q602;
    }

    public void setS10q602(String s10q602) {
        this.s10q602 = s10q602;
    }

    public String getS10q603() {
        return s10q603;
    }

    public void setS10q603(String s10q603) {
        this.s10q603 = s10q603;
    }

    public String getS10q604() {
        return s10q604;
    }

    public void setS10q604(String s10q604) {
        this.s10q604 = s10q604;
    }

    public String getS10q605() {
        return s10q605;
    }

    public void setS10q605(String s10q605) {
        this.s10q605 = s10q605;
    }

    public String getS10q606() {
        return s10q606;
    }

    public void setS10q606(String s10q606) {
        this.s10q606 = s10q606;
    }

    public String getS10q607() {
        return s10q607;
    }

    public void setS10q607(String s10q607) {
        this.s10q607 = s10q607;
    }

    public String getS10q608() {
        return s10q608;
    }

    public void setS10q608(String s10q608) {
        this.s10q608 = s10q608;
    }

    public String getS10q609() {
        return s10q609;
    }

    public void setS10q609(String s10q609) {
        this.s10q609 = s10q609;
    }

    public String getS10q610() {
        return s10q610;
    }

    public void setS10q610(String s10q610) {
        this.s10q610 = s10q610;
    }

    public String getS10q696() {
        return s10q696;
    }

    public void setS10q696(String s10q696) {
        this.s10q696 = s10q696;
    }

    public String getS10q696x() {
        return s10q696x;
    }

    public void setS10q696x(String s10q696x) {
        this.s10q696x = s10q696x;
    }

    public String getS10q699() {
        return s10q699;
    }

    public void setS10q699(String s10q699) {
        this.s10q699 = s10q699;
    }

    public String getS11q7() {
        return s11q7;
    }

    public void setS11q7(String s11q7) {
        this.s11q7 = s11q7;
    }

    public String getS11q7a() {
        return s11q7a;
    }

    public void setS11q7a(String s11q7a) {
        this.s11q7a = s11q7a;
    }

    public String getS11q8() {
        return s11q8;
    }

    public void setS11q8(String s11q8) {
        this.s11q8 = s11q8;
    }

    public String getS11q9() {
        return s11q9;
    }

    public void setS11q9(String s11q9) {
        this.s11q9 = s11q9;
    }

    public String getS11q10a() {
        return s11q10a;
    }

    public void setS11q10a(String s11q10a) {
        this.s11q10a = s11q10a;
    }

    public String getS11q10b() {
        return s11q10b;
    }

    public void setS11q10b(String s11q10b) {
        this.s11q10b = s11q10b;
    }

    public String getS11q10b01x() {
        return s11q10b01x;
    }

    public void setS11q10b01x(String s11q10b01x) {
        this.s11q10b01x = s11q10b01x;
    }

    public String getS11q10c() {
        return s11q10c;
    }

    public void setS11q10c(String s11q10c) {
        this.s11q10c = s11q10c;
    }

    public String getS11q10c01x() {
        return s11q10c01x;
    }

    public void setS11q10c01x(String s11q10c01x) {
        this.s11q10c01x = s11q10c01x;
    }

    public String getS11q10d() {
        return s11q10d;
    }

    public void setS11q10d(String s11q10d) {
        this.s11q10d = s11q10d;
    }

    public String getS11q10e() {
        return s11q10e;
    }

    public void setS11q10e(String s11q10e) {
        this.s11q10e = s11q10e;
    }

    public String getS11q10f() {
        return s11q10f;
    }

    public void setS11q10f(String s11q10f) {
        this.s11q10f = s11q10f;
    }

    public String getS11q10f01x() {
        return s11q10f01x;
    }

    public void setS11q10f01x(String s11q10f01x) {
        this.s11q10f01x = s11q10f01x;
    }

    public String getS11q10g() {
        return s11q10g;
    }

    public void setS11q10g(String s11q10g) {
        this.s11q10g = s11q10g;
    }

    public String getS11q10h() {
        return s11q10h;
    }

    public void setS11q10h(String s11q10h) {
        this.s11q10h = s11q10h;
    }

    public String getS11q10i() {
        return s11q10i;
    }

    public void setS11q10i(String s11q10i) {
        this.s11q10i = s11q10i;
    }

    public String getS11q12a() {
        return s11q12a;
    }

    public void setS11q12a(String s11q12a) {
        this.s11q12a = s11q12a;
    }

    public String getS11q12b() {
        return s11q12b;
    }

    public void setS11q12b(String s11q12b) {
        this.s11q12b = s11q12b;
    }

    public String getS11q12c() {
        return s11q12c;
    }

    public void setS11q12c(String s11q12c) {
        this.s11q12c = s11q12c;
    }

    public String getS11q12d() {
        return s11q12d;
    }

    public void setS11q12d(String s11q12d) {
        this.s11q12d = s11q12d;
    }

    public String getS11q12e() {
        return s11q12e;
    }

    public void setS11q12e(String s11q12e) {
        this.s11q12e = s11q12e;
    }

    public String getS11q12f() {
        return s11q12f;
    }

    public void setS11q12f(String s11q12f) {
        this.s11q12f = s11q12f;
    }

    public String getS11q12g() {
        return s11q12g;
    }

    public void setS11q12g(String s11q12g) {
        this.s11q12g = s11q12g;
    }

    public String getS11q12h() {
        return s11q12h;
    }

    public void setS11q12h(String s11q12h) {
        this.s11q12h = s11q12h;
    }

    public String getS11q12i() {
        return s11q12i;
    }

    public void setS11q12i(String s11q12i) {
        this.s11q12i = s11q12i;
    }

    public String getS11q12j() {
        return s11q12j;
    }

    public void setS11q12j(String s11q12j) {
        this.s11q12j = s11q12j;
    }

    public String getS11q12k() {
        return s11q12k;
    }

    public void setS11q12k(String s11q12k) {
        this.s11q12k = s11q12k;
    }

    public String getS11q12l() {
        return s11q12l;
    }

    public void setS11q12l(String s11q12l) {
        this.s11q12l = s11q12l;
    }

    public String getS11q12m() {
        return s11q12m;
    }

    public void setS11q12m(String s11q12m) {
        this.s11q12m = s11q12m;
    }

    public String getS11q12n() {
        return s11q12n;
    }

    public void setS11q12n(String s11q12n) {
        this.s11q12n = s11q12n;
    }

    public String getS11q12o() {
        return s11q12o;
    }

    public void setS11q12o(String s11q12o) {
        this.s11q12o = s11q12o;
    }

    public String getS11q12p() {
        return s11q12p;
    }

    public void setS11q12p(String s11q12p) {
        this.s11q12p = s11q12p;
    }

/*    public String getS11q12p01() {
        return s11q12p01;
    }

    public void setS11q12p01(String s11q12p01) {
        this.s11q12p01 = s11q12p01;
    }

    public String getS11q12p02() {
        return s11q12p02;
    }

    public void setS11q12p02(String s11q12p02) {
        this.s11q12p02 = s11q12p02;
    }

    public String getS11q12p98() {
        return s11q12p98;
    }

    public void setS11q12p98(String s11q12p98) {
        this.s11q12p98 = s11q12p98;
    }*/

    public String getS11q12q() {
        return s11q12q;
    }

    public void setS11q12q(String s11q12q) {
        this.s11q12q = s11q12q;
    }

  /*  public String getS11q12q01() {
        return s11q12q01;
    }

    public void setS11q12q01(String s11q12q01) {
        this.s11q12q01 = s11q12q01;
    }

    public String getS11q12q02() {
        return s11q12q02;
    }

    public void setS11q12q02(String s11q12q02) {
        this.s11q12q02 = s11q12q02;
    }

    public String getS11q12q98() {
        return s11q12q98;
    }

    public void setS11q12q98(String s11q12q98) {
        this.s11q12q98 = s11q12q98;
    }*/

    public String getS11q13() {
        return s11q13;
    }

    public void setS11q13(String s11q13) {
        this.s11q13 = s11q13;
    }

    public String getS11q14() {
        return s11q14;
    }

    public void setS11q14(String s11q14) {
        this.s11q14 = s11q14;
    }

    public String getS11q1401x() {
        return s11q1401x;
    }

    public void setS11q1401x(String s11q1401x) {
        this.s11q1401x = s11q1401x;
    }

    public String getS11q15() {
        return s11q15;
    }

    public void setS11q15(String s11q15) {
        this.s11q15 = s11q15;
    }

    public String getS11q16() {
        return s11q16;
    }

    public void setS11q16(String s11q16) {
        this.s11q16 = s11q16;
    }

    public String getS11q1696x() {
        return s11q1696x;
    }

    public void setS11q1696x(String s11q1696x) {
        this.s11q1696x = s11q1696x;
    }

    public String getS11q17() {
        return s11q17;
    }

    public void setS11q17(String s11q17) {
        this.s11q17 = s11q17;
    }

    public String getS11q1796x() {
        return s11q1796x;
    }

    public void setS11q1796x(String s11q1796x) {
        this.s11q1796x = s11q1796x;
    }

    public String getS11q18() {
        return s11q18;
    }

    public void setS11q18(String s11q18) {
        this.s11q18 = s11q18;
    }

    public String getS12q1() {
        return s12q1;
    }

    public void setS12q1(String s12q1) {
        this.s12q1 = s12q1;
    }

    public String getS12q2a() {
        return s12q2a;
    }

    public void setS12q2a(String s12q2a) {
        this.s12q2a = s12q2a;
    }

    public String getS12q2a01x() {
        return s12q2a01x;
    }

    public void setS12q2a01x(String s12q2a01x) {
        this.s12q2a01x = s12q2a01x;
    }

    public String getS12q2b() {
        return s12q2b;
    }

    public void setS12q2b(String s12q2b) {
        this.s12q2b = s12q2b;
    }

    public String getS12q2b01x() {
        return s12q2b01x;
    }

    public void setS12q2b01x(String s12q2b01x) {
        this.s12q2b01x = s12q2b01x;
    }

    public String getS12q2c() {
        return s12q2c;
    }

    public void setS12q2c(String s12q2c) {
        this.s12q2c = s12q2c;
    }

    public String getS12q2c01x() {
        return s12q2c01x;
    }

    public void setS12q2c01x(String s12q2c01x) {
        this.s12q2c01x = s12q2c01x;
    }

    public String getS12q2d() {
        return s12q2d;
    }

    public void setS12q2d(String s12q2d) {
        this.s12q2d = s12q2d;
    }

    public String getS12q2d01x() {
        return s12q2d01x;
    }

    public void setS12q2d01x(String s12q2d01x) {
        this.s12q2d01x = s12q2d01x;
    }

    public String getS12q2e() {
        return s12q2e;
    }

    public void setS12q2e(String s12q2e) {
        this.s12q2e = s12q2e;
    }

    public String getS12q2e01x() {
        return s12q2e01x;
    }

    public void setS12q2e01x(String s12q2e01x) {
        this.s12q2e01x = s12q2e01x;
    }

    public String getS12q2f() {
        return s12q2f;
    }

    public void setS12q2f(String s12q2f) {
        this.s12q2f = s12q2f;
    }

    public String getS12q2f01x() {
        return s12q2f01x;
    }

    public void setS12q2f01x(String s12q2f01x) {
        this.s12q2f01x = s12q2f01x;
    }

    public String getS12q2g() {
        return s12q2g;
    }

    public void setS12q2g(String s12q2g) {
        this.s12q2g = s12q2g;
    }

    public String getS12q2g01x() {
        return s12q2g01x;
    }

    public void setS12q2g01x(String s12q2g01x) {
        this.s12q2g01x = s12q2g01x;
    }

    public String getS12q2h() {
        return s12q2h;
    }

    public void setS12q2h(String s12q2h) {
        this.s12q2h = s12q2h;
    }

    public String getS12q2h01x() {
        return s12q2h01x;
    }

    public void setS12q2h01x(String s12q2h01x) {
        this.s12q2h01x = s12q2h01x;
    }

    public String getS12q2i() {
        return s12q2i;
    }

    public void setS12q2i(String s12q2i) {
        this.s12q2i = s12q2i;
    }

    public String getS12q2i01x() {
        return s12q2i01x;
    }

    public void setS12q2i01x(String s12q2i01x) {
        this.s12q2i01x = s12q2i01x;
    }

    public String getS12q2j() {
        return s12q2j;
    }

    public void setS12q2j(String s12q2j) {
        this.s12q2j = s12q2j;
    }

    public String getS12q2j01x() {
        return s12q2j01x;
    }

    public void setS12q2j01x(String s12q2j01x) {
        this.s12q2j01x = s12q2j01x;
    }

    public String getS12q2k() {
        return s12q2k;
    }

    public void setS12q2k(String s12q2k) {
        this.s12q2k = s12q2k;
    }

    public String getS12q2k01x() {
        return s12q2k01x;
    }

    public void setS12q2k01x(String s12q2k01x) {
        this.s12q2k01x = s12q2k01x;
    }

    public String getS12q2l() {
        return s12q2l;
    }

    public void setS12q2l(String s12q2l) {
        this.s12q2l = s12q2l;
    }

    public String getS12q2l01x() {
        return s12q2l01x;
    }

    public void setS12q2l01x(String s12q2l01x) {
        this.s12q2l01x = s12q2l01x;
    }

    public String getS12q2m() {
        return s12q2m;
    }

    public void setS12q2m(String s12q2m) {
        this.s12q2m = s12q2m;
    }

    public String getS12q2m01x() {
        return s12q2m01x;
    }

    public void setS12q2m01x(String s12q2m01x) {
        this.s12q2m01x = s12q2m01x;
    }

    public String getS12q2n() {
        return s12q2n;
    }

    public void setS12q2n(String s12q2n) {
        this.s12q2n = s12q2n;
    }

    public String getS12q2n01x() {
        return s12q2n01x;
    }

    public void setS12q2n01x(String s12q2n01x) {
        this.s12q2n01x = s12q2n01x;
    }

    public String getS12q2o() {
        return s12q2o;
    }

    public void setS12q2o(String s12q2o) {
        this.s12q2o = s12q2o;
    }

    public String getS12q2o01x() {
        return s12q2o01x;
    }

    public void setS12q2o01x(String s12q2o01x) {
        this.s12q2o01x = s12q2o01x;
    }

    public String getS12q301() {
        return s12q301;
    }

    public void setS12q301(String s12q301) {
        this.s12q301 = s12q301;
    }

    public String getS12q302() {
        return s12q302;
    }

    public void setS12q302(String s12q302) {
        this.s12q302 = s12q302;
    }

    public String getS12q303() {
        return s12q303;
    }

    public void setS12q303(String s12q303) {
        this.s12q303 = s12q303;
    }

    public String getS12q304() {
        return s12q304;
    }

    public void setS12q304(String s12q304) {
        this.s12q304 = s12q304;
    }

    public String getS12q305() {
        return s12q305;
    }

    public void setS12q305(String s12q305) {
        this.s12q305 = s12q305;
    }

    public String getS12q306() {
        return s12q306;
    }

    public void setS12q306(String s12q306) {
        this.s12q306 = s12q306;
    }

    public String getS12q307() {
        return s12q307;
    }

    public void setS12q307(String s12q307) {
        this.s12q307 = s12q307;
    }

    public String getS12q308() {
        return s12q308;
    }

    public void setS12q308(String s12q308) {
        this.s12q308 = s12q308;
    }

    public String getS12q396() {
        return s12q396;
    }

    public void setS12q396(String s12q396) {
        this.s12q396 = s12q396;
    }

    public String getS12q4() {
        return s12q4;
    }

    public void setS12q4(String s12q4) {
        this.s12q4 = s12q4;
    }

    public String getS12q5() {
        return s12q5;
    }

    public void setS12q5(String s12q5) {
        this.s12q5 = s12q5;
    }

    public String getS12q501() {
        return s12q501;
    }

    public void setS12q501(String s12q501) {
        this.s12q501 = s12q501;
    }

    public String getS12q502() {
        return s12q502;
    }

    public void setS12q502(String s12q502) {
        this.s12q502 = s12q502;
    }

    public String getS12q503() {
        return s12q503;
    }

    public void setS12q503(String s12q503) {
        this.s12q503 = s12q503;
    }

    public String getS12q504() {
        return s12q504;
    }

    public void setS12q504(String s12q504) {
        this.s12q504 = s12q504;
    }

    public String getS12q505() {
        return s12q505;
    }

    public void setS12q505(String s12q505) {
        this.s12q505 = s12q505;
    }

    public String getS12q596() {
        return s12q596;
    }

    public void setS12q596(String s12q596) {
        this.s12q596 = s12q596;
    }

    public String getS12q596x() {
        return s12q596x;
    }

    public void setS12q596x(String s12q596x) {
        this.s12q596x = s12q596x;
    }

    public String getS12q6() {
        return s12q6;
    }

    public void setS12q6(String s12q6) {
        this.s12q6 = s12q6;
    }

    public String getS12q601() {
        return s12q601;
    }

    public void setS12q601(String s12q601) {
        this.s12q601 = s12q601;
    }

    public String getS12q602() {
        return s12q602;
    }

    public void setS12q602(String s12q602) {
        this.s12q602 = s12q602;
    }

    public String getS12q603() {
        return s12q603;
    }

    public void setS12q603(String s12q603) {
        this.s12q603 = s12q603;
    }

    public String getS12q604() {
        return s12q604;
    }

    public void setS12q604(String s12q604) {
        this.s12q604 = s12q604;
    }

    public String getS12q696() {
        return s12q696;
    }

    public void setS12q696(String s12q696) {
        this.s12q696 = s12q696;
    }

    public String getS12q696x() {
        return s12q696x;
    }

    public void setS12q696x(String s12q696x) {
        this.s12q696x = s12q696x;
    }

    public String getS13q1() {
        return s13q1;
    }

    public void setS13q1(String s13q1) {
        this.s13q1 = s13q1;
    }

    public String getS13q196x() {
        return s13q196x;
    }

    public void setS13q196x(String s13q196x) {
        this.s13q196x = s13q196x;
    }

    public String getS13q2() {
        return s13q2;
    }

    public void setS13q2(String s13q2) {
        this.s13q2 = s13q2;
    }

    public String getS13q202x() {
        return s13q202x;
    }

    public void setS13q202x(String s13q202x) {
        this.s13q202x = s13q202x;
    }

    public String getS13q201x() {
        return s13q201x;
    }

    public void setS13q201x(String s13q201x) {
        this.s13q201x = s13q201x;
    }

    public String getS13q3() {
        return s13q3;
    }

    public void setS13q3(String s13q3) {
        this.s13q3 = s13q3;
    }

    public String getS13q4() {
        return s13q4;
    }

    public void setS13q4(String s13q4) {
        this.s13q4 = s13q4;
    }

    public String getS13q496x() {
        return s13q496x;
    }

    public void setS13q496x(String s13q496x) {
        this.s13q496x = s13q496x;
    }

    public String getS13q5() {
        return s13q5;
    }

    public void setS13q5(String s13q5) {
        this.s13q5 = s13q5;
    }

    public String getS13q596x() {
        return s13q596x;
    }

    public void setS13q596x(String s13q596x) {
        this.s13q596x = s13q596x;
    }

    public String getS13q601() {
        return s13q601;
    }

    public void setS13q601(String s13q601) {
        this.s13q601 = s13q601;
    }

    public String getS13q602() {
        return s13q602;
    }

    public void setS13q602(String s13q602) {
        this.s13q602 = s13q602;
    }

    public String getS13q603() {
        return s13q603;
    }

    public void setS13q603(String s13q603) {
        this.s13q603 = s13q603;
    }

    public String getS13q696() {
        return s13q696;
    }

    public void setS13q696(String s13q696) {
        this.s13q696 = s13q696;
    }

    public String getS13q696x() {
        return s13q696x;
    }

    public void setS13q696x(String s13q696x) {
        this.s13q696x = s13q696x;
    }

    public String getS13q698() {
        return s13q698;
    }

    public void setS13q698(String s13q698) {
        this.s13q698 = s13q698;
    }

    public String getS13q7() {
        return s13q7;
    }

    public void setS13q7(String s13q7) {
        this.s13q7 = s13q7;
    }

    public String getS13q796x() {
        return s13q796x;
    }

    public void setS13q796x(String s13q796x) {
        this.s13q796x = s13q796x;
    }

    public String getS13q8() {
        return s13q8;
    }

    public void setS13q8(String s13q8) {
        this.s13q8 = s13q8;
    }

    public String getS13q896x() {
        return s13q896x;
    }

    public void setS13q896x(String s13q896x) {
        this.s13q896x = s13q896x;
    }

    public String getS13q9() {
        return s13q9;
    }

    public void setS13q9(String s13q9) {
        this.s13q9 = s13q9;
    }

    public String getS13q996x() {
        return s13q996x;
    }

    public void setS13q996x(String s13q996x) {
        this.s13q996x = s13q996x;
    }

    public String getS13q10() {
        return s13q10;
    }

    public void setS13q10(String s13q10) {
        this.s13q10 = s13q10;
    }

    public String getS13q1001() {
        return s13q1001;
    }

    public void setS13q1001(String s13q1001) {
        this.s13q1001 = s13q1001;
    }

    public String getS13q1002() {
        return s13q1002;
    }

    public void setS13q1002(String s13q1002) {
        this.s13q1002 = s13q1002;
    }

    public String getS13q1003() {
        return s13q1003;
    }

    public void setS13q1003(String s13q1003) {
        this.s13q1003 = s13q1003;
    }

    public String getS13q1004() {
        return s13q1004;
    }

    public void setS13q1004(String s13q1004) {
        this.s13q1004 = s13q1004;
    }

    public String getS13q1005() {
        return s13q1005;
    }

    public void setS13q1005(String s13q1005) {
        this.s13q1005 = s13q1005;
    }

    public String getS13q1006() {
        return s13q1006;
    }

    public void setS13q1006(String s13q1006) {
        this.s13q1006 = s13q1006;
    }

    public String getS13q1007() {
        return s13q1007;
    }

    public void setS13q1007(String s13q1007) {
        this.s13q1007 = s13q1007;
    }

    public String getS1qno() {
        return s1qno;
    }

    public void setS1qno(String s1qno) {
        this.s1qno = s1qno;
    }

    public String getS1q1() {
        return s1q1;
    }

    public void setS1q1(String s1q1) {
        this.s1q1 = s1q1;
    }

    public String getS1q2() {
        return s1q2;
    }

    public void setS1q2(String s1q2) {
        this.s1q2 = s1q2;
    }

    public String getS1q4() {
        return s1q4;
    }

    public void setS1q4(String s1q4) {
        this.s1q4 = s1q4;
    }

    public String getS1q6() {
        return s1q6;
    }

    public void setS1q6(String s1q6) {
        this.s1q6 = s1q6;
    }

    public String getS1q8() {
        return s1q8;
    }

    public void setS1q8(String s1q8) {
        this.s1q8 = s1q8;
    }

    public String getS1q9() {
        return s1q9;
    }

    public void setS1q9(String s1q9) {
        this.s1q9 = s1q9;
    }

    public String getS1q10() {
        return s1q10;
    }

    public void setS1q10(String s1q10) {
        this.s1q10 = s1q10;
    }

    public String getS1q11() {
        return s1q11;
    }

    public void setS1q11(String s1q11) {
        this.s1q11 = s1q11;
    }

    public String getS1q12() {
        return s1q12;
    }

    public void setS1q12(String s1q12) {
        this.s1q12 = s1q12;
    }

    public String getS1q13() {
        return s1q13;
    }

    public void setS1q13(String s1q13) {
        this.s1q13 = s1q13;
    }

    public String getS1q14() {
        return s1q14;
    }

    public void setS1q14(String s1q14) {
        this.s1q14 = s1q14;
    }

    public String getS1q15() {
        return s1q15;
    }

    public void setS1q15(String s1q15) {
        this.s1q15 = s1q15;
    }

    public String getS1q16() {
        return s1q16;
    }

    public void setS1q16(String s1q16) {
        this.s1q16 = s1q16;
    }

    public String getS1q17() {
        return s1q17;
    }

    public void setS1q17(String s1q17) {
        this.s1q17 = s1q17;
    }

    public String getS1q18() {
        return s1q18;
    }

    public void setS1q18(String s1q18) {
        this.s1q18 = s1q18;
    }

    public String getS1_consent() {
        return s1_consent;
    }

    public void setS1_consent(String s1_consent) {
        this.s1_consent = s1_consent;
    }

    public String getS1q19et() {
        return s1q19et;
    }

    public void setS1q19et(String s1q19et) {
        this.s1q19et = s1q19et;
    }

    public String getS1q20a() {
        return s1q20a;
    }

    public void setS1q20a(String s1q20a) {
        this.s1q20a = s1q20a;
    }

    public String getS1q20b() {
        return s1q20b;
    }

    public void setS1q20b(String s1q20b) {
        this.s1q20b = s1q20b;
    }

    public String getS1q20c() {
        return s1q20c;
    }

    public void setS1q20c(String s1q20c) {
        this.s1q20c = s1q20c;
    }


    public String getS1q20d() {
        return s1q20d;
    }

    public void setS1q20d(String s1q20d) {
        this.s1q20d = s1q20d;
    }


    public String getS1q20e() {
        return s1q20e;
    }

    public void setS1q20e(String s1q20e) {
        this.s1q20e = s1q20e;
    }


    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }


    public Form Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.username = jsonObject.getString(FormsTable.COLUMN_USERNAME);
        this.sysdate = jsonObject.getString(FormsTable.COLUMN_SYSDATE);
        this.formdate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.formtype = jsonObject.getString(FormsTable.COLUMN_FORMTYPE);
        this.sInfo = jsonObject.getString(FormsTable.COLUMN_SINFO);
        this.s02 = jsonObject.getString(FormsTable.COLUMN_S02);
        this.s03 = jsonObject.getString(FormsTable.COLUMN_S03);
        this.s04 = jsonObject.getString(FormsTable.COLUMN_S04);
        this.s05 = jsonObject.getString(FormsTable.COLUMN_S05);
        this.s06 = jsonObject.getString(FormsTable.COLUMN_S06);
        this.s07 = jsonObject.getString(FormsTable.COLUMN_S07);
        this.s08 = jsonObject.getString(FormsTable.COLUMN_S08);
        this.s09 = jsonObject.getString(FormsTable.COLUMN_S09);
        this.s10 = jsonObject.getString(FormsTable.COLUMN_S10);
        this.s11 = jsonObject.getString(FormsTable.COLUMN_S11);
        this.s12 = jsonObject.getString(FormsTable.COLUMN_S12);
        this.s13 = jsonObject.getString(FormsTable.COLUMN_S13);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsdate = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsacc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APPVERSION);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus96x = jsonObject.getString(FormsTable.COLUMN_ISTATUS96x);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.refno = jsonObject.getString(FormsTable.COLUMN_REFNO);

        return this;

    }

    public Form Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.username = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USERNAME));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYSDATE));
        this.formdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.formtype = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMTYPE));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsacc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus96x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS96x));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.refno = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_REFNO));

        sInfoHydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SINFO)));
        s02Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S02)));
        s03Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S03)));
        s04Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S04)));
        s05Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S05)));
        s06Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S06)));
        s07Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S07)));
        s08Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S08)));
        s09Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S09)));
        s10Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S10)));
        s11Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S11)));
        s12Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S12)));
        s13Hydrate(cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_S13)));

        return this;

    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, Form.class);
    }


    public String sInfotoString() {

        JSONObject json = new JSONObject();

        try {
            json
                    .put("s1qno", s1qno)
                    .put("s1q1", s1q1)
                    .put("s1q2", s1q2)
                    .put("s1q4", s1q4)
                    .put("s1q6", s1q6)
                    .put("s1q8", s1q8)
                    .put("s1q9", s1q9)
                    .put("s1q10", s1q10)
                    .put("s1q11", s1q11)
                    .put("s1q12", s1q12)
                    .put("s1q13", s1q13)
                    .put("s1q14", s1q14)
                    .put("s1q15", s1q15)
                    .put("s1q16", s1q16)
                    .put("s1q17", s1q17)
                    .put("s1q18", s1q18)
                    .put("s1_consent", s1_consent)
                    .put("s1q19et", s1q19et)
                    .put("s1q20a", s1q20a)
                    .put("s1q20b", s1q20b)
                    .put("s1q20c", s1q20c)
                    .put("s1q20d", s1q20d)
                    .put("s1q20e", s1q20e);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s02toString() {

        JSONObject json = new JSONObject();

        try {
            json
                    .put("s2q1", s2q1)
                    .put("s2q196x", s2q196x)
                    .put("s2q2", s2q2)
                    .put("s2q296x", s2q296x)
                    .put("s2q3", s2q3)
                    .put("s2q396x", s2q396x)
                    .put("s2q4", s2q4)
                    .put("s2q5", s2q5)
                    .put("s2q596x", s2q596x)
                    .put("s2q6", s2q6)
                    .put("s2q696x", s2q696x)
                    .put("s2q7", s2q7)
                    .put("s2q8", s2q8)
                    .put("s2q801x", s2q801x)
                    .put("s2q9a", s2q9a)
                    .put("s2q9b", s2q9b)
                    .put("s2q9c", s2q9c)
                    .put("s2q9d", s2q9d)
                    .put("s2q9e", s2q9e)
                    .put("s2q9f", s2q9f)
                    .put("s2q9g", s2q9g)
                    .put("s2q9h", s2q9h)
                    .put("s2q9i", s2q9i)
                    .put("s2q9j", s2q9j)
                    .put("s2q9k", s2q9k)
                    .put("s2q9l", s2q9l)
                    .put("s2q9m", s2q9m)
                    .put("s2q9n", s2q9n)
                    .put("s2q9o", s2q9o)
                    .put("s2q9p", s2q9p)
                    .put("s2q9q", s2q9q)
                    .put("s2q9r", s2q9r)
                    .put("s2q9s", s2q9s)
                    .put("s2q10a", s2q10a)
                    .put("s2q10b", s2q10b)
                    .put("s2q10c", s2q10c)
                    .put("s2q10d", s2q10d)
                    .put("s2q10e", s2q10e)
                    .put("s2q10f", s2q10f)
                    .put("s2q10g", s2q10g)
                    .put("s2q10h", s2q10h)
                    .put("s2q10i", s2q10i)
                    .put("s2q11", s2q11)
                    .put("s2q1196x", s2q1196x)
                    .put("s2q12", s2q12)
                    .put("s2q1296x", s2q1296x)
                    .put("s2q13", s2q13)
                    .put("s2q1396x", s2q1396x)
                    .put("s2q14", s2q14)
                    .put("s2q1496x", s2q1496x)
                    .put("s2q15", s2q15)
                    .put("s2q16", s2q16)
                    .put("s2q17", s2q17)
                    .put("s2q1701x", s2q1701x)
                    .put("s2q1702x", s2q1702x)
                    .put("s2q1703x", s2q1703x)
                    .put("s2q18", s2q18)
                    .put("s2q1901", s2q1901)
                    .put("s2q1902", s2q1902)
                    .put("s2q1903", s2q1903)
                    .put("s2q1904", s2q1904)
                    .put("s2q1905", s2q1905)
                    .put("s2q1906", s2q1906)
                    .put("s2q1907", s2q1907)
                    .put("s2q20", s2q20);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s03toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s3q1", s3q1)
                    .put("s3q1096x", s3q1096x)
                    .put("s3q2", s3q2)
                    .put("s3q301", s3q301)
                    .put("s3q302", s3q302)
                    .put("s3q303", s3q303)
                    .put("s3q304", s3q304)
                    .put("s3q305", s3q305)
                    .put("s3q4", s3q4)
                    .put("s3q501", s3q501)
                    .put("s3q502", s3q502)
                    .put("s3q503", s3q503)
                    .put("s3q504", s3q504)
                    .put("s3q505", s3q505)
                    .put("s3q6a", s3q6a)
                    .put("s3q6b", s3q6b)
                    .put("s3q6c", s3q6c)
                    .put("s3q6d", s3q6d)
                    .put("s3q6e", s3q6e)
                    .put("s3q696", s3q696)
                    .put("s3q696x", s3q696x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s04toString() {
        JSONObject json = new JSONObject();

        try {
            json
/*                    .put("s4q1", s4q1)
                    .put("s4q1bx", s4q1bx)
                    .put("s4q1cx", s4q1cx)
                    .put("s4q2", s4q2)
                    .put("s4q2bx", s4q2bx)
                    .put("s4q2cx", s4q2cx)
                    .put("s4q3", s4q3)
                    .put("s4q3bx", s4q3bx)
                    .put("s4q3cx", s4q3cx)
                    .put("s4q4", s4q4)
                    .put("s4q4bx", s4q4bx)
                    .put("s4q4cx", s4q4cx)
                    .put("s4q5", s4q5);*/

                    .put("s4q1", s4q1)
                    .put("s4q1b", s4q1b)
                    .put("s4q1c", s4q1c)
                    .put("s4q2", s4q2)
                    .put("s4q2b", s4q2b)
                    .put("s4q2c", s4q2c)
                    .put("s4q3", s4q3)
                    .put("s4q3b", s4q3b)
                    .put("s4q3c", s4q3c)
                    .put("s4q4", s4q4)
                    .put("s4q4b", s4q4b)
                    .put("s4q4c", s4q4c)
                    .put("s4q5", s4q5);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s05toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s5q1", s5q1)
                    .put("s5q1a", s5q1a)
                    .put("s5q2", s5q2)
                    .put("s5q2a", s5q2a)
                    .put("s5q3", s5q3)
                    .put("s5q3a", s5q3a)
                    .put("s5q4", s5q4)
                    .put("s5q4a", s5q4a)
                    .put("s5q5", s5q5)
                    .put("s5q5a", s5q5a)
                    .put("s5q6", s5q6)
                    .put("s5q6a", s5q6a)
                    .put("s5q7", s5q7)
                    .put("s5q7a", s5q7a)
                    .put("s5q8", s5q8)
                    .put("s5q8a", s5q8a)
                    .put("s5q9", s5q9)
                    .put("s5q9a", s5q9a);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s06toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s6mea1", s6mea1)
                    .put("s6mea2", s6mea2)
                    .put("s6q1a", s6q1a)
                    .put("s6q1b", s6q1b)
                    .put("s6q2a", s6q2a)
                    .put("s6q2b", s6q2b)
                    .put("s6q3a", s6q3a)
                    .put("s6q3b", s6q3b);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s07toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s7qa", s7qa)
                    .put("s7qb", s7qb)
                    .put("s7qc", s7qc)
                    .put("s7qd", s7qd)
                    .put("s7qe", s7qe)
                    .put("s7qf", s7qf)
                    .put("s7qg", s7qg)
                    .put("s7qh", s7qh)
                    .put("s7qi", s7qi)
                    .put("s7qj", s7qj)
                    .put("s7qk", s7qk)
                    .put("s7ql", s7ql)
                    .put("s7qm", s7qm)
                    .put("s7qn", s7qn)
                    .put("s7qo", s7qo)
                    .put("s7qp", s7qp)
                    .put("s7qq", s7qq)
                    .put("s7qr", s7qr);


        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s08toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s8q1", s8q1)
                    .put("s8q1a", s8q1a)
                    .put("s8q2", s8q2)
                    .put("s8q2a", s8q2a)
                    .put("s8q2b01", s8q2b01)
                    .put("s8q2b02", s8q2b02)
                    .put("s8q2b03", s8q2b03)
                    .put("s8q2b04", s8q2b04)
                    .put("s8q2b05", s8q2b05)
                    .put("s8q2b96", s8q2b96)
                    .put("s8q2b96x", s8q2b96x)
                    .put("s8q2c01", s8q2c01)
                    .put("s8q2c02", s8q2c02)
                    .put("s8q2c03", s8q2c03)
                    .put("s8q2c04", s8q2c04)
                    .put("s8q2c96", s8q2c96)
                    .put("s8q2c96x", s8q2c96x)
                    .put("s8q3", s8q3)
                    .put("s8q3a", s8q3a)
                    .put("s8q3a01x", s8q3a01x)
                    .put("s8q4", s8q4)
                    .put("s8q4a", s8q4a)
                    .put("s8q4a01x", s8q4a01x)
                    .put("s8q5", s8q5)
                    .put("s8q6", s8q6)
                    .put("s8q7", s8q7)
                    .put("s8q7a", s8q7a)
                    .put("s8q7a01x", s8q7a01x)
                    .put("s8q7a02x", s8q7a02x)
                    .put("s8q801", s8q801)
                    .put("s8q802", s8q802)
                    .put("s8q803", s8q803)
                    .put("s8q804", s8q804)
                    .put("s8q805", s8q805)
                    .put("s8q806", s8q806)
                    .put("s8q896", s8q896)
                    .put("s8q896x", s8q896x)
                    .put("s8q899", s8q899)
                    .put("s8q9", s8q9)
                    .put("s8q996x", s8q996x)
                    .put("s8q10", s8q10)
                    .put("s8q1001x", s8q1001x)
                    .put("s8q1198", s8q1198)
                    .put("s8q1101", s8q1101)
                    .put("s8q1102", s8q1102)
                    .put("s8q1103", s8q1103)
                    .put("s8q12", s8q12)
                    .put("s8q1296x", s8q1296x)
                    .put("s8q13", s8q13)
                    .put("s8q1396x", s8q1396x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s09toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s9q1", s9q1)
                    .put("s9q2", s9q2)
                    .put("s9q3", s9q3)
                    .put("s9mea1", s9mea1)
                    .put("s9mea2", s9mea2)
                    .put("s9q4a", s9q4a)
                    .put("s9q4b", s9q4b)
                    .put("s9q5a", s9q5a)
                    .put("s9q5b", s9q5b)
                    .put("s9q6a", s9q6a);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s10toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s10q1", s10q1)
                    .put("s10q2", s10q2)
                    .put("s10q202x", s10q202x)
                    .put("s10q203x", s10q201x)
                    .put("s10q3", s10q3)
                    .put("s10q4", s10q4)
                    .put("s10q496x", s10q496x)
                    .put("s10q5", s10q5)
                    .put("s10q601", s10q601)
                    .put("s10q602", s10q602)
                    .put("s10q603", s10q603)
                    .put("s10q604", s10q604)
                    .put("s10q605", s10q605)
                    .put("s10q606", s10q606)
                    .put("s10q607", s10q607)
                    .put("s10q608", s10q608)
                    .put("s10q609", s10q609)
                    .put("s10q610", s10q610)
                    .put("s10q696", s10q696)
                    .put("s10q696x", s10q696x)
                    .put("s10q699", s10q699);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s11toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s11q7", s11q7)
                    .put("s11q7a", s11q7a)
                    .put("s11q8", s11q8)
                    .put("s11q9", s11q9)
                    .put("s11q10a", s11q10a)
                    .put("s11q10b", s11q10b)
                    .put("s11q10b01x", s11q10b01x)
                    .put("s11q10c", s11q10c)
                    .put("s11q10c01x", s11q10c01x)
                    .put("s11q10d", s11q10d)
                    .put("s11q10e", s11q10e)
                    .put("s11q10f", s11q10f)
                    .put("s11q10f01x", s11q10f01x)
                    .put("s11q10g", s11q10g)
                    .put("s11q10h", s11q10h)
                    .put("s11q10i", s11q10i)
                    .put("s11q12a", s11q12a)
                    .put("s11q12b", s11q12b)
                    .put("s11q12c", s11q12c)
                    .put("s11q12d", s11q12d)
                    .put("s11q12e", s11q12e)
                    .put("s11q12f", s11q12f)
                    .put("s11q12g", s11q12g)
                    .put("s11q12h", s11q12h)
                    .put("s11q12i", s11q12i)
                    .put("s11q12j", s11q12j)
                    .put("s11q12k", s11q12k)
                    .put("s11q12l", s11q12l)
                    .put("s11q12m", s11q12m)
                    .put("s11q12n", s11q12n)
                    .put("s11q12o", s11q12o)
                    .put("s11q12p", s11q12p)
/* Modified on portal
                    .put("s11q12p01", s11q12p01)
                    .put("s11q12p02", s11q12p02)
                    .put("s11q12p98", s11q12p98)
*/
                    .put("s11q12q", s11q12q)
/* Modified on portal
                    .put("s11q12q01", s11q12q01)
                    .put("s11q12q02", s11q12q02)
                    .put("s11q12q98", s11q12q98)
*/
                    .put("s11q13", s11q13)
                    .put("s11q14", s11q14)
                    .put("s11q1401x", s11q1401x)
                    .put("s11q15", s11q15)
                    .put("s11q16", s11q16)
                    .put("s11q1696x", s11q1696x)
                    .put("s11q17", s11q17)
                    .put("s11q1796x", s11q1796x)
                    .put("s11q18", s11q18);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s12toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s12q1", s12q1)
                    .put("s12q2a", s12q2a)
                    .put("s12q2a01x", s12q2a01x)
                    .put("s12q2b", s12q2b)
                    .put("s12q2b01x", s12q2b01x)
                    .put("s12q2c", s12q2c)
                    .put("s12q2c01x", s12q2c01x)
                    .put("s12q2d", s12q2d)
                    .put("s12q2d01x", s12q2d01x)
                    .put("s12q2e", s12q2e)
                    .put("s12q2e01x", s12q2e01x)
                    .put("s12q2f", s12q2f)
                    .put("s12q2f01x", s12q2f01x)
                    .put("s12q2g", s12q2g)
                    .put("s12q2g01x", s12q2g01x)
                    .put("s12q2h", s12q2h)
                    .put("s12q2h01x", s12q2h01x)
                    .put("s12q2i", s12q2i)
                    .put("s12q2i01x", s12q2i01x)
                    .put("s12q2j", s12q2j)
                    .put("s12q2j01x", s12q2j01x)
                    .put("s12q2k", s12q2k)
                    .put("s12q2k01x", s12q2k01x)
                    .put("s12q2l", s12q2l)
                    .put("s12q2l01x", s12q2l01x)
                    .put("s12q2m", s12q2m)
                    .put("s12q2m01x", s12q2m01x)
                    .put("s12q2n", s12q2n)
                    .put("s12q2n01x", s12q2n01x)
                    .put("s12q2o", s12q2o)
                    .put("s12q2o01x", s12q2o01x)
                    .put("s12q301", s12q301)
                    .put("s12q302", s12q302)
                    .put("s12q303", s12q303)
                    .put("s12q304", s12q304)
                    .put("s12q305", s12q305)
                    .put("s12q306", s12q306)
                    .put("s12q307", s12q307)
                    .put("s12q308", s12q308)
                    .put("s12q396", s12q396)
                    .put("s12q4", s12q4)
                    .put("s12q501", s12q501)
                    .put("s12q502", s12q502)
                    .put("s12q503", s12q503)
                    .put("s12q504", s12q504)
                    .put("s12q505", s12q505)
                    .put("s12q596", s12q596)
                    .put("s12q596x", s12q596x)
                    .put("s12q601", s12q601)
                    .put("s12q602", s12q602)
                    .put("s12q603", s12q603)
                    .put("s12q604", s12q604)
                    .put("s12q696", s12q696)
                    .put("s12q696x", s12q696x);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }

    public String s13toString() {
        JSONObject json = new JSONObject();

        try {
            json
                    .put("s13q1", s13q1)
                    .put("s13q196x", s13q196x)
                    .put("s13q2", s13q2)
                    .put("s13q201x", s13q201x)
                    .put("s13q202x", s13q202x)
                    .put("s13q3", s13q3)
                    .put("s13q4", s13q4)
                    .put("s13q496x", s13q496x)
                    .put("s13q5", s13q5)
                    .put("s13q596x", s13q596x)
                    // error on portal s13q601 missing in portal contract
                    .put("s13q601", s13q601)
                    .put("s13q602", s13q602)
                    .put("s13q603", s13q603)
                    .put("s13q696", s13q696)
                    .put("s13q696x", s13q696x)
                    // error on portal s13q698 missing in portal contract
                    .put("s13q698", s13q698)
                    .put("s13q7", s13q7)
                    .put("s13q796x", s13q796x)
                    .put("s13q8", s13q8)
                    .put("s13q896x", s13q896x)
                    .put("s13q9", s13q9)
                    .put("s13q996x", s13q996x)
                    .put("s13q1001", s13q1001)
                    .put("s13q1002", s13q1002)
                    .put("s13q1003", s13q1003)
                    .put("s13q1004", s13q1004)
                    .put("s13q1005", s13q1005)
                    .put("s13q1006", s13q1006)
                    .put("s13q1007", s13q1007);

        } catch (JSONException e)   {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
            json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            json.put(FormsTable.COLUMN_REFNO, this.refno == null ? JSONObject.NULL : this.refno);
            json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            json.put(FormsTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsTable.COLUMN_GPSDATE, this.gpsdate == null ? JSONObject.NULL : this.gpsdate);
            json.put(FormsTable.COLUMN_GPSACC, this.gpsacc == null ? JSONObject.NULL : this.gpsacc);
            json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            json.put(FormsTable.COLUMN_SINFO, new JSONObject(sInfotoString()));
            json.put(FormsTable.COLUMN_S02, new JSONObject(s02toString()));
            json.put(FormsTable.COLUMN_S03, new JSONObject(s03toString()));
            json.put(FormsTable.COLUMN_S04, new JSONObject(s04toString()));
            json.put(FormsTable.COLUMN_S05, new JSONObject(s05toString()));
            json.put(FormsTable.COLUMN_S06, new JSONObject(s06toString()));
            json.put(FormsTable.COLUMN_S07, new JSONObject(s07toString()));
            json.put(FormsTable.COLUMN_S08, new JSONObject(s08toString()));
            json.put(FormsTable.COLUMN_S09, new JSONObject(s09toString()));
            json.put(FormsTable.COLUMN_S10, new JSONObject(s10toString()));
            json.put(FormsTable.COLUMN_S11, new JSONObject(s11toString()));
            json.put(FormsTable.COLUMN_S12, new JSONObject(s12toString()));
            json.put(FormsTable.COLUMN_S13, new JSONObject(s13toString()));


            if (this.s02 != null && !this.s02.equals("")) {
                json.put(FormsTable.COLUMN_S02, new JSONObject(this.s02));
            }

            if (this.s03 != null && !this.s03.equals("")) {
                json.put(FormsTable.COLUMN_S03, new JSONObject(this.s03));
            }

            if (this.s04 != null && !this.s04.equals("")) {
                json.put(FormsTable.COLUMN_S04, new JSONObject(this.s04));
            }

            if (this.s05 != null && !this.s05.equals("")) {
                json.put(FormsTable.COLUMN_S05, new JSONObject(this.s05));
            }

            if (this.s06 != null && !this.s06.equals("")) {
                json.put(FormsTable.COLUMN_S06, new JSONObject(this.s06));
            }

            if (this.s07 != null && !this.s07.equals("")) {
                json.put(FormsTable.COLUMN_S07, new JSONObject(this.s07));
            }

            if (this.s08 != null && !this.s08.equals("")) {
                json.put(FormsTable.COLUMN_S08, new JSONObject(this.s08));
            }

            if (this.s09 != null && !this.s09.equals("")) {
                json.put(FormsTable.COLUMN_S09, new JSONObject(this.s09));
            }

            if (this.s10 != null && !this.s10.equals("")) {
                json.put(FormsTable.COLUMN_S10, new JSONObject(this.s10));
            }

            if (this.s11 != null && !this.s11.equals("")) {
                json.put(FormsTable.COLUMN_S11, new JSONObject(this.s11));
            }

            if (this.s12 != null && !this.s12.equals("")) {
                json.put(FormsTable.COLUMN_S12, new JSONObject(this.s12));
            }

            if (this.s13 != null && !this.s13.equals("")) {
                json.put(FormsTable.COLUMN_S13, new JSONObject(this.s13));
            }

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    private void sInfoHydrate(String string) {

        if (string != null) {
            try {
                JSONObject json = new JSONObject(string);

                this.s1qno = json.getString("s1qno");
                this.s1q1 = json.getString("s1q1");
                this.s1q2 = json.getString("s1q2");
                this.s1q4 = json.getString("s1q4");
                this.s1q6 = json.getString("s1q6");
                this.s1q8 = json.getString("s1q8");
                this.s1q9 = json.getString("s1q9");
                this.s1q10 = json.getString("s1q10");
                this.s1q11 = json.getString("s1q11");
                this.s1q12 = json.getString("s1q12");
                this.s1q13 = json.getString("s1q13");
                this.s1q14 = json.getString("s1q14");
                this.s1q15 = json.getString("s1q15");
                this.s1q16 = json.getString("s1q16");
                this.s1q17 = json.getString("s1q17");
                this.s1q18 = json.getString("s1q18");
                this.s1_consent = json.getString("s1_consent");
                this.s1q19et = json.getString("s1q19et");
                this.s1q20a = json.getString("s1q20a");
                this.s1q20b = json.getString("s1q20b");
                this.s1q20c = json.getString("s1q20c");
                this.s1q20d = json.getString("s1q20d");
                this.s1q20e = json.getString("s1q20e");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s02Hydrate(String string) {

        if (string != null) {
            try {
                JSONObject json = new JSONObject(string);

                this.s2q1 = json.getString("s2q1");
                this.s2q196x = json.getString("s2q196x");
                this.s2q2 = json.getString("s2q2");
                this.s2q296x = json.getString("s2q296x");
                this.s2q3 = json.getString("s2q3");
                this.s2q396x = json.getString("s2q396x");
                this.s2q4 = json.getString("s2q4");
                this.s2q5 = json.getString("s2q5");
                this.s2q596x = json.getString("s2q596x");
                this.s2q6 = json.getString("s2q6");
                this.s2q696x = json.getString("s2q696x");
                this.s2q7 = json.getString("s2q7");
                this.s2q8 = json.getString("s2q8");
                this.s2q801x = json.getString("s2q801x");
                this.s2q9a = json.getString("s2q9a");
                this.s2q9b = json.getString("s2q9b");
                this.s2q9c = json.getString("s2q9c");
                this.s2q9d = json.getString("s2q9d");
                this.s2q9e = json.getString("s2q9e");
                this.s2q9f = json.getString("s2q9f");
                this.s2q9g = json.getString("s2q9g");
                this.s2q9h = json.getString("s2q9h");
                this.s2q9i = json.getString("s2q9i");
                this.s2q9j = json.getString("s2q9j");
                this.s2q9k = json.getString("s2q9k");
                this.s2q9l = json.getString("s2q9l");
                this.s2q9m = json.getString("s2q9m");
                this.s2q9n = json.getString("s2q9n");
                this.s2q9o = json.getString("s2q9o");
                this.s2q9p = json.getString("s2q9p");
                this.s2q9q = json.getString("s2q9q");
                this.s2q9r = json.getString("s2q9r");
                this.s2q9s = json.getString("s2q9s");
                this.s2q10a = json.getString("s2q10a");
                this.s2q10b = json.getString("s2q10b");
                this.s2q10c = json.getString("s2q10c");
                this.s2q10d = json.getString("s2q10d");
                this.s2q10e = json.getString("s2q10e");
                this.s2q10f = json.getString("s2q10f");
                this.s2q10g = json.getString("s2q10g");
                this.s2q10h = json.getString("s2q10h");
                this.s2q10i = json.getString("s2q10i");
                this.s2q11 = json.getString("s2q11");
                this.s2q1196x = json.getString("s2q1196x");
                this.s2q12 = json.getString("s2q12");
                this.s2q1296x = json.getString("s2q1296x");
                this.s2q13 = json.getString("s2q13");
                this.s2q1396x = json.getString("s2q1396x");
                this.s2q14 = json.getString("s2q14");
                this.s2q1496x = json.getString("s2q1496x");
                this.s2q15 = json.getString("s2q15");
                this.s2q16 = json.getString("s2q16");
                this.s2q17 = json.getString("s2q17");
                this.s2q1701x = json.getString("s2q1701x");
                this.s2q1702x = json.getString("s2q1702x");
                this.s2q1703x = json.getString("s2q1703x");
                this.s2q18 = json.getString("s2q18");
                this.s2q1901 = json.getString("s2q1901");
                this.s2q1902 = json.getString("s2q1902");
                this.s2q1903 = json.getString("s2q1903");
                this.s2q1904 = json.getString("s2q1904");
                this.s2q1905 = json.getString("s2q1905");
                this.s2q1906 = json.getString("s2q1906");
                this.s2q1907 = json.getString("s2q1907");
                this.s2q20 = json.getString("s2q20");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s03Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s1qno = json.getString("s1qno");
                this.s1q1 = json.getString("s1q1");
                this.s1q2 = json.getString("s1q2");
                this.s1q4 = json.getString("s1q4");
                this.s1q6 = json.getString("s1q6");
                this.s1q8 = json.getString("s1q8");
                this.s1q9 = json.getString("s1q9");
                this.s1q10 = json.getString("s1q10");
                this.s1q11 = json.getString("s1q11");
                this.s1q12 = json.getString("s1q12");
                this.s1q13 = json.getString("s1q13");
                this.s1q14 = json.getString("s1q14");
                this.s1q15 = json.getString("s1q15");
                this.s1q16 = json.getString("s1q16");
                this.s1q17 = json.getString("s1q17");
                this.s1q18 = json.getString("s1q18");
                this.s1_consent = json.getString("s1_consent");
                this.s1q19et = json.getString("s1q19et");
                this.s1q20a = json.getString("s1q20a");
                this.s1q20b = json.getString("s1q20b");
                this.s1q20c = json.getString("s1q20c");
                this.s1q20d = json.getString("s1q20d");
                this.s1q20e = json.getString("s1q20e");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s04Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

/* Modified on Portal
                this.s4q1 = json.getString(" s4q1 ");
                this.s4q1bx = json.getString(" s4q1bx ");
                this.s4q1cx = json.getString(" s4q1cx ");
                this.s4q2 = json.getString(" s4q2 ");
                this.s4q2bx = json.getString(" s4q2bx ");
                this.s4q2cx = json.getString(" s4q2cx ");
                this.s4q3 = json.getString(" s4q3 ");
                this.s4q3bx = json.getString(" s4q3bx ");
                this.s4q3cx = json.getString(" s4q3cx ");
                this.s4q4 = json.getString(" s4q4 ");
                this.s4q4bx = json.getString(" s4q4bx ");
                this.s4q4cx = json.getString(" s4q4cx ");
                this.s4q5 = json.getString(" s4q5 ");
                */
                this.s4q1 = json.getString("s4q1");
                this.s4q1b = json.getString("s4q1b");
                this.s4q1c = json.getString("s4q1c");
                this.s4q2 = json.getString("s4q2");
                this.s4q2b = json.getString("s4q2b");
                this.s4q2c = json.getString("s4q2c");
                this.s4q3 = json.getString("s4q3");
                this.s4q3b = json.getString("s4q3b");
                this.s4q3c = json.getString("s4q3c");
                this.s4q4 = json.getString("s4q4");
                this.s4q4b = json.getString("s4q4b");
                this.s4q4c = json.getString("s4q4c");
                this.s4q5 = json.getString("s4q5");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s05Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s5q1 = json.getString("s5q1");
                this.s5q1a = json.getString("s5q1a");
                this.s5q2 = json.getString("s5q2");
                this.s5q2a = json.getString("s5q2a");
                this.s5q3 = json.getString("s5q3");
                this.s5q3a = json.getString("s5q3a");
                this.s5q4 = json.getString("s5q4");
                this.s5q4a = json.getString("s5q4a");
                this.s5q5 = json.getString("s5q5");
                this.s5q5a = json.getString("s5q5a");
                this.s5q6 = json.getString("s5q6");
                this.s5q6a = json.getString("s5q6a");
                this.s5q7 = json.getString("s5q7");
                this.s5q7a = json.getString("s5q7a");
                this.s5q8 = json.getString("s5q8");
                this.s5q8a = json.getString("s5q8a");
                this.s5q9 = json.getString("s5q9");
                this.s5q9a = json.getString("s5q9a");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s06Hydrate(String string){

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s6mea1 = json.getString("s6mea1");
                this.s6mea2 = json.getString("s6mea2");
                this.s6q1a = json.getString("s6q1a");
                this.s6q1b = json.getString("s6q1b");
                this.s6q2a = json.getString("s6q2a");
                this.s6q2b = json.getString("s6q2b");
                this.s6q3a = json.getString("s6q3a");
                this.s6q3b = json.getString("s6q3b");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s07Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s7qa = json.getString("s7qa");
                this.s7qb = json.getString("s7qb");
                this.s7qc = json.getString("s7qc");
                this.s7qd = json.getString("s7qd");
                this.s7qe = json.getString("s7qe");
                this.s7qf = json.getString("s7qf");
                this.s7qg = json.getString("s7qg");
                this.s7qh = json.getString("s7qh");
                this.s7qi = json.getString("s7qi");
                this.s7qj = json.getString("s7qj");
                this.s7qk = json.getString("s7qk");
                this.s7ql = json.getString("s7ql");
                this.s7qm = json.getString("s7qm");
                this.s7qn = json.getString("s7qn");
                this.s7qo = json.getString("s7qo");
                this.s7qp = json.getString("s7qp");
                this.s7qq = json.getString("s7qq");
                this.s7qr = json.getString("s7qr");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s08Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s8q1 = json.getString("s8q1");
                this.s8q1a = json.getString("s8q1a");
                this.s8q2 = json.getString("s8q2");
                this.s8q2a = json.getString("s8q2a");
                // this.s8q2btitle1 = json.getString("s8q2btitle1");
                this.s8q2b01 = json.getString("s8q2b01");
                this.s8q2b02 = json.getString("s8q2b02");
                this.s8q2b03 = json.getString("s8q2b03");
                //this.s8q2btitle2 = json.getString("s8q2btitle2");
                this.s8q2b04 = json.getString("s8q2b04");
                this.s8q2b05 = json.getString("s8q2b05");
                this.s8q2b96 = json.getString("s8q2b96");
                this.s8q2b96x = json.getString("s8q2b96x");
                this.s8q2c01 = json.getString("s8q2c01");
                this.s8q2c02 = json.getString("s8q2c02");
                this.s8q2c03 = json.getString("s8q2c03");
                this.s8q2c04 = json.getString("s8q2c04");
                this.s8q2c96 = json.getString("s8q2c96");
                this.s8q2c96x = json.getString("s8q2c96x");
                this.s8q3 = json.getString("s8q3");
                this.s8q3a = json.getString("s8q3a");
                this.s8q3a01x = json.getString("s8q3a01x");
                this.s8q4 = json.getString("s8q4");
                this.s8q4a = json.getString("s8q4a");
                this.s8q4a01x = json.getString("s8q4a01x");
                this.s8q5 = json.getString("s8q5");
                this.s8q6 = json.getString("s8q6");
                this.s8q7 = json.getString("s8q7");
                this.s8q7a = json.getString("s8q7a");
                this.s8q7a01x = json.getString("s8q7a01x");
                this.s8q7a02x = json.getString("s8q7a02x");
                //this.s8q8title1 = json.getString("s8q8title1");
                this.s8q801 = json.getString("s8q801");
                this.s8q802 = json.getString("s8q802");
                this.s8q803 = json.getString("s8q803");
                //this.s8q8title2 = json.getString("s8q8title2");
                this.s8q804 = json.getString("s8q804");
                this.s8q805 = json.getString("s8q805");
                this.s8q806 = json.getString("s8q806");
                this.s8q896 = json.getString("s8q896");
                this.s8q896x = json.getString("s8q896x");
                this.s8q899 = json.getString("s8q899");
                this.s8q9 = json.getString("s8q9");
                this.s8q996x = json.getString("s8q996x");
                this.s8q10 = json.getString("s8q10");
                this.s8q1001x = json.getString("s8q1001x");
                this.s8q1198 = json.getString("s8q1198");
                this.s8q1101 = json.getString("s8q1101");
                this.s8q1102 = json.getString("s8q1102");
                this.s8q1103 = json.getString("s8q1103");
                this.s8q12 = json.getString("s8q12");
                this.s8q1296x = json.getString("s8q1296x");
                this.s8q13 = json.getString("s8q13");
                this.s8q1396x = json.getString("s8q1396x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s09Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s9q1 = json.getString("s9q1");
                this.s9q2 = json.getString("s9q2");
                this.s9q3 = json.getString("s9q3");
                this.s9mea1 = json.getString("s9mea1");
                this.s9mea2 = json.getString("s9mea2");
                this.s9q4a = json.getString("s9q4a");
                this.s9q4b = json.getString("s9q4b");
                this.s9q5a = json.getString("s9q5a");
                this.s9q5b = json.getString("s9q5b");
                this.s9q6a = json.getString("s9q6a");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s10Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s10q1 = json.getString("s10q1");
                this.s10q2 = json.getString("s10q2");
                this.s10q202x = json.getString("s10q202x");
                this.s10q201x = json.getString("s10q201x");
                this.s10q3 = json.getString("s10q3");
                this.s10q4 = json.getString("s10q4");
                this.s10q496x = json.getString("s10q496x");
                this.s10q5 = json.getString("s10q5");
                this.s10q601 = json.getString("s10q601");
                this.s10q602 = json.getString("s10q602");
                this.s10q603 = json.getString("s10q603");
                this.s10q604 = json.getString("s10q604");
                this.s10q605 = json.getString("s10q605");
                this.s10q606 = json.getString("s10q606");
                this.s10q607 = json.getString("s10q607");
                this.s10q608 = json.getString("s10q608");
                this.s10q609 = json.getString("s10q609");
                this.s10q610 = json.getString("s10q610");
                this.s10q696 = json.getString("s10q696");
                this.s10q696x = json.getString("s10q696x");
                this.s10q699 = json.getString("s10q699");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s11Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s11q7 = json.getString("s11q7");
                this.s11q7a = json.getString("s11q7a");
                this.s11q8 = json.getString("s11q8");
                this.s11q9 = json.getString("s11q9");
                this.s11q10a = json.getString("s11q10a");
                this.s11q10b = json.getString("s11q10b");
                this.s11q10b01x = json.getString("s11q10b01x");
                this.s11q10c = json.getString("s11q10c");
                this.s11q10c01x = json.getString("s11q10c01x");
                this.s11q10d = json.getString("s11q10d");
                this.s11q10e = json.getString("s11q10e");
                this.s11q10f = json.getString("s11q10f");
                this.s11q10f01x = json.getString("s11q10f01x");
                this.s11q10g = json.getString("s11q10g");
                this.s11q10h = json.getString("s11q10h");
                this.s11q10i = json.getString("s11q10i");
                this.s11q12a = json.getString("s11q12a");
                this.s11q12b = json.getString("s11q12b");
                this.s11q12c = json.getString("s11q12c");
                this.s11q12d = json.getString("s11q12d");
                this.s11q12e = json.getString("s11q12e");
                this.s11q12f = json.getString("s11q12f");
                this.s11q12g = json.getString("s11q12g");
                this.s11q12h = json.getString("s11q12h");
                this.s11q12i = json.getString("s11q12i");
                this.s11q12j = json.getString("s11q12j");
                this.s11q12k = json.getString("s11q12k");
                this.s11q12l = json.getString("s11q12l");
                this.s11q12m = json.getString("s11q12m");
                this.s11q12n = json.getString("s11q12n");
                this.s11q12o = json.getString("s11q12o");
                this.s11q12p = json.getString("s11q12p");
/* Removed from Portal
                this.s11q12p01 = json.getString("s11q12p01");
                this.s11q12p02 = json.getString("s11q12p02");
                this.s11q12p98 = json.getString("s11q12p98");
*/
                this.s11q12q = json.getString("s11q12q");
/* Removed from Portal
                this.s11q12q01 = json.getString("s11q12q01");
                this.s11q12q02 = json.getString("s11q12q02");
                this.s11q12q98 = json.getString("s11q12q98");
*/

                this.s11q13 = json.getString("s11q13");
                this.s11q14 = json.getString("s11q14");
                this.s11q1401x = json.getString("s11q1401x");
                this.s11q15 = json.getString("s11q15");
                this.s11q16 = json.getString("s11q16");
                this.s11q1696x = json.getString("s11q1696x");
                this.s11q17 = json.getString("s11q17");
                this.s11q1796x = json.getString("s11q1796x");
                this.s11q18 = json.getString("s11q18");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s12Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s12q1 = json.getString("s12q1");
                this.s12q2a = json.getString("s12q2a");
                this.s12q2a01x = json.getString("s12q2a01x");
                this.s12q2b = json.getString("s12q2b");
                this.s12q2b01x = json.getString("s12q2b01x");
                this.s12q2c = json.getString("s12q2c");
                this.s12q2c01x = json.getString("s12q2c01x");
                this.s12q2d = json.getString("s12q2d");
                this.s12q2d01x = json.getString("s12q2d01x");
                this.s12q2e = json.getString("s12q2e");
                this.s12q2e01x = json.getString("s12q2e01x");
                this.s12q2f = json.getString("s12q2f");
                this.s12q2f01x = json.getString("s12q2f01x");
                this.s12q2g = json.getString("s12q2g");
                this.s12q2g01x = json.getString("s12q2g01x");
                this.s12q2h = json.getString("s12q2h");
                this.s12q2h01x = json.getString("s12q2h01x");
                this.s12q2i = json.getString("s12q2i");
                this.s12q2i01x = json.getString("s12q2i01x");
                this.s12q2j = json.getString("s12q2j");
                this.s12q2j01x = json.getString("s12q2j01x");
                this.s12q2k = json.getString("s12q2k");
                this.s12q2k01x = json.getString("s12q2k01x");
                this.s12q2l = json.getString("s12q2l");
                this.s12q2l01x = json.getString("s12q2l01x");
                this.s12q2m = json.getString("s12q2m");
                this.s12q2m01x = json.getString("s12q2m01x");
                this.s12q2n = json.getString("s12q2n");
                this.s12q2n01x = json.getString("s12q2n01x");
                this.s12q2o = json.getString("s12q2o");
                this.s12q2o01x = json.getString("s12q2o01x");
                this.s12q301 = json.getString("s12q301");
                this.s12q302 = json.getString("s12q302");
                this.s12q303 = json.getString("s12q303");
                this.s12q304 = json.getString("s12q304");
                this.s12q305 = json.getString("s12q305");
                this.s12q306 = json.getString("s12q306");
                this.s12q307 = json.getString("s12q307");
                this.s12q308 = json.getString("s12q308");
                this.s12q396 = json.getString("s12q396");
                this.s12q4 = json.getString("s12q4");
                // this.s12q5title1 = json.getString("s12q5title1");
                this.s12q501 = json.getString("s12q501");
                this.s12q502 = json.getString("s12q502");
                this.s12q503 = json.getString("s12q503");
                //this.s12q5title2 = json.getString("s12q5title2");
                this.s12q504 = json.getString("s12q504");
                this.s12q505 = json.getString("s12q505");
                this.s12q596 = json.getString("s12q596");
                this.s12q596x = json.getString("s12q596x");
                this.s12q601 = json.getString("s12q601");
                this.s12q602 = json.getString("s12q602");
                this.s12q603 = json.getString("s12q603");
                this.s12q604 = json.getString("s12q604");
                this.s12q696 = json.getString("s12q696");
                this.s12q696x = json.getString("s12q696x");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void s13Hydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s13q1 = json.getString("s13q1");
                this.s13q196x = json.getString("s13q196x");
                this.s13q2 = json.getString("s13q2");
                this.s13q202x = json.getString("s13q202x");
                this.s13q201x = json.getString("s13q201x");
                this.s13q3 = json.getString("s13q3");
                this.s13q4 = json.getString("s13q4");
                this.s13q496x = json.getString("s13q496x");
                this.s13q5 = json.getString("s13q5");
                this.s13q596x = json.getString("s13q596x");
                // Error on Portal
                this.s13q601 = json.getString("s13q601");
                this.s13q602 = json.getString("s13q602");
                this.s13q603 = json.getString("s13q603");
                this.s13q696 = json.getString("s13q696");
                //  Error on Portal
                this.s13q696x = json.getString("s13q696x");
                this.s13q698 = json.getString("s13q698");
                this.s13q7 = json.getString("s13q7");
                this.s13q796x = json.getString("s13q796x");
                this.s13q8 = json.getString("s13q8");
                this.s13q896x = json.getString("s13q896x");
                this.s13q9 = json.getString("s13q9");
                this.s13q996x = json.getString("s13q996x");
                this.s13q1001 = json.getString("s13q1001");
                this.s13q1002 = json.getString("s13q1002");
                this.s13q1003 = json.getString("s13q1003");
                this.s13q1004 = json.getString("s13q1004");
                this.s13q1005 = json.getString("s13q1005");
                this.s13q1006 = json.getString("s13q1006");
                this.s13q1007 = json.getString("s13q1007");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
