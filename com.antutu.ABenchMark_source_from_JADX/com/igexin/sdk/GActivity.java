package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.p158b.p159a.p167c.C3688a;

public class GActivity extends Activity {
    public static final String TAG;

    static {
        TAG = GActivity.class.getName();
    }

    protected void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        try {
            Intent intent2 = getIntent();
            intent = new Intent(this, PushService.class);
            if (intent2 != null) {
                if (intent2.hasExtra(PushConsts.CMD_ACTION) && intent2.hasExtra("isSlave")) {
                    intent.putExtra(PushConsts.CMD_ACTION, intent2.getStringExtra(PushConsts.CMD_ACTION));
                    intent.putExtra("isSlave", intent2.getBooleanExtra("isSlave", false));
                    if (intent2.hasExtra("op_app")) {
                        intent.putExtra("op_app", intent2.getStringExtra("op_app"));
                    }
                    C3688a.m15097b("GActivity action = " + intent2.getStringExtra(PushConsts.CMD_ACTION) + ", isSlave = " + intent2.getBooleanExtra("isSlave", false));
                }
            }
        } catch (Exception e) {
            C3688a.m15097b(TAG + "|put extra exception" + e.toString());
        } catch (Throwable th) {
            C3688a.m15097b(TAG + th.toString());
        }
        startService(intent);
        C3688a.m15097b(TAG + "|start PushService from GActivity");
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
