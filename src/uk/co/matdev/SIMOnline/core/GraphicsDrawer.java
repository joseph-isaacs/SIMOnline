package uk.co.matdev.SIMOnline.core;

import org.newdawn.slick.Graphics;

/**
 * Created by joeisaacs on 24/02/2015.
 */
public class GraphicsDrawer {
    //This class will own the GraphicsImp?
    //Don't know if this is better or other class should just have
    //access to GraphicsImp directly.


    //could added a method the check if a class is drawing outside of it's bounds.
    GraphicsImp mImp;

    GraphicsDrawer(GraphicsImp imp){
        mImp = imp;
    }
}
