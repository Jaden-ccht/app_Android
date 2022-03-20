package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.GameView;
import com.example.myapplication.R;
import com.example.myapplication.fragments.MyFragment;
import com.example.myapplication.model.MyThread;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.player.Pecheur;

public class GameActivity extends AppCompatActivity {
    private GameView myCustomView;
    private GameManager theGM;
    private String myNickname;
    private View game_paused;
    private View countdown;
    private MyThread myThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        myNickname = intent.getExtras().getString("nickName");
        theGM = new GameManager();
        theGM.setLePecheur(new Pecheur(myNickname));

        getIntent().putExtra("monGameManager", theGM);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new MyFragment();
        fm.beginTransaction().replace(R.id.frag, fragment).commit();

        setContentView(R.layout.viewcustomjeu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myCustomView = findViewById(R.id.customview); //retourne la CustomViewJeu
        myCustomView.setgM(theGM);
        myCustomView.getgM().startNewGame();

        game_paused = findViewById(R.id.game_paused);
        //context -> getFileDir (chemin du fichier pr persistance profonde a changer ds gameManager)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        theGM.stopGame();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("testpause", "resume");
        Button btnContinue = (Button) findViewById(R.id.btn_continue);
        bindButtonContinue(btnContinue);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("testpause", "pause");
        game_paused.setVisibility(View.VISIBLE);
        theGM.stopGame();
    }

    private void bindButtonContinue(Button btn) {
        btn.setOnClickListener(view -> {
            game_paused.setVisibility(View.INVISIBLE);
            theGM.resumeGame();
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("player_name",theGM.getLePecheur().getPseudo());
        outState.putInt("player_score",theGM.getLePecheur().getScorePecheur());
        outState.putFloat("time_remaining",theGM.getTheTimer().getActualTime());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        myNickname = savedInstanceState.getString("nickname");
        Log.d("nick",myNickname);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
