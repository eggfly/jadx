package com.miui.support.net.http;

import android.util.Log;
import com.miui.support.net.http.Cache.Entry;
import com.miui.support.security.DigestUtils;
import com.miui.support.text.ExtraTextUtils;
import com.miui.support.util.AppConstants;
import com.miui.support.util.IOUtils;
import com.miui.support.util.SoftReferenceSingleton;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DiskBasedCache implements Cache {
    private static final SoftReferenceSingleton<DiskBasedCache> f3429e;
    private final Map<String, DiskCacheEntry> f3430a;
    private long f3431b;
    private final File f3432c;
    private final int f3433d;

    /* renamed from: com.miui.support.net.http.DiskBasedCache.1 */
    final class C04071 extends SoftReferenceSingleton<DiskBasedCache> {
        C04071() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5107a();
        }

        protected DiskBasedCache m5107a() {
            DiskBasedCache diskBasedCache = new DiskBasedCache();
            diskBasedCache.m5131b();
            return diskBasedCache;
        }
    }

    private static class CacheFileContentInputStream extends FilterInputStream {
        private DiskCacheEntry f3415a;

        protected CacheFileContentInputStream(DiskCacheEntry diskCacheEntry) {
            super(m5108a(diskCacheEntry));
            if (this.in != null) {
                this.f3415a = diskCacheEntry;
            }
        }

        private static InputStream m5108a(DiskCacheEntry diskCacheEntry) {
            diskCacheEntry.m5121b();
            try {
                InputStream fileInputStream = new FileInputStream(diskCacheEntry.f3416a);
                if (fileInputStream.skip(diskCacheEntry.f3418c) == diskCacheEntry.f3418c) {
                    return fileInputStream;
                }
                throw new IOException("skip failed for file " + diskCacheEntry.f3416a.getName());
            } catch (Throwable th) {
                diskCacheEntry.m5123d();
            }
        }

        public void close() {
            this.f3415a.m5123d();
            super.close();
        }
    }

    private static class DiskCacheEntry {
        public File f3416a;
        public long f3417b;
        public long f3418c;
        public String f3419d;
        public String f3420e;
        public String f3421f;
        public String f3422g;
        public long f3423h;
        public long f3424i;
        public long f3425j;
        public Map<String, String> f3426k;
        private volatile boolean f3427l;
        private volatile int f3428m;

        private DiskCacheEntry() {
        }

        public static DiskCacheEntry m5110a(File file) {
            InputStream inputStream;
            Throwable th;
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    if (m5109a(fileInputStream) != 538182184) {
                        IOUtils.m5387a(fileInputStream);
                        return null;
                    }
                    DiskCacheEntry diskCacheEntry = new DiskCacheEntry();
                    diskCacheEntry.f3419d = m5117c(fileInputStream);
                    diskCacheEntry.f3420e = m5117c(fileInputStream);
                    if ("".equals(diskCacheEntry.f3420e)) {
                        diskCacheEntry.f3420e = null;
                    }
                    diskCacheEntry.f3421f = m5117c(fileInputStream);
                    if ("".equals(diskCacheEntry.f3421f)) {
                        diskCacheEntry.f3421f = null;
                    }
                    diskCacheEntry.f3422g = m5117c(fileInputStream);
                    if ("".equals(diskCacheEntry.f3422g)) {
                        diskCacheEntry.f3422g = null;
                    }
                    diskCacheEntry.f3423h = m5116b(fileInputStream);
                    diskCacheEntry.f3424i = m5116b(fileInputStream);
                    diskCacheEntry.f3425j = m5116b(fileInputStream);
                    diskCacheEntry.f3426k = m5118d(fileInputStream);
                    diskCacheEntry.f3418c = fileInputStream.getChannel().position();
                    diskCacheEntry.f3416a = file;
                    diskCacheEntry.f3417b = file.length();
                    IOUtils.m5387a(fileInputStream);
                    return diskCacheEntry;
                } catch (IOException e) {
                    inputStream = fileInputStream;
                    IOUtils.m5387a(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.m5387a(fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                inputStream = null;
                IOUtils.m5387a(inputStream);
                return null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                IOUtils.m5387a(fileInputStream);
                throw th;
            }
        }

        public static DiskCacheEntry m5111a(File file, String str, Entry entry) {
            OutputStream fileOutputStream;
            Throwable e;
            InputStream inputStream = entry.f3400a;
            try {
                entry.f3400a = null;
                fileOutputStream = new FileOutputStream(file);
                try {
                    m5112a(fileOutputStream, 538182184);
                    m5114a(fileOutputStream, str);
                    m5114a(fileOutputStream, entry.f3402c == null ? "" : entry.f3402c);
                    m5114a(fileOutputStream, entry.f3403d == null ? "" : entry.f3403d);
                    m5114a(fileOutputStream, entry.f3404e == null ? "" : entry.f3404e);
                    m5113a(fileOutputStream, entry.f3405f);
                    m5113a(fileOutputStream, entry.f3406g);
                    m5113a(fileOutputStream, entry.f3407h);
                    m5115a(entry.f3408i, fileOutputStream);
                    fileOutputStream.flush();
                    DiskCacheEntry diskCacheEntry = new DiskCacheEntry();
                    diskCacheEntry.f3419d = str;
                    diskCacheEntry.f3420e = entry.f3402c;
                    diskCacheEntry.f3421f = entry.f3403d;
                    diskCacheEntry.f3422g = entry.f3404e;
                    diskCacheEntry.f3423h = entry.f3405f;
                    diskCacheEntry.f3424i = entry.f3406g;
                    diskCacheEntry.f3425j = entry.f3407h;
                    diskCacheEntry.f3426k = entry.f3408i;
                    diskCacheEntry.f3416a = file;
                    diskCacheEntry.f3418c = fileOutputStream.getChannel().position();
                    IOUtils.m5384a(inputStream, fileOutputStream);
                    fileOutputStream.flush();
                    diskCacheEntry.f3417b = fileOutputStream.getChannel().position();
                    if (entry.f3401b <= 0) {
                        entry.f3401b = diskCacheEntry.f3417b - diskCacheEntry.f3418c;
                    } else if (entry.f3401b != diskCacheEntry.f3417b - diskCacheEntry.f3418c) {
                        throw new IOException("length not match " + entry.f3401b + ":" + (diskCacheEntry.f3417b - diskCacheEntry.f3418c));
                    }
                    fileOutputStream.close();
                    entry.f3400a = new CacheFileContentInputStream(diskCacheEntry);
                    IOUtils.m5387a(inputStream);
                    IOUtils.m5389a(null);
                    if (diskCacheEntry != null || file.delete()) {
                        return diskCacheEntry;
                    }
                    Log.e("DisBasedCache", "Cannot delete file " + file);
                    return diskCacheEntry;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.w("DisBasedCache", "Cannot save cache to disk file " + file, e);
                        IOUtils.m5387a(inputStream);
                        IOUtils.m5389a(fileOutputStream);
                        if (null == null || file.delete()) {
                            return null;
                        }
                        Log.e("DisBasedCache", "Cannot delete file " + file);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        IOUtils.m5387a(inputStream);
                        IOUtils.m5389a(fileOutputStream);
                        if (null == null && !file.delete()) {
                            Log.e("DisBasedCache", "Cannot delete file " + file);
                        }
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                Log.w("DisBasedCache", "Cannot save cache to disk file " + file, e);
                IOUtils.m5387a(inputStream);
                IOUtils.m5389a(fileOutputStream);
                if (null == null) {
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                IOUtils.m5387a(inputStream);
                IOUtils.m5389a(fileOutputStream);
                Log.e("DisBasedCache", "Cannot delete file " + file);
                throw e;
            }
        }

        public Entry m5120a() {
            try {
                Entry entry = new Entry();
                entry.f3400a = new FileInputStream(this.f3416a);
                if (entry.f3400a.skip(this.f3418c) != this.f3418c) {
                    return null;
                }
                entry.f3401b = this.f3417b - this.f3418c;
                entry.f3402c = this.f3420e;
                entry.f3403d = this.f3421f;
                entry.f3404e = this.f3422g;
                entry.f3405f = this.f3423h;
                entry.f3406g = this.f3424i;
                entry.f3407h = this.f3425j;
                entry.f3408i = this.f3426k;
                return entry;
            } catch (IOException e) {
                return null;
            }
        }

        public synchronized void m5121b() {
            this.f3428m++;
        }

        public synchronized boolean m5122c() {
            return this.f3428m > 0;
        }

        public synchronized void m5123d() {
            this.f3428m--;
            if (this.f3428m <= 0 && this.f3427l && !this.f3416a.delete()) {
                Log.e("DisBasedCache", "Cannot delete file " + this.f3416a);
            }
        }

        public synchronized void m5124e() {
            if (this.f3428m > 0) {
                this.f3427l = true;
            } else if (!this.f3416a.delete()) {
                Log.e("DisBasedCache", "Cannot delete file " + this.f3416a);
            }
        }

        private static int m5119e(InputStream inputStream) {
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            throw new EOFException();
        }

        static void m5112a(OutputStream outputStream, int i) {
            outputStream.write(i & 255);
            outputStream.write((i >> 8) & 255);
            outputStream.write((i >> 16) & 255);
            outputStream.write((i >> 24) & 255);
        }

        static int m5109a(InputStream inputStream) {
            return (((0 | m5119e(inputStream)) | (m5119e(inputStream) << 8)) | (m5119e(inputStream) << 16)) | (m5119e(inputStream) << 24);
        }

        static void m5113a(OutputStream outputStream, long j) {
            outputStream.write((byte) ((int) j));
            outputStream.write((byte) ((int) (j >>> 8)));
            outputStream.write((byte) ((int) (j >>> 16)));
            outputStream.write((byte) ((int) (j >>> 24)));
            outputStream.write((byte) ((int) (j >>> 32)));
            outputStream.write((byte) ((int) (j >>> 40)));
            outputStream.write((byte) ((int) (j >>> 48)));
            outputStream.write((byte) ((int) (j >>> 56)));
        }

        static long m5116b(InputStream inputStream) {
            return (((((((0 | (((long) m5119e(inputStream)) & 255)) | ((((long) m5119e(inputStream)) & 255) << 8)) | ((((long) m5119e(inputStream)) & 255) << 16)) | ((((long) m5119e(inputStream)) & 255) << 24)) | ((((long) m5119e(inputStream)) & 255) << 32)) | ((((long) m5119e(inputStream)) & 255) << 40)) | ((((long) m5119e(inputStream)) & 255) << 48)) | ((((long) m5119e(inputStream)) & 255) << 56);
        }

        static void m5114a(OutputStream outputStream, String str) {
            byte[] bytes = str.getBytes("UTF-8");
            m5113a(outputStream, (long) bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }

        static String m5117c(InputStream inputStream) {
            int b = (int) m5116b(inputStream);
            if (b < 0 || b > 8192) {
                throw new IOException("Malformed data structure encountered");
            }
            byte[] bArr = new byte[b];
            int i = 0;
            while (i < b) {
                int read = inputStream.read(bArr, i, b - i);
                if (read == -1) {
                    break;
                }
                i += read;
            }
            if (i == b) {
                return new String(bArr, "UTF-8");
            }
            throw new IOException("Expected " + b + " bytes but read " + i + " bytes");
        }

        static void m5115a(Map<String, String> map, OutputStream outputStream) {
            if (map == null || map.size() == 0) {
                m5112a(outputStream, 0);
                return;
            }
            m5112a(outputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                m5114a(outputStream, (String) entry.getKey());
                m5114a(outputStream, (String) entry.getValue());
            }
        }

        static Map<String, String> m5118d(InputStream inputStream) {
            int a = m5109a(inputStream);
            Map<String, String> hashMap = new HashMap();
            for (int i = 0; i < a; i++) {
                hashMap.put(m5117c(inputStream).intern(), m5117c(inputStream).intern());
            }
            return hashMap;
        }
    }

    static {
        f3429e = new C04071();
    }

    public static DiskBasedCache m5125a() {
        return (DiskBasedCache) f3429e.get();
    }

    public DiskBasedCache() {
        this(null, 10485760);
    }

    public DiskBasedCache(File file, int i) {
        this.f3430a = new ConcurrentHashMap(16, 0.75f);
        this.f3431b = 0;
        if (file == null) {
            file = new File(AppConstants.m4227a().getCacheDir(), "com.miui.support.net.http");
        }
        this.f3432c = file;
        this.f3433d = i;
    }

    public Entry m5129a(String str) {
        DiskCacheEntry diskCacheEntry = (DiskCacheEntry) this.f3430a.get(str);
        if (diskCacheEntry == null) {
            return null;
        }
        return diskCacheEntry.m5120a();
    }

    public boolean m5130a(String str, Entry entry) {
        DiskCacheEntry a = DiskCacheEntry.m5111a(m5128b(str), str, entry);
        if (a == null) {
            return false;
        }
        m5126a(a.f3417b);
        m5127a(a);
        return true;
    }

    public void m5131b() {
        this.f3430a.clear();
        this.f3431b = 0;
        if (this.f3432c.exists()) {
            File[] listFiles = this.f3432c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    DiskCacheEntry a = DiskCacheEntry.m5110a(file);
                    if (a != null) {
                        m5127a(a);
                    } else if (!file.delete()) {
                        Log.e("DisBasedCache", "Cannot delete file " + file);
                    }
                }
            }
        } else if (!this.f3432c.mkdirs()) {
            Log.e("DisBasedCache", "Cannot create directory " + this.f3432c);
        }
    }

    private File m5128b(String str) {
        return new File(this.f3432c, ExtraTextUtils.m5242a(DigestUtils.m5235a((CharSequence) str, "MD5")));
    }

    private void m5126a(long j) {
        if (this.f3431b + j >= ((long) this.f3433d)) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.f3430a) {
                if (this.f3431b + j < ((long) this.f3433d)) {
                    return;
                }
                DiskCacheEntry diskCacheEntry;
                Iterator it = this.f3430a.entrySet().iterator();
                while (it.hasNext()) {
                    diskCacheEntry = (DiskCacheEntry) ((Map.Entry) it.next()).getValue();
                    if (diskCacheEntry.f3424i < currentTimeMillis) {
                        diskCacheEntry.m5124e();
                        this.f3431b -= diskCacheEntry.f3417b;
                        it.remove();
                    }
                }
                if (this.f3431b + j < ((long) this.f3433d)) {
                    return;
                }
                it = this.f3430a.entrySet().iterator();
                while (it.hasNext()) {
                    diskCacheEntry = (DiskCacheEntry) ((Map.Entry) it.next()).getValue();
                    if (diskCacheEntry.f3425j < currentTimeMillis) {
                        diskCacheEntry.m5124e();
                        this.f3431b -= diskCacheEntry.f3417b;
                        it.remove();
                        if (((float) (this.f3431b + j)) < ((float) this.f3433d) * 0.9f) {
                            break;
                        }
                    }
                }
                if (this.f3431b + j < ((long) this.f3433d)) {
                    return;
                }
                Iterator it2 = this.f3430a.entrySet().iterator();
                while (it2.hasNext()) {
                    diskCacheEntry = (DiskCacheEntry) ((Map.Entry) it2.next()).getValue();
                    if (!diskCacheEntry.m5122c()) {
                        diskCacheEntry.m5124e();
                        it2.remove();
                        if (((float) (this.f3431b + j)) < ((float) this.f3433d) * 0.9f) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private void m5127a(DiskCacheEntry diskCacheEntry) {
        synchronized (this.f3430a) {
            DiskCacheEntry diskCacheEntry2 = (DiskCacheEntry) this.f3430a.get(diskCacheEntry.f3419d);
            if (diskCacheEntry2 == null) {
                this.f3431b += diskCacheEntry.f3417b;
            } else {
                this.f3431b += diskCacheEntry.f3417b - diskCacheEntry2.f3417b;
            }
            this.f3430a.put(diskCacheEntry.f3419d, diskCacheEntry);
        }
    }
}
