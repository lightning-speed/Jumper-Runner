package qbit.engine.movement;

import qbit.engine.ui.Obj;

public class Colision {
    public static boolean areColiding(Obj from, Obj to){
        if((to.getWidth()+from.getWidth())/2>=Math.abs(from.getX()-to.getX())&&(to.getHeight()+from.getHeight())/2>=Math.abs(from.getY()-to.getY()))return true;
        return false;
    }
}
