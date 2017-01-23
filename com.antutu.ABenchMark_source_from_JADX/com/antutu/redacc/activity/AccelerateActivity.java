package com.antutu.redacc.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.activity.C1708a.C1714a;
import com.antutu.redacc.p066a.C1695a;
import com.antutu.redacc.p066a.C1695a.C1693a;
import com.antutu.redacc.p067f.C1744a;
import com.antutu.redacc.p067f.C1745b;
import com.antutu.redacc.p067f.C1747d;
import com.antutu.redacc.p067f.C1755l;
import com.antutu.redacc.p067f.C1757n;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p070d.C1735b;
import com.antutu.redacc.p072e.C1737a;
import com.antutu.redacc.view.C1779a;
import com.antutu.redacc.view.C1780b;
import com.antutu.redacc.view.C1780b.C1703a;
import com.antutu.redacc.view.C1781c;
import com.antutu.utils.widget.SystemBarTintManager;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class AccelerateActivity extends C1708a {
    private C1781c f6066A;
    private int f6067B;
    private List<C1737a> f6068e;
    private int f6069f;
    private int f6070g;
    private int f6071h;
    private int f6072i;
    private boolean f6073j;
    private boolean f6074k;
    private LinearLayout f6075l;
    private LinearLayout f6076m;
    private ImageView f6077n;
    private ImageView f6078o;
    private ImageView f6079p;
    private TextView f6080q;
    private Button f6081r;
    private RecyclerView f6082s;
    private ImageView f6083t;
    private TextView f6084u;
    private TextView f6085v;
    private C1780b f6086w;
    private C1714a f6087x;
    private C1695a f6088y;
    private BroadcastReceiver f6089z;

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.1 */
    class C17001 implements OnClickListener {
        final /* synthetic */ AccelerateActivity f6055a;

        /* renamed from: com.antutu.redacc.activity.AccelerateActivity.1.1 */
        class C16991 extends Thread {
            final /* synthetic */ C17001 f6054a;

            C16991(C17001 c17001) {
                this.f6054a = c17001;
            }

            public void run() {
                this.f6054a.f6055a.m6638d();
            }
        }

        C17001(AccelerateActivity accelerateActivity) {
            this.f6055a = accelerateActivity;
        }

        public void onClick(View view) {
            if (this.f6055a.f6081r.isClickable()) {
                MobclickAgent.onEvent(this.f6055a, "accelerate_now");
                C1744a.m6736a(this.f6055a, 2, this.f6055a.f6069f);
                new C16991(this).start();
            }
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.2 */
    class C17012 implements OnClickListener {
        final /* synthetic */ AccelerateActivity f6056a;

        C17012(AccelerateActivity accelerateActivity) {
            this.f6056a = accelerateActivity;
        }

        public void onClick(View view) {
            if (this.f6056a.f6069f == 0) {
                this.f6056a.f6083t.setBackgroundResource(C1692R.drawable.bg_cb_checked);
                this.f6056a.f6083t.setImageResource(C1692R.drawable.cb_checked_all);
                if (this.f6056a.f6068e != null) {
                    for (C1737a a : this.f6056a.f6068e) {
                        a.m6707a(true);
                        this.f6056a.f6069f = this.f6056a.f6069f + 1;
                    }
                    this.f6056a.f6088y.m6611a(this.f6056a.f6068e);
                }
            } else {
                this.f6056a.f6069f = 0;
                this.f6056a.f6083t.setBackgroundResource(C1692R.drawable.bg_cb_unchecked);
                this.f6056a.f6083t.setImageResource(C1692R.drawable.bg_cb_unchecked);
                if (this.f6056a.f6068e != null) {
                    for (C1737a a2 : this.f6056a.f6068e) {
                        a2.m6707a(false);
                    }
                    this.f6056a.f6088y.m6611a(this.f6056a.f6068e);
                }
            }
            this.f6056a.f6085v.setText(this.f6056a.f6069f + BuildConfig.FLAVOR);
            AccelerateActivity accelerateActivity = this.f6056a;
            boolean z = !this.f6056a.f6074k && this.f6056a.f6069f > 0;
            accelerateActivity.m6627a(z);
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.3 */
    class C17023 implements C1693a {
        final /* synthetic */ AccelerateActivity f6057a;

        C17023(AccelerateActivity accelerateActivity) {
            this.f6057a = accelerateActivity;
        }

        public void m6613a(C1737a c1737a) {
            if (c1737a.m6717e()) {
                this.f6056a.f6069f = this.f6057a.f6069f + 1;
            } else {
                this.f6057a.f6069f = this.f6057a.f6069f - 1;
            }
            this.f6057a.f6085v.setText(this.f6057a.f6069f + BuildConfig.FLAVOR);
            AccelerateActivity accelerateActivity = this.f6057a;
            boolean z = !this.f6057a.f6074k && this.f6057a.f6069f > 0;
            accelerateActivity.m6627a(z);
            this.f6057a.m6642f();
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.4 */
    class C17044 implements C1703a {
        final /* synthetic */ AccelerateActivity f6058a;

        C17044(AccelerateActivity accelerateActivity) {
            this.f6058a = accelerateActivity;
        }

        public void m6615a() {
            this.f6058a.m6647i();
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.5 */
    class C17055 implements OnClickListener {
        final /* synthetic */ AccelerateActivity f6059a;

        C17055(AccelerateActivity accelerateActivity) {
            this.f6059a = accelerateActivity;
        }

        public void onClick(View view) {
            try {
                C1762r.m6776e().m6786a(this.f6059a.getApplicationContext(), ((LayoutInflater) this.f6059a.getSystemService("layout_inflater")).inflate(C1692R.layout.toast_accelerate_tips, null));
                C1762r.m6776e().m6811m();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.6 */
    class C17066 extends BroadcastReceiver {
        final /* synthetic */ AccelerateActivity f6060a;

        C17066(AccelerateActivity accelerateActivity) {
            this.f6060a = accelerateActivity;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("MSG_BR_ON_KILL_APP")) {
                    if (this.f6060a.f6074k) {
                        this.f6060a.m6626a(intent.getStringExtra(Constants.KEY_ELECTION_PKG), intent.getStringExtra("index"));
                    }
                } else if ("android.intent.action.BATTERY_CHANGED".equals(action) && !this.f6060a.f6073j) {
                    if (this.f6060a.f6071h == -273) {
                        this.f6060a.f6071h = intent.getIntExtra("temperature", 0);
                        this.f6060a.f6072i = 0;
                        this.f6060a.f6073j = true;
                    } else {
                        this.f6060a.f6071h = intent.getIntExtra("temperature", 0);
                    }
                    this.f6060a.f6071h = C1745b.m6737a(this.f6060a).m6741a(this.f6060a.f6071h);
                    this.f6060a.f6070g = intent.getIntExtra("health", 2);
                    if (this.f6060a.f6070g == 2 && this.f6060a.f6071h >= 350) {
                        this.f6060a.f6070g = 3;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 5;
                    this.f6060a.f6087x.sendMessage(obtain);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.redacc.activity.AccelerateActivity.a */
    class C1707a extends AsyncTask<Integer, Integer, String> {
        final /* synthetic */ AccelerateActivity f6061a;

        C1707a(AccelerateActivity accelerateActivity) {
            this.f6061a = accelerateActivity;
        }

        protected String m6616a(Integer... numArr) {
            try {
                int intValue = numArr[0].intValue();
                C1762r.m6776e().m6804g(this.f6061a);
                if (this.f6061a.f6068e == null) {
                    if (VERSION.SDK_INT < 21) {
                        C1762r.m6776e().m6783a(this.f6061a, false, false, false);
                    } else {
                        C1762r.m6776e().m6782a(this.f6061a, true, false);
                    }
                }
                if (intValue == 1) {
                    if (C1762r.m6776e().m6798c()) {
                        C1762r.m6776e().m6780a(this.f6061a, 1200);
                    } else {
                        if (C1762r.m6776e().m6800d()) {
                            C1762r.m6776e().m6781a(this.f6061a, false);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Exception e2) {
            }
            return BuildConfig.FLAVOR;
        }

        protected void m6617a(String str) {
            super.onPostExecute(str);
            this.f6061a.f6074k = false;
            this.f6061a.f6086w.m6860c();
            this.f6061a.m6627a(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6616a((Integer[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6617a((String) obj);
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.f6061a.f6086w.m6856a();
            switch (this.f6061a.f6067B) {
                case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    Toast.makeText(this.f6061a, C1692R.string.coocler_cooling_down, 1).show();
                    break;
            }
            this.f6061a.f6074k = true;
            this.f6061a.m6627a(false);
        }
    }

    public AccelerateActivity() {
        this.f6068e = null;
        this.f6069f = 0;
        this.f6071h = -273;
        this.f6072i = 0;
        this.f6073j = false;
        this.f6074k = false;
        this.f6089z = null;
    }

    private int m6620a(int i, int i2, int i3, int i4) {
        if (i3 == i4) {
            return i4;
        }
        float abs = i > i2 ? 1.0f - (((float) (i - i2)) / ((float) Math.abs(i2))) : 1.0f - (((float) (i2 - i)) / ((float) Math.abs(i2)));
        int i5 = (i3 >> 16) & MotionEventCompat.ACTION_MASK;
        int i6 = (i3 >> 8) & MotionEventCompat.ACTION_MASK;
        int i7 = i3 & MotionEventCompat.ACTION_MASK;
        return ((((((int) ((((float) (((i4 >> 16) & MotionEventCompat.ACTION_MASK) - i5)) * abs) + ((float) i5))) << 16) & 16711680) + SystemBarTintManager.DEFAULT_TINT_COLOR) + ((((int) ((((float) (((i4 >> 8) & MotionEventCompat.ACTION_MASK) - i6)) * abs) + ((float) i6))) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) + (((int) ((abs * ((float) ((i4 & MotionEventCompat.ACTION_MASK) - i7))) + ((float) i7))) & MotionEventCompat.ACTION_MASK);
    }

    private void m6623a(int i) {
        this.f6075l.setBackgroundColor(i);
        this.f6076m.setBackgroundColor(i);
    }

    private void m6626a(String str, String str2) {
        try {
            if (str.equals("com.android.settings")) {
                this.f6087x.sendEmptyMessage(3);
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str2;
            this.f6087x.sendMessage(obtain);
        } catch (Exception e) {
        }
    }

    private void m6627a(boolean z) {
        this.f6081r.setClickable(z);
        this.f6081r.setBackgroundColor(getResources().getColor(z ? C1692R.color.bg_boost_now : C1692R.color.text_tran_99));
    }

    private void m6630b() {
        this.f6075l = (LinearLayout) findViewById(C1692R.id.layout_title);
        this.f6076m = (LinearLayout) findViewById(C1692R.id.ll_boost_header);
        this.f6077n = (ImageView) findViewById(C1692R.id.iv_back);
        this.f6078o = (ImageView) findViewById(C1692R.id.iv_setting);
        this.f6079p = (ImageView) findViewById(C1692R.id.iv_thermometer);
        this.f6080q = (TextView) findViewById(C1692R.id.tv_temperture);
        this.f6081r = (Button) findViewById(C1692R.id.tv_accelerator_now);
        this.f6083t = (ImageView) findViewById(C1692R.id.iv_selectApp);
        this.f6084u = (TextView) findViewById(C1692R.id.tv_runningAppCount);
        this.f6085v = (TextView) findViewById(C1692R.id.tv_selectedAppCount);
        this.f6082s = (RecyclerView) findViewById(C1692R.id.rv_apps);
        this.f6082s.setLayoutManager(new LinearLayoutManager(this));
        this.f6082s.setItemAnimator(new aj());
        this.f6066A = new C1781c(this);
        this.f6079p.setImageDrawable(this.f6066A);
        this.f6088y = new C1695a(this, this, null);
        this.f6082s.setAdapter(this.f6088y);
    }

    private void m6633c() {
        this.f6077n.setOnClickListener(this.c);
        this.f6078o.setOnClickListener(this.d);
        this.f6081r.setOnClickListener(new C17001(this));
        m6627a(false);
        this.f6083t.setOnClickListener(new C17012(this));
        this.f6088y.m6609a(new C17023(this));
        this.f6086w.m6857a(new C17044(this));
    }

    private void m6638d() {
        boolean a = C1762r.m6776e().m6791a();
        if (C1755l.m6760a(this).m6761a("IS_FIRST_REQUEST_ROOT", true)) {
            C1755l.m6760a(this).m6762b("IS_FIRST_REQUEST_ROOT", false);
            C1762r.m6776e().m6807i();
        }
        if (a) {
            C1762r.m6776e().m6794b(true);
            try {
                C1762r.m6776e().m6807i();
            } catch (Exception e) {
            }
            this.f6087x.sendEmptyMessage(7);
            return;
        }
        C1762r.m6776e().m6794b(false);
        if (C1762r.m6776e().m6800d()) {
            this.f6087x.sendEmptyMessage(8);
        } else {
            this.f6087x.sendEmptyMessage(9);
        }
    }

    private void m6640e() {
        if (VERSION.SDK_INT < 21) {
            C1762r.m6776e().m6783a((Context) this, false, true, false);
        } else {
            C1762r.m6776e().m6782a((Context) this, true, false);
        }
        this.f6087x.sendEmptyMessage(6);
    }

    private void m6642f() {
        if (this.f6069f == 0) {
            this.f6083t.setBackgroundResource(C1692R.drawable.bg_cb_unchecked);
            this.f6083t.setImageResource(C1692R.drawable.bg_cb_unchecked);
        } else if (this.f6068e == null || this.f6069f >= this.f6068e.size()) {
            this.f6083t.setBackgroundResource(C1692R.drawable.bg_cb_checked);
            this.f6083t.setImageResource(C1692R.drawable.cb_checked_all);
        } else {
            this.f6083t.setBackgroundResource(C1692R.drawable.bg_cb_checked);
            this.f6083t.setImageResource(C1692R.drawable.cb_checked);
        }
    }

    private void m6644g() {
        if (this.f6089z == null) {
            this.f6089z = new C17066(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("MSG_BR_ON_KILL_APP");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            registerReceiver(this.f6089z, intentFilter);
        }
    }

    private void m6646h() {
        try {
            if (this.f6089z != null) {
                unregisterReceiver(this.f6089z);
                this.f6089z = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m6647i() {
        C1745b.m6737a((Context) this).m6742a();
        finish();
        if (this.a != 1) {
            try {
                startActivity(getPackageManager().getLaunchIntentForPackage("com.antutu.ABenchMark"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m6658a(Message message) {
        switch (message.what) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f6086w.m6858a((String) message.obj);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                finish();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                switch (this.f6067B) {
                    case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        this.f6086w.m6859b();
                        Toast.makeText(this, C1692R.string.coocler_cooling_finish, 0).show();
                        m6647i();
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        this.f6086w.m6859b();
                    default:
                }
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                int color;
                switch (this.f6070g) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        color = getResources().getColor(C1692R.color.bg_boost_header_good);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        color = getResources().getColor(C1692R.color.bg_boost_header_hot);
                        break;
                    default:
                        color = getResources().getColor(C1692R.color.bg_boost_header_cold);
                        break;
                }
                if (!this.f6073j) {
                    this.f6080q.setText(C1757n.m6764a(this.f6071h, false));
                } else if (this.f6071h > 0) {
                    this.f6072i = (int) (((double) this.f6072i) + (Math.random() * 10.0d));
                    if (this.f6072i < this.f6071h) {
                        this.f6066A.m6863a(this.f6072i);
                        this.f6080q.setText(C1757n.m6764a(this.f6072i, false));
                        color = m6620a(this.f6072i, this.f6071h, getResources().getColor(C1692R.color.bg_boost_header_cold), color);
                        this.f6087x.sendEmptyMessageDelayed(5, 20);
                    } else {
                        this.f6066A.m6863a(this.f6071h);
                        this.f6080q.setText(C1757n.m6764a(this.f6071h, false));
                        this.f6073j = false;
                    }
                } else {
                    this.f6072i = (int) (((double) this.f6072i) - (Math.random() * 10.0d));
                    if (this.f6072i < this.f6071h) {
                        this.f6066A.m6863a(this.f6071h);
                        this.f6080q.setText(C1757n.m6764a(this.f6071h, false));
                        this.f6073j = false;
                    } else {
                        this.f6066A.m6863a(this.f6072i);
                        this.f6080q.setText(C1757n.m6764a(this.f6072i, false));
                        color = m6620a(this.f6072i, this.f6071h, getResources().getColor(C1692R.color.bg_boost_header_cold), color);
                        this.f6087x.sendEmptyMessageDelayed(5, 20);
                    }
                }
                m6623a(color);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                this.f6068e = C1762r.m6776e().m6805g();
                this.f6082s.setAdapter(new C1735b(this.f6088y, this.f6082s));
                this.f6069f = 0;
                int size = this.f6068e.size();
                for (int i = 0; i < size; i++) {
                    if (((C1737a) this.f6068e.get(i)).m6717e()) {
                        this.f6069f++;
                    }
                }
                C1744a.m6736a(this, 1, this.f6069f);
                boolean z = !this.f6074k && this.f6069f > 0;
                m6627a(z);
                this.f6084u.setText(String.valueOf(this.f6068e.size()));
                this.f6088y.m6611a(this.f6068e);
                this.f6085v.setText(this.f6069f + BuildConfig.FLAVOR);
                m6642f();
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                new C1707a(this).execute(new Integer[]{Integer.valueOf(1)});
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                new C1707a(this).execute(new Integer[]{Integer.valueOf(1)});
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                C1779a c1779a = new C1779a(this, C1692R.style.Theme_CustomDialog);
                c1779a.setCanceledOnTouchOutside(false);
                c1779a.m6855a(new C17055(this));
                c1779a.show();
            default:
                super.m6619a(message);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(4194304);
        setContentView(C1692R.layout.activity_accelerate);
        if (getIntent() != null) {
            this.a = getIntent().getIntExtra("isLive", 0);
            this.b = getIntent().getIntExtra(AgooConstants.MESSAGE_FROM_PKG, 0);
        }
        this.f6067B = C1747d.m6744a(this, 24, true);
        this.f6086w = new C1780b(this);
        m6644g();
        this.f6087x = new C1714a(this, this);
        m6630b();
        m6633c();
        m6640e();
        m6644g();
        if (getIntent().getBooleanExtra("EXTRA_FROM_NOTIFY", false)) {
            MobclickAgent.onEvent(this, "optimizeActivityStart");
        }
        if (getIntent().getBooleanExtra("EXTRA_START_CLEAN", false) && !this.f6074k) {
            m6638d();
        }
    }

    protected void onDestroy() {
        m6646h();
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("EXTRA_FROM_NOTIFY", false)) {
            MobclickAgent.onEvent(this, "optimizeActivityStart");
        }
        if (intent.getBooleanExtra("EXTRA_START_CLEAN", false) && !this.f6074k) {
            m6638d();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
