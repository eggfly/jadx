package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.view.MaterialRippleLayout;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.PointMark;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.m */
public class C1133m extends BaseAdapter {
    private Activity f3820a;
    private List<C1131a> f3821b;

    /* renamed from: com.antutu.benchmark.a.m.1 */
    class C11301 implements OnClickListener {
        final /* synthetic */ String f3807a;
        final /* synthetic */ boolean f3808b;
        final /* synthetic */ C1518a f3809c;
        final /* synthetic */ C1133m f3810d;

        C11301(C1133m c1133m, String str, boolean z, C1518a c1518a) {
            this.f3810d = c1133m;
            this.f3807a = str;
            this.f3808b = z;
            this.f3809c = c1518a;
        }

        public void onClick(View view) {
            if (NetUtils.isNetworkAvailable()) {
                PointMark.getInstance(this.f3810d.f3820a).pointThis(this.f3807a);
                String str = this.f3807a;
                if (this.f3808b) {
                    Methods.openApp(this.f3810d.f3820a, str);
                    return;
                } else {
                    WebBrowserActivity.openURL(this.f3810d.f3820a, this.f3809c.f5209g, BuildConfig.FLAVOR);
                    return;
                }
            }
            Methods.showToast(this.f3810d.f3820a, (int) C1082R.string.prompt_net, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.a.m.a */
    public static class C1131a {
        private boolean f3811a;
        private int f3812b;
        private int f3813c;
        private OnClickListener f3814d;
        private C1518a f3815e;

        public C1131a(int i, int i2, OnClickListener onClickListener) {
            this.f3812b = i;
            this.f3813c = i2;
            this.f3814d = onClickListener;
            this.f3811a = false;
        }

        public C1131a(C1518a c1518a) {
            this.f3815e = c1518a;
            this.f3811a = true;
        }
    }

    /* renamed from: com.antutu.benchmark.a.m.b */
    static class C1132b {
        ImageView f3816a;
        TextView f3817b;
        MaterialRippleLayout f3818c;
        ImageView f3819d;

        C1132b() {
        }
    }

    public C1133m(Activity activity, List<C1131a> list) {
        this.f3820a = activity;
        this.f3821b = list;
    }

    public int getCount() {
        return this.f3821b.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1132b c1132b;
        if (view == null) {
            view = View.inflate(this.f3820a, C1082R.layout.adapter_more_test_ad, null);
            c1132b = new C1132b();
            c1132b.f3816a = (ImageView) view.findViewById(C1082R.id.img);
            c1132b.f3817b = (TextView) view.findViewById(C1082R.id.tv_text);
            c1132b.f3818c = (MaterialRippleLayout) view.findViewById(C1082R.id.ll_bg);
            c1132b.f3819d = (ImageView) view.findViewById(C1082R.id.ad_tag);
            view.setTag(c1132b);
        } else {
            c1132b = (C1132b) view.getTag();
        }
        C1131a c1131a = (C1131a) this.f3821b.get(i);
        if (c1131a.f3811a) {
            C1518a b = c1131a.f3815e;
            ImageUtil.displayImageNews(b.f5206d, c1132b.f3816a);
            c1132b.f3817b.setText(b.f5207e);
            c1132b.f3819d.setVisibility(0);
            String str = b.f5205c;
            c1132b.f3818c.setOnClickListener(new C11301(this, str, Methods.hasInstalled(str), b));
        } else {
            c1132b.f3819d.setVisibility(8);
            c1132b.f3816a.setImageResource(c1131a.f3812b);
            c1132b.f3817b.setText(c1131a.f3813c);
            c1132b.f3818c.setOnClickListener(c1131a.f3814d);
        }
        return view;
    }
}
