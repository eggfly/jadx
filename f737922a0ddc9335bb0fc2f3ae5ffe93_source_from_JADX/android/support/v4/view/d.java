package android.support.v4.view;

import android.os.Build.VERSION;

public class d {
    static final a j6;

    interface a {
        int j6(int i, int i2);
    }

    static class b implements a {
        b() {
        }

        public int j6(int i, int i2) {
            return -8388609 & i;
        }
    }

    static class c implements a {
        c() {
        }

        public int j6(int i, int i2) {
            return e.j6(i, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            j6 = new c();
        } else {
            j6 = new b();
        }
    }

    public static int j6(int i, int i2) {
        return j6.j6(i, i2);
    }
}
