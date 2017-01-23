package com.miui.calculator.tax;

import com.miui.calculator.tax.TaxRateGetter.CityTaxData;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class TaxCalculator {
    public static int f1838a;
    public static int f1839b;

    public static class TaxResult {
        int f1829a;
        double f1830b;
        double f1831c;
        double f1832d;
        double f1833e;
        double f1834f;
        double f1835g;
        double f1836h;
        double f1837i;
    }

    static {
        f1838a = 3500;
        f1839b = 4800;
    }

    public static TaxResult m3199a(int i, int i2, CityTaxData cityTaxData, int i3) {
        switch (i2) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return m3202b(i, cityTaxData);
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return m3200a(i, cityTaxData);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return m3198a(i, i3);
            default:
                return null;
        }
    }

    private static double m3197a(double d, double d2) {
        int i = 0;
        double d3 = 0.0d;
        if (d > 0.0d) {
            if (d <= 1500.0d) {
                d3 = 0.03d;
            } else if (d <= 4500.0d) {
                i = 105;
                d3 = 0.1d;
            } else if (d <= 9000.0d) {
                i = 555;
                d3 = 0.2d;
            } else if (d <= 35000.0d) {
                i = 1005;
                d3 = 0.25d;
            } else if (d <= 55000.0d) {
                i = 2755;
                d3 = 0.3d;
            } else if (d <= 80000.0d) {
                i = 5505;
                d3 = 0.35d;
            } else {
                i = 13505;
                d3 = 0.45d;
            }
        }
        return (d3 * d2) - ((double) i);
    }

    private static TaxResult m3198a(int i, int i2) {
        int max = i - Math.max(0, f1838a - i2);
        double a = m3197a(((double) max) / 12.0d, (double) max);
        TaxResult taxResult = new TaxResult();
        taxResult.f1829a = i;
        taxResult.f1831c = m3196a(a);
        taxResult.f1830b = m3196a(((double) i) - a);
        return taxResult;
    }

    private static TaxResult m3201a(int i, CityTaxData cityTaxData, int i2) {
        double min = cityTaxData.f1851j > 0.0d ? ((double) i) > cityTaxData.f1852k ? Math.min(cityTaxData.f1851j, (double) i) : 0.0d : Math.max(cityTaxData.f1852k, Math.min(cityTaxData.f1850i * 3.0d, (double) i));
        double min2 = cityTaxData.f1853l > 0.0d ? ((double) i) > cityTaxData.f1854m ? Math.min(cityTaxData.f1853l, (double) i) : 0.0d : Math.max(cityTaxData.f1854m, Math.min(cityTaxData.f1850i * 3.0d, (double) i));
        double d = cityTaxData.f1845d * min;
        double d2 = cityTaxData.f1844c * min;
        double d3 = cityTaxData.f1846e * min;
        double d4 = cityTaxData.f1847f * min;
        double d5 = cityTaxData.f1848g * min;
        double d6 = (((d + d2) + d3) + d4) + d5;
        min2 *= cityTaxData.f1849h;
        min = ((((double) i) - d6) - min2) - ((double) i2);
        double a = m3197a(min, min);
        TaxResult taxResult = new TaxResult();
        taxResult.f1829a = i < 0 ? 0 : i;
        taxResult.f1832d = m3196a(d);
        taxResult.f1833e = m3196a(d2);
        taxResult.f1834f = m3196a(d3);
        taxResult.f1835g = m3196a(d4);
        taxResult.f1836h = m3196a(d5);
        taxResult.f1837i = m3196a(min2);
        taxResult.f1831c = m3196a(a);
        taxResult.f1830b = m3196a(((((double) i) - a) - d6) - min2);
        return taxResult;
    }

    private static TaxResult m3200a(int i, CityTaxData cityTaxData) {
        return m3201a(i, cityTaxData, f1839b);
    }

    private static TaxResult m3202b(int i, CityTaxData cityTaxData) {
        return m3201a(i, cityTaxData, f1838a);
    }

    private static double m3196a(double d) {
        if (d >= 1.0E-7d || d <= -1.0E-7d) {
            return d;
        }
        return 0.0d;
    }
}
