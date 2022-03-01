package com.example.myapplication.model;

import java.util.Observable;

public abstract class Poisson extends Observable {
    private int valeur;
    private Deplaceur deplaceurPoisson;
    private boolean isCatched;
    private int heightSprite;
    private int widthSprite;
    private int noDrawableInR;
    private int cooXPoisson;
    private int cooYPoisson;


    //constructeur
    public Poisson(int noDrawableInR, int valeur) {
        this.valeur = valeur;
        this.noDrawableInR = noDrawableInR;
        setHeightSprite(50);
        setWidthSprite(60);
        isCatched = false;
    }


    //GETTER & SETTER
    //(en android pas de propriétés comme en javafx, les getters et setters suffisent)

    public int getHeightSprite() {
        return heightSprite;
    }

    public void setHeightSprite(int heightSprite) {
        this.heightSprite = heightSprite;
    }

    public int getWidthSprite() {
        return widthSprite;
    }

    public void setWidthSprite(int widthSprite) {
        this.widthSprite = widthSprite;
    }

    public Deplaceur getDeplaceurPoisson() {
        return deplaceurPoisson;
    }

    public void setDeplaceurPoisson(Deplaceur deplaceurPoisson) {
        this.deplaceurPoisson = deplaceurPoisson;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getNoDrawableInR() {
        return noDrawableInR;
    }

    public void setNoDrawableInR(int noDrawableInR) {
        this.noDrawableInR = noDrawableInR;
    }

    public boolean isCatched() {
        return isCatched;
    }

    public void setCatched(boolean catched) {
        isCatched = catched;
    }

    public int getCooXPoisson() {
        return cooXPoisson;
    }

    public void setCooXPoisson(int cooXPoisson) {
        this.cooXPoisson = cooXPoisson;
    }

    public int getCooYPoisson() {
        return cooYPoisson;
    }

    public void setCooYPoisson(int cooYPoisson) {
        this.cooYPoisson = cooYPoisson;
    }
}
