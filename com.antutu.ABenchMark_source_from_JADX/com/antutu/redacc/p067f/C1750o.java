package com.antutu.redacc.p067f;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.antutu.redacc.f.o */
public abstract class C1750o implements Runnable {
    private int f6179a;
    private Handler f6180b;

    /* renamed from: com.antutu.redacc.f.o.1 */
    class C17581 extends Handler {
        final /* synthetic */ C1750o f6190a;

        C17581(C1750o c1750o) {
            this.f6190a = c1750o;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.f6190a.m6748a(message);
        }
    }

    public C1750o() {
        this.f6180b = new C17581(this);
        this.f6179a = -1;
    }

    abstract Object m6747a();

    abstract void m6748a(Message message);

    abstract void m6749b();

    public void run() {
        Message obtainMessage;
        this.f6179a = 1;
        try {
            m6749b();
            Object a = m6747a();
            this.f6179a = 0;
            obtainMessage = this.f6180b.obtainMessage(0, a);
        } catch (Exception e) {
            this.f6179a = 2;
            obtainMessage = this.f6180b.obtainMessage(-1, null);
        } finally {
            this.f6180b.sendMessage(null);
        }
    }
}
