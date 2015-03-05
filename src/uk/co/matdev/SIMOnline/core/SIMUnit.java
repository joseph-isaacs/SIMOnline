package uk.co.matdev.SIMOnline.core;

import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 05/03/2015.
 */
public abstract class SIMUnit implements SIMObject{

    Vector2d<Integer> Velocity;
    Vector2d<Integer> TargetVelocity;

    int MaxDamage;
    int MinDamage;
    int CritMultiplyer;
    int CritChance;
    int Haste;

    int Health;
    int Defence;
    int DodgeChance;

    /**
     *
     * @param u
     * @return Will return the velocity vector of how to move after a collision.
     */
    public Vector2d<Integer> collision(SIMUnit u){
        if (u instanceof InanimateUnit){
            return new Vector2d<>(0,0); //Some random side to side vector
        }else{
            return null;
        }
    }

    public abstract void die();


    public Vector2d<Integer> getVelocity() {
        return Velocity;
    }

    public void setVelocity(Vector2d<Integer> velocity) {
        Velocity = velocity;
    }

    public Vector2d<Integer> getTargetVelocity() {
        return TargetVelocity;
    }

    public void setTargetVelocity(Vector2d<Integer> targetVelocity) {
        TargetVelocity = targetVelocity;
    }

    public int getMaxDamage() {
        return MaxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        MaxDamage = maxDamage;
    }

    public int getMinDamage() {
        return MinDamage;
    }

    public void setMinDamage(int minDamage) {
        MinDamage = minDamage;
    }

    public int getCritMultiplyer() {
        return CritMultiplyer;
    }

    public void setCritMultiplyer(int critMultiplyer) {
        CritMultiplyer = critMultiplyer;
    }

    public int getCritChance() {
        return CritChance;
    }

    public void setCritChance(int critChance) {
        CritChance = critChance;
    }

    public int getHaste() {
        return Haste;
    }

    public void setHaste(int haste) {
        Haste = haste;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getDodgeChance() {
        return DodgeChance;
    }

    public void setDodgeChance(int dodgeChance) {
        DodgeChance = dodgeChance;
    }
}
