package vicdna.com.manager_library.Module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import vicdna.com.manager_library.DB.DBHelper;


/**
 * Created by lewis on 2017/10/23.
 */

public class DBManager {

    private static DBHelper dbHelper;
    private final String TAG = "DBManager";

    public DBManager(Context context, String filePath, String DBName) {
        dbHelper = new DBHelper(context, filePath, DBName);
    }

    /**
     * getTableCursor
     *
     * @param tableName
     * @return
     */
    public static Cursor getTableCursor(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        Cursor cursor = dbHelper.getSqliteDatabase().rawQuery(sql, null);
        return cursor;
    }

    /**
     * addRowData
     *
     * @param tableName
     * @param contentValues
     * @return
     */
    public long addRowData(String tableName, ContentValues contentValues) {
        return dbHelper.getSqliteDatabase().insert(tableName, null, contentValues);
    }

    /**
     * closeDB
     */
    public void closeDB() {
        dbHelper.getSqliteDatabase().close();
    }

    /**
     * deleteRowData
     *
     * @param tableName
     * @param rowId
     * @return
     */
    public int deleteRowData(String tableName, long rowId) {
        return dbHelper.getSqliteDatabase().delete(tableName, "_ID=" + rowId, null);
    }

    /**
     * deleteTable
     *
     * @param tableName
     */
    public void deleteTable(String tableName) {
        dbHelper.getSqliteDatabase().execSQL("delete from " + tableName);
    }

    /**
     * getTableCount
     *
     * @param tableName
     * @return
     */
    public int getTableCount(String tableName) {
        if (dbHelper.getSqliteDatabase() != null) {
            String sql = "SELECT * FROM " + tableName;
            Cursor cursor = dbHelper.getSqliteDatabase().rawQuery(sql, null);
            int count = cursor.getCount();
            cursor.close();
            return count;
        }
        return 0;
    }

    /**
     * updateData
     *
     * @param tableName
     * @param rowId
     * @param contentValues
     * @return
     */
    public int updateData(String tableName, long rowId, ContentValues contentValues) {
        return dbHelper.getSqliteDatabase().update(tableName, contentValues, "_ID=" + rowId, null);
    }

}
