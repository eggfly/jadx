package com.antutu.benchmark.p036a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.p040c.C1360b;
import com.antutu.benchmark.view.C1647a;
import com.antutu.benchmark.view.C1680k;
import com.antutu.utils.BaiduADUtils;
import com.antutu.utils.FacebookADUtil;
import com.antutu.utils.GDTUtils;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.NetUtils;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.widget.WebBrowserActivity;
import com.baidu.mobad.feeds.NativeResponse;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.qq.p035e.ads.nativ.NativeADDataRef;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.a.n */
public class C1148n extends C0510a<C1139b> {
    private SimpleDateFormat f3864a;
    private Context f3865b;
    private List<NewsInfoData> f3866c;
    private LayoutInflater f3867d;
    private C1360b f3868e;
    private String f3869f;
    private C1680k f3870g;
    private C1647a f3871h;
    private boolean f3872i;

    /* renamed from: com.antutu.benchmark.a.n.1 */
    class C11341 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3822a;
        final /* synthetic */ NativeADDataRef f3823b;
        final /* synthetic */ C1148n f3824c;

        C11341(C1148n c1148n, NewsInfoData newsInfoData, NativeADDataRef nativeADDataRef) {
            this.f3824c = c1148n;
            this.f3822a = newsInfoData;
            this.f3823b = nativeADDataRef;
        }

        public void onClick(View view) {
            this.f3824c.f3868e.m5422a(this.f3822a.getUrl());
            this.f3823b.onClicked(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.2 */
    class C11352 implements OnClickListener {
        final /* synthetic */ C1148n f3825a;

        C11352(C1148n c1148n) {
            this.f3825a = c1148n;
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.3 */
    class C11363 implements AdListener {
        final /* synthetic */ NewsInfoData f3826a;
        final /* synthetic */ C1148n f3827b;

        C11363(C1148n c1148n, NewsInfoData newsInfoData) {
            this.f3827b = c1148n;
            this.f3826a = newsInfoData;
        }

        public void onAdClicked(Ad ad) {
            this.f3827b.f3868e.m5422a(this.f3826a.getUrl());
        }

        public void onAdLoaded(Ad ad) {
        }

        public void onError(Ad ad, AdError adError) {
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.4 */
    class C11374 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3828a;
        final /* synthetic */ NativeResponse f3829b;
        final /* synthetic */ C1148n f3830c;

        C11374(C1148n c1148n, NewsInfoData newsInfoData, NativeResponse nativeResponse) {
            this.f3830c = c1148n;
            this.f3828a = newsInfoData;
            this.f3829b = nativeResponse;
        }

        public void onClick(View view) {
            this.f3830c.f3868e.m5422a(this.f3828a.getUrl());
            this.f3829b.handleClick(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.5 */
    class C11385 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3831a;
        final /* synthetic */ C1148n f3832b;

        C11385(C1148n c1148n, NewsInfoData newsInfoData) {
            this.f3832b = c1148n;
            this.f3831a = newsInfoData;
        }

        public void onClick(View view) {
            if (NewsInfoData.EXTEND_TYPE_APK.equals(this.f3831a.getExtend_type()) && NetUtils.getNetWorkType(this.f3832b.f3865b) == 4 && this.f3831a.getUrl() != null && !BuildConfig.FLAVOR.equals(this.f3831a.getUrl())) {
                DownloadInfos downloadInfos = new DownloadInfos();
                downloadInfos.setNeedRename(true);
                downloadInfos.setUrl(this.f3831a.getApk_url());
                downloadInfos.setTitle(BuildConfig.FLAVOR);
                DownloadsService.startDownload(this.f3832b.f3865b, downloadInfos);
            }
            try {
                this.f3832b.m4903a(this.f3831a.getTitle(), this.f3831a.getUrl());
                if (this.f3831a.getStyle().intValue() == 3) {
                    WebBrowserActivity.openWebActivity(this.f3832b.f3865b, this.f3831a.getUrl(), this.f3831a.getTitle(), (String) this.f3831a.getImglist().get(0), this.f3831a.getTitle(), this.f3831a.getShare_url());
                } else {
                    WebBrowserActivity.openWebActivity(this.f3832b.f3865b, this.f3831a.getUrl(), this.f3831a.getTitle(), this.f3831a.getPicture(), this.f3831a.getTitle(), this.f3831a.getShare_url());
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.b */
    public static class C1139b extends C0532u {
        View f3833a;
        View f3834b;

        public C1139b(View view) {
            super(view);
            this.f3833a = view;
            this.f3834b = this.f3833a.findViewById(C1082R.id.ll_bg);
        }

        public View m4900a() {
            return this.f3833a;
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.a */
    static class C1140a extends C1139b {
        public C1140a(View view) {
            super(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.c */
    static class C1141c extends C1139b {
        public C1141c(View view) {
            super(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.d */
    static class C1142d extends C1139b {
        ImageView f3835c;
        TextView f3836d;
        TextView f3837e;
        TextView f3838f;

        public C1142d(View view) {
            super(view);
            this.f3835c = (ImageView) view.findViewById(C1082R.id.iv_img);
            this.f3836d = (TextView) view.findViewById(C1082R.id.tv_app_name);
            this.f3838f = (TextView) view.findViewById(C1082R.id.tv_install_desc);
            this.f3837e = (TextView) view.findViewById(C1082R.id.tv_desc);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.e */
    static class C1143e extends C1139b {
        TextView f3839c;
        ImageView f3840d;
        TextView f3841e;
        TextView f3842f;
        TextView f3843g;

        public C1143e(View view) {
            super(view);
            this.f3839c = (TextView) view.findViewById(C1082R.id.tv_title);
            this.f3841e = (TextView) view.findViewById(C1082R.id.tv_date);
            this.f3840d = (ImageView) view.findViewById(C1082R.id.iv_img);
            this.f3842f = (TextView) view.findViewById(C1082R.id.tv_comment_count);
            this.f3843g = (TextView) view.findViewById(C1082R.id.tv_love);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.f */
    static class C1144f extends C1139b {
        ImageView f3844c;
        TextView f3845d;
        TextView f3846e;
        TextView f3847f;

        public C1144f(View view) {
            super(view);
            this.f3844c = (ImageView) view.findViewById(C1082R.id.iv_img);
            this.f3845d = (TextView) view.findViewById(C1082R.id.tv_app_name);
            this.f3847f = (TextView) view.findViewById(C1082R.id.tv_install_desc);
            this.f3846e = (TextView) view.findViewById(C1082R.id.tv_desc);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.g */
    static class C1145g extends C1139b {
        ImageView f3848c;
        TextView f3849d;
        TextView f3850e;
        TextView f3851f;

        public C1145g(View view) {
            super(view);
            this.f3848c = (ImageView) view.findViewById(C1082R.id.iv_img);
            this.f3849d = (TextView) view.findViewById(C1082R.id.tv_app_name);
            this.f3851f = (TextView) view.findViewById(C1082R.id.tv_install_desc);
            this.f3850e = (TextView) view.findViewById(C1082R.id.tv_desc);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.h */
    static class C1146h extends C1139b {
        TextView f3852c;
        TextView f3853d;
        ImageView f3854e;
        ImageView f3855f;
        ImageView f3856g;
        TextView f3857h;
        TextView f3858i;

        public C1146h(View view) {
            super(view);
            this.f3852c = (TextView) view.findViewById(C1082R.id.tv_title);
            this.f3853d = (TextView) view.findViewById(C1082R.id.tv_date);
            this.f3854e = (ImageView) view.findViewById(C1082R.id.iv_first);
            this.f3855f = (ImageView) view.findViewById(C1082R.id.iv_second);
            this.f3856g = (ImageView) view.findViewById(C1082R.id.iv_third);
            this.f3857h = (TextView) view.findViewById(C1082R.id.tv_comment_count);
            this.f3858i = (TextView) view.findViewById(C1082R.id.tv_love);
        }
    }

    /* renamed from: com.antutu.benchmark.a.n.i */
    static class C1147i extends C1139b {
        TextView f3859c;
        TextView f3860d;
        ImageView f3861e;
        TextView f3862f;
        TextView f3863g;

        public C1147i(View view) {
            super(view);
            this.f3859c = (TextView) view.findViewById(C1082R.id.tv_title);
            this.f3860d = (TextView) view.findViewById(C1082R.id.tv_date);
            this.f3861e = (ImageView) view.findViewById(C1082R.id.iv_img);
            this.f3862f = (TextView) view.findViewById(C1082R.id.tv_comment_count);
            this.f3863g = (TextView) view.findViewById(C1082R.id.tv_love);
        }
    }

    public C1148n(Context context, List<NewsInfoData> list, String str, boolean z) {
        this.f3864a = new SimpleDateFormat("MM-dd");
        this.f3872i = false;
        this.f3865b = context;
        this.f3868e = new C1360b(context);
        this.f3867d = (LayoutInflater) this.f3865b.getSystemService("layout_inflater");
        this.f3866c = list;
        this.f3869f = str;
        if (z) {
            this.f3870g = new C1680k(this.f3865b);
            this.f3870g.setTime(4000);
        }
        this.f3871h = new C1647a(this.f3865b);
        this.f3872i = z;
    }

    private void m4903a(String str, String str2) {
        if (this.f3865b.getString(C1082R.string.home).equals(this.f3869f)) {
            Map hashMap = new HashMap();
            hashMap.put(this.f3865b.getString(C1082R.string.article_title), str);
            hashMap.put(this.f3865b.getString(C1082R.string.article_url), str2);
            MobclickAgent.onEvent(this.f3865b, MobclickAgentConstants.click_home_hot_news, hashMap);
            return;
        }
        hashMap = new HashMap();
        hashMap.put(this.f3865b.getString(C1082R.string.article_title), str);
        hashMap.put(this.f3865b.getString(C1082R.string.article_url), str2);
        hashMap.put(this.f3865b.getString(C1082R.string.article_from_page), this.f3865b.getString(C1082R.string.info));
        MobclickAgent.onEvent(this.f3865b, MobclickAgentConstants.click_news_detail, hashMap);
    }

    public C1139b m4905a(ViewGroup viewGroup, int i) {
        return 1 == i ? new C1147i(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_smallimage, viewGroup, false)) : 2 == i ? new C1146h(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_multimage, viewGroup, false)) : 3 == i ? new C1143e(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_bigimage, viewGroup, false)) : 4 == i ? new C1145g(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_gdt, viewGroup, false)) : 6 == i ? new C1144f(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_facebook, viewGroup, false)) : 5 == i ? new C1142d(LayoutInflater.from(this.f3865b).inflate(C1082R.layout.item_news_baidu_ad, viewGroup, false)) : 7 == i ? new C1141c(this.f3870g) : 8 == i ? new C1140a(this.f3871h) : new C1139b(new View(this.f3865b));
    }

    public C1680k m4906a() {
        return this.f3870g;
    }

    public void m4907a(C1139b c1139b, int i) {
        if (this.f3872i) {
            i--;
        }
        NewsInfoData newsInfoData;
        if (c1139b instanceof C1147i) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            c1139b = (C1147i) c1139b;
            Date date = new Date(newsInfoData.getAddtime().longValue() * 1000);
            c1139b.f3859c.setText(newsInfoData.getTitle());
            c1139b.f3860d.setText(this.f3864a.format(date));
            c1139b.f3862f.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
            c1139b.f3863g.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
            ImageUtil.displayImageNews(newsInfoData.getPicture(), c1139b.f3861e);
            m4908a(c1139b, newsInfoData);
        } else if (c1139b instanceof C1143e) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            c1139b = (C1143e) c1139b;
            c1139b.f3839c.setText(newsInfoData.getTitle());
            c1139b.f3841e.setText(this.f3864a.format(new Date(newsInfoData.getAddtime().longValue() * 1000)));
            c1139b.f3842f.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
            c1139b.f3843g.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
            ImageUtil.displayImageNews(newsInfoData.getPicture(), c1139b.f3840d);
            m4908a(c1139b, newsInfoData);
        } else if (c1139b instanceof C1146h) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            c1139b = (C1146h) c1139b;
            c1139b.f3853d.setText(this.f3864a.format(new Date(newsInfoData.getAddtime().longValue() * 1000)));
            c1139b.f3852c.setText(newsInfoData.getTitle());
            c1139b.f3857h.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
            c1139b.f3858i.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
            List imglist = newsInfoData.getImglist();
            if (imglist != null && imglist.size() >= 3) {
                ImageUtil.displayImageNews((String) imglist.get(0), c1139b.f3854e);
                ImageUtil.displayImageNews((String) imglist.get(1), c1139b.f3855f);
                ImageUtil.displayImageNews((String) imglist.get(2), c1139b.f3856g);
            }
            m4908a(c1139b, newsInfoData);
        } else if (c1139b instanceof C1145g) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            C1145g c1145g = (C1145g) c1139b;
            r1 = newsInfoData.getGdtposition();
            if (r1 == null || r1.intValue() == -1) {
                r1 = Integer.valueOf(GDTUtils.getAdsPosition());
                newsInfoData.setGdtposition(r1);
            }
            NativeADDataRef ads = GDTUtils.getAds(r1.intValue());
            if (ads != null) {
                c1145g.f3850e.setText(ads.getDesc());
                c1145g.f3849d.setText(ads.getTitle());
                c1145g.f3851f.setText(GDTUtils.getAppStatus(this.f3865b, ads));
                ImageUtil.displayImageNews(ads.getIconUrl(), c1145g.f3848c);
                ads.onExposured(c1145g.a);
                c1145g.b.setOnClickListener(new C11341(this, newsInfoData, ads));
            }
        } else if (c1139b instanceof C1144f) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            C1144f c1144f = (C1144f) c1139b;
            r1 = newsInfoData.getFacebookposition();
            if (r1 == null || r1.intValue() == -1) {
                r1 = Integer.valueOf(FacebookADUtil.getAdsPosition());
                newsInfoData.setFacebookposition(r1);
            }
            NativeAd ads2 = FacebookADUtil.getAds(r1);
            if (ads2 != null) {
                c1144f.f3846e.setText(ads2.getAdBody());
                c1144f.f3845d.setText(ads2.getAdTitle());
                c1144f.f3847f.setText(ads2.getAdCallToAction());
                ImageUtil.displayImageNews(ads2.getAdIcon().getUrl(), c1144f.f3844c);
                c1144f.b.setOnClickListener(new C11352(this));
                ads2.registerViewForInteraction(c1144f.a);
                ads2.setAdListener(new C11363(this, newsInfoData));
            }
        } else if (c1139b instanceof C1142d) {
            newsInfoData = (NewsInfoData) this.f3866c.get(i);
            C1142d c1142d = (C1142d) c1139b;
            r1 = newsInfoData.getBaiduadposition();
            if (r1 == null || r1.intValue() == -1) {
                r1 = Integer.valueOf(BaiduADUtils.getAdsPosition());
                newsInfoData.setBaiduadposition(r1);
            }
            NativeResponse ads3 = BaiduADUtils.getAds(r1.intValue());
            if (ads3 != null) {
                c1142d.f3837e.setText(ads3.getDesc());
                c1142d.f3836d.setText(ads3.getTitle());
                c1142d.f3838f.setText(BaiduADUtils.getAppStatus(this.f3865b, ads3));
                ImageUtil.displayImageNews(ads3.getIconUrl(), c1142d.f3835c);
                ads3.recordImpression(c1142d.a);
                c1142d.b.setOnClickListener(new C11374(this, newsInfoData, ads3));
            }
        } else if (c1139b instanceof C1140a) {
            this.f3871h.m6495a(((NewsInfoData) this.f3866c.get(i)).getUrl());
        }
    }

    public void m4908a(C1139b c1139b, NewsInfoData newsInfoData) {
        c1139b.f3834b.setOnClickListener(new C11385(this, newsInfoData));
    }

    public void m4909a(List<NewsInfoData> list) {
        Iterator it;
        if (!GDTUtils.hasAds()) {
            it = list.iterator();
            while (it.hasNext()) {
                if (NewsInfoData.EXTEND_TYPE_GDT.equals(((NewsInfoData) it.next()).getExtend_type())) {
                    it.remove();
                }
            }
        }
        if (!BaiduADUtils.hasAds()) {
            it = list.iterator();
            while (it.hasNext()) {
                if (NewsInfoData.EXTEND_TYPE_BAIDU_AD.equals(((NewsInfoData) it.next()).getExtend_type())) {
                    it.remove();
                }
            }
        }
        if (!FacebookADUtil.hasAds()) {
            it = list.iterator();
            while (it.hasNext()) {
                if (NewsInfoData.EXTEND_TYPE_FACEBOOK.equals(((NewsInfoData) it.next()).getExtend_type())) {
                    it.remove();
                }
            }
        }
        this.f3866c = list;
        notifyDataSetChanged();
    }

    public void m4910a(boolean z) {
        this.f3872i = z;
    }

    public void m4911b(List<NewsInfoData> list) {
        this.f3866c.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        int size = this.f3866c.size();
        return this.f3872i ? size + 1 : size;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        if (i == 0 && this.f3872i) {
            return 7;
        }
        if (this.f3872i) {
            i--;
        }
        try {
            NewsInfoData newsInfoData = (NewsInfoData) this.f3866c.get(i);
            return NewsInfoData.EXTEND_TYPE_GDT.equals(newsInfoData.getExtend_type()) ? 4 : NewsInfoData.EXTEND_TYPE_BAIDU_AD.equals(newsInfoData.getExtend_type()) ? 5 : NewsInfoData.EXTEND_TYPE_FACEBOOK.equals(newsInfoData.getExtend_type()) ? 6 : NewsInfoData.EXTEND_TYPE_58_URL.equals(newsInfoData.getExtend_type()) ? 8 : 1 == newsInfoData.getStyle().intValue() ? 3 : 3 == newsInfoData.getStyle().intValue() ? 2 : 2 == newsInfoData.getStyle().intValue() ? 1 : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public /* synthetic */ void onBindViewHolder(C0532u c0532u, int i) {
        m4907a((C1139b) c0532u, i);
    }

    public /* synthetic */ C0532u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m4905a(viewGroup, i);
    }
}
