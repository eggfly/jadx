package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import org.apache.thrift.protocol.C4605g;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4608a.C4606a;
import org.apache.thrift.transport.C4619a;

/* renamed from: org.apache.thrift.g */
public class C4598g {
    private final ByteArrayOutputStream f16443a;
    private final C4619a f16444b;
    private C4607e f16445c;

    public C4598g() {
        this(new C4606a());
    }

    public C4598g(C4605g c4605g) {
        this.f16443a = new ByteArrayOutputStream();
        this.f16444b = new C4619a(this.f16443a);
        this.f16445c = c4605g.m19302a(this.f16444b);
    }

    public byte[] m19300a(C4454a c4454a) {
        this.f16443a.reset();
        c4454a.m18410b(this.f16445c);
        return this.f16443a.toByteArray();
    }
}
