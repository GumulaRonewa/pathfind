package com.mygdx.game;

/**
 * Created by gmlron001 on 2018/10/14.
 */

public class locationgrid {
    int xcord,ycord;

public locationgrid(float x,float y){
    xcord=(int)x/40;
    ycord=(int)y/42;

}

    public int getYcord() {
        return ycord;
    }

    public int getXcord() {

        return xcord;
    }

}
