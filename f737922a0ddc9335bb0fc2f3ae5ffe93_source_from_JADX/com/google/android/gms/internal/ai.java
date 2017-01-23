package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@eh
public class ai {
    private final int DW;
    private final int FH;
    private final ah Hw;
    private final int j6;

    class 1 implements Comparator<com.google.android.gms.internal.al.a> {
        final /* synthetic */ ai j6;

        1(ai aiVar) {
            this.j6 = aiVar;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((com.google.android.gms.internal.al.a) obj, (com.google.android.gms.internal.al.a) obj2);
        }

        public int j6(com.google.android.gms.internal.al.a aVar, com.google.android.gms.internal.al.a aVar2) {
            int i = aVar.FH - aVar2.FH;
            return i != 0 ? i : (int) (aVar.j6 - aVar2.j6);
        }
    }

    static class a {
        Base64OutputStream DW;
        ByteArrayOutputStream j6;

        public a() {
            this.j6 = new ByteArrayOutputStream(4096);
            this.DW = new Base64OutputStream(this.j6, 10);
        }

        public void j6(byte[] bArr) {
            this.DW.write(bArr);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.DW.close();
            } catch (Throwable e) {
                b.DW("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.j6.close();
                byteArrayOutputStream = this.j6.toString();
            } catch (Throwable e2) {
                b.DW("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.j6 = null;
                this.DW = null;
            }
            return byteArrayOutputStream;
        }
    }

    public ai(int i) {
        this.Hw = new ak();
        this.DW = i;
        this.j6 = 6;
        this.FH = 0;
    }

    a j6() {
        return new a();
    }

    String j6(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        a j6 = j6();
        PriorityQueue priorityQueue = new PriorityQueue(this.DW, new 1(this));
        for (String DW : split) {
            String[] DW2 = aj.DW(DW);
            if (DW2.length != 0) {
                al.j6(DW2, this.DW, this.j6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                j6.j6(this.Hw.j6(((com.google.android.gms.internal.al.a) it.next()).DW));
            } catch (Throwable e) {
                b.DW("Error while writing hash to byteStream", e);
            }
        }
        return j6.toString();
    }

    public String j6(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return j6(stringBuffer.toString());
    }
}
