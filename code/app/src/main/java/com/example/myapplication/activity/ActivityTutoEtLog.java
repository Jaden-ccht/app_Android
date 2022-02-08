package com.example.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.activity.ActivityJeu;
import com.example.myapplication.model.Pecheur;

public class ActivityTutoEtLog extends Activity {
    private Pecheur thePecheur = new Pecheur();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewtutolog);

        Button myButton = (Button)findViewById(R.id.buttonStartGame);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewJeu(view, savedInstanceState);
                EditText inputName = (EditText)findViewById(R.id.editTextPecheurName);
                thePecheur.setName(inputName.getText().toString());
            }
        });
    }

    public void openViewJeu(View view, @Nullable Bundle savedInstanceState) {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
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
