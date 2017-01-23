package com.google.android.gms.analytics;

import afq;
import com.google.android.gms.common.internal.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class l {
    private final afq DW;
    private final List<r> EQ;
    private boolean FH;
    private long Hw;
    private long VH;
    private long Zo;
    private long gn;
    private final o j6;
    private final Map<Class<? extends n>, n> tp;
    private boolean u7;
    private long v5;

    l(l lVar) {
        this.j6 = lVar.j6;
        this.DW = lVar.DW;
        this.Hw = lVar.Hw;
        this.v5 = lVar.v5;
        this.Zo = lVar.Zo;
        this.VH = lVar.VH;
        this.gn = lVar.gn;
        this.EQ = new ArrayList(lVar.EQ);
        this.tp = new HashMap(lVar.tp.size());
        for (Entry entry : lVar.tp.entrySet()) {
            n FH = FH((Class) entry.getKey());
            ((n) entry.getValue()).j6(FH);
            this.tp.put((Class) entry.getKey(), FH);
        }
    }

    l(o oVar, afq afq) {
        b.j6((Object) oVar);
        b.j6((Object) afq);
        this.j6 = oVar;
        this.DW = afq;
        this.VH = 1800000;
        this.gn = 3024000000L;
        this.tp = new HashMap();
        this.EQ = new ArrayList();
    }

    private static <T extends n> T FH(Class<T> cls) {
        try {
            return (n) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public <T extends n> T DW(Class<T> cls) {
        n nVar = (n) this.tp.get(cls);
        if (nVar != null) {
            return nVar;
        }
        T FH = FH(cls);
        this.tp.put(cls, FH);
        return FH;
    }

    public Collection<n> DW() {
        return this.tp.values();
    }

    void EQ() {
        this.u7 = true;
    }

    public List<r> FH() {
        return this.EQ;
    }

    public long Hw() {
        return this.Hw;
    }

    void VH() {
        this.Zo = this.DW.DW();
        if (this.v5 != 0) {
            this.Hw = this.v5;
        } else {
            this.Hw = this.DW.j6();
        }
        this.FH = true;
    }

    public boolean Zo() {
        return this.FH;
    }

    o gn() {
        return this.j6;
    }

    public l j6() {
        return new l(this);
    }

    public <T extends n> T j6(Class<T> cls) {
        return (n) this.tp.get(cls);
    }

    public void j6(long j) {
        this.v5 = j;
    }

    public void j6(n nVar) {
        b.j6((Object) nVar);
        Class cls = nVar.getClass();
        if (cls.getSuperclass() != n.class) {
            throw new IllegalArgumentException();
        }
        nVar.j6(DW(cls));
    }

    boolean tp() {
        return this.u7;
    }

    p u7() {
        return this.j6.Ws();
    }

    public void v5() {
        u7().j6(this);
    }
}
