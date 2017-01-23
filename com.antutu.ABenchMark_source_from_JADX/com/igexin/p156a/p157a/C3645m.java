package com.igexin.p156a.p157a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.m */
public class C3645m extends C3639g {
    public C3645m(C3642j c3642j, C3637e c3637e, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(c3637e.f12298a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = c3642j.m14899c(allocate, (c3637e.f12301d + ((long) (c3637e.f12304g * i))) + 28);
    }
}
