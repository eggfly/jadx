package com.github.mikephil.charting.data;

import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2586h;

/* renamed from: com.github.mikephil.charting.data.k */
public class C2576k extends C2560e<C2586h> {
    public /* synthetic */ C2563d m9868a(int i) {
        return m9871b(i);
    }

    public C2586h m9869a() {
        return (C2586h) this.h.get(0);
    }

    public float m9870b() {
        float f = 0.0f;
        for (int i = 0; i < m9869a().m9792m(); i++) {
            f += m9869a().m9783f(i).m9742b();
        }
        return f;
    }

    public C2586h m9871b(int i) {
        return i == 0 ? m9869a() : null;
    }
}
