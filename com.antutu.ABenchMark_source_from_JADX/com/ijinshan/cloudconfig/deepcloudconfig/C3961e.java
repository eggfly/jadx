package com.ijinshan.cloudconfig.deepcloudconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.ijinshan.cloudconfig.p073a.C3950b;
import com.ijinshan.cloudconfig.p187b.C3951a;
import com.ijinshan.cloudconfig.p188c.C3952a;
import com.ijinshan.cloudconfig.p189d.C3953a;
import com.ijinshan.cloudconfig.p189d.C3954b;
import com.ijinshan.cloudconfig.p189d.C3955c;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.e */
public class C3961e implements Runnable {
    private static C3961e f13279b;
    private final String f13280a;
    private volatile boolean f13281c;
    private boolean f13282d;
    private Context f13283e;
    private String f13284f;
    private String f13285g;
    private StringBuffer f13286h;
    private volatile String f13287i;
    private boolean f13288j;
    private long f13289k;
    private boolean f13290l;
    private String f13291m;
    private String f13292n;
    private String f13293o;
    private String f13294p;

    private C3961e() {
        this.f13280a = "local_version";
        this.f13281c = false;
        this.f13282d = false;
        this.f13291m = "https://ups.ksmobile.net/";
        this.f13292n = "/getversions.php";
        this.f13293o = "/getversions.php";
        this.f13294p = "https://ws.ksmobile.net/api/GetCloudMsgAdv";
    }

    private int m16291a(String str, String str2) {
        int i = 0;
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split == null && split2 == null) {
            return 0;
        }
        if (split == null) {
            return -1;
        }
        if (split2 == null) {
            return 1;
        }
        while (i < split.length && i < split2.length) {
            try {
                long parseLong = Long.parseLong(split[i]);
                try {
                    long parseLong2 = Long.parseLong(split2[i]);
                    if (parseLong > parseLong2) {
                        return 1;
                    }
                    if (parseLong < parseLong2) {
                        return -1;
                    }
                    i++;
                } catch (NumberFormatException e) {
                    return 1;
                }
            } catch (NumberFormatException e2) {
                return -1;
            }
        }
        return split.length - split2.length;
    }

    public static C3961e m16292a() {
        if (f13279b == null) {
            synchronized (C3961e.class) {
                if (f13279b == null) {
                    f13279b = new C3961e();
                }
            }
        }
        return f13279b;
    }

    private void m16293b(String str) {
        if (m16295c(str)) {
            Object a = C3954b.m16258a(this.f13286h.toString(), AdError.SERVER_ERROR_CODE, 3);
            if (TextUtils.isEmpty(a)) {
                C3957a.m16278a().m16281a(C3953a.m16254a(m16302g()));
                m16298e();
                m16296d();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.optInt(C4233j.f14375B, -1) == 0 && C3953a.m16257a(jSONObject, m16302g())) {
                    this.f13290l = true;
                    if (C3952a.m16247b()) {
                        C3957a.m16278a().m16281a(jSONObject);
                    }
                    if (C3952a.m16249c()) {
                        m16298e();
                    }
                    m16296d();
                    if (!TextUtils.isEmpty(this.f13285g)) {
                        m16299e(this.f13285g);
                    }
                    this.f13289k = System.currentTimeMillis();
                    C3951a.m16236a().m16238a("last_update_time", Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        C3957a.m16278a().m16281a(C3953a.m16254a(m16302g()));
        m16298e();
        m16296d();
    }

    private void m16294b(boolean z, boolean z2) {
        BroadcastReceiver c3960d;
        IntentFilter intentFilter;
        if (z2) {
            c3960d = new C3960d();
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
            try {
                this.f13283e.registerReceiver(c3960d, intentFilter);
            } catch (Exception e) {
                this.f13283e.getApplicationContext().registerReceiver(c3960d, intentFilter);
            }
        }
        if (z && C3952a.m16249c()) {
            c3960d = new C3959c();
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.ijinshan.krcmd.deepcloudconfig.CloudDataChangeReceiver.datachange");
            try {
                this.f13283e.registerReceiver(c3960d, intentFilter);
            } catch (Exception e2) {
                this.f13283e.getApplicationContext().registerReceiver(c3960d, intentFilter);
            }
        }
    }

    private boolean m16295c(String str) {
        this.f13284f = m16300f();
        this.f13286h = new StringBuffer();
        this.f13286h.append(this.f13294p).append(this.f13284f);
        String a = C3955c.m16262a(this.f13284f);
        String b = C3951a.m16236a().m16240b("local_params", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(str) || m16297d(str)) {
            C3951a.m16236a().m16239a("local_params", a);
            return true;
        } else if (a.equalsIgnoreCase(b)) {
            return false;
        } else {
            C3951a.m16236a().m16239a("local_params", a);
            return true;
        }
    }

    private void m16296d() {
        String f = C3955c.m16268f(this.f13283e);
        Intent intent = new Intent();
        intent.setPackage(f);
        intent.setAction("com.cmplay.activesdk.cloud_cfg.update");
        this.f13283e.sendBroadcast(intent);
    }

    private boolean m16297d(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String b = C3951a.m16236a().m16240b("local_version", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(b)) {
            this.f13285g = str;
            return true;
        }
        int a = m16291a(str, b);
        if (a > 0) {
            this.f13285g = str;
        }
        return a > 0;
    }

    private void m16298e() {
        Intent intent = new Intent();
        intent.setPackage(C3955c.m16268f(this.f13283e));
        intent.setAction("com.ijinshan.krcmd.deepcloudconfig.CloudDataChangeReceiver.datachange");
        this.f13283e.sendBroadcast(intent);
    }

    private void m16299e(String str) {
        if (!TextUtils.isEmpty(str)) {
            C3951a.m16236a().m16239a("local_version", str);
        }
    }

    private String m16300f() {
        StringBuffer stringBuffer = new StringBuffer();
        String c = C3950b.m16234c();
        if (TextUtils.isEmpty(c)) {
            c = new StringBuilder(String.valueOf(C3955c.m16261a(this.f13283e))).append("_").append(C3955c.m16264b(this.f13283e)).toString();
        }
        stringBuffer.append("?lan=" + m16301f(c));
        stringBuffer.append("&apkversion=" + m16301f(C3950b.m16231a()));
        c = C3950b.m16235d();
        if (TextUtils.isEmpty(c)) {
            c = C3952a.m16251e();
        }
        stringBuffer.append("&channelid=" + m16301f(c));
        stringBuffer.append("&osversion=" + m16301f(VERSION.RELEASE));
        stringBuffer.append("&mcc=" + m16301f(C3955c.m16265c(this.f13283e)));
        Object obj = Build.MODEL;
        if (TextUtils.isEmpty(obj)) {
            stringBuffer.append("&device=null");
        } else {
            stringBuffer.append("&device=");
            stringBuffer.append(obj.replace(" ", "_"));
        }
        stringBuffer.append("&resolution=" + m16301f(C3955c.m16266d(this.f13283e)));
        stringBuffer.append("&mem_size=" + C3955c.m16259a(C3955c.m16267e(this.f13283e)));
        c = C3950b.m16233b();
        if (TextUtils.isEmpty(c)) {
            c = C3955c.m16268f(this.f13283e);
        }
        stringBuffer.append("&pkg=" + m16301f(c));
        stringBuffer.append("&version=1");
        stringBuffer.append("&aid=" + m16301f(C3955c.m16269g(this.f13283e)));
        return stringBuffer.toString();
    }

    private String m16301f(String str) {
        return TextUtils.isEmpty(str) ? null : str;
    }

    private String m16302g() {
        return new StringBuilder(String.valueOf(this.f13283e.getApplicationContext().getDir("deep_cloud_config", 0).getAbsolutePath())).append(File.separator).append("cloudmsgadv.json").toString();
    }

    public synchronized void m16303a(String str) {
        this.f13287i = str;
        this.f13288j = false;
        if (this.f13282d) {
            if (!this.f13281c) {
                this.f13281c = true;
                new Thread(this).start();
            }
        }
    }

    public void m16304a(boolean z) {
        this.f13290l = z;
    }

    public void m16305a(boolean z, boolean z2) {
        if (TextUtils.isEmpty(C3952a.m16241a())) {
            throw new IllegalAccessError("PullCloudConfig init error, the prodect is empty, please check...");
        }
        this.f13283e = C3952a.m16250d();
        m16294b(z, z2);
        if (z2) {
            this.f13293o = this.f13291m + C3952a.m16241a() + this.f13292n;
            this.f13282d = true;
        }
    }

    public void m16306b() {
        m16305a(true, true);
    }

    public synchronized void m16307c() {
        this.f13288j = true;
        if (this.f13282d) {
            if (!this.f13281c) {
                if (this.f13289k == 0) {
                    this.f13289k = C3951a.m16236a().m16237a("last_update_time", 0);
                }
                if (System.currentTimeMillis() - this.f13289k >= 21600000) {
                    this.f13281c = true;
                    new Thread(this).start();
                }
            }
        }
    }

    public void run() {
        this.f13290l = false;
        if (C3952a.m16248b(this.f13283e)) {
            if (this.f13288j) {
                Object a = C3954b.m16258a(this.f13293o, AdError.SERVER_ERROR_CODE, 3);
                if (!TextUtils.isEmpty(a)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(a).optJSONObject(Constants.KEY_DATA);
                        if (optJSONObject != null) {
                            this.f13287i = optJSONObject.optString("business_config", BuildConfig.FLAVOR);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            m16293b(this.f13287i);
            this.f13281c = false;
            return;
        }
        C3957a.m16278a().m16281a(C3953a.m16254a(m16302g()));
        m16298e();
        m16296d();
        this.f13281c = false;
    }
}
