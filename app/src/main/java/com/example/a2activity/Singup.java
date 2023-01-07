package com.example.a2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2activity.Database.DBHelper;

public class Singup extends AppCompatActivity {

    Button btnRegister;
    EditText username, password,mail,repassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        username=findViewById(R.id.username);
        mail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.repassword);
        btnRegister=findViewById(R.id.register);
        DB=new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  user=username.getText().toString();
                String email=mail.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(Singup.this,"All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser=DB.checkusername(user);
                        if(!checkuser){ //false deci nu e in baza de date
                            Boolean insert = DB.insertData(user,pass,email);
                            if(insert){ //s-a putut insera
                                Toast.makeText(Singup.this,"Registed Succesfully",Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Singup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Singup.this,"User already Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Singup.this,"Passwords are not matching",Toast.LENGTH_SHORT).show(); //asta trebuia sa fie mai intai verificata cred eu da e irelevent
                    }
                }



            }
        });
    }
}