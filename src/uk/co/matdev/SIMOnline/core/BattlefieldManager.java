package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject{

    private Vector2d<Integer> mObjectLocation, mObjectSize;
    private Vector2d<Integer> mWorldSize = new Vector2d<>(80,80);
    private int mTileSize = 10;

    BattlefieldManager(){
        mObjectLocation = new Vector2d<>(0,0);
        mObjectSize = new Vector2d<>(mWorldSize.getX()*mTileSize,mWorldSize.getY()*mTileSize);
    }

    BattlefieldManager(Vector2d<Integer> ObjectLocation){
        mObjectLocation = new Vector2d<>(ObjectLocation.getX(),ObjectLocation.getY());
        mObjectSize = new Vector2d<>(mWorldSize.getX()*mTileSize,mWorldSize.getY()*mTileSize);
    }

    @Override
    public void draw(Graphics g) {
        //This command could be used to offset the graphics with object location?
        g.translate(mObjectLocation.getX(),mObjectLocation.getY());

        //Background to the battlefield
        g.setColor(new Color(20,20,20,255));
        g.fillRect(0,0,(mWorldSize.getX())* (mTileSize+ 1), (mWorldSize.getY())* (mTileSize + 1));

        //Fill grid with green squares
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
