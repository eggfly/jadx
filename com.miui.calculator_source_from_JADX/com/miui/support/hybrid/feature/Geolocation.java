package com.miui.support.hybrid.feature;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.miui.support.hybrid.Callback;
import com.miui.support.hybrid.HybridFeature;
import com.miui.support.hybrid.HybridFeature.Mode;
import com.miui.support.hybrid.Request;
import com.miui.support.hybrid.Response;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Geolocation implements HybridFeature {
    private String f2080a;
    private Callback f2081b;
    private LocationListener f2082c;

    private class NetworkLocationListener implements LocationListener {
        final /* synthetic */ Geolocation f2079a;

        private NetworkLocationListener(Geolocation geolocation) {
            this.f2079a = geolocation;
        }

        public void onLocationChanged(Location location) {
            if (this.f2079a.f2081b != null) {
                this.f2079a.f2081b.m3492a(this.f2079a.m3575a(location));
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public Geolocation() {
        this.f2080a = "network";
    }

    public void m3581a(Map<String, String> map) {
        if ("gps".equals((String) map.get("type"))) {
            this.f2080a = "gps";
        }
    }

    public Response m3580a(Request request) {
        String a = request.m3550a();
        Log.i("HybridGeolocation", "invoke with action: " + a);
        LocationManager locationManager = (LocationManager) request.m3560e().m3544a().getSystemService("location");
        if ("enableListener".equals(a)) {
            return m3576a(locationManager, request);
        }
        if ("get".equals(a)) {
            return m3578b(locationManager, request);
        }
        if ("disableListener".equals(a)) {
            return m3579c(locationManager, request);
        }
        return new Response(204, "no such action");
    }

    private Response m3576a(LocationManager locationManager, Request request) {
        this.f2081b = request.m3558c();
        if (this.f2082c == null) {
            this.f2082c = new NetworkLocationListener();
            Looper.prepare();
            locationManager.requestLocationUpdates(this.f2080a, 0, 0.0f, this.f2082c);
            Looper.loop();
        }
        this.f2081b.m3492a(m3575a(locationManager.getLastKnownLocation(this.f2080a)));
        return null;
    }

    private Response m3578b(LocationManager locationManager, Request request) {
        return m3575a(locationManager.getLastKnownLocation(this.f2080a));
    }

    private Response m3579c(LocationManager locationManager, Request request) {
        if (this.f2082c != null) {
            locationManager.removeUpdates(this.f2082c);
            this.f2082c = null;
        }
        this.f2081b = null;
        request.m3558c().m3492a(new Response(0, "remove"));
        return null;
    }

    private Response m3575a(Location location) {
        if (location != null) {
            Log.i("HybridGeolocation", "response with valid location.");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("latitude", location.getLatitude());
                jSONObject.put("longitude", location.getLongitude());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return new Response(3, jSONObject.toString());
        }
        Log.i("HybridGeolocation", "error: response location with null.");
        return new Response(200, "no location");
    }

    public Mode m3582b(Request request) {
        if ("get".equals(request.m3550a())) {
            return Mode.SYNC;
        }
        return Mode.CALLBACK;
    }
}
