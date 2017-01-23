package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import java.util.PriorityQueue;

@eh
public class al {

    public static class a {
        final String DW;
        final int FH;
        final long j6;

        a(long j, String str, int i) {
            this.j6 = j;
            this.DW = str;
            this.FH = i;
        }

        public boolean equals(Object obj) {
            return (obj == null || !(obj instanceof a)) ? false : ((a) obj).j6 == this.j6 && ((a) obj).FH == this.FH;
        }

        public int hashCode() {
            return (int) this.j6;
        }
    }

    private static long DW(String[] strArr, int i, int i2) {
        long j6 = (((long) aj.j6(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            j6 = (((j6 * 16785407) % 1073807359) + ((((long) aj.j6(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return j6;
    }

    static long j6(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long j6(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? j6((j * j) % 1073807359, i / 2) % 1073807359 : ((j6((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String j6(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            b.DW("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void j6(int i, long j, String str, int i2, PriorityQueue<a> priorityQueue) {
        a aVar = new a(j, str, i2);
        if ((priorityQueue.size() != i || (((a) priorityQueue.peek()).FH <= aVar.FH && ((a) priorityQueue.peek()).j6 <= aVar.j6)) && !priorityQueue.contains(aVar)) {
            priorityQueue.add(aVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void j6(String[] strArr, int i, int i2, PriorityQueue<a> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            j6(i3, DW(strArr, 0, strArr.length), j6(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long DW = DW(strArr, 0, i2);
        j6(i, DW, j6(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long j6 = j6(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long j62 = j6(aj.j6(strArr[i4 - 1]), aj.j6(strArr[(i4 + i2) - 1]), DW, j6, 16785407);
            j6(i, j62, j6(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            DW = j62;
        }
    }
}
