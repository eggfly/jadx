package com.google.android.gms.ads.internal.client;

import aes;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.eh;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@eh
public final class e {
    public static final String j6;
    private final Date DW;
    private final String EQ;
    private final String FH;
    private final int Hw;
    private final int J0;
    private final Set<String> J8;
    private final Set<String> QX;
    private final boolean VH;
    private final Bundle Ws;
    private final boolean XL;
    private final Location Zo;
    private final Bundle gn;
    private final String tp;
    private final Map<Class<? extends Object>, Object> u7;
    private final Set<String> v5;
    private final com.google.android.gms.ads.search.a we;

    public static final class a {
        private final Bundle DW;
        private boolean EQ;
        private final HashMap<Class<? extends Object>, Object> FH;
        private final HashSet<String> Hw;
        private String J0;
        private int J8;
        private Date VH;
        private boolean Ws;
        private final HashSet<String> Zo;
        private String gn;
        private final HashSet<String> j6;
        private Location tp;
        private int u7;
        private final Bundle v5;
        private String we;

        public a() {
            this.j6 = new HashSet();
            this.DW = new Bundle();
            this.FH = new HashMap();
            this.Hw = new HashSet();
            this.v5 = new Bundle();
            this.Zo = new HashSet();
            this.u7 = -1;
            this.EQ = false;
            this.J8 = -1;
        }

        public void DW(String str) {
            this.Hw.add(str);
        }

        public void DW(boolean z) {
            this.Ws = z;
        }

        public void FH(String str) {
            this.Hw.remove(str);
        }

        public void j6(int i) {
            this.u7 = i;
        }

        public void j6(Location location) {
            this.tp = location;
        }

        public void j6(Class<? extends aes> cls, Bundle bundle) {
            this.DW.putBundle(cls.getName(), bundle);
        }

        public void j6(String str) {
            this.j6.add(str);
        }

        public void j6(Date date) {
            this.VH = date;
        }

        public void j6(boolean z) {
            this.J8 = z ? 1 : 0;
        }
    }

    static {
        j6 = w.j6().j6("emulator");
    }

    public e(a aVar) {
        this(aVar, null);
    }

    public e(a aVar, com.google.android.gms.ads.search.a aVar2) {
        this.DW = aVar.VH;
        this.FH = aVar.gn;
        this.Hw = aVar.u7;
        this.v5 = Collections.unmodifiableSet(aVar.j6);
        this.Zo = aVar.tp;
        this.VH = aVar.EQ;
        this.gn = aVar.DW;
        this.u7 = Collections.unmodifiableMap(aVar.FH);
        this.tp = aVar.we;
        this.EQ = aVar.J0;
        this.we = aVar2;
        this.J0 = aVar.J8;
        this.J8 = Collections.unmodifiableSet(aVar.Hw);
        this.Ws = aVar.v5;
        this.QX = Collections.unmodifiableSet(aVar.Zo);
        this.XL = aVar.Ws;
    }

    public String DW() {
        return this.FH;
    }

    public Bundle EQ() {
        return this.gn;
    }

    public int FH() {
        return this.Hw;
    }

    public Set<String> Hw() {
        return this.v5;
    }

    public Bundle J0() {
        return this.Ws;
    }

    public Set<String> J8() {
        return this.QX;
    }

    public String VH() {
        return this.tp;
    }

    public boolean Ws() {
        return this.XL;
    }

    public boolean Zo() {
        return this.VH;
    }

    public String gn() {
        return this.EQ;
    }

    public Bundle j6(Class<? extends aes> cls) {
        return this.gn.getBundle(cls.getName());
    }

    public Date j6() {
        return this.DW;
    }

    public boolean j6(Context context) {
        return this.J8.contains(w.j6().j6(context));
    }

    public Map<Class<? extends Object>, Object> tp() {
        return this.u7;
    }

    public com.google.android.gms.ads.search.a u7() {
        return this.we;
    }

    public Location v5() {
        return this.Zo;
    }

    public int we() {
        return this.J0;
    }
}
