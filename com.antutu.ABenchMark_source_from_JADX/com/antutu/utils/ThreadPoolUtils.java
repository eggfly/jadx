package com.antutu.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
    private static final int MAX_SIZE = 256;
    private static ThreadPoolUtils mInstance;
    private static ExecutorService mService;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;

    static {
        sPoolWorkQueue = new LinkedBlockingQueue(100);
    }

    private ThreadPoolUtils() {
        mService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, MAX_SIZE, 0, TimeUnit.MILLISECONDS, sPoolWorkQueue);
    }

    public static ThreadPoolUtils getInstance() {
        if (mInstance == null) {
            synchronized (ThreadPoolUtils.class) {
                if (mInstance == null) {
                    ThreadPoolUtils threadPoolUtils = new ThreadPoolUtils();
                    mInstance = threadPoolUtils;
                    return threadPoolUtils;
                }
            }
        }
        return mInstance;
    }

    public static void shutdown() {
        mService.shutdownNow();
    }

    public void addRunnable(TaskItem taskItem) {
        sPoolWorkQueue.add(taskItem);
    }

    public void submit(TaskItem taskItem) {
        mService.submit(taskItem);
    }
}
