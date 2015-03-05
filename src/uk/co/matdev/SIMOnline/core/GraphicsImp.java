package uk.co.matdev.SIMOnline.core;


import uk.co.matdev.SIMOnline.maths.Rectangle2d;

import java.awt.Color;

/**
 * <p>
 * This is a Graphics implementation interface that
 * is meant to be sub classed to provide implementations
 * of how to draw to the screen in different ways.
 * </p>
 * <p>
 * There is also a notion of of a part {@link Rectangle2d}  of the screen which
 * it is valid to draw on it is up to the subclasses to choose
 * to inforce this
 * </p>
 */
public interface GraphicsImp {
    //specific classes will implements this interface meaning that the graphics backend can be swapped out.

    /**
     *
     * @param validRectangle
     * This is a rectangle in which the graphics should be drawn.
     * @see Rectangle2d
     */

    void setValidRectangle(Rectangle2d<Integer> validRectangle);

    Rectangle2d<Integer> setValidRectangle();

    /**
     *
     * @param x The x position of the bottom left corner of the rectangle
     * @param y The y position of the bottom left corner of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param filled Whether the rectangle should be filled
     *
     */

    void drawRectangle(float x, float y,float width, float height, boolean filled);

    /**
     *
     * @param rect The rectangle to be drawn
     * @param filled Whether the rectangle should be filled
     * @see Rectangle2d
     */

    void drawRectangle(Rectangle2d<Float> rect, boolean filled);

    void drawLine(float xStart, float yStart, float xEnd, float yEnd);

    void drawRoundedRectangle(float x, float y, float width, float height, int cornerRadius, int numberOfSegments);

    void drawArc(float x1, float y1, float width, float height, int segments, float start, float end);

    void drawGradientLine(float x1, float y1, Color Color1, float x2, float y2, Color Color2);

    void setColor(Color c);

    void drawText(String value, float x, float y );
}
