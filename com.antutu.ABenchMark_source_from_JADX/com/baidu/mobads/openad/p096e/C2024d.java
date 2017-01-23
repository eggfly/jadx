package com.baidu.mobads.openad.p096e;

import android.net.Uri.Builder;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.openad.e.d */
public class C2024d {
    public String f7053a;
    public String f7054b;
    public long f7055c;
    public String f7056d;
    public int f7057e;
    private Builder f7058f;

    public C2024d(String str, String str2) {
        this.f7055c = 0;
        this.f7056d = "text/plain";
        this.f7057e = 1;
        this.f7053a = str;
        this.f7054b = str2;
    }

    public String m7548a() {
        return C1991m.m7449a().m7460i().getFixedString(this.f7053a);
    }

    public void m7549a(int i) {
        this.f7057e = i;
    }

    public void m7550a(Builder builder) {
        this.f7058f = builder;
    }

    public Builder m7551b() {
        return this.f7058f;
    }
}
