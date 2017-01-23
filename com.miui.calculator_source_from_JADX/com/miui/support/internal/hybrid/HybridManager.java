package com.miui.support.internal.hybrid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.miui.support.hybrid.Callback;
import com.miui.support.hybrid.HybridChromeClient;
import com.miui.support.hybrid.HybridFeature;
import com.miui.support.hybrid.HybridFeature.Mode;
import com.miui.support.hybrid.HybridSettings;
import com.miui.support.hybrid.HybridView;
import com.miui.support.hybrid.HybridViewClient;
import com.miui.support.hybrid.LifecycleListener;
import com.miui.support.hybrid.NativeInterface;
import com.miui.support.hybrid.PageContext;
import com.miui.support.hybrid.Request;
import com.miui.support.hybrid.Response;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public class HybridManager {
    private static ExecutorService f2443a;
    private static String f2444b;
    private Activity f2445c;
    private HybridView f2446d;
    private boolean f2447e;
    private NativeInterface f2448f;
    private FeatureManager f2449g;
    private PermissionManager f2450h;
    private PageContext f2451i;
    private Set<LifecycleListener> f2452j;

    /* renamed from: com.miui.support.internal.hybrid.HybridManager.1 */
    class C02821 implements OnAttachStateChangeListener {
        final /* synthetic */ HybridManager f2435a;

        C02821(HybridManager hybridManager) {
            this.f2435a = hybridManager;
        }

        public void onViewAttachedToWindow(View view) {
            this.f2435a.f2447e = false;
        }

        public void onViewDetachedFromWindow(View view) {
            this.f2435a.f2447e = true;
        }
    }

    private class AsyncInvocation implements Runnable {
        final /* synthetic */ HybridManager f2436a;
        private HybridFeature f2437b;
        private Request f2438c;
        private String f2439d;

        public AsyncInvocation(HybridManager hybridManager, HybridFeature hybridFeature, Request request, String str) {
            this.f2436a = hybridManager;
            this.f2437b = hybridFeature;
            this.f2438c = request;
            this.f2439d = str;
        }

        public void run() {
            Response a = this.f2437b.m3504a(this.f2438c);
            if (this.f2437b.m3506b(this.f2438c) == Mode.ASYNC) {
                this.f2436a.m4042a(a, this.f2438c.m3559d(), this.f2439d);
            }
        }
    }

    private class JsInvocation implements Runnable {
        final /* synthetic */ HybridManager f2440a;
        private Response f2441b;
        private String f2442c;

        public JsInvocation(HybridManager hybridManager, Response response, String str) {
            this.f2440a = hybridManager;
            this.f2441b = response;
            this.f2442c = str;
        }

        public void run() {
            this.f2440a.f2446d.m3521a("javascript:" + this.f2440a.m4026a(this.f2441b, this.f2442c));
        }
    }

    static {
        f2443a = Executors.newCachedThreadPool();
    }

    public HybridManager(Activity activity, HybridView hybridView) {
        this.f2452j = new CopyOnWriteArraySet();
        this.f2445c = activity;
        this.f2446d = hybridView;
    }

    public void m4039a(int i, String str) {
        this.f2448f = new NativeInterface(this);
        Config a = m4025a(i);
        m4027a(a, false);
        m4034i();
        if (str == null && !TextUtils.isEmpty(a.m4003c())) {
            str = m4032c(a.m4003c());
        }
        if (str != null) {
            this.f2446d.m3521a(str);
        }
    }

    private Config m4025a(int i) {
        XmlConfigParser a;
        if (i == 0) {
            try {
                a = XmlConfigParser.m4091a(this.f2445c);
            } catch (HybridException e) {
                throw new RuntimeException("cannot load config: " + e.getMessage());
            }
        }
        a = XmlConfigParser.m4092a(this.f2445c, i);
        return a.m4100a(null);
    }

    private String m4027a(Config config, boolean z) {
        if (z) {
            SecurityManager securityManager = new SecurityManager(config, this.f2445c.getApplicationContext());
            if (securityManager.m4080a() || !securityManager.m4081b()) {
                return new Response(202).toString();
            }
        }
        this.f2449g = new FeatureManager(config, this.f2445c.getClassLoader());
        this.f2450h = new PermissionManager(config);
        return new Response(0).toString();
    }

    public String m4035a(String str) {
        try {
            return m4027a(JsonConfigParser.m4060a(str).m4007a(null), true);
        } catch (HybridException e) {
            return new Response(201, e.getMessage()).toString();
        }
    }

    public void m4041a(PageContext pageContext) {
        this.f2451i = pageContext;
    }

    private void m4034i() {
        m4029a(this.f2446d.getSettings());
        this.f2446d.setHybridViewClient(new HybridViewClient());
        this.f2446d.setHybridChromeClient(new HybridChromeClient());
        this.f2446d.m3520a(new JsInterface(this), "MiuiJsBridge");
        this.f2446d.addOnAttachStateChangeListener(new C02821(this));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m4029a(HybridSettings hybridSettings) {
        hybridSettings.m3517a(true);
        hybridSettings.m3516a(m4031b(hybridSettings.m3515a()));
    }

    private String m4031b(String str) {
        if (f2444b == null) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" XiaoMi/HybridView/");
            stringBuilder.append(m4022a(this.f2445c, "com.miui.core").versionName);
            stringBuilder.append(" ");
            stringBuilder.append(this.f2445c.getPackageName());
            stringBuilder.append("/");
            stringBuilder.append(m4022a(this.f2445c, this.f2445c.getPackageName()).versionName);
            f2444b = stringBuilder.toString();
        }
        return f2444b;
    }

    private static PackageInfo m4022a(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    private String m4032c(String str) {
        if (Pattern.compile("^[a-z-]+://").matcher(str).find()) {
            return str;
        }
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }
        return "file:///android_asset/hybrid/" + str;
    }

    private HybridFeature m4033d(String str) {
        if (this.f2450h.m4071a(this.f2451i.m3547a())) {
            return this.f2449g.m4020a(str);
        }
        throw new HybridException(203, "feature not permitted: " + str);
    }

    private Request m4024a(String str, String str2, String str3) {
        Request request = new Request();
        request.m3555a(str2);
        request.m3557b(str3);
        request.m3554a(this.f2451i);
        request.m3551a(this.f2446d);
        request.m3553a(this.f2448f);
        return request;
    }

    public String m4036a(String str, String str2) {
        try {
            if (m4033d(str).m3506b(m4024a(str, str2, null)) == null) {
                return new Response(205, "action not supported: " + str2).toString();
            }
            return new Response(0).toString();
        } catch (HybridException e) {
            return e.m4021a().toString();
        }
    }

    public String m4037a(String str, String str2, String str3, String str4) {
        try {
            HybridFeature d = m4033d(str);
            Request a = m4024a(str, str2, str3);
            Mode b = d.m3506b(a);
            if (b == Mode.SYNC) {
                m4042a(new Response(1), this.f2451i, str4);
                return d.m3504a(a).toString();
            } else if (b == Mode.ASYNC) {
                f2443a.execute(new AsyncInvocation(this, d, a, str4));
                return new Response(2).toString();
            } else {
                a.m3552a(new Callback(this, this.f2451i, str4));
                f2443a.execute(new AsyncInvocation(this, d, a, str4));
                return new Response(3).toString();
            }
        } catch (HybridException e) {
            Response a2 = e.m4021a();
            m4042a(a2, this.f2451i, str4);
            return a2.toString();
        }
    }

    public boolean m4043a() {
        return this.f2447e;
    }

    public void m4042a(Response response, PageContext pageContext, String str) {
        if (response != null && !TextUtils.isEmpty(str) && pageContext.equals(this.f2451i) && !this.f2447e && !this.f2445c.isFinishing()) {
            if (Log.isLoggable("hybrid", 3)) {
                Log.d("hybrid", "non-blocking response is " + response.toString());
            }
            this.f2445c.runOnUiThread(new JsInvocation(this, response, str));
        }
    }

    private String m4026a(Response response, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("('");
        stringBuilder.append(response.toString().replace("\\", "\\\\").replace("'", "\\'"));
        stringBuilder.append("');");
        return stringBuilder.toString();
    }

    public Activity m4044b() {
        return this.f2445c;
    }

    public void m4040a(LifecycleListener lifecycleListener) {
        this.f2452j.add(lifecycleListener);
    }

    public void m4045b(LifecycleListener lifecycleListener) {
        this.f2452j.remove(lifecycleListener);
    }

    public void m4046c() {
        for (LifecycleListener a : this.f2452j) {
            a.m3537a();
        }
    }

    public void m4047d() {
        for (LifecycleListener b : this.f2452j) {
            b.m3539b();
        }
    }

    public void m4048e() {
        for (LifecycleListener c : this.f2452j) {
            c.m3540c();
        }
    }

    public void m4049f() {
        for (LifecycleListener d : this.f2452j) {
            d.m3541d();
        }
    }

    public void m4050g() {
        for (LifecycleListener e : this.f2452j) {
            e.m3542e();
        }
    }

    public void m4051h() {
        for (LifecycleListener f : this.f2452j) {
            f.m3543f();
        }
    }

    public void m4038a(int i, int i2, Intent intent) {
        for (LifecycleListener a : this.f2452j) {
            a.m3538a(i, i2, intent);
        }
    }
}
