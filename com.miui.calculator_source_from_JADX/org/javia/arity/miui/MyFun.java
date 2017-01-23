package org.javia.arity.miui;

class MyFun extends Function {
    Symbols f4964b;
    Function f4965c;

    MyFun() {
        this.f4964b = new Symbols();
        try {
            this.f4965c = this.f4964b.m6772c("1-x");
        } catch (SyntaxException e) {
            System.out.println("" + e);
        }
    }

    public double m6741a(double d) {
        return this.f4965c.m6622a(d);
    }

    public int m6742a() {
        return 1;
    }
}
