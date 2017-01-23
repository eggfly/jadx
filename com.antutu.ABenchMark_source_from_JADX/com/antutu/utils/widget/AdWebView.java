package com.antutu.utils.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import org.android.spdy.TnetStatusCode;

public class AdWebView extends ViewGroup {
    private final String TAG_OEMID;
    private final String TAG_SAID;
    private final String TAG_SETTING;
    private final int TYPE_WIFI;
    private final int TYPE_WIMAX;
    private Handler adHandler;
    private String adInfo;
    private UpdateADRunner adRunner;
    private String adURL;
    private boolean bInitAd;
    private boolean bUpdate;
    private boolean canOverload;
    private float density;
    private UIHandler handler;
    private boolean overload;
    Runnable rweb;
    private int tryTime;
    private UpdateAdThread updateAdThread;
    private UpdateHandler updateHandler;
    private boolean urlError;
    private WebView webView;
    private URL xmlUrl;

    /* renamed from: com.antutu.utils.widget.AdWebView.1 */
    class C18331 implements Runnable {
        C18331() {
        }

        public void run() {
            int contentHeight = AdWebView.this.webView.getContentHeight();
            AdWebView.access$206(AdWebView.this);
            if (contentHeight > 1) {
                LayoutParams layoutParams = AdWebView.this.getLayoutParams();
                layoutParams.height = (int) (((float) contentHeight) * AdWebView.this.density);
                AdWebView.this.setLayoutParams(layoutParams);
            } else if (AdWebView.this.tryTime > 0) {
                AdWebView.this.handler.postDelayed(AdWebView.this.rweb, 300);
            }
        }
    }

    /* renamed from: com.antutu.utils.widget.AdWebView.2 */
    class C18352 extends WebChromeClient {
        final /* synthetic */ Context val$context;

        /* renamed from: com.antutu.utils.widget.AdWebView.2.1 */
        class C18341 extends WebViewClient {
            C18341() {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                try {
                    WebBrowserActivity.openURL(C18352.this.val$context, str, BuildConfig.FLAVOR);
                } catch (Exception e) {
                }
                webView.stopLoading();
                super.onPageStarted(webView, str, bitmap);
            }
        }

        C18352(Context context) {
            this.val$context = context;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            try {
                WebView webView2 = new WebView(webView.getContext());
                ((WebViewTransport) message.obj).setWebView(webView2);
                webView2.setWebViewClient(new C18341());
                message.sendToTarget();
                return true;
            } catch (Exception e) {
                return super.onCreateWindow(webView, z, z2, message);
            }
        }
    }

    /* renamed from: com.antutu.utils.widget.AdWebView.3 */
    class C18363 extends WebViewClient {
        final /* synthetic */ Context val$context;

        C18363(Context context) {
            this.val$context = context;
        }

        public void onPageFinished(WebView webView, String str) {
            try {
                if (AdWebView.this.canOverload) {
                    AdWebView.this.overload = true;
                }
                if (!AdWebView.this.urlError) {
                    AdWebView.this.handler.sendEmptyMessage(0);
                }
            } catch (Exception e) {
            }
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (AdWebView.this.overload) {
                try {
                    WebBrowserActivity.openURL(this.val$context, str, BuildConfig.FLAVOR);
                    webView.stopLoading();
                } catch (Exception e) {
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (i == -2 || i == -14) {
                AdWebView.this.urlError = true;
            }
            super.onReceivedError(webView, i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.val$context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return true;
                }
            } catch (Exception e) {
            }
            try {
                WebBrowserActivity.openURL(this.val$context, str, BuildConfig.FLAVOR);
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    static class UIHandler extends Handler {
        WeakReference<AdWebView> mActivity;

        UIHandler(AdWebView adWebView) {
            this.mActivity = new WeakReference(adWebView);
        }

        public void handleMessage(Message message) {
            try {
                ((AdWebView) this.mActivity.get()).onUIHander(message.what);
            } catch (Exception e) {
            }
        }
    }

    private class UpdateADRunner implements Runnable {
        private UpdateADRunner() {
        }

        public void run() {
            try {
                if (AdWebView.this.xmlUrl == null) {
                    AdWebView.this.bUpdate = false;
                } else if (AdWebView.this.updateAdThread == null) {
                    AdWebView.this.updateAdThread = new UpdateAdThread(null);
                    AdWebView.this.updateAdThread.start();
                } else {
                    AdWebView.this.bUpdate = false;
                }
            } catch (Exception e) {
            }
        }
    }

    private class UpdateAdThread extends Thread {
        private UpdateAdThread() {
        }

        public void run() {
            try {
                int i;
                char[] cArr = new char[com.taobao.accs.data.Message.FLAG_RET];
                String[] split = new String(cArr).substring(0, new InputStreamReader(AdWebView.this.xmlUrl.openConnection().getInputStream()).read(cArr)).trim().split("\\|\\*\\|");
                if (split.length >= 3) {
                    if (!AdWebView.this.adInfo.equals(split[0])) {
                        AdWebView.this.adInfo = split[0];
                    }
                    if (AdWebView.this.adURL.equals(split[1])) {
                        i = 0;
                    } else {
                        AdWebView.this.adURL = split[1];
                        AdWebView.this.updateHandler.sendEmptyMessage(0);
                        try {
                            i = Integer.valueOf(split[2]).intValue();
                        } catch (Exception e) {
                            i = 0;
                        }
                    }
                    AdWebView.this.bInitAd = true;
                } else {
                    i = 0;
                }
                if (i > 0) {
                    AdWebView.this.adHandler.postDelayed(AdWebView.this.adRunner, (long) (i * 3600000));
                }
            } catch (Exception e2) {
            }
            AdWebView.this.updateAdThread = null;
            AdWebView.this.bUpdate = false;
        }
    }

    static class UpdateHandler extends Handler {
        WeakReference<AdWebView> mThis;

        UpdateHandler(AdWebView adWebView) {
            this.mThis = new WeakReference(adWebView);
        }

        public void handleMessage(Message message) {
            try {
                ((AdWebView) this.mThis.get()).onHandlerUpdate(message.what);
            } catch (Exception e) {
            }
        }
    }

    private AdWebView(Context context) {
        super(context);
        this.overload = false;
        this.canOverload = false;
        this.xmlUrl = null;
        this.adInfo = BuildConfig.FLAVOR;
        this.adURL = BuildConfig.FLAVOR;
        this.bInitAd = false;
        this.bUpdate = false;
        this.adHandler = null;
        this.adRunner = null;
        this.updateAdThread = null;
        this.webView = null;
        this.tryTime = 0;
        this.density = 0.0f;
        this.TYPE_WIMAX = 6;
        this.TYPE_WIFI = 1;
        this.TAG_SETTING = "setting";
        this.TAG_OEMID = "oemid";
        this.TAG_SAID = "softid";
        this.urlError = false;
        this.rweb = new C18331();
        this.handler = new UIHandler(this);
        this.updateHandler = new UpdateHandler(this);
    }

    public AdWebView(Context context, String str, int i) {
        super(context);
        this.overload = false;
        this.canOverload = false;
        this.xmlUrl = null;
        this.adInfo = BuildConfig.FLAVOR;
        this.adURL = BuildConfig.FLAVOR;
        this.bInitAd = false;
        this.bUpdate = false;
        this.adHandler = null;
        this.adRunner = null;
        this.updateAdThread = null;
        this.webView = null;
        this.tryTime = 0;
        this.density = 0.0f;
        this.TYPE_WIMAX = 6;
        this.TYPE_WIFI = 1;
        this.TAG_SETTING = "setting";
        this.TAG_OEMID = "oemid";
        this.TAG_SAID = "softid";
        this.urlError = false;
        this.rweb = new C18331();
        this.handler = new UIHandler(this);
        this.updateHandler = new UpdateHandler(this);
        try {
            int i2;
            String attributeValue;
            String str2 = BuildConfig.FLAVOR;
            String str3 = BuildConfig.FLAVOR;
            XmlResourceParser xml = getResources().getXml(i);
            int i3 = 0;
            while (true) {
                int next = xml.next();
                if (next == 2) {
                    if (xml.getName().equals("setting")) {
                        int attributeCount = xml.getAttributeCount();
                        i2 = 0;
                        while (i2 < attributeCount) {
                            String attributeName = xml.getAttributeName(i2);
                            attributeValue = xml.getAttributeValue(i2);
                            if (attributeName.equals("oemid")) {
                                i3 = Integer.valueOf(attributeValue).intValue();
                                str3 = str2;
                            } else if (attributeName.equals("softid")) {
                                String str4 = str3;
                                str3 = attributeValue;
                                attributeValue = str4;
                            } else {
                                attributeValue = str3;
                                str3 = str2;
                            }
                            i2++;
                            str2 = str3;
                            str3 = attributeValue;
                        }
                    }
                } else if (next == 1) {
                    break;
                }
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i4 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels - ((displayMetrics.densityDpi * 60) / 160);
            this.density = displayMetrics.density;
            attributeValue = getResources().getConfiguration().locale.getLanguage();
            if (attributeValue == null) {
                attributeValue = "en";
            } else if (attributeValue.equals("zh")) {
                attributeValue = attributeValue + "_" + getResources().getConfiguration().locale.getCountry();
            }
            String str5 = ("http://info.antutu." + (i3 > 100 ? "net" : "com") + "/info/info.php?gpv=") + jni.getDataSafe(((((((("softid=" + str2 + "&oem=" + str3 + "&lan=" + attributeValue) + "&softaid=" + str + "&w=" + i4 + "&h=" + i2) + "&imei=" + C1503b.m5915c().m5925a(context, false)) + "&model=" + URLEncoder.encode(Build.MODEL, HttpRequest.f14548a)) + "&device=" + URLEncoder.encode(Build.DEVICE, HttpRequest.f14548a)) + "&brand=" + URLEncoder.encode(Build.BRAND, HttpRequest.f14548a)) + "&product=" + URLEncoder.encode(Build.PRODUCT, HttpRequest.f14548a)) + "&adversion=" + Utils.getAdVersion(context) + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            this.overload = false;
            this.xmlUrl = new URL(str5);
            setBackgroundColor(0);
            setLayoutParams(new LayoutParams(-1, -2));
            setVisibility(8);
            updateAd(context, str);
        } catch (Exception e) {
        }
    }

    static /* synthetic */ int access$206(AdWebView adWebView) {
        int i = adWebView.tryTime - 1;
        adWebView.tryTime = i;
        return i;
    }

    private void loadURI() {
        loadWebView(this.adURL);
    }

    private void loadWebView(String str) {
        if (this.webView == null) {
            Context context = getContext();
            this.urlError = false;
            this.webView = new WebView(context);
            this.webView.setWebChromeClient(new C18352(context));
            this.webView.setWebViewClient(new C18363(context));
            this.webView.setFocusable(false);
            this.webView.setBackgroundColor(0);
            this.webView.getSettings().setSupportMultipleWindows(true);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setHorizontalScrollBarEnabled(false);
            this.webView.setVerticalScrollBarEnabled(false);
            this.webView.setScrollBarStyle(33554432);
            addView(this.webView);
        }
        this.webView.loadUrl(str);
    }

    private void onHandlerUpdate(int i) {
        if (i == 0) {
            try {
                loadURI();
            } catch (Exception e) {
            }
        }
    }

    private void onUIHander(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                try {
                    LayoutParams layoutParams = getLayoutParams();
                    layoutParams.height = 1;
                    setLayoutParams(layoutParams);
                    setVisibility(0);
                    this.tryTime = 5;
                    this.handler.postDelayed(this.rweb, 300);
                } catch (Exception e) {
                }
            default:
        }
    }

    private void updateAd(Context context, String str) {
        int type;
        if (!this.bUpdate) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo.isConnected()) {
                    type = activeNetworkInfo.getType();
                    try {
                        if (this.bInitAd && r0 != 1 && r0 != 6) {
                            return;
                        }
                        if (str.startsWith("http://")) {
                            loadWebView(str);
                            return;
                        }
                        this.bUpdate = true;
                        this.adRunner = new UpdateADRunner();
                        this.adHandler = new Handler();
                        this.adHandler.post(this.adRunner);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                type = 0;
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            getChildAt(0).layout(i, i2, i3, i4);
        }
    }
}
