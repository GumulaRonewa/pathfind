package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.*;
import java.util.ArrayList;

public class MyGdxGame implements Screen  {
	SpriteBatch batch;
	Texture img,img2;
	enemy enmy;
	player play;
	int itr=1;
	Square current;
	movement move;
	int i=0;
	int il=0;
	Square enemy,player,b;
	ArrayList<block> blocks = new ArrayList<block>();
    ArrayList<block> blocky = new ArrayList<block>();
	ArrayList<Square> open = new ArrayList<Square>();
	ArrayList<Square> closed = new ArrayList<Square>();
	ArrayList<Square> squares = new ArrayList<Square>();
	ArrayList<Square> blocked = new ArrayList<Square>();
	int add=0;
	int hard=0;
	MyGdxGame(int h){
		hard=h;
	}
	@Override
	public void show () {
		batch = new SpriteBatch();
		img = new Texture("path.png");

		enmy=new enemy("enemy.png");
		int y=0;
        for(int i=0;i<16;i++){
            blocky.add(new block("block.jpg",0,y));
            y +=44;
        }
        int x=0;
        for(int i=0;i<16;i++){
            blocks.add(new block("block.jpg",x,0));
            x +=40;
        }
        blocked.add(new Square(10*40,7*44));
		blocked.add(new Square(10*40,6*44));
		blocked.add(new Square(10*40,5*44));
        play=new player("turtle.png");
        play.playerY=5*44;
        play.playerX=8*40;
		enemy=new Square(enmy.enemyX, enmy.enemyY);

		ArrayList<Square> squares = new ArrayList<Square>();


	}
   int drawer=0;
    float score=0;
	@Override
	public void render (float v) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		player=new Square(play.playerX, play.playerY);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(play.getSprite(), play.getPlayerX(), play.playerY);
		batch.draw(enmy.getSprite(), enmy.enemyX, enmy.enemyY);
		batch.draw(new Texture("block.jpg"),0,44);
        for(int i=0;i<11;i++){
            batch.draw(blocky.get(i).sprite,blocky.get(i).getPositionx(),blocky.get(i).getPositiony());
        }
        for(int i=0;i<16;i++){
           batch.draw(blocks.get(i).sprite,blocks.get(i).getPositionx(),blocks.get(i).getPositiony());
        }
		for(int i=0;i<blocked.size();i++){
			batch.draw(blocks.get(i).sprite,blocked.get(i).getX()*40,blocked.get(i).getY()*44);
		}
        float px=play.playerX;
        float py= play.playerY;
		player=new Square(play.playerX, play.playerY);
		enemy=new Square(enmy.enemyX, enmy.enemyY);
         score +=0.01f;
        int numbX=0;
		int numbY=0;
		if(add==0){
			itr=0;
			closed.clear();
			squares.clear();;
			squares.add(enemy);
            il=0;
			for(int i=0;i<16;i++)
			{
				for (int j=0;j<11;j++){
					squares.add(new Square(numbX,numbY));
					squares.get(itr).setCosts(enemy,player);
                    if(squares.get(itr).getX()==10&&squares.get(itr).getY()==7){
						squares.get(itr).setF(1000);
					}
					else if(squares.get(itr).getX()==10&&squares.get(itr).getY()==6){
						squares.get(itr).setF(1000);
					}
					else if(squares.get(itr).getX()==10&&squares.get(itr).getY()==5){
						squares.get(itr).setF(1000);
					}



					numbY+=44;
					itr++;

				}
				numbX +=40;
				numbY=0;
			}
			move=new movement(squares,player,enemy);
			open=move.getZ();



		}


		add+=10;

        if(drawer==hard){

        	if(il<closed.size()){
				Square curr=closed.get(il);


				float yx=Math.abs(curr.getY());

				float XY=Math.abs(curr.getX());

				if(yx==(play.getPlayerY()/44)&&curr.getX()==(play.getPlayerX()/40)){
					((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new winOrLose("Score: "+(int)score));

				}


                enmy.enemyX=curr.getX()*40;
			enmy.enemyY=yx*44;
        	 il++;
        	}
			drawer=0;
		}
        drawer++;
		add=play.handleInput();

		if(add==0){
			itr=0;
			closed.clear();
			squares.clear();;
			squares.add(enemy);
			il=0;
			for(int i=0;i<16;i++)
			{
				for (int j=0;j<11;j++){
					squares.add(new Square(numbX,numbY));
					squares.get(itr).setCosts(enemy,player);
					if(squares.get(itr).getX()==10&&squares.get(itr).getY()==7){
						squares.get(itr).setF(1000);
					}
					else if(squares.get(itr).getX()==10&&squares.get(itr).getY()==6){
						squares.get(itr).setF(1000);
					}
					else if(squares.get(itr).getX()==10&&squares.get(itr).getY()==5){
						squares.get(itr).setF(1000);
					}



					numbY+=44;
					itr++;

				}
				numbX +=40;
				numbY=0;
			}
			move=new movement(squares,player,enemy);
			open=move.getZ();



		}


		while (!open.isEmpty()){

			current=move.get();

			move=new movement(squares,player,current);
			closed.add(current);


			if(player.getX()==current.getX()&&player.getY()==current.getY()){

				open.clear();
				break;

			}else {


				for (int i=0;i<move.getZ().size();i++){
					if(NotIn(blocked,move.getZ().get(i))&&NotIn(closed,move.getZ().get(i))){

						open.add(move.getZ().get(i));


					}
					;

				}



			}


		}
		batch.end();

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
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	public boolean NotIn(ArrayList<Square> a,Square x){

	for(int i=0;i<a.size();i++){
		if(a.get(i).getY()-x.getY()<1 && a.get(i).getX()-x.getX()<1){

			return false;
		}

	}

    return true;}


		//

}
