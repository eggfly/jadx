package com.aide.ui.build.packagingservice;

import ahl;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.aide.common.w;
import com.aide.ui.build.android.i;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import qh;
import tq;
import tt;
import tu;
import wq;
import yi;
import yv;

public class ExternalPackagingService extends Service {
    private final com.aide.ui.build.packagingservice.a.a DW;
    private b j6;

    class 1 extends com.aide.ui.build.packagingservice.a.a {
        final /* synthetic */ ExternalPackagingService j6;

        1(ExternalPackagingService externalPackagingService) {
            this.j6 = externalPackagingService;
        }

        public void j6(b bVar) {
            this.j6.j6.j6(bVar);
        }

        public void j6(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
            this.j6.j6.j6(str, strArr, strArr2, strArr3, str2, str3, str4, strArr4, str5, str6, str7, str8, str9, z, z2, z3);
        }

        public void j6() {
            this.j6.j6.j6();
        }
    }

    private interface a {
        String DW(String str);

        boolean j6(String str);
    }

    private class b {
        private b DW;
        private ExecutorService FH;
        private c Hw;
        final /* synthetic */ ExternalPackagingService j6;
        private List<b> v5;

        class 1 implements ThreadFactory {
            final /* synthetic */ b DW;
            final /* synthetic */ ExternalPackagingService j6;

            1(b bVar, ExternalPackagingService externalPackagingService) {
                this.DW = bVar;
                this.j6 = externalPackagingService;
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(null, runnable, "ExternalPackaginServiceWorker", 1048576);
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ b DW;
            final /* synthetic */ b j6;

            2(b bVar, b bVar2) {
                this.DW = bVar;
                this.j6 = bVar2;
            }

            public void run() {
                this.DW.DW = this.j6;
            }
        }

        private class a implements Callable<Void> {
            private List<b> DW;
            final /* synthetic */ b j6;

            public /* synthetic */ Object call() {
                return j6();
            }

            public a(b bVar, List<b> list) {
                this.j6 = bVar;
                this.DW = list;
            }

            public Void j6() {
                for (b j6 : this.DW) {
                    j6.j6();
                }
                return null;
            }
        }

        private class b {
            private final String DW;
            private final String EQ;
            private String[] FH;
            private String[] Hw;
            private final String J0;
            private final String J8;
            private tt Mr;
            private final boolean QX;
            private final String VH;
            private final boolean Ws;
            private final boolean XL;
            private final String Zo;
            private String aM;
            private final String gn;
            private tq j3;
            final /* synthetic */ b j6;
            private final String tp;
            private final String[] u7;
            private String[] v5;
            private final String we;

            class 1 implements a {
                final /* synthetic */ b j6;

                1(b bVar) {
                    this.j6 = bVar;
                }

                public boolean j6(String str) {
                    if (new File(str).getName().startsWith(".")) {
                        return false;
                    }
                    if (str.endsWith(File.separator)) {
                        return true;
                    }
                    if (str.endsWith(".so")) {
                        return true;
                    }
                    return false;
                }

                public String DW(String str) {
                    String[] split = str.split("/");
                    if (split.length >= 2) {
                        return "lib/" + split[split.length - 2] + "/" + split[split.length - 1];
                    }
                    return str;
                }
            }

            public b(b bVar, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
                this.j6 = bVar;
                this.DW = str;
                this.FH = strArr;
                this.Hw = strArr2;
                this.v5 = strArr3;
                this.Zo = str2;
                this.VH = str3;
                this.gn = str4;
                this.u7 = strArr4;
                this.tp = str5;
                this.Ws = z;
                this.EQ = str6;
                this.we = str7;
                this.J0 = str8;
                this.J8 = str9;
                this.QX = z2;
                this.XL = z3;
                this.j3 = DW();
            }

            private tq DW() {
                tq tqVar = new tq();
                tqVar.j6 = 13;
                return tqVar;
            }

            private tt j6(PrintStream printStream) {
                tt ttVar = new tt();
                ttVar.Hw = this.QX;
                ttVar.FH = false;
                ttVar.gn = printStream;
                return ttVar;
            }

            private void j6(String str, int i) {
                this.aM = str;
                this.j6.j6(str + "...", i);
            }

            public void j6() {
                List Hw = Hw();
                if (this.tp.endsWith(".zip")) {
                    j6(Hw);
                    return;
                }
                DW(Hw);
                FH();
            }

            private void j6(List<String> list) {
                e eVar = new e(new FileOutputStream(this.tp));
                try {
                    for (String str : list) {
                        j6(new File(str).getParentFile(), new File(str), eVar, null, false);
                    }
                } finally {
                    try {
                        eVar.close();
                    } catch (Throwable e) {
                        com.aide.common.e.j6(e);
                    }
                }
            }

            private void FH() {
                Throwable th;
                InputStream inputStream = null;
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                j6("Signing APK", 90);
                File file = new File(this.tp + "-unsigned");
                File file2 = new File(this.tp);
                if (file2.exists()) {
                    file2.delete();
                }
                if (qh.J0(this.EQ)) {
                    try {
                        KeyStore iVar = new i();
                        InputStream fileInputStream = new FileInputStream(this.EQ);
                        try {
                            iVar.load(fileInputStream, this.we.toCharArray());
                            X509Certificate x509Certificate = (X509Certificate) iVar.getCertificateChain(this.J0)[0];
                            PrivateKey privateKey = (PrivateKey) iVar.getKey(this.J0, this.J8.toCharArray());
                            ahl ahl = new ahl();
                            ahl.j6("custom", x509Certificate, privateKey, null);
                            ahl.j6(file.getPath(), file2.getPath());
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = fileInputStream;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                }
                ahl ahl2 = new ahl();
                ahl2.j6("auto-testkey");
                ahl2.j6(file.getPath(), file2.getPath());
                file.delete();
            }

            private void DW(List<String> list) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                j6("Building APK", 80);
                File file = new File(this.tp + "-unsigned");
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                OutputStream fileOutputStream = new FileOutputStream(file);
                e eVar;
                try {
                    int i;
                    String str;
                    String str2;
                    eVar = new e(fileOutputStream);
                    com.aide.common.e.j6("Adding aapt generated resources from " + this.gn);
                    j6(this.gn, null, eVar, true);
                    for (i = 0; i < list.size(); i++) {
                        str = (String) list.get(i);
                        com.aide.common.e.j6("Adding classes.dex from " + str);
                        if (i == 0) {
                            str2 = "classes.dex";
                        } else {
                            str2 = "classes" + (i + 1) + ".dex";
                        }
                        j6(str2, null, new File(str), eVar, null, false);
                    }
                    for (String str22 : this.Hw) {
                        com.aide.common.e.j6("Adding resources from source dir " + str22);
                        j6(new File(str22), new File(str22), eVar, new d(), false);
                    }
                    for (String str3 : this.u7) {
                        if (new File(str3).exists()) {
                            com.aide.common.e.j6("Adding native libs from " + str3);
                            j6(new File(str3).getParentFile(), new File(str3), eVar, new 1(this), false);
                        }
                        for (String str4 : this.v5) {
                            com.aide.common.e.j6("Adding resources from JAR " + str4);
                            j6(str4, new c(), eVar, false);
                        }
                    }
                    eVar.close();
                } catch (Throwable e) {
                    com.aide.common.e.j6(e);
                } catch (Throwable th) {
                    fileOutputStream.close();
                }
                fileOutputStream.close();
            }

            private void j6(String str, a aVar, e eVar, boolean z) {
                if (new File(str).exists()) {
                    InputStream fileInputStream = new FileInputStream(str);
                    ZipInputStream zipInputStream;
                    try {
                        zipInputStream = new ZipInputStream(fileInputStream);
                        j6(zipInputStream, eVar, aVar, z);
                        zipInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable th) {
                        fileInputStream.close();
                    }
                } else {
                    com.aide.common.e.Hw("JAR file not found: " + str);
                }
            }

            private List<String> Hw() {
                List<String> arrayList = new ArrayList();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                j6("Dexing", 60);
                File file = new File(this.VH);
                if (file.exists() || file.mkdirs()) {
                    int i;
                    String str;
                    long currentTimeMillis;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    List arrayList2 = new ArrayList();
                    Collection<String> arrayList3 = new ArrayList();
                    j6(this.v5, arrayList2, (List) arrayList3, !this.Ws);
                    List arrayList4 = new ArrayList();
                    Map hashMap = new HashMap();
                    j6(new File(this.DW), arrayList4, hashMap, !this.Ws);
                    for (String str2 : this.FH) {
                        if (!str2.equals(this.DW)) {
                            j6(new File(str2), arrayList4, hashMap, !this.Ws);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        j6("Dexing - Libraries", 60);
                        currentTimeMillis = System.currentTimeMillis();
                        i = 0;
                        while (i < arrayList2.size()) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            str2 = (String) arrayList2.get(i);
                            try {
                                j6(str2);
                                com.aide.common.e.j6("Dexing " + new File(str2).getName() + " elapsed " + (System.currentTimeMillis() - currentTimeMillis3) + "ms");
                                i++;
                            } catch (Throwable th) {
                                com.aide.common.e.j6("Error dexing " + new File(str2).getName());
                            }
                        }
                        com.aide.common.e.j6("Dexing JAR files elapsed " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                    if (arrayList4.size() > 0) {
                        j6("Dexing - Classes", 60);
                        currentTimeMillis = System.currentTimeMillis();
                        for (i = 0; i < arrayList4.size(); i++) {
                            str2 = (String) arrayList4.get(i);
                            j6(str2, DW(str2));
                        }
                        com.aide.common.e.j6("Dexing .class files elapsed " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                    j6("Dexing - Merging", 60);
                    if (this.XL) {
                        List<String> arrayList5 = new ArrayList();
                        Collection arrayList6 = new ArrayList();
                        for (String str22 : arrayList3) {
                            if (new File(str22).getParentFile().getName().startsWith("multidex-")) {
                                arrayList6.add(str22);
                            } else {
                                arrayList5.add(str22);
                            }
                        }
                        str22 = this.Zo + "/classes.dex";
                        arrayList.add(str22);
                        j6(str22, hashMap.values(), arrayList6);
                        for (String str222 : arrayList5) {
                            arrayList.add(FH(str222));
                        }
                    } else {
                        str222 = this.Zo + "/classes.dex";
                        arrayList.add(str222);
                        j6(str222, hashMap.values(), (Collection) arrayList3);
                    }
                    com.aide.common.e.j6("Dexing elapsed " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                    return arrayList;
                }
                throw new IOException("Could not create DX JAR dir " + this.VH);
            }

            private void j6(String str, Collection<String> collection, Collection<String> collection2) {
                long currentTimeMillis = System.currentTimeMillis();
                yv yvVar = new yv();
                long currentTimeMillis2 = System.currentTimeMillis();
                for (String str2 : collection) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    yvVar.j6(new yi(new File(DW(str2))));
                }
                for (String str22 : collection2) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    yvVar.j6(new yi(new File(FH(str22))));
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                com.aide.common.e.j6("Dex merging stage 1 elapsed " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                currentTimeMillis2 = System.currentTimeMillis();
                yvVar.DW();
                com.aide.common.e.j6("Dex merging stage 2 elapsed " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                currentTimeMillis2 = System.currentTimeMillis();
                for (String str222 : collection) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    yvVar.DW(new yi(new File(DW(str222))));
                }
                for (String str2222 : collection2) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    yvVar.DW(new yi(new File(FH(str2222))));
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                com.aide.common.e.j6("Dex merging stage 3 elapsed " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                currentTimeMillis2 = System.currentTimeMillis();
                yvVar.j6();
                com.aide.common.e.j6("Dex merging stage 4 elapsed " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                com.aide.common.e.j6("Dex merging elapsed " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                new File(str).getParentFile().mkdirs();
                OutputStream fileOutputStream = new FileOutputStream(str);
                try {
                    yvVar.j6(fileOutputStream);
                } finally {
                    fileOutputStream.close();
                }
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void j6(java.lang.String r11) {
                /*
                r10 = this;
                r0 = java.lang.Thread.interrupted();
                if (r0 == 0) goto L_0x000c;
            L_0x0006:
                r0 = new java.lang.InterruptedException;
                r0.<init>();
                throw r0;
            L_0x000c:
                r0 = r10.FH(r11);
                r1 = new java.io.File;
                r1.<init>(r0);
                r1 = r1.getParentFile();
                r2 = r1.exists();
                if (r2 != 0) goto L_0x0043;
            L_0x001f:
                r2 = r1.mkdirs();
                if (r2 != 0) goto L_0x0043;
            L_0x0025:
                r0 = new java.io.IOException;
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "Could not create DX JAR dir ";
                r2 = r2.append(r3);
                r1 = r1.getPath();
                r1 = r2.append(r1);
                r1 = r1.toString();
                r0.<init>(r1);
                throw r0;
            L_0x0043:
                r2 = new java.io.File;
                r2.<init>(r11);
                r2 = r2.getName();
                r3 = ".dex.zip";
                r1 = java.io.File.createTempFile(r2, r3, r1);
                r2 = java.lang.Thread.interrupted();	 Catch:{ all -> 0x005f }
                if (r2 == 0) goto L_0x0064;
            L_0x0059:
                r0 = new java.lang.InterruptedException;	 Catch:{ all -> 0x005f }
                r0.<init>();	 Catch:{ all -> 0x005f }
                throw r0;	 Catch:{ all -> 0x005f }
            L_0x005f:
                r0 = move-exception;
                r1.delete();
                throw r0;
            L_0x0064:
                r10.j6(r11, r1);	 Catch:{ all -> 0x005f }
                r2 = new yv;	 Catch:{ all -> 0x005f }
                r2.<init>();	 Catch:{ all -> 0x005f }
                r3 = new java.io.FileInputStream;	 Catch:{ all -> 0x005f }
                r3.<init>(r1);	 Catch:{ all -> 0x005f }
                r4 = new java.util.zip.ZipInputStream;	 Catch:{ all -> 0x008d }
                r4.<init>(r3);	 Catch:{ all -> 0x008d }
            L_0x0076:
                r5 = r4.getNextEntry();	 Catch:{ all -> 0x0088 }
                if (r5 == 0) goto L_0x00ad;
            L_0x007c:
                r6 = java.lang.Thread.interrupted();	 Catch:{ all -> 0x0088 }
                if (r6 == 0) goto L_0x0092;
            L_0x0082:
                r0 = new java.lang.InterruptedException;	 Catch:{ all -> 0x0088 }
                r0.<init>();	 Catch:{ all -> 0x0088 }
                throw r0;	 Catch:{ all -> 0x0088 }
            L_0x0088:
                r0 = move-exception;
                r4.close();	 Catch:{ all -> 0x008d }
                throw r0;	 Catch:{ all -> 0x008d }
            L_0x008d:
                r0 = move-exception;
                r3.close();	 Catch:{ all -> 0x005f }
                throw r0;	 Catch:{ all -> 0x005f }
            L_0x0092:
                r6 = r5.getName();	 Catch:{ all -> 0x0088 }
                r7 = ".dex";
                r6 = r6.endsWith(r7);	 Catch:{ all -> 0x0088 }
                if (r6 == 0) goto L_0x0076;
            L_0x009f:
                r6 = new yi;	 Catch:{ all -> 0x0088 }
                r8 = r5.getSize();	 Catch:{ all -> 0x0088 }
                r5 = (int) r8;	 Catch:{ all -> 0x0088 }
                r6.<init>(r4, r5);	 Catch:{ all -> 0x0088 }
                r2.j6(r6);	 Catch:{ all -> 0x0088 }
                goto L_0x0076;
            L_0x00ad:
                r4.close();	 Catch:{ all -> 0x008d }
                r3.close();	 Catch:{ all -> 0x005f }
                r3 = java.lang.Thread.interrupted();	 Catch:{ all -> 0x005f }
                if (r3 == 0) goto L_0x00bf;
            L_0x00b9:
                r0 = new java.lang.InterruptedException;	 Catch:{ all -> 0x005f }
                r0.<init>();	 Catch:{ all -> 0x005f }
                throw r0;	 Catch:{ all -> 0x005f }
            L_0x00bf:
                r2.DW();	 Catch:{ all -> 0x005f }
                r3 = new java.io.FileInputStream;	 Catch:{ all -> 0x005f }
                r3.<init>(r1);	 Catch:{ all -> 0x005f }
                r4 = new java.util.zip.ZipInputStream;	 Catch:{ all -> 0x00e3 }
                r4.<init>(r3);	 Catch:{ all -> 0x00e3 }
            L_0x00cc:
                r5 = r4.getNextEntry();	 Catch:{ all -> 0x00de }
                if (r5 == 0) goto L_0x0103;
            L_0x00d2:
                r6 = java.lang.Thread.interrupted();	 Catch:{ all -> 0x00de }
                if (r6 == 0) goto L_0x00e8;
            L_0x00d8:
                r0 = new java.lang.InterruptedException;	 Catch:{ all -> 0x00de }
                r0.<init>();	 Catch:{ all -> 0x00de }
                throw r0;	 Catch:{ all -> 0x00de }
            L_0x00de:
                r0 = move-exception;
                r4.close();	 Catch:{ all -> 0x00e3 }
                throw r0;	 Catch:{ all -> 0x00e3 }
            L_0x00e3:
                r0 = move-exception;
                r3.close();	 Catch:{ all -> 0x005f }
                throw r0;	 Catch:{ all -> 0x005f }
            L_0x00e8:
                r6 = r5.getName();	 Catch:{ all -> 0x00de }
                r7 = ".dex";
                r6 = r6.endsWith(r7);	 Catch:{ all -> 0x00de }
                if (r6 == 0) goto L_0x00cc;
            L_0x00f5:
                r6 = new yi;	 Catch:{ all -> 0x00de }
                r8 = r5.getSize();	 Catch:{ all -> 0x00de }
                r5 = (int) r8;	 Catch:{ all -> 0x00de }
                r6.<init>(r4, r5);	 Catch:{ all -> 0x00de }
                r2.DW(r6);	 Catch:{ all -> 0x00de }
                goto L_0x00cc;
            L_0x0103:
                r4.close();	 Catch:{ all -> 0x00e3 }
                r3.close();	 Catch:{ all -> 0x005f }
                r2.j6();	 Catch:{ all -> 0x005f }
                r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x005f }
                r3.<init>(r0);	 Catch:{ all -> 0x005f }
                r2.j6(r3);	 Catch:{ all -> 0x0126 }
                r3.close();	 Catch:{ all -> 0x005f }
                r1.delete();
                r0 = java.lang.Thread.interrupted();
                if (r0 == 0) goto L_0x012b;
            L_0x0120:
                r0 = new java.lang.InterruptedException;
                r0.<init>();
                throw r0;
            L_0x0126:
                r0 = move-exception;
                r3.close();	 Catch:{ all -> 0x005f }
                throw r0;	 Catch:{ all -> 0x005f }
            L_0x012b:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.build.packagingservice.ExternalPackagingService.b.b.j6(java.lang.String):void");
            }

            private void j6(String str, File file) {
                InputStream fileInputStream = new FileInputStream(str);
                try {
                    InputStream zipInputStream = new ZipInputStream(fileInputStream);
                    DataInputStream dataInputStream = new DataInputStream(zipInputStream);
                    try {
                        OutputStream fileOutputStream = new FileOutputStream(file);
                        e eVar;
                        try {
                            eVar = new e(fileOutputStream);
                            eVar.setLevel(0);
                            ZipEntry zipEntry = new ZipEntry("placeholder.txt");
                            zipEntry.setSize(0);
                            eVar.putNextEntry(zipEntry);
                            eVar.closeEntry();
                            while (true) {
                                zipEntry = zipInputStream.getNextEntry();
                                if (zipEntry == null) {
                                    try {
                                        break;
                                    } catch (Throwable e) {
                                        com.aide.common.e.j6("Exception closing zip out for " + str);
                                        com.aide.common.e.j6(e);
                                    }
                                } else if (zipEntry.getName().toLowerCase().endsWith(".class")) {
                                    byte[] j6 = j6(dataInputStream, zipEntry.getName(), (int) zipEntry.getSize());
                                    ZipEntry zipEntry2 = new ZipEntry(zipEntry.getName() + ".dex");
                                    zipEntry2.setSize((long) j6.length);
                                    if (eVar.j6(zipEntry.getName())) {
                                        com.aide.common.e.Hw("Ignoring duplicate entry '" + zipEntry.getName() + "' while writing DEX file for '" + str);
                                    } else {
                                        eVar.putNextEntry(zipEntry2);
                                        eVar.write(j6);
                                        eVar.closeEntry();
                                    }
                                }
                            }
                            eVar.close();
                            fileOutputStream.close();
                            fileInputStream.close();
                        } catch (Throwable th) {
                            fileOutputStream.close();
                        }
                    } finally {
                        zipInputStream.close();
                    }
                } catch (Throwable th2) {
                    fileInputStream.close();
                }
            }

            private byte[] j6(DataInputStream dataInputStream, String str, int i) {
                byte[] toByteArray;
                wq wqVar = new wq(this.j3);
                if (i < 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    w.j6(dataInputStream, byteArrayOutputStream, false);
                    toByteArray = byteArrayOutputStream.toByteArray();
                } else {
                    toByteArray = new byte[i];
                    dataInputStream.readFully(toByteArray);
                }
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream2);
                this.Mr = j6(printStream);
                try {
                    wqVar.j6(tu.j6(str, toByteArray, this.Mr, this.j3));
                    return wqVar.j6(null, false);
                } catch (Throwable e) {
                    printStream.flush();
                    com.aide.common.e.j6("Exception while dexing " + str);
                    com.aide.common.e.j6("Dexer error output " + new String(byteArrayOutputStream2.toByteArray()));
                    throw new RuntimeException(e);
                }
            }

            private String DW(String str) {
                return str.substring(0, str.length() - ".class".length()) + ".dex";
            }

            private String FH(String str) {
                String Hw = Hw(str);
                if (Hw != null) {
                    return new File(Hw, new File(str).getName() + ".dex").getPath();
                }
                return new File(this.VH, new File(str).getName() + ".dex").getPath();
            }

            private String Hw(String str) {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (parentFile.getName().endsWith(".aar") && "classes.jar".equals(file.getName())) {
                    return parentFile.getPath() + "/bin/jardex";
                }
                if ("libs".equals(parentFile.getName()) && parentFile.getParentFile().getName().endsWith(".aar")) {
                    return parentFile.getParentFile().getPath() + "/bin/jardex";
                }
                return null;
            }

            private void j6(File file, List<String> list, Map<String, String> map, boolean z) {
                j6(file, file, (List) list, (Map) map, z);
            }

            private void j6(File file, File file2, List<String> list, Map<String, String> map, boolean z) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        if (file3.isDirectory()) {
                            j6(file, file3, (List) list, (Map) map, z);
                        } else if (file3.isFile()) {
                            String path = file3.getPath();
                            if (path.toLowerCase().endsWith(".class")) {
                                String substring = path.substring(file.getPath().length());
                                if (map.containsKey(substring)) {
                                    com.aide.common.e.j6("Ignoring duplicate .class file " + path);
                                } else {
                                    map.put(substring, path);
                                    if (z) {
                                        File file4 = new File(DW(path));
                                        if (file4.isFile() && file4.lastModified() >= file3.lastModified()) {
                                        }
                                    }
                                    list.add(path);
                                }
                            }
                        }
                    }
                }
            }

            private void j6(String[] strArr, List<String> list, List<String> list2, boolean z) {
                for (String str : strArr) {
                    if (str.toLowerCase().endsWith(".jar") && new File(str).exists()) {
                        list2.add(str);
                        if (z) {
                            File file = new File(FH(str));
                            if (file.isFile() && file.lastModified() >= new File(str).lastModified()) {
                            }
                        }
                        list.add(str);
                    }
                }
            }

            private void j6(String str, String str2) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                InputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    fileOutputStream.write(j6(new DataInputStream(fileInputStream), str, (int) new File(str).length()));
                    fileOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    fileInputStream.close();
                }
            }

            private void j6(File file, File file2, e eVar, a aVar, boolean z) {
                if (file != null && file.exists()) {
                    j6(file2.getPath().substring(file.getPath().length()), file, file2, eVar, aVar, z);
                }
            }

            private void j6(String str, File file, File file2, e eVar, a aVar, boolean z) {
                String str2;
                if (!file2.isDirectory() || str.endsWith(File.separator)) {
                    str2 = str;
                } else {
                    str2 = str + File.separator;
                }
                if (aVar == null || aVar.j6(r1)) {
                    while (str.startsWith(File.separator)) {
                        str = str.substring(1);
                    }
                    if (aVar != null) {
                        str = aVar.DW(str);
                    }
                    if (file2.isDirectory()) {
                        if (str.length() != 0 && z) {
                            if (!str.endsWith(File.separator)) {
                                str = str + File.separator;
                            }
                            ZipEntry zipEntry = new ZipEntry(str);
                            zipEntry.setTime(file2.lastModified());
                            eVar.putNextEntry(zipEntry);
                            eVar.closeEntry();
                        }
                        for (File j6 : file2.listFiles()) {
                            j6(file, j6, eVar, aVar, z);
                        }
                        return;
                    }
                    ZipEntry zipEntry2 = new ZipEntry(str);
                    zipEntry2.setTime(file2.lastModified());
                    if (eVar.j6(str)) {
                        com.aide.common.e.Hw("Ignoring duplicate entry '" + str + "' while writing APK file");
                        return;
                    }
                    eVar.putNextEntry(zipEntry2);
                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        w.j6(bufferedInputStream, eVar, false);
                        eVar.closeEntry();
                    } finally {
                        bufferedInputStream.close();
                    }
                }
            }

            private void j6(ZipInputStream zipInputStream, e eVar, a aVar, boolean z) {
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        j6(nextEntry, zipInputStream, eVar, aVar, z);
                    } else {
                        return;
                    }
                }
            }

            private void j6(ZipEntry zipEntry, ZipInputStream zipInputStream, e eVar, a aVar, boolean z) {
                if (aVar != null && !aVar.j6(zipEntry.getName())) {
                    return;
                }
                if (zipEntry.isDirectory()) {
                    ZipEntry zipEntry2 = new ZipEntry(zipEntry.getName());
                    zipEntry2.setTime(zipEntry.getTime());
                    eVar.putNextEntry(zipEntry2);
                    eVar.closeEntry();
                    return;
                }
                zipEntry2 = new ZipEntry(zipEntry.getName());
                if (z && zipEntry.getMethod() != -1) {
                    if (zipEntry.getMethod() == 0) {
                        zipEntry2.setCrc(zipEntry.getCrc());
                        zipEntry2.setSize(zipEntry.getSize());
                    }
                    zipEntry2.setMethod(zipEntry.getMethod());
                }
                zipEntry2.setTime(zipEntry.getTime());
                if (eVar.j6(zipEntry2.getName())) {
                    com.aide.common.e.Hw("Ignoring duplicate entry '" + zipEntry2.getName() + "' while writing APK file");
                    return;
                }
                eVar.putNextEntry(zipEntry2);
                w.j6(zipInputStream, eVar, false);
            }
        }

        private class c extends FutureTask<Void> {
            private a DW;
            final /* synthetic */ b j6;

            public c(b bVar, a aVar) {
                this.j6 = bVar;
                super(aVar);
                this.DW = aVar;
            }

            protected void done() {
                if (!isCancelled()) {
                    try {
                        get();
                        this.j6.FH();
                    } catch (InterruptedException e) {
                        this.j6.Hw();
                    } catch (ExecutionException e2) {
                        ExecutionException executionException = e2;
                        String str = "Packaging error";
                        if (executionException.getMessage() != null) {
                            str = str + ": " + executionException.getMessage();
                        }
                        this.j6.j6(str, executionException.getCause());
                    }
                }
            }
        }

        public b(ExternalPackagingService externalPackagingService) {
            this.j6 = externalPackagingService;
            this.FH = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new 1(this, externalPackagingService));
        }

        public void j6(b bVar) {
            this.FH.execute(new 2(this, bVar));
        }

        public void j6() {
            if (this.Hw != null) {
                this.Hw.cancel(true);
                this.Hw = null;
            }
            this.Hw = new c(this, new a(this, this.v5));
            this.v5 = null;
            this.FH.execute(this.Hw);
        }

        public void j6(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
            if (this.v5 == null) {
                this.v5 = new ArrayList();
            }
            List list = this.v5;
            r19.add(new b(this, str, strArr, strArr2, strArr3, str2, str3, str4, strArr4, str5, str6, str7, str8, str9, z, z2, z3));
        }

        private void FH() {
            if (this.DW != null) {
                try {
                    this.DW.j6(true);
                } catch (Throwable e) {
                    this.DW = null;
                    com.aide.common.e.j6(e);
                }
            }
        }

        private void Hw() {
            if (this.DW != null) {
                try {
                    this.DW.j6();
                } catch (Throwable e) {
                    this.DW = null;
                    com.aide.common.e.j6(e);
                }
            }
        }

        private void j6(String str, Throwable th) {
            com.aide.common.e.j6(th);
            if (this.DW != null) {
                try {
                    this.DW.j6(str);
                } catch (Throwable e) {
                    this.DW = null;
                    com.aide.common.e.j6(e);
                }
            }
        }

        private void j6(String str, int i) {
            if (this.DW != null) {
                try {
                    this.DW.j6(str, i);
                } catch (Throwable e) {
                    this.DW = null;
                    com.aide.common.e.j6(e);
                }
            }
        }

        public void DW() {
            this.FH.shutdown();
        }
    }

    private static class c implements a {
        private c() {
        }

        public boolean j6(String str) {
            if (new File(str).getName().startsWith(".")) {
                return false;
            }
            String toLowerCase = str.replace('\\', '/').toLowerCase();
            if (toLowerCase.endsWith(".class") || toLowerCase.endsWith(".java") || toLowerCase.startsWith("meta-inf/")) {
                return false;
            }
            return true;
        }

        public String DW(String str) {
            return str;
        }
    }

    private static class d implements a {
        private d() {
        }

        public boolean j6(String str) {
            if (new File(str).getName().startsWith(".")) {
                return false;
            }
            String toLowerCase = str.replace('\\', '/').toLowerCase();
            if (toLowerCase.endsWith(".java") || toLowerCase.endsWith(".class") || toLowerCase.endsWith(".aidl") || toLowerCase.endsWith("/package.html")) {
                return false;
            }
            return true;
        }

        public String DW(String str) {
            return str;
        }
    }

    private static class e extends ZipOutputStream {
        private HashSet<String> j6;

        public e(OutputStream outputStream) {
            super(outputStream);
            this.j6 = new HashSet();
        }

        public boolean j6(String str) {
            return this.j6.contains(str);
        }

        public void putNextEntry(ZipEntry zipEntry) {
            if (!this.j6.contains(zipEntry.getName())) {
                this.j6.add(zipEntry.getName());
                super.putNextEntry(zipEntry);
            } else if (!zipEntry.isDirectory()) {
                throw new ZipException("Entry already exists: " + zipEntry.getName());
            }
        }
    }

    public ExternalPackagingService() {
        this.j6 = new b(this);
        this.DW = new 1(this);
    }

    public IBinder onBind(Intent intent) {
        com.aide.common.e.DW("ExternalPackagingService bound - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        return this.DW;
    }

    public void onDestroy() {
        com.aide.common.e.DW("ExternalPackagingService shutdown - pid " + Process.myPid() + " id " + System.identityHashCode(this));
        this.j6.DW();
        this.j6 = null;
    }
}
