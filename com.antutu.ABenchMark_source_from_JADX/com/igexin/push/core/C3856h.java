package com.igexin.push.core;

import android.os.Looper;

/* renamed from: com.igexin.push.core.h */
public class C3856h extends Thread {
    public void run() {
        Looper.prepare();
        if (C3854f.m15859a() != null) {
            C3854f.m15859a().m15862a(new C3853e());
        }
        C3854f.m15859a().m15871b();
        Looper.loop();
    }
}
