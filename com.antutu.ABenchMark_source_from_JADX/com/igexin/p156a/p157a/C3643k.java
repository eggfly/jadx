package com.igexin.p156a.p157a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.k */
public class C3643k extends C3638f {
    public C3643k(C3642j c3642j, C3637e c3637e, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(c3637e.f12298a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = c3637e.f12300c + (((long) c3637e.f12302e) * j);
        this.a = c3642j.m14899c(allocate, j2);
        this.b = c3642j.m14899c(allocate, 4 + j2);
        this.c = c3642j.m14899c(allocate, 8 + j2);
        this.d = c3642j.m14899c(allocate, j2 + 20);
    }
}
