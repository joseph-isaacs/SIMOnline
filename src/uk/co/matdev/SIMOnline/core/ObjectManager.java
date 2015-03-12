package uk.co.matdev.SIMOnline.core;

import com.sun.istack.internal.NotNull;
import org.newdawn.slick.Input;
import uk.co.matdev.SIMOnline.core.battle.units.SIMUnit;
import uk.co.matdev.SIMOnline.maths.Vector2d;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class ObjectManager implements SIMObject{
    private List<SIMObject> objects = new LinkedList<>();

    public ObjectManager(){};
    public ObjectManager(Input input){}

    public void addObject(SIMObject o){
        objects.add(o);
    }


    @Override
    public void draw(SIMGraphics g) {
        objects.forEach((object) -> object.draw(g));
    }

    @Override
    public void doUpdate() {
        objects.forEach(SIMObject::doUpdate);
    }
}
