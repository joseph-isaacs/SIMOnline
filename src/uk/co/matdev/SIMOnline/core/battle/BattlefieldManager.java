package uk.co.matdev.SIMOnline.core.battle;

import com.sun.istack.internal.NotNull;
import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.core.battle.units.RussianUnit;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.SIMObject;
import uk.co.matdev.SIMOnline.core.battle.units.*;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.SIMRandom;
import uk.co.matdev.SIMOnline.maths.Vector2d;


/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattlefieldManager implements SIMObject {

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
    private int mTileSize = 15;
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
        for (int i = 0; i != mWorldSize.getY()-1; i++) {
            spawnUnit(new endUnit(), new Vector2d<Integer>(0, i));
            spawnUnit(new endUnit(), new Vector2d<Integer>(mWorldSize.getX()-1, i));
        }
    }

    public void spawnUnit(@NotNull SIMUnit toSpawn, Vector2d<Integer> where){
        if(checkGridPosition(where)){
            mUnitPositions[where.getX()][where.getY()] = new BattlefieldUnit(toSpawn, mBattlePhase);
        }
    }


    @Override
    public void draw(SIMGraphics g) {
        Rectangle2d<Integer> tmpRec = g.getValidRectangle();
        g.getGraphics().setColor(Color.lightGray);
        for (int i = 1; i < mWorldSize.getX() - 1; i++) {
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
    private boolean checkGridPosition(Vector2d<Integer> position){
        return checkGridPosition(position.getX(),position.getY());
    }

    private void updateHelper(BattlefieldUnit battleUnit, int x, int y){

        int newXPos = x + battleUnit.unit.getTargetVelocity().getX();
        int newYPos = y + battleUnit.unit.getTargetVelocity().getY();
        if(!checkGridPosition(newXPos, newYPos))
            return;
        BattlefieldUnit otherUnit = mUnitPositions[newXPos][newYPos];

        if (otherUnit != null
                && otherUnit.phase != mBattlePhase
                &&((battleUnit.unit instanceof RussianUnit && otherUnit.unit instanceof RussianUnit)
                    || (battleUnit.unit instanceof SlimeUnit && otherUnit.unit instanceof SlimeUnit))){
            //Need to update one in-front first
            updateHelper(otherUnit, newXPos, newYPos);
            mUnitPositions[x][y].phase = mBattlePhase;
        }
        if (moveUnit(battleUnit, x, y, newXPos, newYPos)) {
            battleUnit.unit.setVelocity(new Vector2d<Integer>(battleUnit.unit.getTargetVelocity()));
        }
        else{
            CollisionReport result = battleUnit.unit.collision(otherUnit.unit, true);
            if (!handleDeath(result,new Vector2d<Integer>(x,y),new Vector2d<Integer>(newXPos,newYPos))){
                return;
            }
            Vector2d<Integer> afterVelocity = result.getFinalVelocity();
            newXPos = x + afterVelocity.getX();
            newYPos = y + afterVelocity.getY();
            if(!checkGridPosition(newXPos, newYPos)) {
                battleUnit.unit.turnAround();
                return;
            }
            if(!moveUnit(battleUnit, x,y,newXPos,newYPos)){
                otherUnit = mUnitPositions[newXPos][newYPos];
                CollisionReport result2 = battleUnit.unit.collision(otherUnit.unit, false);
                if (!handleDeath(result2,new Vector2d<Integer>(x,y),new Vector2d<Integer>(newXPos,newYPos))){
                    return;
                }
                Vector2d<Integer> afterVelocity2 = result2.getFinalVelocity();
                newXPos = x + afterVelocity2.getX();
                newYPos = y + afterVelocity2.getY();
                if(!checkGridPosition(newXPos, newYPos))
                    return;
                if(!moveUnit(battleUnit, x, y, newXPos, newYPos)) {
                    otherUnit = mUnitPositions[newXPos][newYPos];
                    CollisionReport result3 = battleUnit.unit.collision(otherUnit.unit, false);
                    handleDeath(result3,new Vector2d<Integer>(x,y),new Vector2d<Integer>(newXPos,newYPos));
                    return;
                }
            }
        }
    }

    private boolean handleDeath(CollisionReport report, Vector2d<Integer> colliderPos, Vector2d<Integer> collidedPos){
        //Returns true if collider stays alive, or false if collider dies
        switch (report.getDeaths()){
            case NONE: return true;
            case COLLIDER:
                kill(colliderPos); break;
            case COLLIDED:
                kill(collidedPos);
                return true;
            case BOTH:
                kill(colliderPos);
                kill(collidedPos);
                break;
        }
        return false;
    }

    private void kill(Vector2d<Integer> position){
        if (checkGridPosition(position)){
            BattlefieldUnit battleUnit = mUnitPositions[position.getX()][position.getY()];
            if (battleUnit != null){
                battleUnit.unit.die();
                mUnitPositions[position.getX()][position.getY()] = null;
            }
        }
    }

    private boolean moveUnit(BattlefieldUnit battleUnit, int x, int y, int newXPos, int newYPos){
        if(x == newXPos && y == newYPos)
            return true;
        else if(mUnitPositions[newXPos][newYPos] == null) {
            mUnitPositions[newXPos][newYPos] = new BattlefieldUnit(battleUnit.unit, mBattlePhase);
            mUnitPositions[x][y] = null;
            battleUnit.unit.setFighting(false);

            return true;
        }
        return false;
    }
}
