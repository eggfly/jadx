package com.antutu.utils.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageControl {
    public static final int THREAD_SIZE_THUMBNAIL = 3;
    private static ImageControl mImageCacheControl;
    private ExecutorService mThreadPool;

    private ImageControl() {
        init();
    }

    public static final ImageControl getInstance() {
        if (mImageCacheControl == null) {
            synchronized (ImageControl.class) {
                if (mImageCacheControl == null) {
                    mImageCacheControl = new ImageControl();
                }
            }
        }
        return mImageCacheControl;
    }

    private void init() {
        this.mThreadPool = Executors.newFixedThreadPool(THREAD_SIZE_THUMBNAIL);
    }

    public void getImage(String str, ImageTaskBack imageTaskBack) {
        this.mThreadPool.execute(new ImageTask(str, imageTaskBack));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
