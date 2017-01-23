package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

@gb
@TargetApi(11)
/* renamed from: com.google.android.gms.b.io */
public class io extends WebChromeClient {
    private final ii f11484a;

    /* renamed from: com.google.android.gms.b.io.1 */
    static class C32891 implements OnCancelListener {
        final /* synthetic */ JsResult f11476a;

        C32891(JsResult jsResult) {
            this.f11476a = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f11476a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.b.io.2 */
    static class C32902 implements OnClickListener {
        final /* synthetic */ JsResult f11477a;

        C32902(JsResult jsResult) {
            this.f11477a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11477a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.b.io.3 */
    static class C32913 implements OnClickListener {
        final /* synthetic */ JsResult f11478a;

        C32913(JsResult jsResult) {
            this.f11478a = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11478a.confirm();
        }
    }

    /* renamed from: com.google.android.gms.b.io.4 */
    static class C32924 implements OnCancelListener {
        final /* synthetic */ JsPromptResult f11479a;

        C32924(JsPromptResult jsPromptResult) {
            this.f11479a = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f11479a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.b.io.5 */
    static class C32935 implements OnClickListener {
        final /* synthetic */ JsPromptResult f11480a;

        C32935(JsPromptResult jsPromptResult) {
            this.f11480a = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11480a.cancel();
        }
    }

    /* renamed from: com.google.android.gms.b.io.6 */
    static class C32946 implements OnClickListener {
        final /* synthetic */ JsPromptResult f11481a;
        final /* synthetic */ EditText f11482b;

        C32946(JsPromptResult jsPromptResult, EditText editText) {
            this.f11481a = jsPromptResult;
            this.f11482b = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11481a.confirm(this.f11482b.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.b.io.7 */
    static /* synthetic */ class C32957 {
        static final /* synthetic */ int[] f11483a;

        static {
            f11483a = new int[MessageLevel.values().length];
            try {
                f11483a[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11483a[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11483a[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11483a[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11483a[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public io(ii iiVar) {
        this.f11484a = iiVar;
    }

    private final Context m13417a(WebView webView) {
        if (!(webView instanceof ii)) {
            return webView.getContext();
        }
        ii iiVar = (ii) webView;
        Context f = iiVar.m13243f();
        return f == null ? iiVar.getContext() : f;
    }

    private static void m13418a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C32913(jsResult)).setNegativeButton(17039360, new C32902(jsResult)).setOnCancelListener(new C32891(jsResult)).create().show();
    }

    private static void m13419a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C32946(jsPromptResult, editText)).setNegativeButton(17039360, new C32935(jsPromptResult)).setOnCancelListener(new C32924(jsPromptResult)).create().show();
    }

    private final boolean m13420a() {
        return C2968s.m11525e().m13045a(this.f11484a.getContext().getPackageManager(), this.f11484a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || C2968s.m11525e().m13045a(this.f11484a.getContext().getPackageManager(), this.f11484a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void m13421a(View view, int i, CustomViewCallback customViewCallback) {
        C2864d i2 = this.f11484a.m13246i();
        if (i2 == null) {
            C2972b.m11583d("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        i2.m11100a(view, customViewCallback);
        i2.m11098a(i);
    }

    protected boolean m13422a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                io.m13419a(context, builder, str2, str3, jsPromptResult);
            } else {
                io.m13418a(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof ii) {
            C2864d i = ((ii) webView).m13246i();
            if (i == null) {
                C2972b.m11583d("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                i.m11097a();
                return;
            }
        }
        C2972b.m11583d("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + C4233j.f14397t;
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C32957.f11483a[consoleMessage.messageLevel().ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                C2972b.m11579b(str);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                C2972b.m11583d(str);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
                C2972b.m11581c(str);
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                C2972b.m11576a(str);
                break;
            default:
                C2972b.m11581c(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.f11484a.m13249l());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, m13420a(), true);
        }
    }

    public final void onHideCustomView() {
        C2864d i = this.f11484a.m13246i();
        if (i == null) {
            C2972b.m11583d("Could not get ad overlay when hiding custom view.");
        } else {
            i.m11104b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m13422a(m13417a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m13422a(m13417a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m13422a(m13417a(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m13422a(m13417a(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m13421a(view, -1, customViewCallback);
    }
}
