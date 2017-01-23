package com.p029a.p030a.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.sdk.PushConsts;
import com.p029a.p030a.C1061a;
import java.io.IOException;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.a.a.b.a */
public class C1054a {
    protected boolean f3544d;
    protected Context f3545e;
    public int f3546f;
    public int f3547g;
    C1064b f3548h;
    Handler f3549i;
    boolean f3550j;
    String[] f3551k;
    boolean f3552l;
    boolean f3553m;
    boolean f3554n;
    int f3555o;
    int f3556p;
    int f3557q;

    /* renamed from: com.a.a.b.a.a */
    private class C1063a extends Handler {
        final /* synthetic */ C1054a f3572a;

        private C1063a(C1054a c1054a) {
            this.f3572a = c1054a;
        }

        public final void handleMessage(Message message) {
            int i = message.getData().getInt(PushConsts.CMD_ACTION);
            String string = message.getData().getString("text");
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f3572a.m4719a(this.f3572a.f3556p, string);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f3572a.m4718a(this.f3572a.f3556p, this.f3572a.f3555o);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f3572a.m4722b(this.f3572a.f3556p, string);
                default:
            }
        }
    }

    /* renamed from: com.a.a.b.a.b */
    private class C1064b extends Thread {
        final /* synthetic */ C1054a f3573a;

        private C1064b(C1054a c1054a) {
            this.f3573a = c1054a;
        }

        public void run() {
            if (this.f3573a.f3557q > 0) {
                while (!this.f3573a.f3552l) {
                    synchronized (this.f3573a) {
                        try {
                            this.f3573a.wait((long) this.f3573a.f3557q);
                        } catch (InterruptedException e) {
                        }
                    }
                    if (!this.f3573a.f3552l) {
                        C1061a.m4746c("Timeout Exception has occurred.");
                        this.f3573a.m4720a("Timeout Exception");
                    }
                }
            }
        }
    }

    public C1054a(int i, boolean z, String... strArr) {
        this.f3544d = false;
        this.f3545e = null;
        this.f3546f = 0;
        this.f3547g = 0;
        this.f3548h = null;
        this.f3549i = null;
        this.f3550j = false;
        this.f3551k = new String[0];
        this.f3552l = false;
        this.f3553m = false;
        this.f3554n = true;
        this.f3555o = -1;
        this.f3556p = 0;
        this.f3557q = C1061a.f3571c;
        this.f3551k = strArr;
        this.f3556p = i;
        m4715a(z);
    }

    public C1054a(int i, String... strArr) {
        this.f3544d = false;
        this.f3545e = null;
        this.f3546f = 0;
        this.f3547g = 0;
        this.f3548h = null;
        this.f3549i = null;
        this.f3550j = false;
        this.f3551k = new String[0];
        this.f3552l = false;
        this.f3553m = false;
        this.f3554n = true;
        this.f3555o = -1;
        this.f3556p = 0;
        this.f3557q = C1061a.f3571c;
        this.f3551k = strArr;
        this.f3556p = i;
        m4715a(C1061a.f3570b);
    }

    private void m4715a(boolean z) {
        this.f3554n = z;
        if (Looper.myLooper() == null || !z) {
            C1061a.m4746c("CommandHandler not created");
            return;
        }
        C1061a.m4746c("CommandHandler created");
        this.f3549i = new C1063a();
    }

    protected final void m4716a() {
        if (!this.f3553m) {
            synchronized (this) {
                if (this.f3549i == null || !this.f3554n) {
                    m4718a(this.f3556p, this.f3555o);
                } else {
                    Message obtainMessage = this.f3549i.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, 2);
                    obtainMessage.setData(bundle);
                    this.f3549i.sendMessage(obtainMessage);
                }
                C1061a.m4746c("Command " + this.f3556p + " finished.");
                m4721b();
            }
        }
    }

    protected final void m4717a(int i) {
        synchronized (this) {
            this.f3555o = i;
        }
    }

    public void m4718a(int i, int i2) {
    }

    public void m4719a(int i, String str) {
        C1061a.m4740a("Command", "ID: " + i + ", " + str);
        this.f3547g++;
    }

    protected final void m4720a(String str) {
        try {
            C1071b.m4769e();
            C1061a.m4746c("Terminating all shells.");
            m4723b(str);
        } catch (IOException e) {
        }
    }

    protected final void m4721b() {
        this.f3550j = false;
        this.f3552l = true;
        notifyAll();
    }

    public void m4722b(int i, String str) {
    }

    protected final void m4723b(String str) {
        synchronized (this) {
            if (this.f3549i == null || !this.f3554n) {
                m4722b(this.f3556p, str);
            } else {
                Message obtainMessage = this.f3549i.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt(PushConsts.CMD_ACTION, 3);
                bundle.putString("text", str);
                obtainMessage.setData(bundle);
                this.f3549i.sendMessage(obtainMessage);
            }
            C1061a.m4746c("Command " + this.f3556p + " did not finish because it was terminated. Termination reason: " + str);
            m4717a(-1);
            this.f3553m = true;
            m4721b();
        }
    }

    public final String m4724c() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f3551k.length; i++) {
            if (i > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(this.f3551k[i]);
        }
        return stringBuilder.toString();
    }

    protected final void m4725c(int i, String str) {
        this.f3546f++;
        if (this.f3549i == null || !this.f3554n) {
            m4719a(i, str);
            return;
        }
        Message obtainMessage = this.f3549i.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, 1);
        bundle.putString("text", str);
        obtainMessage.setData(bundle);
        this.f3549i.sendMessage(obtainMessage);
    }

    public final boolean m4726d() {
        return this.f3550j;
    }

    public final boolean m4727e() {
        return this.f3552l;
    }

    protected final void m4728f() {
        this.f3548h = new C1064b();
        this.f3548h.setPriority(1);
        this.f3548h.start();
        this.f3550j = true;
    }

    public final void m4729g() {
        this.f3552l = false;
        this.f3546f = 0;
        this.f3547g = 0;
        this.f3550j = false;
        this.f3553m = false;
        this.f3555o = -1;
    }
}
