package edu.aku.hassannaqvi.spsa_afg.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class DistrictContract {

    private static final String TAG = "District_CONTRACT";

    String provinceCode;
    String districtCode;
    String districtName;


    public DistrictContract() {
        // Default Constructor
    }


    public DistrictContract Sync(JSONObject jsonObject) throws JSONException {
        this.provinceCode = jsonObject.getString(table.COLUMN_PCODE);
        this.districtCode = jsonObject.getString(table.COLUMN_DCODE);
        this.districtName = jsonObject.getString(table.COLUMN_DNAME);
        return this;
    }


    public DistrictContract HydrateDistrict(Cursor cursor) {
        this.provinceCode = cursor.getString(cursor.getColumnIndex(table.COLUMN_PCODE));
        this.districtCode = cursor.getString(cursor.getColumnIndex(table.COLUMN_DCODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(table.COLUMN_DNAME));
        return this;
    }


    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }


    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }



    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(table.COLUMN_PCODE, this.provinceCode == null ? JSONObject.NULL : this.provinceCode);
        json.put(table.COLUMN_DCODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(table.COLUMN_DNAME, this.districtName == null ? JSONObject.NULL : this.districtName);
        return json;
    }


    public static abstract class table implements BaseColumns {

        public static final String TABLE_NAME = "districts";
        public static final String COLUMN_PCODE = "prov_code";
        public static final String COLUMN_DCODE = "dist_code";
        public static final String COLUMN_DNAME = "dist_name";

        public static final String _URI = "districts.php";
    }
}