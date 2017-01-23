package com.antutu.redacc.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p072e.C1737a;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;

public class OptimizeService extends Service {
    Handler f6235a;
    private View f6236b;
    private boolean f6237c;
    private String f6238d;
    private BroadcastReceiver f6239e;
    private boolean f6240f;
    private boolean f6241g;
    private String f6242h;
    private Uri f6243i;
    private TextView f6244j;
    private ImageView f6245k;
    private View f6246l;
    private View f6247m;

    /* renamed from: com.antutu.redacc.service.OptimizeService.1 */
    class C17661 extends Thread {
        final /* synthetic */ Context f6231a;
        final /* synthetic */ OptimizeService f6232b;

        C17661(OptimizeService optimizeService, Context context) {
            this.f6232b = optimizeService;
            this.f6231a = context;
        }

        public void run() {
            try {
                this.f6232b.f6241g = true;
                if ((VERSION.SDK_INT < 21 ? C1762r.m6776e().m6783a(this.f6231a, false, false, false) : C1762r.m6776e().m6782a(this.f6231a, true, false)) > 0) {
                    this.f6232b.f6235a.sendEmptyMessage(1);
                    if (this.f6232b.f6237c) {
                        C1762r.m6776e().m6780a(this.f6231a, 900);
                    } else {
                        C1762r.m6776e().m6781a(this.f6231a, true);
                    }
                    String k = C1762r.m6776e().m6809k();
                    if (!k.isEmpty()) {
                        C1762r.m6776e().m6788a(this.f6232b.getApplicationContext(), k);
                    }
                    try {
                        C17661.sleep(1000);
                    } catch (Exception e) {
                    }
                }
                this.f6232b.m6819a();
            } catch (Exception e2) {
                this.f6232b.m6819a();
            }
            this.f6232b.stopSelf();
            super.run();
        }
    }

    /* renamed from: com.antutu.redacc.service.OptimizeService.2 */
    class C17672 extends Handler {
        final /* synthetic */ OptimizeService f6233a;

        C17672(OptimizeService optimizeService) {
            this.f6233a = optimizeService;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f6233a.m6831e();
            } else if (message.what == 1) {
                this.f6233a.m6829d();
            } else if (message.what == 2) {
                this.f6233a.m6827c();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.antutu.redacc.service.OptimizeService.3 */
    class C17683 extends BroadcastReceiver {
        final /* synthetic */ OptimizeService f6234a;

        C17683(OptimizeService optimizeService) {
            this.f6234a = optimizeService;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("MSG_BR_ON_KILL_APP") && this.f6234a.f6241g) {
                    this.f6234a.m6822a(intent.getStringExtra(Constants.KEY_ELECTION_PKG));
                }
            } catch (Exception e) {
            }
        }
    }

    public OptimizeService() {
        this.f6236b = null;
        this.f6237c = false;
        this.f6238d = "root";
        this.f6239e = null;
        this.f6235a = new C17672(this);
        this.f6240f = false;
        this.f6241g = false;
        this.f6242h = BuildConfig.FLAVOR;
        this.f6243i = null;
        this.f6244j = null;
        this.f6245k = null;
        this.f6246l = null;
        this.f6247m = null;
    }

    private void m6819a() {
        this.f6241g = false;
        sendBroadcast(new Intent().setAction("MSG_BR_ON_OPT_FINISH").setPackage(getPackageName()));
        this.f6235a.sendEmptyMessage(0);
    }

    public static void m6820a(Context context) {
        try {
            context.startService(new Intent("com.antutu.redacc.service.OPTIMIZE", null, context, OptimizeService.class));
        } catch (Exception e) {
        }
    }

    private void m6822a(String str) {
        try {
            if (str.equals("com.android.settings")) {
                this.f6240f = true;
                sendBroadcast(new Intent().setAction("MSG_BR_ON_OPT_FINISH").setPackage(getPackageName()));
                C1737a j = C1762r.m6776e().m6808j();
                this.f6242h = j.m6718f();
                this.f6243i = j.m6716d();
                this.f6235a.sendEmptyMessage(2);
                return;
            }
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            this.f6242h = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            this.f6243i = C1762r.m6776e().m6784a(str, packageInfo.applicationInfo.icon);
            this.f6235a.sendEmptyMessage(2);
        } catch (Exception e) {
        }
    }

    private void m6825b() {
        try {
            this.f6239e = new C17683(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("MSG_BR_ON_KILL_APP");
            registerReceiver(this.f6239e, intentFilter);
        } catch (Exception e) {
        }
    }

    private void m6827c() {
        try {
            if (this.f6241g) {
                this.f6244j.setText(this.f6242h);
                this.f6245k.setImageURI(this.f6243i);
                if (this.f6240f) {
                    this.f6246l.setVisibility(8);
                    this.f6247m.setVisibility(0);
                }
            }
        } catch (Exception e) {
        }
    }

    private void m6829d() {
        try {
            this.f6236b = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1692R.layout.float_view_icon, null);
            this.f6244j = (TextView) this.f6236b.findViewById(C1692R.id.appName);
            this.f6245k = (ImageView) this.f6236b.findViewById(C1692R.id.appIcon);
            this.f6246l = this.f6236b.findViewById(C1692R.id.progressView);
            this.f6247m = this.f6236b.findViewById(C1692R.id.finishView);
            this.f6240f = false;
            WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2005;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.width = -1;
            layoutParams.height = -1;
            windowManager.addView(this.f6236b, layoutParams);
        } catch (Exception e) {
        }
    }

    private void m6831e() {
        try {
            if (this.f6236b != null) {
                ((WindowManager) getSystemService("window")).removeView(this.f6236b);
                this.f6236b = null;
            }
        } catch (Exception e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C1762r.m6776e().m6785a((Context) this);
    }

    public void onDestroy() {
        try {
            m6831e();
            if (this.f6239e != null) {
                unregisterReceiver(this.f6239e);
            }
            this.f6239e = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            if (intent.getAction().equals("com.antutu.redacc.service.OPTIMIZE")) {
                m6825b();
                Context applicationContext = getApplicationContext();
                this.f6237c = PreferenceManager.getDefaultSharedPreferences(this).getString("work_mode", this.f6238d).equals(this.f6238d);
                new C17661(this, applicationContext).start();
            }
        } catch (Exception e) {
        }
        return super.onStartCommand(intent, 3, i2);
    }
}
