package com.baidu.mobads.p094i;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.baidu.mobads.i.a */
public class C1977a {
    private static Method f6877d;
    private static Method f6878e;
    private static Method f6879f;
    private static Class<?> f6880g;
    private static char[] f6881n;
    private Context f6882a;
    private TelephonyManager f6883b;
    private C1975a f6884c;
    private WifiManager f6885h;
    private C1976b f6886i;
    private long f6887j;
    private String f6888k;
    private int f6889l;
    private String f6890m;

    /* renamed from: com.baidu.mobads.i.a.a */
    private class C1975a {
        public int f6868a;
        public int f6869b;
        public int f6870c;
        public int f6871d;
        public char f6872e;
        final /* synthetic */ C1977a f6873f;

        private C1975a(C1977a c1977a) {
            this.f6873f = c1977a;
            this.f6868a = -1;
            this.f6869b = -1;
            this.f6870c = -1;
            this.f6871d = -1;
            this.f6872e = '\u0000';
        }

        private boolean m7372b() {
            return this.f6868a > -1 && this.f6869b > 0;
        }

        public String m7373a() {
            if (!m7372b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(SpdyProtocol.SLIGHTSSLV2);
            stringBuffer.append(this.f6872e);
            stringBuffer.append(IXAdRequestInfo.HEIGHT);
            if (this.f6870c != 460) {
                stringBuffer.append(this.f6870c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[]{Integer.valueOf(this.f6871d), Integer.valueOf(this.f6868a), Integer.valueOf(this.f6869b)}));
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.baidu.mobads.i.a.b */
    protected class C1976b {
        public List<ScanResult> f6874a;
        final /* synthetic */ C1977a f6875b;
        private long f6876c;

        public C1976b(C1977a c1977a, List<ScanResult> list) {
            this.f6875b = c1977a;
            this.f6874a = null;
            this.f6876c = 0;
            this.f6874a = list;
            this.f6876c = System.currentTimeMillis();
            m7375b();
        }

        private void m7375b() {
            if (m7377a() >= 1) {
                Object obj = 1;
                for (int size = this.f6874a.size() - 1; size >= 1 && r2 != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.f6874a.get(i)).level < ((ScanResult) this.f6874a.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.f6874a.get(i + 1);
                            this.f6874a.set(i + 1, this.f6874a.get(i));
                            this.f6874a.set(i, scanResult);
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                }
            }
        }

        private boolean m7376c() {
            long currentTimeMillis = System.currentTimeMillis() - this.f6876c;
            return currentTimeMillis < 0 || currentTimeMillis > 500;
        }

        public int m7377a() {
            return this.f6874a == null ? 0 : this.f6874a.size();
        }

        public String m7378a(int i) {
            if (m7377a() < 1) {
                return null;
            }
            Object obj;
            Object obj2;
            boolean a = this.f6875b.m7390c();
            if (a) {
                i--;
                obj = null;
            } else {
                int i2 = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
            int size = this.f6874a.size();
            int i3 = 0;
            int i4 = 0;
            Object obj3 = 1;
            Object obj4 = obj;
            while (i3 < size) {
                if (((ScanResult) this.f6874a.get(i3)).level == 0) {
                    i2 = i4;
                    obj2 = obj3;
                    obj3 = obj4;
                } else {
                    String str = ((ScanResult) this.f6874a.get(i3)).BSSID;
                    i2 = ((ScanResult) this.f6874a.get(i3)).level;
                    str = str.replace(":", BuildConfig.FLAVOR);
                    if (this.f6875b.f6888k == null || !str.equals(this.f6875b.f6888k)) {
                        if (i4 < i) {
                            stringBuffer.append(IXAdRequestInfo.HEIGHT);
                            stringBuffer.append(str);
                            stringBuffer.append("m");
                            stringBuffer.append(StrictMath.abs(i2));
                            i2 = i4 + 1;
                            obj2 = null;
                        } else {
                            i2 = i4;
                            obj2 = obj3;
                        }
                        if (i2 > i && obj4 != null) {
                            break;
                        }
                        obj3 = obj4;
                    } else {
                        this.f6875b.f6889l = StrictMath.abs(i2);
                        i2 = i4;
                        obj2 = obj3;
                        int i5 = 1;
                    }
                }
                i3++;
                obj4 = obj3;
                obj3 = obj2;
                i4 = i2;
            }
            obj2 = obj3;
            String str2 = a ? IXAdRequestInfo.HEIGHT + this.f6875b.f6888k + "km" + this.f6875b.f6889l : null;
            return obj2 == null ? str2 + stringBuffer.toString() : str2;
        }
    }

    static {
        f6877d = null;
        f6878e = null;
        f6879f = null;
        f6880g = null;
        f6881n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    }

    public C1977a(Context context) {
        String deviceId;
        this.f6882a = null;
        this.f6883b = null;
        this.f6884c = new C1975a();
        this.f6885h = null;
        this.f6886i = null;
        this.f6887j = 0;
        this.f6888k = null;
        this.f6889l = 0;
        this.f6890m = null;
        this.f6882a = context.getApplicationContext();
        String packageName = this.f6882a.getPackageName();
        try {
            this.f6883b = (TelephonyManager) this.f6882a.getSystemService("phone");
            deviceId = this.f6883b.getDeviceId();
        } catch (Exception e) {
            deviceId = null;
        }
        this.f6890m = "&" + packageName + "&" + deviceId;
        this.f6885h = (WifiManager) this.f6882a.getSystemService(UtilityImpl.NET_TYPE_WIFI);
    }

    private C1975a m7380a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        C1975a c1975a = new C1975a();
        Object obj = null;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c1975a.f6870c = m7386b(cellIdentity.getMcc());
            c1975a.f6871d = m7386b(cellIdentity.getMnc());
            c1975a.f6868a = m7386b(cellIdentity.getLac());
            c1975a.f6869b = m7386b(cellIdentity.getCid());
            c1975a.f6872e = 'g';
            obj = 1;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c1975a.f6871d = m7386b(cellIdentity2.getSystemId());
            c1975a.f6868a = m7386b(cellIdentity2.getNetworkId());
            c1975a.f6869b = m7386b(cellIdentity2.getBasestationId());
            c1975a.f6872e = 'w';
            r0 = 1;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c1975a.f6870c = m7386b(cellIdentity3.getMcc());
            c1975a.f6871d = m7386b(cellIdentity3.getMnc());
            c1975a.f6868a = m7386b(cellIdentity3.getTac());
            c1975a.f6869b = m7386b(cellIdentity3.getCi());
            c1975a.f6872e = 'g';
            r0 = 1;
        }
        if (intValue >= 18 && r0 == null) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c1975a.f6870c = m7386b(cellIdentity4.getMcc());
                    c1975a.f6871d = m7386b(cellIdentity4.getMnc());
                    c1975a.f6868a = m7386b(cellIdentity4.getLac());
                    c1975a.f6869b = m7386b(cellIdentity4.getCid());
                    c1975a.f6872e = 'g';
                }
            } catch (Exception e) {
            }
        }
        return c1975a;
    }

    private String m7381a(int i) {
        String a;
        String a2;
        if (i < 3) {
            i = 3;
        }
        try {
            C1975a b = m7387b();
            if (b == null || !b.m7372b()) {
                m7384a(this.f6883b.getCellLocation());
            } else {
                this.f6884c = b;
            }
            a = this.f6884c.m7373a();
        } catch (Exception e) {
            a = null;
        }
        if (a == null) {
            a = "Z";
        }
        try {
            if (this.f6886i == null || this.f6886i.m7376c()) {
                this.f6886i = new C1976b(this, this.f6885h.getScanResults());
            }
            a2 = this.f6886i.m7378a(i);
        } catch (Exception e2) {
            a2 = null;
        }
        if (a2 != null) {
            a = a + a2;
        }
        return a.equals("Z") ? null : C1977a.m7382a(a + C0714a.TIMESTAMP + System.currentTimeMillis() + this.f6890m);
    }

    private static String m7382a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
        byte nextInt2 = (byte) new Random().nextInt(MotionEventCompat.ACTION_MASK);
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr[i2] = nextInt;
        i2 = i + 1;
        bArr[i] = nextInt2;
        return C1977a.m7383a(bArr);
    }

    private static String m7383a(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            Object obj;
            Object obj2;
            int i3 = (bArr[i2] & MotionEventCompat.ACTION_MASK) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & MotionEventCompat.ACTION_MASK;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            if (i2 + 2 < bArr.length) {
                i3 |= bArr[i2 + 2] & MotionEventCompat.ACTION_MASK;
                obj2 = 1;
            } else {
                obj2 = null;
            }
            cArr[i + 3] = f6881n[obj2 != null ? 63 - (i3 & 63) : 64];
            int i4 = i3 >> 6;
            cArr[i + 2] = f6881n[obj != null ? 63 - (i4 & 63) : 64];
            i3 = i4 >> 6;
            cArr[i + 1] = f6881n[63 - (i3 & 63)];
            cArr[i + 0] = f6881n[63 - ((i3 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return new String(cArr);
    }

    private void m7384a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.f6883b != null) {
            C1975a c1975a = new C1975a();
            String networkOperator = this.f6883b.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.f6884c.f6870c;
                        }
                        c1975a.f6870c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] toCharArray = substring.toCharArray();
                        while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                            i++;
                        }
                    }
                    i = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (i < 0) {
                        i = this.f6884c.f6871d;
                    }
                    c1975a.f6871d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                c1975a.f6868a = ((GsmCellLocation) cellLocation).getLac();
                c1975a.f6869b = ((GsmCellLocation) cellLocation).getCid();
                c1975a.f6872e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                c1975a.f6872e = 'w';
                if (f6880g == null) {
                    try {
                        f6880g = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        f6877d = f6880g.getMethod("getBaseStationId", new Class[0]);
                        f6878e = f6880g.getMethod("getNetworkId", new Class[0]);
                        f6879f = f6880g.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e2) {
                        f6880g = null;
                        return;
                    }
                }
                if (f6880g != null && f6880g.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) f6879f.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.f6884c.f6871d;
                        }
                        c1975a.f6871d = i;
                        c1975a.f6869b = ((Integer) f6877d.invoke(cellLocation, new Object[0])).intValue();
                        c1975a.f6868a = ((Integer) f6878e.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (c1975a.m7372b()) {
                this.f6884c = c1975a;
            }
        }
    }

    private int m7386b(int i) {
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.mobads.p094i.C1977a.C1975a m7387b() {
        /*
        r5 = this;
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r2 = 17;
        if (r0 >= r2) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r5.f6883b;	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0046 }
        r0 = r0.getAllCellInfo();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0046 }
        if (r0 == 0) goto L_0x000f;
    L_0x0018:
        r2 = r0.size();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0046 }
        if (r2 <= 0) goto L_0x000f;
    L_0x001e:
        r3 = r0.iterator();	 Catch:{ Exception -> 0x0048, NoSuchMethodError -> 0x0046 }
        r2 = r1;
    L_0x0023:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x0046 }
        if (r0 == 0) goto L_0x0050;
    L_0x0029:
        r0 = r3.next();	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x0046 }
        r0 = (android.telephony.CellInfo) r0;	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x0046 }
        r4 = r0.isRegistered();	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x0046 }
        if (r4 == 0) goto L_0x0023;
    L_0x0035:
        r0 = r5.m7380a(r0);	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x0046 }
        if (r0 != 0) goto L_0x003d;
    L_0x003b:
        r2 = r0;
        goto L_0x0023;
    L_0x003d:
        r2 = r0.m7372b();	 Catch:{ Exception -> 0x004d, NoSuchMethodError -> 0x0046 }
        if (r2 != 0) goto L_0x0044;
    L_0x0043:
        r0 = r1;
    L_0x0044:
        r1 = r0;
        goto L_0x000f;
    L_0x0046:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0048:
        r0 = move-exception;
        goto L_0x000f;
    L_0x004a:
        r0 = move-exception;
        r1 = r2;
        goto L_0x000f;
    L_0x004d:
        r1 = move-exception;
        r1 = r0;
        goto L_0x000f;
    L_0x0050:
        r1 = r2;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.i.a.b():com.baidu.mobads.i.a$a");
    }

    private boolean m7390c() {
        String str = null;
        this.f6888k = null;
        this.f6889l = 0;
        WifiInfo connectionInfo = this.f6885h.getConnectionInfo();
        if (connectionInfo == null) {
            return false;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                str = bssid.replace(":", BuildConfig.FLAVOR);
            }
            if (str.length() != 12) {
                return false;
            }
            this.f6888k = new String(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String m7391a() {
        try {
            return m7381a(10);
        } catch (Exception e) {
            return null;
        }
    }
}
