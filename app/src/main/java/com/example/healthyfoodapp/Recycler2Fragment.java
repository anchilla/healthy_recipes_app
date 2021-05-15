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


public class Recycler2Fragment extends Fragment {

    private List<Recipe> recipeS;
    int brojFrag;


    public Recycler2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView secondRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recycler1, container, false);

        recipeS = new ArrayList<>();
        DatabaseRecipes databaseR = new DatabaseRecipes(getActivity());
        brojFrag=2;

        recipeS = databaseR.getSweet();
        RecyclerAdapter adapter1 = new RecyclerAdapter(recipeS);
        RecyclerView recyclerV = secondRecycler.findViewById(R.id.food_recycler);
        recyclerV.setAdapter(adapter1);
        GridLayoutManager layoutManager1 = new GridLayoutManager(getContext(), 2);
        recyclerV.setLayoutManager(layoutManager1);

        adapter1.setListener(position -> {
            Intent intent = new Intent(getContext(), DetailRecipeActivity.class);
            int id = recipeS.get(position).getId();
            intent.putExtra("id", id);
            intent.putExtra("broj fragmenta", brojFrag);
            Log.v("RECYCLER", "POSITION JE: " + position);
            startActivity(intent);
        });

        return secondRecycler;
    }
}