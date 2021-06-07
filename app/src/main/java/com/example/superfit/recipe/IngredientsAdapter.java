package com.example.superfit.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superfit.R;
import com.example.superfit.common.Recipe;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {
    String[] data;
    public IngredientsAdapter(Context context, String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ingredients_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.content.setText(data[position]);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.text);
        }
    }

}
