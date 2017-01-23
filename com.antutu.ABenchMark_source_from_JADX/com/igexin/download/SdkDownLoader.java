package com.igexin.download;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SdkDownLoader {
    static int f12494a;
    static String f12495b;
    static SdkDownLoader f12496c;
    Handler f12497d;
    String[] f12498e;
    private Context f12499f;
    private List f12500g;
    private final Object f12501h;
    public Map updateData;

    static {
        f12494a = 3;
        f12495b = "/libs/tmp";
    }

    private SdkDownLoader(Context context) {
        this.f12500g = new ArrayList();
        this.updateData = new HashMap();
        this.f12501h = new Object();
        this.f12498e = new String[]{C4233j.f14384g, Downloads._DATA, Downloads.COLUMN_FILE_NAME_HINT, MsgConstant.KEY_STATUS, Downloads.COLUMN_TOTAL_BYTES, Downloads.COLUMN_CURRENT_BYTES};
        this.f12499f = context;
        this.f12497d = new C3710j(this, context.getMainLooper());
    }

    private int m15180a(ContentValues contentValues) {
        try {
            ContentResolver contentResolver = this.f12499f.getContentResolver();
            contentValues.put(Downloads.COLUMN_DATA10, String.valueOf(System.currentTimeMillis()));
            Uri insert = contentResolver.insert(Downloads.f12492a, contentValues);
            if (insert != null) {
                return Integer.parseInt((String) insert.getPathSegments().get(1));
            }
        } catch (Throwable th) {
        }
        return -1;
    }

    private int m15181a(String str, String str2, ContentValues contentValues, String str3) {
        ContentValues contentValues2 = new ContentValues();
        if (contentValues != null) {
            contentValues2.putAll(contentValues);
        }
        contentValues2.put(Downloads.COLUMN_DESTINATION, Integer.valueOf(0));
        if (str != null) {
            contentValues2.put(Downloads.COLUMN_URI, str);
        }
        if (str2 != null) {
            contentValues2.put(Downloads.COLUMN_FILE_NAME_HINT, str2.replaceAll("\\*", BuildConfig.FLAVOR));
        }
        if (str3 != null) {
            contentValues2.put(Downloads.COLUMN_DESCRIPTION, str3);
        }
        return m15180a(contentValues2);
    }

    public static SdkDownLoader getInstantiate(Context context) {
        if (f12496c == null) {
            f12496c = new SdkDownLoader(context);
        }
        return f12496c;
    }

    IDownloadCallback m15184a(String str) {
        if (str == null) {
            return null;
        }
        for (IDownloadCallback iDownloadCallback : this.f12500g) {
            if (str.equals(iDownloadCallback.getName())) {
                return iDownloadCallback;
            }
        }
        return null;
    }

    protected void m15185a(Collection collection) {
        synchronized (this.f12501h) {
            if (collection != null) {
                if (collection.isEmpty()) {
                    this.updateData.clear();
                } else {
                    Map hashMap = new HashMap();
                    for (DownloadInfo downloadInfo : collection) {
                        DownloadInfo downloadInfo2;
                        if (this.updateData.containsKey(Integer.valueOf(downloadInfo.mId))) {
                            downloadInfo2 = (DownloadInfo) this.updateData.get(Integer.valueOf(downloadInfo.mId));
                            if (downloadInfo2 != null) {
                                downloadInfo2.copyFrom(downloadInfo);
                                hashMap.put(Integer.valueOf(downloadInfo2.mId), downloadInfo2);
                            }
                        } else {
                            downloadInfo2 = downloadInfo.clone();
                            if (downloadInfo2 != null) {
                                hashMap.put(Integer.valueOf(downloadInfo.mId), downloadInfo2);
                            }
                        }
                    }
                    this.updateData = hashMap;
                }
            }
        }
    }

    public boolean deleteTask(int i) {
        try {
            this.f12499f.getContentResolver().delete(ContentUris.withAppendedId(Downloads.f12492a, (long) i), null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean deleteTask(int[] iArr) {
        try {
            ContentResolver contentResolver = this.f12499f.getContentResolver();
            String[] strArr = new String[iArr.length];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = String.valueOf(iArr[i]);
            }
            contentResolver.delete(Downloads.f12492a, "_id=?", strArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public IDownloadCallback getCallback(String str) {
        if (str == null) {
            return null;
        }
        for (IDownloadCallback iDownloadCallback : this.f12500g) {
            if (str.equals(iDownloadCallback.getName())) {
                return iDownloadCallback;
            }
        }
        return null;
    }

    public boolean isRegistered(String str) {
        for (IDownloadCallback name : this.f12500g) {
            String name2 = name.getName();
            if (name2 != null && name2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int newTask(String str, String str2, String str3, boolean z, String str4) {
        ContentValues contentValues = new ContentValues();
        if (str3 != null) {
            contentValues.put(Downloads.COLUMN_DATA6, str3);
        }
        if (z) {
            contentValues.put(Downloads.COLUMN_DATA9, UtilityImpl.NET_TYPE_WIFI);
        }
        contentValues.put(Downloads.COLUMN_DATA8, str4);
        return m15181a(str, str2, contentValues, null);
    }

    public boolean pauseAllTask() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.COLUMN_CONTROL, Integer.valueOf(1));
            contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(Downloads.STATUS_RUNNING_PAUSED));
            this.f12499f.getContentResolver().update(Downloads.f12492a, contentValues, "status=? OR status=? OR(status=? AND control<>?)", new String[]{String.valueOf(Downloads.STATUS_RUNNING), String.valueOf(Downloads.STATUS_PENDING), String.valueOf(Downloads.STATUS_RUNNING_PAUSED), String.valueOf(1)});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean pauseTask(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.COLUMN_CONTROL, Integer.valueOf(1));
            this.f12499f.getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) i), contentValues, null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean queryTask(String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (Downloads.f12492a == null) {
            return false;
        }
        try {
            Cursor query = this.f12499f.getContentResolver().query(Downloads.f12492a, null, "data_8 = ? ", new String[]{str}, null);
            if (query != null) {
                try {
                    boolean z = query.getCount() > 0;
                    if (query != null) {
                        query.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else if (query == null) {
                return false;
            } else {
                query.close();
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void refreshList() {
        Message message = new Message();
        message.what = 2;
        this.f12497d.sendMessage(message);
    }

    public void registerDownloadCallback(IDownloadCallback iDownloadCallback) {
        if (!this.f12500g.contains(iDownloadCallback)) {
            this.f12500g.add(iDownloadCallback);
        }
    }

    public void setDownloadDir(String str) {
        f12495b = str;
    }

    public boolean startTask(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.COLUMN_CONTROL, Integer.valueOf(0));
            contentValues.put("numfailed", Integer.valueOf(0));
            this.f12499f.getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) i), contentValues, null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void unregisterDownloadCallback(IDownloadCallback iDownloadCallback) {
        this.f12500g.remove(iDownloadCallback);
    }

    public boolean updateTask(int i, String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str, str2);
            this.f12499f.getContentResolver().update(ContentUris.withAppendedId(Downloads.f12492a, (long) i), contentValues, null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
