package com.baidu.mobads.openad.p083a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.openad.p079d.C1899b;
import com.igexin.sdk.PushConsts;

/* renamed from: com.baidu.mobads.openad.a.c */
public class C2005c extends C1915d {
    private int f6985a;
    private C2004b f6986d;
    private IntentFilter f6987e;

    public C2005c(Context context) {
        super(context);
    }

    public void m7480a() {
        if (this.f6985a == 0) {
            if (this.f6986d == null) {
                m7481a(new C2004b(this));
            }
            this.f6987e = new IntentFilter();
            this.f6987e.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        }
        this.f6985a++;
        this.b.registerReceiver(this.f6986d, this.f6987e);
    }

    public void m7481a(BroadcastReceiver broadcastReceiver) {
        this.f6986d = (C2004b) broadcastReceiver;
    }

    public void m7482b() {
        dispatchEvent(new C1899b("network_changed"));
    }
}
