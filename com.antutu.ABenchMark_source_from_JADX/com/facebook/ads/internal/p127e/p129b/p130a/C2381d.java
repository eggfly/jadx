package com.facebook.ads.internal.p127e.p129b.p130a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.e.b.a.d */
class C2381d {

    /* renamed from: com.facebook.ads.internal.e.b.a.d.a */
    private static final class C2380a implements Comparator<File> {
        private C2380a() {
        }

        private int m9160a(long j, long j2) {
            return j < j2 ? -1 : j == j2 ? 0 : 1;
        }

        public int m9161a(File file, File file2) {
            return m9160a(file.lastModified(), file2.lastModified());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9161a((File) obj, (File) obj2);
        }
    }

    static void m9162a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", new Object[]{file.getAbsolutePath()}));
        }
    }

    static List<File> m9163b(File file) {
        List linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new C2380a());
        return asList;
    }

    static void m9164c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                C2381d.m9165d(file);
                if (file.lastModified() < currentTimeMillis) {
                    throw new IOException("Error set last modified date to " + file);
                }
            }
        }
    }

    static void m9165d(File file) {
        long length = file.length();
        if (length == 0) {
            C2381d.m9166e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        randomAccessFile.seek(length - 1);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(length - 1);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void m9166e(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
