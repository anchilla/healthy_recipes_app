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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Recycler3Fragment extends Fragment {

    private List<Recipe> myRec;
    int brojFrag;

    public Recycler3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView thiredRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recycler1, container, false);


        myRec = new ArrayList<>();
        DatabaseRecipes databaseR = new DatabaseRecipes(getActivity());
        brojFrag=3;


        myRec = databaseR.getMyRec();
        RecyclerAdapter adapter4 = new RecyclerAdapter(myRec);
        if (myRec != null && myRec.isEmpty()) {
            Toast toast = Toast.makeText(getContext(), "No recipes yet", Toast.LENGTH_SHORT);
            toast.show();
        }
        RecyclerView recyclerV = thiredRecycler.findViewById(R.id.food_recycler);
        recyclerV.setAdapter(adapter4);
        GridLayoutManager layoutManager4 = new GridLayoutManager(getContext(), 2);
        recyclerV.setLayoutManager(layoutManager4);

        adapter4.setListener(position -> {
            Intent intent = new Intent(getContext(), DetailRecipeActivity.class);
            int id = myRec.get(position).getId();
            intent.putExtra("id", id);
            intent.putExtra("broj fragmenta", brojFrag);
            Log.v("RECYCLER", "POSITION JE: " + position);
            startActivity(intent);
        });

        return thiredRecycler;
    }
}