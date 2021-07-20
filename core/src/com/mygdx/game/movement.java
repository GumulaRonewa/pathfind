package com.mygdx.game;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by gmlron001 on 2018/10/14.
 */

public class movement {

    ArrayList<Square> squares;
    Square dest;
    Square begin;
    movement(ArrayList<Square> a,Square b,Square c){
        squares=a;
        dest=b;
        begin=c;
        squares.remove(c);




    }

    public Square get() {
        return  min(removeDuplicates(order()));

    }
    public ArrayList<Square> getZ() {
        ArrayList<Square> s=removeDuplicates(order());

        return s;
    }



    public ArrayList<Square> order(){
        ArrayList<Square> sq=new ArrayList<Square>();
        for (int i=2;i<squares.size();i++){
           int x=(int)(begin.getX()-squares.get(i).getX());
            int y=(int)(begin.getY()-squares.get(i).getY());
            if(begin.getX()==squares.get(i).getX()&&begin.getY()==squares.get(i).getY()){
                continue;
            }
            if(Math.abs(y)<=1 && Math.abs(x)<=1){

                sq.add(squares.get(i));
            }

        }



        return sq;

    }

    public Square min(ArrayList<Square> a){

        Square min=a.get(0);
        int x=(int)(min.getX());
        int y=(int)(min.getY());
        int xd=(int)(dest.getX());
        int yd=(int)(dest.getY());
        int posx=Math.abs(x-xd);
        int posy=Math.abs(y-yd);
        int beginx=(int)dest.getX();
        int beginy=(int)dest.getY();



        double desti =Math.sqrt(((xd-x)*(xd-x))+((yd-y)*(yd-y)));
        for (int i=0;i<a.size();i++){
            int v=(int)(a.get(i).getX());
            int k=(int)(a.get(i).getY());

            if(min.getF()>a.get(i).getF()){




                double pl=Math.sqrt(((xd-v)*(xd-v))+((yd-k)*(yd-k)));

                if(desti>pl){

                    min=a.get(i);
                }

                desti=Math.sqrt(((xd-v)*(xd-v))+((yd-k)*(yd-k)));






            }
        }

        return min;
    }

     ArrayList<Square> removeDuplicates(ArrayList<Square> list) {

        // Store unique items in result.
        ArrayList<Square> result = new ArrayList<Square>();


         for(int i=0;i<list.size();i++){
           if(!dublicate(result,list.get(i))){
               result.add(list.get(i));
           }

         }


        return list;
    }
    boolean dublicate(ArrayList<Square> a,Square x){
        for(int i=0;i<a.size();i++){
            if(a.get(i).getY()-x.getY()<1 && a.get(i).getX()-x.getX()<1){

                return true;
            }

        }

    return false;}

}
