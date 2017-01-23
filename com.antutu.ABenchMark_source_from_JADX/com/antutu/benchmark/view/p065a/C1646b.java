package com.antutu.benchmark.view.p065a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.gc.materialdesign.C2513R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.C2560e;
import com.github.mikephil.charting.data.C2569g;
import com.github.mikephil.charting.p138c.C2538f;
import com.github.mikephil.charting.p138c.C2538f.C2537a;
import com.github.mikephil.charting.p138c.C2541g;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.view.a.b */
public class C1646b extends C1643a {
    private Typeface f5897c;

    /* renamed from: com.antutu.benchmark.view.a.b.a */
    private static class C1645a {
        LineChart f5895a;
        TextView f5896b;

        private C1645a() {
        }
    }

    public C1646b(C2560e<?> c2560e, String str, Context context) {
        super(c2560e, str);
        this.f5897c = Typeface.DEFAULT;
    }

    public View m6493a(int i, View view, Context context) {
        C1645a c1645a;
        if (view == null) {
            c1645a = new C1645a();
            view = LayoutInflater.from(context).inflate(C1082R.layout.list_item_linechart, null);
            c1645a.f5895a = (LineChart) view.findViewById(C1082R.id.chart);
            c1645a.f5896b = (TextView) view.findViewById(C2513R.id.title);
            view.setTag(c1645a);
        } else {
            c1645a = (C1645a) view.getTag();
        }
        c1645a.f5896b.setText(this.b);
        c1645a.f5895a.setDescription(BuildConfig.FLAVOR);
        c1645a.f5895a.setDrawGridBackground(false);
        C2538f xAxis = c1645a.f5895a.getXAxis();
        xAxis.m9614a(C2537a.BOTTOM);
        xAxis.m9559a(this.f5897c);
        xAxis.m9566a(false);
        xAxis.m9568b(true);
        C2541g axisLeft = c1645a.f5895a.getAxisLeft();
        axisLeft.m9559a(this.f5897c);
        axisLeft.m9634a(5, false);
        axisLeft.m9633a(0.0f);
        axisLeft = c1645a.f5895a.getAxisRight();
        axisLeft.m9559a(this.f5897c);
        axisLeft.m9634a(5, false);
        axisLeft.m9566a(false);
        axisLeft.m9633a(0.0f);
        c1645a.f5895a.setData((C2569g) this.a);
        c1645a.f5895a.m9648a(750);
        return view;
    }
}
