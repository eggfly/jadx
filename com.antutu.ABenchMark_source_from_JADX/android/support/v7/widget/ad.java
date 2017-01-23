package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.aw.C0556a;

class ad implements ae {
    final RectF f1763a;

    /* renamed from: android.support.v7.widget.ad.1 */
    class C05571 implements C0556a {
        final /* synthetic */ ad f1762a;

        C05571(ad adVar) {
            this.f1762a = adVar;
        }

        public void m2186a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                this.f1762a.f1763a.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(this.f1762a.f1763a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1762a.f1763a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1762a.f1763a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1762a.f1763a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
        }
    }

    ad() {
        this.f1763a = new RectF();
    }

    private aw m2187a(Context context, int i, float f, float f2, float f3) {
        return new aw(context.getResources(), i, f, f2, f3);
    }

    private aw m2188i(ac acVar) {
        return (aw) acVar.m1676c();
    }

    public float m2189a(ac acVar) {
        return m2188i(acVar).m2448c();
    }

    public void m2190a() {
        aw.f1903c = new C05571(this);
    }

    public void m2191a(ac acVar, float f) {
        m2188i(acVar).m2441a(f);
        m2200f(acVar);
    }

    public void m2192a(ac acVar, int i) {
        m2188i(acVar).m2443a(i);
    }

    public void m2193a(ac acVar, Context context, int i, float f, float f2, float f3) {
        Drawable a = m2187a(context, i, f, f2, f3);
        a.m2445a(acVar.m1675b());
        acVar.m1673a(a);
        m2200f(acVar);
    }

    public float m2194b(ac acVar) {
        return m2188i(acVar).m2450d();
    }

    public void m2195b(ac acVar, float f) {
        m2188i(acVar).m2449c(f);
        m2200f(acVar);
    }

    public float m2196c(ac acVar) {
        return m2188i(acVar).m2451e();
    }

    public void m2197c(ac acVar, float f) {
        m2188i(acVar).m2447b(f);
    }

    public float m2198d(ac acVar) {
        return m2188i(acVar).m2440a();
    }

    public float m2199e(ac acVar) {
        return m2188i(acVar).m2446b();
    }

    public void m2200f(ac acVar) {
        Rect rect = new Rect();
        m2188i(acVar).m2444a(rect);
        acVar.m1671a((int) Math.ceil((double) m2194b(acVar)), (int) Math.ceil((double) m2196c(acVar)));
        acVar.m1672a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void m2201g(ac acVar) {
    }

    public void m2202h(ac acVar) {
        m2188i(acVar).m2445a(acVar.m1675b());
        m2200f(acVar);
    }
}
