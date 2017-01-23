package com.taobao.accs.internal;

import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;

/* renamed from: com.taobao.accs.internal.c */
class C4106c extends AccsAbstractDataListener {
    final /* synthetic */ C4103b f13747a;

    C4106c(C4103b c4103b) {
        this.f13747a = c4103b;
    }

    public void onBind(String str, int i, ExtraInfo extraInfo) {
    }

    public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, ExtraInfo extraInfo) {
        this.f13747a.m16779a(bArr, i);
        if (this.f13747a.f13731o != null) {
            this.f13747a.f13731o.cancel(true);
        }
    }

    public void onSendData(String str, String str2, int i, ExtraInfo extraInfo) {
    }

    public void onUnbind(String str, int i, ExtraInfo extraInfo) {
    }
}
