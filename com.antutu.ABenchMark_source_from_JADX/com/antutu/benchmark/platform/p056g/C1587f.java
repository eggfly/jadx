package com.antutu.benchmark.platform.p056g;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.antutu.benchmark.platform.g.f */
public class C1587f {
    public static String f5558a;

    /* renamed from: com.antutu.benchmark.platform.g.f.a */
    public static class C1586a {
        byte[] f5555a;
        byte[] f5556b;
        byte[] f5557c;
    }

    static {
        f5558a = "SecureMessageFormatter";
    }

    public static C1586a m6281a(byte[] bArr) {
        C1586a c1586a = new C1586a();
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 12);
        wrap.order(ByteOrder.BIG_ENDIAN);
        int i = wrap.getInt();
        int i2 = wrap.getInt();
        int i3 = wrap.getInt();
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, 12, (i + i2) + i3);
        c1586a.f5556b = new byte[i];
        c1586a.f5557c = new byte[i2];
        c1586a.f5555a = new byte[i3];
        wrap2.get(c1586a.f5556b, 0, i);
        wrap2.get(c1586a.f5557c, 0, i2);
        wrap2.get(c1586a.f5555a, 0, i3);
        return c1586a;
    }

    public static ByteBuffer m6282a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ByteBuffer allocate = ByteBuffer.allocate(((bArr.length + 12) + bArr2.length) + bArr3.length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(bArr2.length);
        allocate.putInt(bArr3.length);
        allocate.putInt(bArr.length);
        allocate.put(bArr2);
        allocate.put(bArr3);
        allocate.put(bArr);
        return allocate;
    }
}
