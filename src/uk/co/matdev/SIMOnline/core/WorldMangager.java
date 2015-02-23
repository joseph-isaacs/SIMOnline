package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class WorldMangager implements SIMObject{

    private int width = 100;
    private int height = 100;

    private int tileSize = 10;

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++){
                g.setColor(new Color(0,255,0,i*j % 255));
                g.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
            }
        }
    }

    @Override
    public void doUpdate() {
        ;
    }
}
