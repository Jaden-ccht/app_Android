package com.example.myapplication.model.observateurs;

import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.fish.VaguePoissons;

public class ObservateurCreationPoisson extends Observateur{
    private VaguePoissons maVaguePoisson;

    public ObservateurCreationPoisson(VaguePoissons maVaguePoisson) {
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {
        VaguePoissons nvVague = new VaguePoissons(4);
        maVaguePoisson.setNbPoissons(maVaguePoisson.getNbPoissons()+nvVague.getNbPoissons());
        for (Poisson p:
                nvVague.getListPoissons()) {
            maVaguePoisson.getListPoissons().add(p);
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
