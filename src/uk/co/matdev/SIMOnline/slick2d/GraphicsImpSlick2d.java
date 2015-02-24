package uk.co.matdev.SIMOnline.slick2d;


import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.core.GraphicsImp;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class GraphicsImpSlick2d implements GraphicsImp {
    Graphics mGraphics;


    GraphicsImpSlick2d(Graphics g){
        mGraphics = g;
    }


    @Override
    public void drawRectangle(float x, float y, float width, float height) {
        mGraphics.drawRect(x,y,width,height);
    }
}
