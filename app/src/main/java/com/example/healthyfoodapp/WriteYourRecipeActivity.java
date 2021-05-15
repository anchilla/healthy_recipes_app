package com.example.healthyfoodapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteYourRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseRecipes db;
    EditText title, ingredientsNew, instructionsNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_your_recipe);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(false);
              actionBar.setTitle("Add your recipe");

        db=new DatabaseRecipes(this);
        Button button = findViewById(R.id.save);

        title = findViewById(R.id.first);
        ingredientsNew = findViewById(R.id.second);
        instructionsNew = findViewById(R.id.third);

        button.setOnClickListener(this);

    }

    public void onClick(View view) {
        String myTitle = title.getText().toString();
        String myIngredients = ingredientsNew.getText().toString();
        String myInstructions = instructionsNew.getText().toString();

        if(myTitle.length()>0 & myIngredients.length()>0 & myInstructions.length()>0) {
            db.makeMyRecipe(myTitle, myIngredients, myInstructions);

            Toast toast = Toast.makeText(this,
                    "Saved", Toast.LENGTH_SHORT);
            toast.show();

            title.getText().clear();
            ingredientsNew.getText().clear();
            instructionsNew.getText().clear();
        }else {
            Toast t= Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT);
            t.show();
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

