package com.antutu.benchmark.p042e;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.HotNewsBannerModel;
import com.antutu.benchmark.modelreflact.HotNewsBannerResponseModel.DataBean;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.modelreflact.NewsResponseModel.DataEntity;
import com.antutu.benchmark.modelreflact.PageModel;
import com.antutu.benchmark.p036a.C1148n;
import com.antutu.benchmark.p036a.C1172s;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p037f.C1244b;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1360b;
import com.antutu.benchmark.view.C1680k.C1431a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.Utils;
import com.antutu.utils.widget.WebBrowserActivity;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.e.e */
public class C1439e extends C1338c implements OnRefreshListener {
    private TextView f4942b;
    private C1148n f4943c;
    private List<NewsInfoData> f4944d;
    private View f4945e;
    private RecyclerView f4946f;
    private CustomSwipeRefreshLayout f4947g;
    private C1360b f4948h;
    private int f4949i;
    private int f4950j;
    private int f4951k;
    private boolean f4952l;
    private C1095a<DataEntity> f4953m;
    private C1095a<DataEntity> f4954n;

    /* renamed from: com.antutu.benchmark.e.e.1 */
    class C14331 implements C1095a<DataBean> {
        final /* synthetic */ C1439e f4936a;

        /* renamed from: com.antutu.benchmark.e.e.1.1 */
        class C14321 implements C1431a {
            final /* synthetic */ C14331 f4935a;

            C14321(C14331 c14331) {
                this.f4935a = c14331;
            }

            public void m5644a(HotNewsBannerModel hotNewsBannerModel, int i, View view) {
                WebBrowserActivity.openWebActivity(this.f4935a.f4936a.a, hotNewsBannerModel.getUrl(), hotNewsBannerModel.getTitle(), hotNewsBannerModel.getPicture(), hotNewsBannerModel.getTitle(), hotNewsBannerModel.getShare_url());
            }
        }

        C14331(C1439e c1439e) {
            this.f4936a = c1439e;
        }

        public void m5645a(DataBean dataBean) {
            List infolist = dataBean.getInfolist();
            if (infolist == null || infolist.size() == 0) {
                this.f4936a.f4943c.m4910a(false);
                this.f4936a.f4943c.notifyDataSetChanged();
            }
            this.f4936a.f4943c.m4906a().m6587a(infolist, new C14321(this));
            this.f4936a.f4943c.m4906a().setWheel(true);
        }

        public void m5647a(String str) {
            this.f4936a.f4943c.m4910a(false);
            this.f4936a.f4943c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.antutu.benchmark.e.e.2 */
    class C14342 implements OnClickListener {
        final /* synthetic */ C1439e f4937a;

        C14342(C1439e c1439e) {
            this.f4937a = c1439e;
        }

        public void onClick(View view) {
            this.f4937a.f4950j = 1;
            this.f4937a.m5667e();
        }
    }

    /* renamed from: com.antutu.benchmark.e.e.3 */
    class C14353 extends C1244b {
        final /* synthetic */ C1439e f4938a;

        C14353(C1439e c1439e) {
            this.f4938a = c1439e;
        }

        public void m5648a() {
            if (!this.f4938a.f4947g.isRefreshing()) {
                MLog.m6865d("hch", "loadmore");
                this.f4938a.m5674c();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.e.4 */
    class C14364 implements C1095a<DataEntity> {
        final /* synthetic */ C1439e f4939a;

        C14364(C1439e c1439e) {
            this.f4939a = c1439e;
        }

        public void m5649a(DataEntity dataEntity) {
            this.f4939a.f4947g.setRefreshing(false);
            PageModel page = dataEntity.getPage();
            this.f4939a.f4950j = page.getCurrpage();
            this.f4939a.f4949i = page.getCountpage();
            this.f4939a.f4943c.m4911b(dataEntity.getInfolist());
        }

        public void m5651a(String str) {
            this.f4939a.f4947g.setRefreshing(false);
        }
    }

    /* renamed from: com.antutu.benchmark.e.e.5 */
    class C14375 implements C1095a<DataEntity> {
        final /* synthetic */ C1439e f4940a;

        C14375(C1439e c1439e) {
            this.f4940a = c1439e;
        }

        public void m5652a(DataEntity dataEntity) {
            this.f4940a.f4947g.setRefreshing(false);
            this.f4940a.f4946f.setVisibility(0);
            this.f4940a.f4945e.setVisibility(8);
            PageModel page = dataEntity.getPage();
            this.f4940a.f4950j = page.getCurrpage();
            this.f4940a.f4949i = page.getCountpage();
            this.f4940a.f4943c.m4909a(dataEntity.getInfolist());
        }

        public void m5654a(String str) {
            this.f4940a.m5671h();
        }
    }

    /* renamed from: com.antutu.benchmark.e.e.6 */
    class C14386 implements C1095a<DataEntity> {
        final /* synthetic */ C1439e f4941a;

        C14386(C1439e c1439e) {
            this.f4941a = c1439e;
        }

        public void m5655a(DataEntity dataEntity) {
            this.f4941a.f4947g.setRefreshing(false);
            this.f4941a.f4946f.setVisibility(0);
            this.f4941a.f4945e.setVisibility(8);
            PageModel page = dataEntity.getPage();
            this.f4941a.f4950j = page.getCurrpage();
            this.f4941a.f4949i = page.getCountpage();
            this.f4941a.f4943c.m4909a(dataEntity.getInfolist());
        }

        public void m5657a(String str) {
            this.f4941a.f4947g.setRefreshing(false);
            this.f4941a.m5665d();
        }
    }

    public C1439e() {
        this.f4944d = new ArrayList();
        this.f4949i = 0;
        this.f4950j = 1;
        this.f4951k = 0;
        this.f4952l = false;
        this.f4953m = new C14364(this);
        this.f4954n = new C14375(this);
    }

    private void m5660a(View view) {
        this.f4945e = view.findViewById(C1082R.id.no_net_container);
        this.f4946f = (RecyclerView) view.findViewById(C1082R.id.list);
        this.f4942b = (TextView) view.findViewById(C1082R.id.try_again);
        this.f4947g = (CustomSwipeRefreshLayout) view.findViewById(C1082R.id.sr_ll_refresh);
        this.f4947g.setColorSchemeResources(C1082R.color.colorPrimary_day);
    }

    private void m5665d() {
        List a = this.f4948h.m5419a();
        if (a == null || a.size() == 0) {
            this.f4945e.setVisibility(0);
            this.f4946f.setVisibility(8);
            return;
        }
        this.f4946f.setVisibility(0);
        this.f4945e.setVisibility(8);
        this.f4950j = 1;
        this.f4949i = 1;
        this.f4943c.m4909a(a);
    }

    private void m5667e() {
        this.f4948h.m5420a(this.f4950j, 100028, this.f4954n);
    }

    private void m5669f() {
        this.f4942b.setOnClickListener(new C14342(this));
        this.f4947g.setOnRefreshListener(this);
        this.f4946f.addOnScrollListener(new C14353(this));
    }

    private void m5671h() {
        this.f4948h.m5426c(new C14386(this));
    }

    public void m5673b() {
        if (this.f4946f != null) {
            this.f4947g.setRefreshing(true);
            m5667e();
        }
    }

    public void m5674c() {
        this.f4947g.setRefreshing(true);
        if (isAdded() && !Utils.isNetworkConnected(getActivity())) {
            Methods.showToast(getActivity(), getString(C1082R.string.net_work_error_try), 1);
            this.f4947g.setRefreshing(false);
        } else if (this.f4950j >= this.f4949i) {
            this.f4952l = true;
            if (this.f4951k > 0) {
                Methods.showToast(this.a, (int) C1082R.string.listfooterview_finished, 0);
            }
            this.f4947g.setRefreshing(false);
        } else {
            this.f4951k++;
            C1360b c1360b = this.f4948h;
            int i = this.f4950j + 1;
            this.f4950j = i;
            c1360b.m5420a(i, 100028, this.f4953m);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MLog.m6864d(getClass().getName() + "---onCreate");
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f4943c = new C1148n(getActivity(), this.f4944d, this.a.getString(C1082R.string.info), true);
        this.f4948h = new C1360b(this.a);
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_news, viewGroup, false);
        m5660a(inflate);
        this.f4946f.setLayoutManager(new LinearLayoutManager(this.a));
        this.f4946f.setItemAnimator(new aj());
        this.f4946f.setAdapter(new C1172s(this.f4943c));
        m5669f();
        if (Utils.isNetworkConnected(getActivity())) {
            this.f4945e.setVisibility(8);
            this.f4946f.setVisibility(0);
            m5667e();
        } else {
            m5665d();
        }
        this.f4948h.m5421a(new C14331(this));
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        MLog.m6864d(getClass().getName() + "---onDestroy");
    }

    public void onPause() {
        super.onPause();
        MLog.m6864d(getClass().getName() + "---onPause");
    }

    public void onRefresh() {
        this.f4950j = 1;
        if (!isAdded() || Utils.isNetworkConnected(getActivity())) {
            m5667e();
            return;
        }
        Methods.showToast(getActivity(), getString(C1082R.string.net_work_error_try), 1);
        this.f4947g.setRefreshing(false);
    }

    public void onResume() {
        super.onResume();
        MLog.m6864d(getClass().getName() + "---onResume");
        this.f4943c.notifyDataSetChanged();
    }
}
