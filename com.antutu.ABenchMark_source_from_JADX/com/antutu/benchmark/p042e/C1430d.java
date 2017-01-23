package com.antutu.benchmark.p042e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.DetailScoreActivity;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.activity.ScoreBenchActivity;
import com.antutu.benchmark.activity.TestResultActivity;
import com.antutu.benchmark.modelreflact.HomeFlagModel;
import com.antutu.benchmark.modelreflact.HomeFlagResponseModel;
import com.antutu.benchmark.p036a.C1122k;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1745b;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.NetUtils;
import com.antutu.utils.Utils;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.e.d */
public class C1430d extends C1338c implements OnRefreshListener, OnClickListener {
    private ListView f4925b;
    private View f4926c;
    private C1122k f4927d;
    private TextView f4928e;
    private TextView f4929f;
    private TextView f4930g;
    private Button f4931h;
    private LinearLayout f4932i;
    private C1371d f4933j;
    private C1429a f4934k;

    /* renamed from: com.antutu.benchmark.e.d.1 */
    class C14221 implements C1095a<HomeFlagResponseModel> {
        final /* synthetic */ C1430d f4915a;

        C14221(C1430d c1430d) {
            this.f4915a = c1430d;
        }

        public void m5620a(HomeFlagResponseModel homeFlagResponseModel) {
            List data = homeFlagResponseModel.getData();
            HomeFlagModel homeFlagModel = null;
            if (this.f4915a.f4927d.getCount() > 1 && this.f4915a.f4927d.m4878a(1) != null && HomeFlagModel.IS_SHOW_JIASU.equals(this.f4915a.f4927d.m4878a(1).getLabel())) {
                homeFlagModel = this.f4915a.f4927d.m4878a(1);
            }
            this.f4915a.f4927d.m4882a(data);
            if (homeFlagModel != null) {
                this.f4915a.f4927d.m4881a(homeFlagModel, 1);
            }
            this.f4915a.f4927d.notifyDataSetChanged();
        }

        public void m5622a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.2 */
    class C14232 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1430d f4916a;

        C14232(C1430d c1430d) {
            this.f4916a = c1430d;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (Utils.isNetworkConnected(this.f4916a.a)) {
                Methods.downloadFromGP(this.f4916a.a, "market://details?id=com.antutu.benchmark.full");
                dialogInterface.dismiss();
                return;
            }
            Methods.showToast(this.f4916a.a, (int) C1692R.string.network_error, 1);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.3 */
    static class C14243 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context f4917a;

        C14243(Context context) {
            this.f4917a = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
            intent.setFlags(270532608);
            this.f4917a.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.4 */
    class C14254 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1430d f4918a;

        C14254(C1430d c1430d) {
            this.f4918a = c1430d;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Methods.editSharedPreferences("clickMarketDownload", true);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.antutu.benchmark.full"));
                if (Utils.hasMarket(ABenchmarkApplication.getContext(), intent)) {
                    Methods.showToast(ABenchmarkApplication.getContext(), (int) C1082R.string.not_have_market, 0);
                    return;
                }
                intent.addFlags(268435456);
                ABenchmarkApplication.getContext().startActivity(intent);
            } catch (Exception e) {
                MLog.m6865d("hch", e.getMessage());
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.5 */
    class C14265 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1430d f4919a;

        C14265(C1430d c1430d) {
            this.f4919a = c1430d;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (Utils.isNetworkConnected(this.f4919a.a)) {
                C1516b.m6009a(this.f4919a.getContext());
                Methods.showToast(ABenchmarkApplication.getContext(), (int) C1082R.string.now_downloading, 0);
                return;
            }
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.antutu_download_3dplugin);
            Methods.showToast(ABenchmarkApplication.getContext(), (int) C1692R.string.network_error, 1);
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.6 */
    class C14276 implements DialogInterface.OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener f4920a;
        final /* synthetic */ C1430d f4921b;

        C14276(C1430d c1430d, DialogInterface.OnClickListener onClickListener) {
            this.f4921b = c1430d;
            this.f4920a = onClickListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Map hashMap = new HashMap();
            hashMap.put(this.f4921b.getString(C1082R.string.network_env), "WIFI");
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.market_download_3dplugin, hashMap);
            this.f4920a.onClick(dialogInterface, i);
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.7 */
    class C14287 implements DialogInterface.OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener f4922a;
        final /* synthetic */ C1430d f4923b;

        C14287(C1430d c1430d, DialogInterface.OnClickListener onClickListener) {
            this.f4923b = c1430d;
            this.f4922a = onClickListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Map hashMap = new HashMap();
            hashMap.put(this.f4923b.getString(C1082R.string.network_env), "NOT WIFI");
            MobclickAgent.onEvent(ABenchmarkApplication.getContext(), MobclickAgentConstants.market_download_3dplugin, hashMap);
            this.f4922a.onClick(dialogInterface, i);
        }
    }

    /* renamed from: com.antutu.benchmark.e.d.a */
    private class C1429a extends BroadcastReceiver {
        final /* synthetic */ C1430d f4924a;

        private C1429a(C1430d c1430d) {
            this.f4924a = c1430d;
        }

        public IntentFilter m5623a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            return intentFilter;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                this.f4924a.m5625a(C1745b.m6737a(context).m6741a(intent.getIntExtra("temperature", -1)));
            }
        }
    }

    public C1430d() {
        this.f4934k = new C1429a();
    }

    private void m5625a(int i) {
        if (i > 0) {
            if (this.f4927d.getCount() > 1 && this.f4927d.m4878a(1) != null && HomeFlagModel.IS_SHOW_JIASU.equals(this.f4927d.m4878a(1).getLabel())) {
                this.f4927d.m4884b(1);
            }
            this.f4927d.m4881a(new HomeFlagModel(HomeFlagModel.IS_SHOW_JIASU, Integer.valueOf(i)), 1);
            this.f4927d.notifyDataSetChanged();
        }
    }

    static boolean m5627a(Context context) {
        try {
            if (System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0) {
                C1430d.m5629b(context);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    private static void m5629b(Context context) {
        new Builder(context).setTitle(C1082R.string.always_finish_title).setMessage(C1082R.string.always_finish_info).setPositiveButton(C1692R.string.confirm, new C14243(context)).show();
    }

    private void m5632d() {
        this.f4927d.m4879a();
        this.f4927d.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_YANJI, Integer.valueOf(1)));
        this.f4927d.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_PINGLUN, Integer.valueOf(2)));
        this.f4927d.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_MORE_TEST, Integer.valueOf(3)));
        this.f4927d.m4880a(new HomeFlagModel(HomeFlagModel.IS_SHOW_LONG_TEST, Integer.valueOf(4)));
        this.f4927d.notifyDataSetChanged();
    }

    private void m5634e() {
        this.f4933j.m5431b(new C14221(this));
    }

    private void m5635f() {
        m5636h();
        this.f4929f.setText(C1503b.m5915c().m5970w());
    }

    private void m5636h() {
        this.f4928e.setText(C1503b.m5915c().m5967t() + BuildConfig.FLAVOR);
        if (C1503b.m5915c().m5966s()) {
            this.f4928e.setTextColor(getResources().getColor(C1082R.color.fake_score));
            this.f4930g.setTextColor(getResources().getColor(C1082R.color.fake_score));
            return;
        }
        this.f4928e.setTextColor(getResources().getColor(C1082R.color.green_text));
        this.f4930g.setTextColor(getResources().getColor(C1082R.color.green_text));
    }

    private void m5637i() {
        this.f4931h.setOnClickListener(this);
        this.f4932i.setOnClickListener(this);
    }

    private void m5638j() {
        this.f4928e = (TextView) this.f4926c.findViewById(C1082R.id.tv_score);
        this.f4929f = (TextView) this.f4926c.findViewById(C1082R.id.tv_device_name);
        this.f4931h = (Button) this.f4926c.findViewById(C1082R.id.tv_test_again);
        this.f4930g = (TextView) this.f4926c.findViewById(C1082R.id.tv_score_tail);
        this.f4932i = (LinearLayout) this.f4926c.findViewById(C1082R.id.ll_score);
    }

    private void m5639k() {
        Builder builder = new Builder(this.a);
        DialogInterface.OnClickListener c14254 = new C14254(this);
        if (NetUtils.getNetWorkType(this.a) == 4) {
            builder.setTitle(C4459R.string.app_name);
            builder.setMessage(C1082R.string.need_download3d_content);
            builder.setNegativeButton(C1082R.string.download_and_install, new C14265(this));
            builder.setPositiveButton(C1082R.string.market_download, new C14276(this, c14254));
        } else {
            builder.setTitle(C1082R.string.not_wifi_environment);
            builder.setMessage(C1082R.string.need_download3d_content_not_wifi);
            builder.setNegativeButton(C1082R.string.market_download, new C14287(this, c14254));
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    private void m5640l() {
        Intent intent = new Intent(this.a, ScoreBenchActivity.class);
        intent.setFlags(335544320);
        intent.putExtra("startBench", true);
        this.a.startActivity(intent);
        this.a.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
        if (!(this.a instanceof MainActivity)) {
            this.a.finish();
        }
    }

    public void m5641a(Object obj) {
        m5635f();
        if (!(obj instanceof String) || !"FINISH_BENCHMARK_FINISH_TAG".equals(obj)) {
            return;
        }
        if (Utils.isCn(this.a)) {
            Intent intent = new Intent(this.a, TestResultActivity.class);
            intent.putExtra("INTENT_EXTRA_SHOW_ARROW", true);
            startActivity(intent);
            return;
        }
        startActivity(new Intent(this.a, DetailScoreActivity.class));
    }

    public void m5642c() {
        try {
            if (!C1430d.m5627a(this.a) || !C1421c.m5588a(this.a)) {
                return;
            }
            if ((C1503b.f5113a & 2) == 0 || C1516b.m6022c(this.a)) {
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.startbench_has_plugin);
                m5640l();
                return;
            }
            C1516b.m6010a(this.a, 2);
            MobclickAgent.onEvent(this.a, MobclickAgentConstants.startbench_no_plugin);
            try {
                String a = C1503b.m5915c().m5923a();
                if (a != null) {
                    Intent flags = new Intent("android.intent.action.VIEW").setFlags(268435456);
                    flags.setDataAndType(Uri.fromFile(new File(a)), "application/vnd.android.package-archive");
                    startActivity(flags);
                } else if (C1503b.m5915c().m5954k() == 1) {
                    Builder builder = new Builder(this.a);
                    builder.setTitle(C1082R.string.gp_download_3dplugin_title);
                    builder.setMessage(C1082R.string.gp_download_3dplugin);
                    builder.setNegativeButton(C1082R.string.download, new C14232(this));
                    AlertDialog create = builder.create();
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } else {
                    m5639k();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.ll_score /*2131624376*/:
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_home_item_detail_score);
                if (Utils.isCn(this.a)) {
                    m5395a(new Intent(this.a, TestResultActivity.class));
                } else {
                    m5395a(new Intent(this.a, DetailScoreActivity.class));
                }
                InfocUtil.antutu_click_testtab(view.getContext(), 4);
            case C1082R.id.tv_test_again /*2131624377*/:
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.rebenchmark);
                MLog.m6865d("HomePageTestedFragment", "start test....");
                InfocUtil.antutu_click_testtab(view.getContext(), 5);
                m5642c();
            default:
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.home_page_tested, null);
        this.f4925b = (ListView) inflate.findViewById(C1082R.id.lv_testedlist);
        this.f4926c = layoutInflater.inflate(C1082R.layout.header_tested_home_page, null);
        this.f4933j = new C1371d(this.a);
        m5638j();
        this.f4925b.addHeaderView(this.f4926c);
        this.f4927d = new C1122k();
        m5632d();
        this.f4925b.setAdapter(this.f4927d);
        m5641a(null);
        m5637i();
        m5634e();
        return inflate;
    }

    public void onPause() {
        getContext().unregisterReceiver(this.f4934k);
        super.onPause();
    }

    public void onRefresh() {
        m5634e();
    }

    public void onResume() {
        super.onResume();
        getContext().registerReceiver(this.f4934k, this.f4934k.m5623a());
    }
}
