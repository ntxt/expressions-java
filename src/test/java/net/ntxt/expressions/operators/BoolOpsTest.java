package net.ntxt.expressions.operators;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;
import net.ntxt.expressions.Operator;
import net.ntxt.expressions.evaluation.Valid;
import net.ntxt.expressions.model.Args;
import net.ntxt.expressions.model.ValBoolean;
import net.ntxt.expressions.model.ValNumeric;
import org.junit.Assert;
import org.junit.Test;

public class BoolOpsTest {

    private final ExpLeaf tru = ValBoolean.TRUE;
    private final ExpLeaf fal = ValBoolean.FALSE;
    private final Context c = null;


    @Test
    public void type() {
        for(BoolOps op : BoolOps.values()){
            Assert.assertEquals(op.name() + " has to be Boolean", Boolean.TYPE, op.type());
        }
    }

    @Test
    public void evaluateAnd() {

        BoolOps op = BoolOps.And;

        assertResult(op, new Args(tru, tru), tru);
        assertResult(op, new Args(tru, fal), fal);
        assertResult(op, new Args(fal, tru), fal);
        assertResult(op, new Args(fal, fal), fal);

        assertResult(op, new Args(tru, tru, tru), tru);
        assertResult(op, new Args(tru, tru, fal), fal);
        assertResult(op, new Args(fal, fal, fal), fal);
    }

    @Test
    public void evaluateOr() {

        BoolOps op = BoolOps.Or;

        assertResult(op, new Args(tru, tru), tru);
        assertResult(op, new Args(tru, fal), tru);
        assertResult(op, new Args(fal, tru), tru);
        assertResult(op, new Args(fal, fal), fal);

        assertResult(op, new Args(tru, tru, tru), tru);
        assertResult(op, new Args(tru, tru, fal), tru);
        assertResult(op, new Args(fal, fal, fal), fal);
    }

    @Test
    public void validate() {
        ExpLeaf num = new ValNumeric(7);
        Assert.assertEquals( Valid.OK, BoolOps.And.validate(new Args(tru, fal, fal)) );
        Assert.assertNotEquals( Valid.OK, BoolOps.And.validate(new Args(tru, fal, num)) );
    }

    @Test
    public void validOrThrow() {
        ExpLeaf num = new ValNumeric(7);

        try {
            BoolOps.And.validOrThrow(new Args(tru, fal));
            Assert.assertTrue(true);
        }catch(IllegalArgumentException e){
            Assert.fail("All boolean arguments should not trigger an exception");
        }

        try {
            BoolOps.And.validOrThrow(new Args(tru, fal, num));
            Assert.fail("A numeric argument should trigger an exception in Boolean operation");
        }catch(IllegalArgumentException e){
            Assert.assertEquals("One of the arguments is not boolean: 7", e.getMessage());
        }
    }

    private void assertResult(Operator op, Args args, ExpLeaf assertedRes){
        Assert.assertEquals(op.evaluate(c, args), assertedRes);
    }
}