package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* renamed from: android.support.v7.widget.u */
public class C0625u extends RatingBar {
    private C0623s f2112a;
    private C0616l f2113b;

    public C0625u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.ratingBarStyle);
    }

    public C0625u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2113b = C0616l.m2672a();
        this.f2112a = new C0623s(this, this.f2113b);
        this.f2112a.m2707a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2112a.m2706a();
        if (a != null) {
            setMeasuredDimension(ViewCompat.resolveSizeAndState(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
