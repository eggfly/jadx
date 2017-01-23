package com.antutu.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GarbageCleaner {
    private static final int MSG_CACHE_INFO = 1;
    private static GarbageCleaner mInstance;
    private volatile int count;
    private volatile boolean hasFindAll;
    private boolean isClean;
    private Map<String, AppInfo> mAppInfos;
    private Context mContext;
    private List<GarbageCleanerCallback> mGCCallbackList;
    private Handler mHandler;
    private PackageManager pm;
    private long totalCacheSize;

    /* renamed from: com.antutu.utils.GarbageCleaner.1 */
    class C17951 extends Handler {
        C17951(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == GarbageCleaner.MSG_CACHE_INFO) {
                try {
                    PackageStats packageStats = (PackageStats) message.obj;
                    String str = packageStats.packageName;
                    long j = packageStats.cacheSize;
                    if (j == 0) {
                        GarbageCleaner.this.mAppInfos.remove(str);
                    } else {
                        GarbageCleaner.access$104(GarbageCleaner.this);
                        GarbageCleaner.this.totalCacheSize = GarbageCleaner.this.totalCacheSize + j;
                        AppInfo appInfo = (AppInfo) GarbageCleaner.this.mAppInfos.get(packageStats.packageName);
                        appInfo.cacheSize = j;
                        appInfo.icon = GarbageCleaner.this.getAppIcon(packageStats.packageName);
                    }
                    if (GarbageCleaner.this.count == GarbageCleaner.this.mAppInfos.size()) {
                        GarbageCleaner.this.hasFindAll = true;
                        MLog.m6865d("GarbageCleaner", "hzd, count=" + GarbageCleaner.this.count);
                        for (GarbageCleanerCallback access$600 : GarbageCleaner.this.mGCCallbackList) {
                            GarbageCleaner.this.notifyGCFinished(access$600);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.utils.GarbageCleaner.2 */
    class C17962 extends Thread {
        C17962() {
        }

        public void run() {
            GarbageCleaner.this.totalCacheSize = 0;
            GarbageCleaner.this.hasFindAll = false;
            GarbageCleaner.this.queryAppInfo();
            GarbageCleaner.this.queryCacheSize();
        }
    }

    public static class AppInfo {
        public long cacheSize;
        public Drawable icon;
        public String label;
        public String pkgName;

        public String toString() {
            return "\u5e94\u7528\u7a0b\u5e8f\uff1a" + this.label + ", \u5305\u540d\uff1a" + this.pkgName + ", \u7f13\u5b58\u5927\u5c0f\uff1a" + this.cacheSize;
        }
    }

    public interface GarbageCleanerCallback {
        void onCleanFinished();

        void onGCFinished(int i);
    }

    class PkgSizeObserver extends Stub {
        PkgSizeObserver() {
        }

        public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            if (GarbageCleaner.this.isValid(packageStats)) {
                Message obtainMessage = GarbageCleaner.this.mHandler.obtainMessage(GarbageCleaner.MSG_CACHE_INFO);
                obtainMessage.obj = packageStats;
                GarbageCleaner.this.mHandler.sendMessage(obtainMessage);
            }
        }
    }

    static {
        mInstance = null;
    }

    private GarbageCleaner(Context context) {
        this.mAppInfos = new ConcurrentHashMap(16, 0.75f, 2);
        this.totalCacheSize = 0;
        this.count = 0;
        this.hasFindAll = false;
        this.isClean = false;
        if (context == null) {
            throw new IllegalArgumentException("context can not be null!");
        }
        this.mGCCallbackList = new ArrayList(5);
        this.mContext = context;
        this.pm = this.mContext.getPackageManager();
        this.mHandler = new C17951(this.mContext.getMainLooper());
    }

    static /* synthetic */ int access$104(GarbageCleaner garbageCleaner) {
        int i = garbageCleaner.count + MSG_CACHE_INFO;
        garbageCleaner.count = i;
        return i;
    }

    private Drawable getAppIcon(String str) {
        try {
            return this.pm.getApplicationInfo(str, 0).loadIcon(this.pm);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static GarbageCleaner getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new GarbageCleaner(context);
        }
        return mInstance;
    }

    private boolean isValid(PackageStats packageStats) {
        if (packageStats == null) {
            return false;
        }
        CharSequence charSequence = packageStats.packageName;
        if (!this.mContext.getPackageName().equals(charSequence)) {
            return !TextUtils.isEmpty(charSequence);
        } else {
            this.mAppInfos.remove(charSequence);
            return false;
        }
    }

    private void notifyGCFinished(GarbageCleanerCallback garbageCleanerCallback) {
        if (garbageCleanerCallback != null) {
            int size = this.mAppInfos.size();
            if (this.mAppInfos != null && this.hasFindAll) {
                garbageCleanerCallback.onGCFinished(size);
            }
            if (!this.mGCCallbackList.contains(garbageCleanerCallback)) {
                this.mGCCallbackList.add(garbageCleanerCallback);
            }
        }
    }

    private void queryAppInfo() {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = this.pm.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(this.pm));
        if (this.mAppInfos != null) {
            this.mAppInfos.clear();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                String charSequence = resolveInfo.loadLabel(this.pm).toString();
                AppInfo appInfo = new AppInfo();
                appInfo.pkgName = str;
                appInfo.label = charSequence;
                this.mAppInfos.put(str, appInfo);
            }
        }
    }

    private void queryCacheSize() {
        try {
            Method method = this.pm.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class});
            method.setAccessible(true);
            PkgSizeObserver pkgSizeObserver = new PkgSizeObserver();
            for (AppInfo appInfo : this.mAppInfos.values()) {
                if (!TextUtils.isEmpty(appInfo.pkgName)) {
                    method.invoke(this.pm, new Object[]{r0, pkgSizeObserver});
                }
            }
        } catch (Exception e) {
        }
    }

    public void addGarbageCleanerCallback(GarbageCleanerCallback garbageCleanerCallback) {
        if (garbageCleanerCallback != null) {
            MLog.m6871i(BuildConfig.FLAVOR, "hzd, addGarbageCleanerCallback, c=" + garbageCleanerCallback.toString());
            notifyGCFinished(garbageCleanerCallback);
        }
    }

    public List<AppInfo> getAppInfoList() {
        List<AppInfo> arrayList = new ArrayList();
        for (AppInfo add : this.mAppInfos.values()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void getAppInfos() {
        new C17962().start();
    }

    public String getGarbageSize() {
        return !this.hasFindAll ? BuildConfig.FLAVOR : Formatter.formatShortFileSize(this.mContext, this.totalCacheSize);
    }

    public boolean isClean() {
        return this.isClean;
    }

    public void notifyCleanFinished() {
        MLog.m6871i(BuildConfig.FLAVOR, "hzd, notifyCleanFinished...");
        for (GarbageCleanerCallback garbageCleanerCallback : this.mGCCallbackList) {
            if (garbageCleanerCallback != null) {
                garbageCleanerCallback.onCleanFinished();
            }
        }
        recycle();
    }

    public void recycle() {
        if (this.mGCCallbackList != null) {
            this.mGCCallbackList.clear();
        }
        if (this.mAppInfos != null) {
            this.mAppInfos.clear();
        }
    }

    public synchronized void setIsClean(boolean z) {
        this.isClean = z;
    }
}
