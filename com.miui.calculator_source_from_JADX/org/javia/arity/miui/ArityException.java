package org.javia.arity.miui;

public class ArityException extends RuntimeException {
    public ArityException(String str) {
        super(str);
    }

    public ArityException(int i) {
        this("Didn't expect " + i + " arguments");
    }
}
