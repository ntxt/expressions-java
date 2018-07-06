package net.ntxt.expressions.evaluation;

import java.lang.reflect.Type;
import java.util.Comparator;

public class BaseComparator implements Comparator {

    @Override
    public int compare(Object a, Object b) {
        if(a == null) {
            throw new IllegalArgumentException("First argument to compare is null");
        }
        if (b == null) {
            throw new IllegalArgumentException("Second argument to compare is null");
        }
        if (a.equals(b)) return 0;
        Type typeA = a.getClass();
        Type typeB = b.getClass();
        if (typeA.equals(typeB) && a instanceof Comparable) {
            return ((Comparable) a).compareTo(b);
        } else {
            return a.toString().compareTo(b.toString());
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
