package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat {
    static final DrawableImpl f450a;

    interface DrawableImpl {
        void m581a(Drawable drawable, int i);

        boolean m582a(Drawable drawable);
    }

    static class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
        }

        public boolean m584a(Drawable drawable) {
            return false;
        }

        public void m583a(Drawable drawable, int i) {
        }
    }

    static class HoneycombDrawableImpl extends BaseDrawableImpl {
        HoneycombDrawableImpl() {
        }
    }

    static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
        JellybeanMr1DrawableImpl() {
        }

        public void m585a(Drawable drawable, int i) {
            DrawableCompatJellybeanMr1.m591a(drawable, i);
        }
    }

    static class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
        KitKatDrawableImpl() {
        }

        public boolean m586a(Drawable drawable) {
            return DrawableCompatKitKat.m592a(drawable);
        }
    }

    static class LollipopDrawableImpl extends KitKatDrawableImpl {
        LollipopDrawableImpl() {
        }
    }

    static class LollipopMr1DrawableImpl extends LollipopDrawableImpl {
        LollipopMr1DrawableImpl() {
        }
    }

    static class MDrawableImpl extends LollipopMr1DrawableImpl {
        MDrawableImpl() {
        }

        public void m587a(Drawable drawable, int i) {
            DrawableCompatApi23.m590a(drawable, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f450a = new MDrawableImpl();
        } else if (i >= 22) {
            f450a = new LollipopMr1DrawableImpl();
        } else if (i >= 21) {
            f450a = new LollipopDrawableImpl();
        } else if (i >= 19) {
            f450a = new KitKatDrawableImpl();
        } else if (i >= 17) {
            f450a = new JellybeanMr1DrawableImpl();
        } else if (i >= 11) {
            f450a = new HoneycombDrawableImpl();
        } else {
            f450a = new BaseDrawableImpl();
        }
    }

    public static boolean m589a(Drawable drawable) {
        return f450a.m582a(drawable);
    }

    public static void m588a(Drawable drawable, int i) {
        f450a.m581a(drawable, i);
    }
}
