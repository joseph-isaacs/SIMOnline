package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ViewMangager implements SIMObject {

    WorldMangager mWorld = new WorldMangager();

    @Override
    public void draw(Graphics g) {
        mWorld.draw(g);
    }

    @Override
    public void doUpdate() {
        mWorld.doUpdate();
    }
}