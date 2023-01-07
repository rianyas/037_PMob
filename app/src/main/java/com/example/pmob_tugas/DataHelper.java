package com.example.pmob_tugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data_akun.db";
    private static final int DATABASE_VERSION = 1;

    private static final String nama = "nama";
    private static final String nim = "nim";
    private static final String password = "password";
    private Context context;
    private SQLiteDatabase db;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE data(nama text not null, nim text not null primary key, password text not null unique);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int db1, int db2) {
        db.execSQL("DROP TABLE IF EXISTS data");
    }

//    public Boolean ceknim(String nama, String nim, String password) {
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM data WHERE nama = ? AND nim = ? AND password = ?", new String[] {nama,nim,password});
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if (count > 0)
//            return true;
//        else
//            return false;
//    }
}
