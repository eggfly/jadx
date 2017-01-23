package com.google.android.gms.p146b;

import android.support.v7.widget.LinearLayoutManager;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.aa */
public class aa {
    private final Object f10204a;
    private int f10205b;
    private List<C3377z> f10206c;

    public aa() {
        this.f10204a = new Object();
        this.f10206c = new LinkedList();
    }

    public C3377z m11730a() {
        C3377z c3377z = null;
        synchronized (this.f10204a) {
            if (this.f10206c.size() == 0) {
                C2972b.m11576a("Queue empty");
                return null;
            } else if (this.f10206c.size() >= 2) {
                int i = LinearLayoutManager.INVALID_OFFSET;
                for (C3377z c3377z2 : this.f10206c) {
                    C3377z c3377z3;
                    int i2;
                    int h = c3377z2.m13917h();
                    if (h > i) {
                        int i3 = h;
                        c3377z3 = c3377z2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        c3377z3 = c3377z;
                    }
                    i = i2;
                    c3377z = c3377z3;
                }
                this.f10206c.remove(c3377z);
                return c3377z;
            } else {
                c3377z2 = (C3377z) this.f10206c.get(0);
                c3377z2.m13913d();
                return c3377z2;
            }
        }
    }

    public boolean m11731a(C3377z c3377z) {
        boolean z;
        synchronized (this.f10204a) {
            if (this.f10206c.contains(c3377z)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean m11732b(C3377z c3377z) {
        boolean z;
        synchronized (this.f10204a) {
            Iterator it = this.f10206c.iterator();
            while (it.hasNext()) {
                C3377z c3377z2 = (C3377z) it.next();
                if (c3377z != c3377z2 && c3377z2.m13910b().equals(c3377z.m13910b())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void m11733c(C3377z c3377z) {
        synchronized (this.f10204a) {
            if (this.f10206c.size() >= 10) {
                C2972b.m11576a("Queue is full, current size = " + this.f10206c.size());
                this.f10206c.remove(0);
            }
            int i = this.f10205b;
            this.f10205b = i + 1;
            c3377z.m13907a(i);
            this.f10206c.add(c3377z);
        }
    }
}
