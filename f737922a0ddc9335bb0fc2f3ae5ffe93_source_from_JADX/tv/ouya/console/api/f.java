package tv.ouya.console.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import bhu;
import bhu$a;
import bhy;
import java.util.ArrayList;
import java.util.List;

public class f implements ServiceConnection {
    private static final String[] DW;
    private static f FH;
    private static final String[] j6;
    private static boolean tp;
    private Context Hw;
    private boolean VH;
    private List<Runnable> Zo;
    private String gn;
    private b u7;
    private bhu v5;

    public enum a {
        OUYA,
        MOJO,
        UNKNOWN
    }

    public static class b {
        private String DW;
        private a FH;
        private boolean j6;

        b(boolean z, String str, a aVar) {
            this.j6 = z;
            this.DW = str;
            this.FH = aVar;
        }

        public boolean j6() {
            return this.j6;
        }
    }

    private class c extends i {
        private final Purchasable FH;
        final /* synthetic */ f j6;

        public c(f fVar, Purchasable purchasable, h<String> hVar) {
            this.j6 = fVar;
            super(hVar, "purchasing");
            this.FH = purchasable;
        }

        void j6() {
            this.j6.v5.j6(this.j6.gn, this.FH, new bhy(this.DW));
        }
    }

    private class d extends i {
        final /* synthetic */ f j6;

        private d(f fVar, h<String> hVar) {
            this.j6 = fVar;
            super(hVar, "fetching receipts");
        }

        void j6() {
            this.j6.v5.j6(this.j6.gn, new bhy(this.DW));
        }
    }

    static {
        j6 = new String[]{"value"};
        DW = new String[]{"property_name", "value"};
        FH = new f();
        tp = false;
    }

    public static f j6() {
        return FH;
    }

    f() {
        this.Zo = new ArrayList();
        Log.v("OUYAF", "ODK version number: 62");
    }

    public void j6(Context context, String str) {
        if (!FH()) {
            this.Hw = context.getApplicationContext();
            this.gn = str;
            Intent intent = new Intent("tv.ouya.ODK_INITIALIZED");
            intent.putExtra("package_name", context.getPackageName());
            this.Hw.sendBroadcast(intent);
        }
    }

    public void DW() {
        if (this.Hw != null) {
            if (this.v5 != null) {
                this.Hw.unbindService(this);
                this.v5 = null;
                this.VH = false;
            }
            Intent intent = new Intent("tv.ouya.ODK_SHUTDOWN");
            intent.putExtra("package_name", this.Hw.getPackageName());
            this.Hw.sendBroadcast(intent);
            this.Hw = null;
        }
    }

    public boolean FH() {
        return this.Hw != null;
    }

    public b Hw() {
        if (this.u7 == null) {
            if (FH()) {
                Intent registerReceiver = this.Hw.registerReceiver(null, new IntentFilter("tv.ouya.DEVICE_INFO_ACTION"));
                if (registerReceiver == null) {
                    return new b(false, "unknown", a.UNKNOWN);
                }
                boolean booleanExtra = registerReceiver.getBooleanExtra("SUPPORTED_DEVICE", false);
                String stringExtra = registerReceiver.getStringExtra("DEVICE_NAME");
                String stringExtra2 = registerReceiver.getStringExtra("DEVICE_ENUM");
                a aVar = a.UNKNOWN;
                try {
                    aVar = a.valueOf(stringExtra2);
                } catch (Exception e) {
                    Log.w("OUYAF", "Error looking up deviceEnum for: " + stringExtra2);
                }
                this.u7 = new b(booleanExtra, stringExtra, aVar);
            } else {
                throw new RuntimeException("Must call OuyaFacade.init first");
            }
        }
        return this.u7;
    }

    public boolean v5() {
        return Hw().j6();
    }

    public void j6(Purchasable purchasable, h<String> hVar) {
        j6(new c(this, purchasable, hVar));
    }

    public void j6(h<String> hVar) {
        j6(new d(hVar, null));
    }

    private void j6(Runnable runnable) {
        Zo();
        if (this.v5 != null) {
            runnable.run();
        } else {
            this.Zo.add(runnable);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("inAppPurchase", "Successfully bound to IapService");
        this.v5 = bhu$a.j6(iBinder);
        while (this.Zo.size() > 0) {
            ((Runnable) this.Zo.remove(0)).run();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.v5 = null;
        this.VH = false;
    }

    void Zo() {
        if (this.Hw == null) {
            Log.e("OUYAF", "Dropping request because connect has been shut down");
        } else if (!this.VH) {
            Log.d("inAppPurchase", "Binding to IapService");
            Intent intent = new Intent();
            intent.setClassName("tv.ouya", "tv.ouya.console.service.iap.IapService");
            this.Hw.bindService(intent, this, 1);
            this.VH = true;
        }
    }
}
