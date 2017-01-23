package com.igexin.p156a.p157a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.h */
public class C3640h extends C3637e {
    private final C3642j f12312j;

    public C3640h(boolean z, C3642j c3642j) {
        this.a = z;
        this.f12312j = c3642j;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = c3642j.m14900d(allocate, 16);
        this.c = c3642j.m14899c(allocate, 28);
        this.d = c3642j.m14899c(allocate, 32);
        this.e = c3642j.m14900d(allocate, 42);
        this.f = c3642j.m14900d(allocate, 44);
        this.g = c3642j.m14900d(allocate, 46);
        this.h = c3642j.m14900d(allocate, 48);
        this.i = c3642j.m14900d(allocate, 50);
    }

    public C3633d m14887a(long j, int i) {
        return new C3634a(this.f12312j, this, j, i);
    }

    public C3638f m14888a(long j) {
        return new C3643k(this.f12312j, this, j);
    }

    public C3639g m14889a(int i) {
        return new C3645m(this.f12312j, this, i);
    }
}
