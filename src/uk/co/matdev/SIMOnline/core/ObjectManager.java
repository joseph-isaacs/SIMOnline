package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectManager {
    private List<SIMObject> objects = new LinkedList<>();

    public ObjectManager(){}

    public void update(){
        objects.forEach(SIMObject::doUpdate);
    }

    public void render(Graphics g){
        objects.forEach((object) -> object.draw(g));
    }

    public void addObject(SIMObject o){
        objects.add(o);
    }
}
