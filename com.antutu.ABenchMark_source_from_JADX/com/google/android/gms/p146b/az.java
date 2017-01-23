package com.google.android.gms.p146b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.igexin.sdk.PushConsts;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.az */
public class az {
    boolean f10344a;
    private final List<aw> f10345b;
    private final Map<String, String> f10346c;
    private final Object f10347d;
    private String f10348e;
    private aw f10349f;
    private az f10350g;

    public az(boolean z, String str, String str2) {
        this.f10345b = new LinkedList();
        this.f10346c = new LinkedHashMap();
        this.f10347d = new Object();
        this.f10344a = z;
        this.f10346c.put(PushConsts.CMD_ACTION, str);
        this.f10346c.put("ad_format", str2);
    }

    public aw m11849a() {
        return m11850a(C2968s.m11529i().m13544b());
    }

    public aw m11850a(long j) {
        return !this.f10344a ? null : new aw(j, null, null);
    }

    public void m11851a(az azVar) {
        synchronized (this.f10347d) {
            this.f10350g = azVar;
        }
    }

    public void m11852a(String str) {
        if (this.f10344a) {
            synchronized (this.f10347d) {
                this.f10348e = str;
            }
        }
    }

    public void m11853a(String str, String str2) {
        if (this.f10344a && !TextUtils.isEmpty(str2)) {
            as e = C2968s.m11528h().m12948e();
            if (e != null) {
                synchronized (this.f10347d) {
                    e.m11825a(str).m11836a(this.f10346c, str, str2);
                }
            }
        }
    }

    public boolean m11854a(aw awVar, long j, String... strArr) {
        synchronized (this.f10347d) {
            for (String awVar2 : strArr) {
                this.f10345b.add(new aw(j, awVar2, awVar));
            }
        }
        return true;
    }

    public boolean m11855a(aw awVar, String... strArr) {
        return (!this.f10344a || awVar == null) ? false : m11854a(awVar, C2968s.m11529i().m13544b(), strArr);
    }

    public void m11856b() {
        synchronized (this.f10347d) {
            this.f10349f = m11849a();
        }
    }

    public String m11857c() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f10347d) {
            for (aw awVar : this.f10345b) {
                long a = awVar.m11841a();
                String b = awVar.m11842b();
                aw awVar2 = awVar2.m11843c();
                if (awVar2 != null && a > 0) {
                    stringBuilder2.append(b).append('.').append(a - awVar2.m11841a()).append(',');
                }
            }
            this.f10345b.clear();
            if (!TextUtils.isEmpty(this.f10348e)) {
                stringBuilder2.append(this.f10348e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> m11858d() {
        Map<String, String> map;
        synchronized (this.f10347d) {
            as e = C2968s.m11528h().m12948e();
            if (e == null || this.f10350g == null) {
                map = this.f10346c;
            } else {
                map = e.m11827a(this.f10346c, this.f10350g.m11858d());
            }
        }
        return map;
    }

    public aw m11859e() {
        aw awVar;
        synchronized (this.f10347d) {
            awVar = this.f10349f;
        }
        return awVar;
    }
}
