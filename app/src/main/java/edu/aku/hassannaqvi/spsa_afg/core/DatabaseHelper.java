package edu.aku.hassannaqvi.spsa_afg.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.android.gms.common.internal.Asserts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.spsa_afg.contracts.BLRandomContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.UsersContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VersionAppContract;
import edu.aku.hassannaqvi.spsa_afg.models.BLRandom;
import edu.aku.hassannaqvi.spsa_afg.models.Form;
import edu.aku.hassannaqvi.spsa_afg.models.Users;
import edu.aku.hassannaqvi.spsa_afg.models.VersionApp;
import edu.aku.hassannaqvi.spsa_afg.utils.CreateTable;


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

    private boolean getTableNames(SQLiteDatabase db, String name) {
        Cursor c = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table'", null);
        Asserts.checkNotNull(c);

        List<String> actual = new ArrayList<>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                actual.add(c.getString(0));
                c.moveToNext();
            }
        }
        c.close();

        if (actual.size() == 0) return false;
        return actual.contains(name);
    }


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
        values.put(FormsContract.FormsTable.COLUMN_FORMTYPE, form.getFormType());
        values.put(FormsContract.FormsTable.COLUMN_PID, form.getPid());
        values.put(FormsContract.FormsTable.COLUMN_S1Q1, form.getS1q1());
        values.put(FormsContract.FormsTable.COLUMN_S1Q2, form.getS1q2());
    //    values.put(FormsContract.FormsTable.COLUMN_S1Q3, form.getS1q3());
        values.put(FormsContract.FormsTable.COLUMN_S1Q4, form.getS1q4());
        //       values.put(FormsContract.FormsTable.COLUMN_S1Q5, form.getS1q5());
        values.put(FormsContract.FormsTable.COLUMN_S1Q6, form.getS1q6());
        values.put(FormsContract.FormsTable.COLUMN_INFO, form.getInfo());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, form.getIstatus());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, form.getIstatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, form.getEndingdatetime());
        values.put(FormsContract.FormsTable.COLUMN_GPSLAT, form.getGpsLat());
        values.put(FormsContract.FormsTable.COLUMN_GPSLNG, form.getGpsLng());
        values.put(FormsContract.FormsTable.COLUMN_GPSDATE, form.getGpsDT());
        values.put(FormsContract.FormsTable.COLUMN_GPSACC, form.getGpsAcc());
        values.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, form.getDevicetagID());
        values.put(FormsContract.FormsTable.COLUMN_DEVICEID, form.getDeviceID());
        values.put(FormsContract.FormsTable.COLUMN_APPVERSION, form.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsContract.FormsTable.TABLE_NAME_FORMS,
                FormsContract.FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updateFormID() {
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
                FormsContract.FormsTable.COLUMN_PID,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                //               FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                FormsContract.FormsTable.COLUMN_S1Q5,
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_S01,
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
                FormsContract.FormsTable.COLUMN_PID,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                FormsContract.FormsTable.COLUMN_S1Q5,
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_SB,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION,

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

    public Collection<Form> getUnsyncedForms(int formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsContract.FormsTable._ID,
                FormsContract.FormsTable.COLUMN_UID,
                FormsContract.FormsTable.COLUMN_USERNAME,
                FormsContract.FormsTable.COLUMN_SYSDATE,
                FormsContract.FormsTable.COLUMN_FORMDATE,
                FormsContract.FormsTable.COLUMN_FORMTYPE,
                FormsContract.FormsTable.COLUMN_PID,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                FormsContract.FormsTable.COLUMN_S1Q5,
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_SB,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_ISTATUS96x,
                FormsContract.FormsTable.COLUMN_ENDINGDATETIME,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION,
        };

        String whereClause = FormsContract.FormsTable.COLUMN_SYNCED + " is null OR " + FormsContract.FormsTable.COLUMN_SYNCED + " == ''";
        String[] whereArgs = null;
        if (formType != 0) {
            if (formType == 1) {
                whereClause = "(" + FormsContract.FormsTable.COLUMN_SYNCED + " is null OR " + FormsContract.FormsTable.COLUMN_SYNCED + " == '') AND (" + FormsContract.FormsTable.COLUMN_FORMTYPE + "=? OR " + FormsContract.FormsTable.COLUMN_FORMTYPE + " is null)";
                whereArgs = new String[]{String.valueOf(formType)};
            } else {
                whereClause = "(" + FormsContract.FormsTable.COLUMN_SYNCED + " is null OR " + FormsContract.FormsTable.COLUMN_SYNCED + " == '') AND " + FormsContract.FormsTable.COLUMN_FORMTYPE + "=?";
                whereArgs = new String[]{String.valueOf(formType)};
            }
        }
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
                FormsContract.FormsTable.COLUMN_PID,
                FormsContract.FormsTable.COLUMN_S1Q1,
                FormsContract.FormsTable.COLUMN_S1Q2,
                FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                FormsContract.FormsTable.COLUMN_S1Q5,
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_SB,
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
                form.setFormType(formValue == null ? "1" : formValue);
                form.setPid(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_PID)));
                form.setS1q1(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q1)));
                form.setS1q2(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q2)));
                form.setS1q3(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q3)));
                form.setS1q4(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q4)));
                form.setS1q5(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q5)));
                form.setS1q6(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_S1Q6)));
                form.setsB(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_SB)));
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
                FormsContract.FormsTable.COLUMN_PID,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsContract.FormsTable.COLUMN_PID + " = ? ";
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
                form.setPid(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_PID)));
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
                FormsContract.FormsTable.COLUMN_PID,
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
                form.setPid(c.getString(c.getColumnIndex(FormsContract.FormsTable.COLUMN_PID)));
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
                FormsContract.FormsTable.COLUMN_S1Q3,
                FormsContract.FormsTable.COLUMN_S1Q4,
                FormsContract.FormsTable.COLUMN_S1Q5,
                FormsContract.FormsTable.COLUMN_S1Q6,
                FormsContract.FormsTable.COLUMN_ISTATUS,
                FormsContract.FormsTable.COLUMN_ISTATUS96x,
                FormsContract.FormsTable.COLUMN_ENDINGDATETIME,
                FormsContract.FormsTable.COLUMN_SB,
                FormsContract.FormsTable.COLUMN_GPSLAT,
                FormsContract.FormsTable.COLUMN_GPSLNG,
                FormsContract.FormsTable.COLUMN_GPSDATE,
                FormsContract.FormsTable.COLUMN_GPSACC,
                FormsContract.FormsTable.COLUMN_DEVICETAGID,
                FormsContract.FormsTable.COLUMN_DEVICEID,
                FormsContract.FormsTable.COLUMN_APPVERSION
        };

//        String whereClause = "(" + FormsTable.COLUMN_ISTATUS + " is null OR " + FormsTable.COLUMN_ISTATUS + "='') AND " + FormsTable.COLUMN_CLUSTERCODE + "=? AND " + FormsTable.COLUMN_HHNO + "=?";
        String whereClause = FormsContract.FormsTable.COLUMN_S1Q1 + "=? AND " + FormsContract.FormsTable.COLUMN_PID + "=?";
        String[] whereArgs = {district, refno};
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