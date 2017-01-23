package com.igexin.download;

/* renamed from: com.igexin.download.f */
class C3706f extends Thread {
    final /* synthetic */ DownloadService f12510a;

    public C3706f(DownloadService downloadService) {
        this.f12510a = downloadService;
        super("Download Service");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r22 = this;
        r2 = 10;
        android.os.Process.setThreadPriority(r2);
        r4 = 0;
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r10 = r2;
        r12 = r4;
    L_0x000d:
        r0 = r22;
        r3 = r0.f12510a;
        monitor-enter(r3);
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r2 = r2.f12485d;	 Catch:{ all -> 0x0026 }
        r0 = r22;
        if (r2 == r0) goto L_0x0029;
    L_0x001e:
        r2 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0026 }
        r4 = "multiple UpdateThreads in DownloadService";
        r2.<init>(r4);	 Catch:{ all -> 0x0026 }
        throw r2;	 Catch:{ all -> 0x0026 }
    L_0x0026:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r2;
    L_0x0029:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r2 = r2.f12486e;	 Catch:{ all -> 0x0026 }
        if (r2 != 0) goto L_0x009a;
    L_0x0033:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r4 = 0;
        r2.f12485d = r4;	 Catch:{ all -> 0x0026 }
        if (r12 != 0) goto L_0x0044;
    L_0x003d:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r2.stopSelf();	 Catch:{ all -> 0x0026 }
    L_0x0044:
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x005b;
    L_0x004d:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r4 = "alarm";
        r2 = r2.getSystemService(r4);	 Catch:{ all -> 0x0026 }
        r2 = (android.app.AlarmManager) r2;	 Catch:{ all -> 0x0026 }
        if (r2 != 0) goto L_0x006d;
    L_0x005b:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r4 = 0;
        r2.f12490i = r4;	 Catch:{ all -> 0x0026 }
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r4 = 0;
        r2.f12491j = r4;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x006c:
        return;
    L_0x006d:
        r4 = new android.content.Intent;	 Catch:{ all -> 0x0026 }
        r5 = "android.intent.action.GTDOWNLOAD_WAKEUP";
        r4.<init>(r5);	 Catch:{ all -> 0x0026 }
        r0 = r22;
        r5 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r5 = r5.getPackageName();	 Catch:{ all -> 0x0026 }
        r6 = com.igexin.download.DownloadReceiver.class;
        r6 = r6.getName();	 Catch:{ all -> 0x0026 }
        r4.setClassName(r5, r6);	 Catch:{ all -> 0x0026 }
        r5 = 0;
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0026 }
        r6 = r6 + r10;
        r0 = r22;
        r8 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r9 = 0;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = android.app.PendingIntent.getBroadcast(r8, r9, r4, r10);	 Catch:{ all -> 0x0026 }
        r2.set(r5, r6, r4);	 Catch:{ all -> 0x0026 }
        goto L_0x005b;
    L_0x009a:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ all -> 0x0026 }
        r4 = 0;
        r2.f12486e = r4;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        r0 = r22;
        r2 = r0.f12510a;
        r14 = com.igexin.download.C3708h.m15198a(r2);
        r0 = r22;
        r2 = r0.f12510a;
        r15 = com.igexin.download.C3708h.m15204c(r2);
        r8 = java.lang.System.currentTimeMillis();
        r13 = 0;
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x02e8, all -> 0x02e5 }
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x02e8, all -> 0x02e5 }
        r3 = com.igexin.download.Downloads.f12492a;	 Catch:{ Exception -> 0x02e8, all -> 0x02e5 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "_id";
        r4 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x02e8, all -> 0x02e5 }
        if (r4 != 0) goto L_0x00d3;
    L_0x00cd:
        if (r4 == 0) goto L_0x006c;
    L_0x00cf:
        r4.close();
        goto L_0x006c;
    L_0x00d3:
        r4.moveToFirst();	 Catch:{ Exception -> 0x02f1, all -> 0x02de }
        r5 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r3 = r4.isAfterLast();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = "_id";
        r16 = r4.getColumnIndexOrThrow(r2);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
    L_0x00e8:
        if (r3 == 0) goto L_0x00f8;
    L_0x00ea:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.f12484c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.size();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r5 >= r2) goto L_0x0279;
    L_0x00f8:
        if (r3 == 0) goto L_0x010e;
    L_0x00fa:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.m15165b(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        goto L_0x00e8;
    L_0x0102:
        r2 = move-exception;
    L_0x0103:
        if (r4 == 0) goto L_0x02fe;
    L_0x0105:
        r4.close();
        r2 = r12;
        r4 = r11;
    L_0x010a:
        r10 = r2;
        r12 = r4;
        goto L_0x000d;
    L_0x010e:
        r0 = r16;
        r6 = r4.getInt(r0);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.f12484c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.size();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r5 != r2) goto L_0x0183;
    L_0x0122:
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r14;
        r7 = r15;
        r3.m15154a(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15174d(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0314;
    L_0x0135:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15168b();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0149;
    L_0x013f:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15159a(r4, r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 != 0) goto L_0x0314;
    L_0x0149:
        r10 = 1;
        r11 = 1;
        r3 = r10;
    L_0x014c:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15172c(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0157;
    L_0x0156:
        r11 = 1;
    L_0x0157:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r2.m15147a(r5, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 != 0) goto L_0x0177;
    L_0x0165:
        r11 = 1;
        r6 = r12;
        r10 = r11;
    L_0x0168:
        r5 = r5 + 1;
        r4.moveToNext();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
        r2 = r4.isAfterLast();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
    L_0x0171:
        r12 = r6;
        r11 = r10;
        r10 = r3;
        r3 = r2;
        goto L_0x00e8;
    L_0x0177:
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 <= 0) goto L_0x0310;
    L_0x017d:
        r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r2 >= 0) goto L_0x0310;
    L_0x0181:
        r10 = r11;
        goto L_0x0168;
    L_0x0183:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.f12484c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.get(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = (com.igexin.download.DownloadInfo) r2;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.mId;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 >= r6) goto L_0x01bd;
    L_0x0195:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15174d(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x01b1;
    L_0x019f:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15168b();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x01b1;
    L_0x01a9:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = 0;
        r2.m15159a(r6, r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
    L_0x01b1:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.m15165b(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r3;
        r6 = r12;
        r3 = r10;
        r10 = r11;
        goto L_0x0171;
    L_0x01bd:
        if (r2 != r6) goto L_0x021c;
    L_0x01bf:
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r14;
        r7 = r15;
        r3.m15166b(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15174d(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x030d;
    L_0x01d2:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15168b();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x01e6;
    L_0x01dc:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15159a(r4, r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 != 0) goto L_0x030d;
    L_0x01e6:
        r10 = 1;
        r11 = 1;
        r3 = r10;
    L_0x01e9:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15172c(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x01f4;
    L_0x01f3:
        r11 = 1;
    L_0x01f4:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r2.m15147a(r5, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 != 0) goto L_0x0210;
    L_0x0202:
        r11 = 1;
        r6 = r12;
        r10 = r11;
    L_0x0205:
        r5 = r5 + 1;
        r4.moveToNext();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
        r2 = r4.isAfterLast();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
        goto L_0x0171;
    L_0x0210:
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 <= 0) goto L_0x0309;
    L_0x0216:
        r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r2 >= 0) goto L_0x0309;
    L_0x021a:
        r10 = r11;
        goto L_0x0205;
    L_0x021c:
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r14;
        r7 = r15;
        r3.m15154a(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15174d(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0306;
    L_0x022f:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15168b();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0243;
    L_0x0239:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15159a(r4, r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 != 0) goto L_0x0306;
    L_0x0243:
        r10 = 1;
        r11 = 1;
        r3 = r10;
    L_0x0246:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.m15172c(r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0251;
    L_0x0250:
        r11 = 1;
    L_0x0251:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = r2.m15147a(r5, r8);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 != 0) goto L_0x026d;
    L_0x025f:
        r11 = 1;
        r6 = r12;
        r10 = r11;
    L_0x0262:
        r5 = r5 + 1;
        r4.moveToNext();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
        r2 = r4.isAfterLast();	 Catch:{ Exception -> 0x02f9, all -> 0x02de }
        goto L_0x0171;
    L_0x026d:
        r18 = 0;
        r2 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
        if (r2 <= 0) goto L_0x0302;
    L_0x0273:
        r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r2 >= 0) goto L_0x0302;
    L_0x0277:
        r10 = r11;
        goto L_0x0262;
    L_0x0279:
        r2 = com.igexin.download.SdkDownLoader.f12496c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 == 0) goto L_0x0299;
    L_0x027d:
        r2 = com.igexin.download.SdkDownLoader.f12496c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3 = r3.f12484c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.m15185a(r3);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = new android.os.Message;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3 = 2;
        r2.what = r3;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3 = com.igexin.download.SdkDownLoader.f12496c;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3 = r3.f12497d;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3.sendMessage(r2);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
    L_0x0299:
        if (r10 == 0) goto L_0x02d2;
    L_0x029b:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.f12488g;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        if (r2 != 0) goto L_0x02c9;
    L_0x02a5:
        r2 = new android.content.Intent;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r3 = "com.android.providers.media";
        r5 = "com.android.providers.media.MediaScannerService";
        r2.setClassName(r3, r5);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r5 = 1;
        r3.f12488g = r5;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r3 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r0 = r22;
        r5 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r5 = r5.f12487f;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r6 = 1;
        r3.bindService(r2, r5, r6);	 Catch:{ Exception -> 0x0102, all -> 0x02de }
    L_0x02c9:
        if (r4 == 0) goto L_0x02fe;
    L_0x02cb:
        r4.close();
        r2 = r12;
        r4 = r11;
        goto L_0x010a;
    L_0x02d2:
        r0 = r22;
        r2 = r0.f12510a;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2 = r2.f12487f;	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        r2.m15186a();	 Catch:{ Exception -> 0x0102, all -> 0x02de }
        goto L_0x02c9;
    L_0x02de:
        r2 = move-exception;
    L_0x02df:
        if (r4 == 0) goto L_0x02e4;
    L_0x02e1:
        r4.close();
    L_0x02e4:
        throw r2;
    L_0x02e5:
        r2 = move-exception;
        r4 = r13;
        goto L_0x02df;
    L_0x02e8:
        r2 = move-exception;
        r4 = r13;
        r20 = r10;
        r11 = r12;
        r12 = r20;
        goto L_0x0103;
    L_0x02f1:
        r2 = move-exception;
        r20 = r10;
        r11 = r12;
        r12 = r20;
        goto L_0x0103;
    L_0x02f9:
        r2 = move-exception;
        r12 = r6;
        r11 = r10;
        goto L_0x0103;
    L_0x02fe:
        r2 = r12;
        r4 = r11;
        goto L_0x010a;
    L_0x0302:
        r6 = r12;
        r10 = r11;
        goto L_0x0262;
    L_0x0306:
        r3 = r10;
        goto L_0x0246;
    L_0x0309:
        r6 = r12;
        r10 = r11;
        goto L_0x0205;
    L_0x030d:
        r3 = r10;
        goto L_0x01e9;
    L_0x0310:
        r6 = r12;
        r10 = r11;
        goto L_0x0168;
    L_0x0314:
        r3 = r10;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.download.f.run():void");
    }
}
