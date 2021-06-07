package com.example.superfit.common;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Api {
    public static void searchRecipes(Context context, String q, String diet, PRunnable<Recipe[]> callback){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://api.edamam.com/search?q="+q+"&app_id=4da5a427&app_key=6dd6f99730da1737e964379d886e607d";
        if(!diet.equals(""))
            url += "&diet="+diet;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray array = response.getJSONArray("hits");
                    Recipe[] recipes = new Recipe[array.length()];
                    for(int i = 0; i < recipes.length;i++){
                        JSONObject recipe = array.getJSONObject(i).getJSONObject("recipe");
                        recipes[i] = new Recipe();
                        recipes[i].setName(recipe.getString("label"));
                        JSONObject nut = recipe.getJSONObject("totalNutrients");
                        recipes[i].setKcal(String.format("%.0f kcal",recipe.getDouble("calories")));
                        double protein = nut.getJSONObject("PROCNT").getDouble("quantity");
                        double fat = nut.getJSONObject("FAT").getDouble("quantity");
                        double carbs = nut.getJSONObject("CHOCDF").getDouble("quantity");
                        recipes[i].setThumb(recipe.getString("image"));
                        recipes[i].setKzbu(String.format("%.0fg protein • %.0fg fat • %.0fg carbs",protein,fat,carbs));
                        JSONArray ing = recipe.getJSONArray("ingredientLines");
                        String[] ingredientLines = new String[ing.length()];
                        for(int j = 0; j < ingredientLines.length;j++){
                            ingredientLines[j] = ing.getString(j);
                        }
                        recipes[i].setIngredients(ingredientLines);
                    }
                    callback.run(recipes);
                }catch (Exception e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}
