package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener;
import com.taobao.accs.common.C4089a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.taobao.accs.net.g */
class C4118g implements IDispatchEventListener {
    final /* synthetic */ C4117f f13782a;

    C4118g(C4117f c4117f) {
        this.f13782a = c4117f;
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        C4089a.m16687a(new C4119h(this), 2000, TimeUnit.MILLISECONDS);
    }
}
