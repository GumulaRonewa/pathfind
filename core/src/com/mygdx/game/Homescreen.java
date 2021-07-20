package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Homescreen  implements Screen{
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Skin skin;
    public static Music rainMusic;
    boolean pl;
    boolean m;
    int hard=80;
    Homescreen(boolean p,boolean s,boolean ha){
        pl=p;
        m=s;
        if(ha){
            hard=40;
        }

    }

    private void createBasicSkin(){
        BitmapFont font=new BitmapFont();
        skin=new Skin();
        skin.add("default",font);
        Pixmap pixmap=new Pixmap((int) Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/8,Pixmap.Format.RGB888);
        pixmap.setColor(Color.RED);
        pixmap.fill();;
        skin.add("background",new Texture(pixmap));
        TextButton.TextButtonStyle style=new TextButton.TextButtonStyle();
        style.up=skin.newDrawable("background",Color.GRAY);
        style.down=skin.newDrawable("background",Color.DARK_GRAY);
        style.checked=skin.newDrawable("background",Color.DARK_GRAY);
        style.over=skin.newDrawable("background",Color.DARK_GRAY);
        style.font=skin.getFont("default");
        skin.add("default",style);
    }
    @Override
    public void show() {
        img = new Texture("wallpaper.png");
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("beats.mp3"));

        // start the playback of the background music immediately
        if(pl){
            rainMusic.play();

        }
        rainMusic.setLooping(true);

        batch=new SpriteBatch();
        int buttonofset=20;
        stage=new Stage();

        Gdx.input.setInputProcessor(stage);
        createBasicSkin();
        TextButton start= new TextButton("New game",skin);
        TextButton sett= new TextButton("Setting",skin);
        start.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 +(start.getHeight()+buttonofset)) ;
        TextButton exit= new TextButton("Exit",skin);
        stage.addActor(start);
        sett.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2+buttonofset);
        exit.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2-(start.getHeight()-buttonofset));
        stage.addActor(exit);
        stage.addActor(sett);

        start.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){

                Homescreen.this.dispose();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new MyGdxGame(hard));


            }
        });

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){




                Gdx.app.exit();

            }
        });
        sett.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){



                Homescreen.this.dispose();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new settings(true,false,true));



            }
        });


        stage.addActor(exit);

    }

    public static  Music music(){
        return rainMusic;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();



        batch.draw(img,0,0);
        batch.end();

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        skin.dispose();
       // rainMusic.dispose();
    }
}
