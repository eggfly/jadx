package com.antutu.utils.downloader;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.view.QuietUpdateFinishedActivity;
import com.antutu.redacc.C1692R;
import com.antutu.utils.MLog;
import com.antutu.utils.NetUtils;
import com.antutu.utils.downloader.IDownloadService.Stub;
import com.igexin.sdk.PushConsts;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadsService extends Service {
    public static final String ACTION_DOWNLOAD_DOWNLOADING_PERCENT = "ACTION_DOWNLOAD_DOWNLOADING_PERCENT";
    public static final String ACTION_DOWNLOAD_DOWNLOADING_SIZE = "ACTION_DOWNLOAD_DOWNLOADING_SIZE";
    public static final String ACTION_DOWNLOAD_FINISHED = "ACTION_DOWNLOAD_FINISHED";
    public static final String ACTION_DOWNLOAD_HAS_STARTED = "ACTION_DOWNLOAD_HAS_STARTED";
    public static final String ACTION_DOWNLOAD_INTERRUPTTED = "ACTION_DOWNLOAD_INTERRUPTTED";
    public static final String ACTION_DOWNLOAD_MESSAGE = "com.antutu.ABenchMark.download.ACTION_DOWNLOAD_MESSAGE";
    public static final String ACTION_DOWNLOAD_START = "ACTION_DOWNLOAD_START";
    public static final String DOWNLOAD_ABSOLUTE_PATH;
    public static final String DOWNLOAD_ACTION_ALL_AWAKE = "com.antutu.ABenchMark.DOWNLOAD_ACTION_ALL_AWAKE";
    public static final String DOWNLOAD_ACTION_ALL_PAUSE = "com.antutu.ABenchMark.DOWNLOAD_ACTION_ALL_PAUSE";
    public static final String DOWNLOAD_ACTION_START = "com.antutu.ABenchMark.DOWNLOAD_START";
    public static final String DOWNLOAD_ACTION_STOP = "com.antutu.ABenchMark.DOWNLOAD_STOP";
    public static final String DOWNLOAD_PATH = "/Download/";
    private static final int HANDLE_INTERRUPTTED = 3;
    private static final int HANDLE_NORMAL_FINISHED = 2;
    private static final int HANDLE_PRECENT = 1;
    private static final int HANDLE_SHOW_TOAST = 4;
    private static final int HANDLE_SIZE = 5;
    private static final int NOTIFY_ID = 17250;
    private static final String TAG = "DownloadService";
    private BroadcastReceiver broadcastReceiver;
    private int downloadIndex;
    private Map<String, DownloadInfos> downloadMap;
    Stub mBinder;
    private FileService mFileService;
    private Handler mHandler;
    private NotificationManager manager;
    private int nowNetStatus;
    private Map<String, DownloadInfos> pauseDownloadMap;
    private int perviousNetStatus;
    private final File saveDir;

    /* renamed from: com.antutu.utils.downloader.DownloadsService.1 */
    class C18111 extends BroadcastReceiver {
        C18111() {
        }

        public void onReceive(Context context, Intent intent) {
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                DownloadsService.this.perviousNetStatus = DownloadsService.this.nowNetStatus;
                DownloadsService.this.nowNetStatus = NetUtils.getNetWorkType(context);
                if (DownloadsService.this.nowNetStatus == 0) {
                    DownloadsService.this.pauseAllDownloadJob();
                }
                if (((DownloadsService.this.perviousNetStatus == DownloadsService.HANDLE_SHOW_TOAST && DownloadsService.this.nowNetStatus == DownloadsService.HANDLE_NORMAL_FINISHED) || DownloadsService.this.nowNetStatus == DownloadsService.HANDLE_INTERRUPTTED || DownloadsService.this.nowNetStatus == DownloadsService.HANDLE_PRECENT) && DownloadsService.this.pauseAllDownloadJob()) {
                    DownloadsService.this.showContinueDownAllDialog();
                }
                if ((DownloadsService.this.nowNetStatus == DownloadsService.HANDLE_SHOW_TOAST && DownloadsService.this.perviousNetStatus == DownloadsService.HANDLE_NORMAL_FINISHED) || DownloadsService.this.perviousNetStatus == DownloadsService.HANDLE_INTERRUPTTED || DownloadsService.this.perviousNetStatus == DownloadsService.HANDLE_PRECENT) {
                    DownloadsService.this.awokeAllDownloadJob();
                }
            }
        }
    }

    /* renamed from: com.antutu.utils.downloader.DownloadsService.2 */
    class C18122 extends Stub {
        C18122() {
        }

        public void cancelDownload(String str) {
        }

        public boolean isDownloading(String str) {
            return DownloadsService.this.downloadMap.containsKey(str);
        }

        public void startDownload(DownloadInfos downloadInfos, IDownloadServiceCallback iDownloadServiceCallback) {
            if (downloadInfos != null && !downloadInfos.isDownloading()) {
                if (DownloadsService.this.downloadMap.containsKey(downloadInfos.getUrl())) {
                    MLog.m6877w(DownloadsService.TAG, "hzd, @startDownload, \u76ee\u6807\u6587\u4ef6\u5df2\u5728\u4e0b\u8f7d\u4e2d...url=" + downloadInfos.getUrl());
                    DownloadInfos downloadInfos2 = (DownloadInfos) DownloadsService.this.downloadMap.get(downloadInfos.getUrl());
                    downloadInfos2.setDownloadServiceCallback(iDownloadServiceCallback);
                    if (iDownloadServiceCallback != null) {
                        iDownloadServiceCallback.onProgress(downloadInfos2.lastPercent);
                    }
                } else if (downloadInfos.isAvailable()) {
                    downloadInfos.setUid(DownloadsService.this.downloadIndex = DownloadsService.this.downloadIndex + DownloadsService.HANDLE_PRECENT);
                    downloadInfos.setDownloadServiceCallback(iDownloadServiceCallback);
                    DownloadsService.this.downloadMap.put(downloadInfos.getUrl(), downloadInfos);
                    DownloadsService.this.download(downloadInfos);
                }
            }
        }
    }

    /* renamed from: com.antutu.utils.downloader.DownloadsService.3 */
    class C18133 extends Handler {
        C18133() {
        }

        public void handleMessage(Message message) {
            DownloadInfos downloadInfos;
            switch (message.what) {
                case DownloadsService.HANDLE_PRECENT /*1*/:
                    int i = message.getData().getInt("percent");
                    downloadInfos = (DownloadInfos) message.obj;
                    if (downloadInfos == null) {
                        MLog.m6867e("hzd, DownloadInfo is null.");
                        return;
                    }
                    downloadInfos.lastPercent = i;
                    IDownloadServiceCallback downloadServiceCallback = downloadInfos.getDownloadServiceCallback();
                    if (downloadServiceCallback != null) {
                        try {
                            downloadServiceCallback.onProgress(i);
                        } catch (RemoteException e) {
                        }
                    }
                    DownloadsService.this.sendDownloadBroadCast(DownloadsService.ACTION_DOWNLOAD_DOWNLOADING_PERCENT, downloadInfos);
                    if (!downloadInfos.isQuietDownload()) {
                        downloadInfos.getNotify().contentView.setTextViewText(C1082R.id.progress_text, i + "%");
                        downloadInfos.getNotify().contentView.setProgressBar(C1082R.id.progress_bar, 100, i, false);
                        DownloadsService.this.manager.notify(downloadInfos.getUid() + DownloadsService.NOTIFY_ID, downloadInfos.getNotify());
                        if (i == 100) {
                            String downloadFilepath = downloadInfos.getDownloadFilepath();
                            File file = new File(downloadFilepath);
                            if (file.isFile()) {
                                boolean z = (downloadFilepath.toLowerCase().endsWith(".apk") && downloadInfos.isOpenable()) ? DownloadsService.HANDLE_PRECENT : false;
                                if (z) {
                                    Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                                    flags.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                                    DownloadsService.this.startActivity(flags);
                                }
                            }
                        }
                    }
                case DownloadsService.HANDLE_NORMAL_FINISHED /*2*/:
                    MLog.m6876w("hzd, HANDLE_NORMAL_FINISHED....");
                    DownloadsService.this.onDownloadStoped((DownloadInfos) message.obj);
                case DownloadsService.HANDLE_INTERRUPTTED /*3*/:
                    MLog.m6876w("hzd, HANDLE_INTERRUPTTED....");
                    DownloadsService.this.onDownloadStoped((DownloadInfos) message.obj);
                case DownloadsService.HANDLE_SHOW_TOAST /*4*/:
                    try {
                        Toast makeText = Toast.makeText(DownloadsService.this, (String) message.obj, DownloadsService.HANDLE_PRECENT);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    } catch (Exception e2) {
                    }
                case DownloadsService.HANDLE_SIZE /*5*/:
                    downloadInfos = (DownloadInfos) message.obj;
                    MLog.m6865d("Martin", "download handler size:" + downloadInfos.lastSize + "/" + downloadInfos.fileSize);
                    DownloadsService.this.sendDownloadBroadCast(DownloadsService.ACTION_DOWNLOAD_DOWNLOADING_SIZE, downloadInfos);
                default:
            }
        }
    }

    private class NormalDownloadThread extends Thread {
        private DownloadInfos info;

        /* renamed from: com.antutu.utils.downloader.DownloadsService.NormalDownloadThread.1 */
        class C18141 implements DownloadProgressListener {
            C18141() {
            }

            public void onDownloadSize(int i, int i2) {
                MLog.m6865d("Martin", "onDownloadSize size = " + i + " " + i2);
                int i3 = (int) ((((float) i) / ((float) i2)) * 100.0f);
                if (i3 >= 100 && i < i2) {
                    i3 = 99;
                }
                if (i != NormalDownloadThread.this.info.lastSize) {
                    NormalDownloadThread.this.info.fileSize = i2;
                    NormalDownloadThread.this.info.lastSize = i;
                    Message message = new Message();
                    message.what = DownloadsService.HANDLE_SIZE;
                    message.obj = NormalDownloadThread.this.info;
                    DownloadsService.this.mHandler.sendMessage(message);
                }
                if (i3 != NormalDownloadThread.this.info.lastPercent) {
                    NormalDownloadThread.this.info.lastPercent = i3;
                    message = new Message();
                    message.what = DownloadsService.HANDLE_PRECENT;
                    message.obj = NormalDownloadThread.this.info;
                    message.getData().putInt("percent", i3);
                    DownloadsService.this.mHandler.sendMessage(message);
                }
            }

            public void onFinished(boolean z) {
                DownloadsService.this.sendDownloadBroadCast(DownloadsService.ACTION_DOWNLOAD_FINISHED, NormalDownloadThread.this.info);
                MLog.m6865d("Martin", "onDownloadFinished isLocalFile = " + z);
                if (z || !NormalDownloadThread.this.info.isQuietDownload()) {
                    Message message = new Message();
                    message.what = DownloadsService.HANDLE_NORMAL_FINISHED;
                    message.obj = NormalDownloadThread.this.info;
                    DownloadsService.this.mHandler.sendMessage(message);
                    return;
                }
                DownloadsService.this.downloadMap.remove(NormalDownloadThread.this.info.getUrl());
                if (DownloadsService.this.downloadMap.size() < DownloadsService.HANDLE_PRECENT) {
                    DownloadsService.this.stopSelf();
                }
            }

            public void onInterrupted() {
                Message message = new Message();
                message.what = DownloadsService.HANDLE_INTERRUPTTED;
                message.obj = NormalDownloadThread.this.info;
                DownloadsService.this.mHandler.sendMessage(message);
            }
        }

        public NormalDownloadThread(DownloadInfos downloadInfos) {
            this.info = downloadInfos;
        }

        public void run() {
            DownloadProgressListener c18141 = new C18141();
            File access$1100 = DownloadsService.this.saveDir;
            if (!this.info.getSaveDir().isEmpty()) {
                access$1100 = new File(this.info.getSaveDir());
            }
            if (!(access$1100.exists() && access$1100.isDirectory())) {
                access$1100.mkdirs();
            }
            FileDownloader fileDownloader = new FileDownloader(DownloadsService.this, this.info.getUrl(), this.info.isNeedRename(), DownloadsService.this.mFileService, DownloadsService.this.saveDir, DownloadsService.HANDLE_PRECENT, c18141);
            File saveFile = fileDownloader.getSaveFile();
            if (saveFile == null) {
                DownloadsService.this.onDownloadStoped(null);
                return;
            }
            this.info.setDownloadFilepath(saveFile.getAbsolutePath());
            this.info.setDownloader(fileDownloader);
            CharSequence title = this.info.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = DownloadsService.this.getString(C1692R.string.donwload_plugin);
            } else {
                DownloadsService downloadsService = DownloadsService.this;
                Object[] objArr = new Object[DownloadsService.HANDLE_PRECENT];
                objArr[0] = title;
                title = downloadsService.getString(C1692R.string.download_format, objArr);
            }
            try {
                if (this.info.isPlugIn()) {
                    Message message = new Message();
                    message.what = DownloadsService.HANDLE_SHOW_TOAST;
                    message.obj = DownloadsService.this.getString(C1082R.string.a3d_download);
                    DownloadsService.this.mHandler.sendMessage(message);
                }
            } catch (Exception e) {
            }
            try {
                this.info.setIsDownloading(true);
                Intent intent = new Intent();
                if (DownloadsService.HANDLE_PRECENT == this.info.getCancelDialogStyle()) {
                    intent.setClass(DownloadsService.this, Stop3DPluginActivity.class);
                    intent.setFlags(268435456);
                } else if (this.info.getCancelDialogStyle() == 0) {
                    intent.setClass(DownloadsService.this, StopActivity.class);
                    intent.setFlags(268435456);
                }
                intent.putExtra("info", this.info);
                if (!this.info.isQuietDownload()) {
                    Notification notification = new Notification();
                    this.info.setNotify(notification);
                    notification.icon = C1082R.drawable.download;
                    notification.tickerText = title;
                    notification.flags = DownloadsService.HANDLE_NORMAL_FINISHED;
                    notification.contentIntent = PendingIntent.getActivity(DownloadsService.this, this.info.getUid(), intent, 134217728);
                    notification.contentView = new RemoteViews(DownloadsService.this.getPackageName(), C1082R.layout.download_notify_view);
                    notification.contentView.setTextViewText(C1082R.id.info_text, notification.tickerText);
                    DownloadsService.this.manager.notify(this.info.getUid() + DownloadsService.NOTIFY_ID, notification);
                }
                fileDownloader.download();
            } catch (Exception e2) {
                DownloadsService.this.onDownloadStoped(this.info);
            }
        }
    }

    static {
        DOWNLOAD_ABSOLUTE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + DOWNLOAD_PATH;
    }

    public DownloadsService() {
        this.saveDir = new File(DOWNLOAD_ABSOLUTE_PATH);
        this.manager = null;
        this.downloadIndex = 0;
        this.perviousNetStatus = -1;
        this.nowNetStatus = -1;
        this.broadcastReceiver = new C18111();
        this.mBinder = new C18122();
        this.mHandler = new C18133();
    }

    public static void awakeAllPauseDownload(Context context) {
        try {
            context.startService(new Intent(DOWNLOAD_ACTION_ALL_AWAKE, null, context, DownloadsService.class));
        } catch (Exception e) {
        }
    }

    private void download(DownloadInfos downloadInfos) {
        new NormalDownloadThread(downloadInfos).start();
    }

    private void downloadStart(DownloadInfos downloadInfos) {
        if (downloadInfos != null && downloadInfos.isAvailable()) {
            int i = this.downloadIndex;
            this.downloadIndex = i + HANDLE_PRECENT;
            downloadInfos.setUid(i);
            this.downloadMap.put(downloadInfos.getUrl(), downloadInfos);
            insertDownloadingDb(downloadInfos);
            sendDownloadBroadCast(ACTION_DOWNLOAD_START, downloadInfos);
            download(downloadInfos);
        }
    }

    private void downloadStop(DownloadInfos downloadInfos, boolean z) {
        sendDownloadBroadCast(ACTION_DOWNLOAD_INTERRUPTTED, downloadInfos);
        if (downloadInfos != null) {
            if (downloadInfos != null) {
                FileDownloader downloader = downloadInfos.getDownloader();
                if (downloader != null) {
                    downloader.stopDownload();
                }
            }
            onDownloadStoped(downloadInfos, z);
        }
    }

    private void insertDownloadingDb(DownloadInfos downloadInfos) {
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("downpath", downloadInfos.getUrl());
        contentValues.put("uid", Integer.valueOf(downloadInfos.getUid()));
        contentResolver.insert(Uri.parse("content://com.antutu.benchmark.provider.download/downloading"), contentValues);
    }

    private boolean isDownloading(DownloadInfos downloadInfos) {
        if (downloadInfos == null || !this.downloadMap.containsKey(downloadInfos.getUrl())) {
            return false;
        }
        MLog.m6877w(TAG, "hzd, @onStartCommand, \u76ee\u6807\u6587\u4ef6\u5df2\u5728\u4e0b\u8f7d\u4e2d...url=" + downloadInfos.getUrl());
        sendDownloadBroadCast(ACTION_DOWNLOAD_HAS_STARTED, downloadInfos);
        return true;
    }

    private void onDownloadStoped(DownloadInfos downloadInfos) {
        onDownloadStoped(downloadInfos, true);
    }

    private void onDownloadStoped(DownloadInfos downloadInfos, boolean z) {
        if (downloadInfos != null) {
            MLog.m6865d("Martin", "onDownloadStoped");
            try {
                if (!downloadInfos.isQuietDownload()) {
                    this.manager.cancel(downloadInfos.getUid() + NOTIFY_ID);
                }
                downloadInfos.setIsDownloading(false);
                IDownloadServiceCallback downloadServiceCallback = downloadInfos.getDownloadServiceCallback();
                if (downloadServiceCallback != null) {
                    if (downloadInfos.lastPercent == 100) {
                        downloadServiceCallback.onDownloadFinished();
                    } else {
                        downloadServiceCallback.onDownloadInterruptted();
                    }
                }
            } catch (Exception e) {
            }
            this.downloadMap.remove(downloadInfos.getUrl());
            String[] strArr = new String[HANDLE_PRECENT];
            strArr[0] = downloadInfos.getUrl();
            getContentResolver().delete(Uri.parse("content://com.antutu.benchmark.provider.download/downloading"), "downpath = ?", strArr);
            if (downloadInfos.isQuietDownload()) {
                Intent intent = new Intent(this, QuietUpdateFinishedActivity.class);
                intent.putExtra("SAVE_DIR", downloadInfos.getDownloadFilepath());
                intent.setFlags(268435456);
                startActivity(intent);
            }
            MLog.m6865d("Martin", "downloadMap size " + this.downloadMap.size());
            if (this.downloadMap.size() < HANDLE_PRECENT && z) {
                MLog.m6865d("Martin", "stop self");
                stopSelf();
            }
        }
    }

    public static void pauseAllDownload(Context context) {
        try {
            context.startService(new Intent(DOWNLOAD_ACTION_ALL_PAUSE, null, context, DownloadsService.class));
        } catch (Exception e) {
        }
    }

    private void sendDownloadBroadCast(String str, DownloadInfos downloadInfos) {
        Intent intent = new Intent(str);
        intent.setAction(ACTION_DOWNLOAD_MESSAGE);
        intent.putExtra(PushConsts.CMD_ACTION, str);
        intent.putExtra("info", downloadInfos);
        sendBroadcast(intent);
    }

    private void showContinueDownAllDialog() {
    }

    public static void startDownload(Context context, DownloadInfos downloadInfos) {
        Intent intent = new Intent(DOWNLOAD_ACTION_START, null, context, DownloadsService.class);
        intent.putExtra("info", downloadInfos);
        context.startService(intent);
    }

    public static void startDownloadService(Context context) {
        try {
            context.startService(new Intent(DOWNLOAD_ACTION_START, null, context, DownloadsService.class));
        } catch (Exception e) {
        }
    }

    public static void stopDownload(Context context, int i, String str) {
        try {
            context.startService(new Intent(DOWNLOAD_ACTION_STOP, null, context, DownloadsService.class).putExtra("url", str).putExtra("uid", i));
        } catch (Exception e) {
        }
    }

    public static void stopDownload(Context context, String str) {
        try {
            context.startService(new Intent(DOWNLOAD_ACTION_STOP, null, context, DownloadsService.class).putExtra("url", str));
        } catch (Exception e) {
        }
    }

    public void awokeAllDownloadJob() {
        Object obj = null;
        for (String str : this.pauseDownloadMap.keySet()) {
            downloadStart((DownloadInfos) this.pauseDownloadMap.get(obj));
        }
        this.pauseDownloadMap.clear();
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        try {
            if (this.manager == null) {
                this.manager = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            }
            if (this.downloadMap == null) {
                this.downloadMap = new HashMap();
            }
            if (this.pauseDownloadMap == null) {
                this.pauseDownloadMap = new HashMap();
            }
            getContentResolver().delete(Uri.parse("content://com.antutu.benchmark.provider.download/downloading"), null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerReceiver(this.broadcastReceiver, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    public void onDestroy() {
        MLog.m6871i(TAG, "hzd, onDestroy...");
        try {
            this.mFileService.closeDB();
            for (DownloadInfos uid : this.downloadMap.values()) {
                this.manager.cancel(uid.getUid() + NOTIFY_ID);
            }
            this.downloadMap.clear();
        } catch (Exception e) {
        }
        getContentResolver().delete(Uri.parse("content://com.antutu.benchmark.provider.download/downloading"), null, null);
        try {
            unregisterReceiver(this.broadcastReceiver);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
        System.exit(0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MLog.m6871i(TAG, "hzd, onStartCommand...");
        if (intent == null) {
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        if (this.mFileService == null) {
            this.mFileService = new FileService(this);
        }
        String action = intent.getAction();
        DownloadInfos downloadInfos;
        if (DOWNLOAD_ACTION_STOP.equals(action)) {
            int intExtra = intent.getIntExtra("uid", -1);
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra == null) {
                return super.onStartCommand(intent, i, i2);
            }
            downloadInfos = (DownloadInfos) this.downloadMap.get(stringExtra);
            if (downloadInfos == null) {
                return super.onStartCommand(intent, i, i2);
            }
            this.manager.cancel((intExtra == -1 ? downloadInfos.getUid() : intExtra) + NOTIFY_ID);
            downloadInfos = (DownloadInfos) this.downloadMap.get(stringExtra);
            MLog.m6865d("hch", "stop download url = " + stringExtra);
            downloadStop(downloadInfos, true);
        } else if (DOWNLOAD_ACTION_START.equals(action)) {
            downloadInfos = (DownloadInfos) intent.getParcelableExtra("info");
            if (downloadInfos == null) {
                return super.onStartCommand(intent, i, i2);
            }
            if (isDownloading(downloadInfos)) {
                return super.onStartCommand(intent, i, i2);
            }
            downloadStart(downloadInfos);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        MLog.m6871i(TAG, "hzd, onUnbind...");
        return super.onUnbind(intent);
    }

    public boolean pauseAllDownloadJob() {
        if (this.downloadMap == null || this.downloadMap.size() <= 0) {
            return false;
        }
        if (this.pauseDownloadMap == null) {
            this.pauseDownloadMap = new HashMap();
        } else {
            this.pauseDownloadMap.clear();
        }
        Object obj = null;
        for (String str : this.downloadMap.keySet()) {
            this.pauseDownloadMap.put(obj, this.downloadMap.get(obj));
            downloadStop((DownloadInfos) this.downloadMap.get(obj), false);
        }
        return true;
    }
}
