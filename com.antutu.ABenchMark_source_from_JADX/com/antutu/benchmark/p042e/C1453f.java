package com.antutu.benchmark.p042e;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1522c;
import com.antutu.benchmark.modelreflact.AddCommentModel.DataEntity.CmtinfoEntity;
import com.antutu.benchmark.modelreflact.CommentModel;
import com.antutu.benchmark.modelreflact.CommentResponseModel;
import com.antutu.benchmark.modelreflact.CommentResponseModel.DataBean;
import com.antutu.benchmark.p036a.C1104c;
import com.antutu.benchmark.p036a.C1104c.C1100a;
import com.antutu.benchmark.p036a.C1104c.C1101b;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.C1682l;
import com.antutu.benchmark.view.C1682l.C1681a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.benchmark.view.KeyboardLayout;
import com.antutu.benchmark.view.KeyboardLayout.C1445a;
import com.antutu.benchmark.view.RatingView;
import com.antutu.benchmark.view.RatingView.C1442a;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Utils;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.e.f */
public class C1453f extends C1338c implements OnRefreshListener, OnClickListener {
    private C1095a<CommentResponseModel> f4968A;
    private C1095a<CommentResponseModel> f4969B;
    private C1095a<CmtinfoEntity> f4970C;
    private C1353a f4971b;
    private CustomSwipeRefreshLayout f4972c;
    private ListView f4973d;
    private int f4974e;
    private LinearLayout f4975f;
    private LinearLayout f4976g;
    private LinearLayout f4977h;
    private boolean f4978i;
    private RatingView f4979j;
    private C1104c f4980k;
    private Button f4981l;
    private EditText f4982m;
    private Button f4983n;
    private TextView f4984o;
    private TextView f4985p;
    private LinearLayout f4986q;
    private int[] f4987r;
    private int f4988s;
    private C1682l f4989t;
    private boolean f4990u;
    private boolean f4991v;
    private C1452a f4992w;
    private boolean f4993x;
    private KeyboardLayout f4994y;
    private TextView f4995z;

    /* renamed from: com.antutu.benchmark.e.f.1 */
    class C14401 implements OnScrollListener {
        final /* synthetic */ C1453f f4955a;

        C14401(C1453f c1453f) {
            this.f4955a = c1453f;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f4955a.f4972c.isRefreshing() && i2 + i >= i3 - 2 && i3 > 0 && Utils.isNetworkConnected(this.f4955a.a)) {
                this.f4955a.m5718i();
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.2 */
    class C14412 implements C1100a {
        final /* synthetic */ C1453f f4956a;

        C14412(C1453f c1453f) {
            this.f4956a = c1453f;
        }

        public void m5675a(PopupWindow popupWindow, C1522c c1522c, int i) {
            this.f4956a.f4993x = false;
            this.f4956a.m5712e();
            this.f4956a.f4992w.m5696a(c1522c);
            this.f4956a.f4992w.m5695a(i);
            String h = c1522c.m6056h();
            if (i == 0) {
                h = c1522c.m6056h();
            } else if (c1522c.m6058j() != null && 1 == i) {
                h = c1522c.m6058j().getRegion();
            }
            this.f4956a.f4995z.setText(this.f4956a.getString(C1082R.string.reply) + h + this.f4956a.getString(C1082R.string.colon));
            this.f4956a.f4986q.setVisibility(8);
            this.f4956a.f4981l.setOnClickListener(this.f4956a.f4992w);
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.3 */
    class C14433 implements C1442a {
        final /* synthetic */ C1453f f4957a;

        C14433(C1453f c1453f) {
            this.f4957a = c1453f;
        }

        public void m5677a(int i) {
            this.f4957a.f4988s = i;
            if (i - 1 < 0 || i > this.f4957a.f4987r.length) {
                this.f4957a.f4985p.setText(BuildConfig.FLAVOR);
                return;
            }
            if (i - 1 >= 0) {
                this.f4957a.f4985p.setText(this.f4957a.f4987r[i - 1]);
            }
            this.f4957a.m5712e();
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.4 */
    class C14444 implements TextWatcher {
        final /* synthetic */ C1453f f4958a;

        C14444(C1453f c1453f) {
            this.f4958a = c1453f;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f4958a.m5712e();
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.5 */
    class C14465 implements C1445a {
        final /* synthetic */ C1453f f4959a;

        C14465(C1453f c1453f) {
            this.f4959a = c1453f;
        }

        public void m5679a(int i) {
            if (-2 == i) {
                this.f4959a.f4993x = true;
                this.f4959a.m5721j();
                this.f4959a.m5712e();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.6 */
    class C14476 implements C1095a<DataBean> {
        final /* synthetic */ C1453f f4960a;

        C14476(C1453f c1453f) {
            this.f4960a = c1453f;
        }

        public void m5680a(DataBean dataBean) {
            this.f4960a.f4990u = true;
            if (dataBean.getCmtlist() != null && dataBean.getCmtlist().size() > 0) {
                C1101b c1101b = new C1101b();
                c1101b.f3689a = this.f4960a.getString(C1082R.string.hot_comment);
                c1101b.m4850a(dataBean.getCmtlist());
                this.f4960a.f4980k.m4863a(0, c1101b);
            }
            this.f4960a.m5722k();
        }

        public void m5682a(String str) {
            this.f4960a.f4990u = true;
            this.f4960a.m5722k();
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.7 */
    class C14487 implements C1095a<CommentResponseModel> {
        final /* synthetic */ C1453f f4961a;

        C14487(C1453f c1453f) {
            this.f4961a = c1453f;
        }

        public void m5683a(CommentResponseModel commentResponseModel) {
            this.f4961a.f4972c.setRefreshing(false);
            List cmtlist = commentResponseModel.getData().getCmtlist();
            if (cmtlist.size() == 0) {
                Utils.show(this.f4961a.a, this.f4961a.getString(C1082R.string.no_more_comment));
                this.f4961a.f4978i = true;
                return;
            }
            this.f4961a.f4980k.m4866a(this.f4961a.getString(C1082R.string.news_comment), cmtlist);
            this.f4961a.f4980k.notifyDataSetChanged();
            this.f4961a.f4974e = ((CommentModel) cmtlist.get(cmtlist.size() - 1)).getId();
        }

        public void m5685a(String str) {
            this.f4961a.f4972c.setRefreshing(false);
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.8 */
    class C14498 implements C1095a<CommentResponseModel> {
        final /* synthetic */ C1453f f4962a;

        C14498(C1453f c1453f) {
            this.f4962a = c1453f;
        }

        public void m5686a(CommentResponseModel commentResponseModel) {
            List cmtlist = commentResponseModel.getData().getCmtlist();
            if (cmtlist.size() == 0) {
                this.f4962a.m5739a(false);
                this.f4962a.f4972c.setRefreshing(false);
                this.f4962a.f4991v = false;
                this.f4962a.f4990u = false;
                return;
            }
            this.f4962a.m5739a(true);
            this.f4962a.f4974e = ((CommentModel) cmtlist.get(cmtlist.size() - 1)).getId();
            this.f4962a.f4991v = true;
            C1101b c1101b = new C1101b();
            c1101b.f3689a = this.f4962a.getString(C1082R.string.news_comment);
            c1101b.m4850a(cmtlist);
            this.f4962a.f4980k.m4865a(c1101b);
            this.f4962a.m5722k();
        }

        public void m5688a(String str) {
            this.f4962a.m5739a(false);
            this.f4962a.f4972c.setRefreshing(false);
            this.f4962a.f4980k.m4862a();
            this.f4962a.f4991v = false;
            this.f4962a.f4990u = false;
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.9 */
    class C14509 implements C1095a<CmtinfoEntity> {
        final /* synthetic */ C1453f f4963a;

        C14509(C1453f c1453f) {
            this.f4963a = c1453f;
        }

        public void m5689a(CmtinfoEntity cmtinfoEntity) {
            this.f4963a.f4989t.dismiss();
            Methods.showToast(this.f4963a.a, (int) C1082R.string.fabiaochenggong, 0);
            this.f4963a.f4982m.setText(BuildConfig.FLAVOR);
            Methods.hideSoftKeyboard(this.f4963a.a, this.f4963a.f4982m);
            this.f4963a.m5714f();
        }

        public void m5691a(String str) {
            this.f4963a.f4989t.dismiss();
            if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                Utils.show(this.f4963a.a, str);
            }
            Methods.hideSoftKeyboard(this.f4963a.a, this.f4963a.f4982m);
        }
    }

    /* renamed from: com.antutu.benchmark.e.f.a */
    private class C1452a implements OnClickListener {
        final /* synthetic */ C1453f f4965a;
        private C1522c f4966b;
        private int f4967c;

        /* renamed from: com.antutu.benchmark.e.f.a.1 */
        class C14511 implements C1095a<DataBean> {
            final /* synthetic */ C1452a f4964a;

            C14511(C1452a c1452a) {
                this.f4964a = c1452a;
            }

            public void m5692a(DataBean dataBean) {
                this.f4964a.f4965a.f4989t.dismiss();
                Methods.showToast(this.f4964a.f4965a.a, (int) C1082R.string.fabiaochenggong, 0);
                this.f4964a.f4965a.f4982m.setText(BuildConfig.FLAVOR);
                Methods.hideSoftKeyboard(this.f4964a.f4965a.a, this.f4964a.f4965a.f4982m);
                this.f4964a.f4965a.m5714f();
            }

            public void m5694a(String str) {
                this.f4964a.f4965a.f4989t.dismiss();
                if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                    Utils.show(this.f4964a.f4965a.a, str);
                }
                Methods.hideSoftKeyboard(this.f4964a.f4965a.a, this.f4964a.f4965a.f4982m);
            }
        }

        public C1452a(C1453f c1453f) {
            this.f4965a = c1453f;
        }

        public void m5695a(int i) {
            this.f4967c = i;
        }

        public void m5696a(C1522c c1522c) {
            this.f4966b = c1522c;
        }

        public void onClick(View view) {
            if (this.f4966b != null) {
                String obj = this.f4965a.f4982m.getText().toString();
                if (obj.replace(" ", BuildConfig.FLAVOR).length() < 5 || obj.length() < 5) {
                    Utils.show(this.f4965a.a, this.f4965a.getString(C1082R.string.cant_less_five));
                    return;
                }
                this.f4965a.f4989t.show();
                this.f4965a.f4971b.m5413a(C1503b.m5915c().m5960n(this.f4965a.a), this.f4967c == 0 ? this.f4966b.m6051c() : this.f4966b.m6058j().getId(), obj, new C14511(this));
            }
        }
    }

    public C1453f() {
        this.f4974e = 0;
        this.f4978i = false;
        this.f4987r = new int[]{C1082R.string.dislike, C1082R.string.general, C1082R.string.good, C1082R.string.pretty, C1082R.string.excellent};
        this.f4988s = 0;
        this.f4990u = false;
        this.f4991v = false;
        this.f4993x = true;
        this.f4968A = new C14487(this);
        this.f4969B = new C14498(this);
        this.f4970C = new C14509(this);
    }

    private void m5701a(View view) {
        this.f4972c = (CustomSwipeRefreshLayout) view.findViewById(C1082R.id.sr_refresh);
        this.f4973d = (ListView) view.findViewById(C1082R.id.list);
        this.f4975f = (LinearLayout) view.findViewById(C1082R.id.no_content);
        this.f4976g = (LinearLayout) view.findViewById(C1082R.id.no_net);
        this.f4977h = (LinearLayout) view.findViewById(C1082R.id.ll_add_comment);
        this.f4979j = (RatingView) view.findViewById(C1082R.id.rv_star);
        this.f4979j.setCanRate(true);
        this.f4981l = (Button) view.findViewById(C1082R.id.send_btn);
        this.f4982m = (EditText) view.findViewById(C1082R.id.et_comment_text);
        this.f4983n = (Button) view.findViewById(C1082R.id.btn_refresh);
        this.f4984o = (TextView) view.findViewById(C1082R.id.tv_device);
        this.f4985p = (TextView) view.findViewById(C1082R.id.leve_text);
        this.f4986q = (LinearLayout) view.findViewById(C1082R.id.ll_star_bg);
        this.f4994y = (KeyboardLayout) view.findViewById(C1082R.id.kl_bg);
        this.f4995z = (TextView) view.findViewById(C1082R.id.reply_title);
    }

    private void m5708d() {
        this.f4972c.setOnRefreshListener(this);
        this.f4983n.setOnClickListener(this);
        this.f4973d.setOnScrollListener(new C14401(this));
        this.f4980k.m4864a(new C14412(this));
        this.f4979j.setOnRateChangeListener(new C14433(this));
        this.f4981l.setOnClickListener(this);
        this.f4982m.addTextChangedListener(new C14444(this));
        this.f4994y.setOnkbdStateListener(new C14465(this));
    }

    private void m5712e() {
        String obj = this.f4982m.getText().toString();
        if (this.f4993x) {
            if (obj == null || obj.toString().trim().length() <= 0 || this.f4988s == 0) {
                this.f4981l.setBackgroundResource(C1082R.drawable.send);
            } else {
                this.f4981l.setBackgroundResource(C1082R.drawable.send_red);
            }
            this.f4995z.setVisibility(8);
            return;
        }
        if (obj == null || obj.toString().trim().length() <= 0) {
            this.f4981l.setBackgroundResource(C1082R.drawable.send);
        } else {
            this.f4981l.setBackgroundResource(C1082R.drawable.send_red);
        }
        this.f4995z.setVisibility(0);
    }

    private void m5714f() {
        if (Utils.isNetworkConnected(this.a)) {
            m5739a(true);
        } else {
            m5740c();
        }
        m5717h();
        this.f4972c.setRefreshing(true);
        this.f4971b.m5412a(C1503b.m5915c().m5960n(this.a), this.f4974e, this.f4969B);
        this.f4971b.m5414a(C1503b.m5915c().m5960n(this.a), new C14476(this));
    }

    private void m5717h() {
        this.f4974e = 0;
        this.f4978i = false;
        this.f4988s = 0;
        this.f4979j.m6477a();
        this.f4985p.setText(C1082R.string.please_get_score);
        this.f4990u = false;
        this.f4991v = false;
        this.f4980k.m4862a();
    }

    private void m5718i() {
        this.f4972c.setRefreshing(true);
        this.f4971b.m5412a(C1503b.m5915c().m5960n(this.a), this.f4974e, this.f4968A);
    }

    private void m5721j() {
        this.f4986q.setVisibility(0);
        this.f4981l.setOnClickListener(this);
    }

    private void m5722k() {
        if (this.f4990u && this.f4991v) {
            this.f4980k.notifyDataSetChanged();
            this.f4972c.setRefreshing(false);
        }
    }

    public void m5739a(boolean z) {
        if (z) {
            this.f4975f.setVisibility(8);
            this.f4976g.setVisibility(8);
            this.f4977h.setVisibility(0);
            this.f4972c.setVisibility(0);
            return;
        }
        this.f4975f.setVisibility(0);
        this.f4976g.setVisibility(8);
        this.f4977h.setVisibility(0);
        this.f4972c.setVisibility(8);
    }

    public void m5740c() {
        this.f4975f.setVisibility(8);
        this.f4976g.setVisibility(0);
        this.f4977h.setVisibility(8);
        this.f4972c.setVisibility(8);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.btn_refresh /*2131624109*/:
                if (Utils.isNetworkConnected(this.a)) {
                    m5714f();
                } else {
                    Methods.showToast(this.a, getString(C1082R.string.net_work_error_try), 0);
                }
            case C1082R.id.send_btn /*2131624281*/:
                if (!Utils.isNetworkConnected(this.a)) {
                    Methods.showToast(this.a, getString(C1082R.string.net_work_error_try), 0);
                } else if (this.f4988s == 0) {
                    Utils.show(this.a, getString(C1082R.string.select_leve));
                } else {
                    int length = this.f4982m.getText().toString().length();
                    String obj = this.f4982m.getText().toString();
                    if (obj.replace(" ", BuildConfig.FLAVOR).length() < 5 || length < 5) {
                        Utils.show(this.a, getString(C1082R.string.cant_less_five));
                        return;
                    }
                    MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_pinglun_send);
                    this.f4989t.show();
                    this.f4971b.m5411a(this.f4988s, obj, this.f4970C);
                }
            default:
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_comment, null);
        m5701a(inflate);
        this.f4984o.setText(C1503b.m5915c().m5970w());
        this.f4971b = new C1353a(this.a);
        this.f4980k = new C1104c(this.a, true, "PAGE_COMMENT");
        this.f4973d.setAdapter(this.f4980k);
        this.f4992w = new C1452a(this);
        C1681a c1681a = new C1681a(this.a);
        c1681a.m6589a(getString(C1082R.string.sending));
        this.f4989t = c1681a.m6590a();
        this.f4989t.setCanceledOnTouchOutside(false);
        m5708d();
        if (Utils.isNetworkConnected(this.a)) {
            m5714f();
        } else {
            m5740c();
        }
        return inflate;
    }

    public void onRefresh() {
        m5714f();
    }
}
