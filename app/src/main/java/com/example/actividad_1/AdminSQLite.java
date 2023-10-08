package com.example.actividad_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLite extends SQLiteOpenHelper {

    public static final String TABLE_NAME ="Usuarios";
    public static final String DB_NAME="Clientes";
    public static final int DB_VERSION=1;

    public AdminSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "User TEXT NOT NULL," +
                "Clave TEXT NOT NULL," +
                "Nombre TEXT NOT NULL" +
                ")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
