package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView Student = (TextView) findViewById(R.id.button3);
        TextView Faculty = (TextView) findViewById(R.id.button1);

        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentDetails.class);
                startActivity(intent);
            }
        });
        Faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FacultyDetails.class);
                startActivity(intent);
            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_for_main_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareOptionsMenu(Menu menu) {
            super.onPrepareOptionsMenu(menu);
            // If this is a new pet, hide the "Delete" menu item.
            MenuItem menuItem = menu.findItem(R.id.LogOut);
            menuItem.setVisible(true);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.LogOut:
                    Intent intent = new Intent(getApplicationContext(), Log_In.class);
                    startActivity(intent);
                    break;

            }
            return super.onOptionsItemSelected(item);

    }
}
