package org.apache.thrift.protocol;

import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.C4597f;
import org.apache.thrift.protocol.C4608a.C4606a;
import org.apache.thrift.transport.C4618d;

/* renamed from: org.apache.thrift.protocol.k */
public class C4617k extends C4608a {
    private static int f16488f;
    private static int f16489g;
    private static int f16490h;
    private static int f16491i;
    private static int f16492j;

    /* renamed from: org.apache.thrift.protocol.k.a */
    public static class C4616a extends C4606a {
        public C4616a() {
            super(false, true);
        }

        public C4616a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        public C4607e m19379a(C4618d c4618d) {
            C4607e c4617k = new C4617k(c4618d, this.a, this.b);
            if (this.c != 0) {
                c4617k.m19355c(this.c);
            }
            return c4617k;
        }
    }

    static {
        f16488f = 10000;
        f16489g = 10000;
        f16490h = 10000;
        f16491i = 10485760;
        f16492j = 104857600;
    }

    public C4617k(C4618d c4618d, boolean z, boolean z2) {
        super(c4618d, z, z2);
    }

    public C4611d m19380j() {
        byte q = m19370q();
        byte q2 = m19370q();
        int s = m19372s();
        if (s <= f16488f) {
            return new C4611d(q, q2, s);
        }
        throw new C4612f(3, "Thrift map size " + s + " out of range!");
    }

    public C4610c m19381l() {
        byte q = m19370q();
        int s = m19372s();
        if (s <= f16489g) {
            return new C4610c(q, s);
        }
        throw new C4612f(3, "Thrift list size " + s + " out of range!");
    }

    public C4614i m19382n() {
        byte q = m19370q();
        int s = m19372s();
        if (s <= f16490h) {
            return new C4614i(q, s);
        }
        throw new C4612f(3, "Thrift set size " + s + " out of range!");
    }

    public String m19383v() {
        int s = m19372s();
        if (s > f16491i) {
            throw new C4612f(3, "Thrift string size " + s + " out of range!");
        } else if (this.e.m19390c() < s) {
            return m19352b(s);
        } else {
            try {
                String str = new String(this.e.m19387a(), this.e.m19388b(), s, HttpRequest.f14548a);
                this.e.m19386a(s);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new C4597f("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    public ByteBuffer m19384w() {
        int s = m19372s();
        if (s > f16492j) {
            throw new C4612f(3, "Thrift binary size " + s + " out of range!");
        }
        m19357d(s);
        if (this.e.m19390c() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.m19387a(), this.e.m19388b(), s);
            this.e.m19386a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.e.m19391d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }
}
