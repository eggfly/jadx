package com.antutu.benchmark.p042e;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.activity.MainActivity.C1255c;
import com.antutu.benchmark.model.C1539q;
import com.antutu.benchmark.p036a.C1120j;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.view.MainViewPager;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.PointMark;
import com.antutu.utils.Utils;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.antutu.benchmark.e.m */
public class C1493m extends C1338c implements OnClickListener {
    C1492a f5087b;
    private MainViewPager f5088c;
    private List<C1539q> f5089d;
    private CheckedTextView f5090e;
    private CheckedTextView f5091f;
    private CheckedTextView f5092g;
    private CheckedTextView f5093h;
    private CheckedTextView[] f5094i;
    private TextView f5095j;
    private RelativeLayout f5096k;
    private C1255c f5097l;

    /* renamed from: com.antutu.benchmark.e.m.1 */
    class C14911 implements OnPageChangeListener {
        final /* synthetic */ C1493m f5085a;

        C14911(C1493m c1493m) {
            this.f5085a = c1493m;
        }

        public void onPageScrollStateChanged(int i) {
            MLog.m6864d("page state:" + i + "---index:" + this.f5085a.f5088c.getCurrentItem());
            if (i == 0) {
                int currentItem = this.f5085a.f5088c.getCurrentItem();
                if (this.f5085a.f5097l != null && currentItem == 3) {
                    this.f5085a.f5097l.m5128a();
                }
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            this.f5085a.m5889c(i);
        }
    }

    /* renamed from: com.antutu.benchmark.e.m.a */
    class C1492a extends C1120j implements OnPageChangeListener {
        final /* synthetic */ C1493m f5086a;

        public C1492a(C1493m c1493m, FragmentManager fragmentManager) {
            this.f5086a = c1493m;
            super(fragmentManager);
        }

        public Fragment m5879a(int i) {
            this.f5086a.m5885a(":getItem---" + i);
            C1539q c1539q = (C1539q) this.f5086a.f5089d.get(i);
            c1539q.f5358a.setArguments(c1539q.f5359b);
            c1539q.f5359b.putInt("page_num", i);
            return c1539q.f5358a;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
            this.f5086a.m5885a("destroyItem:" + i);
        }

        public int getCount() {
            return this.f5086a.f5089d.size();
        }

        @SuppressLint({"DefaultLocale"})
        public CharSequence getPageTitle(int i) {
            return ((C1539q) this.f5086a.f5089d.get(i)).f5360c;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public C1493m() {
        this.f5089d = new ArrayList();
        this.f5094i = new CheckedTextView[4];
        this.f5095j = null;
    }

    private void m5881a(View view) {
        this.f5090e = (CheckedTextView) view.findViewById(C1082R.id.ctv_home_test);
        this.f5091f = (CheckedTextView) view.findViewById(C1082R.id.ctv_home_rank);
        this.f5092g = (CheckedTextView) view.findViewById(C1082R.id.ctv_home_info);
        this.f5093h = (CheckedTextView) view.findViewById(C1082R.id.ctv_home_news);
        this.f5096k = (RelativeLayout) view.findViewById(C1082R.id.rl_home_news);
        this.f5094i[0] = this.f5090e;
        this.f5094i[1] = this.f5091f;
        this.f5094i[2] = this.f5092g;
        this.f5094i[3] = this.f5093h;
        if (!Utils.isCn(this.a)) {
            this.f5096k.setVisibility(8);
        }
    }

    private void m5882a(C1338c c1338c, Bundle bundle, String str) {
        this.f5089d.add(new C1539q(c1338c, bundle, str));
    }

    private void m5885a(String str) {
        MLog.m6865d("TabFragment", str);
    }

    private void m5887b(int i) {
        if (i == 0) {
            PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.K_MAIN_UI);
        } else if (i == 1) {
            PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.K_RANK_UI);
        } else if (i == 2) {
            PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.K_DEVICEINO);
        }
    }

    private void m5889c(int i) {
        try {
            ((C1539q) this.f5089d.get(i)).f5358a.m5394a();
        } catch (Exception e) {
        }
        for (int i2 = 0; i2 < this.f5094i.length; i2++) {
            if (i2 == i) {
                this.f5094i[i2].setChecked(true);
            } else {
                this.f5094i[i2].setChecked(false);
            }
        }
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                InfocUtil.antutu_tabshow(this.a, 1);
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_test);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                InfocUtil.antutu_tabshow(this.a, 2);
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_rank);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                InfocUtil.antutu_tabshow(this.a, 3);
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_info);
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                InfocUtil.antutu_tabshow(this.a, 4);
                MobclickAgent.onEvent(this.a, MobclickAgentConstants.click_news);
                break;
        }
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).m5187a(i);
        }
    }

    private void m5890d() {
        this.f5090e.setOnClickListener(this);
        this.f5091f.setOnClickListener(this);
        this.f5092g.setOnClickListener(this);
        this.f5093h.setOnClickListener(this);
        this.f5088c.addOnPageChangeListener(new C14911(this));
    }

    private void m5891e() {
        try {
            ((C1539q) this.f5089d.get(3)).f5358a.m5397b();
        } catch (Exception e) {
        }
    }

    public void m5892a(int i) {
        this.f5095j.setVisibility(i);
    }

    public void m5893a(int i, Object obj) {
        m5885a(":switchTab");
        if (i < 0 || i > this.f5089d.size() - 1) {
            throw new IllegalArgumentException("position is illegal!");
        }
        m5887b(i);
        this.f5088c.setCurrentItem(i);
        ((C1539q) this.f5089d.get(i)).f5358a.m5396a(obj);
    }

    public void m5894a(C1255c c1255c) {
        this.f5097l = c1255c;
    }

    public void m5895a(Object obj) {
        m5885a(":updateViews");
        for (int i = 0; i < this.f5089d.size(); i++) {
            ((C1539q) this.f5089d.get(i)).f5358a.m5396a(obj);
        }
    }

    public boolean m5896c() {
        if (this.f5090e.isChecked()) {
            return false;
        }
        this.f5088c.setCurrentItem(0);
        m5889c(0);
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.ctv_home_test /*2131624554*/:
                if (!this.f5090e.isChecked()) {
                    this.f5088c.setCurrentItem(0);
                    m5889c(0);
                }
            case C1082R.id.ctv_home_rank /*2131624555*/:
                if (!this.f5091f.isChecked()) {
                    this.f5088c.setCurrentItem(1);
                    m5889c(1);
                }
            case C1082R.id.ctv_home_info /*2131624556*/:
                if (!this.f5092g.isChecked()) {
                    this.f5088c.setCurrentItem(2);
                    m5889c(2);
                }
            case C1082R.id.ctv_home_news /*2131624558*/:
                if (this.f5093h.isChecked()) {
                    m5891e();
                    return;
                }
                this.f5088c.setCurrentItem(3);
                m5889c(3);
                m5892a(8);
            default:
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5885a(":onCreate");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_num", 0);
        Bundle bundle3 = new Bundle();
        bundle2.putInt("page_num", 1);
        Bundle bundle4 = new Bundle();
        bundle2.putInt("page_num", 2);
        Bundle bundle5 = new Bundle();
        bundle5.putInt("page_num", 4);
        m5882a(new C1410b(), bundle2, getString(C1082R.string.tab_test));
        m5882a(new C1473j(), bundle3, getString(C1082R.string.tab_rank));
        m5882a(new C1409a(), bundle4, getString(C1082R.string.tab_device));
        if (Utils.getLocalLanguage(this.a).equals("CN")) {
            m5882a(new C1439e(), bundle5, getString(C1082R.string.tab_news));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m5885a(":onCreateView");
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity().getApplicationContext(), C1082R.style.Theme_CustomPageIndicator)).inflate(C1082R.layout.tab_fragment, viewGroup, false);
        m5881a(inflate);
        this.f5087b = new C1492a(this, getFragmentManager());
        this.f5088c = (MainViewPager) inflate.findViewById(C1082R.id.pager);
        this.f5088c.setCanScroll(false);
        this.f5088c.setOffscreenPageLimit(this.f5089d.size());
        this.f5088c.setAdapter(this.f5087b);
        this.f5088c.requestFocus();
        this.f5095j = (TextView) inflate.findViewById(C1082R.id.unread);
        m5890d();
        m5889c(0);
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        m5885a("index:" + this.f5088c.getCurrentItem());
        bundle.putInt("pageIndex", this.f5088c.getCurrentItem());
    }
}
