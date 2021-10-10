package com.example.sqlitelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="LOGIN.db";
    public DBHelper(@Nullable Context context) {
        super(context, "LOGIN.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
mydb.execSQL("create table users(username text primary key, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {

mydb.execSQL("drop table if exists users");
    }
    public boolean insertData(String username, String password){

        SQLiteDatabase mydb =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password", password);
        long result = mydb.insert("users", null, contentValues);
if(result == -1)
    return false;
else
        return true;
    }
    public boolean checkusername(String username){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from user where username=?", new String[]{username});
        if (cursor.getCount()>0)
            return true;
            else
                return false;

    }

    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from user where username=?", new String[]{username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }
}
