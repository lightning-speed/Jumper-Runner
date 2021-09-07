package qbit.engine.ui;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text, Color color,int size,int x,int y,int width){
        super(text);
        setLocation(x,y);
        setSize(width,size+10);
        setFont(new Font("Arial",Font.PLAIN,size));
        setForeground(color);
    }
}
