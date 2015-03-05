package uk.co.matdev.SIMOnline.maths;

import com.sun.istack.internal.NotNull;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class Rectangle2d<T> {

    private T mTopLeftX, mTopLeftY, mHeight, mWidth;

    public Rectangle2d(T topLeftX, T topLeftY, T height, T width){
        mTopLeftX = topLeftX;
        mTopLeftY = topLeftY;
        mHeight = height;
        mWidth = width;
    }



    public T getTopLeftX() {
        return mTopLeftX;
    }

    public void getTopLeftX(T leftBottomX) {
        this.mTopLeftX = mTopLeftX;
    }

    public T getTopLeftY() {
        return mTopLeftY;
    }

    public void setTopLeftY(T leftBottomY) {
        this.mTopLeftY = mTopLeftY;
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
