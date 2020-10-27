package edu.aku.hassannaqvi.spsa_afg.utils;

import edu.aku.hassannaqvi.spsa_afg.contracts.BLRandomContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.DistrictContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.FormsContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.ProvinceContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.UsersContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VersionAppContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VillageContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "spsa_afg.db";
    public static final String DB_NAME = "spsa_afg_copy.db";
    public static final String PROJECT_NAME = "spsa_afg";
    public static final int DATABASE_VERSION = 3;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME_FORMS + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMTYPE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S1Q1 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S1Q2 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S1Q4 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S1Q6 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SINFO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S02 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S03 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S04 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S05 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S06 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S07 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S08 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S09 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S10 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S11 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S12 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S13 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS96x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    public static final String SQL_ALTER_FORMS01 = "ALTER TABLE " +
            FormsContract.FormsTable.TABLE_NAME_FORMS + " ADD COLUMN " +
            FormsContract.FormsTable.COLUMN_FORMTYPE + " TEXT";

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersContract.UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.UsersTable.COLUMN_USERNAME + " TEXT,"
            + UsersContract.UsersTable.COLUMN_PASSWORD + " TEXT,"
            + UsersContract.UsersTable.COLUMN_FULL_NAME + " TEXT"
            + " );";

    public static final String SQL_CREATE_PROVINCE = "CREATE TABLE " + ProvinceContract.table.TABLE_NAME + "("
            + ProvinceContract.table._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ProvinceContract.table.COLUMN_PCODE + " TEXT,"
            + ProvinceContract.table.COLUMN_PNAME + " TEXT"
            + " );";

    public static final String SQL_CREATE_DISTRICT = "CREATE TABLE " + DistrictContract.table.TABLE_NAME + "("
            + DistrictContract.table._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DistrictContract.table.COLUMN_PCODE + " TEXT,"
            + DistrictContract.table.COLUMN_DCODE + " TEXT,"
            + DistrictContract.table.COLUMN_DNAME + " TEXT"
            + " );";

    public static final String SQL_CREATE_VILLAGE = "CREATE TABLE " + VillageContract.table.TABLE_NAME + "("
            + VillageContract.table._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillageContract.table.COLUMN_DCODE + " TEXT,"
            + VillageContract.table.COLUMN_VCODE + " TEXT,"
            + VillageContract.table.COLUMN_VNAME + " TEXT"
            + " );";

    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";

    public static final String SQL_CREATE_BL_RANDOM = "CREATE TABLE " + BLRandomContract.BLRandomTable.TABLE_NAME + "("
            + BLRandomContract.BLRandomTable.COLUMN_ID + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_P_CODE + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_EB_CODE + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_LUID + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_HH + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_STRUCTURE_NO + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_HH_HEAD + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_CONTACT + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_RANDOMDT + " TEXT,"
            + BLRandomContract.BLRandomTable.COLUMN_SNO_HH + " TEXT );";

    public static final String SQL_ALTER_FORMS_S1q4CODE = "ALTER TABLE " +
            FormsContract.FormsTable.TABLE_NAME_FORMS + " ADD COLUMN " +
            FormsContract.FormsTable.COLUMN_S1Q4 + " TEXT";
}
