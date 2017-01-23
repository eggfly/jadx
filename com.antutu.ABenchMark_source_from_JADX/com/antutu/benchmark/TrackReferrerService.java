package com.antutu.benchmark;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import com.antutu.redacc.C1692R;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Report;
import com.google.analytics.tracking.android.ModelFields;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.Map;

public class TrackReferrerService extends Service {

    /* renamed from: com.antutu.benchmark.TrackReferrerService.1 */
    class C10891 implements Runnable {
        final /* synthetic */ TrackReferrerService f3666a;

        C10891(TrackReferrerService trackReferrerService) {
            this.f3666a = trackReferrerService;
        }

        public void run() {
            this.f3666a.stopSelf();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String stringExtra = intent.getStringExtra(ModelFields.REFERRER);
            if (!(stringExtra == null || stringExtra.isEmpty())) {
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
                edit.putString(MobclickAgentConstants.gp_referrer, stringExtra);
                edit.commit();
                Report.reportInstallOEM(this, C1692R.xml.default_settings);
                Map hashMap = new HashMap();
                hashMap.put(stringExtra, stringExtra);
                MobclickAgent.onEvent((Context) this, MobclickAgentConstants.gp_referrer, hashMap);
                new Handler().postDelayed(new C10891(this), 15000);
            }
        } catch (Exception e) {
            stopSelf();
        }
        return 2;
    }
}
