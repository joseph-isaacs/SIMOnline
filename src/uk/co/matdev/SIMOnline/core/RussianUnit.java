package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 05/03/2015.
 */
public abstract class RussianUnit extends SIMUnit{
    //All Russian Type Units inherit this class

    @Override
    public Vector2d<Integer> collision(SIMUnit unit){
        Vector2d v = super.collision(unit);
        if (v != null){
            return v;
        }

        //Assert: not colliding with inanimateUnit
        if (unit instanceof RussianUnit){
            return updateTurningVelocity();
        }else{
            return null;
        }
    }
}
