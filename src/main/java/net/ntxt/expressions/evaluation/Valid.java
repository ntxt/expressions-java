package net.ntxt.expressions.evaluation;

import net.ntxt.expressions.ValidationResult;

public enum Valid implements ValidationResult {
    OK;

    @Override
    public Boolean isValid() {
        return Boolean.TRUE;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }
}
