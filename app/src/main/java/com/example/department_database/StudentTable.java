package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.department_database.data.DbHealperStudent;
import com.example.department_database.data.StudentContact;

import java.util.ArrayList;

public class StudentTable extends AppCompatActivity {
    ListView listView;
    ArrayList<Student> StudentList = new ArrayList<Student>();
    list listAdapter;
    DbHealperStudent sqLiteHelper;
    EditText editText;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_table);

        listView = (ListView) findViewById(R.id.listView1);

        listView.setTextFilterEnabled(true);

        sqLiteHelper = new DbHealperStudent(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StudentTable.this, EditorActivityStudent.class);
                Student ListViewClickData = (Student) parent.getItemAtPosition(position);
                //  Uri currentUri = Uri.parse(ListViewClickData.getName());
                String item = ListViewClickData.getName();
                String usn = ListViewClickData.getNumber();
                String phone = ListViewClickData.getPhoneNumber();
                String year = ListViewClickData.getCurrentYear();
                String Sem = ListViewClickData.getCurrentSem();
                String Aadhar = ListViewClickData.getAadharNo();
                String Father = ListViewClickData.getFatherName();
                String Mother = ListViewClickData.getMotherName();
                String CommAdr = ListViewClickData.getComAdd();
                String Blood = ListViewClickData.getBloodGroup();
                String FatherNum = ListViewClickData.getFatherNum();
                String MotherNum = ListViewClickData.getMotherNum();
                String Hostel = ListViewClickData.getHostel();
                String DipB = ListViewClickData.getDipB();
                String DipClg = ListViewClickData.getDipClg();
                String DipPer = ListViewClickData.getDipPer();
                String DipQYear = ListViewClickData.getDipQYear();
                String HscB = ListViewClickData.getHscB();
                String HscClg = ListViewClickData.getHscClg();
                String HscPer = ListViewClickData.getHscPer();
                String HscQYear = ListViewClickData.getHscQYear();
                String SslcB = ListViewClickData.getSslcB();
                String SslcClg = ListViewClickData.getSslcClg();
                String SslcPer = ListViewClickData.getSslcPer();
                String SslcQYear = ListViewClickData.getSslsQYear();
                String StuId = ListViewClickData.getStuId();

                intent.putExtra("StudentName", item);
                intent.putExtra("usn", usn);
                intent.putExtra("Phone", phone);
                intent.putExtra("Year", year);
                intent.putExtra("Sem", Sem);
                intent.putExtra("AadharNo", Aadhar);
                intent.putExtra("FatherName", Father);
                intent.putExtra("MotherName", Mother);
                intent.putExtra("CommAddress", CommAdr);
                intent.putExtra("Blood", Blood);
                intent.putExtra("FatherNum", FatherNum);
                intent.putExtra("MotherNum", MotherNum);
                intent.putExtra("Hostel", Hostel);
                intent.putExtra("DipB", DipB);
                intent.putExtra("DipClg", DipClg);
                intent.putExtra("DipPer", DipPer);
                intent.putExtra("DipQYear", DipQYear);
                intent.putExtra("HscB", HscB);
                intent.putExtra("HscClg", HscClg);
                intent.putExtra("HscPer", HscPer);
                intent.putExtra("HscQYear", HscQYear);
                intent.putExtra("SslcB", SslcB);
                intent.putExtra("SslcClg", SslcClg);
                intent.putExtra("SslcPer", SslcPer);
                intent.putExtra("SslcQYear", SslcQYear);
                intent.putExtra("StuId", StuId);

                startActivity(intent);
                Toast.makeText(StudentTable.this, ListViewClickData.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void DisplayDataInToListView() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ StudentContact.StudentEntry.TABLE_NAME+"", null);

        Student student;
        StudentList = new ArrayList<Student>();

        if (cursor.moveToFirst()) {
            do {
                int nameColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_NAME);

                String tempName = cursor.getString(nameColumnIndex);

                int breedColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_USN);

                String tempNumber= cursor.getString(breedColumnIndex);

                int PhoneColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_CONTACT_NO);

                String tempPhoneNumber= cursor.getString(PhoneColumnIndex);

                int YearColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_YEAR);

                String tempYearNumber= cursor.getString(YearColumnIndex);

                int SemColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_SEM);

                String SemPhoneNumber= cursor.getString(SemColumnIndex);

                int AadharColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_AADHAR_NUMBER);

                String tempAadharNumber= cursor.getString(AadharColumnIndex);

                int FatherColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_NAME);

                String tempFatherName= cursor.getString(FatherColumnIndex);

                int MotherColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_NAME);

                String tempMotherName = cursor.getString(MotherColumnIndex);

                int CommAdColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_COMMUNICATION_ADDRESS);

                String tempCommAdd = cursor.getString(CommAdColumnIndex);

                int BloodColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_BLOOD_GROUP);

                String tempBlood = cursor.getString(BloodColumnIndex);

                int FatherNumColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_FATHER_CONTACT_NO);

                String tempFatherNum = cursor.getString(FatherNumColumnIndex);

                int MotherNumColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_MOTHER_CONTACT_NO);

                String tempMotherNum = cursor.getString(MotherNumColumnIndex);

                int HostelColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_HOSTEL_DAY);

                String tempHostel = cursor.getString(HostelColumnIndex);

                int DipBColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_DIP_BRANCH);

                String tempDipB = cursor.getString(DipBColumnIndex);

                int DipClgColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_DIP_CLG_NAME);

                String tempDipClg = cursor.getString(DipClgColumnIndex);

                int DipPerColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_DIP_PERCENTAGE);

                String tempDipPer = cursor.getString(DipPerColumnIndex);

                int DipQYearColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Dip);

                String tempDipQYear = cursor.getString(DipQYearColumnIndex);

                int HscBColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_HSC_BRANCH);

                String tempHscB = cursor.getString(HscBColumnIndex);

                int HscClgColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_HSC_CLG_NAME);

                String tempHscClg = cursor.getString(HscClgColumnIndex);

                int HscPerColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_HSC_PERCENTAGE);

                String tempHscPer = cursor.getString(HscPerColumnIndex);

                int HscQYearColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Hsc);

                String tempHscQYear = cursor.getString(HscQYearColumnIndex);

                int SslcBColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_BRANCH);

                String tempSslcB = cursor.getString(SslcBColumnIndex);

                int SslcClgColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_SCH_NAME);

                String tempSslcClg = cursor.getString(SslcClgColumnIndex);

                int SslcPerColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_STUDENT_SSLC_PERCENTAGE);

                String tempSslcPer = cursor.getString(SslcPerColumnIndex);

                int SslcQYearColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry.COLUMN_YEAR_QUAL_Sslc);

                String tempSslcQYear = cursor.getString(SslcQYearColumnIndex);

                int StuIdColumnIndex = cursor.getColumnIndex(StudentContact.StudentEntry._ID);

                String tempStuid = cursor.getString(StuIdColumnIndex);


                student = new Student(tempName, tempNumber, tempPhoneNumber,tempYearNumber,SemPhoneNumber,tempAadharNumber,tempFatherName,tempMotherName,
                        tempCommAdd,tempBlood,tempFatherNum,tempMotherNum,tempHostel,tempDipB,tempDipClg,tempDipPer,tempDipQYear,tempHscB,tempHscClg,tempHscPer,
                        tempHscQYear,tempSslcB,tempSslcClg,tempSslcPer,tempSslcQYear,tempStuid);

                StudentList.add(student);

            } while (cursor.moveToNext());
        }

        listAdapter = new list(StudentTable.this, R.layout.custom1, StudentList);

        listView.setAdapter(listAdapter);

        cursor.close();
    }

    @Override
    protected void onResume() {

        DisplayDataInToListView() ;

        super.onResume();

    }
}