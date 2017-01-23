package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.cm */
public class cm implements Iterable<cl> {
    private final List<cl> f10455a;

    public cm() {
        this.f10455a = new LinkedList();
    }

    private cl m12071c(ii iiVar) {
        Iterator it = C2968s.m11540t().iterator();
        while (it.hasNext()) {
            cl clVar = (cl) it.next();
            if (clVar.f10452a == iiVar) {
                return clVar;
            }
        }
        return null;
    }

    public void m12072a(cl clVar) {
        this.f10455a.add(clVar);
    }

    public boolean m12073a(ii iiVar) {
        cl c = m12071c(iiVar);
        if (c == null) {
            return false;
        }
        c.f10453b.m12087b();
        return true;
    }

    public void m12074b(cl clVar) {
        this.f10455a.remove(clVar);
    }

    public boolean m12075b(ii iiVar) {
        return m12071c(iiVar) != null;
    }

    public Iterator<cl> iterator() {
        return this.f10455a.iterator();
    }
}
