package com.antutu.benchmark.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.MLog;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.downloader.IDownloadService;
import com.antutu.utils.downloader.IDownloadServiceCallback;
import com.antutu.utils.downloader.IDownloadServiceCallback.Stub;
import java.util.List;

/* renamed from: com.antutu.benchmark.activity.a */
public abstract class C1214a extends C1197a {
    protected final int f4069a;
    protected final int f4070b;
    protected final int f4071c;
    protected IDownloadService f4072d;
    private boolean f4073e;
    private IDownloadServiceCallback f4074f;
    private ServiceConnection f4075g;

    /* renamed from: com.antutu.benchmark.activity.a.1 */
    class C13211 extends Stub {
        final /* synthetic */ C1214a f4515a;

        C13211(C1214a c1214a) {
            this.f4515a = c1214a;
        }

        public void onDownloadFinished() {
            MLog.m6874v("BindDownloadServiceActivity", "hzd, onDownloadFinished..");
            this.f4515a.m4978c();
        }

        public void onDownloadInterruptted() {
            MLog.m6874v("BindDownloadServiceActivity", "hzd, onDownloadInterruptted..");
            this.f4515a.m4977b();
            this.f4515a.m4974h();
        }

        public void onProgress(int i) {
            MLog.m6874v("BindDownloadServiceActivity", "hzd, onProgress...percent=" + i);
            this.f4515a.m4976a(i);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.a.2 */
    class C13222 implements ServiceConnection {
        final /* synthetic */ C1214a f4516a;

        C13222(C1214a c1214a) {
            this.f4516a = c1214a;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MLog.m6874v("BindDownloadServiceActivity", "hzd, onServiceConnected..");
            this.f4516a.f4072d = IDownloadService.Stub.asInterface(iBinder);
            this.f4516a.m4973a(this.f4516a.m4975a());
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MLog.m6874v("BindDownloadServiceActivity", "hzd, onServiceDisconnected..");
        }
    }

    public C1214a() {
        this.f4069a = 10;
        this.f4070b = 12;
        this.f4071c = 13;
        this.f4074f = new C13211(this);
        this.f4075g = new C13222(this);
    }

    public static Intent m4970a(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    private void m4973a(DownloadInfos downloadInfos) {
        if (downloadInfos != null) {
            try {
                this.f4072d.startDownload(downloadInfos, this.f4074f);
            } catch (RemoteException e) {
            }
        }
    }

    private void m4974h() {
        if (this.f4073e) {
            unbindService(this.f4075g);
            this.f4073e = false;
        }
    }

    protected abstract DownloadInfos m4975a();

    protected abstract void m4976a(int i);

    protected abstract void m4977b();

    protected abstract void m4978c();

    protected boolean m4979d() {
        return this.f4072d != null && this.f4073e;
    }

    protected void m4980e() {
        DownloadsService.startDownloadService(this);
        bindService(new Intent(C1214a.m4970a((Context) this, new Intent(DownloadsService.DOWNLOAD_ACTION_START))), this.f4075g, 1);
        this.f4073e = true;
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            m4974h();
        } catch (Exception e) {
        }
    }
}
