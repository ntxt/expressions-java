package net.ntxt.expressions.evaluation;

import org.junit.Assert;
import org.junit.Test;

public class BaseComparatorTest {
    @Test
    public void compareItems(){

        BaseComparator comp = new BaseComparator();
        Assert.assertEquals("1 is less than two, expect -1",-1, comp.compare(1, 2));
        Assert.assertEquals("2 is greater than 1, expect +1",1, comp.compare(2, 1));
        Assert.assertEquals("2 and 2 are equal, expect 0",0, comp.compare(2, 2));

        Assert.assertEquals("c is less than d, expect -1",-1, comp.compare("c", "d"));
        Assert.assertEquals("d is greater than c, expect +1",1, comp.compare("d", "c"));
        Assert.assertEquals("d and d are equal, expect 0",0, comp.compare("d", "d"));

        try{
            comp.compare(null, 2);
            Assert.fail("Null argument should have thrown an exception");
        }catch(IllegalArgumentException e){
            Assert.assertTrue(true);
        }
        try{
            comp.compare(2, null);
            Assert.fail("Null argument should have thrown an exception");
        }catch(IllegalArgumentException e){
            Assert.assertTrue(true);
        }

        // Different types are cast to strings and compared
        Assert.assertEquals( 0, comp.compare("2", 2));
        Assert.assertEquals( 0, comp.compare(Long.valueOf(2), 2));
    }

}