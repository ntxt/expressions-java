package net.ntxt.expressions;

import java.sql.Date;

/** a terminal node of evalutation tree */
public interface ExpLeaf extends Expression {

    Object valueOf(Context context);
//    Boolean asBoolean();
//    Long asLong();
//    String asString();
//    Date asDate();

    @Override
    default ExpLeaf evaluate(Context context) {
        return this;
    }
}
