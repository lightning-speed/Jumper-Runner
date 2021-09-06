package qbit.engine.movement;

import qbit.engine.ui.Obj;

public class Gravity {
    public int ground_y = 0;
    double temp = 0;
    public boolean canPull = false;
    public int pull_speed = 0;
    public int time_interval=0;
    public Obj in_obj = null;
    public Gravity(Obj obj) {
       in_obj = obj;
    }
    public void setGroundY(int ground){
      ground_y = ground;
    }
    public void setPullSpeed(int speed){
      pull_speed = speed;
    }
    public void setTime_interval(int in){
        time_interval = in;
    }
    public void start(){
        temp = 0;
        canPull = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
               for(;canPull;){
                   try {
                       Thread.sleep(time_interval);
                       if(in_obj.getY()<ground_y){
                           in_obj.setY(in_obj.getY()+(int)temp);
                       }
                       if(temp<pull_speed)temp+=0.2;
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }
    public void stop(){
        canPull = false;
    }
}
