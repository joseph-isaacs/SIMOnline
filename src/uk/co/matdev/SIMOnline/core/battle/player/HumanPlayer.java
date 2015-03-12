package uk.co.matdev.SIMOnline.core.battle.player;

import org.lwjgl.Sys;
import org.newdawn.slick.Input;

import org.newdawn.slick.KeyListener;

/**
 * Created by joeisaacs on 12/03/2015.
 */
public class HumanPlayer implements SIMPlayer, KeyListener {

    public HumanPlayer(Input input){
        input.addKeyListener(this);
        System.out.println("set this");
    }


    @Override
    public void keyPressed(int i, char c) {
        System.out.println(c +" : "+  i);
    }

    @Override
    public void keyReleased(int i, char c) {

    }

    @Override
    public void setInput(Input input) {

    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }
}
