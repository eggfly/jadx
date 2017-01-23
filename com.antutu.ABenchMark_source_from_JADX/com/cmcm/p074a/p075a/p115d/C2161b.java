package com.cmcm.p074a.p075a.p115d;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.cmcm.p074a.p075a.p112a.ae;

/* renamed from: com.cmcm.a.a.d.b */
class C2161b implements Runnable {
    final /* synthetic */ Context f7520a;
    final /* synthetic */ C2160a f7521b;

    C2161b(C2160a c2160a, Context context) {
        this.f7521b = c2160a;
        this.f7520a = context;
    }

    public void run() {
        boolean a;
        Exception exception;
        String str;
        Exception exception2;
        if (ae.m7934a(this.f7520a)) {
            ServiceConnection a2 = C2160a.m8146a(this.f7520a);
            if (a2 != null) {
                String str2;
                String str3 = null;
                try {
                    C2162d c2162d = (C2162d) C2160a.m8145a(a2.m8162a());
                    str3 = c2162d.m8153a();
                    try {
                        a = c2162d.m8154a(false);
                        str2 = str3;
                    } catch (Exception e) {
                        exception = e;
                        str = str3;
                        exception2 = exception;
                        exception2.printStackTrace();
                        str2 = str;
                        a = false;
                        if (!TextUtils.isEmpty(str2)) {
                            synchronized (this.f7521b.f7518a) {
                                this.f7521b.f7518a = str2;
                                this.f7521b.f7519b = a;
                            }
                        }
                        this.f7520a.unbindService(a2);
                    }
                } catch (Exception e2) {
                    exception = e2;
                    str = str3;
                    exception2 = exception;
                    exception2.printStackTrace();
                    str2 = str;
                    a = false;
                    if (TextUtils.isEmpty(str2)) {
                        synchronized (this.f7521b.f7518a) {
                            this.f7521b.f7518a = str2;
                            this.f7521b.f7519b = a;
                        }
                    }
                    this.f7520a.unbindService(a2);
                }
                if (TextUtils.isEmpty(str2)) {
                    synchronized (this.f7521b.f7518a) {
                        this.f7521b.f7518a = str2;
                        this.f7521b.f7519b = a;
                    }
                }
                try {
                    this.f7520a.unbindService(a2);
                } catch (IllegalArgumentException e3) {
                }
            }
        }
    }
}
