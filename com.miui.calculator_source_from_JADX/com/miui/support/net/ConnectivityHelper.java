package com.miui.support.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.miui.support.internal.variable.Android_Net_ConnectivityManager_class.Factory;
import com.miui.support.util.AppConstants;
import com.miui.support.util.SoftReferenceSingleton;

public class ConnectivityHelper {
    private static final SoftReferenceSingleton<ConnectivityHelper> f3388a;
    private Context f3389b;
    private ConnectivityManager f3390c;
    private WifiManager f3391d;
    private String f3392e;

    /* renamed from: com.miui.support.net.ConnectivityHelper.1 */
    final class C04061 extends SoftReferenceSingleton<ConnectivityHelper> {
        C04061() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5081a();
        }

        protected ConnectivityHelper m5081a() {
            return new ConnectivityHelper();
        }
    }

    static {
        f3388a = new C04061();
    }

    public static ConnectivityHelper m5082a() {
        return (ConnectivityHelper) f3388a.get();
    }

    private ConnectivityHelper() {
        this.f3389b = AppConstants.m4227a();
        this.f3390c = (ConnectivityManager) this.f3389b.getSystemService("connectivity");
    }

    public String m5083b() {
        if (this.f3392e != null) {
            return this.f3392e;
        }
        try {
            this.f3392e = this.f3389b.createPackageContext("com.miui.core", 2).getSharedPreferences("public", 1).getString("mac_address", null);
        } catch (Throwable e) {
            Log.e("ConnectivityHelper", "Fail to getMacAddress", e);
        }
        if (this.f3392e == null) {
            if (this.f3391d == null) {
                this.f3391d = (WifiManager) this.f3389b.getSystemService("wifi");
            }
            WifiInfo connectionInfo = this.f3391d.getConnectionInfo();
            if (connectionInfo != null) {
                this.f3392e = connectionInfo.getMacAddress();
            }
        }
        return this.f3392e;
    }

    public boolean m5084c() {
        if (Factory.getInstance().get().isNetworkSupported(this.f3390c, 0)) {
            return false;
        }
        return true;
    }
}
