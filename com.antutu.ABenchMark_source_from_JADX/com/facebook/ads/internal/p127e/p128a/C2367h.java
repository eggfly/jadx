package com.facebook.ads.internal.p127e.p128a;

import android.os.AsyncTask;

/* renamed from: com.facebook.ads.internal.e.a.h */
public class C2367h extends AsyncTask<C2368l, Void, C2373n> implements C2362c {
    private C2360a f8253a;
    private C2361b f8254b;
    private Exception f8255c;

    public C2367h(C2360a c2360a, C2361b c2361b) {
        this.f8253a = c2360a;
        this.f8254b = c2361b;
    }

    protected C2373n m9123a(C2368l... c2368lArr) {
        if (c2368lArr != null) {
            try {
                if (c2368lArr.length > 0) {
                    return this.f8253a.m9094a(c2368lArr[0]);
                }
            } catch (Exception e) {
                this.f8255c = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    public void m9124a(C2368l c2368l) {
        super.execute(new C2368l[]{c2368l});
    }

    protected void m9125a(C2373n c2373n) {
        this.f8254b.m9109a(c2373n);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9123a((C2368l[]) objArr);
    }

    protected void onCancelled() {
        this.f8254b.m9110a(this.f8255c);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9125a((C2373n) obj);
    }
}
