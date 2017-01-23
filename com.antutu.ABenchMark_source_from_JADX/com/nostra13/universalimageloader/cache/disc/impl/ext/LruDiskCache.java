package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Snapshot;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.C4039L;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected DiskLruCache cache;
    protected CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    static {
        DEFAULT_COMPRESS_FORMAT = CompressFormat.PNG;
    }

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i) {
        this.bufferSize = DEFAULT_BUFFER_SIZE;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = DEFAULT_COMPRESS_QUALITY;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        } else if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        } else if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        } else if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        } else {
            long j2 = j == 0 ? Long.MAX_VALUE : j;
            int i2 = i == 0 ? Integer.MAX_VALUE : i;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            initCache(file, file2, j2, i2);
        }
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j, int i) {
        try {
            this.cache = DiskLruCache.open(file, 1, 1, j, i);
        } catch (Throwable e) {
            C4039L.m16506e(e);
            if (file2 != null) {
                initCache(file2, null, j, i);
            }
            if (this.cache == null) {
                throw e;
            }
        }
    }

    public void clear() {
        try {
            this.cache.delete();
        } catch (Throwable e) {
            C4039L.m16506e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
        } catch (Throwable e2) {
            C4039L.m16506e(e2);
        }
    }

    public void close() {
        try {
            this.cache.close();
        } catch (Throwable e) {
            C4039L.m16506e(e);
        }
        this.cache = null;
    }

    public File get(String str) {
        Snapshot snapshot;
        Throwable e;
        Throwable th;
        File file = null;
        try {
            snapshot = this.cache.get(getKey(str));
            if (snapshot != null) {
                try {
                    file = snapshot.getFile(0);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        C4039L.m16506e(e);
                        if (snapshot != null) {
                            snapshot.close();
                        }
                        return file;
                    } catch (Throwable th2) {
                        th = th2;
                        if (snapshot != null) {
                            snapshot.close();
                        }
                        throw th;
                    }
                }
            }
            if (snapshot != null) {
                snapshot.close();
            }
        } catch (IOException e3) {
            e = e3;
            snapshot = file;
            C4039L.m16506e(e);
            if (snapshot != null) {
                snapshot.close();
            }
            return file;
        } catch (Throwable e4) {
            snapshot = file;
            th = e4;
            if (snapshot != null) {
                snapshot.close();
            }
            throw th;
        }
        return file;
    }

    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (Throwable e) {
            C4039L.m16506e(e);
            return false;
        }
    }

    public boolean save(String str, Bitmap bitmap) {
        boolean z = false;
        Editor edit = this.cache.edit(getKey(str));
        if (edit != null) {
            Closeable bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
            try {
                z = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
                if (z) {
                    edit.commit();
                } else {
                    edit.abort();
                }
            } finally {
                IoUtils.closeSilently(bufferedOutputStream);
            }
        }
        return z;
    }

    public boolean save(String str, InputStream inputStream, CopyListener copyListener) {
        boolean z = false;
        Editor edit = this.cache.edit(getKey(str));
        if (edit != null) {
            Closeable bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
            try {
                z = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
                IoUtils.closeSilently(bufferedOutputStream);
                if (z) {
                    edit.commit();
                } else {
                    edit.abort();
                }
            } catch (Throwable th) {
                IoUtils.closeSilently(bufferedOutputStream);
                edit.abort();
            }
        }
        return z;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }
}
