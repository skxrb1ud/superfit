package com.example.superfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.superfit.recipes.RecipesActivity;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
    }
    public void onSeeAll(View view){
        Intent intent = new Intent(AppActivity.this,ExercisesActivity.class);
        startActivity(intent);
    }
    public void onRecipes(View view){
        Intent intent = new Intent(AppActivity.this, RecipesActivity.class);
        startActivity(intent);
    }
}