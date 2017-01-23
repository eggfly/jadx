package com.cmcm.support.p118c;

import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cmcm.support.c.d */
public class C2214d {
    private static C2214d f7628a;
    private Map<String, C2213a> f7629b;

    /* renamed from: com.cmcm.support.c.d.a */
    private class C2213a {
        FileChannel f7623a;
        RandomAccessFile f7624b;
        FileLock f7625c;
        int f7626d;
        final /* synthetic */ C2214d f7627e;

        C2213a(C2214d c2214d, FileLock fileLock, int i, RandomAccessFile randomAccessFile, FileChannel fileChannel) {
            this.f7627e = c2214d;
            this.f7625c = fileLock;
            this.f7626d = i;
            this.f7624b = randomAccessFile;
            this.f7623a = fileChannel;
        }
    }

    public C2214d() {
        this.f7629b = new ConcurrentHashMap();
    }

    private int m8324a(String str) {
        Integer valueOf = Integer.valueOf(0);
        if (this.f7629b.containsKey(str)) {
            C2213a c2213a = (C2213a) this.f7629b.get(str);
            int i = c2213a.f7626d - 1;
            c2213a.f7626d = i;
            valueOf = Integer.valueOf(i);
            if (valueOf.intValue() <= 0) {
                this.f7629b.remove(str);
            }
        }
        return valueOf.intValue();
    }

    private int m8325a(String str, FileLock fileLock, RandomAccessFile randomAccessFile, FileChannel fileChannel) {
        Integer valueOf;
        Integer.valueOf(0);
        if (this.f7629b.containsKey(str)) {
            C2213a c2213a = (C2213a) this.f7629b.get(str);
            int i = c2213a.f7626d;
            c2213a.f7626d = i + 1;
            valueOf = Integer.valueOf(i);
        } else {
            Integer valueOf2 = Integer.valueOf(1);
            this.f7629b.put(str, new C2213a(this, fileLock, valueOf2.intValue(), randomAccessFile, fileChannel));
            valueOf = valueOf2;
        }
        return valueOf.intValue();
    }

    public static synchronized C2214d m8326a() {
        C2214d c2214d;
        synchronized (C2214d.class) {
            if (f7628a == null) {
                f7628a = new C2214d();
            }
            c2214d = f7628a;
        }
        return c2214d;
    }

    public boolean m8327a(File file) {
        if (file == null) {
            throw new RuntimeException("dir is null");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            File file2 = new File(file.getAbsolutePath().concat("/").concat("fileLock"));
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2.getAbsolutePath(), "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Log.w("gwj", "[ExclusiveLock.lock] before getLock ");
            FileLock lock = channel.lock();
            Log.w("gwj", "[ExclusiveLock.lock] after getLock isValid()=" + lock.isValid());
            if (!lock.isValid()) {
                return false;
            }
            m8325a(file2.getAbsolutePath(), lock, randomAccessFile, channel);
            return true;
        } catch (Throwable e) {
            Log.w("gwj", "FileLock " + file.getAbsolutePath().concat("/").concat("fileLock") + " Lock FAIL! " + e.getMessage(), e);
            return false;
        }
    }

    public void m8328b(File file) {
        if (file == null || !file.exists()) {
            throw new RuntimeException("dir is not exists");
        }
        File file2 = new File(file.getAbsolutePath().concat("/").concat("fileLock"));
        if (!file2.exists()) {
            return;
        }
        if (file2 == null || this.f7629b.containsKey(file2.getAbsolutePath())) {
            C2213a c2213a = (C2213a) this.f7629b.get(file2.getAbsolutePath());
            if (c2213a != null) {
                FileLock fileLock = c2213a.f7625c;
                RandomAccessFile randomAccessFile = c2213a.f7624b;
                FileChannel fileChannel = c2213a.f7623a;
                try {
                    if (m8324a(file2.getAbsolutePath()) <= 0) {
                        if (fileLock != null && fileLock.isValid()) {
                            Log.w("gwj", "[ExclusiveLock.lock] before releaseLock");
                            fileLock.release();
                            Log.w("gwj", "[ExclusiveLock.lock] after releaseLock");
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                    }
                } catch (Throwable e) {
                    Log.w("gwj", "FileLock " + file.getAbsolutePath().concat("/").concat("fileLock") + " unlock FAIL! " + e.getMessage(), e);
                }
            }
        }
    }
}
