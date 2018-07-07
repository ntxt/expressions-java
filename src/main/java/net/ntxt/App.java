package net.ntxt;

import net.ntxt.expressions.ExpLeaf;
import net.ntxt.expressions.ExpNode;
import net.ntxt.expressions.model.*;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ExpLeaf tru = ValBoolean.TRUE;
        ExpLeaf fal = ValBoolean.FALSE;
        ExpLeaf one = new ValNumeric(1);
        ExpLeaf alot = new ValNumeric(BigDecimal.valueOf(1,10));
        ExpLeaf cat = new ValString("cat");
        ExpLeaf dog = new ValString("dog");
        ExpNode and = new And(tru, tru, tru, fal);
        ExpNode or = new Or(tru, fal);
        ExpNode greater = new GreaterThan(alot, one);
        ExpNode same = new Equal(cat, cat);
        ExpNode different = new NotEqual(dog, cat);
        ExpNode complex = new Or(same, different);




        System.out.println(and.evaluate(null));
        System.out.println(or.evaluate(null));
        ExpNode andor = new Or(and, or);
        System.out.println(andor.evaluate(null));
        System.out.println(greater.evaluate(null));
        System.out.println(same.evaluate(null));
        System.out.println(different.evaluate(null));
        System.out.println(complex.evaluate(null));

    }
}
