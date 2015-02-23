package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class WorldMangager implements SIMObject{

    private Vector2d<Integer> mWorldSize = new Vector2d<>(80,80);



    private int mTileSize = 10;

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(20,20,20,255));
        g.fillRect(0,0,(mWorldSize.getX()+10)* mTileSize, (10+ mWorldSize.getY())* mTileSize);
        for (int i = 0; i < mWorldSize.getX(); i++) {
            for(int j = 0; j < mWorldSize.getY(); j++){
                g.setColor(Color.green);
                g.fillRect(i* mTileSize + i, j* mTileSize + j, mTileSize, mTileSize);
            }
        }
    }

    @Override
    public void doUpdate() {
        ;
    }
}
