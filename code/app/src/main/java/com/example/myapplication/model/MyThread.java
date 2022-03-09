package com.example.myapplication.model;

import androidx.annotation.Nullable;

import com.example.myapplication.model.boucleurs.BoucleurAbstrait;

public class MyThread extends Thread{
    private BoucleurAbstrait bcl;

    public MyThread(@Nullable Runnable target) {
        super(target);
        this.bcl = (BoucleurAbstrait) target;
    }

    public BoucleurAbstrait getBcl() {
        return bcl;
    }

    public void setBcl(BoucleurAbstrait bcl) {
        this.bcl = bcl;
    }
}
