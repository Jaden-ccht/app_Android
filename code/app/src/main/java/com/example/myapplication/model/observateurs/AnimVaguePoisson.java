package com.example.myapplication.model.observateurs;

import android.util.Log;

import com.example.MyApplication;
import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.manager.GameManager;

import java.util.ArrayList;

public class AnimVaguePoisson extends Observateur {
    private GameManager gM;
    private int maxHeigthAllowed;
    private int maxWidthAllowed;

    public AnimVaguePoisson(GameManager gM) {
        this.gM = gM;
        maxHeigthAllowed = 0;
        maxWidthAllowed = 0;
    }

    @Override
    public void update() {

        ArrayList<Poisson> listFishtoRemove = new ArrayList<Poisson>();
        for (Poisson p: gM.getvP().getListPoissons()) {
            if(!p.isCatched())
                p.getDeplaceurPoisson().deplacer(p);
            else if(p.isCatched() || p.getCooXPoisson() > MyApplication.getAppContext().getResources().getDisplayMetrics().widthPixels)
                listFishtoRemove.add(p);
        }
        Log.d("maxScreenWidth", String.valueOf(maxWidthAllowed));
        gM.getvP().getListPoissons().removeAll(listFishtoRemove);
    }

    public void widthOrHeightGameViewChanged(int w, int h) {
        maxHeigthAllowed = h;
        maxWidthAllowed = w;
    }
}
