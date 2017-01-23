package android.support.v7.widget;

import android.content.Context;
import android.view.View;

class ab implements ae {
    ab() {
    }

    private av m2170i(ac acVar) {
        return (av) acVar.m1676c();
    }

    public float m2171a(ac acVar) {
        return m2170i(acVar).m2429a();
    }

    public void m2172a() {
    }

    public void m2173a(ac acVar, float f) {
        m2170i(acVar).m2430a(f);
    }

    public void m2174a(ac acVar, int i) {
        m2170i(acVar).m2432a(i);
    }

    public void m2175a(ac acVar, Context context, int i, float f, float f2, float f3) {
        acVar.m1673a(new av(i, f));
        View d = acVar.m1677d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        m2177b(acVar, f3);
    }

    public float m2176b(ac acVar) {
        return m2180d(acVar) * 2.0f;
    }

    public void m2177b(ac acVar, float f) {
        m2170i(acVar).m2431a(f, acVar.m1674a(), acVar.m1675b());
        m2182f(acVar);
    }

    public float m2178c(ac acVar) {
        return m2180d(acVar) * 2.0f;
    }

    public void m2179c(ac acVar, float f) {
        acVar.m1677d().setElevation(f);
    }

    public float m2180d(ac acVar) {
        return m2170i(acVar).m2433b();
    }

    public float m2181e(ac acVar) {
        return acVar.m1677d().getElevation();
    }

    public void m2182f(ac acVar) {
        if (acVar.m1674a()) {
            float a = m2171a(acVar);
            float d = m2180d(acVar);
            int ceil = (int) Math.ceil((double) aw.m2436b(a, d, acVar.m1675b()));
            int ceil2 = (int) Math.ceil((double) aw.m2434a(a, d, acVar.m1675b()));
            acVar.m1672a(ceil, ceil2, ceil, ceil2);
            return;
        }
        acVar.m1672a(0, 0, 0, 0);
    }

    public void m2183g(ac acVar) {
        m2177b(acVar, m2171a(acVar));
    }

    public void m2184h(ac acVar) {
        m2177b(acVar, m2171a(acVar));
    }
}
