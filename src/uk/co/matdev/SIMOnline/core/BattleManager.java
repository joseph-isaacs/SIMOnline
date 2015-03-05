package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;
import uk.co.matdev.SIMOnline.maths.Vector2d;
import uk.co.matdev.SIMOnline.slick2d.GraphicsImpSlick2d;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class BattleManager implements SIMObject {

    BattlefieldManager mWorld = new BattlefieldManager();
    BattlefieldManager mWorld2 = new BattlefieldManager(new Vector2d<>(800, 20));

    @Override
    public void draw(GraphicsImp g) {
        g.setValidRectangle(new Rectangle2d<>(50,50,500,500));
        mWorld.draw(g);
        g.setValidRectangle(new Rectangle2d<>(500,50,950,950));
        mWorld2.draw(g);
    }

    @Override
    public void doUpdate() {
        mWorld.doUpdate();
    }
}