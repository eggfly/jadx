package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.google.android.gms.ads.internal.C2968s;
import com.taobao.accs.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;

@gb
/* renamed from: com.google.android.gms.b.ar */
public class ar {
    private boolean f10313a;
    private String f10314b;
    private Map<String, String> f10315c;
    private Context f10316d;
    private String f10317e;

    public ar(Context context, String str) {
        this.f10316d = null;
        this.f10317e = null;
        this.f10316d = context;
        this.f10317e = str;
        this.f10313a = ((Boolean) aq.f10267G.m11794c()).booleanValue();
        this.f10314b = (String) aq.f10268H.m11794c();
        this.f10315c = new LinkedHashMap();
        this.f10315c.put("s", "gmob_sdk");
        this.f10315c.put(IXAdRequestInfo.f6909V, MessageService.MSG_DB_NOTIFY_DISMISS);
        this.f10315c.put(Constants.KEY_OS_VERSION, VERSION.RELEASE);
        this.f10315c.put("sdk", VERSION.SDK);
        this.f10315c.put("device", C2968s.m11525e().m13064d());
        this.f10315c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        gj a = C2968s.m11531k().m12897a(this.f10316d);
        this.f10315c.put("network_coarse", Integer.toString(a.f11139m));
        this.f10315c.put("network_fine", Integer.toString(a.f11140n));
    }

    boolean m11816a() {
        return this.f10313a;
    }

    String m11817b() {
        return this.f10314b;
    }

    Context m11818c() {
        return this.f10316d;
    }

    String m11819d() {
        return this.f10317e;
    }

    Map<String, String> m11820e() {
        return this.f10315c;
    }
}
