package com.example.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.PecheurTestV2;

public class ActivityJeu extends Activity {
    private PecheurTestV2 thePecheurTestV2;

    public ActivityJeu() {
        thePecheurTestV2 = new PecheurTestV2();
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
        outState.putString("nomPecheur", thePecheurTestV2.getName());
    }
}
