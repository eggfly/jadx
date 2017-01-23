package com.antutu.benchmark.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.averify.activity.ActivityVerifying;
import com.antutu.benchmark.averify.logic.C1333c;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.redacc.C1692R;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.NetUtils;
import com.antutu.utils.PointMark;
import com.antutu.utils.Utils;
import com.umeng.analytics.MobclickAgent;
import java.util.Calendar;
import java.util.Date;

/* renamed from: com.antutu.benchmark.view.j */
public class C1674j extends RelativeLayout {
    private Context f5977a;
    private TextView f5978b;
    private TextView f5979c;
    private C1371d f5980d;
    private MaterialRippleLayout f5981e;
    private String f5982f;
    private String f5983g;
    private long f5984h;

    /* renamed from: com.antutu.benchmark.view.j.1 */
    class C16711 implements OnClickListener {
        final /* synthetic */ C1674j f5974a;

        C16711(C1674j c1674j) {
            this.f5974a = c1674j;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f5974a.f5977a, MobclickAgentConstants.click_verify);
            MobclickAgent.onEvent(this.f5974a.f5977a, MobclickAgentConstants.click_home_item_verify);
            PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_START_VERIFYMOBILE);
            if (NetUtils.isNetworkAvailable()) {
                this.f5974a.m6566b();
            } else if (TextUtils.isEmpty(C1333c.m5390a(this.f5974a.f5977a))) {
                Methods.showToast(this.f5974a.f5977a, (int) C1692R.string.network_error, 0);
            } else {
                this.f5974a.m6566b();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.j.2 */
    class C16722 implements C1095a<String> {
        final /* synthetic */ C1674j f5975a;

        C16722(C1674j c1674j) {
            this.f5975a = c1674j;
        }

        public /* synthetic */ void m6557a(Object obj) {
            m6559b((String) obj);
        }

        public void m6558a(String str) {
        }

        public void m6559b(String str) {
            Methods.editSharedPreferences("all_verify_phone_counts", str);
            Methods.editSharedPreferences("verify_phone_counts_update_time", System.currentTimeMillis());
            this.f5975a.f5979c.setText(str);
        }
    }

    /* renamed from: com.antutu.benchmark.view.j.3 */
    class C16733 implements C1095a<String> {
        final /* synthetic */ C1674j f5976a;

        C16733(C1674j c1674j) {
            this.f5976a = c1674j;
        }

        public /* synthetic */ void m6560a(Object obj) {
            m6562b((String) obj);
        }

        public void m6561a(String str) {
        }

        public void m6562b(String str) {
            Methods.editSharedPreferences("today_verify_phone_counts", str);
            Methods.editSharedPreferences("verify_phone_counts_update_time", System.currentTimeMillis());
            this.f5976a.f5978b.setText(str);
        }
    }

    public C1674j(Context context) {
        super(context);
        this.f5978b = null;
        this.f5979c = null;
        m6565a(context, null, 0);
    }

    private void m6564a() {
        this.f5981e.setOnClickListener(new C16711(this));
        this.f5984h = Methods.getSharedPreferencesLong("verify_phone_counts_update_time", 0);
        this.f5982f = Methods.getSharedPreferencesString("today_verify_phone_counts", null);
        this.f5983g = Methods.getSharedPreferencesString("all_verify_phone_counts", null);
        if ((!Utils.isNetworkConnected(this.f5977a) && this.f5983g == null) || this.f5982f == null) {
            this.f5978b.setText(C1082R.string.please_check_network);
            this.f5979c.setText(C1082R.string.please_check_network);
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(this.f5984h));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(new Date());
        Object obj = instance.get(6) == instance2.get(6) ? 1 : null;
        if (!(this.f5983g == null || this.f5982f == null || obj == null)) {
            this.f5978b.setText(this.f5982f);
            this.f5979c.setText(this.f5983g);
        }
        this.f5980d.m5430a(new C16722(this), "c");
        this.f5980d.m5430a(new C16733(this), "tc");
    }

    private void m6565a(Context context, AttributeSet attributeSet, int i) {
        this.f5977a = context;
        View.inflate(context, C1082R.layout.item_home_verify, this);
        this.f5980d = new C1371d(this.f5977a);
        this.f5978b = (TextView) findViewById(C1082R.id.tv_today_verify_count);
        this.f5979c = (TextView) findViewById(C1082R.id.tv_all_verify_count);
        this.f5981e = (MaterialRippleLayout) findViewById(C1082R.id.ll_bg);
        m6564a();
    }

    private void m6566b() {
        InfocUtil.antutu_click_testtab(this.f5977a, 8);
        this.f5977a.startActivity(ActivityVerifying.m5345a(this.f5977a));
    }
}
