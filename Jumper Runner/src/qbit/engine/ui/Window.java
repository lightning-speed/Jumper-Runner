package qbit.engine.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import java.awt.event.WindowStateListener;

public class Window extends JFrame {
    public static View view = null;
    public Window() {
        this.setSize(200, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(new Color(70, 70, 70));
        this.setLayout(null);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        Thread.sleep(200);
                        setBackground(new Color(70, 70, 70));
                        view.setBounds((getWidth() - view.getWidth()) / 2, (getHeight() - view.getHeight()) / 2, view.getWidth(), view.getHeight());
                        repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
    public void setView(View view){
        this.view = view;
        add(this.view);
        view.setBounds((getWidth()-view.getWidth())/2,(int)((getHeight()-view.getHeight())/2),view.getWidth(),view.getHeight());
    }
    public void removeView(){
        remove(this.view);
    }
}
