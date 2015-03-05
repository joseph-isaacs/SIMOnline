package uk.co.matdev.SIMOnline.maths;

/**
 * Created by Matt on 05/03/2015.
 */
public class SIMRandom {
    public static int range(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
