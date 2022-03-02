package com.example.myapplication.model.fish;

import java.util.ArrayList;
import java.util.Random;

public class VaguePoissons {
    private int nbPoissons;
    private ArrayList<Poisson> listPoissons;

    //CONSTRUCTEUR
    public VaguePoissons(int nbPoissons) {
        listPoissons = new ArrayList<>();
        this.nbPoissons = nbPoissons;

        Random r = new Random();
        int low = 5;
        int high = 25;
        //5 poissons ou +
        if(getNbPoissons() > 5) {
            for (int i = 0; i < nbPoissons-2; i++) {
                int valeur = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(valeur));
            }
            listPoissons.add(new PoissonBombe(0)); //-50 rajouté dans le constructeur de PoissonBombe
            listPoissons.add(new PoissonDore(0)); //+50 rajouté dans le constructeur de PoissonDore
        }
        // - de 5 poissons
        else {
            for (int i = 0; i < nbPoissons; i++) {
                int valeur = r.nextInt(high-low) + low;
                listPoissons.add(new PoissonClassique(valeur));
            }
        }

        //positionnement de chaque Poisson de la vague à des coo aléatoires
        for (Poisson p:
             getListPoissons()) {
            Random rCooY = new Random();
            int lowY = 150;
            int highY = 550;
            p.setCooXPoisson(15);
            p.setCooYPoisson(rCooY.nextInt(highY-lowY) + lowY);
        }
    }

    //GETTERS ET SETTERS
    public int getNbPoissons() {
        return nbPoissons;
    }
    public void setNbPoissons(int nbPoissons) {
        this.nbPoissons = nbPoissons;
    }

    public ArrayList<Poisson> getListPoissons() {
        return listPoissons;
    }

    public void setListPoissons(ArrayList<Poisson> listPoissons) {
        this.listPoissons = listPoissons;
    }
}
