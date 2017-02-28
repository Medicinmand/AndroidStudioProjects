package mwkn.ucn.dk.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 23-02-2017.
 */

public class ToDoDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_TASK };

    public ToDoDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    //Insert to database and then get from database by id.
    public ToDoTask createToDoTask(String task){
        //insert
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TASK, task);
        long insertId = database.insert(MySQLiteHelper.TABLE_TODO, null, values);

        //Get
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TODO, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        ToDoTask todoTask = cursorToTask(cursor);
        cursor.close();
        return todoTask;
    }

    public void deleteTask(ToDoTask task) {
        long id = task.getId();
        System.out.println("Task deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_TODO, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<ToDoTask> getAllToDoTasks() {
        List<ToDoTask> tasks = new ArrayList<ToDoTask>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_TODO,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ToDoTask task = cursorToTask(cursor);
            tasks.add(task);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return tasks;
    }

    private ToDoTask cursorToTask(Cursor cursor) {
        ToDoTask task = new ToDoTask();
        task.setId(cursor.getLong(0));
        task.setTask(cursor.getString(1));
        return task;
    }

    public String GetDbName(){
        return dbHelper.getDatabaseName();
    }
}
