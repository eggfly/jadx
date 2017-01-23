package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.TextUtils;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.android.agoo.common.AgooConstants;

public class UmengDownloadResourceService extends Service {
    public static final String TAG;
    private static final String f14166d = ".tmp";
    private static final String f14167e = "RETRY_TIME";
    private static final String f14168f = "OPERATIOIN";
    private static final int f14169g = 1;
    private static final int f14170h = 2;
    private static final long f14171i = 1048576;
    private static final long f14172j = 86400000;
    private static final int f14173k = 300000;
    private static final int f14174l = 3;
    private static Thread f14175m;
    ScheduledThreadPoolExecutor f14176a;
    Context f14177b;
    ArrayList<String> f14178c;

    /* renamed from: com.umeng.message.UmengDownloadResourceService.1 */
    static class C42041 implements Runnable {
        final /* synthetic */ File f14160a;
        final /* synthetic */ long f14161b;

        C42041(File file, long j) {
            this.f14160a = file;
            this.f14161b = j;
        }

        public void run() {
            UmengDownloadResourceService.m17130b(this.f14160a, this.f14161b);
            UmengDownloadResourceService.f14175m = null;
        }
    }

    public class DownloadResourceTask extends AsyncTask<Void, Void, Boolean> {
        UMessage f14162a;
        ArrayList<String> f14163b;
        int f14164c;
        final /* synthetic */ UmengDownloadResourceService f14165d;

        public DownloadResourceTask(UmengDownloadResourceService umengDownloadResourceService, UMessage uMessage, int i) {
            this.f14165d = umengDownloadResourceService;
            this.f14162a = uMessage;
            this.f14163b = new ArrayList();
            if (uMessage.isLargeIconFromInternet()) {
                this.f14163b.add(uMessage.img);
            }
            if (uMessage.isSoundFromInternet()) {
                this.f14163b.add(uMessage.sound);
            }
            this.f14164c = i;
        }

        protected Boolean m17124a(Void... voidArr) {
            Iterator it = this.f14163b.iterator();
            boolean z = true;
            while (it.hasNext()) {
                z = download((String) it.next()) & z;
            }
            return Boolean.valueOf(z);
        }

        protected void m17125a(Boolean bool) {
            super.onPostExecute(bool);
            this.f14165d.f14178c.remove(this.f14162a.msg_id);
            if (bool.booleanValue() || this.f14164c <= 0) {
                MessageSharedPrefs.getInstance(this.f14165d.f14177b).setMessageResourceDownloaded(this.f14162a.msg_id);
                String jSONObject = this.f14162a.getRaw().toString();
                Intent intent = new Intent(this.f14165d.f14177b, UmengDownloadResourceService.class);
                intent.putExtra(C4156a.f13961w, jSONObject);
                intent.putExtra(AgooConstants.MESSAGE_ID, this.f14162a.message_id);
                intent.putExtra(AgooConstants.MESSAGE_TASK_ID, this.f14162a.task_id);
                intent.putExtra(UmengDownloadResourceService.f14168f, UmengDownloadResourceService.f14169g);
                intent.putExtra(UmengDownloadResourceService.f14167e, this.f14164c);
                this.f14165d.startService(intent);
            } else if (this.f14165d.f14178c.size() == 0) {
                this.f14165d.stopSelf();
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m17124a((Void[]) objArr);
        }

        public boolean download(String str) {
            Closeable openStream;
            Closeable fileOutputStream;
            Exception e;
            Throwable th;
            Closeable closeable = null;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                String str2 = str.hashCode() + BuildConfig.FLAVOR;
                String messageResourceFolder = UmengDownloadResourceService.getMessageResourceFolder(this.f14165d.f14177b, this.f14162a);
                File file = new File(messageResourceFolder, str2 + UmengDownloadResourceService.f14166d);
                File file2 = new File(messageResourceFolder, str2);
                if (file2.exists()) {
                    this.f14165d.close(null);
                    this.f14165d.close(null);
                    return true;
                }
                File file3 = new File(messageResourceFolder);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                openStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = openStream;
                    try {
                        e.printStackTrace();
                        this.f14165d.close(fileOutputStream);
                        this.f14165d.close(closeable);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        openStream = fileOutputStream;
                        this.f14165d.close(openStream);
                        this.f14165d.close(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.f14165d.close(openStream);
                    this.f14165d.close(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = openStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            file.renameTo(file2);
                            this.f14165d.close(openStream);
                            this.f14165d.close(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    closeable = fileOutputStream;
                    fileOutputStream = openStream;
                    e.printStackTrace();
                    this.f14165d.close(fileOutputStream);
                    this.f14165d.close(closeable);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    closeable = fileOutputStream;
                    this.f14165d.close(openStream);
                    this.f14165d.close(closeable);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                e.printStackTrace();
                this.f14165d.close(fileOutputStream);
                this.f14165d.close(closeable);
                return false;
            } catch (Throwable th5) {
                th = th5;
                openStream = null;
                this.f14165d.close(openStream);
                this.f14165d.close(closeable);
                throw th;
            }
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m17125a((Boolean) obj);
        }
    }

    static {
        TAG = UmengDownloadResourceService.class.getSimpleName();
    }

    private static long m17126a(File file) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return 0;
        }
        Stack stack = new Stack();
        stack.clear();
        stack.push(file);
        long j = 0;
        while (!stack.isEmpty()) {
            File[] listFiles = ((File) stack.pop()).listFiles();
            int length = listFiles.length;
            long j2 = j;
            for (int i = 0; i < length; i += f14169g) {
                File file2 = listFiles[i];
                if (!file2.isDirectory()) {
                    j2 += file2.length();
                }
            }
            j = j2;
        }
        return j;
    }

    private PendingIntent m17127a(UMessage uMessage, int i) {
        String jSONObject = uMessage.getRaw().toString();
        int hashCode = uMessage.msg_id.hashCode();
        Intent intent = new Intent(this.f14177b, UmengDownloadResourceService.class);
        intent.putExtra(C4156a.f13961w, jSONObject);
        intent.putExtra(AgooConstants.MESSAGE_ID, uMessage.message_id);
        intent.putExtra(AgooConstants.MESSAGE_TASK_ID, uMessage.task_id);
        intent.putExtra(f14168f, f14170h);
        intent.putExtra(f14167e, i);
        PendingIntent service = PendingIntent.getService(this.f14177b, hashCode, intent, 134217728);
        UmLog.m17140i(TAG, "PendingIntent: msgId:" + uMessage.msg_id + ",requestCode:" + hashCode + ",retryTime:" + i);
        return service;
    }

    private static void m17130b(File file, long j) {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i += f14169g) {
                File file2 = listFiles[i];
                if (!file2.isDirectory() && System.currentTimeMillis() - file2.lastModified() > j) {
                    file2.delete();
                }
            }
        }
    }

    public static void checkDir(File file, long j, long j2) {
        if (file.exists() && m17126a(file.getCanonicalFile()) > j) {
            if (f14175m == null) {
                f14175m = new Thread(new C42041(file, j2));
            }
            synchronized (f14175m) {
                f14175m.start();
            }
        }
    }

    public static String getMessageResourceFolder(Context context, UMessage uMessage) {
        String str = context.getCacheDir() + "/umeng_push/";
        return (uMessage == null || uMessage.msg_id == null) ? str : str + uMessage.msg_id + "/";
    }

    public void checkCache() {
        try {
            checkDir(new File(getMessageResourceFolder(this.f14177b, null)), f14171i, f14172j);
        } catch (Throwable th) {
        }
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAlarm(UMessage uMessage, int i) {
        UmLog.m17140i(TAG, "deleteAlarm");
        ((AlarmManager) getSystemService(NotificationCompatApi21.CATEGORY_ALARM)).cancel(m17127a(uMessage, i));
    }

    @SuppressLint({"NewApi"})
    public void downloadResource(UMessage uMessage, int i) {
        DownloadResourceTask downloadResourceTask = new DownloadResourceTask(this, uMessage, i);
        if (VERSION.SDK_INT >= 11) {
            downloadResourceTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            downloadResourceTask.execute(new Void[0]);
        }
    }

    public void notification(UMessage uMessage) {
        UHandler messageHandler = PushAgent.getInstance(this).getMessageHandler();
        if (messageHandler == null) {
            return;
        }
        if (TextUtils.equals(UMessage.DISPLAY_TYPE_AUTOUPDATE, uMessage.display_type)) {
            UmengMessageHandler umengMessageHandler = (UmengMessageHandler) PushAgent.getInstance(this.f14177b).getMessageHandler();
            if (umengMessageHandler != null) {
                umengMessageHandler.dealWithNotificationMessage(this.f14177b, uMessage);
                return;
            }
            return;
        }
        messageHandler.handleMessage(this, uMessage);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.f14176a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
        this.f14177b = this;
        this.f14178c = new ArrayList();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public int onStartCommand(android.content.Intent r6, int r7, int r8) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0007;
    L_0x0002:
        r0 = super.onStartCommand(r6, r7, r8);
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = "OPERATIOIN";
        r1 = 2;
        r0 = r6.getIntExtra(r0, r1);
        r1 = "RETRY_TIME";
        r2 = 3;
        r1 = r6.getIntExtra(r1, r2);
        r2 = "body";
        r2 = r6.getStringExtra(r2);
        r3 = new com.umeng.message.entity.UMessage;	 Catch:{ Exception -> 0x0066 }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0066 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0066 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0066 }
        r2 = "id";
        r2 = r6.getStringExtra(r2);	 Catch:{ Exception -> 0x0066 }
        r3.message_id = r2;	 Catch:{ Exception -> 0x0066 }
        r2 = "task_id";
        r2 = r6.getStringExtra(r2);	 Catch:{ Exception -> 0x0066 }
        r3.task_id = r2;	 Catch:{ Exception -> 0x0066 }
        r2 = r5.f14178c;	 Catch:{ Exception -> 0x0066 }
        r4 = r3.msg_id;	 Catch:{ Exception -> 0x0066 }
        r2 = r2.contains(r4);	 Catch:{ Exception -> 0x0066 }
        if (r2 == 0) goto L_0x0044;
    L_0x003f:
        r0 = super.onStartCommand(r6, r7, r8);	 Catch:{ Exception -> 0x0066 }
        goto L_0x0006;
    L_0x0044:
        r2 = r5.f14178c;	 Catch:{ Exception -> 0x0066 }
        r4 = r3.msg_id;	 Catch:{ Exception -> 0x0066 }
        r2.add(r4);	 Catch:{ Exception -> 0x0066 }
        switch(r0) {
            case 1: goto L_0x006b;
            case 2: goto L_0x0053;
            default: goto L_0x004e;
        };
    L_0x004e:
        r0 = super.onStartCommand(r6, r7, r8);
        goto L_0x0006;
    L_0x0053:
        r0 = TAG;	 Catch:{ Exception -> 0x0066 }
        r2 = "Start Download Resource";
        com.umeng.message.common.UmLog.m17140i(r0, r2);	 Catch:{ Exception -> 0x0066 }
        r0 = r1 + -1;
        r5.setAlarm(r3, r0);	 Catch:{ Exception -> 0x0066 }
        r5.checkCache();	 Catch:{ Exception -> 0x0066 }
        r5.downloadResource(r3, r0);	 Catch:{ Exception -> 0x0066 }
        goto L_0x004e;
    L_0x0066:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x004e;
    L_0x006b:
        r5.deleteAlarm(r3, r1);	 Catch:{ Exception -> 0x0066 }
        r0 = TAG;	 Catch:{ Exception -> 0x0066 }
        r1 = "Show Notification After Downloaded Resource";
        com.umeng.message.common.UmLog.m17140i(r0, r1);	 Catch:{ Exception -> 0x0066 }
        r5.notification(r3);	 Catch:{ Exception -> 0x0066 }
        r0 = r5.f14178c;	 Catch:{ Exception -> 0x0066 }
        r1 = r3.msg_id;	 Catch:{ Exception -> 0x0066 }
        r0.remove(r1);	 Catch:{ Exception -> 0x0066 }
        r0 = r5.f14178c;	 Catch:{ Exception -> 0x0066 }
        r0 = r0.size();	 Catch:{ Exception -> 0x0066 }
        if (r0 != 0) goto L_0x004e;
    L_0x0087:
        r5.stopSelf();	 Catch:{ Exception -> 0x0066 }
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengDownloadResourceService.onStartCommand(android.content.Intent, int, int):int");
    }

    public void setAlarm(UMessage uMessage, int i) {
        UmLog.m17140i(TAG, "setAlarm");
        ((AlarmManager) getSystemService(NotificationCompatApi21.CATEGORY_ALARM)).set(f14169g, System.currentTimeMillis() + 300000, m17127a(uMessage, i));
    }
}
