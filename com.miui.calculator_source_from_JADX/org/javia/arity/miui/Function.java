package org.javia.arity.miui;

import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public abstract class Function {
    String f4887a;
    private Function f4888b;

    public abstract int m6625a();

    public Function() {
        this.f4888b = null;
    }

    public Function m6633d() {
        if (this.f4888b == null) {
            this.f4888b = new Derivative(this);
        }
        return this.f4888b;
    }

    void m6629a(Function function) {
        this.f4888b = function;
    }

    public double m6632c() {
        throw new ArityException(0);
    }

    public double m6622a(double d) {
        throw new ArityException(1);
    }

    public double m6623a(double d, double d2) {
        throw new ArityException(2);
    }

    public double m6624a(double[] dArr) {
        switch (dArr.length) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return m6632c();
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return m6622a(dArr[0]);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return m6623a(dArr[0], dArr[1]);
            default:
                throw new ArityException(dArr.length);
        }
    }

    public Complex m6630b() {
        m6631b(0);
        return new Complex(m6632c(), 0.0d);
    }

    public Complex m6626a(Complex complex) {
        m6631b(1);
        return new Complex(complex.f4909b == 0.0d ? m6622a(complex.f4908a) : Double.NaN, 0.0d);
    }

    public Complex m6627a(Complex complex, Complex complex2) {
        m6631b(2);
        double a = (complex.f4909b == 0.0d && complex2.f4909b == 0.0d) ? m6623a(complex.f4908a, complex2.f4908a) : Double.NaN;
        return new Complex(a, 0.0d);
    }

    public Complex m6628a(Complex[] complexArr) {
        switch (complexArr.length) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return m6630b();
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return m6626a(complexArr[0]);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return m6627a(complexArr[0], complexArr[1]);
            default:
                int length = complexArr.length;
                m6631b(length);
                double[] dArr = new double[length];
                for (length = complexArr.length - 1; length >= 0; length--) {
                    if (complexArr[length].f4909b != 0.0d) {
                        return new Complex(Double.NaN, 0.0d);
                    }
                    dArr[length] = complexArr[length].f4908a;
                }
                return new Complex(m6624a(dArr), 0.0d);
        }
    }

    public void m6631b(int i) {
        if (m6625a() != i) {
            throw new ArityException("Expected " + m6625a() + " arguments, got " + i);
        }
    }
}
