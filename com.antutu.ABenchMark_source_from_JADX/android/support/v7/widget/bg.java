package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class bg extends au {
    private final WeakReference<Context> f1986a;

    public bg(Context context, Resources resources) {
        super(resources);
        this.f1986a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1986a.get();
        if (!(drawable == null || context == null)) {
            C0616l.m2672a();
            C0616l.m2678a(context, i, drawable);
        }
        return drawable;
    }
}
