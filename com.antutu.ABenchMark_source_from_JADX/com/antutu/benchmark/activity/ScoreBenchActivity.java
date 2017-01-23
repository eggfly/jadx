package com.antutu.benchmark.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.ABenchMarkStart;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.BenchmarkService;
import com.antutu.benchmark.BenchmarkService.C1087b;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.MLog;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.RealFullscreen;
import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ScoreBenchActivity extends C1197a {
    public static boolean f4411c;
    private static final String f4412k;
    Animation f4413a;
    public TextView f4414b;
    BenchmarkService f4415d;
    boolean f4416e;
    C1292b f4417f;
    C1292b f4418g;
    C1292b f4419h;
    C1292b f4420i;
    private C1291a f4421l;
    private float f4422m;
    private TextView f4423n;
    private TextView f4424o;
    private boolean f4425p;
    private ServiceConnection f4426q;

    /* renamed from: com.antutu.benchmark.activity.ScoreBenchActivity.1 */
    class C12881 implements OnClickListener {
        final /* synthetic */ ScoreBenchActivity f4398a;

        C12881(ScoreBenchActivity scoreBenchActivity) {
            this.f4398a = scoreBenchActivity;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f4398a, MobclickAgentConstants.stop_benchmark);
            BenchmarkService.m4815c(this.f4398a.getApplicationContext());
            this.f4398a.m5255a(1);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ScoreBenchActivity.2 */
    class C12892 implements Runnable {
        final /* synthetic */ ScoreBenchActivity f4399a;

        C12892(ScoreBenchActivity scoreBenchActivity) {
            this.f4399a = scoreBenchActivity;
        }

        public void run() {
            BenchmarkService.m4816c(this.f4399a.getApplicationContext(), 4);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ScoreBenchActivity.3 */
    class C12903 implements ServiceConnection {
        final /* synthetic */ ScoreBenchActivity f4400a;

        C12903(ScoreBenchActivity scoreBenchActivity) {
            this.f4400a = scoreBenchActivity;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1087b c1087b = (C1087b) iBinder;
            this.f4400a.f4415d = c1087b.m4807a();
            this.f4400a.f4416e = true;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f4400a.f4416e = false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ScoreBenchActivity.a */
    private class C1291a extends BroadcastReceiver {
        final /* synthetic */ ScoreBenchActivity f4401a;

        private C1291a(ScoreBenchActivity scoreBenchActivity) {
            this.f4401a = scoreBenchActivity;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("com.antutu.benchmark.update.UI")) {
                    try {
                        int intExtra = intent.getIntExtra("uid", -1);
                        String stringExtra = intent.getStringExtra("info");
                        if (stringExtra != null) {
                            this.f4401a.m5256a(intExtra, stringExtra);
                        }
                    } catch (Exception e) {
                    }
                } else if (action.equals("com.antutu.benchmark.test.STOP")) {
                    r0 = new Intent();
                    r0.setAction("com.antutu.benchmark.UPDATE_ON_STOP");
                    r0.setPackage(this.f4401a.getPackageName());
                    this.f4401a.sendBroadcast(r0);
                    this.f4401a.m5255a(3);
                } else if (action.equals("com.antutu.benchmark.test.FINISHED")) {
                    if (ABenchmarkApplication.f3647c == 0) {
                        MLog.m6871i(ScoreBenchActivity.f4412k, "MainActivity is destroy");
                        r0 = new Intent(context, ABenchMarkStart.class);
                        r0.setAction("com.antutu.benchmark.UPDATE_ON_FINISHED");
                        context.startActivity(r0);
                    }
                    r0 = new Intent();
                    r0.setAction("com.antutu.benchmark.UPDATE_ON_FINISHED");
                    r0.setPackage(this.f4401a.getPackageName());
                    this.f4401a.sendBroadcast(r0);
                    this.f4401a.m5255a(4);
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ScoreBenchActivity.b */
    class C1292b {
        public ImageView f4402a;
        public ImageView f4403b;
        public TextView f4404c;
        public TextView f4405d;
        final /* synthetic */ ScoreBenchActivity f4406e;
        private boolean f4407f;
        private boolean f4408g;
        private int f4409h;
        private View f4410i;

        public C1292b(ScoreBenchActivity scoreBenchActivity, View view) {
            this.f4406e = scoreBenchActivity;
            this.f4407f = false;
            this.f4408g = false;
            this.f4409h = 0;
            this.f4402a = null;
            this.f4403b = null;
            this.f4404c = null;
            this.f4405d = null;
            this.f4410i = null;
            this.f4404c = (TextView) view.findViewById(C1082R.id.text_title);
            this.f4405d = (TextView) view.findViewById(C1082R.id.text_info);
            this.f4402a = (ImageView) view.findViewById(C1082R.id.img_anim);
            this.f4403b = (ImageView) view.findViewById(C1082R.id.img_static);
            this.f4410i = view.findViewById(C1082R.id.title_line);
        }

        public void m5245a() {
            if (!this.f4407f && this.f4408g) {
                this.f4402a.startAnimation(this.f4406e.f4413a);
            }
        }

        public void m5246a(int i) {
            if (i == 0) {
                this.f4409h = C1082R.string.TID_3D;
            } else if (i == 1) {
                this.f4409h = C1082R.string.TID_RAM;
            } else if (i == 3) {
                this.f4409h = C1082R.string.TID_UX;
            } else if (i == 2) {
                this.f4409h = C1082R.string.TID_CPU;
            }
            this.f4404c.setText(this.f4409h);
        }

        public void m5247a(Context context, String str, String str2) {
            if (!this.f4408g) {
                this.f4408g = true;
                this.f4403b.setImageResource(C1082R.drawable.loading_sm);
                this.f4402a.setVisibility(0);
                this.f4405d.setVisibility(0);
            }
            this.f4402a.startAnimation(this.f4406e.f4413a);
            CharSequence string = context.getString(C1082R.string.testing_wait, new Object[]{context.getString(this.f4409h) + " : " + str});
            this.f4404c.setText(r0);
            this.f4405d.setText(str2);
            this.f4406e.f4414b.setText(string);
        }

        public void m5248b(int i) {
            if (!this.f4407f) {
                this.f4407f = true;
                this.f4402a.clearAnimation();
                this.f4402a.setVisibility(4);
                this.f4403b.setImageResource(C1082R.drawable.loading_right);
                this.f4410i.setBackgroundResource(C1082R.color.light_red);
                this.f4404c.setText(this.f4409h);
                if (i == 0) {
                    this.f4406e.f4422m = this.f4406e.f4422m + 45.0f;
                } else if (i == 1) {
                    this.f4406e.f4424o.setTextColor(Color.parseColor("#d36008"));
                    this.f4406e.f4423n.setTextColor(Color.parseColor("#d36008"));
                } else if (i == 2) {
                    this.f4406e.f4424o.setTextColor(Color.parseColor("#57be0b"));
                    this.f4406e.f4423n.setTextColor(Color.parseColor("#57be0b"));
                }
            }
        }
    }

    static {
        f4412k = ScoreBenchActivity.class.getSimpleName();
        f4411c = false;
    }

    public ScoreBenchActivity() {
        this.f4421l = null;
        this.f4422m = 0.0f;
        this.f4413a = null;
        this.f4414b = null;
        this.f4423n = null;
        this.f4424o = null;
        this.f4425p = false;
        this.f4416e = false;
        this.f4417f = null;
        this.f4418g = null;
        this.f4419h = null;
        this.f4420i = null;
        this.f4426q = new C12903(this);
    }

    void m5254a() {
        this.f4424o.setText(((int) this.f4422m) + BuildConfig.FLAVOR);
        this.f4422m = (float) (((double) this.f4422m) + 2.5d);
        if (this.f4422m > 100.0f) {
            this.f4422m = 100.0f;
        }
    }

    public void m5255a(int i) {
        MLog.m6871i(f4412k, "willFinish : " + i);
        f4411c = false;
        if (this.f4416e) {
            unbindService(this.f4426q);
            this.f4416e = false;
        }
        finish();
    }

    void m5256a(int i, String str) {
        try {
            String str2 = BuildConfig.FLAVOR;
            switch (i) {
                case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                    this.f4422m = 99.0f;
                    m5254a();
                    this.f4420i.m5245a();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f4417f.m5248b(0);
                    m5254a();
                    this.f4418g.m5247a(getApplicationContext(), str, getApplicationContext().getResources().getString(C1082R.string.TID_RAM_INFO));
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                case SpdyProtocol.QUIC /*4*/:
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    this.f4417f.m5248b(0);
                    this.f4418g.m5248b(1);
                    m5254a();
                    this.f4419h.m5247a(getApplicationContext(), str, getApplicationContext().getResources().getString(C1082R.string.TID_CPU_INFO));
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                case SpdyProtocol.CUSTOM /*16*/:
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                case C4209a.f14215r /*22*/:
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                    this.f4417f.m5248b(0);
                    this.f4418g.m5248b(1);
                    this.f4419h.m5248b(2);
                    m5254a();
                    this.f4420i.m5247a(getApplicationContext(), str, getApplicationContext().getResources().getString(C1082R.string.TID_UX_INFO));
                case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                case C4209a.f14216s /*24*/:
                    this.f4417f.m5247a(getApplicationContext(), str, getApplicationContext().getResources().getString(C1082R.string.TID_3D_INFO));
                case MsgConstant.ACTION_TYPE_PULLED_FAIL /*50*/:
                    m5254a();
                default:
            }
        } catch (Exception e) {
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        getWindow().addFlags(SpdyProtocol.SLIGHTSSLV2);
        RealFullscreen.setFullscreen(this);
        setContentView(C1082R.layout.activity_main_test);
        if (!this.f4416e) {
            bindService(new Intent(this, BenchmarkService.class), this.f4426q, 1);
        }
        if (bundle != null) {
            this.f4425p = bundle.getBoolean("startBench", false);
        }
        if (!(this.f4425p || getIntent() == null)) {
            try {
                this.f4425p = getIntent().getBooleanExtra("startBench", false);
                if (this.f4425p) {
                    BenchmarkService.m4811b((Context) this);
                }
            } catch (Exception e) {
                m5255a(2);
            }
        }
        this.f4423n = (TextView) findViewById(C1082R.id.text_percent_mark);
        this.f4424o = (TextView) findViewById(C1082R.id.text_percent);
        this.f4414b = (TextView) findViewById(C1082R.id.text_main_info);
        TextView textView = (TextView) findViewById(C1082R.id.text_dev_name);
        String string = getResources().getString(C4459R.string.app_name);
        try {
            str = string + " v" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e2) {
            str = string;
        }
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6415a(false).m6418b(false).m6419c(true).m6420d(true).m6414a(str).m6411a());
        this.f4417f = new C1292b(this, findViewById(C1082R.id.test_layout_3d));
        this.f4418g = new C1292b(this, findViewById(C1082R.id.test_layout_ram));
        this.f4419h = new C1292b(this, findViewById(C1082R.id.test_layout_cpu));
        this.f4420i = new C1292b(this, findViewById(C1082R.id.test_layout_ux));
        this.f4417f.m5246a(0);
        this.f4418g.m5246a(1);
        this.f4419h.m5246a(2);
        this.f4420i.m5246a(3);
        this.f4424o.setTextColor(Color.parseColor("#cd2a1f"));
        this.f4423n.setTextColor(Color.parseColor("#cd2a1f"));
        this.f4422m = 0.0f;
        textView.setText(Build.MODEL);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.antutu.benchmark.update.UI");
        intentFilter.addAction("com.antutu.benchmark.test.STOP");
        intentFilter.addAction("com.antutu.benchmark.test.FINISHED");
        this.f4421l = new C1291a();
        registerReceiver(this.f4421l, intentFilter);
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
        this.f4413a = AnimationUtils.loadAnimation(this, C1082R.anim.rotate);
        this.f4413a.setInterpolator(new LinearInterpolator());
        try {
            ((Button) findViewById(C1082R.id.btn_test_stop)).setOnClickListener(new C12881(this));
        } catch (Exception e3) {
        }
    }

    public void onDestroy() {
        f4411c = false;
        try {
            unregisterReceiver(this.f4421l);
        } catch (Exception e) {
        }
        MLog.m6871i(f4412k, "onDestroy :: I am recycled");
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? true : super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        MLog.m6871i(f4412k, "onLowMemory :: I can not be recycled");
        super.onLowMemory();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        new Handler().postDelayed(new C12892(this), 1000);
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("startBench", this.f4425p);
        super.onSaveInstanceState(bundle);
    }

    public void onTrimMemory(int i) {
        if (i >= 80) {
            MLog.m6871i(f4412k, "onTrimMemory :: I can not be recycled");
        }
    }
}
