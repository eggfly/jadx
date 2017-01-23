package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C2633b;
import com.google.android.gms.ads.p154e.C2720a;
import com.google.android.gms.p146b.gb;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.b */
public final class C2755b {
    public static final String f9374a;
    private final Date f9375b;
    private final String f9376c;
    private final int f9377d;
    private final Set<String> f9378e;
    private final Location f9379f;
    private final boolean f9380g;
    private final Bundle f9381h;
    private final Map<Class<? extends Object>, Object> f9382i;
    private final String f9383j;
    private final String f9384k;
    private final C2720a f9385l;
    private final int f9386m;
    private final Set<String> f9387n;
    private final Bundle f9388o;
    private final Set<String> f9389p;
    private final boolean f9390q;

    /* renamed from: com.google.android.gms.ads.internal.client.b.a */
    public static final class C2754a {
        private final HashSet<String> f9359a;
        private final Bundle f9360b;
        private final HashMap<Class<? extends Object>, Object> f9361c;
        private final HashSet<String> f9362d;
        private final Bundle f9363e;
        private final HashSet<String> f9364f;
        private Date f9365g;
        private String f9366h;
        private int f9367i;
        private Location f9368j;
        private boolean f9369k;
        private String f9370l;
        private String f9371m;
        private int f9372n;
        private boolean f9373o;

        public C2754a() {
            this.f9359a = new HashSet();
            this.f9360b = new Bundle();
            this.f9361c = new HashMap();
            this.f9362d = new HashSet();
            this.f9363e = new Bundle();
            this.f9364f = new HashSet();
            this.f9367i = -1;
            this.f9369k = false;
            this.f9372n = -1;
        }

        public void m10582a(int i) {
            this.f9367i = i;
        }

        public void m10583a(Location location) {
            this.f9368j = location;
        }

        public void m10584a(Class<? extends C2633b> cls, Bundle bundle) {
            this.f9360b.putBundle(cls.getName(), bundle);
        }

        public void m10585a(String str) {
            this.f9359a.add(str);
        }

        public void m10586a(Date date) {
            this.f9365g = date;
        }

        public void m10587a(boolean z) {
            this.f9372n = z ? 1 : 0;
        }

        public void m10588b(String str) {
            this.f9362d.add(str);
        }

        public void m10589b(boolean z) {
            this.f9373o = z;
        }

        public void m10590c(String str) {
            this.f9362d.remove(str);
        }
    }

    static {
        f9374a = C2784w.m10741a().m11563a("emulator");
    }

    public C2755b(C2754a c2754a) {
        this(c2754a, null);
    }

    public C2755b(C2754a c2754a, C2720a c2720a) {
        this.f9375b = c2754a.f9365g;
        this.f9376c = c2754a.f9366h;
        this.f9377d = c2754a.f9367i;
        this.f9378e = Collections.unmodifiableSet(c2754a.f9359a);
        this.f9379f = c2754a.f9368j;
        this.f9380g = c2754a.f9369k;
        this.f9381h = c2754a.f9360b;
        this.f9382i = Collections.unmodifiableMap(c2754a.f9361c);
        this.f9383j = c2754a.f9370l;
        this.f9384k = c2754a.f9371m;
        this.f9385l = c2720a;
        this.f9386m = c2754a.f9372n;
        this.f9387n = Collections.unmodifiableSet(c2754a.f9362d);
        this.f9388o = c2754a.f9363e;
        this.f9389p = Collections.unmodifiableSet(c2754a.f9364f);
        this.f9390q = c2754a.f9373o;
    }

    public Bundle m10591a(Class<? extends C2633b> cls) {
        return this.f9381h.getBundle(cls.getName());
    }

    public Date m10592a() {
        return this.f9375b;
    }

    public boolean m10593a(Context context) {
        return this.f9387n.contains(C2784w.m10741a().m11562a(context));
    }

    public String m10594b() {
        return this.f9376c;
    }

    public int m10595c() {
        return this.f9377d;
    }

    public Set<String> m10596d() {
        return this.f9378e;
    }

    public Location m10597e() {
        return this.f9379f;
    }

    public boolean m10598f() {
        return this.f9380g;
    }

    public String m10599g() {
        return this.f9383j;
    }

    public String m10600h() {
        return this.f9384k;
    }

    public C2720a m10601i() {
        return this.f9385l;
    }

    public Map<Class<? extends Object>, Object> m10602j() {
        return this.f9382i;
    }

    public Bundle m10603k() {
        return this.f9381h;
    }

    public int m10604l() {
        return this.f9386m;
    }

    public Bundle m10605m() {
        return this.f9388o;
    }

    public Set<String> m10606n() {
        return this.f9389p;
    }

    public boolean m10607o() {
        return this.f9390q;
    }
}
