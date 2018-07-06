package net.ntxt.expressions.model;

import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {

    private ValNumeric expNum1 = new ValNumeric(1);
    private ValNumeric expNum2 = new ValNumeric(2);
    private ValBoolean expBool = ValBoolean.TRUE;

    @Test
    public void get() {
        Args args = new Args(expNum1, expNum2, expBool);
        Assert.assertEquals(3, args.get().count());
    }

    @Test
    public void first() {
        Args args = new Args(expNum1, expNum2, expBool);
        Assert.assertEquals(expNum1, args.first());
    }

    @Test
    public void second() {
        Args args = new Args(expNum1, expNum2, expBool);
        Assert.assertEquals(expNum2, args.second());
    }

    @Test
    public void size() {
        Args args = new Args(expNum1, expNum2, expBool);
        Assert.assertEquals(3, args.size());
    }

    @Test
    public void toStringTest() {
        Args args = new Args(expNum1, expNum2, expBool);
        Assert.assertEquals("[1, 2, TRUE]", args.toString());
    }
}