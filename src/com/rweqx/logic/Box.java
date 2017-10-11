package com.rweqx.logic;

public class Box {

    private boolean allowed[] = new boolean[9];
    private int value = 0;

    public Box(){
        for(boolean b : allowed){
            b = true;
        }
    }

    public boolean[] getAllowed(){
        return allowed;
    }
    public void removeAllowed(int i){
        allowed[i] = false;
    }

    public void setValue(int i){
        value = i;

        for(boolean b : allowed){
            b = false;
        }
    }

    public int getValue(){
        return value;
    }
}
