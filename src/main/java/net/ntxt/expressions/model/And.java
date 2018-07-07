package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;
import net.ntxt.expressions.operators.BoolOps;

public class And extends AbstractExpNode {

    public And(Expression... exps) {
        this(new Args(exps));
    }

    public And(Args args) {
        this.op = BoolOps.And;
        this.args = args;
        this.op.validOrThrow(args);
    }


}
