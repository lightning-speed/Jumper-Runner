package qbit.engine.ui;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    ImageIcon back  = null;
    @Override
    public void paintComponent(Graphics g){
        if(back !=null) {

            g.drawImage(back.getImage(), 0, 0, null);
        }
    }
    public View(){
        this.setLayout(null);
    }
    public void draw(Component c){
        add(c);
    }
    public void setBack(ImageIcon image){
        back = image;
    }
}
