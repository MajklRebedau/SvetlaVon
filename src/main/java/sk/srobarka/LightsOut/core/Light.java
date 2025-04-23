package sk.srobarka.LightsOut.core;

public class Light {

    private boolean on;

    public Light(){
        this.on = false;
    }

    public boolean isOn(){
        return this.on;
    }

    public void toggle(){
        this.on=!this.on;

        }
    }


