package com.igexin.download;

public interface IDownloadCallback {
    public static final boolean isVisibilty = true;

    String getName();

    void update(DownloadInfo downloadInfo);
}
