package com.p063b.p064a;

import com.p063b.p064a.C1847a.C1846a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.b.a.c */
public final class C1855c extends C1847a {
    boolean f6332b;
    private ArrayList<C1847a> f6333c;
    private HashMap<C1847a, C1854e> f6334d;
    private ArrayList<C1854e> f6335e;
    private ArrayList<C1854e> f6336f;
    private boolean f6337g;
    private C1850a f6338h;
    private boolean f6339i;
    private long f6340j;
    private C1863m f6341k;
    private long f6342l;

    /* renamed from: com.b.a.c.1 */
    class C18491 extends C1848b {
        boolean f6314a;
        final /* synthetic */ ArrayList f6315b;
        final /* synthetic */ C1855c f6316c;

        C18491(C1855c c1855c, ArrayList arrayList) {
            this.f6316c = c1855c;
            this.f6315b = arrayList;
            this.f6314a = false;
        }

        public void m6902b(C1847a c1847a) {
            if (!this.f6314a) {
                int size = this.f6315b.size();
                for (int i = 0; i < size; i++) {
                    C1854e c1854e = (C1854e) this.f6315b.get(i);
                    c1854e.f6326a.m6894a();
                    this.f6316c.f6333c.add(c1854e.f6326a);
                }
            }
        }
    }

    /* renamed from: com.b.a.c.a */
    private class C1850a implements C1846a {
        final /* synthetic */ C1855c f6317a;
        private C1855c f6318b;

        C1850a(C1855c c1855c, C1855c c1855c2) {
            this.f6317a = c1855c;
            this.f6318b = c1855c2;
        }

        public void m6903a(C1847a c1847a) {
        }

        public void m6904b(C1847a c1847a) {
            c1847a.m6897b(this);
            this.f6317a.f6333c.remove(c1847a);
            ((C1854e) this.f6318b.f6334d.get(c1847a)).f6331f = true;
            if (!this.f6317a.f6332b) {
                int i;
                boolean z;
                ArrayList c = this.f6318b.f6336f;
                int size = c.size();
                for (i = 0; i < size; i++) {
                    if (!((C1854e) c.get(i)).f6331f) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    if (this.f6317a.a != null) {
                        ArrayList arrayList = (ArrayList) this.f6317a.a.clone();
                        int size2 = arrayList.size();
                        for (i = 0; i < size2; i++) {
                            ((C1846a) arrayList.get(i)).m6891b(this.f6318b);
                        }
                    }
                    this.f6318b.f6339i = false;
                }
            }
        }

        public void m6905c(C1847a c1847a) {
        }
    }

    /* renamed from: com.b.a.c.b */
    public class C1851b {
        final /* synthetic */ C1855c f6319a;
        private C1854e f6320b;

        C1851b(C1855c c1855c, C1847a c1847a) {
            this.f6319a = c1855c;
            this.f6320b = (C1854e) c1855c.f6334d.get(c1847a);
            if (this.f6320b == null) {
                this.f6320b = new C1854e(c1847a);
                c1855c.f6334d.put(c1847a, this.f6320b);
                c1855c.f6335e.add(this.f6320b);
            }
        }

        public C1851b m6906a(C1847a c1847a) {
            C1854e c1854e = (C1854e) this.f6319a.f6334d.get(c1847a);
            if (c1854e == null) {
                c1854e = new C1854e(c1847a);
                this.f6319a.f6334d.put(c1847a, c1854e);
                this.f6319a.f6335e.add(c1854e);
            }
            c1854e.m6912a(new C1852c(this.f6320b, 0));
            return this;
        }
    }

    /* renamed from: com.b.a.c.c */
    private static class C1852c {
        public C1854e f6321a;
        public int f6322b;

        public C1852c(C1854e c1854e, int i) {
            this.f6321a = c1854e;
            this.f6322b = i;
        }
    }

    /* renamed from: com.b.a.c.d */
    private static class C1853d implements C1846a {
        private C1855c f6323a;
        private C1854e f6324b;
        private int f6325c;

        public C1853d(C1855c c1855c, C1854e c1854e, int i) {
            this.f6323a = c1855c;
            this.f6324b = c1854e;
            this.f6325c = i;
        }

        private void m6907d(C1847a c1847a) {
            if (!this.f6323a.f6332b) {
                Object obj;
                int size = this.f6324b.f6328c.size();
                for (int i = 0; i < size; i++) {
                    obj = (C1852c) this.f6324b.f6328c.get(i);
                    if (obj.f6322b == this.f6325c && obj.f6321a.f6326a == c1847a) {
                        c1847a.m6897b(this);
                        break;
                    }
                }
                obj = null;
                this.f6324b.f6328c.remove(obj);
                if (this.f6324b.f6328c.size() == 0) {
                    this.f6324b.f6326a.m6894a();
                    this.f6323a.f6333c.add(this.f6324b.f6326a);
                }
            }
        }

        public void m6908a(C1847a c1847a) {
            if (this.f6325c == 0) {
                m6907d(c1847a);
            }
        }

        public void m6909b(C1847a c1847a) {
            if (this.f6325c == 1) {
                m6907d(c1847a);
            }
        }

        public void m6910c(C1847a c1847a) {
        }
    }

    /* renamed from: com.b.a.c.e */
    private static class C1854e implements Cloneable {
        public C1847a f6326a;
        public ArrayList<C1852c> f6327b;
        public ArrayList<C1852c> f6328c;
        public ArrayList<C1854e> f6329d;
        public ArrayList<C1854e> f6330e;
        public boolean f6331f;

        public C1854e(C1847a c1847a) {
            this.f6327b = null;
            this.f6328c = null;
            this.f6329d = null;
            this.f6330e = null;
            this.f6331f = false;
            this.f6326a = c1847a;
        }

        public C1854e m6911a() {
            try {
                C1854e c1854e = (C1854e) super.clone();
                c1854e.f6326a = this.f6326a.m6898c();
                return c1854e;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        public void m6912a(C1852c c1852c) {
            if (this.f6327b == null) {
                this.f6327b = new ArrayList();
                this.f6329d = new ArrayList();
            }
            this.f6327b.add(c1852c);
            if (!this.f6329d.contains(c1852c.f6321a)) {
                this.f6329d.add(c1852c.f6321a);
            }
            C1854e c1854e = c1852c.f6321a;
            if (c1854e.f6330e == null) {
                c1854e.f6330e = new ArrayList();
            }
            c1854e.f6330e.add(this);
        }

        public /* synthetic */ Object clone() {
            return m6911a();
        }
    }

    public C1855c() {
        this.f6333c = new ArrayList();
        this.f6334d = new HashMap();
        this.f6335e = new ArrayList();
        this.f6336f = new ArrayList();
        this.f6337g = true;
        this.f6338h = null;
        this.f6332b = false;
        this.f6339i = false;
        this.f6340j = 0;
        this.f6341k = null;
        this.f6342l = -1;
    }

    private void m6918e() {
        int size;
        C1854e c1854e;
        int i;
        if (this.f6337g) {
            this.f6336f.clear();
            ArrayList arrayList = new ArrayList();
            size = this.f6335e.size();
            for (int i2 = 0; i2 < size; i2++) {
                c1854e = (C1854e) this.f6335e.get(i2);
                if (c1854e.f6327b == null || c1854e.f6327b.size() == 0) {
                    arrayList.add(c1854e);
                }
            }
            Object arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (i = 0; i < size2; i++) {
                    c1854e = (C1854e) arrayList.get(i);
                    this.f6336f.add(c1854e);
                    if (c1854e.f6330e != null) {
                        int size3 = c1854e.f6330e.size();
                        for (size = 0; size < size3; size++) {
                            C1854e c1854e2 = (C1854e) c1854e.f6330e.get(size);
                            c1854e2.f6329d.remove(c1854e);
                            if (c1854e2.f6329d.size() == 0) {
                                arrayList2.add(c1854e2);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f6337g = false;
            if (this.f6336f.size() != this.f6335e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f6335e.size();
        for (i = 0; i < size4; i++) {
            c1854e = (C1854e) this.f6335e.get(i);
            if (c1854e.f6327b != null && c1854e.f6327b.size() > 0) {
                int size5 = c1854e.f6327b.size();
                for (size = 0; size < size5; size++) {
                    C1852c c1852c = (C1852c) c1854e.f6327b.get(size);
                    if (c1854e.f6329d == null) {
                        c1854e.f6329d = new ArrayList();
                    }
                    if (!c1854e.f6329d.contains(c1852c.f6321a)) {
                        c1854e.f6329d.add(c1852c.f6321a);
                    }
                }
            }
            c1854e.f6331f = false;
        }
    }

    public /* synthetic */ C1847a m6919a(long j) {
        return m6925c(j);
    }

    public C1851b m6920a(C1847a c1847a) {
        if (c1847a == null) {
            return null;
        }
        this.f6337g = true;
        return new C1851b(this, c1847a);
    }

    public void m6921a() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.f6332b = false;
        this.f6339i = true;
        m6918e();
        int size = this.f6336f.size();
        for (i = 0; i < size; i++) {
            C1854e c1854e = (C1854e) this.f6336f.get(i);
            Collection b = c1854e.f6326a.m6896b();
            if (b != null && b.size() > 0) {
                Iterator it = new ArrayList(b).iterator();
                while (it.hasNext()) {
                    C1846a c1846a = (C1846a) it.next();
                    if ((c1846a instanceof C1853d) || (c1846a instanceof C1850a)) {
                        c1854e.f6326a.m6897b(c1846a);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            c1854e = (C1854e) this.f6336f.get(i2);
            if (this.f6338h == null) {
                this.f6338h = new C1850a(this, this);
            }
            if (c1854e.f6327b == null || c1854e.f6327b.size() == 0) {
                arrayList2.add(c1854e);
            } else {
                int size2 = c1854e.f6327b.size();
                for (i = 0; i < size2; i++) {
                    C1852c c1852c = (C1852c) c1854e.f6327b.get(i);
                    c1852c.f6321a.f6326a.m6895a(new C1853d(this, c1854e, c1852c.f6322b));
                }
                c1854e.f6328c = (ArrayList) c1854e.f6327b.clone();
            }
            c1854e.f6326a.m6895a(this.f6338h);
        }
        if (this.f6340j <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c1854e = (C1854e) it2.next();
                c1854e.f6326a.m6894a();
                this.f6333c.add(c1854e.f6326a);
            }
        } else {
            this.f6341k = C1863m.m6958b(0.0f, 1.0f);
            this.f6341k.m6977c(this.f6340j);
            this.f6341k.m6895a(new C18491(this, arrayList2));
            this.f6341k.m6971a();
        }
        if (this.a != null) {
            arrayList = (ArrayList) this.a.clone();
            i2 = arrayList.size();
            for (i = 0; i < i2; i++) {
                ((C1846a) arrayList.get(i)).m6890a(this);
            }
        }
        if (this.f6335e.size() == 0 && this.f6340j == 0) {
            this.f6339i = false;
            if (this.a != null) {
                arrayList = (ArrayList) this.a.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((C1846a) arrayList.get(i3)).m6891b(this);
                    i3++;
                }
            }
        }
    }

    public void m6922a(C1847a... c1847aArr) {
        int i = 1;
        if (c1847aArr != null) {
            this.f6337g = true;
            C1851b a = m6920a(c1847aArr[0]);
            while (i < c1847aArr.length) {
                a.m6906a(c1847aArr[i]);
                i++;
            }
        }
    }

    public void m6923b(long j) {
        this.f6340j = j;
    }

    public /* synthetic */ C1847a m6924c() {
        return m6926d();
    }

    public C1855c m6925c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.f6335e.iterator();
        while (it.hasNext()) {
            ((C1854e) it.next()).f6326a.m6893a(j);
        }
        this.f6342l = j;
        return this;
    }

    public /* synthetic */ Object clone() {
        return m6926d();
    }

    public C1855c m6926d() {
        C1855c c1855c = (C1855c) super.m6898c();
        c1855c.f6337g = true;
        c1855c.f6332b = false;
        c1855c.f6339i = false;
        c1855c.f6333c = new ArrayList();
        c1855c.f6334d = new HashMap();
        c1855c.f6335e = new ArrayList();
        c1855c.f6336f = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.f6335e.iterator();
        while (it.hasNext()) {
            C1854e c1854e = (C1854e) it.next();
            C1854e a = c1854e.m6911a();
            hashMap.put(c1854e, a);
            c1855c.f6335e.add(a);
            c1855c.f6334d.put(a.f6326a, a);
            a.f6327b = null;
            a.f6328c = null;
            a.f6330e = null;
            a.f6329d = null;
            ArrayList b = a.f6326a.m6896b();
            if (b != null) {
                Iterator it2 = b.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    C1846a c1846a = (C1846a) it2.next();
                    if (c1846a instanceof C1850a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c1846a);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        b.remove((C1846a) it3.next());
                    }
                }
            }
        }
        it = this.f6335e.iterator();
        while (it.hasNext()) {
            c1854e = (C1854e) it.next();
            a = (C1854e) hashMap.get(c1854e);
            if (c1854e.f6327b != null) {
                Iterator it4 = c1854e.f6327b.iterator();
                while (it4.hasNext()) {
                    C1852c c1852c = (C1852c) it4.next();
                    a.m6912a(new C1852c((C1854e) hashMap.get(c1852c.f6321a), c1852c.f6322b));
                }
            }
        }
        return c1855c;
    }
}
