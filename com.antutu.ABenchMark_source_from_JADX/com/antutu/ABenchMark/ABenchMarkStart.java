package com.antutu.ABenchMark;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.sharesdk.framework.ShareSDK;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.p043g.C1502a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p043g.C1504c;
import com.antutu.benchmark.p047k.C1515a;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.platform.C1545a;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.benchmark.service.LocationService;
import com.antutu.redacc.C1692R;
import com.antutu.utils.ApkSearchUtils;
import com.antutu.utils.BackgroundApps;
import com.antutu.utils.BaiduADUtils;
import com.antutu.utils.CMCloudUtil;
import com.antutu.utils.FacebookADUtil;
import com.antutu.utils.GDTUtils;
import com.antutu.utils.GarbageCleaner;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.PushMessageUtil;
import com.antutu.utils.RealFullscreen;
import com.antutu.utils.Report;
import com.antutu.utils.Utils;
import com.antutu.utils.update.Update;
import com.igexin.sdk.PushManager;
import com.qq.p035e.ads.splash.SplashAD;
import com.qq.p035e.ads.splash.SplashADListener;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import org.android.spdy.SpdyProtocol;

public class ABenchMarkStart extends Activity {
    private GLSurfaceView f3631a;
    private boolean f3632b;
    private int f3633c;
    private ImageView f3634d;
    private ViewGroup f3635e;
    private SplashAD f3636f;
    private C1080a f3637g;
    private SplashADListener f3638h;

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.1 */
    class C10741 extends Thread {
        final /* synthetic */ ABenchMarkStart f3623a;

        C10741(ABenchMarkStart aBenchMarkStart) {
            this.f3623a = aBenchMarkStart;
        }

        public void run() {
            int i = 0;
            do {
                try {
                    if (!C1516b.m6013a()) {
                        break;
                    }
                    C10741.sleep(100);
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } while (i <= 10);
            C1504c.m5974a().m5975a(this.f3623a);
            C1516b.m6038l();
            C1503b.f5115c = true;
            this.f3623a.f3633c = this.f3623a.f3633c + 1;
            GarbageCleaner.getInstance(this.f3623a).getAppInfos();
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.2 */
    class C10752 extends Thread {
        final /* synthetic */ ABenchMarkStart f3624a;

        C10752(ABenchMarkStart aBenchMarkStart) {
            this.f3624a = aBenchMarkStart;
        }

        public void run() {
            try {
                C1545a.m6119b(ABenchmarkApplication.getContext());
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.3 */
    class C10763 extends Thread {
        final /* synthetic */ ABenchMarkStart f3625a;

        C10763(ABenchMarkStart aBenchMarkStart) {
            this.f3625a = aBenchMarkStart;
        }

        public void run() {
            try {
                C1503b.m5915c().m5930a(C1516b.m6022c(ABenchmarkApplication.getContext()));
                this.f3623a.f3633c = this.f3625a.f3633c + 1;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.4 */
    class C10774 extends Thread {
        final /* synthetic */ ABenchMarkStart f3626a;

        C10774(ABenchMarkStart aBenchMarkStart) {
            this.f3626a = aBenchMarkStart;
        }

        public void run() {
            try {
                if (!Methods.hasInstalled("com.antutu.benchmark.full")) {
                    C1503b.m5915c().m5929a(ApkSearchUtils.find3dPluginAPK(ABenchmarkApplication.getContext()));
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.5 */
    class C10785 extends Thread {
        final /* synthetic */ ABenchMarkStart f3627a;

        C10785(ABenchMarkStart aBenchMarkStart) {
            this.f3627a = aBenchMarkStart;
        }

        public void run() {
            int i = 0;
            while (i < 10) {
                try {
                    if (this.f3627a.f3633c >= 3) {
                        break;
                    }
                    C10785.sleep(1000);
                    i++;
                } catch (Exception e) {
                }
            }
            this.f3627a.f3637g.sendEmptyMessage(0);
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.6 */
    class C10796 implements SplashADListener {
        final /* synthetic */ ABenchMarkStart f3628a;

        C10796(ABenchMarkStart aBenchMarkStart) {
            this.f3628a = aBenchMarkStart;
        }

        public void onADClicked() {
            MLog.m6865d("hch", "onADClicked");
        }

        public void onADDismissed() {
            this.f3623a.f3633c = this.f3628a.f3633c + 1;
            MLog.m6865d("hch", "onADDismissed");
        }

        public void onADPresent() {
            MLog.m6865d("hch", "onADPresent");
            Methods.editSharedPreferences("shlash_ad_count", Methods.getSharedPreferencesLong("shlash_ad_count", 0) + 1);
        }

        public void onNoAD(int i) {
            this.f3623a.f3633c = this.f3628a.f3633c + 1;
            MLog.m6865d("hch", "onNoAD");
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.a */
    static class C1080a extends Handler {
        WeakReference<ABenchMarkStart> f3629a;

        C1080a(ABenchMarkStart aBenchMarkStart) {
            this.f3629a = new WeakReference(aBenchMarkStart);
        }

        public void handleMessage(Message message) {
            try {
                ((ABenchMarkStart) this.f3629a.get()).m4803b();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.ABenchMark.ABenchMarkStart.b */
    class C1081b implements Runnable {
        final /* synthetic */ ABenchMarkStart f3630a;

        C1081b(ABenchMarkStart aBenchMarkStart) {
            this.f3630a = aBenchMarkStart;
        }

        public void run() {
            if (!this.f3630a.f3632b) {
                this.f3630a.f3632b = true;
                try {
                    Update.CheckUpdate(this.f3630a.getApplicationContext(), false);
                } catch (Exception e) {
                }
                try {
                    CMCloudUtil.initCloudConfig(ABenchmarkApplication.getContext());
                    CMCloudUtil.initDmc(ABenchmarkApplication.getContext());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                boolean booleanExtra = this.f3630a.getIntent().getBooleanExtra(PushMessageUtil.ACTION_HAS_PUSH, false);
                Intent intent = new Intent(this.f3630a.getApplication(), MainActivity.class);
                if (booleanExtra) {
                    intent.putExtra(PushMessageUtil.ACTION_HAS_PUSH, booleanExtra);
                    int intExtra = this.f3630a.getIntent().getIntExtra(PushMessageUtil.ACTION_PUSH_PLATFORM, 0);
                    if (intExtra > 0) {
                        intent.putExtra(PushMessageUtil.ACTION_PUSH_PLATFORM, intExtra);
                        switch (intExtra) {
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                intent.putExtra(PushMessageUtil.ACTION_PUSH_MESSAGE, this.f3630a.getIntent().getStringExtra(PushMessageUtil.ACTION_PUSH_MESSAGE));
                                break;
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                intent.putExtra(PushMessageUtil.ACTION_PUSH_MESSAGE, this.f3630a.getIntent().getParcelableExtra(PushMessageUtil.ACTION_PUSH_MESSAGE));
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                                intent.putExtra(PushMessageUtil.ACTION_PUSH_MESSAGE, this.f3630a.getIntent().getSerializableExtra(PushMessageUtil.ACTION_PUSH_MESSAGE));
                                break;
                        }
                    }
                    return;
                }
                if (this.f3630a.getIntent().hasExtra("ACTION_OPEN_MENU")) {
                    intent.putExtra("ACTION_OPEN_MENU", this.f3630a.getIntent().getBooleanExtra("ACTION_OPEN_MENU", false));
                }
                if ("com.antutu.benchmark.UPDATE_ON_FINISHED".equals(this.f3630a.getIntent().getAction())) {
                    intent.setAction("com.antutu.benchmark.UPDATE_ON_FINISHED");
                }
                this.f3630a.startActivity(intent);
                this.f3630a.finish();
            }
        }
    }

    public ABenchMarkStart() {
        this.f3632b = false;
        this.f3633c = 0;
        this.f3637g = new C1080a(this);
        this.f3638h = new C10796(this);
    }

    private void m4799a(Context context) {
        context.startService(BenchmarkMainService.m6354c(context));
        if (C1502a.m5906a(context) <= 0) {
            InfocUtil.antutu_install(context, 1);
            C1502a.m5907a(context, 6030303);
        } else if (C1502a.m5906a(context) < 6030303) {
            InfocUtil.antutu_install(context, 2);
            C1502a.m5907a(context, 6030303);
        }
    }

    private boolean m4800a() {
        Date date = new Date(Methods.getSharedPreferencesLong("splash_ad_date", 0));
        long sharedPreferencesLong = Methods.getSharedPreferencesLong("shlash_ad_count", 0);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance.get(6) == instance2.get(6)) {
            return sharedPreferencesLong < 2;
        } else {
            Methods.editSharedPreferences("splash_ad_date", new Date().getTime());
            Methods.editSharedPreferences("shlash_ad_count", 0);
            return true;
        }
    }

    private void m4803b() {
        new Handler().postDelayed(new C1081b(this), 800);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RealFullscreen.setFullscreen(this);
        setContentView(C1082R.layout.splash);
        this.f3634d = (ImageView) findViewById(C1082R.id.splash_bg);
        this.f3635e = (ViewGroup) findViewById(C1082R.id.ad_container);
        if (!"CN".equals(Utils.getLocalLanguage(this))) {
            this.f3634d.setImageResource(C1082R.drawable.logo_en);
        }
        PointMark.getInstance(ABenchmarkApplication.getContext()).setKeyUrl("http://certinfo.antutu.net/i/api/member/secret");
        PointMark.getInstance(ABenchmarkApplication.getContext()).setUrl("http://certinfo.antutu.net/i/api/soft/activity");
        if (getResources().getConfiguration().orientation == 2) {
            if (((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
                setRequestedOrientation(8);
            } else {
                setRequestedOrientation(0);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(5);
        }
        C1503b.f5117e = false;
        C1503b.m5915c().m5951i(this);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (VERSION.SDK_INT < 17) {
                C1516b.m6018b(displayMetrics.densityDpi + BuildConfig.FLAVOR);
                C1516b.m6011a(displayMetrics.ydpi + BuildConfig.FLAVOR);
                C1516b.m6021c(displayMetrics.widthPixels + " x " + displayMetrics.heightPixels);
                C1516b.m6008a(displayMetrics.widthPixels);
                C1516b.m6016b(displayMetrics.heightPixels);
            } else {
                Utils.setScreenPix(displayMetrics, this);
            }
            this.f3631a = new GLSurfaceView(this);
            if (((ActivityManager) getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION) {
                this.f3631a.setEGLContextClientVersion(2);
                C1516b.m6012a(true);
            } else {
                C1516b.m6012a(false);
            }
            this.f3631a.setRenderer(new C1515a(this));
            this.f3631a.setRenderMode(0);
            this.f3631a.setLayoutParams(new LayoutParams(-1, -1));
            ((FrameLayout) findViewById(C1082R.id.frameLayout)).addView(this.f3631a);
            Report.report(getApplicationContext(), C1692R.xml.default_settings);
            m4799a((Context) this);
            InfocUtil.antutu_start(this, 1);
        } catch (Exception e) {
        }
        BackgroundApps.updateAppsListFile(getApplicationContext());
        this.f3633c = 0;
        try {
            C1503b.m5915c().m5937c(getIntent().getStringExtra("74Sd42l35nH"));
        } catch (Exception e2) {
        }
        new C10741(this).start();
        new C10752(this).start();
        new C10763(this).start();
        new C10774(this).start();
        boolean a = m4800a();
        if (Utils.getLocalLanguage(this).equals("CN") && a) {
            this.f3636f = new SplashAD(this, this.f3635e, "1105161001", "9030101943994946", this.f3638h);
        } else {
            this.f3633c++;
        }
        ShareSDK.initSDK(getApplicationContext());
        if (!Utils.getLocalLanguage(this).equals("CN") || C1503b.m5915c().m5954k() == 1) {
            FacebookADUtil.initAds(this);
        } else {
            GDTUtils.initAds(this);
            BaiduADUtils.initAds(this);
        }
        new C10785(this).start();
        startService(new Intent(BuildConfig.FLAVOR, null, getApplication(), LocationService.class));
        PushManager.getInstance().initialize(getApplicationContext());
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        super.onPause();
        this.f3631a.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f3631a.onResume();
    }
}
