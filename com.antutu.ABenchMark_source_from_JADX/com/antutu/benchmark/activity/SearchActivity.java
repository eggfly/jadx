package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import anet.channel.strategy.dispatch.C0714a;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.modelreflact.SearchDetailModel;
import com.antutu.benchmark.modelreflact.SearchDetailResponseModel;
import com.antutu.benchmark.modelreflact.SearchResponseModel;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p044h.C1509a;
import com.antutu.benchmark.p045i.C1512a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.redacc.C1692R;
import com.antutu.utils.JsonParseUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.RequestListener;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.google.analytics.tracking.android.ModelFields;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class SearchActivity extends C1197a implements OnClickListener, OnRefreshListener2 {
    private View f4443a;
    private ImageView f4444b;
    private LinearLayout f4445c;
    private LinearLayout f4446d;
    private LinearLayout f4447e;
    private LinearLayout f4448f;
    private LinearLayout f4449g;
    private EditText f4450h;
    private ImageView f4451i;
    private PullToRefreshListView f4452k;
    private String f4453l;
    private C1509a f4454m;
    private List<SearchDetailModel> f4455n;
    private int f4456o;
    private int f4457p;
    private Handler f4458q;
    private OnClickListener f4459r;

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.1 */
    class C12961 extends Handler {
        final /* synthetic */ SearchActivity f4437a;

        C12961(SearchActivity searchActivity) {
            this.f4437a = searchActivity;
        }

        public void handleMessage(Message message) {
            SearchDetailResponseModel searchDetailResponseModel;
            switch (message.what) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    this.f4437a.f4448f.setVisibility(8);
                    this.f4437a.f4443a.setVisibility(8);
                    this.f4437a.f4445c.setVisibility(0);
                    this.f4437a.f4446d.setVisibility(0);
                    this.f4437a.f4452k.setVisibility(0);
                    searchDetailResponseModel = (SearchDetailResponseModel) message.obj;
                    this.f4437a.f4456o = searchDetailResponseModel.getPager().getCurrPage();
                    this.f4437a.f4457p = searchDetailResponseModel.getPager().getTotalPage();
                    this.f4437a.f4455n.clear();
                    this.f4437a.f4455n.addAll(searchDetailResponseModel.getThelist());
                    this.f4437a.f4454m.m5994a(this.f4437a.f4455n);
                    this.f4437a.f4454m.notifyDataSetChanged();
                    if (searchDetailResponseModel.getThelist().size() > 0) {
                        ((ListView) this.f4437a.f4452k.getRefreshableView()).setSelection(0);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f4437a.f4445c.setVisibility(0);
                    this.f4437a.f4446d.setVisibility(0);
                    this.f4437a.f4443a.setVisibility(0);
                    this.f4437a.f4452k.setVisibility(8);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    searchDetailResponseModel = (SearchDetailResponseModel) message.obj;
                    this.f4437a.f4456o = searchDetailResponseModel.getPager().getCurrPage();
                    this.f4437a.f4457p = searchDetailResponseModel.getPager().getTotalPage();
                    this.f4437a.f4455n.addAll(searchDetailResponseModel.getThelist());
                    this.f4437a.f4454m.m5994a(this.f4437a.f4455n);
                    this.f4437a.f4454m.notifyDataSetChanged();
                default:
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.2 */
    class C12972 implements OnClickListener {
        final /* synthetic */ SearchActivity f4438a;

        C12972(SearchActivity searchActivity) {
            this.f4438a = searchActivity;
        }

        public void onClick(View view) {
            Methods.hideSoftKeyboard(this.f4438a, this.f4438a.f4450h);
            this.f4438a.j.onClick(view);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.3 */
    class C12983 implements OnClickListener {
        final /* synthetic */ SearchActivity f4439a;

        C12983(SearchActivity searchActivity) {
            this.f4439a = searchActivity;
        }

        public void onClick(View view) {
            this.f4439a.f4450h.setText(BuildConfig.FLAVOR);
            this.f4439a.f4450h.requestFocus();
            this.f4439a.f4446d.setVisibility(8);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.4 */
    class C12994 implements RequestListener {
        final /* synthetic */ SearchActivity f4440a;

        C12994(SearchActivity searchActivity) {
            this.f4440a = searchActivity;
        }

        public void setRespond(int i, String str) {
            if (i != -1) {
                String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                if (commonResponseModel == null) {
                    Methods.showToast(this.f4440a, (int) C1692R.string.network_error, 1);
                } else if (commonResponseModel.getIsdata() != 1) {
                    r1 = Message.obtain();
                    r1.what = 1;
                    r1.obj = commonResponseModel.getDesc();
                    this.f4440a.f4458q.sendMessage(r1);
                } else {
                    SearchDetailResponseModel data = ((SearchResponseModel) JsonParseUtil.parse(stringSafe, SearchResponseModel.class)).getData();
                    r1 = Message.obtain();
                    r1.obj = data;
                    r1.what = 0;
                    this.f4440a.f4458q.sendMessage(r1);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.5 */
    class C13005 implements Runnable {
        final /* synthetic */ SearchActivity f4441a;

        C13005(SearchActivity searchActivity) {
            this.f4441a = searchActivity;
        }

        public void run() {
            Methods.showToast(this.f4441a, (int) C1082R.string.not_have_more, 0);
            this.f4441a.f4452k.onRefreshComplete();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SearchActivity.6 */
    class C13016 implements RequestListener {
        final /* synthetic */ SearchActivity f4442a;

        C13016(SearchActivity searchActivity) {
            this.f4442a = searchActivity;
        }

        public void setRespond(int i, String str) {
            if (i != -1) {
                String stringSafe = jni.getStringSafe(str, BuildConfig.FLAVOR);
                CommonResponseModel commonResponseModel = (CommonResponseModel) JsonParseUtil.parse(stringSafe, CommonResponseModel.class);
                this.f4442a.f4452k.onRefreshComplete();
                if (commonResponseModel == null) {
                    Methods.showToast(this.f4442a, (int) C1692R.string.network_error, 1);
                } else if (commonResponseModel.getIsdata() != 1) {
                    this.f4442a.f4458q.sendEmptyMessage(1);
                } else {
                    SearchDetailResponseModel data = ((SearchResponseModel) JsonParseUtil.parse(stringSafe, SearchResponseModel.class)).getData();
                    Message obtain = Message.obtain();
                    obtain.obj = data;
                    obtain.what = 2;
                    this.f4442a.f4458q.sendMessage(obtain);
                }
            }
        }
    }

    public SearchActivity() {
        this.f4455n = new ArrayList();
        this.f4456o = 1;
        this.f4457p = 1;
        this.f4458q = new C12961(this);
        this.f4459r = new C12972(this);
    }

    private void m5264a() {
        this.f4445c = (LinearLayout) findViewById(C1082R.id.start_search_layout);
        this.f4444b = (ImageView) findViewById(C1082R.id.start_search_btn);
        this.f4449g = (LinearLayout) findViewById(C1082R.id.start_search_ll);
        this.f4450h = (EditText) findViewById(C1082R.id.search_edit_text);
        this.f4450h.requestFocus();
        this.f4451i = (ImageView) findViewById(C1082R.id.clear_search_btn);
        this.f4446d = (LinearLayout) findViewById(C1082R.id.linear_result);
        this.f4447e = (LinearLayout) findViewById(C1082R.id.linear_fail);
        this.f4448f = (LinearLayout) findViewById(C1082R.id.linear_searching);
        this.f4452k = (PullToRefreshListView) findViewById(C1082R.id.ListViewRank);
        this.f4452k.setMode(Mode.PULL_FROM_END);
        this.f4443a = findViewById(C1082R.id.linear_no_result);
    }

    private void m5267b() {
        this.f4451i.setOnClickListener(new C12983(this));
        this.f4444b.setOnClickListener(this);
        this.f4449g.setOnClickListener(this);
        this.f4452k.setOnRefreshListener((OnRefreshListener2) this);
    }

    private void m5269c() {
        Methods.hideSoftKeyboard(this, this.f4450h);
        this.f4446d.setVisibility(8);
        this.f4448f.setVisibility(0);
        m5271d();
    }

    private void m5271d() {
        C1512a c1512a = new C1512a();
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", this.f4453l);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageIntZero(this));
        hashMap.put(ModelFields.PAGE, Integer.valueOf(1));
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_app", Utils.getVersionCode());
        c1512a.m5997a(hashMap);
        c1512a.m5996a(new C12994(this));
    }

    private void m5273e() {
        if (this.f4457p <= this.f4456o) {
            this.f4458q.postDelayed(new C13005(this), 300);
            return;
        }
        C1512a c1512a = new C1512a();
        HashMap hashMap = new HashMap();
        hashMap.put("keyword", this.f4453l);
        hashMap.put(PointMark.T_LANG, Utils.getLocalLanguageIntZero(this));
        String str = ModelFields.PAGE;
        int i = this.f4456o + 1;
        this.f4456o = i;
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(Constants.KEY_OS_VERSION, C0714a.ANDROID);
        hashMap.put("version_app", Utils.getVersionCode());
        c1512a.m5997a(hashMap);
        c1512a.m5996a(new C13016(this));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.start_search_ll /*2131624520*/:
            case C1082R.id.start_search_btn /*2131624521*/:
                this.f4453l = this.f4450h.getText().toString().trim();
                if (TextUtils.isEmpty(this.f4453l)) {
                    this.f4450h.requestFocus();
                } else {
                    m5269c();
                }
            default:
        }
    }

    protected void onCreate(Bundle bundle) {
        OnItemClickListener onItemClickListener = null;
        super.onCreate(bundle);
        setContentView(C1082R.layout.searchresult);
        PointMark.getInstance(this).pointThis(PointMark.K_SEARCHRESULT);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.search), false, this.f4459r, null));
        m5264a();
        m5267b();
        this.f4454m = new C1509a(this, this.f4455n);
        this.f4452k.setAdapter(this.f4454m);
        PullToRefreshListView pullToRefreshListView = this.f4452k;
        if (Methods.isChinese()) {
            onItemClickListener = this.f4454m;
        }
        pullToRefreshListView.setOnItemClickListener(onItemClickListener);
    }

    public void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase) {
    }

    public void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase) {
        m5273e();
    }
}
