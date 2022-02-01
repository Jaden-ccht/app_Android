package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class MainActivityAccueil extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewaccueil);
    }

    public void openViewJeu(View view) {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
    }
}
