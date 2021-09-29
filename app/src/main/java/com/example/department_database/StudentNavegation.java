package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StudentNavegation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_navegation);

        TextView Insert = (TextView) findViewById(R.id.button1);
        TextView Search = (TextView) findViewById(R.id.button3);
        TextView Read = (TextView) findViewById(R.id.button2);
        TextView update = (TextView) findViewById(R.id.button4);
        TextView All = (TextView) findViewById(R.id.button5);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentDetails.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchCato.class);
                startActivity(intent);
            }
        });
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchSQLiteActivity.class);
                Toast.makeText(StudentNavegation.this, "please click on item to read Student data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchSQLiteActivity.class);
                Toast.makeText(StudentNavegation.this, "please click on item to Update/Delete Student data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentTable.class);
                Toast.makeText(StudentNavegation.this, "please click on item to Update/Delete Student data", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}