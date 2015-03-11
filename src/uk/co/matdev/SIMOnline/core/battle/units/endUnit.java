package uk.co.matdev.SIMOnline.core.battle.units;

import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 11/03/2015.
 */
public class endUnit extends SIMUnit {

    public endUnit(){
        mTargetVelocity = new Vector2d<Integer>(0,0);
    }

    @Override
    public void die() {
        ;
    }

    @Override
    public int compareTo(SIMUnit o) {
        return 0;
    }

    @Override
    public void draw(SIMGraphics g) {

    }

    @Override
    public void doUpdate() {

    }
}
