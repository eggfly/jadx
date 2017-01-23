package com.antutu.benchmark.p044h;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.CompareActivity;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.model.C1537o;
import com.antutu.benchmark.modelreflact.SearchDetailModel;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.h.a */
public class C1509a extends BaseAdapter implements OnItemClickListener {
    private LayoutInflater f5179a;
    private Activity f5180b;
    private List<SearchDetailModel> f5181c;
    private DisplayImageOptions f5182d;

    /* renamed from: com.antutu.benchmark.h.a.1 */
    class C15071 implements OnClickListener {
        final /* synthetic */ SearchDetailModel f5171a;
        final /* synthetic */ C1509a f5172b;

        C15071(C1509a c1509a, SearchDetailModel searchDetailModel) {
            this.f5172b = c1509a;
            this.f5171a = searchDetailModel;
        }

        public void onClick(View view) {
            try {
                if (C1503b.m5915c().m5972y()) {
                    MobclickAgent.onEvent(this.f5172b.f5180b, MobclickAgentConstants.click_compare);
                    C1537o c1537o = new C1537o();
                    this.f5172b.m5993a(c1537o, this.f5171a);
                    CompareActivity.m5014a(c1537o);
                    Intent intent = new Intent();
                    intent.setClass(this.f5172b.f5180b, CompareActivity.class);
                    this.f5172b.f5180b.startActivity(intent);
                    this.f5172b.f5180b.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
                    return;
                }
                Methods.showToast(this.f5172b.f5180b, (int) C1082R.string.prompt_rank, 0);
                Message message = new Message();
                message.what = 1;
                message.arg1 = 0;
                message.obj = null;
                MainActivity.m5138a(message);
                this.f5172b.f5180b.finish();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.h.a.a */
    private static class C1508a {
        ImageView f5173a;
        TextView f5174b;
        TextView f5175c;
        TextView f5176d;
        Button f5177e;
        TextView f5178f;

        private C1508a() {
        }
    }

    public C1509a(Activity activity, List<SearchDetailModel> list) {
        this.f5179a = null;
        this.f5180b = null;
        this.f5181c = new ArrayList();
        this.f5180b = activity;
        this.f5179a = LayoutInflater.from(activity);
        this.f5181c.addAll(list);
        this.f5182d = new Builder().showImageOnLoading((int) C1082R.drawable.news_loading).showImageForEmptyUri((int) C1082R.drawable.mobile_default_icon).showImageOnFail((int) C1082R.drawable.mobile_default_icon).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(Config.RGB_565).resetViewBeforeLoading(true).displayer(new FadeInBitmapDisplayer(100)).build();
    }

    private SpannableStringBuilder m5991a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder(BuildConfig.FLAVOR);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, str.indexOf(str2) + str2.length(), 33);
        return spannableStringBuilder;
    }

    private void m5993a(C1537o c1537o, SearchDetailModel searchDetailModel) {
        c1537o.m6087b(searchDetailModel.getName());
        c1537o.m6088c(searchDetailModel.getModel());
        c1537o.m6084a(30, searchDetailModel.getS1());
        c1537o.m6084a(31, searchDetailModel.getS2());
        c1537o.m6084a(32, searchDetailModel.getS3());
        c1537o.m6084a(33, searchDetailModel.getS4());
        c1537o.m6084a(34, searchDetailModel.getS5());
        c1537o.m6084a(35, searchDetailModel.getS6());
        c1537o.m6084a(36, searchDetailModel.getS7());
        c1537o.m6084a(37, searchDetailModel.getS8());
        c1537o.m6084a(38, searchDetailModel.getS9());
        c1537o.m6084a(39, searchDetailModel.getS10());
        c1537o.m6084a(40, searchDetailModel.getS11());
        c1537o.m6084a(41, searchDetailModel.getScore());
    }

    public void m5994a(List<SearchDetailModel> list) {
        this.f5181c.clear();
        this.f5181c.addAll(list);
    }

    public int getCount() {
        return this.f5181c.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C1508a c1508a;
        boolean z = true;
        if (view == null) {
            try {
                inflate = this.f5179a.inflate(C1082R.layout.search_result_item, null);
                try {
                    c1508a = new C1508a();
                    c1508a.f5173a = (ImageView) inflate.findViewById(C1082R.id.device_imageview);
                    c1508a.f5174b = (TextView) inflate.findViewById(C1082R.id.device_name);
                    c1508a.f5175c = (TextView) inflate.findViewById(C1082R.id.cpu_info);
                    c1508a.f5176d = (TextView) inflate.findViewById(C1082R.id.textScore);
                    c1508a.f5177e = (Button) inflate.findViewById(C1082R.id.pk_btn);
                    c1508a.f5178f = (TextView) inflate.findViewById(C1082R.id.lowprice_textview);
                    inflate.setTag(c1508a);
                } catch (Exception e) {
                    return inflate;
                }
            } catch (Exception e2) {
                return view;
            }
        }
        c1508a = (C1508a) view.getTag();
        inflate = view;
        SearchDetailModel searchDetailModel = (SearchDetailModel) this.f5181c.get(i);
        boolean isChinese = Methods.isChinese();
        String str = searchDetailModel.getLowPrice() + BuildConfig.FLAVOR;
        if (TextUtils.isEmpty(str)) {
            c1508a.f5178f.setVisibility(8);
        } else if (isChinese) {
            c1508a.f5178f.setVisibility(0);
            c1508a.f5178f.setText(m5991a(this.f5180b.getString(C1082R.string.search_low_price, new Object[]{str}), str));
        }
        Button button = c1508a.f5177e;
        if (isChinese) {
            z = false;
        }
        button.setFocusable(z);
        c1508a.f5177e.setOnClickListener(new C15071(this, searchDetailModel));
        CharSequence name = searchDetailModel.getName();
        if (name == null || BuildConfig.FLAVOR.equals(name)) {
            c1508a.f5174b.setText(searchDetailModel.getModel());
        } else {
            c1508a.f5174b.setText(name);
        }
        c1508a.f5176d.setText(searchDetailModel.getScore() + BuildConfig.FLAVOR);
        c1508a.f5175c.setText(searchDetailModel.getCpuMax() + " MHz");
        ImageLoader.getInstance().displayImage(searchDetailModel.getAvatar(), c1508a.f5173a, this.f5182d);
        return inflate;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SearchDetailModel searchDetailModel = (SearchDetailModel) this.f5181c.get(i - 1);
        String wapUrl = searchDetailModel.getWapUrl();
        String productid = searchDetailModel.getProductid();
        String country = this.f5180b.getResources().getConfiguration().locale.getCountry();
        String language = this.f5180b.getResources().getConfiguration().locale.getLanguage();
        if ((language != null && language.contains("zh") && country == null) || country.contains("CN")) {
            Methods.openZOL(this.f5180b, wapUrl, productid);
        }
    }
}
