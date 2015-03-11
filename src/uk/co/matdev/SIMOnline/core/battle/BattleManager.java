package uk.co.matdev.SIMOnline.core.battle;


import com.sun.istack.internal.NotNull;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.SIMObject;
import uk.co.matdev.SIMOnline.core.battle.units.SIMUnit;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattleManager implements SIMObject {

    BattlefieldManager mWorld = new BattlefieldManager();

    public void spawnUnit(@NotNull SIMUnit toSpawn, Vector2d<Integer> where){ mWorld.spawnUnit(toSpawn,where);}

    @Override
    public void draw(SIMGraphics g) {
        g.setValidRectangle(new Rectangle2d<>(50,50,500,500));
        mWorld.draw(g);
    }

    @Override
    public void doUpdate() {
        mWorld.doUpdate();
    }
}