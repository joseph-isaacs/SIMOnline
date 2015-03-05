package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.maths.Vector2d;

import static java.lang.System.identityHashCode;

/**
 * Created by Matt on 05/03/2015.
 */
public class BlockInanimateUnit extends InanimateUnit{



    @Override
    public void die() {

    }

    @Override
    public void draw(SIMGraphics g) {
        g.getGraphics().setColor(Color.gray);
        g.getGraphics().fillRect(0,0,g.getValidRectangle().getWidth(),g.getValidRectangle().getHeight());
    }

    @Override
    public void doUpdate() {

    }

    @Override
    public int compareTo(SIMUnit o) {
        return identityHashCode(this ) - identityHashCode(o);
    }
}
