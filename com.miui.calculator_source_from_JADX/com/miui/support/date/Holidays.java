package com.miui.support.date;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.os.SystemProperties;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.Pools.Manager;
import com.miui.support.util.Pools.Pool;
import com.miui.support.util.SoftReferenceSingleton;
import java.util.HashMap;

public class Holidays {
    private static final HashMap<String, int[][]> f1974a;
    private static final int[][] f1975b;
    private static final SoftReferenceSingleton<Holidays> f1976c;
    private static final Pool<Calendar> f1977d;
    private static final SparseIntArray f1978h;
    private String f1979e;
    private Resources f1980f;
    private boolean f1981g;

    /* renamed from: com.miui.support.date.Holidays.1 */
    final class C02431 extends Manager<Calendar> {
        C02431() {
        }

        public /* synthetic */ Object m3433b() {
            return m3432a();
        }

        public Calendar m3432a() {
            return new Calendar();
        }
    }

    private static class HolidaysSingleton extends SoftReferenceSingleton<Holidays> {

        /* renamed from: com.miui.support.date.Holidays.HolidaysSingleton.1 */
        final class C02441 implements Runnable {
            C02441() {
            }

            public void run() {
                ((Holidays) Holidays.f1976c.get()).m3437a(DeviceHelper.m4219a());
            }
        }

        private HolidaysSingleton() {
        }

        protected /* synthetic */ Object createInstance() {
            return m3434a();
        }

        static {
            SystemProperties.m5190a(new C02441());
        }

        protected Holidays m3434a() {
            return new Holidays();
        }
    }

    static {
        r0 = new int[16][];
        r0[0] = new int[]{-1, C0264R.string.the_eve_of_the_spring_festival};
        r0[1] = new int[]{101, C0264R.string.the_spring_festival};
        r0[2] = new int[]{102, C0264R.string.the_second_day};
        r0[3] = new int[]{103, C0264R.string.the_third_day};
        r0[4] = new int[]{104, C0264R.string.the_forth_day};
        r0[5] = new int[]{105, C0264R.string.the_fifth_day};
        r0[6] = new int[]{106, C0264R.string.the_sixth_day};
        r0[7] = new int[]{107, C0264R.string.the_seventh_day};
        r0[8] = new int[]{115, C0264R.string.the_lantern_festival};
        r0[9] = new int[]{505, C0264R.string.the_dragon_boat_festival};
        r0[10] = new int[]{707, C0264R.string.the_night_of_sevens};
        r0[11] = new int[]{715, C0264R.string.the_spirit_festival};
        r0[12] = new int[]{815, C0264R.string.the_mid_autumn_festival};
        r0[13] = new int[]{909, C0264R.string.the_double_ninth_festival};
        r0[14] = new int[]{1015, C0264R.string.the_water_lantern_festival};
        r0[15] = new int[]{1208, C0264R.string.the_laba_festival};
        f1975b = r0;
        f1974a = new HashMap();
        r2 = new int[7][];
        r2[0] = new int[]{101, C0264R.string.the_new_years_day};
        r2[1] = new int[]{214, C0264R.string.the_valentines_day};
        r2[2] = new int[]{308, C0264R.string.the_international_womens_day};
        r2[3] = new int[]{312, C0264R.string.the_arbor_day};
        r2[4] = new int[]{401, C0264R.string.the_fools_day};
        r2[5] = new int[]{501, C0264R.string.the_labour_day};
        r2[6] = new int[]{1225, C0264R.string.the_christmas_day};
        f1974a.put("", r2);
        r2 = new int[13][];
        r2[0] = new int[]{101, C0264R.string.the_new_years_day};
        r2[1] = new int[]{214, C0264R.string.the_valentines_day};
        r2[2] = new int[]{308, C0264R.string.the_international_womens_day};
        r2[3] = new int[]{312, C0264R.string.the_arbor_day};
        r2[4] = new int[]{401, C0264R.string.the_fools_day};
        r2[5] = new int[]{501, C0264R.string.the_labour_day};
        r2[6] = new int[]{504, C0264R.string.the_chinese_youth_day};
        r2[7] = new int[]{601, C0264R.string.the_childrens_day};
        r2[8] = new int[]{701, C0264R.string.the_partys_day};
        r2[9] = new int[]{801, C0264R.string.the_armys_day};
        r2[10] = new int[]{910, C0264R.string.the_teachers_day};
        r2[11] = new int[]{1001, C0264R.string.the_national_day};
        r2[12] = new int[]{1225, C0264R.string.the_christmas_day};
        f1974a.put("CN", r2);
        r2 = new int[18][];
        r2[0] = new int[]{101, C0264R.string.the_new_years_day};
        r2[1] = new int[]{214, C0264R.string.the_valentines_day};
        r2[2] = new int[]{228, C0264R.string.the_peace_day};
        r2[3] = new int[]{308, C0264R.string.the_international_womens_day};
        r2[4] = new int[]{312, C0264R.string.the_arbor_day};
        r2[5] = new int[]{314, C0264R.string.the_anti_aggression_day};
        r2[6] = new int[]{329, C0264R.string.the_tw_youth_day};
        r2[7] = new int[]{401, C0264R.string.the_fools_day};
        r2[8] = new int[]{404, C0264R.string.the_tw_childrens_day};
        r2[9] = new int[]{501, C0264R.string.the_labour_day};
        r2[10] = new int[]{715, C0264R.string.the_anniversary_of_lifting_martial_law};
        r2[11] = new int[]{903, C0264R.string.the_armed_forces_day};
        r2[12] = new int[]{928, C0264R.string.the_teachers_day};
        r2[13] = new int[]{1010, C0264R.string.the_national_day};
        r2[14] = new int[]{1024, C0264R.string.the_united_nations_day};
        r2[15] = new int[]{1025, C0264R.string.the_retrocession_day};
        r2[16] = new int[]{1112, C0264R.string.the_national_father_day};
        r2[17] = new int[]{1225, C0264R.string.the_christmas_day};
        f1974a.put("TW", r2);
        r2 = new int[7][];
        r2[0] = new int[]{-1, C0264R.string.the_easter_day};
        r2[1] = new int[]{101, C0264R.string.the_new_years_day};
        r2[2] = new int[]{214, C0264R.string.the_valentines_day};
        r2[3] = new int[]{501, C0264R.string.the_labour_day};
        r2[4] = new int[]{701, C0264R.string.the_hksar_establishment_day};
        r2[5] = new int[]{1001, C0264R.string.the_national_day};
        r2[6] = new int[]{1225, C0264R.string.the_christmas_day};
        f1974a.put("HK", r2);
        f1976c = new HolidaysSingleton();
        f1977d = Pools.m5435b(new C02431(), 1);
        f1978h = new SparseIntArray();
    }

    private Holidays() {
        this(DeviceHelper.m4219a());
    }

    private Holidays(String str) {
        this.f1980f = AppConstants.m4227a().getResources();
        m3437a(str);
    }

    private void m3437a(String str) {
        this.f1979e = str.toUpperCase();
        boolean z = "CN".equals(this.f1979e) || "HK".equals(this.f1979e) || "TW".equals(this.f1979e);
        this.f1981g = z;
    }
}
