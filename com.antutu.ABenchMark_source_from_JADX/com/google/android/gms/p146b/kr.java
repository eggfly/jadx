package com.google.android.gms.p146b;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.google.android.gms.p146b.C3345w.C3369a;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.android.spdy.SpdyProtocol;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.google.android.gms.b.kr */
public class kr implements dx {
    protected static final boolean f11671a;
    private static int f11672d;
    private static int f11673e;
    protected final kw f11674b;
    protected final ks f11675c;

    static {
        f11671a = ke.f11609b;
        f11672d = 3000;
        f11673e = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
    }

    public kr(kw kwVar) {
        this(kwVar, new ks(f11673e));
    }

    public kr(kw kwVar, ks ksVar) {
        this.f11674b = kwVar;
        this.f11675c = ksVar;
    }

    protected static Map<String, String> m13727a(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void m13728a(long j, it<?> itVar, byte[] bArr, StatusLine statusLine) {
        if (f11671a || j > ((long) f11672d)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = itVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(itVar.m12007s().m11962b());
            ke.m13615b(str, objArr);
        }
    }

    private static void m13729a(String str, it<?> itVar, jz jzVar) {
        ju s = itVar.m12007s();
        int r = itVar.m12006r();
        try {
            s.m11961a(jzVar);
            itVar.m11989b(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
        } catch (jz e) {
            itVar.m11989b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(r)}));
            throw e;
        }
    }

    private void m13730a(Map<String, String> map, C3369a c3369a) {
        if (c3369a != null) {
            if (c3369a.f11747b != null) {
                map.put(HttpRequest.f14563p, c3369a.f11747b);
            }
            if (c3369a.f11749d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c3369a.f11749d)));
            }
        }
    }

    private byte[] m13731a(HttpEntity httpEntity) {
        C3037b c3037b = new C3037b(this.f11675c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new jv();
            }
            bArr = this.f11675c.m13736a((int) IXAdIOUtils.BUFFER_SIZE);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                c3037b.write(bArr, 0, read);
            }
            byte[] toByteArray = c3037b.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                ke.m13613a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f11675c.m13735a(bArr);
            c3037b.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.p146b.gs m13732a(com.google.android.gms.p146b.it<?> r19) {
        /*
        r18 = this;
        r16 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r14 = 0;
        r6 = java.util.Collections.emptyMap();
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r4 = r19.m11994f();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r18;
        r0.m13730a(r2, r4);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r18;
        r4 = r0.f11674b;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r19;
        r15 = r4.m13763a(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r12 = r15.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r4 = r12.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r2 = r15.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r6 = com.google.android.gms.p146b.kr.m13727a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r2) goto L_0x0065;
    L_0x0036:
        r2 = r19.m11994f();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        if (r2 != 0) goto L_0x004c;
    L_0x003c:
        r3 = new com.google.android.gms.b.gs;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r4 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r5 = 0;
        r7 = 1;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
    L_0x004b:
        return r3;
    L_0x004c:
        r3 = r2.f11752g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r3.putAll(r6);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r7 = new com.google.android.gms.b.gs;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r8 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r9 = r2.f11746a;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r10 = r2.f11752g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r11 = 1;
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r12 = r2 - r16;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r3 = r7;
        goto L_0x004b;
    L_0x0065:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        if (r2 == 0) goto L_0x009f;
    L_0x006b:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        r0 = r18;
        r11 = r0.m13731a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
    L_0x0075:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r8 = r2 - r16;
        r7 = r18;
        r10 = r19;
        r7.m13728a(r8, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 < r2) goto L_0x008a;
    L_0x0086:
        r2 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r4 <= r2) goto L_0x00a3;
    L_0x008a:
        r2 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
    L_0x0090:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.google.android.gms.b.jy;
        r3.<init>();
        r0 = r19;
        com.google.android.gms.p146b.kr.m13729a(r2, r0, r3);
        goto L_0x0004;
    L_0x009f:
        r2 = 0;
        r11 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        goto L_0x0075;
    L_0x00a3:
        r3 = new com.google.android.gms.b.gs;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        r8 = r8 - r16;
        r5 = r11;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        goto L_0x004b;
    L_0x00b1:
        r2 = move-exception;
        r2 = "connection";
        r3 = new com.google.android.gms.b.jy;
        r3.<init>();
        r0 = r19;
        com.google.android.gms.p146b.kr.m13729a(r2, r0, r3);
        goto L_0x0004;
    L_0x00c0:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Bad URL ";
        r4 = r4.append(r5);
        r5 = r19.m11992d();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4, r2);
        throw r3;
    L_0x00de:
        r2 = move-exception;
        r5 = r14;
    L_0x00e0:
        r7 = 0;
        if (r3 == 0) goto L_0x0125;
    L_0x00e3:
        r2 = r3.getStatusLine();
        r4 = r2.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r4);
        r3[r8] = r9;
        r8 = 1;
        r9 = r19.m11992d();
        r3[r8] = r9;
        com.google.android.gms.p146b.ke.m13616c(r2, r3);
        if (r5 == 0) goto L_0x0131;
    L_0x0103:
        r3 = new com.google.android.gms.b.gs;
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);
        r2 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r2) goto L_0x0117;
    L_0x0113:
        r2 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r4 != r2) goto L_0x012b;
    L_0x0117:
        r2 = "auth";
        r4 = new com.google.android.gms.b.a;
        r4.<init>(r3);
        r0 = r19;
        com.google.android.gms.p146b.kr.m13729a(r2, r0, r4);
        goto L_0x0004;
    L_0x0125:
        r3 = new com.google.android.gms.b.hs;
        r3.<init>(r2);
        throw r3;
    L_0x012b:
        r2 = new com.google.android.gms.b.jv;
        r2.<init>(r3);
        throw r2;
    L_0x0131:
        r2 = new com.google.android.gms.b.fz;
        r2.<init>(r7);
        throw r2;
    L_0x0137:
        r2 = move-exception;
        r5 = r14;
        r3 = r15;
        goto L_0x00e0;
    L_0x013b:
        r2 = move-exception;
        r5 = r11;
        r3 = r15;
        goto L_0x00e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.kr.a(com.google.android.gms.b.it):com.google.android.gms.b.gs");
    }
}
