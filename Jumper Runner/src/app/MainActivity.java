package app;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import qbit.engine.Activity;
import qbit.engine.movement.Animation;
import qbit.engine.movement.Colision;
import qbit.engine.movement.Gravity;
import qbit.engine.ui.Obj;
import qbit.engine.ui.View;
import qbit.engine.ui.Window;
import qbit.engine.ui.WindowManager;

import javax.swing.*;
import java.awt.*;


public class MainActivity extends Activity {
    View view;
    int interval = 0;
    public void startApp(){
        view = new View();
        view.setSize(800,600);
        WindowManager.createWindow("Jumper Runner",800,600);
        WindowManager.getWindow().setView(view);
        view.setBack(new ImageIcon("assets/images/QBit.png"));
        startRender(1);
    }
    public void update(){
     interval++;
     if(interval==3000){
         WindowManager.getWindow().removeView();
         end();
         view = null;
         new GameActivity().startApp();
     }
    }
}
