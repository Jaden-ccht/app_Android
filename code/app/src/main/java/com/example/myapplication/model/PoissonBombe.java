package com.example.myapplication.model;


import com.example.myapplication.R;

public class PoissonBombe extends Poisson{
    public PoissonBombe(int valeur) {
        super(R.drawable.poissonbombe, valeur - 50);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
