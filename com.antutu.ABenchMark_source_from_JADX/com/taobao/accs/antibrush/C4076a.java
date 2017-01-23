package com.taobao.accs.antibrush;

import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.antibrush.a */
class C4076a implements Runnable {
    final /* synthetic */ AntiBrush f13573a;

    C4076a(AntiBrush antiBrush) {
        this.f13573a = antiBrush;
    }

    public void run() {
        ALog.m16903e("AntiBrush", "anti bursh timeout", new Object[0]);
        AntiBrush.onResult(this.f13573a.mContext, false);
    }
}
