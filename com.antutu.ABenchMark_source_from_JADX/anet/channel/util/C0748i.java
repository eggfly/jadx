package anet.channel.util;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: anet.channel.util.i */
public class C0748i {
    private static AtomicInteger f2436a;

    static {
        f2436a = new AtomicInteger();
    }

    public static String m2987a() {
        if (f2436a.get() == Integer.MAX_VALUE) {
            f2436a.set(0);
        }
        return StringUtils.buildString("AWCN", String.valueOf(f2436a.incrementAndGet()));
    }
}
