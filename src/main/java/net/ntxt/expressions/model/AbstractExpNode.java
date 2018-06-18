package net.ntxt.expressions.model;

import net.ntxt.expressions.*;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public class AbstractExpNode implements ExpNode {

    protected Args args;
    protected Operator op;

    @Override
    public Operator getOp() {
        return op;
    }

    @Override
    public Stream<Expression> getArgs() {
        return args.get();
    }

    @Override
    public Type type() { return op.type(); }

    @Override
    public ExpLeaf evaluate(Context context){
        return op.evaluate(context, args );
    }

    @Override
    public String toString(){
        return op.name() + ":" + args.toString();
    }
}
