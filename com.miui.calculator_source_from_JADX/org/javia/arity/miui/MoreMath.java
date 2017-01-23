package org.javia.arity.miui;

class MoreMath {
    static final double[] f4962a;
    static final double[] f4963b;

    MoreMath() {
    }

    public static final double m6728a(double d) {
        return d < 0.0d ? -m6728a(-d) : Math.log((d + d) + (1.0d / (Math.sqrt((d * d) + 1.0d) + d)));
    }

    public static final double m6730b(double d) {
        return Math.log((d + d) - (1.0d / (Math.sqrt((d * d) - 1.0d) + d)));
    }

    public static final double m6732c(double d) {
        return d < 0.0d ? -m6732c(-d) : 0.5d * Math.log(((d + d) / (1.0d - d)) + 1.0d);
    }

    public static final double m6729a(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || Double.isInfinite(d) || Double.isInfinite(d2)) {
            return Double.NaN;
        }
        double abs = Math.abs(d);
        double d3 = abs;
        abs = Math.abs(d2);
        while (d3 < 1.0E15d * abs) {
            double d4 = d3 % abs;
            d3 = abs;
            abs = d4;
        }
        return d3;
    }

    static {
        f4962a = new double[]{57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
        f4963b = new double[]{1.0d, 40320.0d, 2.0922789888E13d, 6.204484017332394E23d, 2.631308369336935E35d, 8.159152832478977E47d, 1.2413915592536073E61d, 7.109985878048635E74d, 1.2688693218588417E89d, 6.1234458376886085E103d, 7.156945704626381E118d, 1.8548264225739844E134d, 9.916779348709496E149d, 1.0299016745145628E166d, 1.974506857221074E182d, 6.689502913449127E198d, 3.856204823625804E215d, 3.659042881952549E232d, 5.5502938327393044E249d, 1.3113358856834524E267d, 4.7147236359920616E284d, 2.5260757449731984E302d};
    }

    public static final double m6734d(double d) {
        double d2 = d + 5.2421875d;
        double d3 = 0.9999999999999971d;
        for (double d4 : f4962a) {
            d += 1.0d;
            d3 += d4 / d;
        }
        return ((0.9189385332046728d + Math.log(d3)) + ((d2 - 4.7421875d) * Math.log(d2))) - d2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final double m6735e(double r6) {
        /*
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r0 = 0;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x000b;
    L_0x0008:
        r0 = 9221120237041090560; // 0x7ff8000000000000 float:0.0 double:NaN;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = 4640185359819341824; // 0x4065400000000000 float:0.0 double:170.0;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x0022;
    L_0x0014:
        r0 = java.lang.Math.floor(r6);
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r2 = (int) r6;
        r0 = r2 & 7;
        switch(r0) {
            case 0: goto L_0x0040;
            case 1: goto L_0x0038;
            case 2: goto L_0x004f;
            case 3: goto L_0x004d;
            case 4: goto L_0x004b;
            case 5: goto L_0x0049;
            case 6: goto L_0x0047;
            case 7: goto L_0x002b;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = m6734d(r6);
        r0 = java.lang.Math.exp(r0);
        goto L_0x000a;
    L_0x002b:
        r0 = r6 - r4;
        r6 = r6 * r0;
    L_0x002e:
        r0 = r0 - r4;
        r6 = r6 * r0;
    L_0x0030:
        r0 = r0 - r4;
        r6 = r6 * r0;
    L_0x0032:
        r0 = r0 - r4;
        r6 = r6 * r0;
    L_0x0034:
        r0 = r0 - r4;
        r6 = r6 * r0;
    L_0x0036:
        r0 = r0 - r4;
        r6 = r6 * r0;
    L_0x0038:
        r0 = f4963b;
        r1 = r2 >> 3;
        r0 = r0[r1];
        r0 = r0 * r6;
        goto L_0x000a;
    L_0x0040:
        r0 = f4963b;
        r1 = r2 >> 3;
        r0 = r0[r1];
        goto L_0x000a;
    L_0x0047:
        r0 = r6;
        goto L_0x002e;
    L_0x0049:
        r0 = r6;
        goto L_0x0030;
    L_0x004b:
        r0 = r6;
        goto L_0x0032;
    L_0x004d:
        r0 = r6;
        goto L_0x0034;
    L_0x004f:
        r0 = r6;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.javia.arity.miui.MoreMath.e(double):double");
    }

    public static final double m6731b(double d, double d2) {
        if (d < 0.0d || d2 < 0.0d) {
            return Double.NaN;
        }
        if (d < d2) {
            return 0.0d;
        }
        if (Math.floor(d) != d || Math.floor(d2) != d2) {
            return Math.exp((m6734d(d) - m6734d(d2)) - m6734d(d - d2));
        }
        double min = Math.min(d2, d - d2);
        if (d <= 170.0d && 12.0d < min && min <= 170.0d) {
            return (m6735e(d) / m6735e(min)) / m6735e(d - min);
        }
        double d3 = d - min;
        double d4 = min;
        min = 1.0d;
        while (d4 > 0.5d && min < Double.POSITIVE_INFINITY) {
            double d5 = ((d3 + d4) / d4) * min;
            d4 -= 1.0d;
            min = d5;
        }
        return min;
    }

    public static final double m6733c(double d, double d2) {
        if (d < 0.0d || d2 < 0.0d) {
            return Double.NaN;
        }
        if (d < d2) {
            return 0.0d;
        }
        if (Math.floor(d) != d || Math.floor(d2) != d2) {
            return Math.exp(m6734d(d) - m6734d(d - d2));
        }
        if (d <= 170.0d && 10.0d < d2 && d2 <= 170.0d) {
            return m6735e(d) / m6735e(d - d2);
        }
        double d3 = 0.5d + (d - d2);
        double d4 = 1.0d;
        while (d > d3 && d4 < Double.POSITIVE_INFINITY) {
            d4 *= d;
            d -= 1.0d;
        }
        return d4;
    }

    public static final double m6736f(double d) {
        return Math.log(d) * 1.4426950408889634d;
    }

    private static final boolean m6740j(double d) {
        double d2 = d / 3.141592653589793d;
        return d2 == Math.floor(d2);
    }

    public static final double m6737g(double d) {
        return m6740j(d) ? 0.0d : Math.sin(d);
    }

    public static final double m6738h(double d) {
        return m6740j(d - 1.5707963267948966d) ? 0.0d : Math.cos(d);
    }

    public static final double m6739i(double d) {
        return m6740j(d) ? 0.0d : Math.tan(d);
    }
}
