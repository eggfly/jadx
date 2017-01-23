package com.igexin.p156a.p157a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.a */
public class C3634a extends C3633d {
    public C3634a(C3642j c3642j, C3637e c3637e, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(c3637e.f12298a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = ((long) (i * 8)) + j;
        this.a = c3642j.m14899c(allocate, j2);
        this.b = c3642j.m14899c(allocate, j2 + 4);
    }
}
