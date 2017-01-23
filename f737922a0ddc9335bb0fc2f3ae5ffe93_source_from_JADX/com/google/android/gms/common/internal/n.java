package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.hx;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class n {
    private final Set<Scope> DW;
    private final Set<Scope> FH;
    private final Map<com.google.android.gms.common.api.a<?>, a> Hw;
    private final String VH;
    private final View Zo;
    private final String gn;
    private final Account j6;
    private Integer tp;
    private final hx u7;
    private final int v5;

    public static final class a {
        public final Set<Scope> j6;
    }

    public n(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, a> map, int i, View view, String str, String str2, hx hxVar) {
        Map map2;
        this.j6 = account;
        this.DW = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.Hw = map2;
        this.Zo = view;
        this.v5 = i;
        this.VH = str;
        this.gn = str2;
        this.u7 = hxVar;
        Set hashSet = new HashSet(this.DW);
        for (a aVar : this.Hw.values()) {
            hashSet.addAll(aVar.j6);
        }
        this.FH = Collections.unmodifiableSet(hashSet);
    }

    public static n j6(Context context) {
        return new Builder(context).j6();
    }

    public Set<Scope> DW() {
        return this.FH;
    }

    public String FH() {
        return this.VH;
    }

    public String Hw() {
        return this.gn;
    }

    public Integer Zo() {
        return this.tp;
    }

    public Account j6() {
        return this.j6;
    }

    public hx v5() {
        return this.u7;
    }
}
