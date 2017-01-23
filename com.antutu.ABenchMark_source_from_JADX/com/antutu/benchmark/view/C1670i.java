package com.antutu.benchmark.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.ScreenEntryActivity;
import com.antutu.redacc.C1692R;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MobclickAgentConstants;
import com.umeng.analytics.MobclickAgent;

/* renamed from: com.antutu.benchmark.view.i */
public class C1670i extends RelativeLayout {
    private Context f5971a;
    private ImageView f5972b;
    private MaterialRippleLayout f5973c;

    /* renamed from: com.antutu.benchmark.view.i.1 */
    class C16691 implements OnClickListener {
        final /* synthetic */ C1670i f5970a;

        C16691(C1670i c1670i) {
            this.f5970a = c1670i;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f5970a.f5971a, MobclickAgentConstants.click_more_test_ad);
            InfocUtil.antutu_click_testtab(this.f5970a.f5971a, 11);
            this.f5970a.f5971a.startActivity(new Intent(this.f5970a.f5971a, ScreenEntryActivity.class));
            if (this.f5970a.f5971a instanceof Activity) {
                ((Activity) this.f5970a.f5971a).overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
            }
        }
    }

    public C1670i(Context context) {
        super(context);
        m6556a(context, null, 0);
    }

    private void m6556a(Context context, AttributeSet attributeSet, int i) {
        this.f5971a = context;
        View.inflate(context, C1082R.layout.item_home_screen_test, this);
        this.f5972b = (ImageView) findViewById(C1082R.id.iv_arrow_right);
        this.f5973c = (MaterialRippleLayout) findViewById(C1082R.id.ll_bg);
        this.f5973c.setOnClickListener(new C16691(this));
    }
}
