package com.taobao.accs.client;

import com.taobao.accs.antibrush.C4077b;
import com.taobao.accs.utl.UtilityImpl;

/* renamed from: com.taobao.accs.client.c */
class C4087c implements Runnable {
    final /* synthetic */ GlobalClientInfo f13641a;

    C4087c(GlobalClientInfo globalClientInfo) {
        this.f13641a = globalClientInfo;
    }

    public void run() {
        C4077b.m16629a(GlobalClientInfo.f13610e);
        GlobalClientInfo.f13606a = UtilityImpl.restoreCookie(GlobalClientInfo.f13610e);
    }
}
