package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0349g;
import java.lang.ref.WeakReference;

public class bj extends Resources {
    private final WeakReference<Context> f2012a;

    public bj(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2012a = new WeakReference(context);
    }

    public static boolean m2567a() {
        return C0349g.m868k() && VERSION.SDK_INT <= 20;
    }

    final Drawable m2568a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2012a.get();
        return context != null ? C0616l.m2672a().m2697a(context, this, i) : super.getDrawable(i);
    }
}
