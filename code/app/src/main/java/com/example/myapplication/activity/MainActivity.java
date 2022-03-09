package com.example.myapplication.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        if(savedInstanceState != null){
            EditText inputText = findViewById(R.id.editTextTextPersonName);
            inputText.setText(savedInstanceState.getString("nickname"));
        }
    }

    /* Un onsaveinstancestate
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nomPecheur", thePecheurTestV2.getName());
    }
     */



    @Override
    protected void onResume() {
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            findViewById(R.id.imageView).setScrollX(0);
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            findViewById(R.id.imageView).setScrollX(-100);
        }
        super.onResume();
    }

    /*
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText inputText = findViewById(R.id.editTextTextPersonName);
        outState.putString("nickname", inputText.getText().toString());
    }*/


    public void settingsClick(View view) {
        Intent monIntent = new Intent(this, HighscoreActivity.class);
        startActivity(monIntent);
    }

    public void rulesClick(View view) {
        Intent monIntent = new Intent(this, RulesActivity.class);
        startActivity(monIntent);
    }

    public void gameButton(View view) {
        Intent monIntent = new Intent(this, GameActivity.class);
        EditText inputText = findViewById(R.id.editTextTextPersonName);
        monIntent.putExtra("nickName", inputText.getText().toString());
        startActivity(monIntent);
    }
}