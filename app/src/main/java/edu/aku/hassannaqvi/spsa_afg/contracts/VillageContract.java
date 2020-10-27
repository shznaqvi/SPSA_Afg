package edu.aku.hassannaqvi.spsa_afg.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class VillageContract {

    private static final String TAG = "Village_CONTRACT";

    String districtCode;
    String villageCode;
    String villageName;


    public VillageContract() {
        // Default Constructor
    }


    public VillageContract Sync(JSONObject jsonObject) throws JSONException {
        this.districtCode = jsonObject.getString(table.COLUMN_DCODE);
        this.villageCode = jsonObject.getString(table.COLUMN_VCODE);
        this.villageName = jsonObject.getString(table.COLUMN_VNAME);
        return this;
    }


    public VillageContract HydrateVillage(Cursor cursor) {
        this.districtCode = cursor.getString(cursor.getColumnIndex(table.COLUMN_DCODE));
        this.villageCode = cursor.getString(cursor.getColumnIndex(table.COLUMN_VCODE));
        this.villageName = cursor.getString(cursor.getColumnIndex(table.COLUMN_VNAME));
        return this;
    }


    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }


    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }


    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }



    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(table.COLUMN_DCODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(table.COLUMN_VCODE, this.villageCode == null ? JSONObject.NULL : this.villageCode);
        json.put(table.COLUMN_VNAME, this.villageName == null ? JSONObject.NULL : this.villageName);
        return json;
    }


    public static abstract class table implements BaseColumns {

        public static final String TABLE_NAME = "village";
        public static final String COLUMN_DCODE = "dist_code";
        public static final String COLUMN_VCODE = "village_code";
        public static final String COLUMN_VNAME = "village_name";

        public static final String _URI = "villages.php";
    }
}