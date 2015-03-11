package uk.co.matdev.SIMOnline.core.battle.units;

import uk.co.matdev.SIMOnline.core.battle.CollisionReport;
import uk.co.matdev.SIMOnline.core.battle.eDeaths;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 05/03/2015.
 */
public abstract class RussianUnit extends SIMUnit {
    //All Russian Type Units inherit this class

    @Override
    public CollisionReport collision(SIMUnit unit, boolean frontCollision){
        CollisionReport r = super.collision(unit, frontCollision);
        if (r != null){
            return r;
        }

        //Assert: not colliding with inanimateUnit
        if (unit instanceof RussianUnit){
            return new CollisionReport(updateTurningVelocity(frontCollision), eDeaths.NONE);
        }else{
            //Assert: not colliding with inanimateUnit or RussianUnit
            //Therefore, definitely something to fight
            if (mFighting){
                mFighting = false;
                return new CollisionReport(new Vector2d<Integer>(0,0), fight(unit));
            }else{
                mFighting = true;
                return new CollisionReport(new Vector2d<Integer>(0,0), eDeaths.NONE);
            }
        }
    }
}
