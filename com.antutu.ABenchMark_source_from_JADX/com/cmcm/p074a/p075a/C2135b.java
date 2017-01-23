package com.cmcm.p074a.p075a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.cmcm.p074a.p075a.p112a.C2116j;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.cmcm.p074a.p075a.p112a.C2131x;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import com.cmcm.p074a.p075a.p115d.C2169j;
import java.io.File;

/* renamed from: com.cmcm.a.a.b */
public class C2135b {
    private static final C2135b f7485a;
    private volatile boolean f7486b;

    static {
        f7485a = new C2135b();
    }

    public static C2135b m8062a() {
        return f7485a;
    }

    public synchronized boolean m8063a(Context context, int i, C1788a c1788a) {
        boolean z = true;
        synchronized (this) {
            if (this.f7486b) {
                ad.m7931a("DmcContext", "retry to startup", new Object[0]);
            } else {
                if (context == null) {
                    throw new RuntimeException("invalid parameters");
                } else if (C2131x.m8050a().m8051a(context)) {
                    File file = new File(context.getFilesDir(), "dmc");
                    if (file.exists() || file.mkdirs()) {
                        if (C2133z.f7482a) {
                            ad.m7931a("DmcContext", "DMC startup...", new Object[0]);
                        } else {
                            ad.m7931a("DmcContext", "DMC log disabled", new Object[0]);
                        }
                        HandlerThread handlerThread = new HandlerThread("DMC");
                        handlerThread.start();
                        Handler handler = new Handler(handlerThread.getLooper());
                        C2116j c2116j = new C2116j(c1788a, file, context, handler);
                        C2126s.m8032a(context, handler, file, i, c2116j);
                        C2169j a = C2169j.m8169a();
                        a.m8199a((long) C2126s.m8026a("reporter", "interval_check_fast", 0));
                        a.m8201b((long) C2126s.m8026a("reporter", "interval_check_batch", 0));
                        a.m8200a(context, file);
                        C2126s.m8039b();
                        c2116j.m8003a();
                        this.f7486b = true;
                    } else {
                        if (C2133z.f7482a) {
                            ad.m7931a("DmcContext", "failed to initialize the root directory", new Object[0]);
                        }
                        z = false;
                    }
                } else {
                    ad.m7931a("DmcContext", "failed to load config", new Object[0]);
                    z = false;
                }
            }
        }
        return z;
    }
}
