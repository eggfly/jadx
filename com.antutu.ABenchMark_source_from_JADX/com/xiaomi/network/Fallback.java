package com.xiaomi.network;

import android.text.TextUtils;
import com.taobao.accs.internal.C4103b;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallback {
    public String f14840a;
    public String f14841b;
    public String f14842c;
    public String f14843d;
    public String f14844e;
    public String f14845f;
    public String f14846g;
    protected String f14847h;
    private long f14848i;
    private ArrayList<C4366c> f14849j;
    private String f14850k;
    private double f14851l;
    private String f14852m;
    private long f14853n;

    public Fallback(String str) {
        this.f14849j = new ArrayList();
        this.f14851l = 0.1d;
        this.f14852m = "s.mi1.cc";
        this.f14853n = C4156a.f13948j;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f14848i = System.currentTimeMillis();
        this.f14849j.add(new C4366c(str, -1));
        this.f14840a = HostManager.getInstance().getActiveNetworkLabel();
        this.f14841b = str;
    }

    private synchronized void m17891c(String str) {
        Iterator it = this.f14849j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(((C4366c) it.next()).f14864a, str)) {
                it.remove();
            }
        }
    }

    public synchronized Fallback m17892a(JSONObject jSONObject) {
        this.f14840a = jSONObject.optString("net");
        this.f14853n = jSONObject.getLong("ttl");
        this.f14851l = jSONObject.getDouble("pct");
        this.f14848i = jSONObject.getLong(MsgConstant.KEY_TS);
        this.f14843d = jSONObject.optString("city");
        this.f14842c = jSONObject.optString("prv");
        this.f14846g = jSONObject.optString("cty");
        this.f14844e = jSONObject.optString("isp");
        this.f14845f = jSONObject.optString("ip");
        this.f14841b = jSONObject.optString(C4103b.ELECTION_KEY_HOST);
        this.f14847h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            m17897a(new C4366c().m17939a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public ArrayList<String> m17893a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f14841b)) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = m17894a(true).iterator();
            while (it.hasNext()) {
                Host a = Host.m17913a((String) it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.m17916b(), a.m17915a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> m17894a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            C4366c[] c4366cArr = new C4366c[this.f14849j.size()];
            this.f14849j.toArray(c4366cArr);
            Arrays.sort(c4366cArr);
            arrayList = new ArrayList();
            for (C4366c c4366c : c4366cArr) {
                if (z) {
                    arrayList.add(c4366c.f14864a);
                } else {
                    int indexOf = c4366c.f14864a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(c4366c.f14864a.substring(0, indexOf));
                    } else {
                        arrayList.add(c4366c.f14864a);
                    }
                }
            }
        }
        return arrayList;
    }

    public void m17895a(double d) {
        this.f14851l = d;
    }

    public void m17896a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.f14853n = j;
    }

    synchronized void m17897a(C4366c c4366c) {
        m17891c(c4366c.f14864a);
        this.f14849j.add(c4366c);
    }

    public void m17898a(String str, int i, long j, long j2, Exception exception) {
        m17901a(str, new AccessHistory(i, j, j2, exception));
    }

    public void m17899a(String str, long j, long j2) {
        try {
            m17906b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException e) {
        }
    }

    public void m17900a(String str, long j, long j2, Exception exception) {
        try {
            m17907b(new URL(str).getHost(), j, j2, exception);
        } catch (MalformedURLException e) {
        }
    }

    public synchronized void m17901a(String str, AccessHistory accessHistory) {
        Iterator it = this.f14849j.iterator();
        while (it.hasNext()) {
            C4366c c4366c = (C4366c) it.next();
            if (TextUtils.equals(str, c4366c.f14864a)) {
                c4366c.m17941a(accessHistory);
                break;
            }
        }
    }

    public synchronized void m17902a(String[] strArr) {
        for (int size = this.f14849j.size() - 1; size >= 0; size--) {
            for (CharSequence equals : strArr) {
                if (TextUtils.equals(((C4366c) this.f14849j.get(size)).f14864a, equals)) {
                    this.f14849j.remove(size);
                    break;
                }
            }
        }
        Iterator it = this.f14849j.iterator();
        int i = 0;
        while (it.hasNext()) {
            C4366c c4366c = (C4366c) it.next();
            i = c4366c.f14865b > i ? c4366c.f14865b : i;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            m17897a(new C4366c(strArr[i2], (strArr.length + i) - i2));
        }
    }

    public boolean m17903a() {
        return TextUtils.equals(this.f14840a, HostManager.getInstance().getActiveNetworkLabel());
    }

    public boolean m17904a(Fallback fallback) {
        return TextUtils.equals(this.f14840a, fallback.f14840a);
    }

    public void m17905b(String str) {
        this.f14852m = str;
    }

    public void m17906b(String str, long j, long j2) {
        m17898a(str, 0, j, j2, null);
    }

    public void m17907b(String str, long j, long j2, Exception exception) {
        m17898a(str, -1, j, j2, exception);
    }

    public boolean m17908b() {
        return System.currentTimeMillis() - this.f14848i < this.f14853n;
    }

    boolean m17909c() {
        long j = 864000000;
        if (864000000 < this.f14853n) {
            j = this.f14853n;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f14848i > j || (currentTimeMillis - this.f14848i > this.f14853n && this.f14840a.startsWith("WIFI-"));
    }

    public synchronized ArrayList<String> m17910d() {
        return m17894a(false);
    }

    public synchronized String m17911e() {
        String str;
        if (!TextUtils.isEmpty(this.f14850k)) {
            str = this.f14850k;
        } else if (TextUtils.isEmpty(this.f14844e)) {
            str = "hardcode_isp";
        } else {
            this.f14850k = HostManager.join(new String[]{this.f14844e, this.f14842c, this.f14843d, this.f14846g, this.f14845f}, "_");
            str = this.f14850k;
        }
        return str;
    }

    public synchronized JSONObject m17912f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f14840a);
        jSONObject.put("ttl", this.f14853n);
        jSONObject.put("pct", this.f14851l);
        jSONObject.put(MsgConstant.KEY_TS, this.f14848i);
        jSONObject.put("city", this.f14843d);
        jSONObject.put("prv", this.f14842c);
        jSONObject.put("cty", this.f14846g);
        jSONObject.put("isp", this.f14844e);
        jSONObject.put("ip", this.f14845f);
        jSONObject.put(C4103b.ELECTION_KEY_HOST, this.f14841b);
        jSONObject.put("xf", this.f14847h);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f14849j.iterator();
        while (it.hasNext()) {
            jSONArray.put(((C4366c) it.next()).m17940a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14840a);
        stringBuilder.append("\n");
        stringBuilder.append(m17911e());
        Iterator it = this.f14849j.iterator();
        while (it.hasNext()) {
            C4366c c4366c = (C4366c) it.next();
            stringBuilder.append("\n");
            stringBuilder.append(c4366c.toString());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
