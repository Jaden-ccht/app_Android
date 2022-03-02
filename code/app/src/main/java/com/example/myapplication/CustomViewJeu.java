package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.model.fish.Poisson;
import com.example.myapplication.model.manager.GameManager;

public class CustomViewJeu extends View {
    private Drawable mCustomImage;
    private Drawable fish;
    private GameManager gM;
    private Context context;

    //CONSTRUCTORS
    public CustomViewJeu(Context context) {
        super(context);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
        this.context = context;
    }
    public CustomViewJeu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect imageBounds = canvas.getClipBounds();

        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        //fish.setBounds(createBoundsXY(640,150, 150));
        //fish.draw(canvas);
        for (Poisson p:
             gM.getvP().getListPoissons()) {
            Drawable actualFish = context.getResources().getDrawable(R.drawable.fish);
            actualFish.setBounds(createBoundsXY(p.getCooXPoisson(), p.getCooYPoisson(), 150));
            actualFish.draw(canvas);
        }
        this.invalidate();
        Log.d("cooFish", String.valueOf(gM.getvP().getListPoissons().get(0).getCooXPoisson()));
        Log.d("cooFish", String.valueOf(gM.getvP().getListPoissons().get(0).getCooYPoisson()));
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
