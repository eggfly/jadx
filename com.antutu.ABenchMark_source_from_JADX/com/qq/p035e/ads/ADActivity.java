package com.qq.p035e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.ACTD;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.ADActivity */
public class ADActivity extends Activity {
    private ACTD f13381a;

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f13381a != null) {
            this.f13381a.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13381a != null) {
            this.f13381a.onConfigurationChanged(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        String string = intent.getExtras().getString(ACTD.DELEGATE_NAME_KEY);
        String string2 = intent.getExtras().getString(ACTD.APPID_KEY);
        if (!(StringUtil.isEmpty(string) || StringUtil.isEmpty(string2))) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                    this.f13381a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                    if (this.f13381a == null) {
                        GDTLogger.m16600e("Init ADActivity Delegate return null,delegateName" + string);
                    }
                } else {
                    GDTLogger.m16600e("Init GDTADManager fail in AdActivity");
                }
            } catch (Throwable th) {
                GDTLogger.m16601e("Init ADActivity Delegate Faile,DelegateName:" + string, th);
            }
        }
        if (this.f13381a != null) {
            this.f13381a.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        if (this.f13381a != null) {
            this.f13381a.onAfterCreate(bundle);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f13381a != null) {
            this.f13381a.onDestroy();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f13381a != null) {
            this.f13381a.onResume();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.f13381a != null) {
            this.f13381a.onStop();
        }
    }
}
