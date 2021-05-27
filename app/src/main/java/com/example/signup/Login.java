package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
     private  EditText e1,e2;
     private Button b1;
     Databasehelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.email1);
        e2=findViewById(R.id.password1);
        b1=findViewById(R.id.btn);
        db=new Databasehelper(this);
    }

    public void loginup(View view) {
        String email=e1.getText().toString();
        String password=e2.getText().toString();
        Boolean Checkemailpass=db.emailpassword(email,password);
        if (Checkemailpass==true)
            Toast.makeText(getApplicationContext(),"successfully Login",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"wrong Email or password",Toast.LENGTH_SHORT).show();
    }
}