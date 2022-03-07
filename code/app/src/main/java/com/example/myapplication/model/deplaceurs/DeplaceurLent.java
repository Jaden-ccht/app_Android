package com.example.myapplication.model.deplaceurs;

import com.example.myapplication.model.fish.Poisson;

import java.util.Random;

public class DeplaceurLent extends Deplaceur{

    @Override
    public void deplacer(Poisson p) {
        Random r = new Random();
        int firstMovementIsUp = r.nextInt(2);
        p.setCooXPoisson(p.getCooXPoisson()+15);

        //ou si le poisson est trop haut ou trop bas sur l'écran
        if((firstMovementIsUp == 0 || p.getCooYPoisson() <= 100) &&  p.getCooYPoisson() <= 700)
            p.setCooYPoisson(p.getCooYPoisson()+15);
        else
            p.setCooYPoisson(p.getCooYPoisson()-15);
    }
}
