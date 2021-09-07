package qbit.engine;

import javax.swing.*;
import java.awt.*;

public class Activity{
    boolean isRunning = false;
    public  void update(){ }
    public Activity(){
     isRunning = true;
    }
    public void startRender(int in){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;isRunning;) {
                    try {
                        Thread.sleep(in);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    update();
                }
            }
        }).start();
    }
    public void end(){
        isRunning = false;
    }
}
