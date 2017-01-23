package com.aide.ui;

import android.content.SharedPreferences;
import com.aide.common.d;
import java.util.GregorianCalendar;

public class m {
    private static final GregorianCalendar j6;

    static {
        j6 = new GregorianCalendar(2014, 11, 31);
    }

    public static GregorianCalendar j6() {
        return j6;
    }

    public static GregorianCalendar DW() {
        long j6 = j6("PrimeYearlyPromoAIDE3");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j6 + 172800000);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar;
    }

    private static long j6(String str) {
        SharedPreferences sharedPreferences = e.gn().getSharedPreferences("StartTimes", 0);
        long j = sharedPreferences.getLong(str, 0);
        if (j != 0) {
            return j;
        }
        j = System.currentTimeMillis();
        sharedPreferences.edit().putLong(str, j).commit();
        return j;
    }

    public static GregorianCalendar FH() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long U2 = e.Mr().U2();
        if (U2 == -1) {
            U2 = System.currentTimeMillis();
        }
        gregorianCalendar.setTimeInMillis(U2);
        gregorianCalendar.add(5, 1);
        return gregorianCalendar;
    }

    private static boolean j6(GregorianCalendar gregorianCalendar) {
        GregorianCalendar gregorianCalendar2 = (GregorianCalendar) gregorianCalendar.clone();
        gregorianCalendar2.add(5, 1);
        return new GregorianCalendar().before(gregorianCalendar2);
    }

    private static boolean DW(GregorianCalendar gregorianCalendar) {
        GregorianCalendar gregorianCalendar2 = (GregorianCalendar) gregorianCalendar.clone();
        gregorianCalendar2.add(5, 1);
        return new GregorianCalendar().before(gregorianCalendar2);
    }

    public static GregorianCalendar Hw() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(e.u7().Zo() + 3600000);
        return gregorianCalendar;
    }

    public static boolean v5() {
        if ((e.j6.equals("com.aide.ui") || e.j6.equals("com.aide.web")) && !d.j6()) {
            return j6(DW());
        }
        return false;
    }

    public static boolean Zo() {
        if (!e.j6.equals("com.aide.ui") || d.j6()) {
            return false;
        }
        return j6(j6());
    }

    public static boolean VH() {
        return false;
    }

    public static boolean gn() {
        return DW(FH());
    }

    public static boolean u7() {
        if (!e.j6.equals("com.aide.ui")) {
            return false;
        }
        if (e.Mr().gn() || e.Mr().Mr() || e.Mr().tp()) {
            return true;
        }
        return false;
    }
}
