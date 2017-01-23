package com.antutu.utils.downloader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.antutu.ABenchMark.C1082R;
import com.antutu.redacc.C1692R;
import com.umeng.analytics.MobclickAgent;

public class StopActivity extends Activity {

    /* renamed from: com.antutu.utils.downloader.StopActivity.1 */
    class C18181 implements OnClickListener {
        C18181() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            StopActivity.this.finish();
        }
    }

    /* renamed from: com.antutu.utils.downloader.StopActivity.2 */
    class C18192 implements OnClickListener {
        final /* synthetic */ int val$uid;
        final /* synthetic */ String val$url;

        C18192(int i, String str) {
            this.val$uid = i;
            this.val$url = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            DownloadsService.stopDownload(StopActivity.this, this.val$uid, this.val$url);
            dialogInterface.dismiss();
            StopActivity.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DownloadInfos downloadInfos = (DownloadInfos) getIntent().getParcelableExtra("info");
        int uid = downloadInfos.getUid();
        String url = downloadInfos.getUrl();
        setContentView(C1082R.layout.download_stop);
        Builder builder = new Builder(this);
        builder.setTitle(getString(C1692R.string.download_stop)).setMessage(getString(C1692R.string.download_stop_info)).setPositiveButton(getString(C1692R.string.stop), new C18192(uid, url)).setNegativeButton(getString(C1692R.string.continue2), new C18181());
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
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
