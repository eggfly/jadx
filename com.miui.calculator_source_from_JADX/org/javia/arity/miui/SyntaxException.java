package org.javia.arity.miui;

public class SyntaxException extends Exception {
    public String f5003a;
    public String f5004b;
    public int f5005c;

    public String toString() {
        return "SyntaxException: " + this.f5004b + " in '" + this.f5003a + "' at position " + this.f5005c;
    }

    SyntaxException m6773a(String str, int i) {
        this.f5004b = str;
        this.f5005c = i;
        fillInStackTrace();
        return this;
    }
}
