package net.ntxt;

import net.ntxt.expressions.ExpLeaf;
import net.ntxt.expressions.ExpNode;
import net.ntxt.expressions.model.Or;
import net.ntxt.expressions.model.ValBoolean;
import net.ntxt.expressions.model.And;

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
        ExpNode and = new And(tru, tru, tru, fal);
        ExpNode or = new Or(tru, fal);
        System.out.println(and.evaluate(null));
        System.out.println(or.evaluate(null));
        ExpNode andor = new Or(and, or);
        System.out.println(andor.evaluate(null));

    }
}
