package com.example.superfit.recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.superfit.R;
import com.example.superfit.common.Recipe;
import com.example.superfit.recipe.RecipeActivity;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    private Recipe[] data;
    private Context context;
    public RecipesAdapter(Context context,Recipe[] array){
        data = array;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe r = data[position];
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,RecipeActivity.class);
                intent.putExtra("recipe",r);
                context.startActivity(intent);
            }
        });
        holder.name.setText(r.getName());
        holder.kcal.setText(r.getKcal());
        holder.kzbu.setText(r.getKzbu());
        Glide
                .with(context)
                .load(r.getThumb())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView kcal;
        TextView kzbu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            kcal = itemView.findViewById(R.id.kcal);
            kzbu = itemView.findViewById(R.id.kzbu);
        }
    }
}
