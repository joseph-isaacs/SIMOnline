package uk.co.matdev.SIMOnline.maths;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class Vector2d<T> {
    T mX;
    T mY;

    public Vector2d(T x, T y){
        mX = x;
        mY = y;
    }

    public T getX(){return mX;}
    public T getY(){return mY;}

    public void setX(T x){mX = x;}
    public void setY(T y){mY = y;}
}
