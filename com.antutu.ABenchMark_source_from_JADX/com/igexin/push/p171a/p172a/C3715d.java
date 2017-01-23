package com.igexin.push.p171a.p172a;

import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.push.p169f.p170b.C3711d;

/* renamed from: com.igexin.push.a.a.d */
public class C3715d implements C3711d {
    private static final String f12528a;
    private long f12529b;
    private long f12530c;

    static {
        f12528a = C3715d.class.getName();
    }

    public C3715d() {
        this.f12529b = 0;
        this.f12530c = 0;
    }

    private void m15223c() {
        C3685c.m15060b().m15053a(new C3717e(this, null), false, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15224a() {
        /*
        r15 = this;
        r6 = 0;
        r12 = 0;
        r10 = 0;
        r8 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r0 = com.igexin.push.core.C3855g.f12976n;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        if (r0 == 0) goto L_0x000f;
    L_0x000c:
        r12 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
    L_0x000f:
        r0 = com.igexin.push.core.C3855g.f12971i;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r10 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
    L_0x0016:
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r1 = "yyyy-MM-dd";
        r2 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r1 = new java.util.Date;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r1.<init>();	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r7 = r0.format(r1);	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r0 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r0 = r0.m15881k();	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r1 = "bi";
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r3 = 0;
        r4 = "type";
        r2[r3] = r4;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r4 = 0;
        r5 = "1";
        r3[r4] = r5;	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        r4 = 0;
        r5 = 0;
        r6 = r0.m15242a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0201, all -> 0x01fa }
        if (r6 == 0) goto L_0x0097;
    L_0x004c:
        r0 = r6.getCount();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        if (r0 != 0) goto L_0x0204;
    L_0x0052:
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r0.<init>();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r2 = 0;
        r1 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r1 == 0) goto L_0x0066;
    L_0x005d:
        r1 = "online_time";
        r2 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x0066:
        r2 = 0;
        r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r1 == 0) goto L_0x0075;
    L_0x006c:
        r1 = "network_time";
        r2 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x0075:
        r1 = "running_time";
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r1 = "create_time";
        r0.put(r1, r7);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r1 = "type";
        r2 = "1";
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r1 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r1 = r1.m15881k();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r2 = "bi";
        r1.m15243a(r2, r0);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x0097:
        if (r6 == 0) goto L_0x009c;
    L_0x0099:
        r6.close();
    L_0x009c:
        r0 = java.lang.System.currentTimeMillis();
        r2 = com.igexin.push.core.C3855g.f12948L;
        r0 = r0 - r2;
        r2 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r0 = r0 - r2;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00da;
    L_0x00ad:
        r0 = com.igexin.push.core.p176a.C3777e.m15491a();
        r1 = 0;
        r2 = 0;
        r0 = r0.m15510a(r1, r2);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00da;
    L_0x00bd:
        r1 = new com.igexin.push.core.c.j;
        r2 = com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl();
        r0 = r0.getBytes();
        r3 = 0;
        r4 = 1;
        r1.<init>(r2, r0, r3, r4);
        r0 = com.igexin.p158b.p159a.p161b.C3685c.m15060b();
        r2 = new com.igexin.push.f.a.c;
        r2.<init>(r1);
        r1 = 0;
        r3 = 1;
        r0.m15053a(r2, r1, r3);
    L_0x00da:
        r0 = com.igexin.push.config.C3754m.f12680x;
        if (r0 == 0) goto L_0x00f5;
    L_0x00de:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r15.f12530c;
        r0 = r0 - r2;
        r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x00f5;
    L_0x00ec:
        r15.m15223c();
        r0 = java.lang.System.currentTimeMillis();
        r15.f12530c = r0;
    L_0x00f5:
        return;
    L_0x00f6:
        r8 = r6.moveToNext();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        if (r8 == 0) goto L_0x0097;
    L_0x00fc:
        r8 = "create_time";
        r8 = r6.getColumnIndexOrThrow(r8);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8 = r6.getString(r8);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = "id";
        r9 = r6.getColumnIndexOrThrow(r9);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = r6.getString(r9);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8 = r7.equals(r8);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        if (r8 == 0) goto L_0x018c;
    L_0x0116:
        r8 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.<init>();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = 0;
        r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r10 == 0) goto L_0x0136;
    L_0x0121:
        r10 = "online_time";
        r10 = r6.getColumnIndexOrThrow(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = r6.getInt(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = (long) r10;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r4 = r4 + r10;
        r10 = "online_time";
        r11 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r10, r11);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x0136:
        r10 = 0;
        r10 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r10 == 0) goto L_0x0151;
    L_0x013c:
        r10 = "network_time";
        r10 = r6.getColumnIndexOrThrow(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = r6.getInt(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = (long) r10;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r2 = r2 + r10;
        r10 = "network_time";
        r11 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r10, r11);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x0151:
        r10 = "running_time";
        r10 = r6.getColumnIndexOrThrow(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = r6.getInt(r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = (long) r10;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r0 = r0 + r10;
        r10 = "running_time";
        r11 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r10, r11);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = r10.m15881k();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r11 = "bi";
        r12 = 1;
        r12 = new java.lang.String[r12];	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r13 = 0;
        r14 = "id";
        r12[r13] = r14;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r13 = 1;
        r13 = new java.lang.String[r13];	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r14 = 0;
        r13[r14] = r9;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10.m15244a(r11, r8, r12, r13);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        goto L_0x00f6;
    L_0x0183:
        r0 = move-exception;
        r0 = r6;
    L_0x0185:
        if (r0 == 0) goto L_0x009c;
    L_0x0187:
        r0.close();
        goto L_0x009c;
    L_0x018c:
        r8 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.<init>();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = "type";
        r11 = "2";
        r8.put(r10, r11);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = r10.m15881k();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r11 = "bi";
        r12 = 1;
        r12 = new java.lang.String[r12];	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r13 = 0;
        r14 = "id";
        r12[r13] = r14;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r13 = 1;
        r13 = new java.lang.String[r13];	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r14 = 0;
        r13[r14] = r9;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10.m15244a(r11, r8, r12, r13);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.<init>();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = 0;
        r9 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x01c7;
    L_0x01be:
        r9 = "online_time";
        r10 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r9, r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x01c7:
        r10 = 0;
        r9 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x01d6;
    L_0x01cd:
        r9 = "network_time";
        r10 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r9, r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
    L_0x01d6:
        r9 = "running_time";
        r10 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r8.put(r9, r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = "create_time";
        r8.put(r9, r7);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = "type";
        r10 = "1";
        r8.put(r9, r10);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r9 = r9.m15881k();	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        r10 = "bi";
        r9.m15243a(r10, r8);	 Catch:{ Exception -> 0x0183, all -> 0x01fa }
        goto L_0x00f6;
    L_0x01fa:
        r0 = move-exception;
        if (r6 == 0) goto L_0x0200;
    L_0x01fd:
        r6.close();
    L_0x0200:
        throw r0;
    L_0x0201:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0185;
    L_0x0204:
        r0 = r8;
        r2 = r10;
        r4 = r12;
        goto L_0x00f6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.a.a.d.a():void");
    }

    public void m15225a(long j) {
        this.f12529b = j;
    }

    public boolean m15226b() {
        return System.currentTimeMillis() - this.f12529b > 1800000;
    }
}
