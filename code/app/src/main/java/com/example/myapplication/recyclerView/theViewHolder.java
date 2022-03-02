package com.example.myapplication.recyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.persistance.OneHS;

public class theViewHolder extends RecyclerView.ViewHolder {
    private TextView score;
    private TextView pseudo;

    theViewHolder(View myView) {
        super(myView);

        score = (TextView) myView.findViewById(R.id.scores);
        pseudo = (TextView) myView.findViewById(R.id.pseudos);
    }

    void display(OneHS singleHS) {
        score.setText(singleHS.getScore().toString());
        pseudo.setText(singleHS.getPseudo());
    }
}
