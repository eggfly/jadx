package com.p105c.p106a.p111c;

import android.content.Context;
import com.p105c.p106a.p107a.p108a.C2090d;
import com.p105c.p106a.p107a.p108a.C2091e;
import java.util.zip.Adler32;

/* renamed from: com.c.a.c.c */
public class C2103c {
    static String f7387a;
    static final Object f7388b;
    private static C2102b f7389c;

    static {
        f7389c = null;
        f7387a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
        f7388b = new Object();
    }

    static long m7894a(C2102b c2102b) {
        if (c2102b != null) {
            String format = String.format("%s%s%s%s%s", new Object[]{c2102b.m7893e(), c2102b.m7891d(), Long.valueOf(c2102b.m7883a()), c2102b.m7889c(), c2102b.m7886b()});
            if (!C2091e.m7809a(format)) {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(format.getBytes());
                return adler32.getValue();
            }
        }
        return 0;
    }

    public static synchronized C2102b m7895a(Context context) {
        C2102b c2102b;
        synchronized (C2103c.class) {
            if (f7389c != null) {
                c2102b = f7389c;
            } else if (context != null) {
                c2102b = C2103c.m7896b(context);
                f7389c = c2102b;
            } else {
                c2102b = null;
            }
        }
        return c2102b;
    }

    private static C2102b m7896b(Context context) {
        if (context != null) {
            C2102b c2102b = new C2102b();
            synchronized (f7388b) {
                String a = C2104d.m7897a(context).m7908a();
                if (C2091e.m7809a(a)) {
                } else {
                    String substring = a.endsWith("\n") ? a.substring(0, a.length() - 1) : a;
                    c2102b = new C2102b();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = C2090d.m7807a(context);
                    String b = C2090d.m7808b(context);
                    c2102b.m7890c(a2);
                    c2102b.m7885a(a2);
                    c2102b.m7887b(currentTimeMillis);
                    c2102b.m7888b(b);
                    c2102b.m7892d(substring);
                    c2102b.m7884a(C2103c.m7894a(c2102b));
                    return c2102b;
                }
            }
        }
        return null;
    }
}
