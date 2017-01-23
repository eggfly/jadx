package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@gb
/* renamed from: com.google.android.gms.b.cq */
public class cq extends cn {
    private static final Set<String> f10474d;
    private static final DecimalFormat f10475e;
    private File f10476f;
    private boolean f10477g;

    static {
        f10474d = Collections.synchronizedSet(new HashSet());
        f10475e = new DecimalFormat("#,###");
    }

    public cq(ii iiVar) {
        super(iiVar);
        File cacheDir = this.a.getCacheDir();
        if (cacheDir == null) {
            C2972b.m11583d("Context.getCacheDir() returned null");
            return;
        }
        this.f10476f = new File(cacheDir, "admobVideoStreams");
        if (!this.f10476f.isDirectory() && !this.f10476f.mkdirs()) {
            C2972b.m11583d("Could not create preload cache directory at " + this.f10476f.getAbsolutePath());
            this.f10476f = null;
        } else if (!this.f10476f.setReadable(true, false) || !this.f10476f.setExecutable(true, false)) {
            C2972b.m11583d("Could not set cache file permissions at " + this.f10476f.getAbsolutePath());
            this.f10476f = null;
        }
    }

    private File m12089a(File file) {
        return new File(this.f10476f, file.getName() + ".done");
    }

    private static void m12090b(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m12091a(java.lang.String r27) {
        /*
        r26 = this;
        r0 = r26;
        r2 = r0.f10476f;
        if (r2 != 0) goto L_0x0013;
    L_0x0006:
        r2 = 0;
        r3 = "noCacheDir";
        r4 = 0;
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r2, r3, r4);
        r2 = 0;
    L_0x0012:
        return r2;
    L_0x0013:
        r3 = r26.m12093c();
        r2 = com.google.android.gms.p146b.aq.f10301o;
        r2 = r2.m11794c();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r3 <= r2) goto L_0x003d;
    L_0x0025:
        r2 = r26.m12094d();
        if (r2 != 0) goto L_0x0013;
    L_0x002b:
        r2 = "Unable to expire stream cache";
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);
        r2 = 0;
        r3 = "expireFailed";
        r4 = 0;
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r2, r3, r4);
        r2 = 0;
        goto L_0x0012;
    L_0x003d:
        r2 = r26.m12086b(r27);
        r11 = new java.io.File;
        r0 = r26;
        r3 = r0.f10476f;
        r11.<init>(r3, r2);
        r0 = r26;
        r12 = r0.m12089a(r11);
        r2 = r11.isFile();
        if (r2 == 0) goto L_0x0086;
    L_0x0056:
        r2 = r12.isFile();
        if (r2 == 0) goto L_0x0086;
    L_0x005c:
        r2 = r11.length();
        r2 = (int) r2;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Stream cache hit at ";
        r3 = r3.append(r4);
        r0 = r27;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r3);
        r3 = r11.getAbsolutePath();
        r0 = r26;
        r1 = r27;
        r0.m12082a(r1, r3, r2);
        r2 = 1;
        goto L_0x0012;
    L_0x0086:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r26;
        r3 = r0.f10476f;
        r3 = r3.getAbsolutePath();
        r2 = r2.append(r3);
        r0 = r27;
        r2 = r2.append(r0);
        r13 = r2.toString();
        r3 = f10474d;
        monitor-enter(r3);
        r2 = f10474d;	 Catch:{ all -> 0x00d6 }
        r2 = r2.contains(r13);	 Catch:{ all -> 0x00d6 }
        if (r2 == 0) goto L_0x00d9;
    L_0x00ac:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d6 }
        r2.<init>();	 Catch:{ all -> 0x00d6 }
        r4 = "Stream cache already in progress at ";
        r2 = r2.append(r4);	 Catch:{ all -> 0x00d6 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ all -> 0x00d6 }
        r2 = r2.toString();	 Catch:{ all -> 0x00d6 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);	 Catch:{ all -> 0x00d6 }
        r2 = r11.getAbsolutePath();	 Catch:{ all -> 0x00d6 }
        r4 = "inProgress";
        r5 = 0;
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r2, r4, r5);	 Catch:{ all -> 0x00d6 }
        r2 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x00d6 }
        goto L_0x0012;
    L_0x00d6:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00d6 }
        throw r2;
    L_0x00d9:
        r2 = f10474d;	 Catch:{ all -> 0x00d6 }
        r2.add(r13);	 Catch:{ all -> 0x00d6 }
        monitor-exit(r3);	 Catch:{ all -> 0x00d6 }
        r5 = 0;
        r9 = "error";
        r8 = 0;
        r2 = new java.net.URL;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r0 = r27;
        r2.<init>(r0);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = r2.openConnection();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = com.google.android.gms.p146b.aq.f10306t;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.m11794c();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = (java.lang.Integer) r2;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.intValue();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3.setConnectTimeout(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3.setReadTimeout(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r3 instanceof java.net.HttpURLConnection;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        if (r2 == 0) goto L_0x01bb;
    L_0x0104:
        r0 = r3;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r0;
        r2 = r2.getResponseCode();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 < r4) goto L_0x01bb;
    L_0x0110:
        r4 = "badUrl";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r3.<init>();	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r6 = "HTTP request failed. Code: ";
        r3 = r3.append(r6);	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r6 = java.lang.Integer.toString(r2);	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r3 = r3.append(r6);	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r3 = r3.toString();	 Catch:{ IOException -> 0x03e3, RuntimeException -> 0x03cc }
        r6 = new java.io.IOException;	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r7.<init>();	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r8 = "HTTP status code ";
        r7 = r7.append(r8);	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r2 = r7.append(r2);	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r7 = " at ";
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        r6.<init>(r2);	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
        throw r6;	 Catch:{ IOException -> 0x014e, RuntimeException -> 0x03d0 }
    L_0x014e:
        r2 = move-exception;
    L_0x014f:
        r6 = r2 instanceof java.lang.RuntimeException;
        if (r6 == 0) goto L_0x015b;
    L_0x0153:
        r6 = com.google.android.gms.ads.internal.C2968s.m11528h();
        r7 = 1;
        r6.m12941a(r2, r7);
    L_0x015b:
        r5.close();	 Catch:{ IOException -> 0x03c1, NullPointerException -> 0x03c4 }
    L_0x015e:
        r0 = r26;
        r5 = r0.f10477g;
        if (r5 == 0) goto L_0x03a1;
    L_0x0164:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "Preload aborted for URL \"";
        r2 = r2.append(r5);
        r0 = r27;
        r2 = r2.append(r0);
        r5 = "\"";
        r2 = r2.append(r5);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C2972b.m11581c(r2);
    L_0x0182:
        r2 = r11.exists();
        if (r2 == 0) goto L_0x01a8;
    L_0x0188:
        r2 = r11.delete();
        if (r2 != 0) goto L_0x01a8;
    L_0x018e:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "Could not delete partial cache file at ";
        r2 = r2.append(r5);
        r5 = r11.getAbsolutePath();
        r2 = r2.append(r5);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);
    L_0x01a8:
        r2 = r11.getAbsolutePath();
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r2, r4, r3);
        r2 = f10474d;
        r2.remove(r13);
        r2 = 0;
        goto L_0x0012;
    L_0x01bb:
        r6 = r3.getContentLength();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        if (r6 >= 0) goto L_0x01ef;
    L_0x01c1:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.<init>();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = "Stream cache aborted, missing content-length header at ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = "contentLengthMissing";
        r4 = 0;
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r2, r3, r4);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = f10474d;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.remove(r13);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = 0;
        goto L_0x0012;
    L_0x01ef:
        r2 = f10475e;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r14 = (long) r6;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r4 = r2.format(r14);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = com.google.android.gms.p146b.aq.f10302p;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.m11794c();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = (java.lang.Integer) r2;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r14 = r2.intValue();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        if (r6 <= r14) goto L_0x024e;
    L_0x0204:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.<init>();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = "Content length ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = " exceeds limit at ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.<init>();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = "File too big for full file cache. Size: ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r3 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r4 = "sizeExceeded";
        r0 = r26;
        r1 = r27;
        r0.m12084a(r1, r3, r4, r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = f10474d;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.remove(r13);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = 0;
        goto L_0x0012;
    L_0x024e:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2.<init>();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r7 = "Caching ";
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r4 = " bytes from ";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r2 = r3.getInputStream();	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r15 = java.nio.channels.Channels.newChannel(r2);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r10 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r10.<init>(r11);	 Catch:{ IOException -> 0x03de, RuntimeException -> 0x03c7 }
        r16 = r10.getChannel();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r17 = java.nio.ByteBuffer.allocate(r2);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r18 = com.google.android.gms.ads.internal.C2968s.m11529i();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r5 = 0;
        r20 = r18.m13543a();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = com.google.android.gms.p146b.aq.f10305s;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2.m11794c();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = (java.lang.Long) r2;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2.longValue();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r19 = new com.google.android.gms.b.hr;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r0 = r19;
        r0.<init>(r2);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = com.google.android.gms.p146b.aq.f10304r;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2.m11794c();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = (java.lang.Long) r2;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r22 = r2.longValue();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
    L_0x02af:
        r0 = r17;
        r2 = r15.read(r0);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        if (r2 < 0) goto L_0x0353;
    L_0x02b7:
        r5 = r5 + r2;
        if (r5 <= r14) goto L_0x02df;
    L_0x02ba:
        r4 = "sizeExceeded";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2.<init>();	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = "File too big for full file cache. Size: ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = java.lang.Integer.toString(r5);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = r2.toString();	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
        r5 = "stream cache file size limit exceeded";
        r2.<init>(r5);	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
        throw r2;	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
    L_0x02db:
        r2 = move-exception;
        r5 = r10;
        goto L_0x014f;
    L_0x02df:
        r17.flip();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
    L_0x02e2:
        r2 = r16.write(r17);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        if (r2 > 0) goto L_0x02e2;
    L_0x02e8:
        r17.clear();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r18.m13543a();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2 - r20;
        r24 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r24 = r24 * r22;
        r2 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1));
        if (r2 <= 0) goto L_0x0324;
    L_0x02f9:
        r4 = "downloadTimeout";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2.<init>();	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = "Timeout exceeded. Limit: ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = java.lang.Long.toString(r22);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = " sec";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = r2.toString();	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
        r5 = "stream cache time limit exceeded";
        r2.<init>(r5);	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
        throw r2;	 Catch:{ IOException -> 0x02db, RuntimeException -> 0x0320 }
    L_0x0320:
        r2 = move-exception;
        r5 = r10;
        goto L_0x014f;
    L_0x0324:
        r0 = r26;
        r2 = r0.f10477g;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        if (r2 == 0) goto L_0x0339;
    L_0x032a:
        r4 = "externalAbort";
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        r3 = "abort requested";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
        throw r2;	 Catch:{ IOException -> 0x0334, RuntimeException -> 0x03d9 }
    L_0x0334:
        r2 = move-exception;
        r3 = r8;
        r5 = r10;
        goto L_0x014f;
    L_0x0339:
        r2 = r19.m13157a();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        if (r2 == 0) goto L_0x02af;
    L_0x033f:
        r4 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r7 = 0;
        r2 = r26;
        r3 = r27;
        r2.m12083a(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        goto L_0x02af;
    L_0x034d:
        r2 = move-exception;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        goto L_0x014f;
    L_0x0353:
        r10.close();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = 3;
        r2 = com.google.android.gms.ads.internal.util.client.C2972b.m11578a(r2);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        if (r2 == 0) goto L_0x0386;
    L_0x035d:
        r2 = f10475e;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r6 = (long) r5;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2.format(r6);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r3.<init>();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r4 = "Preloaded ";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r3 = " bytes from ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r0 = r27;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r2);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
    L_0x0386:
        r2 = 1;
        r3 = 0;
        r11.setReadable(r2, r3);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        com.google.android.gms.p146b.cq.m12090b(r12);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = r11.getAbsolutePath();	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r0 = r26;
        r1 = r27;
        r0.m12082a(r1, r2, r5);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = f10474d;	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2.remove(r13);	 Catch:{ IOException -> 0x034d, RuntimeException -> 0x03d3 }
        r2 = 1;
        goto L_0x0012;
    L_0x03a1:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Preload failed for URL \"";
        r5 = r5.append(r6);
        r0 = r27;
        r5 = r5.append(r0);
        r6 = "\"";
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r5, r2);
        goto L_0x0182;
    L_0x03c1:
        r5 = move-exception;
        goto L_0x015e;
    L_0x03c4:
        r5 = move-exception;
        goto L_0x015e;
    L_0x03c7:
        r2 = move-exception;
        r3 = r8;
        r4 = r9;
        goto L_0x014f;
    L_0x03cc:
        r2 = move-exception;
        r3 = r8;
        goto L_0x014f;
    L_0x03d0:
        r2 = move-exception;
        goto L_0x014f;
    L_0x03d3:
        r2 = move-exception;
        r3 = r8;
        r4 = r9;
        r5 = r10;
        goto L_0x014f;
    L_0x03d9:
        r2 = move-exception;
        r3 = r8;
        r5 = r10;
        goto L_0x014f;
    L_0x03de:
        r2 = move-exception;
        r3 = r8;
        r4 = r9;
        goto L_0x014f;
    L_0x03e3:
        r2 = move-exception;
        r3 = r8;
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.cq.a(java.lang.String):boolean");
    }

    public void m12092b() {
        this.f10477g = true;
    }

    public int m12093c() {
        int i = 0;
        if (this.f10476f != null) {
            for (File name : this.f10476f.listFiles()) {
                if (!name.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean m12094d() {
        if (this.f10476f == null) {
            return false;
        }
        boolean delete;
        File file = null;
        long j = Long.MAX_VALUE;
        File[] listFiles = this.f10476f.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            long lastModified;
            File file2;
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                lastModified = file3.lastModified();
                if (lastModified < j) {
                    file2 = file3;
                    i++;
                    file = file2;
                    j = lastModified;
                }
            }
            lastModified = j;
            file2 = file;
            i++;
            file = file2;
            j = lastModified;
        }
        if (file != null) {
            delete = file.delete();
            File a = m12089a(file);
            if (a.isFile()) {
                delete &= a.delete();
            }
        } else {
            delete = false;
        }
        return delete;
    }
}
