package com.example.healthyfoodapp;


import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Favorites extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;
    String name;
    int brojFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
             actionBar.setTitle("Favorites");
        brojFrag=4;
        ListView listFavorites=findViewById(R.id.list_favorites);
        try{
            SQLiteOpenHelper recipesHelper=new DatabaseRecipes(this);
            db=recipesHelper.getReadableDatabase();
            favoritesCursor=db.query("FAVORITES",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            CursorAdapter favoriteAdapter=new SimpleCursorAdapter(Favorites.this,
                    android.R.layout.simple_list_item_2,
                    favoritesCursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1}, 0);
            Log.v("FAVORITES", "cursor ima: " + favoriteAdapter.getCount());

            listFavorites.setAdapter(favoriteAdapter);
            if(favoritesCursor.getCount()==0){
                Toast toast = Toast.makeText(this, "No favorites yet", Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch(SQLiteException e){

            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        listFavorites.setOnItemClickListener((parent, view, position, id) -> {
            name=favoritesCursor.getString(favoritesCursor.getColumnIndex("NAME"));
            Intent intent = new Intent(Favorites.this, DetailRecipeActivity.class);
            intent.putExtra("Name", name);
            intent.putExtra("broj fragmenta", brojFrag);
            intent.putExtra("idFave", position);
            startActivity(intent);
        });
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(favoritesCursor!=null) {
            favoritesCursor.close();
            db.close();
        }else
            db.close();

    }

    public void onRestart() {
        super.onRestart();
        try {
            DatabaseRecipes databaseRecipes = new DatabaseRecipes(this);
            db=databaseRecipes.getReadableDatabase();

            Cursor newFavorites=db.query("FAVORITES",
                    new String[]{"_id", "NAME"},
                    null, null, null, null,null);

            Log.v("FAVORITES", "novi cursor ima: " + newFavorites.getCount());
            ListView listFavorites = findViewById(R.id.list_favorites);
            CursorAdapter adapter=(CursorAdapter) listFavorites.getAdapter();
            adapter.changeCursor(newFavorites);
            favoritesCursor=newFavorites;
        }catch (SQLException e){
            Toast toast = Toast.makeText(this, "No favorites yet", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //za ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_others, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent=new Intent(this, RecipesCategoryActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);

    }


}
