package com.example.myapplication.model.observateurs;

import android.util.Log;

import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.fish.VaguePoissons;
import com.example.myapplication.model.manager.GameManager;

public class AnimVaguePoisson extends Observateur {
    private VaguePoissons maVaguePoisson;
    private GameManager gM;

    public AnimVaguePoisson(VaguePoissons maVaguePoisson, GameManager gM) {
        this.gM = gM;
        this.maVaguePoisson = maVaguePoisson;
    }

    @Override
    public void update() {

        //VaguePoissons maVaguePoissonUpdated = getMaVaguePoisson();
        //ArrayList<Poisson> listFishtoRemove = new ArrayList<Poisson>();
        for (Poisson p: gM.getvP().getListPoissons()) {
            //Log.d("cooFish","Update AnimVague");
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
