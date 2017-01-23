package com.igexin.p156a.p157a;

import android.support.v4.view.MotionEventCompat;
import cn.sharesdk.framework.Platform;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.igexin.a.a.j */
public class C3642j implements C3636c, Closeable {
    private final int f12314a;
    private final FileChannel f12315b;

    public C3642j(File file) {
        this.f12314a = 1179403647;
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f12315b = new FileInputStream(file).getChannel();
    }

    private long m14893a(C3637e c3637e, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            C3638f a = c3637e.m14885a(j3);
            if (a.f12307a == 1 && a.f12309c <= j2 && j2 <= a.f12309c + a.f12310d) {
                return (j2 - a.f12309c) + a.f12308b;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public C3637e m14894a() {
        this.f12315b.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (m14899c(allocate, 0) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short e = m14901e(allocate, 4);
        boolean z = m14901e(allocate, 5) == (short) 2;
        if (e == (short) 1) {
            return new C3640h(z, this);
        }
        if (e == (short) 2) {
            return new C3641i(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    protected String m14895a(ByteBuffer byteBuffer, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short e = m14901e(byteBuffer, j);
            if (e == (short) 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) e);
            j = j2;
        }
    }

    protected void m14896a(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.f12315b.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += (long) read;
        }
        byteBuffer.position(0);
    }

    protected long m14897b(ByteBuffer byteBuffer, long j) {
        m14896a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public List m14898b() {
        long j;
        this.f12315b.position(0);
        List arrayList = new ArrayList();
        C3637e a = m14894a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a.f12298a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) a.f12303f;
        if (j2 == 65535) {
            j2 = a.m14886a(0).f12311a;
        }
        for (j = 0; j < j2; j++) {
            C3638f a2 = a.m14885a(j);
            if (a2.f12307a == 2) {
                j = a2.f12308b;
                break;
            }
        }
        j = 0;
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        int i = 0;
        List<Long> arrayList2 = new ArrayList();
        long j3 = 0;
        C3633d a3;
        do {
            a3 = a.m14884a(j, i);
            if (a3.f12296a == 1) {
                arrayList2.add(Long.valueOf(a3.f12297b));
            } else if (a3.f12296a == 5) {
                j3 = a3.f12297b;
            }
            i++;
        } while (a3.f12296a != 0);
        if (j3 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        j2 = m14893a(a, j2, j3);
        for (Long longValue : arrayList2) {
            arrayList.add(m14895a(allocate, longValue.longValue() + j2));
        }
        return arrayList;
    }

    protected long m14899c(ByteBuffer byteBuffer, long j) {
        m14896a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public void close() {
        this.f12315b.close();
    }

    protected int m14900d(ByteBuffer byteBuffer, long j) {
        m14896a(byteBuffer, j, 2);
        return byteBuffer.getShort() & Platform.CUSTOMER_ACTION_MASK;
    }

    protected short m14901e(ByteBuffer byteBuffer, long j) {
        m14896a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & MotionEventCompat.ACTION_MASK);
    }
}
