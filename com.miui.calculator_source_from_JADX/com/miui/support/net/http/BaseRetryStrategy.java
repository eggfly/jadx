package com.miui.support.net.http;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLException;

public class BaseRetryStrategy implements RetryStrategy {
    private static ArrayList<Class<?>> f3395a;
    private int f3396b;
    private int f3397c;
    private final int f3398d;
    private final float f3399e;

    static {
        f3395a = new ArrayList();
        f3395a.add(InterruptedIOException.class);
        f3395a.add(SSLException.class);
    }

    public BaseRetryStrategy() {
        this(10000, 3, 1.0f);
    }

    public BaseRetryStrategy(int i, int i2, float f) {
        this.f3396b = i;
        this.f3398d = i2;
        this.f3399e = f;
    }

    public int m5090a() {
        return this.f3396b;
    }

    public boolean m5091a(Throwable th) {
        this.f3397c++;
        this.f3396b = (int) (((float) this.f3396b) + (((float) this.f3396b) * this.f3399e));
        return m5092b() && m5093b(th);
    }

    protected boolean m5092b() {
        return this.f3397c <= this.f3398d;
    }

    protected boolean m5093b(Throwable th) {
        Iterator it = f3395a.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
