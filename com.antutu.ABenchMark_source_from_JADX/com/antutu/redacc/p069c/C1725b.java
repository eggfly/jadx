package com.antutu.redacc.p069c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p066a.C1698b;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p072e.C1737a;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.antutu.redacc.c.b */
public class C1725b extends C1719a {
    protected Activity f6110b;
    Handler f6111c;
    private GridView f6112d;
    private View f6113e;
    private View f6114f;
    private View f6115g;
    private SharedPreferences f6116h;
    private boolean f6117i;
    private int f6118j;
    private BroadcastReceiver f6119k;
    private View f6120l;
    private boolean f6121m;
    private C1698b f6122n;
    private boolean f6123o;
    private String f6124p;
    private Uri f6125q;
    private TextView f6126r;
    private ImageView f6127s;
    private View f6128t;
    private View f6129u;

    /* renamed from: com.antutu.redacc.c.b.1 */
    class C17201 implements OnItemClickListener {
        final /* synthetic */ C1725b f6105a;

        C17201(C1725b c1725b) {
            this.f6105a = c1725b;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f6105a.m6671a(view.getContext(), i, false);
        }
    }

    /* renamed from: com.antutu.redacc.c.b.2 */
    class C17212 extends Handler {
        final /* synthetic */ C1725b f6106a;

        C17212(C1725b c1725b) {
            this.f6106a = c1725b;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                C1762r.m6776e().m6793b(this.f6106a.f6110b, this.f6106a.f6120l);
            } else if (message.what == 1) {
                this.f6106a.m6680c();
            } else if (message.what == 2) {
                this.f6106a.f6110b.finish();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.antutu.redacc.c.b.3 */
    class C17233 extends BroadcastReceiver {
        final /* synthetic */ C1725b f6108a;

        /* renamed from: com.antutu.redacc.c.b.3.1 */
        class C17221 extends Thread {
            final /* synthetic */ C17233 f6107a;

            C17221(C17233 c17233) {
                this.f6107a = c17233;
            }

            public void run() {
                try {
                    C1762r.m6776e().m6807i();
                } catch (Exception e) {
                }
                super.run();
            }
        }

        C17233(C1725b c1725b) {
            this.f6108a = c1725b;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action.equals("MSG_BR_ON_BTN_OPT_CLICK")) {
                    try {
                        int intExtra = intent.getIntExtra(AgooConstants.MESSAGE_ID, -1);
                        if (intExtra >= 0) {
                            this.f6108a.m6671a(this.f6108a.getContext(), intExtra, true);
                        }
                    } catch (Exception e) {
                    }
                } else if (action.equals("MSG_BR_ON_DLG_OPT_CLICK")) {
                    this.f6108a.f6118j = 1;
                    new C1724a(this.f6108a).execute(new Integer[]{Integer.valueOf(this.f6108a.f6118j)});
                } else if (action.equals("MSG_BR_ON_NOTIFY_CHANGE")) {
                    if (!this.f6108a.f6116h.getBoolean("background_service", true)) {
                    }
                } else if (action.equals("MSG_BR_REFRESH_LIST")) {
                    if (this.f6108a.f6117i) {
                        this.f6108a.f6118j = 0;
                        new C1724a(this.f6108a).execute(new Integer[]{Integer.valueOf(0)});
                    }
                } else if (action.equals("MSG_BR_ON_WMODE_CHANGE")) {
                    action = "root";
                    if (this.f6108a.f6116h.getString("work_mode", action).equals(action)) {
                        C1762r.m6776e().m6794b(true);
                        new C17221(this).start();
                        return;
                    }
                    C1762r.m6776e().m6794b(false);
                    C1762r.m6776e().m6786a(context, this.f6108a.f6120l);
                } else if (action.equals("MSG_BR_ON_KILL_APP") && this.f6108a.f6121m) {
                    this.f6108a.m6674a(intent.getStringExtra(Constants.KEY_ELECTION_PKG));
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: com.antutu.redacc.c.b.a */
    class C1724a extends AsyncTask<Integer, Integer, String> {
        final /* synthetic */ C1725b f6109a;

        C1724a(C1725b c1725b) {
            this.f6109a = c1725b;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected java.lang.String m6665a(java.lang.Integer... r9) {
            /*
            r8 = this;
            r0 = 1;
            r1 = 0;
            r2 = 0;
            r2 = r9[r2];	 Catch:{ Exception -> 0x0062 }
            r2 = r2.intValue();	 Catch:{ Exception -> 0x0062 }
            r3 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r4 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r4 = r4.f6110b;	 Catch:{ Exception -> 0x0062 }
            r3.m6804g(r4);	 Catch:{ Exception -> 0x0062 }
            r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0062 }
            r4 = 21;
            if (r3 >= r4) goto L_0x0054;
        L_0x001a:
            r3 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r4 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r4 = r4.f6110b;	 Catch:{ Exception -> 0x0062 }
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r3.m6783a(r4, r5, r6, r7);	 Catch:{ Exception -> 0x0062 }
        L_0x0028:
            if (r2 != r0) goto L_0x008c;
        L_0x002a:
            r2 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r2 = r2.m6798c();	 Catch:{ Exception -> 0x0062 }
            if (r2 == 0) goto L_0x0064;
        L_0x0034:
            r1 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r2 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r2 = r2.f6110b;	 Catch:{ Exception -> 0x0062 }
            r3 = 1200; // 0x4b0 float:1.682E-42 double:5.93E-321;
            r1.m6780a(r2, r3);	 Catch:{ Exception -> 0x0062 }
        L_0x0041:
            if (r0 == 0) goto L_0x0051;
        L_0x0043:
            r0 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r0 = r0.m6809k();	 Catch:{ Exception -> 0x0062 }
            r0 = r0.isEmpty();	 Catch:{ Exception -> 0x0062 }
            if (r0 != 0) goto L_0x0051;
        L_0x0051:
            r0 = "";
            return r0;
        L_0x0054:
            r3 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r4 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r4 = r4.f6110b;	 Catch:{ Exception -> 0x0062 }
            r5 = 1;
            r6 = 0;
            r3.m6782a(r4, r5, r6);	 Catch:{ Exception -> 0x0062 }
            goto L_0x0028;
        L_0x0062:
            r0 = move-exception;
            goto L_0x0051;
        L_0x0064:
            r2 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r2 = r2.m6800d();	 Catch:{ Exception -> 0x0062 }
            if (r2 == 0) goto L_0x0082;
        L_0x006e:
            r1 = com.antutu.redacc.p067f.C1762r.m6776e();	 Catch:{ Exception -> 0x0062 }
            r2 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r2 = r2.f6110b;	 Catch:{ Exception -> 0x0062 }
            r3 = 0;
            r1.m6781a(r2, r3);	 Catch:{ Exception -> 0x0062 }
        L_0x007a:
            r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            java.lang.Thread.sleep(r2);	 Catch:{ Exception -> 0x0080 }
            goto L_0x0041;
        L_0x0080:
            r1 = move-exception;
            goto L_0x0041;
        L_0x0082:
            r0 = r8.f6109a;	 Catch:{ Exception -> 0x0062 }
            r0 = r0.f6111c;	 Catch:{ Exception -> 0x0062 }
            r2 = 0;
            r0.sendEmptyMessage(r2);	 Catch:{ Exception -> 0x0062 }
            r0 = r1;
            goto L_0x007a;
        L_0x008c:
            r0 = r1;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.antutu.redacc.c.b.a.a(java.lang.Integer[]):java.lang.String");
        }

        protected void m6666a(String str) {
            this.f6109a.f6121m = false;
            if (this.f6109a.f6118j == 1) {
                this.f6109a.m6684e();
            } else {
                this.f6109a.f6112d.setVisibility(0);
            }
            List f = C1762r.m6776e().m6803f();
            try {
                this.f6109a.f6122n = new C1698b(this.f6109a.f6112d.getContext(), f);
                this.f6109a.f6112d.setAdapter(this.f6109a.f6122n);
                this.f6109a.f6122n.notifyDataSetChanged();
            } catch (Exception e) {
            }
            if (f.size() > 0) {
                this.f6109a.f6113e.setVisibility(8);
            } else {
                this.f6109a.f6113e.setVisibility(0);
            }
            this.f6109a.f6112d.setEnabled(true);
            this.f6109a.f6114f.setVisibility(8);
            this.f6109a.f6117i = true;
            if (this.f6109a.f6118j == 1) {
                this.f6109a.f6111c.sendEmptyMessage(2);
            }
            super.onPostExecute(str);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6665a((Integer[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6666a((String) obj);
        }

        protected void onPreExecute() {
            this.f6109a.f6117i = false;
            this.f6109a.f6112d.setEnabled(false);
            this.f6109a.f6113e.setVisibility(8);
            if (this.f6109a.f6118j == 1) {
                this.f6109a.m6681d();
            } else {
                this.f6109a.f6112d.setVisibility(4);
                this.f6109a.f6114f.setVisibility(0);
            }
            this.f6109a.f6121m = true;
            super.onPreExecute();
        }
    }

    public C1725b() {
        this.f6115g = null;
        this.f6117i = true;
        this.f6118j = 0;
        this.f6119k = null;
        this.f6120l = null;
        this.f6121m = false;
        this.f6122n = null;
        this.f6111c = new C17212(this);
        this.f6123o = false;
        this.f6124p = BuildConfig.FLAVOR;
        this.f6125q = null;
        this.f6126r = null;
        this.f6127s = null;
        this.f6128t = null;
        this.f6129u = null;
    }

    private void m6670a() {
        if (this.f6116h.getBoolean("show_tips_ex", true)) {
            C1731d.m6693a(this.f6110b);
            return;
        }
        this.f6118j = 1;
        new C1724a(this).execute(new Integer[]{Integer.valueOf(this.f6118j)});
    }

    private void m6671a(Context context, int i, boolean z) {
        Object obj = 1;
        try {
            List f = C1762r.m6776e().m6803f();
            for (int i2 = 0; i2 < f.size(); i2++) {
                C1737a c1737a = (C1737a) f.get(i2);
                if (c1737a.m6721i().equalsIgnoreCase("com.tencent.mm")) {
                    Log.e("weixin", "weixin");
                }
                if (i2 == i) {
                    if (!c1737a.m6717e()) {
                        obj = null;
                    }
                    c1737a.m6707a(true);
                } else {
                    c1737a.m6707a(false);
                }
                C1762r.m6776e().m6789a(context, c1737a.m6721i(), c1737a.m6718f(), c1737a.m6717e());
            }
            if (obj == null) {
                if (this.f6116h.getBoolean("show_tips_ex", true)) {
                    if (!z) {
                        C1731d.m6693a(this.f6110b);
                    }
                } else if (this.f6116h.getBoolean("background_service", true)) {
                }
                this.f6122n.notifyDataSetChanged();
            }
            if (z) {
                m6670a();
            }
        } catch (Exception e) {
        }
    }

    private void m6674a(String str) {
        try {
            if (str.equals("com.android.settings")) {
                this.f6123o = true;
                this.f6111c.sendEmptyMessage(1);
                return;
            }
            PackageManager packageManager = this.f6110b.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            this.f6124p = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            this.f6125q = C1762r.m6776e().m6784a(str, packageInfo.applicationInfo.icon);
            this.f6111c.sendEmptyMessage(1);
        } catch (Exception e) {
        }
    }

    private void m6677b() {
        try {
            this.f6119k = new C17233(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("MSG_BR_ON_WMODE_CHANGE");
            intentFilter.addAction("MSG_BR_ON_BTN_OPT_CLICK");
            intentFilter.addAction("MSG_BR_ON_DLG_OPT_CLICK");
            intentFilter.addAction("MSG_BR_REFRESH_LIST");
            intentFilter.addAction("MSG_BR_ON_NOTIFY_CHANGE");
            intentFilter.addAction("MSG_BR_ON_KILL_APP");
            this.f6110b.registerReceiver(this.f6119k, intentFilter);
        } catch (Exception e) {
        }
    }

    private void m6680c() {
        try {
            if (!this.f6121m) {
                return;
            }
            if (this.f6123o) {
                this.f6128t.setVisibility(8);
                this.f6126r.setVisibility(8);
                this.f6127s.setVisibility(8);
                this.f6129u.setVisibility(0);
                return;
            }
            this.f6126r.setText(this.f6124p);
            this.f6127s.setImageURI(this.f6125q);
        } catch (Exception e) {
        }
    }

    private void m6681d() {
        try {
            this.f6115g = ((LayoutInflater) this.f6110b.getSystemService("layout_inflater")).inflate(C1692R.layout.float_view_icon, null);
            this.f6126r = (TextView) this.f6115g.findViewById(C1692R.id.appName);
            this.f6127s = (ImageView) this.f6115g.findViewById(C1692R.id.appIcon);
            this.f6128t = this.f6115g.findViewById(C1692R.id.progressView);
            this.f6129u = this.f6115g.findViewById(C1692R.id.finishView);
            this.f6123o = false;
            WindowManager windowManager = (WindowManager) this.f6110b.getApplicationContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2005;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.width = -1;
            layoutParams.height = -1;
            windowManager.addView(this.f6115g, layoutParams);
        } catch (Exception e) {
        }
    }

    private void m6684e() {
        try {
            if (this.f6115g != null) {
                ((WindowManager) this.f6110b.getSystemService("window")).removeView(this.f6115g);
                this.f6115g = null;
            }
        } catch (Exception e) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6110b = getActivity();
        this.f6116h = PreferenceManager.getDefaultSharedPreferences(this.f6110b);
        try {
            this.f6120l = ((LayoutInflater) this.f6110b.getSystemService("layout_inflater")).inflate(C1692R.layout.toast_view, null);
            ((TextView) this.f6120l.findViewById(C1692R.id.info)).setText(String.format(getString(C1692R.string.accessibility_enable), new Object[]{getString(C1692R.string.app_name)}));
        } catch (Exception e) {
        }
        m6677b();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1692R.layout.fragment_home_red, viewGroup, false);
        this.f6112d = (GridView) inflate.findViewById(C1692R.id.gridViewApp);
        this.f6113e = inflate.findViewById(C1692R.id.textNoApp);
        this.f6114f = inflate.findViewById(C1692R.id.layoutProgress);
        this.f6112d.setOnItemClickListener(new C17201(this));
        this.f6117i = true;
        this.f6118j = 0;
        new C1724a(this).execute(new Integer[]{Integer.valueOf(this.f6118j)});
        return inflate;
    }

    public void onDestroy() {
        try {
            m6684e();
            if (this.f6119k != null) {
                this.f6110b.unregisterReceiver(this.f6119k);
            }
            this.f6119k = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("Home");
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("Home");
    }
}
