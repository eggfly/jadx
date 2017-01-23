package org.javia.arity.miui;

public class Derivative extends Function {
    private final Function f4921b;
    private Complex f4922c;

    public Derivative(Function function) {
        this.f4922c = new Complex();
        this.f4921b = function;
        function.m6631b(1);
    }

    public double m6714a(double d) {
        return this.f4921b.m6626a(this.f4922c.m6669a(d, 1.0E-12d)).f4909b * 1.0E12d;
    }

    public int m6715a() {
        return 1;
    }
}
