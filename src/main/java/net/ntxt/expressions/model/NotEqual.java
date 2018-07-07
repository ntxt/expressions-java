package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;
import net.ntxt.expressions.operators.CompareOps;

public class NotEqual extends AbstractExpNode {

    public NotEqual(Expression... exps) {
        this(new Args(exps));
    }

    public NotEqual(Args args) {
        this.op = CompareOps.NotEqual;
        this.args = args;
        this.op.validOrThrow(args);
    }
}
