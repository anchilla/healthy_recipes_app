package com.example.healthyfoodapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class CategoryFragment extends Fragment {

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_category, container, false);

        AdapterView.OnItemClickListener itemClickListener= (listView, view, position, id) -> {
            if(position==0) {

                Intent intent = new Intent(getContext(), ListOfRecipes.class);

                intent.putExtra("pos", position);
                startActivity(intent);
            }
            if(position==1){

                Intent intent= new Intent(getContext(), ListOfRecipes.class);
                intent.putExtra("pos", position);
                Log.v("IZ LISTE", "intent je: "+position);
                startActivity(intent);
            }
            if(position==2){

                Intent intent= new Intent(getContext(), ListOfRecipes.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        };
        ListView listView= v.findViewById(R.id.category_list);
        listView.setOnItemClickListener(itemClickListener);

        return v;
    }

}
