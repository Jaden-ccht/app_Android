package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.GameView;
import com.example.myapplication.R;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.player.Pecheur;

public class GameActivity extends AppCompatActivity {
    private GameView myCustomView;
    private GameManager theGM;
    private String myNickname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        myNickname = intent.getExtras().getString("nickName");
        setContentView(R.layout.viewcustomjeu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myCustomView = findViewById(R.id.customview); //retourne la CustomViewJeu
        theGM = new GameManager();
        myCustomView.setgM(theGM);
        myCustomView.getgM().setLePecheur(new Pecheur(myNickname));
        myCustomView.getgM().startNewGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        theGM.stopGame();
    }

    /*
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        myNickname = savedInstanceState.getString("nickname");
        Log.d("nick",myNickname);
        super.onRestoreInstanceState(savedInstanceState);
    }*/
}
