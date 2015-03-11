package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.maths.Vector2d;

import static java.lang.System.identityHashCode;

/**
 * Created by Matt on 10/03/2015.
 */
public class NormalSlimeUnit extends SlimeUnit {

    NormalSlimeUnit(Vector2d<Integer> targetVelocity){
        mTargetVelocity = new Vector2d<Integer>(targetVelocity);
        mVelocity = new Vector2d<Integer>(targetVelocity);

        //MAXDAM_MINDAM_CRITMULT_CRITCHANCE_HASTE_HEALTH_DEFENCE_DODGE
        setAllStats(10,7,2,5,60,100,5,5);
    }

    @Override
    public Vector2d<Integer> collision(SIMUnit unit, boolean frontCollision){
        Vector2d v = super.collision(unit, frontCollision);
        if (v != null){
            return v;
        }

        //Assert: not colliding with inanimateUnit or SlimeUnit
        //Therefore, definitely something to fight
        //TODO: Add code for fighting
        return new Vector2d<Integer>(0,0);
    }

    @Override
    public void die() {

    }

    @Override
    public void draw(SIMGraphics g) {
        if (mTargetVelocity.getY() == -1){
            g.getGraphics().setColor(Color.black);
        }else{
            g.getGraphics().setColor(Color.green);
        }

        g.getGraphics().fillOval(0, 0, g.getValidRectangle().getWidth(), g.getValidRectangle().getHeight());
    }

    @Override
    public void doUpdate() {

    }

    @Override
    public int compareTo(SIMUnit o) {
        return identityHashCode(this ) - identityHashCode(o);
    }

}
