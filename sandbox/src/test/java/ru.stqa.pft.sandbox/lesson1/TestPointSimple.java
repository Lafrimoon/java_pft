package ru.stqa.pft.sandbox.lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPointSimple {
    @Test
    public void testFirst() {
        Point a = new Point (4,-3);
        Point b = new Point (1,-1);

        System.out.println(a.distanceTo(b));
        Assert.assertEquals(a.distanceTo(b), 3.605551275463989);
    }
}
