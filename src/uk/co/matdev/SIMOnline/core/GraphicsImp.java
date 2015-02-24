package uk.co.matdev.SIMOnline.core;


import uk.co.matdev.SIMOnline.maths.Rectangle2d;

import java.awt.Color;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public interface GraphicsImp {
    //specific classes will implements this interface meaning that the graphics backend can be swapped out.

    void setValidRectangle(Rectangle2d validRectangle);

    void drawRectangle(float x, float y,float width, float height, boolean filled);

    void drawRectangle(Rectangle2d<Float> rect, boolean filled);

    void drawLine(float xStart, float yStart, float xEnd, float yEnd);

    void drawRoundedRectangle(float x, float y, float width, float height, int cornerRadius, int numberOfSegments);

    void drawArc(float x1, float y1, float width, float height, int segments, float start, float end);

    void drawGradientLine(float x1, float y1, Color Color1, float x2, float y2, Color Color2);
}
