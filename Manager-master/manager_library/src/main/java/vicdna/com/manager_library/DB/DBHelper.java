package vicdna.com.manager_library.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lewis on 2017/10/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "cpami.db";
    public static final String KEY_ID = "_id";

    // 本機建立的資料表
    public static final String TABLE_NAME_MARK = "bdc_mark";
    public static final String TABLE_NAME_USER = "bdc_user";
    public static final String TABLE_NAME_NEWS = "bdc_rule_news";

    // User DB
    public static final String UID = "uid";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String GOOGLE_UID = "google_uid";
    public static final String FACEBOOK_UID = "facebook_uid";
    public static final String LOGIN_STATUS = "login_status";
    public static final String DB_VERSION_NAME = "db_version_name";
    public static final String ACCOUNT_ENABLED = "account_enabled";

    // Mark DB
    public static final String MARK_ID = "mark_id";
    public static final String TARGET_TYPE = "target_type";
    public static final String DELETED_TIME = "deleted_time";
    public static final String IS_DELETE = "is_delete";

    // bdc_news
    public static final String NID = "nid";
    public static final String TITLE = "title";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String IS_NEW = "is_new";

    // online get table
    public static final String TABLE_NAME_RULE = "bdc_rule";
    public static final String TABLE_NAME_RULE_ITEM = "bdc_rule_item";
    public static final String TABLE_NAME_RULE_EXPLAIN = "bdc_rule_item_explain";
    public static final String TABLE_NAME_RULE_ITEM_LINK = "bdc_rule_item_link";

    // bdc_rule
    public static final String RULE_ID = "rule_id";
    public static final String RULE_GROUP = "rule_group";
    public static final String RULE_AREA = "rule_area";
    public static final String RULE_DATE = "rule_date";
    public static final String RULE_NAME = "rule_name";
    public static final String RULE_DESC = "rule_desc";
    public static final String RULE_TYPE = "rule_type";
    public static final String RULE_FILE = "rule_file";
    public static final String VERSION = "version";
    public static final String CREATE_TIME = "create_time";
    public static final String IS_PUBLIC = "is_public";
    public static final String PUBLIC_TIME = "public_time";
    // bdc_rule_item
    public static final String ITEM_FILE = "item_file";
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_NO = "item_no";
    public static final String ITEM_CHAPTER = "item_chapter";
    public static final String ITEM_TEXT = "item_text";
    public static final String ITEM_CHANGE = "item_change";
    public static final String ITEM_NEW = "item_new";
    public static final String ITEM_DELETE = "item_delete";
    // bdc_rule_item_explain
    public static final String ITEM_LIST = "item_list";
    public static final String ITEM_PUBLISH = "item_publish";
    public static final String ITEM_SUMMARY = "item_summary";
    public static final String ITEM_SUBJECT = "item_subject";
    public static final String ITEM_DESC = "item_desc";
    public static final String ITEM_REMARKS = "item_remarks";
    // bdc_rule_item_link
    public static final String UNIQUE_ID = "unique_id";
    public static final String TARGET_ID = "target_id";
    public static final String LINK_TYPE = "link_type";
    public static final String LINK_ERROR = "link_error";

    public final String TAG = this.getClass().getSimpleName();
    public Context mContext;
    public SQLiteDatabase mSqliteDatabase;

    public DBHelper(Context context, String filePath, String DBName) {
//      super(context, DB_NAME, null, DB_VERSION);
        super(context, filePath + DBName, null, DB_VERSION);
        mContext = context;
        mSqliteDatabase = getWritableDatabase();
    }

    public SQLiteDatabase getSqliteDatabase() {
        return mSqliteDatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void createTable(SQLiteDatabase sqLiteDatabase) {

        String DATABASE_CREATE_TABLE;

        // local create table User's Info region --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_USER + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + UID + " TEXT,"
                + NAME + " TEXT,"
                + EMAIL + " TEXT,"
                + CREATE_TIME + " TEXT,"
                + LOGIN_STATUS + " TEXT,"
                + ACCOUNT_ENABLED + " TEXT,"
                + DB_VERSION_NAME + " TEXT,"
                + GOOGLE_UID + " TEXT,"
                + FACEBOOK_UID + " TEXT,"
                + IS_DELETE + " TEXT,"
                + DELETED_TIME + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        //  local create table User's Mark region --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_MARK + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + UID + " TEXT,"
                + RULE_ID + " TEXT,"
                + ITEM_ID + " TEXT,"
                + MARK_ID + " TEXT,"
                + TARGET_ID + " TEXT,"
                + TARGET_TYPE + " TEXT,"
                + CREATE_TIME + " TEXT,"
                + IS_DELETE + " TEXT,"
                + DELETED_TIME + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        // local create table  bdc_news region --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_NEWS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + NID + " TEXT,"
                + TITLE + " TEXT,"
                + START_DATE + " TEXT,"
                + END_DATE + " TEXT,"
                + IS_NEW + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        // Online get table
        // region bdc_rule --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_RULE + " ("
                + RULE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + RULE_GROUP + " TEXT,"
                + RULE_AREA + " TEXT,"
                + RULE_DATE + " TEXT,"
                + RULE_NAME + " TEXT,"
                + RULE_DESC + " TEXT,"
                + RULE_TYPE + " TEXT,"
                + RULE_FILE + " TEXT"
                + VERSION + " TEXT,"
                + CREATE_TIME + " TEXT,"
                + IS_PUBLIC + " TEXT,"
                + PUBLIC_TIME + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        // region  bdc_rule item --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_RULE_ITEM + " ("
                + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + ITEM_FILE + " TEXT,"
                + ITEM_NO + " TEXT,"
                + RULE_ID + " TEXT,"
                + ITEM_CHAPTER + " TEXT,"
                + ITEM_TEXT + " TEXT,"
                + ITEM_CHANGE + " TEXT,"
                + ITEM_NEW + " TEXT,"
                + ITEM_DELETE + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        // region bdc_rule_item_explain  --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_RULE_EXPLAIN + " ("
                + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + ITEM_LIST + " TEXT,"
                + ITEM_SUMMARY + " TEXT,"
                + ITEM_PUBLISH + " TEXT,"
                + ITEM_SUBJECT + " TEXT,"
                + ITEM_DESC + " TEXT,"
                + ITEM_REMARKS + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

        // region bdc_rule_item_link  --------
        DATABASE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_RULE_ITEM_LINK + " ("
                + UNIQUE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + ITEM_ID + " TEXT,"
                + TARGET_ID + " TEXT,"
                + LINK_TYPE + " TEXT,"
                + LINK_ERROR + " TEXT"
                + ")";

        sqLiteDatabase.execSQL(DATABASE_CREATE_TABLE);
        // endregion

    }
}
