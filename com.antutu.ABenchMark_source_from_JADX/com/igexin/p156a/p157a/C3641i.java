package com.igexin.p156a.p157a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.i */
public class C3641i extends C3637e {
    private final C3642j f12313j;

    public C3641i(boolean z, C3642j c3642j) {
        this.a = z;
        this.f12313j = c3642j;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = c3642j.m14900d(allocate, 16);
        this.c = c3642j.m14897b(allocate, 32);
        this.d = c3642j.m14897b(allocate, 40);
        this.e = c3642j.m14900d(allocate, 54);
        this.f = c3642j.m14900d(allocate, 56);
        this.g = c3642j.m14900d(allocate, 58);
        this.h = c3642j.m14900d(allocate, 60);
        this.i = c3642j.m14900d(allocate, 62);
    }

    public C3633d m14890a(long j, int i) {
        return new C3635b(this.f12313j, this, j, i);
    }

    public C3638f m14891a(long j) {
        return new C3644l(this.f12313j, this, j);
    }

    public C3639g m14892a(int i) {
        return new C3646n(this.f12313j, this, i);
    }
}
