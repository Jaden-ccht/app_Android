package com.example.myapplication.activityV2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        EditText inputText = findViewById(R.id.editTextTextPersonName);
        outState.putString("nickname", inputText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        EditText inputText = findViewById(R.id.editTextTextPersonName);
        inputText.setText(savedInstanceState.getString("nickname"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void settingsClick(View view) {
        Intent monIntent = new Intent(this, Highscore.class);
        startActivity(monIntent);
    }

    public void rulesClick(View view) {
        Intent monIntent = new Intent(this, Rules.class);
        startActivity(monIntent);
    }

    public void gameButton(View view) {
        Intent monIntent = new Intent(this, gameView.class);
        startActivity(monIntent);
    }
}