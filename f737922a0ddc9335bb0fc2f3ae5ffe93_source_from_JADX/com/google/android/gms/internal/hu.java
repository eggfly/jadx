package com.google.android.gms.internal;

import com.google.android.gms.internal.aa.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class hu implements cl {
    private static int Hw;
    protected static final boolean j6;
    private static int v5;
    protected final id DW;
    protected final hz FH;

    static {
        j6 = hq.DW;
        Hw = 3000;
        v5 = 4096;
    }

    public hu(id idVar) {
        this(idVar, new hz(v5));
    }

    public hu(id idVar, hz hzVar) {
        this.DW = idVar;
        this.FH = hzVar;
    }

    protected static Map<String, String> j6(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void j6(long j, es<?> esVar, byte[] bArr, StatusLine statusLine) {
        if (j6 || j > ((long) Hw)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = esVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(esVar.j3().DW());
            hq.DW(str, objArr);
        }
    }

    private static void j6(String str, es<?> esVar, hp hpVar) {
        gu j3 = esVar.j3();
        int aM = esVar.aM();
        try {
            j3.j6(hpVar);
            esVar.DW(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(aM)}));
        } catch (hp e) {
            esVar.DW(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(aM)}));
            throw e;
        }
    }

    private void j6(Map<String, String> map, a aVar) {
        if (aVar != null) {
            if (aVar.DW != null) {
                map.put("If-None-Match", aVar.DW);
            }
            if (aVar.Hw > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(aVar.Hw)));
            }
        }
    }

    private byte[] j6(HttpEntity httpEntity) {
        b bVar = new b(this.FH, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new he();
            }
            bArr = this.FH.j6(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                bVar.write(bArr, 0, read);
            }
            byte[] toByteArray = bVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                hq.j6("Error occured when calling consumingContent", new Object[0]);
            }
            this.FH.j6(bArr);
            bVar.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ef j6(com.google.android.gms.internal.es<?> r19) {
        /*
        r18 = this;
        r16 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r14 = 0;
        r6 = java.util.Collections.emptyMap();
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r4 = r19.v5();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r0 = r18;
        r0.j6(r2, r4);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r0 = r18;
        r4 = r0.DW;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r0 = r19;
        r15 = r4.j6(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x00e5 }
        r12 = r15.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r4 = r12.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r2 = r15.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r6 = j6(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r2) goto L_0x0065;
    L_0x0036:
        r2 = r19.v5();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        if (r2 != 0) goto L_0x004c;
    L_0x003c:
        r3 = new com.google.android.gms.internal.ef;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r4 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r5 = 0;
        r7 = 1;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
    L_0x004b:
        return r3;
    L_0x004c:
        r3 = r2.VH;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r3.putAll(r6);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r7 = new com.google.android.gms.internal.ef;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r8 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r9 = r2.j6;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r10 = r2.VH;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r11 = 1;
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r12 = r2 - r16;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r3 = r7;
        goto L_0x004b;
    L_0x0065:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        if (r2 == 0) goto L_0x00a0;
    L_0x006b:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        r0 = r18;
        r11 = r0.j6(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
    L_0x0075:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        r8 = r2 - r16;
        r7 = r18;
        r10 = r19;
        r7.j6(r8, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 < r2) goto L_0x008a;
    L_0x0086:
        r2 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r4 <= r2) goto L_0x00a4;
    L_0x008a:
        r2 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
    L_0x0090:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.google.android.gms.internal.hm;
        r3.<init>();
        r0 = r19;
        j6(r2, r0, r3);
        goto L_0x0004;
    L_0x00a0:
        r2 = 0;
        r11 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0140 }
        goto L_0x0075;
    L_0x00a4:
        r3 = new com.google.android.gms.internal.ef;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        r8 = r8 - r16;
        r5 = r11;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b2, MalformedURLException -> 0x00c2, IOException -> 0x0144 }
        goto L_0x004b;
    L_0x00b2:
        r2 = move-exception;
        r2 = "connection";
        r3 = new com.google.android.gms.internal.hm;
        r3.<init>();
        r0 = r19;
        j6(r2, r0, r3);
        goto L_0x0004;
    L_0x00c2:
        r2 = move-exception;
        r3 = r2;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r19.FH();
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x00df;
    L_0x00d7:
        r2 = r5.concat(r2);
    L_0x00db:
        r4.<init>(r2, r3);
        throw r4;
    L_0x00df:
        r2 = new java.lang.String;
        r2.<init>(r5);
        goto L_0x00db;
    L_0x00e5:
        r2 = move-exception;
        r5 = r14;
    L_0x00e7:
        if (r3 == 0) goto L_0x012d;
    L_0x00e9:
        r2 = r3.getStatusLine();
        r4 = r2.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r7] = r8;
        r7 = 1;
        r8 = r19.FH();
        r3[r7] = r8;
        com.google.android.gms.internal.hq.FH(r2, r3);
        if (r5 == 0) goto L_0x0139;
    L_0x010a:
        r3 = new com.google.android.gms.internal.ef;
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);
        r2 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r2) goto L_0x011e;
    L_0x011a:
        r2 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r4 != r2) goto L_0x0133;
    L_0x011e:
        r2 = "auth";
        r4 = new com.google.android.gms.internal.a;
        r4.<init>(r3);
        r0 = r19;
        j6(r2, r0, r4);
        goto L_0x0004;
    L_0x012d:
        r3 = new com.google.android.gms.internal.ej;
        r3.<init>(r2);
        throw r3;
    L_0x0133:
        r2 = new com.google.android.gms.internal.he;
        r2.<init>(r3);
        throw r2;
    L_0x0139:
        r2 = new com.google.android.gms.internal.dq;
        r3 = 0;
        r2.<init>(r3);
        throw r2;
    L_0x0140:
        r2 = move-exception;
        r5 = r14;
        r3 = r15;
        goto L_0x00e7;
    L_0x0144:
        r2 = move-exception;
        r5 = r11;
        r3 = r15;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.hu.j6(com.google.android.gms.internal.es):com.google.android.gms.internal.ef");
    }
}
