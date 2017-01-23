package org.apache.thrift;

import org.apache.thrift.protocol.C4605g;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4608a.C4606a;
import org.apache.thrift.transport.C4621c;

/* renamed from: org.apache.thrift.e */
public class C4596e {
    private final C4607e f16441a;
    private final C4621c f16442b;

    public C4596e() {
        this(new C4606a());
    }

    public C4596e(C4605g c4605g) {
        this.f16442b = new C4621c();
        this.f16441a = c4605g.m19302a(this.f16442b);
    }

    public void m19299a(C4454a c4454a, byte[] bArr) {
        try {
            this.f16442b.m19398a(bArr);
            c4454a.m18409a(this.f16441a);
        } finally {
            this.f16441a.m19338x();
        }
    }
}
