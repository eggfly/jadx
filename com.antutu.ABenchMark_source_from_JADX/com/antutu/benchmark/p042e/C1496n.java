package com.antutu.benchmark.p042e;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.BenchmarkService;
import com.antutu.benchmark.activity.MainActivity;
import com.antutu.benchmark.activity.ScoreBenchActivity;
import com.antutu.benchmark.activity.WebTestActivity;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p038b.C1341f;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.redacc.C1692R;
import com.antutu.utils.BackgroundApps;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.antutu.utils.Utils;
import com.antutu.utils.widget.WebBrowserActivity;
import com.facebook.ads.AdError;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.e.n */
public class C1496n extends C1338c implements OnClickListener {
    private static BackgroundApps f5100f;
    private CheckBox f5101b;
    private View f5102c;
    private int f5103d;
    private int f5104e;
    private BroadcastReceiver f5105g;
    private int f5106h;

    /* renamed from: com.antutu.benchmark.e.n.1 */
    class C14941 implements OnClickListener {
        final /* synthetic */ C1496n f5098a;

        C14941(C1496n c1496n) {
            this.f5098a = c1496n;
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: com.antutu.benchmark.e.n.2 */
    static class C14952 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context f5099a;

        C14952(Context context) {
            this.f5099a = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
            intent.setFlags(270532608);
            this.f5099a.startActivity(intent);
        }
    }

    static {
        f5100f = new BackgroundApps();
    }

    private static void m5897a(Activity activity, int i, boolean z) {
        String str = BuildConfig.FLAVOR;
        str = f5100f.getAppList();
        if (str.length() > 5) {
            activity.getString(C1082R.string.sec_app_tip) + "\n" + str;
        }
        Intent intent = new Intent(activity, ScoreBenchActivity.class);
        intent.setFlags(335544320);
        intent.putExtra("startBench", true);
        activity.startActivity(intent);
        activity.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
        if (!(activity instanceof MainActivity)) {
            activity.finish();
        }
    }

    public static void m5898a(Activity activity, boolean z) {
        try {
            if (!C1496n.m5900a((Context) activity)) {
                return;
            }
            if ((C1503b.f5113a & 2) == 0 || C1516b.m6022c((Context) activity)) {
                C1496n.m5897a(activity, 0, z);
                return;
            }
            try {
                Toast makeText = Toast.makeText(activity, activity.getString(C1082R.string.a3d_wait), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }

    private void m5899a(View view) {
        this.f5102c = view.findViewById(C1082R.id.start_test_region);
        this.f5101b = (CheckBox) view.findViewById(C1082R.id.check_mem_optimization);
        this.f5102c.setOnClickListener(this);
        view.findViewById(C1082R.id.test_html5).setOnClickListener(this);
        view.findViewById(C1082R.id.test_battery).setOnClickListener(this);
        view.findViewById(C1082R.id.test_video).setOnClickListener(this);
        View findViewById = view.findViewById(C1082R.id.test_stability);
        ((TextView) findViewById.findViewById(C1082R.id.test_stability_img)).setBackgroundResource(C1082R.drawable.btn_64bit);
        ((TextView) findViewById.findViewById(C1082R.id.test_stability_text)).setText(C1082R.string.test_64bit_name);
        findViewById.setOnClickListener(new C14941(this));
        OnTouchListener c1341f = new C1341f(this.a);
        c1341f.m5400a(this);
        view.setOnTouchListener(c1341f);
    }

    static boolean m5900a(Context context) {
        try {
            if (System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0) {
                C1496n.m5901b(context);
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    private static void m5901b(Context context) {
        new Builder(context).setTitle(C1082R.string.always_finish_title).setMessage(C1082R.string.always_finish_info).setPositiveButton(C1692R.string.confirm, new C14952(context)).show();
    }

    private void m5902c() {
        if (!BenchmarkService.m4822g()) {
            startActivity(new Intent(getActivity(), WebTestActivity.class));
        }
    }

    private void m5903d() {
        if (Methods.hasInstalled("com.antutu.tester")) {
            Methods.openApp("com.antutu.tester", "com.antutu.tester.HardMainPage");
        } else if (!Utils.isNetworkConnected(this.a)) {
            Methods.showToast(this.a, (int) C1082R.string.prompt_net, (int) AdError.NETWORK_ERROR_CODE);
        } else if (C1503b.m5915c().m5954k() == 1) {
            Methods.downloadFromGP(this.a, "market://details?id=com.antutu.tester");
        } else {
            WebBrowserActivity.openURL(this.a, "http://soft.antutu.net/soft/antutu-tester.apk", getString(C1082R.string.power_test_title));
        }
    }

    private void m5904e() {
        if (Methods.hasInstalled("com.antutu.videobench")) {
            Methods.openApp("com.antutu.videobench", "com.antutu.videobench.activity.VideoMainActivity");
        } else if (!Utils.isNetworkConnected(this.a)) {
            Methods.showToast(this.a, (int) C1082R.string.prompt_net, (int) AdError.NETWORK_ERROR_CODE);
        } else if (C1503b.m5915c().m5954k() == 1) {
            Methods.downloadFromGP(this.a, "market://details?id=com.antutu.videobench");
        } else {
            WebBrowserActivity.openURL(this.a, "http://soft.antutu.net/soft/antutu-videobench.apk", getString(C1082R.string.video_test_name));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.start_test_region /*2131624370*/:
                MLog.m6865d("TestFragment", "start test....");
                PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_CUSTOMTEST);
                C1496n.m5898a(this.a, this.f5101b.isChecked());
            case C1082R.id.test_html5 /*2131624562*/:
                PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_HTML5TEST);
                m5902c();
            case C1082R.id.test_battery /*2131624566*/:
                PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_BATTERYTEST);
                m5903d();
            case C1082R.id.test_video /*2131624569*/:
                PointMark.getInstance(ABenchmarkApplication.getContext()).pointThis(PointMark.E_VIDEOTEST);
                m5904e();
            default:
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1503b.f5113a = 31;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.test_layout, viewGroup, false);
        m5899a(inflate);
        if (f5100f == null) {
            f5100f = new BackgroundApps();
        }
        f5100f.checkRunningApps(viewGroup.getContext());
        this.f5103d = getResources().getDimensionPixelSize(C1082R.dimen.choose_test_paddingTop);
        this.f5104e = getResources().getDimensionPixelSize(C1082R.dimen.choose_test_paddingLeft);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        MLog.m6865d("TestFragment", "hzd, onDestroy");
    }

    public void onResume() {
        super.onResume();
        if (this.f5106h < 0) {
            if (getResources().getConfiguration().orientation == 2) {
                if (((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
                    this.f5106h = 8;
                } else {
                    this.f5106h = 0;
                }
            } else if (getResources().getConfiguration().orientation == 1) {
                this.f5106h = 1;
            } else {
                this.f5106h = 5;
            }
        }
        this.a.setRequestedOrientation(this.f5106h);
    }

    public void onStart() {
        super.onStart();
        MLog.m6865d("TestFragment", "hzd, onStart...");
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.f5105g != null) {
                this.a.unregisterReceiver(this.f5105g);
            }
        } catch (Exception e) {
        }
    }
}
