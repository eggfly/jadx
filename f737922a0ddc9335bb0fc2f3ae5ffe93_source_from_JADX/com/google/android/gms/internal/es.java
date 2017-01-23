package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class es<T> implements Comparable<es<T>> {
    private final int DW;
    private long EQ;
    private final String FH;
    private final int Hw;
    private com.google.android.gms.internal.aa.a J0;
    private fi VH;
    private Integer Zo;
    private boolean gn;
    private final a j6;
    private boolean tp;
    private boolean u7;
    private final com.google.android.gms.internal.gh.a v5;
    private gu we;

    class 1 implements Runnable {
        final /* synthetic */ long DW;
        final /* synthetic */ es FH;
        final /* synthetic */ String j6;

        1(es esVar, String str, long j) {
            this.FH = esVar;
            this.j6 = str;
            this.DW = j;
        }

        public void run() {
            this.FH.j6.j6(this.j6, this.DW);
            this.FH.j6.j6(toString());
        }
    }

    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public es(int i, String str, com.google.android.gms.internal.gh.a aVar) {
        this.j6 = a.j6 ? new a() : null;
        this.gn = true;
        this.u7 = false;
        this.tp = false;
        this.EQ = 0;
        this.J0 = null;
        this.DW = i;
        this.FH = str;
        this.v5 = aVar;
        j6(new av());
        this.Hw = j6(str);
    }

    private static int j6(String str) {
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

    private byte[] j6(Map<String, String> map, String str) {
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
            Throwable th = e;
            String str2 = "Encoding not supported: ";
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    public int DW() {
        return this.Hw;
    }

    public void DW(hp hpVar) {
        if (this.v5 != null) {
            this.v5.j6(hpVar);
        }
    }

    public void DW(String str) {
        if (a.j6) {
            this.j6.j6(str, Thread.currentThread().getId());
        } else if (this.EQ == 0) {
            this.EQ = SystemClock.elapsedRealtime();
        }
    }

    @Deprecated
    public byte[] EQ() {
        Map gn = gn();
        return (gn == null || gn.size() <= 0) ? null : j6(gn, u7());
    }

    public String FH() {
        return this.FH;
    }

    void FH(String str) {
        if (this.VH != null) {
            this.VH.DW(this);
        }
        if (a.j6) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new 1(this, str, id));
                return;
            }
            this.j6.j6(str, id);
            this.j6.j6(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.EQ >= 3000) {
            hq.DW("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.EQ), toString());
        }
    }

    public String Hw() {
        return FH();
    }

    protected String J0() {
        return "UTF-8";
    }

    public String J8() {
        String str = "application/x-www-form-urlencoded; charset=";
        String valueOf = String.valueOf(J0());
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public void Mr() {
        this.tp = true;
    }

    public final boolean QX() {
        return this.gn;
    }

    public boolean U2() {
        return this.tp;
    }

    public Map<String, String> VH() {
        return Collections.emptyMap();
    }

    public byte[] Ws() {
        Map we = we();
        return (we == null || we.size() <= 0) ? null : j6(we, J0());
    }

    public a XL() {
        return a.NORMAL;
    }

    public boolean Zo() {
        return false;
    }

    public final int aM() {
        return this.we.j6();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return j6((es) obj);
    }

    @Deprecated
    protected Map<String, String> gn() {
        return we();
    }

    public gu j3() {
        return this.we;
    }

    public int j6() {
        return this.DW;
    }

    public int j6(es<T> esVar) {
        a XL = XL();
        a XL2 = esVar.XL();
        return XL == XL2 ? this.Zo.intValue() - esVar.Zo.intValue() : XL2.ordinal() - XL.ordinal();
    }

    public final es<?> j6(int i) {
        this.Zo = Integer.valueOf(i);
        return this;
    }

    public es<?> j6(com.google.android.gms.internal.aa.a aVar) {
        this.J0 = aVar;
        return this;
    }

    public es<?> j6(fi fiVar) {
        this.VH = fiVar;
        return this;
    }

    public es<?> j6(gu guVar) {
        this.we = guVar;
        return this;
    }

    protected abstract gh<T> j6(ef efVar);

    protected hp j6(hp hpVar) {
        return hpVar;
    }

    protected abstract void j6(T t);

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(DW()));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String valueOf2 = String.valueOf(FH());
        String valueOf3 = String.valueOf(XL());
        String valueOf4 = String.valueOf(this.Zo);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(str).append(valueOf2).append(" ").append(valueOf).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    @Deprecated
    public String tp() {
        return J8();
    }

    @Deprecated
    protected String u7() {
        return J0();
    }

    public com.google.android.gms.internal.aa.a v5() {
        return this.J0;
    }

    protected Map<String, String> we() {
        return null;
    }
}
