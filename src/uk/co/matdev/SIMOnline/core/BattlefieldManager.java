package uk.co.matdev.SIMOnline.core;


import java.awt.Color;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject{

    private Vector2d<Integer> mObjectLocation, mObjectSize;
    private Vector2d<Integer> mWorldSize = new Vector2d<>(20,20);
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
    public void draw(GraphicsImp g) {
        //This command could be used to offset the graphics with object location?
       // g.translate(mObjectLocation.getX(),mObjectLocation.getY());

        //Background to the battlefield
        g.setColor(new java.awt.Color(20,20,20,255));
        //g.fillRect(0,0,(mWorldSize.getX())* (mTileSize+ 1), (mWorldSize.getY())* (mTileSize + 1));

        //Fill grid with green squares
        for (int i = 0; i < mWorldSize.getX(); i++) {
            for(int j = 0; j < mWorldSize.getY(); j++){
                g.setColor(new Color(0,255,0,255));
                g.drawRectangle(i * mTileSize + i, j * mTileSize + j, mTileSize, mTileSize, true);
            }
        }
        g.setColor(new Color(255,0,0,255));
        g.drawRectangle(new Rectangle2d<Float>(30f,30f,10f,10f), true);
    }

    @Override
    public void doUpdate() {
        ;
    }
}
