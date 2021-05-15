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


public class DetailRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);

        Intent intent = getIntent();
        int idList = intent.getIntExtra("id", 0);
        int brojFragmenta = intent.getIntExtra("broj fragmenta", 0);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("Recipe");

        switch (brojFragmenta) {
            case 0:
                Toast t = Toast.makeText(this, "default value", Toast.LENGTH_SHORT);
                t.show();
                break;
            case 1:
                Detail1Fragment fragment = new Detail1Fragment();
                Bundle bundle = new Bundle();
                bundle.putInt("idList", idList);

                fragment.setArguments(bundle);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_detail_container, fragment);
                transaction.commit();
                break;
            case 2:
                DetailSweetFragment fragmentSweet = new DetailSweetFragment();
                Bundle bundleSweet = new Bundle();
                bundleSweet.putInt("idList", idList);

                fragmentSweet.setArguments(bundleSweet);
                FragmentTransaction transactionSweet = getSupportFragmentManager().beginTransaction();
                transactionSweet.replace(R.id.fragment_detail_container, fragmentSweet);
                transactionSweet.commit();
                break;
            case 3:
                DetailMyRecFragment fragmentMyRec = new DetailMyRecFragment();
                Bundle bundleMyRec = new Bundle();
                bundleMyRec.putInt("idList", idList);

                fragmentMyRec.setArguments(bundleMyRec);
                FragmentTransaction transactionMyRec = getSupportFragmentManager().beginTransaction();
                transactionMyRec.replace(R.id.fragment_detail_container, fragmentMyRec);
                transactionMyRec.commit();
                break;
            case 4:
                int idFave;
                String name;
                Bundle bundleFave = intent.getExtras();
                if (bundleFave != null) {
                    idFave = bundleFave.getInt("idFave");
                    name = bundleFave.getString("Name");
                    Log.v("FAVORITES", "intent name je: " + name);
                    bundleFave.putInt("idList", idFave + 1);
                    bundleFave.putString("Name", name);
                }

                DetailFaveFragment fragmentFave = new DetailFaveFragment();
                fragmentFave.setArguments(bundleFave);
                FragmentTransaction transactionFave = getSupportFragmentManager().beginTransaction();
                transactionFave.replace(R.id.fragment_detail_container, fragmentFave);
                transactionFave.commit();
                break;

        }
    }

    //za ActionBar
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
                Intent intent = new Intent(this, RecipesCategoryActivity.class);
                startActivity(intent);
                return true;
            case R.id.favs:
                Intent intent2 = new Intent(this, Favorites.class);
                startActivity(intent2);
                return true;
            case R.id.my_rec:
                Intent intent3 = new Intent(this, WriteYourRecipeActivity.class);
                startActivity(intent3);
                return true;
            case R.id.home:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}