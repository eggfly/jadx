package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.C0384j.C0383a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.app.k */
class C0386k extends C0384j {
    private final UiModeManager f973r;

    /* renamed from: android.support.v7.app.k.a */
    class C0385a extends C0383a {
        final /* synthetic */ C0386k f972c;

        C0385a(C0386k c0386k, Callback callback) {
            this.f972c = c0386k;
            super(c0386k, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f972c.m1077o()) {
                switch (i) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        return m1069a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    C0386k(Context context, Window window, C0374f c0374f) {
        super(context, window, c0374f);
        this.f973r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback m1078a(Callback callback) {
        return new C0385a(this, callback);
    }

    int m1079d(int i) {
        return (i == 0 && this.f973r.getNightMode() == 0) ? -1 : super.m1075d(i);
    }
}
