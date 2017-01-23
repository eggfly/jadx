package com.p063b.p064a;

import java.util.ArrayList;

/* renamed from: com.b.a.a */
public abstract class C1847a implements Cloneable {
    ArrayList<C1846a> f6313a;

    /* renamed from: com.b.a.a.a */
    public interface C1846a {
        void m6890a(C1847a c1847a);

        void m6891b(C1847a c1847a);

        void m6892c(C1847a c1847a);
    }

    public C1847a() {
        this.f6313a = null;
    }

    public abstract C1847a m6893a(long j);

    public void m6894a() {
    }

    public void m6895a(C1846a c1846a) {
        if (this.f6313a == null) {
            this.f6313a = new ArrayList();
        }
        this.f6313a.add(c1846a);
    }

    public ArrayList<C1846a> m6896b() {
        return this.f6313a;
    }

    public void m6897b(C1846a c1846a) {
        if (this.f6313a != null) {
            this.f6313a.remove(c1846a);
            if (this.f6313a.size() == 0) {
                this.f6313a = null;
            }
        }
    }

    public C1847a m6898c() {
        try {
            C1847a c1847a = (C1847a) super.clone();
            if (this.f6313a != null) {
                ArrayList arrayList = this.f6313a;
                c1847a.f6313a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c1847a.f6313a.add(arrayList.get(i));
                }
            }
            return c1847a;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public /* synthetic */ Object clone() {
        return m6898c();
    }
}
