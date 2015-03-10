package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;


/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject{

    private class BattlefieldUnit {
        BattlefieldUnit(SIMUnit unit){
            this.unit = unit;
            phase = mBattlePhase;
        }
        BattlefieldUnit(SIMUnit unit, boolean phase){
            this.unit = unit;
            this.phase = phase;
        }
        public boolean phase;
        public SIMUnit unit;

    }

    private BattlefieldUnit[][] mUnitPositions;
    private Vector2d<Integer> mWorldSize = new Vector2d<>(80,60);
    private int mTileSize = 10;
    private boolean mBattlePhase = false;

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
        mUnitPositions = new BattlefieldUnit[mWorldSize.getX()][mWorldSize.getY()];
        mUnitPositions[0][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[0][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[2][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[2][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[4][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[4][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));

        mUnitPositions[10][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[10][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][0] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][2] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));

        mUnitPositions[10][10] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[10][12] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][10] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][12] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][10] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][12] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));

        mUnitPositions[10][11] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[10][13] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][11] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[12][13] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][11] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));
        mUnitPositions[14][13] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));

        mUnitPositions[0][10] = new BattlefieldUnit(new MilitiaRussianUnit(new Vector2d<Integer>(1,0)));

        mUnitPositions[5][1] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][2] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][3] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][4] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][5] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][6] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][7] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][8] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][9] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][10] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][11] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][12] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][13] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][14] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][15] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][16] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][17] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][18] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[5][19] = new BattlefieldUnit(new BlockInanimateUnit());




        mUnitPositions[15][1] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][2] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][3] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][4] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][5] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[14][5] = new BattlefieldUnit(new BlockInanimateUnit());

        mUnitPositions[15][9] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[16][10] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][11] = new BattlefieldUnit(new BlockInanimateUnit());
        mUnitPositions[15][11] = new BattlefieldUnit(new BlockInanimateUnit());

    }


    @Override
    public void draw(SIMGraphics g) {
        Rectangle2d<Integer> tmpRec = g.getValidRectangle();
        g.getGraphics().setColor(Color.green);
        for (int i = 0; i < mWorldSize.getX(); i++) {
            for(int j = 0; j < mWorldSize.getY(); j++){
                g.getGraphics().fillRect(i * mTileSize + i, j * mTileSize + j, mTileSize, mTileSize);
            }
        }
        for (int x = 0; x != mUnitPositions.length; x++) {
            for (int y = 0; y != mUnitPositions[x].length; y++) {
                BattlefieldUnit unit = mUnitPositions[x][y];
                if(unit != null){
                    g.setValidRectangle(new Rectangle2d<Integer>(x*(mTileSize+1)+tmpRec.getTopLeftX(), y*(mTileSize+1)+tmpRec.getTopLeftX(), mTileSize, mTileSize));
                    unit.unit.draw(g);
                }
            }
        }
    }

    @Override
    public void doUpdate() {

        for (int x = 0; x != mUnitPositions.length; x++) {
            for (int y = 0; y != mUnitPositions[x].length; y++) {
                BattlefieldUnit battleUnit = mUnitPositions[x][y];
                if(battleUnit != null && battleUnit.phase != mBattlePhase && !(battleUnit.unit instanceof InanimateUnit)){
                    updateHelper(battleUnit, x, y);
                    if(mUnitPositions[x][y] != null)
                        mUnitPositions[x][y].phase = mBattlePhase;
                }
            }
        }
        mBattlePhase = !mBattlePhase;
    }


    private boolean checkGridPosition(int x, int y){
        if(x < 0 || y < 0 || x >= mUnitPositions.length || y >= mUnitPositions[0].length)
            return false;
        return true;
    }

    private void updateHelper(BattlefieldUnit battleUnit, int x, int y){

        int newXPos = x + battleUnit.unit.getTargetVelocity().getX();
        int newYPos = y + battleUnit.unit.getTargetVelocity().getY();
        if(!checkGridPosition(newXPos, newYPos))
            return;
        BattlefieldUnit otherUnit = mUnitPositions[newXPos][newYPos];

        if (moveUnit(battleUnit, x, y, newXPos, newYPos)) {
            battleUnit.unit.setVelocity(new Vector2d<Integer>(battleUnit.unit.getTargetVelocity()));
        }
        else{
            Vector2d<Integer> afterVelocity = battleUnit.unit.collision(otherUnit.unit, true);
            newXPos = x + afterVelocity.getX();
            newYPos = y + afterVelocity.getY();
            if(!checkGridPosition(newXPos, newYPos)) {
                battleUnit.unit.turnArround();
                return;
            }
            if(!moveUnit(battleUnit, x,y,newXPos,newYPos)){
                otherUnit = mUnitPositions[newXPos][newYPos];
                Vector2d<Integer> afterVelocity2 = battleUnit.unit.collision(otherUnit.unit, false);
                newXPos = x + afterVelocity2.getX();
                newYPos = y + afterVelocity2.getY();
                if(!checkGridPosition(newXPos, newYPos))
                    return;
                if(!moveUnit(battleUnit, x, y, newXPos, newYPos)) {
                    otherUnit = mUnitPositions[newXPos][newYPos];
                    battleUnit.unit.collision(otherUnit.unit, false);
                    return;
                }
            }
        }
    }

    private boolean moveUnit(BattlefieldUnit battleUnit, int x, int y, int newXPos, int newYPos){
         if(x == newXPos && y == newYPos)
            return true;
        else if(mUnitPositions[newXPos][newYPos] == null) {
             mUnitPositions[newXPos][newYPos] = new BattlefieldUnit(battleUnit.unit, mBattlePhase);
             mUnitPositions[x][y] = null;

             return true;
        }
        return false;
    }
}
