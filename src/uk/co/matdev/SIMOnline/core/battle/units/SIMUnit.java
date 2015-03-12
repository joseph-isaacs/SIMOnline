package uk.co.matdev.SIMOnline.core.battle.units;

import org.newdawn.slick.Color;
import uk.co.matdev.SIMOnline.core.SIMGraphics;
import uk.co.matdev.SIMOnline.core.SIMObject;
import uk.co.matdev.SIMOnline.core.battle.CollisionReport;
import uk.co.matdev.SIMOnline.core.battle.eDeaths;
import uk.co.matdev.SIMOnline.maths.SIMRandom;
import uk.co.matdev.SIMOnline.maths.Vector2d;

/**
 * Created by joeisaacs on 05/03/2015.
 */
public abstract class SIMUnit implements SIMObject, Comparable<SIMUnit>{

    protected Vector2d<Integer> mVelocity;
    protected Vector2d<Integer> mTargetVelocity;

    protected int mMaxDamage; // >= minDamage
    protected int mMinDamage; // >= 0
    protected int mCritMultiplier; // Percentage that damage multiples by (e.g. 150 would mean x150%)
    protected int mCritChance; // 0 <= Percentage <= 100
    protected int mHaste; // Any fairly small value relative to other units >= 0

    protected int mHealth; // 0 < Health <= MaxHealth
    protected int mMaxHealth;
    protected int mDefence; // >= 0
    protected int mDodgeChance; // 0 <= Percentage <= 100

    protected boolean mFighting = false;

    /**
     *
     * @param unit
     * @return Will return the velocity vector of how to move after a collision.
     */
    public CollisionReport collision(SIMUnit unit, boolean frontCollision){
        if (unit instanceof InanimateUnit){
            return new CollisionReport(updateTurningVelocity(frontCollision), eDeaths.NONE); //Some side to side motion
        }
        else if (unit instanceof endUnit) {
            return new CollisionReport(new Vector2d<Integer> (0,0), eDeaths.COLLIDER);
        }
        else{
            return null;
        }
    }

    protected void setAllStats(int MaxDamage, int MinDamage, int CritMultiplier, int CritChance, int Haste, int Health, int Defence, int DodgeChange){
        setMaxDamage(MaxDamage);
        setMinDamage(MinDamage);
        setCritMultiplier(CritMultiplier);
        setCritChance(CritChance);
        setHaste(Haste);
        setHealth(Health);
        setMaxHealth(Health);
        setDefence(Defence);
        setDodgeChance(DodgeChange);
    }

    protected Vector2d<Integer> updateTurningVelocity(boolean frontCollision){
        Vector2d<Integer> v = computeTurningVelocity(mTargetVelocity, mVelocity, frontCollision);
        if (v.equals(new Vector2d<>(0,0))){
            v.setXY(mTargetVelocity.getX(), mTargetVelocity.getY());
        }
        mVelocity = new Vector2d<>(v);

        return new Vector2d<Integer>(mVelocity);
    }

    public void turnAround(){
        mVelocity = new Vector2d<>(-mVelocity.getX(),-mVelocity.getY());
    }

    public static Vector2d<Integer> computeTurningVelocity(Vector2d<Integer> TargetVelocity, Vector2d<Integer> CurrentVelocity, boolean frontCollision){
        if (TargetVelocity.getX().equals(CurrentVelocity.getX()) && TargetVelocity.getY().equals(CurrentVelocity.getY())){
            //Current and Target Velocities are equal, so choose a random sideways direction
            if (SIMRandom.range(0,1) == 0){
                return new Vector2d<>(-TargetVelocity.getY(),TargetVelocity.getX());
            }else{
                return new Vector2d<>(TargetVelocity.getY(),-TargetVelocity.getX());
            }
        }
        if(frontCollision)
            return new Vector2d<>(CurrentVelocity);
        return new Vector2d<>(-CurrentVelocity.getX(),-CurrentVelocity.getY());
    }

    public abstract void die();

    protected eDeaths fight(SIMUnit enemy){
        //Makes no unit type check (should never need to)
        //Leaf unit type override this if they need special fight code
        //Decide who hits first

        //for each hit:
            //Decide if receiver dodges hit
            //Decide how much damage is done (does it crit? and by how much?)
            //Decide how much damage is reduced by receiver's defence
            //Update health of receiver
            //If receiver dies, return COLLIDED, else do other hit.
        //If attacker dies, return COLLIDER

        SIMUnit attacker, defender;
        eDeaths ifAttackerDies, ifDefenderDies;

        if (SIMRandom.range(1,100) < Math.ceil(this.getHaste()/(this.getHaste() + enemy.getHaste())*100)){
            //Attacker goes first
            attacker = this;
            ifAttackerDies = eDeaths.COLLIDER;
            defender = enemy;
            ifDefenderDies = eDeaths.COLLIDED;
        }else{
            attacker = enemy;
            ifAttackerDies = eDeaths.COLLIDED;
            defender = this;
            ifDefenderDies = eDeaths.COLLIDER;
        }

        if (oneHit(attacker, defender)){
            return ifDefenderDies;
        }else if (oneHit(defender, attacker)){
            return ifAttackerDies;
        }

        return eDeaths.NONE;
    }

    protected boolean oneHit(SIMUnit attacker, SIMUnit defender){
        //return true if defender dies

        if (SIMRandom.range(0,99) < defender.getDodgeChance()){
            //Defender successfully dodges
            defender.hasDodged(attacker);
        }else{
            int baseDmg = SIMRandom.range(attacker.getMinDamage(),attacker.getMaxDamage());
            if (SIMRandom.range(0,99) < attacker.getCritChance()) {
                baseDmg *= attacker.getCritMultiplier();
            }
            baseDmg -= defender.getDefence();
            if (baseDmg < 0){
                baseDmg = 0;
            }
            baseDmg = attacker.aboutToAttack(baseDmg, defender);
            baseDmg = defender.aboutToDefend(baseDmg, attacker);
            defender.setHealth(defender.getHealth() - baseDmg);
            attacker.hasAttacked(baseDmg, defender);
            defender.hasDefended(baseDmg, attacker);
            if (defender.getHealth() <= 0){
                attacker.hasKilled(defender);
                defender.killedBy(attacker);
                return true;
            }
        }

        return false;
    }

    private void hasKilled(SIMUnit defender) {}

    private void killedBy(SIMUnit defender) {
        System.out.println("Died, leaving attacker with " + defender.getHealth() + " health.");
        System.out.println();
    }

    private void hasAttacked(int baseDmg, SIMUnit defender) {}

    private void hasDefended(int baseDmg, SIMUnit defender) {}

    protected int aboutToAttack(int baseDmg, SIMUnit defender) {
        return baseDmg;
    }

    protected int aboutToDefend(int baseDmg, SIMUnit attacker) {
        return baseDmg;
    }

    protected void hasDodged(SIMUnit attacker){}

    public Vector2d<Integer> getVelocity() {
        return mVelocity;
    }

    protected void drawHealthBar(SIMGraphics g){
        //Calculate length of bar in pixels
        int a = (int) Math.ceil((float) getHealth() / (float) getMaxHealth() * (float) (g.getValidRectangle().getWidth() - 2));
        //Draw white background
        g.getGraphics().setColor(Color.white);
        g.getGraphics().fillRect(0,g.getValidRectangle().getHeight()/2-2,g.getValidRectangle().getWidth(),4);
        //Draw red health fill
        g.getGraphics().setColor(Color.red);
        g.getGraphics().fillRect(1,g.getValidRectangle().getHeight()/2-1,a,2);
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

    public int getCritMultiplier() {
        return mCritMultiplier;
    }

    public void setCritMultiplier(int critMultiplier) {
        mCritMultiplier = critMultiplier;
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

    public boolean isFighting() {
        return mFighting;
    }

    public void setFighting(boolean fighting) {
        mFighting = fighting;
    }

    public int getMaxHealth() {
        return mMaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        mMaxHealth = maxHealth;
    }
}
