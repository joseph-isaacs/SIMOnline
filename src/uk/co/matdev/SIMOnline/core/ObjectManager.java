package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectManager implements SIMObject{
    private List<SIMObject> objects = new LinkedList<>();

    public ObjectManager(){}

    public void addObject(SIMObject o){
        objects.add(o);
    }

    @Override
    public void draw(GraphicsImp g) {
        objects.forEach((object) -> object.draw(g));
    }

    @Override
    public void doUpdate() {
        objects.forEach(SIMObject::doUpdate);
    }
}
