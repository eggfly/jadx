package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ia implements aa {
    private long DW;
    private final File FH;
    private final int Hw;
    private final Map<String, a> j6;

    static class a {
        public String DW;
        public String FH;
        public long Hw;
        public long VH;
        public long Zo;
        public Map<String, String> gn;
        public long j6;
        public long v5;

        private a() {
        }

        public a(String str, com.google.android.gms.internal.aa.a aVar) {
            this.DW = str;
            this.j6 = (long) aVar.j6.length;
            this.FH = aVar.DW;
            this.Hw = aVar.FH;
            this.v5 = aVar.Hw;
            this.Zo = aVar.v5;
            this.VH = aVar.Zo;
            this.gn = aVar.VH;
        }

        public static a j6(InputStream inputStream) {
            a aVar = new a();
            if (ia.j6(inputStream) != 538247942) {
                throw new IOException();
            }
            aVar.DW = ia.FH(inputStream);
            aVar.FH = ia.FH(inputStream);
            if (aVar.FH.equals("")) {
                aVar.FH = null;
            }
            aVar.Hw = ia.DW(inputStream);
            aVar.v5 = ia.DW(inputStream);
            aVar.Zo = ia.DW(inputStream);
            aVar.VH = ia.DW(inputStream);
            aVar.gn = ia.Hw(inputStream);
            return aVar;
        }

        public com.google.android.gms.internal.aa.a j6(byte[] bArr) {
            com.google.android.gms.internal.aa.a aVar = new com.google.android.gms.internal.aa.a();
            aVar.j6 = bArr;
            aVar.DW = this.FH;
            aVar.FH = this.Hw;
            aVar.Hw = this.v5;
            aVar.v5 = this.Zo;
            aVar.Zo = this.VH;
            aVar.VH = this.gn;
            return aVar;
        }

        public boolean j6(OutputStream outputStream) {
            try {
                ia.j6(outputStream, 538247942);
                ia.j6(outputStream, this.DW);
                ia.j6(outputStream, this.FH == null ? "" : this.FH);
                ia.j6(outputStream, this.Hw);
                ia.j6(outputStream, this.v5);
                ia.j6(outputStream, this.Zo);
                ia.j6(outputStream, this.VH);
                ia.j6(this.gn, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                hq.DW("%s", e.toString());
                return false;
            }
        }
    }

    private static class b extends FilterInputStream {
        private int j6;

        private b(InputStream inputStream) {
            super(inputStream);
            this.j6 = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.j6++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.j6 += read;
            }
            return read;
        }
    }

    public ia(File file) {
        this(file, 5242880);
    }

    public ia(File file, int i) {
        this.j6 = new LinkedHashMap(16, 0.75f, true);
        this.DW = 0;
        this.FH = file;
        this.Hw = i;
    }

    static long DW(InputStream inputStream) {
        return (((((((0 | ((((long) v5(inputStream)) & 255) << null)) | ((((long) v5(inputStream)) & 255) << 8)) | ((((long) v5(inputStream)) & 255) << 16)) | ((((long) v5(inputStream)) & 255) << 24)) | ((((long) v5(inputStream)) & 255) << 32)) | ((((long) v5(inputStream)) & 255) << 40)) | ((((long) v5(inputStream)) & 255) << 48)) | ((((long) v5(inputStream)) & 255) << 56);
    }

    static String FH(InputStream inputStream) {
        return new String(j6(inputStream, (int) DW(inputStream)), "UTF-8");
    }

    private String Hw(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> Hw(InputStream inputStream) {
        int j6 = j6(inputStream);
        Map<String, String> emptyMap = j6 == 0 ? Collections.emptyMap() : new HashMap(j6);
        for (int i = 0; i < j6; i++) {
            emptyMap.put(FH(inputStream).intern(), FH(inputStream).intern());
        }
        return emptyMap;
    }

    static int j6(InputStream inputStream) {
        return ((((v5(inputStream) << 0) | 0) | (v5(inputStream) << 8)) | (v5(inputStream) << 16)) | (v5(inputStream) << 24);
    }

    private void j6(int i) {
        if (this.DW + ((long) i) >= ((long) this.Hw)) {
            int i2;
            if (hq.DW) {
                hq.j6("Pruning old cache entries.", new Object[0]);
            }
            long j = this.DW;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.j6.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                a aVar = (a) ((Entry) it.next()).getValue();
                if (FH(aVar.DW).delete()) {
                    this.DW -= aVar.j6;
                } else {
                    hq.DW("Could not delete cache entry for key=%s, filename=%s", aVar.DW, Hw(aVar.DW));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.DW + ((long) i))) < ((float) this.Hw) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (hq.DW) {
                hq.j6("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.DW - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void j6(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void j6(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void j6(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        j6(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void j6(String str, a aVar) {
        if (this.j6.containsKey(str)) {
            a aVar2 = (a) this.j6.get(str);
            this.DW = (aVar.j6 - aVar2.j6) + this.DW;
        } else {
            this.DW += aVar.j6;
        }
        this.j6.put(str, aVar);
    }

    static void j6(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            j6(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                j6(outputStream, (String) entry.getKey());
                j6(outputStream, (String) entry.getValue());
            }
            return;
        }
        j6(outputStream, 0);
    }

    private static byte[] j6(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    private static int v5(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void v5(String str) {
        a aVar = (a) this.j6.get(str);
        if (aVar != null) {
            this.DW -= aVar.j6;
            this.j6.remove(str);
        }
    }

    public synchronized void DW(String str) {
        boolean delete = FH(str).delete();
        v5(str);
        if (!delete) {
            hq.DW("Could not delete cache entry for key=%s, filename=%s", str, Hw(str));
        }
    }

    public File FH(String str) {
        return new File(this.FH, Hw(str));
    }

    public synchronized com.google.android.gms.internal.aa.a j6(String str) {
        com.google.android.gms.internal.aa.a aVar;
        b bVar;
        IOException e;
        Throwable th;
        a aVar2 = (a) this.j6.get(str);
        if (aVar2 == null) {
            aVar = null;
        } else {
            File FH = FH(str);
            try {
                bVar = new b(null);
                try {
                    a.j6((InputStream) bVar);
                    aVar = aVar2.j6(j6((InputStream) bVar, (int) (FH.length() - ((long) bVar.j6))));
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e2) {
                            aVar = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        hq.DW("%s: %s", FH.getAbsolutePath(), e.toString());
                        DW(str);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e4) {
                                aVar = null;
                            }
                        }
                        aVar = null;
                        return aVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e5) {
                                aVar = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                bVar = null;
                hq.DW("%s: %s", FH.getAbsolutePath(), e.toString());
                DW(str);
                if (bVar != null) {
                    bVar.close();
                }
                aVar = null;
                return aVar;
            } catch (Throwable th3) {
                th = th3;
                bVar = null;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        }
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j6() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.FH;	 Catch:{ all -> 0x006d }
        r1 = r1.exists();	 Catch:{ all -> 0x006d }
        if (r1 != 0) goto L_0x0026;
    L_0x000a:
        r0 = r9.FH;	 Catch:{ all -> 0x006d }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006d }
        if (r0 != 0) goto L_0x0024;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006d }
        r2 = 0;
        r3 = r9.FH;	 Catch:{ all -> 0x006d }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006d }
        r1[r2] = r3;	 Catch:{ all -> 0x006d }
        com.google.android.gms.internal.hq.FH(r0, r1);	 Catch:{ all -> 0x006d }
    L_0x0024:
        monitor-exit(r9);
        return;
    L_0x0026:
        r1 = r9.FH;	 Catch:{ all -> 0x006d }
        r3 = r1.listFiles();	 Catch:{ all -> 0x006d }
        if (r3 == 0) goto L_0x0024;
    L_0x002e:
        r4 = r3.length;	 Catch:{ all -> 0x006d }
        r2 = r0;
    L_0x0030:
        if (r2 >= r4) goto L_0x0024;
    L_0x0032:
        r5 = r3[r2];	 Catch:{ all -> 0x006d }
        r1 = 0;
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r1 = com.google.android.gms.internal.ia.a.j6(r0);	 Catch:{ IOException -> 0x0079 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0079 }
        r1.j6 = r6;	 Catch:{ IOException -> 0x0079 }
        r6 = r1.DW;	 Catch:{ IOException -> 0x0079 }
        r9.j6(r6, r1);	 Catch:{ IOException -> 0x0079 }
        if (r0 == 0) goto L_0x0053;
    L_0x0050:
        r0.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0053:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0030;
    L_0x0057:
        r0 = move-exception;
        r0 = r1;
    L_0x0059:
        if (r5 == 0) goto L_0x005e;
    L_0x005b:
        r5.delete();	 Catch:{ all -> 0x0074 }
    L_0x005e:
        if (r0 == 0) goto L_0x0053;
    L_0x0060:
        r0.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0053;
    L_0x0064:
        r0 = move-exception;
        goto L_0x0053;
    L_0x0066:
        r0 = move-exception;
    L_0x0067:
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r1.close();	 Catch:{ IOException -> 0x0072 }
    L_0x006c:
        throw r0;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0053;
    L_0x0072:
        r1 = move-exception;
        goto L_0x006c;
    L_0x0074:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0067;
    L_0x0079:
        r1 = move-exception;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ia.j6():void");
    }

    public synchronized void j6(String str, com.google.android.gms.internal.aa.a aVar) {
        j6(aVar.j6.length);
        File FH = FH(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(FH);
            a aVar2 = new a(str, aVar);
            if (aVar2.j6(fileOutputStream)) {
                fileOutputStream.write(aVar.j6);
                fileOutputStream.close();
                j6(str, aVar2);
            } else {
                fileOutputStream.close();
                hq.DW("Failed to write header for %s", FH.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!FH.delete()) {
                hq.DW("Could not clean up file %s", FH.getAbsolutePath());
            }
        }
    }
}
