package com.antutu.benchmark.p042e;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.model.C1522c;
import com.antutu.benchmark.modelreflact.CommentResponseModel.DataBean;
import com.antutu.benchmark.modelreflact.CommentSendResponseModel;
import com.antutu.benchmark.p036a.C1104c;
import com.antutu.benchmark.p036a.C1104c.C1100a;
import com.antutu.benchmark.p036a.C1104c.C1101b;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.C1682l;
import com.antutu.benchmark.view.C1682l.C1681a;
import com.antutu.benchmark.view.C1690n;
import com.antutu.benchmark.view.C1690n.C1478a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import com.antutu.utils.Methods;
import com.antutu.utils.Utils;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.e.k */
public class C1482k extends C1338c implements OnRefreshListener {
    private CustomSwipeRefreshLayout f5055b;
    private ListView f5056c;
    private LinearLayout f5057d;
    private TextView f5058e;
    private C1353a f5059f;
    private C1104c f5060g;
    private int f5061h;
    private int f5062i;
    private boolean f5063j;
    private C1690n f5064k;
    private C1682l f5065l;

    /* renamed from: com.antutu.benchmark.e.k.1 */
    class C14741 implements OnScrollListener {
        final /* synthetic */ C1482k f5047a;

        C14741(C1482k c1482k) {
            this.f5047a = c1482k;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f5047a.f5055b.isRefreshing() && i2 + i >= i3 - 2 && i3 > 0 && Utils.isNetworkConnected(this.f5047a.a)) {
                this.f5047a.m5817c();
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.k.2 */
    class C14752 implements OnClickListener {
        final /* synthetic */ C1482k f5048a;

        C14752(C1482k c1482k) {
            this.f5048a = c1482k;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f5048a.a, MainActivity.class);
            intent.putExtra("ACTION_HAS_JUMP_PAGE", true);
            intent.putExtra("ACTION_JUMP_PAGE", "ACTION_JUMP_PAGE_COMMENT");
            this.f5048a.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.e.k.3 */
    class C14763 implements C1100a {
        final /* synthetic */ C1482k f5049a;

        C14763(C1482k c1482k) {
            this.f5049a = c1482k;
        }

        public void m5802a(PopupWindow popupWindow, C1522c c1522c, int i) {
            String h = c1522c.m6056h();
            if (i == 0) {
                h = c1522c.m6056h();
            } else if (c1522c.m6058j() != null && 1 == i) {
                h = c1522c.m6058j().getRegion();
            }
            this.f5049a.f5064k.m6604a(this.f5049a.getString(C1082R.string.reply) + h + this.f5049a.getString(C1082R.string.colon));
            int[] iArr = new int[2];
            this.f5049a.f5056c.getLocationOnScreen(iArr);
            this.f5049a.f5064k.showAtLocation(this.f5049a.f5056c, 0, iArr[0], (iArr[1] + this.f5049a.f5056c.getHeight()) - this.f5049a.f5064k.getHeight());
            this.f5049a.f5064k.m6602a(c1522c);
            this.f5049a.f5064k.m6601a(i);
            this.f5049a.f5064k.m6600a();
        }
    }

    /* renamed from: com.antutu.benchmark.e.k.4 */
    class C14794 implements C1478a {
        final /* synthetic */ C1482k f5052a;

        /* renamed from: com.antutu.benchmark.e.k.4.1 */
        class C14771 implements C1095a<DataBean> {
            final /* synthetic */ EditText f5050a;
            final /* synthetic */ C14794 f5051b;

            C14771(C14794 c14794, EditText editText) {
                this.f5051b = c14794;
                this.f5050a = editText;
            }

            public void m5803a(DataBean dataBean) {
                this.f5051b.f5052a.f5065l.dismiss();
                Methods.showToast(this.f5051b.f5052a.a, (int) C1082R.string.fabiaochenggong, 0);
                this.f5050a.setText(BuildConfig.FLAVOR);
                Methods.hideSoftKeyboard(this.f5051b.f5052a.a, this.f5050a);
                this.f5051b.f5052a.f5064k.dismiss();
                this.f5051b.f5052a.m5820d();
            }

            public void m5805a(String str) {
                this.f5051b.f5052a.f5065l.dismiss();
                if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                    Utils.show(this.f5051b.f5052a.a, str);
                }
                Methods.hideSoftKeyboard(this.f5051b.f5052a.a, this.f5050a);
            }
        }

        C14794(C1482k c1482k) {
            this.f5052a = c1482k;
        }

        public void m5807a(EditText editText, String str, C1522c c1522c, int i) {
            if (c1522c != null) {
                if ((str == null || str.replace(" ", BuildConfig.FLAVOR).length() >= 5) && str.length() >= 5) {
                    this.f5052a.f5065l.show();
                    this.f5052a.f5059f.m5413a(C1503b.m5915c().m5960n(this.f5052a.a), i == 0 ? c1522c.m6051c() : c1522c.m6058j().getId(), str, new C14771(this, editText));
                    return;
                }
                Utils.show(this.f5052a.a, this.f5052a.getString(C1082R.string.cant_less_five));
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.k.5 */
    class C14805 implements C1095a<CommentSendResponseModel> {
        final /* synthetic */ C1482k f5053a;

        C14805(C1482k c1482k) {
            this.f5053a = c1482k;
        }

        public void m5808a(CommentSendResponseModel commentSendResponseModel) {
            this.f5053a.f5055b.setRefreshing(false);
            this.f5053a.f5061h = this.f5053a.f5061h + 1;
            if (commentSendResponseModel.getData().getCmtlist().size() > 0 || this.f5053a.f5062i <= 0) {
                this.f5053a.f5062i = this.f5053a.f5062i + 1;
                C1101b c1101b = new C1101b();
                c1101b.m4852b(commentSendResponseModel.getData().getCmtlist());
                this.f5053a.f5060g.m4865a(c1101b);
                this.f5053a.f5060g.m4867b(null, commentSendResponseModel.getData().getCmtlist());
                this.f5053a.f5060g.notifyDataSetChanged();
                return;
            }
            Utils.show(this.f5053a.a, this.f5053a.getString(C1082R.string.no_more_comment));
            this.f5053a.f5063j = true;
        }

        public void m5810a(String str) {
            this.f5053a.f5055b.setRefreshing(false);
            this.f5053a.f5062i = this.f5053a.f5062i + 1;
        }
    }

    /* renamed from: com.antutu.benchmark.e.k.6 */
    class C14816 implements C1095a<CommentSendResponseModel> {
        final /* synthetic */ C1482k f5054a;

        C14816(C1482k c1482k) {
            this.f5054a = c1482k;
        }

        public void m5811a(CommentSendResponseModel commentSendResponseModel) {
            this.f5054a.f5055b.setRefreshing(false);
            if (commentSendResponseModel.getData().getCmtlist().size() <= 0) {
                this.f5054a.m5822e();
                return;
            }
            this.f5054a.m5824f();
            this.f5053a.f5061h = this.f5054a.f5061h + 1;
            C1101b c1101b = new C1101b();
            c1101b.m4852b(commentSendResponseModel.getData().getCmtlist());
            this.f5054a.f5060g.m4865a(c1101b);
            this.f5054a.f5060g.notifyDataSetChanged();
        }

        public void m5813a(String str) {
            this.f5054a.f5055b.setRefreshing(false);
            this.f5054a.m5822e();
        }
    }

    public C1482k() {
        this.f5061h = 1;
        this.f5062i = 0;
        this.f5063j = false;
    }

    private void m5817c() {
        this.f5055b.setRefreshing(true);
        if (isAdded() && !Utils.isNetworkConnected(getActivity())) {
            Methods.showToast(getActivity(), getString(C1082R.string.net_work_error_try), 1);
            this.f5055b.setRefreshing(false);
        } else if (this.f5063j) {
            if (this.f5062i > 0) {
                Methods.showToast(this.a, (int) C1082R.string.listfooterview_finished, 0);
            }
            this.f5055b.setRefreshing(false);
        } else {
            this.f5059f.m5417b(this.f5061h, new C14805(this));
        }
    }

    private void m5820d() {
        this.f5061h = 1;
        this.f5055b.setRefreshing(true);
        this.f5060g.m4862a();
        this.f5059f.m5417b(this.f5061h, new C14816(this));
    }

    private void m5822e() {
        this.f5057d.setVisibility(0);
        this.f5055b.setVisibility(8);
    }

    private void m5824f() {
        this.f5057d.setVisibility(8);
        this.f5055b.setVisibility(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_send_message, null);
        this.f5059f = new C1353a(this.a);
        this.f5055b = (CustomSwipeRefreshLayout) inflate.findViewById(C1082R.id.sr_ll_refresh);
        this.f5056c = (ListView) inflate.findViewById(C1082R.id.list);
        this.f5057d = (LinearLayout) inflate.findViewById(C1082R.id.ll_nocomment);
        this.f5058e = (TextView) inflate.findViewById(C1082R.id.tv_nocomment);
        this.f5064k = new C1690n(this.a);
        this.f5060g = new C1104c(this.a, true, "PAGE_MY_RECEIVE");
        this.f5056c.setAdapter(this.f5060g);
        this.f5055b.setOnRefreshListener(this);
        C1681a c1681a = new C1681a(this.a);
        c1681a.m6589a(getString(C1082R.string.sending));
        this.f5065l = c1681a.m6590a();
        this.f5065l.setCanceledOnTouchOutside(false);
        this.f5056c.setOnScrollListener(new C14741(this));
        this.f5058e.setOnClickListener(new C14752(this));
        this.f5060g.m4864a(new C14763(this));
        this.f5064k.m6603a(new C14794(this));
        m5820d();
        return inflate;
    }

    public void onRefresh() {
        m5820d();
    }
}
