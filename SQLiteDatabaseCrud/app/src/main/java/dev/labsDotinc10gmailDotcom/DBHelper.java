package dev.labsDotinc10gmailDotcom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("Create table user(firstname primary key,lastname text, contact text, dob text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists user");
    }

    public Boolean insertData(String firstname, String lastname, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = DB.insert("user", null, contentValues);
        if (result == -1) {
            return false;

        } else {
            return true;

        }
    }

    public Boolean updateData(String firstname, String lastname, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lastname", lastname);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);

        Cursor cursor = DB.rawQuery("select * from user where firstname=?", new String[]{firstname});

        if (cursor.getCount() > 0) {
            long result = DB.update("user", contentValues, "lastname=?", new String[]{firstname});
        }

        int result = 0;
        if (result == -1) {
                return false;

            } else {
                return true;
            }
        }

    public Boolean deleteData(String firstname) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where firstname=?", new String[]{firstname});

        if (cursor.getCount() > 0) {
            long result = DB.delete("user",  "lastname=?", new String[]{firstname});
        }

        int result = 0;
        if (result == -1) {
            return false;

        } else {
            return true;
        }
    }

    public Cursor getData(String firstname) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where firstname=?", new String[]{firstname});
return cursor;

    }
    }

