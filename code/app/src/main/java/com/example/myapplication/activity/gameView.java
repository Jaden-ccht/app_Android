package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.CustomViewJeu;
import com.example.myapplication.R;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.player.Pecheur;

public class gameView extends AppCompatActivity {
    private CustomViewJeu myCustomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcustomjeu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myCustomView = findViewById(R.id.customview); //retourne la CustomViewJeu
        myCustomView.setgM(new GameManager());
        myCustomView.getgM().setLePecheur(new Pecheur("test"));
        myCustomView.getgM().startNewGame();
    }
}
