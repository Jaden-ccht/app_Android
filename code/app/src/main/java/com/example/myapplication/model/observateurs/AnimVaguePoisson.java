package com.example.myapplication.model.observateurs;

import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.manager.GameManager;

import java.util.ArrayList;

public class AnimVaguePoisson extends Observateur {
    private GameManager gM;
    private int maxHeigthAllowed;
    private int maxWidthAllowed;

    public AnimVaguePoisson(GameManager gM) {
        this.gM = gM;
    }

    @Override
    public void update() {

        ArrayList<Poisson> listFishtoRemove = new ArrayList<Poisson>();
        for (Poisson p: gM.getvP().getListPoissons()) {
            if(p.isCatched() || p.getCooXPoisson() > maxWidthAllowed)
                listFishtoRemove.add(p);
            else
                p.getDeplaceurPoisson().deplacer(p);
        }
        gM.getvP().getListPoissons().removeAll(listFishtoRemove);
    }

    public void widthOrHeightGameViewChanged(int w, int h) {
        maxHeigthAllowed = h;
        maxWidthAllowed = w;
    }
}
