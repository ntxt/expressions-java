package net.ntxt.expressions.model;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;

import java.lang.reflect.Type;

public enum ValBoolean implements ExpLeaf {

    TRUE {
        @Override
        public Object valueOf(Context c) {
            return Boolean.TRUE;
        }

        @Override
        public String toString() {
            return "TRUE";
        }
    },
    FALSE {
        @Override
        public Object valueOf(Context c) {
            return Boolean.FALSE;
        }

        @Override
        public String toString() {
            return "FALSE";
        }
    };


    @Override
    public Type type() {
        return Boolean.TYPE;
    }


}
