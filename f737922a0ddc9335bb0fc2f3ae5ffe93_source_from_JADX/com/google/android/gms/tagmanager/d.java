package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d VH;
    private final Context DW;
    private final c FH;
    private final am Hw;
    private final ax Zo;
    private final a j6;
    private final ConcurrentMap<aw, Boolean> v5;

    class 1 implements b {
        final /* synthetic */ d j6;

        1(d dVar) {
            this.j6 = dVar;
        }

        public void j6(Map<String, Object> map) {
            Object obj = map.get("event");
            if (obj != null) {
                this.j6.j6(obj.toString());
            }
        }
    }

    public interface a {
    }

    class 2 implements a {
        2() {
        }
    }

    class 3 implements ComponentCallbacks2 {
        final /* synthetic */ d j6;

        3(d dVar) {
            this.j6 = dVar;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.j6.j6();
            }
        }
    }

    static /* synthetic */ class 4 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[a.values().length];
            try {
                j6[a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    d(Context context, a aVar, c cVar, am amVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.DW = context.getApplicationContext();
        this.Hw = amVar;
        this.j6 = aVar;
        this.v5 = new ConcurrentHashMap();
        this.FH = cVar;
        this.FH.j6(new 1(this));
        this.FH.j6(new zzd(this.DW));
        this.Zo = new ax();
        DW();
    }

    @TargetApi(14)
    private void DW() {
        if (VERSION.SDK_INT >= 14) {
            this.DW.registerComponentCallbacks(new 3(this));
        }
    }

    public static d j6(Context context) {
        d dVar;
        synchronized (d.class) {
            if (VH == null) {
                if (context == null) {
                    r.j6("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                VH = new d(context, new 2(), new c(new zzw(context)), an.FH());
            }
            dVar = VH;
        }
        return dVar;
    }

    private void j6(String str) {
        for (aw j6 : this.v5.keySet()) {
            j6.j6(str);
        }
    }

    public void j6() {
        this.Hw.j6();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean j6(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.ad.j6();	 Catch:{ all -> 0x0049 }
        r0 = r1.j6(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.Hw();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.d.4.j6;	 Catch:{ all -> 0x0049 }
        r3 = r1.DW();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.v5;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.aw) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.Hw();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.DW(r3);	 Catch:{ all -> 0x0049 }
        r0.FH();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.v5;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.aw) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.Hw();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.FH();	 Catch:{ all -> 0x0049 }
        r0.DW(r4);	 Catch:{ all -> 0x0049 }
        r0.FH();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.v5();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.DW(r4);	 Catch:{ all -> 0x0049 }
        r0.FH();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.d.j6(android.net.Uri):boolean");
    }

    public boolean j6(aw awVar) {
        return this.v5.remove(awVar) != null;
    }
}
