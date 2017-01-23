package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoConstants;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.taobao.accs.client.a */
public class C4085a {
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    public static int f13620a;
    public static String f13621b;
    public static String f13622c;
    public static String f13623d;
    public static String f13624e;
    public static IProcessName f13625f;
    public static AtomicInteger f13626g;
    private static volatile C4085a f13627h;
    private static Context f13628i;
    private String f13629j;
    private IAppReceiver f13630k;
    private ActivityManager f13631l;
    private ConnectivityManager f13632m;

    static {
        f13620a = 0;
        f13621b = null;
        f13626g = new AtomicInteger(-1);
    }

    private C4085a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        } else if (f13628i == null) {
            f13628i = context.getApplicationContext();
        }
    }

    public static C4085a m16662a(Context context) {
        if (f13627h == null) {
            synchronized (C4085a.class) {
                if (f13627h == null) {
                    f13627h = new C4085a(context);
                }
            }
        }
        return f13627h;
    }

    public static String m16663b(String str) {
        String str2 = TextUtils.isEmpty(f13621b) ? str + TaobaoConstants.DEFAULT_INTENT_SERVICE_CLASS_NAME : f13621b;
        Object[] objArr = new Object[SECURITY_OFF];
        objArr[0] = "name";
        objArr[SECURITY_OPEN] = str2;
        ALog.m16901d("AdapterGlobalClientInfo", "getAgooCustomServiceName", objArr);
        return str2;
    }

    public static boolean m16664d() {
        return f13626g.intValue() == 0;
    }

    public String m16665a() {
        return this.f13629j;
    }

    public void m16666a(IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            this.f13630k = iAppReceiver;
        }
    }

    public void m16667a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13629j = str;
        }
    }

    public ActivityManager m16668b() {
        if (this.f13631l == null) {
            this.f13631l = (ActivityManager) f13628i.getSystemService("activity");
        }
        return this.f13631l;
    }

    public ConnectivityManager m16669c() {
        if (this.f13632m == null) {
            this.f13632m = (ConnectivityManager) f13628i.getSystemService("connectivity");
        }
        return this.f13632m;
    }
}
