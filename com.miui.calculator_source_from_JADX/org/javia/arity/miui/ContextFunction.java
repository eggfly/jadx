package org.javia.arity.miui;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public abstract class ContextFunction extends Function {
    private static EvalContext f4889b;
    private static final double[] f4890c;
    private static final Complex[] f4891d;

    public abstract double m6641a(double[] dArr, EvalContext evalContext);

    public abstract Complex m6647a(Complex[] complexArr, EvalContext evalContext);

    static {
        f4889b = new EvalContext();
        f4890c = new double[0];
        f4891d = new Complex[0];
    }

    Complex[] m6649b(double[] dArr, EvalContext evalContext) {
        int i = 0;
        Complex[] complexArr;
        switch (dArr.length) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return f4891d;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                complexArr = evalContext.f4934f;
                complexArr[0].m6669a(dArr[0], 0.0d);
                return complexArr;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                complexArr = evalContext.f4935g;
                complexArr[0].m6669a(dArr[0], 0.0d);
                complexArr[1].m6669a(dArr[1], 0.0d);
                return complexArr;
            default:
                complexArr = new Complex[dArr.length];
                while (i < dArr.length) {
                    complexArr[i] = new Complex(dArr[i], 0.0d);
                    i++;
                }
                return complexArr;
        }
    }

    public double m6650c() {
        return m6640a(f4890c);
    }

    public double m6636a(double d) {
        double a;
        synchronized (f4889b) {
            a = m6639a(d, f4889b);
        }
        return a;
    }

    public double m6637a(double d, double d2) {
        double a;
        synchronized (f4889b) {
            a = m6638a(d, d2, f4889b);
        }
        return a;
    }

    public double m6640a(double[] dArr) {
        double a;
        synchronized (f4889b) {
            a = m6641a(dArr, f4889b);
        }
        return a;
    }

    public double m6639a(double d, EvalContext evalContext) {
        double[] dArr = evalContext.f4932d;
        dArr[0] = d;
        return m6641a(dArr, evalContext);
    }

    public double m6638a(double d, double d2, EvalContext evalContext) {
        double[] dArr = evalContext.f4933e;
        dArr[0] = d;
        dArr[1] = d2;
        return m6641a(dArr, evalContext);
    }

    public Complex m6648b() {
        return m6646a(f4891d);
    }

    public Complex m6642a(Complex complex) {
        Complex a;
        synchronized (f4889b) {
            a = m6645a(complex, f4889b);
        }
        return a;
    }

    public Complex m6643a(Complex complex, Complex complex2) {
        Complex a;
        synchronized (f4889b) {
            a = m6644a(complex, complex2, f4889b);
        }
        return a;
    }

    public Complex m6646a(Complex[] complexArr) {
        Complex a;
        synchronized (f4889b) {
            a = m6647a(complexArr, f4889b);
        }
        return a;
    }

    public Complex m6645a(Complex complex, EvalContext evalContext) {
        Complex[] complexArr = evalContext.f4934f;
        complexArr[0] = complex;
        return m6647a(complexArr, evalContext);
    }

    public Complex m6644a(Complex complex, Complex complex2, EvalContext evalContext) {
        Complex[] complexArr = evalContext.f4935g;
        complexArr[0] = complex;
        complexArr[1] = complex2;
        return m6647a(complexArr, evalContext);
    }
}
