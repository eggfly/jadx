package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalBroadcastManager {
    private static final Object f431d;
    private final Context f432a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f433b;
    private final ArrayList<BroadcastRecord> f434c;

    /* renamed from: android.support.v4.content.LocalBroadcastManager.1 */
    class C00351 extends Handler {
        final /* synthetic */ LocalBroadcastManager f426a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f426a.m579a();
                default:
                    super.handleMessage(message);
            }
        }
    }

    private static class BroadcastRecord {
        final Intent f427a;
        final ArrayList<ReceiverRecord> f428b;
    }

    private static class ReceiverRecord {
        final IntentFilter f429a;
        final BroadcastReceiver f430b;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.f430b);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.f429a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    static {
        f431d = new Object();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m579a() {
        /*
        r8 = this;
        r2 = 0;
    L_0x0001:
        r1 = r8.f433b;
        monitor-enter(r1);
        r0 = r8.f434c;	 Catch:{ all -> 0x003f }
        r0 = r0.size();	 Catch:{ all -> 0x003f }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        return;
    L_0x000e:
        r4 = new android.support.v4.content.LocalBroadcastManager.BroadcastRecord[r0];	 Catch:{ all -> 0x003f }
        r0 = r8.f434c;	 Catch:{ all -> 0x003f }
        r0.toArray(r4);	 Catch:{ all -> 0x003f }
        r0 = r8.f434c;	 Catch:{ all -> 0x003f }
        r0.clear();	 Catch:{ all -> 0x003f }
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        r3 = r2;
    L_0x001c:
        r0 = r4.length;
        if (r3 >= r0) goto L_0x0001;
    L_0x001f:
        r5 = r4[r3];
        r1 = r2;
    L_0x0022:
        r0 = r5.f428b;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0042;
    L_0x002a:
        r0 = r5.f428b;
        r0 = r0.get(r1);
        r0 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r0;
        r0 = r0.f430b;
        r6 = r8.f432a;
        r7 = r5.f427a;
        r0.onReceive(r6, r7);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
    L_0x0042:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.a():void");
    }
}
