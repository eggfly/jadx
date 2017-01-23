package com.antutu.utils.downloader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import com.antutu.ABenchMark.C1082R;
import com.umeng.analytics.MobclickAgent;

public class Stop3DPluginActivity extends Activity {
    private BroadcastReceiver mReceiver;
    private ProgressDialog progressDialog;
    private int uid;
    private String url;

    /* renamed from: com.antutu.utils.downloader.Stop3DPluginActivity.1 */
    class C18151 extends BroadcastReceiver {
        C18151() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r11, android.content.Intent r12) {
            /*
            r10 = this;
            r4 = 2;
            r3 = 1;
            r1 = 0;
            r8 = 4652218415073722368; // 0x4090000000000000 float:0.0 double:1024.0;
            r0 = r12.getAction();	 Catch:{ Exception -> 0x0065 }
            r2 = "com.antutu.ABenchMark.download.ACTION_DOWNLOAD_MESSAGE";
            r0 = r2.equals(r0);	 Catch:{ Exception -> 0x0065 }
            if (r0 == 0) goto L_0x0037;
        L_0x0011:
            r0 = "action";
            r5 = r12.getStringExtra(r0);	 Catch:{ Exception -> 0x0065 }
            r0 = "info";
            r0 = r12.getParcelableExtra(r0);	 Catch:{ Exception -> 0x0065 }
            r0 = (com.antutu.utils.downloader.DownloadInfos) r0;	 Catch:{ Exception -> 0x0065 }
            r2 = com.antutu.benchmark.p047k.C1516b.f5191a;	 Catch:{ Exception -> 0x0065 }
            r6 = r0.getUrl();	 Catch:{ Exception -> 0x0065 }
            r2 = r2.equals(r6);	 Catch:{ Exception -> 0x0065 }
            if (r2 == 0) goto L_0x0037;
        L_0x002b:
            r2 = -1;
            r6 = r5.hashCode();	 Catch:{ Exception -> 0x0065 }
            switch(r6) {
                case -1974223744: goto L_0x0041;
                case -1232072738: goto L_0x004b;
                case 596659444: goto L_0x0055;
                case 1115155188: goto L_0x0038;
                default: goto L_0x0033;
            };	 Catch:{ Exception -> 0x0065 }
        L_0x0033:
            r1 = r2;
        L_0x0034:
            switch(r1) {
                case 0: goto L_0x0037;
                case 1: goto L_0x005f;
                case 2: goto L_0x0037;
                case 3: goto L_0x0067;
                default: goto L_0x0037;
            };	 Catch:{ Exception -> 0x0065 }
        L_0x0037:
            return;
        L_0x0038:
            r3 = "ACTION_DOWNLOAD_START";
            r3 = r5.equals(r3);	 Catch:{ Exception -> 0x0065 }
            if (r3 == 0) goto L_0x0033;
        L_0x0040:
            goto L_0x0034;
        L_0x0041:
            r1 = "ACTION_DOWNLOAD_FINISHED";
            r1 = r5.equals(r1);	 Catch:{ Exception -> 0x0065 }
            if (r1 == 0) goto L_0x0033;
        L_0x0049:
            r1 = r3;
            goto L_0x0034;
        L_0x004b:
            r1 = "ACTION_DOWNLOAD_INTERRUPTTED";
            r1 = r5.equals(r1);	 Catch:{ Exception -> 0x0065 }
            if (r1 == 0) goto L_0x0033;
        L_0x0053:
            r1 = r4;
            goto L_0x0034;
        L_0x0055:
            r1 = "ACTION_DOWNLOAD_DOWNLOADING_SIZE";
            r1 = r5.equals(r1);	 Catch:{ Exception -> 0x0065 }
            if (r1 == 0) goto L_0x0033;
        L_0x005d:
            r1 = 3;
            goto L_0x0034;
        L_0x005f:
            r0 = com.antutu.utils.downloader.Stop3DPluginActivity.this;	 Catch:{ Exception -> 0x0065 }
            r0.finish();	 Catch:{ Exception -> 0x0065 }
            goto L_0x0037;
        L_0x0065:
            r0 = move-exception;
            goto L_0x0037;
        L_0x0067:
            r1 = com.antutu.utils.downloader.Stop3DPluginActivity.this;	 Catch:{ Exception -> 0x0065 }
            r1 = r1.progressDialog;	 Catch:{ Exception -> 0x0065 }
            if (r1 == 0) goto L_0x0037;
        L_0x006f:
            r1 = com.antutu.utils.downloader.Stop3DPluginActivity.this;	 Catch:{ Exception -> 0x0065 }
            r1 = r1.progressDialog;	 Catch:{ Exception -> 0x0065 }
            r2 = r0.lastPercent;	 Catch:{ Exception -> 0x0065 }
            r1.setProgress(r2);	 Catch:{ Exception -> 0x0065 }
            r1 = com.antutu.utils.downloader.Stop3DPluginActivity.this;	 Catch:{ Exception -> 0x0065 }
            r1 = r1.progressDialog;	 Catch:{ Exception -> 0x0065 }
            r2 = "%.1fM/%.1fM";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0065 }
            r4 = 0;
            r5 = r0.lastSize;	 Catch:{ Exception -> 0x0065 }
            r6 = (double) r5;	 Catch:{ Exception -> 0x0065 }
            r6 = r6 / r8;
            r6 = r6 / r8;
            r5 = java.lang.Double.valueOf(r6);	 Catch:{ Exception -> 0x0065 }
            r3[r4] = r5;	 Catch:{ Exception -> 0x0065 }
            r4 = 1;
            r0 = r0.fileSize;	 Catch:{ Exception -> 0x0065 }
            r6 = (double) r0;	 Catch:{ Exception -> 0x0065 }
            r6 = r6 / r8;
            r6 = r6 / r8;
            r0 = java.lang.Double.valueOf(r6);	 Catch:{ Exception -> 0x0065 }
            r3[r4] = r0;	 Catch:{ Exception -> 0x0065 }
            r0 = java.lang.String.format(r2, r3);	 Catch:{ Exception -> 0x0065 }
            r1.setProgressNumberFormat(r0);	 Catch:{ Exception -> 0x0065 }
            goto L_0x0037;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.downloader.Stop3DPluginActivity.1.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* renamed from: com.antutu.utils.downloader.Stop3DPluginActivity.2 */
    class C18162 implements OnClickListener {
        C18162() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DownloadsService.stopDownload(Stop3DPluginActivity.this, Stop3DPluginActivity.this.uid, Stop3DPluginActivity.this.url);
            dialogInterface.dismiss();
            Stop3DPluginActivity.this.finish();
        }
    }

    /* renamed from: com.antutu.utils.downloader.Stop3DPluginActivity.3 */
    class C18173 implements OnClickListener {
        C18173() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            Stop3DPluginActivity.this.finish();
        }
    }

    public Stop3DPluginActivity() {
        this.uid = 0;
        this.url = null;
        this.mReceiver = new C18151();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.download_stop_3dplugin);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadsService.ACTION_DOWNLOAD_MESSAGE);
        registerReceiver(this.mReceiver, intentFilter);
        DownloadInfos downloadInfos = (DownloadInfos) getIntent().getParcelableExtra("info");
        if (downloadInfos == null) {
            finish();
        }
        this.uid = downloadInfos.getUid();
        this.url = downloadInfos.getUrl();
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setTitle(getString(C1082R.string.antutu_prompt));
        this.progressDialog.setMessage(getString(C1082R.string.need_download3d_content));
        this.progressDialog.setButton(-2, getString(C1082R.string.cancel_download), new C18162());
        this.progressDialog.setButton(-1, getString(C1082R.string.continue_download), new C18173());
        this.progressDialog.setProgressStyle(1);
        this.progressDialog.setIndeterminate(false);
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setProgress(downloadInfos.lastPercent);
        this.progressDialog.setProgressNumberFormat(String.format("%.1fM/%.1fM", new Object[]{Double.valueOf((((double) downloadInfos.lastSize) / 1024.0d) / 1024.0d), Double.valueOf((((double) downloadInfos.fileSize) / 1024.0d) / 1024.0d)}));
        this.progressDialog.show();
    }

    protected void onDestroy() {
        unregisterReceiver(this.mReceiver);
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }
}
