package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;
import net.ntxt.expressions.operators.CompareOps;

public class Equal extends AbstractExpNode {

    public Equal(Expression... exps) {
        this(new Args(exps));
    }

    public Equal(Args args) {
        this.op = CompareOps.Equal;
        this.args = args;
        this.op.validOrThrow(args);
    }
}
