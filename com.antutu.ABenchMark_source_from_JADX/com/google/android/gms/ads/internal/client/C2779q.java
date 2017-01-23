package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.p154e.C2720a;
import com.google.android.gms.p146b.gb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.q */
public class C2779q {
    public static final C2779q f9450a;

    static {
        f9450a = new C2779q();
    }

    protected C2779q() {
    }

    public static C2779q m10726a() {
        return f9450a;
    }

    public AdRequestParcel m10727a(Context context, C2755b c2755b) {
        Date a = c2755b.m10592a();
        long time = a != null ? a.getTime() : -1;
        String b = c2755b.m10594b();
        int c = c2755b.m10595c();
        Collection d = c2755b.m10596d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = c2755b.m10593a(context);
        int l = c2755b.m10604l();
        Location e = c2755b.m10597e();
        Bundle a3 = c2755b.m10591a(AdMobAdapter.class);
        boolean f = c2755b.m10598f();
        String g = c2755b.m10599g();
        C2720a i = c2755b.m10601i();
        SearchAdRequestParcel searchAdRequestParcel = i != null ? new SearchAdRequestParcel(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = C2784w.m10741a().m11565a(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, a3, c, unmodifiableList, a2, l, f, g, searchAdRequestParcel, e, b, c2755b.m10603k(), c2755b.m10605m(), Collections.unmodifiableList(new ArrayList(c2755b.m10606n())), c2755b.m10600h(), str, c2755b.m10607o());
    }
}
