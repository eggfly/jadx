package com.cmcm.p074a.p075a.p114c;

import android.content.SharedPreferences;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.taobao.accs.common.Constants;

/* renamed from: com.cmcm.a.a.c.a */
public abstract class C2137a extends C2136b {
    private void m8077i() {
        SharedPreferences h = m8076h();
        String j = m8078j();
        int a = C2126s.m8026a(m8074f(), Constants.SP_KEY_VERSION, -1);
        if (h.getInt(j, -1) < a) {
            if (m8073e()) {
                m8081c();
            }
            h.edit().putInt(j, a).apply();
        }
    }

    private String m8078j() {
        return m8074f() + "_version";
    }

    public void m8079a() {
        super.m8065a();
        m8077i();
    }

    public void m8080b() {
        super.m8071b();
        m8077i();
    }

    protected abstract void m8081c();
}
