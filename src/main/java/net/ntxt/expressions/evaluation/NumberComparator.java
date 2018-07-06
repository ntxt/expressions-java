package net.ntxt.expressions.evaluation;

import java.lang.reflect.Type;
import java.util.Comparator;

public class NumberComparator<T extends Number & Comparable<T>> implements Comparator<T> {

    @Override
    public int compare( T a, T b ) {
        Type typeA = a.getClass();
        Type typeB = b.getClass();
        if (typeA.equals(typeB)) {
            return (a.compareTo(b));
        } else {
            return a.toString().compareTo(b.toString());
        }
    }

}
