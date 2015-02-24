package uk.co.matdev.SIMOnline.slick2d;


import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.core.GraphicsImp;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;

import java.awt.Color;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class GraphicsImpSlick2d implements GraphicsImp {
    Graphics mGraphics;
    Rectangle2d<Integer> mValidRectangle;

    //only makes sense to instantiate this class with a validRectangle.
    GraphicsImpSlick2d(Graphics g, Rectangle2d<Integer> validRectangle){
        setValidRectangle(validRectangle);
        setGraphicsContext(g);
    }


    public void setGraphicsContext(Graphics g){
        mGraphics = g;
        if(mValidRectangle != null)
            mGraphics.translate(mValidRectangle.getLeftBottomX(), mValidRectangle.getLeftBottomY());
    }

    public Graphics getGraphicsContext(){
        return mGraphics;
    }

    public Rectangle2d<Integer> getValidRectangle(){
        return mValidRectangle;
    }

    @Override
    public void setValidRectangle(Rectangle2d validRectangle) {
        //will remove the old translation.
        if(mValidRectangle != null)
            mGraphics.translate(-mValidRectangle.getLeftBottomX(), -mValidRectangle.getLeftBottomY());
        mValidRectangle = validRectangle;

        //will apply the new translation.
        mGraphics.translate(mValidRectangle.getLeftBottomX(), mValidRectangle.getLeftBottomY());
    }

    @Override
    public void drawRectangle(float x, float y, float width, float height, boolean filled) {
        if(filled)
            mGraphics.fillRect(x, y, width, height);
        else

            mGraphics.drawRect(x, y, width, height);
    }

    @Override
    public void drawRectangle(Rectangle2d<Float> rect, boolean filled) {
        drawRectangle(rect.getLeftBottomX(), rect.getLeftBottomY(), rect.getWidth(), rect.getHeight(), filled);
    }


    @Override
    public void drawLine(float xStart, float yStart, float xEnd, float yEnd) {
        mGraphics.drawLine(xStart, yStart, xEnd, yEnd);
    }

    @Override
    public void drawRoundedRectangle(float x, float y, float width, float height, int cornerRadius, int numberOfSegments) {
        mGraphics.drawRoundRect(x,y,width,height,cornerRadius,numberOfSegments);
    }

    @Override
    public void drawArc(float x1, float y1, float width, float height, int segments, float start, float end) {
        mGraphics.drawArc(x1,y1,width,height,segments,start,end);
    }

    @Override
    public void drawGradientLine(float x1, float y1, java.awt.Color colour1, float x2, float y2, java.awt.Color colour2) {
        mGraphics.drawGradientLine(
                x1,
                y1,
                new org.newdawn.slick.Color(colour1.getRed(), colour1.getGreen(), colour1.getBlue(), colour1.getAlpha()),
                x2,
                y2,
                new org.newdawn.slick.Color(colour2.getRed(), colour2.getGreen(), colour2.getBlue(), colour2.getAlpha())
        );
    }
}
