package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class player {
    float playerX = 0;
    float playerY = 0;
    float up=1;

    public Sprite sprite;
    public player(String name) {

        sprite = new Sprite(new Texture(name));


    }
    public int handleInput(){


        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
        {
            if(playerY<=44){
                playerY=44;

            }
            else if(playerY<=8*44&&playerY>5*44){
                if (playerX==400){
                    playerY=8*44;
                }
                else {
                    playerY-=(sprite.getHeight()+4);
                }

            }
            else{
           playerY-=(sprite.getHeight()+4);
            }
         return 0;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){

            if(playerY>=438){
                playerY=438;
            }
            else  if(playerY>=4*44){
                if (playerX==400){
                    playerY=4*44;
                }
                else {
                    playerY+=sprite.getHeight()+4;
                }

            }
            else{
                playerY+=sprite.getHeight()+4;

            }

            return 0;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            if (playerX<=40){

            playerX=40;}
            else if(playerX<=440&&playerX>400){
                if(playerY==7*44){
                    playerX=440;
                }
               else if(playerY==6*44){
                    playerX=440;
                }
               else if(playerY==5*44){
                    playerX=440;
                }
                else {
                    playerX-=sprite.getWidth();
                }
            }
            else{

                playerX-=sprite.getWidth();

            }
         return 0;

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            if (playerX>=600){
                playerX=600;}
            else if(playerX>=360&&playerX<400){
                if(playerY==7*44){
                    playerX=360;
                }
                else if(playerY==6*44){
                    playerX=360;
                }
                else if(playerY==5*44){
                    playerX=360;
                }
                else {
                    playerX+=sprite.getWidth();
                }
            }
            else{

                playerX+=sprite.getWidth();
            }
            return 0;
        }



 return 1;


    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getPlayerX() {
        return playerX;
    }

    public float getPlayerY() {
        return playerY;
    }
}
