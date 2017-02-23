package mwkn.ucn.dk.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by martin on 23-02-2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TODO = "todotask";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASK = "task";

    private static final String DATABASE_NAME = "todo.db";
    private static final int DATABASE_VERSION = 1;

    //Sql statement for Database creation
    private static final  String DATABASE_CREATE = "create table "
            + TABLE_TODO + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TASK
            + " text not null);";

    //constructor
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }
}
