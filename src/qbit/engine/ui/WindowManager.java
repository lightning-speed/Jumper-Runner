package qbit.engine.ui;

import java.awt.*;

public class WindowManager {
    public static Window curentWindow = null;
    public static void createWindow(String name,int width,int height){
        curentWindow = new Window();
        curentWindow.setTitle(name);
        curentWindow.setSize(width,height);
        curentWindow.setLocationRelativeTo(null);
        curentWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    public static Window getWindow(){
        return  curentWindow;
    }
}
