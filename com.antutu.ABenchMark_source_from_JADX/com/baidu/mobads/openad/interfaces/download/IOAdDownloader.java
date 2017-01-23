package com.baidu.mobads.openad.interfaces.download;

import java.util.Observer;

public interface IOAdDownloader {

    public enum DownloadStatus {
        NONE(-1, "\u672a\u5f00\u59cb"),
        INITING(0, "\u4e0b\u8f7d\u51c6\u5907\u4e2d"),
        DOWNLOADING(1, "\u6b63\u5728\u4e0b\u8f7d"),
        CANCELLED(2, "\u5df2\u53d6\u6d88\u4e0b\u8f7d"),
        COMPLETED(3, "\u4e0b\u8f7d\u5b8c\u6210"),
        ERROR(4, "\u4e0b\u8f7d\u5931\u8d25"),
        COMPLETE_BUT_FILE_REMOVED(5, "\u4e0b\u8f7d\u5b8c\u4f46\u6587\u4ef6\u5f02\u5e38"),
        PAUSED(6, "\u5df2\u6682\u505c\u4e0b\u8f7d");
        
        private int f7069a;
        private String f7070b;

        private DownloadStatus(int i, String str) {
            this.f7069a = i;
            this.f7070b = str;
        }

        public int getCode() {
            return this.f7069a;
        }

        public String getMessage() {
            return this.f7070b;
        }
    }

    void addObserver(Observer observer);

    void cancel();

    int getFileSize();

    String getOutputPath();

    String getPackageName();

    float getProgress();

    DownloadStatus getState();

    String getTargetURL();

    String getTitle();

    String getURL();

    void pause();

    void removeObservers();

    void resume();

    void start();
}
