package com.example.superfit.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import com.example.superfit.R;
import com.example.superfit.common.Api;
import com.example.superfit.common.PRunnable;
import com.example.superfit.common.Recipe;

import java.util.Timer;
import java.util.TimerTask;

public class RecipesActivity extends AppCompatActivity {
    ToggleButton balanced;
    ToggleButton highProtein;
    ToggleButton highFiber;
    RecyclerView recipes;
    EditText q;
    Timer timer;
    String diet;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        balanced = findViewById(R.id.balanced);
        highProtein = findViewById(R.id.high_protein);
        highFiber = findViewById(R.id.high_fiber);
        recipes = findViewById(R.id.recipes);
        q = findViewById(R.id.q);
        progress = findViewById(R.id.progress);
        recipes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        q.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                startTimer(4000);
            }
        });
        loadData();
    }
    public void startTimer(long delay){
        if(timer != null){
            timer.cancel();
        }
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                    }
                });

            }
        };
        timer.schedule(task,delay);
    }
    public void onChangeDiet(View view){
        if(view != balanced)
            balanced.setChecked(false);
        if(view != highProtein)
            highProtein.setChecked(false);
        if(view != highFiber)
            highFiber.setChecked(false);
        startTimer(0);
    }
    public void loadData(){

        String diet = "";
        if(balanced.isChecked())
            diet = "balanced";
        if(highFiber.isChecked())
            diet = "low-fat";
        if(highProtein.isChecked())
            diet = "high-protein";
        Api.searchRecipes(this,q.getText().toString(), diet, new PRunnable<Recipe[]>() {
            @Override
            public void run(Recipe[] data) {
                recipes.setAdapter(new RecipesAdapter(RecipesActivity.this,data));
                progress.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void onBack(View view){
        finish();
    }
}