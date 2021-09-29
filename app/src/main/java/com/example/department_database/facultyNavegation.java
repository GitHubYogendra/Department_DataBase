package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class facultyNavegation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_navegation);

        TextView Insert = (TextView) findViewById(R.id.button1);
        TextView Search = (TextView) findViewById(R.id.button3);
        TextView Read = (TextView) findViewById(R.id.button2);
        TextView update = (TextView) findViewById(R.id.button4);
        TextView All = (TextView) findViewById(R.id.button5);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FacultyDetails.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFac.class);
                startActivity(intent);
            }
        });
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFaculty.class);
                Toast.makeText(facultyNavegation.this, "please click on item to read faculty data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFaculty.class);
                Toast.makeText(facultyNavegation.this, "please click on item to Update/Delete faculty data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FacultyTable.class);
                Toast.makeText(facultyNavegation.this, "please click on item to Update/Delete Student data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}