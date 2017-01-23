package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ImageLoaderEngine {
    private final Map<Integer, String> cacheKeysForImageAwares;
    final ImageLoaderConfiguration configuration;
    private final AtomicBoolean networkDenied;
    private final Object pauseLock;
    private final AtomicBoolean paused;
    private final AtomicBoolean slowNetwork;
    private Executor taskDistributor;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map<String, ReentrantLock> uriLocks;

    /* renamed from: com.nostra13.universalimageloader.core.ImageLoaderEngine.1 */
    class C40311 implements Runnable {
        final /* synthetic */ LoadAndDisplayImageTask val$task;

        C40311(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.val$task = loadAndDisplayImageTask;
        }

        public void run() {
            File file = ImageLoaderEngine.this.configuration.diskCache.get(this.val$task.getLoadingUri());
            Object obj = (file == null || !file.exists()) ? null : 1;
            ImageLoaderEngine.this.initExecutorsIfNeed();
            if (obj != null) {
                ImageLoaderEngine.this.taskExecutorForCachedImages.execute(this.val$task);
            } else {
                ImageLoaderEngine.this.taskExecutor.execute(this.val$task);
            }
        }
    }

    ImageLoaderEngine(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
        this.uriLocks = new WeakHashMap();
        this.paused = new AtomicBoolean(false);
        this.networkDenied = new AtomicBoolean(false);
        this.slowNetwork = new AtomicBoolean(false);
        this.pauseLock = new Object();
        this.configuration = imageLoaderConfiguration;
        this.taskExecutor = imageLoaderConfiguration.taskExecutor;
        this.taskExecutorForCachedImages = imageLoaderConfiguration.taskExecutorForCachedImages;
        this.taskDistributor = DefaultConfigurationFactory.createTaskDistributor();
    }

    private Executor createTaskExecutor() {
        return DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
    }

    private void initExecutorsIfNeed() {
        if (!this.configuration.customExecutor && ((ExecutorService) this.taskExecutor).isShutdown()) {
            this.taskExecutor = createTaskExecutor();
        }
        if (!this.configuration.customExecutorForCachedImages && ((ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
            this.taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    void cancelDisplayTaskFor(ImageAware imageAware) {
        this.cacheKeysForImageAwares.remove(Integer.valueOf(imageAware.getId()));
    }

    void denyNetworkDownloads(boolean z) {
        this.networkDenied.set(z);
    }

    void fireCallback(Runnable runnable) {
        this.taskDistributor.execute(runnable);
    }

    String getLoadingUriForView(ImageAware imageAware) {
        return (String) this.cacheKeysForImageAwares.get(Integer.valueOf(imageAware.getId()));
    }

    ReentrantLock getLockForUri(String str) {
        ReentrantLock reentrantLock = (ReentrantLock) this.uriLocks.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        reentrantLock = new ReentrantLock();
        this.uriLocks.put(str, reentrantLock);
        return reentrantLock;
    }

    AtomicBoolean getPause() {
        return this.paused;
    }

    Object getPauseLock() {
        return this.pauseLock;
    }

    void handleSlowNetwork(boolean z) {
        this.slowNetwork.set(z);
    }

    boolean isNetworkDenied() {
        return this.networkDenied.get();
    }

    boolean isSlowNetwork() {
        return this.slowNetwork.get();
    }

    void pause() {
        this.paused.set(true);
    }

    void prepareDisplayTaskFor(ImageAware imageAware, String str) {
        this.cacheKeysForImageAwares.put(Integer.valueOf(imageAware.getId()), str);
    }

    void resume() {
        this.paused.set(false);
        synchronized (this.pauseLock) {
            this.pauseLock.notifyAll();
        }
    }

    void stop() {
        if (!this.configuration.customExecutor) {
            ((ExecutorService) this.taskExecutor).shutdownNow();
        }
        if (!this.configuration.customExecutorForCachedImages) {
            ((ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
        }
        this.cacheKeysForImageAwares.clear();
        this.uriLocks.clear();
    }

    void submit(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.taskDistributor.execute(new C40311(loadAndDisplayImageTask));
    }

    void submit(ProcessAndDisplayImageTask processAndDisplayImageTask) {
        initExecutorsIfNeed();
        this.taskExecutorForCachedImages.execute(processAndDisplayImageTask);
    }
}
