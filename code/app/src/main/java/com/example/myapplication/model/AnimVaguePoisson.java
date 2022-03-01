package com.example.myapplication.model;

import java.util.ArrayList;

public class AnimVaguePoisson extends Observateur{
    private VaguePoissons maVaguePoisson;
   //private GameManager gM;

    public AnimVaguePoisson(VaguePoissons maVaguePoisson, GameManager gM) {
        //this.gM = gM;
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {

        VaguePoissons maVaguePoissonUpdated = getMaVaguePoisson();
        ArrayList<Poisson> listFishtoRemove = new ArrayList<Poisson>();
        for (Poisson p:
             getMaVaguePoisson().getListPoissons()) {
            if(!p.isCatched())
                p.getDeplaceurPoisson().deplacer(p);
        }
    }


    //GETTERS & SETTERS
    public VaguePoissons getMaVaguePoisson() {
        return maVaguePoisson;
    }

    public void setMaVaguePoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }
}
