package com.antutu.benchmark.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.antutu.ABenchMark.C1082R;
import com.antutu.redacc.C1692R;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

public class QuietUpdateFinishedActivity extends Activity {

    /* renamed from: com.antutu.benchmark.view.QuietUpdateFinishedActivity.1 */
    class C16371 implements OnClickListener {
        final /* synthetic */ String f5855a;
        final /* synthetic */ QuietUpdateFinishedActivity f5856b;

        C16371(QuietUpdateFinishedActivity quietUpdateFinishedActivity, String str) {
            this.f5856b = quietUpdateFinishedActivity;
            this.f5855a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5856b.m6473a(this.f5855a);
            dialogInterface.dismiss();
            this.f5856b.finish();
        }
    }

    /* renamed from: com.antutu.benchmark.view.QuietUpdateFinishedActivity.2 */
    class C16382 implements OnClickListener {
        final /* synthetic */ QuietUpdateFinishedActivity f5857a;

        C16382(QuietUpdateFinishedActivity quietUpdateFinishedActivity) {
            this.f5857a = quietUpdateFinishedActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f5857a.finish();
        }
    }

    private void m6473a(String str) {
        if (str != null && !BuildConfig.FLAVOR.equals(str)) {
            File file = new File(str);
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.download_stop);
        String stringExtra = getIntent().getStringExtra("SAVE_DIR");
        Builder builder = new Builder(this);
        builder.setTitle(getString(C1692R.string.download_stop)).setMessage(getString(C1692R.string.download_stop_info)).setPositiveButton(getString(C1692R.string.cancel), new C16382(this)).setNegativeButton(getString(C1692R.string.confirm), new C16371(this, stringExtra));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }
}
