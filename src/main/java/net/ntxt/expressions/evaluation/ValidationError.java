package net.ntxt.expressions.evaluation;

import net.ntxt.expressions.ValidationResult;

public class ValidationError implements ValidationResult {

    private final String msg;

    public ValidationError(String msg){
        this.msg = msg;
    }

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}
