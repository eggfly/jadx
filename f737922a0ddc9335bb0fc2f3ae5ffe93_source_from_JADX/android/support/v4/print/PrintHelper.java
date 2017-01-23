package android.support.v4.print;

import android.content.Context;
import android.os.Build.VERSION;

public final class PrintHelper {
    c j6;

    interface c {
    }

    private static final class a implements c {
        private final a j6;

        a(Context context) {
            this.j6 = new a(context);
        }
    }

    private static final class b implements c {
        int DW;
        int FH;
        int j6;

        private b() {
            this.j6 = 2;
            this.DW = 2;
            this.FH = 1;
        }
    }

    public static boolean j6() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return false;
    }

    public PrintHelper(Context context) {
        if (j6()) {
            this.j6 = new a(context);
        } else {
            this.j6 = new b();
        }
    }
}
