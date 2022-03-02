package com.example.myapplication.model.persistance;

public class OneHS {
    private String pseudo;
    private Integer score;

    public OneHS(String pseudo, Integer score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
