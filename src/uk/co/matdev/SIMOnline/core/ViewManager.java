package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ViewManager implements SIMObject {

    WorldManager mWorld = new WorldManager();

    @Override
    public void draw(Graphics g) {
        mWorld.draw(g);
    }

    @Override
    public void doUpdate() {
        mWorld.doUpdate();
    }
}