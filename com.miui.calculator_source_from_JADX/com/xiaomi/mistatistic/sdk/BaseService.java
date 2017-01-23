package com.xiaomi.mistatistic.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.xiaomi.mistatistic.sdk.C0520a.C0521a;
import com.xiaomi.mistatistic.sdk.controller.C0559f;
import com.xiaomi.mistatistic.sdk.data.StatEventPojo;
import java.util.List;

public class BaseService extends Service {
    private C0559f f4635a;

    /* renamed from: com.xiaomi.mistatistic.sdk.BaseService.1 */
    class C05221 extends C0521a {
        final /* synthetic */ BaseService f4634a;

        C05221(BaseService baseService) {
            this.f4634a = baseService;
        }

        public StatEventPojo m6237a(String str, String str2) {
            return this.f4634a.f4635a.m6383b(str, str2);
        }

        public List<StatEventPojo> m6238a(long j) {
            return this.f4634a.f4635a.m6384b(j);
        }

        public int m6236a() {
            return this.f4634a.f4635a.m6393e();
        }
    }

    public void onCreate() {
        super.onCreate();
        C0559f.m6375a();
        this.f4635a = new C0559f();
    }

    public IBinder onBind(Intent intent) {
        return new C05221(this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (!(intent == null || intent.getExtras() == null)) {
            Bundle extras = intent.getExtras();
            if (extras.containsKey("type")) {
                switch (extras.getInt("type")) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        this.f4635a.m6387b((StatEventPojo) extras.getParcelable("StatEventPojo"));
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        this.f4635a.m6388b(extras.getString("key"), extras.getString("category"), extras.getString("newValue"));
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        this.f4635a.m6389c();
                        break;
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                        this.f4635a.m6392d(extras.getLong("timeStamp"));
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        this.f4635a.m6386b(extras.getLong("startTime"), extras.getLong("endTime"));
                        break;
                }
            }
        }
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
