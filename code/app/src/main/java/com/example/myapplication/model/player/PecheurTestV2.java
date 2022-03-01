package com.example.myapplication.model.player;

public class PecheurTestV2 {
    private String name;
    private int points;


    public PecheurTestV2() {
       name = "default_name";
        points = 0;
    }


    //GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
