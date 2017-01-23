package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fd;
import com.google.android.gms.p146b.fi;

public class InAppPurchaseActivity extends Activity {
    private fd f10105a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f10105a != null) {
                this.f10105a.m11226a(i, i2, intent);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10105a = fi.m12702a((Activity) this);
        if (this.f10105a == null) {
            C2972b.m11583d("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f10105a.m11225a();
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f10105a != null) {
                this.f10105a.m11227b();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
