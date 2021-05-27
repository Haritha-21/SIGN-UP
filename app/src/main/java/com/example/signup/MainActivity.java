package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    Databasehelper db;
    private EditText e1, e2, e3;
    private Button b1, b2;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Databasehelper(this);
        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.password);
        e3 = findViewById(R.id.conformpass);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);


    }

    public void login(View view) {
        // createmd5(s);
        String email = e1.getText().toString();
        String pass = e2.getText().toString();
        //String pass = createmd5(e2.getText().toString());
        String repass = e3.getText().toString();
        // String repass= createmd5(e3.getText().toString());
        if (email.equals("") || pass.equals("") || repass.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            if (pass.equals(repass)) {
                Boolean checkemail = db.checkemail(email);
                if (checkemail == true) {
                    Boolean insert = db.insert(email, pass);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                }
            }
            Toast.makeText(getApplicationContext(), "password do not match", Toast.LENGTH_SHORT).show();
        }

    }
    
    public void nxtlogin(View view) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }

}