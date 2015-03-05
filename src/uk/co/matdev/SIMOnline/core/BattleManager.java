package uk.co.matdev.SIMOnline.core;


import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattleManager implements SIMObject {

    BattlefieldManager mWorld = new BattlefieldManager();
   // BattlefieldManager mWorld2 = new BattlefieldManager(new Vector2d<>(800, 20));

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