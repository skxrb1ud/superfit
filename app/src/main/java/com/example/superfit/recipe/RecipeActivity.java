package com.example.superfit.recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.superfit.R;
import com.example.superfit.common.Recipe;

public class RecipeActivity extends AppCompatActivity {
    TextView name;
    TextView kzbu;
    TextView kcal;
    Recipe recipe;
    ImageView image;
    RecyclerView ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Intent intent = getIntent();
        name = findViewById(R.id.name);
        kzbu = findViewById(R.id.kzbu);
        image = findViewById(R.id.imageView);
        kcal = findViewById(R.id.kcal);
        recipe = intent.getParcelableExtra("recipe");
        name.setText(recipe.getName());
        kzbu.setText(recipe.getKzbu());
        kcal.setText(recipe.getKcal());
        ingredients = findViewById(R.id.ingredients);
        ingredients.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        ingredients.setAdapter(new IngredientsAdapter(this,recipe.getIngredients()));
        Glide
                .with(this)
                .load(recipe.getThumb())
                .into(image);
    }

    public void onBack(View view){
        finish();
    }
}