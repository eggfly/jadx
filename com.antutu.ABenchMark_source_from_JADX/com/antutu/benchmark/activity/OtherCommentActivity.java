package com.antutu.benchmark.activity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
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
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.C1682l;
import com.antutu.benchmark.view.C1682l.C1681a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.utils.Methods;
import com.antutu.utils.Utils;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

public class OtherCommentActivity extends C1197a implements OnRefreshListener, OnClickListener {
    private C1353a f4370a;
    private CustomSwipeRefreshLayout f4371b;
    private ListView f4372c;
    private int f4373d;
    private LinearLayout f4374e;
    private LinearLayout f4375f;
    private boolean f4376g;
    private C1104c f4377h;
    private Button f4378i;
    private EditText f4379k;
    private Button f4380l;
    private TextView f4381m;
    private C1682l f4382n;
    private boolean f4383o;
    private boolean f4384p;
    private C1283a f4385q;
    private TextView f4386r;
    private long f4387s;
    private PopupWindow f4388t;
    private C1095a<CommentResponseModel> f4389u;
    private C1095a<CommentResponseModel> f4390v;
    private C1095a<CmtinfoEntity> f4391w;

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.1 */
    class C12741 implements OnScrollListener {
        final /* synthetic */ OtherCommentActivity f4358a;

        C12741(OtherCommentActivity otherCommentActivity) {
            this.f4358a = otherCommentActivity;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f4358a.f4371b.isRefreshing() && i2 + i >= i3 - 2 && i3 > 0 && Utils.isNetworkConnected(this.f4358a)) {
                this.f4358a.m5237j();
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.2 */
    class C12772 implements C1100a {
        final /* synthetic */ OtherCommentActivity f4361a;

        /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.2.1 */
        class C12751 implements TextWatcher {
            final /* synthetic */ C12772 f4359a;

            C12751(C12772 c12772) {
                this.f4359a = c12772;
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f4359a.f4361a.m5227d();
            }
        }

        /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.2.2 */
        class C12762 implements Runnable {
            final /* synthetic */ C12772 f4360a;

            C12762(C12772 c12772) {
                this.f4360a = c12772;
            }

            public void run() {
                ((InputMethodManager) this.f4360a.f4361a.f4379k.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        }

        C12772(OtherCommentActivity otherCommentActivity) {
            this.f4361a = otherCommentActivity;
        }

        public void m5199a(PopupWindow popupWindow, C1522c c1522c, int i) {
            this.f4361a.m5227d();
            this.f4361a.f4385q.m5216a(c1522c);
            this.f4361a.f4385q.m5215a(i);
            String h = c1522c.m6056h();
            if (i == 0) {
                h = c1522c.m6056h();
            } else if (c1522c.m6058j() != null && 1 == i) {
                h = c1522c.m6058j().getRegion();
            }
            this.f4361a.f4386r.setText(this.f4361a.getString(C1082R.string.reply) + h + this.f4361a.getString(C1082R.string.colon));
            this.f4361a.f4379k.requestFocus();
            this.f4361a.f4379k.addTextChangedListener(new C12751(this));
            this.f4361a.f4388t.showAtLocation(this.f4361a.f4371b, 80, 0, 0);
            new Handler().postDelayed(new C12762(this), 200);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.3 */
    class C12783 implements C1095a<DataBean> {
        final /* synthetic */ OtherCommentActivity f4362a;

        C12783(OtherCommentActivity otherCommentActivity) {
            this.f4362a = otherCommentActivity;
        }

        public void m5200a(DataBean dataBean) {
            this.f4362a.f4383o = true;
            if (dataBean.getCmtlist() != null && dataBean.getCmtlist().size() > 0) {
                C1101b c1101b = new C1101b();
                c1101b.f3689a = this.f4362a.getString(C1082R.string.hot_comment);
                c1101b.m4850a(dataBean.getCmtlist());
                this.f4362a.f4377h.m4863a(0, c1101b);
            }
            this.f4362a.m5238k();
        }

        public void m5202a(String str) {
            this.f4362a.f4383o = true;
            this.f4362a.m5238k();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.4 */
    class C12794 implements C1095a<CommentResponseModel> {
        final /* synthetic */ OtherCommentActivity f4363a;

        C12794(OtherCommentActivity otherCommentActivity) {
            this.f4363a = otherCommentActivity;
        }

        public void m5203a(CommentResponseModel commentResponseModel) {
            this.f4363a.f4371b.setRefreshing(false);
            List cmtlist = commentResponseModel.getData().getCmtlist();
            if (cmtlist.size() == 0) {
                Utils.show(this.f4363a, this.f4363a.getString(C1082R.string.no_more_comment));
                this.f4363a.f4376g = true;
                return;
            }
            this.f4363a.f4377h.m4866a(this.f4363a.getString(C1082R.string.news_comment), cmtlist);
            this.f4363a.f4377h.notifyDataSetChanged();
            this.f4363a.f4373d = ((CommentModel) cmtlist.get(cmtlist.size() - 1)).getId();
        }

        public void m5205a(String str) {
            this.f4363a.f4371b.setRefreshing(false);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.5 */
    class C12805 implements C1095a<CommentResponseModel> {
        final /* synthetic */ OtherCommentActivity f4364a;

        C12805(OtherCommentActivity otherCommentActivity) {
            this.f4364a = otherCommentActivity;
        }

        public void m5206a(CommentResponseModel commentResponseModel) {
            List cmtlist = commentResponseModel.getData().getCmtlist();
            if (cmtlist.size() == 0) {
                this.f4364a.m5243a(false);
                this.f4364a.f4371b.setRefreshing(false);
                this.f4364a.f4384p = false;
                this.f4364a.f4383o = false;
                return;
            }
            this.f4364a.m5243a(true);
            this.f4364a.f4373d = ((CommentModel) cmtlist.get(cmtlist.size() - 1)).getId();
            this.f4364a.f4384p = true;
            C1101b c1101b = new C1101b();
            c1101b.f3689a = this.f4364a.getString(C1082R.string.news_comment);
            c1101b.m4850a(cmtlist);
            this.f4364a.f4377h.m4865a(c1101b);
            this.f4364a.m5238k();
        }

        public void m5208a(String str) {
            this.f4364a.m5243a(false);
            this.f4364a.f4371b.setRefreshing(false);
            this.f4364a.f4377h.m4862a();
            this.f4364a.f4384p = false;
            this.f4364a.f4383o = false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.6 */
    class C12816 implements C1095a<CmtinfoEntity> {
        final /* synthetic */ OtherCommentActivity f4365a;

        C12816(OtherCommentActivity otherCommentActivity) {
            this.f4365a = otherCommentActivity;
        }

        public void m5209a(CmtinfoEntity cmtinfoEntity) {
            this.f4365a.f4382n.dismiss();
            Methods.showToast(this.f4365a, (int) C1082R.string.fabiaochenggong, 0);
            this.f4365a.f4379k.setText(BuildConfig.FLAVOR);
            Methods.hideSoftKeyboard(this.f4365a, this.f4365a.f4379k);
            this.f4365a.m5233h();
        }

        public void m5211a(String str) {
            this.f4365a.f4382n.dismiss();
            if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                Utils.show(this.f4365a, str);
            }
            Methods.hideSoftKeyboard(this.f4365a, this.f4365a.f4379k);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.a */
    private class C1283a implements OnClickListener {
        final /* synthetic */ OtherCommentActivity f4367a;
        private C1522c f4368b;
        private int f4369c;

        /* renamed from: com.antutu.benchmark.activity.OtherCommentActivity.a.1 */
        class C12821 implements C1095a<DataBean> {
            final /* synthetic */ C1283a f4366a;

            C12821(C1283a c1283a) {
                this.f4366a = c1283a;
            }

            public void m5212a(DataBean dataBean) {
                this.f4366a.f4367a.f4382n.dismiss();
                Methods.showToast(this.f4366a.f4367a, (int) C1082R.string.fabiaochenggong, 0);
                this.f4366a.f4367a.f4379k.setText(BuildConfig.FLAVOR);
                Methods.hideSoftKeyboard(this.f4366a.f4367a, this.f4366a.f4367a.f4379k);
                if (this.f4366a.f4367a.f4388t != null) {
                    this.f4366a.f4367a.f4388t.dismiss();
                }
                this.f4366a.f4367a.m5233h();
            }

            public void m5214a(String str) {
                this.f4366a.f4367a.f4382n.dismiss();
                if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                    Utils.show(this.f4366a.f4367a, str);
                }
                Methods.hideSoftKeyboard(this.f4366a.f4367a, this.f4366a.f4367a.f4379k);
                if (this.f4366a.f4367a.f4388t != null) {
                    this.f4366a.f4367a.f4388t.dismiss();
                }
            }
        }

        public C1283a(OtherCommentActivity otherCommentActivity) {
            this.f4367a = otherCommentActivity;
        }

        public void m5215a(int i) {
            this.f4369c = i;
        }

        public void m5216a(C1522c c1522c) {
            this.f4368b = c1522c;
        }

        public void onClick(View view) {
            if (this.f4368b != null) {
                String obj = this.f4367a.f4379k.getText().toString();
                if (obj.replace(" ", BuildConfig.FLAVOR).length() < 5 || obj.length() < 5) {
                    Utils.show(this.f4367a, this.f4367a.getString(C1082R.string.cant_less_five));
                    return;
                }
                this.f4367a.f4382n.show();
                this.f4367a.f4370a.m5413a(this.f4367a.f4387s, this.f4369c == 0 ? this.f4368b.m6051c() : this.f4368b.m6058j().getId(), obj, new C12821(this));
            }
        }
    }

    public OtherCommentActivity() {
        this.f4373d = 0;
        this.f4376g = false;
        this.f4383o = false;
        this.f4384p = false;
        this.f4389u = new C12794(this);
        this.f4390v = new C12805(this);
        this.f4391w = new C12816(this);
    }

    private void m5220b() {
        this.f4371b.setOnRefreshListener(this);
        this.f4380l.setOnClickListener(this);
        this.f4372c.setOnScrollListener(new C12741(this));
        this.f4377h.m4864a(new C12772(this));
    }

    private void m5223c() {
        this.f4388t = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this).inflate(C1082R.layout.reply_comment_bottom_bar, null);
        this.f4388t.setContentView(inflate);
        this.f4386r = (TextView) inflate.findViewById(C1082R.id.reply_title);
        this.f4378i = (Button) inflate.findViewById(C1082R.id.send_btn);
        this.f4379k = (EditText) inflate.findViewById(C1082R.id.et_comment_text);
        this.f4378i.setOnClickListener(this);
        this.f4388t.setFocusable(true);
        this.f4388t.setOutsideTouchable(true);
        this.f4388t.setBackgroundDrawable(new BitmapDrawable());
        this.f4388t.setSoftInputMode(20);
        this.f4378i.setOnClickListener(this.f4385q);
    }

    private void m5227d() {
        String obj = this.f4379k.getText().toString();
        if (obj == null || obj.toString().trim().length() <= 0) {
            this.f4378i.setBackgroundResource(C1082R.drawable.send);
        } else {
            this.f4378i.setBackgroundResource(C1082R.drawable.send_red);
        }
        this.f4386r.setVisibility(0);
    }

    private void m5229e() {
        this.f4371b = (CustomSwipeRefreshLayout) findViewById(C1082R.id.sr_refresh);
        this.f4372c = (ListView) findViewById(C1082R.id.list);
        this.f4374e = (LinearLayout) findViewById(C1082R.id.no_content);
        this.f4375f = (LinearLayout) findViewById(C1082R.id.no_net);
        this.f4380l = (Button) findViewById(C1082R.id.btn_refresh);
        this.f4381m = (TextView) findViewById(C1082R.id.tv_device);
    }

    private void m5233h() {
        if (Utils.isNetworkConnected(this)) {
            m5243a(true);
        } else {
            m5242a();
        }
        m5234i();
        this.f4371b.setRefreshing(true);
        this.f4370a.m5412a(this.f4387s, this.f4373d, this.f4390v);
        this.f4370a.m5414a(this.f4387s, new C12783(this));
    }

    private void m5234i() {
        this.f4373d = 0;
        this.f4376g = false;
        this.f4383o = false;
        this.f4384p = false;
        this.f4377h.m4862a();
    }

    private void m5237j() {
        this.f4371b.setRefreshing(true);
        this.f4370a.m5412a(this.f4387s, this.f4373d, this.f4389u);
    }

    private void m5238k() {
        if (this.f4383o && this.f4384p) {
            this.f4377h.notifyDataSetChanged();
            this.f4371b.setRefreshing(false);
        }
    }

    public void m5242a() {
        this.f4374e.setVisibility(8);
        this.f4375f.setVisibility(0);
        this.f4371b.setVisibility(8);
    }

    public void m5243a(boolean z) {
        if (z) {
            this.f4374e.setVisibility(8);
            this.f4375f.setVisibility(8);
            this.f4371b.setVisibility(0);
            return;
        }
        this.f4374e.setVisibility(0);
        this.f4375f.setVisibility(8);
        this.f4371b.setVisibility(8);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.btn_refresh /*2131624109*/:
                if (Utils.isNetworkConnected(this)) {
                    m5233h();
                } else {
                    Methods.showToast((Context) this, getString(C1082R.string.net_work_error_try), 0);
                }
            default:
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_other_comment);
        this.f4387s = getIntent().getLongExtra("INTENT_ACTION_MODEL_ID", C1503b.m5915c().m5960n(this));
        CharSequence stringExtra = getIntent().getStringExtra("INTENT_ACTION_PHONE_NAME");
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, stringExtra, false, this.j, null));
        this.f4385q = new C1283a(this);
        m5229e();
        m5223c();
        this.f4381m.setText(stringExtra);
        this.f4370a = new C1353a(this);
        this.f4377h = new C1104c(this, true, "PAGE_COMMENT");
        this.f4372c.setAdapter(this.f4377h);
        C1681a c1681a = new C1681a(this);
        c1681a.m6589a(getString(C1082R.string.sending));
        this.f4382n = c1681a.m6590a();
        this.f4382n.setCanceledOnTouchOutside(false);
        m5220b();
        if (Utils.isNetworkConnected(this)) {
            m5233h();
        } else {
            m5242a();
        }
    }

    public void onRefresh() {
        m5233h();
    }
}
