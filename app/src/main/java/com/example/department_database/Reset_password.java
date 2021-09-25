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

public class Reset_password extends AppCompatActivity {
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        EditText name = (EditText) findViewById(R.id.UserName1);
        EditText password = (EditText) findViewById(R.id.password1);
        EditText reEnter = (EditText) findViewById(R.id.ConfirmPassword1);
        TextView button = (TextView) findViewById(R.id.button1);
        db = new DbHelper(this);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("UserName"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = name.getText().toString();
                String pass = password.getText().toString();
                String repass = reEnter.getText().toString();
                if (uname.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(Reset_password.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean check = db.updatepasword(uname, pass);
                        if (check == true) {
                            Intent intent = new Intent(Reset_password.this, Log_In.class);
                            startActivity(intent);
                            Toast.makeText(Reset_password.this, "password updated successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Reset_password.this, "Password Not updated", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Reset_password.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}