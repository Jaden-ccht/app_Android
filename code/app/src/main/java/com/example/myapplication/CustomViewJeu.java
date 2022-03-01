package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomViewJeu extends View {
    private Drawable mCustomImage;
    private Drawable fish;

    //CONSTRUCTORS
    public CustomViewJeu(Context context) {
        super(context);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
    }
    public CustomViewJeu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCustomImage = context.getResources().getDrawable(R.drawable.full_lake);
        fish = context.getResources().getDrawable(R.drawable.fish);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect imageBounds = canvas.getClipBounds();

        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        fish.setBounds(createBoundsXY(640,150, 150));
        fish.draw(canvas);
    }

    private Rect createBoundsXY(int x, int y, int fishSize) {
        return new Rect(x, y, x+ fishSize, y+fishSize);
    }
}
