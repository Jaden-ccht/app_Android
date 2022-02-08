package com.example.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MainActivityAccueil extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewaccueil);

        Button myButton = (Button)findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewTutoLog(view);
            }
        });
    }

    public void openViewTutoLog(View view) {
        Intent monIntent = new Intent(this, ActivityTutoEtLog.class);
        startActivity(monIntent);
    }
}
