package com.miui.calculator.common.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocationGetter {
    private static LocationGetter f1541a;
    private String f1542b;
    private String f1543c;
    private String f1544d;
    private Location f1545e;
    private Context f1546f;
    private LocationManager f1547g;
    private LocationListener f1548h;
    private LocationListener f1549i;

    /* renamed from: com.miui.calculator.common.utils.LocationGetter.1 */
    class C01761 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ LocatedCallback f1538a;
        final /* synthetic */ LocationGetter f1539b;

        C01761(LocationGetter locationGetter, LocatedCallback locatedCallback) {
            this.f1539b = locationGetter;
            this.f1538a = locatedCallback;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2845a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m2846a((Void) obj);
        }

        protected Void m2845a(Void... voidArr) {
            long currentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTimeMillis < 20000 && this.f1539b.f1545e == null) {
                synchronized (this.f1539b) {
                    if (this.f1539b.f1547g != null) {
                        this.f1539b.f1545e = this.f1539b.f1547g.getLastKnownLocation("gps");
                        if (this.f1539b.f1545e == null) {
                            this.f1539b.f1545e = this.f1539b.f1547g.getLastKnownLocation("network");
                        }
                    }
                }
                synchronized (this) {
                    if (this.f1539b.f1545e == null) {
                        try {
                            wait(50);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
            if (this.f1539b.f1545e != null) {
                try {
                    Object a = NetRequestor.m2866a("https://weatherapi.market.xiaomi.com/wtr-v3/location/city/geo?latitude=" + this.f1539b.f1545e.getLatitude() + "&longitude=" + this.f1539b.f1545e.getLongitude() + "&locale=zh_CN&appKey=" + "weather20151024&sign=zUFJoAR2ZVrDy1vF3D07", (int) (20000 - (System.currentTimeMillis() - currentTimeMillis)));
                    if (!TextUtils.isEmpty(a)) {
                        JSONObject jSONObject = new JSONArray(a).getJSONObject(0);
                        this.f1539b.f1542b = jSONObject.getString("name");
                        String[] split = jSONObject.getString("affiliation").split(",");
                        if (split.length > 1) {
                            this.f1539b.f1543c = split[0];
                            this.f1539b.f1544d = split[1];
                        }
                    }
                } catch (Throwable e2) {
                    Log.e("LocationGetter", "Exception", e2);
                }
            }
            return null;
        }

        protected void m2846a(Void voidR) {
            this.f1539b.m2859e();
            if (this.f1538a == null) {
                return;
            }
            if (this.f1539b.m2862a()) {
                this.f1538a.m2847a(true, this.f1539b.f1545e, this.f1539b.f1542b, this.f1539b.f1543c, this.f1539b.f1544d);
            } else {
                this.f1538a.m2847a(false, this.f1539b.f1545e, this.f1539b.f1542b, this.f1539b.f1543c, this.f1539b.f1544d);
            }
        }
    }

    public interface LocatedCallback {
        void m2847a(boolean z, Location location, String str, String str2, String str3);
    }

    private class LocationListener implements android.location.LocationListener {
        final /* synthetic */ LocationGetter f1540a;

        private LocationListener(LocationGetter locationGetter) {
            this.f1540a = locationGetter;
        }

        public void onLocationChanged(Location location) {
            this.f1540a.f1545e = location;
            if (this.f1540a.f1545e != null) {
                this.f1540a.m2859e();
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }
    }

    public static LocationGetter m2850a(Context context) {
        LocationGetter locationGetter;
        synchronized (LocationGetter.class) {
            if (f1541a == null) {
                f1541a = new LocationGetter(context.getApplicationContext());
            }
            locationGetter = f1541a;
        }
        return locationGetter;
    }

    public boolean m2862a() {
        return (TextUtils.isEmpty(this.f1542b) || TextUtils.isEmpty(this.f1543c) || TextUtils.isEmpty(this.f1544d) || this.f1545e == null) ? false : true;
    }

    public String m2863b() {
        return this.f1542b;
    }

    public String m2864c() {
        return this.f1543c;
    }

    private LocationGetter(Context context) {
        this.f1546f = context.getApplicationContext();
    }

    public void m2861a(LocatedCallback locatedCallback, boolean z) {
        if (z || !m2862a()) {
            this.f1547g = (LocationManager) this.f1546f.getSystemService("location");
            this.f1545e = null;
            this.f1542b = null;
            this.f1543c = null;
            this.f1544d = null;
            m2857d();
            new C01761(this, locatedCallback).execute(new Void[0]);
        } else if (locatedCallback != null) {
            locatedCallback.m2847a(true, this.f1545e, this.f1542b, this.f1543c, this.f1544d);
        }
    }

    private void m2857d() {
        this.f1548h = new LocationListener();
        this.f1549i = new LocationListener();
        try {
            this.f1547g.requestLocationUpdates("gps", 2000, 10.0f, this.f1548h);
            this.f1547g.requestLocationUpdates("network", 2000, 10.0f, this.f1549i);
        } catch (IllegalArgumentException e) {
            Log.e("LocationGetter", "register location listener error: " + e);
        }
    }

    private synchronized void m2859e() {
        if (this.f1547g != null) {
            if (this.f1548h != null) {
                this.f1547g.removeUpdates(this.f1548h);
            }
            if (this.f1549i != null) {
                this.f1547g.removeUpdates(this.f1549i);
            }
            this.f1548h = null;
            this.f1549i = null;
            this.f1547g = null;
        }
    }
}
