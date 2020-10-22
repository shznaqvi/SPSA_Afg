package edu.aku.hassannaqvi.spsa_afg.contracts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    public static String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.spsa_afg";

    public static abstract class FormsTable implements BaseColumns {
        public static final String TABLE_NAME_FORMS = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_REFNO = "refno";
        public static final String COLUMN_PID = "pid";
        public static final String COLUMN_S1Q1 = "s1q1";
        public static final String COLUMN_S1Q2 = "s1q2";
        public static final String COLUMN_S1Q4 = "s1q4";
        public static final String COLUMN_S1Q6 = "s1q6";
        public static final String COLUMN_SINFO = "sInfo";
        public static final String COLUMN_S02 = "s02";
        public static final String COLUMN_S03 = "s03";
        public static final String COLUMN_S04 = "s04";
        public static final String COLUMN_S05 = "s05";
        public static final String COLUMN_S06 = "s06";
        public static final String COLUMN_S07 = "s07";
        public static final String COLUMN_S08 = "s08";
        public static final String COLUMN_S09 = "s09";
        public static final String COLUMN_S10 = "s10";
        public static final String COLUMN_S11 = "s11";
        public static final String COLUMN_S12 = "s12";
        public static final String COLUMN_S13 = "s13";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS96x = "istatus96x";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static String PATH = "forms";
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH;
        public static Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY)
                .buildUpon().appendPath(PATH).build();
        public static String SERVER_URL = "sync.php";

        public static String getMovieKeyFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        public static Uri buildUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
