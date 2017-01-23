package com.igexin.download;

import com.facebook.ads.AdError;
import java.io.Serializable;

public class DownloadInfo implements Serializable, Cloneable {
    long f12476a;
    public int mControl;
    public String mCookies;
    public long mCreateMod;
    public int mCurrentBytes;
    public String mData1;
    public long mData10;
    public String mData2;
    public String mData3;
    public String mData4;
    public String mData5;
    public String mData6;
    public String mData7;
    public String mData8;
    public String mData9;
    public int mDestination;
    public long mDownSpeed;
    public String mETag;
    public String mExtras;
    public String mFileName;
    public int mFuzz;
    public volatile boolean mHasActiveThread;
    public String mHint;
    public int mId;
    public int mIsWebIcon;
    public int mLastBytes;
    public long mLastMod;
    public boolean mMediaScanned;
    public String mMimeType;
    public boolean mNoIntegrity;
    public boolean mNotice;
    public boolean mNotify;
    public int mNumFailed;
    public int mRedirectCount;
    public String mReferer;
    public int mRetryAfter;
    public int mStatus;
    public int mTotalBytes;
    public String mUri;
    public String mUserAgent;
    public int mVisibility;

    public DownloadInfo() {
        this.mNotice = true;
        this.mNotify = true;
    }

    public DownloadInfo(int i, String str, boolean z, String str2, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2, String str5, String str6, String str7, String str8, int i9, int i10, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, long j3, int i11, boolean z2) {
        this.mNotice = true;
        this.mNotify = true;
        this.mId = i;
        this.mUri = str;
        this.mNoIntegrity = z;
        this.mHint = str2;
        this.mFileName = str3;
        this.mMimeType = str4;
        this.mDestination = i2;
        this.mVisibility = i3;
        this.mControl = i4;
        this.mStatus = i5;
        this.mNumFailed = i6;
        this.mRetryAfter = i7;
        this.mRedirectCount = i8;
        this.mLastMod = j;
        this.mCreateMod = j2;
        this.mExtras = str5;
        this.mCookies = str6;
        this.mUserAgent = str7;
        this.mReferer = str8;
        this.mTotalBytes = i9;
        this.mCurrentBytes = i10;
        this.mETag = str9;
        this.mFuzz = C3708h.f12513a.nextInt(AdError.NO_FILL_ERROR_CODE);
        this.mData1 = str10;
        this.mData2 = str11;
        this.mData3 = str12;
        this.mData4 = str13;
        this.mData5 = str14;
        this.mData6 = str15;
        this.mData7 = str16;
        this.mData8 = str17;
        this.mData9 = str18;
        this.mData10 = j3;
        this.mIsWebIcon = i11;
        this.mMediaScanned = z2;
    }

    public boolean canUseNetwork(boolean z, boolean z2) {
        return !z ? false : (this.mDestination == 3 && z2) ? false : true;
    }

    public DownloadInfo clone() {
        try {
            return (DownloadInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void copyFrom(DownloadInfo downloadInfo) {
        this.mControl = downloadInfo.mControl;
        this.mStatus = downloadInfo.mStatus;
        this.mTotalBytes = downloadInfo.mTotalBytes;
        this.mCurrentBytes = downloadInfo.mCurrentBytes;
        this.mLastBytes = downloadInfo.mLastBytes;
        this.mNotice = downloadInfo.mNotice;
        if (this.mFileName == null) {
            this.mFileName = downloadInfo.mFileName;
        }
    }

    public boolean hasCompletionNotification() {
        return Downloads.isStatusCompleted(this.mStatus) && this.mVisibility == 1;
    }

    public boolean isReadyToRestart(long j) {
        return this.mControl == 1 ? false : this.mStatus == 0 ? true : this.mStatus == Downloads.STATUS_PENDING ? true : (this.mStatus == Downloads.STATUS_RUNNING_PAUSED || Downloads.isStatusError(this.mStatus)) ? this.mNumFailed == 0 ? true : restartTime() < j : false;
    }

    public boolean isReadyToStart(long j) {
        return this.mControl == 1 ? false : this.mStatus == 0 ? true : this.mStatus == Downloads.STATUS_PENDING ? true : this.mStatus == Downloads.STATUS_RUNNING ? true : this.mStatus == Downloads.STATUS_RUNNING_PAUSED ? this.mNumFailed == 0 ? true : restartTime() < j : false;
    }

    public void refreshSpeed() {
        if (Downloads.isStatusCompleted(this.mStatus) || this.mStatus != Downloads.STATUS_RUNNING) {
            this.mDownSpeed = 0;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f12476a;
        this.f12476a = System.currentTimeMillis();
        if (this.mCurrentBytes != this.mLastBytes) {
            if (this.f12476a != 0) {
                this.mDownSpeed = ((long) (Math.max(0, this.mCurrentBytes - this.mLastBytes) * AdError.NETWORK_ERROR_CODE)) / currentTimeMillis;
            } else {
                this.mDownSpeed = 0;
            }
            this.mLastBytes = this.mCurrentBytes;
        } else if (currentTimeMillis > 1500) {
            this.mDownSpeed = 0;
        } else if (currentTimeMillis > 500) {
            this.mDownSpeed >>= 1;
        }
    }

    public long restartTime() {
        return this.mRetryAfter > 0 ? this.mLastMod + ((long) this.mRetryAfter) : this.mLastMod + ((long) (((this.mFuzz + AdError.NETWORK_ERROR_CODE) * 30) * (1 << (this.mNumFailed - 1))));
    }
}
