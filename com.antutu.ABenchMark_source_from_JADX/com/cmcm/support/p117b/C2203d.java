package com.cmcm.support.p117b;

/* renamed from: com.cmcm.support.b.d */
public class C2203d implements C2201b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m8277a(java.io.InputStream r6) {
        /*
        r3 = "";
        r0 = "";
        r0 = 0;
        r2 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0045, all -> 0x0051 }
        r4 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0045, all -> 0x0051 }
        r4.<init>(r6);	 Catch:{ Throwable -> 0x0045, all -> 0x0051 }
        r1.<init>(r4);	 Catch:{ Throwable -> 0x0045, all -> 0x0051 }
        r2 = r3;
        r3 = r0;
    L_0x0012:
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        if (r0 == 0) goto L_0x0066;
    L_0x0018:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r4.<init>();	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r0 = r4.append(r0);	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r2 = r0.toString();	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r0.<init>();	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r4 = "\r\n";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0060, all -> 0x005b }
        r2 = r3 + 1;
        r3 = 4;
        if (r2 <= r3) goto L_0x0068;
    L_0x0041:
        r1.close();	 Catch:{ Throwable -> 0x0057 }
    L_0x0044:
        return r0;
    L_0x0045:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
    L_0x0048:
        r1.printStackTrace();	 Catch:{ all -> 0x005d }
        r2.close();	 Catch:{ Throwable -> 0x004f }
        goto L_0x0044;
    L_0x004f:
        r1 = move-exception;
        goto L_0x0044;
    L_0x0051:
        r0 = move-exception;
        r1 = r2;
    L_0x0053:
        r1.close();	 Catch:{ Throwable -> 0x0059 }
    L_0x0056:
        throw r0;
    L_0x0057:
        r1 = move-exception;
        goto L_0x0044;
    L_0x0059:
        r1 = move-exception;
        goto L_0x0056;
    L_0x005b:
        r0 = move-exception;
        goto L_0x0053;
    L_0x005d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0053;
    L_0x0060:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x0048;
    L_0x0066:
        r0 = r2;
        goto L_0x0041;
    L_0x0068:
        r3 = r2;
        r2 = r0;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcm.support.b.d.a(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m8278a(com.cmcm.support.p117b.C2202c r13, java.lang.String r14, com.cmcm.support.p117b.C2201b.C2200a r15) {
        /*
        r12 = this;
        r6 = 0;
        r1 = 1;
        r3 = 0;
        r7 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0076, all -> 0x00bb }
        r0.<init>(r14);	 Catch:{ Exception -> 0x0076, all -> 0x00bb }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0076, all -> 0x00bb }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0076, all -> 0x00bb }
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x010c, all -> 0x00f5 }
        r2 = 1;
        r0.setDoInput(r2);	 Catch:{ Exception -> 0x010c, all -> 0x00f5 }
        r2 = "POST";
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x010c, all -> 0x00f5 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x010c, all -> 0x00f5 }
        r4.<init>();	 Catch:{ Exception -> 0x010c, all -> 0x00f5 }
        r2 = r13.m8275c();	 Catch:{ Exception -> 0x0114, all -> 0x00fc }
        r5 = 0;
        r8 = r2.length;	 Catch:{ Exception -> 0x0114, all -> 0x00fc }
        r4.write(r2, r5, r8);	 Catch:{ Exception -> 0x0114, all -> 0x00fc }
        r5 = r0.getOutputStream();	 Catch:{ Exception -> 0x0114, all -> 0x00fc }
        r4.writeTo(r5);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r2 = r0.getInputStream();	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r2 = com.cmcm.support.p117b.C2203d.m8277a(r2);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r2 = com.cmcm.support.p117b.C2199a.m8265a(r2);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        if (r2 == 0) goto L_0x0134;
    L_0x003f:
        r8 = r2.f7594b;	 Catch:{ Exception -> 0x0124, all -> 0x0102 }
        if (r8 != r1) goto L_0x0134;
    L_0x0043:
        if (r0 == 0) goto L_0x0048;
    L_0x0045:
        r0.disconnect();
    L_0x0048:
        if (r5 == 0) goto L_0x004d;
    L_0x004a:
        r5.close();	 Catch:{ IOException -> 0x0066 }
    L_0x004d:
        if (r4 == 0) goto L_0x0052;
    L_0x004f:
        r4.close();	 Catch:{ IOException -> 0x006b }
    L_0x0052:
        if (r3 == 0) goto L_0x0131;
    L_0x0054:
        r7.close();	 Catch:{ IOException -> 0x0070 }
        r0 = r1;
    L_0x0058:
        if (r15 == 0) goto L_0x0065;
    L_0x005a:
        if (r0 == 0) goto L_0x00e3;
    L_0x005c:
        if (r2 == 0) goto L_0x00e3;
    L_0x005e:
        r4 = r2.f7593a;
        r1 = r2.f7595c;
        r15.m8266a(r4, r1, r13);
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x004d;
    L_0x006b:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0052;
    L_0x0070:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0058;
    L_0x0076:
        r0 = move-exception;
        r1 = r3;
        r2 = r3;
        r4 = r3;
        r5 = r3;
    L_0x007b:
        r8 = "KHttpPoster";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r9.<init>();	 Catch:{ all -> 0x0107 }
        r10 = "Exception => ";
        r9 = r9.append(r10);	 Catch:{ all -> 0x0107 }
        r0 = r9.append(r0);	 Catch:{ all -> 0x0107 }
        r0 = r0.toString();	 Catch:{ all -> 0x0107 }
        android.util.Log.e(r8, r0);	 Catch:{ all -> 0x0107 }
        if (r5 == 0) goto L_0x0098;
    L_0x0095:
        r5.disconnect();
    L_0x0098:
        if (r4 == 0) goto L_0x009d;
    L_0x009a:
        r4.close();	 Catch:{ IOException -> 0x00aa }
    L_0x009d:
        if (r2 == 0) goto L_0x00a2;
    L_0x009f:
        r2.close();	 Catch:{ IOException -> 0x00af }
    L_0x00a2:
        if (r3 == 0) goto L_0x012d;
    L_0x00a4:
        r7.close();	 Catch:{ IOException -> 0x00b4 }
        r0 = r6;
        r2 = r1;
        goto L_0x0058;
    L_0x00aa:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009d;
    L_0x00af:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00a2;
    L_0x00b4:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r6;
        r2 = r1;
        goto L_0x0058;
    L_0x00bb:
        r0 = move-exception;
        r4 = r3;
        r5 = r3;
        r1 = r3;
    L_0x00bf:
        if (r1 == 0) goto L_0x00c4;
    L_0x00c1:
        r1.disconnect();
    L_0x00c4:
        if (r5 == 0) goto L_0x00c9;
    L_0x00c6:
        r5.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x00c9:
        if (r4 == 0) goto L_0x00ce;
    L_0x00cb:
        r4.close();	 Catch:{ IOException -> 0x00d9 }
    L_0x00ce:
        if (r3 == 0) goto L_0x00d3;
    L_0x00d0:
        r7.close();	 Catch:{ IOException -> 0x00de }
    L_0x00d3:
        throw r0;
    L_0x00d4:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c9;
    L_0x00d9:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ce;
    L_0x00de:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d3;
    L_0x00e3:
        if (r2 == 0) goto L_0x00ee;
    L_0x00e5:
        r4 = r2.f7593a;
        r1 = r2.f7595c;
        r15.m8267b(r4, r1, r13);
        goto L_0x0065;
    L_0x00ee:
        r4 = 0;
        r15.m8267b(r4, r3, r13);
        goto L_0x0065;
    L_0x00f5:
        r1 = move-exception;
        r4 = r3;
        r5 = r3;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00bf;
    L_0x00fc:
        r1 = move-exception;
        r5 = r3;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00bf;
    L_0x0102:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00bf;
    L_0x0107:
        r0 = move-exception;
        r1 = r5;
        r5 = r4;
        r4 = r2;
        goto L_0x00bf;
    L_0x010c:
        r1 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r0;
        r0 = r1;
        r1 = r3;
        goto L_0x007b;
    L_0x0114:
        r1 = move-exception;
        r2 = r4;
        r5 = r0;
        r0 = r1;
        r4 = r3;
        r1 = r3;
        goto L_0x007b;
    L_0x011c:
        r1 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r0;
        r0 = r1;
        r1 = r3;
        goto L_0x007b;
    L_0x0124:
        r1 = move-exception;
        r11 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r5;
        r5 = r0;
        r0 = r11;
        goto L_0x007b;
    L_0x012d:
        r0 = r6;
        r2 = r1;
        goto L_0x0058;
    L_0x0131:
        r0 = r1;
        goto L_0x0058;
    L_0x0134:
        r1 = r6;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmcm.support.b.d.a(com.cmcm.support.b.c, java.lang.String, com.cmcm.support.b.b$a):boolean");
    }
}
