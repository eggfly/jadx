package com.p063b.p064a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.p063b.p064a.C1847a.C1846a;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.b.a.m */
public class C1863m extends C1847a {
    private static ThreadLocal<C1886a> f6358h;
    private static final ThreadLocal<ArrayList<C1863m>> f6359i;
    private static final ThreadLocal<ArrayList<C1863m>> f6360j;
    private static final ThreadLocal<ArrayList<C1863m>> f6361k;
    private static final ThreadLocal<ArrayList<C1863m>> f6362l;
    private static final ThreadLocal<ArrayList<C1863m>> f6363m;
    private static final Interpolator f6364n;
    private static final C1856l f6365o;
    private static final C1856l f6366p;
    private static long f6367z;
    private int f6368A;
    private int f6369B;
    private Interpolator f6370C;
    private ArrayList<C1623b> f6371D;
    long f6372b;
    long f6373c;
    int f6374d;
    boolean f6375e;
    C1879k[] f6376f;
    HashMap<String, C1879k> f6377g;
    private boolean f6378q;
    private int f6379r;
    private float f6380s;
    private boolean f6381t;
    private long f6382u;
    private boolean f6383v;
    private boolean f6384w;
    private long f6385x;
    private long f6386y;

    /* renamed from: com.b.a.m.b */
    public interface C1623b {
        void m6406a(C1863m c1863m);
    }

    /* renamed from: com.b.a.m.1 */
    static class C18811 extends ThreadLocal<ArrayList<C1863m>> {
        C18811() {
        }

        protected ArrayList<C1863m> m7080a() {
            return new ArrayList();
        }

        protected /* synthetic */ Object initialValue() {
            return m7080a();
        }
    }

    /* renamed from: com.b.a.m.2 */
    static class C18822 extends ThreadLocal<ArrayList<C1863m>> {
        C18822() {
        }

        protected ArrayList<C1863m> m7081a() {
            return new ArrayList();
        }

        protected /* synthetic */ Object initialValue() {
            return m7081a();
        }
    }

    /* renamed from: com.b.a.m.3 */
    static class C18833 extends ThreadLocal<ArrayList<C1863m>> {
        C18833() {
        }

        protected ArrayList<C1863m> m7082a() {
            return new ArrayList();
        }

        protected /* synthetic */ Object initialValue() {
            return m7082a();
        }
    }

    /* renamed from: com.b.a.m.4 */
    static class C18844 extends ThreadLocal<ArrayList<C1863m>> {
        C18844() {
        }

        protected ArrayList<C1863m> m7083a() {
            return new ArrayList();
        }

        protected /* synthetic */ Object initialValue() {
            return m7083a();
        }
    }

    /* renamed from: com.b.a.m.5 */
    static class C18855 extends ThreadLocal<ArrayList<C1863m>> {
        C18855() {
        }

        protected ArrayList<C1863m> m7084a() {
            return new ArrayList();
        }

        protected /* synthetic */ Object initialValue() {
            return m7084a();
        }
    }

    /* renamed from: com.b.a.m.a */
    private static class C1886a extends Handler {
        private C1886a() {
        }

        public void handleMessage(Message message) {
            ArrayList arrayList;
            Object obj;
            ArrayList arrayList2;
            int size;
            int i;
            C1863m c1863m;
            ArrayList arrayList3 = (ArrayList) C1863m.f6359i.get();
            ArrayList arrayList4 = (ArrayList) C1863m.f6361k.get();
            switch (message.what) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    arrayList = (ArrayList) C1863m.f6360j.get();
                    if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                        obj = null;
                    } else {
                        int i2 = 1;
                    }
                    while (arrayList.size() > 0) {
                        arrayList2 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        size = arrayList2.size();
                        for (i = 0; i < size; i++) {
                            c1863m = (C1863m) arrayList2.get(i);
                            if (c1863m.f6386y == 0) {
                                c1863m.m6969n();
                            } else {
                                arrayList4.add(c1863m);
                            }
                        }
                    }
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    obj = 1;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) C1863m.f6363m.get();
            arrayList2 = (ArrayList) C1863m.f6362l.get();
            size = arrayList4.size();
            for (i = 0; i < size; i++) {
                c1863m = (C1863m) arrayList4.get(i);
                if (c1863m.m6960b(currentAnimationTimeMillis)) {
                    arrayList.add(c1863m);
                }
            }
            size = arrayList.size();
            if (size > 0) {
                for (i = 0; i < size; i++) {
                    c1863m = (C1863m) arrayList.get(i);
                    c1863m.m6969n();
                    c1863m.f6383v = true;
                    arrayList4.remove(c1863m);
                }
                arrayList.clear();
            }
            i = arrayList3.size();
            int i3 = 0;
            while (i3 < i) {
                int i4;
                C1863m c1863m2 = (C1863m) arrayList3.get(i3);
                if (c1863m2.m6980e(currentAnimationTimeMillis)) {
                    arrayList2.add(c1863m2);
                }
                if (arrayList3.size() == i) {
                    i4 = i3 + 1;
                    i3 = i;
                } else {
                    i--;
                    arrayList2.remove(c1863m2);
                    i4 = i3;
                    i3 = i;
                }
                i = i3;
                i3 = i4;
            }
            if (arrayList2.size() > 0) {
                for (i3 = 0; i3 < arrayList2.size(); i3++) {
                    ((C1863m) arrayList2.get(i3)).m6962e();
                }
                arrayList2.clear();
            }
            if (obj == null) {
                return;
            }
            if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, C1863m.f6367z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    static {
        f6358h = new ThreadLocal();
        f6359i = new C18811();
        f6360j = new C18822();
        f6361k = new C18833();
        f6362l = new C18844();
        f6363m = new C18855();
        f6364n = new AccelerateDecelerateInterpolator();
        f6365o = new C1860f();
        f6366p = new C1857d();
        f6367z = 10;
    }

    public C1863m() {
        this.f6373c = -1;
        this.f6378q = false;
        this.f6379r = 0;
        this.f6380s = 0.0f;
        this.f6381t = false;
        this.f6374d = 0;
        this.f6383v = false;
        this.f6384w = false;
        this.f6375e = false;
        this.f6385x = 300;
        this.f6386y = 0;
        this.f6368A = 0;
        this.f6369B = 1;
        this.f6370C = f6364n;
        this.f6371D = null;
    }

    private void m6955a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f6378q = z;
        this.f6379r = 0;
        this.f6374d = 0;
        this.f6384w = true;
        this.f6381t = false;
        ((ArrayList) f6360j.get()).add(this);
        if (this.f6386y == 0) {
            m6979d(m6982g());
            this.f6374d = 0;
            this.f6383v = true;
            if (this.a != null) {
                ArrayList arrayList = (ArrayList) this.a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1846a) arrayList.get(i)).m6890a(this);
                }
            }
        }
        C1886a c1886a = (C1886a) f6358h.get();
        if (c1886a == null) {
            c1886a = new C1886a();
            f6358h.set(c1886a);
        }
        c1886a.sendEmptyMessage(0);
    }

    public static C1863m m6958b(float... fArr) {
        C1863m c1863m = new C1863m();
        c1863m.m6974a(fArr);
        return c1863m;
    }

    private boolean m6960b(long j) {
        if (this.f6381t) {
            long j2 = j - this.f6382u;
            if (j2 > this.f6386y) {
                this.f6372b = j - (j2 - this.f6386y);
                this.f6374d = 1;
                return true;
            }
        }
        this.f6381t = true;
        this.f6382u = j;
        return false;
    }

    private void m6962e() {
        ((ArrayList) f6359i.get()).remove(this);
        ((ArrayList) f6360j.get()).remove(this);
        ((ArrayList) f6361k.get()).remove(this);
        this.f6374d = 0;
        if (this.f6383v && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1846a) arrayList.get(i)).m6891b(this);
            }
        }
        this.f6383v = false;
        this.f6384w = false;
    }

    private void m6969n() {
        m6978d();
        ((ArrayList) f6359i.get()).add(this);
        if (this.f6386y > 0 && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1846a) arrayList.get(i)).m6890a(this);
            }
        }
    }

    public /* synthetic */ C1847a m6970a(long j) {
        return m6977c(j);
    }

    public void m6971a() {
        m6955a(false);
    }

    void m6972a(float f) {
        int i;
        float interpolation = this.f6370C.getInterpolation(f);
        this.f6380s = interpolation;
        for (C1879k a : this.f6376f) {
            a.m7063a(interpolation);
        }
        if (this.f6371D != null) {
            int size = this.f6371D.size();
            for (i = 0; i < size; i++) {
                ((C1623b) this.f6371D.get(i)).m6406a(this);
            }
        }
    }

    public void m6973a(int i) {
        this.f6368A = i;
    }

    public void m6974a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f6376f == null || this.f6376f.length == 0) {
                m6975a(C1879k.m7057a(BuildConfig.FLAVOR, fArr));
            } else {
                this.f6376f[0].m7068a(fArr);
            }
            this.f6375e = false;
        }
    }

    public void m6975a(C1879k... c1879kArr) {
        this.f6376f = c1879kArr;
        this.f6377g = new HashMap(r2);
        for (C1879k c1879k : c1879kArr) {
            this.f6377g.put(c1879k.m7071c(), c1879k);
        }
        this.f6375e = false;
    }

    public /* synthetic */ C1847a m6976c() {
        return m6981f();
    }

    public C1863m m6977c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6385x = j;
        return this;
    }

    public /* synthetic */ Object clone() {
        return m6981f();
    }

    void m6978d() {
        if (!this.f6375e) {
            for (C1879k b : this.f6376f) {
                b.m7069b();
            }
            this.f6375e = true;
        }
    }

    public void m6979d(long j) {
        m6978d();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f6374d != 1) {
            this.f6373c = j;
            this.f6374d = 2;
        }
        this.f6372b = currentAnimationTimeMillis - j;
        m6980e(currentAnimationTimeMillis);
    }

    boolean m6980e(long j) {
        boolean z = false;
        if (this.f6374d == 0) {
            this.f6374d = 1;
            if (this.f6373c < 0) {
                this.f6372b = j;
            } else {
                this.f6372b = j - this.f6373c;
                this.f6373c = -1;
            }
        }
        switch (this.f6374d) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float f;
                float f2 = this.f6385x > 0 ? ((float) (j - this.f6372b)) / ((float) this.f6385x) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f6379r < this.f6368A || this.f6368A == -1) {
                    if (this.a != null) {
                        int size = this.a.size();
                        for (int i = 0; i < size; i++) {
                            ((C1846a) this.a.get(i)).m6892c(this);
                        }
                    }
                    if (this.f6369B == 2) {
                        this.f6378q = !this.f6378q;
                    }
                    this.f6379r += (int) f2;
                    f = f2 % 1.0f;
                    this.f6372b += this.f6385x;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.f6378q) {
                    f = 1.0f - f;
                }
                m6972a(f);
                break;
        }
        return z;
    }

    public C1863m m6981f() {
        int i = 0;
        C1863m c1863m = (C1863m) super.m6898c();
        if (this.f6371D != null) {
            ArrayList arrayList = this.f6371D;
            c1863m.f6371D = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c1863m.f6371D.add(arrayList.get(i2));
            }
        }
        c1863m.f6373c = -1;
        c1863m.f6378q = false;
        c1863m.f6379r = 0;
        c1863m.f6375e = false;
        c1863m.f6374d = 0;
        c1863m.f6381t = false;
        C1879k[] c1879kArr = this.f6376f;
        if (c1879kArr != null) {
            int length = c1879kArr.length;
            c1863m.f6376f = new C1879k[length];
            c1863m.f6377g = new HashMap(length);
            while (i < length) {
                C1879k a = c1879kArr[i].m7062a();
                c1863m.f6376f[i] = a;
                c1863m.f6377g.put(a.m7071c(), a);
                i++;
            }
        }
        return c1863m;
    }

    public long m6982g() {
        return (!this.f6375e || this.f6374d == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.f6372b;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f6376f != null) {
            for (C1879k c1879k : this.f6376f) {
                str = str + "\n    " + c1879k.toString();
            }
        }
        return str;
    }
}
