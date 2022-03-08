package com.example.myapplication.model.manager;

import com.example.myapplication.model.boucleurs.BoucleurLent;
import com.example.myapplication.model.boucleurs.BoucleurRapide;
import com.example.myapplication.model.fish.VaguePoissons;
import com.example.myapplication.model.observateurs.AnimVaguePoisson;
import com.example.myapplication.model.observateurs.Timer;
import com.example.myapplication.model.persistance.Highscores;
import com.example.myapplication.model.player.Pecheur;

public class GameManager {
    private Pecheur lePecheur;
    private VaguePoissons vP;
    private Highscores hS;
    private final int millisSleepBoucleurRapide;
    private final int millisSleepBoucleurLent;
    private Timer theTimer;
    private Thread thread1;
    private Thread thread2;
    private AnimVaguePoisson animatorVP;
    private int heightGameView;
    private int widthGameView;

    public GameManager() {
        vP = new VaguePoissons(4);
        /*
        try {
            hS = new Highscores(new SauvegardeurHS(), new ChargeurHS());
            System.out.println(hS.getMapHighScores().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        millisSleepBoucleurRapide = 25; //25 millissec
        millisSleepBoucleurLent = 2500; //7s sec
    }

    public void widthOrHeightGameViewChanged(int w, int h) {
        widthGameView = w;
        heightGameView = h;
        animatorVP.widthOrHeightGameViewChanged(w, h);
    }

    public void startNewGame() {
        vP = new VaguePoissons(4);
        lePecheur.setScorePecheur(0);
        animatorVP = new AnimVaguePoisson(this);
        BoucleurRapide boucleurRapide = new BoucleurRapide(millisSleepBoucleurRapide, vP, animatorVP, this);
        BoucleurLent boucleurLent = new BoucleurLent(millisSleepBoucleurLent, vP);
        thread1 = new Thread(boucleurRapide);
        thread2 = new Thread(boucleurLent);
        thread1.start();
        thread2.start();
    }


    //GETTERS ET SETTERS
    public VaguePoissons getvP() {
        return vP;
    }

    public void setvP(VaguePoissons vP) {
        this.vP = vP;
    }

    public Highscores gethS() {
        return hS;
    }

    public void sethS(Highscores hS) {
        this.hS = hS;
    }

    public Pecheur getLePecheur() {
        return lePecheur;
    }

    public void setLePecheur(Pecheur lePecheur) {
        this.lePecheur = lePecheur;
    }

    public Timer getTheTimer() {
        return theTimer;
    }

    public void setTheTimer(Timer theTimer) {
        this.theTimer = theTimer;
    }

    public Thread getThread1() {
        return thread1;
    }

    public void setThread1(Thread thread1) {
        this.thread1 = thread1;
    }

    public Thread getThread2() {
        return thread2;
    }

    public void setThread2(Thread thread2) {
        this.thread2 = thread2;
    }
}
