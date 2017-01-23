package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import java.util.Calendar;

/* renamed from: android.support.v7.app.s */
class C0409s {
    private static final C0408a f1013a;
    private final Context f1014b;
    private final LocationManager f1015c;

    /* renamed from: android.support.v7.app.s.a */
    private static class C0408a {
        boolean f1007a;
        long f1008b;
        long f1009c;
        long f1010d;
        long f1011e;
        long f1012f;

        private C0408a() {
        }
    }

    static {
        f1013a = new C0408a();
    }

    C0409s(Context context) {
        this.f1014b = context;
        this.f1015c = (LocationManager) context.getSystemService(MsgConstant.KEY_LOCATION_PARAMS);
    }

    private Location m1136a(String str) {
        if (this.f1015c != null) {
            try {
                if (this.f1015c.isProviderEnabled(str)) {
                    return this.f1015c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private void m1137a(Location location) {
        long j;
        C0408a c0408a = f1013a;
        long currentTimeMillis = System.currentTimeMillis();
        C0406r a = C0406r.m1134a();
        a.m1135a(currentTimeMillis - C4156a.f13948j, location.getLatitude(), location.getLongitude());
        long j2 = a.f1004a;
        a.m1135a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1006c == 1;
        long j3 = a.f1005b;
        long j4 = a.f1004a;
        a.m1135a(C4156a.f13948j + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1005b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        c0408a.f1007a = z;
        c0408a.f1008b = j2;
        c0408a.f1009c = j3;
        c0408a.f1010d = j4;
        c0408a.f1011e = j5;
        c0408a.f1012f = j;
    }

    private boolean m1138a(C0408a c0408a) {
        return c0408a != null && c0408a.f1012f > System.currentTimeMillis();
    }

    private Location m1139b() {
        Location location = null;
        Location a = PermissionChecker.checkSelfPermission(this.f1014b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m1136a("network") : null;
        if (PermissionChecker.checkSelfPermission(this.f1014b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m1136a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    boolean m1140a() {
        C0408a c0408a = f1013a;
        if (m1138a(c0408a)) {
            return c0408a.f1007a;
        }
        Location b = m1139b();
        if (b != null) {
            m1137a(b);
            return c0408a.f1007a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
