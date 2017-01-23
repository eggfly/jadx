package com.antutu.benchmark.p042e;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1539q;
import com.antutu.benchmark.modelreflact.RankModel;
import com.antutu.benchmark.modelreflact.RankResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p038b.C1340e;
import com.antutu.benchmark.p040c.C1362c;
import com.antutu.utils.MobclickAgentConstants;
import com.umeng.analytics.MobclickAgent;
import com.viewpagerindicator.TabPageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.e.j */
public class C1473j extends C1338c {
    private ViewPager f5038b;
    private List<C1539q> f5039c;
    private C1340e f5040d;
    private C1362c f5041e;
    private TabPageIndicator f5042f;
    private View f5043g;
    private View f5044h;
    private Button f5045i;
    private LinearLayout f5046j;

    /* renamed from: com.antutu.benchmark.e.j.1 */
    class C14711 implements OnPageChangeListener {
        final /* synthetic */ C1473j f5036a;

        C14711(C1473j c1473j) {
            this.f5036a = c1473j;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (this.f5036a.f5039c.size() - 1 >= i) {
                ((C1539q) this.f5036a.f5039c.get(i)).f5358a.m5394a();
            }
            Map hashMap = new HashMap();
            hashMap.put(this.f5036a.a.getString(C1082R.string.biaoti), ((C1539q) this.f5036a.f5039c.get(i)).f5360c);
            MobclickAgent.onEvent(this.f5036a.a, MobclickAgentConstants.click_rank_detail, hashMap);
        }
    }

    /* renamed from: com.antutu.benchmark.e.j.2 */
    class C14722 implements C1095a<RankResponseModel> {
        final /* synthetic */ C1473j f5037a;

        C14722(C1473j c1473j) {
            this.f5037a = c1473j;
        }

        public void m5784a(RankResponseModel rankResponseModel) {
            List data = rankResponseModel.getData();
            if (data == null) {
                this.f5037a.m5792d();
            }
            this.f5037a.f5039c.clear();
            for (int i = 0; i < data.size(); i++) {
                RankModel rankModel = (RankModel) data.get(i);
                C1338c c1468h = "default".equals(rankModel.getUrl()) ? new C1468h() : new C1470i();
                Bundle bundle = new Bundle();
                bundle.putString("KEY_URL", rankModel.getUrl());
                this.f5037a.f5039c.add(new C1539q(c1468h, bundle, rankModel.getTitle()));
            }
            this.f5037a.m5797f();
            this.f5037a.f5040d.notifyDataSetChanged();
            this.f5037a.f5038b.setOffscreenPageLimit(this.f5037a.f5039c.size());
            this.f5037a.f5042f.m17569a();
        }

        public void m5786a(String str) {
            this.f5037a.m5792d();
        }
    }

    public C1473j() {
        this.f5039c = new ArrayList();
        this.f5040d = null;
        this.f5043g = null;
        this.f5044h = null;
        this.f5045i = null;
        this.f5046j = null;
    }

    private void m5788a(View view) {
        this.f5038b = (ViewPager) view.findViewById(C1082R.id.viewpager);
        this.f5043g = view.findViewById(C1082R.id.loading);
        this.f5044h = view.findViewById(C1082R.id.no_network);
        this.f5045i = (Button) view.findViewById(C1082R.id.reload_btn);
        this.f5046j = (LinearLayout) view.findViewById(C1082R.id.ll_rank_layout);
    }

    private void m5791c() {
        this.f5041e.m5428a(new C14722(this));
    }

    private void m5792d() {
        m5797f();
        this.f5039c.clear();
        this.f5039c.add(new C1539q(new C1468h(), new Bundle(), this.a.getString(C1082R.string.all_rank)));
        this.f5040d.notifyDataSetChanged();
        this.f5038b.setOffscreenPageLimit(this.f5039c.size());
        this.f5042f.m17569a();
    }

    private void m5794e() {
        this.f5043g.setVisibility(0);
        this.f5044h.setVisibility(8);
        this.f5046j.setVisibility(8);
        this.f5042f.setVisibility(8);
    }

    private void m5797f() {
        this.f5043g.setVisibility(8);
        this.f5044h.setVisibility(8);
        this.f5046j.setVisibility(0);
        if (this.f5039c == null || this.f5039c.size() <= 1) {
            this.f5042f.setVisibility(8);
        } else {
            this.f5042f.setVisibility(0);
        }
    }

    public void m5800a() {
        for (int i = 0; i < this.f5039c.size(); i++) {
            ((C1539q) this.f5039c.get(i)).f5358a.m5394a();
        }
    }

    public void m5801a(Object obj) {
        for (int i = 0; i < this.f5039c.size(); i++) {
            ((C1539q) this.f5039c.get(i)).f5358a.m5396a(obj);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5041e = new C1362c(this.a);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity().getApplicationContext(), C1082R.style.Theme_CustomPageIndicator)).inflate(C1082R.layout.fragment_ranking, viewGroup, false);
        m5788a(inflate);
        this.f5040d = new C1340e(getFragmentManager(), this.f5039c);
        this.f5038b.setAdapter(this.f5040d);
        this.f5038b.setOffscreenPageLimit(this.f5039c.size());
        this.f5042f = (TabPageIndicator) inflate.findViewById(C1082R.id.indicator);
        this.f5042f.setViewPager(this.f5038b);
        this.f5042f.setOnPageChangeListener(this.f5040d);
        this.f5038b.addOnPageChangeListener(new C14711(this));
        m5794e();
        m5791c();
        return inflate;
    }
}
