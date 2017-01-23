package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;

public class af extends android.support.v4.app.ah.a {
    private static final a VH;
    public static final android.support.v4.app.ah.a.a j6;
    private final String DW;
    private final CharSequence FH;
    private final CharSequence[] Hw;
    private final Bundle Zo;
    private final boolean v5;

    static class 1 implements android.support.v4.app.ah.a.a {
        1() {
        }
    }

    interface a {
    }

    static class b implements a {
        b() {
        }
    }

    static class c implements a {
        c() {
        }
    }

    static class d implements a {
        d() {
        }
    }

    public String j6() {
        return this.DW;
    }

    public CharSequence DW() {
        return this.FH;
    }

    public CharSequence[] FH() {
        return this.Hw;
    }

    public boolean Hw() {
        return this.v5;
    }

    public Bundle v5() {
        return this.Zo;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            VH = new b();
        } else if (VERSION.SDK_INT >= 16) {
            VH = new d();
        } else {
            VH = new c();
        }
        j6 = new 1();
    }
}
