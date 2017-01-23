package com.antutu.benchmark.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.C1501f;
import com.antutu.benchmark.model.C1537o;
import com.antutu.benchmark.p036a.C1105d;
import com.antutu.benchmark.p036a.C1107e;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p038b.C1341f;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.PointMark;
import com.antutu.utils.ShareUtil;
import com.antutu.utils.jni;
import java.util.ArrayList;
import java.util.List;

public class CompareActivity extends C1197a {
    private static C1537o f4114a;
    private ListView f4115b;
    private View f4116c;
    private LinearLayout f4117d;
    private OnClickListener f4118e;

    /* renamed from: com.antutu.benchmark.activity.CompareActivity.1 */
    class C12211 implements OnClickListener {
        final /* synthetic */ CompareActivity f4113a;

        C12211(CompareActivity compareActivity) {
            this.f4113a = compareActivity;
        }

        public void onClick(View view) {
            ShareUtil.showShareApp(this.f4113a, null, this.f4113a.f4117d, CompareActivity.f4114a.m6083a());
        }
    }

    static {
        f4114a = null;
    }

    public CompareActivity() {
        this.f4118e = new C12211(this);
    }

    public static void m5014a(C1537o c1537o) {
        f4114a = c1537o;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.compare);
        PointMark.getInstance(this).pointThis(PointMark.K_COMPARE);
        this.f4115b = (ListView) findViewById(C1082R.id.CompareList);
        TextView textView = (TextView) findViewById(C1082R.id.r_name);
        TextView textView2 = (TextView) findViewById(C1082R.id.l_name);
        TextView textView3 = (TextView) findViewById(C1082R.id.r_brand);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6412a((int) C1082R.drawable.main_title_icon_back).m6413a(this.j).m6414a(getResources().getString(C1082R.string.cmp_result)).m6416b((int) C1082R.drawable.share).m6418b(true).m6420d(false).m6417b(this.f4118e).m6411a());
        try {
            if (f4114a == null) {
                finish();
                return;
            }
            textView2.setText(C1503b.m5915c().m5940d(Build.MODEL));
            textView.setText(f4114a.m6083a());
            textView3.setText(f4114a.m6086b());
            int benchmarkScore = jni.benchmarkScore(this, 41);
            C1501f c1501f = new C1501f(this);
            List arrayList = new ArrayList();
            arrayList.add(new C1105d(benchmarkScore, f4114a.m6082a(41), 0, getResources().getString(C1082R.string.c_info_total)));
            for (int i = 30; i < 41; i++) {
                arrayList.add(new C1105d(jni.benchmarkScore(this, i), f4114a.m6082a(i), 0, c1501f.m5905a(i)));
            }
            Object c1107e = new C1107e(this, arrayList);
            this.f4115b.setAdapter(c1107e);
            c1107e.notifyDataSetChanged();
            OnTouchListener c1341f = new C1341f(this);
            c1341f.m5400a(this);
            this.f4116c = findViewById(C1082R.id.compare_layout);
            this.f4117d = (LinearLayout) findViewById(C1082R.id.ll_compare_content);
            this.f4116c.setOnTouchListener(c1341f);
            this.f4115b.setOnTouchListener(c1341f);
        } catch (Exception e) {
            finish();
        }
    }
}
