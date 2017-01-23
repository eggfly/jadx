package com.google.android.gms.p146b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.an */
public class an {
    private final Collection<am> f10252a;
    private final Collection<am<String>> f10253b;
    private final Collection<am<String>> f10254c;

    public an() {
        this.f10252a = new ArrayList();
        this.f10253b = new ArrayList();
        this.f10254c = new ArrayList();
    }

    public List<String> m11803a() {
        List<String> arrayList = new ArrayList();
        for (am c : this.f10253b) {
            String str = (String) c.m11794c();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void m11804a(am amVar) {
        this.f10252a.add(amVar);
    }

    public List<String> m11805b() {
        List<String> a = m11803a();
        for (am c : this.f10254c) {
            String str = (String) c.m11794c();
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    public void m11806b(am<String> amVar) {
        this.f10253b.add(amVar);
    }

    public void m11807c(am<String> amVar) {
        this.f10254c.add(amVar);
    }
}
