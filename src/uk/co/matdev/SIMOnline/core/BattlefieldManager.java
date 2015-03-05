package uk.co.matdev.SIMOnline.core;


import uk.co.matdev.SIMOnline.maths.Vector2d;

import java.util.ArrayList;


/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject{


    private int[][] mUnitPositions;
    private Vector2d<Integer> mWorldSize = new Vector2d<>(20,20);
    private int mTileSize = 10;

    BattlefieldManager(){
        mUnitPositions = new int[mWorldSize.getX()][mWorldSize.getY()];
    }

    BattlefieldManager(Vector2d<Integer> ObjectLocation){
    }

    @Override
    public void draw(SIMGraphics g) {
    }

    @Override
    public void doUpdate() {
        ;
    }
}
