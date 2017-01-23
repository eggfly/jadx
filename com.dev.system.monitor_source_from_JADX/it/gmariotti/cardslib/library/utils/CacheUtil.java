package it.gmariotti.cardslib.library.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

public class CacheUtil {
    private static CacheUtil sInstance;
    protected LruCache<String, Bitmap> mMemoryCache;

    protected CacheUtil() {
    }

    public static CacheUtil getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        CacheUtil cacheUtil = new CacheUtil();
        sInstance = cacheUtil;
        return cacheUtil;
    }

    public static LruCache<String, Bitmap> getMemoryCache() {
        return getInstance().mMemoryCache;
    }

    public static void putMemoryCache(LruCache<String, Bitmap> memoryCache) {
        getInstance().mMemoryCache = memoryCache;
    }
}
