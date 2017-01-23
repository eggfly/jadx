package com.cmcm.p074a.p075a.p112a;

import com.cmcm.p074a.p075a.p113b.C2121a;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;

/* renamed from: com.cmcm.a.a.a.o */
class C2122o extends C2121a {
    final /* synthetic */ C2116j f7451a;
    private ByteArrayOutputStream f7452b;
    private C2109c f7453c;
    private int f7454d;

    private C2122o(C2116j c2116j) {
        this.f7451a = c2116j;
        this.f7452b = new ByteArrayOutputStream();
    }

    public void m8016a(String str) {
        this.f7452b.reset();
        m8015c(str);
    }

    public void m8017a(boolean z) {
        this.f7454d++;
        boolean b = z ? m8021b(this.f7452b.toString()) : m8021b(null);
        if (m8018a() && b) {
            if (this.f7453c == null) {
                this.f7453c = new C2109c(1, this.f7451a.f7433b);
            }
            this.f7453c.m7951a(new C2123p(this), 60000);
        }
    }

    public boolean m8018a() {
        return this.f7454d < 3;
    }

    public boolean m8019a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Charset", "utf8");
        return super.m8009a(httpURLConnection);
    }

    public boolean m8020a(HttpURLConnection httpURLConnection, byte[] bArr, int i, int i2) {
        this.f7452b.write(bArr, i, i2);
        return super.m8011a(httpURLConnection, bArr, i, i2);
    }

    public boolean m8021b(String str) {
        return false;
    }
}
