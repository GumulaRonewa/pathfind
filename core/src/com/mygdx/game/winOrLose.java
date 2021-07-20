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

public class winOrLose implements Screen{
    SpriteBatch batch;
    Texture img;
    Stage stage;
    Skin skin;
    boolean difficulty;
     String win;
    boolean musicp;
    Pixmap pixmap;
    Color color= Color.RED;
    private Music rainMusic;
    public winOrLose(String x){
        win =x;
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
        final TextButton play= new TextButton(win,skin);



        TextButton home= new TextButton("Home screen",skin);
        play.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2 +(buttonofset)) ;


        home.setPosition(Gdx.graphics.getWidth()/3-Gdx.graphics.getHeight()/8,Gdx.graphics.getHeight()/2-(home.getHeight()-buttonofset));





        home.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent s, float x, float y){

                winOrLose.this.dispose();
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Homescreen(true,true,true));
            }
        });
        //stage.addActor(home);
        stage.addActor(play);

        stage.addActor(home);



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
        Homescreen.music().dispose();
        //rainMusic.dispose();

    }
}
