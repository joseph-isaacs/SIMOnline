package uk.co.matdev.SIMOnline.core.battle.player;

import uk.co.matdev.SIMOnline.core.battle.BattlefieldManager;
import uk.co.matdev.SIMOnline.core.battle.units.NormalSlimeUnit;
import uk.co.matdev.SIMOnline.maths.SIMRandom;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 12/03/2015.
 */
public class EasyAIPlayer implements SIMPlayer{


    @Override
    public void applySpawn(BattlefieldManager bm) {
        bm.spawnUnit(new NormalSlimeUnit(new Vector2d<Integer> (-1,0)),new Vector2d<Integer>(78, SIMRandom.range(2,40)));

    }
}
