package com.example.superfit.common;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipe implements Parcelable {
    private String name;
    private String kcal;
    private String kzbu;
    private String thumb;

    public Recipe(){

    }
    protected Recipe(Parcel in) {
        name = in.readString();
        kcal = in.readString();
        kzbu = in.readString();
        thumb = in.readString();
        ingredients = in.createStringArray();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    private String[] ingredients;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getKzbu() {
        return kzbu;
    }

    public void setKzbu(String kzbu) {
        this.kzbu = kzbu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(kcal);
        dest.writeString(kzbu);
        dest.writeString(thumb);
        dest.writeStringArray(ingredients);
    }
}
