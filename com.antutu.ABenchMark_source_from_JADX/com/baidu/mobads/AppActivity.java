package com.baidu.mobads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.antutu.utils.widget.SystemBarTintManager;
import com.baidu.mobads.command.C1924a;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.openad.p088c.C2012b;
import com.baidu.mobads.openad.p088c.C2014d;
import com.baidu.mobads.p080j.C1982d;
import com.baidu.mobads.p080j.C1989j;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p092g.C1939a;
import com.baidu.mobads.p092g.C1944d;
import com.baidu.mobads.vo.p104a.C2075c;
import com.umeng.message.MsgConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AppActivity extends Activity {
    protected static final int ACTIONBAR_VIEW_ID = 1001;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    private static int f6445F;
    private static ActionBarColorTheme f6446I;
    private static final String f6447o;
    private XAdLandingPageExtraInfo f6448A;
    private View f6449B;
    private final IXAdLogger f6450C;
    private IXAdCommonUtils f6451D;
    private boolean f6452E;
    private PageFinishedListener f6453G;
    private boolean f6454H;
    float f6455a;
    public Handler actionBarHandler;
    float f6456b;
    C1939a f6457c;
    public C2083z curWebview;
    RelativeLayout f6458d;
    int f6459e;
    int f6460f;
    int f6461g;
    int f6462h;
    int f6463i;
    int f6464j;
    String f6465k;
    String f6466l;
    View f6467m;
    protected C1944d mBottomView;
    protected boolean mBottomViewIsShowing;
    HandlerThread f6468n;
    private Handler f6469p;
    private int f6470q;
    private long f6471r;
    private String f6472s;
    private boolean f6473t;
    private int f6474u;
    private int f6475v;
    private int f6476w;
    private boolean f6477x;
    private boolean f6478y;
    private C2075c f6479z;

    public static class ActionBarColorTheme {
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME;
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME;
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME;
        private int f6617a;
        private int f6618b;
        private int f6619c;
        private int f6620d;

        static {
            ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
            ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
            ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
            ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
            ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
            ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
            ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        }

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.f6617a = i;
            this.f6618b = i2;
            this.f6619c = i3;
            this.f6620d = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.f6617a = actionBarColorTheme.f6617a;
            this.f6618b = actionBarColorTheme.f6618b;
            this.f6619c = actionBarColorTheme.f6619c;
            this.f6620d = actionBarColorTheme.f6620d;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.f6620d == actionBarColorTheme.f6620d && this.f6618b == actionBarColorTheme.f6618b && this.f6617a == actionBarColorTheme.f6617a && this.f6619c == actionBarColorTheme.f6619c;
        }

        public int getBackgroundColor() {
            return this.f6620d;
        }

        public int getCloseColor() {
            return this.f6617a;
        }

        public int getProgressColor() {
            return this.f6619c;
        }

        public int getTitleColor() {
            return this.f6618b;
        }

        public void setBackgroundColor(int i) {
            this.f6620d = i;
        }

        public void setCloseColor(int i) {
            this.f6617a = i;
        }

        public void setProgressColor(int i) {
            this.f6619c = i;
        }

        public void setTitleColor(int i) {
            this.f6618b = i;
        }
    }

    public interface PageFinishedListener {
        void onPageFinished(WebView webView);
    }

    /* renamed from: com.baidu.mobads.AppActivity.a */
    class C1904a extends View {
        final /* synthetic */ AppActivity f6621a;
        private Paint f6622b;
        private int f6623c;
        private int f6624d;

        public C1904a(AppActivity appActivity, Context context) {
            this.f6621a = appActivity;
            super(context);
            this.f6623c = 0;
            this.f6624d = 0;
            this.f6622b = new Paint();
            this.f6622b.setColor(AppActivity.f6446I.getProgressColor());
            this.f6624d = appActivity.f6451D.getScreenRect(appActivity.getApplicationContext()).width();
        }

        public void m7184a(int i) {
            if (i != this.f6623c) {
                this.f6623c = i;
                postInvalidate();
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (float) ((this.f6624d * this.f6623c) / 100), (float) getLayoutParams().height, this.f6622b);
        }
    }

    /* renamed from: com.baidu.mobads.AppActivity.b */
    class C1905b {
        boolean f6625a;
        String f6626b;
        boolean f6627c;
        boolean f6628d;
        final /* synthetic */ AppActivity f6629e;

        C1905b(AppActivity appActivity) {
            this.f6629e = appActivity;
            this.f6625a = false;
            this.f6626b = BuildConfig.FLAVOR;
            this.f6627c = false;
            this.f6628d = true;
        }
    }

    static {
        f6447o = AppActivity.class.getSimpleName();
        f6445F = 39;
        f6446I = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    }

    public AppActivity() {
        this.f6455a = 1.0f;
        this.f6456b = 1.0f;
        this.f6457c = null;
        this.f6469p = null;
        this.f6470q = 0;
        this.f6459e = 0;
        this.f6471r = 0;
        this.f6460f = 0;
        this.f6461g = -1;
        this.f6462h = 0;
        this.f6463i = 0;
        this.f6473t = false;
        this.f6474u = 1;
        this.f6475v = 0;
        this.f6476w = -1;
        this.f6477x = false;
        this.f6478y = false;
        this.f6464j = 1;
        this.f6465k = "barC";
        this.f6466l = BuildConfig.FLAVOR;
        this.f6450C = C1991m.m7449a().m7457f();
        this.f6452E = true;
        this.f6467m = null;
        this.mBottomViewIsShowing = false;
        this.f6468n = new HandlerThread("handler_thread");
        this.f6454H = true;
    }

    @TargetApi(3)
    private RelativeLayout m7124a(String str) {
        View c1904a = new C1904a(this, this);
        this.curWebview = new C2083z(this, true, true);
        C1905b c1905b = new C1905b(this);
        this.curWebview.f7328a = str;
        this.curWebview.getSettings().setUseWideViewPort(true);
        this.curWebview.getSettings().setBuiltInZoomControls(true);
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE}).invoke(this.curWebview.getSettings(), new Object[]{Boolean.valueOf(false)});
        } catch (Exception e) {
            this.f6450C.m7393d(f6447o, e.getMessage());
        }
        this.curWebview.setWebChromeClient(new C1930d(this, c1904a));
        this.curWebview.setOnTouchListener(new C1978i(this));
        this.curWebview.setWebViewClient(new C1998j(this, c1905b));
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f6467m = m7142d();
        relativeLayout.addView(this.f6467m);
        relativeLayout.addView(this.curWebview, new LayoutParams(-1, -1));
        relativeLayout.addView(c1904a, new LayoutParams(-1, this.f6451D.getPixel(getApplicationContext(), 2)));
        return relativeLayout;
    }

    @TargetApi(12)
    private void m7127a(View view) {
        try {
            view.animate().setDuration(700);
            view.setTranslationX((float) view.getWidth());
            view.animate().setDuration(700).translationX(0.0f);
        } catch (Throwable e) {
            this.f6450C.m7399e(e);
        }
    }

    private void m7128a(WebView webView, String str, Runnable runnable, Runnable runnable2) {
        try {
            C1982d m = C1991m.m7449a().m7464m();
            if (this.f6452E ? C2083z.m7777a(str) : C2083z.m7779b(str)) {
                Intent intent;
                if (C2083z.m7787i(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "audio/*");
                    webView.getContext().startActivity(intent);
                } else if (C2083z.m7786h(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "video/*");
                    webView.getContext().startActivity(intent);
                } else {
                    m.browserOutside(webView.getContext(), str);
                }
                if (runnable != null) {
                    runnable.run();
                }
            } else if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Exception e) {
            this.f6450C.m7393d(f6447o, e.getMessage());
        }
    }

    private void m7129a(WebView webView, String str, boolean z, String str2) {
        if (webView != null) {
            C1982d m = C1991m.m7449a().m7464m();
            if (this.f6478y) {
                this.f6460f++;
                this.f6479z.f7287r.decrementAndGet();
                this.f6478y = false;
            }
            if (z && str2.equals("ignore")) {
                try {
                    this.curWebview.loadUrl(str);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            try {
                Map hashMap = new HashMap();
                if (str2.equals("ignore")) {
                    hashMap.put(HttpRequest.f14567t, "http://mobads.baidu.com/" + m.getAppPackage(this));
                } else {
                    hashMap.put(HttpRequest.f14567t, str2);
                }
                this.curWebview.getClass().getMethod("loadUrl", new Class[]{String.class, Map.class}).invoke(this.curWebview, new Object[]{str, hashMap});
            } catch (Exception e2) {
                try {
                    this.curWebview.loadUrl(str);
                } catch (Exception e3) {
                    this.f6450C.m7393d(f6447o, e2.getMessage());
                }
            }
        }
    }

    private void m7135b(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable e) {
                this.f6450C.m7399e(e);
            }
        }
    }

    private void m7138b(String str) {
        this.f6458d = new RelativeLayout(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, C1991m.m7449a().m7464m().getPixel(this, 46));
        layoutParams.addRule(10);
        this.f6457c.setId(ACTIONBAR_VIEW_ID);
        this.f6458d.addView(this.f6457c, layoutParams);
        View a = m7124a(str);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(3, ACTIONBAR_VIEW_ID);
        this.f6458d.addView(a, layoutParams2);
        if (this.f6473t && canSupportAnimate()) {
            this.f6458d.getViewTreeObserver().addOnPreDrawListener(new C2027p(this));
        }
    }

    private View m7142d() {
        View abVar = new ab(this);
        int pixel = C1991m.m7449a().m7464m().getPixel(this, 38);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, pixel);
        layoutParams.addRule(13);
        abVar.setLayoutParams(layoutParams);
        return abVar;
    }

    private void m7144e() {
        m7147f();
        initBottomView();
        this.f6458d.addView(this.f6449B);
        this.f6458d.addView(this.mBottomView);
        if (canSupportAnimate()) {
            this.mBottomView.getViewTreeObserver().addOnPreDrawListener(new C2068r(this));
        }
    }

    @TargetApi(11)
    private void m7147f() {
        this.f6449B = new View(this);
        this.f6449B.setOnClickListener(new C2069s(this));
        if (canSupportAnimate()) {
            this.f6449B.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
            this.f6449B.setAlpha(0.0f);
        }
        this.f6449B.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    private void m7149g() {
        if (this.curWebview != null) {
            this.curWebview.reload();
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return f6446I;
    }

    @TargetApi(16)
    private void m7151h() {
        if (canSupportAnimate()) {
            try {
                View view = this.f6458d;
                if (this.f6473t) {
                    view.setTranslationX(0.0f);
                    ViewPropertyAnimator translationX = view.animate().setDuration(300).translationX((float) view.getWidth());
                    if (VERSION.SDK_INT >= 16) {
                        translationX.withEndAction(new C1934f(this));
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new C1948g(this), 300);
                        return;
                    }
                }
                finish();
                return;
            } catch (Throwable e) {
                this.f6450C.m7399e(e);
                return;
            }
        }
        finish();
    }

    private void m7153i() {
        if (this.f6467m != null) {
            m7135b(this.f6467m);
            this.f6467m = null;
        }
    }

    private int m7154j() {
        try {
            Method method = Context.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(this, new Object[0])).intValue();
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
            return -1;
        }
    }

    private boolean m7157k() {
        try {
            return 16973840 == m7154j();
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
            return false;
        }
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            f6446I = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    protected boolean canSupportAnimate() {
        try {
            return VERSION.SDK_INT >= 12;
        } catch (Throwable e) {
            C1989j.m7430a().m7439e(e);
            return false;
        }
    }

    @TargetApi(11)
    protected void copyCurrentPageUrl() {
        if (VERSION.SDK_INT < 11) {
            Toast.makeText(this, "\u7cfb\u7edf\u7248\u672c\u4e0d\u652f\u6301", 0).show();
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.curWebview.getUrl())) {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("\u7f51\u9875\u94fe\u63a5", this.curWebview.getUrl()));
                Toast.makeText(this, "\u5df2\u590d\u5236\u5230\u526a\u5207\u677f", 0).show();
            }
        } catch (Throwable e) {
            this.f6450C.m7399e(e);
        }
    }

    protected void initActionBar() {
        this.f6457c = new C1939a(this, f6446I);
        this.f6457c.setId(ACTIONBAR_VIEW_ID);
        this.f6457c.m7280a(new C2067q(this));
    }

    @TargetApi(11)
    protected void initBottomView() {
        this.mBottomView = new C1944d(this);
        this.mBottomView.m7288a(new C2070t(this));
        if (canSupportAnimate()) {
            this.mBottomView.setAlpha(0.0f);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mBottomView.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6473t = m7157k();
        this.f6451D = C1991m.m7449a().m7464m();
        Intent intent = getIntent();
        String stringExtra;
        if (intent.getBooleanExtra("dealWithDownload", false)) {
            try {
                int intExtra = intent.getIntExtra(MsgConstant.KEY_STATUS, -1);
                String stringExtra2 = intent.getStringExtra(IXAdRequestInfo.PACKAGE);
                IOAdDownloader adsApkDownloader = C2014d.m7517a(getApplicationContext()).getAdsApkDownloader(stringExtra2);
                this.f6450C.m7393d(f6447o, "dealWithDownload now: status=" + intExtra + ";pk=" + stringExtra2 + ";downloader=" + adsApkDownloader);
                if (intExtra == DownloadStatus.COMPLETED.getCode()) {
                    stringExtra = intent.getStringExtra("localApkPath");
                    if (C1991m.m7449a().m7463l().isInstalled(this, stringExtra2)) {
                        C1991m.m7449a().m7463l().openApp(this, stringExtra2);
                    } else {
                        File file = new File(stringExtra);
                        if (!file.exists() || file.length() <= 0) {
                            this.f6450C.m7402i(f6447o, "\u6587\u4ef6[" + stringExtra + "] \u5df2\u7ecf\u88ab\u5220\u9664");
                        } else {
                            startActivity(C1991m.m7449a().m7463l().getInstallIntent(stringExtra));
                        }
                    }
                } else if (intExtra == DownloadStatus.ERROR.getCode() || intExtra == DownloadStatus.PAUSED.getCode()) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0) {
                        C2012b a = C2012b.m7506a(stringExtra2);
                        if (a != null) {
                            C1924a a2 = a.m7515a();
                            if (a2 != null) {
                                a2.f6747r = true;
                            }
                        }
                    }
                    if (adsApkDownloader != null) {
                        adsApkDownloader.resume();
                    }
                }
            } catch (Throwable e) {
                this.f6450C.m7394d(f6447o, e);
            }
            finish();
            return;
        }
        this.f6452E = intent.getBooleanExtra("canOpenAppForAPO", this.f6452E);
        C1982d m = C1991m.m7449a().m7464m();
        this.f6448A = (XAdLandingPageExtraInfo) getIntent().getParcelableExtra(EXTRA_DATA);
        this.f6479z = new C2075c(this.f6448A);
        Rect windowRect = m.getWindowRect(this);
        this.f6456b = (float) ((((double) windowRect.width()) * 1.0d) / 640.0d);
        this.f6455a = (float) ((((double) windowRect.height()) * 1.0d) / 960.0d);
        requestWindowFeature(1);
        this.f6472s = this.f6448A.title;
        if (this.f6448A.orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        this.f6471r = System.currentTimeMillis();
        try {
            if (this.f6448A.isFullScreen) {
                getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
            }
        } catch (Exception e2) {
            this.f6450C.m7393d(f6447o, "exception when getIntent");
        }
        this.f6459e = this.f6448A.from;
        stringExtra = this.f6448A.url;
        if (C2083z.m7777a(stringExtra)) {
            this.f6450C.m7393d(f6447o, "AppActivity.browser external");
            Intent intent2;
            if (C2083z.m7787i(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "audio/*");
                startActivity(intent2);
            } else if (C2083z.m7786h(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "video/*");
                startActivity(intent2);
            } else {
                m.browserOutside(this, stringExtra);
            }
            finish();
            return;
        }
        this.f6469p = startUrlHandler(this);
        initActionBar();
        m7138b(stringExtra);
        m7129a(this.curWebview, stringExtra, false, "http://mobads.baidu.com/" + m.getAppPackage(this));
        this.f6458d.setBackgroundColor(-1);
        setContentView(this.f6458d);
    }

    public void onDestroy() {
        int i = 0;
        super.onDestroy();
        if (this.f6469p != null) {
            this.f6479z.f7283n = this.f6465k;
            C2075c c2075c = this.f6479z;
            int i2 = this.f6470q;
            this.f6470q = i2 + 1;
            c2075c.f7284o = i2;
            this.f6479z.f7285p = this.curWebview != null ? this.curWebview.getContentHeight() : 0;
            c2075c = this.f6479z;
            if (this.curWebview != null) {
                i = this.curWebview.getProgress();
            }
            c2075c.f7286q = i;
            this.f6479z.f7288s = this.f6460f;
            this.f6479z.f7289t = this.f6461g;
            this.f6479z.f7290u = System.currentTimeMillis() - this.f6471r;
            this.f6479z.f7291v = this.f6474u;
            this.f6479z.f7292w = this.f6475v;
            this.f6479z.f7293x = this.f6459e;
            this.f6479z.f7294y = this.f6464j;
            Message obtain = Message.obtain();
            obtain.what = f6445F;
            obtain.obj = this.f6479z;
            this.f6469p.sendMessage(obtain);
            try {
                this.curWebview.setVisibility(8);
                this.f6450C.m7393d(f6447o, "onDestroy");
                this.curWebview.stopLoading();
                this.curWebview.destroy();
            } catch (Exception e) {
                this.f6450C.m7393d(f6447o, e.getMessage());
            }
        }
        m7153i();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.mBottomViewIsShowing) {
                    runBottomViewExitAnimation(this.f6449B, this.mBottomView);
                } else if (this.curWebview.canGoBack()) {
                    this.curWebview.goBack();
                } else {
                    this.f6465k = "backC";
                    m7151h();
                }
                C2075c c2075c = this.f6479z;
                c2075c.f7281G++;
                return true;
            } catch (Exception e) {
                this.f6450C.m7393d(f6447o, e.getMessage());
            }
        } else {
            if (i == 46) {
                this.curWebview.reload();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f6454H) {
            this.f6454H = false;
            return;
        }
        C2075c c2075c = this.f6479z;
        c2075c.f7282H++;
    }

    @TargetApi(12)
    protected void runBottomViewEnterAnimation(View view, View view2) {
        this.mBottomViewIsShowing = true;
        try {
            view.animate().setDuration(500).alpha(0.5f);
            view2.setTranslationY((float) view2.getHeight());
            view2.animate().setDuration(500).alpha(1.0f).translationY(0.0f);
        } catch (Throwable e) {
            this.f6450C.m7399e(e);
        }
    }

    @TargetApi(16)
    protected void runBottomViewExitAnimation(View view, View view2) {
        this.mBottomViewIsShowing = false;
        if (canSupportAnimate()) {
            try {
                view.clearAnimation();
                view.animate().setDuration(250).alpha(0.0f);
                view2.setTranslationY(0.0f);
                ViewPropertyAnimator translationY = view2.animate().setDuration(250).alpha(0.0f).translationY((float) view2.getHeight());
                if (VERSION.SDK_INT >= 16) {
                    translationY.withEndAction(new C2071u(this, view2, view));
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new C1932e(this, view2, view), 250);
                    return;
                }
            } catch (Throwable e) {
                this.f6450C.m7399e(e);
                return;
            }
        }
        m7135b(view2);
        m7135b(view);
    }

    public void setPageFinishedListener(PageFinishedListener pageFinishedListener) {
        this.f6453G = pageFinishedListener;
    }

    public Handler startUrlHandler(Context context) {
        this.f6468n.start();
        return new C1973h(this, this.f6468n.getLooper());
    }
}
