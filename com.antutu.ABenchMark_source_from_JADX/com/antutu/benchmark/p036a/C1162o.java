package com.antutu.benchmark.p036a;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.p040c.C1360b;
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
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.a.o */
public class C1162o extends BaseAdapter {
    private SimpleDateFormat f3932a;
    private Context f3933b;
    private List<NewsInfoData> f3934c;
    private LayoutInflater f3935d;
    private C1360b f3936e;
    private String f3937f;

    /* renamed from: com.antutu.benchmark.a.o.1 */
    class C11491 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3873a;
        final /* synthetic */ String f3874b;
        final /* synthetic */ String f3875c;
        final /* synthetic */ int f3876d;
        final /* synthetic */ C1162o f3877e;

        C11491(C1162o c1162o, NewsInfoData newsInfoData, String str, String str2, int i) {
            this.f3877e = c1162o;
            this.f3873a = newsInfoData;
            this.f3874b = str;
            this.f3875c = str2;
            this.f3876d = i;
        }

        public void onClick(View view) {
            this.f3877e.m4917a(this.f3873a, this.f3874b, this.f3875c, this.f3876d);
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.2 */
    class C11502 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3878a;
        final /* synthetic */ String f3879b;
        final /* synthetic */ String f3880c;
        final /* synthetic */ int f3881d;
        final /* synthetic */ C1162o f3882e;

        C11502(C1162o c1162o, NewsInfoData newsInfoData, String str, String str2, int i) {
            this.f3882e = c1162o;
            this.f3878a = newsInfoData;
            this.f3879b = str;
            this.f3880c = str2;
            this.f3881d = i;
        }

        public void onClick(View view) {
            this.f3882e.m4917a(this.f3878a, this.f3879b, this.f3880c, this.f3881d);
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.3 */
    class C11513 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3883a;
        final /* synthetic */ String f3884b;
        final /* synthetic */ String f3885c;
        final /* synthetic */ int f3886d;
        final /* synthetic */ C1162o f3887e;

        C11513(C1162o c1162o, NewsInfoData newsInfoData, String str, String str2, int i) {
            this.f3887e = c1162o;
            this.f3883a = newsInfoData;
            this.f3884b = str;
            this.f3885c = str2;
            this.f3886d = i;
        }

        public void onClick(View view) {
            this.f3887e.m4917a(this.f3883a, this.f3884b, this.f3885c, this.f3886d);
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.4 */
    class C11524 implements OnClickListener {
        final /* synthetic */ C1162o f3888a;

        C11524(C1162o c1162o) {
            this.f3888a = c1162o;
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.5 */
    class C11535 implements AdListener {
        final /* synthetic */ NewsInfoData f3889a;
        final /* synthetic */ C1162o f3890b;

        C11535(C1162o c1162o, NewsInfoData newsInfoData) {
            this.f3890b = c1162o;
            this.f3889a = newsInfoData;
        }

        public void onAdClicked(Ad ad) {
            this.f3890b.f3936e.m5422a(this.f3889a.getUrl());
        }

        public void onAdLoaded(Ad ad) {
        }

        public void onError(Ad ad, AdError adError) {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.6 */
    class C11546 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3891a;
        final /* synthetic */ NativeADDataRef f3892b;
        final /* synthetic */ C1162o f3893c;

        C11546(C1162o c1162o, NewsInfoData newsInfoData, NativeADDataRef nativeADDataRef) {
            this.f3893c = c1162o;
            this.f3891a = newsInfoData;
            this.f3892b = nativeADDataRef;
        }

        public void onClick(View view) {
            this.f3893c.f3936e.m5422a(this.f3891a.getUrl());
            this.f3892b.onClicked(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.7 */
    class C11557 implements OnClickListener {
        final /* synthetic */ NewsInfoData f3894a;
        final /* synthetic */ NativeResponse f3895b;
        final /* synthetic */ C1162o f3896c;

        C11557(C1162o c1162o, NewsInfoData newsInfoData, NativeResponse nativeResponse) {
            this.f3896c = c1162o;
            this.f3894a = newsInfoData;
            this.f3895b = nativeResponse;
        }

        public void onClick(View view) {
            this.f3896c.f3936e.m5422a(this.f3894a.getUrl());
            this.f3895b.handleClick(view);
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.a */
    static class C1156a {
        ImageView f3897a;
        TextView f3898b;
        TextView f3899c;
        TextView f3900d;
        View f3901e;

        C1156a() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.b */
    static class C1157b {
        TextView f3902a;
        ImageView f3903b;
        TextView f3904c;
        TextView f3905d;
        TextView f3906e;
        View f3907f;

        C1157b() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.c */
    static class C1158c {
        ImageView f3908a;
        TextView f3909b;
        TextView f3910c;
        TextView f3911d;
        View f3912e;

        C1158c() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.d */
    static class C1159d {
        ImageView f3913a;
        TextView f3914b;
        TextView f3915c;
        TextView f3916d;
        View f3917e;

        C1159d() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.e */
    static class C1160e {
        TextView f3918a;
        TextView f3919b;
        ImageView f3920c;
        ImageView f3921d;
        ImageView f3922e;
        TextView f3923f;
        TextView f3924g;
        View f3925h;

        C1160e() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.o.f */
    static class C1161f {
        TextView f3926a;
        TextView f3927b;
        ImageView f3928c;
        TextView f3929d;
        TextView f3930e;
        View f3931f;

        C1161f() {
        }
    }

    public C1162o(Context context, List<NewsInfoData> list, String str) {
        this.f3932a = new SimpleDateFormat("MM-dd");
        this.f3933b = context;
        this.f3936e = new C1360b(context);
        this.f3935d = (LayoutInflater) this.f3933b.getSystemService("layout_inflater");
        this.f3934c = list;
        this.f3937f = str;
    }

    private View m4912a(View view, int i, NewsInfoData newsInfoData) {
        C1157b e;
        ViewGroup viewGroup;
        C1160e c1160e;
        C1160e c1160e2;
        View view2;
        View view3;
        String url = newsInfoData.getUrl();
        String title = newsInfoData.getTitle();
        Object obj;
        if (view == null) {
            ViewGroup viewGroup2;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    view = this.f3935d.inflate(C1082R.layout.item_home_news_bigimage, null);
                    e = m4924e(view);
                    view.setTag(e);
                    Object obj2 = e;
                    viewGroup = null;
                    c1160e = null;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    view = this.f3935d.inflate(C1082R.layout.item_home_news_smallimage, null);
                    C1161f d = m4923d(view);
                    view.setTag(d);
                    viewGroup2 = null;
                    obj = d;
                    c1160e = null;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    view = this.f3935d.inflate(C1082R.layout.item_news_multimage, null);
                    c1160e = m4925f(view);
                    view.setTag(c1160e);
                    viewGroup2 = null;
                    viewGroup = null;
                    break;
                default:
                    c1160e = null;
                    viewGroup2 = null;
                    viewGroup = null;
                    break;
            }
            c1160e2 = c1160e;
            e = viewGroup2;
            view2 = view;
        } else {
            Object tag = view.getTag();
            Object obj3;
            if (tag instanceof C1157b) {
                e = (C1157b) tag;
                obj3 = null;
                viewGroup = null;
                view2 = view;
            } else if (tag instanceof C1161f) {
                obj3 = null;
                obj = (C1161f) tag;
                view2 = view;
                e = null;
            } else if (tag instanceof C1160e) {
                c1160e2 = (C1160e) tag;
                viewGroup = null;
                view2 = view;
                e = null;
            } else {
                obj3 = null;
                e = null;
                viewGroup = null;
                view2 = view;
            }
        }
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (e instanceof C1157b) {
                    view3 = view2;
                } else {
                    View inflate = this.f3935d.inflate(C1082R.layout.item_home_news_bigimage, null);
                    e = m4924e(inflate);
                    inflate.setTag(e);
                    view3 = inflate;
                }
                e.f3902a.setText(newsInfoData.getTitle());
                e.f3904c.setText(this.f3932a.format(new Date(newsInfoData.getAddtime().longValue() * 1000)));
                e.f3905d.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
                e.f3906e.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
                ImageUtil.displayImageNews(newsInfoData.getPicture(), e.f3903b);
                e.f3907f.setOnClickListener(new C11491(this, newsInfoData, title, url, i));
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (viewGroup instanceof C1161f) {
                    tag = viewGroup;
                    view3 = view2;
                } else {
                    view2 = this.f3935d.inflate(C1082R.layout.item_home_news_smallimage, null);
                    d = m4923d(view2);
                    view2.setTag(d);
                    view3 = view2;
                }
                Date date = new Date(newsInfoData.getAddtime().longValue() * 1000);
                d.f3926a.setText(newsInfoData.getTitle());
                d.f3927b.setText(this.f3932a.format(date));
                d.f3929d.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
                d.f3930e.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
                ImageUtil.displayImageNews(newsInfoData.getPicture(), d.f3928c);
                d.f3931f.setOnClickListener(new C11502(this, newsInfoData, title, url, i));
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                C1160e c1160e3;
                if (c1160e2 instanceof C1160e) {
                    c1160e3 = c1160e2;
                    view3 = view2;
                } else {
                    view2 = this.f3935d.inflate(C1082R.layout.item_news_multimage, null);
                    c1160e = m4925f(view2);
                    view2.setTag(c1160e);
                    c1160e3 = c1160e;
                    view3 = view2;
                }
                c1160e3.f3919b.setText(this.f3932a.format(new Date(newsInfoData.getAddtime().longValue() * 1000)));
                c1160e3.f3918a.setText(newsInfoData.getTitle());
                c1160e3.f3923f.setText(newsInfoData.getComment() + BuildConfig.FLAVOR);
                c1160e3.f3924g.setText(newsInfoData.getZan() + BuildConfig.FLAVOR);
                List imglist = newsInfoData.getImglist();
                if (imglist != null && imglist.size() >= 3) {
                    ImageUtil.displayImageNews((String) imglist.get(0), c1160e3.f3920c);
                    ImageUtil.displayImageNews((String) imglist.get(1), c1160e3.f3921d);
                    ImageUtil.displayImageNews((String) imglist.get(2), c1160e3.f3922e);
                }
                c1160e3.f3925h.setOnClickListener(new C11513(this, newsInfoData, title, url, i));
                break;
            default:
                view3 = view2;
                break;
        }
        if (view3 == null) {
            Log.d(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        }
        return view3;
    }

    private View m4913a(View view, NewsInfoData newsInfoData) {
        C1158c a;
        if (view == null || !(view.getTag() instanceof C1158c)) {
            view = this.f3935d.inflate(C1082R.layout.item_news_facebook, null);
            a = m4914a(view);
            view.setTag(a);
        } else {
            a = (C1158c) view.getTag();
        }
        Integer facebookposition = newsInfoData.getFacebookposition();
        if (facebookposition == null || facebookposition.intValue() == -1) {
            facebookposition = Integer.valueOf(FacebookADUtil.getAdsPosition());
            newsInfoData.setFacebookposition(facebookposition);
        }
        NativeAd ads = FacebookADUtil.getAds(facebookposition);
        if (ads == null) {
            return null;
        }
        a.f3910c.setText(ads.getAdBody());
        a.f3909b.setText(ads.getAdTitle());
        a.f3911d.setText(ads.getAdCallToAction());
        ImageUtil.displayImageNews(ads.getAdIcon().getUrl(), a.f3908a);
        a.f3912e.setOnClickListener(new C11524(this));
        ads.registerViewForInteraction(view);
        ads.setAdListener(new C11535(this, newsInfoData));
        return view;
    }

    private C1158c m4914a(View view) {
        C1158c c1158c = new C1158c();
        c1158c.f3908a = (ImageView) view.findViewById(C1082R.id.iv_img);
        c1158c.f3909b = (TextView) view.findViewById(C1082R.id.tv_app_name);
        c1158c.f3911d = (TextView) view.findViewById(C1082R.id.tv_install_desc);
        c1158c.f3910c = (TextView) view.findViewById(C1082R.id.tv_desc);
        c1158c.f3912e = view.findViewById(C1082R.id.ll_bg);
        return c1158c;
    }

    private void m4917a(NewsInfoData newsInfoData, String str, String str2, int i) {
        if (NewsInfoData.EXTEND_TYPE_APK.equals(newsInfoData.getExtend_type()) && NetUtils.getNetWorkType(this.f3933b) == 4 && newsInfoData.getUrl() != null && !BuildConfig.FLAVOR.equals(newsInfoData.getUrl())) {
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setNeedRename(true);
            downloadInfos.setUrl(newsInfoData.getApk_url());
            downloadInfos.setTitle(BuildConfig.FLAVOR);
            DownloadsService.startDownload(this.f3933b, downloadInfos);
        }
        try {
            m4918a(str, str2);
            if (i == 3) {
                WebBrowserActivity.openWebActivity(this.f3933b, str2, str, (String) newsInfoData.getImglist().get(0), newsInfoData.getTitle(), newsInfoData.getShare_url());
                return;
            }
            WebBrowserActivity.openWebActivity(this.f3933b, str2, str, newsInfoData.getPicture(), newsInfoData.getTitle(), newsInfoData.getShare_url());
        } catch (Exception e) {
        }
    }

    private void m4918a(String str, String str2) {
        if (this.f3933b.getString(C1082R.string.home).equals(this.f3937f)) {
            Map hashMap = new HashMap();
            hashMap.put(this.f3933b.getString(C1082R.string.article_title), str);
            hashMap.put(this.f3933b.getString(C1082R.string.article_url), str2);
            MobclickAgent.onEvent(this.f3933b, MobclickAgentConstants.click_home_hot_news, hashMap);
            return;
        }
        hashMap = new HashMap();
        hashMap.put(this.f3933b.getString(C1082R.string.article_title), str);
        hashMap.put(this.f3933b.getString(C1082R.string.article_url), str2);
        hashMap.put(this.f3933b.getString(C1082R.string.article_from_page), this.f3933b.getString(C1082R.string.info));
        MobclickAgent.onEvent(this.f3933b, MobclickAgentConstants.click_news_detail, hashMap);
    }

    private View m4919b(View view, NewsInfoData newsInfoData) {
        C1159d b;
        if (view == null || !(view.getTag() instanceof C1159d)) {
            view = this.f3935d.inflate(C1082R.layout.item_news_gdt, null);
            b = m4920b(view);
            view.setTag(b);
        } else {
            b = (C1159d) view.getTag();
        }
        Integer gdtposition = newsInfoData.getGdtposition();
        if (gdtposition == null || gdtposition.intValue() == -1) {
            gdtposition = Integer.valueOf(GDTUtils.getAdsPosition());
            newsInfoData.setGdtposition(gdtposition);
        }
        NativeADDataRef ads = GDTUtils.getAds(gdtposition.intValue());
        if (ads == null) {
            return null;
        }
        b.f3915c.setText(ads.getDesc());
        b.f3914b.setText(ads.getTitle());
        b.f3916d.setText(GDTUtils.getAppStatus(this.f3933b, ads));
        ImageUtil.displayImageNews(ads.getIconUrl(), b.f3913a);
        ads.onExposured(view);
        b.f3917e.setOnClickListener(new C11546(this, newsInfoData, ads));
        return view;
    }

    private C1159d m4920b(View view) {
        C1159d c1159d = new C1159d();
        c1159d.f3913a = (ImageView) view.findViewById(C1082R.id.iv_img);
        c1159d.f3914b = (TextView) view.findViewById(C1082R.id.tv_app_name);
        c1159d.f3916d = (TextView) view.findViewById(C1082R.id.tv_install_desc);
        c1159d.f3915c = (TextView) view.findViewById(C1082R.id.tv_desc);
        c1159d.f3917e = view.findViewById(C1082R.id.ll_bg);
        return c1159d;
    }

    private View m4921c(View view, NewsInfoData newsInfoData) {
        C1156a c;
        if (view == null || !(view.getTag() instanceof C1159d)) {
            view = this.f3935d.inflate(C1082R.layout.item_news_gdt, null);
            c = m4922c(view);
            view.setTag(c);
        } else {
            c = (C1156a) view.getTag();
        }
        Integer baiduadposition = newsInfoData.getBaiduadposition();
        if (baiduadposition == null || baiduadposition.intValue() == -1) {
            baiduadposition = Integer.valueOf(BaiduADUtils.getAdsPosition());
            newsInfoData.setBaiduadposition(baiduadposition);
        }
        NativeResponse ads = BaiduADUtils.getAds(baiduadposition.intValue());
        if (ads == null) {
            return null;
        }
        c.f3899c.setText(ads.getDesc());
        c.f3898b.setText(ads.getTitle());
        c.f3900d.setText(BaiduADUtils.getAppStatus(this.f3933b, ads));
        ImageUtil.displayImageNews(ads.getIconUrl(), c.f3897a);
        ads.recordImpression(view);
        c.f3901e.setOnClickListener(new C11557(this, newsInfoData, ads));
        return view;
    }

    private C1156a m4922c(View view) {
        C1156a c1156a = new C1156a();
        c1156a.f3897a = (ImageView) view.findViewById(C1082R.id.iv_img);
        c1156a.f3898b = (TextView) view.findViewById(C1082R.id.tv_app_name);
        c1156a.f3900d = (TextView) view.findViewById(C1082R.id.tv_install_desc);
        c1156a.f3899c = (TextView) view.findViewById(C1082R.id.tv_desc);
        c1156a.f3901e = view.findViewById(C1082R.id.ll_bg);
        return c1156a;
    }

    private C1161f m4923d(View view) {
        C1161f c1161f = new C1161f();
        c1161f.f3926a = (TextView) view.findViewById(C1082R.id.tv_title);
        c1161f.f3927b = (TextView) view.findViewById(C1082R.id.tv_date);
        c1161f.f3928c = (ImageView) view.findViewById(C1082R.id.iv_img);
        c1161f.f3929d = (TextView) view.findViewById(C1082R.id.tv_comment_count);
        c1161f.f3930e = (TextView) view.findViewById(C1082R.id.tv_love);
        c1161f.f3931f = view.findViewById(C1082R.id.ll_bg);
        return c1161f;
    }

    private C1157b m4924e(View view) {
        C1157b c1157b = new C1157b();
        c1157b.f3902a = (TextView) view.findViewById(C1082R.id.tv_title);
        c1157b.f3904c = (TextView) view.findViewById(C1082R.id.tv_date);
        c1157b.f3903b = (ImageView) view.findViewById(C1082R.id.iv_img);
        c1157b.f3905d = (TextView) view.findViewById(C1082R.id.tv_comment_count);
        c1157b.f3906e = (TextView) view.findViewById(C1082R.id.tv_love);
        c1157b.f3907f = view.findViewById(C1082R.id.ll_bg);
        return c1157b;
    }

    private C1160e m4925f(View view) {
        C1160e c1160e = new C1160e();
        c1160e.f3918a = (TextView) view.findViewById(C1082R.id.tv_title);
        c1160e.f3919b = (TextView) view.findViewById(C1082R.id.tv_date);
        c1160e.f3920c = (ImageView) view.findViewById(C1082R.id.iv_first);
        c1160e.f3921d = (ImageView) view.findViewById(C1082R.id.iv_second);
        c1160e.f3922e = (ImageView) view.findViewById(C1082R.id.iv_third);
        c1160e.f3923f = (TextView) view.findViewById(C1082R.id.tv_comment_count);
        c1160e.f3924g = (TextView) view.findViewById(C1082R.id.tv_love);
        c1160e.f3925h = view.findViewById(C1082R.id.ll_bg);
        return c1160e;
    }

    public int getCount() {
        return this.f3934c.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        Integer style = ((NewsInfoData) this.f3934c.get(i)).getStyle();
        return style == null ? -1 : style.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        NewsInfoData newsInfoData = (NewsInfoData) this.f3934c.get(i);
        try {
            View b = NewsInfoData.EXTEND_TYPE_GDT.equals(newsInfoData.getExtend_type()) ? m4919b(view, newsInfoData) : NewsInfoData.EXTEND_TYPE_FACEBOOK.equals(newsInfoData.getExtend_type()) ? m4913a(view, newsInfoData) : NewsInfoData.EXTEND_TYPE_BAIDU_AD.equals(newsInfoData.getExtend_type()) ? m4921c(view, newsInfoData) : m4912a(view, getItemViewType(i), newsInfoData);
            return b == null ? new View(this.f3933b) : b;
        } catch (Exception e) {
            e.printStackTrace();
            return new View(this.f3933b);
        }
    }

    public int getViewTypeCount() {
        return 1;
    }
}
