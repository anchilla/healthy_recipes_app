package com.example.healthyfoodapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMyRecFragment extends Fragment {

    DatabaseRecipes dataB;
    String nameText;
    int photoId;
    String ingredientsText;
    String instructionsText;

    public DetailMyRecFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail1, container, false);
        int idFrag;

        assert getArguments() != null;
        idFrag = getArguments().getInt("idList");
        Log.v("DETAIL FRAG", "idFrag je: " + idFrag);

        dataB = new DatabaseRecipes(getContext());
        try {
            SQLiteOpenHelper foodDatabaseHelper = new DatabaseRecipes(getContext());
            SQLiteDatabase db = foodDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query("MY_FOOD_RECIPES",
                    new String[]{"NAME", "IMAGE_RESOURCE_ID", "INGREDIENTS", "INSTRUCTIONS",
                            "FAVORITE"},
                    "_id=?",
                    new String[]{Integer.toString(idFrag)},
                    null, null, null, null);

            if (cursor.moveToFirst()) {
                nameText = cursor.getString(0);
                photoId = cursor.getInt(1);
                ingredientsText = cursor.getString(2);
                instructionsText = cursor.getString(3);
                boolean check = (cursor.getInt(4) < 1);

                TextView name = view.findViewById(R.id.food_title);
                name.setText(nameText);

                ImageView photo =  view.findViewById(R.id.food_image);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                TextView ingredients = view.findViewById(R.id.ingredients);
                ingredients.setText(ingredientsText);

                TextView instructions =  view.findViewById(R.id.instructions);
                instructions.setText(instructionsText);

                CheckBox favorite = view.findViewById(R.id.favorite);
                favorite.setChecked(!check);
                favorite.setOnClickListener(v -> {

                    ContentValues foodValues = new ContentValues();
                    foodValues.put("FAVORITE", favorite.isChecked());
                    SQLiteOpenHelper foodHelper = new DatabaseRecipes(getContext());

                    try {
                        SQLiteDatabase db1 = foodHelper.getWritableDatabase();
                        db1.update("MY_FOOD_RECIPES", foodValues,
                                "_id = ?",
                                new String[]{Integer.toString(idFrag)});

                        if(favorite.isChecked()) {
                            dataB.insertFavorites(db1, nameText, photoId, ingredientsText, instructionsText, true);
                            Log.v("MYREC FRAG ", "ubaci u favorite: "+nameText);
                            Toast t=Toast.makeText(getContext(), "Added to favortes", Toast.LENGTH_SHORT);
                            t.show();
                        } else {
                            Log.v("MYREC FRAG ", "ime recepta za brisanje je: " + nameText);
                            dataB.deleteFavorite(nameText);
                        }

                        db1.close();

                    } catch (SQLiteException e) {
                        Toast toast = Toast.makeText(getContext(), "Not inserted", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                );

            }

            cursor.close();
            db.close();
        } catch (SQLException e) {
            Toast toast = Toast.makeText(getContext(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        return view;

    }
}