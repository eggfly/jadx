package com.igexin.p158b.p159a.p161b;

import android.support.v4.view.MotionEventCompat;
import java.io.OutputStream;

/* renamed from: com.igexin.b.a.b.a */
public class C3682a extends OutputStream {
    private OutputStream f12404a;
    private int f12405b;
    private int f12406c;
    private int f12407d;
    private int f12408e;

    public C3682a(OutputStream outputStream, int i) {
        this.f12404a = null;
        this.f12405b = 0;
        this.f12406c = 0;
        this.f12407d = 0;
        this.f12408e = 0;
        this.f12404a = outputStream;
        this.f12408e = i;
    }

    protected void m15041a() {
        int i = 61;
        if (this.f12406c > 0) {
            if (this.f12408e > 0 && this.f12407d == this.f12408e) {
                this.f12404a.write("\r\n".getBytes());
                this.f12407d = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f12405b << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f12405b << 14) >>> 26);
            int charAt3 = this.f12406c < 2 ? 61 : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f12405b << 20) >>> 26);
            if (this.f12406c >= 3) {
                i = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f12405b << 26) >>> 26);
            }
            this.f12404a.write(charAt);
            this.f12404a.write(charAt2);
            this.f12404a.write(charAt3);
            this.f12404a.write(i);
            this.f12407d += 4;
            this.f12406c = 0;
            this.f12405b = 0;
        }
    }

    public void close() {
        m15041a();
        this.f12404a.close();
    }

    public void write(int i) {
        this.f12405b = ((i & MotionEventCompat.ACTION_MASK) << (16 - (this.f12406c * 8))) | this.f12405b;
        this.f12406c++;
        if (this.f12406c == 3) {
            m15041a();
        }
    }
}
