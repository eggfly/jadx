package org.codehaus.groovy;

public class GroovyException extends Exception implements GroovyExceptionInterface {
    private boolean j6;

    public GroovyException() {
        this.j6 = true;
    }

    public GroovyException(String str, boolean z) {
        super(str);
        this.j6 = true;
        this.j6 = z;
    }
}
