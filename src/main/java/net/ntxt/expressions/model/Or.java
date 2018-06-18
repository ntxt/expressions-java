package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;
import net.ntxt.expressions.operators.BoolOps;

public class Or extends AbstractExpNode {

    public Or(Expression... exps){
        this(new Args(exps));
    }

    public Or(Args args) {
        this.op = BoolOps.Or;
        this.args = args;
        getOp().validOrThrow(args);
    }
}
