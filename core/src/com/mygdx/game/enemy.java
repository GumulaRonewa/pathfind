package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class enemy {



        float enemyX = 600;
        float enemyY = 438;
        

        public Sprite sprite;
        public enemy(String name) {

            sprite = new Sprite(new Texture(name));

        }

        public Sprite getSprite() {
            return sprite;
        }


        public float getenemyX() {
            return enemyX;
        }

        public float getenemyY() {
            return enemyY;
        }
    }

