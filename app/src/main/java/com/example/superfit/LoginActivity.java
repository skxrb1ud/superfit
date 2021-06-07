package com.example.superfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
    }
    public void onSignInClick(View view){
        Intent intent = new Intent(this,SignInActivity.class);
        intent.putExtra("login",login.getText().toString());
        startActivity(intent);
    }
    public void onSignUpClick(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}