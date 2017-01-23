package com.p029a.p033b;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.p029a.p030a.C1061a;
import com.p029a.p030a.p031b.C1054a;
import com.p029a.p030a.p031b.C1071b;
import com.p029a.p030a.p031b.C1071b.C1068a;
import com.p029a.p033b.p034a.C1072a;

/* renamed from: com.a.b.a */
public final class C1073a {
    public static boolean f3619a;
    public static boolean f3620b;
    public static int f3621c;
    private static C1072a f3622d;

    static {
        f3622d = null;
        f3619a = false;
        f3620b = true;
        f3621c = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    }

    public static C1071b m4792a(boolean z) {
        return C1073a.m4793a(z, 0);
    }

    public static C1071b m4793a(boolean z, int i) {
        return C1073a.m4794a(z, i, C1071b.f3592a, 3);
    }

    public static C1071b m4794a(boolean z, int i, C1068a c1068a, int i2) {
        return C1061a.m4735a(z, i, c1068a, i2);
    }

    public static void m4795a(C1071b c1071b, C1054a c1054a) {
        c1071b.m4784a(c1054a);
    }

    public static boolean m4796a() {
        return C1061a.m4745b();
    }

    public static boolean m4797b() {
        return C1061a.m4747c();
    }
}
