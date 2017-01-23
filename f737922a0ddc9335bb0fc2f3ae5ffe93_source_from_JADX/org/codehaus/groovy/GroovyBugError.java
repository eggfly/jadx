package org.codehaus.groovy;

public class GroovyBugError extends AssertionError {
    private final Exception DW;
    private String j6;

    public GroovyBugError(String str) {
        this(str, null);
    }

    public GroovyBugError(String str, Exception exception) {
        this.DW = exception;
        this.j6 = str;
    }

    public String toString() {
        return getMessage();
    }

    public String getMessage() {
        if (this.j6 != null) {
            return "BUG! " + this.j6;
        }
        return "BUG! UNCAUGHT EXCEPTION: " + this.DW.getMessage();
    }

    public Throwable getCause() {
        return this.DW;
    }
}
