package com.example.myapplication.model.boucleurs;

import com.example.myapplication.model.observateurs.AnimVaguePoisson;
import com.example.myapplication.model.manager.GameManager;
import com.example.myapplication.model.observateurs.Timer;
import com.example.myapplication.model.fish.VaguePoissons;

import java.util.ArrayList;

public class BoucleurRapide extends BoucleurAbstrait{

    public BoucleurRapide(int millisSleep, VaguePoissons vP, GameManager myGm){
        super.setListObservateurs(new ArrayList<>());
        super.attacher(new AnimVaguePoisson(vP, myGm));
        this.setMillisSleep(millisSleep);
        Timer myTimer = new Timer(45, getMillisSleep());
        super.attacher(myTimer);
        myGm.setTheTimer(myTimer);
    }


    @Override
    public void run(){
        while(true) {
            //voir dans la classe mère
            notifier();
            try {
                //System.out.println("testboucleur");
                Thread.sleep(getMillisSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
