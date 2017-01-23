package com.antutu.benchmark.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.GridView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1521a;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1524e;
import com.antutu.benchmark.model.C1525f;
import com.antutu.benchmark.modelreflact.PraiseModel;
import com.antutu.benchmark.modelreflact.ShareInfoModel;
import com.antutu.benchmark.p036a.C1113g;
import com.antutu.benchmark.p036a.C1116h;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.ShareUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.net.C4112a;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailScoreActivity extends C1197a {
    private View f4173a;
    private View f4174b;
    private ExpandableListView f4175c;
    private C1116h f4176d;
    private List<C1525f> f4177e;
    private List<List<C1524e>> f4178f;
    private TextView f4179g;
    private TextView f4180h;
    private TextView f4181i;
    private TextView f4182k;
    private TextView f4183l;
    private GridView f4184m;
    private C1371d f4185n;
    private ShareInfoModel f4186o;
    private C1113g f4187p;
    private List<C1518a> f4188q;
    private OnClickListener f4189r;

    /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.1 */
    class C12301 implements DownloadJobListener {
        final /* synthetic */ DetailScoreActivity f4168a;

        /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.1.1 */
        class C12291 implements Runnable {
            final /* synthetic */ Map f4166a;
            final /* synthetic */ C12301 f4167b;

            C12291(C12301 c12301, Map map) {
                this.f4167b = c12301;
                this.f4166a = map;
            }

            public void run() {
                List list = (List) this.f4166a.get("10002");
                if (list != null && list.size() > 0) {
                    this.f4167b.f4168a.f4187p.m4872a(list);
                    this.f4167b.f4168a.f4187p.notifyDataSetChanged();
                    if (this.f4167b.f4168a.f4175c.getFooterViewsCount() <= 0) {
                        this.f4167b.f4168a.f4175c.addFooterView(this.f4167b.f4168a.f4174b);
                    }
                }
            }
        }

        C12301(DetailScoreActivity detailScoreActivity) {
            this.f4168a = detailScoreActivity;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                try {
                    this.f4168a.runOnUiThread(new C12291(this, ((C1521a) c1519k).m6045a()));
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.2 */
    class C12312 implements OnGroupClickListener {
        final /* synthetic */ DetailScoreActivity f4169a;

        C12312(DetailScoreActivity detailScoreActivity) {
            this.f4169a = detailScoreActivity;
        }

        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            if (i == 0) {
                MobclickAgent.onEvent(this.f4169a, MobclickAgentConstants.score_3d);
            } else if (i == 1) {
                MobclickAgent.onEvent(this.f4169a, MobclickAgentConstants.score_ux);
            } else if (i == 2) {
                MobclickAgent.onEvent(this.f4169a, MobclickAgentConstants.score_cpu);
            }
            return false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.3 */
    class C12323 implements C1095a<PraiseModel> {
        final /* synthetic */ DetailScoreActivity f4170a;

        C12323(DetailScoreActivity detailScoreActivity) {
            this.f4170a = detailScoreActivity;
        }

        public void m5042a(PraiseModel praiseModel) {
            this.f4170a.f4182k.setVisibility(0);
            this.f4170a.f4181i.setText(praiseModel.getGoodpercent());
            Methods.editSharedPreferences("phone_level", praiseModel.getLevel());
            this.f4170a.m5052a(praiseModel.getLevel());
        }

        public void m5044a(String str) {
            this.f4170a.f4182k.setVisibility(8);
            this.f4170a.f4181i.setText(this.f4170a.getString(C1082R.string.not_praise));
        }
    }

    /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.4 */
    class C12334 implements OnClickListener {
        final /* synthetic */ DetailScoreActivity f4171a;

        C12334(DetailScoreActivity detailScoreActivity) {
            this.f4171a = detailScoreActivity;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f4171a, MobclickAgentConstants.click_home_item_share);
            if (this.f4171a.f4186o != null) {
                ShareUtil.showShare(this.f4171a, this.f4171a.f4186o.getUrl(), null, this.f4171a.getString(C1082R.string.my_phone_score), this.f4171a.getString(C1082R.string.my_phone_desc, new Object[]{C1503b.m5915c().m5970w(), Integer.valueOf(C1503b.m5915c().m5967t())}));
                return;
            }
            Methods.showToast(this.f4171a, (int) C1082R.string.not_have_data, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.DetailScoreActivity.5 */
    class C12345 implements C1095a<ShareInfoModel> {
        final /* synthetic */ DetailScoreActivity f4172a;

        C12345(DetailScoreActivity detailScoreActivity) {
            this.f4172a = detailScoreActivity;
        }

        public void m5045a(ShareInfoModel shareInfoModel) {
            this.f4172a.f4186o = shareInfoModel;
        }

        public void m5047a(String str) {
        }
    }

    public DetailScoreActivity() {
        this.f4177e = new ArrayList();
        this.f4178f = new ArrayList();
        this.f4188q = new ArrayList();
        this.f4189r = new C12334(this);
    }

    private void m5050a() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("oem=").append(C1503b.m5915c().m5954k()).append("&lan=").append(C1523d.m6061b()).append("&softid=123").append("&adversion=" + Utils.getAdVersion(this) + BuildConfig.FLAVOR).append("&aid=10").append("&format=json").append("&imei=").append(C1503b.m5915c().m5925a((Context) this, false)).append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&device=").append(Build.DEVICE).append("&str1=").append(C1503b.m5915c().m5961n()).append("&softversion=").append(C1503b.m5915c().m5958m());
            MLog.m6864d("hzd, loadAds, parms: " + stringBuilder.toString());
            String dataSafe = jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
            HashMap hashMap = new HashMap();
            hashMap.put("gpv", dataSafe);
            DownloadJob downloadJob = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=adinfo&data=1", new C1521a("10002"), hashMap);
            downloadJob.setDownloadJobListener(new C12301(this));
            downloadJob.start(false);
        } catch (Exception e) {
        }
    }

    private void m5052a(String str) {
        this.f4185n.m5432b(new C12345(this), str);
    }

    private void m5054b() {
        this.f4175c.setOnGroupClickListener(new C12312(this));
    }

    private void m5056c() {
        this.f4179g.setText(C1503b.m5915c().m5967t() + BuildConfig.FLAVOR);
        if (C1503b.m5915c().m5966s()) {
            this.f4179g.setTextColor(getResources().getColor(C1082R.color.fake_score));
            this.f4183l.setTextColor(getResources().getColor(C1082R.color.fake_score));
        } else {
            this.f4179g.setTextColor(getResources().getColor(C1082R.color.green_text));
            this.f4183l.setTextColor(getResources().getColor(C1082R.color.green_text));
        }
        this.f4180h.setText(C1503b.m5915c().m5970w());
        this.f4185n.m5429a(new C12323(this));
        m5052a(Methods.getSharedPreferencesString("phone_level", null));
    }

    private void m5058d() {
        this.f4179g = (TextView) this.f4173a.findViewById(C1082R.id.tv_score);
        this.f4180h = (TextView) this.f4173a.findViewById(C1082R.id.tv_device_name);
        this.f4181i = (TextView) this.f4173a.findViewById(C1082R.id.tv_praise);
        this.f4182k = (TextView) this.f4173a.findViewById(C1082R.id.tv_praise_percent);
        this.f4183l = (TextView) this.f4173a.findViewById(C1082R.id.tv_score_tail);
        this.f4184m = (GridView) this.f4174b.findViewById(C1082R.id.gv_ads);
    }

    private void m5060e() {
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
        List list = this.f4177e;
        String string4 = getString(C1082R.string.score_3d_property);
        String str = string + BuildConfig.FLAVOR;
        boolean z = r[39] || r[40];
        list.add(new C1525f(string4, str, z));
        list = this.f4177e;
        string4 = getString(C1082R.string.score_ux_property);
        String str2 = i2 + BuildConfig.FLAVOR;
        z = r[34] || r[35] || r[36] || r[37] || r[38];
        list.add(new C1525f(string4, str2, z));
        List list2 = this.f4177e;
        String string5 = getString(C1082R.string.score_cpu_property);
        String str3 = i + BuildConfig.FLAVOR;
        z = r[31] || r[32] || r[33];
        list2.add(new C1525f(string5, str3, z));
        this.f4177e.add(new C1525f(getString(C1082R.string.score_ram_property), benchmarkScore + BuildConfig.FLAVOR, r[30]));
        List arrayList = new ArrayList();
        arrayList.add(new C1524e(getString(C1082R.string.SID_3D_MAROONED), string3 + BuildConfig.FLAVOR, r[40]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_3D_GARDEN), string2 + BuildConfig.FLAVOR, r[39]));
        i3 = C1503b.m5915c().m5936c((Context) this);
        string3 = i3 < 15000 ? getString(C1082R.string.score_gpu_3d_15000) : (i3 < 15000 || i3 >= BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT) ? (i3 < BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT || i3 >= C4112a.ACCS_RECEIVE_TIMEOUT) ? getString(C1082R.string.score_gpu_3d_40000) : getString(C1082R.string.score_gpu_3d_20000_40000) : getString(C1082R.string.score_gpu_3d_15000_20000);
        arrayList.add(new C1524e(string3, BuildConfig.FLAVOR, false));
        this.f4178f.add(arrayList);
        List arrayList2 = new ArrayList();
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_SEC), benchmarkScore5 + BuildConfig.FLAVOR, r[34]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_DATA), benchmarkScore6 + BuildConfig.FLAVOR, r[35]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_GAME), benchmarkScore7 + BuildConfig.FLAVOR, r[36]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_IMG), benchmarkScore8 + BuildConfig.FLAVOR, r[37]));
        arrayList2.add(new C1524e(getString(C1082R.string.SID_UX_IO), benchmarkScore9 + BuildConfig.FLAVOR, r[38]));
        this.f4178f.add(arrayList2);
        arrayList = new ArrayList();
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_MATH), benchmarkScore2 + BuildConfig.FLAVOR, r[31]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_APP), benchmarkScore3 + BuildConfig.FLAVOR, r[32]));
        arrayList.add(new C1524e(getString(C1082R.string.SID_CPU_MULTI), benchmarkScore4 + BuildConfig.FLAVOR, r[33]));
        i3 = C1503b.m5915c().m5932b((Context) this);
        string3 = i3 < 8000 ? getString(C1082R.string.score_cpu_float_800) : (i3 < 8000 || i3 >= 15000) ? (i3 < 15000 || i3 >= 24000) ? getString(C1082R.string.score_cpu_float_5000) : getString(C1082R.string.score_cpu_float_3000) : getString(C1082R.string.score_cpu_float_1500);
        arrayList.add(new C1524e(string3, BuildConfig.FLAVOR, false));
        this.f4178f.add(arrayList);
        this.f4178f.add(new ArrayList());
    }

    private void m5062h() {
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.detail_score_title)).m6413a(this.j).m6416b((int) C1082R.drawable.share).m6418b(true).m6420d(false).m6417b(this.f4189r).m6411a());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_detail_score);
        this.f4175c = (ExpandableListView) findViewById(C1082R.id.elv_detail_score);
        m5062h();
        this.f4185n = new C1371d(this);
        this.f4173a = View.inflate(this, C1082R.layout.header_detail_score, null);
        this.f4174b = View.inflate(this, C1082R.layout.footer_detail_score_ad, null);
        m5058d();
        m5060e();
        m5056c();
        this.f4176d = new C1116h(this, this.f4177e, this.f4178f);
        this.f4187p = new C1113g(this, this.f4188q);
        this.f4184m.setAdapter(this.f4187p);
        this.f4175c.addHeaderView(this.f4173a);
        this.f4175c.setAdapter(this.f4176d);
        m5050a();
        m5054b();
        InfocUtil.antutu_tabshow(this, 5);
    }
}
