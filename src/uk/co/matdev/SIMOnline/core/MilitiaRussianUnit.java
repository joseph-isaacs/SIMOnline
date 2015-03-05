package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.maths.Vector2d;

import static java.lang.System.identityHashCode;

/**
 * Created by Matt on 05/03/2015.
 */
public class MilitiaRussianUnit extends RussianUnit {

    MilitiaRussianUnit(Vector2d<Integer> targetVelocity){
        mTargetVelocity = new Vector2d<Integer>(targetVelocity);
        mVelocity = new Vector2d<Integer>(targetVelocity);
    }

    @Override
    public Vector2d<Integer> collision(SIMUnit unit, boolean frontCollision){
        Vector2d v = super.collision(unit, frontCollision);
        if (v != null){
            return v;
        }

        //Assert: not colliding with inanimateUnit or RussianUnit
        //Therefore, definitely something to fight
        //TODO: Add code for fighting
        return new Vector2d<Integer>(0,0);
    }

    @Override
    public void die() {

    }

    @Override
    public void draw(SIMGraphics g) {
        g.getGraphics().setColor(Color.red);
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
