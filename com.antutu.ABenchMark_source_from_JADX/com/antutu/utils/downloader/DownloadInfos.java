package com.antutu.utils.downloader;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.pushsdk.BuildConfig;

public class DownloadInfos implements Parcelable {
    public static final int CANCEL_DIALOG_STYLE_3DPLUGIN = 1;
    public static final int CANCEL_DIALOG_STYLE_DEFAULT = 0;
    public static final Creator<DownloadInfos> CREATOR;
    private IDownloadServiceCallback callback;
    private String cancelDialogCancelText;
    private String cancelDialogConfirmText;
    private String cancelDialogContent;
    private int cancelDialogStyle;
    private String cancelDialogTitle;
    private String downloadPath;
    private FileDownloader downloader;
    public int fileSize;
    private boolean isDownloading;
    private boolean isOpenable;
    private boolean isPlugIn;
    private boolean isQuietDownload;
    public int lastPercent;
    public int lastSize;
    private boolean needRename;
    private Notification notify;
    private String saveDir;
    private String title_info;
    private int uid;
    private String url;

    /* renamed from: com.antutu.utils.downloader.DownloadInfos.1 */
    static class C18101 implements Creator<DownloadInfos> {
        C18101() {
        }

        public DownloadInfos createFromParcel(Parcel parcel) {
            return new DownloadInfos(parcel);
        }

        public DownloadInfos[] newArray(int i) {
            return new DownloadInfos[i];
        }
    }

    static {
        CREATOR = new C18101();
    }

    public DownloadInfos() {
        this.uid = 0;
        this.url = BuildConfig.FLAVOR;
        this.lastPercent = 0;
        this.lastSize = 0;
        this.fileSize = 0;
        this.title_info = BuildConfig.FLAVOR;
        this.downloadPath = BuildConfig.FLAVOR;
        this.saveDir = BuildConfig.FLAVOR;
        this.needRename = false;
        this.isDownloading = false;
        this.isPlugIn = false;
        this.downloader = null;
        this.notify = null;
        this.isQuietDownload = false;
        this.isOpenable = true;
        this.cancelDialogStyle = 0;
    }

    public DownloadInfos(Parcel parcel) {
        this.uid = 0;
        this.url = BuildConfig.FLAVOR;
        this.lastPercent = 0;
        this.lastSize = 0;
        this.fileSize = 0;
        this.title_info = BuildConfig.FLAVOR;
        this.downloadPath = BuildConfig.FLAVOR;
        this.saveDir = BuildConfig.FLAVOR;
        this.needRename = false;
        this.isDownloading = false;
        this.isPlugIn = false;
        this.downloader = null;
        this.notify = null;
        this.isQuietDownload = false;
        this.isOpenable = true;
        this.cancelDialogStyle = 0;
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        boolean z = true;
        try {
            this.uid = parcel.readInt();
            this.url = parcel.readString();
            this.lastPercent = parcel.readInt();
            this.title_info = parcel.readString();
            this.downloadPath = parcel.readString();
            this.needRename = parcel.readByte() != null;
            this.isDownloading = parcel.readByte() != null;
            if (parcel.readByte() == null) {
                z = false;
            }
            this.isPlugIn = z;
            this.saveDir = parcel.readString();
            this.cancelDialogStyle = parcel.readInt();
            this.cancelDialogTitle = parcel.readString();
            this.cancelDialogContent = parcel.readString();
            this.cancelDialogCancelText = parcel.readString();
            this.cancelDialogConfirmText = parcel.readString();
            this.isQuietDownload = Boolean.parseBoolean(parcel.readString());
            this.fileSize = parcel.readInt();
            this.lastSize = parcel.readInt();
            this.isOpenable = Boolean.parseBoolean(parcel.readString());
        } catch (Exception e) {
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getCancelDialogCancelText() {
        return this.cancelDialogCancelText;
    }

    public String getCancelDialogConfirmText() {
        return this.cancelDialogConfirmText;
    }

    public String getCancelDialogContent() {
        return this.cancelDialogContent;
    }

    public int getCancelDialogStyle() {
        return this.cancelDialogStyle;
    }

    public String getCancelDialogTitle() {
        return this.cancelDialogTitle;
    }

    public String getDownloadFilepath() {
        return this.downloadPath;
    }

    public IDownloadServiceCallback getDownloadServiceCallback() {
        return this.callback;
    }

    public FileDownloader getDownloader() {
        return this.downloader;
    }

    public Notification getNotify() {
        return this.notify;
    }

    public String getSaveDir() {
        return this.saveDir;
    }

    public String getTitle() {
        return this.title_info;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAvailable() {
        return this.url != null && this.url.length() >= 5;
    }

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public boolean isNeedRename() {
        return this.needRename;
    }

    public boolean isOpenable() {
        return this.isOpenable;
    }

    public boolean isPlugIn() {
        return this.isPlugIn;
    }

    public boolean isQuietDownload() {
        return this.isQuietDownload;
    }

    public void setCancelDialogCancelText(String str) {
        this.cancelDialogCancelText = str;
    }

    public void setCancelDialogConfirmText(String str) {
        this.cancelDialogConfirmText = str;
    }

    public void setCancelDialogContent(String str) {
        this.cancelDialogContent = str;
    }

    public void setCancelDialogStyle(int i) {
        this.cancelDialogStyle = i;
    }

    public void setCancelDialogTitle(String str) {
        this.cancelDialogTitle = str;
    }

    public void setDownloadFilepath(String str) {
        this.downloadPath = str;
    }

    public void setDownloadServiceCallback(IDownloadServiceCallback iDownloadServiceCallback) {
        this.callback = iDownloadServiceCallback;
    }

    public void setDownloader(FileDownloader fileDownloader) {
        this.downloader = fileDownloader;
    }

    public void setIsDownloading(boolean z) {
        this.isDownloading = z;
    }

    public void setIsOpenable(boolean z) {
        this.isOpenable = z;
    }

    public void setIsPlugIn(boolean z) {
        this.isPlugIn = z;
    }

    public void setIsQuietDownload(boolean z) {
        this.isQuietDownload = z;
    }

    public void setNeedRename(boolean z) {
        this.needRename = z;
    }

    public void setNotify(Notification notification) {
        this.notify = notification;
    }

    public void setSaveDir(String str) {
        this.saveDir = str;
    }

    public void setTitle(String str) {
        this.title_info = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = CANCEL_DIALOG_STYLE_3DPLUGIN;
        try {
            parcel.writeInt(this.uid);
            parcel.writeString(this.url);
            parcel.writeInt(this.lastPercent);
            parcel.writeString(this.title_info);
            parcel.writeString(this.downloadPath);
            parcel.writeByte((byte) (this.needRename ? CANCEL_DIALOG_STYLE_3DPLUGIN : 0));
            parcel.writeByte((byte) (this.isDownloading ? CANCEL_DIALOG_STYLE_3DPLUGIN : 0));
            if (!this.isPlugIn) {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeString(this.saveDir);
            parcel.writeInt(this.cancelDialogStyle);
            parcel.writeString(this.cancelDialogTitle);
            parcel.writeString(this.cancelDialogContent);
            parcel.writeString(this.cancelDialogCancelText);
            parcel.writeString(this.cancelDialogConfirmText);
            parcel.writeString(String.valueOf(this.isQuietDownload));
            parcel.writeInt(this.fileSize);
            parcel.writeInt(this.lastSize);
            parcel.writeString(String.valueOf(this.isOpenable));
        } catch (Exception e) {
        }
    }
}
