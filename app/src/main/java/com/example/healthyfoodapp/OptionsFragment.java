package com.example.healthyfoodapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class OptionsFragment extends Fragment {


    public OptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_options, container, false);

        AdapterView.OnItemClickListener itemClickListener= (listView, view, position, id) -> {
            if(position==0) {
                Intent intent = new Intent(getContext(), RecipesCategoryActivity.class);
                startActivity(intent);
            }
            if(position==1){
                Intent intent=new Intent(getContext(), Favorites.class);
                startActivity(intent);
            }
            if(position==2){
                Intent intent= new Intent(getContext(), WriteYourRecipeActivity.class);
                startActivity(intent);
            }
        };
        ListView listView= v.findViewById(R.id.options_frag);
        listView.setOnItemClickListener(itemClickListener);

        return v;
    }

}
