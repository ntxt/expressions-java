package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;
import net.ntxt.expressions.operators.CompareOps;

public class GreaterThan extends AbstractExpNode {

    public GreaterThan(Expression... exps) {
        this(new Args(exps));
    }

    public GreaterThan(Args args) {
        this.op = CompareOps.GreaterThan;
        this.args = args;
        this.op.validOrThrow(args);
    }
}
