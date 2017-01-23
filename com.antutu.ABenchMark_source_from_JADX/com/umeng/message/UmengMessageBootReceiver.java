package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C4239k;
import com.umeng.message.proguard.C4239k.C4237c;
import com.umeng.message.proguard.C4239k.C4238d;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Iterator;
import org.android.agoo.message.MessageService;

public class UmengMessageBootReceiver extends BroadcastReceiver {
    private static final String f14184b;
    private static final String f14185c = "android.intent.action.BOOT_COMPLETED";
    Runnable f14186a;
    private Context f14187d;

    /* renamed from: com.umeng.message.UmengMessageBootReceiver.1 */
    class C42061 implements Runnable {
        final /* synthetic */ UmengMessageBootReceiver f14183a;

        C42061(UmengMessageBootReceiver umengMessageBootReceiver) {
            this.f14183a = umengMessageBootReceiver;
        }

        public void run() {
            try {
                Iterator it = C4239k.m17301a(this.f14183a.f14187d).m17315b().iterator();
                while (it.hasNext()) {
                    C4237c c4237c = (C4237c) it.next();
                    if (C4239k.m17301a(this.f14183a.f14187d).m17305a(c4237c.f14415a) == null && c4237c.f14416b.equals(UMessage.DISPLAY_TYPE_NOTIFICATION)) {
                        C4239k.m17301a(this.f14183a.f14187d).m17311a(c4237c.f14415a, 2, System.currentTimeMillis());
                    }
                }
                Iterator it2 = C4239k.m17301a(this.f14183a.f14187d).m17322d().iterator();
                while (it2.hasNext()) {
                    C4238d c4238d = (C4238d) it2.next();
                    if (C4239k.m17301a(this.f14183a.f14187d).m17319c(c4238d.f14418a) == null && c4238d.f14420c.equals(UMessage.DISPLAY_TYPE_NOTIFICATION)) {
                        C4239k.m17301a(this.f14183a.f14187d).m17314a(c4238d.f14418a, c4238d.f14419b, MessageService.MSG_ACCS_NOTIFY_DISMISS, System.currentTimeMillis());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                UmLog.m17136d(UmengMessageBootReceiver.f14184b, e.toString());
            }
        }
    }

    static {
        f14184b = UmengMessageBootReceiver.class.getName();
    }

    public UmengMessageBootReceiver() {
        this.f14186a = new C42061(this);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            UmLog.m17136d(f14184b, "Boot this system , UmengMessageBootReceiver onReceive()");
            String action = intent.getAction();
            if (action != null && !action.equals(BuildConfig.FLAVOR)) {
                UmLog.m17136d(f14184b, "action=" + intent.getAction());
                if (TextUtils.equals(intent.getAction(), f14185c)) {
                    this.f14187d = context;
                    new Thread(this.f14186a).start();
                }
            }
        } catch (Exception e) {
            UmLog.m17136d(f14184b, e.toString());
        }
    }
}
