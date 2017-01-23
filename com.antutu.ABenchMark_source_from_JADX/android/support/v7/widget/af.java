package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.aw.C0556a;

class af extends ad {

    /* renamed from: android.support.v7.widget.af.1 */
    class C05581 implements C0556a {
        final /* synthetic */ af f1764a;

        C05581(af afVar) {
            this.f1764a = afVar;
        }

        public void m2203a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    af() {
    }

    public void m2204a() {
        aw.f1903c = new C05581(this);
    }
}
