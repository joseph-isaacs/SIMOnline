package uk.co.matdev.SIMOnline.core.battle.units;

import uk.co.matdev.SIMOnline.core.battle.CollisionReport;
import uk.co.matdev.SIMOnline.core.battle.eDeaths;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 10/03/2015.
 */
public abstract class SlimeUnit extends SIMUnit{
    //All slime units inherit this class

    @Override
    public CollisionReport collision(SIMUnit unit, boolean frontCollision){
        CollisionReport r = super.collision(unit, frontCollision);
        if (r != null){
            return r;
        }

        //Assert: not colliding with inanimateUnit
        if (unit instanceof SlimeUnit){
            return new CollisionReport(updateTurningVelocity(frontCollision), eDeaths.NONE);
        }else{
            //Assert: not colliding with inanimateUnit or SlimeUnit
            //Therefore, definitely something to fight
            if (fighting){
                fighting = false;
                return new CollisionReport(new Vector2d<Integer>(0,0), fight(unit));
            }else{
                fighting = true;
                return new CollisionReport(new Vector2d<Integer>(0,0), eDeaths.NONE);
            }
        }
    }
}
