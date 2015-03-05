package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;

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
}
