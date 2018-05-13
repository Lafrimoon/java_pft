package ru.stqa.pft.sandbox.lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPointSimple {
    @Test
    public void testPositive() {
        Point a = new Point (-4,-3);
        Point b = new Point (-1,-1);

        double l = a.distanceTo(b);
        //System.out.println(l);
        Assert.assertEquals(l, 3.605551275463989);
    }
    @Test
    public void testNegative() {
        Point a = new Point (4,13);
        Point b = new Point (1,20);

        double l = a.distanceTo(b);
        //System.out.println(l);
        Assert.assertEquals(l, 7.615773105863909);
    }
    @Test
    public void testZero() {
        Point a = new Point (0,0);
        Point b = new Point (0,0);

        double l = a.distanceTo(b);
        //System.out.println(l);
        Assert.assertEquals(l, 0.0);
    }
    @Test
    public void testDoubleSmall() {
        Point a = new Point (0.00004,0.00005);
        Point b = new Point (0.00001,0.00002);

        double l = a.distanceTo(b);
        //System.out.println(l);
        Assert.assertEquals(l, 4.2426406871192855E-5);
    }
    @Test
    public void testBig() {
        Point a = new Point (9999999,9999999);
        Point b = new Point (-9999999,-9999999);

        double l = a.distanceTo(b);
        //System.out.println(l);
        Assert.assertEquals(l, 2.8284268419034775E7);
    }
}
