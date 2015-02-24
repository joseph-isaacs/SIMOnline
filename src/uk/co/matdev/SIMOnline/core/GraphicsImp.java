package uk.co.matdev.SIMOnline.core;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public interface GraphicsImp {
    //specific classes will implements this interface meaning that the graphics backend can be swapped out.
    void drawRectangle(float x, float y,float width, float height);
}
