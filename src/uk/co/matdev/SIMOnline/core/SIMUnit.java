package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 05/03/2015.
 */
public abstract class SIMUnit implements SIMObject{
    Vector2d<Integer> mPosition;
    Vector2d<Integer> mVelocity;

    int mMaxDamage;
    int mMinDamage;
    int mCritMultiplyer;
    int mCritChance;
    int mHaste;

    int mHealth;
    int mDefence;
    int mDodgeChance;

    /**
     *
     * @param u
     * @return Will return the velocity vector of how to move after a collision.
     */
    public abstract Vector2d<Integer> collision(SIMUnit u);

    public abstract void die();
}
