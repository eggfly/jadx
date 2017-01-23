package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.activity.WebViewActivity;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.modelreflact.TestResultAdData;
import com.antutu.benchmark.modelreflact.TestResultHuiShouBao;
import com.antutu.benchmark.modelreflact.TestResultModel;
import com.antutu.benchmark.p040c.C1360b;
import com.antutu.benchmark.view.C1691o;
import com.antutu.benchmark.view.MaterialRippleLayout;
import com.antutu.redacc.C1692R;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.v */
public class C1193v extends BaseAdapter {
    private Activity f4014a;
    private List<TestResultModel> f4015b;
    private LayoutInflater f4016c;
    private C1360b f4017d;

    /* renamed from: com.antutu.benchmark.a.v.1 */
    class C11841 implements OnClickListener {
        final /* synthetic */ TestResultAdData f3990a;
        final /* synthetic */ C1193v f3991b;

        C11841(C1193v c1193v, TestResultAdData testResultAdData) {
            this.f3991b = c1193v;
            this.f3990a = testResultAdData;
        }

        public void onClick(View view) {
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setNeedRename(true);
            downloadInfos.setUrl(this.f3990a.getApk_url());
            downloadInfos.setTitle(BuildConfig.FLAVOR);
            DownloadsService.startDownload(ABenchmarkApplication.getContext(), downloadInfos);
            this.f3991b.f4017d.m5422a(this.f3990a.getUrl());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.2 */
    class C11852 implements OnClickListener {
        final /* synthetic */ TestResultAdData f3992a;
        final /* synthetic */ C1193v f3993b;

        C11852(C1193v c1193v, TestResultAdData testResultAdData) {
            this.f3993b = c1193v;
            this.f3992a = testResultAdData;
        }

        public void onClick(View view) {
            WebViewActivity.m5314a(this.f3993b.f4014a, this.f3992a.getApk_url());
            this.f3993b.f4017d.m5422a(this.f3992a.getUrl());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.3 */
    class C11863 implements OnClickListener {
        final /* synthetic */ TestResultAdData f3994a;
        final /* synthetic */ C1193v f3995b;

        C11863(C1193v c1193v, TestResultAdData testResultAdData) {
            this.f3995b = c1193v;
            this.f3994a = testResultAdData;
        }

        public void onClick(View view) {
            Methods.openApp(ABenchmarkApplication.getContext(), this.f3994a.getPackage_name());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.4 */
    class C11874 implements OnClickListener {
        final /* synthetic */ TestResultAdData f3996a;
        final /* synthetic */ C1193v f3997b;

        C11874(C1193v c1193v, TestResultAdData testResultAdData) {
            this.f3997b = c1193v;
            this.f3996a = testResultAdData;
        }

        public void onClick(View view) {
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setNeedRename(true);
            downloadInfos.setUrl(this.f3996a.getApk_url());
            downloadInfos.setTitle(BuildConfig.FLAVOR);
            DownloadsService.startDownload(ABenchmarkApplication.getContext(), downloadInfos);
            this.f3997b.f4017d.m5422a(this.f3996a.getUrl());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.5 */
    class C11885 implements OnClickListener {
        final /* synthetic */ TestResultAdData f3998a;
        final /* synthetic */ C1193v f3999b;

        C11885(C1193v c1193v, TestResultAdData testResultAdData) {
            this.f3999b = c1193v;
            this.f3998a = testResultAdData;
        }

        public void onClick(View view) {
            WebViewActivity.m5314a(this.f3999b.f4014a, this.f3998a.getApk_url());
            this.f3999b.f4017d.m5422a(this.f3998a.getUrl());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.6 */
    class C11896 implements OnClickListener {
        final /* synthetic */ TestResultHuiShouBao f4000a;
        final /* synthetic */ C1193v f4001b;

        C11896(C1193v c1193v, TestResultHuiShouBao testResultHuiShouBao) {
            this.f4001b = c1193v;
            this.f4000a = testResultHuiShouBao;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f4001b.f4014a, MobclickAgentConstants.click_test_result_recycle);
            WebViewActivity.m5314a(this.f4001b.f4014a, this.f4000a.getUrl());
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.a */
    static class C1190a {
        MaterialRippleLayout f4002a;
        ImageView f4003b;
        ImageView f4004c;
        TextView f4005d;
        TextView f4006e;

        C1190a() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.b */
    static class C1191b {
        MaterialRippleLayout f4007a;
        ImageView f4008b;
        TextView f4009c;

        C1191b() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.v.c */
    static class C1192c {
        MaterialRippleLayout f4010a;
        ImageView f4011b;
        TextView f4012c;
        TextView f4013d;

        C1192c() {
        }
    }

    public C1193v(Activity activity, List<TestResultModel> list) {
        this.f4014a = activity;
        this.f4015b = list;
        this.f4016c = LayoutInflater.from(activity);
        this.f4017d = new C1360b(activity);
    }

    public void m4955a(List<TestResultModel> list) {
        if (list != null) {
            this.f4015b.clear();
            this.f4015b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        return this.f4015b.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        TestResultModel testResultModel = (TestResultModel) this.f4015b.get(i);
        if (!TestResultModel.TYPE_AD.equals(testResultModel.getType())) {
            return TestResultModel.TYPE_NEWSLIST.equals(testResultModel.getType()) ? 2 : TestResultModel.TYPE_HUISHOUBAO.equals(testResultModel.getType()) ? 3 : 0;
        } else {
            TestResultAdData testResultAdData = (TestResultAdData) testResultModel.getData();
            return testResultAdData.getStyle() == 2 ? 0 : testResultAdData.getStyle() == 1 ? 1 : 1;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TestResultModel testResultModel = (TestResultModel) this.f4015b.get(i);
        int itemViewType = getItemViewType(i);
        TestResultAdData testResultAdData;
        if (itemViewType == 1) {
            C1190a c1190a;
            testResultAdData = (TestResultAdData) testResultModel.getData();
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C1190a)) {
                view = this.f4016c.inflate(C1082R.layout.item_test_result_ad_big, viewGroup, false);
                C1190a c1190a2 = new C1190a();
                c1190a2.f4004c = (ImageView) view.findViewById(C1082R.id.img);
                c1190a2.f4005d = (TextView) view.findViewById(C1082R.id.tv_desc);
                c1190a2.f4006e = (TextView) view.findViewById(C1692R.id.btn);
                c1190a2.f4003b = (ImageView) view.findViewById(C1082R.id.img_center);
                c1190a2.f4002a = (MaterialRippleLayout) view.findViewById(C1082R.id.ll_bg);
                view.setTag(c1190a2);
                c1190a = c1190a2;
            } else {
                c1190a = (C1190a) view.getTag();
            }
            ImageUtil.displayImageNews(testResultAdData.getPicture(), c1190a.f4003b);
            c1190a.f4005d.setText(testResultAdData.getTitle());
            c1190a.f4006e.setText(testResultAdData.getBtn_text());
            ImageUtil.displayImageNews(testResultAdData.getApp_icon(), c1190a.f4004c);
            if (NewsInfoData.EXTEND_TYPE_APK.equals(testResultAdData.getExtend_type())) {
                if (Methods.hasInstalled(testResultAdData.getPackage_name())) {
                    Methods.openApp(ABenchmarkApplication.getContext(), testResultAdData.getPackage_name());
                    return view;
                }
                c1190a.f4002a.setOnClickListener(new C11841(this, testResultAdData));
                return view;
            } else if ("link".equals(testResultAdData.getExtend_type())) {
                c1190a.f4002a.setOnClickListener(new C11852(this, testResultAdData));
                return view;
            } else {
                this.f4017d.m5422a(testResultAdData.getUrl());
                return view;
            }
        } else if (itemViewType == 0) {
            C1192c c1192c;
            testResultAdData = (TestResultAdData) testResultModel.getData();
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C1192c)) {
                view = this.f4016c.inflate(C1082R.layout.item_test_result_ad_small, viewGroup, false);
                C1192c c1192c2 = new C1192c();
                c1192c2.f4011b = (ImageView) view.findViewById(C1082R.id.img);
                c1192c2.f4012c = (TextView) view.findViewById(C1082R.id.tv_desc);
                c1192c2.f4013d = (TextView) view.findViewById(C1692R.id.btn);
                c1192c2.f4010a = (MaterialRippleLayout) view.findViewById(C1082R.id.ll_bg);
                view.setTag(c1192c2);
                c1192c = c1192c2;
            } else {
                c1192c = (C1192c) view.getTag();
            }
            ImageUtil.displayImageNews(testResultAdData.getApp_icon(), c1192c.f4011b);
            c1192c.f4012c.setText(testResultAdData.getTitle());
            c1192c.f4013d.setText(testResultAdData.getBtn_text());
            if (NewsInfoData.EXTEND_TYPE_APK.equals(testResultAdData.getExtend_type())) {
                if (Methods.hasInstalled(testResultAdData.getPackage_name())) {
                    c1192c.f4013d.setText(C1082R.string.open);
                    c1192c.f4010a.setOnClickListener(new C11863(this, testResultAdData));
                    return view;
                }
                c1192c.f4010a.setOnClickListener(new C11874(this, testResultAdData));
                return view;
            } else if ("link".equals(testResultAdData.getExtend_type())) {
                c1192c.f4010a.setOnClickListener(new C11885(this, testResultAdData));
                return view;
            } else {
                this.f4017d.m5422a(testResultAdData.getUrl());
                return view;
            }
        } else if (itemViewType == 3) {
            C1191b c1191b;
            TestResultHuiShouBao testResultHuiShouBao = (TestResultHuiShouBao) testResultModel.getData();
            if (view == null || view.getTag() == null || !(view.getTag() instanceof C1191b)) {
                view = this.f4016c.inflate(C1082R.layout.item_test_result_huishoubao, viewGroup, false);
                C1191b c1191b2 = new C1191b();
                c1191b2.f4009c = (TextView) view.findViewById(C1082R.id.tv_desc);
                c1191b2.f4008b = (ImageView) view.findViewById(C1082R.id.img);
                c1191b2.f4007a = (MaterialRippleLayout) view.findViewById(C1082R.id.ll_bg);
                view.setTag(c1191b2);
                c1191b = c1191b2;
            } else {
                c1191b = (C1191b) view.getTag();
            }
            ImageUtil.displayImageNews(testResultHuiShouBao.getPicture(), c1191b.f4008b);
            if ("0.0".equals(testResultHuiShouBao.getMaxprice())) {
                c1191b.f4009c.setVisibility(8);
            } else {
                c1191b.f4009c.setVisibility(0);
                c1191b.f4009c.setText(this.f4014a.getString(C1082R.string.huishoubao_desc, new Object[]{testResultHuiShouBao.getMaxprice()}));
            }
            c1191b.f4007a.setOnClickListener(new C11896(this, testResultHuiShouBao));
            return view;
        } else if (itemViewType != 2) {
            return new View(this.f4014a);
        } else {
            List list = (List) testResultModel.getData();
            view = new C1691o(this.f4014a);
            view.setData(list);
            return view;
        }
    }

    public int getViewTypeCount() {
        return 4;
    }
}
