package uk.co.matdev.SIMOnline.core;


import org.newdawn.slick.Graphics;
import uk.co.matdev.SIMOnline.maths.Rectangle2d;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class SIMGraphics {
    Graphics mGraphics;
    Rectangle2d<Integer> mValidRectangle;

    //only makes sense to instantiate this class with a validRectangle.
    public SIMGraphics(Graphics g, Rectangle2d<Integer> validRectangle){
        setGraphicsContext(g);
        setValidRectangle(validRectangle);
    }

    /**
     *
     * @param g The graphics context
     * @see <a href="http://slick.ninjacave.com/javadoc/">Graphics</a>
     */
    public void setGraphicsContext(Graphics g){
        mGraphics = g;
        if(mValidRectangle != null)
            mGraphics.translate(mValidRectangle.getTopLeftX(), mValidRectangle.getTopLeftY());
    }

    public Rectangle2d<Integer> setValidRectangle() {
        return mValidRectangle;
    }

    public Graphics getGraphics(){
        return mGraphics;
    }

    public Rectangle2d<Integer> getValidRectangle(){
        return mValidRectangle;
    }

    public void setValidRectangle(Rectangle2d<Integer> validRectangle) {
        if(validRectangle == null)
            return;
        //will remove the old translation.
        if(mValidRectangle != null)
            mGraphics.translate(validRectangle.getTopLeftX()-mValidRectangle.getTopLeftX(),validRectangle.getTopLeftY() -mValidRectangle.getTopLeftY());
        else{
            mGraphics.translate(validRectangle.getTopLeftX(), validRectangle.getTopLeftY());
        }
        mValidRectangle = validRectangle;

        //will apply the new translation.
    }
}
