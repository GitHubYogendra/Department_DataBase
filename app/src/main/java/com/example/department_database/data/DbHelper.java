package com.example.department_database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.department_database.data.StudentContact.StudentEntry;


public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Department.db";
    String USER = "create table user (username TEXT primary Key,password TEXT,bookName TEXT)";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase Db) {

        Db.execSQL(USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL("drop table if exists user");
    }


    public Boolean insertData(String username,String password,String bookName){
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("bookName",bookName);
        long result = Mydb.insert("user", null,values);
        if(result == -1) {
            return false;
        }else {
            return true;
        }
    }
    public  Boolean checkUsername(String username) {
        SQLiteDatabase Mydb = this.getReadableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from user  where username =? ", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkPassword(String username, String password) {
        SQLiteDatabase Mydb = this.getReadableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from user where username =? and  password =? ", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public  Boolean checkbookName(String bookName){
        SQLiteDatabase Mydb = this.getReadableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from user  where username =? ",new String[] {bookName});
        if (cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }
    public Boolean checkNameBook(String username, String Book){
        SQLiteDatabase Mydb = this.getReadableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from user where username =? and  bookName =? ",new String[] {username,Book});
        if (cursor.getCount()>0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean updatepasword(String username,String password){
        SQLiteDatabase Mydb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        long result = Mydb.update("user", values,"username=?",new String[] {username});

        if(result == -1) {
            return false;
        }else {
            return true;
        }
    }
}
