package com.miui.calculator.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.miui.calculator.CalculatorApplication;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.xiaomi.mistatistic.sdk.CustomSettings;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtils {
    public static String f1556a;
    private static String f1557b;
    private static boolean f1558c;

    static {
        try {
            Context b = CalculatorApplication.m2559b();
            PackageInfo packageInfo = b.getPackageManager().getPackageInfo(b.getPackageName(), 0);
            f1556a = packageInfo.versionName;
            f1557b = String.valueOf(packageInfo.versionCode);
            f1558c = CalculatorUtils.m2830i();
            Log.i("StatisticUtils", String.format("Calculator versionName:%s, versionCode:%s, statVersion:%s", new Object[]{f1556a, f1557b, "2"}));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean m2894a() {
        return (CalculatorUtils.m2821b() || CalculatorUtils.m2823c()) ? false : true;
    }

    public static void m2888a(Context context) {
        if (m2894a()) {
            try {
                CustomSettings.m6252a(true);
                MiStatInterface.m6269a(true);
                MiStatInterface.m6263a(context, "2882303761517473707", "5171747317707", m2895b(context), true);
                MiStatInterface.m6260a(1, 0);
            } catch (Throwable e) {
                Log.e("StatisticUtils", "initialize error", e);
            }
        }
    }

    private static String m2895b(Context context) {
        String str = null;
        try {
            str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("mi_stat_channel");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str) || str.equals("${channel_value}")) {
            str = "miui";
        }
        Log.i("StatisticUtils", "getChannelValue: " + str);
        return str;
    }

    private static void m2893a(Map<String, String> map) {
        map.put("stat_version", "2");
        map.put("param_version_name", f1556a);
        map.put("param_version_code", f1557b);
        map.put("param_is_miui_rom", String.valueOf(f1558c));
    }

    public static void m2891a(String str, String str2) {
        m2892a(str, str2, new HashMap());
    }

    public static void m2892a(String str, String str2, Map<String, String> map) {
        if (m2894a()) {
            Map hashMap;
            if (map == null) {
                try {
                    hashMap = new HashMap();
                } catch (Throwable e) {
                    Log.e("StatisticUtils", "recordCountEvent error", e);
                    return;
                }
            }
            m2893a(hashMap);
            MiStatInterface.m6268a(str, str2, hashMap);
        }
    }

    public static void m2889a(String str) {
        if (m2894a()) {
            try {
                MiStatInterface.m6261a(CalculatorApplication.m2559b(), str);
            } catch (Throwable e) {
                Log.e("StatisticUtils", "recordPageStart error", e);
            }
        }
    }

    public static void m2897b(String str) {
        if (m2894a()) {
            try {
                MiStatInterface.m6271b(CalculatorApplication.m2559b(), str);
            } catch (Throwable e) {
                Log.e("StatisticUtils", "recordPageEnd error", e);
            }
        }
    }

    public static void m2899c(String str) {
        Map hashMap = new HashMap();
        hashMap.put("from", str);
        m2892a("category_click", "count_btn_click_main_menu_activity", hashMap);
    }

    public static void m2896b() {
        m2891a("category_click", "count_enter_cal_edit_mode");
    }

    public static void m2900d(String str) {
        Map hashMap = new HashMap();
        hashMap.put("from", str);
        m2892a("category_click", "count_long_click_cal_result", hashMap);
    }

    public static void m2901e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("from", str);
        m2892a("category_click", "count_reulst_menu_click_wordfigure", hashMap);
    }

    public static void m2902f(String str) {
        Map hashMap = new HashMap();
        hashMap.put("from", str);
        m2892a("category_click", "count_reulst_menu_click_copy", hashMap);
    }

    public static void m2887a(int i, int i2, double d, double d2, int i3, long j, double d3, double d4) {
        Object obj;
        String str;
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                str = "commercial";
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                str = "accumulation";
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                str = "combining";
                break;
            default:
                obj = null;
                break;
        }
        Object obj2 = null;
        switch (i2) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                obj2 = "fixed_interest";
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                obj2 = "fixed_principal";
                break;
        }
        Map hashMap = new HashMap();
        hashMap.put("mortgageType", obj);
        hashMap.put("repaymentType", obj2);
        hashMap.put("loans", String.valueOf(d));
        hashMap.put("loansCombinded", String.valueOf(d2));
        hashMap.put("mortgageYears", String.valueOf(i3));
        hashMap.put("startTime", String.valueOf(j));
        hashMap.put("rate", String.valueOf(d3));
        hashMap.put("rateCombined", String.valueOf(d4));
        m2892a("category_click", "count_btn_click_mortgage_cal", hashMap);
    }

    public static void m2898b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("unit", str2);
        m2892a("unit_select", "select_unit_" + str, hashMap);
    }

    public static void m2890a(String str, Intent intent) {
        Map hashMap = new HashMap();
        hashMap.put("param_activity", str);
        String str2 = null;
        if (intent != null) {
            str2 = intent.getStringExtra("miref");
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "self";
        }
        hashMap.put("param_mi_ref", str2);
        m2892a("category_start", "start_activity", hashMap);
        Log.i("StatisticUtils", "record start, activity:" + str + ", miref:" + str2);
    }

    public static void m2903g(String str) {
        Map hashMap = new HashMap();
        hashMap.put("preference_key", str);
        m2892a("category_click", "settings_click", hashMap);
    }
}
