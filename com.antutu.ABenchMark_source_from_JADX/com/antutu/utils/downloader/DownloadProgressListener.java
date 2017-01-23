package com.antutu.utils.downloader;

public interface DownloadProgressListener {
    void onDownloadSize(int i, int i2);

    void onFinished(boolean z);

    void onInterrupted();
}
