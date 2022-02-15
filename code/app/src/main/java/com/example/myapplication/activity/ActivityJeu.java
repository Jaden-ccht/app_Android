package com.example.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.CustomViewJeu;
import com.example.myapplication.R;
import com.example.myapplication.model.Pecheur;

public class ActivityJeu extends Activity {
    private Pecheur thePecheur;

    public ActivityJeu() {
        thePecheur = new Pecheur();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewcustomjeu);
        //TextView displayNamePecheur = (TextView)findViewById(R.id.textViewRealNamePecheur);
        //displayNamePecheur.setText(thePecheur.getName());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nomPecheur", thePecheur.getName());
    }
}
