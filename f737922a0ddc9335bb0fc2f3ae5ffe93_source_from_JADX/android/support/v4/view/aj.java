package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class aj {
    static final c j6;

    interface c {
        void j6(ViewGroup viewGroup, boolean z);
    }

    static class f implements c {
        f() {
        }

        public void j6(ViewGroup viewGroup, boolean z) {
        }
    }

    static class a extends f {
        a() {
        }

        public void j6(ViewGroup viewGroup, boolean z) {
            ak.j6(viewGroup, z);
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class d extends b {
        d() {
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            j6 = new e();
        } else if (i >= 18) {
            j6 = new d();
        } else if (i >= 14) {
            j6 = new b();
        } else if (i >= 11) {
            j6 = new a();
        } else {
            j6 = new f();
        }
    }

    public static void j6(ViewGroup viewGroup, boolean z) {
        j6.j6(viewGroup, z);
    }
}
