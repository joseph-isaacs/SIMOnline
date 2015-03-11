package uk.co.matdev.SIMOnline.core.battle;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by Matt on 11/03/2015.
 */
public class CollisionReport {

    private Vector2d<Integer> mFinalVelocity;
    private eDeaths mDeaths;

    public CollisionReport(Vector2d<Integer> finalVelocity, eDeaths deaths){
        mFinalVelocity = finalVelocity;
        mDeaths = deaths;
    }

    public eDeaths getDeaths() {
        return mDeaths;
    }

    public Vector2d<Integer> getFinalVelocity() {
        return mFinalVelocity;
    }
}
