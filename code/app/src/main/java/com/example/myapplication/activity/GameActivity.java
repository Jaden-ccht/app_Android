package com.example.myapplication.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.GameView;
import com.example.myapplication.R;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.player.Pecheur;

public class GameActivity extends AppCompatActivity {
    private GameView myCustomView;

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
