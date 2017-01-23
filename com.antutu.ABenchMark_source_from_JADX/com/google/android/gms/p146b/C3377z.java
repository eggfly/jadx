package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

@gb
/* renamed from: com.google.android.gms.b.z */
public class C3377z {
    private final int f11763a;
    private final int f11764b;
    private final int f11765c;
    private final ae f11766d;
    private final Object f11767e;
    private ArrayList<String> f11768f;
    private ArrayList<String> f11769g;
    private int f11770h;
    private int f11771i;
    private int f11772j;
    private int f11773k;
    private String f11774l;
    private String f11775m;

    public C3377z(int i, int i2, int i3, int i4) {
        this.f11767e = new Object();
        this.f11768f = new ArrayList();
        this.f11769g = new ArrayList();
        this.f11770h = 0;
        this.f11771i = 0;
        this.f11772j = 0;
        this.f11774l = BuildConfig.FLAVOR;
        this.f11775m = BuildConfig.FLAVOR;
        this.f11763a = i;
        this.f11764b = i2;
        this.f11765c = i3;
        this.f11766d = new ae(i4);
    }

    private String m13904a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m13905c(String str, boolean z) {
        if (str != null && str.length() >= this.f11765c) {
            synchronized (this.f11767e) {
                this.f11768f.add(str);
                this.f11770h += str.length();
                if (z) {
                    this.f11769g.add(str);
                }
            }
        }
    }

    int m13906a(int i, int i2) {
        return (this.f11763a * i) + (this.f11764b * i2);
    }

    public void m13907a(int i) {
        this.f11771i = i;
    }

    public void m13908a(String str, boolean z) {
        m13905c(str, z);
        synchronized (this.f11767e) {
            if (this.f11772j < 0) {
                C2972b.m11576a("ActivityContent: negative number of WebViews.");
            }
            m13916g();
        }
    }

    public boolean m13909a() {
        boolean z;
        synchronized (this.f11767e) {
            z = this.f11772j == 0;
        }
        return z;
    }

    public String m13910b() {
        return this.f11774l;
    }

    public void m13911b(String str, boolean z) {
        m13905c(str, z);
    }

    public String m13912c() {
        return this.f11775m;
    }

    public void m13913d() {
        synchronized (this.f11767e) {
            this.f11773k -= 100;
        }
    }

    public void m13914e() {
        synchronized (this.f11767e) {
            this.f11772j--;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3377z)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C3377z c3377z = (C3377z) obj;
        return c3377z.m13910b() != null && c3377z.m13910b().equals(m13910b());
    }

    public void m13915f() {
        synchronized (this.f11767e) {
            this.f11772j++;
        }
    }

    public void m13916g() {
        synchronized (this.f11767e) {
            int a = m13906a(this.f11770h, this.f11771i);
            if (a > this.f11773k) {
                this.f11773k = a;
                this.f11774l = this.f11766d.m11760a(this.f11768f);
                this.f11775m = this.f11766d.m11760a(this.f11769g);
            }
        }
    }

    public int m13917h() {
        return this.f11773k;
    }

    public int hashCode() {
        return m13910b().hashCode();
    }

    int m13918i() {
        return this.f11770h;
    }

    public String toString() {
        return "ActivityContent fetchId: " + this.f11771i + " score:" + this.f11773k + " total_length:" + this.f11770h + "\n text: " + m13904a(this.f11768f, 100) + "\n viewableText" + m13904a(this.f11769g, 100) + "\n signture: " + this.f11774l + "\n viewableSignture: " + this.f11775m;
    }
}
