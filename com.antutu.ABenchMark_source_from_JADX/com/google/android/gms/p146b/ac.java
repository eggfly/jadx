package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@gb
@TargetApi(14)
/* renamed from: com.google.android.gms.b.ac */
public class ac extends Thread {
    private boolean f10221a;
    private boolean f10222b;
    private boolean f10223c;
    private final Object f10224d;
    private final ab f10225e;
    private final aa f10226f;
    private final ga f10227g;
    private final int f10228h;
    private final int f10229i;
    private final int f10230j;
    private final int f10231k;
    private final int f10232l;

    /* renamed from: com.google.android.gms.b.ac.1 */
    class C30181 implements Runnable {
        final /* synthetic */ View f10210a;
        final /* synthetic */ ac f10211b;

        C30181(ac acVar, View view) {
            this.f10211b = acVar;
            this.f10210a = view;
        }

        public void run() {
            this.f10211b.m11746b(this.f10210a);
        }
    }

    /* renamed from: com.google.android.gms.b.ac.2 */
    class C30202 implements Runnable {
        ValueCallback<String> f10213a;
        final /* synthetic */ C3377z f10214b;
        final /* synthetic */ WebView f10215c;
        final /* synthetic */ boolean f10216d;
        final /* synthetic */ ac f10217e;

        /* renamed from: com.google.android.gms.b.ac.2.1 */
        class C30191 implements ValueCallback<String> {
            final /* synthetic */ C30202 f10212a;

            C30191(C30202 c30202) {
                this.f10212a = c30202;
            }

            public void m11737a(String str) {
                this.f10212a.f10217e.m11741a(this.f10212a.f10214b, this.f10212a.f10215c, str, this.f10212a.f10216d);
            }

            public /* synthetic */ void onReceiveValue(Object obj) {
                m11737a((String) obj);
            }
        }

        C30202(ac acVar, C3377z c3377z, WebView webView, boolean z) {
            this.f10217e = acVar;
            this.f10214b = c3377z;
            this.f10215c = webView;
            this.f10216d = z;
            this.f10213a = new C30191(this);
        }

        public void run() {
            if (this.f10215c.getSettings().getJavaScriptEnabled()) {
                try {
                    this.f10215c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f10213a);
                } catch (Throwable th) {
                    this.f10213a.onReceiveValue(BuildConfig.FLAVOR);
                }
            }
        }
    }

    @gb
    /* renamed from: com.google.android.gms.b.ac.a */
    class C3021a {
        final int f10218a;
        final int f10219b;
        final /* synthetic */ ac f10220c;

        C3021a(ac acVar, int i, int i2) {
            this.f10220c = acVar;
            this.f10218a = i;
            this.f10219b = i2;
        }
    }

    public ac(ab abVar, aa aaVar, ga gaVar) {
        this.f10221a = false;
        this.f10222b = false;
        this.f10223c = false;
        this.f10225e = abVar;
        this.f10226f = aaVar;
        this.f10227g = gaVar;
        this.f10224d = new Object();
        this.f10229i = ((Integer) aq.f10271K.m11794c()).intValue();
        this.f10230j = ((Integer) aq.f10272L.m11794c()).intValue();
        this.f10231k = ((Integer) aq.f10273M.m11794c()).intValue();
        this.f10232l = ((Integer) aq.f10274N.m11794c()).intValue();
        this.f10228h = ((Integer) aq.f10275O.m11794c()).intValue();
        setName("ContentFetchTask");
    }

    C3021a m11738a(View view, C3377z c3377z) {
        int i = 0;
        if (view == null) {
            return new C3021a(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new C3021a(this, 0, 0);
            }
            c3377z.m13911b(text.toString(), globalVisibleRect);
            return new C3021a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof ii)) {
            c3377z.m13915f();
            return m11745a((WebView) view, c3377z, globalVisibleRect) ? new C3021a(this, 0, 1) : new C3021a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C3021a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                C3021a a = m11738a(viewGroup.getChildAt(i), c3377z);
                i3 += a.f10218a;
                i2 += a.f10219b;
                i++;
            }
            return new C3021a(this, i3, i2);
        }
    }

    public void m11739a() {
        synchronized (this.f10224d) {
            if (this.f10221a) {
                C2972b.m11576a("Content hash thread already started, quiting...");
                return;
            }
            this.f10221a = true;
            start();
        }
    }

    void m11740a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                m11744a(view);
            }
        }
    }

    void m11741a(C3377z c3377z, WebView webView, String str, boolean z) {
        c3377z.m13914e();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    c3377z.m13908a(optString, z);
                } else {
                    c3377z.m13908a(webView.getTitle() + "\n" + optString, z);
                }
            }
            if (c3377z.m13909a()) {
                this.f10226f.m11732b(c3377z);
            }
        } catch (JSONException e) {
            C2972b.m11576a("Json string may be malformed.");
        } catch (Throwable th) {
            C2972b.m11577a("Failed to get webview content.", th);
            this.f10227g.m12806a(th, true);
        }
    }

    boolean m11742a(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean m11743a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean m11744a(View view) {
        if (view == null) {
            return false;
        }
        view.post(new C30181(this, view));
        return true;
    }

    @TargetApi(19)
    boolean m11745a(WebView webView, C3377z c3377z, boolean z) {
        if (!jq.m13572e()) {
            return false;
        }
        c3377z.m13915f();
        webView.post(new C30202(this, c3377z, webView, z));
        return true;
    }

    void m11746b(View view) {
        try {
            C3377z c3377z = new C3377z(this.f10229i, this.f10230j, this.f10231k, this.f10232l);
            C3021a a = m11738a(view, c3377z);
            c3377z.m13916g();
            if (a.f10218a != 0 || a.f10219b != 0) {
                if (a.f10219b != 0 || c3377z.m13918i() != 0) {
                    if (a.f10219b != 0 || !this.f10226f.m11731a(c3377z)) {
                        this.f10226f.m11733c(c3377z);
                    }
                }
            }
        } catch (Throwable e) {
            C2972b.m11580b("Exception in fetchContentOnUIThread", e);
            this.f10227g.m12806a(e, true);
        }
    }

    boolean m11747b() {
        try {
            Context b = this.f10225e.m11736b();
            if (b == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) b.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) b.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (m11742a(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && m11743a(b)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public C3377z m11748c() {
        return this.f10226f.m11730a();
    }

    public void m11749d() {
        synchronized (this.f10224d) {
            this.f10222b = false;
            this.f10224d.notifyAll();
            C2972b.m11576a("ContentFetchThread: wakeup");
        }
    }

    public void m11750e() {
        synchronized (this.f10224d) {
            this.f10222b = true;
            C2972b.m11576a("ContentFetchThread: paused, mPause = " + this.f10222b);
        }
    }

    public boolean m11751f() {
        return this.f10222b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.f10223c;
        if (r0 != 0) goto L_0x0052;
    L_0x0004:
        r0 = r3.m11747b();	 Catch:{ Throwable -> 0x0018 }
        if (r0 == 0) goto L_0x0044;
    L_0x000a:
        r0 = r3.f10225e;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0.m11735a();	 Catch:{ Throwable -> 0x0018 }
        if (r0 != 0) goto L_0x0038;
    L_0x0012:
        r0 = "ContentFetchThread: no activity";
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0000;
    L_0x0018:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.ads.internal.util.client.C2972b.m11580b(r1, r0);
        r1 = r3.f10227g;
        r2 = 1;
        r1.m12806a(r0, r2);
    L_0x0024:
        r1 = r3.f10224d;
        monitor-enter(r1);
    L_0x0027:
        r0 = r3.f10222b;	 Catch:{ all -> 0x004f }
        if (r0 == 0) goto L_0x004d;
    L_0x002b:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r0);	 Catch:{ InterruptedException -> 0x0036 }
        r0 = r3.f10224d;	 Catch:{ InterruptedException -> 0x0036 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0036 }
        goto L_0x0027;
    L_0x0036:
        r0 = move-exception;
        goto L_0x0027;
    L_0x0038:
        r3.m11740a(r0);	 Catch:{ Throwable -> 0x0018 }
    L_0x003b:
        r0 = r3.f10228h;	 Catch:{ Throwable -> 0x0018 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0018 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0024;
    L_0x0044:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.ads.internal.util.client.C2972b.m11576a(r0);	 Catch:{ Throwable -> 0x0018 }
        r3.m11750e();	 Catch:{ Throwable -> 0x0018 }
        goto L_0x003b;
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        goto L_0x0000;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x004f }
        throw r0;
    L_0x0052:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ac.run():void");
    }
}
