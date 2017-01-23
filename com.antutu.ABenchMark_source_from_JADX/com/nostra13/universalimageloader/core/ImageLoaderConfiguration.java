package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.C4039L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.InputStream;
import java.util.concurrent.Executor;
import org.android.spdy.SpdyProtocol;

public final class ImageLoaderConfiguration {
    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final ImageDecoder decoder;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiskCache diskCache;
    final ImageDownloader downloader;
    final int maxImageHeightForDiskCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiskCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCache memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final BitmapProcessor processorForDiskCache;
    final Resources resources;
    final ImageDownloader slowNetworkDownloader;
    final Executor taskExecutor;
    final Executor taskExecutorForCachedImages;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;

    /* renamed from: com.nostra13.universalimageloader.core.ImageLoaderConfiguration.1 */
    static /* synthetic */ class C40301 {
        static final /* synthetic */ int[] f13378x4730d1a3;

        static {
            f13378x4730d1a3 = new int[Scheme.values().length];
            try {
                f13378x4730d1a3[Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13378x4730d1a3[Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        private Context context;
        private boolean customExecutor;
        private boolean customExecutorForCachedImages;
        private ImageDecoder decoder;
        private DisplayImageOptions defaultDisplayImageOptions;
        private boolean denyCacheImageMultipleSizesInMemory;
        private DiskCache diskCache;
        private int diskCacheFileCount;
        private FileNameGenerator diskCacheFileNameGenerator;
        private long diskCacheSize;
        private ImageDownloader downloader;
        private int maxImageHeightForDiskCache;
        private int maxImageHeightForMemoryCache;
        private int maxImageWidthForDiskCache;
        private int maxImageWidthForMemoryCache;
        private MemoryCache memoryCache;
        private int memoryCacheSize;
        private BitmapProcessor processorForDiskCache;
        private Executor taskExecutor;
        private Executor taskExecutorForCachedImages;
        private QueueProcessingType tasksProcessingType;
        private int threadPoolSize;
        private int threadPriority;
        private boolean writeLogs;

        static {
            DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        }

        public Builder(Context context) {
            this.maxImageWidthForMemoryCache = 0;
            this.maxImageHeightForMemoryCache = 0;
            this.maxImageWidthForDiskCache = 0;
            this.maxImageHeightForDiskCache = 0;
            this.processorForDiskCache = null;
            this.taskExecutor = null;
            this.taskExecutorForCachedImages = null;
            this.customExecutor = false;
            this.customExecutorForCachedImages = false;
            this.threadPoolSize = DEFAULT_THREAD_PRIORITY;
            this.threadPriority = DEFAULT_THREAD_PRIORITY;
            this.denyCacheImageMultipleSizesInMemory = false;
            this.tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
            this.memoryCacheSize = 0;
            this.diskCacheSize = 0;
            this.diskCacheFileCount = 0;
            this.memoryCache = null;
            this.diskCache = null;
            this.diskCacheFileNameGenerator = null;
            this.downloader = null;
            this.defaultDisplayImageOptions = null;
            this.writeLogs = false;
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration();
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            return diskCache(diskCache);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i, i2, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i) {
            return diskCacheFileCount(i);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i) {
            return diskCacheSize(i);
        }

        public Builder diskCache(DiskCache diskCache) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                C4039L.m16509w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                C4039L.m16509w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCache = diskCache;
            return this;
        }

        public Builder diskCacheExtraOptions(int i, int i2, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i;
            this.maxImageHeightForDiskCache = i2;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.diskCache != null) {
                C4039L.m16509w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            this.diskCacheFileCount = i;
            return this;
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                C4039L.m16509w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.diskCache != null) {
                C4039L.m16509w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            this.diskCacheSize = (long) i;
            return this;
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            if (this.memoryCacheSize != 0) {
                C4039L.m16509w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i, int i2) {
            this.maxImageWidthForMemoryCache = i;
            this.maxImageHeightForMemoryCache = i2;
            return this;
        }

        public Builder memoryCacheSize(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.memoryCache != null) {
                C4039L.m16509w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCacheSize = i;
            return this;
        }

        public Builder memoryCacheSizePercentage(int i) {
            if (i <= 0 || i >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.memoryCache != null) {
                C4039L.m16509w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (((float) i) / 100.0f));
            return this;
        }

        public Builder taskExecutor(Executor executor) {
            if (!(this.threadPoolSize == DEFAULT_THREAD_PRIORITY && this.threadPriority == DEFAULT_THREAD_PRIORITY && this.tasksProcessingType == DEFAULT_TASK_PROCESSING_TYPE)) {
                C4039L.m16509w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (!(this.threadPoolSize == DEFAULT_THREAD_PRIORITY && this.threadPriority == DEFAULT_THREAD_PRIORITY && this.tasksProcessingType == DEFAULT_TASK_PROCESSING_TYPE)) {
                C4039L.m16509w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4039L.m16509w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4039L.m16509w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.threadPoolSize = i;
            return this;
        }

        public Builder threadPriority(int i) {
            if (!(this.taskExecutor == null && this.taskExecutorForCachedImages == null)) {
                C4039L.m16509w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            if (i < 1) {
                this.threadPriority = 1;
            } else if (i > 10) {
                this.threadPriority = 10;
            } else {
                this.threadPriority = i;
            }
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    private static class NetworkDeniedImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        public InputStream getStream(String str, Object obj) {
            switch (C40301.f13378x4730d1a3[Scheme.ofUri(str).ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    throw new IllegalStateException();
                default:
                    return this.wrappedDownloader.getStream(str, obj);
            }
        }
    }

    private static class SlowNetworkImageDownloader implements ImageDownloader {
        private final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        public InputStream getStream(String str, Object obj) {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            switch (C40301.f13378x4730d1a3[Scheme.ofUri(str).ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return new FlushedInputStream(stream);
                default:
                    return stream;
            }
        }
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.downloader = builder.downloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(this.downloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(this.downloader);
        C4039L.writeDebugLogs(builder.writeLogs);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i = this.maxImageWidthForMemoryCache;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.maxImageHeightForMemoryCache;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new ImageSize(i, i2);
    }
}
