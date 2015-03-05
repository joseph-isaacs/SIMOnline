package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 05/03/2015.
 */
public class MilitiaRussianUnit extends RussianUnit {

    @Override
    public Vector2d<Integer> collision(SIMUnit unit){
        Vector2d v = super.collision(unit);
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
}
