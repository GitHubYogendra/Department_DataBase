package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.department_database.data.DBHealperFaculty;
import com.example.department_database.data.TeacherContact;

public class EditorFaculty extends AppCompatActivity {
    DBHealperFaculty faculty = new DBHealperFaculty(this);

    private EditText mNameEditText;
    private EditText mFid;
    private EditText mPhone1;
    private EditText mPhone2;
    private EditText mCommAddress;
    private EditText mAadharNum;
    private EditText mphd;
    private EditText mphdClg;
    private EditText mphdYear;
    private EditText mphdPer;
    private EditText mme;
    private EditText mmeClg;
    private EditText mmeYear;
    private EditText mmePer;
    private EditText mBe;
    private EditText mBeClg;
    private EditText mBeYear;
    private EditText mBePer;
    private EditText mHsc;
    private EditText mHscClg;
    private EditText mHscYear;
    private EditText mHscPer;
    private EditText mSslc;
    private EditText mSslcclg;
    private EditText mSslcYear;
    private EditText mSslcPer;
    private EditText mAward;
    private EditText mIndu;
    private EditText mMember;
    private EditText mAcademic;
    private EditText mFUnic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_faculty);

        mNameEditText = (EditText) findViewById(R.id.Facultyname1);
        mFid = (EditText) findViewById(R.id.FacId1);
        mPhone1 = (EditText) findViewById(R.id.FacConphone11);
        mPhone2 = (EditText) findViewById(R.id.FacConphone21);
        mCommAddress = (EditText) findViewById(R.id.FacCommAdd1);
        mAadharNum = (EditText) findViewById(R.id.FacAdhar11);
        mphd = (EditText) findViewById(R.id.PHDImag1);
        mphdClg = (EditText) findViewById(R.id.PHDClgName1);
        mphdYear = (EditText) findViewById(R.id.PHDQYear1);
        mphdPer = (EditText) findViewById(R.id.PHDPer1);
        mme = (EditText) findViewById(R.id.MEBranch1);
        mmeClg = (EditText) findViewById(R.id.MEClgName1);
        mmeYear = (EditText) findViewById(R.id.MEQYear1);
        mmePer = (EditText) findViewById(R.id.MEPer1);
        mBe = (EditText) findViewById(R.id.BEBranch1);
        mBeClg = (EditText) findViewById(R.id.BEClgName1);
        mBeYear = (EditText) findViewById(R.id.BEQYear1);
        mBePer = (EditText) findViewById(R.id.BEPer1);
        mHsc = (EditText) findViewById(R.id.HSCBranch1);
        mHscClg = (EditText) findViewById(R.id.HSCClgName1);
        mHscYear = (EditText) findViewById(R.id.HSCQYear1);
        mHscPer = (EditText) findViewById(R.id.HSCPer1);
        mSslc = (EditText) findViewById(R.id.SSLCBranch1);
        mSslcclg = (EditText) findViewById(R.id.SSLCClgName1);
        mSslcYear = (EditText) findViewById(R.id.SSLCQYear1);
        mSslcPer = (EditText) findViewById(R.id.SSLCPer1);
        mAward = (EditText) findViewById(R.id.PUBAwards1);
        mIndu = (EditText) findViewById(R.id.EXPInd1);
        mMember = (EditText) findViewById(R.id.PUBMember1);
        mAcademic = (EditText) findViewById(R.id.EXPAcd1);
        mFUnic = (EditText)findViewById(R.id.Funiquq);


        Intent intent = getIntent();

        mNameEditText.setText(intent.getStringExtra("FName"));
        mFid.setText(intent.getStringExtra("Fid"));
        mPhone1.setText(intent.getStringExtra("PhoneNo1"));
        mPhone2.setText(intent.getStringExtra("PhoneNo2"));
        mCommAddress.setText(intent.getStringExtra("ComAdd"));
        mAadharNum.setText(intent.getStringExtra("Adar"));
        mphd.setText(intent.getStringExtra("phd"));
        mphdClg.setText(intent.getStringExtra("phdClg"));
        mphdYear.setText(intent.getStringExtra("phdYear"));
        mphdPer.setText(intent.getStringExtra("phdPer"));
        mme.setText(intent.getStringExtra("me"));
        mmeClg.setText(intent.getStringExtra("meClg"));
        mmeYear.setText(intent.getStringExtra("meYear"));
        mmePer.setText(intent.getStringExtra("mePer"));
        mBe.setText(intent.getStringExtra("Be"));
        mBeClg.setText(intent.getStringExtra("BeClg"));
        mBeYear.setText(intent.getStringExtra("Beyear"));
        mBePer.setText(intent.getStringExtra("BePer"));
        mHsc.setText(intent.getStringExtra("Hsc"));
        mHscClg.setText(intent.getStringExtra("HscClg"));
        mHscYear.setText(intent.getStringExtra("HscYear"));
        mHscPer.setText(intent.getStringExtra("HscPer"));
        mSslc.setText(intent.getStringExtra("Sslc"));
        mSslcclg.setText(intent.getStringExtra("SslcSch"));
        mSslcYear.setText(intent.getStringExtra("SslcYear"));
        mSslcPer.setText(intent.getStringExtra("SslcPer"));
        mAward.setText(intent.getStringExtra("Award"));
        mIndu.setText(intent.getStringExtra("Industry"));
        mMember.setText(intent.getStringExtra("Member"));
        mAcademic.setText(intent.getStringExtra("Academic"));
        mFUnic.setText(intent.getStringExtra("FUniqe"));

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

        String fname = mNameEditText.getText().toString().trim();
        String id = mFid.getText().toString().trim();
        String phoneCo1 = mPhone1.getText().toString().trim();
        String phoneCo2 = mPhone2.getText().toString().trim();
        String ComAdd = mCommAddress.getText().toString().trim();
        String Aadhar = mAadharNum.getText().toString().trim();
        String phd = mphd.getText().toString().trim();
        String phdClg = mphdClg.getText().toString().trim();
        String phdYear = mphdYear.getText().toString().trim();
        String phdPer = mphdPer.getText().toString().trim();
        String me = mme.getText().toString().trim();
        String meClg = mmeClg.getText().toString().trim();
        String meYear = mmeYear.getText().toString().trim();
        String mePer = mmePer.getText().toString().trim();
        String Be = mBe.getText().toString().trim();
        String BeClg = mBeClg.getText().toString().trim();
        String BeYear = mBeYear.getText().toString().trim();
        String BePer = mBePer.getText().toString().trim();
        String hsc = mHsc.getText().toString().toString();
        String hscClg = mHscClg.getText().toString().trim();
        String hscYear = mHscYear.getText().toString().trim();
        String hscPer = mHscPer.getText().toString().trim();
        String sslc = mSslc.getText().toString().trim();
        String sslcClg = mSslcclg.getText().toString().trim();
        String sslcYear = mSslcYear.getText().toString().trim();
        String sslcPer = mSslcPer.getText().toString().trim();
        String Award = mAward.getText().toString().trim();
        String member = mMember.getText().toString().trim();
        String Ind = mIndu.getText().toString().trim();
        String Aca = mAcademic.getText().toString().trim();
        String Funic = mFUnic.getText().toString().trim();

        if (TextUtils.isEmpty(fname) && TextUtils.isEmpty(id) && TextUtils.isEmpty(phoneCo1) &&
                TextUtils.isEmpty(Aadhar) && TextUtils.isEmpty(phoneCo2) && TextUtils.isEmpty(ComAdd) && TextUtils.isEmpty(phd) &&
                TextUtils.isEmpty(phdClg) && TextUtils.isEmpty(phdYear) && TextUtils.isEmpty(phdPer) && TextUtils.isEmpty(me) &&
                TextUtils.isEmpty(meClg) && TextUtils.isEmpty(meYear) && TextUtils.isEmpty(mePer) && TextUtils.isEmpty(Be) && TextUtils.isEmpty(BeClg) &&
                TextUtils.isEmpty(BeYear) && TextUtils.isEmpty(BePer) && TextUtils.isEmpty(hsc) && TextUtils.isEmpty(hscClg) && TextUtils.isEmpty(hscYear) &&
                TextUtils.isEmpty(hscPer) && TextUtils.isEmpty(sslc) && TextUtils.isEmpty(sslcClg) && TextUtils.isEmpty(sslcYear)&&TextUtils.isEmpty(sslcPer)&&
        TextUtils.isEmpty(Award)&&TextUtils.isEmpty(member)&&TextUtils.isEmpty(Ind)&&TextUtils.isEmpty(Aca)&&TextUtils.isEmpty(Funic)) {

            return;
        }

        ContentValues values = new ContentValues();
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME,fname);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_ID,id);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS,ComAdd);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER,Aadhar);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1,phoneCo1);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2,phoneCo2);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD,phd);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME,phdClg);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR,phdYear);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER,phdPer);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME,me);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME,meClg);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR,meYear);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER,mePer);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE,Be);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME,BeClg);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR,BeYear);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER,BePer);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC,hsc);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME,hscClg);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR,hscYear);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER,hscPer);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC,sslc);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME,sslcClg);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE,sslcPer);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR,sslcYear);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS,Award);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY,Ind);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP,member);
        values.put(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC,Aca);
        values.put(TeacherContact.TeacherEntry._ID,Funic);

        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME);
        }

        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_ID)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_ID);
        }

        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP);
        }
        if (values.containsKey(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC)) {
            String name = values.getAsString(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC);
        }
        if (values.size() == 0) {
            return;
        }
        SQLiteDatabase database = faculty.getWritableDatabase();
        selection = TeacherContact.TeacherEntry._ID+ "=?";
        selectionArgs = new String[] {Funic};
        int rowsUpdated = database.update(TeacherContact.TeacherEntry.TABLE_NAME, values, selection, selectionArgs);
        if(rowsUpdated > 0){
            Toast.makeText(EditorFaculty.this, "updated successfully", Toast.LENGTH_SHORT).show();
        }  else {
            Toast.makeText(EditorFaculty.this, "updated Failed", Toast.LENGTH_SHORT).show();
        }
    }
    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete this Faculty?");
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
        SQLiteDatabase database = faculty.getWritableDatabase();
        int rowsDeleted;
        String Funicq = mFUnic.getText().toString().trim();
        selection = TeacherContact.TeacherEntry._ID + "=?";
        selectionArgs = new String[] {Funicq};
        rowsDeleted = database.delete(TeacherContact.TeacherEntry.TABLE_NAME, selection, selectionArgs);
        if(rowsDeleted > 0){
            Toast.makeText(EditorFaculty.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
        }  else {
            Toast.makeText(EditorFaculty.this, "Deleted Failed", Toast.LENGTH_SHORT).show();
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