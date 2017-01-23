package org.javia.arity.miui;

public class Complex {
    public double f4908a;
    public double f4909b;

    public Complex(double d, double d2) {
        m6669a(d, d2);
    }

    public Complex(Complex complex) {
        m6670a(complex);
    }

    public Complex m6669a(double d, double d2) {
        this.f4908a = d;
        this.f4909b = d2;
        return this;
    }

    public Complex m6670a(Complex complex) {
        this.f4908a = complex.f4908a;
        this.f4909b = complex.f4909b;
        return this;
    }

    public String toString() {
        return this.f4909b == 0.0d ? "" + this.f4908a : "(" + this.f4908a + ", " + this.f4909b + ')';
    }

    public double m6667a() {
        return this.f4909b == 0.0d ? this.f4908a : Double.NaN;
    }

    public final Complex m6671b() {
        return m6669a(this.f4908a, -this.f4909b);
    }

    public final Complex m6673c() {
        return m6669a(-this.f4908a, -this.f4909b);
    }

    public final boolean m6676d() {
        return Double.isInfinite(this.f4908a) || (Double.isInfinite(this.f4909b) && !m6680f());
    }

    public final boolean m6678e() {
        return (m6676d() || m6680f()) ? false : true;
    }

    public final boolean m6680f() {
        return Double.isNaN(this.f4908a) || Double.isNaN(this.f4909b);
    }

    public final double m6681g() {
        return Math.atan2(this.f4909b, this.f4908a);
    }

    public final double m6683h() {
        double abs = Math.abs(this.f4908a);
        double abs2 = Math.abs(this.f4909b);
        if (abs == 0.0d || abs2 == 0.0d) {
            return abs + abs2;
        }
        Object obj = abs > abs2 ? 1 : null;
        double d = obj != null ? abs2 / abs : abs / abs2;
        if (obj == null) {
            abs = abs2;
        }
        return abs * Math.sqrt(1.0d + (d * d));
    }

    public final double m6685i() {
        return (this.f4908a * this.f4908a) + (this.f4909b * this.f4909b);
    }

    public final Complex m6672b(Complex complex) {
        double ulp = Math.ulp(this.f4908a);
        this.f4908a += complex.f4908a;
        this.f4909b += complex.f4909b;
        if (Math.abs(this.f4908a) < ulp * 1024.0d) {
            this.f4908a = 0.0d;
        }
        return this;
    }

    public final Complex m6674c(Complex complex) {
        double ulp = Math.ulp(this.f4908a);
        this.f4908a -= complex.f4908a;
        this.f4909b -= complex.f4909b;
        if (Math.abs(this.f4908a) < ulp * 1024.0d) {
            this.f4908a = 0.0d;
        }
        return this;
    }

    Complex m6668a(double d) {
        this.f4908a *= d;
        this.f4909b *= d;
        return this;
    }

    public final Complex m6675d(Complex complex) {
        double d = this.f4908a;
        double d2 = this.f4909b;
        double d3 = complex.f4908a;
        double d4 = complex.f4909b;
        if (d2 == 0.0d && d4 == 0.0d) {
            return m6669a(d * d3, 0.0d);
        }
        double d5 = (d * d3) - (d2 * d4);
        double d6 = (d * d4) + (d2 * d3);
        if (!m6669a(d5, d6).m6680f()) {
            return this;
        }
        if (m6669a(d, d2).m6676d()) {
            m6664C();
            d = this.f4908a;
            d2 = this.f4909b;
        }
        if (complex.m6676d()) {
            m6669a(d3, d4).m6664C();
            d3 = this.f4908a;
            d4 = this.f4909b;
        }
        if (d2 == 0.0d) {
            if (d4 == 0.0d) {
                return m6669a(d * d3, 0.0d);
            }
            if (d3 == 0.0d) {
                return m6669a(0.0d, d * d4);
            }
            return m6669a(d * d3, d * d4);
        } else if (d == 0.0d) {
            if (d3 == 0.0d) {
                return m6669a((-d2) * d4, 0.0d);
            }
            if (d4 == 0.0d) {
                return m6669a(0.0d, d2 * d3);
            }
            return m6669a((-d2) * d4, d2 * d3);
        } else if (d4 == 0.0d) {
            return m6669a(d * d3, d2 * d3);
        } else {
            if (d3 == 0.0d) {
                return m6669a((-d2) * d4, d * d4);
            }
            return m6669a(d5, d6);
        }
    }

    public final Complex m6677e(Complex complex) {
        double d = complex.f4908a;
        double d2 = complex.f4909b;
        if (this.f4909b == 0.0d && d2 == 0.0d) {
            return m6669a(this.f4908a / d, 0.0d);
        }
        if (complex.m6676d() && m6678e()) {
            return m6669a(0.0d, 0.0d);
        }
        if (d2 == 0.0d) {
            if (this.f4908a == 0.0d) {
                return m6669a(0.0d, this.f4909b / d);
            }
            return m6669a(this.f4908a / d, this.f4909b / d);
        } else if (d == 0.0d) {
            return m6669a(this.f4909b / d2, (-this.f4908a) / d2);
        } else {
            double d3;
            if (Math.abs(d) > Math.abs(d2)) {
                d3 = d2 / d;
                d += d2 * d3;
                return m6669a((this.f4908a + (this.f4909b * d3)) / d, (this.f4909b - (d3 * this.f4908a)) / d);
            }
            d3 = d / d2;
            d = (d * d3) + d2;
            return m6669a(((this.f4908a * d3) + this.f4909b) / d, ((d3 * this.f4909b) - this.f4908a) / d);
        }
    }

    public final Complex m6687j() {
        if (this.f4909b != 0.0d) {
            double sqrt = Math.sqrt((Math.abs(this.f4908a) + m6683h()) / 2.0d);
            if (this.f4908a >= 0.0d) {
                m6669a(sqrt, this.f4909b / (sqrt + sqrt));
            } else {
                double abs = Math.abs(this.f4909b) / (sqrt + sqrt);
                if (this.f4909b < 0.0d) {
                    sqrt = -sqrt;
                }
                m6669a(abs, sqrt);
            }
        } else if (this.f4908a >= 0.0d) {
            m6669a(Math.sqrt(this.f4908a), 0.0d);
        } else {
            m6669a(0.0d, Math.sqrt(-this.f4908a));
        }
        return this;
    }

    public final Complex m6679f(Complex complex) {
        double d = this.f4908a;
        double d2 = this.f4909b;
        if (d2 == 0.0d && complex.f4909b == 0.0d) {
            return m6669a(d % complex.f4908a, 0.0d);
        }
        return m6677e(complex).m6669a(Math.rint(this.f4908a), Math.rint(this.f4909b)).m6675d(complex).m6669a(d - this.f4908a, d2 - this.f4909b);
    }

    public final Complex m6682g(Complex complex) {
        if (this.f4909b == 0.0d && complex.f4909b == 0.0d) {
            return m6669a(MoreMath.m6729a(this.f4908a, complex.f4908a), 0.0d);
        }
        Complex complex2 = new Complex(complex);
        double i = m6685i();
        for (double i2 = complex2.m6685i(); i < 1.0E30d * i2; i2 = complex2.m6685i()) {
            i = complex2.f4908a;
            double d = complex2.f4909b;
            complex2.m6670a(m6679f(complex2));
            m6669a(i, d);
            i = i2;
        }
        if (Math.abs(this.f4908a) < Math.abs(this.f4909b)) {
            m6669a(-this.f4909b, this.f4908a);
        }
        if (this.f4908a >= 0.0d) {
            return this;
        }
        m6673c();
        return this;
    }

    public final Complex m6689k() {
        if (this.f4909b == 0.0d && this.f4908a >= 0.0d) {
            return m6669a(Math.log(this.f4908a), 0.0d);
        }
        return m6669a(Math.log(m6683h()), Math.atan2(this.f4909b, this.f4908a));
    }

    public final Complex m6690l() {
        double exp = Math.exp(this.f4908a);
        if (this.f4909b == 0.0d) {
            return m6669a(exp, 0.0d);
        }
        return m6669a(MoreMath.m6738h(this.f4909b) * exp, exp * MoreMath.m6737g(this.f4909b));
    }

    public final Complex m6691m() {
        return m6669a((this.f4908a * this.f4908a) - (this.f4909b * this.f4909b), (2.0d * this.f4908a) * this.f4909b);
    }

    public final Complex m6684h(Complex complex) {
        double pow;
        if (complex.f4909b == 0.0d) {
            if (complex.f4908a == 0.0d) {
                return m6669a(1.0d, 0.0d);
            }
            if (this.f4909b == 0.0d) {
                pow = Math.pow(this.f4908a, complex.f4908a);
                if (pow == pow) {
                    return m6669a(pow, 0.0d);
                }
            }
            if (complex.f4908a == 2.0d) {
                return m6691m();
            }
            if (complex.f4908a == 0.5d) {
                return m6687j();
            }
            pow = Math.pow(m6685i(), complex.f4908a / 2.0d);
            double g = m6681g() * complex.f4908a;
            return m6669a(MoreMath.m6738h(g) * pow, pow * MoreMath.m6737g(g));
        } else if (this.f4909b != 0.0d || this.f4908a <= 0.0d) {
            return m6689k().m6669a((complex.f4908a * this.f4908a) - (complex.f4909b * this.f4909b), (complex.f4908a * this.f4909b) + (complex.f4909b * this.f4908a)).m6690l();
        } else {
            pow = Math.pow(this.f4908a, complex.f4908a);
            return m6669a(0.0d, complex.f4909b * Math.log(this.f4908a)).m6690l().m6669a(this.f4908a * pow, pow * this.f4909b);
        }
    }

    public final Complex m6692n() {
        double d = 0.9999999999999971d;
        double d2 = 0.0d;
        double d3 = (this.f4908a * this.f4908a) + (this.f4909b * this.f4909b);
        double d4 = this.f4908a;
        double[] dArr = MoreMath.f4962a;
        for (double d5 : dArr) {
            d4 += 1.0d;
            d3 += (d4 + d4) - 1.0d;
            d += (d5 * d4) / d3;
            d2 -= (d5 * this.f4909b) / d3;
        }
        double d6 = this.f4908a + 0.5d;
        d4 = this.f4908a + 5.2421875d;
        d3 = this.f4909b;
        this.f4908a = d4;
        m6689k();
        d4 = (((this.f4908a * d6) - (this.f4909b * d3)) + 0.9189385332046728d) - d4;
        d6 = ((d6 * this.f4909b) + (this.f4908a * d3)) - d3;
        m6669a(d, d2).m6689k();
        this.f4908a = d4 + this.f4908a;
        this.f4909b = d6 + this.f4909b;
        return this;
    }

    public final Complex m6693o() {
        return this.f4909b == 0.0d ? m6669a(MoreMath.m6735e(this.f4908a), 0.0d) : m6692n().m6690l();
    }

    public final Complex m6694p() {
        return this.f4909b == 0.0d ? m6669a(MoreMath.m6737g(this.f4908a), 0.0d) : m6669a(MoreMath.m6737g(this.f4908a) * Math.cosh(this.f4909b), MoreMath.m6738h(this.f4908a) * Math.sinh(this.f4909b));
    }

    public final Complex m6695q() {
        return this.f4909b == 0.0d ? m6669a(Math.sinh(this.f4908a), 0.0d) : m6663B().m6694p().m6663B();
    }

    public final Complex m6696r() {
        return this.f4909b == 0.0d ? m6669a(MoreMath.m6738h(this.f4908a), 0.0d) : m6669a(MoreMath.m6738h(this.f4908a) * Math.cosh(this.f4909b), (-MoreMath.m6737g(this.f4908a)) * Math.sinh(this.f4909b));
    }

    public final Complex m6697s() {
        return this.f4909b == 0.0d ? m6669a(Math.cosh(this.f4908a), 0.0d) : m6663B().m6696r().m6671b();
    }

    public final Complex m6698t() {
        if (this.f4909b == 0.0d) {
            return m6669a(MoreMath.m6739i(this.f4908a), 0.0d);
        }
        double d = this.f4908a + this.f4908a;
        double d2 = this.f4909b + this.f4909b;
        double h = MoreMath.m6738h(d) + Math.cosh(d2);
        return m6669a(MoreMath.m6737g(d) / h, Math.sinh(d2) / h);
    }

    public final Complex m6699u() {
        return this.f4909b == 0.0d ? m6669a(Math.tanh(this.f4908a), 0.0d) : m6663B().m6698t().m6663B();
    }

    public final Complex m6700v() {
        if (this.f4909b == 0.0d && Math.abs(this.f4908a) <= 1.0d) {
            return m6669a(Math.asin(this.f4908a), 0.0d);
        }
        double d = this.f4908a;
        return m6665D().m6669a(this.f4908a - this.f4909b, d + this.f4909b).m6689k().m6669a(this.f4909b, -this.f4908a);
    }

    public final Complex m6701w() {
        if (this.f4909b == 0.0d && Math.abs(this.f4908a) <= 1.0d) {
            return m6669a(Math.acos(this.f4908a), 0.0d);
        }
        return m6665D().m6669a(this.f4908a - this.f4909b, this.f4909b + this.f4908a).m6689k().m6669a(this.f4909b, -this.f4908a);
    }

    public final Complex m6702x() {
        if (this.f4909b == 0.0d) {
            return m6669a(Math.atan(this.f4908a), 0.0d);
        }
        double d = this.f4908a * this.f4908a;
        double d2 = this.f4909b * this.f4909b;
        double d3 = (((d + d2) - this.f4909b) - this.f4909b) + 1.0d;
        return m6669a((-((d + d2) - 1.0d)) / d3, (-(this.f4908a + this.f4908a)) / d3).m6689k().m6669a((-this.f4909b) / 2.0d, this.f4908a / 2.0d);
    }

    public final Complex m6703y() {
        if (this.f4909b == 0.0d) {
            return m6669a(MoreMath.m6728a(this.f4908a), 0.0d);
        }
        return m6669a(((this.f4908a * this.f4908a) - (this.f4909b * this.f4909b)) + 1.0d, (2.0d * this.f4908a) * this.f4909b).m6687j().m6669a(this.f4908a + this.f4908a, this.f4909b + this.f4909b).m6689k();
    }

    public final Complex m6704z() {
        if (this.f4909b == 0.0d && this.f4908a >= 1.0d) {
            return m6669a(MoreMath.m6730b(this.f4908a), 0.0d);
        }
        return m6669a(((this.f4908a * this.f4908a) - (this.f4909b * this.f4909b)) - 1.0d, (2.0d * this.f4908a) * this.f4909b).m6687j().m6669a(this.f4908a + this.f4908a, this.f4909b + this.f4909b).m6689k();
    }

    public final Complex m6666A() {
        if (this.f4909b == 0.0d) {
            return m6669a(MoreMath.m6732c(this.f4908a), 0.0d);
        }
        double d = this.f4908a * this.f4908a;
        double d2 = ((d + 1.0d) - this.f4908a) - this.f4908a;
        return m6669a(((1.0d - d) - (this.f4909b * this.f4909b)) / d2, (this.f4909b + this.f4909b) / d2).m6689k().m6669a(this.f4908a / 2.0d, this.f4909b / 2.0d);
    }

    public final Complex m6686i(Complex complex) {
        if (this.f4909b == 0.0d && complex.f4909b == 0.0d) {
            return m6669a(MoreMath.m6731b(this.f4908a, complex.f4908a), 0.0d);
        }
        double d = this.f4908a;
        double d2 = this.f4909b;
        m6692n();
        double d3 = this.f4908a;
        double d4 = this.f4909b;
        m6670a(complex).m6692n();
        double d5 = this.f4908a;
        double d6 = this.f4909b;
        m6669a(d - complex.f4908a, d2 - complex.f4909b).m6692n();
        return m6669a((d3 - d5) - this.f4908a, (d4 - d6) - this.f4909b).m6690l();
    }

    public final Complex m6688j(Complex complex) {
        if (this.f4909b == 0.0d && complex.f4909b == 0.0d) {
            return m6669a(MoreMath.m6733c(this.f4908a, complex.f4908a), 0.0d);
        }
        double d = this.f4908a;
        double d2 = this.f4909b;
        m6692n();
        double d3 = this.f4908a;
        double d4 = this.f4909b;
        m6669a(d - complex.f4908a, d2 - complex.f4909b).m6692n();
        return m6669a(d3 - this.f4908a, d4 - this.f4909b).m6690l();
    }

    private final Complex m6663B() {
        return m6669a(this.f4909b, this.f4908a);
    }

    private final Complex m6664C() {
        if (!Double.isInfinite(this.f4909b)) {
            this.f4909b = 0.0d;
        } else if (!Double.isInfinite(this.f4908a)) {
            this.f4908a = 0.0d;
        }
        return this;
    }

    private final Complex m6665D() {
        return m6669a((1.0d - (this.f4908a * this.f4908a)) + (this.f4909b * this.f4909b), (-2.0d * this.f4908a) * this.f4909b).m6687j();
    }
}
