package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by gmlron001 on 2018/10/14.
 */

public class block {
    public Sprite sprite;
    int positionx=0,positiony=0;
    public block(String name,int x,int y) {

        sprite = new Sprite(new Texture(name));
        setPositiony(y);
        setPositionx(x);

    }



    public int getPositionx() {
        return positionx;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setPositiony(int y) {
       positiony=y;

    }

    public void setPositionx(int x) {
        positionx= x;
    }

    public int getPositiony() {
        return positiony;
    }
    public void setrange(){

    }
}
