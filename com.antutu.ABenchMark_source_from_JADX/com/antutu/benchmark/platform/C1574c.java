package com.antutu.benchmark.platform;

import java.text.SimpleDateFormat;

/* renamed from: com.antutu.benchmark.platform.c */
public class C1574c {
    private int f5469a;
    private int f5470b;
    private long f5471c;
    private long f5472d;
    private long f5473e;

    public C1574c() {
        this.f5469a = 0;
        this.f5470b = 10;
    }

    public void m6232a() {
        if (this.f5469a == 2) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (this.f5469a != 0) {
            throw new IllegalStateException("Stopwatch already started. ");
        } else {
            this.f5471c = System.nanoTime();
            this.f5472d = System.currentTimeMillis();
            this.f5469a = 1;
        }
    }

    public void m6233b() {
        if (this.f5469a == 1 || this.f5469a == 3) {
            if (this.f5469a == 1) {
                this.f5473e = System.nanoTime();
            }
            this.f5469a = 2;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void m6234c() {
        this.f5469a = 0;
        this.f5470b = 10;
    }

    public long m6235d() {
        return m6236e() / 1000000;
    }

    public long m6236e() {
        if (this.f5469a == 2 || this.f5469a == 3) {
            return this.f5473e - this.f5471c;
        }
        if (this.f5469a == 0) {
            return 0;
        }
        if (this.f5469a == 1) {
            return System.nanoTime() - this.f5471c;
        }
        throw new RuntimeException("Illegal running state has occured. ");
    }

    public String toString() {
        return new SimpleDateFormat("hh:mm:ss.SSS").format(Long.valueOf(m6235d()));
    }
}
