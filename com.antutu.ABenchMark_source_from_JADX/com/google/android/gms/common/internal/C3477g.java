package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C3427c.C3447a;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p146b.kd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.g */
public final class C3477g {
    private final Account f12058a;
    private final Set<Scope> f12059b;
    private final Set<Scope> f12060c;
    private final Map<C3444a<?>, C3476a> f12061d;
    private final int f12062e;
    private final View f12063f;
    private final String f12064g;
    private final String f12065h;
    private final kd f12066i;
    private Integer f12067j;

    /* renamed from: com.google.android.gms.common.internal.g.a */
    public static final class C3476a {
        public final Set<Scope> f12056a;
        public final boolean f12057b;
    }

    public C3477g(Account account, Set<Scope> set, Map<C3444a<?>, C3476a> map, int i, View view, String str, String str2, kd kdVar) {
        Map map2;
        this.f12058a = account;
        this.f12059b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f12061d = map2;
        this.f12063f = view;
        this.f12062e = i;
        this.f12064g = str;
        this.f12065h = str2;
        this.f12066i = kdVar;
        Set hashSet = new HashSet(this.f12059b);
        for (C3476a c3476a : this.f12061d.values()) {
            hashSet.addAll(c3476a.f12056a);
        }
        this.f12060c = Collections.unmodifiableSet(hashSet);
    }

    public static C3477g m14343a(Context context) {
        return new C3447a(context).m14252a();
    }

    public Account m14344a() {
        return this.f12058a;
    }

    public void m14345a(Integer num) {
        this.f12067j = num;
    }

    public Account m14346b() {
        return this.f12058a != null ? this.f12058a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m14347c() {
        return this.f12059b;
    }

    public Set<Scope> m14348d() {
        return this.f12060c;
    }

    public Map<C3444a<?>, C3476a> m14349e() {
        return this.f12061d;
    }

    public String m14350f() {
        return this.f12064g;
    }

    public String m14351g() {
        return this.f12065h;
    }

    public kd m14352h() {
        return this.f12066i;
    }

    public Integer m14353i() {
        return this.f12067j;
    }
}
