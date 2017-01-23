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

/* renamed from: com.antutu.benchmark.e.l */
public class C1490l extends C1338c implements OnRefreshListener {
    private CustomSwipeRefreshLayout f5074b;
    private ListView f5075c;
    private LinearLayout f5076d;
    private TextView f5077e;
    private C1353a f5078f;
    private C1104c f5079g;
    private int f5080h;
    private int f5081i;
    private boolean f5082j;
    private C1690n f5083k;
    private C1682l f5084l;

    /* renamed from: com.antutu.benchmark.e.l.1 */
    class C14831 implements OnScrollListener {
        final /* synthetic */ C1490l f5066a;

        C14831(C1490l c1490l) {
            this.f5066a = c1490l;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f5066a.f5074b.isRefreshing() && i2 + i >= i3 - 2 && i3 > 0 && Utils.isNetworkConnected(this.f5066a.a)) {
                this.f5066a.m5855c();
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.l.2 */
    class C14842 implements OnClickListener {
        final /* synthetic */ C1490l f5067a;

        C14842(C1490l c1490l) {
            this.f5067a = c1490l;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.f5067a.a, MainActivity.class);
            intent.putExtra("ACTION_HAS_JUMP_PAGE", true);
            intent.putExtra("ACTION_JUMP_PAGE", "ACTION_JUMP_PAGE_COMMENT");
            this.f5067a.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.e.l.3 */
    class C14853 implements C1100a {
        final /* synthetic */ C1490l f5068a;

        C14853(C1490l c1490l) {
            this.f5068a = c1490l;
        }

        public void m5841a(PopupWindow popupWindow, C1522c c1522c, int i) {
            String h = c1522c.m6056h();
            if (i == 0) {
                h = c1522c.m6056h();
            } else if (c1522c.m6058j() != null && 1 == i) {
                h = c1522c.m6058j().getRegion();
            }
            this.f5068a.f5083k.m6604a(this.f5068a.getString(C1082R.string.reply) + h + this.f5068a.getString(C1082R.string.colon));
            int[] iArr = new int[2];
            this.f5068a.f5075c.getLocationOnScreen(iArr);
            this.f5068a.f5083k.showAtLocation(this.f5068a.f5075c, 0, iArr[0], (iArr[1] + this.f5068a.f5075c.getHeight()) - this.f5068a.f5083k.getHeight());
            this.f5068a.f5083k.m6602a(c1522c);
            this.f5068a.f5083k.m6601a(i);
            this.f5068a.f5083k.m6600a();
        }
    }

    /* renamed from: com.antutu.benchmark.e.l.4 */
    class C14874 implements C1478a {
        final /* synthetic */ C1490l f5071a;

        /* renamed from: com.antutu.benchmark.e.l.4.1 */
        class C14861 implements C1095a<DataBean> {
            final /* synthetic */ EditText f5069a;
            final /* synthetic */ C14874 f5070b;

            C14861(C14874 c14874, EditText editText) {
                this.f5070b = c14874;
                this.f5069a = editText;
            }

            public void m5842a(DataBean dataBean) {
                this.f5070b.f5071a.f5084l.dismiss();
                Methods.showToast(this.f5070b.f5071a.a, (int) C1082R.string.fabiaochenggong, 0);
                this.f5069a.setText(BuildConfig.FLAVOR);
                Methods.hideSoftKeyboard(this.f5070b.f5071a.a, this.f5069a);
                this.f5070b.f5071a.f5083k.dismiss();
                this.f5070b.f5071a.m5858d();
            }

            public void m5844a(String str) {
                this.f5070b.f5071a.f5084l.dismiss();
                if (!(BuildConfig.FLAVOR.equals(str) || str == null)) {
                    Utils.show(this.f5070b.f5071a.a, str);
                }
                Methods.hideSoftKeyboard(this.f5070b.f5071a.a, this.f5069a);
            }
        }

        C14874(C1490l c1490l) {
            this.f5071a = c1490l;
        }

        public void m5845a(EditText editText, String str, C1522c c1522c, int i) {
            if (c1522c != null) {
                if ((str == null || str.replace(" ", BuildConfig.FLAVOR).length() >= 5) && str.length() >= 5) {
                    this.f5071a.f5084l.show();
                    this.f5071a.f5078f.m5413a(C1503b.m5915c().m5960n(this.f5071a.a), i == 0 ? c1522c.m6051c() : c1522c.m6058j().getId(), str, new C14861(this, editText));
                    return;
                }
                Utils.show(this.f5071a.a, this.f5071a.getString(C1082R.string.cant_less_five));
            }
        }
    }

    /* renamed from: com.antutu.benchmark.e.l.5 */
    class C14885 implements C1095a<CommentSendResponseModel> {
        final /* synthetic */ C1490l f5072a;

        C14885(C1490l c1490l) {
            this.f5072a = c1490l;
        }

        public void m5846a(CommentSendResponseModel commentSendResponseModel) {
            this.f5072a.f5074b.setRefreshing(false);
            this.f5072a.f5080h = this.f5072a.f5080h + 1;
            if (commentSendResponseModel.getData().getCmtlist().size() > 0 || this.f5072a.f5081i <= 0) {
                this.f5072a.f5081i = this.f5072a.f5081i + 1;
                C1101b c1101b = new C1101b();
                c1101b.m4852b(commentSendResponseModel.getData().getCmtlist());
                this.f5072a.f5079g.m4865a(c1101b);
                this.f5072a.f5079g.m4867b(null, commentSendResponseModel.getData().getCmtlist());
                this.f5072a.f5079g.notifyDataSetChanged();
                return;
            }
            Utils.show(this.f5072a.a, this.f5072a.getString(C1082R.string.no_more_comment));
            this.f5072a.f5082j = true;
        }

        public void m5848a(String str) {
            this.f5072a.f5074b.setRefreshing(false);
            this.f5072a.f5081i = this.f5072a.f5081i + 1;
        }
    }

    /* renamed from: com.antutu.benchmark.e.l.6 */
    class C14896 implements C1095a<CommentSendResponseModel> {
        final /* synthetic */ C1490l f5073a;

        C14896(C1490l c1490l) {
            this.f5073a = c1490l;
        }

        public void m5849a(CommentSendResponseModel commentSendResponseModel) {
            this.f5073a.f5074b.setRefreshing(false);
            if (commentSendResponseModel.getData().getCmtlist().size() <= 0) {
                this.f5073a.m5860e();
                return;
            }
            this.f5073a.m5862f();
            this.f5072a.f5080h = this.f5073a.f5080h + 1;
            C1101b c1101b = new C1101b();
            c1101b.m4852b(commentSendResponseModel.getData().getCmtlist());
            this.f5073a.f5079g.m4865a(c1101b);
            this.f5073a.f5079g.notifyDataSetChanged();
        }

        public void m5851a(String str) {
            this.f5073a.f5074b.setRefreshing(false);
            this.f5073a.m5860e();
        }
    }

    public C1490l() {
        this.f5080h = 1;
        this.f5081i = 0;
        this.f5082j = false;
    }

    private void m5855c() {
        this.f5074b.setRefreshing(true);
        if (isAdded() && !Utils.isNetworkConnected(getActivity())) {
            Methods.showToast(getActivity(), getString(C1082R.string.net_work_error_try), 1);
            this.f5074b.setRefreshing(false);
        } else if (this.f5082j) {
            if (this.f5081i > 0) {
                Methods.showToast(this.a, (int) C1082R.string.listfooterview_finished, 0);
            }
            this.f5074b.setRefreshing(false);
        } else {
            this.f5078f.m5410a(this.f5080h, new C14885(this));
        }
    }

    private void m5858d() {
        this.f5080h = 1;
        this.f5074b.setRefreshing(true);
        this.f5079g.m4862a();
        this.f5078f.m5410a(this.f5080h, new C14896(this));
    }

    private void m5860e() {
        this.f5076d.setVisibility(0);
        this.f5074b.setVisibility(8);
    }

    private void m5862f() {
        this.f5076d.setVisibility(8);
        this.f5074b.setVisibility(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_send_message, null);
        this.f5078f = new C1353a(this.a);
        this.f5074b = (CustomSwipeRefreshLayout) inflate.findViewById(C1082R.id.sr_ll_refresh);
        this.f5075c = (ListView) inflate.findViewById(C1082R.id.list);
        this.f5076d = (LinearLayout) inflate.findViewById(C1082R.id.ll_nocomment);
        this.f5077e = (TextView) inflate.findViewById(C1082R.id.tv_nocomment);
        this.f5083k = new C1690n(this.a);
        this.f5079g = new C1104c(this.a, true, "PAGE_MY_SEND");
        this.f5075c.setAdapter(this.f5079g);
        this.f5074b.setOnRefreshListener(this);
        C1681a c1681a = new C1681a(this.a);
        c1681a.m6589a(getString(C1082R.string.sending));
        this.f5084l = c1681a.m6590a();
        this.f5084l.setCanceledOnTouchOutside(false);
        this.f5075c.setOnScrollListener(new C14831(this));
        this.f5077e.setOnClickListener(new C14842(this));
        this.f5079g.m4864a(new C14853(this));
        this.f5083k.m6603a(new C14874(this));
        m5858d();
        return inflate;
    }

    public void onRefresh() {
        m5858d();
    }
}
