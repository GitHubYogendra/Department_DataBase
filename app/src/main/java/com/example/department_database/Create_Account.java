package com.example.department_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.department_database.data.DbHelper;
import com.google.android.material.textfield.TextInputEditText;

public class Create_Account extends AppCompatActivity {
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        EditText name = (EditText) findViewById(R.id.UserName1);
        EditText password = (EditText) findViewById(R.id.password1);
        EditText RePassword = (EditText) findViewById(R.id.ConfirmPassword1);
        EditText Book = (EditText) findViewById(R.id.Ans1);
        TextView logIn = (TextView) findViewById(R.id.button1);
        db = new DbHelper(this);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Pass = password.getText().toString();
                String Repass = RePassword.getText().toString();
                String BookName = Book.getText().toString();
                if(Name.equals("")||Pass.equals("")||Repass.equals("")){
                    Toast.makeText(Create_Account.this, "Please enter all  the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if(Pass.equals(Repass)){
                        Boolean check = db.checkUsername(Name);
                        if(check== false){
                            Boolean insert1=  db.insertData(Name,Pass,BookName);
                            if(insert1== true){
                                Toast.makeText(Create_Account.this, "Registered Successfully Please Log in", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Create_Account.this,Log_In.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Create_Account.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Create_Account.this, "user already exits! Please Log in", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Create_Account.this,Log_In.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(Create_Account.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}