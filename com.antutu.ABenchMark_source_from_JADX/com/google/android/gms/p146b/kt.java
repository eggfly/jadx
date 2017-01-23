package com.google.android.gms.p146b;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.p146b.C3345w.C3369a;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
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

/* renamed from: com.google.android.gms.b.kt */
public class kt implements C3345w {
    private final Map<String, C3343a> f11690a;
    private long f11691b;
    private final File f11692c;
    private final int f11693d;

    /* renamed from: com.google.android.gms.b.kt.a */
    static class C3343a {
        public long f11681a;
        public String f11682b;
        public String f11683c;
        public long f11684d;
        public long f11685e;
        public long f11686f;
        public long f11687g;
        public Map<String, String> f11688h;

        private C3343a() {
        }

        public C3343a(String str, C3369a c3369a) {
            this.f11682b = str;
            this.f11681a = (long) c3369a.f11746a.length;
            this.f11683c = c3369a.f11747b;
            this.f11684d = c3369a.f11748c;
            this.f11685e = c3369a.f11749d;
            this.f11686f = c3369a.f11750e;
            this.f11687g = c3369a.f11751f;
            this.f11688h = c3369a.f11752g;
        }

        public static C3343a m13737a(InputStream inputStream) {
            C3343a c3343a = new C3343a();
            if (kt.m13744a(inputStream) != 538247942) {
                throw new IOException();
            }
            c3343a.f11682b = kt.m13753c(inputStream);
            c3343a.f11683c = kt.m13753c(inputStream);
            if (c3343a.f11683c.equals(BuildConfig.FLAVOR)) {
                c3343a.f11683c = null;
            }
            c3343a.f11684d = kt.m13752b(inputStream);
            c3343a.f11685e = kt.m13752b(inputStream);
            c3343a.f11686f = kt.m13752b(inputStream);
            c3343a.f11687g = kt.m13752b(inputStream);
            c3343a.f11688h = kt.m13755d(inputStream);
            return c3343a;
        }

        public C3369a m13738a(byte[] bArr) {
            C3369a c3369a = new C3369a();
            c3369a.f11746a = bArr;
            c3369a.f11747b = this.f11683c;
            c3369a.f11748c = this.f11684d;
            c3369a.f11749d = this.f11685e;
            c3369a.f11750e = this.f11686f;
            c3369a.f11751f = this.f11687g;
            c3369a.f11752g = this.f11688h;
            return c3369a;
        }

        public boolean m13739a(OutputStream outputStream) {
            try {
                kt.m13746a(outputStream, 538247942);
                kt.m13748a(outputStream, this.f11682b);
                kt.m13748a(outputStream, this.f11683c == null ? BuildConfig.FLAVOR : this.f11683c);
                kt.m13747a(outputStream, this.f11684d);
                kt.m13747a(outputStream, this.f11685e);
                kt.m13747a(outputStream, this.f11686f);
                kt.m13747a(outputStream, this.f11687g);
                kt.m13750a(this.f11688h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                ke.m13615b("%s", e.toString());
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.b.kt.b */
    private static class C3344b extends FilterInputStream {
        private int f11689a;

        private C3344b(InputStream inputStream) {
            super(inputStream);
            this.f11689a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f11689a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f11689a += read;
            }
            return read;
        }
    }

    public kt(File file) {
        this(file, UtilityImpl.TNET_FILE_SIZE);
    }

    public kt(File file, int i) {
        this.f11690a = new LinkedHashMap(16, 0.75f, true);
        this.f11691b = 0;
        this.f11692c = file;
        this.f11693d = i;
    }

    static int m13744a(InputStream inputStream) {
        return (((0 | (kt.m13756e(inputStream) << 0)) | (kt.m13756e(inputStream) << 8)) | (kt.m13756e(inputStream) << 16)) | (kt.m13756e(inputStream) << 24);
    }

    private void m13745a(int i) {
        if (this.f11691b + ((long) i) >= ((long) this.f11693d)) {
            int i2;
            if (ke.f11609b) {
                ke.m13613a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f11691b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f11690a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C3343a c3343a = (C3343a) ((Entry) it.next()).getValue();
                if (m13762c(c3343a.f11682b).delete()) {
                    this.f11691b -= c3343a.f11681a;
                } else {
                    ke.m13615b("Could not delete cache entry for key=%s, filename=%s", c3343a.f11682b, m13754d(c3343a.f11682b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f11691b + ((long) i))) < ((float) this.f11693d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (ke.f11609b) {
                ke.m13613a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f11691b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m13746a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    static void m13747a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m13748a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes(HttpRequest.f14548a);
        kt.m13747a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m13749a(String str, C3343a c3343a) {
        if (this.f11690a.containsKey(str)) {
            C3343a c3343a2 = (C3343a) this.f11690a.get(str);
            this.f11691b = (c3343a.f11681a - c3343a2.f11681a) + this.f11691b;
        } else {
            this.f11691b += c3343a.f11681a;
        }
        this.f11690a.put(str, c3343a);
    }

    static void m13750a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            kt.m13746a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                kt.m13748a(outputStream, (String) entry.getKey());
                kt.m13748a(outputStream, (String) entry.getValue());
            }
            return;
        }
        kt.m13746a(outputStream, 0);
    }

    private static byte[] m13751a(InputStream inputStream, int i) {
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

    static long m13752b(InputStream inputStream) {
        return (((((((0 | ((((long) kt.m13756e(inputStream)) & 255) << null)) | ((((long) kt.m13756e(inputStream)) & 255) << 8)) | ((((long) kt.m13756e(inputStream)) & 255) << 16)) | ((((long) kt.m13756e(inputStream)) & 255) << 24)) | ((((long) kt.m13756e(inputStream)) & 255) << 32)) | ((((long) kt.m13756e(inputStream)) & 255) << 40)) | ((((long) kt.m13756e(inputStream)) & 255) << 48)) | ((((long) kt.m13756e(inputStream)) & 255) << 56);
    }

    static String m13753c(InputStream inputStream) {
        return new String(kt.m13751a(inputStream, (int) kt.m13752b(inputStream)), HttpRequest.f14548a);
    }

    private String m13754d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> m13755d(InputStream inputStream) {
        int a = kt.m13744a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(kt.m13753c(inputStream).intern(), kt.m13753c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m13756e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m13757e(String str) {
        C3343a c3343a = (C3343a) this.f11690a.get(str);
        if (c3343a != null) {
            this.f11691b -= c3343a.f11681a;
            this.f11690a.remove(str);
        }
    }

    public synchronized C3369a m13758a(String str) {
        C3369a c3369a;
        C3344b c3344b;
        IOException e;
        Throwable th;
        C3343a c3343a = (C3343a) this.f11690a.get(str);
        if (c3343a == null) {
            c3369a = null;
        } else {
            File c = m13762c(str);
            try {
                c3344b = new C3344b(null);
                try {
                    C3343a.m13737a((InputStream) c3344b);
                    c3369a = c3343a.m13738a(kt.m13751a((InputStream) c3344b, (int) (c.length() - ((long) c3344b.f11689a))));
                    if (c3344b != null) {
                        try {
                            c3344b.close();
                        } catch (IOException e2) {
                            c3369a = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ke.m13615b("%s: %s", c.getAbsolutePath(), e.toString());
                        m13761b(str);
                        if (c3344b != null) {
                            try {
                                c3344b.close();
                            } catch (IOException e4) {
                                c3369a = null;
                            }
                        }
                        c3369a = null;
                        return c3369a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c3344b != null) {
                            try {
                                c3344b.close();
                            } catch (IOException e5) {
                                c3369a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c3344b = null;
                ke.m13615b("%s: %s", c.getAbsolutePath(), e.toString());
                m13761b(str);
                if (c3344b != null) {
                    c3344b.close();
                }
                c3369a = null;
                return c3369a;
            } catch (Throwable th3) {
                th = th3;
                c3344b = null;
                if (c3344b != null) {
                    c3344b.close();
                }
                throw th;
            }
        }
        return c3369a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m13759a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f11692c;	 Catch:{ all -> 0x006c }
        r1 = r1.exists();	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f11692c;	 Catch:{ all -> 0x006c }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x006c }
        r2 = 0;
        r3 = r9.f11692c;	 Catch:{ all -> 0x006c }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x006c }
        r1[r2] = r3;	 Catch:{ all -> 0x006c }
        com.google.android.gms.p146b.ke.m13616c(r0, r1);	 Catch:{ all -> 0x006c }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f11692c;	 Catch:{ all -> 0x006c }
        r3 = r1.listFiles();	 Catch:{ all -> 0x006c }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x006c }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x006c }
        r1 = 0;
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x0056, all -> 0x0065 }
        r1 = com.google.android.gms.p146b.kt.C3343a.m13737a(r0);	 Catch:{ IOException -> 0x0078 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0078 }
        r1.f11681a = r6;	 Catch:{ IOException -> 0x0078 }
        r6 = r1.f11682b;	 Catch:{ IOException -> 0x0078 }
        r9.m13749a(r6, r1);	 Catch:{ IOException -> 0x0078 }
        if (r0 == 0) goto L_0x0052;
    L_0x004f:
        r0.close();	 Catch:{ IOException -> 0x006f }
    L_0x0052:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0056:
        r0 = move-exception;
        r0 = r1;
    L_0x0058:
        if (r5 == 0) goto L_0x005d;
    L_0x005a:
        r5.delete();	 Catch:{ all -> 0x0073 }
    L_0x005d:
        if (r0 == 0) goto L_0x0052;
    L_0x005f:
        r0.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0052;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0065:
        r0 = move-exception;
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.close();	 Catch:{ IOException -> 0x0071 }
    L_0x006b:
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006f:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0071:
        r1 = move-exception;
        goto L_0x006b;
    L_0x0073:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0066;
    L_0x0078:
        r1 = move-exception;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.kt.a():void");
    }

    public synchronized void m13760a(String str, C3369a c3369a) {
        m13745a(c3369a.f11746a.length);
        File c = m13762c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C3343a c3343a = new C3343a(str, c3369a);
            if (c3343a.m13739a(fileOutputStream)) {
                fileOutputStream.write(c3369a.f11746a);
                fileOutputStream.close();
                m13749a(str, c3343a);
            } else {
                fileOutputStream.close();
                ke.m13615b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                ke.m13615b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m13761b(String str) {
        boolean delete = m13762c(str).delete();
        m13757e(str);
        if (!delete) {
            ke.m13615b("Could not delete cache entry for key=%s, filename=%s", str, m13754d(str));
        }
    }

    public File m13762c(String str) {
        return new File(this.f11692c, m13754d(str));
    }
}
