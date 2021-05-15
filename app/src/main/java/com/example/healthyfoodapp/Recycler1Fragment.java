package com.example.healthyfoodapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Recycler1Fragment extends Fragment {

    private List<Recipe> recipeL;
    int brojFrag;

    public Recycler1Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView firstRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recycler1, container, false);

        recipeL = new ArrayList<>();
        DatabaseRecipes databaseR = new DatabaseRecipes(getActivity());
        brojFrag=1;

        recipeL = databaseR.getAllRecipes();
        RecyclerAdapter adapter = new RecyclerAdapter(recipeL);
        RecyclerView recyclerV = firstRecycler.findViewById(R.id.food_recycler);

        recyclerV.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerV.setLayoutManager(layoutManager);

        adapter.setListener(position -> {
            Intent intent = new Intent(getContext(), DetailRecipeActivity.class);
            int id = recipeL.get(position).getId();
            intent.putExtra("id", id);
            intent.putExtra("broj fragmenta", brojFrag);
            Log.v("RECYCLER SLIKA", "id je: " + id);
            Log.v("RECYCLER", "POSITION JE: " + position);
            startActivity(intent);
        });
    return firstRecycler;
    }
}