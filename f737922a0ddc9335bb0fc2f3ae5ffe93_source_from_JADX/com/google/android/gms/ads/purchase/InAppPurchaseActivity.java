package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.dv;

public class InAppPurchaseActivity extends Activity {
    private dv j6;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.j6 != null) {
                this.j6.j6(i, i2, intent);
            }
        } catch (Throwable e) {
            b.FH("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j6 = w.DW().j6((Activity) this);
        if (this.j6 == null) {
            b.Hw("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.j6.j6();
        } catch (Throwable e) {
            b.FH("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.j6 != null) {
                this.j6.DW();
            }
        } catch (Throwable e) {
            b.FH("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
