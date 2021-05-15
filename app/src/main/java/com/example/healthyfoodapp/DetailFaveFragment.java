package com.example.healthyfoodapp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFaveFragment extends Fragment {

    DatabaseRecipes dataB;
    String nameText;
    int photoId;
    String ingredientsText;
    String instructionsText;

    public DetailFaveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fave_detail, container, false);
        Log.v("DETAIL FRAG", "onCreateView");

        int idFrag;
        String nameIntent;
        assert getArguments() != null;
        idFrag = getArguments().getInt("idList");
        nameIntent= getArguments().getString("Name");
        Log.v("DETAIL FRAG", "idFrag je: " + idFrag);
        Log.v("DETAIL FRAG", "name je: " + nameIntent);

        dataB = new DatabaseRecipes(getContext());
        try {
            SQLiteOpenHelper foodDatabaseHelper = new DatabaseRecipes(getContext());
            SQLiteDatabase db = foodDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query("FAVORITES",
                    new String[]{"NAME", "IMAGE_RESOURCE_ID", "INGREDIENTS", "INSTRUCTIONS",
                            "FAVORITE"},
                    "NAME=?",
                    new String[]{nameIntent},
                    null, null, null, null);

            if (cursor.moveToFirst()) {
                nameText = cursor.getString(0);
                photoId = cursor.getInt(1);
                ingredientsText = cursor.getString(2);
                instructionsText = cursor.getString(3);

                TextView name = view.findViewById(R.id.food_title);
                name.setText(nameText);

                ImageView photo = view.findViewById(R.id.food_image);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                TextView ingredients = view.findViewById(R.id.ingredients);
                ingredients.setText(ingredientsText);

                TextView instructions = view.findViewById(R.id.instructions);
                instructions.setText(instructionsText);

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