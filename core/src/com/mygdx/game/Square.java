package com.mygdx.game;

public class Square {
    float x,y;int h,f;
    int g,ycord,xcord;
    Square(float x,float y){
        locationgrid loc= new locationgrid(x,y);
        this.x=loc.getXcord();
        this.y=loc.getYcord();



    }


    public void setH(Square goal) {
        int a=Math.abs((int)(x-goal.getX()));
        int b=Math.abs((int)(y-goal.getY()));
        h=a+Math.abs(b-a);

    }

    public void setG(Square home) {

        int a=(int)(x-home.getX());
        int b=(int)(y-home.getY());
        g=Math.abs(Math.min(a,b));


    }

    public int getH() {
        return h;
    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setF(int m) {
        f = m;
    }

    public void setCosts(Square prev, Square target) {

       setH(target);
       setG(prev);

        int a=(int)(x-prev.getX());
        int b=(int)(y-prev.getY());
        g=Math.abs(Math.min(a,b));
        int l=Math.abs((int)(x-target.getX()));
        int r=Math.abs((int)(y-target.getY()));
        h=Math.abs(l+r);

        f = g +h;

        setF(g+h);
    }

    public int getG() {
        return g;
    }

    public int getF() {

        return f;
    }

}
