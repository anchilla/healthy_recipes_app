package com.example.healthyfoodapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ListOfRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_recipes);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
              actionBar.setTitle("Recipes");
        Intent intent = getIntent();
        int posNum;
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            posNum = bundle.getInt("pos");
            Log.v("RECYCLER intent", "Broj frag(posNum) je: " + posNum);

                 switch (posNum) {
                     case 0:

                         Recycler1Fragment fragment = new Recycler1Fragment();
                         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                         transaction.replace(R.id.fragment_container, fragment);
                         transaction.commit();
                         break;

                     case 1:

                         Recycler2Fragment fragment2 = new Recycler2Fragment();
                         FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                         transaction2.replace(R.id.fragment_container, fragment2);
                         transaction2.commit();
                         break;
                     case 2:

                         Recycler3Fragment fragment3 = new Recycler3Fragment();
                         FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                         transaction3.replace(R.id.fragment_container, fragment3);
                         transaction3.commit();
                         break;
                 }
        }
        else{
            Toast t=Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            t.show();
        }
    }
    //za Action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

           switch (item.getItemId()) {
        case R.id.all_recipes:
        Intent intent1 = new Intent(this, RecipesCategoryActivity.class);
        startActivity(intent1);
        return true;
        case R.id.favs:
        Intent intent2 = new Intent(this, Favorites.class);
        startActivity(intent2);
        return true;
        case R.id.my_rec:
        Intent intent3 = new Intent(this, WriteYourRecipeActivity.class);
        startActivity(intent3);
        return true;
        default:
        return super.onOptionsItemSelected(item);
    }

}
}