package net.ntxt.expressions.contexts;

public class ContextLookupException extends RuntimeException {
    public ContextLookupException(String message, Throwable cause) {
        super(message, cause);
    }
    public ContextLookupException(String message) {
        super(message);
    }
}
