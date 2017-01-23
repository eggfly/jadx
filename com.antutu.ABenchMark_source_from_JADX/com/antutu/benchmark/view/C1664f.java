package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.NewsInfoData;
import com.antutu.benchmark.modelreflact.NewsResponseModel.DataEntity;
import com.antutu.benchmark.p036a.C1162o;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1360b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.view.f */
public class C1664f extends RelativeLayout {
    private Context f5954a;
    private LinearLayout f5955b;
    private TextView f5956c;
    private LinearLayout f5957d;
    private ListView f5958e;
    private C1162o f5959f;
    private List<NewsInfoData> f5960g;
    private C1360b f5961h;

    /* renamed from: com.antutu.benchmark.view.f.1 */
    class C16631 implements C1095a<DataEntity> {
        final /* synthetic */ C1664f f5953a;

        C16631(C1664f c1664f) {
            this.f5953a = c1664f;
        }

        public void m6543a(DataEntity dataEntity) {
            List infolist = dataEntity.getInfolist();
            if (infolist == null || infolist.size() < 1) {
                this.f5953a.setHasContent(false);
                return;
            }
            this.f5953a.setHasContent(true);
            this.f5953a.f5960g.clear();
            this.f5953a.f5960g.add(infolist.get(0));
            this.f5953a.f5959f.notifyDataSetChanged();
        }

        public void m6545a(String str) {
            this.f5953a.setHasContent(false);
        }
    }

    public C1664f(Context context) {
        super(context);
        this.f5960g = new ArrayList();
        m6547a(context, null, 0);
    }

    private void m6547a(Context context, AttributeSet attributeSet, int i) {
        this.f5954a = context;
        View.inflate(context, C1082R.layout.item_home_news, this);
        m6549b();
        this.f5959f = new C1162o(this.f5954a, this.f5960g, this.f5954a.getString(C1082R.string.home));
        this.f5958e.setAdapter(this.f5959f);
        this.f5961h = new C1360b(this.f5954a);
        m6550a();
        this.f5961h.m5425b(new C16631(this));
    }

    private void m6549b() {
        this.f5955b = (LinearLayout) findViewById(C1082R.id.ll_loading);
        this.f5956c = (TextView) findViewById(C1082R.id.no_content);
        this.f5957d = (LinearLayout) findViewById(C1082R.id.ll_bg);
        this.f5958e = (ListView) findViewById(C1082R.id.list);
    }

    public void m6550a() {
        this.f5957d.setVisibility(8);
        this.f5955b.setVisibility(0);
        this.f5956c.setVisibility(8);
    }

    public void setHasContent(boolean z) {
        if (z) {
            this.f5957d.setVisibility(0);
            this.f5955b.setVisibility(8);
            this.f5956c.setVisibility(8);
            return;
        }
        this.f5957d.setVisibility(8);
        this.f5955b.setVisibility(8);
        this.f5956c.setVisibility(0);
    }
}
