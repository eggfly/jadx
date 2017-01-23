package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1539q;
import com.antutu.benchmark.p038b.C1220d;
import com.antutu.benchmark.p038b.C1340e;
import com.antutu.benchmark.p042e.C1453f;
import com.antutu.benchmark.p042e.C1460g;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.viewpagerindicator.TabPageIndicator;
import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends C1220d {
    private List<C1539q> f4109b;
    private TabPageIndicator f4110c;
    private ViewPager f4111d;
    private C1340e f4112e;

    public CommentActivity() {
        this.f4109b = new ArrayList();
        this.f4112e = null;
    }

    private void m5011b() {
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.yonghuhaopingdu)).m6413a(this.a).m6418b(false).m6411a());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_comment);
        m5011b();
        this.f4109b.add(new C1539q(new C1453f(), null, getString(C1082R.string.now_phone)));
        this.f4109b.add(new C1539q(new C1460g(), null, getString(C1082R.string.other_phone)));
        this.f4112e = new C1340e(getSupportFragmentManager(), this.f4109b);
        this.f4111d = (ViewPager) findViewById(C1082R.id.viewpager);
        this.f4111d.setAdapter(this.f4112e);
        this.f4111d.setOffscreenPageLimit(this.f4109b.size());
        this.f4110c = (TabPageIndicator) findViewById(C1082R.id.indicator);
        this.f4110c.setViewPager(this.f4111d);
        this.f4110c.setOnPageChangeListener(this.f4112e);
    }
}
