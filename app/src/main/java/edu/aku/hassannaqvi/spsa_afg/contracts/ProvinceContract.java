package edu.aku.hassannaqvi.spsa_afg.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ProvinceContract {

    private static final String TAG = "Province_CONTRACT";
    String provinceCode;
    String provinceName;


    public ProvinceContract() {
        // Default Constructor
    }


    public ProvinceContract Sync(JSONObject jsonObject) throws JSONException {
        this.provinceCode = jsonObject.getString(table.COLUMN_PCODE);
        this.provinceName = jsonObject.getString(table.COLUMN_PNAME);
        return this;
    }


    public ProvinceContract HydrateProvince(Cursor cursor) {
        this.provinceCode = cursor.getString(cursor.getColumnIndex(table.COLUMN_PCODE));
        this.provinceName = cursor.getString(cursor.getColumnIndex(table.COLUMN_PNAME));
        return this;
    }


    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }


    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }



    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(table.COLUMN_PCODE, this.provinceCode == null ? JSONObject.NULL : this.provinceCode);
        json.put(table.COLUMN_PNAME, this.provinceName == null ? JSONObject.NULL : this.provinceName);
        return json;
    }


    public static abstract class table implements BaseColumns {

        public static final String TABLE_NAME = "province";
        public static final String COLUMN_PCODE = "prov_code";
        public static final String COLUMN_PNAME = "prov_name";

        public static final String _URI = "provinces.php";
    }
}