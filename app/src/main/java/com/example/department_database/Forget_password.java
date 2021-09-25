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

public class Forget_password extends AppCompatActivity {
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        EditText Book = (EditText) findViewById(R.id.Ans1);
        EditText name = (EditText) findViewById(R.id.UserName1);
        TextView reset = (TextView) findViewById(R.id.button1);
        db = new DbHelper(this);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String bookName = Book.getText().toString();
                if(userName.equals("")||bookName.equals("")){
                    Toast.makeText(Forget_password.this, "please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean check = db.checkNameBook(userName,bookName);
                    if(check == true){
                        Intent intent = new Intent(getApplicationContext(),Reset_password.class);
                        intent.putExtra("UserName",userName);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Forget_password.this, "InCorrect Enter", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}