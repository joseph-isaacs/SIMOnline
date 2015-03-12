package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * Created by Matt on 12/03/2015.
 */
public class Globals {
    private static Globals instance = null;

    //Battlefield:
    private static boolean mHealthBarsEnabled = false;

    protected Globals(){}
    public static Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }

        return instance;
    }

    public boolean isHealthBarsEnabled() {
        return mHealthBarsEnabled;
    }

    public void setHealthBarsEnabled(boolean healthBarsEnabled) {
        mHealthBarsEnabled = healthBarsEnabled;
    }
}
