package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

import java.util.Random;


/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject{

    private SIMUnit[][] mUnitPositions;
    private Vector2d<Integer> mWorldSize = new Vector2d<>(20,20);
    private int mTileSize = 10;

    /**
     * will create a matrix
     * M[0][1]
     *  - -
     * | | |
     * |X| |
     *
     *  M[1][0]
     *  - -
     * | |X|
     * | | |
     */
    BattlefieldManager(){
        mUnitPositions = new SIMUnit[mWorldSize.getX()][mWorldSize.getY()];
    }


    BattlefieldManager(Vector2d<Integer> ObjectLocation){
    }

    @Override
    public void draw(SIMGraphics g) {
    }

    @Override
    public void doUpdate() {
        for (int x = 0; x != mUnitPositions.length; x++) {
            for (int y = 0; y != mUnitPositions[x].length; y++) {
                SIMUnit unit = mUnitPositions[x][y];
                if(unit != null){
                    updateHelper(unit, x, y, false);
                }
            }
        }
    }

    private void updateHelper(SIMUnit unit, int x, int y, boolean hitOnce){

        int newXPos = x + unit.getTargetVelocity().getX();
        int newYPos = y + unit.getTargetVelocity().getY();
        SIMUnit otherUnit = mUnitPositions[newXPos][newYPos];

        if (!moveUnit(unit, x, y, newXPos, newYPos)) {
            Vector2d<Integer> afterVelocity = unit.collision(otherUnit);
            newXPos = x + afterVelocity.getX();
            newYPos = y + afterVelocity.getY();
            if(!moveUnit(unit, x,y,newXPos,newYPos)){
                Vector2d<Integer> afterVelocity2 = unit.collision(otherUnit);
                newXPos = x + afterVelocity2.getX();
                newYPos = y + afterVelocity2.getY();
                if(!moveUnit(unit, x, y, newXPos, newYPos))
                    return;
            }

        }
    }

    private boolean moveUnit(SIMUnit unit, int x, int y, int newXPos, int newYPos){
        if(mUnitPositions[newXPos][newYPos] == null) {
            mUnitPositions[newXPos][newYPos] = unit;
            mUnitPositions[x][y] = null;
            return true;
        }
        else if(mUnitPositions[newXPos][newYPos].equals(unit))
            return true;
        return false;
    }
}
