package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.c;
import com.google.android.gms.ads.internal.client.l;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.eh;

@eh
public final class f {
    private c DW;
    private a FH;
    private final Object j6;

    public static abstract class a {
        public void j6() {
        }
    }

    public f() {
        this.j6 = new Object();
    }

    public void j6(a aVar) {
        b.j6((Object) aVar, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.j6) {
            this.FH = aVar;
            if (this.DW == null) {
                return;
            }
            try {
                this.DW.j6(new l(aVar));
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.DW("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public void j6(c cVar) {
        synchronized (this.j6) {
            this.DW = cVar;
            if (this.FH != null) {
                j6(this.FH);
            }
        }
    }
}
