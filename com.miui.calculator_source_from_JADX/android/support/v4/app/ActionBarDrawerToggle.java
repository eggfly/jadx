package android.support.v4.app;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;

@Deprecated
public class ActionBarDrawerToggle implements DrawerListener {
    private static final ActionBarDrawerToggleImpl f39a;
    private final Activity f40b;
    private final Delegate f41c;
    private boolean f42d;
    private SlideDrawable f43e;
    private final int f44f;
    private final int f45g;
    private Object f46h;

    private interface ActionBarDrawerToggleImpl {
        Object m45a(Object obj, Activity activity, int i);
    }

    private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplBase() {
        }

        public Object m46a(Object obj, Activity activity, int i) {
            return obj;
        }
    }

    private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplHC() {
        }

        public Object m47a(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleHoneycomb.m62a(obj, activity, i);
        }
    }

    private static class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplJellybeanMR2() {
        }

        public Object m48a(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleJellybeanMR2.m63a(obj, activity, i);
        }
    }

    public interface Delegate {
        void m49a(@StringRes int i);
    }

    public interface DelegateProvider {
    }

    private class SlideDrawable extends InsetDrawable implements Callback {
        final /* synthetic */ ActionBarDrawerToggle f34a;
        private final boolean f35b;
        private final Rect f36c;
        private float f37d;
        private float f38e;

        public void m51a(float f) {
            this.f37d = f;
            invalidateSelf();
        }

        public float m50a() {
            return this.f37d;
        }

        public void draw(Canvas canvas) {
            int i = 1;
            copyBounds(this.f36c);
            canvas.save();
            int i2 = ViewCompat.m1467f(this.f34a.f40b.getWindow().getDecorView()) == 1 ? 1 : 0;
            if (i2 != 0) {
                i = -1;
            }
            int width = this.f36c.width();
            canvas.translate(((float) i) * (((-this.f38e) * ((float) width)) * this.f37d), 0.0f);
            if (!(i2 == 0 || this.f35b)) {
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
            f39a = new ActionBarDrawerToggleImplJellybeanMR2();
        } else if (i >= 11) {
            f39a = new ActionBarDrawerToggleImplHC();
        } else {
            f39a = new ActionBarDrawerToggleImplBase();
        }
    }

    public void m59a(View view, float f) {
        float a = this.f43e.m50a();
        if (f > 0.5f) {
            a = Math.max(a, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            a = Math.min(a, f * 2.0f);
        }
        this.f43e.m51a(a);
    }

    public void m58a(View view) {
        this.f43e.m51a(1.0f);
        if (this.f42d) {
            m60b(this.f45g);
        }
    }

    public void m61b(View view) {
        this.f43e.m51a(0.0f);
        if (this.f42d) {
            m60b(this.f44f);
        }
    }

    public void m57a(int i) {
    }

    void m60b(int i) {
        if (this.f41c != null) {
            this.f41c.m49a(i);
        } else {
            this.f46h = f39a.m45a(this.f46h, this.f40b, i);
        }
    }
}
