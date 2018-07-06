package net.ntxt.expressions.operators;

import net.ntxt.expressions.*;
import net.ntxt.expressions.evaluation.BaseComparator;
import net.ntxt.expressions.evaluation.Valid;
import net.ntxt.expressions.evaluation.ValidationError;
import net.ntxt.expressions.model.Args;
import net.ntxt.expressions.model.ValBoolean;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.Optional;

public enum BoolOps implements Operator {
    And {
        @Override
        public ExpLeaf evaluate(Context context, Args args){
            return args.get()
                    .allMatch( a -> isTrue(a, context) ) ?
                    ValBoolean.TRUE : ValBoolean.FALSE;
        }
    },
    Or {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {
            return args.get()
                    .anyMatch(a -> isTrue(a, context) ) ?
                    ValBoolean.TRUE : ValBoolean.FALSE;
        }
    },
    Equals {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {
            return args.get().map( e -> e.evaluate(context).valueOf(context) ).distinct().count() == 1 ?
                    ValBoolean.TRUE :
                    ValBoolean.FALSE;
        }
    },
    NotEquals {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {

            return args.get().map( e -> e.evaluate(context).valueOf(context) ).distinct().count() > 1 ?
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

    protected boolean isTrue(Expression e, Context context){
        return e.evaluate(context).valueOf(context).equals(Boolean.TRUE);
    }


    @Override
    public Type type() { return Boolean.TYPE; }

    @Override
    public ValidationResult validate(Args args) {
        if(args == null){
            return new ValidationError("Null arguments given");
        }

        Optional nonBool = args.get().filter( a -> !a.type().equals(Boolean.TYPE) ).findAny();
        if(nonBool.isPresent()){
            return new ValidationError("One of the arguments is not boolean: " + nonBool.get().toString());
        }else{
            return Valid.OK;
        }
    }

    @Override
    public void validOrThrow(Args args) {
        ValidationResult res = validate(args);
        if( !res.isValid() ) throw new IllegalArgumentException(res.getErrorMsg());
    }
}
