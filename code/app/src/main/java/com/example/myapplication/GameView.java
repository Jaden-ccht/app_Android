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
                            p.setSpritePoisson(new Image("img/bigBang.png"));
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

        //fish.setBounds(createBoundsXY(640,150, 150));
        //fish.draw(canvas);

        for (Poisson p: gM.getvP().getListPoissons()) {
            Drawable actualFish = context.getResources().getDrawable(R.drawable.fish);
            actualFish.setBounds(createBoundsXY(p.getCooXPoisson(), p.getCooYPoisson(), 150));
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
