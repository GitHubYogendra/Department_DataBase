package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.department_database.data.DbHelper;
import com.google.android.material.textfield.TextInputLayout;

public class Log_In extends AppCompatActivity {
    DbHelper db;
    TextInputLayout UserName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        EditText name = (EditText) findViewById(R.id.UserName1);
        EditText password = (EditText) findViewById(R.id.password1);
        TextView click = (TextView) findViewById(R.id.forget);
        TextView logIn = (TextView) findViewById(R.id.button);
        TextView create = (TextView) findViewById(R.id.textView2);
        db = new DbHelper(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Create_Account.class);
                startActivity(intent);
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Forget_password.class);
                startActivity(intent);
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Pass = password.getText().toString();
                if (Name.equals("") || Pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean check = db.checkPassword(Name, Pass);
                    if (check) {
                        Toast.makeText(getApplicationContext(), "log in Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Log_In.this, Main_Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "InCorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
