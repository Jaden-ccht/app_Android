package com.example.myapplication.model;


import com.example.myapplication.R;

public class PoissonClassique extends Poisson{

    public PoissonClassique(int valeur) {
        super(R.drawable.fish, valeur);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
