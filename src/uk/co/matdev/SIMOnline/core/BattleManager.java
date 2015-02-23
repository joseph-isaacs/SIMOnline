package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattleManager implements SIMObject {

    BattlefieldManager mWorld = new BattlefieldManager();
    BattlefieldManager mWorld2 = new BattlefieldManager(new Vector2d<>(800, 20));

    @Override
    public void draw(Graphics g) {
        mWorld.draw(g);
        mWorld2.draw(g);
    }

    @Override
    public void doUpdate() {
        mWorld.doUpdate();
    }
}