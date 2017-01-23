package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public class i {
    static final a j6;

    interface a {
        void j6(LayoutInflater layoutInflater, m mVar);
    }

    static class b implements a {
        b() {
        }

        public void j6(LayoutInflater layoutInflater, m mVar) {
            j.j6(layoutInflater, mVar);
        }
    }

    static class c extends b {
        c() {
        }

        public void j6(LayoutInflater layoutInflater, m mVar) {
            k.j6(layoutInflater, mVar);
        }
    }

    static class d extends c {
        d() {
        }

        public void j6(LayoutInflater layoutInflater, m mVar) {
            l.j6(layoutInflater, mVar);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            j6 = new d();
        } else if (i >= 11) {
            j6 = new c();
        } else {
            j6 = new b();
        }
    }

    public static void j6(LayoutInflater layoutInflater, m mVar) {
        j6.j6(layoutInflater, mVar);
    }
}
