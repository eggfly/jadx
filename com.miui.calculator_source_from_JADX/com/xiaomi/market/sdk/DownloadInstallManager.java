package com.xiaomi.market.sdk;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.xiaomi.market.sdk.Constants.Update;
import java.io.File;
import java.lang.reflect.Method;

public class DownloadInstallManager {
    public static DownloadInstallManager f4584a;
    private static DownloadManager f4585f;
    private UpdateInfo f4586b;
    private LocalAppInfo f4587c;
    private long f4588d;
    private File f4589e;
    private HandlerThread f4590g;
    private WorkerHandler f4591h;
    private Context f4592i;

    private static class DownloadManagerInfo {
        public long f4574a;
        public int f4575b;
        public int f4576c;
        public int f4577d;
        public int f4578e;
        public String f4579f;

        private DownloadManagerInfo() {
        }

        public static DownloadManagerInfo m6169a(long j) {
            DownloadManagerInfo downloadManagerInfo = null;
            Query query = new Query();
            query.setFilterById(new long[]{j});
            try {
                Cursor query2 = DownloadInstallManager.f4585f.query(query);
                if (query2 != null) {
                    try {
                        if (query2.moveToFirst()) {
                            downloadManagerInfo = m6170a(query2);
                            return downloadManagerInfo;
                        }
                    } finally {
                        if (query2 != null) {
                            query2.close();
                        }
                    }
                }
                if (query2 != null) {
                    query2.close();
                }
            } catch (Exception e) {
                Log.e("MarketUpdateDownload", "Query download from DownloadManager failed - " + e.toString());
            }
            return downloadManagerInfo;
        }

        @SuppressLint({"InlinedApi"})
        private static DownloadManagerInfo m6170a(Cursor cursor) {
            String str;
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
            int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("status");
            int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("reason");
            int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("bytes_so_far");
            int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow("total_size");
            if (Client.m6137a()) {
                str = "local_filename";
            } else {
                str = "file_path";
            }
            int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(str);
            DownloadManagerInfo downloadManagerInfo = new DownloadManagerInfo();
            downloadManagerInfo.f4574a = cursor.getLong(columnIndexOrThrow);
            downloadManagerInfo.f4575b = cursor.getInt(columnIndexOrThrow2);
            downloadManagerInfo.f4576c = cursor.getInt(columnIndexOrThrow3);
            downloadManagerInfo.f4577d = cursor.getInt(columnIndexOrThrow4);
            downloadManagerInfo.f4578e = cursor.getInt(columnIndexOrThrow5);
            downloadManagerInfo.f4579f = cursor.getString(columnIndexOrThrow6);
            return downloadManagerInfo;
        }
    }

    public class WorkerHandler extends Handler {
        final /* synthetic */ DownloadInstallManager f4583a;

        /* renamed from: com.xiaomi.market.sdk.DownloadInstallManager.WorkerHandler.1 */
        class C05161 implements Runnable {
            final /* synthetic */ WorkerHandler f4580a;

            C05161(WorkerHandler workerHandler) {
                this.f4580a = workerHandler;
            }

            public void run() {
                Context a = XiaomiUpdateAgent.m6213a();
                if (a != null) {
                    if (!Utils.m6202a(true)) {
                        Toast.makeText(a, Utils.m6198a(a.getPackageName(), "string", "xiaomi_external_storage_unavailable"), 0).show();
                    } else if (DownloadInstallManager.f4585f != null) {
                        String a2;
                        if (TextUtils.isEmpty(this.f4580a.f4583a.f4586b.f4620j)) {
                            a2 = Connection.m6159a(this.f4580a.f4583a.f4586b.f4611a, this.f4580a.f4583a.f4586b.f4617g);
                        } else {
                            a2 = Connection.m6159a(this.f4580a.f4583a.f4586b.f4611a, this.f4580a.f4583a.f4586b.f4620j);
                        }
                        Uri parse = Uri.parse(a2);
                        File externalFilesDir = a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                        Uri uri = null;
                        if (externalFilesDir != null) {
                            File file = new File(externalFilesDir.getAbsolutePath() + "/updates");
                            if (!(file == null || file.exists())) {
                                file.mkdirs();
                            }
                            this.f4580a.f4583a.f4589e = new File(file.getAbsolutePath() + "/" + this.f4580a.f4583a.f4587c.f4593a + this.f4580a.f4583a.f4586b.f4615e);
                            if (this.f4580a.f4583a.f4589e.exists()) {
                                this.f4580a.f4583a.f4589e.delete();
                            }
                            uri = Uri.parse("file://" + this.f4580a.f4583a.f4589e.getAbsolutePath());
                        }
                        Request request = new Request(parse);
                        request.setMimeType("application/apk-ota");
                        request.setTitle(this.f4580a.f4583a.f4587c.f4594b);
                        if (uri != null) {
                            request.setDestinationUri(uri);
                        }
                        try {
                            this.f4580a.f4583a.f4588d = DownloadInstallManager.f4585f.enqueue(request);
                        } catch (Throwable th) {
                            Log.e("MarketUpdateDownload", th.toString());
                            Toast.makeText(a, Utils.m6198a(a.getPackageName(), "string", "xiaomi_connect_download_manager_fail"), 1).show();
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", this.f4580a.f4583a.f4587c.f4593a);
                        contentValues.put("download_id", Long.valueOf(this.f4580a.f4583a.f4588d));
                        contentValues.put("version_code", Integer.valueOf(this.f4580a.f4583a.f4586b.f4615e));
                        contentValues.put("apk_url", this.f4580a.f4583a.f4586b.f4617g);
                        contentValues.put("apk_hash", this.f4580a.f4583a.f4586b.f4618h);
                        contentValues.put("diff_url", this.f4580a.f4583a.f4586b.f4620j);
                        contentValues.put("diff_hash", this.f4580a.f4583a.f4586b.f4621k);
                        contentValues.put("apk_path", this.f4580a.f4583a.f4589e != null ? this.f4580a.f4583a.f4589e.getAbsolutePath() : "");
                        SDKDatabaseHelper.m6194a(a).m6196a(contentValues);
                    }
                }
            }
        }

        /* renamed from: com.xiaomi.market.sdk.DownloadInstallManager.WorkerHandler.2 */
        class C05172 implements Runnable {
            final /* synthetic */ DownloadManagerInfo f4581a;
            final /* synthetic */ WorkerHandler f4582b;

            C05172(WorkerHandler workerHandler, DownloadManagerInfo downloadManagerInfo) {
                this.f4582b = workerHandler;
                this.f4581a = downloadManagerInfo;
            }

            public void run() {
                Context a = XiaomiUpdateAgent.m6213a();
                if (a != null && !TextUtils.isEmpty(this.f4581a.f4579f)) {
                    String absolutePath;
                    this.f4582b.m6173a();
                    this.f4582b.f4583a.f4589e = new File(this.f4581a.f4579f);
                    if (TextUtils.isEmpty(this.f4582b.f4583a.f4586b.f4620j)) {
                        absolutePath = this.f4582b.f4583a.f4589e.getAbsolutePath();
                    } else {
                        absolutePath = this.f4582b.m6172a(this.f4582b.f4583a.f4589e.getAbsolutePath(), this.f4582b.f4583a.f4586b.f4621k);
                    }
                    if (TextUtils.isEmpty(this.f4582b.f4583a.f4586b.f4618h) || TextUtils.isEmpty(absolutePath) || TextUtils.equals(Coder.m6149a(new File(absolutePath)), this.f4582b.f4583a.f4586b.f4618h)) {
                        Uri a2;
                        if (Client.m6139b()) {
                            File file = new File(absolutePath);
                            a2 = FileProvider.m573a(this.f4582b.f4583a.f4592i, this.f4582b.f4583a.f4592i.getPackageName() + ".selfupdate.fileprovider", file);
                            this.f4582b.f4583a.f4592i.grantUriPermission("com.google.android.packageinstaller", a2, 1);
                        } else {
                            a2 = Uri.parse("file://" + absolutePath);
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(a2, "application/vnd.android.package-archive");
                        intent.setFlags(268435456);
                        a.startActivity(intent);
                    }
                }
            }
        }

        public WorkerHandler(DownloadInstallManager downloadInstallManager, Looper looper) {
            this.f4583a = downloadInstallManager;
            super(looper);
        }

        public void m6173a() {
            Throwable th;
            Context a = XiaomiUpdateAgent.m6213a();
            if (a != null) {
                if (this.f4583a.f4587c == null || this.f4583a.f4586b == null) {
                    this.f4583a.f4587c = XiaomiUpdateAgent.m6220b(a);
                    if (this.f4583a.f4587c != null) {
                        Cursor a2;
                        try {
                            a2 = SDKDatabaseHelper.m6194a(a).m6197a("update_download", Update.f4569a, "package_name=?", new String[]{this.f4583a.f4587c.f4593a}, null, null, null);
                            if (a2 != null) {
                                try {
                                    if (a2.moveToFirst()) {
                                        this.f4583a.f4588d = a2.getLong(a2.getColumnIndex("download_id"));
                                        UpdateInfo updateInfo = new UpdateInfo();
                                        updateInfo.f4615e = a2.getInt(a2.getColumnIndex("version_code"));
                                        updateInfo.f4617g = a2.getString(a2.getColumnIndex("apk_url"));
                                        updateInfo.f4618h = a2.getString(a2.getColumnIndex("apk_hash"));
                                        updateInfo.f4620j = a2.getString(a2.getColumnIndex("diff_url"));
                                        updateInfo.f4621k = a2.getString(a2.getColumnIndex("diff_hash"));
                                        this.f4583a.f4586b = updateInfo;
                                        if (a2 != null) {
                                            a2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a2 != null) {
                                        a2.close();
                                    }
                                    throw th;
                                }
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            a2 = null;
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                }
            }
        }

        public void m6175b() {
            post(new C05161(this));
        }

        public void m6174a(DownloadManagerInfo downloadManagerInfo) {
            post(new C05172(this, downloadManagerInfo));
        }

        private String m6172a(String str, String str2) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(Coder.m6149a(new File(str)), str2)) {
                return null;
            }
            String str3 = this.f4583a.f4589e.getAbsolutePath() + ".apk";
            if (this.f4583a.f4587c == null || TextUtils.isEmpty(this.f4583a.f4587c.f4598f)) {
                return null;
            }
            Patcher.m6192a(this.f4583a.f4587c.f4598f, str3, str);
            try {
                new File(str).delete();
            } catch (Exception e) {
            }
            return str3;
        }
    }

    private DownloadInstallManager(Context context) {
        this.f4588d = -1;
        Client.m6136a(context);
        this.f4592i = context.getApplicationContext();
        m6184b();
        this.f4590g = new HandlerThread("Worker Thread");
        this.f4590g.start();
        this.f4591h = new WorkerHandler(this, this.f4590g.getLooper());
    }

    private void m6184b() {
        f4585f = (DownloadManager) this.f4592i.getSystemService("download");
        if (Client.m6139b()) {
            try {
                Method declaredMethod = f4585f.getClass().getDeclaredMethod("setAccessFilename", new Class[]{Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(f4585f, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m6189a(LocalAppInfo localAppInfo, UpdateInfo updateInfo) {
        if (updateInfo != null && localAppInfo != null) {
            this.f4586b = updateInfo;
            this.f4587c = localAppInfo;
            this.f4591h.m6175b();
        }
    }

    public void m6188a(long j) {
        if (j >= 0 && this.f4588d == j) {
            DownloadManagerInfo a = DownloadManagerInfo.m6169a(this.f4588d);
            if (a != null && a.f4575b != 16 && !TextUtils.isEmpty(a.f4579f)) {
                this.f4591h.m6174a(a);
            }
        }
    }

    public static DownloadInstallManager m6178a(Context context) {
        if (f4584a == null) {
            f4584a = new DownloadInstallManager(context);
        }
        return f4584a;
    }

    public boolean m6190a(LocalAppInfo localAppInfo) {
        Context a = XiaomiUpdateAgent.m6213a();
        if (a == null) {
            return false;
        }
        long j;
        Cursor query;
        int i;
        Cursor a2 = SDKDatabaseHelper.m6194a(a).m6197a("update_download", Update.f4569a, "package_name=?", new String[]{localAppInfo.f4593a}, null, null, null);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    j = a2.getLong(a2.getColumnIndex("download_id"));
                    if (j != -1) {
                        if (a2 != null) {
                            a2.close();
                        }
                        return false;
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    Query query2 = new Query();
                    query2.setFilterById(new long[]{j});
                    query = f4585f.query(query2);
                    i = -1;
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                i = query.getInt(query.getColumnIndexOrThrow("status"));
                            }
                        } catch (Throwable th) {
                            if (query != null) {
                                query.close();
                            }
                        }
                    }
                    if (i != 4 || i == 1 || i == 2) {
                        if (query != null) {
                            query.close();
                        }
                        return true;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        j = -1;
        if (j != -1) {
            if (a2 != null) {
                a2.close();
            }
            Query query22 = new Query();
            query22.setFilterById(new long[]{j});
            query = f4585f.query(query22);
            i = -1;
            if (query != null) {
                if (query.moveToFirst()) {
                    i = query.getInt(query.getColumnIndexOrThrow("status"));
                }
            }
            if (i != 4) {
            }
            if (query != null) {
                query.close();
            }
            return true;
        }
        if (a2 != null) {
            a2.close();
        }
        return false;
    }
}
