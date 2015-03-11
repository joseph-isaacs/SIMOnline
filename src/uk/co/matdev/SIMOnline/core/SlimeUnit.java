package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 10/03/2015.
 */
public abstract class SlimeUnit extends SIMUnit{
    //All slime units inherit this class

    @Override
    public Vector2d<Integer> collision(SIMUnit unit, boolean frontCollision){
        Vector2d v = super.collision(unit, frontCollision);
        if (v != null){
            return v;
        }

        //Assert: not colliding with inanimateUnit
        if (unit instanceof SlimeUnit){
            return updateTurningVelocity(frontCollision);
        }else{
            return null;
        }
    }
}
