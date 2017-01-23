package org.javia.arity.miui;

public class EvalContext {
    double[] f4929a;
    final Complex[] f4930b;
    int f4931c;
    double[] f4932d;
    double[] f4933e;
    Complex[] f4934f;
    Complex[] f4935g;

    public EvalContext() {
        this.f4929a = new double[128];
        this.f4930b = new Complex[128];
        this.f4931c = 0;
        this.f4932d = new double[1];
        this.f4933e = new double[2];
        for (int i = 0; i < 128; i++) {
            this.f4930b[i] = new Complex();
        }
        this.f4934f = new Complex[]{new Complex()};
        this.f4935g = new Complex[]{new Complex(), new Complex()};
    }
}
