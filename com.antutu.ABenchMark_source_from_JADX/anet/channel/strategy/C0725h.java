package anet.channel.strategy;

import android.os.AsyncTask;
import java.io.Serializable;
import java.util.Map.Entry;

/* renamed from: anet.channel.strategy.h */
class C0725h extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ Entry f2373a;
    final /* synthetic */ LURStrategyMap f2374b;

    C0725h(LURStrategyMap lURStrategyMap, Entry entry) {
        this.f2374b = lURStrategyMap;
        this.f2373a = entry;
    }

    protected Void m2935a() {
        C0732l.m2943a((Serializable) this.f2373a.getValue(), StrategyInfoHolder.m2887b(((StrategyTable) this.f2373a.getValue()).f2332a));
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2935a();
    }
}
