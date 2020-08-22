package com.exam.application.view.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String imageId, String comment) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.IMAGEID, imageId);
        contentValue.put(DatabaseHelper.COMMENT, comment);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.IMAGEID, DatabaseHelper.COMMENT};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String imageId, String comment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.IMAGEID, imageId);
        contentValues.put(DatabaseHelper.COMMENT, comment);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

    public Cursor fetchDataByImageId(String imageId) throws SQLException {
        Cursor row = null;
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        if (imageId == null || imageId.length() == 0) {
            row = database.rawQuery(query, null);
        } else {
            query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.IMAGEID + " like '%" + imageId + "%'";
            row = database.rawQuery(query, null);
        }
        if (row != null) {
            row.moveToFirst();
        }
        return row;
    }

    public boolean IsImageIdExists(String imageid) {
        String Query = "Select * from " + DatabaseHelper.TABLE_NAME + " where " + DatabaseHelper.IMAGEID + " = " + "'" + imageid + "'";
        Cursor cursor = database.rawQuery(Query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

}
