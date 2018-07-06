package net.ntxt.expressions.evaluation;

import org.junit.Assert;
import org.junit.Test;

public class NumberComparatorTest {

    @Test
    public void compare(){
        int a = 1;
        int b = 2;
        double c = 3.0;
        double d = 2.0;

        NumberComparator comp = new NumberComparator();

        Assert.assertEquals(-1, comp.compare(a, b));
        Assert.assertEquals(-1, comp.compare(a, c));
        Assert.assertEquals(0, comp.compare(b, d));
    }

}