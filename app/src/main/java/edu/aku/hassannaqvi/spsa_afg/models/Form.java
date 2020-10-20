package edu.aku.hassannaqvi.spsa_afg.models;

import androidx.lifecycle.LiveData;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class Form extends LiveData<Form> {

    private final String projectName = "spsa_afg";
    private String _ID = "";
    private String _UID = "";
    private String username;
    private String sysdate = "";
    private String formdate = "";
    private String pid = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String istatus = ""; // Interview Status
    private String istatus96x = ""; // Interview Status
    private String endingdatetime = "";
    private String formType = "";

    // SECTIONS
    public String S01;
    public String S02;
    public String S03;
    public String S04;
    public String S05;
    public String S06;
    public String S07;
    public String S08;
    public String S09;
    public String S10;
    public String S11;
    public String S12;
    public String S13;


    public String s1_title1;
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
    public String s1q20;
    public String s1q20a;
    public String s1q20b;
    public String s1q20c;
    public String s1q20d;
    public String s1q20e;
    public String s2q1;
    public String s2q196;
    public String s2q2;
    public String s2q296;
    public String s2q3;
    public String s2q396;
    public String s2q4;
    public String s2q5;
    public String s2q596;
    public String s2q6;
    public String s2q696;
    public String s2q7;
    public String s2q8;
    public String s2q9;
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
    public String s2q10;
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
    public String s2q1196;
    public String s2q12;
    public String s2q1296;
    public String s2q13;
    public String s2q1396;
    public String s2q14;
    public String s2q1496;
    public String s2q15;
    public String s2q16;
    public String s2q17;
    public String s2q18;
    public String s2q19;
    public String s2q1901;
    public String s2q1902;
    public String s2q1903;
    public String s2q1904;
    public String s2q1905;
    public String s2q1906;
    public String s2q1907;
    public String s2q20;
    public String s3title;
    public String s3q1;
    public String s3q104;
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
    public String s4title1;
    public String s4title2;
    public String s4title3;
    public String s4q1;
    public String s4q1c;
    public String s4q2;
    public String s4q2c;
    public String s4q3;
    public String s4q3c;
    public String s4q4;
    public String s4q4c;
    public String s4q5;
    public String s5title;
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
    public String s6title;
    public String s6q1;
    public String s6q2;
    public String s6q3;
    public String s7title1;
    public String s7title2;
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
    public String s8title;
    public String s8q1;
    public String s8q1a;
    public String s8q2;
    public String s8q2a;
    public String s8q2b;
    public String s8q2btitle1;
    public String s8q2b01;
    public String s8q2b02;
    public String s8q2b03;
    public String s8q2btitle2;
    public String s8q2b04;
    public String s8q2b05;
    public String s8q2b96;
    public String s8q2c;
    public String s8q2c01;
    public String s8q2c02;
    public String s8q2c03;
    public String s8q2c04;
    public String s8q2c96;
    public String s8q3;
    public String s8q3a;
    public String s8q4;
    public String s8q4a;
    public String s8q5;
    public String s8q6;
    public String s8q7;
    public String s8q7a;
    public String s8q8;
    public String s8q8title1;
    public String s8q801;
    public String s8q802;
    public String s8q803;
    public String s8q8title2;
    public String s8q804;
    public String s8q805;
    public String s8q806;
    public String s8q896;
    public String s8q899;
    public String s8q9;
    public String s8q996;
    public String s8q10;
    public String s8q11;
    public String s8q12;
    public String s8q1296;
    public String s8q13;
    public String s8q1396;
    public String s9title;
    public String s9q1;
    public String s9q2;
    public String s9q3;
    public String s9q4;
    public String s9q5;
    public String s9q6;
    public String s10title;
    public String s10q1;
    public String s10q2;
    public String s10q3;
    public String s10q4;
    public String s10q496;
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
    public String s10q699;
    public String s11title;
    public String s11q7;
    public String s11q7a;
    public String s11q8;
    public String s11q9;
    public String s11title1;
    public String s11q10;
    public String s11q10a;
    public String s11q10b;
    public String s11q10c;
    public String s11q10d;
    public String s11q10e;
    public String s11q10f;
    public String s11q10g;
    public String s11q10h;
    public String s11q10i;
    public String s11q12;
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
    public String s11q12p01;
    public String s11q12p02;
    public String s11q12p98;
    public String s11q12q;
    public String s11q12q01;
    public String s11q12q02;
    public String s11q12q98;
    public String s11q13;
    public String s11q14;
    public String s11q15;
    public String s11q16;
    public String s11q1696;
    public String s11q17;
    public String s11q1796;
    public String s11q18;
    public String s12title;
    public String s12q1;
    public String s12q2;
    public String s12q2a;
    public String s12q2b;
    public String s12q2c;
    public String s12q2d;
    public String s12q2e;
    public String s12q2f;
    public String s12q2g;
    public String s12q2h;
    public String s12q2i;
    public String s12q2j;
    public String s12q2k;
    public String s12q2l;
    public String s12q2m;
    public String s12q2n;
    public String s12q2o;
    public String s12q3;
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
    public String s12q5title1;
    public String s12q501;
    public String s12q502;
    public String s12q503;
    public String s12q5title2;
    public String s12q504;
    public String s12q505;
    public String s12q596;
    public String s12q6;
    public String s12q601;
    public String s12q602;
    public String s12q603;
    public String s12q604;
    public String s12q696;
    public String s13title;
    public String s13q1;
    public String s13q196x;
    public String s13q2;
    public String s13q3;
    public String s13q4;
    public String s13q496;
    public String s13q5;
    public String s13q596;
    public String s13q6;
    public String s13q601;
    public String s13q602;
    public String s13q603;
    public String s13q696;
    public String s13q698;
    public String s13q7;
    public String s13q796;
    public String s13q8;
    public String s13q896;
    public String s13q9;
    public String s13q996;
    public String s13q10;
    public String s13q1001;
    public String s13q1002;
    public String s13q1003;
    public String s13q1004;
    public String s13q1005;
    public String s13q1006;
    public String s13q1007;



    public Form() {
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public Form set_ID(String _ID) {
        this._ID = _ID;
        return this;
    }

    public String get_UID() {
        return _UID;
    }

    public Form set_UID(String _UID) {
        this._UID = _UID;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Form setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSysdate() {
        return sysdate;
    }

    public Form setSysdate(String sysdate) {
        this.sysdate = sysdate;
        return this;
    }

    public String getFormdate() {
        return formdate;
    }

    public Form setFormdate(String formdate) {
        this.formdate = formdate;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public Form setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public Form setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
        return this;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public Form setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
        return this;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public Form setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
        return this;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public Form setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
        return this;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public Form setDeviceID(String deviceID) {
        this.deviceID = deviceID;
        return this;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public Form setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
        return this;
    }

    public String getSynced() {
        return synced;
    }

    public Form setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public Form setSynced_date(String synced_date) {
        this.synced_date = synced_date;
        return this;
    }

    public String getAppversion() {
        return appversion;
    }

    public Form setAppversion(String appversion) {
        this.appversion = appversion;
        return this;
    }

    public String getIstatus() {
        return istatus;
    }

    public Form setIstatus(String istatus) {
        this.istatus = istatus;
        return this;
    }

    public String getIstatus96x() {
        return istatus96x;
    }

    public Form setIstatus96x(String istatus96x) {
        this.istatus96x = istatus96x;
        return this;
    }

    public String getEndingdatetime() {
        return endingdatetime;
    }

    public Form setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
        return this;
    }


    public String getS01() {
        return S01;
    }

    public Form setS01(String s01) {
        S01 = s01;
        return this;
    }

    public String getS02() {
        return S02;
    }

    public Form setS02(String s02) {
        S02 = s02;
        return this;
    }

    public String getS03() {
        return S03;
    }

    public Form setS03(String s03) {
        S03 = s03;
        return this;
    }

    public String getS04() {
        return S04;
    }

    public Form setS04(String s04) {
        S04 = s04;
        return this;
    }

    public String getS05() {
        return S05;
    }

    public Form setS05(String s05) {
        S05 = s05;
        return this;
    }

    public String getS06() {
        return S06;
    }

    public Form setS06(String s06) {
        S06 = s06;
        return this;
    }

    public String getS07() {
        return S07;
    }

    public Form setS07(String s07) {
        S07 = s07;
        return this;
    }

    public String getS08() {
        return S08;
    }

    public Form setS08(String s08) {
        S08 = s08;
        return this;
    }

    public String getS09() {
        return S09;
    }

    public Form setS09(String s09) {
        S09 = s09;
        return this;
    }

    public String getS10() {
        return S10;
    }

    public Form setS10(String s10) {
        S10 = s10;
        return this;
    }

    public String getS11() {
        return S11;
    }

    public Form setS11(String s11) {
        S11 = s11;
        return this;
    }

    public String getS12() {
        return S12;
    }

    public Form setS12(String s12) {
        S12 = s12;
        return this;
    }

    public String getS13() {
        return S13;
    }

    public Form setS13(String s13) {
        S13 = s13;
        return this;
    }

    public String getS2q1() {
        return s2q1;
    }

    public Form setS2q1(String s2q1) {
        this.s2q1 = s2q1;
        return this;
    }

    public String getS2q196() {
        return s2q196;
    }

    public Form setS2q196(String s2q196) {
        this.s2q196 = s2q196;
        return this;
    }

    public String getS2q2() {
        return s2q2;
    }

    public Form setS2q2(String s2q2) {
        this.s2q2 = s2q2;
        return this;
    }

    public String getS2q296() {
        return s2q296;
    }

    public Form setS2q296(String s2q296) {
        this.s2q296 = s2q296;
        return this;
    }

    public String getS2q3() {
        return s2q3;
    }

    public Form setS2q3(String s2q3) {
        this.s2q3 = s2q3;
        return this;
    }

    public String getS2q396() {
        return s2q396;
    }

    public Form setS2q396(String s2q396) {
        this.s2q396 = s2q396;
        return this;
    }

    public String getS2q4() {
        return s2q4;
    }

    public Form setS2q4(String s2q4) {
        this.s2q4 = s2q4;
        return this;
    }

    public String getS2q5() {
        return s2q5;
    }

    public Form setS2q5(String s2q5) {
        this.s2q5 = s2q5;
        return this;
    }

    public String getS2q596() {
        return s2q596;
    }

    public Form setS2q596(String s2q596) {
        this.s2q596 = s2q596;
        return this;
    }

    public String getS2q6() {
        return s2q6;
    }

    public Form setS2q6(String s2q6) {
        this.s2q6 = s2q6;
        return this;
    }

    public String getS2q696() {
        return s2q696;
    }

    public Form setS2q696(String s2q696) {
        this.s2q696 = s2q696;
        return this;
    }

    public String getS2q7() {
        return s2q7;
    }

    public Form setS2q7(String s2q7) {
        this.s2q7 = s2q7;
        return this;
    }

    public String getS2q8() {
        return s2q8;
    }

    public Form setS2q8(String s2q8) {
        this.s2q8 = s2q8;
        return this;
    }

    public String getS2q9() {
        return s2q9;
    }

    public Form setS2q9(String s2q9) {
        this.s2q9 = s2q9;
        return this;
    }

    public String getS2q9a() {
        return s2q9a;
    }

    public Form setS2q9a(String s2q9a) {
        this.s2q9a = s2q9a;
        return this;
    }

    public String getS2q9b() {
        return s2q9b;
    }

    public Form setS2q9b(String s2q9b) {
        this.s2q9b = s2q9b;
        return this;
    }

    public String getS2q9c() {
        return s2q9c;
    }

    public Form setS2q9c(String s2q9c) {
        this.s2q9c = s2q9c;
        return this;
    }

    public String getS2q9d() {
        return s2q9d;
    }

    public Form setS2q9d(String s2q9d) {
        this.s2q9d = s2q9d;
        return this;
    }

    public String getS2q9e() {
        return s2q9e;
    }

    public Form setS2q9e(String s2q9e) {
        this.s2q9e = s2q9e;
        return this;
    }

    public String getS2q9f() {
        return s2q9f;
    }

    public Form setS2q9f(String s2q9f) {
        this.s2q9f = s2q9f;
        return this;
    }

    public String getS2q9g() {
        return s2q9g;
    }

    public Form setS2q9g(String s2q9g) {
        this.s2q9g = s2q9g;
        return this;
    }

    public String getS2q9h() {
        return s2q9h;
    }

    public Form setS2q9h(String s2q9h) {
        this.s2q9h = s2q9h;
        return this;
    }

    public String getS2q9i() {
        return s2q9i;
    }

    public Form setS2q9i(String s2q9i) {
        this.s2q9i = s2q9i;
        return this;
    }

    public String getS2q9j() {
        return s2q9j;
    }

    public Form setS2q9j(String s2q9j) {
        this.s2q9j = s2q9j;
        return this;
    }

    public String getS2q9k() {
        return s2q9k;
    }

    public Form setS2q9k(String s2q9k) {
        this.s2q9k = s2q9k;
        return this;
    }

    public String getS2q9l() {
        return s2q9l;
    }

    public Form setS2q9l(String s2q9l) {
        this.s2q9l = s2q9l;
        return this;
    }

    public String getS2q9m() {
        return s2q9m;
    }

    public Form setS2q9m(String s2q9m) {
        this.s2q9m = s2q9m;
        return this;
    }

    public String getS2q9n() {
        return s2q9n;
    }

    public Form setS2q9n(String s2q9n) {
        this.s2q9n = s2q9n;
        return this;
    }

    public String getS2q9o() {
        return s2q9o;
    }

    public Form setS2q9o(String s2q9o) {
        this.s2q9o = s2q9o;
        return this;
    }

    public String getS2q9p() {
        return s2q9p;
    }

    public Form setS2q9p(String s2q9p) {
        this.s2q9p = s2q9p;
        return this;
    }

    public String getS2q9q() {
        return s2q9q;
    }

    public Form setS2q9q(String s2q9q) {
        this.s2q9q = s2q9q;
        return this;
    }

    public String getS2q9r() {
        return s2q9r;
    }

    public Form setS2q9r(String s2q9r) {
        this.s2q9r = s2q9r;
        return this;
    }

    public String getS2q9s() {
        return s2q9s;
    }

    public Form setS2q9s(String s2q9s) {
        this.s2q9s = s2q9s;
        return this;
    }

    public String getS2q10() {
        return s2q10;
    }

    public Form setS2q10(String s2q10) {
        this.s2q10 = s2q10;
        return this;
    }

    public String getS2q10a() {
        return s2q10a;
    }

    public Form setS2q10a(String s2q10a) {
        this.s2q10a = s2q10a;
        return this;
    }

    public String getS2q10b() {
        return s2q10b;
    }

    public Form setS2q10b(String s2q10b) {
        this.s2q10b = s2q10b;
        return this;
    }

    public String getS2q10c() {
        return s2q10c;
    }

    public Form setS2q10c(String s2q10c) {
        this.s2q10c = s2q10c;
        return this;
    }

    public String getS2q10d() {
        return s2q10d;
    }

    public Form setS2q10d(String s2q10d) {
        this.s2q10d = s2q10d;
        return this;
    }

    public String getS2q10e() {
        return s2q10e;
    }

    public Form setS2q10e(String s2q10e) {
        this.s2q10e = s2q10e;
        return this;
    }

    public String getS2q10f() {
        return s2q10f;
    }

    public Form setS2q10f(String s2q10f) {
        this.s2q10f = s2q10f;
        return this;
    }

    public String getS2q10g() {
        return s2q10g;
    }

    public Form setS2q10g(String s2q10g) {
        this.s2q10g = s2q10g;
        return this;
    }

    public String getS2q10h() {
        return s2q10h;
    }

    public Form setS2q10h(String s2q10h) {
        this.s2q10h = s2q10h;
        return this;
    }

    public String getS2q10i() {
        return s2q10i;
    }

    public Form setS2q10i(String s2q10i) {
        this.s2q10i = s2q10i;
        return this;
    }

    public String getS2q11() {
        return s2q11;
    }

    public Form setS2q11(String s2q11) {
        this.s2q11 = s2q11;
        return this;
    }

    public String getS2q1196() {
        return s2q1196;
    }

    public Form setS2q1196(String s2q1196) {
        this.s2q1196 = s2q1196;
        return this;
    }

    public String getS2q12() {
        return s2q12;
    }

    public Form setS2q12(String s2q12) {
        this.s2q12 = s2q12;
        return this;
    }

    public String getS2q1296() {
        return s2q1296;
    }

    public Form setS2q1296(String s2q1296) {
        this.s2q1296 = s2q1296;
        return this;
    }

    public String getS2q13() {
        return s2q13;
    }

    public Form setS2q13(String s2q13) {
        this.s2q13 = s2q13;
        return this;
    }

    public String getS2q1396() {
        return s2q1396;
    }

    public Form setS2q1396(String s2q1396) {
        this.s2q1396 = s2q1396;
        return this;
    }

    public String getS2q14() {
        return s2q14;
    }

    public Form setS2q14(String s2q14) {
        this.s2q14 = s2q14;
        return this;
    }

    public String getS2q1496() {
        return s2q1496;
    }

    public Form setS2q1496(String s2q1496) {
        this.s2q1496 = s2q1496;
        return this;
    }

    public String getS2q15() {
        return s2q15;
    }

    public Form setS2q15(String s2q15) {
        this.s2q15 = s2q15;
        return this;
    }

    public String getS2q16() {
        return s2q16;
    }

    public Form setS2q16(String s2q16) {
        this.s2q16 = s2q16;
        return this;
    }

    public String getS2q17() {
        return s2q17;
    }

    public Form setS2q17(String s2q17) {
        this.s2q17 = s2q17;
        return this;
    }

    public String getS2q18() {
        return s2q18;
    }

    public Form setS2q18(String s2q18) {
        this.s2q18 = s2q18;
        return this;
    }

    public String getS2q19() {
        return s2q19;
    }

    public Form setS2q19(String s2q19) {
        this.s2q19 = s2q19;
        return this;
    }

    public String getS2q1901() {
        return s2q1901;
    }

    public Form setS2q1901(String s2q1901) {
        this.s2q1901 = s2q1901;
        return this;
    }

    public String getS2q1902() {
        return s2q1902;
    }

    public Form setS2q1902(String s2q1902) {
        this.s2q1902 = s2q1902;
        return this;
    }

    public String getS2q1903() {
        return s2q1903;
    }

    public Form setS2q1903(String s2q1903) {
        this.s2q1903 = s2q1903;
        return this;
    }

    public String getS2q1904() {
        return s2q1904;
    }

    public Form setS2q1904(String s2q1904) {
        this.s2q1904 = s2q1904;
        return this;
    }

    public String getS2q1905() {
        return s2q1905;
    }

    public Form setS2q1905(String s2q1905) {
        this.s2q1905 = s2q1905;
        return this;
    }

    public String getS2q1906() {
        return s2q1906;
    }

    public Form setS2q1906(String s2q1906) {
        this.s2q1906 = s2q1906;
        return this;
    }

    public String getS2q1907() {
        return s2q1907;
    }

    public Form setS2q1907(String s2q1907) {
        this.s2q1907 = s2q1907;
        return this;
    }

    public String getS2q20() {
        return s2q20;
    }

    public Form setS2q20(String s2q20) {
        this.s2q20 = s2q20;
        return this;
    }

    public String getS3title() {
        return s3title;
    }

    public Form setS3title(String s3title) {
        this.s3title = s3title;
        return this;
    }

    public String getS3q1() {
        return s3q1;
    }

    public Form setS3q1(String s3q1) {
        this.s3q1 = s3q1;
        return this;
    }

    public String getS3q104() {
        return s3q104;
    }

    public Form setS3q104(String s3q104) {
        this.s3q104 = s3q104;
        return this;
    }

    public String getS3q2() {
        return s3q2;
    }

    public Form setS3q2(String s3q2) {
        this.s3q2 = s3q2;
        return this;
    }

    public String getS3q3() {
        return s3q3;
    }

    public Form setS3q3(String s3q3) {
        this.s3q3 = s3q3;
        return this;
    }

    public String getS3q301() {
        return s3q301;
    }

    public Form setS3q301(String s3q301) {
        this.s3q301 = s3q301;
        return this;
    }

    public String getS3q302() {
        return s3q302;
    }

    public Form setS3q302(String s3q302) {
        this.s3q302 = s3q302;
        return this;
    }

    public String getS3q303() {
        return s3q303;
    }

    public Form setS3q303(String s3q303) {
        this.s3q303 = s3q303;
        return this;
    }

    public String getS3q304() {
        return s3q304;
    }

    public Form setS3q304(String s3q304) {
        this.s3q304 = s3q304;
        return this;
    }

    public String getS3q305() {
        return s3q305;
    }

    public Form setS3q305(String s3q305) {
        this.s3q305 = s3q305;
        return this;
    }

    public String getS3q4() {
        return s3q4;
    }

    public Form setS3q4(String s3q4) {
        this.s3q4 = s3q4;
        return this;
    }

    public String getS3q5() {
        return s3q5;
    }

    public Form setS3q5(String s3q5) {
        this.s3q5 = s3q5;
        return this;
    }

    public String getS3q501() {
        return s3q501;
    }

    public Form setS3q501(String s3q501) {
        this.s3q501 = s3q501;
        return this;
    }

    public String getS3q502() {
        return s3q502;
    }

    public Form setS3q502(String s3q502) {
        this.s3q502 = s3q502;
        return this;
    }

    public String getS3q503() {
        return s3q503;
    }

    public Form setS3q503(String s3q503) {
        this.s3q503 = s3q503;
        return this;
    }

    public String getS3q504() {
        return s3q504;
    }

    public Form setS3q504(String s3q504) {
        this.s3q504 = s3q504;
        return this;
    }

    public String getS3q505() {
        return s3q505;
    }

    public Form setS3q505(String s3q505) {
        this.s3q505 = s3q505;
        return this;
    }

    public String getS3q6() {
        return s3q6;
    }

    public Form setS3q6(String s3q6) {
        this.s3q6 = s3q6;
        return this;
    }

    public String getS3q6a() {
        return s3q6a;
    }

    public Form setS3q6a(String s3q6a) {
        this.s3q6a = s3q6a;
        return this;
    }

    public String getS3q6b() {
        return s3q6b;
    }

    public Form setS3q6b(String s3q6b) {
        this.s3q6b = s3q6b;
        return this;
    }

    public String getS3q6c() {
        return s3q6c;
    }

    public Form setS3q6c(String s3q6c) {
        this.s3q6c = s3q6c;
        return this;
    }

    public String getS3q6d() {
        return s3q6d;
    }

    public Form setS3q6d(String s3q6d) {
        this.s3q6d = s3q6d;
        return this;
    }

    public String getS3q6e() {
        return s3q6e;
    }

    public Form setS3q6e(String s3q6e) {
        this.s3q6e = s3q6e;
        return this;
    }

    public String getS3q696() {
        return s3q696;
    }

    public Form setS3q696(String s3q696) {
        this.s3q696 = s3q696;
        return this;
    }

    public String getS4title1() {
        return s4title1;
    }

    public Form setS4title1(String s4title1) {
        this.s4title1 = s4title1;
        return this;
    }

    public String getS4title2() {
        return s4title2;
    }

    public Form setS4title2(String s4title2) {
        this.s4title2 = s4title2;
        return this;
    }

    public String getS4title3() {
        return s4title3;
    }

    public Form setS4title3(String s4title3) {
        this.s4title3 = s4title3;
        return this;
    }

    public String getS4q1() {
        return s4q1;
    }

    public Form setS4q1(String s4q1) {
        this.s4q1 = s4q1;
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

    public String getS5title() {
        return s5title;
    }

    public Form setS5title(String s5title) {
        this.s5title = s5title;
        return this;
    }

    public String getS5q1() {
        return s5q1;
    }

    public Form setS5q1(String s5q1) {
        this.s5q1 = s5q1;
        return this;
    }

    public String getS5q1a() {
        return s5q1a;
    }

    public Form setS5q1a(String s5q1a) {
        this.s5q1a = s5q1a;
        return this;
    }

    public String getS5q2() {
        return s5q2;
    }

    public Form setS5q2(String s5q2) {
        this.s5q2 = s5q2;
        return this;
    }

    public String getS5q2a() {
        return s5q2a;
    }

    public Form setS5q2a(String s5q2a) {
        this.s5q2a = s5q2a;
        return this;
    }

    public String getS5q3() {
        return s5q3;
    }

    public Form setS5q3(String s5q3) {
        this.s5q3 = s5q3;
        return this;
    }

    public String getS5q3a() {
        return s5q3a;
    }

    public Form setS5q3a(String s5q3a) {
        this.s5q3a = s5q3a;
        return this;
    }

    public String getS5q4() {
        return s5q4;
    }

    public Form setS5q4(String s5q4) {
        this.s5q4 = s5q4;
        return this;
    }

    public String getS5q4a() {
        return s5q4a;
    }

    public Form setS5q4a(String s5q4a) {
        this.s5q4a = s5q4a;
        return this;
    }

    public String getS5q5() {
        return s5q5;
    }

    public Form setS5q5(String s5q5) {
        this.s5q5 = s5q5;
        return this;
    }

    public String getS5q5a() {
        return s5q5a;
    }

    public Form setS5q5a(String s5q5a) {
        this.s5q5a = s5q5a;
        return this;
    }

    public String getS5q6() {
        return s5q6;
    }

    public Form setS5q6(String s5q6) {
        this.s5q6 = s5q6;
        return this;
    }

    public String getS5q6a() {
        return s5q6a;
    }

    public Form setS5q6a(String s5q6a) {
        this.s5q6a = s5q6a;
        return this;
    }

    public String getS5q7() {
        return s5q7;
    }

    public Form setS5q7(String s5q7) {
        this.s5q7 = s5q7;
        return this;
    }

    public String getS5q7a() {
        return s5q7a;
    }

    public Form setS5q7a(String s5q7a) {
        this.s5q7a = s5q7a;
        return this;
    }

    public String getS5q8() {
        return s5q8;
    }

    public Form setS5q8(String s5q8) {
        this.s5q8 = s5q8;
        return this;
    }

    public String getS5q8a() {
        return s5q8a;
    }

    public Form setS5q8a(String s5q8a) {
        this.s5q8a = s5q8a;
        return this;
    }

    public String getS5q9() {
        return s5q9;
    }

    public Form setS5q9(String s5q9) {
        this.s5q9 = s5q9;
        return this;
    }

    public String getS5q9a() {
        return s5q9a;
    }

    public Form setS5q9a(String s5q9a) {
        this.s5q9a = s5q9a;
        return this;
    }

    public String getS6title() {
        return s6title;
    }

    public Form setS6title(String s6title) {
        this.s6title = s6title;
        return this;
    }

    public String getS6q1() {
        return s6q1;
    }

    public Form setS6q1(String s6q1) {
        this.s6q1 = s6q1;
        return this;
    }

    public String getS6q2() {
        return s6q2;
    }

    public Form setS6q2(String s6q2) {
        this.s6q2 = s6q2;
        return this;
    }

    public String getS6q3() {
        return s6q3;
    }

    public Form setS6q3(String s6q3) {
        this.s6q3 = s6q3;
        return this;
    }

    public String getS7title1() {
        return s7title1;
    }

    public Form setS7title1(String s7title1) {
        this.s7title1 = s7title1;
        return this;
    }

    public String getS7title2() {
        return s7title2;
    }

    public Form setS7title2(String s7title2) {
        this.s7title2 = s7title2;
        return this;
    }

    public String getS7qa() {
        return s7qa;
    }

    public Form setS7qa(String s7qa) {
        this.s7qa = s7qa;
        return this;
    }

    public String getS7qb() {
        return s7qb;
    }

    public Form setS7qb(String s7qb) {
        this.s7qb = s7qb;
        return this;
    }

    public String getS7qc() {
        return s7qc;
    }

    public Form setS7qc(String s7qc) {
        this.s7qc = s7qc;
        return this;
    }

    public String getS7qd() {
        return s7qd;
    }

    public Form setS7qd(String s7qd) {
        this.s7qd = s7qd;
        return this;
    }

    public String getS7qe() {
        return s7qe;
    }

    public Form setS7qe(String s7qe) {
        this.s7qe = s7qe;
        return this;
    }

    public String getS7qf() {
        return s7qf;
    }

    public Form setS7qf(String s7qf) {
        this.s7qf = s7qf;
        return this;
    }

    public String getS7qg() {
        return s7qg;
    }

    public Form setS7qg(String s7qg) {
        this.s7qg = s7qg;
        return this;
    }

    public String getS7qh() {
        return s7qh;
    }

    public Form setS7qh(String s7qh) {
        this.s7qh = s7qh;
        return this;
    }

    public String getS7qi() {
        return s7qi;
    }

    public Form setS7qi(String s7qi) {
        this.s7qi = s7qi;
        return this;
    }

    public String getS7qj() {
        return s7qj;
    }

    public Form setS7qj(String s7qj) {
        this.s7qj = s7qj;
        return this;
    }

    public String getS7qk() {
        return s7qk;
    }

    public Form setS7qk(String s7qk) {
        this.s7qk = s7qk;
        return this;
    }

    public String getS7ql() {
        return s7ql;
    }

    public Form setS7ql(String s7ql) {
        this.s7ql = s7ql;
        return this;
    }

    public String getS7qm() {
        return s7qm;
    }

    public Form setS7qm(String s7qm) {
        this.s7qm = s7qm;
        return this;
    }

    public String getS7qn() {
        return s7qn;
    }

    public Form setS7qn(String s7qn) {
        this.s7qn = s7qn;
        return this;
    }

    public String getS7qo() {
        return s7qo;
    }

    public Form setS7qo(String s7qo) {
        this.s7qo = s7qo;
        return this;
    }

    public String getS7qp() {
        return s7qp;
    }

    public Form setS7qp(String s7qp) {
        this.s7qp = s7qp;
        return this;
    }

    public String getS7qq() {
        return s7qq;
    }

    public Form setS7qq(String s7qq) {
        this.s7qq = s7qq;
        return this;
    }

    public String getS7qr() {
        return s7qr;
    }

    public Form setS7qr(String s7qr) {
        this.s7qr = s7qr;
        return this;
    }

    public String getS8title() {
        return s8title;
    }

    public Form setS8title(String s8title) {
        this.s8title = s8title;
        return this;
    }

    public String getS8q1() {
        return s8q1;
    }

    public Form setS8q1(String s8q1) {
        this.s8q1 = s8q1;
        return this;
    }

    public String getS8q1a() {
        return s8q1a;
    }

    public Form setS8q1a(String s8q1a) {
        this.s8q1a = s8q1a;
        return this;
    }

    public String getS8q2() {
        return s8q2;
    }

    public Form setS8q2(String s8q2) {
        this.s8q2 = s8q2;
        return this;
    }

    public String getS8q2a() {
        return s8q2a;
    }

    public Form setS8q2a(String s8q2a) {
        this.s8q2a = s8q2a;
        return this;
    }

    public String getS8q2b() {
        return s8q2b;
    }

    public Form setS8q2b(String s8q2b) {
        this.s8q2b = s8q2b;
        return this;
    }

    public String getS8q2btitle1() {
        return s8q2btitle1;
    }

    public Form setS8q2btitle1(String s8q2btitle1) {
        this.s8q2btitle1 = s8q2btitle1;
        return this;
    }

    public String getS8q2b01() {
        return s8q2b01;
    }

    public Form setS8q2b01(String s8q2b01) {
        this.s8q2b01 = s8q2b01;
        return this;
    }

    public String getS8q2b02() {
        return s8q2b02;
    }

    public Form setS8q2b02(String s8q2b02) {
        this.s8q2b02 = s8q2b02;
        return this;
    }

    public String getS8q2b03() {
        return s8q2b03;
    }

    public Form setS8q2b03(String s8q2b03) {
        this.s8q2b03 = s8q2b03;
        return this;
    }

    public String getS8q2btitle2() {
        return s8q2btitle2;
    }

    public Form setS8q2btitle2(String s8q2btitle2) {
        this.s8q2btitle2 = s8q2btitle2;
        return this;
    }

    public String getS8q2b04() {
        return s8q2b04;
    }

    public Form setS8q2b04(String s8q2b04) {
        this.s8q2b04 = s8q2b04;
        return this;
    }

    public String getS8q2b05() {
        return s8q2b05;
    }

    public Form setS8q2b05(String s8q2b05) {
        this.s8q2b05 = s8q2b05;
        return this;
    }

    public String getS8q2b96() {
        return s8q2b96;
    }

    public Form setS8q2b96(String s8q2b96) {
        this.s8q2b96 = s8q2b96;
        return this;
    }

    public String getS8q2c() {
        return s8q2c;
    }

    public Form setS8q2c(String s8q2c) {
        this.s8q2c = s8q2c;
        return this;
    }

    public String getS8q2c01() {
        return s8q2c01;
    }

    public Form setS8q2c01(String s8q2c01) {
        this.s8q2c01 = s8q2c01;
        return this;
    }

    public String getS8q2c02() {
        return s8q2c02;
    }

    public Form setS8q2c02(String s8q2c02) {
        this.s8q2c02 = s8q2c02;
        return this;
    }

    public String getS8q2c03() {
        return s8q2c03;
    }

    public Form setS8q2c03(String s8q2c03) {
        this.s8q2c03 = s8q2c03;
        return this;
    }

    public String getS8q2c04() {
        return s8q2c04;
    }

    public Form setS8q2c04(String s8q2c04) {
        this.s8q2c04 = s8q2c04;
        return this;
    }

    public String getS8q2c96() {
        return s8q2c96;
    }

    public Form setS8q2c96(String s8q2c96) {
        this.s8q2c96 = s8q2c96;
        return this;
    }

    public String getS8q3() {
        return s8q3;
    }

    public Form setS8q3(String s8q3) {
        this.s8q3 = s8q3;
        return this;
    }

    public String getS8q3a() {
        return s8q3a;
    }

    public Form setS8q3a(String s8q3a) {
        this.s8q3a = s8q3a;
        return this;
    }

    public String getS8q4() {
        return s8q4;
    }

    public Form setS8q4(String s8q4) {
        this.s8q4 = s8q4;
        return this;
    }

    public String getS8q4a() {
        return s8q4a;
    }

    public Form setS8q4a(String s8q4a) {
        this.s8q4a = s8q4a;
        return this;
    }

    public String getS8q5() {
        return s8q5;
    }

    public Form setS8q5(String s8q5) {
        this.s8q5 = s8q5;
        return this;
    }

    public String getS8q6() {
        return s8q6;
    }

    public Form setS8q6(String s8q6) {
        this.s8q6 = s8q6;
        return this;
    }

    public String getS8q7() {
        return s8q7;
    }

    public Form setS8q7(String s8q7) {
        this.s8q7 = s8q7;
        return this;
    }

    public String getS8q7a() {
        return s8q7a;
    }

    public Form setS8q7a(String s8q7a) {
        this.s8q7a = s8q7a;
        return this;
    }

    public String getS8q8() {
        return s8q8;
    }

    public Form setS8q8(String s8q8) {
        this.s8q8 = s8q8;
        return this;
    }

    public String getS8q8title1() {
        return s8q8title1;
    }

    public Form setS8q8title1(String s8q8title1) {
        this.s8q8title1 = s8q8title1;
        return this;
    }

    public String getS8q801() {
        return s8q801;
    }

    public Form setS8q801(String s8q801) {
        this.s8q801 = s8q801;
        return this;
    }

    public String getS8q802() {
        return s8q802;
    }

    public Form setS8q802(String s8q802) {
        this.s8q802 = s8q802;
        return this;
    }

    public String getS8q803() {
        return s8q803;
    }

    public Form setS8q803(String s8q803) {
        this.s8q803 = s8q803;
        return this;
    }

    public String getS8q8title2() {
        return s8q8title2;
    }

    public Form setS8q8title2(String s8q8title2) {
        this.s8q8title2 = s8q8title2;
        return this;
    }

    public String getS8q804() {
        return s8q804;
    }

    public Form setS8q804(String s8q804) {
        this.s8q804 = s8q804;
        return this;
    }

    public String getS8q805() {
        return s8q805;
    }

    public Form setS8q805(String s8q805) {
        this.s8q805 = s8q805;
        return this;
    }

    public String getS8q806() {
        return s8q806;
    }

    public Form setS8q806(String s8q806) {
        this.s8q806 = s8q806;
        return this;
    }

    public String getS8q896() {
        return s8q896;
    }

    public Form setS8q896(String s8q896) {
        this.s8q896 = s8q896;
        return this;
    }

    public String getS8q899() {
        return s8q899;
    }

    public Form setS8q899(String s8q899) {
        this.s8q899 = s8q899;
        return this;
    }

    public String getS8q9() {
        return s8q9;
    }

    public Form setS8q9(String s8q9) {
        this.s8q9 = s8q9;
        return this;
    }

    public String getS8q996() {
        return s8q996;
    }

    public Form setS8q996(String s8q996) {
        this.s8q996 = s8q996;
        return this;
    }

    public String getS8q10() {
        return s8q10;
    }

    public Form setS8q10(String s8q10) {
        this.s8q10 = s8q10;
        return this;
    }

    public String getS8q11() {
        return s8q11;
    }

    public Form setS8q11(String s8q11) {
        this.s8q11 = s8q11;
        return this;
    }

    public String getS8q12() {
        return s8q12;
    }

    public Form setS8q12(String s8q12) {
        this.s8q12 = s8q12;
        return this;
    }

    public String getS8q1296() {
        return s8q1296;
    }

    public Form setS8q1296(String s8q1296) {
        this.s8q1296 = s8q1296;
        return this;
    }

    public String getS8q13() {
        return s8q13;
    }

    public Form setS8q13(String s8q13) {
        this.s8q13 = s8q13;
        return this;
    }

    public String getS8q1396() {
        return s8q1396;
    }

    public Form setS8q1396(String s8q1396) {
        this.s8q1396 = s8q1396;
        return this;
    }

    public String getS9title() {
        return s9title;
    }

    public Form setS9title(String s9title) {
        this.s9title = s9title;
        return this;
    }

    public String getS9q1() {
        return s9q1;
    }

    public Form setS9q1(String s9q1) {
        this.s9q1 = s9q1;
        return this;
    }

    public String getS9q2() {
        return s9q2;
    }

    public Form setS9q2(String s9q2) {
        this.s9q2 = s9q2;
        return this;
    }

    public String getS9q3() {
        return s9q3;
    }

    public Form setS9q3(String s9q3) {
        this.s9q3 = s9q3;
        return this;
    }

    public String getS9q4() {
        return s9q4;
    }

    public Form setS9q4(String s9q4) {
        this.s9q4 = s9q4;
        return this;
    }

    public String getS9q5() {
        return s9q5;
    }

    public Form setS9q5(String s9q5) {
        this.s9q5 = s9q5;
        return this;
    }

    public String getS9q6() {
        return s9q6;
    }

    public Form setS9q6(String s9q6) {
        this.s9q6 = s9q6;
        return this;
    }

    public String getS10title() {
        return s10title;
    }

    public Form setS10title(String s10title) {
        this.s10title = s10title;
        return this;
    }

    public String getS10q1() {
        return s10q1;
    }

    public Form setS10q1(String s10q1) {
        this.s10q1 = s10q1;
        return this;
    }

    public String getS10q2() {
        return s10q2;
    }

    public Form setS10q2(String s10q2) {
        this.s10q2 = s10q2;
        return this;
    }

    public String getS10q3() {
        return s10q3;
    }

    public Form setS10q3(String s10q3) {
        this.s10q3 = s10q3;
        return this;
    }

    public String getS10q4() {
        return s10q4;
    }

    public Form setS10q4(String s10q4) {
        this.s10q4 = s10q4;
        return this;
    }

    public String getS10q496() {
        return s10q496;
    }

    public Form setS10q496(String s10q496) {
        this.s10q496 = s10q496;
        return this;
    }

    public String getS10q5() {
        return s10q5;
    }

    public Form setS10q5(String s10q5) {
        this.s10q5 = s10q5;
        return this;
    }

    public String getS10q6() {
        return s10q6;
    }

    public Form setS10q6(String s10q6) {
        this.s10q6 = s10q6;
        return this;
    }

    public String getS10q601() {
        return s10q601;
    }

    public Form setS10q601(String s10q601) {
        this.s10q601 = s10q601;
        return this;
    }

    public String getS10q602() {
        return s10q602;
    }

    public Form setS10q602(String s10q602) {
        this.s10q602 = s10q602;
        return this;
    }

    public String getS10q603() {
        return s10q603;
    }

    public Form setS10q603(String s10q603) {
        this.s10q603 = s10q603;
        return this;
    }

    public String getS10q604() {
        return s10q604;
    }

    public Form setS10q604(String s10q604) {
        this.s10q604 = s10q604;
        return this;
    }

    public String getS10q605() {
        return s10q605;
    }

    public Form setS10q605(String s10q605) {
        this.s10q605 = s10q605;
        return this;
    }

    public String getS10q606() {
        return s10q606;
    }

    public Form setS10q606(String s10q606) {
        this.s10q606 = s10q606;
        return this;
    }

    public String getS10q607() {
        return s10q607;
    }

    public Form setS10q607(String s10q607) {
        this.s10q607 = s10q607;
        return this;
    }

    public String getS10q608() {
        return s10q608;
    }

    public Form setS10q608(String s10q608) {
        this.s10q608 = s10q608;
        return this;
    }

    public String getS10q609() {
        return s10q609;
    }

    public Form setS10q609(String s10q609) {
        this.s10q609 = s10q609;
        return this;
    }

    public String getS10q610() {
        return s10q610;
    }

    public Form setS10q610(String s10q610) {
        this.s10q610 = s10q610;
        return this;
    }

    public String getS10q696() {
        return s10q696;
    }

    public Form setS10q696(String s10q696) {
        this.s10q696 = s10q696;
        return this;
    }

    public String getS10q699() {
        return s10q699;
    }

    public Form setS10q699(String s10q699) {
        this.s10q699 = s10q699;
        return this;
    }

    public String getS11title() {
        return s11title;
    }

    public Form setS11title(String s11title) {
        this.s11title = s11title;
        return this;
    }

    public String getS11q7() {
        return s11q7;
    }

    public Form setS11q7(String s11q7) {
        this.s11q7 = s11q7;
        return this;
    }

    public String getS11q7a() {
        return s11q7a;
    }

    public Form setS11q7a(String s11q7a) {
        this.s11q7a = s11q7a;
        return this;
    }

    public String getS11q8() {
        return s11q8;
    }

    public Form setS11q8(String s11q8) {
        this.s11q8 = s11q8;
        return this;
    }

    public String getS11q9() {
        return s11q9;
    }

    public Form setS11q9(String s11q9) {
        this.s11q9 = s11q9;
        return this;
    }

    public String getS11title1() {
        return s11title1;
    }

    public Form setS11title1(String s11title1) {
        this.s11title1 = s11title1;
        return this;
    }

    public String getS11q10() {
        return s11q10;
    }

    public Form setS11q10(String s11q10) {
        this.s11q10 = s11q10;
        return this;
    }

    public String getS11q10a() {
        return s11q10a;
    }

    public Form setS11q10a(String s11q10a) {
        this.s11q10a = s11q10a;
        return this;
    }

    public String getS11q10b() {
        return s11q10b;
    }

    public Form setS11q10b(String s11q10b) {
        this.s11q10b = s11q10b;
        return this;
    }

    public String getS11q10c() {
        return s11q10c;
    }

    public Form setS11q10c(String s11q10c) {
        this.s11q10c = s11q10c;
        return this;
    }

    public String getS11q10d() {
        return s11q10d;
    }

    public Form setS11q10d(String s11q10d) {
        this.s11q10d = s11q10d;
        return this;
    }

    public String getS11q10e() {
        return s11q10e;
    }

    public Form setS11q10e(String s11q10e) {
        this.s11q10e = s11q10e;
        return this;
    }

    public String getS11q10f() {
        return s11q10f;
    }

    public Form setS11q10f(String s11q10f) {
        this.s11q10f = s11q10f;
        return this;
    }

    public String getS11q10g() {
        return s11q10g;
    }

    public Form setS11q10g(String s11q10g) {
        this.s11q10g = s11q10g;
        return this;
    }

    public String getS11q10h() {
        return s11q10h;
    }

    public Form setS11q10h(String s11q10h) {
        this.s11q10h = s11q10h;
        return this;
    }

    public String getS11q10i() {
        return s11q10i;
    }

    public Form setS11q10i(String s11q10i) {
        this.s11q10i = s11q10i;
        return this;
    }

    public String getS11q12() {
        return s11q12;
    }

    public Form setS11q12(String s11q12) {
        this.s11q12 = s11q12;
        return this;
    }

    public String getS11q12a() {
        return s11q12a;
    }

    public Form setS11q12a(String s11q12a) {
        this.s11q12a = s11q12a;
        return this;
    }

    public String getS11q12b() {
        return s11q12b;
    }

    public Form setS11q12b(String s11q12b) {
        this.s11q12b = s11q12b;
        return this;
    }

    public String getS11q12c() {
        return s11q12c;
    }

    public Form setS11q12c(String s11q12c) {
        this.s11q12c = s11q12c;
        return this;
    }

    public String getS11q12d() {
        return s11q12d;
    }

    public Form setS11q12d(String s11q12d) {
        this.s11q12d = s11q12d;
        return this;
    }

    public String getS11q12e() {
        return s11q12e;
    }

    public Form setS11q12e(String s11q12e) {
        this.s11q12e = s11q12e;
        return this;
    }

    public String getS11q12f() {
        return s11q12f;
    }

    public Form setS11q12f(String s11q12f) {
        this.s11q12f = s11q12f;
        return this;
    }

    public String getS11q12g() {
        return s11q12g;
    }

    public Form setS11q12g(String s11q12g) {
        this.s11q12g = s11q12g;
        return this;
    }

    public String getS11q12h() {
        return s11q12h;
    }

    public Form setS11q12h(String s11q12h) {
        this.s11q12h = s11q12h;
        return this;
    }

    public String getS11q12i() {
        return s11q12i;
    }

    public Form setS11q12i(String s11q12i) {
        this.s11q12i = s11q12i;
        return this;
    }

    public String getS11q12j() {
        return s11q12j;
    }

    public Form setS11q12j(String s11q12j) {
        this.s11q12j = s11q12j;
        return this;
    }

    public String getS11q12k() {
        return s11q12k;
    }

    public Form setS11q12k(String s11q12k) {
        this.s11q12k = s11q12k;
        return this;
    }

    public String getS11q12l() {
        return s11q12l;
    }

    public Form setS11q12l(String s11q12l) {
        this.s11q12l = s11q12l;
        return this;
    }

    public String getS11q12m() {
        return s11q12m;
    }

    public Form setS11q12m(String s11q12m) {
        this.s11q12m = s11q12m;
        return this;
    }

    public String getS11q12n() {
        return s11q12n;
    }

    public Form setS11q12n(String s11q12n) {
        this.s11q12n = s11q12n;
        return this;
    }

    public String getS11q12o() {
        return s11q12o;
    }

    public Form setS11q12o(String s11q12o) {
        this.s11q12o = s11q12o;
        return this;
    }

    public String getS11q12p() {
        return s11q12p;
    }

    public Form setS11q12p(String s11q12p) {
        this.s11q12p = s11q12p;
        return this;
    }

    public String getS11q12p01() {
        return s11q12p01;
    }

    public Form setS11q12p01(String s11q12p01) {
        this.s11q12p01 = s11q12p01;
        return this;
    }

    public String getS11q12p02() {
        return s11q12p02;
    }

    public Form setS11q12p02(String s11q12p02) {
        this.s11q12p02 = s11q12p02;
        return this;
    }

    public String getS11q12p98() {
        return s11q12p98;
    }

    public Form setS11q12p98(String s11q12p98) {
        this.s11q12p98 = s11q12p98;
        return this;
    }

    public String getS11q12q() {
        return s11q12q;
    }

    public Form setS11q12q(String s11q12q) {
        this.s11q12q = s11q12q;
        return this;
    }

    public String getS11q12q01() {
        return s11q12q01;
    }

    public Form setS11q12q01(String s11q12q01) {
        this.s11q12q01 = s11q12q01;
        return this;
    }

    public String getS11q12q02() {
        return s11q12q02;
    }

    public Form setS11q12q02(String s11q12q02) {
        this.s11q12q02 = s11q12q02;
        return this;
    }

    public String getS11q12q98() {
        return s11q12q98;
    }

    public Form setS11q12q98(String s11q12q98) {
        this.s11q12q98 = s11q12q98;
        return this;
    }

    public String getS11q13() {
        return s11q13;
    }

    public Form setS11q13(String s11q13) {
        this.s11q13 = s11q13;
        return this;
    }

    public String getS11q14() {
        return s11q14;
    }

    public Form setS11q14(String s11q14) {
        this.s11q14 = s11q14;
        return this;
    }

    public String getS11q15() {
        return s11q15;
    }

    public Form setS11q15(String s11q15) {
        this.s11q15 = s11q15;
        return this;
    }

    public String getS11q16() {
        return s11q16;
    }

    public Form setS11q16(String s11q16) {
        this.s11q16 = s11q16;
        return this;
    }

    public String getS11q1696() {
        return s11q1696;
    }

    public Form setS11q1696(String s11q1696) {
        this.s11q1696 = s11q1696;
        return this;
    }

    public String getS11q17() {
        return s11q17;
    }

    public Form setS11q17(String s11q17) {
        this.s11q17 = s11q17;
        return this;
    }

    public String getS11q1796() {
        return s11q1796;
    }

    public Form setS11q1796(String s11q1796) {
        this.s11q1796 = s11q1796;
        return this;
    }

    public String getS11q18() {
        return s11q18;
    }

    public Form setS11q18(String s11q18) {
        this.s11q18 = s11q18;
        return this;
    }

    public String getS12title() {
        return s12title;
    }

    public Form setS12title(String s12title) {
        this.s12title = s12title;
        return this;
    }

    public String getS12q1() {
        return s12q1;
    }

    public Form setS12q1(String s12q1) {
        this.s12q1 = s12q1;
        return this;
    }

    public String getS12q2() {
        return s12q2;
    }

    public Form setS12q2(String s12q2) {
        this.s12q2 = s12q2;
        return this;
    }

    public String getS12q2a() {
        return s12q2a;
    }

    public Form setS12q2a(String s12q2a) {
        this.s12q2a = s12q2a;
        return this;
    }

    public String getS12q2b() {
        return s12q2b;
    }

    public Form setS12q2b(String s12q2b) {
        this.s12q2b = s12q2b;
        return this;
    }

    public String getS12q2c() {
        return s12q2c;
    }

    public Form setS12q2c(String s12q2c) {
        this.s12q2c = s12q2c;
        return this;
    }

    public String getS12q2d() {
        return s12q2d;
    }

    public Form setS12q2d(String s12q2d) {
        this.s12q2d = s12q2d;
        return this;
    }

    public String getS12q2e() {
        return s12q2e;
    }

    public Form setS12q2e(String s12q2e) {
        this.s12q2e = s12q2e;
        return this;
    }

    public String getS12q2f() {
        return s12q2f;
    }

    public Form setS12q2f(String s12q2f) {
        this.s12q2f = s12q2f;
        return this;
    }

    public String getS12q2g() {
        return s12q2g;
    }

    public Form setS12q2g(String s12q2g) {
        this.s12q2g = s12q2g;
        return this;
    }

    public String getS12q2h() {
        return s12q2h;
    }

    public Form setS12q2h(String s12q2h) {
        this.s12q2h = s12q2h;
        return this;
    }

    public String getS12q2i() {
        return s12q2i;
    }

    public Form setS12q2i(String s12q2i) {
        this.s12q2i = s12q2i;
        return this;
    }

    public String getS12q2j() {
        return s12q2j;
    }

    public Form setS12q2j(String s12q2j) {
        this.s12q2j = s12q2j;
        return this;
    }

    public String getS12q2k() {
        return s12q2k;
    }

    public Form setS12q2k(String s12q2k) {
        this.s12q2k = s12q2k;
        return this;
    }

    public String getS12q2l() {
        return s12q2l;
    }

    public Form setS12q2l(String s12q2l) {
        this.s12q2l = s12q2l;
        return this;
    }

    public String getS12q2m() {
        return s12q2m;
    }

    public Form setS12q2m(String s12q2m) {
        this.s12q2m = s12q2m;
        return this;
    }

    public String getS12q2n() {
        return s12q2n;
    }

    public Form setS12q2n(String s12q2n) {
        this.s12q2n = s12q2n;
        return this;
    }

    public String getS12q2o() {
        return s12q2o;
    }

    public Form setS12q2o(String s12q2o) {
        this.s12q2o = s12q2o;
        return this;
    }

    public String getS12q3() {
        return s12q3;
    }

    public Form setS12q3(String s12q3) {
        this.s12q3 = s12q3;
        return this;
    }

    public String getS12q301() {
        return s12q301;
    }

    public Form setS12q301(String s12q301) {
        this.s12q301 = s12q301;
        return this;
    }

    public String getS12q302() {
        return s12q302;
    }

    public Form setS12q302(String s12q302) {
        this.s12q302 = s12q302;
        return this;
    }

    public String getS12q303() {
        return s12q303;
    }

    public Form setS12q303(String s12q303) {
        this.s12q303 = s12q303;
        return this;
    }

    public String getS12q304() {
        return s12q304;
    }

    public Form setS12q304(String s12q304) {
        this.s12q304 = s12q304;
        return this;
    }

    public String getS12q305() {
        return s12q305;
    }

    public Form setS12q305(String s12q305) {
        this.s12q305 = s12q305;
        return this;
    }

    public String getS12q306() {
        return s12q306;
    }

    public Form setS12q306(String s12q306) {
        this.s12q306 = s12q306;
        return this;
    }

    public String getS12q307() {
        return s12q307;
    }

    public Form setS12q307(String s12q307) {
        this.s12q307 = s12q307;
        return this;
    }

    public String getS12q308() {
        return s12q308;
    }

    public Form setS12q308(String s12q308) {
        this.s12q308 = s12q308;
        return this;
    }

    public String getS12q396() {
        return s12q396;
    }

    public Form setS12q396(String s12q396) {
        this.s12q396 = s12q396;
        return this;
    }

    public String getS12q4() {
        return s12q4;
    }

    public Form setS12q4(String s12q4) {
        this.s12q4 = s12q4;
        return this;
    }

    public String getS12q5() {
        return s12q5;
    }

    public Form setS12q5(String s12q5) {
        this.s12q5 = s12q5;
        return this;
    }

    public String getS12q5title1() {
        return s12q5title1;
    }

    public Form setS12q5title1(String s12q5title1) {
        this.s12q5title1 = s12q5title1;
        return this;
    }

    public String getS12q501() {
        return s12q501;
    }

    public Form setS12q501(String s12q501) {
        this.s12q501 = s12q501;
        return this;
    }

    public String getS12q502() {
        return s12q502;
    }

    public Form setS12q502(String s12q502) {
        this.s12q502 = s12q502;
        return this;
    }

    public String getS12q503() {
        return s12q503;
    }

    public Form setS12q503(String s12q503) {
        this.s12q503 = s12q503;
        return this;
    }

    public String getS12q5title2() {
        return s12q5title2;
    }

    public Form setS12q5title2(String s12q5title2) {
        this.s12q5title2 = s12q5title2;
        return this;
    }

    public String getS12q504() {
        return s12q504;
    }

    public Form setS12q504(String s12q504) {
        this.s12q504 = s12q504;
        return this;
    }

    public String getS12q505() {
        return s12q505;
    }

    public Form setS12q505(String s12q505) {
        this.s12q505 = s12q505;
        return this;
    }

    public String getS12q596() {
        return s12q596;
    }

    public Form setS12q596(String s12q596) {
        this.s12q596 = s12q596;
        return this;
    }

    public String getS12q6() {
        return s12q6;
    }

    public Form setS12q6(String s12q6) {
        this.s12q6 = s12q6;
        return this;
    }

    public String getS12q601() {
        return s12q601;
    }

    public Form setS12q601(String s12q601) {
        this.s12q601 = s12q601;
        return this;
    }

    public String getS12q602() {
        return s12q602;
    }

    public Form setS12q602(String s12q602) {
        this.s12q602 = s12q602;
        return this;
    }

    public String getS12q603() {
        return s12q603;
    }

    public Form setS12q603(String s12q603) {
        this.s12q603 = s12q603;
        return this;
    }

    public String getS12q604() {
        return s12q604;
    }

    public Form setS12q604(String s12q604) {
        this.s12q604 = s12q604;
        return this;
    }

    public String getS12q696() {
        return s12q696;
    }

    public Form setS12q696(String s12q696) {
        this.s12q696 = s12q696;
        return this;
    }

    public String getS13title() {
        return s13title;
    }

    public Form setS13title(String s13title) {
        this.s13title = s13title;
        return this;
    }

    public String getS13q1() {
        return s13q1;
    }

    public Form setS13q1(String s13q1) {
        this.s13q1 = s13q1;
        return this;
    }

    public String getS13q196x() {
        return s13q196x;
    }

    public Form setS13q196x(String s13q196x) {
        this.s13q196x = s13q196x;
        return this;
    }

    public String getS13q2() {
        return s13q2;
    }

    public Form setS13q2(String s13q2) {
        this.s13q2 = s13q2;
        return this;
    }

    public String getS13q3() {
        return s13q3;
    }

    public Form setS13q3(String s13q3) {
        this.s13q3 = s13q3;
        return this;
    }

    public String getS13q4() {
        return s13q4;
    }

    public Form setS13q4(String s13q4) {
        this.s13q4 = s13q4;
        return this;
    }

    public String getS13q496() {
        return s13q496;
    }

    public Form setS13q496(String s13q496) {
        this.s13q496 = s13q496;
        return this;
    }

    public String getS13q5() {
        return s13q5;
    }

    public Form setS13q5(String s13q5) {
        this.s13q5 = s13q5;
        return this;
    }

    public String getS13q596() {
        return s13q596;
    }

    public Form setS13q596(String s13q596) {
        this.s13q596 = s13q596;
        return this;
    }

    public String getS13q6() {
        return s13q6;
    }

    public Form setS13q6(String s13q6) {
        this.s13q6 = s13q6;
        return this;
    }

    public String getS13q601() {
        return s13q601;
    }

    public Form setS13q601(String s13q601) {
        this.s13q601 = s13q601;
        return this;
    }

    public String getS13q602() {
        return s13q602;
    }

    public Form setS13q602(String s13q602) {
        this.s13q602 = s13q602;
        return this;
    }

    public String getS13q603() {
        return s13q603;
    }

    public Form setS13q603(String s13q603) {
        this.s13q603 = s13q603;
        return this;
    }

    public String getS13q696() {
        return s13q696;
    }

    public Form setS13q696(String s13q696) {
        this.s13q696 = s13q696;
        return this;
    }

    public String getS13q698() {
        return s13q698;
    }

    public Form setS13q698(String s13q698) {
        this.s13q698 = s13q698;
        return this;
    }

    public String getS13q7() {
        return s13q7;
    }

    public Form setS13q7(String s13q7) {
        this.s13q7 = s13q7;
        return this;
    }

    public String getS13q796() {
        return s13q796;
    }

    public Form setS13q796(String s13q796) {
        this.s13q796 = s13q796;
        return this;
    }

    public String getS13q8() {
        return s13q8;
    }

    public Form setS13q8(String s13q8) {
        this.s13q8 = s13q8;
        return this;
    }

    public String getS13q896() {
        return s13q896;
    }

    public Form setS13q896(String s13q896) {
        this.s13q896 = s13q896;
        return this;
    }

    public String getS13q9() {
        return s13q9;
    }

    public Form setS13q9(String s13q9) {
        this.s13q9 = s13q9;
        return this;
    }

    public String getS13q996() {
        return s13q996;
    }

    public Form setS13q996(String s13q996) {
        this.s13q996 = s13q996;
        return this;
    }

    public String getS13q10() {
        return s13q10;
    }

    public Form setS13q10(String s13q10) {
        this.s13q10 = s13q10;
        return this;
    }

    public String getS13q1001() {
        return s13q1001;
    }

    public Form setS13q1001(String s13q1001) {
        this.s13q1001 = s13q1001;
        return this;
    }

    public String getS13q1002() {
        return s13q1002;
    }

    public Form setS13q1002(String s13q1002) {
        this.s13q1002 = s13q1002;
        return this;
    }

    public String getS13q1003() {
        return s13q1003;
    }

    public Form setS13q1003(String s13q1003) {
        this.s13q1003 = s13q1003;
        return this;
    }

    public String getS13q1004() {
        return s13q1004;
    }

    public Form setS13q1004(String s13q1004) {
        this.s13q1004 = s13q1004;
        return this;
    }

    public String getS13q1005() {
        return s13q1005;
    }

    public Form setS13q1005(String s13q1005) {
        this.s13q1005 = s13q1005;
        return this;
    }

    public String getS13q1006() {
        return s13q1006;
    }

    public Form setS13q1006(String s13q1006) {
        this.s13q1006 = s13q1006;
        return this;
    }

    public String getS13q1007() {
        return s13q1007;
    }

    public Form setS13q1007(String s13q1007) {
        this.s13q1007 = s13q1007;
        return this;
    }

    public String getS1_title1() {
        return s1_title1;
    }

    public Form setS1_title1(String s1_title1) {
        this.s1_title1 = s1_title1;
        return this;
    }

    public String getS1qno() {
        return s1qno;
    }

    public Form setS1qno(String s1qno) {
        this.s1qno = s1qno;
        return this;
    }

    public String getS1q1() {
        return s1q1;
    }

    public Form setS1q1(String s1q1) {
        this.s1q1 = s1q1;
        return this;
    }

    public String getS1q2() {
        return s1q2;
    }

    public Form setS1q2(String s1q2) {
        this.s1q2 = s1q2;
        return this;
    }

    public String getS1q4() {
        return s1q4;
    }

    public Form setS1q4(String s1q4) {
        this.s1q4 = s1q4;
        return this;
    }

    public String getS1q6() {
        return s1q6;
    }

    public Form setS1q6(String s1q6) {
        this.s1q6 = s1q6;
        return this;
    }

    public String getS1q8() {
        return s1q8;
    }

    public Form setS1q8(String s1q8) {
        this.s1q8 = s1q8;
        return this;
    }

    public String getS1q9() {
        return s1q9;
    }

    public Form setS1q9(String s1q9) {
        this.s1q9 = s1q9;
        return this;
    }

    public String getS1q10() {
        return s1q10;
    }

    public Form setS1q10(String s1q10) {
        this.s1q10 = s1q10;
        return this;
    }

    public String getS1q11() {
        return s1q11;
    }

    public Form setS1q11(String s1q11) {
        this.s1q11 = s1q11;
        return this;
    }

    public String getS1q12() {
        return s1q12;
    }

    public Form setS1q12(String s1q12) {
        this.s1q12 = s1q12;
        return this;
    }

    public String getS1q13() {
        return s1q13;
    }

    public Form setS1q13(String s1q13) {
        this.s1q13 = s1q13;
        return this;
    }

    public String getS1q14() {
        return s1q14;
    }

    public Form setS1q14(String s1q14) {
        this.s1q14 = s1q14;
        return this;
    }

    public String getS1q15() {
        return s1q15;
    }

    public Form setS1q15(String s1q15) {
        this.s1q15 = s1q15;
        return this;
    }

    public String getS1q16() {
        return s1q16;
    }

    public Form setS1q16(String s1q16) {
        this.s1q16 = s1q16;
        return this;
    }

    public String getS1q17() {
        return s1q17;
    }

    public Form setS1q17(String s1q17) {
        this.s1q17 = s1q17;
        return this;
    }

    public String getS1q18() {
        return s1q18;
    }

    public Form setS1q18(String s1q18) {
        this.s1q18 = s1q18;
        return this;
    }

    public String getS1_consent() {
        return s1_consent;
    }

    public Form setS1_consent(String s1_consent) {
        this.s1_consent = s1_consent;
        return this;
    }

    public String getS1q19et() {
        return s1q19et;
    }

    public Form setS1q19et(String s1q19et) {
        this.s1q19et = s1q19et;
        return this;
    }

    public String getS1q20() {
        return s1q20;
    }

    public Form setS1q20(String s1q20) {
        this.s1q20 = s1q20;
        return this;
    }

    public String getS1q20a() {
        return s1q20a;
    }

    public Form setS1q20a(String s1q20a) {
        this.s1q20a = s1q20a;
        return this;
    }

    public String getS1q20b() {
        return s1q20b;
    }

    public Form setS1q20b(String s1q20b) {
        this.s1q20b = s1q20b;
        return this;
    }

    public String getS1q20c() {
        return s1q20c;
    }

    public Form setS1q20c(String s1q20c) {
        this.s1q20c = s1q20c;
        return this;
    }

    public String getS1q20d() {
        return s1q20d;
    }

    public Form setS1q20d(String s1q20d) {
        this.s1q20d = s1q20d;
        return this;
    }

    public String getS1q20e() {  return s1q20e; }

    public Form setS1q20e(String s1q20e) {
        this.s1q20e = s1q20e;
        return this;
    }

  public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsContract.FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
            json.put(FormsContract.FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
            json.put(FormsContract.FormsTable.COLUMN_USERNAME, this.username == null ? JSONObject.NULL : this.username);
            json.put(FormsContract.FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
            json.put(FormsContract.FormsTable.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
            json.put(FormsContract.FormsTable.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
            json.put(FormsContract.FormsTable.COLUMN_PID, this.pid == null ? JSONObject.NULL : this.pid);

            if (this.sB != null && !this.sB.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_SB, new JSONObject(this.sB));
            }

            if (this.formType == null || this.formType.equals("1")) {
                json.put(FormsContract.FormsTable.COLUMN_S1Q1, this.s1q1 == null ? JSONObject.NULL : this.s1q1);
                json.put(FormsContract.FormsTable.COLUMN_S1Q2, this.s1q2 == null ? JSONObject.NULL : this.s1q2);
                json.put(FormsContract.FormsTable.COLUMN_S1Q3, this.s1q3 == null ? JSONObject.NULL : this.s1q3);
                json.put(FormsContract.FormsTable.COLUMN_S1Q4, this.s1q4 == null ? JSONObject.NULL : this.s1q4);
                json.put(FormsContract.FormsTable.COLUMN_S1Q5, this.s1q5 == null ? JSONObject.NULL : this.s1q5);
                json.put(FormsContract.FormsTable.COLUMN_S1Q6, this.s1q6 == null ? JSONObject.NULL : this.s1q6);

                json.put(FormsContract.FormsTable.COLUMN_SB, new JSONObject(sBtoString(this.formType != null)));
            }

            json.put(FormsContract.FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, this.istatus96x == null ? JSONObject.NULL : this.istatus96x);
            json.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
            json.put(FormsContract.FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
            json.put(FormsContract.FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
            json.put(FormsContract.FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
            json.put(FormsContract.FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
            json.put(FormsContract.FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
            json.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
            json.put(FormsContract.FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void sBHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = new JSONObject(string);

                this.s2q101 = json.getString("s2q101");
                this.s2q101x = json.getString("s2q101x");
                this.s2q102 = json.getString("s2q102");
                this.s2q102x = json.getString("s2q102x");
                this.s2q103 = json.getString("s2q103");
                this.s2q103x = json.getString("s2q103x");
                this.s2q104 = json.getString("s2q104");
                this.s2q104x = json.getString("s2q104x");
                this.s2q105 = json.getString("s2q105");
                this.s2q105x = json.getString("s2q105x");
                this.s2q106 = json.getString("s2q106");
                this.s2q106x = json.getString("s2q106x");
                this.s2q107 = json.getString("s2q107");
                this.s2q107x = json.getString("s2q107x");
                this.s2q108 = json.getString("s2q108");
                this.s2q108x = json.getString("s2q108x");
                this.s2q109 = json.getString("s2q109");
                this.s2q109x = json.getString("s2q109x");
                this.s2q110 = json.getString("s2q110");
                this.s2q110x = json.getString("s2q110x");
                this.s2q111 = json.getString("s2q111");
                this.s2q111x = json.getString("s2q111x");
                this.s2q112 = json.getString("s2q112");
                this.s2q112x = json.getString("s2q112x");
                this.s2q113 = json.getString("s2q113");
                this.s2q113x = json.getString("s2q113x");
                this.s2q114 = json.getString("s2q114");
                this.s2q114x = json.getString("s2q114x");
                this.s2q115 = json.getString("s2q115");
                this.s2q115x = json.getString("s2q115x");
                this.s2q116 = json.getString("s2q116");
                this.s2q116x = json.getString("s2q116x");
                this.s2q2 = json.getString("s2q2");
                this.s2q3 = json.getString("s2q3");
                this.s2q31 = json.getString("s2q31");
                this.s2q32 = json.getString("s2q32");
                this.s2q33 = json.getString("s2q33");
                this.s2q4 = json.getString("s2q4");
                this.s2q501 = json.getString("s2q501");
                this.s2q502 = json.getString("s2q502");
                this.s2q503 = json.getString("s2q503");
                this.s2q504 = json.getString("s2q504");
                this.s2q505 = json.getString("s2q505");
                this.s2q506 = json.getString("s2q506");
                this.s2q507 = json.getString("s2q507");
                this.s2q508 = json.getString("s2q508");
                this.s2q509 = json.getString("s2q509");
                this.s2q596 = json.getString("s2q596");
                this.s2q596x = json.getString("s2q596x");
                this.s2q6 = json.getString("s2q6");
                this.s2q7 = json.getString("s2q7");
                /*this.s2q71 = json.getString("s2q71");
                this.s2q72 = json.getString("s2q72");*/

                if (this.formType != null) {
                    this.s2q197 = json.getString("s2q197");
                    this.s2q597 = json.getString("s2q597");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
