package com.antutu.benchmark.view;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.view.c */
public class C1655c extends RelativeLayout implements OnClickListener {
    private Context f5917a;
    private Button f5918b;
    private LinearLayout f5919c;
    private LinearLayout f5920d;
    private TextView f5921e;
    private TextView f5922f;
    private TextView f5923g;

    /* renamed from: com.antutu.benchmark.view.c.1 */
    class C16521 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1655c f5914a;

        C16521(C1655c c1655c) {
            this.f5914a = c1655c;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (Utils.isNetworkConnected(this.f5914a.f5917a)) {
                Methods.downloadFromGP(this.f5914a.f5917a, "market://details?id=com.antutu.benchmark.full");
                dialogInterface.dismiss();
                return;
            }
            Methods.showToast(this.f5914a.f5917a, (int) C1692R.string.network_error, 1);
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.view.c.2 */
    class C16532 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1655c f5915a;

        C16532(C1655c c1655c) {
            this.f5915a = c1655c;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.antutu.benchmark.view.c.3 */
    class C16543 implements DialogInterface.OnClickListener {
        final /* synthetic */ C1655c f5916a;

        C16543(C1655c c1655c) {
            this.f5916a = c1655c;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.content.DialogInterface r4, int r5) {
            /*
            r3 = this;
            r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0039 }
            r1 = "android.intent.action.VIEW";
            r2 = "market://details?id=com.antutu.benchmark.full";
            r2 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x0039 }
            r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0039 }
            r1 = r3.f5916a;	 Catch:{ Exception -> 0x0039 }
            r1 = r1.f5917a;	 Catch:{ Exception -> 0x0039 }
            r1 = com.antutu.utils.Utils.hasMarket(r1, r0);	 Catch:{ Exception -> 0x0039 }
            if (r1 != 0) goto L_0x002b;
        L_0x0019:
            r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r0.addFlags(r1);	 Catch:{ Exception -> 0x0039 }
            r1 = r3.f5916a;	 Catch:{ Exception -> 0x0039 }
            r1 = r1.f5917a;	 Catch:{ Exception -> 0x0039 }
            r1.startActivity(r0);	 Catch:{ Exception -> 0x0039 }
        L_0x0027:
            r4.dismiss();
        L_0x002a:
            return;
        L_0x002b:
            r0 = r3.f5916a;	 Catch:{ Exception -> 0x0039 }
            r0 = r0.f5917a;	 Catch:{ Exception -> 0x0039 }
            r1 = 2131165477; // 0x7f070125 float:1.7945172E38 double:1.052935648E-314;
            r2 = 0;
            com.antutu.utils.Methods.showToast(r0, r1, r2);	 Catch:{ Exception -> 0x0039 }
            goto L_0x0027;
        L_0x0039:
            r0 = move-exception;
            r1 = "hch";
            r0 = r0.getMessage();	 Catch:{ all -> 0x0047 }
            com.antutu.utils.MLog.m6865d(r1, r0);	 Catch:{ all -> 0x0047 }
            r4.dismiss();
            goto L_0x002a;
        L_0x0047:
            r0 = move-exception;
            r4.dismiss();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.antutu.benchmark.view.c.3.onClick(android.content.DialogInterface, int):void");
        }
    }

    public C1655c(Context context) {
        super(context);
        m6510a(context, null, 0);
    }

    private void m6509a() {
        int benchmarkScore = jni.benchmarkScore(this.f5917a, 39);
        int benchmarkScore2 = jni.benchmarkScore(this.f5917a, 40);
        int i = benchmarkScore + benchmarkScore2;
        if (benchmarkScore + benchmarkScore2 > 0) {
            this.f5920d.setVisibility(0);
            this.f5919c.setVisibility(8);
        } else {
            this.f5920d.setVisibility(8);
            this.f5919c.setVisibility(0);
        }
        String string = benchmarkScore > 0 ? benchmarkScore + BuildConfig.FLAVOR : this.f5917a.getString(C1082R.string.unsupported);
        this.f5921e.setText((benchmarkScore2 > 0 ? benchmarkScore2 + BuildConfig.FLAVOR : this.f5917a.getString(C1082R.string.unsupported)) + BuildConfig.FLAVOR);
        this.f5922f.setText(string + BuildConfig.FLAVOR);
        String string2 = i < 15000 ? this.f5917a.getString(C1082R.string.game_performance_0_desc) : (i < 15000 || i >= 25000) ? this.f5917a.getString(C1082R.string.game_performance_25000_desc) : this.f5917a.getString(C1082R.string.game_performance_15000_desc);
        this.f5923g.setText(this.f5917a.getString(C1082R.string.game_performance_device_desc, new Object[]{C1503b.m5915c().m5970w(), string2}));
    }

    private void m6510a(Context context, AttributeSet attributeSet, int i) {
        this.f5917a = context;
        View.inflate(context, C1082R.layout.item_home_3d_test, this);
        m6511b();
        m6509a();
        this.f5918b.setOnClickListener(this);
    }

    private void m6511b() {
        this.f5918b = (Button) findViewById(C1082R.id.btn_3d_test);
        this.f5919c = (LinearLayout) findViewById(C1082R.id.ll_not_tested_3d);
        this.f5920d = (LinearLayout) findViewById(C1082R.id.ll_tested_3d);
        this.f5921e = (TextView) findViewById(C1082R.id.tv_marooned_score);
        this.f5922f = (TextView) findViewById(C1082R.id.tv_garden_score);
        this.f5923g = (TextView) findViewById(C1082R.id.tv_device_name);
    }

    private void m6512c() {
        if (C1516b.m6022c(this.f5917a)) {
            MobclickAgent.onEvent(this.f5917a, MobclickAgentConstants.click_home_item_3d_test_has_plugin);
            Intent intent = new Intent();
            intent.setAction("com.antutu.benchmark.full.MAROONED_RUN");
            intent.setFlags(335544320);
            intent.setComponent(new ComponentName("com.antutu.benchmark.full", "com.antutu.benchmark.full.UnityPlayerActivity"));
            this.f5917a.startActivity(intent);
            return;
        }
        C1516b.m6010a(this.f5917a, 2);
        MobclickAgent.onEvent(this.f5917a, MobclickAgentConstants.click_home_item_3d_test_not_has_plugin);
        try {
            Builder builder;
            AlertDialog create;
            if (C1503b.m5915c().m5954k() == 1) {
                builder = new Builder(this.f5917a);
                builder.setTitle(C1082R.string.gp_download_3dplugin_title);
                builder.setMessage(C1082R.string.gp_download_3dplugin);
                builder.setNegativeButton(C1082R.string.download, new C16521(this));
                create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
                return;
            }
            builder = new Builder(this.f5917a);
            builder.setMessage(C1082R.string.need_download_3dplugin);
            builder.setNegativeButton(C1692R.string.cancel, new C16532(this));
            builder.setPositiveButton(C1082R.string.todownload, new C16543(this));
            create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Exception e) {
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.btn_3d_test /*2131624405*/:
                m6512c();
            default:
        }
    }
}
