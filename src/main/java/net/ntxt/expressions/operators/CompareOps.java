package net.ntxt.expressions.operators;

import net.ntxt.expressions.Context;
import net.ntxt.expressions.ExpLeaf;
import net.ntxt.expressions.Operator;
import net.ntxt.expressions.ValidationResult;
import net.ntxt.expressions.evaluation.BaseComparator;
import net.ntxt.expressions.evaluation.Valid;
import net.ntxt.expressions.evaluation.ValidationError;
import net.ntxt.expressions.model.Args;
import net.ntxt.expressions.model.ValBoolean;

import java.lang.reflect.Type;
import java.util.Comparator;

public enum CompareOps implements Operator {
    Equal {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {
            return args.get().map(e -> e.evaluate(context).valueOf(context)).distinct().count() == 1 ?
                    ValBoolean.TRUE :
                    ValBoolean.FALSE;
        }
    },
    NotEqual {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {

            return args.get().map(e -> e.evaluate(context).valueOf(context)).distinct().count() > 1 ?
                    ValBoolean.TRUE :
                    ValBoolean.FALSE;
        }
    },
    GreaterThan {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {
            Object a = args.first().evaluate(context).valueOf(context);
            Object b = args.second().evaluate(context).valueOf(context);
            return comparator.compare(a, b) > 0 ?
                    ValBoolean.TRUE :
                    ValBoolean.FALSE;
        }
    };

    private final static Comparator comparator = new BaseComparator();

    @Override
    public Type type() {
        return Boolean.TYPE;
    }

    @Override
    public ValidationResult validate(Args args) {
        if (args == null) {
            return new ValidationError("Null arguments given");
        } else if (args.size() != 2) {
            return new ValidationError("Comparison needs exactly two arguments, given: " + args.toString());
        } else {
            return Valid.OK;
        }
    }

    @Override
    public void validOrThrow(Args args) {
        ValidationResult res = validate(args);
        if (!res.isValid()) throw new IllegalArgumentException(res.getErrorMsg());
    }
}
