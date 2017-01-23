package com.google.android.gms.p146b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.cx.C3108a;
import com.google.android.gms.p146b.gj.C3229a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

@gb
/* renamed from: com.google.android.gms.b.cu */
public class cu {
    private final Map<cv, cx> f10523a;
    private final LinkedList<cv> f10524b;
    private cr f10525c;

    public cu() {
        this.f10523a = new HashMap();
        this.f10524b = new LinkedList();
    }

    private static void m12142a(String str, cv cvVar) {
        if (C2972b.m11578a(2)) {
            hf.m12982e(String.format(str, new Object[]{cvVar}));
        }
    }

    private String[] m12143a(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), HttpRequest.f14548a);
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private String m12144e() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f10524b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((cv) it.next()).toString().getBytes(HttpRequest.f14548a), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return BuildConfig.FLAVOR;
        }
    }

    C3108a m12145a(AdRequestParcel adRequestParcel, String str) {
        cx cxVar;
        int i = new C3229a(this.f10525c.m12097b()).m12895a().f11139m;
        cv cvVar = new cv(adRequestParcel, str, i);
        cx cxVar2 = (cx) this.f10523a.get(cvVar);
        if (cxVar2 == null) {
            cu.m12142a("Interstitial pool created at %s.", cvVar);
            cxVar2 = new cx(adRequestParcel, str, i);
            this.f10523a.put(cvVar, cxVar2);
            cxVar = cxVar2;
        } else {
            cxVar = cxVar2;
        }
        this.f10524b.remove(cvVar);
        this.f10524b.add(cvVar);
        cvVar.m12153a();
        while (this.f10524b.size() > ((Integer) aq.ag.m11794c()).intValue()) {
            cv cvVar2 = (cv) this.f10524b.remove();
            cx cxVar3 = (cx) this.f10523a.get(cvVar2);
            cu.m12142a("Evicting interstitial queue for %s.", cvVar2);
            while (cxVar3.m12173e() > 0) {
                cxVar3.m12172d().f10535a.m10988D();
            }
            this.f10523a.remove(cvVar2);
        }
        while (cxVar.m12173e() > 0) {
            C3108a d = cxVar.m12172d();
            if (!d.f10539e || C2968s.m11529i().m13543a() - d.f10538d <= 1000 * ((long) ((Integer) aq.ai.m11794c()).intValue())) {
                cu.m12142a("Pooled interstitial returned at %s.", cvVar);
                return d;
            }
            cu.m12142a("Expired interstitial at %s.", cvVar);
        }
        return null;
    }

    void m12146a() {
        if (this.f10525c != null) {
            for (Entry entry : this.f10523a.entrySet()) {
                cv cvVar = (cv) entry.getKey();
                cx cxVar = (cx) entry.getValue();
                while (cxVar.m12173e() < ((Integer) aq.ah.m11794c()).intValue()) {
                    cu.m12142a("Pooling one interstitial for %s.", cvVar);
                    cxVar.m12169a(this.f10525c);
                }
            }
            m12148b();
        }
    }

    void m12147a(cr crVar) {
        if (this.f10525c == null) {
            this.f10525c = crVar;
            m12149c();
        }
    }

    void m12148b() {
        if (this.f10525c != null) {
            Editor edit = this.f10525c.m12097b().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.f10523a.entrySet()) {
                cv cvVar = (cv) entry.getKey();
                if (cvVar.m12154b()) {
                    edit.putString(cvVar.toString(), new cz((cx) entry.getValue()).m12198a());
                    cu.m12142a("Saved interstitial queue for %s.", cvVar);
                }
            }
            edit.putString("PoolKeys", m12144e());
            edit.commit();
        }
    }

    void m12149c() {
        Throwable e;
        if (this.f10525c != null) {
            cv cvVar;
            SharedPreferences sharedPreferences = this.f10525c.m12097b().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            m12150d();
            Map hashMap = new HashMap();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        cz czVar = new cz((String) entry.getValue());
                        cvVar = new cv(czVar.f10552a, czVar.f10553b, czVar.f10554c);
                        if (!this.f10523a.containsKey(cvVar)) {
                            this.f10523a.put(cvVar, new cx(czVar.f10552a, czVar.f10553b, czVar.f10554c));
                            hashMap.put(cvVar.toString(), cvVar);
                            cu.m12142a("Restored interstitial queue for %s.", cvVar);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    C2972b.m11584d("Malformed preferences value for InterstitialAdPool.", e);
                } catch (ClassCastException e3) {
                    e = e3;
                    C2972b.m11584d("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            for (Object obj : m12143a(sharedPreferences.getString("PoolKeys", BuildConfig.FLAVOR))) {
                cvVar = (cv) hashMap.get(obj);
                if (this.f10523a.containsKey(cvVar)) {
                    this.f10524b.add(cvVar);
                }
            }
        }
    }

    void m12150d() {
        while (this.f10524b.size() > 0) {
            cv cvVar = (cv) this.f10524b.remove();
            cx cxVar = (cx) this.f10523a.get(cvVar);
            cu.m12142a("Flushing interstitial queue for %s.", cvVar);
            while (cxVar.m12173e() > 0) {
                cxVar.m12172d().f10535a.m10988D();
            }
            this.f10523a.remove(cvVar);
        }
    }
}
