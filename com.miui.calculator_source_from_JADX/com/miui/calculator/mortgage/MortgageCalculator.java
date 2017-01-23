package com.miui.calculator.mortgage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MortgageCalculator {

    public static class MortgageMonthly implements Parcelable {
        public static final Creator<MortgageMonthly> CREATOR;
        double f1669a;
        double f1670b;
        double f1671c;
        double f1672d;

        /* renamed from: com.miui.calculator.mortgage.MortgageCalculator.MortgageMonthly.1 */
        final class C02001 implements Creator<MortgageMonthly> {
            C02001() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3054a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3055a(i);
            }

            public MortgageMonthly m3054a(Parcel parcel) {
                return new MortgageMonthly(null);
            }

            public MortgageMonthly[] m3055a(int i) {
                return new MortgageMonthly[i];
            }
        }

        private MortgageMonthly(Parcel parcel) {
            this.f1669a = parcel.readDouble();
            this.f1670b = parcel.readDouble();
            this.f1671c = parcel.readDouble();
            this.f1672d = parcel.readDouble();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.f1669a);
            parcel.writeDouble(this.f1670b);
            parcel.writeDouble(this.f1671c);
            parcel.writeDouble(this.f1672d);
        }

        static {
            CREATOR = new C02001();
        }
    }

    public static class MortgageResult implements Parcelable {
        public static final Creator<MortgageResult> CREATOR;
        public int f1673a;
        public double f1674b;
        public double f1675c;
        public double f1676d;
        public double f1677e;
        public int f1678f;
        public MortgageMonthly[] f1679g;

        /* renamed from: com.miui.calculator.mortgage.MortgageCalculator.MortgageResult.1 */
        final class C02011 implements Creator<MortgageResult> {
            C02011() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3056a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3057a(i);
            }

            public MortgageResult m3056a(Parcel parcel) {
                return new MortgageResult(null);
            }

            public MortgageResult[] m3057a(int i) {
                return new MortgageResult[i];
            }
        }

        private MortgageResult(Parcel parcel) {
            this.f1673a = parcel.readInt();
            this.f1674b = parcel.readDouble();
            this.f1675c = parcel.readDouble();
            this.f1676d = parcel.readDouble();
            this.f1677e = parcel.readDouble();
            this.f1678f = parcel.readInt();
            this.f1679g = (MortgageMonthly[]) parcel.createTypedArray(MortgageMonthly.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1673a);
            parcel.writeDouble(this.f1674b);
            parcel.writeDouble(this.f1675c);
            parcel.writeDouble(this.f1676d);
            parcel.writeDouble(this.f1677e);
            parcel.writeInt(this.f1678f);
            parcel.writeTypedArray(this.f1679g, i);
        }

        static {
            CREATOR = new C02011();
        }
    }

    public static MortgageResult m3059a(int i, int i2, double d, double d2, int i3, double d3, double d4) {
        if (i3 == 0) {
            return null;
        }
        double d5;
        MortgageResult mortgageResult = new MortgageResult();
        mortgageResult.f1673a = i2;
        mortgageResult.f1675c = 0.0d;
        mortgageResult.f1676d = 0.0d;
        if (i == 3) {
            d5 = d + d2;
        } else {
            d5 = d;
        }
        mortgageResult.f1677e = d5;
        mortgageResult.f1678f = i3;
        int i4 = i3 * 12;
        mortgageResult.f1679g = new MortgageMonthly[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            mortgageResult.f1679g[i5] = new MortgageMonthly();
            mortgageResult.f1679g[i5].f1669a = m3058a(i2, i5 + 1, d, i4, d3);
            mortgageResult.f1679g[i5].f1670b = m3062d(i2, i5 + 1, d, i4, d3);
            mortgageResult.f1679g[i5].f1671c = m3061c(i2, i5 + 1, d, i4, d3);
            mortgageResult.f1679g[i5].f1672d = m3060b(i2, i5 + 1, d, i4, d3);
            if (i == 3) {
                MortgageMonthly mortgageMonthly = mortgageResult.f1679g[i5];
                mortgageMonthly.f1669a = m3058a(i2, i5 + 1, d2, i4, d4) + mortgageMonthly.f1669a;
                mortgageMonthly = mortgageResult.f1679g[i5];
                mortgageMonthly.f1670b = m3062d(i2, i5 + 1, d2, i4, d4) + mortgageMonthly.f1670b;
                mortgageMonthly = mortgageResult.f1679g[i5];
                mortgageMonthly.f1671c = m3061c(i2, i5 + 1, d2, i4, d4) + mortgageMonthly.f1671c;
                mortgageResult.f1679g[i5].f1672d = m3060b(i2, i5 + 1, d2, i4, d4);
            }
            mortgageResult.f1675c += mortgageResult.f1679g[i5].f1671c;
            mortgageResult.f1676d += mortgageResult.f1679g[i5].f1669a;
        }
        mortgageResult.f1674b = mortgageResult.f1679g[0].f1669a;
        return mortgageResult;
    }

    public static double m3058a(int i, int i2, double d, int i3, double d2) {
        double d3 = 0.0d;
        double d4 = d2 / 12.0d;
        double d5 = (double) i3;
        double d6 = (double) i2;
        if (i == 0) {
            d3 = ((d * d4) * Math.pow(1.0d + d4, d5)) / (Math.pow(d4 + 1.0d, d5) - 1.0d);
        } else if (i == 1) {
            d3 = (d / d5) + ((d4 * d) * (1.0d - ((d6 - 1.0d) / d5)));
        }
        return d3 < 0.0d ? 0.0d : d3;
    }

    public static double m3060b(int i, int i2, double d, int i3, double d2) {
        double d3 = d2 / 12.0d;
        double d4 = (double) i3;
        double d5 = (double) i2;
        if (i == 0) {
            d3 = (Math.pow(1.0d + d3, d5) - ((Math.pow(1.0d + d3, d5 + d4) - Math.pow(1.0d + d3, d4)) / (Math.pow(d3 + 1.0d, d4) - 1.0d))) * d;
        } else {
            d3 = (1.0d - (d5 / d4)) * d;
        }
        return d3 < 0.0d ? 0.0d : d3;
    }

    public static double m3061c(int i, int i2, double d, int i3, double d2) {
        double d3 = d2 / 12.0d;
        double d4 = (double) i3;
        double d5 = (double) i2;
        if (i == 0) {
            d3 = (Math.pow(1.0d + d3, d5 - 1.0d) - ((Math.pow(1.0d + d3, (d5 + d4) - 1.0d) - Math.pow(1.0d + d3, d4)) / (Math.pow(d3 + 1.0d, d4) - 1.0d))) * (d * d3);
        } else {
            d3 = (d3 * d) * (1.0d - ((d5 - 1.0d) / d4));
        }
        return d3 < 0.0d ? 0.0d : d3;
    }

    public static double m3062d(int i, int i2, double d, int i3, double d2) {
        double d3 = d2 / 12.0d;
        double d4 = (double) i3;
        double d5 = (double) i2;
        if (i == 0) {
            d3 = ((Math.pow(1.0d + d3, (d4 + d5) - 1.0d) / (Math.pow(1.0d + d3, d4) - 1.0d)) - Math.pow(d3 + 1.0d, d5 - 1.0d)) * (d * d3);
        } else {
            d3 = d / d4;
        }
        return d3 < 0.0d ? 0.0d : d3;
    }
}
