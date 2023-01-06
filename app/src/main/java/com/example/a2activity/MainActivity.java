package com.example.a2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2activity.Database.DBHelper;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    Button btnlogin,btnsingup;
    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnsingup=findViewById(R.id.singbtn);
        btnlogin=findViewById(R.id.loginbtn);
        DB=new DBHelper(this);

        //admin and admin

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivity.this,"All fields Requierd",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),Secondactivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),Singup.class);
                startActivity(intent);

            }
        });



    }
}