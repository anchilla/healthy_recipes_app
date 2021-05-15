package com.example.healthyfoodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    private ListView drawerList;

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    //za Drawer
    private class DrawerClickListenerI implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            selectItem(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);

        textView=findViewById(R.id.text_dugme);
        textView.setOnClickListener(this);

        String[] categories = getResources().getStringArray(R.array.category_food_list);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.drawer);
        drawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, categories));

        drawerList.setOnItemClickListener(new MainActivity.DrawerClickListenerI());

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.open_drawer, R.string.close_drawer) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);

    }

    //za drawer
    private void selectItem(int position) {

        switch(position) {
            case 0:
                Intent intent = new Intent(this, ListOfRecipes.class);
                intent.putExtra("pos", position);
                startActivity(intent);
                break;
            case 1:

                int positio=1;
                Intent intent1 = new Intent(this, ListOfRecipes.class);
                intent1.putExtra("pos", positio);
                startActivity(intent1);
                break;
            case 2:
                int positi=2;
                Intent intent2 = new Intent(this, ListOfRecipes.class);
                intent2.putExtra("pos", positi);
                startActivity(intent2);

                break;

        }DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_others,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this, RecipesCategoryActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        CategoryFragment frag=new CategoryFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frag_recipe_options_main, frag);
        transaction.commit();
    }

}