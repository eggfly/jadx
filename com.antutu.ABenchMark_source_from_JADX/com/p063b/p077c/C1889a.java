package com.p063b.p077c;

import android.view.View;
import com.p063b.p077c.p078a.C1888a;

/* renamed from: com.b.c.a */
public final class C1889a {

    /* renamed from: com.b.c.a.a */
    private static final class C1887a {
        static float m7085a(View view) {
            return view.getX();
        }

        static void m7086a(View view, float f) {
            view.setX(f);
        }

        static float m7087b(View view) {
            return view.getY();
        }

        static void m7088b(View view, float f) {
            view.setY(f);
        }
    }

    public static float m7120a(View view) {
        return C1888a.f6427a ? C1888a.m7089a(view).m7118m() : C1887a.m7085a(view);
    }

    public static void m7121a(View view, float f) {
        if (C1888a.f6427a) {
            C1888a.m7089a(view).m7115k(f);
        } else {
            C1887a.m7086a(view, f);
        }
    }

    public static float m7122b(View view) {
        return C1888a.f6427a ? C1888a.m7089a(view).m7119n() : C1887a.m7087b(view);
    }

    public static void m7123b(View view, float f) {
        if (C1888a.f6427a) {
            C1888a.m7089a(view).m7117l(f);
        } else {
            C1887a.m7088b(view, f);
        }
    }
}
