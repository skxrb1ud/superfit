package com.example.superfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class SignInActivity extends AppCompatActivity {
    GridLayout grid;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        grid = findViewById(R.id.buttons);
        login = findViewById(R.id.login);
        login.setText(getIntent().getStringExtra("login"));
        regenerateButtons();
    }
    private void regenerateButtons(){
        grid.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        int[] array = new int[9];
        for(int i = 0; i < 9;i++){
            array[i] = i+1;
        }
        Random r = new Random();
        for(int i = 0; i < 9;i++){
            int temp = array[i];
            int index = r.nextInt(9);
            array[i] = array[index];
            array[index] = temp;
        }
        for(int i = 0; i < 9;i++){
            Button button = (Button) inflater.inflate(R.layout.sign_in_button,grid,false);
            button.setText(String.valueOf(array[i]));
            grid.addView(button);
        }
    }
}