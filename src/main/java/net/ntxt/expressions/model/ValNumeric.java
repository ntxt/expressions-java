package net.ntxt.expressions.model;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ValNumeric implements ExpLeaf {

    private Object val;
    private Type type;


    public ValNumeric(Number val) {
        if(val == null) {
            throw new IllegalArgumentException("Cannot create ValNumeric from null");
        }
        this.val = val;
        this.type = val.getClass();
    }

    @Override
    public Object valueOf(Context c) {
        return this.val;
    }

    @Override
    public String toString() {
        return val.toString();
    }

    @Override
    public Type type() {
        return val.getClass();
    }

}
