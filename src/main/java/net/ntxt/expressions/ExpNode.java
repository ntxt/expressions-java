package net.ntxt.expressions;

import net.ntxt.expressions.model.Args;

import java.util.stream.Stream;

public interface ExpNode extends Expression {
    /** The operator, implementing the evaluation */
    Operator getOp();
    /** Zero or more operands for the operator */
    Stream<Expression> getArgs();

}
