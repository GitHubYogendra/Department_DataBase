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

import com.example.department_database.data.DBHealperFaculty;
import com.example.department_database.data.TeacherContact;


public class FacultyDetails extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase1;
    Boolean EditTextEmptyHold1;
    EditText getFacultyNAME1, getFacultyPhoneNumber1, getFacultyId1, getFacultyPhoneNumber21, getFacultyCommAdd1, getFacultyAadharNo1, getFacultyPhd1, geFacultyPhdQYear1;
    EditText getFacultyPhdClgName1, getFacultyPhdPer1, getFacultyMe1, getFacultyMeQYear1, getFacultyMeClgName1, getFacultyMePer1, getFacultyBe1, getFacultyBeQYear, getFacultyBeClgName1, getFacultyBePer1, getFacultyHsc1, getFacultyHscQYear, getFacultyHscClgName, getFacultyHscPer, getFacultySslc1, getFacultySslcQyear, getFacultySslcClgNAme, getFacultySslcPer, getFacultyAward, getFacultyMambership, getFacultyAcademic, getFacultyIndustry;
    Button SubmitData1, ShowData1;
    String Fname, FphoneNumber1, FphoneNumber2, FId, FCommAdd, FAadharNum, FPhd1, FPhdYear, FPhdClgName, FPhdPer, FME1, FMeyear, FMeClgName, FMePer, FBe1, FBeClgName, FBeYear, FBePer, FHsc1, FHscClgName, FHscYear, FHscPer, FSslc1, FSslcClgName, FSslcYear, FSslcPer, FAward, FMember, FIndstry, FAcademic, query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        getFacultyNAME1 = (EditText) findViewById(R.id.Facultyname);
        getFacultyId1 = (EditText) findViewById(R.id.FacId);
        getFacultyCommAdd1 = (EditText) findViewById(R.id.FacCommAdd);
        getFacultyPhoneNumber1 = (EditText) findViewById(R.id.FacConphone1);
        getFacultyPhoneNumber21 = (EditText) findViewById(R.id.FacConphone2);
        getFacultyAadharNo1 = (EditText) findViewById(R.id.FacAdhar1);
        getFacultyPhd1 = (EditText) findViewById(R.id.PHDImag);
        getFacultyPhdClgName1 = (EditText) findViewById(R.id.PHDClgName);
        geFacultyPhdQYear1 = (EditText) findViewById(R.id.PHDQYear);
        getFacultyPhdPer1 = (EditText) findViewById(R.id.PHDPer);
        getFacultyMe1 = (EditText) findViewById(R.id.MEBranch);
        getFacultyMeQYear1 = (EditText) findViewById(R.id.MEQYear);
        getFacultyMeClgName1 = (EditText) findViewById(R.id.MEClgName);
        getFacultyMePer1 = (EditText) findViewById(R.id.MEPer);
        getFacultyBe1 = (EditText) findViewById(R.id.BEBranch);
        getFacultyBeClgName1 = (EditText) findViewById(R.id.BEClgName);
        getFacultyBeQYear = (EditText) findViewById(R.id.BEQYear);
        getFacultyBePer1 = (EditText) findViewById(R.id.BEPer);
        getFacultyHsc1 = (EditText) findViewById(R.id.HSCBranch);
        getFacultyHscClgName = (EditText) findViewById(R.id.HSCClgName);
        getFacultyHscQYear = (EditText) findViewById(R.id.HSCQYear);
        getFacultyHscPer = (EditText) findViewById(R.id.HSCPer);
        getFacultySslc1 = (EditText) findViewById(R.id.SSLCBranch);
        getFacultySslcClgNAme = (EditText) findViewById(R.id.SSLCClgName);
        getFacultySslcQyear = (EditText) findViewById(R.id.SSLCQYear);
        getFacultySslcPer = (EditText) findViewById(R.id.SSLCPer);
        getFacultyAcademic = (EditText) findViewById(R.id.EXPAcd);
        getFacultyIndustry = (EditText) findViewById(R.id.EXPInd);
        getFacultyAward = (EditText) findViewById(R.id.PUBAwards);
        getFacultyMambership = (EditText) findViewById(R.id.PUBMember);
        SubmitData1 = (Button) findViewById(R.id.buttonToInsert);
        ShowData1 = (Button) findViewById(R.id.buttontoSearch);

        SubmitData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDataBaseBuild1();

                SQLiteTableBuild1();

                CheckEditTextStatus1();

                InsertDataIntoSQLiteDatabase1();

                EmptyEditTextAfterDataInsert1();
            }
        });

        ShowData1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FacultyDetails.this, SearchFaculty.class);
                startActivity(intent);
            }
        });
    }

    public void SQLiteDataBaseBuild1() {

        sqLiteDatabase1 = openOrCreateDatabase(DBHealperFaculty.DATABASE_NAME2, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild1() {
        sqLiteDatabase1.execSQL("CREATE TABLE IF NOT EXISTS " + TeacherContact.TeacherEntry.TABLE_NAME + " (" + TeacherContact.TeacherEntry._ID + " INTEGER PRIMARY KEY, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_ID + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1 + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2 + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_ME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_BE + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY + " VARCHAR, " + TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS + " VARCHAR, " +
                TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP + " VARCHAR);");
    }

    public void CheckEditTextStatus1() {

        Fname = getFacultyNAME1.getText().toString();
        FphoneNumber1 = getFacultyPhoneNumber1.getText().toString();
        FphoneNumber2 = getFacultyPhoneNumber21.getText().toString();
        FId = getFacultyId1.getText().toString();
        FCommAdd = getFacultyCommAdd1.getText().toString();
        FAadharNum = getFacultyAadharNo1.getText().toString();
        FPhd1 = getFacultyPhd1.getText().toString();
        FPhdYear = geFacultyPhdQYear1.getText().toString();
        FPhdClgName = getFacultyPhdClgName1.getText().toString();
        FPhdPer = getFacultyPhdPer1.getText().toString();
        FME1 = getFacultyMe1.getText().toString();
        FMeyear = getFacultyMeQYear1.getText().toString();
        FMeClgName = getFacultyMeClgName1.getText().toString();
        FMePer = getFacultyMePer1.getText().toString();
        FBe1 = getFacultyBe1.getText().toString();
        FBeClgName = getFacultyBeClgName1.getText().toString();
        FBeYear = getFacultyBeQYear.getText().toString();
        FBePer = getFacultyBePer1.getText().toString();
        FHsc1 = getFacultyHsc1.getText().toString();
        FHscClgName = getFacultyHscClgName.getText().toString();
        FHscYear = getFacultyHscQYear.getText().toString();
        FHscPer = getFacultyHscPer.getText().toString();
        FSslc1 = getFacultySslc1.getText().toString();
        FSslcClgName = getFacultySslcClgNAme.getText().toString();
        FSslcYear = getFacultySslcQyear.getText().toString();
        FSslcPer = getFacultySslcPer.getText().toString();
        FAward = getFacultyAward.getText().toString();
        FMember = getFacultyMambership.getText().toString();
        FIndstry = getFacultyIndustry.getText().toString();
        FAcademic = getFacultyAcademic.getText().toString();

        if (TextUtils.isEmpty(Fname) || TextUtils.isEmpty(FphoneNumber1) || TextUtils.isEmpty(FphoneNumber2) || TextUtils.isEmpty(FId) ||
                TextUtils.isEmpty(FCommAdd) || TextUtils.isEmpty(FAadharNum) || TextUtils.isEmpty(FPhd1) || TextUtils.isEmpty(FPhdYear) ||
                TextUtils.isEmpty(FPhdClgName) || TextUtils.isEmpty(FPhdPer) || TextUtils.isEmpty(FME1) || TextUtils.isEmpty(FMeyear) || TextUtils.isEmpty(FMeClgName) ||
                TextUtils.isEmpty(FMePer) || TextUtils.isEmpty(FBe1) || TextUtils.isEmpty(FBeClgName) || TextUtils.isEmpty(FBeYear) || TextUtils.isEmpty(FBePer) ||
                TextUtils.isEmpty(FHsc1) || TextUtils.isEmpty(FHscClgName) || TextUtils.isEmpty(FHscYear) || TextUtils.isEmpty(FHscPer) || TextUtils.isEmpty(FSslc1) ||
                TextUtils.isEmpty(FSslcClgName) || TextUtils.isEmpty(FSslcYear) || TextUtils.isEmpty(FSslcPer) || TextUtils.isEmpty(FAward) || TextUtils.isEmpty(FMember) ||
                TextUtils.isEmpty(FIndstry) || TextUtils.isEmpty(FAcademic)) {

            EditTextEmptyHold1 = false;

        } else {

            EditTextEmptyHold1 = true;
        }
    }

    public void InsertDataIntoSQLiteDatabase1() {

        if (EditTextEmptyHold1 == true) {

            query = "INSERT INTO " + TeacherContact.TeacherEntry.TABLE_NAME + " (nameT,FaculityIdT,AadharNumberT,addressT,phoneNum1T,phoneNum2T,imageT,phdQualYearT,phdClgNameT,phdPercentageT,meBranchT,meQualYearT,meClgNameT,mePercentageT,BEBranchT,BEQualYearT,BEClgNameT,BEPercentageT,HSCBranchT,HSCClgNameT,HSCQualYearT,HSCPercentageT,SSLCBranchT,SSLCQualYearT,SSLCSchNameT,SSLCPercentageT,EXEPAcademicT,EXEPIndustryT,PUBLMemberT,PUBLAwardsT) " +
                    "VALUES('" + Fname + "','" + FId + "','" + FAadharNum + "','" + FCommAdd + "','" + FphoneNumber1 + "','" + FphoneNumber2 + "','" + FPhd1 + "','" + FPhdYear + "','" + FPhdClgName + "','" + FPhdPer + "','" + FME1 + "','" + FMeyear + "','" + FMeClgName + "','" + FMePer + "','" + FBe1 + "','" + FBeYear + "','" + FBeClgName + "','" + FBePer + "','" + FHsc1 + "','" + FHscClgName + "','" + FHscYear + "','" + FHscPer + "','" + FSslc1 + "','" + FSslcYear + "','" + FSslcClgName + "','" + FSslcPer + "','" + FAcademic + "','" + FIndstry + "','" + FMember + "','" + FAward + "');";
            sqLiteDatabase1.execSQL(query);

            Toast.makeText(FacultyDetails.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(FacultyDetails.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }
    public void EmptyEditTextAfterDataInsert1 () {
        getFacultyNAME1.getText().clear();
        getFacultyPhoneNumber1.getText().clear();
        getFacultyPhoneNumber21.getText().clear();
        getFacultyId1.getText().clear();
        getFacultyCommAdd1.getText().clear();
        getFacultyAadharNo1.getText().clear();
        getFacultyPhd1.getText().clear();
        geFacultyPhdQYear1.getText().clear();
        getFacultyPhdClgName1.getText().clear();
        getFacultyPhdPer1.getText().clear();
        getFacultyMe1.getText().clear();
        getFacultyMeQYear1.getText().clear();
        getFacultyMeClgName1.getText().clear();
        getFacultyMePer1.getText().clear();
        getFacultyBe1.getText().clear();
        getFacultyBeClgName1.getText().clear();
        getFacultyBeQYear.getText().clear();
        getFacultyBePer1.getText().clear();
        getFacultyHsc1.getText().clear();
        getFacultyHscClgName.getText().clear();
        getFacultyHscQYear.getText().clear();
        getFacultyHscPer.getText().clear();
        getFacultySslc1.getText().clear();
        getFacultySslcClgNAme.getText().clear();
        getFacultySslcQyear.getText().clear();
        getFacultySslcPer.getText().clear();
        getFacultyAward.getText().clear();
        getFacultyMambership.getText().clear();
        getFacultyIndustry.getText().clear();
        getFacultyAcademic.getText().clear();
    }
}