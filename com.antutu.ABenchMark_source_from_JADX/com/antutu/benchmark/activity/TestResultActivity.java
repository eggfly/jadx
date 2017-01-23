package com.antutu.benchmark.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1524e;
import com.antutu.benchmark.model.C1525f;
import com.antutu.benchmark.modelreflact.PraiseModel;
import com.antutu.benchmark.modelreflact.ShareInfoModel;
import com.antutu.benchmark.modelreflact.TestResultAdData;
import com.antutu.benchmark.modelreflact.TestResultHuiShouBao;
import com.antutu.benchmark.modelreflact.TestResultModel;
import com.antutu.benchmark.modelreflact.TestResultNewsModel;
import com.antutu.benchmark.modelreflact.TestResultResponseModel;
import com.antutu.benchmark.p036a.C1116h;
import com.antutu.benchmark.p036a.C1193v;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.benchmark.view.MaterialRippleLayout;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.ShareUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.net.C4112a;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

public class TestResultActivity extends C1197a implements OnRefreshListener {
    private ListView f4478a;
    private C1371d f4479b;
    private TextView f4480c;
    private TextView f4481d;
    private TextView f4482e;
    private ShareInfoModel f4483f;
    private CustomSwipeRefreshLayout f4484g;
    private View f4485h;
    private MaterialRippleLayout f4486i;
    private C1193v f4487k;
    private List<TestResultModel> f4488l;
    private ExpandableListView f4489m;
    private List<C1525f> f4490n;
    private List<List<C1524e>> f4491o;
    private C1116h f4492p;
    private PopupWindow f4493q;
    private ImageView f4494r;
    private Handler f4495s;
    private boolean f4496t;
    private ImageView f4497u;
    private OnClickListener f4498v;

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.1 */
    class C13061 implements OnClickListener {
        final /* synthetic */ TestResultActivity f4468a;

        C13061(TestResultActivity testResultActivity) {
            this.f4468a = testResultActivity;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f4468a, MobclickAgentConstants.click_detail_score);
            this.f4468a.f4497u.setImageResource(C1082R.drawable.arrow_up);
            this.f4468a.f4493q.showAsDropDown(this.f4468a.f4485h, 0, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.2 */
    class C13072 implements OnDismissListener {
        final /* synthetic */ TestResultActivity f4469a;

        C13072(TestResultActivity testResultActivity) {
            this.f4469a = testResultActivity;
        }

        public void onDismiss() {
            this.f4469a.f4497u.setImageResource(C1082R.drawable.arrow_down);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.3 */
    class C13083 implements C1095a<TestResultResponseModel> {
        final /* synthetic */ TestResultActivity f4470a;

        C13083(TestResultActivity testResultActivity) {
            this.f4470a = testResultActivity;
        }

        public void m5282a(TestResultResponseModel testResultResponseModel) {
            this.f4470a.f4484g.setRefreshing(false);
            Gson gson = new Gson();
            for (Object obj : testResultResponseModel.getData()) {
                if (TestResultModel.TYPE_AD.equals(obj.getType())) {
                    obj.setData((TestResultAdData) JsonParseUtil.parse(gson.toJson(obj.getData()), TestResultAdData.class));
                } else if (TestResultModel.TYPE_NEWSLIST.equals(obj.getType())) {
                    obj.setData(((TestResultNewsModel) JsonParseUtil.parse(gson.toJson(obj), TestResultNewsModel.class)).getData());
                } else if (TestResultModel.TYPE_HUISHOUBAO.equals(obj.getType())) {
                    obj.setData((TestResultHuiShouBao) JsonParseUtil.parse(gson.toJson(obj.getData()), TestResultHuiShouBao.class));
                }
            }
            this.f4470a.f4487k.m4955a(testResultResponseModel.getData());
            if (this.f4470a.f4496t) {
                this.f4470a.f4496t = false;
                this.f4470a.m5304e();
            }
        }

        public void m5284a(String str) {
            this.f4470a.f4484g.setRefreshing(false);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.4 */
    class C13094 implements OnClickListener {
        final /* synthetic */ TestResultActivity f4471a;

        C13094(TestResultActivity testResultActivity) {
            this.f4471a = testResultActivity;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f4471a, MobclickAgentConstants.click_home_item_share);
            if (this.f4471a.f4483f != null) {
                ShareUtil.showShare(this.f4471a, this.f4471a.f4483f.getUrl(), null, this.f4471a.getString(C1082R.string.my_phone_score), this.f4471a.getString(C1082R.string.my_phone_desc, new Object[]{C1503b.m5915c().m5970w(), Integer.valueOf(C1503b.m5915c().m5967t())}));
                return;
            }
            Methods.showToast(this.f4471a, (int) C1082R.string.not_have_data, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.5 */
    class C13105 implements C1095a<PraiseModel> {
        final /* synthetic */ TestResultActivity f4472a;

        C13105(TestResultActivity testResultActivity) {
            this.f4472a = testResultActivity;
        }

        public void m5285a(PraiseModel praiseModel) {
            Methods.editSharedPreferences("phone_level", praiseModel.getLevel());
            this.f4472a.m5295a(praiseModel.getLevel());
        }

        public void m5287a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.6 */
    class C13116 implements C1095a<ShareInfoModel> {
        final /* synthetic */ TestResultActivity f4473a;

        C13116(TestResultActivity testResultActivity) {
            this.f4473a = testResultActivity;
        }

        public void m5288a(ShareInfoModel shareInfoModel) {
            this.f4473a.f4483f = shareInfoModel;
        }

        public void m5290a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.7 */
    class C13127 implements AnimationListener {
        final /* synthetic */ TestResultActivity f4474a;

        C13127(TestResultActivity testResultActivity) {
            this.f4474a = testResultActivity;
        }

        public void onAnimationEnd(Animation animation) {
            this.f4474a.f4494r.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.8 */
    class C13138 implements Runnable {
        final /* synthetic */ Animation f4475a;
        final /* synthetic */ TestResultActivity f4476b;

        C13138(TestResultActivity testResultActivity, Animation animation) {
            this.f4476b = testResultActivity;
            this.f4475a = animation;
        }

        public void run() {
            this.f4476b.f4494r.startAnimation(this.f4475a);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.TestResultActivity.9 */
    class C13149 implements OnGroupClickListener {
        final /* synthetic */ TestResultActivity f4477a;

        C13149(TestResultActivity testResultActivity) {
            this.f4477a = testResultActivity;
        }

        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (i == 0) {
                MobclickAgent.onEvent(this.f4477a, MobclickAgentConstants.score_3d);
            } else if (i == 1) {
                MobclickAgent.onEvent(this.f4477a, MobclickAgentConstants.score_ux);
            } else if (i == 2) {
                MobclickAgent.onEvent(this.f4477a, MobclickAgentConstants.score_cpu);
            }
            return false;
        }
    }

    public TestResultActivity() {
        this.f4485h = null;
        this.f4488l = new ArrayList();
        this.f4490n = new ArrayList();
        this.f4491o = new ArrayList();
        this.f4495s = new Handler(Looper.getMainLooper());
        this.f4496t = false;
        this.f4498v = new C13094(this);
    }

    private void m5293a() {
        View inflate = View.inflate(this, C1082R.layout.popup_detail_score, null);
        this.f4493q = new PopupWindow(inflate, -1, -2, true);
        this.f4493q.setFocusable(true);
        this.f4493q.setTouchable(true);
        this.f4493q.setOutsideTouchable(true);
        this.f4493q.setBackgroundDrawable(new BitmapDrawable());
        this.f4489m = (ExpandableListView) inflate.findViewById(C1082R.id.elv_detail_score);
        this.f4489m.setGroupIndicator(null);
        m5308h();
        m5302d();
        this.f4492p = new C1116h(this, this.f4490n, this.f4491o);
        this.f4489m.setAdapter(this.f4492p);
    }

    private void m5295a(String str) {
        this.f4479b.m5432b(new C13116(this), str);
    }

    private void m5298b() {
        this.f4484g.setProgressViewOffset(false, 0, Utils.dpToPxInt(this, 24.0f));
        this.f4484g.setRefreshing(true);
        this.f4479b.m5435e(new C13083(this));
    }

    private void m5300c() {
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.test_detail)).m6413a(this.j).m6416b((int) C1082R.drawable.share).m6418b(true).m6420d(false).m6417b(this.f4498v).m6411a());
    }

    private void m5302d() {
        this.f4480c.setText(C1503b.m5915c().m5967t() + BuildConfig.FLAVOR);
        if (C1503b.m5915c().m5966s()) {
            this.f4480c.setTextColor(getResources().getColor(C1082R.color.fake_score));
            this.f4482e.setTextColor(getResources().getColor(C1082R.color.fake_score));
        } else {
            this.f4480c.setTextColor(getResources().getColor(C1082R.color.green_text));
            this.f4482e.setTextColor(getResources().getColor(C1082R.color.green_text));
        }
        this.f4481d.setText(C1503b.m5915c().m5970w());
        this.f4479b.m5429a(new C13105(this));
        m5295a(Methods.getSharedPreferencesString("phone_level", null));
    }

    private void m5304e() {
        this.f4494r.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C1082R.anim.flash_arrow_up);
        loadAnimation.setAnimationListener(new C13127(this));
        this.f4495s.postDelayed(new C13138(this, loadAnimation), 500);
    }

    private void m5308h() {
        int benchmarkScore = jni.benchmarkScore(this, 30);
        int benchmarkScore2 = jni.benchmarkScore(this, 31);
        int benchmarkScore3 = jni.benchmarkScore(this, 32);
        int benchmarkScore4 = jni.benchmarkScore(this, 33);
        int benchmarkScore5 = jni.benchmarkScore(this, 34);
        int benchmarkScore6 = jni.benchmarkScore(this, 35);
        int benchmarkScore7 = jni.benchmarkScore(this, 36);
        int benchmarkScore8 = jni.benchmarkScore(this, 37);
        int benchmarkScore9 = jni.benchmarkScore(this, 38);
        int benchmarkScore10 = jni.benchmarkScore(this, 39);
        int benchmarkScore11 = jni.benchmarkScore(this, 40);
        int i = (benchmarkScore3 + benchmarkScore4) + benchmarkScore2;
        int i2 = (((benchmarkScore5 + benchmarkScore6) + benchmarkScore7) + benchmarkScore8) + benchmarkScore9;
        int i3 = benchmarkScore10 + benchmarkScore11;
        String string = i3 > 0 ? i3 + BuildConfig.FLAVOR : getString(C1082R.string.unsupported);
        String string2 = benchmarkScore10 > 0 ? benchmarkScore10 + BuildConfig.FLAVOR : getString(C1082R.string.unsupported);
        String string3 = benchmarkScore11 > 0 ? benchmarkScore11 + BuildConfig.FLAVOR : getString(C1082R.string.unsupported);
        boolean[] r = C1503b.m5915c().m5965r();
        List list = this.f4490n;
        String string4 = getString(C1082R.string.score_3d_property);
        String str = string + BuildConfig.FLAVOR;
        boolean z = r[39] || r[40];
        list.add(new C1525f(string4, str, z));
        list = this.f4490n;
        string4 = getString(C1082R.string.score_ux_property);
        String str2 = i2 + BuildConfig.FLAVOR;
        z = r[34] || r[35] || r[36] || r[37] || r[38];
        list.add(new C1525f(string4, str2, z));
        List list2 = this.f4490n;
        String string5 = getString(C1082R.string.score_cpu_property);
        String str3 = i + BuildConfig.FLAVOR;
        z = r[31] || r[32] || r[33];
        list2.add(new C1525f(string5, str3, z));
        this.f4490n.add(new C1525f(getString(C1082R.string.score_ram_property), benchmarkScore + BuildConfig.FLAVOR, r[30]));
        List arrayList = new ArrayList();
        arrayList.add(new C1524e(getString(C1082R.string.SID_3D_MAROONED), string3 + BuildConfig.FLAVOR, r[40]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_3D_GARDEN), string2 + BuildConfig.FLAVOR, r[39]));
        i3 = C1503b.m5915c().m5936c((Context) this);
        string3 = i3 < 15000 ? getString(C1082R.string.score_gpu_3d_15000) : (i3 < 15000 || i3 >= BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT) ? (i3 < BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT || i3 >= C4112a.ACCS_RECEIVE_TIMEOUT) ? getString(C1082R.string.score_gpu_3d_40000) : getString(C1082R.string.score_gpu_3d_20000_40000) : getString(C1082R.string.score_gpu_3d_15000_20000);
        arrayList.add(new C1524e(string3, BuildConfig.FLAVOR, false));
        this.f4491o.add(arrayList);
        List arrayList2 = new ArrayList();
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_SEC), benchmarkScore5 + BuildConfig.FLAVOR, r[34]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_DATA), benchmarkScore6 + BuildConfig.FLAVOR, r[35]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_GAME), benchmarkScore7 + BuildConfig.FLAVOR, r[36]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_IMG), benchmarkScore8 + BuildConfig.FLAVOR, r[37]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_IO), benchmarkScore9 + BuildConfig.FLAVOR, r[38]));
        this.f4491o.add(arrayList2);
        arrayList = new ArrayList();
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_MATH), benchmarkScore2 + BuildConfig.FLAVOR, r[31]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_APP), benchmarkScore3 + BuildConfig.FLAVOR, r[32]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_MULTI), benchmarkScore4 + BuildConfig.FLAVOR, r[33]));
        i3 = C1503b.m5915c().m5932b((Context) this);
        string3 = i3 < 8000 ? getString(C1082R.string.score_cpu_float_800) : (i3 < 8000 || i3 >= 15000) ? (i3 < 15000 || i3 >= 24000) ? getString(C1082R.string.score_cpu_float_5000) : getString(C1082R.string.score_cpu_float_3000) : getString(C1082R.string.score_cpu_float_1500);
        arrayList.add(new C1524e(string3, BuildConfig.FLAVOR, false));
        this.f4491o.add(arrayList);
        this.f4491o.add(new ArrayList());
    }

    private void m5310i() {
        this.f4489m.setOnGroupClickListener(new C13149(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_testresult);
        m5300c();
        this.f4479b = new C1371d(this);
        this.f4496t = getIntent().getBooleanExtra("INTENT_EXTRA_SHOW_ARROW", false);
        this.f4485h = View.inflate(this, C1082R.layout.header_activity_test_result, null);
        this.f4484g = (CustomSwipeRefreshLayout) findViewById(C1082R.id.sr_ll_refresh);
        this.f4478a = (ListView) findViewById(C1082R.id.list);
        this.f4480c = (TextView) this.f4485h.findViewById(C1082R.id.tv_score);
        this.f4481d = (TextView) this.f4485h.findViewById(C1082R.id.tv_device_name);
        this.f4482e = (TextView) this.f4485h.findViewById(C1082R.id.tv_score_tail);
        this.f4486i = (MaterialRippleLayout) this.f4485h.findViewById(C1082R.id.ll_bg);
        this.f4494r = (ImageView) findViewById(C1082R.id.iv_flash_arrow);
        this.f4497u = (ImageView) this.f4485h.findViewById(C1082R.id.arrow);
        m5293a();
        m5310i();
        this.f4478a.addHeaderView(this.f4485h);
        this.f4487k = new C1193v(this, this.f4488l);
        this.f4478a.setAdapter(this.f4487k);
        this.f4484g.setOnRefreshListener(this);
        this.f4486i.setOnClickListener(new C13061(this));
        this.f4493q.setOnDismissListener(new C13072(this));
        m5298b();
        InfocUtil.antutu_tabshow(this, 5);
    }

    public void onRefresh() {
        m5298b();
    }
}
