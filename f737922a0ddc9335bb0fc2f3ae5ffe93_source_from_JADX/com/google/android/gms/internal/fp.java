package com.google.android.gms.internal;

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
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.b;

@eh
@TargetApi(11)
public class fp extends WebChromeClient {
    private final fj j6;

    class 1 implements OnCancelListener {
        final /* synthetic */ JsResult j6;

        1(JsResult jsResult) {
            this.j6 = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.j6.cancel();
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ JsResult j6;

        2(JsResult jsResult) {
            this.j6 = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.cancel();
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ JsResult j6;

        3(JsResult jsResult) {
            this.j6 = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.confirm();
        }
    }

    class 4 implements OnCancelListener {
        final /* synthetic */ JsPromptResult j6;

        4(JsPromptResult jsPromptResult) {
            this.j6 = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.j6.cancel();
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ JsPromptResult j6;

        5(JsPromptResult jsPromptResult) {
            this.j6 = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.cancel();
        }
    }

    class 6 implements OnClickListener {
        final /* synthetic */ EditText DW;
        final /* synthetic */ JsPromptResult j6;

        6(JsPromptResult jsPromptResult, EditText editText) {
            this.j6 = jsPromptResult;
            this.DW = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.j6.confirm(this.DW.getText().toString());
        }
    }

    static /* synthetic */ class 7 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[MessageLevel.values().length];
            try {
                j6[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public fp(fj fjVar) {
        this.j6 = fjVar;
    }

    private final Context j6(WebView webView) {
        if (!(webView instanceof fj)) {
            return webView.getContext();
        }
        fj fjVar = (fj) webView;
        Context VH = fjVar.VH();
        return VH == null ? fjVar.getContext() : VH;
    }

    private static void j6(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new 3(jsResult)).setNegativeButton(17039360, new 2(jsResult)).setOnCancelListener(new 1(jsResult)).create().show();
    }

    private static void j6(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new 6(jsPromptResult, editText)).setNegativeButton(17039360, new 5(jsPromptResult)).setOnCancelListener(new 4(jsPromptResult)).create().show();
    }

    private final boolean j6() {
        return f.FH().j6(this.j6.getContext().getPackageManager(), this.j6.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || f.FH().j6(this.j6.getContext().getPackageManager(), this.j6.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    protected final void j6(View view, int i, CustomViewCallback customViewCallback) {
        c tp = this.j6.tp();
        if (tp == null) {
            b.Hw("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        tp.j6(view, customViewCallback);
        tp.j6(i);
    }

    protected boolean j6(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                j6(context, builder, str2, str3, jsPromptResult);
            } else {
                j6(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            b.FH("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof fj) {
            c tp = ((fj) webView).tp();
            if (tp == null) {
                b.Hw("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                tp.j6();
                return;
            }
        }
        b.Hw("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String valueOf = String.valueOf(consoleMessage.message());
        String valueOf2 = String.valueOf(consoleMessage.sourceId());
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(valueOf2).length()).append("JS: ").append(valueOf).append(" (").append(valueOf2).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (valueOf.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (7.j6[consoleMessage.messageLevel().ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                b.DW(valueOf);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                b.Hw(valueOf);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                b.FH(valueOf);
                break;
            case 5:
                b.j6(valueOf);
                break;
            default:
                b.FH(valueOf);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.j6.J0());
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
            callback.invoke(str, j6(), true);
        }
    }

    public final void onHideCustomView() {
        c tp = this.j6.tp();
        if (tp == null) {
            b.Hw("Could not get ad overlay when hiding custom view.");
        } else {
            tp.DW();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return j6(j6(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return j6(j6(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return j6(j6(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return j6(j6(webView), str, str2, str3, null, jsPromptResult, true);
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
        j6(view, -1, customViewCallback);
    }
}
