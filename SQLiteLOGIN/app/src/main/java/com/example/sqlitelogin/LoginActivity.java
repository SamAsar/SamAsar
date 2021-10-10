package com.example.sqlitelogin;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button signin;
  DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= (EditText) findViewById(R.id.username1);
        password= (EditText) findViewById(R.id.password1);
        signin=(Button) findViewById(R.id.btnsignin1);

DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Kindly enter your details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean chekuserpass = DB.checkusernamepassword(user,pass);
                    if (chekuserpass==true){
                        Toast.makeText(LoginActivity.this, "signed in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }


}