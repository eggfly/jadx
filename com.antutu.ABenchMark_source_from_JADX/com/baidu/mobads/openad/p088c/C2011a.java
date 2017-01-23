package com.baidu.mobads.openad.p088c;

import android.content.Context;
import com.antutu.utils.ACPManager;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.p080j.C1991m;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/* renamed from: com.baidu.mobads.openad.c.a */
public class C2011a extends Observable implements IOAdDownloader, Runnable {
    protected Context f7003a;
    protected URL f7004b;
    protected URL f7005c;
    protected String f7006d;
    protected int f7007e;
    protected Boolean f7008f;
    protected String f7009g;
    protected int f7010h;
    protected DownloadStatus f7011i;
    protected volatile int f7012j;
    protected int f7013k;
    protected ArrayList<C2010a> f7014l;
    C2016g f7015m;
    private String f7016n;
    private String f7017o;

    /* renamed from: com.baidu.mobads.openad.c.a.a */
    protected class C2010a implements Runnable {
        protected int f6991a;
        protected URL f6992b;
        protected String f6993c;
        protected int f6994d;
        protected int f6995e;
        protected int f6996f;
        protected boolean f6997g;
        protected Thread f6998h;
        final /* synthetic */ C2011a f6999i;
        private volatile boolean f7000j;
        private volatile int f7001k;
        private HttpURLConnection f7002l;

        public C2010a(C2011a c2011a, int i, URL url, String str, int i2, int i3, int i4) {
            this.f6999i = c2011a;
            this.f7000j = false;
            this.f7001k = 0;
            this.f6991a = i;
            this.f6992b = url;
            this.f6993c = str;
            this.f6994d = i2;
            this.f6995e = i3;
            this.f6996f = i4;
            this.f6997g = false;
        }

        public void m7494a(HttpURLConnection httpURLConnection) {
            this.f7002l = httpURLConnection;
        }

        public boolean m7495a() {
            return this.f6997g;
        }

        public synchronized void m7496b() {
            this.f7000j = false;
            this.f6998h = new Thread(this);
            this.f6998h.start();
        }

        public synchronized void m7497c() {
            this.f7000j = true;
            this.f7001k++;
        }

        public void m7498d() {
            if (this.f6998h != null) {
                this.f6998h.join();
                return;
            }
            C1991m.m7449a().m7457f().m7408w("DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r12 = this;
            r2 = 0;
            r11 = 2;
            r10 = 1;
            r9 = 0;
            r5 = r12.f7001k;
            r1 = 0;
            r3 = 0;
            r0 = r12.f6994d;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r4 = r12.f6996f;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r0 = r0 + r4;
            r4 = r12.f6995e;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            if (r0 < r4) goto L_0x005f;
        L_0x0011:
            r0 = 1;
            r12.f6997g = r0;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r1 = r2;
            r3 = r2;
            r4 = r2;
        L_0x0017:
            r0 = com.baidu.mobads.p080j.C1991m.m7449a();
            r0 = r0.m7457f();
            r2 = "DownloadThread";
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = "Thread[";
            r6 = r6.append(r7);
            r7 = r12.f6991a;
            r6 = r6.append(r7);
            r7 = "] ver(";
            r6 = r6.append(r7);
            r5 = r6.append(r5);
            r6 = ") executed end; isFinished=";
            r5 = r5.append(r6);
            r6 = r12.f6997g;
            r5 = r5.append(r6);
            r5 = r5.toString();
            r0.m7393d(r2, r5);
            if (r1 == 0) goto L_0x0054;
        L_0x0051:
            r1.close();	 Catch:{ IOException -> 0x03cb }
        L_0x0054:
            if (r3 == 0) goto L_0x0059;
        L_0x0056:
            r3.close();	 Catch:{ IOException -> 0x03e5 }
        L_0x0059:
            if (r4 == 0) goto L_0x005e;
        L_0x005b:
            r4.disconnect();	 Catch:{ Exception -> 0x03ff }
        L_0x005e:
            return;
        L_0x005f:
            r0 = r12.f7002l;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            if (r0 != 0) goto L_0x02df;
        L_0x0063:
            r0 = r12.f6992b;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r0 = r0.openConnection();	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r4 = r12.f6999i;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r4.f7008f;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r4.booleanValue();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            if (r4 == 0) goto L_0x0119;
        L_0x0075:
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4.<init>();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = r12.f6994d;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r7 = r12.f6996f;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = r6 + r7;
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = "-";
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = r12.f6995e;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r4.append(r6);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = "Range";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r7.<init>();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r8 = "bytes=";
            r7 = r7.append(r8);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r7.append(r4);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r0.setRequestProperty(r6, r4);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
        L_0x00ab:
            r0.connect();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = r0.getResponseCode();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = r12.f7001k;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            if (r5 == r6) goto L_0x019b;
        L_0x00b6:
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "Thread[";
            r7 = r7.append(r8);
            r8 = r12.f6991a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f6997g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.m7393d(r6, r5);
            if (r2 == 0) goto L_0x00f3;
        L_0x00f0:
            r3.close();	 Catch:{ IOException -> 0x0416 }
        L_0x00f3:
            if (r2 == 0) goto L_0x00f8;
        L_0x00f5:
            r1.close();	 Catch:{ IOException -> 0x0430 }
        L_0x00f8:
            if (r0 == 0) goto L_0x005e;
        L_0x00fa:
            r0.disconnect();	 Catch:{ Exception -> 0x00ff }
            goto L_0x005e;
        L_0x00ff:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
        L_0x0114:
            r1.m7408w(r2);
            goto L_0x005e;
        L_0x0119:
            r4 = 0;
            r12.f6996f = r4;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            goto L_0x00ab;
        L_0x011d:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
            r1 = r2;
        L_0x0121:
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();	 Catch:{ all -> 0x04c9 }
            r4 = r4.m7457f();	 Catch:{ all -> 0x04c9 }
            r6 = "DownloadThread";
            r0 = r0.getMessage();	 Catch:{ all -> 0x04c9 }
            r4.m7393d(r6, r0);	 Catch:{ all -> 0x04c9 }
            r0 = r12.f7001k;	 Catch:{ all -> 0x04c9 }
            if (r5 != r0) goto L_0x013b;
        L_0x0136:
            r0 = r12.f6999i;	 Catch:{ all -> 0x04c9 }
            r0.m7504b();	 Catch:{ all -> 0x04c9 }
        L_0x013b:
            r0 = com.baidu.mobads.p080j.C1991m.m7449a();
            r0 = r0.m7457f();
            r4 = "DownloadThread";
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = "Thread[";
            r6 = r6.append(r7);
            r7 = r12.f6991a;
            r6 = r6.append(r7);
            r7 = "] ver(";
            r6 = r6.append(r7);
            r5 = r6.append(r5);
            r6 = ") executed end; isFinished=";
            r5 = r5.append(r6);
            r6 = r12.f6997g;
            r5 = r5.append(r6);
            r5 = r5.toString();
            r0.m7393d(r4, r5);
            if (r1 == 0) goto L_0x0178;
        L_0x0175:
            r1.close();	 Catch:{ IOException -> 0x0397 }
        L_0x0178:
            if (r2 == 0) goto L_0x017d;
        L_0x017a:
            r2.close();	 Catch:{ IOException -> 0x03b1 }
        L_0x017d:
            if (r3 == 0) goto L_0x005e;
        L_0x017f:
            r3.disconnect();	 Catch:{ Exception -> 0x0184 }
            goto L_0x005e;
        L_0x0184:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0114;
        L_0x019b:
            r4 = r4 / 100;
            if (r4 == r11) goto L_0x0204;
        L_0x019f:
            r4 = r12.f6999i;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4.m7504b();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "Thread[";
            r7 = r7.append(r8);
            r8 = r12.f6991a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f6997g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.m7393d(r6, r5);
            if (r2 == 0) goto L_0x01e1;
        L_0x01de:
            r3.close();	 Catch:{ IOException -> 0x044a }
        L_0x01e1:
            if (r2 == 0) goto L_0x01e6;
        L_0x01e3:
            r1.close();	 Catch:{ IOException -> 0x0464 }
        L_0x01e6:
            if (r0 == 0) goto L_0x005e;
        L_0x01e8:
            r0.disconnect();	 Catch:{ Exception -> 0x01ed }
            goto L_0x005e;
        L_0x01ed:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0114;
        L_0x0204:
            r4 = r0.getContentType();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r6 = "text/html";
            r4 = r4.equals(r6);	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            if (r4 == 0) goto L_0x0275;
        L_0x0210:
            r4 = r12.f6999i;	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4.m7504b();	 Catch:{ Exception -> 0x011d, all -> 0x04b7 }
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "Thread[";
            r7 = r7.append(r8);
            r8 = r12.f6991a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f6997g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r4.m7393d(r6, r5);
            if (r2 == 0) goto L_0x0252;
        L_0x024f:
            r3.close();	 Catch:{ IOException -> 0x047e }
        L_0x0252:
            if (r2 == 0) goto L_0x0257;
        L_0x0254:
            r1.close();	 Catch:{ IOException -> 0x0498 }
        L_0x0257:
            if (r0 == 0) goto L_0x005e;
        L_0x0259:
            r0.disconnect();	 Catch:{ Exception -> 0x025e }
            goto L_0x005e;
        L_0x025e:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0114;
        L_0x0275:
            r4 = r0;
        L_0x0276:
            r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x04d9, all -> 0x04c2 }
            r0 = r4.getInputStream();	 Catch:{ Exception -> 0x04d9, all -> 0x04c2 }
            r3.<init>(r0);	 Catch:{ Exception -> 0x04d9, all -> 0x04c2 }
            r0 = r12.f6994d;	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r1 = r12.f6996f;	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r0 = r0 + r1;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r1 = r1.m7457f();	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r7.<init>();	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r8 = "tmpStartByte = ";
            r7 = r7.append(r8);	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r7 = r7.append(r0);	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r7 = r7.toString();	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r1.m7393d(r6, r7);	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r1 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r6 = r12.f6993c;	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r7 = "rw";
            r1.<init>(r6, r7);	 Catch:{ Exception -> 0x04de, all -> 0x04c6 }
            r6 = (long) r0;
            r1.seek(r6);	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r2 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
            r2 = new byte[r2];	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
        L_0x02b6:
            r6 = r12.f6999i;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r6 = r6.f7011i;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r7 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            if (r6 != r7) goto L_0x02d1;
        L_0x02be:
            r6 = 0;
            r7 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
            r6 = r3.read(r2, r6, r7);	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r7 = -1;
            if (r6 == r7) goto L_0x02d1;
        L_0x02c9:
            r7 = r12.f6995e;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            if (r0 >= r7) goto L_0x02d1;
        L_0x02cd:
            r7 = r12.f7001k;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            if (r5 == r7) goto L_0x02e6;
        L_0x02d1:
            r2 = r12.f6995e;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            if (r0 < r2) goto L_0x0017;
        L_0x02d5:
            r0 = 1;
            r12.f6997g = r0;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            goto L_0x0017;
        L_0x02da:
            r0 = move-exception;
            r2 = r3;
            r3 = r4;
            goto L_0x0121;
        L_0x02df:
            r1 = r12.f7002l;	 Catch:{ Exception -> 0x04cf, all -> 0x04b2 }
            r0 = 0;
            r12.f7002l = r0;	 Catch:{ Exception -> 0x04d4, all -> 0x04bd }
            r4 = r1;
            goto L_0x0276;
        L_0x02e6:
            r7 = 0;
            r1.write(r2, r7, r6);	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r7 = r12.f6996f;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r7 = r7 + r6;
            r12.f6996f = r7;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r0 = r0 + r6;
            r7 = r12.f6999i;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r7.m7500a(r6);	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            monitor-enter(r12);	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
            r6 = r12.f7000j;	 Catch:{ all -> 0x02fc }
            if (r6 == 0) goto L_0x0349;
        L_0x02fa:
            monitor-exit(r12);	 Catch:{ all -> 0x02fc }
            goto L_0x02d1;
        L_0x02fc:
            r0 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x02fc }
            throw r0;	 Catch:{ Exception -> 0x02da, all -> 0x02ff }
        L_0x02ff:
            r0 = move-exception;
            r2 = r1;
        L_0x0301:
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r6 = "DownloadThread";
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "Thread[";
            r7 = r7.append(r8);
            r8 = r12.f6991a;
            r7 = r7.append(r8);
            r8 = "] ver(";
            r7 = r7.append(r8);
            r5 = r7.append(r5);
            r7 = ") executed end; isFinished=";
            r5 = r5.append(r7);
            r7 = r12.f6997g;
            r5 = r5.append(r7);
            r5 = r5.toString();
            r1.m7393d(r6, r5);
            if (r2 == 0) goto L_0x033e;
        L_0x033b:
            r2.close();	 Catch:{ IOException -> 0x034c }
        L_0x033e:
            if (r3 == 0) goto L_0x0343;
        L_0x0340:
            r3.close();	 Catch:{ IOException -> 0x0365 }
        L_0x0343:
            if (r4 == 0) goto L_0x0348;
        L_0x0345:
            r4.disconnect();	 Catch:{ Exception -> 0x037e }
        L_0x0348:
            throw r0;
        L_0x0349:
            monitor-exit(r12);	 Catch:{ all -> 0x02fc }
            goto L_0x02b6;
        L_0x034c:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r1 = r1.getMessage();
            r5[r10] = r1;
            r2.m7408w(r5);
            goto L_0x033e;
        L_0x0365:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r3 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r3[r9] = r5;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.m7408w(r3);
            goto L_0x0343;
        L_0x037e:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.m7408w(r3);
            goto L_0x0348;
        L_0x0397:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r4 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r4[r9] = r5;
            r0 = r0.getMessage();
            r4[r10] = r0;
            r1.m7408w(r4);
            goto L_0x0178;
        L_0x03b1:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r2[r9] = r4;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.m7408w(r2);
            goto L_0x017d;
        L_0x03cb:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r5 = "DownloadThread";
            r2[r9] = r5;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.m7408w(r2);
            goto L_0x0054;
        L_0x03e5:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            r1.m7408w(r2);
            goto L_0x0059;
        L_0x03ff:
            r0 = move-exception;
            r1 = com.baidu.mobads.p080j.C1991m.m7449a();
            r1 = r1.m7457f();
            r2 = new java.lang.Object[r11];
            r3 = "DownloadThread";
            r2[r9] = r3;
            r0 = r0.getMessage();
            r2[r10] = r0;
            goto L_0x0114;
        L_0x0416:
            r3 = move-exception;
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.m7408w(r5);
            goto L_0x00f3;
        L_0x0430:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.m7408w(r3);
            goto L_0x00f8;
        L_0x044a:
            r3 = move-exception;
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.m7408w(r5);
            goto L_0x01e1;
        L_0x0464:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.m7408w(r3);
            goto L_0x01e6;
        L_0x047e:
            r3 = move-exception;
            r4 = com.baidu.mobads.p080j.C1991m.m7449a();
            r4 = r4.m7457f();
            r5 = new java.lang.Object[r11];
            r6 = "DownloadThread";
            r5[r9] = r6;
            r3 = r3.getMessage();
            r5[r10] = r3;
            r4.m7408w(r5);
            goto L_0x0252;
        L_0x0498:
            r1 = move-exception;
            r2 = com.baidu.mobads.p080j.C1991m.m7449a();
            r2 = r2.m7457f();
            r3 = new java.lang.Object[r11];
            r4 = "DownloadThread";
            r3[r9] = r4;
            r1 = r1.getMessage();
            r3[r10] = r1;
            r2.m7408w(r3);
            goto L_0x0257;
        L_0x04b2:
            r0 = move-exception;
            r3 = r2;
            r4 = r2;
            goto L_0x0301;
        L_0x04b7:
            r1 = move-exception;
            r3 = r2;
            r4 = r0;
            r0 = r1;
            goto L_0x0301;
        L_0x04bd:
            r0 = move-exception;
            r3 = r2;
            r4 = r1;
            goto L_0x0301;
        L_0x04c2:
            r0 = move-exception;
            r3 = r2;
            goto L_0x0301;
        L_0x04c6:
            r0 = move-exception;
            goto L_0x0301;
        L_0x04c9:
            r0 = move-exception;
            r4 = r3;
            r3 = r2;
            r2 = r1;
            goto L_0x0301;
        L_0x04cf:
            r0 = move-exception;
            r1 = r2;
            r3 = r2;
            goto L_0x0121;
        L_0x04d4:
            r0 = move-exception;
            r3 = r1;
            r1 = r2;
            goto L_0x0121;
        L_0x04d9:
            r0 = move-exception;
            r1 = r2;
            r3 = r4;
            goto L_0x0121;
        L_0x04de:
            r0 = move-exception;
            r1 = r2;
            r2 = r3;
            r3 = r4;
            goto L_0x0121;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.a.run():void");
        }
    }

    public C2011a(Context context, URL url, String str, String str2, int i, String str3, String str4) {
        this.f7008f = Boolean.valueOf(true);
        this.f7015m = null;
        this.f7003a = context;
        this.f7004b = url;
        this.f7006d = str;
        this.f7007e = i;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f7009g = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f7009g = str2;
        }
        this.f7010h = -1;
        this.f7011i = DownloadStatus.NONE;
        this.f7012j = 0;
        this.f7013k = 0;
        this.f7016n = str3;
        this.f7017o = str4;
        this.f7014l = new ArrayList();
    }

    protected void m7499a() {
        setChanged();
        notifyObservers();
    }

    protected synchronized void m7500a(int i) {
        this.f7012j += i;
        int progress = (int) getProgress();
        if (this.f7013k < progress) {
            this.f7013k = progress;
            m7499a();
        }
    }

    protected void m7501a(DownloadStatus downloadStatus) {
        this.f7011i = downloadStatus;
        m7499a();
    }

    protected void m7502a(HttpURLConnection httpURLConnection) {
        List arrayList;
        Throwable e;
        List arrayList2;
        int i;
        int round;
        int i2;
        C2010a c2010a;
        Object obj;
        List arrayList3;
        Iterator it;
        C2010a c2010a2;
        String url = this.f7005c.toString();
        String str = (this.f7006d + this.f7009g) + ".tmp";
        if (this.f7014l.size() == 0) {
            RandomAccessFile randomAccessFile;
            int i3;
            File file = new File(this.f7006d);
            if (!file.exists()) {
                file.mkdirs();
            }
            List list = null;
            File file2 = new File(str);
            if (this.f7008f.booleanValue() && file2.exists() && file2.length() == ((long) this.f7010h)) {
                try {
                    this.f7015m = new C2016g(this.f7003a);
                    List<C2017h> b = this.f7015m.m7521b(url, str);
                    if (b != null && b.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            HashSet hashSet = new HashSet();
                            for (C2017h c2017h : b) {
                                if (!hashSet.contains(Integer.valueOf(c2017h.m7529c()))) {
                                    hashSet.add(Integer.valueOf(c2017h.m7529c()));
                                    arrayList.add(c2017h);
                                    C1991m.m7449a().m7457f().m7393d("Downloader", "resume from db: start=" + c2017h.m7531d() + ";end =" + c2017h.m7533e() + ";complete=" + c2017h.m7523a());
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            C1991m.m7449a().m7457f().m7394d("Downloader", e);
                            list = arrayList;
                            if (file2.exists()) {
                                file2.delete();
                            }
                            try {
                                file2.createNewFile();
                                randomAccessFile = new RandomAccessFile(file2, "rwd");
                                randomAccessFile.setLength((long) this.f7010h);
                                randomAccessFile.close();
                                C1991m.m7449a().m7457f().m7392d("Downloader.init():  \u5efa\u7acb\u5b8crandom\u6587\u4ef6 ts:" + System.currentTimeMillis());
                                arrayList2 = new ArrayList();
                                i3 = -1;
                                i = 0;
                                if (this.f7007e > 1) {
                                    arrayList2.add(new C2017h(1, url, str, 0, this.f7010h, 0));
                                    list = arrayList2;
                                } else {
                                    round = Math.round((((float) this.f7010h) / ((float) this.f7007e)) / 102400.0f) * ACPManager.MAX_BUFFER;
                                    while (i3 < this.f7010h) {
                                        i2 = i3 + 1;
                                        i3 = i3 + round < this.f7010h ? this.f7010h : i3 + round;
                                        i++;
                                        arrayList2.add(new C2017h(i, url, str, i2, i3, 0));
                                    }
                                    list = arrayList2;
                                }
                                for (C2017h c2017h2 : r2) {
                                    c2010a = new C2010a(this, c2017h2.m7529c(), this.f7005c, c2017h2.m7534f(), c2017h2.m7531d(), c2017h2.m7533e(), c2017h2.m7523a());
                                    c2010a.m7494a(httpURLConnection);
                                    this.f7014l.add(c2010a);
                                }
                                if (this.f7008f.booleanValue()) {
                                    i2 = 0;
                                } else {
                                    i2 = 0;
                                    for (i = 0; i < this.f7014l.size(); i++) {
                                        i2 += ((C2010a) this.f7014l.get(i)).f6996f;
                                    }
                                }
                                this.f7012j = i2;
                                this.f7013k = (int) getProgress();
                                m7501a(DownloadStatus.DOWNLOADING);
                                C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader starts unfinished threads and waits threads end");
                                for (i = 0; i < this.f7014l.size(); i++) {
                                    if (((C2010a) this.f7014l.get(i)).m7495a()) {
                                        ((C2010a) this.f7014l.get(i)).m7496b();
                                    }
                                }
                                for (i = 0; i < this.f7014l.size(); i++) {
                                    if (((C2010a) this.f7014l.get(i)).m7495a()) {
                                        ((C2010a) this.f7014l.get(i)).m7498d();
                                    }
                                }
                                if (this.f7011i != DownloadStatus.DOWNLOADING) {
                                    while (i < this.f7014l.size()) {
                                        if (((C2010a) this.f7014l.get(i)).m7495a()) {
                                            obj = 1;
                                            break;
                                            if (obj != null) {
                                                m7503a(this.f7014l);
                                                m7501a(DownloadStatus.COMPLETED);
                                            } else {
                                                m7501a(DownloadStatus.ERROR);
                                            }
                                        } else {
                                        }
                                    }
                                    obj = null;
                                    if (obj != null) {
                                        m7501a(DownloadStatus.ERROR);
                                    } else {
                                        m7503a(this.f7014l);
                                        m7501a(DownloadStatus.COMPLETED);
                                    }
                                } else if (this.f7011i != DownloadStatus.ERROR) {
                                    m7501a(DownloadStatus.ERROR);
                                } else if (this.f7011i != DownloadStatus.CANCELLED) {
                                    C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is cancelled");
                                } else if (this.f7011i == DownloadStatus.PAUSED) {
                                    C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is paused");
                                }
                                if (this.f7011i == DownloadStatus.COMPLETED) {
                                    C1991m.m7449a().m7457f().m7393d("Downloader", "save database now");
                                    if (!this.f7008f.booleanValue()) {
                                        try {
                                            if (this.f7015m == null) {
                                                this.f7015m = new C2016g(this.f7003a);
                                            }
                                            arrayList3 = new ArrayList();
                                            it = this.f7014l.iterator();
                                            while (it.hasNext()) {
                                                c2010a2 = (C2010a) it.next();
                                                arrayList3.add(new C2017h(c2010a2.f6991a, url, str, c2010a2.f6994d, c2010a2.f6995e, c2010a2.f6996f));
                                                C1991m.m7449a().m7457f().m7393d("Downloader", "save to db: start=" + c2010a2.f6994d + ";end =" + c2010a2.f6995e + ";complete=" + c2010a2.f6996f);
                                            }
                                            if (this.f7015m.m7520a(url, str)) {
                                                this.f7015m.m7519a(arrayList3);
                                            } else {
                                                this.f7015m.m7522b(arrayList3);
                                            }
                                        } catch (Throwable e3) {
                                            C1991m.m7449a().m7457f().m7394d("Downloader", e3);
                                            return;
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                C1991m.m7449a().m7457f().m7393d("Downloader", " \u5efa\u7acb\u6587\u4ef6\u5931\u8d25:");
                                m7501a(DownloadStatus.ERROR);
                                return;
                            }
                        }
                        list = arrayList;
                    }
                } catch (Throwable e5) {
                    Throwable th = e5;
                    arrayList = null;
                    e3 = th;
                    C1991m.m7449a().m7457f().m7394d("Downloader", e3);
                    list = arrayList;
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rwd");
                    randomAccessFile.setLength((long) this.f7010h);
                    randomAccessFile.close();
                    C1991m.m7449a().m7457f().m7392d("Downloader.init():  \u5efa\u7acb\u5b8crandom\u6587\u4ef6 ts:" + System.currentTimeMillis());
                    arrayList2 = new ArrayList();
                    i3 = -1;
                    i = 0;
                    if (this.f7007e > 1) {
                        round = Math.round((((float) this.f7010h) / ((float) this.f7007e)) / 102400.0f) * ACPManager.MAX_BUFFER;
                        while (i3 < this.f7010h) {
                            i2 = i3 + 1;
                            if (i3 + round < this.f7010h) {
                            }
                            i++;
                            arrayList2.add(new C2017h(i, url, str, i2, i3, 0));
                        }
                        list = arrayList2;
                    } else {
                        arrayList2.add(new C2017h(1, url, str, 0, this.f7010h, 0));
                        list = arrayList2;
                    }
                    for (C2017h c2017h22 : r2) {
                        c2010a = new C2010a(this, c2017h22.m7529c(), this.f7005c, c2017h22.m7534f(), c2017h22.m7531d(), c2017h22.m7533e(), c2017h22.m7523a());
                        c2010a.m7494a(httpURLConnection);
                        this.f7014l.add(c2010a);
                    }
                    if (this.f7008f.booleanValue()) {
                        i2 = 0;
                        for (i = 0; i < this.f7014l.size(); i++) {
                            i2 += ((C2010a) this.f7014l.get(i)).f6996f;
                        }
                    } else {
                        i2 = 0;
                    }
                    this.f7012j = i2;
                    this.f7013k = (int) getProgress();
                    m7501a(DownloadStatus.DOWNLOADING);
                    C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader starts unfinished threads and waits threads end");
                    for (i = 0; i < this.f7014l.size(); i++) {
                        if (((C2010a) this.f7014l.get(i)).m7495a()) {
                            ((C2010a) this.f7014l.get(i)).m7496b();
                        }
                    }
                    for (i = 0; i < this.f7014l.size(); i++) {
                        if (((C2010a) this.f7014l.get(i)).m7495a()) {
                            ((C2010a) this.f7014l.get(i)).m7498d();
                        }
                    }
                    if (this.f7011i != DownloadStatus.DOWNLOADING) {
                        while (i < this.f7014l.size()) {
                            if (((C2010a) this.f7014l.get(i)).m7495a()) {
                                obj = 1;
                                break;
                                if (obj != null) {
                                    m7503a(this.f7014l);
                                    m7501a(DownloadStatus.COMPLETED);
                                } else {
                                    m7501a(DownloadStatus.ERROR);
                                }
                            } else {
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            m7501a(DownloadStatus.ERROR);
                        } else {
                            m7503a(this.f7014l);
                            m7501a(DownloadStatus.COMPLETED);
                        }
                    } else if (this.f7011i != DownloadStatus.ERROR) {
                        m7501a(DownloadStatus.ERROR);
                    } else if (this.f7011i != DownloadStatus.CANCELLED) {
                        C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is cancelled");
                    } else if (this.f7011i == DownloadStatus.PAUSED) {
                        C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is paused");
                    }
                    if (this.f7011i == DownloadStatus.COMPLETED) {
                        C1991m.m7449a().m7457f().m7393d("Downloader", "save database now");
                        if (!this.f7008f.booleanValue()) {
                            if (this.f7015m == null) {
                                this.f7015m = new C2016g(this.f7003a);
                            }
                            arrayList3 = new ArrayList();
                            it = this.f7014l.iterator();
                            while (it.hasNext()) {
                                c2010a2 = (C2010a) it.next();
                                arrayList3.add(new C2017h(c2010a2.f6991a, url, str, c2010a2.f6994d, c2010a2.f6995e, c2010a2.f6996f));
                                C1991m.m7449a().m7457f().m7393d("Downloader", "save to db: start=" + c2010a2.f6994d + ";end =" + c2010a2.f6995e + ";complete=" + c2010a2.f6996f);
                            }
                            if (this.f7015m.m7520a(url, str)) {
                                this.f7015m.m7522b(arrayList3);
                            } else {
                                this.f7015m.m7519a(arrayList3);
                            }
                        }
                    }
                }
            }
            if (list == null || list.size() < 1) {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                randomAccessFile = new RandomAccessFile(file2, "rwd");
                randomAccessFile.setLength((long) this.f7010h);
                randomAccessFile.close();
                C1991m.m7449a().m7457f().m7392d("Downloader.init():  \u5efa\u7acb\u5b8crandom\u6587\u4ef6 ts:" + System.currentTimeMillis());
                arrayList2 = new ArrayList();
                i3 = -1;
                i = 0;
                if (this.f7007e > 1) {
                    round = Math.round((((float) this.f7010h) / ((float) this.f7007e)) / 102400.0f) * ACPManager.MAX_BUFFER;
                    while (i3 < this.f7010h) {
                        i2 = i3 + 1;
                        if (i3 + round < this.f7010h) {
                        }
                        i++;
                        arrayList2.add(new C2017h(i, url, str, i2, i3, 0));
                    }
                    list = arrayList2;
                } else {
                    arrayList2.add(new C2017h(1, url, str, 0, this.f7010h, 0));
                    list = arrayList2;
                }
            }
            for (C2017h c2017h222 : r2) {
                c2010a = new C2010a(this, c2017h222.m7529c(), this.f7005c, c2017h222.m7534f(), c2017h222.m7531d(), c2017h222.m7533e(), c2017h222.m7523a());
                if (c2017h222.m7531d() == 0 && c2017h222.m7523a() == 0) {
                    c2010a.m7494a(httpURLConnection);
                }
                this.f7014l.add(c2010a);
            }
        }
        if (this.f7008f.booleanValue()) {
            i2 = 0;
            for (i = 0; i < this.f7014l.size(); i++) {
                i2 += ((C2010a) this.f7014l.get(i)).f6996f;
            }
        } else {
            i2 = 0;
        }
        this.f7012j = i2;
        this.f7013k = (int) getProgress();
        m7501a(DownloadStatus.DOWNLOADING);
        C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader starts unfinished threads and waits threads end");
        for (i = 0; i < this.f7014l.size(); i++) {
            if (((C2010a) this.f7014l.get(i)).m7495a()) {
                ((C2010a) this.f7014l.get(i)).m7496b();
            }
        }
        for (i = 0; i < this.f7014l.size(); i++) {
            if (((C2010a) this.f7014l.get(i)).m7495a()) {
                ((C2010a) this.f7014l.get(i)).m7498d();
            }
        }
        if (this.f7011i != DownloadStatus.DOWNLOADING) {
            for (i = 0; i < this.f7014l.size(); i++) {
                if (((C2010a) this.f7014l.get(i)).m7495a()) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                m7501a(DownloadStatus.ERROR);
            } else {
                m7503a(this.f7014l);
                m7501a(DownloadStatus.COMPLETED);
            }
        } else if (this.f7011i != DownloadStatus.ERROR) {
            m7501a(DownloadStatus.ERROR);
        } else if (this.f7011i != DownloadStatus.CANCELLED) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is cancelled");
        } else if (this.f7011i == DownloadStatus.PAUSED) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "Downloader is paused");
        }
        if (this.f7011i == DownloadStatus.COMPLETED) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "save database now");
            if (!this.f7008f.booleanValue()) {
                if (this.f7015m == null) {
                    this.f7015m = new C2016g(this.f7003a);
                }
                arrayList3 = new ArrayList();
                it = this.f7014l.iterator();
                while (it.hasNext()) {
                    c2010a2 = (C2010a) it.next();
                    arrayList3.add(new C2017h(c2010a2.f6991a, url, str, c2010a2.f6994d, c2010a2.f6995e, c2010a2.f6996f));
                    C1991m.m7449a().m7457f().m7393d("Downloader", "save to db: start=" + c2010a2.f6994d + ";end =" + c2010a2.f6995e + ";complete=" + c2010a2.f6996f);
                }
                if (this.f7015m.m7520a(url, str)) {
                    this.f7015m.m7522b(arrayList3);
                } else {
                    this.f7015m.m7519a(arrayList3);
                }
            }
        }
    }

    protected void m7503a(ArrayList<C2010a> arrayList) {
        C1991m.m7449a().m7462k().renameFile(this.f7006d + this.f7009g + ".tmp", this.f7006d + this.f7009g);
    }

    protected synchronized void m7504b() {
        this.f7011i = DownloadStatus.ERROR;
        for (int i = 0; i < this.f7014l.size(); i++) {
            if (!((C2010a) this.f7014l.get(i)).m7495a()) {
                ((C2010a) this.f7014l.get(i)).m7497c();
            }
        }
    }

    public void cancel() {
        try {
            C1991m.m7449a().m7457f().m7393d("Downloader", "execute Cancel; state = " + this.f7011i);
            if (this.f7011i == DownloadStatus.PAUSED || this.f7011i == DownloadStatus.DOWNLOADING) {
                if (this.f7014l != null) {
                    for (int i = 0; i < this.f7014l.size(); i++) {
                        if (!((C2010a) this.f7014l.get(i)).m7495a()) {
                            ((C2010a) this.f7014l.get(i)).m7497c();
                        }
                    }
                }
                m7501a(DownloadStatus.CANCELLED);
            }
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "cancel exception");
        }
    }

    public int getFileSize() {
        return this.f7010h;
    }

    public String getOutputPath() {
        return this.f7006d + this.f7009g;
    }

    public String getPackageName() {
        return this.f7017o;
    }

    public float getProgress() {
        return Math.abs((((float) this.f7012j) / ((float) this.f7010h)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f7011i;
    }

    public String getTargetURL() {
        return this.f7005c == null ? null : this.f7005c.toString();
    }

    public String getTitle() {
        return this.f7016n;
    }

    public String getURL() {
        return this.f7004b.toString();
    }

    public void pause() {
        try {
            C1991m.m7449a().m7457f().m7393d("Downloader", "execute Pause; state = " + this.f7011i);
            if (this.f7011i == DownloadStatus.DOWNLOADING || this.f7011i == DownloadStatus.ERROR || this.f7011i == DownloadStatus.NONE) {
                if (this.f7014l != null) {
                    for (int i = 0; i < this.f7014l.size(); i++) {
                        if (!((C2010a) this.f7014l.get(i)).m7495a()) {
                            ((C2010a) this.f7014l.get(i)).m7497c();
                        }
                    }
                }
                m7501a(DownloadStatus.PAUSED);
            }
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "pause exception");
        }
    }

    public void removeObservers() {
        deleteObservers();
    }

    public void resume() {
        try {
            C1991m.m7449a().m7457f().m7393d("Downloader", "execute Resume; state = " + this.f7011i);
            if (this.f7011i == DownloadStatus.PAUSED || this.f7011i == DownloadStatus.ERROR || this.f7011i == DownloadStatus.CANCELLED) {
                m7501a(DownloadStatus.INITING);
                new Thread(this).start();
            }
        } catch (Exception e) {
            C1991m.m7449a().m7457f().m7393d("Downloader", "resume exception");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
        r0 = 0;
        r3 = 1;
        r1 = r5.f7005c;
        if (r1 == 0) goto L_0x000a;
    L_0x0006:
        r1 = r5.f7010h;
        if (r1 >= r3) goto L_0x00cc;
    L_0x000a:
        r1 = com.baidu.mobads.p080j.C1991m.m7449a();	 Catch:{ Exception -> 0x00b8, all -> 0x00c2 }
        r1 = r1.m7460i();	 Catch:{ Exception -> 0x00b8, all -> 0x00c2 }
        r2 = r5.f7004b;	 Catch:{ Exception -> 0x00b8, all -> 0x00c2 }
        r0 = r1.getHttpURLConnection(r2);	 Catch:{ Exception -> 0x00b8, all -> 0x00c2 }
        r1 = "Range";
        r2 = "bytes=0-";
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x00b8 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x00b8 }
        r0.connect();	 Catch:{ Exception -> 0x00b8 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00b8 }
        r1 = r1 / 100;
        r2 = 2;
        if (r1 == r2) goto L_0x003f;
    L_0x0034:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b8 }
        r5.m7501a(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r0 == 0) goto L_0x003e;
    L_0x003b:
        r0.disconnect();
    L_0x003e:
        return;
    L_0x003f:
        r1 = r0.getContentType();	 Catch:{ Exception -> 0x00b8 }
        r2 = "text/html";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0053;
    L_0x004b:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b8 }
        r5.m7501a(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r0 == 0) goto L_0x003e;
    L_0x0052:
        goto L_0x003b;
    L_0x0053:
        r1 = r0.getContentLength();	 Catch:{ Exception -> 0x00b8 }
        if (r1 >= r3) goto L_0x0061;
    L_0x0059:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b8 }
        r5.m7501a(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r0 == 0) goto L_0x003e;
    L_0x0060:
        goto L_0x003b;
    L_0x0061:
        r2 = 5120000; // 0x4e2000 float:7.174648E-39 double:2.529616E-317;
        if (r1 >= r2) goto L_0x0069;
    L_0x0066:
        r2 = 1;
        r5.f7007e = r2;	 Catch:{ Exception -> 0x00b8 }
    L_0x0069:
        r2 = r0.getURL();	 Catch:{ Exception -> 0x00b8 }
        r5.f7005c = r2;	 Catch:{ Exception -> 0x00b8 }
        r2 = "mounted";
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x00b8 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00b8 }
        if (r2 != 0) goto L_0x0083;
    L_0x007b:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00b8 }
        r5.m7501a(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r0 == 0) goto L_0x003e;
    L_0x0082:
        goto L_0x003b;
    L_0x0083:
        r2 = "Content-Range";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b8 }
        if (r2 != 0) goto L_0x00ab;
    L_0x008b:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b8 }
        if (r2 == 0) goto L_0x00a1;
    L_0x0093:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "none";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x00b8 }
        if (r2 == 0) goto L_0x00ab;
    L_0x00a1:
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00b8 }
        r5.f7008f = r2;	 Catch:{ Exception -> 0x00b8 }
        r2 = 1;
        r5.f7007e = r2;	 Catch:{ Exception -> 0x00b8 }
    L_0x00ab:
        r2 = r5.f7010h;	 Catch:{ Exception -> 0x00b8 }
        r3 = -1;
        if (r2 != r3) goto L_0x00b2;
    L_0x00b0:
        r5.f7010h = r1;	 Catch:{ Exception -> 0x00b8 }
    L_0x00b2:
        r5.m7502a(r0);	 Catch:{ Exception -> 0x00b8 }
        if (r0 == 0) goto L_0x003e;
    L_0x00b7:
        goto L_0x003b;
    L_0x00b8:
        r1 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ all -> 0x00e7 }
        r5.m7501a(r1);	 Catch:{ all -> 0x00e7 }
        if (r0 == 0) goto L_0x003e;
    L_0x00c0:
        goto L_0x003b;
    L_0x00c2:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x00c6:
        if (r1 == 0) goto L_0x00cb;
    L_0x00c8:
        r1.disconnect();
    L_0x00cb:
        throw r0;
    L_0x00cc:
        r0 = 0;
        r5.m7502a(r0);	 Catch:{ Exception -> 0x00d2 }
        goto L_0x003e;
    L_0x00d2:
        r0 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r5.m7501a(r1);
        r1 = com.baidu.mobads.p080j.C1991m.m7449a();
        r1 = r1.m7457f();
        r2 = "Downloader";
        r1.m7394d(r2, r0);
        goto L_0x003e;
    L_0x00e7:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x00c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.run():void");
    }

    public void start() {
        C1991m.m7449a().m7457f().m7393d("Downloader", "execute Start; state = " + this.f7011i);
        if (this.f7011i == DownloadStatus.NONE) {
            m7501a(DownloadStatus.INITING);
            new Thread(this).start();
        }
    }
}
