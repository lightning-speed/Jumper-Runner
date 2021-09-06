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
    Obj objects[] = new Obj[100];
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
            @Override public void keyPressed(KeyEvent e) { if(sprite.getY()<407&&e.getKeyChar()==' '&&!isJumping)jump(); }
            @Override public void keyReleased(KeyEvent e) { }
        });
        startRender(10);

    }
    public void update(){
        ot++;
        if(ot==800){
            makeObjects();
            ot = 0;
        }
        for(int i = 0;i<curBlock;i++){
            objects[i].setX(objects[i].getX()-1);
        }
        try {
            if(objects[curBlock-2].getX()<-505)g.setGroundY(3000);
            else g.setGroundY(400);
            System.out.println(objects[curBlock-2].getX());
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
        objects[curBlock] = new Obj(619,386,new ImageIcon("assets/images/building.png"));
        objects[curBlock].setLocation(1000,429);
        view.add(objects[curBlock]);
        curBlock++;
    }
}
