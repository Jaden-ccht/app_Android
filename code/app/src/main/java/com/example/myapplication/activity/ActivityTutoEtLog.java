package com.example.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.PecheurTestV2;

public class ActivityTutoEtLog extends Activity {
    private PecheurTestV2 thePecheurTestV2 = new PecheurTestV2();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewtutolog);

        Button myButton = (Button)findViewById(R.id.buttonStartGame);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputName = (EditText)findViewById(R.id.editTextPecheurName);
                thePecheurTestV2.setName(inputName.getText().toString());
                openViewJeu(view);
            }
        });
    }

    public void openViewJeu(View view) {
        Intent monIntent = new Intent(this, ActivityJeu.class);
        startActivity(monIntent);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("nomPecheur", thePecheurTestV2.getName());
    }
}
