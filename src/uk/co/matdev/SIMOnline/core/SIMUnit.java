package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.SIMRandom;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 05/03/2015.
 */
public abstract class SIMUnit implements SIMObject{

    protected Vector2d<Integer> mVelocity;
    protected Vector2d<Integer> mTargetVelocity;

    protected int mMaxDamage;
    protected int mMinDamage;
    protected int mCritMultiplyer;
    protected int mCritChance;
    protected int mHaste;

    protected int mHealth;
    protected int mDefence;
    protected int mDodgeChance;

    /**
     *
     * @param u
     * @return Will return the velocity vector of how to move after a collision.
     */
    public Vector2d<Integer> collision(SIMUnit u){
        if (u instanceof InanimateUnit){
            return updateTurningVelocity(); //Some random side to side vector
        }else{
            return null;
        }
    }

    public Vector2d<Integer> updateTurningVelocity(){
        Vector2d<Integer> v = computeTurningVelocity(mTargetVelocity, mVelocity);
        if (v.equals(new Vector2d<>(0,0))){
            v.setXY(mTargetVelocity.getX(), mTargetVelocity.getY());
        }
        mVelocity = new Vector2d<>(v);

        return new Vector2d<Integer>(mVelocity);
    }

    public static Vector2d<Integer> computeTurningVelocity(Vector2d<Integer> TargetVelocity, Vector2d<Integer> CurrentVelocity){
        if (TargetVelocity.getX().equals(CurrentVelocity.getX()) && TargetVelocity.getY().equals(CurrentVelocity.getY())){
            //Current and Target Velocities are equal, so choose a random sideways direction
            if (SIMRandom.range(0,1) == 0){
                return new Vector2d<>(-TargetVelocity.getY(),TargetVelocity.getX());
            }else{
                return new Vector2d<>(TargetVelocity.getY(),-TargetVelocity.getX());
            }
        }

        return new Vector2d<>(-CurrentVelocity.getX(),-CurrentVelocity.getY());
    }

    public abstract void die();


    public Vector2d<Integer> getVelocity() {
        return mVelocity;
    }

    public void setVelocity(Vector2d<Integer> velocity) {
        mVelocity = velocity;
    }

    public Vector2d<Integer> getTargetVelocity() {
        return mTargetVelocity;
    }

    public void setTargetVelocity(Vector2d<Integer> targetVelocity) {
        mTargetVelocity = targetVelocity;
    }

    public int getMaxDamage() {
        return mMaxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        mMaxDamage = maxDamage;
    }

    public int getMinDamage() {
        return mMinDamage;
    }

    public void setMinDamage(int minDamage) {
        mMinDamage = minDamage;
    }

    public int getCritMultiplyer() {
        return mCritMultiplyer;
    }

    public void setCritMultiplyer(int critMultiplyer) {
        mCritMultiplyer = critMultiplyer;
    }

    public int getCritChance() {
        return mCritChance;
    }

    public void setCritChance(int critChance) {
        mCritChance = critChance;
    }

    public int getHaste() {
        return mHaste;
    }

    public void setHaste(int haste) {
        mHaste = haste;
    }

    public int getHealth() {
        return mHealth;
    }

    public void setHealth(int health) {
        mHealth = health;
    }

    public int getDefence() {
        return mDefence;
    }

    public void setDefence(int defence) {
        mDefence = defence;
    }

    public int getDodgeChance() {
        return mDodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        mDodgeChance = dodgeChance;
    }
}
