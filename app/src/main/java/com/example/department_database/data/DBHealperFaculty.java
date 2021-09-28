package com.example.department_database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHealperFaculty extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 ="DepartmentFaculty.db";
    String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+ TeacherContact.TeacherEntry.TABLE_NAME+" ("+ TeacherContact.TeacherEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_ID+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_ME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_BE+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY+" VARCHAR, "+ TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS+" VARCHAR, "+
            TeacherContact.TeacherEntry.COLUMN_FACULTY_Dep+" VARCHAR, "+TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP+ " VARCHAR);";

    public DBHealperFaculty(Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }
    public void onCreate(SQLiteDatabase Db) {

        Db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {
        Db.execSQL("drop table if exists user");
    }

}
