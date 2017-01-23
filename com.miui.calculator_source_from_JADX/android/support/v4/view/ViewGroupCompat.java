package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class ViewGroupCompat {
    static final ViewGroupCompatImpl f833a;

    interface ViewGroupCompatImpl {
        void m1513a(ViewGroup viewGroup, boolean z);
    }

    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
        }

        public void m1514a(ViewGroup viewGroup, boolean z) {
        }
    }

    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        ViewGroupCompatHCImpl() {
        }

        public void m1515a(ViewGroup viewGroup, boolean z) {
            ViewGroupCompatHC.m1517a(viewGroup, z);
        }
    }

    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
        }
    }

    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        ViewGroupCompatJellybeanMR2Impl() {
        }
    }

    static class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatLollipopImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f833a = new ViewGroupCompatLollipopImpl();
        } else if (i >= 18) {
            f833a = new ViewGroupCompatJellybeanMR2Impl();
        } else if (i >= 14) {
            f833a = new ViewGroupCompatIcsImpl();
        } else if (i >= 11) {
            f833a = new ViewGroupCompatHCImpl();
        } else {
            f833a = new ViewGroupCompatStubImpl();
        }
    }

    private ViewGroupCompat() {
    }

    public static void m1516a(ViewGroup viewGroup, boolean z) {
        f833a.m1513a(viewGroup, z);
    }
}
