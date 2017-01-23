package com.igexin.download;

import android.app.Service;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.os.IBinder;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import java.io.File;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

public class DownloadService extends Service {
    static boolean f12482a;
    private C3704d f12483b;
    private ArrayList f12484c;
    private C3706f f12485d;
    private boolean f12486e;
    private C3705e f12487f;
    private boolean f12488g;
    private Object f12489h;
    private CharArrayBuffer f12490i;
    private CharArrayBuffer f12491j;

    static {
        f12482a = false;
    }

    private long m15147a(int i, long j) {
        DownloadInfo downloadInfo = (DownloadInfo) this.f12484c.get(i);
        if (Downloads.isStatusCompleted(downloadInfo.mStatus)) {
            return -1;
        }
        if (downloadInfo.mStatus != Downloads.STATUS_RUNNING_PAUSED) {
            return 0;
        }
        if (downloadInfo.mNumFailed == 0) {
            return 0;
        }
        long restartTime = downloadInfo.restartTime();
        return restartTime <= j ? 0 : restartTime - j;
    }

    private String m15152a(String str, Cursor cursor, String str2) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str2);
        if (str == null) {
            return cursor.getString(columnIndexOrThrow);
        }
        if (this.f12491j == null) {
            this.f12491j = new CharArrayBuffer(SpdyProtocol.SLIGHTSSLV2);
        }
        cursor.copyStringToBuffer(columnIndexOrThrow, this.f12491j);
        int i = this.f12491j.sizeCopied;
        if (i != str.length()) {
            return cursor.getString(columnIndexOrThrow);
        }
        if (this.f12490i == null || this.f12490i.sizeCopied < i) {
            this.f12490i = new CharArrayBuffer(i);
        }
        char[] cArr = this.f12490i.data;
        char[] cArr2 = this.f12491j.data;
        str.getChars(0, i, cArr, 0);
        for (columnIndexOrThrow = i - 1; columnIndexOrThrow >= 0; columnIndexOrThrow--) {
            if (cArr[columnIndexOrThrow] != cArr2[columnIndexOrThrow]) {
                return new String(cArr2, 0, i);
            }
        }
        return str;
    }

    private void m15153a() {
        synchronized (this) {
            this.f12486e = true;
            if (this.f12485d == null) {
                this.f12485d = new C3706f(this);
                this.f12485d.start();
            }
        }
    }

    private void m15154a(Cursor cursor, int i, boolean z, boolean z2, long j) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(MsgConstant.KEY_STATUS);
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("numfailed");
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("method"));
        DownloadInfo downloadInfo = new DownloadInfo(cursor.getInt(cursor.getColumnIndexOrThrow(C4233j.f14384g)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_URI)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_NO_INTEGRITY)) == 1, cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_FILE_NAME_HINT)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads._DATA)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_MIME_TYPE)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DESTINATION)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_VISIBILITY)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CONTROL)), cursor.getInt(columnIndexOrThrow), cursor.getInt(columnIndexOrThrow2), 268435455 & i2, i2 >> 28, cursor.getLong(cursor.getColumnIndexOrThrow(Downloads.COLUMN_LAST_MODIFICATION)), cursor.getLong(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CREATE_MODIFICATION)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_EXTRAS)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_COOKIE_DATA)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_USER_AGENT)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_REFERER)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_TOTAL_BYTES)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CURRENT_BYTES)), cursor.getString(cursor.getColumnIndexOrThrow("etag")), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA1)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA2)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA3)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA4)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA5)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA6)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA7)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA8)), cursor.getString(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA9)), cursor.getLong(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DATA10)), cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_IS_WEB_ICON)), cursor.getInt(cursor.getColumnIndexOrThrow("scanned")) == 1);
        this.f12484c.add(i, downloadInfo);
        if (!downloadInfo.canUseNetwork(z, z2)) {
            return;
        }
        if ((UtilityImpl.NET_TYPE_WIFI.equals(downloadInfo.mData9) && !C3708h.m15203b((Context) this)) || !downloadInfo.isReadyToStart(j)) {
            return;
        }
        ContentValues contentValues;
        if (m15158a(SdkDownLoader.f12494a)) {
            if (!downloadInfo.mHasActiveThread) {
                if (downloadInfo.mStatus != Downloads.STATUS_RUNNING) {
                    downloadInfo.mStatus = Downloads.STATUS_RUNNING;
                    contentValues = new ContentValues();
                    contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(downloadInfo.mStatus));
                    getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) downloadInfo.mId), contentValues, null, null);
                }
                C3707g c3707g = new C3707g(this, downloadInfo);
                downloadInfo.mHasActiveThread = true;
                c3707g.start();
                downloadInfo.mNotice = false;
            }
        } else if (downloadInfo.mStatus != Downloads.STATUS_PENDING) {
            downloadInfo.mStatus = Downloads.STATUS_PENDING;
            contentValues = new ContentValues();
            contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(downloadInfo.mStatus));
            getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) downloadInfo.mId), contentValues, null, null);
        }
    }

    private boolean m15158a(int i) {
        Cursor query = getContentResolver().query(Downloads.f12492a, new String[]{C4233j.f14384g}, "status == '192'", null, null);
        if (query == null) {
            return false;
        }
        boolean z = query.getCount() < i;
        query.close();
        return z;
    }

    private boolean m15159a(Cursor cursor, int i) {
        DownloadInfo downloadInfo = (DownloadInfo) this.f12484c.get(i);
        synchronized (this) {
            if (this.f12489h != null) {
                try {
                    this.f12489h.getClass().getMethod("scanFile", new Class[]{String.class, String.class}).invoke(this.f12489h, new Object[]{downloadInfo.mFileName, downloadInfo.mMimeType});
                    downloadInfo.mMediaScanned = true;
                    if (cursor != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("scanned", Integer.valueOf(1));
                        getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, cursor.getLong(cursor.getColumnIndexOrThrow(C4233j.f14384g))), contentValues, null, null);
                    }
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    private boolean m15162a(String str) {
        return true;
    }

    private void m15165b(int i) {
        DownloadInfo downloadInfo = (DownloadInfo) this.f12484c.get(i);
        if (downloadInfo.mStatus == Downloads.STATUS_RUNNING) {
            downloadInfo.mStatus = Downloads.STATUS_CANCELED;
        } else if (!(downloadInfo.mDestination == 0 || downloadInfo.mFileName == null)) {
            new File(downloadInfo.mFileName).delete();
        }
        this.f12484c.remove(i);
    }

    private void m15166b(Cursor cursor, int i, boolean z, boolean z2, long j) {
        DownloadInfo downloadInfo = (DownloadInfo) this.f12484c.get(i);
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(MsgConstant.KEY_STATUS);
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("numfailed");
        downloadInfo.mId = cursor.getInt(cursor.getColumnIndexOrThrow(C4233j.f14384g));
        downloadInfo.mUri = m15152a(downloadInfo.mUri, cursor, Downloads.COLUMN_URI);
        downloadInfo.mNoIntegrity = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_NO_INTEGRITY)) == 1;
        downloadInfo.mHint = m15152a(downloadInfo.mHint, cursor, Downloads.COLUMN_FILE_NAME_HINT);
        downloadInfo.mFileName = m15152a(downloadInfo.mFileName, cursor, Downloads._DATA);
        downloadInfo.mMimeType = m15152a(downloadInfo.mMimeType, cursor, Downloads.COLUMN_MIME_TYPE);
        downloadInfo.mDestination = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_DESTINATION));
        downloadInfo.mVisibility = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_VISIBILITY));
        synchronized (downloadInfo) {
            downloadInfo.mControl = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CONTROL));
        }
        downloadInfo.mStatus = cursor.getInt(columnIndexOrThrow);
        downloadInfo.mNumFailed = cursor.getInt(columnIndexOrThrow2);
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("method"));
        downloadInfo.mRetryAfter = 268435455 & i2;
        downloadInfo.mRedirectCount = i2 >> 28;
        downloadInfo.mLastMod = cursor.getLong(cursor.getColumnIndexOrThrow(Downloads.COLUMN_LAST_MODIFICATION));
        downloadInfo.mCreateMod = cursor.getLong(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CREATE_MODIFICATION));
        downloadInfo.mCookies = m15152a(downloadInfo.mCookies, cursor, Downloads.COLUMN_COOKIE_DATA);
        downloadInfo.mExtras = m15152a(downloadInfo.mExtras, cursor, Downloads.COLUMN_EXTRAS);
        downloadInfo.mUserAgent = m15152a(downloadInfo.mUserAgent, cursor, Downloads.COLUMN_USER_AGENT);
        downloadInfo.mReferer = m15152a(downloadInfo.mReferer, cursor, Downloads.COLUMN_REFERER);
        downloadInfo.mTotalBytes = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_TOTAL_BYTES));
        downloadInfo.mCurrentBytes = cursor.getInt(cursor.getColumnIndexOrThrow(Downloads.COLUMN_CURRENT_BYTES));
        downloadInfo.mETag = m15152a(downloadInfo.mETag, cursor, "etag");
        if (!downloadInfo.canUseNetwork(z, z2)) {
            return;
        }
        if ((UtilityImpl.NET_TYPE_WIFI.equals(downloadInfo.mData9) && !C3708h.m15203b((Context) this)) || !downloadInfo.isReadyToRestart(j)) {
            return;
        }
        ContentValues contentValues;
        if (m15158a(SdkDownLoader.f12494a)) {
            if (!downloadInfo.mHasActiveThread) {
                downloadInfo.mStatus = Downloads.STATUS_RUNNING;
                contentValues = new ContentValues();
                contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(downloadInfo.mStatus));
                getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) downloadInfo.mId), contentValues, null, null);
                C3707g c3707g = new C3707g(this, downloadInfo);
                downloadInfo.mHasActiveThread = true;
                c3707g.start();
                downloadInfo.mNotice = false;
            }
        } else if (downloadInfo.mStatus != Downloads.STATUS_PENDING) {
            downloadInfo.mStatus = Downloads.STATUS_PENDING;
            contentValues = new ContentValues();
            contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(downloadInfo.mStatus));
            getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) downloadInfo.mId), contentValues, null, null);
        }
    }

    private boolean m15168b() {
        return this.f12489h != null;
    }

    private boolean m15172c(int i) {
        return ((DownloadInfo) this.f12484c.get(i)).hasCompletionNotification();
    }

    private boolean m15174d(int i) {
        DownloadInfo downloadInfo = (DownloadInfo) this.f12484c.get(i);
        return !downloadInfo.mMediaScanned && downloadInfo.mDestination == 0 && Downloads.isStatusSuccess(downloadInfo.mStatus) && !m15162a(downloadInfo.mMimeType);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
    }

    public void onCreate() {
        super.onCreate();
        try {
            this.f12484c = (ArrayList) Class.forName("com.google.android.collect.Lists").getMethod("newArrayList", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
        }
        this.f12483b = new C3704d(this);
        if (Downloads.f12492a == null) {
            DownloadProvider.m15140a("downloads." + getPackageName());
        }
        getContentResolver().registerContentObserver(Downloads.f12492a, true, this.f12483b);
        this.f12489h = null;
        this.f12488g = false;
        this.f12487f = new C3705e(this);
    }

    public void onDestroy() {
        getContentResolver().unregisterContentObserver(this.f12483b);
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        m15153a();
    }
}
