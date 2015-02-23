package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectManager {
    private List<SIMObject> object = new LinkedList<>();

    public ObjectManager(){
        object.add(new WorldMangager());
    }


    public void update(){
        object.forEach(SIMObject::doUpdate);
    }

    public void render(Graphics g){
        object.forEach((object) -> object.draw(g));
    }
}
