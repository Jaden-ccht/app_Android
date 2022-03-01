package com.example.myapplication.model;

import com.example.myapplication.R;

public class PoissonDore extends Poisson{
    public PoissonDore(int valeur) {
        super(R.drawable.poissondore, valeur + 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
