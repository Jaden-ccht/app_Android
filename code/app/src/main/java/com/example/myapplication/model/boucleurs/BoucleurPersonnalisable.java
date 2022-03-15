package com.example.myapplication.model.boucleurs;

import com.example.myapplication.model.observateurs.Observateur;

import java.util.ArrayList;

public class BoucleurPersonnalisable extends BoucleurAbstrait{

    public BoucleurPersonnalisable(int millisSleep, ArrayList<Observateur> lesObservateurs){
        super.setListObservateurs(new ArrayList<>());
        for (Observateur unObservateur : lesObservateurs) {
            super.attacher(unObservateur);
        }
        this.setMillisSleep(millisSleep);
    }

    @Override
    public void run(){
        while(!isInterrupted()) {
            notifier();
            try {
                Thread.sleep(getMillisSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
