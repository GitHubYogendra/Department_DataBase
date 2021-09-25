package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.department_database.data.DbHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    DbHelper db;
    SharedPreferences sharedPreferences;

    public static final String fileName = "login";
    public static final String UserInName = "userInName";
    public static final String Password = "password";
   TextInputLayout UserName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = (EditText) findViewById(R.id.UserName1);
        EditText password = (EditText) findViewById(R.id.password1);
        TextView click = (TextView) findViewById(R.id.forget);
        TextView logIn = (TextView) findViewById(R.id.button);
        TextView create = (TextView) findViewById(R.id.textView2);

        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(UserInName)){
            Intent intent = new Intent(getApplicationContext(),Main_Menu.class);
            startActivity(intent);
        }

        db = new DbHelper(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Create_Account.class);
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
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean check = db.checkPassword(Name, Pass);
                    if (check) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(UserInName,Name);
                        editor.putString(Password,Pass);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "log in Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, Main_Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "InCorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}