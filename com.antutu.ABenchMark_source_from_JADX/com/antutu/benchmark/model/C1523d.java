package com.antutu.benchmark.model;

import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.utils.MLog;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.model.d */
public class C1523d {
    public static final String[] f5230a;
    public static String f5231b;
    public static boolean f5232c;
    public static String f5233d;
    public static String f5234e;
    public static String f5235f;
    public static int f5236g;
    public static String f5237h;
    public static int f5238i;
    public static List<Object> f5239j;
    public static String f5240k;
    public static String f5241l;

    static {
        f5230a = new String[]{"7001", "7002", "7003", "7004", "7005", "7006", "7007", "7008", "7009", "7010", "7011"};
        f5231b = "My name";
        f5232c = false;
        f5233d = BuildConfig.FLAVOR;
        f5234e = BuildConfig.FLAVOR;
        f5235f = BuildConfig.FLAVOR;
        f5236g = -1;
        f5237h = BuildConfig.FLAVOR;
        f5238i = 0;
        f5239j = null;
    }

    public static String m6059a() {
        return "http://certinfo.antutu.net";
    }

    public static String m6060a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append(str2).append("?lang=").append(C1523d.m6061b());
        return stringBuilder.toString();
    }

    public static String m6061b() {
        String country = ABenchmarkApplication.getContext().getResources().getConfiguration().locale.getCountry();
        String language = ABenchmarkApplication.getContext().getResources().getConfiguration().locale.getLanguage();
        return (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "zh_CN" : "zh_TW";
    }

    public static void m6062c() {
        f5241l = ABenchmarkApplication.getContext().getResources().getConfiguration().locale.getCountry();
        f5240k = ABenchmarkApplication.getContext().getResources().getConfiguration().locale.getLanguage();
        MLog.m6871i("hzd", "mSysLang=" + f5240k + ", mSysCountry=" + f5241l);
    }

    public static String m6063d() {
        return "fBC3F69MCOjdb4PGWIR4ij1R";
    }
}
