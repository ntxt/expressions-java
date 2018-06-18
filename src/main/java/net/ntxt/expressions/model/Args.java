package net.ntxt.expressions.model;

import net.ntxt.expressions.Expression;

import java.util.Arrays;
import java.util.stream.Stream;

public class Args  {

    private final Expression[] args;

    public Args(Expression... args) {
        for(Expression e : args){
            if(e == null) throw new IllegalArgumentException("Null expression given");
        }
        this.args = args;
    }


    public Stream<Expression> get() {
        return Arrays.stream(args);
    }

    @Override
    public String toString(){
        return Arrays.toString(args);
    }

}
