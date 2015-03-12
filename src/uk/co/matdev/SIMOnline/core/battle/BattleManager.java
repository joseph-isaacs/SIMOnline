package uk.co.matdev.SIMOnline.core.battle;


import com.sun.istack.internal.NotNull;
import org.newdawn.slick.Input;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.SIMObject;
import uk.co.matdev.SIMOnline.core.battle.player.EasyAIPlayer;
import uk.co.matdev.SIMOnline.core.battle.player.HumanPlayer;
import uk.co.matdev.SIMOnline.core.battle.player.SIMPlayer;
import uk.co.matdev.SIMOnline.core.battle.units.SIMUnit;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattleManager implements SIMObject {

    BattlefieldManager mWorld = new BattlefieldManager();

    private SIMPlayer p1;

    private SIMPlayer p2;

    public BattleManager(Input input){
        p1  = new HumanPlayer(input);
        p2  = new EasyAIPlayer();
    }

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