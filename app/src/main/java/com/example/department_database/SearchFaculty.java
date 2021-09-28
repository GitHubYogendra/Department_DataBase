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

import com.example.department_database.data.DBHealperFaculty;
import com.example.department_database.data.TeacherContact;

import java.util.ArrayList;


public class SearchFaculty extends AppCompatActivity {
    ListView listView1;
    ArrayList<Faculty> FacultyList = new ArrayList<Faculty>();
    ListAdapter1 listAdapter1;
    DBHealperFaculty sqLiteHelper1;
    EditText editText1;
    SQLiteDatabase sqLiteDatabase1;
    Cursor cursor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_faculty);
        listView1 = (ListView) findViewById(R.id.listView2);

        editText1 = (EditText) findViewById(R.id.edittext2);

        listView1.setTextFilterEnabled(true);

        sqLiteHelper1 = new DBHealperFaculty(this);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchFaculty.this, EditorFaculty.class);
                Faculty ListViewClickData = (Faculty) parent.getItemAtPosition(position);

                String name = ListViewClickData.getFname();
                String Fid = ListViewClickData.getFId();
                String phone1 = ListViewClickData.getFphoneNumber1();
                String phone2 = ListViewClickData.getFphoneNumber2();
                String CommAdd = ListViewClickData.getFCommAdd();
                String Adhar = ListViewClickData.getFAadharNum();
                String phd = ListViewClickData.getFPhd1();
                String phdClgName = ListViewClickData.getFPhdClgName();
                String phdQYear = ListViewClickData.getFPhdYear();
                String phdPer = ListViewClickData.getFPhdPer();
                String me = ListViewClickData.getFME1();
                String meClgName = ListViewClickData.getFMeClgName();
                String meQYear = ListViewClickData.getFMeyear();
                String mePer = ListViewClickData.getFMePer();
                String Be = ListViewClickData.getFBe1();
                String BeClgName = ListViewClickData.getFBeClgName();
                String BeQYear = ListViewClickData.getFBeYear();
                String BePer = ListViewClickData.getFBePer();
                String Hsc = ListViewClickData.getFHsc1();
                String HscClgName = ListViewClickData.getFHscClgName();
                String HscQYear = ListViewClickData.getFHscYear();
                String HscPer = ListViewClickData.getFHscPer();
                String Sslc = ListViewClickData.getFSslc1();
                String SslcSchName = ListViewClickData.getFSslcClgName();
                String SslcQYear = ListViewClickData.getFSslcYear();
                String SslcPer = ListViewClickData.getFSslcPer();
                String Award = ListViewClickData.getFAward();
                String Academic = ListViewClickData.getFAcademic();
                String Industry = ListViewClickData.getFIndstry();
                String Member = ListViewClickData.getFMember();
                String FUnique = ListViewClickData.getFUnique();
                String FDep = ListViewClickData.getFDepa();

                intent.putExtra("FName",name);
                intent.putExtra("Fid",Fid);
                intent.putExtra("PhoneNo1",phone1);
                intent.putExtra("PhoneNo2",phone2);
                intent.putExtra("ComAdd",CommAdd);
                intent.putExtra("Adar",Adhar);
                intent.putExtra("phd",phd);
                intent.putExtra("phdClg",phdClgName);
                intent.putExtra("phdYear",phdQYear);
                intent.putExtra("phdPer",phdPer);
                intent.putExtra("me",me);
                intent.putExtra("meClg",meClgName);
                intent.putExtra("meYear",meQYear);
                intent.putExtra("mePer",mePer);
                intent.putExtra("Be",Be);
                intent.putExtra("BeClg",BeClgName);
                intent.putExtra("Beyear",BeQYear);
                intent.putExtra("BePer",BePer);
                intent.putExtra("Hsc",Hsc);
                intent.putExtra("HscClg",HscClgName);
                intent.putExtra("HscYear",HscQYear);
                intent.putExtra("HscPer",HscPer);
                intent.putExtra("Sslc",Sslc);
                intent.putExtra("SslcSch",SslcSchName);
                intent.putExtra("SslcYear",SslcQYear);
                intent.putExtra("SslcPer",SslcPer);
                intent.putExtra("Award",Award);
                intent.putExtra("Academic",Academic);
                intent.putExtra("Industry",Industry);
                intent.putExtra("Member",Member);
                intent.putExtra("FUniqe",FUnique);
                intent.putExtra("FDep",FDep);

                startActivity(intent);
                Toast.makeText(SearchFaculty.this, ListViewClickData.getFname(), Toast.LENGTH_SHORT).show();
            }
        });


        editText1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence stringVar, int start, int before, int count) {

                listAdapter1.getFilter().filter(stringVar.toString());
            }
        });

    }

    public void DisplayDataInToListView() {

        sqLiteDatabase1 = sqLiteHelper1.getWritableDatabase();

        cursor1 = sqLiteDatabase1.rawQuery("SELECT * FROM "+ TeacherContact.TeacherEntry.TABLE_NAME+"", null);

        Faculty faculty;
        FacultyList = new ArrayList<Faculty>();

        if (cursor1.moveToFirst()) {
            do {

                int nameColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_NAME);

                String tempName = cursor1.getString(nameColumnIndex);

                int idColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_ID);

                String tempid = cursor1.getString(idColumnIndex);

                int phone1ColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO1);

                String tempNumber1= cursor1.getString(phone1ColumnIndex);

                int phone2ColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_CONTECT_NO2);

                String tempNumber2= cursor1.getString(phone2ColumnIndex);

                int CommAdressColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_COMMUNICATION_ADDRESS);

                String tempcom = cursor1.getString(CommAdressColumnIndex);

                int AadharColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_AADHAR_NUMBER);

                String tempAadhar= cursor1.getString(AadharColumnIndex);

                int phdColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD);

                String tempphd = cursor1.getString(phdColumnIndex);

                int phdYearColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_QUAL_YEAR);

                String tempyear= cursor1.getString(phdYearColumnIndex);

                int phdclgColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_Clg_NAME);

                String tempphdClg = cursor1.getString(phdclgColumnIndex);

                int phdPerColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PHD_PER);

                String tempPhdPer = cursor1.getString(phdPerColumnIndex);

                int meColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME);

                String tempme = cursor1.getString(meColumnIndex);

                int meyearColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_QUAL_YEAR);

                String tempmeYear= cursor1.getString(meyearColumnIndex);

                int meClgColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_CLG_NAME);

                String tempmeClg = cursor1.getString(meClgColumnIndex);

                int mePerColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_ME_PER);

                String tempmePer = cursor1.getString(mePerColumnIndex);

                int BeColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE);

                String tempBe = cursor1.getString(BeColumnIndex);

                int BeClgColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_CLG_NAME);

                String tempBeClg = cursor1.getString(BeClgColumnIndex);

                int BeYearColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_QUAL_YEAR);

                String tempBeYear = cursor1.getString(BeYearColumnIndex);

                int BePerColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_BE_PER);

                String tempBePer = cursor1.getString(BePerColumnIndex);

                int HscColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC);

                String tempHsc = cursor1.getString(HscColumnIndex);

                int HscClgColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_CLG_NAME);

                String tempHscClg = cursor1.getString(HscClgColumnIndex);

                int HscYearColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_QUL_YEAR);

                String tempHscYear = cursor1.getString(HscYearColumnIndex);

                int HscPerColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_HSC_PER);

                String tempHscPer = cursor1.getString(HscPerColumnIndex);

                int sslcColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC);

                String tempsslc= cursor1.getString(sslcColumnIndex);

                int SslcClgColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_SCH_NAME);

                String tempSslcclg = cursor1.getString(SslcClgColumnIndex);

                int SslcYearColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_QUAL_YEAR);

                String tempSslcYear = cursor1.getString(SslcYearColumnIndex);

                int SslcPerColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_SSLC_PERCENTAGE);

                String tempSslcPer = cursor1.getString(SslcPerColumnIndex);

                int AwardColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_AWARDS);

                String tempAward = cursor1.getString(AwardColumnIndex);

                int memberColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_PUBLICATION_MEMBERSHIP);

                String tempmember = cursor1.getString(memberColumnIndex);

                int industryColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_INDUSTRY);

                String tempInd = cursor1.getString(industryColumnIndex);

                int AcamedicColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_EXEPERIENCE_ACADEMIC);

                String tempAcar= cursor1.getString(AcamedicColumnIndex);

                int FuniqueColumnIndex = cursor1.getColumnIndex(TeacherContact.TeacherEntry._ID);

                String tempFUnic= cursor1.getString(FuniqueColumnIndex);

                int FDepa = cursor1.getColumnIndex(TeacherContact.TeacherEntry.COLUMN_FACULTY_Dep);

                String tempFDep= cursor1.getString(FDepa);

                faculty = new Faculty(tempName, tempid,tempNumber1,tempNumber2,tempcom,tempAadhar,tempphd,tempyear,tempphdClg,tempPhdPer,
                       tempme,tempmeYear,tempmeClg,tempmePer,tempBe,tempBeClg,tempBeYear,tempBePer,tempHsc,tempHscClg,tempHscYear,tempHscPer,
                        tempsslc,tempSslcclg,tempSslcYear,tempSslcPer,tempAward,tempmember,tempInd,tempAcar,tempFUnic,tempFDep);

                FacultyList.add(faculty);

            } while (cursor1.moveToNext());
        }

        listAdapter1 = new ListAdapter1(SearchFaculty.this, R.layout.custom_layout, FacultyList);

        listView1.setAdapter(listAdapter1);

        cursor1.close();
    }

    @Override
    protected void onResume() {

        DisplayDataInToListView() ;

        super.onResume();
    }
}