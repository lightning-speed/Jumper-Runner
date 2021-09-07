package app;

import qbit.engine.Activity;
import qbit.engine.movement.Gravity;
import qbit.engine.movement.Movement;
import qbit.engine.ui.Obj;
import qbit.engine.ui.View;
import qbit.engine.ui.WindowManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameActivity extends Activity {
    View view;
    Gravity g;
    int ot = 0;
    int tempC  = 0;
    Obj objects[] = new Obj[100];
    Obj coins[] = new Obj[100];
    Obj sprite =   new Obj(40,40,new ImageIcon("assets/images/sprite.png"));
    Timer jt = null;
    int curBlock = 0;
    int jtt = 0;
    boolean isJumping  = false;
    public void jump(){
      isJumping = true;
    }
    public void startApp(){
        view = new View();
        view.setSize(800,600);
        WindowManager.getWindow().setView(view);
        view.setBack(new ImageIcon("assets/images/background.jpg"));
        view.draw(sprite);
        makeObjects();
        g = new Gravity(sprite);
        g.setPullSpeed(9);
        g.setGroundY(400);
        g.setTime_interval(20);
        sprite.setLocation(100,0);
        g.start();
        WindowManager.getWindow().addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) { }
            @Override public void keyPressed(KeyEvent e) { if(sprite.getY()<415&&e.getKeyChar()==' '&&!isJumping)jump(); }
            @Override public void keyReleased(KeyEvent e) { }
        });
        startRender(10);

    }
    public void gainCoin(int tempi){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<50;i++){
                    coins[tempi].setY(coins[tempi].getY()-2);
                    try {
                        Thread.sleep(8);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int i = 0;i<50;i++){
                    coins[tempi].setY(coins[tempi].getY()+2);
                    try {
                        Thread.sleep(6);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                coins[tempi].setVisible(false);
            }
        }).start();
    }
    public void update(){
        if(coins[tempC].getX()-1<=sprite.getX()){
            if(sprite.getY()>380)
            gainCoin(tempC);
            tempC++;
        }
        ot++;
        if(ot==800){
            makeObjects();
            ot = 0;
        }
        for(int i = 0;i<curBlock;i++){
            objects[i].setX(objects[i].getX()-1);
            coins[i].setX(coins[i].getX()-1);
        }
        try {
            if(objects[curBlock-2].getX()<-505)g.setGroundY(3000);
            else g.setGroundY(400);

        }catch (Exception e){}
      if(isJumping){
          g.stop();
          if(jtt<55){
              sprite.setLocation(sprite.getX(),sprite.getY()-3);
              jtt++;
          }
          else{
              g.start();
              isJumping =false;
              jtt = 0;
          }
      }
    }
    void makeObjects(){
        coins[curBlock] = new Obj(30,30,new ImageIcon("assets/images/coin.png"));
        coins[curBlock].setLocation((int)(1000+(Math.random()*1000)%500),390);
        view.add(coins[curBlock]);
        objects[curBlock] = new Obj(619,386,new ImageIcon("assets/images/building.png"));
        objects[curBlock].setLocation(1000,429);
        view.add(objects[curBlock]);
        curBlock++;
    }
}
