package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public class LayoutInflaterCompat {
    static final LayoutInflaterCompatImpl f772a;

    interface LayoutInflaterCompatImpl {
        void m1247a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    static class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
        }

        public void m1248a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatBase.m1252a(layoutInflater, layoutInflaterFactory);
        }
    }

    static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
        }

        public void m1249a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatHC.m1253a(layoutInflater, layoutInflaterFactory);
        }
    }

    static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
        }

        public void m1250a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatLollipop.m1255a(layoutInflater, layoutInflaterFactory);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f772a = new LayoutInflaterCompatImplV21();
        } else if (i >= 11) {
            f772a = new LayoutInflaterCompatImplV11();
        } else {
            f772a = new LayoutInflaterCompatImplBase();
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void m1251a(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        f772a.m1247a(layoutInflater, layoutInflaterFactory);
    }
}
