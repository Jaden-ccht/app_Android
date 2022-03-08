package com.example.myapplication.model.observateurs;

import android.util.Log;

public class Timer extends Observateur {
    private float timeOf1LoopMillis;
    private float actualTime;

    //à donner en secondes
    public Timer(float totalTimeSec, float timeOf1LoopMillis) {
        this.timeOf1LoopMillis = timeOf1LoopMillis;
        setActualTime(totalTimeSec);
    }

    @Override
    public void update() {

        if((getActualTime() - (timeOf1LoopMillis / 1000)) > 0) {
            setActualTime(getActualTime() - (timeOf1LoopMillis / 1000));
        }
        else
            setActualTime(0);

        Log.d("time", toString().valueOf(getActualTime()));
    }

    public float getActualTime() {
        return actualTime;
    }

    public void setActualTime(float actualTime) {
        this.actualTime = actualTime;
    }
}
