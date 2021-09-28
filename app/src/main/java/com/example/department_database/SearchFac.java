package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SearchFac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_fac);

        TextView Name = (TextView) findViewById(R.id.button3);
        TextView USN = (TextView) findViewById(R.id.button1);
        TextView YEAR = (TextView) findViewById(R.id.button2);

        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFaculty.class);
                startActivity(intent);
            }
        });
        USN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFaculty.class);
                startActivity(intent);
            }
        });
        YEAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFaculty.class);
                startActivity(intent);
            }
        });

    }
}