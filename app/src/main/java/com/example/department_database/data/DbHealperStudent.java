package com.example.department_database.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHealperStudent extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="DepartmentStudent.db";
    String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+ StudentContact.StudentEntry.TABLE_NAME+" ("+ StudentContact.StudentEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ StudentContact.StudentEntry.COLUMN_STUDENT_NAME+" VARCHAR, "+ StudentContact.StudentEntry.COLUMN_STUDENT_USN+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_NAME+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_NAME+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_CONTACT_NO+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_HOSTEL_DAY+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_BLOOD_GROUP+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Dip+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_DIP_BRANCH+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Hsc+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_HSC_BRANCH+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Sslc+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_BRANCH+" VARCHAR,"+
            StudentContact.StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_YEAR+" VARCHAR,"+StudentContact.StudentEntry.COLUMN_STUDENT_SEM+ " VARCHAR);";

    public DbHealperStudent(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase Db) {

        Db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL("drop table if exists user");
    }

}
