package com.qq.p035e.comm.net.rr;

import android.net.Uri;
import android.net.Uri.Builder;
import com.qq.p035e.comm.net.rr.Request.Method;
import com.qq.p035e.comm.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.e.comm.net.rr.AbstractRequest */
public abstract class AbstractRequest implements Request {
    private boolean f13520a;
    private int f13521b;
    private int f13522c;
    private int f13523d;
    private String f13524e;
    private Map<String, String> f13525f;
    private Map<String, String> f13526g;
    private Map<String, String> f13527h;
    private Map<String, String> f13528i;
    private Method f13529j;
    private byte[] f13530k;

    public AbstractRequest(String str, Method method, byte[] bArr) {
        this.f13520a = true;
        this.f13525f = new HashMap();
        this.f13526g = new HashMap();
        this.f13527h = Collections.unmodifiableMap(this.f13525f);
        this.f13528i = Collections.unmodifiableMap(this.f13526g);
        this.f13524e = str;
        this.f13529j = method;
        if (bArr == null) {
            this.f13530k = null;
        } else {
            this.f13530k = (byte[]) bArr.clone();
        }
    }

    public void addHeader(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            this.f13525f.put(str, str2);
        }
    }

    public void addQuery(String str, String str2) {
        this.f13526g.put(str, str2);
    }

    public int getConnectionTimeOut() {
        return this.f13522c;
    }

    public Map<String, String> getHeaders() {
        return this.f13527h;
    }

    public Method getMethod() {
        return this.f13529j;
    }

    public byte[] getPostData() {
        return this.f13530k;
    }

    public int getPriority() {
        return this.f13521b;
    }

    public Map<String, String> getQuerys() {
        return this.f13528i;
    }

    public int getSocketTimeOut() {
        return this.f13523d;
    }

    public String getUrl() {
        return this.f13524e;
    }

    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Entry entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean isAutoClose() {
        return this.f13520a;
    }

    public void setAutoClose(boolean z) {
        this.f13520a = z;
    }

    public void setConnectionTimeOut(int i) {
        this.f13522c = i;
    }

    public void setPriority(int i) {
        this.f13521b = i;
    }

    public void setSocketTimeOut(int i) {
        this.f13523d = i;
    }
}
