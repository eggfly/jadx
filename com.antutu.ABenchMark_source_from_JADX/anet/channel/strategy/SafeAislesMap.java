package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import anet.channel.util.LruCache;
import java.io.Serializable;
import org.android.spdy.SpdyProtocol;

class SafeAislesMap implements Serializable {
    public static final String NO_RESULT = "No_Result";
    private LruCache<String, String> f2311a;

    SafeAislesMap() {
        this.f2311a = null;
        m2875a();
    }

    String m2874a(String str) {
        if (TextUtils.isEmpty(str) || !C0734n.m2958f(str)) {
            return NO_RESULT;
        }
        String str2;
        synchronized (this.f2311a) {
            str2 = (String) this.f2311a.get(str);
            if (str2 == null) {
                this.f2311a.put(str, NO_RESULT);
            }
        }
        return C0734n.m2955c(str) ? (TextUtils.isEmpty(str2) || NO_RESULT.equals(str2)) ? HttpConstant.HTTPS : str2 : str2;
    }

    void m2875a() {
        if (this.f2311a == null) {
            this.f2311a = new LruCache(SpdyProtocol.SLIGHTSSLV2);
        }
        this.f2311a.put(C0734n.m2950a(), HttpConstant.HTTPS);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m2876a(anet.channel.strategy.C0731k.C0730c r10) {
        /*
        r9 = this;
        r1 = 1;
        r3 = 0;
        r0 = r10.f2408c;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r4 = r9.f2311a;
        monitor-enter(r4);
        r2 = r3;
        r0 = r3;
    L_0x000c:
        r5 = r10.f2408c;	 Catch:{ all -> 0x005a }
        r5 = r5.length;	 Catch:{ all -> 0x005a }
        if (r2 >= r5) goto L_0x005d;
    L_0x0011:
        r5 = r10.f2408c;	 Catch:{ all -> 0x005a }
        r5 = r5[r2];	 Catch:{ all -> 0x005a }
        r6 = r5.f2401m;	 Catch:{ all -> 0x005a }
        if (r6 == 0) goto L_0x0023;
    L_0x0019:
        r6 = r9.f2311a;	 Catch:{ all -> 0x005a }
        r5 = r5.f2389a;	 Catch:{ all -> 0x005a }
        r6.remove(r5);	 Catch:{ all -> 0x005a }
    L_0x0020:
        r2 = r2 + 1;
        goto L_0x000c;
    L_0x0023:
        r6 = r5.f2403o;	 Catch:{ all -> 0x005a }
        if (r6 != 0) goto L_0x0020;
    L_0x0027:
        r6 = "http";
        r7 = r5.f2391c;	 Catch:{ all -> 0x005a }
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ all -> 0x005a }
        if (r6 != 0) goto L_0x0050;
    L_0x0031:
        r6 = "https";
        r7 = r5.f2391c;	 Catch:{ all -> 0x005a }
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ all -> 0x005a }
        if (r6 != 0) goto L_0x0050;
    L_0x003b:
        r6 = r9.f2311a;	 Catch:{ all -> 0x005a }
        r7 = r5.f2389a;	 Catch:{ all -> 0x005a }
        r8 = "No_Result";
        r6.put(r7, r8);	 Catch:{ all -> 0x005a }
    L_0x0044:
        if (r0 != 0) goto L_0x0020;
    L_0x0046:
        r5 = r5.f2389a;	 Catch:{ all -> 0x005a }
        r5 = anet.channel.strategy.C0734n.m2955c(r5);	 Catch:{ all -> 0x005a }
        if (r5 == 0) goto L_0x0020;
    L_0x004e:
        r0 = r1;
        goto L_0x0020;
    L_0x0050:
        r6 = r9.f2311a;	 Catch:{ all -> 0x005a }
        r7 = r5.f2389a;	 Catch:{ all -> 0x005a }
        r8 = r5.f2391c;	 Catch:{ all -> 0x005a }
        r6.put(r7, r8);	 Catch:{ all -> 0x005a }
        goto L_0x0044;
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x005d:
        monitor-exit(r4);	 Catch:{ all -> 0x005a }
        r1 = anet.channel.util.ALog.isPrintLog(r1);
        if (r1 == 0) goto L_0x0070;
    L_0x0064:
        r1 = "awcn.SafeAislesMap";
        r2 = r9.toString();
        r4 = 0;
        r3 = new java.lang.Object[r3];
        anet.channel.util.ALog.m2960d(r1, r2, r4, r3);
    L_0x0070:
        if (r0 == 0) goto L_0x0006;
    L_0x0072:
        r0 = anet.channel.AccsSessionManager.getInstance();
        r0.checkAndStartAccsSession();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.SafeAislesMap.a(anet.channel.strategy.k$c):void");
    }

    void m2877a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && C0734n.m2958f(str)) {
            if (HttpConstant.HTTP.equals(str2) || HttpConstant.HTTPS.equals(str2)) {
                synchronized (this.f2311a) {
                    this.f2311a.put(str, str2);
                }
            }
        }
    }

    public String toString() {
        String str;
        synchronized (this.f2311a) {
            str = "SafeAislesMap: " + this.f2311a.toString();
        }
        return str;
    }
}
