package com.example.myapplication.activityV2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.CustomViewJeu;
import com.example.myapplication.R;
import com.example.myapplication.model.manager.GameManager;

public class gameView extends AppCompatActivity {
    private CustomViewJeu myCustomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcustomjeu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myCustomView = findViewById(R.id.customview); //retourne la CustomViewJeu
        myCustomView.setgM(new GameManager());
    }
}
