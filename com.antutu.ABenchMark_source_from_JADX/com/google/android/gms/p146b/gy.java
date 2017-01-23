package com.google.android.gms.p146b;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@gb
/* renamed from: com.google.android.gms.b.gy */
public class gy {
    private final gz f11206a;
    private final LinkedList<C3233a> f11207b;
    private final Object f11208c;
    private final String f11209d;
    private final String f11210e;
    private long f11211f;
    private long f11212g;
    private boolean f11213h;
    private long f11214i;
    private long f11215j;
    private long f11216k;
    private long f11217l;

    @gb
    /* renamed from: com.google.android.gms.b.gy.a */
    private static final class C3233a {
        private long f11204a;
        private long f11205b;

        public C3233a() {
            this.f11204a = -1;
            this.f11205b = -1;
        }

        public long m12915a() {
            return this.f11205b;
        }

        public void m12916b() {
            this.f11205b = SystemClock.elapsedRealtime();
        }

        public void m12917c() {
            this.f11204a = SystemClock.elapsedRealtime();
        }

        public Bundle m12918d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f11204a);
            bundle.putLong("tclose", this.f11205b);
            return bundle;
        }
    }

    public gy(gz gzVar, String str, String str2) {
        this.f11208c = new Object();
        this.f11211f = -1;
        this.f11212g = -1;
        this.f11213h = false;
        this.f11214i = -1;
        this.f11215j = 0;
        this.f11216k = -1;
        this.f11217l = -1;
        this.f11206a = gzVar;
        this.f11209d = str;
        this.f11210e = str2;
        this.f11207b = new LinkedList();
    }

    public gy(String str, String str2) {
        this(C2968s.m11528h(), str, str2);
    }

    public void m12919a() {
        synchronized (this.f11208c) {
            if (this.f11217l != -1 && this.f11212g == -1) {
                this.f11212g = SystemClock.elapsedRealtime();
                this.f11206a.m12937a(this);
            }
            this.f11206a.m12947d().m12974c();
        }
    }

    public void m12920a(long j) {
        synchronized (this.f11208c) {
            this.f11217l = j;
            if (this.f11217l != -1) {
                this.f11206a.m12937a(this);
            }
        }
    }

    public void m12921a(AdRequestParcel adRequestParcel) {
        synchronized (this.f11208c) {
            this.f11216k = SystemClock.elapsedRealtime();
            this.f11206a.m12947d().m12972a(adRequestParcel, this.f11216k);
        }
    }

    public void m12922a(boolean z) {
        synchronized (this.f11208c) {
            if (this.f11217l != -1) {
                this.f11214i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f11212g = this.f11214i;
                    this.f11206a.m12937a(this);
                }
            }
        }
    }

    public void m12923b() {
        synchronized (this.f11208c) {
            if (this.f11217l != -1) {
                C3233a c3233a = new C3233a();
                c3233a.m12917c();
                this.f11207b.add(c3233a);
                this.f11215j++;
                this.f11206a.m12947d().m12973b();
                this.f11206a.m12937a(this);
            }
        }
    }

    public void m12924b(long j) {
        synchronized (this.f11208c) {
            if (this.f11217l != -1) {
                this.f11211f = j;
                this.f11206a.m12937a(this);
            }
        }
    }

    public void m12925b(boolean z) {
        synchronized (this.f11208c) {
            if (this.f11217l != -1) {
                this.f11213h = z;
                this.f11206a.m12937a(this);
            }
        }
    }

    public void m12926c() {
        synchronized (this.f11208c) {
            if (!(this.f11217l == -1 || this.f11207b.isEmpty())) {
                C3233a c3233a = (C3233a) this.f11207b.getLast();
                if (c3233a.m12915a() == -1) {
                    c3233a.m12916b();
                    this.f11206a.m12937a(this);
                }
            }
        }
    }

    public Bundle m12927d() {
        Bundle bundle;
        synchronized (this.f11208c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f11209d);
            bundle.putString("slotid", this.f11210e);
            bundle.putBoolean("ismediation", this.f11213h);
            bundle.putLong("treq", this.f11216k);
            bundle.putLong("tresponse", this.f11217l);
            bundle.putLong("timp", this.f11212g);
            bundle.putLong("tload", this.f11214i);
            bundle.putLong("pcc", this.f11215j);
            bundle.putLong("tfetch", this.f11211f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f11207b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3233a) it.next()).m12918d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
