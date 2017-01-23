package com.antutu.benchmark.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.BenchLongActivity;
import com.antutu.redacc.C1692R;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MobclickAgentConstants;
import com.umeng.analytics.MobclickAgent;

/* renamed from: com.antutu.benchmark.view.h */
public class C1668h extends RelativeLayout {
    private Context f5968a;
    private MaterialRippleLayout f5969b;

    /* renamed from: com.antutu.benchmark.view.h.1 */
    class C16671 implements OnClickListener {
        final /* synthetic */ C1668h f5967a;

        C16671(C1668h c1668h) {
            this.f5967a = c1668h;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f5967a.f5968a, MobclickAgentConstants.click_longtest_button);
            InfocUtil.antutu_click_testtab(this.f5967a.f5968a, 10);
            this.f5967a.f5968a.startActivity(new Intent(this.f5967a.f5968a, BenchLongActivity.class));
            if (this.f5967a.f5968a instanceof Activity) {
                ((Activity) this.f5967a.f5968a).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
            }
        }
    }

    public C1668h(Context context) {
        super(context);
        m6554a(context, null, 0);
    }

    private void m6554a(Context context, AttributeSet attributeSet, int i) {
        this.f5968a = context;
        View.inflate(context, C1082R.layout.item_home_long_test, this);
        this.f5969b = (MaterialRippleLayout) findViewById(C1082R.id.ll_bg);
        this.f5969b.setOnClickListener(new C16671(this));
    }
}
