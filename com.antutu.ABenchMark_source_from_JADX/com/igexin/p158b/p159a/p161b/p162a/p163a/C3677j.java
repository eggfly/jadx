package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3686d;
import com.igexin.p158b.p159a.p161b.p162a.p163a.p164a.C3660b;
import com.igexin.p158b.p159a.p167c.C3688a;
import java.nio.ByteBuffer;

/* renamed from: com.igexin.b.a.b.a.a.j */
public final class C3677j extends C3668a {
    private static final String f12391L;
    private C3660b f12392M;
    private byte[] f12393N;
    private C3686d f12394O;
    C3680m f12395i;
    public C3683b f12396j;

    static {
        f12391L = C3677j.class.getName();
    }

    public C3677j(C3680m c3680m, C3683b c3683b, C3686d c3686d) {
        super(-2035, null, c3683b);
        this.f12396j = c3683b;
        this.f12393N = new byte[61440];
        this.f12395i = c3680m;
        this.f12394O = c3686d;
    }

    public void m15025a(C3660b c3660b) {
        this.f12392M = c3660b;
    }

    public void a_() {
        super.a_();
        Thread currentThread = Thread.currentThread();
        C3688a.m15097b(f12391L + "|" + currentThread + " running");
        while (this.h && !currentThread.isInterrupted() && !this.e) {
            try {
                int a = this.f12395i.m15037a(this.f12393N);
                if (a == -1) {
                    C3688a.m15097b(f12391L + "|read len = -1, EOF ~~~");
                    this.h = false;
                    this.f = C3669b.EXCEPTION;
                    this.g = "end of stream";
                } else if (a == 0) {
                    C3688a.m15097b(f12391L + "|read len = 0");
                } else {
                    C3688a.m15097b(f12391L + "|socket read len = " + a);
                    if (!(this.f12392M == null || this.e)) {
                        this.f = C3669b.NORMAL;
                        this.f12396j.m15045c(null, this.f12394O, ByteBuffer.wrap(this.f12393N, 0, a));
                        this.f12392M.m14940a();
                    }
                }
                for (int i = 0; i < a; i++) {
                    this.f12393N[i] = (byte) 0;
                }
            } catch (Throwable th) {
                this.h = false;
                if (this.f != C3669b.INTERRUPT) {
                    this.f = C3669b.EXCEPTION;
                    this.g = th.toString();
                }
            }
        }
        this.e = true;
        C3688a.m15097b(f12391L + "|finish ~~~~~~");
    }

    public final int m15026b() {
        return -2035;
    }

    public void m15027f() {
        super.m14974f();
        C3688a.m15097b(f12391L + "|dispose");
        if (this.f12392M != null) {
            if (this.f == C3669b.INTERRUPT) {
                this.f12392M.m14939a(this);
            } else if (this.f == C3669b.EXCEPTION && !TextUtils.isEmpty(this.g)) {
                this.f12392M.m14941a(new Exception(this.g));
            }
        }
        if (this.f12393N != null) {
            this.f12393N = null;
        }
        this.f12392M = null;
    }

    public void m15028h() {
        this.h = false;
        this.f = C3669b.INTERRUPT;
        try {
            if (!this.e && this.f12395i.f12402a != null) {
                this.f12395i.f12402a.notifyAll();
            }
        } catch (Exception e) {
        }
    }
}
