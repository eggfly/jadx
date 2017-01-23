package com.nostra13.universalimageloader.cache.disc.impl.ext;

import com.facebook.ads.AdError;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM;
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private int fileCount;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private int maxFileCount;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    /* renamed from: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.1 */
    class C40251 implements Callable<Void> {
        C40251() {
        }

        public Void call() {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                } else {
                    DiskLruCache.this.trimToSize();
                    DiskLruCache.this.trimToFileCount();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.2 */
    static class C40262 extends OutputStream {
        C40262() {
        }

        public void write(int i) {
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }
        }

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public void abort() {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }

        public void commit() {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public String getString(int i) {
            InputStream newInputStream = newInputStream(i);
            return newInputStream != null ? DiskLruCache.inputStreamToString(newInputStream) : null;
        }

        public InputStream newInputStream(int i) {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (this.entry.readable) {
                    try {
                        InputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }

        public OutputStream newOutputStream(int i) {
            OutputStream access$2100;
            synchronized (DiskLruCache.this) {
                File dirtyFile;
                OutputStream fileOutputStream;
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                dirtyFile = this.entry.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.directory.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e2) {
                        access$2100 = DiskLruCache.NULL_OUTPUT_STREAM;
                    }
                }
                access$2100 = new FaultHidingOutputStream(fileOutputStream, null);
            }
            return access$2100;
        }

        public void set(int i, String str) {
            Throwable th;
            Closeable outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), Util.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    Util.closeQuietly(outputStreamWriter);
                } catch (Throwable th2) {
                    th = th2;
                    Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                Util.closeQuietly(outputStreamWriter);
                throw th;
            }
        }
    }

    private final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        private IOException invalidLengths(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        private void setLengths(String[] strArr) {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw invalidLengths(strArr);
                }
            }
        }

        public File getCleanFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + BuildConfig.FLAVOR + i);
        }

        public File getDirtyFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + BuildConfig.FLAVOR + i + ".tmp");
        }

        public String getLengths() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.lengths) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }
    }

    public final class Snapshot implements Closeable {
        private File[] files;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        public void close() {
            for (Closeable closeQuietly : this.ins) {
                Util.closeQuietly(closeQuietly);
            }
        }

        public Editor edit() {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int i) {
            return this.files[i];
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public String getString(int i) {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }
    }

    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
        NULL_OUTPUT_STREAM = new C40262();
    }

    private DiskLruCache(File file, int i, int i2, long j, int i3) {
        this.size = 0;
        this.fileCount = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.cleanupCallable = new C40251();
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.maxFileCount = i3;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void completeEdit(com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor r11, boolean r12) {
        /*
        r10 = this;
        r0 = 0;
        monitor-enter(r10);
        r2 = r11.entry;	 Catch:{ all -> 0x0012 }
        r1 = r2.currentEditor;	 Catch:{ all -> 0x0012 }
        if (r1 == r11) goto L_0x0015;
    L_0x000c:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r0.<init>();	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0015:
        if (r12 == 0) goto L_0x0058;
    L_0x0017:
        r1 = r2.readable;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x0058;
    L_0x001d:
        r1 = r0;
    L_0x001e:
        r3 = r10.valueCount;	 Catch:{ all -> 0x0012 }
        if (r1 >= r3) goto L_0x0058;
    L_0x0022:
        r3 = r11.written;	 Catch:{ all -> 0x0012 }
        r3 = r3[r1];	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0046;
    L_0x002a:
        r11.abort();	 Catch:{ all -> 0x0012 }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r2.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "Newly created entry didn't create value for index ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.<init>(r1);	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0046:
        r3 = r2.getDirtyFile(r1);	 Catch:{ all -> 0x0012 }
        r3 = r3.exists();	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0055;
    L_0x0050:
        r11.abort();	 Catch:{ all -> 0x0012 }
    L_0x0053:
        monitor-exit(r10);
        return;
    L_0x0055:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x0058:
        r1 = r10.valueCount;	 Catch:{ all -> 0x0012 }
        if (r0 >= r1) goto L_0x0093;
    L_0x005c:
        r1 = r2.getDirtyFile(r0);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x008f;
    L_0x0062:
        r3 = r1.exists();	 Catch:{ all -> 0x0012 }
        if (r3 == 0) goto L_0x008c;
    L_0x0068:
        r3 = r2.getCleanFile(r0);	 Catch:{ all -> 0x0012 }
        r1.renameTo(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.lengths;	 Catch:{ all -> 0x0012 }
        r4 = r1[r0];	 Catch:{ all -> 0x0012 }
        r6 = r3.length();	 Catch:{ all -> 0x0012 }
        r1 = r2.lengths;	 Catch:{ all -> 0x0012 }
        r1[r0] = r6;	 Catch:{ all -> 0x0012 }
        r8 = r10.size;	 Catch:{ all -> 0x0012 }
        r4 = r8 - r4;
        r4 = r4 + r6;
        r10.size = r4;	 Catch:{ all -> 0x0012 }
        r1 = r10.fileCount;	 Catch:{ all -> 0x0012 }
        r1 = r1 + 1;
        r10.fileCount = r1;	 Catch:{ all -> 0x0012 }
    L_0x008c:
        r0 = r0 + 1;
        goto L_0x0058;
    L_0x008f:
        deleteIfExists(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x008c;
    L_0x0093:
        r0 = r10.redundantOpCount;	 Catch:{ all -> 0x0012 }
        r0 = r0 + 1;
        r10.redundantOpCount = r0;	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r2.currentEditor = r0;	 Catch:{ all -> 0x0012 }
        r0 = r2.readable;	 Catch:{ all -> 0x0012 }
        r0 = r0 | r12;
        if (r0 == 0) goto L_0x0100;
    L_0x00a4:
        r0 = 1;
        r2.readable = r0;	 Catch:{ all -> 0x0012 }
        r0 = r10.journalWriter;	 Catch:{ all -> 0x0012 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r1.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "CLEAN ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0012 }
        r3 = r2.key;	 Catch:{ all -> 0x0012 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0012 }
        r3 = r2.getLengths();	 Catch:{ all -> 0x0012 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0012 }
        r3 = 10;
        r1 = r1.append(r3);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.write(r1);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x00de;
    L_0x00d4:
        r0 = r10.nextSequenceNumber;	 Catch:{ all -> 0x0012 }
        r4 = 1;
        r4 = r4 + r0;
        r10.nextSequenceNumber = r4;	 Catch:{ all -> 0x0012 }
        r2.sequenceNumber = r0;	 Catch:{ all -> 0x0012 }
    L_0x00de:
        r0 = r10.journalWriter;	 Catch:{ all -> 0x0012 }
        r0.flush();	 Catch:{ all -> 0x0012 }
        r0 = r10.size;	 Catch:{ all -> 0x0012 }
        r2 = r10.maxSize;	 Catch:{ all -> 0x0012 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00f7;
    L_0x00eb:
        r0 = r10.fileCount;	 Catch:{ all -> 0x0012 }
        r1 = r10.maxFileCount;	 Catch:{ all -> 0x0012 }
        if (r0 > r1) goto L_0x00f7;
    L_0x00f1:
        r0 = r10.journalRebuildRequired();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0053;
    L_0x00f7:
        r0 = r10.executorService;	 Catch:{ all -> 0x0012 }
        r1 = r10.cleanupCallable;	 Catch:{ all -> 0x0012 }
        r0.submit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0053;
    L_0x0100:
        r0 = r10.lruEntries;	 Catch:{ all -> 0x0012 }
        r1 = r2.key;	 Catch:{ all -> 0x0012 }
        r0.remove(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.journalWriter;	 Catch:{ all -> 0x0012 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r1.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "REMOVE ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0012 }
        r2 = r2.key;	 Catch:{ all -> 0x0012 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0012 }
        r2 = 10;
        r1 = r1.append(r2);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.write(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x00de;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.completeEdit(com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Editor, boolean):void");
    }

    private static void deleteIfExists(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized Editor edit(String str, long j) {
        Editor editor;
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j == ANY_SEQUENCE_NUMBER || (entry != null && entry.sequenceNumber == j)) {
            Entry entry2;
            if (entry == null) {
                entry = new Entry(str, null);
                this.lruEntries.put(str, entry);
                entry2 = entry;
            } else if (entry.currentEditor != null) {
                editor = null;
            } else {
                entry2 = entry;
            }
            editor = new Editor(entry2, null);
            entry2.currentEditor = editor;
            this.journalWriter.write("DIRTY " + str + '\n');
            this.journalWriter.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    private static String inputStreamToString(InputStream inputStream) {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= AdError.SERVER_ERROR_CODE && this.redundantOpCount >= this.lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j, i3);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                    return diskLruCache;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j, i3);
            diskLruCache.rebuildJournal();
            return diskLruCache;
        }
    }

    private void processJournal() {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i;
            if (entry.currentEditor == null) {
                for (i = 0; i < this.valueCount; i++) {
                    this.size += entry.lengths[i];
                    this.fileCount++;
                }
            } else {
                entry.currentEditor = null;
                for (i = 0; i < this.valueCount; i++) {
                    deleteIfExists(entry.getCleanFile(i));
                    deleteIfExists(entry.getDirtyFile(i));
                }
                it.remove();
            }
        }
    }

    private void readJournal() {
        Closeable strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        int i;
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (MAGIC.equals(readLine) && VERSION_1.equals(readLine2) && Integer.toString(this.appVersion).equals(readLine3) && Integer.toString(this.valueCount).equals(readLine4) && BuildConfig.FLAVOR.equals(readLine5)) {
                i = 0;
                while (true) {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (EOFException e) {
            this.redundantOpCount = i - this.lruEntries.size();
            Util.closeQuietly(strictLineReader);
        } catch (Throwable th) {
            Util.closeQuietly(strictLineReader);
        }
    }

    private void readJournalLine(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        Entry entry = (Entry) this.lruEntries.get(str2);
        if (entry == null) {
            entry = new Entry(str2, null);
            this.lruEntries.put(str2, entry);
        }
        if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry, null);
        } else if (indexOf2 != -1 || indexOf != READ.length() || !str.startsWith(READ)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private synchronized void rebuildJournal() {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write(VERSION_1);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + entry.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void renameTo(File file, File file2, boolean z) {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void trimToFileCount() {
        while (this.fileCount > this.maxFileCount) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    private void trimToSize() {
        while (this.size > this.maxSize) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public synchronized void close() {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            trimToFileCount();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    public void delete() {
        close();
        Util.deleteContents(this.directory);
    }

    public Editor edit(String str) {
        return edit(str, ANY_SEQUENCE_NUMBER);
    }

    public synchronized long fileCount() {
        return (long) this.fileCount;
    }

    public synchronized void flush() {
        checkNotClosed();
        trimToSize();
        trimToFileCount();
        this.journalWriter.flush();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Snapshot get(java.lang.String r11) {
        /*
        r10 = this;
        r2 = 0;
        r1 = 0;
        monitor-enter(r10);
        r10.checkNotClosed();	 Catch:{ all -> 0x008c }
        r10.validateKey(r11);	 Catch:{ all -> 0x008c }
        r0 = r10.lruEntries;	 Catch:{ all -> 0x008c }
        r0 = r0.get(r11);	 Catch:{ all -> 0x008c }
        r0 = (com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x008c }
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r10);
        return r1;
    L_0x0015:
        r3 = r0.readable;	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x0013;
    L_0x001b:
        r3 = r10.valueCount;	 Catch:{ all -> 0x008c }
        r6 = new java.io.File[r3];	 Catch:{ all -> 0x008c }
        r3 = r10.valueCount;	 Catch:{ all -> 0x008c }
        r7 = new java.io.InputStream[r3];	 Catch:{ all -> 0x008c }
        r3 = r2;
    L_0x0024:
        r4 = r10.valueCount;	 Catch:{ FileNotFoundException -> 0x0038 }
        if (r3 >= r4) goto L_0x004a;
    L_0x0028:
        r4 = r0.getCleanFile(r3);	 Catch:{ FileNotFoundException -> 0x0038 }
        r6[r3] = r4;	 Catch:{ FileNotFoundException -> 0x0038 }
        r5 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0038 }
        r5.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0038 }
        r7[r3] = r5;	 Catch:{ FileNotFoundException -> 0x0038 }
        r3 = r3 + 1;
        goto L_0x0024;
    L_0x0038:
        r0 = move-exception;
        r0 = r2;
    L_0x003a:
        r2 = r10.valueCount;	 Catch:{ all -> 0x008c }
        if (r0 >= r2) goto L_0x0013;
    L_0x003e:
        r2 = r7[r0];	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0013;
    L_0x0042:
        r2 = r7[r0];	 Catch:{ all -> 0x008c }
        com.nostra13.universalimageloader.cache.disc.impl.ext.Util.closeQuietly(r2);	 Catch:{ all -> 0x008c }
        r0 = r0 + 1;
        goto L_0x003a;
    L_0x004a:
        r1 = r10.redundantOpCount;	 Catch:{ all -> 0x008c }
        r1 = r1 + 1;
        r10.redundantOpCount = r1;	 Catch:{ all -> 0x008c }
        r1 = r10.journalWriter;	 Catch:{ all -> 0x008c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r2.<init>();	 Catch:{ all -> 0x008c }
        r3 = "READ ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x008c }
        r2 = r2.append(r11);	 Catch:{ all -> 0x008c }
        r3 = 10;
        r2 = r2.append(r3);	 Catch:{ all -> 0x008c }
        r2 = r2.toString();	 Catch:{ all -> 0x008c }
        r1.append(r2);	 Catch:{ all -> 0x008c }
        r1 = r10.journalRebuildRequired();	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x007b;
    L_0x0074:
        r1 = r10.executorService;	 Catch:{ all -> 0x008c }
        r2 = r10.cleanupCallable;	 Catch:{ all -> 0x008c }
        r1.submit(r2);	 Catch:{ all -> 0x008c }
    L_0x007b:
        r1 = new com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Snapshot;	 Catch:{ all -> 0x008c }
        r4 = r0.sequenceNumber;	 Catch:{ all -> 0x008c }
        r8 = r0.lengths;	 Catch:{ all -> 0x008c }
        r9 = 0;
        r2 = r10;
        r3 = r11;
        r1.<init>(r3, r4, r6, r7, r8, r9);	 Catch:{ all -> 0x008c }
        goto L_0x0013;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.get(java.lang.String):com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized int getMaxFileCount() {
        return this.maxFileCount;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r6.checkNotClosed();	 Catch:{ all -> 0x0063 }
        r6.validateKey(r7);	 Catch:{ all -> 0x0063 }
        r0 = r6.lruEntries;	 Catch:{ all -> 0x0063 }
        r0 = r0.get(r7);	 Catch:{ all -> 0x0063 }
        r0 = (com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Entry) r0;	 Catch:{ all -> 0x0063 }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r2 = r0.currentEditor;	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0036;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        monitor-exit(r6);
        return r0;
    L_0x001b:
        r2 = r6.size;	 Catch:{ all -> 0x0063 }
        r4 = r0.lengths;	 Catch:{ all -> 0x0063 }
        r4 = r4[r1];	 Catch:{ all -> 0x0063 }
        r2 = r2 - r4;
        r6.size = r2;	 Catch:{ all -> 0x0063 }
        r2 = r6.fileCount;	 Catch:{ all -> 0x0063 }
        r2 = r2 + -1;
        r6.fileCount = r2;	 Catch:{ all -> 0x0063 }
        r2 = r0.lengths;	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r2[r1] = r4;	 Catch:{ all -> 0x0063 }
        r1 = r1 + 1;
    L_0x0036:
        r2 = r6.valueCount;	 Catch:{ all -> 0x0063 }
        if (r1 >= r2) goto L_0x0066;
    L_0x003a:
        r2 = r0.getCleanFile(r1);	 Catch:{ all -> 0x0063 }
        r3 = r2.exists();	 Catch:{ all -> 0x0063 }
        if (r3 == 0) goto L_0x001b;
    L_0x0044:
        r3 = r2.delete();	 Catch:{ all -> 0x0063 }
        if (r3 != 0) goto L_0x001b;
    L_0x004a:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x0063 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0063 }
        r1.<init>();	 Catch:{ all -> 0x0063 }
        r3 = "failed to delete ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0063 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0063 }
        r1 = r1.toString();	 Catch:{ all -> 0x0063 }
        r0.<init>(r1);	 Catch:{ all -> 0x0063 }
        throw r0;	 Catch:{ all -> 0x0063 }
    L_0x0063:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0066:
        r0 = r6.redundantOpCount;	 Catch:{ all -> 0x0063 }
        r0 = r0 + 1;
        r6.redundantOpCount = r0;	 Catch:{ all -> 0x0063 }
        r0 = r6.journalWriter;	 Catch:{ all -> 0x0063 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0063 }
        r1.<init>();	 Catch:{ all -> 0x0063 }
        r2 = "REMOVE ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0063 }
        r1 = r1.append(r7);	 Catch:{ all -> 0x0063 }
        r2 = 10;
        r1 = r1.append(r2);	 Catch:{ all -> 0x0063 }
        r1 = r1.toString();	 Catch:{ all -> 0x0063 }
        r0.append(r1);	 Catch:{ all -> 0x0063 }
        r0 = r6.lruEntries;	 Catch:{ all -> 0x0063 }
        r0.remove(r7);	 Catch:{ all -> 0x0063 }
        r0 = r6.journalRebuildRequired();	 Catch:{ all -> 0x0063 }
        if (r0 == 0) goto L_0x009c;
    L_0x0095:
        r0 = r6.executorService;	 Catch:{ all -> 0x0063 }
        r1 = r6.cleanupCallable;	 Catch:{ all -> 0x0063 }
        r0.submit(r1);	 Catch:{ all -> 0x0063 }
    L_0x009c:
        r0 = 1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }
}
