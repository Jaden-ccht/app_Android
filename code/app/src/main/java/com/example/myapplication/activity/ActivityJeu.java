package com.example.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        setContentView(R.layout.viewjeu);

        TextView displayNamePecheur = (TextView)findViewById(R.id.textViewRealNamePecheur);
        displayNamePecheur.setText(thePecheur.getName());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        thePecheur.setName(savedInstanceState.getString("nomPecheur"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("nomPecheur", thePecheur.getName());
        super.onSaveInstanceState(outState);
    }
}
