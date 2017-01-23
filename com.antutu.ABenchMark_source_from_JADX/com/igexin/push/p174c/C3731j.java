package com.igexin.push.p174c;

import anet.channel.strategy.dispatch.C0714a;
import com.igexin.p158b.p159a.p167c.C3688a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.c.j */
public class C3731j {
    private static final String f12584a;
    private String f12585b;
    private String f12586c;
    private int f12587d;
    private long f12588e;
    private long f12589f;
    private boolean f12590g;
    private int f12591h;
    private int f12592i;
    private int f12593j;

    static {
        f12584a = C3731j.class.getName();
    }

    public C3731j() {
        this.f12588e = 2147483647L;
        this.f12589f = -1;
        this.f12590g = true;
        this.f12593j = 3;
    }

    public C3731j(String str, int i) {
        this.f12588e = 2147483647L;
        this.f12589f = -1;
        this.f12590g = true;
        this.f12593j = 3;
        this.f12585b = str;
        this.f12587d = i;
    }

    private void m15282j() {
        this.f12586c = null;
        this.f12591h = 0;
        this.f12590g = true;
    }

    private boolean m15283k() {
        return this.f12586c != null && System.currentTimeMillis() - this.f12589f <= C3727f.f12572b && this.f12591h < this.f12593j;
    }

    public synchronized String m15284a() {
        return this.f12585b;
    }

    public void m15285a(int i) {
        this.f12587d = i;
    }

    public void m15286a(long j) {
        this.f12588e = j;
    }

    public synchronized void m15287a(String str) {
        this.f12585b = str;
    }

    public synchronized void m15288a(String str, long j, long j2) {
        this.f12586c = str;
        this.f12588e = j;
        this.f12589f = j2;
        this.f12591h = 0;
        this.f12592i = 0;
        this.f12590g = false;
    }

    public void m15289a(boolean z) {
        this.f12590g = z;
    }

    public synchronized String m15290b(boolean z) {
        String str;
        if (m15283k()) {
            if (z) {
                this.f12591h++;
                C3688a.m15097b(f12584a + "|disc network, ipFailedCnt++  = " + this.f12591h);
            } else {
                C3688a.m15097b(f12584a + "|disc user, ipFailedCnt =  " + this.f12591h);
            }
            C3688a.m15097b(f12584a + "|disc, ip is valid, use ip = " + this.f12586c);
            this.f12590g = false;
            str = this.f12586c;
        } else {
            m15282j();
            C3688a.m15097b(f12584a + "|disc, ip is invalid, use domain = " + this.f12585b);
            if (z) {
                this.f12592i++;
                C3688a.m15097b(f12584a + "|disc network, domainFailedCnt++ = " + this.f12592i);
            } else {
                C3688a.m15097b(f12584a + "|disc user, domainFailedCnt =  " + this.f12592i);
            }
            str = this.f12585b;
        }
        return str;
    }

    public synchronized void m15291b() {
        this.f12586c = null;
        this.f12588e = 2147483647L;
        this.f12589f = -1;
        this.f12590g = true;
        this.f12591h = 0;
    }

    public synchronized void m15292b(int i) {
        if (i < 1) {
            i = 1;
        }
        this.f12593j = i;
    }

    public void m15293b(long j) {
        this.f12589f = j;
    }

    public void m15294b(String str) {
        this.f12586c = str;
    }

    public String m15295c() {
        return this.f12586c;
    }

    public int m15296d() {
        return this.f12587d;
    }

    public synchronized long m15297e() {
        return this.f12588e;
    }

    public synchronized boolean m15298f() {
        boolean z = true;
        synchronized (this) {
            if (!m15283k()) {
                if (this.f12592i >= this.f12593j) {
                    this.f12592i = 0;
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized String m15299g() {
        String str;
        if (m15283k()) {
            this.f12590g = false;
            str = this.f12586c;
        } else {
            m15282j();
            str = this.f12585b;
        }
        return str;
    }

    public synchronized void m15300h() {
        C3688a.m15097b(f12584a + "|register or login success, reset ipFailedCnt + domainFailedCnt");
        this.f12591h = 0;
        this.f12592i = 0;
    }

    public JSONObject m15301i() {
        if (this.f12585b == null || this.f12586c == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C0714a.DOMAIN, this.f12585b);
            jSONObject.put("ip", this.f12586c);
            if (this.f12588e != 2147483647L) {
                jSONObject.put("consumeTime", this.f12588e);
            }
            jSONObject.put("port", this.f12587d);
            if (this.f12589f != -1) {
                jSONObject.put("detectSuccessTime", this.f12589f);
            }
            jSONObject.put("isDomain", this.f12590g);
            jSONObject.put("connectTryCnt", this.f12593j);
            return jSONObject;
        } catch (JSONException e) {
            C3688a.m15097b(f12584a + e.toString());
            return null;
        }
    }
}
