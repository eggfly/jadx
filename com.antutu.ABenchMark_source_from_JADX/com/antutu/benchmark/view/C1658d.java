package com.antutu.benchmark.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.CommentActivity;
import com.antutu.benchmark.modelreflact.PraiseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.redacc.C1692R;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminateSingle;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.message.MessageService;

/* renamed from: com.antutu.benchmark.view.d */
public class C1658d extends RelativeLayout implements OnClickListener {
    private Context f5926a;
    private MaterialRippleLayout f5927b;
    private LinearLayout f5928c;
    private LinearLayout f5929d;
    private TextView f5930e;
    private TextView f5931f;
    private ImageView f5932g;
    private Button f5933h;
    private ProgressBarCircularIndeterminateSingle f5934i;
    private String f5935j;
    private C1371d f5936k;

    /* renamed from: com.antutu.benchmark.view.d.1 */
    class C16561 implements OnClickListener {
        final /* synthetic */ C1658d f5924a;

        C16561(C1658d c1658d) {
            this.f5924a = c1658d;
        }

        public void onClick(View view) {
            InfocUtil.antutu_click_testtab(this.f5924a.f5926a, 9);
            this.f5924a.m6522b();
        }
    }

    /* renamed from: com.antutu.benchmark.view.d.2 */
    class C16572 implements C1095a<PraiseModel> {
        final /* synthetic */ C1658d f5925a;

        C16572(C1658d c1658d) {
            this.f5925a = c1658d;
        }

        public void m6513a(PraiseModel praiseModel) {
            this.f5925a.setHasComement(true);
            this.f5925a.f5930e.setText(praiseModel.getGoodpercent().replaceAll("%", BuildConfig.FLAVOR) + "%");
            this.f5925a.m6519a(praiseModel);
        }

        public void m6515a(String str) {
            this.f5925a.setHasComement(false);
        }
    }

    public C1658d(Context context) {
        super(context);
        this.f5935j = MessageService.MSG_DB_READY_REPORT;
        m6518a(context, null, 0);
    }

    private void m6517a() {
        this.f5927b = (MaterialRippleLayout) findViewById(C1082R.id.ll_comment_bg);
        this.f5928c = (LinearLayout) findViewById(C1082R.id.ll_loading);
        this.f5930e = (TextView) findViewById(C1082R.id.tv_praise);
        this.f5929d = (LinearLayout) findViewById(C1082R.id.ll_nocomment);
        this.f5933h = (Button) findViewById(C1082R.id.btn_add_comment);
        this.f5931f = (TextView) findViewById(C1082R.id.tv_hits);
        this.f5932g = (ImageView) findViewById(C1082R.id.iv_commnet_red);
        this.f5934i = (ProgressBarCircularIndeterminateSingle) findViewById(C1692R.id.progress);
        this.f5934i.setBackgroundColor(this.f5926a.getResources().getColor(C1082R.color.colorPrimary_day));
    }

    private void m6518a(Context context, AttributeSet attributeSet, int i) {
        this.f5926a = context;
        View.inflate(this.f5926a, C1082R.layout.item_home_comment, this);
        this.f5936k = new C1371d(context);
        m6517a();
        this.f5927b.setOnClickListener(new C16561(this));
        this.f5929d.setOnClickListener(this);
        this.f5933h.setOnClickListener(this);
        m6525c();
        this.f5936k.m5429a(new C16572(this));
    }

    private void m6519a(PraiseModel praiseModel) {
        this.f5935j = praiseModel.getComment_count();
        if (this.f5935j == null || BuildConfig.FLAVOR.equals(this.f5935j)) {
            this.f5935j = MessageService.MSG_DB_READY_REPORT;
        }
        if (Methods.getSharedPreferencesString("comments_not_read", "-1").equals(this.f5935j)) {
            this.f5932g.setVisibility(8);
        } else {
            this.f5932g.setVisibility(0);
        }
    }

    private void m6522b() {
        this.f5932g.setVisibility(8);
        Methods.editSharedPreferences("comments_not_read", this.f5935j);
        MobclickAgent.onEvent(this.f5926a, MobclickAgentConstants.click_home_item_look_allcomment);
        this.f5926a.startActivity(new Intent(this.f5926a, CommentActivity.class));
    }

    private void m6525c() {
        this.f5928c.setVisibility(0);
        this.f5929d.setVisibility(8);
        this.f5927b.setVisibility(8);
    }

    private void setHasComement(boolean z) {
        if (z) {
            this.f5928c.setVisibility(8);
            this.f5929d.setVisibility(8);
            this.f5927b.setVisibility(0);
            return;
        }
        this.f5928c.setVisibility(8);
        this.f5929d.setVisibility(0);
        this.f5927b.setVisibility(8);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.ll_nocomment /*2131624294*/:
            case C1082R.id.btn_add_comment /*2131624406*/:
                InfocUtil.antutu_click_testtab(this.f5926a, 9);
                m6522b();
            default:
        }
    }
}
