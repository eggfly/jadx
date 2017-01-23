package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.f;

@eh
public abstract class am<T> {
    private final String DW;
    private final T FH;
    private final int j6;

    class 1 extends am<Boolean> {
        1(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public Boolean DW(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(j6(), ((Boolean) DW()).booleanValue()));
        }

        public /* synthetic */ Object j6(SharedPreferences sharedPreferences) {
            return DW(sharedPreferences);
        }
    }

    class 2 extends am<Integer> {
        2(int i, String str, Integer num) {
            super(str, num, null);
        }

        public Integer DW(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(j6(), ((Integer) DW()).intValue()));
        }

        public /* synthetic */ Object j6(SharedPreferences sharedPreferences) {
            return DW(sharedPreferences);
        }
    }

    class 3 extends am<Long> {
        3(int i, String str, Long l) {
            super(str, l, null);
        }

        public Long DW(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(j6(), ((Long) DW()).longValue()));
        }

        public /* synthetic */ Object j6(SharedPreferences sharedPreferences) {
            return DW(sharedPreferences);
        }
    }

    class 4 extends am<String> {
        4(int i, String str, String str2) {
            super(str, str2, null);
        }

        public String DW(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(j6(), (String) DW());
        }

        public /* synthetic */ Object j6(SharedPreferences sharedPreferences) {
            return DW(sharedPreferences);
        }
    }

    private am(int i, String str, T t) {
        this.j6 = i;
        this.DW = str;
        this.FH = t;
        f.gn().j6(this);
    }

    public static am<String> DW(int i, String str) {
        am<String> j6 = j6(i, str, null);
        f.gn().FH(j6);
        return j6;
    }

    public static am<String> j6(int i, String str) {
        am<String> j6 = j6(i, str, null);
        f.gn().DW(j6);
        return j6;
    }

    public static am<Integer> j6(int i, String str, int i2) {
        return new 2(i, str, Integer.valueOf(i2));
    }

    public static am<Long> j6(int i, String str, long j) {
        return new 3(i, str, Long.valueOf(j));
    }

    public static am<Boolean> j6(int i, String str, Boolean bool) {
        return new 1(i, str, bool);
    }

    public static am<String> j6(int i, String str, String str2) {
        return new 4(i, str, str2);
    }

    public T DW() {
        return this.FH;
    }

    public T FH() {
        return f.u7().j6(this);
    }

    protected abstract T j6(SharedPreferences sharedPreferences);

    public String j6() {
        return this.DW;
    }
}
