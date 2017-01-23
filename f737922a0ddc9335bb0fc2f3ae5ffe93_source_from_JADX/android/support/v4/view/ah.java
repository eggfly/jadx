package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ah {
    static final e j6;

    interface e {
        int j6(ViewConfiguration viewConfiguration);
    }

    static class a implements e {
        a() {
        }

        public int j6(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }
    }

    static class b extends a {
        b() {
        }

        public int j6(ViewConfiguration viewConfiguration) {
            return ai.j6(viewConfiguration);
        }
    }

    static class c extends b {
        c() {
        }
    }

    static class d extends c {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            j6 = new d();
        } else if (VERSION.SDK_INT >= 11) {
            j6 = new c();
        } else if (VERSION.SDK_INT >= 8) {
            j6 = new b();
        } else {
            j6 = new a();
        }
    }

    public static int j6(ViewConfiguration viewConfiguration) {
        return j6.j6(viewConfiguration);
    }
}
