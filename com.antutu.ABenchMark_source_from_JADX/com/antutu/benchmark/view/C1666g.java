package com.antutu.benchmark.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.activity.AccelerateActivity;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.StringUtil;

/* renamed from: com.antutu.benchmark.view.g */
public class C1666g extends RelativeLayout {
    private Context f5963a;
    private MaterialRippleLayout f5964b;
    private TextView f5965c;
    private TextView f5966d;

    /* renamed from: com.antutu.benchmark.view.g.1 */
    class C16651 implements OnClickListener {
        final /* synthetic */ C1666g f5962a;

        C16651(C1666g c1666g) {
            this.f5962a = c1666g;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(this.f5962a.f5963a, 13);
            Intent intent = new Intent(this.f5962a.f5963a, AccelerateActivity.class);
            intent.putExtra("isLive", ABenchmarkApplication.f3647c);
            this.f5962a.f5963a.startActivity(intent);
            if (this.f5962a.f5963a instanceof Activity) {
                ((Activity) this.f5962a.f5963a).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
            }
        }
    }

    public C1666g(Context context) {
        super(context);
        m6552a(context, null, 0);
    }

    private void m6552a(Context context, AttributeSet attributeSet, int i) {
        this.f5963a = context;
        View.inflate(context, C1082R.layout.item_home_jia_su, this);
        this.f5964b = (MaterialRippleLayout) findViewById(C1082R.id.ll_bg);
        this.f5965c = (TextView) findViewById(C1082R.id.textViewTitle1);
        this.f5966d = (TextView) findViewById(C1082R.id.textViewTitle2);
        this.f5964b.setOnClickListener(new C16651(this));
    }

    public void setTemperature(int i) {
        double d = ((double) i) * 0.1d;
        this.f5965c.setText(StringUtil.formatTempToC(d));
        if (d < 35.0d) {
            this.f5965c.setTextColor(Color.parseColor("#0495d9"));
            this.f5966d.setText(C1082R.string.jia_su_title_normal);
            return;
        }
        this.f5965c.setTextColor(Color.parseColor("#dc3e30"));
        this.f5966d.setText(C1082R.string.jia_su_title_high);
    }
}
