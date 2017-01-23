package com.google.android.gms.internal;

import agb;
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
import com.google.android.gms.ads.internal.util.client.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@eh
@TargetApi(14)
public class ag extends Thread {
    private final Object DW;
    private final af FH;
    private final ae Hw;
    private final int VH;
    private final int Zo;
    private final int gn;
    private boolean j6;
    private final int tp;
    private final int u7;
    private final eg v5;

    class 1 implements Runnable {
        final /* synthetic */ ag DW;
        final /* synthetic */ View j6;

        1(ag agVar, View view) {
            this.DW = agVar;
            this.j6 = view;
        }

        public void run() {
            this.DW.DW(this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ ad DW;
        final /* synthetic */ WebView FH;
        final /* synthetic */ boolean Hw;
        ValueCallback<String> j6;
        final /* synthetic */ ag v5;

        class 1 implements ValueCallback<String> {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void j6(String str) {
                this.j6.v5.j6(this.j6.DW, this.j6.FH, str, this.j6.Hw);
            }

            public /* synthetic */ void onReceiveValue(Object obj) {
                j6((String) obj);
            }
        }

        2(ag agVar, ad adVar, WebView webView, boolean z) {
            this.v5 = agVar;
            this.DW = adVar;
            this.FH = webView;
            this.Hw = z;
            this.j6 = new 1(this);
        }

        public void run() {
            if (this.FH.getSettings().getJavaScriptEnabled()) {
                try {
                    this.FH.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.j6);
                } catch (Throwable th) {
                    this.j6.onReceiveValue("");
                }
            }
        }
    }

    @eh
    class a {
        final int DW;
        final /* synthetic */ ag FH;
        final int j6;

        a(ag agVar, int i, int i2) {
            this.FH = agVar;
            this.j6 = i;
            this.DW = i2;
        }
    }

    public void DW() {
        synchronized (this.DW) {
            this.j6 = true;
            b.j6("ContentFetchThread: paused, mPause = " + this.j6);
        }
    }

    void DW(View view) {
        try {
            ad adVar = new ad(this.VH, this.gn, this.u7, this.tp);
            a j6 = j6(view, adVar);
            adVar.v5();
            if (j6.j6 != 0 || j6.DW != 0) {
                if (j6.DW != 0 || adVar.Zo() != 0) {
                    if (j6.DW != 0 || !this.Hw.j6(adVar)) {
                        this.Hw.FH(adVar);
                    }
                }
            }
        } catch (Throwable e) {
            b.DW("Exception in fetchContentOnUIThread", e);
            this.v5.j6(e, true);
        }
    }

    a j6(View view, ad adVar) {
        int i = 0;
        if (view == null) {
            return new a(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new a(this, 0, 0);
            }
            adVar.DW(text.toString(), globalVisibleRect);
            return new a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof fj)) {
            adVar.Hw();
            return j6((WebView) view, adVar, globalVisibleRect) ? new a(this, 0, 1) : new a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                a j6 = j6(viewGroup.getChildAt(i), adVar);
                i3 += j6.j6;
                i2 += j6.DW;
                i++;
            }
            return new a(this, i3, i2);
        }
    }

    void j6(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                j6(view);
            }
        }
    }

    void j6(ad adVar, WebView webView, String str, boolean z) {
        adVar.FH();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    adVar.j6(optString, z);
                } else {
                    String valueOf = String.valueOf(webView.getTitle());
                    adVar.j6(new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z);
                }
            }
            if (adVar.j6()) {
                this.Hw.DW(adVar);
            }
        } catch (JSONException e) {
            b.j6("Json string may be malformed.");
        } catch (Throwable th) {
            b.j6("Failed to get webview content.", th);
            this.v5.j6(th, true);
        }
    }

    boolean j6() {
        try {
            Context DW = this.FH.DW();
            if (DW == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) DW.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) DW.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (j6(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && j6(DW)) {
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

    boolean j6(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean j6(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }

    boolean j6(View view) {
        if (view == null) {
            return false;
        }
        view.post(new 1(this, view));
        return true;
    }

    @TargetApi(19)
    boolean j6(WebView webView, ad adVar, boolean z) {
        if (!agb.VH()) {
            return false;
        }
        adVar.Hw();
        webView.post(new 2(this, adVar, webView, z));
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.j6();	 Catch:{ Throwable -> 0x0038 }
        if (r0 == 0) goto L_0x0046;
    L_0x0006:
        r0 = r3.FH;	 Catch:{ Throwable -> 0x0038 }
        r0 = r0.j6();	 Catch:{ Throwable -> 0x0038 }
        if (r0 != 0) goto L_0x0034;
    L_0x000e:
        r0 = "ContentFetchThread: no activity. Sleeping.";
        com.google.android.gms.ads.internal.util.client.b.j6(r0);	 Catch:{ Throwable -> 0x0038 }
        r3.DW();	 Catch:{ Throwable -> 0x0038 }
    L_0x0017:
        r0 = r3.Zo;	 Catch:{ Throwable -> 0x0038 }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0038 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0038 }
    L_0x001f:
        r1 = r3.DW;
        monitor-enter(r1);
    L_0x0022:
        r0 = r3.j6;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0050;
    L_0x0026:
        r0 = "ContentFetchTask: waiting";
        com.google.android.gms.ads.internal.util.client.b.j6(r0);	 Catch:{ InterruptedException -> 0x0032 }
        r0 = r3.DW;	 Catch:{ InterruptedException -> 0x0032 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0032 }
        goto L_0x0022;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0022;
    L_0x0034:
        r3.j6(r0);	 Catch:{ Throwable -> 0x0038 }
        goto L_0x0017;
    L_0x0038:
        r0 = move-exception;
        r1 = "Error in ContentFetchTask";
        com.google.android.gms.ads.internal.util.client.b.DW(r1, r0);
        r1 = r3.v5;
        r2 = 1;
        r1.j6(r0, r2);
        goto L_0x001f;
    L_0x0046:
        r0 = "ContentFetchTask: sleeping";
        com.google.android.gms.ads.internal.util.client.b.j6(r0);	 Catch:{ Throwable -> 0x0038 }
        r3.DW();	 Catch:{ Throwable -> 0x0038 }
        goto L_0x0017;
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        goto L_0x0000;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0052 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ag.run():void");
    }
}
