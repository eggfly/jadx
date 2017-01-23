package com.xiaomi.stats;

import android.support.v4.view.ViewCompat;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4326a;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.push.thrift.C4455b;
import com.xiaomi.stats.C4506d.C4505a;
import com.xiaomi.xmpush.thrift.ae;
import java.util.Hashtable;
import org.apache.thrift.C4454a;

/* renamed from: com.xiaomi.stats.h */
public class C4512h {
    private static final int f15509a;

    /* renamed from: com.xiaomi.stats.h.a */
    static class C4511a {
        static Hashtable<Integer, Long> f15508a;

        static {
            f15508a = new Hashtable();
        }
    }

    static {
        f15509a = C4452a.PING_RTT.m18407a();
    }

    public static void m18705a() {
        C4512h.m18707a(0, f15509a);
    }

    public static void m18706a(int i) {
        C4455b f = C4509f.m18692a().m18703f();
        f.m18412a(C4452a.CHANNEL_STATS_COUNTER.m18407a());
        f.m18424c(i);
        C4509f.m18692a().m18699a(f);
    }

    public static synchronized void m18707a(int i, int i2) {
        synchronized (C4512h.class) {
            if (i2 < ViewCompat.MEASURED_SIZE_MASK) {
                C4511a.f15508a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                C4302b.m17654d("stats key should less than 16777215");
            }
        }
    }

    public static void m18708a(int i, int i2, int i3, String str, int i4) {
        C4455b f = C4509f.m18692a().m18703f();
        f.m18411a((byte) i);
        f.m18412a(i2);
        f.m18419b(i3);
        f.m18420b(str);
        f.m18424c(i4);
        C4509f.m18692a().m18699a(f);
    }

    public static synchronized void m18709a(int i, int i2, String str, int i3) {
        synchronized (C4512h.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (C4511a.f15508a.containsKey(Integer.valueOf(i4))) {
                C4455b f = C4509f.m18692a().m18703f();
                f.m18412a(i2);
                f.m18419b((int) (currentTimeMillis - ((Long) C4511a.f15508a.get(Integer.valueOf(i4))).longValue()));
                f.m18420b(str);
                if (i3 > -1) {
                    f.m18424c(i3);
                }
                C4509f.m18692a().m18699a(f);
                C4511a.f15508a.remove(Integer.valueOf(i2));
            } else {
                C4302b.m17654d("stats key not found");
            }
        }
    }

    public static void m18710a(XMPushService xMPushService, C4448b c4448b) {
        new C4502a(xMPushService, c4448b).m18674a();
    }

    public static void m18711a(String str, int i, Exception exception) {
        C4455b f = C4509f.m18692a().m18703f();
        if (i > 0) {
            f.m18412a(C4452a.GSLB_REQUEST_SUCCESS.m18407a());
            f.m18420b(str);
            f.m18419b(i);
            C4509f.m18692a().m18699a(f);
            return;
        }
        try {
            C4505a a = C4506d.m18678a(exception);
            f.m18412a(a.f15489a.m18407a());
            f.m18425c(a.f15490b);
            f.m18420b(str);
            C4509f.m18692a().m18699a(f);
        } catch (NullPointerException e) {
        }
    }

    public static void m18712a(String str, Exception exception) {
        try {
            C4505a b = C4506d.m18679b(exception);
            C4455b f = C4509f.m18692a().m18703f();
            f.m18412a(b.f15489a.m18407a());
            f.m18425c(b.f15490b);
            f.m18420b(str);
            C4509f.m18692a().m18699a(f);
        } catch (NullPointerException e) {
        }
    }

    public static void m18713b() {
        C4512h.m18709a(0, f15509a, null, -1);
    }

    public static void m18714b(String str, Exception exception) {
        try {
            C4505a d = C4506d.m18681d(exception);
            C4455b f = C4509f.m18692a().m18703f();
            f.m18412a(d.f15489a.m18407a());
            f.m18425c(d.f15490b);
            f.m18420b(str);
            C4509f.m18692a().m18699a(f);
        } catch (NullPointerException e) {
        }
    }

    public static String m18715c() {
        C4454a e = C4509f.m18692a().m18702e();
        if (e == null) {
            return null;
        }
        byte[] a = ae.m18793a(e);
        return a != null ? new String(C4326a.m17734a(a)) : null;
    }
}
