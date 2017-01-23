package com.facebook.ads.internal.p127e.p129b.p130a;

import com.facebook.ads.internal.p127e.p129b.C2376a;
import com.facebook.ads.internal.p127e.p129b.C2402l;
import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.facebook.ads.internal.e.b.a.b */
public class C2377b implements C2376a {
    public File f8271a;
    private final C2375a f8272b;
    private RandomAccessFile f8273c;

    public C2377b(File file, C2375a c2375a) {
        if (c2375a == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable e) {
                throw new C2402l("Error using file " + file + " as disc cache", e);
            }
        }
        this.f8272b = c2375a;
        C2381d.m9162a(file.getParentFile());
        boolean exists = file.exists();
        this.f8271a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
        this.f8273c = new RandomAccessFile(this.f8271a, exists ? "r" : "rw");
    }

    private boolean m9152a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int m9153a() {
        try {
        } catch (Throwable e) {
            throw new C2402l("Error reading length of file " + this.f8271a, e);
        }
        return (int) this.f8273c.length();
    }

    public synchronized int m9154a(byte[] bArr, long j, int i) {
        try {
            this.f8273c.seek(j);
        } catch (Throwable e) {
            throw new C2402l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(m9153a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f8273c.read(bArr, 0, i);
    }

    public synchronized void m9155a(byte[] bArr, int i) {
        try {
            if (m9158d()) {
                throw new C2402l("Error append cache: cache file " + this.f8271a + " is completed!");
            }
            this.f8273c.seek((long) m9153a());
            this.f8273c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new C2402l(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f8273c, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void m9156b() {
        try {
            this.f8273c.close();
            this.f8272b.m9145a(this.f8271a);
        } catch (Throwable e) {
            throw new C2402l("Error closing file " + this.f8271a, e);
        }
    }

    public synchronized void m9157c() {
        if (!m9158d()) {
            m9156b();
            File file = new File(this.f8271a.getParentFile(), this.f8271a.getName().substring(0, this.f8271a.getName().length() - ".download".length()));
            if (this.f8271a.renameTo(file)) {
                this.f8271a = file;
                try {
                    this.f8273c = new RandomAccessFile(this.f8271a, "r");
                } catch (Throwable e) {
                    throw new C2402l("Error opening " + this.f8271a + " as disc cache", e);
                }
            }
            throw new C2402l("Error renaming file " + this.f8271a + " to " + file + " for completion!");
        }
    }

    public synchronized boolean m9158d() {
        return !m9152a(this.f8271a);
    }
}
