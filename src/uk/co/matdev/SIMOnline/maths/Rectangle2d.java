package uk.co.matdev.SIMOnline.maths;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class Rectangle2d<T> {

    private T mLeftBottomX, mLeftBottomY, mHeight, mWidth;

    public T getLeftBottomX() {
        return mLeftBottomX;
    }

    public void setLeftBottomX(T leftBottomX) {
        this.mLeftBottomX = mLeftBottomX;
    }

    public T getLeftBottomY() {
        return mLeftBottomY;
    }

    public void setLeftBottomY(T leftBottomY) {
        this.mLeftBottomY = mLeftBottomY;
    }

    public T getHeight() {
        return mHeight;
    }

    public void setHeight(T height) {
        this.mHeight = mHeight;
    }

    public T getWidth() {
        return mWidth;
    }

    public void setWidth(T width) {
        this.mWidth = mWidth;
    }
}
