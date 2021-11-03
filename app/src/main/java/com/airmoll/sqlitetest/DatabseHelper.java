package com.airmoll.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "ADD_TO_CART";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String DB_NAME = "sqlite_test";
    public static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "create table "+TABLE_NAME+"("
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TITLE+" TEXT NOT NULL, "
            +DESCRIPTION+" TEXT,"
            +PRICE+" TEXT);";

    public DatabseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
