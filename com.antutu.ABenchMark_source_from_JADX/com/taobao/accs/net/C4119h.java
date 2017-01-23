package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* renamed from: com.taobao.accs.net.h */
class C4119h implements Runnable {
    final /* synthetic */ C4118g f13783a;

    C4119h(C4118g c4118g) {
        this.f13783a = c4118g;
    }

    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
