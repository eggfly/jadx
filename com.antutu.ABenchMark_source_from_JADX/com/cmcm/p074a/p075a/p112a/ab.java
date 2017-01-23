package com.cmcm.p074a.p075a.p112a;

import android.app.AppOpsManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import java.util.List;

/* renamed from: com.cmcm.a.a.a.ab */
public class ab implements LocationListener {
    private C2132y f7410a;
    private Location f7411b;
    private C2109c f7412c;

    private boolean m7926a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private void m7927b() {
        if (this.f7410a != null) {
            this.f7410a.m8061a(this.f7411b);
        }
        m7928a();
    }

    public void m7928a() {
        if (this.f7410a != null) {
            this.f7410a = null;
            this.f7412c.m7953b();
            this.f7412c = null;
            this.f7411b = null;
            try {
                ((LocationManager) C2126s.m8041c().getSystemService(MsgConstant.KEY_LOCATION_PARAMS)).removeUpdates(this);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public void m7929a(C2132y c2132y) {
        if (c2132y == null) {
            throw new AssertionError();
        }
        m7928a();
        Context c = C2126s.m8041c();
        if (VERSION.SDK_INT >= 19) {
            try {
                if (((AppOpsManager) c.getSystemService("appops")).checkOp("android:fine_location", Process.myUid(), c.getPackageName()) != 0) {
                    c2132y.m8061a(null);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f7410a = c2132y;
        this.f7412c = new C2109c(1);
        this.f7412c.m7951a(new ac(this), 120000);
        try {
            LocationManager locationManager = (LocationManager) c.getSystemService(MsgConstant.KEY_LOCATION_PARAMS);
            List allProviders = locationManager.getAllProviders();
            if (allProviders.contains("gps")) {
                this.f7411b = locationManager.getLastKnownLocation("gps");
                locationManager.requestLocationUpdates("gps", 10000, 1000.0f, this);
            }
            if (allProviders.contains("network")) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation != null && m7930a(lastKnownLocation, this.f7411b)) {
                    this.f7411b = lastKnownLocation;
                }
                locationManager.requestLocationUpdates("network", 10000, 1000.0f, this);
            }
        } catch (SecurityException e) {
            m7927b();
            e.printStackTrace();
        } catch (Exception e2) {
            m7927b();
            e2.printStackTrace();
        }
    }

    protected boolean m7930a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        return !(accuracy < 0) ? (!z3 || (accuracy > 0)) ? z3 && !(accuracy > Constants.COMMAND_HANDSHAKE) && m7926a(location.getProvider(), location2.getProvider()) : true : true;
    }

    public void onLocationChanged(Location location) {
        if ("gps".equals(location.getProvider())) {
            this.f7411b = location;
            m7927b();
        } else if (m7930a(location, this.f7411b)) {
            this.f7411b = location;
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
