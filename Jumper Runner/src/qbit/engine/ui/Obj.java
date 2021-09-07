package qbit.engine.ui;

import javax.swing.*;
import java.awt.*;

public class Obj extends JButton {
    public Obj(int width,int height,ImageIcon image){
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setSize(width,height);
        this.setIcon(new ImageIcon(new ImageIcon(image.getImage()).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
    public void setY(int y){
        setLocation(getX(),y);
    }
    public void setX(int x){
        setLocation(x,getY());
    }
    public void setIco(ImageIcon image){
        this.setIcon(new ImageIcon(new ImageIcon(image.getImage()).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));

    }
}