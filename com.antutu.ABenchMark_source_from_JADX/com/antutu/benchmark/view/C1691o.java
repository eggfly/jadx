package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.p036a.C1148n;
import com.antutu.benchmark.p036a.C1148n.C1139b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.view.o */
public class C1691o extends LinearLayout {
    private Context f6033a;
    private LinearLayout f6034b;
    private C1148n f6035c;
    private List<NewsInfoData> f6036d;

    public C1691o(Context context) {
        super(context);
        this.f6036d = new ArrayList();
        m6605a(context, null, 0);
    }

    private void m6605a(Context context, AttributeSet attributeSet, int i) {
        this.f6033a = context;
        View.inflate(context, C1082R.layout.item_news_test_result, this);
        this.f6035c = new C1148n(context, this.f6036d, BuildConfig.FLAVOR, false);
        this.f6034b = (LinearLayout) findViewById(C1082R.id.linearlayout);
        m6606a(this.f6036d);
    }

    private void m6606a(List<NewsInfoData> list) {
        for (int i = 0; i < list.size(); i++) {
            C1139b a = this.f6035c.m4905a(this.f6034b, this.f6035c.getItemViewType(i));
            this.f6035c.m4907a(a, i);
            this.f6034b.addView(a.m4900a());
        }
    }

    public void setData(List<NewsInfoData> list) {
        this.f6036d.clear();
        this.f6036d.addAll(list);
        this.f6034b.removeAllViews();
        m6606a(list);
    }
}
