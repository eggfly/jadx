package com.antutu.benchmark.service;

import android.app.Service;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1535m;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.Utils;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;

public class LocationService extends Service {
    LocationListener f5647a;
    private double f5648b;
    private double f5649c;
    private String f5650d;
    private LocationManager f5651e;
    private String f5652f;

    /* renamed from: com.antutu.benchmark.service.LocationService.1 */
    class C16121 implements LocationListener {
        final /* synthetic */ LocationService f5643a;

        /* renamed from: com.antutu.benchmark.service.LocationService.1.1 */
        class C16111 extends Thread {
            final /* synthetic */ C16121 f5642a;

            C16111(C16121 c16121) {
                this.f5642a = c16121;
            }

            public void run() {
                super.run();
                try {
                    C16111.sleep(15000);
                } catch (Exception e) {
                }
                this.f5642a.f5643a.stopSelf();
            }
        }

        C16121(LocationService locationService) {
            this.f5643a = locationService;
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                try {
                    this.f5643a.m6372a(location);
                    this.f5643a.m6375a();
                } catch (Exception e) {
                }
            }
            new C16111(this).start();
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: com.antutu.benchmark.service.LocationService.2 */
    class C16132 extends Thread {
        final /* synthetic */ LocationService f5644a;

        C16132(LocationService locationService) {
            this.f5644a = locationService;
        }

        public void run() {
            super.run();
            try {
                C16132.sleep(180000);
            } catch (Exception e) {
            }
            this.f5644a.stopSelf();
            this.f5644a.m6375a();
        }
    }

    /* renamed from: com.antutu.benchmark.service.LocationService.3 */
    class C16143 implements DownloadJobListener {
        final /* synthetic */ Location f5645a;
        final /* synthetic */ LocationService f5646b;

        C16143(LocationService locationService, Location location) {
            this.f5646b = locationService;
            this.f5645a = location;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                this.f5646b.f5650d = ((C1535m) c1519k).f5344a;
            } else {
                double latitude = this.f5645a.getLatitude();
                double longitude = this.f5645a.getLongitude();
                DecimalFormat decimalFormat = new DecimalFormat("0.00 ");
                this.f5646b.f5650d = decimalFormat.format(latitude) + C4233j.f14398u + decimalFormat.format(longitude);
            }
            this.f5646b.getSharedPreferences(MsgConstant.KEY_LOCATION_PARAMS, 0).edit().putString("loc", this.f5646b.f5650d).commit();
            this.f5646b.m6380c();
        }
    }

    public LocationService() {
        this.f5648b = 0.0d;
        this.f5649c = 0.0d;
        this.f5647a = new C16121(this);
    }

    private String m6371a(int i, Location location) {
        return i != 1 ? "http://api.map.baidu.com/geocoder?location=" + location.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + location.getLongitude() + "&output=json&key=" + C1523d.m6063d() : "http://maps.google.com/maps/api/geocode/json?latlng=" + location.getLatitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + location.getLongitude() + "&language=en&sensor=false";
    }

    private String m6372a(Location location) {
        try {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            C1503b.m5915c().m5934b(decimalFormat.format(latitude) + C4233j.f14398u + decimalFormat.format(longitude));
        } catch (Exception e) {
        }
        int k = C1503b.m5915c().m5954k();
        DownloadJob downloadJob = k == 1 ? new DownloadJob(this, m6371a(k, location), new C1535m(k)) : new DownloadJob(this, m6371a(k, location), new C1535m(k));
        downloadJob.setDownloadJobListener(new C16143(this, location));
        downloadJob.start();
        return this.f5650d;
    }

    private void m6375a() {
        try {
            this.f5651e.setTestProviderEnabled(this.f5652f, false);
            this.f5651e.removeUpdates(this.f5647a);
        } catch (Exception e) {
        }
    }

    private void m6376a(Intent intent) {
        if (!Utils.isNetworkConnected(this)) {
            stopSelf();
        } else if (Utils.checkPermission(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            m6379b();
        } else {
            stopSelf();
        }
    }

    private void m6379b() {
        try {
            this.f5651e = (LocationManager) getSystemService(MsgConstant.KEY_LOCATION_PARAMS);
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            criteria.setBearingAccuracy(1);
            criteria.setSpeedAccuracy(1);
            criteria.setSpeedRequired(true);
            criteria.setBearingRequired(true);
            criteria.setCostAllowed(false);
            criteria.setAltitudeRequired(false);
            criteria.setPowerRequirement(1);
            this.f5652f = this.f5651e.getBestProvider(criteria, true);
            this.f5651e.requestLocationUpdates(this.f5652f, 300000, 500.0f, this.f5647a);
            Location lastKnownLocation = this.f5651e.getLastKnownLocation(this.f5652f);
            if (lastKnownLocation != null) {
                this.f5648b = lastKnownLocation.getLatitude();
                this.f5649c = lastKnownLocation.getLongitude();
            }
            new C16132(this).start();
        } catch (Exception e) {
            stopSelf();
        }
    }

    private void m6380c() {
        Intent intent = new Intent();
        intent.setAction("com.antutu.device_loc_action");
        intent.putExtra("loc", this.f5650d);
        sendBroadcast(intent);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m6376a(intent);
        return 1;
    }
}
