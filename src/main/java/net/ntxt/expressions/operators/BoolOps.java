package net.ntxt.expressions.operators;

import net.ntxt.expressions.*;
import net.ntxt.expressions.evaluation.Valid;
import net.ntxt.expressions.evaluation.ValidationError;
import net.ntxt.expressions.model.Args;
import net.ntxt.expressions.model.ValBoolean;

import java.lang.reflect.Type;
import java.util.Optional;

public enum BoolOps implements Operator {
    And {
        @Override
        public ExpLeaf evaluate(Context context, Args args){
            return args.get()
                    .allMatch( a -> this.isTrue(a, context) ) ?
                    ValBoolean.TRUE : ValBoolean.FALSE;
        }
    },
    Or {
        @Override
        public ExpLeaf evaluate(Context context, Args args) {
            return args.get()
                    .anyMatch(a -> this.isTrue(a, context) ) ?
                    ValBoolean.TRUE : ValBoolean.FALSE;
        }
    };

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
