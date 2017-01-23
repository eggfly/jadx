package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.PriorityQueue;

@gb
/* renamed from: com.google.android.gms.b.ah */
public class ah {

    /* renamed from: com.google.android.gms.b.ah.a */
    public static class C3025a {
        final long f10244a;
        final String f10245b;
        final int f10246c;

        C3025a(long j, String str, int i) {
            this.f10244a = j;
            this.f10245b = str;
            this.f10246c = i;
        }

        public boolean equals(Object obj) {
            return (obj == null || !(obj instanceof C3025a)) ? false : ((C3025a) obj).f10244a == this.f10244a && ((C3025a) obj).f10246c == this.f10246c;
        }

        public int hashCode() {
            return (int) this.f10244a;
        }
    }

    static long m11769a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m11770a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? ah.m11770a((j * j) % 1073807359, i / 2) % 1073807359 : ((ah.m11770a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m11771a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            C2972b.m11579b("Unable to construct shingle");
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m11772a(int i, long j, String str, int i2, PriorityQueue<C3025a> priorityQueue) {
        C3025a c3025a = new C3025a(j, str, i2);
        if ((priorityQueue.size() != i || ((C3025a) priorityQueue.peek()).f10244a <= c3025a.f10244a) && !priorityQueue.contains(c3025a)) {
            priorityQueue.add(c3025a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m11773a(String[] strArr, int i, int i2, PriorityQueue<C3025a> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            ah.m11772a(i3, ah.m11774b(strArr, 0, strArr.length), ah.m11771a(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long b = ah.m11774b(strArr, 0, i2);
        ah.m11772a(i, b, ah.m11771a(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long a = ah.m11770a(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long a2 = ah.m11769a(af.m11761a(strArr[i4 - 1]), af.m11761a(strArr[(i4 + i2) - 1]), b, a, 16785407);
            ah.m11772a(i, a2, ah.m11771a(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            b = a2;
        }
    }

    private static long m11774b(String[] strArr, int i, int i2) {
        long a = (((long) af.m11761a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) af.m11761a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
