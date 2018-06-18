package net.ntxt.expressions;

import net.ntxt.expressions.model.Args;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public interface Operator {
    ExpLeaf evaluate(Context context, Args args);
    ValidationResult validate(Args args);
    String name();
    Type type();

    void validOrThrow(Args args) throws IllegalArgumentException;
}
