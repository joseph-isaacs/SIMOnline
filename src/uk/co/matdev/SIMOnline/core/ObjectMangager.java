package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectMangager {
    private List<SIMObject> object;


    public ObjectMangager(List<SIMObject> object) {
        this.object = object;
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
