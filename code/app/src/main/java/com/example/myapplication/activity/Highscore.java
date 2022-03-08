package com.example.myapplication.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.recyclerView.HighScoresAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.persistance.OneHS;

import java.util.ArrayList;
import java.util.List;

public class Highscore extends AppCompatActivity {
    private RecyclerView theRecyclerView;
    private List<OneHS> mesHS;
    private HighScoresAdapter theAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        theRecyclerView = (RecyclerView)findViewById(R.id.theRecyclerView);
        mesHS = new ArrayList<>();
        mesHS.add(new OneHS("toto", 42));
        mesHS.add(new OneHS("hihi", 760));
        mesHS.add(new OneHS("bonjour", 3));

        theAdapter = new HighScoresAdapter(mesHS);
        theRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        theRecyclerView.setAdapter(theAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
