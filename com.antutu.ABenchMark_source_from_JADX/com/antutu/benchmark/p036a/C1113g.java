package com.antutu.benchmark.p036a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.utils.ImageUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.downloader.DownloadsService;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.g */
public class C1113g extends BaseAdapter {
    private Context f3752a;
    private List<C1518a> f3753b;

    /* renamed from: com.antutu.benchmark.a.g.1 */
    class C11111 implements OnClickListener {
        final /* synthetic */ C1518a f3746a;
        final /* synthetic */ C1112a f3747b;
        final /* synthetic */ C1113g f3748c;

        C11111(C1113g c1113g, C1518a c1518a, C1112a c1112a) {
            this.f3748c = c1113g;
            this.f3746a = c1518a;
            this.f3747b = c1112a;
        }

        public void onClick(View view) {
            if (Methods.hasInstalled(this.f3746a.f5205c)) {
                Methods.openApp(this.f3748c.f3752a, this.f3746a.f5204b);
            } else if (!this.f3748c.f3752a.getString(C1082R.string.downloading_status).equals(this.f3747b.f3751c.getText().toString())) {
                WebBrowserActivity.openURL(this.f3748c.f3752a, this.f3746a.f5209g, BuildConfig.FLAVOR);
            } else if (this.f3746a.f5209g.startsWith("http://appdownloadwithtitle2.")) {
                String replace = this.f3746a.f5209g.replace("appdownloadwithtitle2.", BuildConfig.FLAVOR);
                int indexOf = replace.indexOf(".");
                if (indexOf > 0) {
                    replace = "http://" + replace.substring(indexOf + 1);
                }
                DownloadsService.stopDownload(this.f3748c.f3752a, replace);
            } else if (this.f3746a.f5209g.endsWith(".apk")) {
                DownloadsService.stopDownload(this.f3748c.f3752a, this.f3746a.f5209g);
                this.f3747b.f3751c.setText(this.f3748c.f3752a.getString(C1082R.string.continue_status));
            } else {
                WebBrowserActivity.openURL(this.f3748c.f3752a, this.f3746a.f5209g, BuildConfig.FLAVOR);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.g.a */
    static class C1112a {
        ImageView f3749a;
        TextView f3750b;
        Button f3751c;

        C1112a() {
        }
    }

    public C1113g(Context context, List<C1518a> list) {
        this.f3753b = null;
        this.f3752a = context;
        this.f3753b = list;
    }

    private void m4871a(C1112a c1112a, C1518a c1518a) {
        c1112a.f3751c.setText(c1518a.f5210h);
        c1112a.f3751c.setOnClickListener(new C11111(this, c1518a, c1112a));
    }

    public void m4872a(List<C1518a> list) {
        if (this.f3753b != null) {
            this.f3753b.clear();
            this.f3753b.addAll(list);
        }
    }

    public int getCount() {
        return this.f3753b.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1112a c1112a;
        C1518a c1518a = (C1518a) this.f3753b.get(i);
        if (view == null) {
            C1112a c1112a2 = new C1112a();
            view = View.inflate(this.f3752a, C1082R.layout.item_detail_ad, null);
            c1112a2.f3750b = (TextView) view.findViewById(C1082R.id.tv_app_name);
            c1112a2.f3749a = (ImageView) view.findViewById(C1082R.id.iv_ad_icon);
            c1112a2.f3751c = (Button) view.findViewById(C1082R.id.btn_ad_download);
            view.setTag(c1112a2);
            c1112a = c1112a2;
        } else {
            c1112a = (C1112a) view.getTag();
        }
        c1112a.f3750b.setText(c1518a.f5207e);
        ImageUtil.displayImageNews(c1518a.f5206d, c1112a.f3749a);
        m4871a(c1112a, c1518a);
        return view;
    }
}
