package net.ntxt.expressions.model;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;

import java.lang.reflect.Type;

public class ValString implements ExpLeaf {
    private Object val;
    private Type type;


    public ValString(String val) {
        if(val == null) {
            throw new IllegalArgumentException("Cannot create ValString from null");
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
