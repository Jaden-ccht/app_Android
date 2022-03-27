package com.example.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentJeuBinding;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.observateurs.Timer;
import com.example.myapplication.model.player.Pecheur;

import java.io.Serializable;

public class MyFragment extends Fragment {
    private GameManager monGameManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        monGameManager = (GameManager) i.getSerializableExtra("monGameManager");

        FragmentJeuBinding fragmentJeuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_jeu, null, false);

        fragmentJeuBinding.setPecheur(monGameManager.getLePecheur());
        return fragmentJeuBinding.getRoot();
    }
}
