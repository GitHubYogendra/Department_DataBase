package com.example.department_database;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Selection;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.example.department_database.data.DbHealperStudent;
import com.example.department_database.data.StudentContact.StudentEntry;

import java.util.Locale;


public class EditorActivityStudent extends AppCompatActivity {

    DbHealperStudent student = new DbHealperStudent(this);

    private EditText mNameEditText;

    private EditText mBreedEditText;

    private EditText mWeightEditText;

    private EditText mCurrentYear;

    private EditText mCurrentSem;

    private EditText mAadharnumber;

    private EditText mFatherName;

    private EditText mMotherName;

    private EditText mComAdr;

    private EditText mBloodGroup;

    private EditText mFatherNum;

    private EditText mMotherNum;

    private EditText mHostel;

    private EditText mDipB1;

    private EditText mDipClg;

    private EditText mDipPer;

    private EditText mDipQYear;

    private EditText mHscB1;

    private EditText mHscClg;

    private EditText mHscPer;

    private EditText mHscQYear;

    private EditText mSslcB1;

    private EditText mSslcClg;

    public EditText mSslcPer;

    private EditText mSslcQYear;

    private EditText mStuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_student);

        mNameEditText = (EditText) findViewById(R.id.Studentname1);
        mWeightEditText = (EditText) findViewById(R.id.usn1);
        mBreedEditText = (EditText) findViewById(R.id.editText21);
        mCurrentYear = (EditText) findViewById(R.id.StudentYear1);
        mCurrentSem = (EditText) findViewById(R.id.StudentSem1);
        mAadharnumber = (EditText) findViewById(R.id.aadharNo1);
        mFatherName = (EditText) findViewById(R.id.FatherName1);
        mMotherName = (EditText) findViewById(R.id.MotherName1);
        mComAdr = (EditText) findViewById(R.id.ComAdr1);
        mBloodGroup = (EditText) findViewById(R.id.BloodGroup1);
        mFatherNum = (EditText) findViewById(R.id.FatherNum1);
        mMotherNum = (EditText) findViewById(R.id.MotherNum1);
        mHostel = (EditText) findViewById(R.id.Hostel1);
        mDipB1 = (EditText) findViewById(R.id.DipB1);
        mDipClg = (EditText) findViewById(R.id.DipCollege1);
        mDipPer = (EditText) findViewById(R.id.DipPercentage1);
        mDipQYear = (EditText) findViewById(R.id.DipYear1);
        mHscB1 = (EditText) findViewById(R.id.HscB1);
        mHscClg = (EditText) findViewById(R.id.HscCollege1);
        mHscPer = (EditText) findViewById(R.id.HscPercentage1);
        mHscQYear = (EditText) findViewById(R.id.HscYear1);
        mSslcB1 = (EditText) findViewById(R.id.SslcB1);
        mSslcClg = (EditText) findViewById(R.id.SslcCollege1);
        mSslcPer = (EditText) findViewById(R.id.SslcPercentage1);
        mSslcQYear = (EditText) findViewById(R.id.SslcYear1);
        mStuid=(EditText)findViewById(R.id.Stuid);

        Intent intent = getIntent();
        mNameEditText.setText(intent.getStringExtra("StudentName"));
        mWeightEditText.setText(intent.getStringExtra("usn"));
        mBreedEditText.setText(intent.getStringExtra("Phone"));
        mCurrentYear.setText(intent.getStringExtra("Year"));
        mCurrentSem.setText(intent.getStringExtra("Sem"));
        mAadharnumber.setText(intent.getStringExtra("AadharNo"));
        mFatherName.setText(intent.getStringExtra("FatherName"));
        mMotherName.setText(intent.getStringExtra("MotherName"));
        mComAdr.setText(intent.getStringExtra("CommAddress"));
        mBloodGroup.setText(intent.getStringExtra("Blood"));
        mFatherNum.setText(intent.getStringExtra("FatherNum"));
        mMotherNum.setText(intent.getStringExtra("MotherNum"));
        mHostel.setText(intent.getStringExtra("Hostel"));
        mDipB1.setText(intent.getStringExtra("DipB"));
        mDipClg.setText(intent.getStringExtra("DipClg"));
        mDipPer.setText(intent.getStringExtra("DipPer"));
        mDipQYear.setText(intent.getStringExtra("DipQYear"));
        mHscB1.setText(intent.getStringExtra("HscB"));
        mHscClg.setText(intent.getStringExtra("HscClg"));
        mHscPer.setText(intent.getStringExtra("HscPer"));
        mHscQYear.setText(intent.getStringExtra("HscQYear"));
        mSslcB1.setText(intent.getStringExtra("SslcB"));
        mSslcClg.setText(intent.getStringExtra("SslcClg"));
        mSslcPer.setText(intent.getStringExtra("SslcPer"));
        mSslcQYear.setText(intent.getStringExtra("SslcQYear"));
        mStuid.setText(intent.getStringExtra("StuId"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        // If this is a new pet, hide the "Delete" menu item.
        MenuItem menuItem = menu.findItem(R.id.action_delete);
        menuItem.setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                savePet();
                finish();
                break;
                case R.id.action_delete:
                 showDeleteConfirmationDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    private void savePet() {
        String selection;
        String[] selectionArgs;

        String uname = mNameEditText.getText().toString().trim();
        String usn = mWeightEditText.getText().toString().trim();
        String phone = mBreedEditText.getText().toString().trim();
        String year =  mCurrentYear.getText().toString().trim();
        String Sem =  mCurrentSem.getText().toString().trim();
        String Aadhar = mAadharnumber.getText().toString().trim();
        String FatherName = mFatherName.getText().toString().trim();
        String MotherName = mMotherName.getText().toString().trim();
        String CommAddress = mComAdr.getText().toString().trim();
        String BloodGroup = mBloodGroup.getText().toString().trim();
        String FatherNum = mFatherNum.getText().toString().trim();
        String MotherNum = mMotherNum.getText().toString().trim();
        String Hostel = mHostel.getText().toString().trim();
        String DipBranch = mDipB1.getText().toString().trim();
        String DipClg = mDipClg.getText().toString().trim();
        String DipPer = mDipPer.getText().toString().trim();
        String DipQyear = mDipQYear.getText().toString().trim();
        String HscBranch = mHscB1.getText().toString().trim();
        String HscClg = mHscClg.getText().toString().trim();
        String HscPer = mHscPer.getText().toString().trim();
        String HscQYear = mHscQYear.getText().toString().trim();
        String SslcBranch = mSslcB1.getText().toString().trim();
        String SslcClg = mSslcClg.getText().toString().trim();
        String SslcPer = mSslcPer.getText().toString().trim();
        String SslcQYear = mSslcQYear.getText().toString().trim();
        String Stui = mStuid.getText().toString().trim();


        if (TextUtils.isEmpty(uname) && TextUtils.isEmpty(usn) &&TextUtils.isEmpty(phone)&&
                TextUtils.isEmpty(Aadhar)&& TextUtils.isEmpty(year)&&TextUtils.isEmpty(Sem)&&TextUtils.isEmpty(FatherName)&&
        TextUtils.isEmpty(MotherName)&&TextUtils.isEmpty(CommAddress)&&TextUtils.isEmpty(BloodGroup)&&TextUtils.isEmpty(FatherNum)&&
        TextUtils.isEmpty(MotherNum)&&TextUtils.isEmpty(Hostel)&&TextUtils.isEmpty(DipBranch)&&TextUtils.isEmpty(DipClg)&&TextUtils.isEmpty(DipPer)&&
        TextUtils.isEmpty(DipQyear)&&TextUtils.isEmpty(HscBranch)&&TextUtils.isEmpty(HscClg)&&TextUtils.isEmpty(HscPer)&&TextUtils.isEmpty(HscQYear)&&
        TextUtils.isEmpty(SslcBranch)&&TextUtils.isEmpty(SslcClg)&&TextUtils.isEmpty(SslcPer)&&TextUtils.isEmpty(SslcQYear)&&TextUtils.isEmpty(Stui)) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(StudentEntry.COLUMN_STUDENT_NAME, uname);
        values.put(StudentEntry.COLUMN_STUDENT_USN, usn);
        values.put(StudentEntry.COLUMN_STUDENT_CONTACT_NO, phone);
        values.put(StudentEntry.COLUMN_STUDENT_YEAR,year);
        values.put(StudentEntry.COLUMN_STUDENT_SEM,Sem);
        values.put(StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER, Aadhar);
        values.put(StudentEntry.COLUMN_STUDENT_FATHER_NAME,FatherName);
        values.put(StudentEntry.COLUMN_STUDENT_MOTHER_NAME,MotherName);
        values.put(StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS,CommAddress);
        values.put(StudentEntry.COLUMN_STUDENT_BLOOD_GROUP,BloodGroup);
        values.put(StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO,FatherNum);
        values.put(StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO,MotherNum);
        values.put(StudentEntry.COLUMN_HOSTEL_DAY,Hostel);
        values.put(StudentEntry.COLUMN_STUDENT_DIP_BRANCH,DipBranch);
        values.put(StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME,DipClg);
        values.put(StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE,DipPer);
        values.put(StudentEntry.COLUMN_YEAR_QUAL_Dip,DipQyear);
        values.put(StudentEntry.COLUMN_STUDENT_HSC_BRANCH,HscBranch);
        values.put(StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME,HscClg);
        values.put(StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE,HscPer);
        values.put(StudentEntry.COLUMN_YEAR_QUAL_Hsc,HscQYear);
        values.put(StudentEntry.COLUMN_STUDENT_SSLC_BRANCH,SslcBranch);
        values.put(StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME,SslcClg);
        values.put(StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE,SslcPer);
        values.put(StudentEntry.COLUMN_YEAR_QUAL_Sslc,SslcQYear);
        values.put(StudentEntry._ID,Stui);


        if (values.containsKey(StudentEntry.COLUMN_STUDENT_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Name");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_USN)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_USN);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a usn");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_CONTACT_NO)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_CONTACT_NO);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Contact Number");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_YEAR)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_YEAR);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Current Year");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_SEM)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_SEM);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Current Sem");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a AadharNum");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_FATHER_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_FATHER_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Father Name");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_MOTHER_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_MOTHER_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Mother Name");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a address");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_BLOOD_GROUP)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_BLOOD_GROUP);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Blood Group");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Father Num");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO);
            if (name == null) {
                throw new IllegalArgumentException("Student requires a Mother Num");
            }
        }
        if (values.containsKey(StudentEntry.COLUMN_HOSTEL_DAY)) {
            String name = values.getAsString(StudentEntry.COLUMN_HOSTEL_DAY);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_DIP_BRANCH)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_DIP_BRANCH);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE);

        }
        if (values.containsKey(StudentEntry.COLUMN_YEAR_QUAL_Dip)) {
            String name = values.getAsString(StudentEntry.COLUMN_YEAR_QUAL_Dip);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_HSC_BRANCH)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_HSC_BRANCH);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE);

        }
        if (values.containsKey(StudentEntry.COLUMN_YEAR_QUAL_Hsc)) {
            String name = values.getAsString(StudentEntry.COLUMN_YEAR_QUAL_Hsc);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_SSLC_BRANCH)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_SSLC_BRANCH);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME);

        }
        if (values.containsKey(StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE)) {
            String name = values.getAsString(StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE);

        }
        if (values.containsKey(StudentEntry.COLUMN_YEAR_QUAL_Sslc)) {
            String name = values.getAsString(StudentEntry.COLUMN_YEAR_QUAL_Sslc);

        }

        if (values.size() == 0) {
            return;
        }
        SQLiteDatabase database = student.getWritableDatabase();

        selection = StudentEntry._ID+ "=?";
        selectionArgs = new String[] {Stui};
        int rowsUpdated = database.update(StudentEntry.TABLE_NAME, values, selection, selectionArgs);
        if(rowsUpdated > 0){
            Toast.makeText(EditorActivityStudent.this, "updated successfully", Toast.LENGTH_SHORT).show();
        }  else {
            Toast.makeText(EditorActivityStudent.this, "updated Failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete this Student?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deletePet();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void deletePet() {
        String selection;
        String[] selectionArgs;
        SQLiteDatabase database = student.getWritableDatabase();
        int rowsDeleted;
        String Stui = mStuid.getText().toString().trim();
        selection = StudentEntry._ID+ "=?";
        selectionArgs = new String[] {Stui};
        rowsDeleted = database.delete(StudentEntry.TABLE_NAME, selection, selectionArgs);
        if(rowsDeleted > 0){
            Toast.makeText(EditorActivityStudent.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
        }  else {
            Toast.makeText(EditorActivityStudent.this, "Deleted Failed", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Discard Your Changes and Quit Editing");
        builder.setPositiveButton("Discard", discardButtonClickListener);
        builder.setNegativeButton("Keep Editing", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public void onBackPressed() {
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                };

        showUnsavedChangesDialog(discardButtonClickListener);
    }
}