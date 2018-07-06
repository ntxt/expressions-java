package net.ntxt.expressions;

import java.lang.reflect.Type;

public interface Context {

    ExpLeaf lookup(String name);

    default ExpLeaf createResultExpression(Object init, Type type){
        return new ExpLeaf() {
            @Override
            public Type type() {
                return type;
            }

            @Override
            public Object valueOf(Context c) {
                return init;
            }
        };

    }

}
