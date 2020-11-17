package edu.aku.hassannaqvi.spsa_afg.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.spsa_afg.contracts.BLRandomContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.DistrictContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.spsa_afg.contracts.ProvinceContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.UsersContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VersionAppContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VillageContract;
import edu.aku.hassannaqvi.spsa_afg.models.BLRandom;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.models.Users;
import edu.aku.hassannaqvi.spsa_afg.models.VersionApp;
import edu.aku.hassannaqvi.spsa_afg.utils.CreateTable;

import static edu.aku.hassannaqvi.spsa_afg.utils.CreateTable.SQL_ALTER_FORMS_S1q4CODE;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, CreateTable.DATABASE_NAME, null, CreateTable.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable.SQL_CREATE_USERS);
        db.execSQL(CreateTable.SQL_CREATE_PROVINCE);
        db.execSQL(CreateTable.SQL_CREATE_DISTRICT);
        db.execSQL(CreateTable.SQL_CREATE_VILLAGE);
        db.execSQL(CreateTable.SQL_CREATE_FORMS);
        db.execSQL(CreateTable.SQL_CREATE_BL_RANDOM);
        db.execSQL(CreateTable.SQL_CREATE_VERSIONAPP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }

/*    private boolean getTableNames(SQLiteDatabase db, String name) {
        Cursor c = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table'", null);
        Asserts.checkNotNull(c);

        ArrayList<String> actual = new ArrayList<>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                actual.add(c.getString(0));
                c.moveToNext();
            }
        }
        c.close();

        if (actual.size() == 0) return false;
        return actual.contains(name);
    }*/


    public int syncBLRandom(JSONArray blList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BLRandomContract.BLRandomTable.TABLE_NAME, null, null);

        int insertCount = 0;
        for (int i = 0; i < blList.length(); i++) {
            JSONObject jsonObjectCC;
            try {
                jsonObjectCC = blList.getJSONObject(i);

                BLRandom Vc = new BLRandom();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(BLRandomContract.BLRandomTable.COLUMN_ID, Vc.get_ID());
                values.put(BLRandomContract.BLRandomTable.COLUMN_LUID, Vc.getLUID());
                values.put(BLRandomContract.BLRandomTable.COLUMN_STRUCTURE_NO, Vc.getStructure());
                values.put(BLRandomContract.BLRandomTable.COLUMN_FAMILY_EXT_CODE, Vc.getExtension());
                values.put(BLRandomContract.BLRandomTable.COLUMN_HH, Vc.getHh());
                values.put(BLRandomContract.BLRandomTable.COLUMN_EB_CODE, Vc.getEbcode());
                values.put(BLRandomContract.BLRandomTable.COLUMN_P_CODE, Vc.getpCode());
                values.put(BLRandomContract.BLRandomTable.COLUMN_RANDOMDT, Vc.getRandomDT());
                values.put(BLRandomContract.BLRandomTable.COLUMN_HH_HEAD, Vc.getHhhead());
                values.put(BLRandomContract.BLRandomTable.COLUMN_CONTACT, Vc.getContact());
                values.put(BLRandomContract.BLRandomTable.COLUMN_HH_SELECTED_STRUCT, Vc.getSelStructure());
                values.put(BLRandomContract.BLRandomTable.COLUMN_SNO_HH, Vc.getSno());

                long row = db.insert(BLRandomContract.BLRandomTable.TABLE_NAME, null, values);
                if (row != -1) insertCount++;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return insertCount;
    }



    public Integer syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppContract.VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }



    public VersionApp getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppContract.VersionAppTable._ID,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppContract.VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionApp allVC = new VersionApp();
        try {
            c = db.query(
                    VersionAppContract.VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }



    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersContract.UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersContract.UsersTable.COLUMN_FULL_NAME, user.getFull_name());
                long rowID = db.insert(UsersContract.UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncProvince(JSONArray Provincelist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ProvinceContract.table.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Provincelist.length(); i++) {

                JSONObject jsonObjectProvince = Provincelist.getJSONObject(i);

                ProvinceContract Province = new ProvinceContract();
                Province.Sync(jsonObjectProvince);
                ContentValues values = new ContentValues();

                values.put(ProvinceContract.table.COLUMN_PCODE, Province.getProv_code());
                values.put(ProvinceContract.table.COLUMN_PNAME, Province.getProv_name());
                long rowID = db.insert(ProvinceContract.table.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncProvince(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncDistricts(JSONArray Districtslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DistrictContract.table.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Districtslist.length(); i++) {

                JSONObject jsonObjectDistrict = Districtslist.getJSONObject(i);

                DistrictContract District = new DistrictContract();
                District.Sync(jsonObjectDistrict);
                ContentValues values = new ContentValues();

                values.put(DistrictContract.table.COLUMN_PCODE, District.getProvinceCode());
                values.put(DistrictContract.table.COLUMN_DCODE, District.getDistrictCode());
                values.put(DistrictContract.table.COLUMN_DNAME, District.getDistrictName());
                long rowID = db.insert(DistrictContract.table.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncDistrict(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public int syncVillages(JSONArray Villageslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VillageContract.table.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Villageslist.length(); i++) {

                JSONObject jsonObjectVillage = Villageslist.getJSONObject(i);

                VillageContract Village = new VillageContract();
                Village.Sync(jsonObjectVillage);
                ContentValues values = new ContentValues();

                values.put(VillageContract.table.COLUMN_DCODE, Village.getDistrictCode());
                values.put(VillageContract.table.COLUMN_VCODE, Village.getVillageCode());
                values.put(VillageContract.table.COLUMN_VNAME, Village.getVillageName());
                long rowID = db.insert(VillageContract.table.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncVillage(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    public Collection<Users> getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UsersContract.UsersTable.COLUMN_USERNAME,
                UsersContract.UsersTable.COLUMN_FULL_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = UsersContract.UsersTable.COLUMN_USERNAME + " ASC";

        Collection<Users> alluser = new ArrayList<>();
        try {
            c = db.query(
                    UsersContract.UsersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                alluser.add(new Users().Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return alluser;
    }


    public Collection<ProvinceContract> getAllProvince() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ProvinceContract.table.COLUMN_PCODE,
                ProvinceContract.table.COLUMN_PNAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                ProvinceContract.table.COLUMN_PNAME + " ASC";

        Collection<ProvinceContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    ProvinceContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ProvinceContract dc = new ProvinceContract();
                allDC.add(dc.HydrateProvince(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


   /* public Collection<DistrictContract> getAllDistricts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                DistrictContract.table.COLUMN_PCODE,
                DistrictContract.table.COLUMN_DCODE,
                DistrictContract.table.COLUMN_DNAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                DistrictContract.table.COLUMN_DNAME + " ASC";

        Collection<DistrictContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    DistrictContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                DistrictContract dc = new DistrictContract();
                allDC.add(dc.HydrateDistrict(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }*/


    public Collection<DistrictContract> getAllDistricts(String dcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                DistrictContract.table.COLUMN_PCODE,
                DistrictContract.table.COLUMN_DCODE,
                DistrictContract.table.COLUMN_DNAME
        };

        String whereClause = DistrictContract.table.COLUMN_PCODE + "=?";
        String[] whereArgs = new String[]{dcode};
        String groupBy = null;
        String having = null;

        String orderBy =
                DistrictContract.table.COLUMN_DNAME + " ASC";

        Collection<DistrictContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    DistrictContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                DistrictContract dc = new DistrictContract();
                allDC.add(dc.HydrateDistrict(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<VillageContract> getAllVillages(String dcode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageContract.table.COLUMN_DCODE,
                VillageContract.table.COLUMN_VCODE,
                VillageContract.table.COLUMN_VNAME
        };

        String whereClause = VillageContract.table.COLUMN_DCODE + "=?";
        String[] whereArgs = new String[]{dcode};
        String groupBy = null;
        String having = null;

        String orderBy =
                VillageContract.table.COLUMN_VNAME + " ASC";

        Collection<VillageContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    VillageContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillageContract dc = new VillageContract();
                allDC.add(dc.HydrateVillage(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    //Get All province
    public List<ProvinceContract> getProvince() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ProvinceContract.table._ID,
                ProvinceContract.table.COLUMN_PCODE,
                ProvinceContract.table.COLUMN_PNAME,
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = ProvinceContract.table._ID + " ASC";
        List<ProvinceContract> allEB = new ArrayList<>();
        try {
            c = db.query(
                    ProvinceContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new ProvinceContract().HydrateProvince(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    //Get All district
    public List<DistrictContract> getDistrict() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                DistrictContract.table._ID,
                DistrictContract.table.COLUMN_PCODE,
                DistrictContract.table.COLUMN_DCODE,
                DistrictContract.table.COLUMN_DNAME,
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = DistrictContract.table._ID + " ASC";
        List<DistrictContract> allEB = new ArrayList<>();
        try {
            c = db.query(
                    DistrictContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new DistrictContract().HydrateDistrict(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    //Get All EnumBlock
    public List<VillageContract> getVillage(String uc_id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageContract.table._ID,
                VillageContract.table.COLUMN_DCODE,
                VillageContract.table.COLUMN_VCODE,
                VillageContract.table.COLUMN_VNAME,
        };

        String whereClause = VillageContract.table.COLUMN_VCODE + " LIKE ? ";
        String[] whereArgs = {"" + uc_id + "%"};
        String groupBy = null;
        String having = null;

        String orderBy = VillageContract.table._ID + " ASC";
        List<VillageContract> allEB = new ArrayList<>();
        try {
            c = db.query(
                    VillageContract.table.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new VillageContract().HydrateVillage(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }


    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.UsersTable.TABLE_NAME + " WHERE " + UsersContract.UsersTable.COLUMN_USERNAME + "=? AND " + UsersContract.UsersTable.COLUMN_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {

                if (mCursor.moveToFirst()) {
//                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(Users.UsersTable.ROW_USERNAME));
                }
                return true;
            }
        }
        return false;
    }


    public Long addForm(Form form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsContract.FormsTable.COLUMN_UID, form.get_UID());
        values.put(FormsContract.FormsTable.COLUMN_USERNAME, form.getUsername());
        values.put(FormsContract.FormsTable.COLUMN_SYSDATE, form.getSysdate());
        values.put(FormsContract.FormsTable.COLUMN_FORMDATE, form.getFormdate());
        values.put(FormsContract.FormsTable.COLUMN_FORMTYPE, form.getFormtype());
        values.put(FormsContract.FormsTable.COLUMN_S1Q1, form.getS1q1());
        values.put(FormsContract.FormsTable.COLUMN_S1Q2, form.getS1q2());
        values.put(FormsContract.FormsTable.COLUMN_S1Q4, form.getS1q4());
        values.put(FormsContract.FormsTable.COLUMN_S1Q6, form.getS1q6());
        values.put(FormsContract.FormsTable.COLUMN_SINFO, form.getsInfo());
        values.put(FormsContract.FormsTable.COLUMN_S02, form.gets02());
        values.put(FormsContract.FormsTable.COLUMN_S03, form.gets03());
        values.put(FormsContract.FormsTable.COLUMN_S04, form.gets04());
        values.put(FormsContract.FormsTable.COLUMN_S05, form.gets05());
        values.put(FormsContract.FormsTable.COLUMN_S06, form.gets06());
        values.put(FormsContract.FormsTable.COLUMN_S07, form.gets07());
        values.put(FormsContract.FormsTable.COLUMN_S08, form.gets08());
        values.put(FormsContract.FormsTable.COLUMN_S09, form.gets09());
        values.put(FormsContract.FormsTable.COLUMN_S10, form.gets10());
        values.put(FormsContract.FormsTable.COLUMN_S11, form.gets11());
        values.put(FormsContract.FormsTable.COLUMN_S12, form.gets12());
        values.put(FormsContract.FormsTable.COLUMN_S13, form.gets13());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, form.getIstatus());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, form.getIstatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, form.getEndingdatetime());
        values.put(FormsContract.FormsTable.COLUMN_GPSLAT, form.getGpsLat());
        values.put(FormsContract.FormsTable.COLUMN_GPSLNG, form.getGpsLng());
        values.put(FormsContract.FormsTable.COLUMN_GPSDATE, form.getGpsdate());
        values.put(FormsContract.FormsTable.COLUMN_GPSACC, form.getGpsacc());
        values.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, form.getDevicetagID());
        values.put(FormsContract.FormsTable.COLUMN_DEVICEID, form.getDeviceID());
        values.put(FormsContract.FormsTable.COLUMN_APPVERSION, form.getAppversion());
        values.put(FormsContract.FormsTable.COLUMN_REFNO, form.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsContract.FormsTable.TABLE_NAME_FORMS,
                FormsContract.FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }



    /*   public int updateFormID() {
           SQLiteDatabase db = this.getReadableDatabase();

   // New value for one column
           ContentValues values = new ContentValues();
           values.put(FormsContract.FormsTable.COLUMN_UID, MainApp.form.get_UID());

   // Which row to update, based on the ID
           String selection = FormsContract.FormsTable._ID + " = ?";
           String[] selectionArgs = {String.valueOf(MainApp.form.get_ID())};

           int count = db.update(FormsContract.FormsTable.TABLE_NAME_FORMS,
                   values,
                   selection,
                   selectionArgs);
           return count;
       }
   */


    public Collection<Form> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_USERNAME,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_FORMTYPE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                //               FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                /* FormsContract.FormsTable.COLUMN_S1Q5,*/
                FormsContract.FormsTable.COLUMN_S1Q6,
                /* FormsContract.FormsTable.COLUMN_S01,*/
                FormsContract.FormsTable.COLUMN_SINFO,
                FormsContract.FormsTable.COLUMN_S02,
                FormsContract.FormsTable.COLUMN_S03,
                FormsContract.FormsTable.COLUMN_S04,
                FormsContract.FormsTable.COLUMN_S05,
                FormsContract.FormsTable.COLUMN_S06,
                FormsContract.FormsTable.COLUMN_S07,
                FormsContract.FormsTable.COLUMN_S08,
                FormsContract.FormsTable.COLUMN_S09,
                FormsContract.FormsTable.COLUMN_S10,
                FormsContract.FormsTable.COLUMN_S11,
                FormsContract.FormsTable.COLUMN_S12,
                FormsContract.FormsTable.COLUMN_S13,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION,
                FormsContract.FormsTable.COLUMN_REFNO,

        };

        String whereClause = FormsTable.COLUMN_S1Q1 + "=? ";
        /* String[] whereArgs = {district, refno};*/
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable._ID + " ASC";
        Form allForms = null;


        try {
           /* c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );*/
            while (c.moveToNext()) {
                allForms = new Form().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return (Collection<Form>) allForms;
    }

    public Collection<Form> checkFormExist() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_USERNAME,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_FORMTYPE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                /* FormsContract.FormsTable.COLUMN_S1Q3,*/
                FormsContract.FormsTable.COLUMN_S1Q4,
                /* FormsContract.FormsTable.COLUMN_S1Q5,*/
                FormsContract.FormsTable.COLUMN_S1Q6,
                /* FormsContract.FormsTable.COLUMN_SB,*/
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION,
                FormsContract.FormsTable.COLUMN_REFNO,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<Form>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                allForms.add(form.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Form> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_FORMTYPE,
               /* FormsTable.COLUMN_S1Q1,
                FormsTable.COLUMN_S1Q2,*/
                /* FormsTable.COLUMN_S1Q3,*/
                FormsTable.COLUMN_S1Q4,
                /*FormsTable.COLUMN_S1Q5,*/
                FormsTable.COLUMN_S1Q6,
                /*FormsTable.COLUMN_SB,*/
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_S02,
                FormsTable.COLUMN_S03,
                FormsTable.COLUMN_S04,
                FormsTable.COLUMN_S05,
                FormsTable.COLUMN_S06,
                FormsTable.COLUMN_S07,
                FormsTable.COLUMN_S08,
                FormsTable.COLUMN_S09,
                FormsTable.COLUMN_S10,
                FormsTable.COLUMN_S11,
                FormsTable.COLUMN_S12,
                FormsTable.COLUMN_S13,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_REFNO,
        };

        //   String whereClause = FormsContract.FormsTable.COLUMN_SYNCED + " is null OR " + FormsContract.FormsTable.COLUMN_SYNCED + " = ''";
        String whereClause = null;
        String[] whereArgs = null;

        String groupBy = null;
        String having = null;
        String orderBy = FormsContract.FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allForms.add(new Form().Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Form> getTodayForms(String sysdate) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_USERNAME,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_FORMTYPE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                /*FormsContract.FormsTable.COLUMN_S1Q3,*/
                FormsContract.FormsTable.COLUMN_S1Q4,
                /*  FormsContract.FormsTable.COLUMN_S1Q5,*/
                FormsContract.FormsTable.COLUMN_S1Q6,
                /*FormsContract.FormsTable.COLUMN_SB,*/
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsContract.FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                form.set_ID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ID)));
                form.set_UID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_UID)));
                form.setUsername(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_USERNAME)));
                form.setSysdate(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE)));
                form.setFormdate(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMDATE)));
                String formValue = c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMTYPE));
                form.setFormtype(formValue == null ? "1" : formValue);
                form.setS1q1(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q1)));
                form.setS1q2(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q2)));
                /* form.setS1q3(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q3)));*/
                form.setS1q4(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q4)));
                /* form.setS1q5(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q5)));*/
                form.setS1q6(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q6)));
                /*form.setsB(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SB)));*/
                form.setIstatus(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS)));
                form.setSynced(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } catch (SQLiteException e) {

            db.rawQuery(SQL_ALTER_FORMS_S1q4CODE, null);

        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Collection<Form> getFormsByCluster(String cluster) {

        // String sysdate =  spDateT.substring(0, 8).trim()
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_S1Q1 + " = ? ";
        String[] whereArgs = new String[]{cluster};
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsContract.FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                form.set_ID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ID)));
                form.set_UID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_UID)));
                form.setSysdate(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE)));
                form.setS1q1(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q1)));
                form.setS1q2(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q2)));
                form.setIstatus(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS)));
                form.setSynced(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public ArrayList<Form> getUnclosedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_SYNCED,
        };
        String whereClause = FormsContract.FormsTable.COLUMN_ISTATUS + " = ''";
        String[] whereArgs = null;
//        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsContract.FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form form = new Form();
                form.set_ID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ID)));
                form.set_UID(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_UID)));
                form.setSysdate(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE)));
                form.setS1q1(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q1)));
                form.setS1q2(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q2)));
                form.setIstatus(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS)));
                form.setSynced(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED)));
                allForms.add(form);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, MainApp.form.getIstatus());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, MainApp.form.getIstatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, MainApp.form.getEndingdatetime());

        // Which row to update, based on the ID
        String selection = FormsContract.FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.get_ID())};

        return db.update(FormsContract.FormsTable.TABLE_NAME_FORMS,
                values,
                selection,
                selectionArgs);
    }

    //Get BLRandom data
    public BLRandom getHHFromBLRandom(String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        String[] columns = {
                BLRandomContract.BLRandomTable.COLUMN_ID,
                BLRandomContract.BLRandomTable.COLUMN_LUID,
                BLRandomContract.BLRandomTable.COLUMN_STRUCTURE_NO,
                BLRandomContract.BLRandomTable.COLUMN_FAMILY_EXT_CODE,
                BLRandomContract.BLRandomTable.COLUMN_HH,
                BLRandomContract.BLRandomTable.COLUMN_P_CODE,
                BLRandomContract.BLRandomTable.COLUMN_EB_CODE,
                BLRandomContract.BLRandomTable.COLUMN_RANDOMDT,
                BLRandomContract.BLRandomTable.COLUMN_HH_SELECTED_STRUCT,
                BLRandomContract.BLRandomTable.COLUMN_CONTACT,
                BLRandomContract.BLRandomTable.COLUMN_HH_HEAD,
                BLRandomContract.BLRandomTable.COLUMN_SNO_HH
        };

        String whereClause = BLRandomContract.BLRandomTable.COLUMN_P_CODE + "=? AND " + BLRandomContract.BLRandomTable.COLUMN_HH + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh};
        String groupBy = null;
        String having = null;

        String orderBy =
                BLRandomContract.BLRandomTable.COLUMN_ID + " ASC";

        BLRandom allBL = null;
        try {
            c = db.query(
                    BLRandomContract.BLRandomTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allBL = new BLRandom().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
    }


    //Get Form already exist
    public Form getFilledForm(String district, String refno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_USERNAME,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                /*FormsContract.FormsTable.COLUMN_S1Q3,*/
                FormsContract.FormsTable.COLUMN_S1Q4,
                /*FormsContract.FormsTable.COLUMN_S1Q5,*/
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_ISTATUS96x,
                FormsContract.FormsTable.COLUMN_ENDINGDATETIME,
                /*FormsContract.FormsTable.COLUMN_SB,*/
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION,
                FormsContract.FormsTable.COLUMN_REFNO
        };

//        String whereClause = "(" + FormsTable.COLUMN_ISTATUS + " is null OR " + FormsTable.COLUMN_ISTATUS + "='') AND " + FormsTable.COLUMN_CLUSTERCODE + "=? AND " + FormsTable.COLUMN_HHNO + "=?";
        String whereClause = FormsContract.FormsTable.COLUMN_S1Q1 + "=?";
        String[] whereArgs = {district};
        String groupBy = null;
        String having = null;
        String orderBy = FormsContract.FormsTable._ID + " ASC";
        Form allForms = null;
        try {
            c = db.query(
                    FormsContract.FormsTable.TABLE_NAME_FORMS,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                /*allForms = new Form().Hydrate(c);*/
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    //Generic update FormColumn
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsContract.FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.get_ID())};

        return db.update(FormsContract.FormsTable.TABLE_NAME_FORMS,
                values,
                selection,
                selectionArgs);
    }


    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    //Generic Un-Synced Forms
    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SYNCED, true);
        values.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsContract.FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsContract.FormsTable.TABLE_NAME_FORMS,
                values,
                where,
                whereArgs);
    }
}