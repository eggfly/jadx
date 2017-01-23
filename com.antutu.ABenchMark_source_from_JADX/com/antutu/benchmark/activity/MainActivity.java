package com.antutu.benchmark.activity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.ABenchMarkStart;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.TrackService;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1521a;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1538p;
import com.antutu.benchmark.modelreflact.CommentNotRedResponseModel.DataBean;
import com.antutu.benchmark.modelreflact.PhoneNotiModel;
import com.antutu.benchmark.modelreflact.WxMainModel;
import com.antutu.benchmark.p036a.C1177t;
import com.antutu.benchmark.p036a.C1177t.C1175a;
import com.antutu.benchmark.p036a.C1183u;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.p040c.C1360b;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.p042e.C1493m;
import com.antutu.benchmark.p042e.C1496n;
import com.antutu.benchmark.p043g.C1502a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.GarbageCleaner;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.NetUtils;
import com.antutu.utils.PointMark;
import com.antutu.utils.PushMessageUtil;
import com.antutu.utils.SPConstants;
import com.antutu.utils.ShareUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.antutu.utils.widget.SystemBarTintManager;
import com.antutu.utils.widget.WebBrowserActivity;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.facebook.ads.AdError;
import com.igexin.download.Downloads;
import com.igexin.sdk.PushManager;
import com.p063b.p064a.C1855c;
import com.p063b.p064a.C1864i;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.MobclickAgent.EScenarioType;
import com.umeng.analytics.MobclickAgent.UMAnalyticsConfig;
import com.umeng.message.IUmengCallback;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.C4209a;
import com.umeng.message.entity.UMessage;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

public class MainActivity extends FragmentActivity implements OnClickListener {
    private static C1269d f4301b;
    private TextView f4302A;
    private String f4303B;
    private boolean f4304C;
    private boolean f4305D;
    private boolean f4306E;
    private C1538p f4307F;
    private C1538p f4308G;
    private C1538p f4309H;
    private C1175a f4310I;
    @SuppressLint({"HandlerLeak"})
    private Handler f4311J;
    private OnClickListener f4312K;
    boolean f4313a;
    private C1493m f4314c;
    private CommonTitleView f4315d;
    private BroadcastReceiver f4316e;
    private BroadcastReceiver f4317f;
    private BroadcastReceiver f4318g;
    private int f4319h;
    private boolean f4320i;
    private C1268b f4321j;
    private Map<String, List<C1518a>> f4322k;
    private C1267a f4323l;
    private DrawerLayout f4324m;
    private RelativeLayout f4325n;
    private ListView f4326o;
    private List<C1538p> f4327p;
    private LinearLayout f4328q;
    private PopupWindow f4329r;
    private SharedPreferences f4330s;
    private C1183u f4331t;
    private C1360b f4332u;
    private C1353a f4333v;
    private C1371d f4334w;
    private C1177t f4335x;
    private LinearLayout f4336y;
    private TextView f4337z;

    /* renamed from: com.antutu.benchmark.activity.MainActivity.14 */
    class AnonymousClass14 extends Thread {
        final /* synthetic */ String f4271a;
        final /* synthetic */ MainActivity f4272b;

        AnonymousClass14(MainActivity mainActivity, String str) {
            this.f4272b = mainActivity;
            this.f4271a = str;
        }

        public void run() {
            boolean z = false;
            String str = BuildConfig.FLAVOR;
            try {
                ApplicationInfo applicationInfo = this.f4272b.getPackageManager().getApplicationInfo(this.f4271a, SpdyProtocol.SLIGHTSSLV2);
                if (applicationInfo != null) {
                    int checkAPK = jni.checkAPK(applicationInfo.sourceDir);
                    MLog.m6865d("MainActivity", "hzd, checkTester, result=" + checkAPK);
                    C1503b c = C1503b.m5915c();
                    if (checkAPK == 0) {
                        z = true;
                    }
                    c.m5938c(z);
                }
            } catch (Exception e) {
                C1503b.m5915c().m5938c(false);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.1 */
    class C12541 implements C1095a<PhoneNotiModel> {
        final /* synthetic */ MainActivity f4280a;

        C12541(MainActivity mainActivity) {
            this.f4280a = mainActivity;
        }

        public void m5122a(PhoneNotiModel phoneNotiModel) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NotificationManager notificationManager = (NotificationManager) this.f4280a.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            Builder builder = new Builder(this.f4280a);
            builder.setContentTitle(phoneNotiModel.getTitle()).setContentText(phoneNotiModel.getSubtitle()).setTicker(phoneNotiModel.getTitle()).setWhen(System.currentTimeMillis()).setDefaults(2).setSmallIcon(C1082R.drawable.app_icon);
            Notification build = builder.build();
            build.flags = 16;
            Intent intent = new Intent();
            intent.putExtra("url", phoneNotiModel.getUrl()).putExtra(Downloads.COLUMN_TITLE, phoneNotiModel.getTitle()).putExtra("shareable", true).putExtra("hideTitle", true).putExtra("shareable", false).setFlags(335544320);
            intent.setClass(this.f4280a, WebBrowserActivity.class);
            build.contentIntent = PendingIntent.getActivity(this.f4280a, 1, intent, 1073741824);
            notificationManager.notify(AdError.NETWORK_ERROR_CODE, build);
        }

        public void m5124a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.c */
    public interface C1255c {
        void m5128a();
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.2 */
    class C12562 implements IUmengCallback {
        final /* synthetic */ MainActivity f4286a;

        C12562(MainActivity mainActivity) {
            this.f4286a = mainActivity;
        }

        public void onFailure(String str, String str2) {
            MLog.m6865d("PushAgent", "disable() onFailure!!");
            Log.e("PushAgent", String.valueOf(str));
            Log.e("PushAgent", String.valueOf(str2));
        }

        public void onSuccess() {
            MLog.m6865d("PushAgent", "disable() onSuccess!!");
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.3 */
    class C12593 implements OnCheckedChangeListener {
        final /* synthetic */ MainActivity f4289a;

        /* renamed from: com.antutu.benchmark.activity.MainActivity.3.1 */
        class C12571 implements IUmengCallback {
            final /* synthetic */ C12593 f4287a;

            C12571(C12593 c12593) {
                this.f4287a = c12593;
            }

            public void onFailure(String str, String str2) {
                MLog.m6865d("PushAgent", "enable() onFailure!!");
                Log.e("PushAgent", String.valueOf(str));
                Log.e("PushAgent", String.valueOf(str2));
            }

            public void onSuccess() {
                MLog.m6865d("PushAgent", "enable() onSuccess!!");
            }
        }

        /* renamed from: com.antutu.benchmark.activity.MainActivity.3.2 */
        class C12582 implements IUmengCallback {
            final /* synthetic */ C12593 f4288a;

            C12582(C12593 c12593) {
                this.f4288a = c12593;
            }

            public void onFailure(String str, String str2) {
                MLog.m6865d("PushAgent", "disable() onFailure!!");
                Log.e("PushAgent", String.valueOf(str));
                Log.e("PushAgent", String.valueOf(str2));
            }

            public void onSuccess() {
                MLog.m6865d("PushAgent", "disable() onSuccess!!");
            }
        }

        C12593(MainActivity mainActivity) {
            this.f4289a = mainActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4289a.f4304C = z;
            if (this.f4289a.f4304C) {
                PushAgent.getInstance(compoundButton.getContext()).enable(new C12571(this));
                PushManager.getInstance().initialize(compoundButton.getContext());
                MiPushClient.resumePush(this.f4289a, null);
                MobclickAgent.onEvent(compoundButton.getContext(), MobclickAgentConstants.click_push_open);
            } else {
                PushAgent.getInstance(compoundButton.getContext()).disable(new C12582(this));
                PushManager.getInstance().stopService(compoundButton.getContext());
                MiPushClient.pausePush(this.f4289a, null);
                MobclickAgent.onEvent(compoundButton.getContext(), MobclickAgentConstants.click_push_close);
            }
            Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, this.f4289a.f4304C);
            if (this.f4289a.f4307F != null) {
                this.f4289a.f4307F.m6090a(z);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.4 */
    class C12604 implements OnCheckedChangeListener {
        final /* synthetic */ MainActivity f4290a;

        C12604(MainActivity mainActivity) {
            this.f4290a = mainActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4290a.f4305D = z;
            Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_AUTO_UPDATE, this.f4290a.f4305D);
            if (this.f4290a.f4308G != null) {
                this.f4290a.f4308G.m6090a(z);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.5 */
    class C12615 implements OnCheckedChangeListener {
        final /* synthetic */ MainActivity f4291a;

        C12615(MainActivity mainActivity) {
            this.f4291a = mainActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4291a.f4306E = z;
            C1502a.m5908a(this.f4291a, this.f4291a.f4306E);
            if (this.f4291a.f4309H != null) {
                this.f4291a.f4309H.m6090a(z);
            }
            this.f4291a.startService(BenchmarkMainService.m6367k(this.f4291a));
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.6 */
    class C12626 implements C1175a {
        final /* synthetic */ MainActivity f4292a;

        C12626(MainActivity mainActivity) {
            this.f4292a = mainActivity;
        }

        public void m5133a(C1177t c1177t, View view, int i, C1538p c1538p) {
            switch (c1538p.m6091b()) {
                case C1082R.string.about /*2131165322*/:
                    PointMark.getInstance(this.f4292a).pointThis(PointMark.E_ABOUT);
                    this.f4292a.m5188a(new Intent(this.f4292a, AboutUsActivity.class));
                    break;
                case C1082R.string.localization /*2131165457*/:
                    this.f4292a.m5188a(new Intent(this.f4292a, LocalizationActivity.class));
                    break;
                case C1082R.string.recommend_tofriend /*2131165516*/:
                    ShareUtil.showShareApp(this.f4292a.getApplicationContext(), null);
                    break;
                case C1082R.string.suggest_feedback /*2131165559*/:
                    PointMark.getInstance(this.f4292a).pointThis(PointMark.E_FEEDBACK);
                    this.f4292a.m5188a(new Intent(this.f4292a, FeedbackActivity.class));
                    break;
                case C1082R.string.phone_search /*2131165875*/:
                    PointMark.getInstance(this.f4292a).pointThis(PointMark.E_SEARCH);
                    MobclickAgent.onEvent(this.f4292a, MobclickAgentConstants.click_search);
                    this.f4292a.m5188a(new Intent(this.f4292a, SearchActivity.class));
                    this.f4292a.m5189b();
                    break;
            }
            this.f4292a.m5189b();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.7 */
    class C12637 implements Runnable {
        final /* synthetic */ MainActivity f4293a;

        C12637(MainActivity mainActivity) {
            this.f4293a = mainActivity;
        }

        public void run() {
            this.f4293a.m5190c();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.8 */
    class C12658 implements DownloadJobListener {
        final /* synthetic */ MainActivity f4295a;

        /* renamed from: com.antutu.benchmark.activity.MainActivity.8.1 */
        class C12641 implements Runnable {
            final /* synthetic */ C12658 f4294a;

            C12641(C12658 c12658) {
                this.f4294a = c12658;
            }

            public void run() {
                this.f4294a.f4295a.m5178q();
                List list = (List) this.f4294a.f4295a.f4322k.get("8002");
                if (this.f4294a.f4295a.f4323l != null && !list.isEmpty()) {
                    this.f4294a.f4295a.f4323l.m5134a(list);
                }
            }
        }

        C12658(MainActivity mainActivity) {
            this.f4295a = mainActivity;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                this.f4295a.f4322k = ((C1521a) c1519k).m6045a();
                this.f4295a.runOnUiThread(new C12641(this));
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.9 */
    class C12669 implements OnClickListener {
        final /* synthetic */ C1518a f4296a;
        final /* synthetic */ MainActivity f4297b;

        C12669(MainActivity mainActivity, C1518a c1518a) {
            this.f4297b = mainActivity;
            this.f4296a = c1518a;
        }

        public void onClick(View view) {
            WebBrowserActivity.openURL(this.f4297b, this.f4296a.f5209g, this.f4296a.f5208f);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.a */
    public interface C1267a {
        void m5134a(List<C1518a> list);
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.b */
    private class C1268b extends BroadcastReceiver {
        final /* synthetic */ MainActivity f4298a;

        private C1268b(MainActivity mainActivity) {
            this.f4298a = mainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    action = intent.getData().getSchemeSpecificPart();
                    C1503b c = C1503b.m5915c();
                    if (C1516b.m6032g(action)) {
                        c.m5930a(C1516b.m6022c(ABenchmarkApplication.getContext()));
                        if (this.f4298a.f4321j != null) {
                            this.f4298a.unregisterReceiver(this.f4298a.f4321j);
                        }
                        this.f4298a.f4321j = null;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.MainActivity.d */
    private class C1269d extends Handler {
        final /* synthetic */ MainActivity f4299a;
        private WeakReference<C1493m> f4300b;

        C1269d(MainActivity mainActivity, C1493m c1493m) {
            this.f4299a = mainActivity;
            this.f4300b = new WeakReference(c1493m);
        }

        public void handleMessage(Message message) {
            C1493m c1493m = (C1493m) this.f4300b.get();
            if (c1493m != null) {
                switch (message.what) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        c1493m.m5893a(message.arg1, message.obj);
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        c1493m.m5895a(message.obj);
                    default:
                }
            }
        }
    }

    public MainActivity() {
        this.f4316e = null;
        this.f4317f = null;
        this.f4318g = null;
        this.f4319h = 0;
        this.f4320i = false;
        this.f4321j = null;
        this.f4327p = new ArrayList();
        this.f4330s = null;
        this.f4335x = null;
        this.f4304C = true;
        this.f4305D = true;
        this.f4306E = true;
        this.f4310I = new C12626(this);
        this.f4313a = false;
        this.f4311J = new Handler() {
            final /* synthetic */ MainActivity f4267a;

            {
                this.f4267a = r1;
            }

            public void handleMessage(Message message) {
                super.handleMessage(message);
                this.f4267a.f4313a = false;
            }
        };
        this.f4312K = new OnClickListener() {
            final /* synthetic */ MainActivity f4270a;

            {
                this.f4270a = r1;
            }

            public void onClick(View view) {
                InfocUtil.antutu_click_testtab(view.getContext(), 12);
                this.f4270a.m5190c();
            }
        };
    }

    public static void m5138a(Message message) {
        if (message == null) {
            message = new Message();
        }
        if (f4301b != null) {
            f4301b.sendMessage(message);
        }
    }

    private void m5139a(View view) {
        C1855c c1855c = new C1855c();
        C1864i.m6983a(view, "translationY", -270.0f, -90.0f, 0.0f, -60.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f).m6973a(0);
        c1855c.m6922a(C1864i.m6983a(view, "alpha", 0.0f, 1.0f), r1);
        c1855c.m6923b(1000);
        c1855c.m6925c(2000);
        c1855c.m6921a();
    }

    static void m5140a(String str) {
        Message message = new Message();
        message.what = 2;
        message.arg1 = 1;
        message.obj = str;
        m5138a(message);
    }

    private boolean m5141a(long j) {
        return System.currentTimeMillis() - j > 300000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5144b(android.content.Intent r5) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        r1 = "ACTION_HAS_JUMP_PAGE";
        r1 = r5.getBooleanExtra(r1, r0);
        if (r1 == 0) goto L_0x0003;
    L_0x000c:
        r1 = "ACTION_JUMP_PAGE";
        r2 = r5.getStringExtra(r1);
        r1 = -1;
        r3 = r2.hashCode();
        switch(r3) {
            case 1807363895: goto L_0x0023;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r1;
    L_0x001b:
        switch(r0) {
            case 0: goto L_0x001f;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x0003;
    L_0x001f:
        r4.m5161h();
        goto L_0x0003;
    L_0x0023:
        r3 = "ACTION_JUMP_PAGE_COMMENT";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x001a;
    L_0x002b:
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.benchmark.activity.MainActivity.b(android.content.Intent):void");
    }

    private void m5145b(String str) {
        if (Methods.hasInstalled("com.uzywpq.cqlzahm")) {
            new AnonymousClass14(this, str).start();
        }
    }

    private void m5148c(Intent intent) {
        if (intent != null) {
            PushMessageUtil.processPushMessage(this, intent);
        }
    }

    private void m5151d(Intent intent) {
        int intExtra = intent.getIntExtra("ACTION_OPEN_PAGE", -1);
        if (intExtra != -1) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = intExtra;
            f4301b.sendMessage(message);
        }
    }

    private void m5153e() {
        if (Utils.isUpdateApp(ABenchmarkApplication.getContext()) && !Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_IS_SHOW_UPDATE_NOTIFIFATION, false)) {
            Methods.editSharedPreferences(SPConstants.SHARE_PREF_IS_SHOW_UPDATE_NOTIFIFATION, true);
            this.f4334w.m5436f(new C12541(this));
        }
    }

    private void m5154e(Intent intent) {
        if (intent != null && intent.getBooleanExtra("ACTION_OPEN_MENU", false) && !this.f4324m.isDrawerOpen(this.f4328q) && this.f4324m != null && this.f4328q != null) {
            this.f4324m.openDrawer(this.f4328q);
        }
    }

    private void m5156f() {
        if ("CN".equals(Utils.getLocalLanguage(this))) {
            this.f4336y.setOnClickListener(new OnClickListener() {
                final /* synthetic */ MainActivity f4269a;

                {
                    this.f4269a = r1;
                }

                public void onClick(View view) {
                    ((ClipboardManager) this.f4269a.getSystemService("clipboard")).setText("AnTuTu_Benchmark");
                    Toast.makeText(this.f4269a.getApplication(), this.f4269a.getString(C1082R.string.has_copyed), 0).show();
                    MobclickAgent.onEvent(this.f4269a, MobclickAgentConstants.click_copy_wx);
                }
            });
            this.f4334w.m5434d(new C1095a<WxMainModel>() {
                final /* synthetic */ MainActivity f4278a;

                {
                    this.f4278a = r1;
                }

                public void m5119a(WxMainModel wxMainModel) {
                    this.f4278a.f4337z.setText(wxMainModel.getTitle1());
                    this.f4278a.f4302A.setText(wxMainModel.getTitle2());
                }

                public void m5121a(String str) {
                    this.f4278a.f4336y.setVisibility(8);
                }
            });
            return;
        }
        this.f4336y.setVisibility(8);
    }

    private void m5157f(Intent intent) {
        if (intent != null) {
            try {
                if (!"com.antutu.benchmark.UPDATE_ON_FINISHED".equals(intent.getAction())) {
                    return;
                }
                if (Utils.isCn(this)) {
                    Intent intent2 = new Intent(this, TestResultActivity.class);
                    intent2.putExtra("INTENT_EXTRA_SHOW_ARROW", true);
                    startActivity(intent2);
                    return;
                }
                startActivity(new Intent(this, DetailScoreActivity.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void m5158g() {
        if (Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_NOT_RED_COMMENT, false)) {
            this.f4315d.setShowRightRedPoint(true);
            this.f4335x.notifyDataSetChanged();
        }
        this.f4333v.m5418b(new C1095a<DataBean>() {
            final /* synthetic */ MainActivity f4281a;

            {
                this.f4281a = r1;
            }

            public void m5125a(DataBean dataBean) {
                if (dataBean.getCmt_received() > 0) {
                    Methods.editSharedPreferences(SPConstants.SHARE_PREF_NOT_RED_COMMENT, true);
                    this.f4281a.f4315d.setShowRightRedPoint(true);
                    this.f4281a.f4335x.notifyDataSetChanged();
                }
            }

            public void m5127a(String str) {
            }
        });
    }

    private void m5161h() {
        m5188a(new Intent(this, CommentActivity.class));
    }

    private void m5162i() {
        AppActivity.setActionBarColorTheme(ActionBarColorTheme.ACTION_BAR_BLACK_THEME);
    }

    private void m5165j() {
        this.f4314c.m5894a(new C1255c() {
            final /* synthetic */ MainActivity f4282a;

            {
                this.f4282a = r1;
            }

            public void m5129a() {
                this.f4282a.f4314c.m5892a(8);
            }
        });
        this.f4324m.addDrawerListener(new DrawerListener() {
            final /* synthetic */ MainActivity f4283a;

            {
                this.f4283a = r1;
            }

            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View view) {
            }

            public void onDrawerSlide(View view, float f) {
            }

            public void onDrawerStateChanged(int i) {
            }
        });
    }

    private void m5166k() {
        MobclickAgent.setScenarioType(this, EScenarioType.E_UM_NORMAL);
        MobclickAgent.enableEncrypt(true);
        MobclickAgent.startWithConfigure(new UMAnalyticsConfig(this, "5135a322527015535f000059", "benchmark_" + C1503b.m5915c().m5954k()));
        PushAgent instance = PushAgent.getInstance(this);
        boolean sharedPreferencesBoolean = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, true);
        MLog.m6865d("PushAgent", " PushSetting = " + sharedPreferencesBoolean);
        if (sharedPreferencesBoolean) {
            instance.enable(new IUmengCallback() {
                final /* synthetic */ MainActivity f4285a;

                {
                    this.f4285a = r1;
                }

                public void onFailure(String str, String str2) {
                    MLog.m6865d("PushAgent", "enable() onFailure!!");
                    Log.e("PushAgent", String.valueOf(str));
                    Log.e("PushAgent", String.valueOf(str2));
                }

                public void onSuccess() {
                    MLog.m6865d("PushAgent", "enable() onSuccess!!");
                }
            });
            PushManager.getInstance().initialize(this);
            return;
        }
        instance.disable(new C12562(this));
        PushManager.getInstance().stopService(this);
    }

    private void m5169l() {
        m5171m();
        m5172n();
        this.f4335x = new C1177t(this, this.f4327p);
        this.f4326o.setAdapter(this.f4335x);
        m5175o();
    }

    private void m5171m() {
        this.f4324m = (DrawerLayout) findViewById(C1082R.id.dl_mainpage);
        this.f4326o = (ListView) findViewById(C1082R.id.lv_other);
        this.f4328q = (LinearLayout) findViewById(C1082R.id.main_scroll);
        this.f4336y = (LinearLayout) findViewById(C1082R.id.ll_wx_bg);
        this.f4337z = (TextView) findViewById(C1082R.id.tv_title1);
        this.f4302A = (TextView) findViewById(C1082R.id.tv_title2);
    }

    private void m5172n() {
        this.f4305D = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_UPDATE, true);
        this.f4304C = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, true);
        this.f4306E = C1502a.m5912e(this);
        this.f4327p.add(new C1538p(C1082R.drawable.search, C1082R.string.phone_search));
        if (Utils.getLocalLanguage(this).equals("CN") && C1503b.m5915c().m5954k() != 1) {
            this.f4307F = new C1538p(C1082R.drawable.message_push, C1082R.string.push_setting, 0, this.f4304C, new C12593(this));
            this.f4327p.add(this.f4307F);
            this.f4308G = new C1538p(C1082R.drawable.soft_upgrade, C1082R.string.update_setting, C1082R.string.update_desc, this.f4305D, new C12604(this));
            this.f4327p.add(this.f4308G);
        }
        this.f4309H = new C1538p(C1082R.drawable.ic_temperature_bar, C1082R.string.temperature_bar_setting, 0, this.f4306E, new C12615(this));
        this.f4327p.add(this.f4309H);
        if (!"CN".equals(Utils.getLocalLanguage(this))) {
            this.f4327p.add(new C1538p(C1082R.drawable.more_localization, C1082R.string.localization));
        }
        this.f4327p.add(new C1538p(C1082R.drawable.more_about, C1082R.string.about));
        this.f4327p.add(new C1538p(C1082R.drawable.more_feedback, C1082R.string.suggest_feedback));
    }

    private void m5175o() {
        this.f4335x.m4944a(this.f4310I);
    }

    private void m5177p() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("oem=").append(C1503b.m5915c().m5954k()).append("&lan=").append(C1523d.m6061b()).append("&softid=").append(C1503b.m5915c().m5956l()).append("&adversion=" + Utils.getAdVersion(this) + BuildConfig.FLAVOR).append("&aid=8").append("&format=json").append("&imei=").append(C1503b.m5915c().m5925a((Context) this, false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n()).append("&softversion=").append(C1503b.m5915c().m5958m());
        MLog.m6864d("hzd, loadAds, parms: " + stringBuilder.toString());
        String dataSafe = jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
        HashMap hashMap = new HashMap();
        hashMap.put("gpv", dataSafe);
        DownloadJob downloadJob = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1521a("8001", "8002"), hashMap);
        downloadJob.setDownloadJobListener(new C12658(this));
        downloadJob.start(false);
    }

    private void m5178q() {
        View findViewById = this.f4315d.findViewById(C1082R.id.action_lottery);
        List list = (List) this.f4322k.get("8001");
        if (findViewById != null && list != null && !list.isEmpty()) {
            C1518a c1518a = (C1518a) list.get(0);
            if (c1518a == null || TextUtils.isEmpty(c1518a.f5209g)) {
                findViewById.setVisibility(8);
                return;
            }
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new C12669(this, c1518a));
            m5139a(findViewById);
        }
    }

    private void m5181r() {
        if (Utils.isNetworkConnected(this)) {
            Intent intent = new Intent(this, TrackService.class);
            ArrayList arrayList = PointMark.getInstance(this).getArrayList();
            String dataParams = PointMark.getInstance(this).getDataParams();
            Bundle bundle = new Bundle();
            bundle.putString(PointMark.PARAMS_VALUE, dataParams);
            bundle.putStringArrayList(PointMark.TOTAL_TAG, arrayList);
            intent.putExtras(bundle);
            startService(intent);
        }
    }

    private void m5183s() {
        try {
            this.f4318g = new BroadcastReceiver() {
                final /* synthetic */ MainActivity f4268a;

                {
                    this.f4268a = r1;
                }

                public void onReceive(Context context, Intent intent) {
                    try {
                        String action = intent.getAction();
                        if (action.equals("com.antutu.benchmark.UPDATE_ON_FINISHED")) {
                            MobclickAgent.onEvent(this.f4268a, MobclickAgentConstants.benckmark_finished);
                            MainActivity.m5140a("FINISH_BENCHMARK_FINISH_TAG");
                        } else if (action.equals("com.antutu.benchmark.UPDATE_ON_STOP")) {
                            C1503b.m5915c().m5926a(context);
                            MainActivity.m5140a(null);
                        } else if (action.equals("com.antutu.benchmark.START_AUTO_BENCH")) {
                            try {
                                if (this.f4268a.f4320i) {
                                    C1503b.f5113a = 31;
                                    C1496n.m5898a(this.f4268a, false);
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.antutu.benchmark.UPDATE_ON_FINISHED");
            intentFilter.addAction("com.antutu.benchmark.UPDATE_ON_STOP");
            intentFilter.addAction("com.antutu.benchmark.START_AUTO_BENCH");
            registerReceiver(this.f4318g, intentFilter);
            this.f4320i = C1503b.m5915c().m5969v();
            if (this.f4320i) {
                sendBroadcast(new Intent().setAction("com.antutu.benchmark.START_AUTO_BENCH").setPackage(getPackageName()));
            }
        } catch (Exception e) {
        }
    }

    private void m5185t() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("oem=").append(C1503b.m5915c().m5954k()).append("&lan=").append(C1523d.m6061b()).append("&softid=123").append("&adversion=" + Utils.getAdVersion(this) + BuildConfig.FLAVOR).append("&aid=9").append("&format=json").append("&imei=").append(C1503b.m5915c().m5925a((Context) this, false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n()).append("&softversion=").append(C1503b.m5915c().m5958m());
            MLog.m6864d("hzd, loadAds, parms: " + stringBuilder.toString());
            String dataSafe = jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
            HashMap hashMap = new HashMap();
            hashMap.put("gpv", dataSafe);
            DownloadJob downloadJob = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1521a("9001"), hashMap);
            downloadJob.setDownloadJobListener(new DownloadJobListener() {
                final /* synthetic */ MainActivity f4277a;

                /* renamed from: com.antutu.benchmark.activity.MainActivity.17.1 */
                class C12531 implements Runnable {
                    final /* synthetic */ Map f4275a;
                    final /* synthetic */ AnonymousClass17 f4276b;

                    C12531(AnonymousClass17 anonymousClass17, Map map) {
                        this.f4276b = anonymousClass17;
                        this.f4275a = map;
                    }

                    public void run() {
                        if (this.f4276b.f4277a.f4331t != null) {
                            List list = (List) this.f4275a.get("9001");
                            if (list != null && list.size() > 0) {
                                this.f4276b.f4277a.f4331t.m4951a(list);
                                this.f4276b.f4277a.f4331t.notifyDataSetChanged();
                                this.f4276b.f4277a.f4329r.showAtLocation(this.f4276b.f4277a.f4325n.getRootView(), 17, 0, ((WindowManager) this.f4276b.f4277a.getSystemService("window")).getDefaultDisplay().getHeight() / 2);
                                Methods.editSharedPreferences("hasShowSuggestApps", true);
                            }
                        }
                    }
                }

                {
                    this.f4277a = r1;
                }

                public void downloadEnded(C1519k c1519k) {
                    if (c1519k != null) {
                        try {
                            this.f4277a.runOnUiThread(new C12531(this, ((C1521a) c1519k).m6045a()));
                        } catch (Exception e) {
                        }
                    }
                }
            });
            downloadJob.start(false);
        } catch (Exception e) {
        }
    }

    public void m5186a() {
        this.f4332u.m5427d(new C1095a<Boolean>() {
            final /* synthetic */ MainActivity f4284a;

            {
                this.f4284a = r1;
            }

            public void m5130a(Boolean bool) {
                if (bool.booleanValue()) {
                    this.f4284a.f4314c.m5892a(0);
                } else {
                    this.f4284a.f4314c.m5892a(8);
                }
            }

            public void m5132a(String str) {
                if (str != null && !BuildConfig.FLAVOR.equals(str)) {
                    Methods.showToast(this.f4284a, str, 0);
                }
            }
        });
    }

    public void m5187a(int i) {
        if (this.f4315d != null) {
            C1625b a = i != 0 ? new C1625b().m6414a(this.f4303B).m6412a((int) C1082R.drawable.main_title_icon_menu).m6413a(this.f4312K).m6418b(false).m6420d(true).m6415a(true) : new C1625b().m6414a(this.f4303B).m6412a((int) C1082R.drawable.main_title_icon_menu).m6413a(this.f4312K).m6418b(true).m6420d(false).m6415a(true).m6416b((int) C1082R.drawable.message).m6417b(new OnClickListener() {
                final /* synthetic */ MainActivity f4279a;

                {
                    this.f4279a = r1;
                }

                public void onClick(View view) {
                    MobclickAgent.onEvent(this.f4279a, MobclickAgentConstants.click_my_msg);
                    Methods.editSharedPreferences(SPConstants.SHARE_PREF_NOT_RED_COMMENT, false);
                    this.f4279a.f4315d.setShowRightRedPoint(false);
                    this.f4279a.m5188a(new Intent(this.f4279a, MyMessageActivity.class));
                }
            });
            if (!Utils.isCn(this)) {
                a.m6418b(false).m6420d(true);
            }
            this.f4315d.setMode(a.m6411a());
        }
    }

    protected void m5188a(Intent intent) {
        startActivity(intent);
        overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
    }

    public void m5189b() {
        new Handler().postDelayed(new C12637(this), 200);
    }

    public void m5190c() {
        if (this.f4324m.isDrawerOpen(this.f4328q)) {
            this.f4324m.closeDrawer(this.f4328q);
        } else {
            MobclickAgent.onEvent(this, MobclickAgentConstants.menu_open);
            this.f4324m.openDrawer(this.f4328q);
        }
        Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_WX_RED, false);
        if (this.f4315d != null) {
            this.f4315d.setShowLeftRedPoint(false);
        }
    }

    public void m5191d() {
        try {
            View inflate = getLayoutInflater().inflate(C1082R.layout.popupwindow_suggest_apps, null);
            if (this.f4329r == null) {
                this.f4329r = new PopupWindow(inflate, -1, -2, true);
            }
            this.f4329r.setBackgroundDrawable(new BitmapDrawable());
            this.f4329r.setFocusable(false);
            this.f4329r.setOutsideTouchable(true);
            GridView gridView = (GridView) inflate.findViewById(C1082R.id.gv_apps);
            this.f4331t = new C1183u(this);
            gridView.setAdapter(this.f4331t);
            inflate.findViewById(C1082R.id.btn_download).setOnClickListener(new OnClickListener() {
                final /* synthetic */ MainActivity f4273a;

                {
                    this.f4273a = r1;
                }

                public void onClick(View view) {
                    if (this.f4273a.f4331t != null) {
                        if (this.f4273a.f4331t.m4952a()) {
                            this.f4273a.f4329r.dismiss();
                        } else {
                            Methods.showToast(this.f4273a, (int) C1082R.string.please_choose_app, 0);
                        }
                    }
                }
            });
            inflate.findViewById(C1082R.id.iv_close).setOnClickListener(new OnClickListener() {
                final /* synthetic */ MainActivity f4274a;

                {
                    this.f4274a = r1;
                }

                public void onClick(View view) {
                    this.f4274a.f4329r.dismiss();
                }
            });
            m5185t();
        } catch (Exception e) {
        }
    }

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ABenchmarkApplication.f3647c++;
        MLog.m6865d("MainActivity", "hzd, onCreate");
        m5166k();
        m5162i();
        if (C1516b.m6019b()) {
            finish();
            startActivity(new Intent(getApplication(), ABenchMarkStart.class));
            return;
        }
        C1523d.m6062c();
        PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.K_MAIN_UI);
        C1523d.f5231b = getResources().getString(C1082R.string.guest);
        this.f4332u = new C1360b(this);
        this.f4333v = new C1353a(this);
        this.f4334w = new C1371d(this);
        if (bundle != null) {
            this.f4314c = (C1493m) getSupportFragmentManager().getFragment(bundle, "mContent");
        }
        if (this.f4314c == null) {
            this.f4314c = new C1493m();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_num", this.f4319h);
            this.f4314c.setArguments(bundle2);
        }
        requestWindowFeature(1);
        setContentView(C1082R.layout.content_frame);
        SystemBarTintManager.setSystemBar(this, C1082R.color.status_bar_color, false);
        m5169l();
        this.f4330s = PreferenceManager.getDefaultSharedPreferences(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(C1082R.id.content_frame, this.f4314c);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        this.f4325n = (RelativeLayout) findViewById(C1082R.id.rl_main_content);
        this.f4315d = (CommonTitleView) findViewById(C1082R.id.title_layout);
        this.f4303B = getResources().getString(C4459R.string.app_name);
        try {
            this.f4303B += " v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
        }
        m5187a(0);
        if (Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_WX_RED, true) && Utils.getLocalLanguage(this).equals("CN")) {
            this.f4315d.setShowLeftRedPoint(true);
        }
        f4301b = new C1269d(this, this.f4314c);
        m5183s();
        try {
            if (!C1503b.m5915c().m5935b()) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme(C4209a.f14200c);
                this.f4321j = new C1268b();
                registerReceiver(this.f4321j, intentFilter);
            }
        } catch (Exception e2) {
        }
        m5177p();
        m5165j();
        m5148c(getIntent());
        m5144b(getIntent());
        m5158g();
        m5156f();
        m5154e(getIntent());
        m5151d(getIntent());
        if (C1503b.m5919h((Context) this)) {
            startActivity(new Intent(this, WizardActivity.class));
        }
        m5153e();
        Utils.getPermissions(this, new String[]{MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, MsgConstant.PERMISSION_READ_PHONE_STATE, "android.permission.ACCESS_COARSE_LOCATION"});
        InfocUtil.antutu_tabshow(this, 999);
        m5157f(getIntent());
    }

    protected void onDestroy() {
        try {
            if (this.f4321j != null) {
                unregisterReceiver(this.f4321j);
            }
            if (this.f4318g != null) {
                unregisterReceiver(this.f4318g);
            }
            if (this.f4316e != null) {
                unregisterReceiver(this.f4316e);
            }
            if (this.f4317f != null) {
                unregisterReceiver(this.f4317f);
            }
            GarbageCleaner.getInstance(this).recycle();
        } catch (Exception e) {
        }
        f4301b = null;
        ABenchmarkApplication.f3647c = 0;
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f4324m == null || this.f4328q == null || !this.f4324m.isDrawerOpen(this.f4328q)) {
                try {
                    if (this.f4314c.m5896c()) {
                        return true;
                    }
                } catch (Exception e) {
                }
                if (this.f4329r != null && this.f4329r.isShowing()) {
                    this.f4329r.dismiss();
                    return true;
                } else if (this.f4313a) {
                    m5181r();
                    ABenchmarkApplication.f3647c = 0;
                    finish();
                } else {
                    this.f4313a = true;
                    Methods.showToast((Context) this, (int) C1082R.string.tap_twice_to_exit, (int) AdError.NETWORK_ERROR_CODE);
                    this.f4311J.sendEmptyMessageDelayed(0, 2000);
                }
            } else {
                this.f4324m.closeDrawer(this.f4328q);
                return true;
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m5148c(intent);
        m5151d(intent);
        m5144b(intent);
        m5154e(intent);
        m5157f(intent);
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        Methods.editSharedPreferences("leavetimes", System.currentTimeMillis());
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        m5145b("com.uzywpq.cqlzahm");
        if (m5141a(Methods.getSharedPreferencesLong("leavetimes", 0))) {
            m5186a();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().putFragment(bundle, "mContent", this.f4314c);
    }

    protected void onStart() {
        C1503b.f5116d = true;
        super.onStart();
    }

    protected void onStop() {
        C1503b.f5116d = false;
        super.onStop();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.f4330s.getBoolean("hasShowSuggestApps", false)) {
            this.f4330s.edit().putBoolean("hasShowSuggestApps", true).commit();
            if (NetUtils.getNetWorkType(getApplicationContext()) == 4) {
                m5191d();
            }
        }
    }
}
