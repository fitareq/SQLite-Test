package com.airmoll.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabseHelper databseHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c)
    {
        context = c;
    }
    public DBManager open() throws SQLException
    {
        databseHelper = new DatabseHelper(context);
        database = databseHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        databseHelper.close();
    }
    public void insert(String title, String description, String price)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabseHelper.TITLE, title);
        contentValues.put(DatabseHelper.DESCRIPTION, description);
        contentValues.put(DatabseHelper.PRICE, price);

        database.insert(DatabseHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch()
    {
        String[] columns = new String[]{DatabseHelper.ID, DatabseHelper.TITLE, DatabseHelper.DESCRIPTION, DatabseHelper.PRICE};
        Cursor cursor = database.query(DatabseHelper.TABLE_NAME, columns, null, null,null,null,null);
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
