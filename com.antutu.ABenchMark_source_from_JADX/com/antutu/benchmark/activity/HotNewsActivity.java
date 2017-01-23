package com.antutu.benchmark.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.modelreflact.NewsResponseModel.DataEntity;
import com.antutu.benchmark.modelreflact.PageModel;
import com.antutu.benchmark.p036a.C1148n;
import com.antutu.benchmark.p036a.C1172s;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p037f.C1244b;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1360b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class HotNewsActivity extends C1197a implements OnRefreshListener {
    private C1360b f4229a;
    private TextView f4230b;
    private RecyclerView f4231c;
    private CustomSwipeRefreshLayout f4232d;
    private View f4233e;
    private C1148n f4234f;
    private List<NewsInfoData> f4235g;
    private int f4236h;
    private int f4237i;
    private int f4238k;
    private boolean f4239l;
    private C1095a<DataEntity> f4240m;
    private C1095a<DataEntity> f4241n;

    /* renamed from: com.antutu.benchmark.activity.HotNewsActivity.1 */
    class C12431 implements OnClickListener {
        final /* synthetic */ HotNewsActivity f4219a;

        C12431(HotNewsActivity hotNewsActivity) {
            this.f4219a = hotNewsActivity;
        }

        public void onClick(View view) {
            this.f4219a.f4237i = 1;
            this.f4219a.m5101d();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HotNewsActivity.2 */
    class C12452 extends C1244b {
        final /* synthetic */ HotNewsActivity f4226a;

        C12452(HotNewsActivity hotNewsActivity) {
            this.f4226a = hotNewsActivity;
        }

        public void m5086a() {
            if (!this.f4226a.f4232d.isRefreshing()) {
                MLog.m6865d("hch", "loadmore");
                this.f4226a.m5102a();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HotNewsActivity.3 */
    class C12463 implements C1095a<DataEntity> {
        final /* synthetic */ HotNewsActivity f4227a;

        C12463(HotNewsActivity hotNewsActivity) {
            this.f4227a = hotNewsActivity;
        }

        public void m5087a(DataEntity dataEntity) {
            this.f4227a.f4232d.setRefreshing(false);
            this.f4227a.f4232d.setVisibility(0);
            this.f4227a.f4233e.setVisibility(8);
            PageModel page = dataEntity.getPage();
            this.f4227a.f4237i = page.getCurrpage();
            this.f4227a.f4236h = page.getCountpage();
            this.f4227a.f4234f.m4909a(dataEntity.getInfolist());
        }

        public void m5089a(String str) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.HotNewsActivity.4 */
    class C12474 implements C1095a<DataEntity> {
        final /* synthetic */ HotNewsActivity f4228a;

        C12474(HotNewsActivity hotNewsActivity) {
            this.f4228a = hotNewsActivity;
        }

        public void m5090a(DataEntity dataEntity) {
            this.f4228a.f4232d.setRefreshing(false);
            PageModel page = dataEntity.getPage();
            this.f4228a.f4237i = page.getCurrpage();
            this.f4228a.f4236h = page.getCountpage();
            this.f4228a.f4234f.m4911b(dataEntity.getInfolist());
        }

        public void m5092a(String str) {
            this.f4228a.f4232d.setRefreshing(false);
        }
    }

    public HotNewsActivity() {
        this.f4235g = new ArrayList();
        this.f4236h = 0;
        this.f4237i = 1;
        this.f4238k = 0;
        this.f4239l = false;
        this.f4240m = new C12463(this);
        this.f4241n = new C12474(this);
    }

    private void m5097b() {
        this.f4230b.setOnClickListener(new C12431(this));
        this.f4232d.setOnRefreshListener(this);
        this.f4231c.addOnScrollListener(new C12452(this));
    }

    private void m5099c() {
        this.f4233e = findViewById(C1082R.id.no_net_container);
        this.f4231c = (RecyclerView) findViewById(C1082R.id.list);
        this.f4230b = (TextView) findViewById(C1082R.id.try_again);
        this.f4232d = (CustomSwipeRefreshLayout) findViewById(C1082R.id.sr_ll_refresh);
    }

    private void m5101d() {
        this.f4229a.m5420a(this.f4237i, 100029, this.f4240m);
    }

    public void m5102a() {
        this.f4232d.setRefreshing(true);
        if (!Utils.isNetworkConnected(this)) {
            Methods.showToast((Context) this, getString(C1082R.string.net_work_error_try), 1);
            this.f4232d.setRefreshing(false);
        } else if (this.f4237i >= this.f4236h) {
            this.f4239l = true;
            if (this.f4238k > 0) {
                Methods.showToast((Context) this, (int) C1082R.string.listfooterview_finished, 0);
            }
            this.f4232d.setRefreshing(false);
        } else {
            this.f4238k++;
            C1360b c1360b = this.f4229a;
            int i = this.f4237i + 1;
            this.f4237i = i;
            c1360b.m5420a(i, 100029, this.f4241n);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_hot_news);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.hot_news), false, this.j, null));
        this.f4229a = new C1360b(this);
        m5099c();
        this.f4231c.setLayoutManager(new LinearLayoutManager(this));
        this.f4231c.setItemAnimator(new aj());
        this.f4234f = new C1148n(this, this.f4235g, getString(C1082R.string.hot_info), false);
        this.f4231c.setAdapter(new C1172s(this.f4234f));
        m5097b();
        if (Utils.isNetworkConnected(this)) {
            this.f4233e.setVisibility(8);
            this.f4232d.setVisibility(0);
            m5101d();
            return;
        }
        this.f4233e.setVisibility(0);
        this.f4232d.setVisibility(8);
    }

    public void onRefresh() {
        this.f4237i = 1;
        if (Utils.isNetworkConnected(this)) {
            m5101d();
            return;
        }
        Methods.showToast((Context) this, getString(C1082R.string.net_work_error_try), 1);
        this.f4232d.setRefreshing(false);
    }
}
