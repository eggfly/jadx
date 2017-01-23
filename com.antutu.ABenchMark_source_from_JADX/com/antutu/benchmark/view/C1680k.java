package com.antutu.benchmark.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.HotNewsActivity;
import com.antutu.benchmark.modelreflact.HotNewsBannerModel;
import com.antutu.redacc.C1692R;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.MobclickAgentConstants;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.view.k */
public class C1680k extends LinearLayout implements OnPageChangeListener {
    final Runnable f5990a;
    private Context f5991b;
    private BaseViewPager f5992c;
    private LinearLayout f5993d;
    private List<ImageView> f5994e;
    private ImageView[] f5995f;
    private TextView f5996g;
    private BaseViewPager f5997h;
    private C1679b f5998i;
    private Handler f5999j;
    private int f6000k;
    private int f6001l;
    private boolean f6002m;
    private boolean f6003n;
    private long f6004o;
    private int f6005p;
    private int f6006q;
    private C1431a f6007r;
    private List<HotNewsBannerModel> f6008s;
    private LinearLayout f6009t;

    /* renamed from: com.antutu.benchmark.view.k.a */
    public interface C1431a {
        void m5643a(HotNewsBannerModel hotNewsBannerModel, int i, View view);
    }

    /* renamed from: com.antutu.benchmark.view.k.1 */
    class C16751 extends Handler {
        final /* synthetic */ C1680k f5985a;

        C16751(C1680k c1680k) {
            this.f5985a = c1680k;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == this.f5985a.f6005p && this.f5985a.f5994e.size() != 0) {
                if (!this.f5985a.f6002m) {
                    int size = this.f5985a.f5994e.size() + 1;
                    int d = (this.f5985a.f6001l + 1) % this.f5985a.f5994e.size();
                    this.f5985a.f5992c.setCurrentItem(d, true);
                    if (d == size) {
                        this.f5985a.f5992c.setCurrentItem(1, false);
                    }
                }
                this.f5985a.f6004o = System.currentTimeMillis();
                this.f5985a.f5999j.removeCallbacks(this.f5985a.f5990a);
                this.f5985a.f5999j.postDelayed(this.f5985a.f5990a, (long) this.f5985a.f6000k);
            } else if (message.what == this.f5985a.f6006q && this.f5985a.f5994e.size() != 0) {
                this.f5985a.f5999j.removeCallbacks(this.f5985a.f5990a);
                this.f5985a.f5999j.postDelayed(this.f5985a.f5990a, (long) this.f5985a.f6000k);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.k.2 */
    class C16762 implements OnClickListener {
        final /* synthetic */ C1680k f5986a;

        C16762(C1680k c1680k) {
            this.f5986a = c1680k;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f5986a.f5991b, MobclickAgentConstants.click_hot_news_all);
            this.f5986a.f5991b.startActivity(new Intent(this.f5986a.f5991b, HotNewsActivity.class));
            if (this.f5986a.f5991b instanceof Activity) {
                ((Activity) this.f5986a.f5991b).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.k.3 */
    class C16773 implements Runnable {
        final /* synthetic */ C1680k f5987a;

        C16773(C1680k c1680k) {
            this.f5987a = c1680k;
        }

        public void run() {
            if (this.f5987a.f5991b != null && this.f5987a.f6003n) {
                if (System.currentTimeMillis() - this.f5987a.f6004o > ((long) (this.f5987a.f6000k - 500))) {
                    this.f5987a.f5999j.sendEmptyMessage(this.f5987a.f6005p);
                } else {
                    this.f5987a.f5999j.sendEmptyMessage(this.f5987a.f6006q);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.k.b */
    private class C1679b extends PagerAdapter {
        final /* synthetic */ C1680k f5989a;

        /* renamed from: com.antutu.benchmark.view.k.b.1 */
        class C16781 implements OnClickListener {
            final /* synthetic */ C1679b f5988a;

            C16781(C1679b c1679b) {
                this.f5988a = c1679b;
            }

            public void onClick(View view) {
                this.f5988a.f5989a.f6007r.m5643a((HotNewsBannerModel) this.f5988a.f5989a.f6008s.get(this.f5988a.f5989a.f6001l - 1), this.f5988a.f5989a.f6001l, view);
            }
        }

        private C1679b(C1680k c1680k) {
            this.f5989a = c1680k;
        }

        public View m6570a(ViewGroup viewGroup, int i) {
            ImageView imageView = (ImageView) this.f5989a.f5994e.get(i);
            if (this.f5989a.f6007r != null) {
                imageView.setOnClickListener(new C16781(this));
            }
            viewGroup.addView(imageView);
            return imageView;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f5989a.f5994e.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
            return m6570a(viewGroup, i);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public C1680k(Context context) {
        super(context);
        this.f5994e = new ArrayList();
        this.f6000k = 4000;
        this.f6001l = 0;
        this.f6002m = false;
        this.f6003n = false;
        this.f6004o = 0;
        this.f6005p = 100;
        this.f6006q = Constants.COMMAND_RECEIVE_DATA;
        this.f5990a = new C16773(this);
        m6574a(context, null, 0, 0);
    }

    private void m6573a() {
        int i = 0;
        ImageView imageView = new ImageView(this.f5991b);
        ImageUtil.displayImageNews(((HotNewsBannerModel) this.f6008s.get(this.f6008s.size() - 1)).getPicture(), imageView);
        this.f5994e.add(imageView);
        for (int i2 = 0; i2 < this.f6008s.size(); i2++) {
            ImageView imageView2 = new ImageView(this.f5991b);
            ImageUtil.displayImageNews(((HotNewsBannerModel) this.f6008s.get(i2)).getPicture(), imageView2);
            this.f5994e.add(imageView2);
        }
        imageView = new ImageView(this.f5991b);
        ImageUtil.displayImageNews(((HotNewsBannerModel) this.f6008s.get(0)).getPicture(), imageView);
        this.f5994e.add(imageView);
        this.f5995f = new ImageView[(this.f5994e.size() - 2)];
        while (i < this.f5995f.length) {
            View inflate = LayoutInflater.from(this.f5991b).inflate(C1082R.layout.view_cycle_viewpager_indicator, null);
            this.f5995f[i] = (ImageView) inflate.findViewById(C1082R.id.image_indicator);
            this.f5993d.addView(inflate);
            i++;
        }
    }

    private void m6574a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f5991b = context;
        View.inflate(context, C1082R.layout.item_hot_news, this);
        this.f5992c = (BaseViewPager) findViewById(C1082R.id.viewPager);
        this.f5993d = (LinearLayout) findViewById(C1082R.id.layout_viewpager_indicator);
        this.f5996g = (TextView) findViewById(C1082R.id.tv_title);
        this.f6009t = (LinearLayout) findViewById(C1082R.id.ll_bg);
        this.f5999j = new C16751(this);
        this.f6009t.setOnClickListener(new C16762(this));
    }

    private void setSelectedIndicator(int i) {
        for (ImageView backgroundResource : this.f5995f) {
            backgroundResource.setBackgroundResource(C1082R.drawable.indicators_normal);
        }
        if (this.f5995f.length > i) {
            this.f5995f[i].setBackgroundResource(C1082R.drawable.indicators_pressed);
        }
    }

    public void m6587a(List<HotNewsBannerModel> list, C1431a c1431a) {
        m6588a(list, c1431a, 0);
    }

    public void m6588a(List<HotNewsBannerModel> list, C1431a c1431a, int i) {
        this.f6007r = c1431a;
        this.f6008s = list;
        this.f5994e.clear();
        this.f5992c.clearOnPageChangeListeners();
        this.f5993d.removeAllViews();
        m6573a();
        this.f5998i = new C1679b();
        setSelectedIndicator(0);
        this.f5992c.setOffscreenPageLimit(3);
        this.f5992c.addOnPageChangeListener(this);
        this.f5992c.setAdapter(this.f5998i);
        if (i < 0 || i >= this.f5994e.size()) {
            i = 0;
        }
        this.f5992c.setCurrentItem(i + 1);
    }

    public int getCurrentPostion() {
        return this.f6001l;
    }

    public BaseViewPager getViewPager() {
        return this.f5992c;
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 1) {
            this.f6002m = true;
            return;
        }
        if (i == 0) {
            if (this.f5997h != null) {
                this.f5997h.setScrollable(true);
            }
            this.f6004o = System.currentTimeMillis();
            this.f5992c.setCurrentItem(this.f6001l, false);
        }
        this.f6002m = false;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        int size = this.f5994e.size() - 1;
        this.f6001l = i;
        if (i == 0) {
            this.f6001l = size - 1;
        } else if (i == size) {
            this.f6001l = 1;
        }
        int i2 = this.f6001l - 1;
        this.f5996g.setText(((HotNewsBannerModel) this.f6008s.get(this.f6001l - 1)).getTitle());
        setSelectedIndicator(i2);
    }

    public void setScrollable(boolean z) {
        this.f5992c.setScrollable(z);
    }

    public void setTime(int i) {
        this.f6000k = i;
    }

    public void setWheel(boolean z) {
        this.f6003n = z;
        if (z) {
            this.f5999j.postDelayed(this.f5990a, (long) this.f6000k);
        }
    }
}
