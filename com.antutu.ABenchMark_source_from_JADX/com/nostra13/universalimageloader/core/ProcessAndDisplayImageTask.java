package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.utils.C4039L;

final class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, Bitmap bitmap, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.bitmap = bitmap;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
    }

    public void run() {
        C4039L.m16504d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
    }
}
