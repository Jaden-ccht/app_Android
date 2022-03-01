package com.example.myapplication.model.fish;


import com.example.myapplication.R;
import com.example.myapplication.model.deplaceurs.DeplaceurLent;
import com.example.myapplication.model.deplaceurs.DeplaceurRapide;

public class PoissonClassique extends Poisson{

    public PoissonClassique(int valeur) {
        super(R.drawable.fish, valeur);

        if(Math.random() > 0.50)
            super.setDeplaceurPoisson(new DeplaceurLent());
        else
            super.setDeplaceurPoisson(new DeplaceurRapide());
    }
}
