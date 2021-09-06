package qbit.engine.movement;

import qbit.engine.ui.Obj;

import javax.swing.*;

public class Animation {
    ImageIcon images[];
    int interval;
    public boolean loop = false;
    Obj foro;
    public Animation(Obj f,ImageIcon imgs[],int change_interval){
        this.images = imgs;
        interval = change_interval;
        this.foro = f;
    }
    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0;i<images.length;i++){
                    try {
                        Thread.sleep(interval);
                        foro.setIco(images[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(loop)start();
            }
        }).start();
    }
}
