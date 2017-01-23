package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* renamed from: com.taobao.accs.utl.f */
public class C4141f extends ByteArrayOutputStream {
    public C4141f(int i) {
        super(i);
    }

    public C4141f m16929a(byte b) {
        write(b);
        return this;
    }

    public C4141f m16930a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
