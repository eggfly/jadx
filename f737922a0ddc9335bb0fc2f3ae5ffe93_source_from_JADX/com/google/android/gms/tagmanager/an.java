package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class an extends am {
    private static an J8;
    private static final Object j6;
    private Context DW;
    private a EQ;
    private o FH;
    private volatile m Hw;
    private boolean J0;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    private p tp;
    private boolean u7;
    private int v5;
    private u we;

    class 1 implements p {
        final /* synthetic */ an j6;

        1(an anVar) {
            this.j6 = anVar;
        }

        public void j6(boolean z) {
            this.j6.j6(z, this.j6.gn);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ an j6;

        2(an anVar) {
            this.j6 = anVar;
        }

        public void run() {
            this.j6.FH.j6();
        }
    }

    public interface a {
        void DW();

        void j6();

        void j6(long j);
    }

    private class b implements a {
        private Handler DW;
        final /* synthetic */ an j6;

        class 1 implements Callback {
            final /* synthetic */ b j6;

            1(b bVar) {
                this.j6 = bVar;
            }

            public boolean handleMessage(Message message) {
                if (1 == message.what && an.j6.equals(message.obj)) {
                    this.j6.j6.j6();
                    if (!this.j6.j6.gn()) {
                        this.j6.j6((long) this.j6.j6.v5);
                    }
                }
                return true;
            }
        }

        private b(an anVar) {
            this.j6 = anVar;
            this.DW = new Handler(this.j6.DW.getMainLooper(), new 1(this));
        }

        private Message FH() {
            return this.DW.obtainMessage(1, an.j6);
        }

        public void DW() {
            this.DW.removeMessages(1, an.j6);
        }

        public void j6() {
            this.DW.removeMessages(1, an.j6);
            this.DW.sendMessage(FH());
        }

        public void j6(long j) {
            this.DW.removeMessages(1, an.j6);
            this.DW.sendMessageDelayed(FH(), j);
        }
    }

    static {
        j6 = new Object();
    }

    private an() {
        this.v5 = 1800000;
        this.Zo = true;
        this.VH = false;
        this.gn = true;
        this.u7 = true;
        this.tp = new 1(this);
        this.J0 = false;
    }

    public static an FH() {
        if (J8 == null) {
            J8 = new an();
        }
        return J8;
    }

    private void VH() {
        this.EQ = new b();
        if (this.v5 > 0) {
            this.EQ.j6((long) this.v5);
        }
    }

    private void Zo() {
        this.we = new u(this);
        this.we.j6(this.DW);
    }

    private boolean gn() {
        return this.J0 || !this.gn || this.v5 <= 0;
    }

    private void u7() {
        if (gn()) {
            this.EQ.DW();
            r.Hw("PowerSaveMode initiated.");
            return;
        }
        this.EQ.j6((long) this.v5);
        r.Hw("PowerSaveMode terminated.");
    }

    public synchronized void DW() {
        if (!gn()) {
            this.EQ.j6();
        }
    }

    synchronized o Hw() {
        if (this.FH == null) {
            if (this.DW == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.FH = new ac(this.tp, this.DW);
        }
        if (this.EQ == null) {
            VH();
        }
        this.VH = true;
        if (this.Zo) {
            j6();
            this.Zo = false;
        }
        if (this.we == null && this.u7) {
            Zo();
        }
        return this.FH;
    }

    public synchronized void j6() {
        if (this.VH) {
            this.Hw.j6(new 2(this));
        } else {
            r.Hw("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.Zo = true;
        }
    }

    synchronized void j6(Context context, m mVar) {
        if (this.DW == null) {
            this.DW = context.getApplicationContext();
            if (this.Hw == null) {
                this.Hw = mVar;
            }
        }
    }

    public synchronized void j6(boolean z) {
        j6(this.J0, z);
    }

    synchronized void j6(boolean z, boolean z2) {
        boolean gn = gn();
        this.J0 = z;
        this.gn = z2;
        if (gn() != gn) {
            u7();
        }
    }
}
