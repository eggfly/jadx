package org.javia.arity.miui;

public class Symbol {
    byte f4989a;
    Function f4990b;
    double f4991c;
    double f4992d;
    boolean f4993e;
    private String f4994f;
    private int f4995g;

    private Symbol(String str, int i, byte b, boolean z, int i2) {
        this.f4993e = false;
        m6761c(str, i);
        this.f4989a = b;
        this.f4993e = z;
    }

    Symbol(String str, Function function) {
        this.f4993e = false;
        m6761c(str, function.m6625a());
        this.f4990b = function;
    }

    Symbol(String str, double d, boolean z) {
        this(str, d, 0.0d, z);
    }

    Symbol(String str, double d, double d2, boolean z) {
        this.f4993e = false;
        m6761c(str, -3);
        this.f4991c = d;
        this.f4992d = d2;
        this.f4993e = z;
    }

    static Symbol m6757a(String str, int i) {
        return new Symbol(str, -3, (byte) (i + 38), false, 0);
    }

    static Symbol m6759b(String str, int i) {
        return new Symbol(str, VM.f5022b[i], (byte) i, true, 0);
    }

    public String toString() {
        return "Symbol '" + this.f4994f + "' arity " + this.f4995g + " val " + this.f4991c + " op " + this.f4989a;
    }

    static Symbol m6758a(Symbol symbol) {
        return new Symbol(symbol.f4994f, symbol.f4995g, (byte) 0, false, 0);
    }

    boolean m6760a() {
        return this.f4989a == null && this.f4990b == null && this.f4991c == 0.0d && this.f4992d == 0.0d;
    }

    Symbol m6761c(String str, int i) {
        this.f4994f = str;
        this.f4995g = i;
        return this;
    }

    public boolean equals(Object obj) {
        Symbol symbol = (Symbol) obj;
        return this.f4994f.equals(symbol.f4994f) && this.f4995g == symbol.f4995g;
    }

    public int hashCode() {
        return this.f4994f.hashCode() + this.f4995g;
    }
}
