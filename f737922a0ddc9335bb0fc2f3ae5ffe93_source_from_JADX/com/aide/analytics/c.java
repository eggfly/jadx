package com.aide.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map.Entry;
import java.util.Random;

public class c {
    public static void j6(Context context, String str, long j) {
        if (FH(context, str) && j > 0) {
            long currentTimeMillis = (System.currentTimeMillis() - j) / 3600000;
            String str2 = str + "_" + (currentTimeMillis / 24) + "days";
            v5(context, str2);
            Hw(context, str2);
            String str3 = str + "_" + currentTimeMillis + "hours";
            v5(context, str3);
            Hw(context, str3);
        }
    }

    public static void j6(Context context, String str) {
        if (FH(context, str)) {
            v5(context, str);
            Hw(context, str);
        }
    }

    public static void j6(Context context, String str, boolean z) {
        if (DW(context, str, z)) {
            v5(context, str);
            Hw(context, str);
        }
    }

    private static boolean DW(Context context, String str, boolean z) {
        boolean z2;
        SharedPreferences j6 = j6(context);
        if (z && j6.contains(str) && !j6.getBoolean(str, false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!j6.getBoolean(str, false)) {
            Editor edit = j6.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
        return z2;
    }

    private static boolean FH(Context context, String str) {
        SharedPreferences j6 = j6(context);
        if (j6.getBoolean(str, false)) {
            return false;
        }
        Editor edit = j6.edit();
        edit.putBoolean(str, true);
        edit.commit();
        return true;
    }

    private static SharedPreferences j6(Context context) {
        return context.getSharedPreferences("Conversions", 0);
    }

    private static void Hw(Context context, String str) {
        for (Entry entry : DW(context).getAll().entrySet()) {
            j6(context, str, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
        }
    }

    public static void j6(Context context, String str, int i) {
        SharedPreferences DW = DW(context);
        if (!DW.contains(str)) {
            Editor edit = DW.edit();
            edit.putInt(str, i);
            edit.commit();
            j6(str, i);
        }
    }

    public static boolean j6(Context context, String str, double... dArr) {
        return DW(context, str, dArr) != 0;
    }

    public static boolean DW(Context context, String str) {
        return DW(context, str, DW(2)) != 0;
    }

    public static int DW(Context context, String str, double... dArr) {
        SharedPreferences DW = DW(context);
        if (!DW.contains(str)) {
            int j6 = j6(dArr);
            Editor edit = DW.edit();
            edit.putInt(str, j6);
            edit.commit();
            j6(str, j6);
        }
        return DW.getInt(str, 0);
    }

    private static void v5(Context context, String str) {
        a.DW("Conversion_" + str);
    }

    private static void j6(Context context, String str, String str2, int i) {
        a.DW("Group_" + str2 + "_" + str + "_" + j6(i));
    }

    private static void j6(String str, int i) {
        a.DW("Group_" + str + "_" + j6(i));
    }

    private static String j6(int i) {
        return Character.toString((char) (i + 65));
    }

    private static SharedPreferences DW(Context context) {
        return context.getSharedPreferences("SplitTests", 0);
    }

    private static int j6(double... dArr) {
        double nextDouble = new Random().nextDouble();
        int i = 0;
        double d = 0.0d;
        while (i < dArr.length) {
            d += dArr[i];
            if (d >= nextDouble) {
                break;
            }
            i++;
        }
        if (i == dArr.length) {
            return dArr.length - 1;
        }
        return i;
    }

    private static double[] DW(int i) {
        double[] dArr = new double[i];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr[i2] = 1.0d / ((double) i);
        }
        return dArr;
    }
}
