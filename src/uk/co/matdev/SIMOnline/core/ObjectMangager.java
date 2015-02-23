package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectMangager {
    private List<SIMObject> object = new LinkedList<>();

    public ObjectMangager(){
        object.add(new WorldMangager());
    }


    public void update(){
        for(SIMObject r: object){
            r.doUpdate();
        }
    }

    public void render(Graphics g){
        for(SIMObject r: object){
            r.draw(g);
        }
    }
}
