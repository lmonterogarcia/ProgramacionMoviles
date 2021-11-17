package com.luismontero.gestinmobiliaria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Casas.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE CASA (Id_Producto INTEGER PRIMARY KEY AUTOINCREMENT, calle TEXT, numero INTEGER, superficie NUMBER(5,2))";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS CASA";

    public DB_SQLite(@Nullable Context context) {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);

    }
}
