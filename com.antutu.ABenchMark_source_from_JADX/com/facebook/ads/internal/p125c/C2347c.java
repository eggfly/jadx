package com.facebook.ads.internal.p125c;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.c.c */
public class C2347c {
    private List<C2344a> f8169a;
    private int f8170b;
    private C2348d f8171c;
    private String f8172d;

    public C2347c(C2348d c2348d, String str) {
        this.f8170b = 0;
        this.f8169a = new ArrayList();
        this.f8171c = c2348d;
        this.f8172d = str;
    }

    public C2348d m9041a() {
        return this.f8171c;
    }

    public void m9042a(C2344a c2344a) {
        this.f8169a.add(c2344a);
    }

    public String m9043b() {
        return this.f8172d;
    }

    public int m9044c() {
        return this.f8169a.size();
    }

    public C2344a m9045d() {
        if (this.f8170b >= this.f8169a.size()) {
            return null;
        }
        this.f8170b++;
        return (C2344a) this.f8169a.get(this.f8170b - 1);
    }
}
