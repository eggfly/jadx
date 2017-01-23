package com.xiaomi.mistatistic.sdk.data;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0571j;
import org.json.JSONObject;

public class HttpEvent {
    private long f4809a;
    private long f4810b;
    private int f4811c;
    private String f4812d;
    private String f4813e;
    private long f4814f;
    private String f4815g;
    private long f4816h;
    private String f4817i;
    private String f4818j;
    private String f4819k;
    private int f4820l;

    public HttpEvent(String str, long j) {
        this(str, j, -1, null);
    }

    public HttpEvent(String str, long j, long j2) {
        this(str, j, j2, -1, null);
    }

    public HttpEvent(String str, long j, long j2, int i) {
        this(str, j, j2, i, null);
    }

    public HttpEvent(String str, long j, int i, String str2) {
        this(str, j, 0, i, str2);
    }

    public HttpEvent(String str, long j, long j2, int i, String str2) {
        this.f4814f = System.currentTimeMillis();
        this.f4816h = 0;
        this.f4820l = 0;
        this.f4815g = str;
        this.f4809a = j;
        this.f4811c = i;
        this.f4812d = str2;
        this.f4816h = j2;
        m6547b();
    }

    public HttpEvent(String str, String str2) {
        this(str, -1, -1, str2);
    }

    public void m6546a(String str) {
        this.f4815g = str;
    }

    public String m6544a() {
        return this.f4815g;
    }

    public void m6545a(long j) {
        this.f4810b = j;
    }

    public void m6547b() {
        if (C0551c.m6352a() == null) {
            this.f4813e = "NULL";
            return;
        }
        String b = C0571j.m6438b(C0551c.m6352a());
        if (TextUtils.isEmpty(b)) {
            this.f4813e = "NULL";
            return;
        }
        this.f4813e = b;
        if (!"WIFI".equalsIgnoreCase(b)) {
            this.f4817i = ((TelephonyManager) C0551c.m6352a().getSystemService("phone")).getSimOperator();
        }
    }

    public JSONObject m6549c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("net", this.f4813e);
        if (this.f4809a > 0) {
            jSONObject.put("cost", this.f4809a);
        }
        if (this.f4810b > 0) {
            jSONObject.put("first_byte_t", this.f4810b);
        }
        if (this.f4811c != -1) {
            jSONObject.put("code", this.f4811c);
        }
        if (!TextUtils.isEmpty(this.f4812d)) {
            jSONObject.put("exception", this.f4812d);
        }
        if (!TextUtils.isEmpty(this.f4817i)) {
            jSONObject.put("op", this.f4817i);
        }
        if (this.f4816h > 0) {
            jSONObject.put("flow", this.f4816h);
        }
        if (this.f4820l == 1 || this.f4820l == 2) {
            jSONObject.put("flow_status", this.f4820l);
        }
        if (!TextUtils.isEmpty(this.f4818j)) {
            jSONObject.put("rid", this.f4818j);
        }
        if (!TextUtils.isEmpty(this.f4819k)) {
            jSONObject.put("dns", this.f4819k);
        }
        jSONObject.put("t", this.f4814f);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpEvent)) {
            return false;
        }
        HttpEvent httpEvent = (HttpEvent) obj;
        if (TextUtils.equals(this.f4815g, httpEvent.f4815g) && TextUtils.equals(this.f4813e, httpEvent.f4813e) && TextUtils.equals(this.f4812d, httpEvent.f4812d) && TextUtils.equals(this.f4819k, httpEvent.f4819k) && this.f4811c == httpEvent.f4811c && this.f4809a == httpEvent.f4809a && this.f4814f == httpEvent.f4814f && this.f4816h == httpEvent.f4816h && this.f4820l == httpEvent.f4820l && TextUtils.equals(this.f4818j, httpEvent.f4818j) && this.f4810b == httpEvent.f4810b) {
            return true;
        }
        return false;
    }

    public void m6548b(String str) {
        this.f4818j = str;
    }

    public void m6550c(String str) {
        this.f4819k = str;
    }
}
