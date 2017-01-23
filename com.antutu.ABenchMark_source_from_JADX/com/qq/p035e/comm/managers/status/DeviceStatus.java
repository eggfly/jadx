package com.qq.p035e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.handmark.pulltorefresh.library.C3628R;
import com.qq.p035e.comm.util.Md5Util;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.MsgConstant;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.qq.e.comm.managers.status.DeviceStatus */
public class DeviceStatus {
    private String f13493a;
    private String f13494b;
    private int f13495c;
    private int f13496d;
    private int f13497e;
    private String f13498f;
    private String f13499g;
    private String f13500h;
    private String f13501i;
    private String f13502j;
    private volatile String f13503k;
    private volatile String f13504l;
    private volatile float f13505m;
    public final String model;
    private Context f13506n;

    /* renamed from: com.qq.e.comm.managers.status.DeviceStatus.1 */
    class C40591 implements LocationListener {
        private /* synthetic */ LocationManager f13491a;
        private /* synthetic */ DeviceStatus f13492b;

        C40591(DeviceStatus deviceStatus, LocationManager locationManager) {
            this.f13492b = deviceStatus;
            this.f13491a = locationManager;
        }

        public void onLocationChanged(Location location) {
            try {
                this.f13492b.f13503k = location.getLatitude();
                this.f13492b.f13504l = location.getLongitude();
                this.f13491a.removeUpdates(this);
            } catch (Throwable th) {
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public DeviceStatus(Context context) {
        this.model = Build.MODEL;
        this.f13506n = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f13497e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.f13495c = getVersion() > 3 ? m16579a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.f13496d = getVersion() > 3 ? m16579a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        m16581a();
    }

    private int m16579a(float f, int i) {
        return (this.f13506n.getApplicationInfo().flags & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) != 0 ? (int) (((float) i) / f) : i;
    }

    private void m16581a() {
        try {
            LocationManager locationManager = (LocationManager) this.f13506n.getSystemService(MsgConstant.KEY_LOCATION_PARAMS);
            if (locationManager != null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(2);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                String bestProvider = locationManager.getBestProvider(criteria, true);
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null) {
                    this.f13503k = lastKnownLocation.getLatitude();
                    this.f13504l = lastKnownLocation.getLongitude();
                    this.f13505m = lastKnownLocation.getAccuracy();
                    return;
                }
                try {
                    locationManager.requestLocationUpdates(bestProvider, 2000, 7000.0f, new C40591(this, locationManager));
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f13506n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        String str;
        switch (activeNetworkInfo.getType()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                str = "ed";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                str = IXAdRequestInfo.WIFI;
                break;
            default:
                str = "unknow";
                break;
        }
        this.f13501i = str;
        return this.f13501i;
    }

    public int getDeviceDensity() {
        return this.f13497e;
    }

    public int getDeviceHeight() {
        return this.f13496d;
    }

    public int getDeviceWidth() {
        return this.f13495c;
    }

    public String getDid() {
        if (this.f13502j == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f13506n.getSystemService("phone");
                if (StringUtil.isEmpty(telephonyManager.getDeviceId())) {
                    this.f13502j = BuildConfig.FLAVOR;
                } else {
                    this.f13502j = Md5Util.encode(telephonyManager.getDeviceId().toLowerCase(Locale.US)).toLowerCase(Locale.US);
                }
            } catch (Exception e) {
            }
        }
        return this.f13502j;
    }

    public Map<String, String> getLacAndCeilId() {
        int i = 0;
        String operator = getOperator();
        Map<String, String> hashMap = new HashMap();
        if (!(StringUtil.isEmpty(operator) || "null".equalsIgnoreCase(operator))) {
            try {
                int parseInt = Integer.parseInt(operator.substring(0, 3));
                int parseInt2 = Integer.parseInt(operator.substring(3));
                if (parseInt == 460) {
                    int baseStationId;
                    TelephonyManager telephonyManager = (TelephonyManager) this.f13506n.getSystemService("phone");
                    if (parseInt2 == 3 || parseInt2 == 5) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                        i = cdmaCellLocation.getNetworkId();
                        baseStationId = cdmaCellLocation.getBaseStationId();
                    } else {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        if (gsmCellLocation != null) {
                            i = gsmCellLocation.getLac();
                            baseStationId = gsmCellLocation.getCid();
                        } else {
                            baseStationId = 0;
                        }
                    }
                    hashMap.put("lac", i);
                    hashMap.put("cellid", baseStationId);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.f13494b == null) {
            this.f13494b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.f13494b.length() == 0) {
                this.f13494b = "en";
            }
        }
        return this.f13494b;
    }

    public String getLat() {
        return this.f13503k;
    }

    public String getLng() {
        return this.f13504l;
    }

    public float getLocationAccuracy() {
        return this.f13505m;
    }

    public NetworkType getNetworkType() {
        int parseInt;
        String dataNet = getDataNet();
        try {
            parseInt = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException e) {
            parseInt = 0;
        }
        if (dataNet != null && dataNet.equals(IXAdRequestInfo.WIFI)) {
            return NetworkType.WIFI;
        }
        switch (parseInt) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return NetworkType.NET_2G;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return NetworkType.NET_3G;
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOperator() {
        try {
            this.f13499g = ((TelephonyManager) this.f13506n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
        }
        return this.f13499g;
    }

    public String getPhoneNet() {
        try {
            this.f13500h = ((TelephonyManager) this.f13506n.getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
        }
        return this.f13500h;
    }

    public String getScreenOrientation() {
        if (this.f13506n.getResources().getConfiguration().orientation == 2) {
            this.f13498f = "l";
        } else if (this.f13506n.getResources().getConfiguration().orientation == 1) {
            this.f13498f = "p";
        }
        return this.f13498f;
    }

    public String getUid() {
        if (this.f13493a == null) {
            String string = Secure.getString(this.f13506n.getContentResolver(), "android_id");
            this.f13493a = string == null ? Md5Util.encode("emulator") : Md5Util.encode(string);
        }
        return this.f13493a;
    }

    public int getVersion() {
        try {
            return VERSION.SDK_INT;
        } catch (Exception e) {
            return 3;
        }
    }
}
