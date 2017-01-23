package com.miui.support.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.support.os.Environment;
import java.util.HashSet;
import java.util.Iterator;

public class SdCardMonitor {
    private BroadcastReceiver f3713a;
    private HashSet<SdCardStatusListener> f3714b;
    private Boolean f3715c;

    /* renamed from: com.miui.support.util.SdCardMonitor.1 */
    class C04341 extends BroadcastReceiver {
        final /* synthetic */ SdCardMonitor f3711a;

        C04341(SdCardMonitor sdCardMonitor) {
            this.f3711a = sdCardMonitor;
        }

        public void onReceive(Context context, Intent intent) {
            boolean c = Environment.m5177c();
            if (this.f3711a.f3715c == null || this.f3711a.f3715c.booleanValue() != c) {
                this.f3711a.f3715c = Boolean.valueOf(c);
                this.f3711a.m5445a(c);
            }
        }
    }

    private static class Holder {
        private static final SdCardMonitor f3712a;

        private Holder() {
        }

        static {
            f3712a = new SdCardMonitor();
        }
    }

    public interface SdCardStatusListener {
        void m5441a(boolean z);
    }

    private SdCardMonitor() {
        this.f3714b = new HashSet();
        this.f3713a = new C04341(this);
    }

    private void m5445a(boolean z) {
        Iterator it = this.f3714b.iterator();
        while (it.hasNext()) {
            ((SdCardStatusListener) it.next()).m5441a(z);
        }
    }
}
