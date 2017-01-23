package com.google.android.gms.p146b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.p146b.C3345w.C3369a;
import com.google.android.gms.p146b.jb.C3268a;
import com.google.android.gms.p146b.ke.C3334a;
import com.umeng.message.util.HttpRequest;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.b.it */
public abstract class it<T> implements Comparable<it<T>> {
    private final C3334a f10386a;
    private final int f10387b;
    private final String f10388c;
    private final int f10389d;
    private final C3268a f10390e;
    private Integer f10391f;
    private iv f10392g;
    private boolean f10393h;
    private boolean f10394i;
    private boolean f10395j;
    private long f10396k;
    private ju f10397l;
    private C3369a f10398m;

    /* renamed from: com.google.android.gms.b.it.1 */
    class C32961 implements Runnable {
        final /* synthetic */ String f11489a;
        final /* synthetic */ long f11490b;
        final /* synthetic */ it f11491c;

        C32961(it itVar, String str, long j) {
            this.f11491c = itVar;
            this.f11489a = str;
            this.f11490b = j;
        }

        public void run() {
            this.f11491c.f10386a.m13612a(this.f11489a, this.f11490b);
            this.f11491c.f10386a.m13611a(toString());
        }
    }

    /* renamed from: com.google.android.gms.b.it.a */
    public enum C3297a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public it(int i, String str, C3268a c3268a) {
        this.f10386a = C3334a.f11605a ? new C3334a() : null;
        this.f10393h = true;
        this.f10394i = false;
        this.f10395j = false;
        this.f10396k = 0;
        this.f10398m = null;
        this.f10387b = i;
        this.f10388c = str;
        this.f10390e = c3268a;
        m11981a(new bv());
        this.f10389d = it.m11975a(str);
    }

    private static int m11975a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] m11976a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public int m11978a(it<T> itVar) {
        C3297a q = m12005q();
        C3297a q2 = itVar.m12005q();
        return q == q2 ? this.f10391f.intValue() - itVar.f10391f.intValue() : q2.ordinal() - q.ordinal();
    }

    public final it<?> m11979a(int i) {
        this.f10391f = Integer.valueOf(i);
        return this;
    }

    public it<?> m11980a(iv ivVar) {
        this.f10392g = ivVar;
        return this;
    }

    public it<?> m11981a(ju juVar) {
        this.f10397l = juVar;
        return this;
    }

    public it<?> m11982a(C3369a c3369a) {
        this.f10398m = c3369a;
        return this;
    }

    protected abstract jb<T> m11983a(gs gsVar);

    protected jz m11984a(jz jzVar) {
        return jzVar;
    }

    public Map<String, String> m11985a() {
        return Collections.emptyMap();
    }

    protected abstract void m11986a(T t);

    public int m11987b() {
        return this.f10387b;
    }

    public void m11988b(jz jzVar) {
        if (this.f10390e != null) {
            this.f10390e.m13139a(jzVar);
        }
    }

    public void m11989b(String str) {
        if (C3334a.f11605a) {
            this.f10386a.m13612a(str, Thread.currentThread().getId());
        } else if (this.f10396k == 0) {
            this.f10396k = SystemClock.elapsedRealtime();
        }
    }

    public int m11990c() {
        return this.f10389d;
    }

    void m11991c(String str) {
        if (this.f10392g != null) {
            this.f10392g.m13431b(this);
        }
        if (C3334a.f11605a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C32961(this, str, id));
                return;
            }
            this.f10386a.m13612a(str, id);
            this.f10386a.m13611a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f10396k >= 3000) {
            ke.m13615b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f10396k), toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m11978a((it) obj);
    }

    public String m11992d() {
        return this.f10388c;
    }

    public String m11993e() {
        return m11992d();
    }

    public C3369a m11994f() {
        return this.f10398m;
    }

    public boolean m11995g() {
        return this.f10394i;
    }

    @Deprecated
    protected Map<String, String> m11996h() {
        return m12000l();
    }

    @Deprecated
    protected String m11997i() {
        return m12001m();
    }

    @Deprecated
    public String m11998j() {
        return m12002n();
    }

    @Deprecated
    public byte[] m11999k() {
        Map h = m11996h();
        return (h == null || h.size() <= 0) ? null : m11976a(h, m11997i());
    }

    protected Map<String, String> m12000l() {
        return null;
    }

    protected String m12001m() {
        return HttpRequest.f14548a;
    }

    public String m12002n() {
        return "application/x-www-form-urlencoded; charset=" + m12001m();
    }

    public byte[] m12003o() {
        Map l = m12000l();
        return (l == null || l.size() <= 0) ? null : m11976a(l, m12001m());
    }

    public final boolean m12004p() {
        return this.f10393h;
    }

    public C3297a m12005q() {
        return C3297a.NORMAL;
    }

    public final int m12006r() {
        return this.f10397l.m11960a();
    }

    public ju m12007s() {
        return this.f10397l;
    }

    public void m12008t() {
        this.f10395j = true;
    }

    public String toString() {
        return (this.f10394i ? "[X] " : "[ ] ") + m11992d() + " " + ("0x" + Integer.toHexString(m11990c())) + " " + m12005q() + " " + this.f10391f;
    }

    public boolean m12009u() {
        return this.f10395j;
    }
}
