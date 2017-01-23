package com.miui.support.date;

import android.content.res.Resources;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AppConstants;
import com.miui.support.util.SoftReferenceSingleton;
import java.util.Locale;

public class CalendarFormatSymbols {
    private static final SoftReferenceSingleton<CalendarFormatSymbols> f1971a;
    private Resources f1972b;

    /* renamed from: com.miui.support.date.CalendarFormatSymbols.1 */
    final class C02411 extends SoftReferenceSingleton<CalendarFormatSymbols> {
        C02411() {
        }

        protected /* synthetic */ Object createInstance() {
            return m3400a();
        }

        protected CalendarFormatSymbols m3400a() {
            return new CalendarFormatSymbols();
        }
    }

    public CalendarFormatSymbols() {
        this.f1972b = AppConstants.m4227a().getResources();
    }

    static {
        f1971a = new C02411();
    }

    public static CalendarFormatSymbols m3401a() {
        return (CalendarFormatSymbols) f1971a.get();
    }

    public Locale m3402b() {
        return Locale.getDefault();
    }

    public String[] m3403c() {
        return this.f1972b.getStringArray(C0264R.array.solar_terms);
    }

    public String[] m3404d() {
        return this.f1972b.getStringArray(C0264R.array.chinese_days);
    }

    public String[] m3405e() {
        return this.f1972b.getStringArray(C0264R.array.detailed_am_pms);
    }

    public String[] m3406f() {
        return this.f1972b.getStringArray(C0264R.array.am_pms);
    }

    public String[] m3407g() {
        return this.f1972b.getStringArray(C0264R.array.chinese_digits);
    }

    public String[] m3408h() {
        return this.f1972b.getStringArray(C0264R.array.chinese_leap_months);
    }

    public String[] m3409i() {
        return this.f1972b.getStringArray(C0264R.array.chinese_months);
    }

    public String[] m3410j() {
        return this.f1972b.getStringArray(C0264R.array.earthly_branches);
    }

    public String[] m3411k() {
        return this.f1972b.getStringArray(C0264R.array.months_short);
    }

    public String[] m3412l() {
        return this.f1972b.getStringArray(C0264R.array.months_shortest);
    }

    public String[] m3413m() {
        return this.f1972b.getStringArray(C0264R.array.months);
    }

    public String[] m3414n() {
        return this.f1972b.getStringArray(C0264R.array.heavenly_stems);
    }

    public String[] m3415o() {
        return this.f1972b.getStringArray(C0264R.array.chinese_symbol_animals);
    }

    public String[] m3416p() {
        return this.f1972b.getStringArray(C0264R.array.eras);
    }

    public String[] m3417q() {
        return this.f1972b.getStringArray(C0264R.array.week_days_short);
    }

    public String[] m3418r() {
        return this.f1972b.getStringArray(C0264R.array.week_days_shortest);
    }

    public String[] m3419s() {
        return this.f1972b.getStringArray(C0264R.array.week_days);
    }
}
