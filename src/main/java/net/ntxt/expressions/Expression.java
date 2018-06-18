package net.ntxt.expressions;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public interface Expression {

    /** Run the operator against the arguments */
    ExpLeaf evaluate(Context context);
    /** should reflect the Operator type, but may be modified by arguments */
    Type type();
}
