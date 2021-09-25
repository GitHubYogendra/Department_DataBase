package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.department_database.data.DbHealperStudent;
import com.example.department_database.data.DbHelper;
import com.example.department_database.data.StudentContact;

public class StudentDetails extends AppCompatActivity {

        SQLiteDatabase sqLiteDatabase;
        Boolean EditTextEmptyHold;
        EditText getNAME, getPhoneNumber,getusn,getStudentCurrentYear,getStudentCurrentSem,getAadhar,getFatherName,getMotherName;
        EditText getComAdh,getBlood,getFatherNum,getMotherNum,getHostel,getDipB,getDipClgName,getDipYear,getDipPer,getHscB,getHscClgName,getHscYear,getHscPer,getSslcB,getSslcClgName,getSslcYear,getSslcPer;
        Button SubmitData, ShowData;
        String name, phoneNumber, usn,Sem,Year,Adhar,FatherName,motherName,query,ComAdr,Blood,FatherNum,motherNum,Hostel,DipB,DipClgName,DipYear,DipPer,HscB,HscClgName,HscYear,HscPer,SslcB,SslcSchName,SslcYear,SslcPer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

            SubmitData = (Button) findViewById(R.id.button);
            getPhoneNumber = (EditText) findViewById(R.id.editText2);
            ShowData = (Button)findViewById(R.id.button2);
            getNAME = (EditText) findViewById(R.id.Studentname);
            getusn = (EditText)findViewById(R.id.usn);
            getStudentCurrentSem= (EditText)findViewById(R.id.StudentSem);
            getStudentCurrentYear = (EditText)findViewById(R.id.StudentYear);
            getAadhar = (EditText)findViewById(R.id.aadharNo);
            getFatherName = (EditText)findViewById(R.id.FatherName);
            getMotherName = (EditText)findViewById(R.id.MotherName);
            getComAdh = (EditText)findViewById(R.id.ComAdr);
            getBlood = (EditText)findViewById(R.id.BloodGroup);
            getFatherNum = (EditText)findViewById(R.id.FatherNum);
            getMotherNum = (EditText)findViewById(R.id.MotherNum);
            getHostel = (EditText)findViewById(R.id.Hostel);
            getDipB = (EditText)findViewById(R.id.DipB);
            getDipClgName = (EditText)findViewById(R.id.DipCollege);
            getDipYear = (EditText)findViewById(R.id.DipYear);
            getDipPer = (EditText)findViewById(R.id.DipPercentage);
            getHscB = (EditText)findViewById(R.id.HscB);
            getHscClgName = (EditText)findViewById(R.id.HscCollege);
            getHscYear = (EditText)findViewById(R.id.HscYear);
            getHscPer = (EditText)findViewById(R.id.HscPercentage);
            getSslcB = (EditText)findViewById(R.id.SslcB);
            getSslcClgName = (EditText)findViewById(R.id.SslcCollege);
            getSslcYear = (EditText)findViewById(R.id.SslcYear);
            getSslcPer = (EditText)findViewById(R.id.SslcPercentage);

            SubmitData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    SQLiteDataBaseBuild();

                    SQLiteTableBuild();

                    CheckEditTextStatus();

                    InsertDataIntoSQLiteDatabase();

                    EmptyEditTextAfterDataInsert();


                }
            });
        ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StudentDetails.this, SearchSQLiteActivity.class);
                startActivity(intent);
            }
        });

    }
    public void SQLiteDataBaseBuild () {

        sqLiteDatabase = openOrCreateDatabase(DbHealperStudent.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild () {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + StudentContact.StudentEntry.TABLE_NAME + "(" + StudentContact.StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + StudentContact.StudentEntry.COLUMN_STUDENT_NAME + " VARCHAR, " + StudentContact.StudentEntry.COLUMN_STUDENT_USN + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_NAME + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_NAME + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_HOSTEL_DAY + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_BLOOD_GROUP + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Dip + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_DIP_BRANCH + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Hsc + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_HSC_BRANCH + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Sslc + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_BRANCH + " VARCHAR," +
                StudentContact.StudentEntry.COLUMN_STUDENT_CONTACT_NO + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_YEAR + " VARCHAR," + StudentContact.StudentEntry.COLUMN_STUDENT_SEM + " VARCHAR);");

    }

            public void CheckEditTextStatus () {

                name = getNAME.getText().toString();
                phoneNumber = getPhoneNumber.getText().toString();
                usn = getusn.getText().toString();
                Sem = getStudentCurrentSem.getText().toString();
                Year = getStudentCurrentYear.getText().toString();
                Adhar = getAadhar.getText().toString();
                FatherName = getFatherName.getText().toString();
                motherName = getMotherName.getText().toString();
                ComAdr = getComAdh.getText().toString();
                FatherNum = getFatherNum.getText().toString();
                motherNum = getMotherNum.getText().toString();
                Hostel = getHostel.getText().toString();
                Blood = getBlood.getText().toString();
                DipB = getDipB.getText().toString();
                DipClgName = getDipClgName.getText().toString();
                DipPer = getDipPer.getText().toString();
                DipYear = getDipYear.getText().toString();
                HscB = getHscB.getText().toString();
                HscClgName = getHscClgName.getText().toString();
                HscPer = getHscPer.getText().toString();
                HscYear = getHscYear.getText().toString();
                SslcB = getSslcB.getText().toString();
                SslcSchName = getSslcClgName.getText().toString();
                SslcYear = getSslcYear.getText().toString();
                SslcPer = getSslcPer.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phoneNumber)||TextUtils.isEmpty(usn)||TextUtils.isEmpty(Year)||TextUtils.isEmpty(Sem)||TextUtils.isEmpty(Adhar)||TextUtils.isEmpty(FatherName)||
                        TextUtils.isEmpty(motherName)||TextUtils.isEmpty(ComAdr)||TextUtils.isEmpty(FatherNum)||TextUtils.isEmpty(motherNum)||TextUtils.isEmpty(Blood)||TextUtils.isEmpty(Hostel)||TextUtils.isEmpty(DipB)
                        ||TextUtils.isEmpty(DipClgName)||TextUtils.isEmpty(DipPer)||TextUtils.isEmpty(DipYear)||TextUtils.isEmpty(HscB)||TextUtils.isEmpty(HscClgName)||TextUtils.isEmpty(HscPer)||TextUtils.isEmpty(HscYear)
                        ||TextUtils.isEmpty(SslcB)||TextUtils.isEmpty(SslcSchName)||TextUtils.isEmpty(SslcYear)||TextUtils.isEmpty(SslcPer)) {

                    EditTextEmptyHold = false;

                } else {

                    EditTextEmptyHold = true;
                }
            }

            public void InsertDataIntoSQLiteDatabase () {

                if (EditTextEmptyHold == true) {

                    query = "INSERT INTO " + StudentContact.StudentEntry.TABLE_NAME + " (name,studentNum,usn,CurrentYear,sem,AadharNumber,FatherName,MotherName,address,studentFatherNum,studentMotherNum,BloodGroup,hotel,BranchName,DipClgName,DipPercentage,yearQualDip,HscBranch,HscClgName,HscPercentage,yearQualHsc,SslcBranch,SslsSchName,SslcPercentage,yearQualSslc) " +
                            "VALUES('" + name + "','" + phoneNumber + "','" + usn + "','" + Year + "','" + Sem + "','" + Adhar + "','" + FatherName + "','" + motherName + "','" + ComAdr + "','" + FatherNum + "','" + motherNum + "','" + Blood + "','" + Hostel + "','" + DipB + "','" + DipClgName + "','" + DipPer + "','" + DipYear + "','" + HscB + "','" + HscClgName + "','" + HscPer + "','" + HscYear + "','" + SslcB + "','" + SslcSchName + "','" + SslcPer + "','" + SslcYear + "');";

                    sqLiteDatabase.execSQL(query);

                    Toast.makeText(StudentDetails.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(StudentDetails.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

                }

            }
            public void EmptyEditTextAfterDataInsert () {

                getNAME.getText().clear();

                getPhoneNumber.getText().clear();

                getusn.getText().clear();

                getStudentCurrentYear.getText().clear();

                getStudentCurrentSem.getText().clear();

                getAadhar.getText().clear();

                getFatherName.getText().clear();

                getMotherName.getText().clear();

                getComAdh.getText().clear();

                getHostel.getText().clear();

                getFatherNum.getText().clear();

                getMotherNum.getText().clear();

                getBlood.getText().clear();

                getDipB.getText().clear();

                getDipClgName.getText().clear();

                getDipYear.getText().clear();

                getDipPer.getText().clear();

                getHscB.getText().clear();

                getHscPer.getText().clear();

                getHscYear.getText().clear();

                getHscClgName.getText().clear();

                getSslcB.getText().clear();

                getSslcClgName.getText().clear();

                getSslcPer.getText().clear();

                getSslcYear.getText().clear();

            }
}