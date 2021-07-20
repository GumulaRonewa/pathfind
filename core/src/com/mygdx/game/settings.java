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

public class settings  implements Screen{
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Skin skin;
    boolean difficulty;
    boolean soundp;
    boolean musicp;
    Pixmap pixmap;
    Color color= Color.RED;
    private Music rainMusic;
    public settings(boolean s,boolean d,boolean m){
        difficulty=d;
        soundp=s;
        musicp=m;
    }

    private void createBasicSkin(Color colour){
        BitmapFont font=new BitmapFont();
        skin=new Skin();
        skin.add("default",font);
        pixmap=new Pixmap((int) Gdx.graphics.getWidth()/2,(int)Gdx.graphics.getHeight()/8,Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill();
        skin.add("background",new Texture(pixmap));
        TextButton.TextButtonStyle style=new TextButton.TextButtonStyle();
       style.up=skin.newDrawable("background",Color.GRAY);
        style.down=skin.newDrawable("background",Color.DARK_GRAY);
        style.over=skin.newDrawable("background",Color.DARK_GRAY);
        style.font=skin.getFont("default");
        skin.add("default",style);
    }
    @Override
    public void show() {
        img =  new Texture("wallpaper.png");
        batch=new SpriteBatch();
        int buttonofset=20;
        stage=new Stage();

        Gdx.input.setInputProcessor(stage);
        createBasicSkin(color);
        final TextButton music= new TextButton("Music   : On",skin);

        final TextButton sound= new TextButton("Sound   : On",skin);
        final TextButton diff= new TextButton("Difficult: Easy",skin);
        sound.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 +(2*sound.getHeight()+buttonofset)) ;
        TextButton home= new TextButton("Home screen",skin);
        music.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 +(sound.getHeight()+buttonofset)) ;

        diff.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2+buttonofset);
        home.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2-(home.getHeight()-buttonofset));

        music.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){
                if(musicp) {
                    music.setText("Music   : Off");
                    Homescreen.music().pause();
                    musicp=false;

                }
                else {
                    music.setText("Music   : On");
                   Homescreen.music().play();
                    musicp=true;


                }


            }
        });

        sound.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){
                if(soundp) {
                    sound.setText("Sound   : Off");
                    soundp=false;

                }
                else {
                    sound.setText("Sound   : On");
                    soundp=true;


                }


            }
        });
        diff.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){
                if(difficulty) {
                    diff.setText("Difficult: Easy");
                    difficulty=false;

                }
                else {
                    diff.setText("Difficult: Hard");
                   difficulty=true;

                    //pixmap.setColor(Color.RED);


                }


            }
        });

        home.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){

                settings.this.dispose();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Homescreen(soundp,musicp,difficulty));
            }
        });
        //stage.addActor(home);
        stage.addActor(diff);
        stage.addActor(sound);
        stage.addActor(home);
        stage.addActor(music);


    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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
        //rainMusic.dispose();

    }
}