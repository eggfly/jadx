package com.cmcm.p074a.p075a.p112a;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.cmcm.a.a.a.aa */
public class aa {
    private int f7406a;
    private boolean f7407b;
    private final Class f7408c;
    private ArrayList f7409d;

    public aa() {
        this(null);
    }

    public aa(Class cls) {
        this.f7409d = new ArrayList();
        this.f7408c = cls;
    }

    private void m7920d() {
        int i = 0;
        this.f7407b = false;
        int size = this.f7409d.size();
        ArrayList arrayList = new ArrayList(size);
        while (i < size) {
            if (this.f7409d.get(i) != null) {
                arrayList.add(this.f7409d.get(i));
            }
            i++;
        }
        this.f7409d = arrayList;
    }

    public Iterator m7921a() {
        return this.f7409d.iterator();
    }

    public void m7922a(Object obj) {
        this.f7409d.add(obj);
    }

    public void m7923b() {
        this.f7406a++;
    }

    public void m7924c() {
        this.f7406a--;
        if (this.f7406a == 0 && this.f7407b) {
            m7920d();
        }
    }
}
