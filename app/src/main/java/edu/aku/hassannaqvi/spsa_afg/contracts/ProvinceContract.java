package edu.aku.hassannaqvi.spsa_afg.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ProvinceContract {

    private static final String TAG = "Province_CONTRACT";
    String prov_code;
    String prov_name;


    public ProvinceContract() {
        // Default Constructor
    }


    public ProvinceContract Sync(JSONObject jsonObject) throws JSONException {
        this.prov_code = jsonObject.getString(table.COLUMN_PCODE);
        this.prov_name = jsonObject.getString(table.COLUMN_PNAME);
        return this;
    }


    public ProvinceContract HydrateProvince(Cursor cursor) {
        this.prov_code = cursor.getString(cursor.getColumnIndex(table.COLUMN_PCODE));
        this.prov_name = cursor.getString(cursor.getColumnIndex(table.COLUMN_PNAME));
        return this;
    }


    public String getProv_code() {
        return prov_code;
    }

    public void setProv_code(String prov_code) {
        this.prov_code = prov_code;
    }


    public String getProv_name() {
        return prov_name;
    }

    public void setProv_name(String prov_name) {
        this.prov_name = prov_name;
    }



    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(table.COLUMN_PCODE, this.prov_code == null ? JSONObject.NULL : this.prov_code);
        json.put(table.COLUMN_PNAME, this.prov_name == null ? JSONObject.NULL : this.prov_name);
        return json;
    }


    public static abstract class table implements BaseColumns {

        public static final String TABLE_NAME = "provinces";
        public static final String COLUMN_PCODE = "prov_code";
        public static final String COLUMN_PNAME = "prov_name";

        public static final String _URI = "provinces.php";
    }
}