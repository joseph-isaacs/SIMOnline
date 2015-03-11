package uk.co.matdev.SIMOnline.maths;

/**
 * Created by joeisaacs on 23/02/2015.
 */
public class Vector2d<T> implements Cloneable{
    T mX;
    T mY;

    public Vector2d(T x, T y){
        mX = x;
        mY = y;
    }

    public Vector2d(Vector2d<T> v){
        mX = v.getX();
        mY = v.getY();
    }

    public T getX(){return mX;}
    public T getY(){return mY;}

    public void setX(T x){mX = x;}
    public void setY(T y){mY = y;}
    public void setXY(T x, T y){mX = x; mY = y;}


    public boolean equals(Vector2d o) {
        return mX.equals(o.mX) && mY.equals(o.mY);
    }


}
