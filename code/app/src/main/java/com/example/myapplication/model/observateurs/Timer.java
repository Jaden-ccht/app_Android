package com.example.myapplication.model.observateurs;

import android.util.Log;

public class Timer extends Observateur {
    private float timeOf1LoopMillis;
    private float actualTime;
    private boolean active;

    //à donner en secondes
    public Timer(float totalTimeSec, float timeOf1LoopMillis) {
        this.timeOf1LoopMillis = timeOf1LoopMillis;
        actualTime = timeOf1LoopMillis;
        active = true;
    }

    @Override
    public void update() {
        if(active) {
            if ((getActualTime() - (timeOf1LoopMillis / 1000)) > 0) {
                setActualTime(getActualTime() - (timeOf1LoopMillis / 1000));
            } else
                setActualTime(0);

            //Log.d("time", toString().valueOf(getActualTime()));
        }
    }

    //GETTERS & SETTERS
    public float getActualTime() {
        return actualTime;
    }

    public void setActualTime(float actualTime) {
        this.actualTime = actualTime;
    }

    public float getTimeOf1LoopMillis() {
        return timeOf1LoopMillis;
    }

    public void setTimeOf1LoopMillis(float timeOf1LoopMillis) {
        this.timeOf1LoopMillis = timeOf1LoopMillis;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
