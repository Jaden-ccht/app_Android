package com.example.myapplication.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.persistance.OneHS;

import java.util.List;

public class HighScoresAdapter extends RecyclerView.Adapter<theViewHolder> {
    private List<OneHS> listOneHS;

    public HighScoresAdapter(List<OneHS> listOneHS) {
        this.listOneHS = listOneHS;
    }

    @NonNull
    @Override
    public theViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layInf = LayoutInflater.from(parent.getContext());
        View theView = layInf.inflate(R.layout.one_score, parent, false);
        return new theViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull theViewHolder holder, int position) {
        holder.display(listOneHS.get(position));
    }

    @Override
    public int getItemCount() {
        return listOneHS.size();
    }
}
