package anet.channel.strategy;

import android.os.AsyncTask;

/* renamed from: anet.channel.strategy.j */
class C0727j extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ C0726i f2378a;

    C0727j(C0726i c0726i) {
        this.f2378a = c0726i;
    }

    protected Void m2939a() {
        if (!this.f2378a.m2937a()) {
            this.f2378a.f2375a.m2893b();
        }
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2939a();
    }
}
