package com.example.mobileappdevelop.testmessmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userNameET, passwordET;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameET = (EditText) findViewById(R.id.userNameInputEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);

        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        editor = sharedPreferences.edit();


    }

    public void userNamePasswordSave() {
        String userName = userNameET.getText().toString();
        editor.putString("user", userName);

        String passWord = passwordET.getText().toString();
        editor.putString("password", passWord);

        editor.commit();
    }


    public void login(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        SharedPreferences sharedPreferences = getSharedPreferences("login",0);
        
       if(!sharedPreferences.getString("user","NotAPerson").equals("NotAPerson")){
           if (CheckLoginInfo()==true){
               startActivity(intent);
           }
           else{
               Toast.makeText(LoginActivity.this, "Wrong username and password", Toast.LENGTH_SHORT).show();
           }

       }
        else{ 
           userNamePasswordSave();
           startActivity(intent);
       }

    }

    public boolean CheckLoginInfo(){
        String userNameToBeMatched = sharedPreferences.getString("user", "not correct");
        String passWordToBeMatched = sharedPreferences.getString("password", "wrong password");
        String userName = userNameET.getText().toString();
        String passWord = passwordET.getText().toString();
        if(userNameToBeMatched.equals(userName) && passWordToBeMatched.equals(passWord)){
            return true;
        }
        else 
            return false;
    }

    
}

