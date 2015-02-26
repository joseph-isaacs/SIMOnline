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
    public GraphicsImpSlick2d(Graphics g, Rectangle2d<Integer> validRectangle){
        setGraphicsContext(g);
        setValidRectangle(validRectangle);
    }

    /**
     *
     * @param g The
     * @see <a href="http://slick.ninjacave.com/javadoc/">Graphics</a>
     */
    public void setGraphicsContext(Graphics g){
        mGraphics = g;
        if(mValidRectangle != null)
            mGraphics.translate(mValidRectangle.getTopLeftX(), mValidRectangle.getTopLeftY());
    }

    @Override
    public Rectangle2d<Integer> setValidRectangle() {
        return mValidRectangle;
    }

    public Graphics getGraphicsContext(){
        return mGraphics;
    }

    public Rectangle2d<Integer> getValidRectangle(){
        return mValidRectangle;
    }

    @Override
    public void setValidRectangle(Rectangle2d validRectangle) {
        if(validRectangle == null)
            return;
        //will remove the old translation.
        if(mValidRectangle != null)
            mGraphics.translate(-mValidRectangle.getTopLeftX(), -mValidRectangle.getTopLeftY());
        mValidRectangle = validRectangle;

        //will apply the new translation.
        mGraphics.translate(mValidRectangle.getTopLeftX(), mValidRectangle.getTopLeftY());
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
        drawRectangle(rect.getTopLeftX(), rect.getTopLeftY(), rect.getWidth(), rect.getHeight(), filled);
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
    public void drawGradientLine(float x1, float y1, java.awt.Color color1, float x2, float y2, java.awt.Color color2) {
        mGraphics.drawGradientLine(
                x1,
                y1,
                new org.newdawn.slick.Color(color1.getRed(), color1.getGreen(), color1.getBlue(), color1.getAlpha()),
                x2,
                y2,
                new org.newdawn.slick.Color(color2.getRed(), color2.getGreen(), color2.getBlue(), color2.getAlpha())
        );
    }

    @Override
    public void setColor(java.awt.Color c) {
        mGraphics.setColor(new org.newdawn.slick.Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()));
    }
}
