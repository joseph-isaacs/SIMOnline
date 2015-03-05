package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 05/03/2015.
 */
public abstract class RussianUnit extends SIMUnit{
    //All Russian Type Units inherit this class

    public Vector2d<Integer> collision(SIMUnit u){
        Vector2d v = super.collision(u);
        if (v != null){
            return v;
        }
        return null;
    }
}
