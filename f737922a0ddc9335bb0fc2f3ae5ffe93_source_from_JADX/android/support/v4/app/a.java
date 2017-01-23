package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

@Deprecated
public class a implements android.support.v4.widget.DrawerLayout.f {
    private static final a j6;
    private final Activity DW;
    private final int EQ;
    private final e FH;
    private final DrawerLayout Hw;
    private Object J0;
    private Drawable VH;
    private boolean Zo;
    private Drawable gn;
    private final int tp;
    private g u7;
    private boolean v5;
    private final int we;

    private interface a {
        Drawable j6(Activity activity);

        Object j6(Object obj, Activity activity, int i);

        Object j6(Object obj, Activity activity, Drawable drawable, int i);
    }

    private static class b implements a {
        private b() {
        }

        public Drawable j6(Activity activity) {
            return null;
        }

        public Object j6(Object obj, Activity activity, Drawable drawable, int i) {
            return obj;
        }

        public Object j6(Object obj, Activity activity, int i) {
            return obj;
        }
    }

    private static class c implements a {
        private c() {
        }

        public Drawable j6(Activity activity) {
            return b.j6(activity);
        }

        public Object j6(Object obj, Activity activity, Drawable drawable, int i) {
            return b.j6(obj, activity, drawable, i);
        }

        public Object j6(Object obj, Activity activity, int i) {
            return b.j6(obj, activity, i);
        }
    }

    private static class d implements a {
        private d() {
        }

        public Drawable j6(Activity activity) {
            return c.j6(activity);
        }

        public Object j6(Object obj, Activity activity, Drawable drawable, int i) {
            return c.j6(obj, activity, drawable, i);
        }

        public Object j6(Object obj, Activity activity, int i) {
            return c.j6(obj, activity, i);
        }
    }

    public interface e {
        Drawable j6();

        void j6(int i);

        void j6(Drawable drawable, int i);
    }

    public interface f {
        e j6();
    }

    private class g extends InsetDrawable implements Callback {
        private final boolean DW;
        private final Rect FH;
        private float Hw;
        final /* synthetic */ a j6;
        private float v5;

        private g(a aVar, Drawable drawable) {
            boolean z = false;
            this.j6 = aVar;
            super(drawable, 0);
            if (VERSION.SDK_INT > 18) {
                z = true;
            }
            this.DW = z;
            this.FH = new Rect();
        }

        public void j6(float f) {
            this.Hw = f;
            invalidateSelf();
        }

        public float j6() {
            return this.Hw;
        }

        public void DW(float f) {
            this.v5 = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            int i = 1;
            copyBounds(this.FH);
            canvas.save();
            int i2 = z.v5(this.j6.DW.getWindow().getDecorView()) == 1 ? 1 : 0;
            if (i2 != 0) {
                i = -1;
            }
            int width = this.FH.width();
            canvas.translate(((float) i) * (((-this.v5) * ((float) width)) * this.Hw), 0.0f);
            if (!(i2 == 0 || this.DW)) {
                canvas.translate((float) width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            j6 = new d();
        } else if (i >= 11) {
            j6 = new c();
        } else {
            j6 = new b();
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !j6((Context) activity), i, i2, i3);
    }

    private static boolean j6(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && VERSION.SDK_INT >= 21;
    }

    public a(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.v5 = true;
        this.DW = activity;
        if (activity instanceof f) {
            this.FH = ((f) activity).j6();
        } else {
            this.FH = null;
        }
        this.Hw = drawerLayout;
        this.tp = i;
        this.EQ = i2;
        this.we = i3;
        this.VH = DW();
        this.gn = android.support.v4.content.c.j6(activity, i);
        this.u7 = new g(this.gn, null);
        this.u7.DW(z ? 0.33333334f : 0.0f);
    }

    public void j6() {
        if (this.Hw.Zo(8388611)) {
            this.u7.j6(1.0f);
        } else {
            this.u7.j6(0.0f);
        }
        if (this.v5) {
            j6(this.u7, this.Hw.Zo(8388611) ? this.we : this.EQ);
        }
    }

    public void j6(Configuration configuration) {
        if (!this.Zo) {
            this.VH = DW();
        }
        this.gn = android.support.v4.content.c.j6(this.DW, this.tp);
        j6();
    }

    public boolean j6(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.v5) {
            return false;
        }
        if (this.Hw.VH(8388611)) {
            this.Hw.v5(8388611);
        } else {
            this.Hw.Hw(8388611);
        }
        return true;
    }

    public void j6(View view, float f) {
        float j6 = this.u7.j6();
        if (f > 0.5f) {
            j6 = Math.max(j6, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            j6 = Math.min(j6, f * 2.0f);
        }
        this.u7.j6(j6);
    }

    public void j6(View view) {
        this.u7.j6(1.0f);
        if (this.v5) {
            DW(this.we);
        }
    }

    public void DW(View view) {
        this.u7.j6(0.0f);
        if (this.v5) {
            DW(this.EQ);
        }
    }

    public void j6(int i) {
    }

    Drawable DW() {
        if (this.FH != null) {
            return this.FH.j6();
        }
        return j6.j6(this.DW);
    }

    void j6(Drawable drawable, int i) {
        if (this.FH != null) {
            this.FH.j6(drawable, i);
        } else {
            this.J0 = j6.j6(this.J0, this.DW, drawable, i);
        }
    }

    void DW(int i) {
        if (this.FH != null) {
            this.FH.j6(i);
        } else {
            this.J0 = j6.j6(this.J0, this.DW, i);
        }
    }
}
