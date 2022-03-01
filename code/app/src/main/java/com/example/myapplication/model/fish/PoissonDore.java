package com.example.myapplication.model.fish;

import com.example.myapplication.R;
import com.example.myapplication.model.deplaceurs.DeplaceurLent;
import com.example.myapplication.model.deplaceurs.DeplaceurRapide;
import com.example.myapplication.model.fish.Poisson;

public class PoissonDore extends Poisson {
    public PoissonDore(int valeur) {
        super(R.drawable.poissondore, valeur + 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
