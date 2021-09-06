package qbit.engine.movement;

import qbit.engine.ui.Obj;

public class Movement {
    public static void moveX(Obj obj, int speed, int time, int to_x){
        new Thread(new Runnable() {
            @Override
            public void run() {
                double temp  = 0;
                boolean cn = true;
                for(;cn;){
                    try {
                        Thread.sleep(time);
                        if(to_x>obj.getX()){obj.setX(obj.getX()+(int)speed);}
                        else if(to_x<obj.getX()){obj.setX(obj.getX()-(int)speed);}
                        if(Math.abs(obj.getX()-to_x)<=speed)cn=false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public static void moveY(Obj obj, int speed, int time, int to_y){
        new Thread(new Runnable() {
            @Override
            public void run() {
                double temp  = 0;
                boolean cn = true;
                for(;cn;){
                    try {
                        Thread.sleep(time);
                        if(to_y>obj.getY()){obj.setY(obj.getY()+(int)temp);}
                        else if(to_y<obj.getY()){obj.setY(obj.getY()-(int)temp);}
                        if(Math.abs(obj.getY()-to_y)<=speed)cn=false;
                        if(temp<speed)temp+=0.1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
