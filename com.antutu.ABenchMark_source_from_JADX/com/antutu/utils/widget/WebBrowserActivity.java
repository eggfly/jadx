package com.antutu.utils.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p037f.C1500c;
import com.antutu.benchmark.p038b.C1337b;
import com.antutu.benchmark.view.CustomWebView;
import com.antutu.redacc.C1692R;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.ShareUtil;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.jni;
import com.igexin.download.Downloads;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Field;
import java.net.URLDecoder;

public class WebBrowserActivity extends C1337b {
    private static String share_image_url;
    private static String share_title;
    private static String share_url;
    private static String summary;
    private boolean mOpenOutside;
    private TextView mShare;
    private ProgressBar webProgress;
    private TextView webTitle;
    private CustomWebView webView;

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.1 */
    class C18391 implements OnClickListener {
        C18391() {
        }

        public void onClick(View view) {
            Methods.hideSoftKeyboard(WebBrowserActivity.this, WebBrowserActivity.this.webView);
            WebBrowserActivity.this.finishWithAnimation();
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.2 */
    class C18402 implements C1500c {
        C18402() {
        }

        public void onEventTrack() {
            WebBrowserActivity.this.finishWithAnimation();
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.3 */
    class C18413 implements OnClickListener {
        C18413() {
        }

        public void onClick(View view) {
            if (WebBrowserActivity.summary == null) {
                WebBrowserActivity.summary = BuildConfig.FLAVOR;
            } else if (WebBrowserActivity.summary.length() > 70) {
                WebBrowserActivity.summary = WebBrowserActivity.summary.substring(0, 70);
                WebBrowserActivity.summary = WebBrowserActivity.summary + "...";
            }
            ShareUtil.showShareApp(WebBrowserActivity.this, null, WebBrowserActivity.share_url, WebBrowserActivity.share_title, WebBrowserActivity.this.webView, WebBrowserActivity.share_image_url, WebBrowserActivity.summary);
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.4 */
    class C18424 extends WebChromeClient {
        C18424() {
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i <= 0 || i >= 100) {
                try {
                    WebBrowserActivity.this.webProgress.setVisibility(8);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            WebBrowserActivity.this.webProgress.setVisibility(0);
            WebBrowserActivity.this.webProgress.setProgress(i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!(!TextUtils.isEmpty(WebBrowserActivity.this.webTitle.getText()) || WebBrowserActivity.this.getIntent() == null || WebBrowserActivity.this.getIntent().getBooleanExtra("hideTitle", false))) {
                WebBrowserActivity.this.webTitle.setText(str);
            }
            super.onReceivedTitle(webView, str);
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.5 */
    class C18435 extends WebViewClient {
        boolean isfirst;

        C18435() {
            this.isfirst = true;
        }

        public void onPageFinished(WebView webView, String str) {
            try {
                WebBrowserActivity.this.webProgress.setVisibility(8);
            } catch (Exception e) {
            }
            super.onPageFinished(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            WebBrowserActivity.this.webProgress.setVisibility(8);
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            MLog.m6864d("hzd, @shouldOverrideUrlLoading, url=" + str);
            if (TextUtils.isEmpty(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (str.startsWith("market://")) {
                Methods.downloadFromGP(WebBrowserActivity.this, str);
                WebBrowserActivity.this.finishWithAnimation();
                return true;
            } else if ((WebBrowserActivity.this.mOpenOutside || !this.isfirst) && (str.startsWith("http://") || str.startsWith("https://"))) {
                Methods.openBrower(WebBrowserActivity.this, str);
                return true;
            } else {
                this.isfirst = false;
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.6 */
    static class C18446 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$title;
        final /* synthetic */ String val$url;

        C18446(Context context, String str, String str2) {
            this.val$context = context;
            this.val$url = str;
            this.val$title = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            WebBrowserActivity.download(this.val$context, this.val$url, this.val$title);
        }
    }

    /* renamed from: com.antutu.utils.widget.WebBrowserActivity.7 */
    static class C18457 implements DialogInterface.OnClickListener {
        C18457() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private class WebInterface {
        private WebInterface() {
        }

        @JavascriptInterface
        public void copy(String str) {
            ((ClipboardManager) WebBrowserActivity.this.getSystemService("clipboard")).setText(str);
            Toast.makeText(WebBrowserActivity.this.getApplication(), WebBrowserActivity.this.getString(C1692R.string.has_copy), 0).show();
        }

        @JavascriptInterface
        public void openInBrowser(String str) {
            if (WebBrowserActivity.this.webView != null && str != null) {
                Methods.openBrower(WebBrowserActivity.this, str);
            }
        }

        @JavascriptInterface
        public void openInWebView(String str) {
            if (WebBrowserActivity.this.webView != null && str != null) {
                WebBrowserActivity.this.webView.loadUrl(str);
            }
        }

        @JavascriptInterface
        public void readSourceText(String str) {
        }

        @JavascriptInterface
        public void shareTo(String str) {
            if ("wx_timeline".equals(str)) {
                if (WebBrowserActivity.summary == null) {
                    WebBrowserActivity.summary = BuildConfig.FLAVOR;
                } else if (WebBrowserActivity.summary.length() > 70) {
                    WebBrowserActivity.summary = WebBrowserActivity.summary.substring(0, 70);
                    WebBrowserActivity.summary = WebBrowserActivity.summary + "...";
                }
                ShareUtil.showShareApp(WebBrowserActivity.this, WechatMoments.NAME, WebBrowserActivity.share_url, WebBrowserActivity.share_title, WebBrowserActivity.this.webView, WebBrowserActivity.share_image_url, WebBrowserActivity.summary);
            } else if ("wx_appmsg".equals(str)) {
                ShareUtil.showShareApp(WebBrowserActivity.this, Wechat.NAME, WebBrowserActivity.share_url, WebBrowserActivity.share_title, WebBrowserActivity.this.webView, WebBrowserActivity.share_image_url, WebBrowserActivity.summary);
            } else {
                ShareUtil.showShareApp(WebBrowserActivity.this, null, WebBrowserActivity.share_url, WebBrowserActivity.share_title, WebBrowserActivity.this.webView, WebBrowserActivity.share_image_url, WebBrowserActivity.summary);
            }
        }
    }

    static {
        share_title = null;
        share_url = null;
        share_image_url = null;
        summary = null;
    }

    public WebBrowserActivity() {
        this.webProgress = null;
        this.webTitle = null;
        this.webView = null;
        this.mShare = null;
        this.mOpenOutside = true;
    }

    private static void download(Context context, String str, String str2) {
        try {
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setUrl(str);
            downloadInfos.setTitle(str2);
            if (!str2.isEmpty()) {
                downloadInfos.setNeedRename(true);
            }
            DownloadsService.startDownload(context, downloadInfos);
        } catch (Exception e) {
        }
    }

    private static void downloadFromWeb(Context context, String str, String str2) {
        downloadFromWeb(context, str, str2, true);
    }

    private static void downloadFromWeb(Context context, String str, String str2, boolean z) {
        if (z && Methods.isMobileNetwork(context)) {
            Builder builder = new Builder(context);
            builder.setTitle(context.getString(C1082R.string.download)).setMessage(context.getString(C1082R.string.continue_mobile_info, new Object[]{str2})).setPositiveButton(context.getString(C1692R.string.cancel), new C18457()).setNegativeButton(context.getString(C1692R.string.confirm), new C18446(context, str, str2));
            AlertDialog show = builder.show();
            show.setCanceledOnTouchOutside(false);
            show.show();
            return;
        }
        download(context, str, str2);
    }

    public static void openURL(Context context, String str, String str2) {
        openURL(context, str, str2, true);
    }

    @SuppressLint({"DefaultLocale"})
    public static void openURL(Context context, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        if (NetUtils.isNetworkAvailable()) {
            if (z) {
                try {
                } catch (Exception e) {
                    return;
                }
            }
            MLog.m6864d("hzd, @openURL: " + str);
            if (str.startsWith("http://openwithwebbrowser.") || str.startsWith("https://openwithwebbrowser.")) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("openwithwebbrowser.", BuildConfig.FLAVOR))).setFlags(268435456));
                return;
            } else if (str.startsWith("http://appdownloadwithtitle.")) {
                r1 = str.replace("appdownloadwithtitle.", BuildConfig.FLAVOR);
                r0 = BuildConfig.FLAVOR;
                r2 = r1.indexOf(".");
                if (r2 > 0) {
                    r0 = r1.substring(7, r2);
                    r1 = "http://" + r1.substring(r2 + 1);
                    r0 = URLDecoder.decode(r0, "utf-8");
                }
                downloadFromWeb(context, r1, r0);
                return;
            } else if (str.startsWith("https://appdownloadwithtitle.")) {
                r1 = str.replace("appdownloadwithtitle.", BuildConfig.FLAVOR);
                r0 = BuildConfig.FLAVOR;
                r2 = r1.indexOf(".");
                if (r2 > 0) {
                    r0 = r1.substring(8, r2);
                    r1 = "https://" + r1.substring(r2 + 1);
                    r0 = URLDecoder.decode(r0, "utf-8");
                }
                downloadFromWeb(context, r1, r0);
                return;
            } else if (str.startsWith("http://appdownloadwithtitle2.")) {
                r1 = str.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                r0 = BuildConfig.FLAVOR;
                r2 = r1.indexOf(".");
                if (r2 > 0) {
                    r0 = r1.substring(7, r2);
                    r1 = "http://" + r1.substring(r2 + 1);
                    r0 = jni.getStringSafe(r0, BuildConfig.FLAVOR);
                }
                downloadFromWeb(context, r1, r0);
                return;
            } else if (str.startsWith("https://appdownloadwithtitle2.")) {
                r1 = str.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                r0 = BuildConfig.FLAVOR;
                r2 = r1.indexOf(".");
                if (r2 > 0) {
                    r0 = r1.substring(8, r2);
                    r1 = "https://" + r1.substring(r2 + 1);
                    r0 = jni.getStringSafe(r0, BuildConfig.FLAVOR);
                }
                downloadFromWeb(context, r1, r0);
                return;
            } else if (str.toLowerCase().endsWith(".apk")) {
                downloadFromWeb(context, str, str2);
                return;
            } else if (str.startsWith("market://")) {
                Methods.downloadFromGP(context, str);
                return;
            } else if (z) {
                context.startActivity(new Intent(context, WebBrowserActivity.class).putExtra("url", str).putExtra(Downloads.COLUMN_TITLE, str2).putExtra("shareable", z).putExtra("imageUrl", str3).putExtra("summmary", str4).putExtra("hideTitle", z2).setFlags(335544320));
                return;
            } else {
                context.startActivity(new Intent(context, WebBrowserActivity.class).putExtra("url", str).putExtra(Downloads.COLUMN_TITLE, str2).setFlags(335544320));
                return;
            }
        }
        Methods.showToast(context, (int) C1082R.string.prompt_net, 0);
    }

    @SuppressLint({"DefaultLocale"})
    public static void openURL(Context context, String str, String str2, boolean z) {
        if (NetUtils.isNetworkAvailable()) {
            try {
                MLog.m6864d("hzd, @openURL: " + str);
                if (str.startsWith("http://openwithwebbrowser.") || str.startsWith("https://openwithwebbrowser.")) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("openwithwebbrowser.", BuildConfig.FLAVOR))).setFlags(268435456));
                    return;
                } else if (str.startsWith("http://appdownloadwithtitle.")) {
                    r1 = str.replace("appdownloadwithtitle.", BuildConfig.FLAVOR);
                    r0 = BuildConfig.FLAVOR;
                    r2 = r1.indexOf(".");
                    if (r2 > 0) {
                        r0 = r1.substring(7, r2);
                        r1 = "http://" + r1.substring(r2 + 1);
                        r0 = URLDecoder.decode(r0, "utf-8");
                    }
                    downloadFromWeb(context, r1, r0, z);
                    return;
                } else if (str.startsWith("http://appdownloadwithtitle2.")) {
                    r1 = str.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                    r0 = BuildConfig.FLAVOR;
                    r2 = r1.indexOf(".");
                    if (r2 > 0) {
                        r0 = r1.substring(7, r2);
                        r1 = "http://" + r1.substring(r2 + 1);
                        r0 = jni.getStringSafe(r0, BuildConfig.FLAVOR);
                    }
                    downloadFromWeb(context, r1, r0, z);
                    return;
                } else if (str.toLowerCase().endsWith(".apk")) {
                    downloadFromWeb(context, str, str2, z);
                    return;
                } else if (str.startsWith("market://")) {
                    Methods.downloadFromGP(context, str);
                    return;
                } else {
                    context.startActivity(new Intent(context, WebBrowserActivity.class).putExtra("url", str).putExtra(Downloads.COLUMN_TITLE, str2).setFlags(335544320));
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
        Methods.showToast(context, (int) C1082R.string.prompt_net, 0);
    }

    public static void openURLInApp(Context context, String str, String str2) {
        context.startActivity(new Intent(context, WebBrowserActivity.class).putExtra("url", str).putExtra(Downloads.COLUMN_TITLE, str2).putExtra("mOpenOutside", false).setFlags(335544320));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
        }
    }

    public static void openWebActivity(Context context, String str, String str2, String str3, String str4, String str5) {
        context.startActivity(new Intent(context, WebBrowserActivity.class).putExtra("url", str).putExtra(Downloads.COLUMN_TITLE, str2).putExtra("shareable", true).putExtra("imageUrl", str3).putExtra("summmary", str4).putExtra("hideTitle", true).putExtra("share_url", str5).setFlags(335544320));
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
        }
    }

    private void setZoomControlGone(WebView webView) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(webView);
            zoomButtonsController.getZoomControls().setVisibility(8);
            declaredField.set(webView, zoomButtonsController);
        } catch (Exception e) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1082R.layout.webbrowser);
        SystemBarTintManager.setSystemBar(this, C1082R.color.status_bar_color, false);
        findViewById(C1082R.id.menu_back_img).setOnClickListener(new C18391());
        if (!CookieManager.getInstance().acceptCookie()) {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        this.mShare = (TextView) findViewById(C1082R.id.share);
        this.mShare.setVisibility(8);
        this.webView = (CustomWebView) findViewById(C1082R.id.webView);
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        }
        this.webView.setFilingListener(new C18402());
        this.mShare.setOnClickListener(new C18413());
        this.webTitle = (TextView) findViewById(C1082R.id.app_title);
        this.webProgress = (ProgressBar) findViewById(C1082R.id.progressWeb);
        this.webProgress.setMax(100);
        this.webView.setWebChromeClient(new C18424());
        this.webView.setWebViewClient(new C18435());
        String str = BuildConfig.FLAVOR;
        try {
            Intent intent = getIntent();
            this.mOpenOutside = intent.getBooleanExtra("mOpenOutside", true);
            str = intent.getStringExtra("url");
            CharSequence stringExtra = intent.getStringExtra(Downloads.COLUMN_TITLE);
            String stringExtra2 = intent.getStringExtra("imageUrl");
            String stringExtra3 = intent.getStringExtra("summmary");
            if (intent.getBooleanExtra("shareable", false)) {
                this.mShare.setVisibility(0);
                share_url = intent.getStringExtra("share_url");
                if (share_url == null) {
                    share_url = str;
                }
                share_title = stringExtra;
                share_image_url = stringExtra2;
                summary = stringExtra3;
            }
            if (str == null || str.length() < 5) {
                finishWithAnimation();
            } else if (!(str.startsWith("http://") || str.startsWith("https://"))) {
                str = "http://" + str;
            }
            if (!(stringExtra == null || stringExtra.length() <= 2 || intent.getBooleanExtra("hideTitle", false))) {
                this.webTitle.setText(stringExtra);
            }
        } catch (Exception e) {
            finishWithAnimation();
        }
        this.webView.getSettings().setSupportMultipleWindows(false);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.addJavascriptInterface(new WebInterface(), "WebInterface");
        setZoomControlGone(this.webView);
        this.webView.loadUrl(str);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.webView.canGoBack()) {
                    this.webView.goBack();
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
