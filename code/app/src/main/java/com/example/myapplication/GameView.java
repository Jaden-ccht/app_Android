package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.manager.GameManager;

import java.util.ArrayList;

public class GameView extends View {
    private Drawable mCustomImage;
    private Drawable fish;
    private GameManager gM;
    private Context context;

    //CONSTRUCTORS
    public GameView(Context context) {
        super(context);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    for(Poisson p : gM.getvP().getListPoissons()) {

                        Rect boundsPoisson = createBoundsXY(p.getCooXPoisson(), p.getCooYPoisson(), p.getHeightSprite()+p.getWidthSprite());
                        if(boundsPoisson.contains((int)motionEvent.getX(),(int) motionEvent.getY())) { //check si le click a lieu dans le rect du poisson
                            p.setCatched(true);
                            gM.getLePecheur().setScorePecheur(gM.getLePecheur().getScorePecheur() + p.getValeur());
                            gM.getLePecheur().getListPoissonsAttrapes().add(p);
                            Log.d("catch","Attrapé !!!");
                        }
                    }
                }
                return false;
            }
        });
        this.context = context;

    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    for(Poisson p : gM.getvP().getListPoissons()) {

                        Rect boundsPoisson = createBoundsXY(p.getCooXPoisson(), p.getCooYPoisson(), p.getHeightSprite()+p.getWidthSprite());
                        if(boundsPoisson.contains((int)motionEvent.getX(),(int) motionEvent.getY())) { //check si le click a lieu dans le rect du poisson
                    /*
                    switch (p.getClass().toString()) {
                        case "class classes.PoissonBombe" -> {
                            p.setHeightSprite(130);
                            p.setWidthSprite(130);
                            p.setSpritePoisson(new Image("img/bigbang.png"));
                        }
                        case "class classes.PoissonDore" -> p.setSpritePoisson(new Image("img/poissondorecatched.png"));
                        case "class classes.PoissonClassique" -> p.setSpritePoisson(new Image("img/fishCatched.png"));
                    } */
                            p.setCatched(true);
                            gM.getLePecheur().setScorePecheur(gM.getLePecheur().getScorePecheur() + p.getValeur());
                            gM.getLePecheur().getListPoissonsAttrapes().add(p);
                            Log.d("catch","Attrapé !!!");
                        }
                    }
                }
                return false;
            }
        });
        this.context = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        gM.widthOrHeightGameViewChanged(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect imageBounds = canvas.getClipBounds();

        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        //recréer une une Arraylist avant de la parcourir
        //permet d'éviter les ConcurrentModificationException !! (sinon on peut faire des SynchronizedList)
        ArrayList<Poisson> myListePoissonSynchronized = new ArrayList(gM.getvP().getListPoissons());
        for (Poisson p: myListePoissonSynchronized) {
            Drawable actualFish = null;
            int fishSize = 150;
            if(p.getNoDrawableInR() == R.drawable.fish) actualFish = context.getResources().getDrawable(R.drawable.fish);
            else if(p.getNoDrawableInR() == R.drawable.poissondore) actualFish = context.getResources().getDrawable(R.drawable.poissondore);
            else if(p.getNoDrawableInR() == R.drawable.poissonbombe && !p.isCatched()) actualFish = context.getResources().getDrawable(R.drawable.poissonbombe);
            else if(p.getNoDrawableInR() == R.drawable.poissonbombe && p.isCatched()) {
                actualFish = context.getResources().getDrawable(R.drawable.bigbang);
                fishSize = 300;
            }
            actualFish.setBounds(createBoundsXY(p.getCooXPoisson(), p.getCooYPoisson(), fishSize));
            actualFish.draw(canvas);
        }
        this.invalidate();

        //passe au coo du nouveau poisson 0 quand l'ancien disparaît
        if(!gM.getvP().getListPoissons().isEmpty()) {
            Log.d("cooXFish", String.valueOf(gM.getvP().getListPoissons().get(0).getCooXPoisson()));
            Log.d("cooYFish", String.valueOf(gM.getvP().getListPoissons().get(0).getCooYPoisson()));
        }
    }

    private Rect createBoundsXY(int x, int y, int fishSize) {
        return new Rect(x, y, x+ fishSize, y+fishSize);
    }

    //GETTERS & SETTERS
    public GameManager getgM() {
        return gM;
    }

    public void setgM(GameManager gM) {
        this.gM = gM;
    }

}
