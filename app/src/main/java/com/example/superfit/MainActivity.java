package com.example.superfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    boolean back = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        back = true;
    }

    private void timer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            launch();
                        }
                    });
                }catch (Exception e){

                }

            }
        }).start();
    }

    private void launch(){
        if(!back){
            Intent intent = new Intent(this,AppActivity.class);
            startActivity(intent);
            finish();
        }

    }
}