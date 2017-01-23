package com.antutu.benchmark.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDataObserver.Stub;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1341f;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.utils.CMDownloadUtil;
import com.antutu.utils.GarbageCleaner;
import com.antutu.utils.GarbageCleaner.AppInfo;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ClearGarbageActivity extends C1214a {
    private final int f4076e;
    private final int f4077f;
    private final int f4078g;
    private final int f4079h;
    private List<AppInfo> f4080i;
    private Button f4081k;
    private BroadcastReceiver f4082l;
    private BroadcastReceiver f4083m;
    private C1212a f4084n;
    private String f4085o;
    private Handler f4086p;

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.1 */
    class C12081 extends Handler {
        final /* synthetic */ ClearGarbageActivity f4055a;

        /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.1.1 */
        class C12041 implements OnClickListener {
            final /* synthetic */ C12081 f4051a;

            C12041(C12081 c12081) {
                this.f4051a = c12081;
            }

            public void onClick(View view) {
                this.f4051a.f4055a.m4990h();
            }
        }

        /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.1.2 */
        class C12052 implements OnClickListener {
            final /* synthetic */ C12081 f4052a;

            C12052(C12081 c12081) {
                this.f4052a = c12081;
            }

            public void onClick(View view) {
                String language = this.f4052a.f4055a.getResources().getConfiguration().locale.getLanguage();
                String country = this.f4052a.f4055a.getResources().getConfiguration().locale.getCountry();
                int k = C1503b.m5915c().m5954k();
                if (language == null || !language.contains("zh") || country == null || !country.contains("CN")) {
                    CMDownloadUtil.downloadInternationalCM(this.f4052a.f4055a, this.f4052a.f4055a.f4085o);
                } else if (k == 1 && Methods.hasInstalled("com.android.vending")) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + CMDownloadUtil.CM + "&referrer=utm_source%" + "3D200103"));
                    intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                    this.f4052a.f4055a.startActivity(intent);
                } else if (CMDownloadUtil.tryInstallFromLocal(this.f4052a.f4055a)) {
                    PointMark.getInstance(this.f4052a.f4055a).pointThis(PointMark.E_START_DOWNLOAD_CM);
                    PointMark.getInstance(this.f4052a.f4055a).trackLimitValue(PointMark.E_START_DOWNLOAD_CM_SINGLE);
                    this.f4052a.f4055a.m4980e();
                    this.f4052a.f4055a.f4086p.sendEmptyMessage(10);
                }
            }
        }

        /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.1.3 */
        class C12063 implements OnClickListener {
            final /* synthetic */ C12081 f4053a;

            C12063(C12081 c12081) {
                this.f4053a = c12081;
            }

            public void onClick(View view) {
                this.f4053a.f4055a.m4961f();
            }
        }

        /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.1.4 */
        class C12074 implements OnClickListener {
            final /* synthetic */ C12081 f4054a;

            C12074(C12081 c12081) {
                this.f4054a = c12081;
            }

            public void onClick(View view) {
                CMDownloadUtil.tryInstallFromLocal(this.f4054a.f4055a);
            }
        }

        C12081(ClearGarbageActivity clearGarbageActivity) {
            this.f4055a = clearGarbageActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    PointMark.getInstance(this.f4055a).pointThis(PointMark.E_START_CLEAN_GARBAGE);
                    this.f4055a.f4081k.setText(C1082R.string.clear_in_progress);
                    this.f4055a.f4081k.setClickable(false);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f4055a.f4081k.setText(C1082R.string.clear_complete);
                    this.f4055a.f4081k.setClickable(true);
                    this.f4055a.f4081k.setOnClickListener(new C12063(this));
                    GarbageCleaner.getInstance(this.f4055a).setIsClean(true);
                    this.f4055a.f4084n.notifyDataSetChanged();
                    GarbageCleaner.getInstance(this.f4055a).notifyCleanFinished();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f4055a.f4081k.setClickable(true);
                    this.f4055a.f4081k.setText(C1082R.string.clear);
                    this.f4055a.f4081k.setOnClickListener(new C12041(this));
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.f4055a.f4081k.setClickable(false);
                    this.f4055a.f4081k.setText(C1082R.string.clear_in_progress);
                    this.f4055a.m4990h();
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    this.f4055a.f4081k.setClickable(false);
                    int i = message.arg1;
                    this.f4055a.f4081k.setText(this.f4055a.getString(C1082R.string.download_in_progress, new Object[]{Integer.valueOf(i)}));
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    this.f4055a.f4081k.setClickable(true);
                    if (CMDownloadUtil.isDownloaded(this.f4055a)) {
                        this.f4055a.f4081k.setText(C1082R.string.clear);
                    } else {
                        this.f4055a.f4081k.setText(C1082R.string.open_clear);
                    }
                    this.f4055a.f4081k.setOnClickListener(new C12052(this));
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    this.f4055a.f4081k.setClickable(true);
                    this.f4055a.f4081k.setText(C1082R.string.clear);
                    this.f4055a.f4081k.setOnClickListener(new C12074(this));
                default:
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.2 */
    class C12092 extends BroadcastReceiver {
        final /* synthetic */ ClearGarbageActivity f4056a;

        C12092(ClearGarbageActivity clearGarbageActivity) {
            this.f4056a = clearGarbageActivity;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            MLog.m6871i("ClearGarbageActivity", "hzd, action=" + action);
            String substring = intent.getDataString().substring(8);
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                if (CMDownloadUtil.CM.equals(substring) || CMDownloadUtil.CM_CN.equals(substring)) {
                    this.f4056a.getSharedPreferences("cm_config", 4).edit().putBoolean(CMDownloadUtil.SHARE_PREF_DOWNLOAD_CM, false).commit();
                    this.f4056a.f4086p.sendEmptyMessageDelayed(3, 2000);
                }
            } else if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
            } else {
                if (CMDownloadUtil.CM.equals(substring) || CMDownloadUtil.CM_CN.equals(substring)) {
                    this.f4056a.f4086p.sendEmptyMessage(12);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.3 */
    class C12103 extends BroadcastReceiver {
        final /* synthetic */ ClearGarbageActivity f4057a;

        C12103(ClearGarbageActivity clearGarbageActivity) {
            this.f4057a = clearGarbageActivity;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            MLog.m6871i("ClearGarbageActivity", "hzd, action=" + action);
            if (CMDownloadUtil.SHARE_PREF_DOWNLOAD_CM.equals(action) || CMDownloadUtil.ACTION_DOWNLOAD_CM_INTERRUPTTED.equals(action)) {
                this.f4057a.f4086p.sendEmptyMessage(12);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.4 */
    class C12114 extends Stub {
        final /* synthetic */ ClearGarbageActivity f4058a;

        C12114(ClearGarbageActivity clearGarbageActivity) {
            this.f4058a = clearGarbageActivity;
        }

        public void onRemoveCompleted(String str, boolean z) {
            MLog.m6864d("hzd, onRemoveCompleted...");
            this.f4058a.f4086p.sendEmptyMessage(1);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.a */
    private class C1212a extends BaseAdapter {
        final /* synthetic */ ClearGarbageActivity f4059a;
        private Context f4060b;
        private LayoutInflater f4061c;
        private Drawable f4062d;
        private Drawable f4063e;

        public C1212a(ClearGarbageActivity clearGarbageActivity, Context context) {
            this.f4059a = clearGarbageActivity;
            this.f4060b = context;
            this.f4061c = LayoutInflater.from(context);
            this.f4062d = this.f4060b.getResources().getDrawable(C1082R.drawable.cross_bg_1);
            this.f4063e = this.f4060b.getResources().getDrawable(C1082R.drawable.cross_bg_2);
        }

        public int getCount() {
            return this.f4059a.f4080i.size();
        }

        public Object getItem(int i) {
            return this.f4059a.f4080i.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C1213b c1213b;
            if (view == null) {
                view = this.f4061c.inflate(C1082R.layout.garbage_item, null);
                c1213b = new C1213b(null);
                c1213b.f4064a = (ImageView) view.findViewById(C1082R.id.icon_img_view);
                c1213b.f4065b = (TextView) view.findViewById(C1082R.id.label_text_view);
                c1213b.f4066c = (TextView) view.findViewById(C1082R.id.size_text_view);
                c1213b.f4067d = (ImageView) view.findViewById(C1082R.id.clean_complete_icon);
                view.setTag(c1213b);
            } else {
                c1213b = (C1213b) view.getTag();
            }
            if (i % 2 == 0) {
                view.setBackgroundDrawable(this.f4062d);
            } else {
                view.setBackgroundDrawable(this.f4063e);
            }
            AppInfo appInfo = (AppInfo) this.f4059a.f4080i.get(i);
            c1213b.f4064a.setImageDrawable(appInfo.icon);
            c1213b.f4065b.setText(appInfo.label);
            c1213b.f4066c.setText(ClearGarbageActivity.m4983b(this.f4060b, appInfo.cacheSize));
            if (GarbageCleaner.getInstance(this.f4060b).isClean()) {
                c1213b.f4067d.setVisibility(0);
            } else {
                c1213b.f4067d.setVisibility(8);
            }
            return view;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ClearGarbageActivity.b */
    private class C1213b {
        ImageView f4064a;
        TextView f4065b;
        TextView f4066c;
        ImageView f4067d;
        final /* synthetic */ ClearGarbageActivity f4068e;

        private C1213b(ClearGarbageActivity clearGarbageActivity) {
            this.f4068e = clearGarbageActivity;
        }
    }

    public ClearGarbageActivity() {
        this.f4076e = 0;
        this.f4077f = 1;
        this.f4078g = 2;
        this.f4079h = 3;
        this.f4086p = new C12081(this);
    }

    private static String m4983b(Context context, long j) {
        return Formatter.formatFileSize(context, j);
    }

    private void m4990h() {
        this.f4086p.sendEmptyMessage(0);
        m4992j();
    }

    private void m4991i() {
        MLog.m6865d("ClearGarbageActivity", "hzd, registerReceiver...");
        this.f4082l = new C12092(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(C4209a.f14200c);
        this.f4083m = new C12103(this);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(CMDownloadUtil.SHARE_PREF_DOWNLOAD_CM);
        intentFilter2.addAction(CMDownloadUtil.ACTION_DOWNLOAD_CM_INTERRUPTTED);
        registerReceiver(this.f4082l, intentFilter);
        registerReceiver(this.f4083m, intentFilter2);
    }

    private void m4992j() {
        PackageManager packageManager = getPackageManager();
        Long valueOf = Long.valueOf(Long.MAX_VALUE);
        try {
            packageManager.getClass().getMethod("freeStorageAndNotify", new Class[]{Long.TYPE, IPackageDataObserver.class}).invoke(packageManager, new Object[]{valueOf, new C12114(this)});
        } catch (Exception e) {
            this.f4086p.sendEmptyMessage(1);
        }
    }

    protected DownloadInfos m4993a() {
        DownloadInfos downloadInfos = new DownloadInfos();
        downloadInfos.setUrl(CMDownloadUtil.URL_CM_CN);
        downloadInfos.setTitle(getString(C1082R.string.clean_master));
        downloadInfos.setNeedRename(true);
        return downloadInfos;
    }

    protected void m4994a(int i) {
        this.f4086p.sendMessage(Message.obtain(this.f4086p, 10, i, 0));
    }

    protected void m4995b() {
        CMDownloadUtil.isDownloading = false;
        getSharedPreferences("cm_config", 4).edit().putBoolean(CMDownloadUtil.SHARE_PREF_DOWNLOAD_CM, false).commit();
        this.f4086p.sendEmptyMessage(12);
    }

    protected void m4996c() {
        CMDownloadUtil.isDownloading = false;
        getSharedPreferences("cm_config", 4).edit().putBoolean(CMDownloadUtil.SHARE_PREF_DOWNLOAD_CM, true).commit();
        this.f4086p.sendEmptyMessage(13);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.garbage_clean_result);
        SystemBarTintManager.setSystemBar(this, C1082R.color.status_bar_color, false);
        String stringExtra = getIntent().getStringExtra("gc_title");
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, stringExtra, false, this.j, null));
        boolean booleanExtra = getIntent().getBooleanExtra("need_download_cm", false);
        this.f4080i = GarbageCleaner.getInstance(this).getAppInfoList();
        this.f4085o = getIntent().getStringExtra(CMDownloadUtil.ACTION_DOWLOAD_CM_FROM);
        this.f4081k = (Button) findViewById(C1082R.id.clear_garbage_btn);
        if (GarbageCleaner.getInstance(this).isClean()) {
            this.f4086p.sendEmptyMessage(1);
        } else if (!booleanExtra) {
            this.f4086p.sendEmptyMessage(2);
        } else if (CMDownloadUtil.isDownloading) {
            m4980e();
            this.f4086p.sendEmptyMessage(10);
        } else {
            this.f4086p.sendEmptyMessage(12);
        }
        ListView listView = (ListView) findViewById(C1082R.id.garbage_listview);
        this.f4084n = new C1212a(this, this);
        listView.setAdapter(this.f4084n);
        OnTouchListener c1341f = new C1341f(this);
        c1341f.m5400a(this);
        listView.setOnTouchListener(c1341f);
        m4991i();
    }

    public void onDestroy() {
        MLog.m6865d("ClearGarbageActivity", "hzd, onDestroy");
        try {
            if (GarbageCleaner.getInstance(this).isClean()) {
                this.f4080i.clear();
            }
            if (this.f4082l != null) {
                unregisterReceiver(this.f4082l);
            }
            if (this.f4083m != null) {
                unregisterReceiver(this.f4083m);
            }
            if (m4979d()) {
                CMDownloadUtil.isDownloading = this.d.isDownloading(CMDownloadUtil.URL_CM_CN);
            }
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
    }
}
