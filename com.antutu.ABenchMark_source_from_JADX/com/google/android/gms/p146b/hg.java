package com.google.android.gms.p146b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.C2968s;

@gb
/* renamed from: com.google.android.gms.b.hg */
public class hg extends Handler {
    public hg(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            C2968s.m11528h().m12941a(e, false);
            throw e;
        }
    }
}
