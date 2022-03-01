package com.example.myapplication.model;

import java.util.ArrayList;

public class Pecheur {
    private String pseudo;
    private ArrayList<Poisson> listPoissonsAttrapes;
    private int scorePecheur;

    //constructeur
    public Pecheur(String pseudo) {
        this.pseudo = pseudo;
        this.setScorePecheur(0);
        listPoissonsAttrapes = new ArrayList<Poisson>();
    }


    /*
    //binding javafx
    private IntegerProperty scorePecheur = new SimpleIntegerProperty();
    public Integer getScorePecheur(){return scorePecheur.get();}
    public void setScorePecheur(int nvScore){scorePecheur.set(nvScore);}
    public ReadOnlyIntegerProperty scorePecheurProperty(){return scorePecheur;}
    */

    //GETTERS & SETTERS
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<Poisson> getListPoissonsAttrapes() {
        return listPoissonsAttrapes;
    }

    public void setListPoissonsAttrapes(ArrayList<Poisson> listPoissonsAttrapes) {
        this.listPoissonsAttrapes = listPoissonsAttrapes;
    }

    public int getScorePecheur() {
        return scorePecheur;
    }

    public void setScorePecheur(int scorePecheur) {
        this.scorePecheur = scorePecheur;
    }
}
