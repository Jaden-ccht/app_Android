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
        Rect fishSize = new Rect(800,650,950,800);

        mCustomImage.setBounds(imageBounds);
        mCustomImage.draw(canvas);

        fish.setBounds(fishSize);

        fish.draw(canvas);
    }
}
