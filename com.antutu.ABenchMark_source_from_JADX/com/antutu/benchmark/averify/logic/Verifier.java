package com.antutu.benchmark.averify.logic;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.antutu.benchmark.C1372c;
import com.antutu.benchmark.C1372c.C1343a;
import com.antutu.benchmark.model.C1528h;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;
import com.antutu.utils.BuildProperties;
import com.antutu.utils.DeviceInfoUtil;
import com.antutu.utils.GZipUtil;
import com.antutu.utils.IO;
import com.antutu.utils.RSAUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;
import org.json.JSONTokener;
import p000a.C0131t;
import p000a.C0134u;
import p000a.C0139x.C0138a;
import p000a.C0140y;

public class Verifier {
    private static final C0131t f4590a;
    private static final C0131t f4591b;
    private Context f4592c;
    private Map<String, Object> f4593d;
    private String f4594e;

    public static class VerifiedResult implements Parcelable {
        public static final Creator<VerifiedResult> CREATOR;
        private int f4581a;
        private String f4582b;
        private String f4583c;
        private String f4584d;
        private String f4585e;
        private String f4586f;
        private String f4587g;
        private String f4588h;
        private long f4589i;

        /* renamed from: com.antutu.benchmark.averify.logic.Verifier.VerifiedResult.1 */
        static class C13301 implements Creator<VerifiedResult> {
            C13301() {
            }

            public VerifiedResult m5358a(Parcel parcel) {
                return new VerifiedResult(parcel);
            }

            public VerifiedResult[] m5359a(int i) {
                return new VerifiedResult[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5358a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5359a(i);
            }
        }

        static {
            CREATOR = new C13301();
        }

        public VerifiedResult() {
            this.f4581a = -1;
            this.f4583c = Build.MODEL;
            this.f4584d = Build.BRAND;
        }

        protected VerifiedResult(Parcel parcel) {
            this.f4581a = -1;
            this.f4583c = Build.MODEL;
            this.f4584d = Build.BRAND;
            this.f4581a = parcel.readInt();
            this.f4582b = parcel.readString();
            this.f4583c = parcel.readString();
            this.f4584d = parcel.readString();
            this.f4585e = parcel.readString();
            this.f4586f = parcel.readString();
            this.f4587g = parcel.readString();
            this.f4588h = parcel.readString();
            this.f4589i = parcel.readLong();
        }

        public String m5360a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"status\":" + this.f4581a);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"no\":\"" + this.f4582b + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"model\":\"" + this.f4583c + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"brand\":\"" + this.f4584d + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"cpu\":\"" + this.f4585e + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"cpucores\":\"" + this.f4586f + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"gpu\":\"" + this.f4587g + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"resolution\":\"" + this.f4588h + "\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"datetime\":\"" + this.f4589i + "\"");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void m5361a(String str) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                this.f4581a = jSONObject.optInt(MsgConstant.KEY_STATUS);
                this.f4582b = jSONObject.optString("no");
                this.f4583c = jSONObject.optString(com.taobao.accs.common.Constants.KEY_MODEL, Build.MODEL);
                this.f4584d = jSONObject.optString(com.taobao.accs.common.Constants.KEY_BRAND, Build.BRAND);
                this.f4585e = jSONObject.optString("cpu");
                this.f4586f = jSONObject.optString("cpucores", String.valueOf(jni.getCpuCount()));
                if ("null".equalsIgnoreCase(this.f4586f) || TextUtils.isEmpty(this.f4586f)) {
                    this.f4586f = String.valueOf(jni.getCpuCount());
                }
                this.f4587g = jSONObject.optString("gpu");
                this.f4588h = jSONObject.optString("resolution");
                this.f4589i = jSONObject.optLong("datetime", System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int m5362b() {
            return this.f4581a;
        }

        public void m5363b(String str) {
            this.f4585e = str;
        }

        public String m5364c() {
            return this.f4582b;
        }

        public void m5365c(String str) {
            this.f4586f = str;
        }

        public String m5366d() {
            return this.f4583c;
        }

        public void m5367d(String str) {
            this.f4587g = str;
        }

        public int describeContents() {
            return 0;
        }

        public String m5368e() {
            return this.f4584d;
        }

        public void m5369e(String str) {
            this.f4588h = str;
        }

        public String m5370f() {
            return this.f4585e;
        }

        public String m5371g() {
            return this.f4586f;
        }

        public String m5372h() {
            return this.f4587g;
        }

        public String m5373i() {
            return this.f4588h;
        }

        public long m5374j() {
            return this.f4589i;
        }

        public String toString() {
            return "VerifiedResult{mStatus=" + this.f4581a + ", mSN='" + this.f4582b + '\'' + ", mModel='" + this.f4583c + '\'' + ", mBrand='" + this.f4584d + '\'' + ", mCPUModel='" + this.f4585e + '\'' + ", mCPUCores='" + this.f4586f + '\'' + ", mGPURenerer='" + this.f4587g + '\'' + ", mResolution='" + this.f4588h + '\'' + ", mDateTime=" + this.f4589i + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4581a);
            parcel.writeString(this.f4582b);
            parcel.writeString(this.f4583c);
            parcel.writeString(this.f4584d);
            parcel.writeString(this.f4585e);
            parcel.writeString(this.f4586f);
            parcel.writeString(this.f4587g);
            parcel.writeString(this.f4588h);
            parcel.writeLong(this.f4589i);
        }
    }

    static {
        f4590a = C0131t.m607a("application/json; charset=utf-8");
        f4591b = C0131t.m607a("multipart/form-data; charset=utf-8");
    }

    public Verifier(Context context) {
        this.f4592c = null;
        this.f4593d = null;
        this.f4594e = BuildConfig.FLAVOR;
        this.f4592c = context;
    }

    private int m5375a(Context context) {
        if (VERSION.SDK_INT >= 20) {
            return 0;
        }
        if (VERSION.SDK_INT == 19) {
            int parseInt;
            try {
                String toLowerCase = m5376a("ro.miui.ui.version.name").toLowerCase();
                parseInt = toLowerCase.startsWith(IXAdRequestInfo.f6909V) ? Integer.parseInt(toLowerCase.substring(1)) : 0;
            } catch (Exception e) {
                parseInt = 0;
            }
            if (parseInt >= 7) {
                return 0;
            }
        }
        return C1332b.m5387a(context);
    }

    private String m5376a(String str) {
        return BuildProperties.getInstance().containsKey(str) ? BuildProperties.getInstance().getProperty(str) : BuildConfig.FLAVOR;
    }

    private String m5377a(String str, String str2, boolean z) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            if (!RSAUtil.verify(decode, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD2s7LAN6lXsRbgeaSUFQxM5Ze/\no7Gq9dZAsAyP42ZesMepbIrDktNBqUrlqtzdWookxmRE4IXBOYMfFqhLdMNZTfP6\nY4UcFNJVDPwaz67nxt3NjzpL7fOrjK131hzC6PKa8GA40AXDrpigQIvhH8ATY6v+\nJcqljkmUnTSoNj4c5wIDAQAB", str2)) {
                return "XXX";
            }
            if (decode != null && decode.length > 0) {
                byte[] decryptByPrivateKey = RSAUtil.decryptByPrivateKey(decode, m5379c());
                if (decryptByPrivateKey != null && decryptByPrivateKey.length > 0) {
                    return z ? GZipUtil.uncompress(decryptByPrivateKey) : new String(decryptByPrivateKey);
                }
            }
            return BuildConfig.FLAVOR;
        } catch (Exception e) {
        }
    }

    private String m5378a(String str, boolean z) {
        byte[] compress;
        if (z) {
            try {
                compress = GZipUtil.compress(str);
            } catch (Exception e) {
            }
        } else {
            compress = str.getBytes();
        }
        if (compress != null && compress.length > 0) {
            compress = RSAUtil.encryptByPublicKey(compress, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD2s7LAN6lXsRbgeaSUFQxM5Ze/\no7Gq9dZAsAyP42ZesMepbIrDktNBqUrlqtzdWookxmRE4IXBOYMfFqhLdMNZTfP6\nY4UcFNJVDPwaz67nxt3NjzpL7fOrjK131hzC6PKa8GA40AXDrpigQIvhH8ATY6v+\nJcqljkmUnTSoNj4c5wIDAQAB");
            if (compress != null && compress.length > 0) {
                return Base64.encodeToString(compress, 2);
            }
        }
        return BuildConfig.FLAVOR;
    }

    private String m5379c() {
        String str = null;
        try {
            if (this.f4593d == null) {
                this.f4593d = RSAUtil.initKey();
            }
            str = RSAUtil.getPrivateKey(this.f4593d);
        } catch (Exception e) {
        }
        return str;
    }

    private String m5380d() {
        String str = null;
        try {
            if (this.f4593d == null) {
                this.f4593d = RSAUtil.initKey();
            }
            str = RSAUtil.getPublicKey(this.f4593d);
        } catch (Exception e) {
        }
        return str;
    }

    private String m5381e() {
        String str;
        String str2;
        int a;
        int i;
        String str3;
        int i2;
        int cPUFrequency;
        NetworkInfo networkInfo;
        List sensorList;
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = BuildConfig.FLAVOR;
        String str5 = BuildConfig.FLAVOR;
        try {
            C1372c.m5438a(this.f4592c);
            C1343a a2 = C1372c.m5437a();
            if (a2.m5407c() > 0) {
                str4 = a2.m5402a() + "x" + a2.m5405b();
            }
            a2 = C1372c.m5439b();
            if (a2.m5407c() > 0) {
                str5 = a2.m5402a() + "x" + a2.m5405b();
            }
            str = str5;
            str2 = str4;
        } catch (Exception e) {
            str = str5;
            str2 = str4;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        double d = 0.0d;
        String str6 = BuildConfig.FLAVOR;
        String str7 = BuildConfig.FLAVOR;
        try {
            i4 = IO.getRamTotalSize();
            d = IO.GetSDCardTotalSize();
            i3 = C1332b.m5388a(Environment.getDataDirectory().getAbsolutePath());
            i5 = C1332b.m5388a(Environment.getRootDirectory().getAbsolutePath());
            a = m5375a(this.f4592c);
            if (i3 != a) {
                i3 += a;
            }
            a = i4;
            i = i3;
            i4 = i5;
        } catch (Exception e2) {
            a = i4;
            i = i3;
            i4 = i5;
            d = d;
        }
        i3 = ((i + i4) / IXAdIOUtils.BUFFER_SIZE) / IXAdIOUtils.BUFFER_SIZE;
        i3 = i3 > 800 ? IXAdIOUtils.BUFFER_SIZE : i3 > OtherError.CONTAINER_INVISIBLE_ERROR ? 768 : i3 > NetWorkError.STUB_NETWORK_ERROR ? AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY : i3 > com.taobao.accs.common.Constants.COMMAND_HANDSHAKE ? AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY : i3 > 80 ? SpdyProtocol.SLIGHTSSLV2 : i3 > 40 ? 64 : i3 > 20 ? 32 : i3 > 10 ? 16 : i3 > 5 ? 8 : i3 > 2 ? 4 : i3 > 1 ? 2 : 0;
        if (i3 > 0) {
            str3 = i3 + "G";
        } else {
            i3 = (i + i4) / IXAdIOUtils.BUFFER_SIZE;
            str3 = i3 > 700 ? "1G" : i3 > NetWorkError.STUB_NETWORK_ERROR ? "512M" : i3 > 150 ? "256M" : i3 > 70 ? "128M" : str7;
        }
        if (a > 716800) {
            str6 = ((int) (((((double) a) / 1024.0d) / 1024.0d) + 0.8d)) + "G";
        } else if (a > IXAdIOUtils.BUFFER_SIZE) {
            i3 = (int) (((double) a) / 1024.0d);
            i3 = i3 > 520 ? 768 : i3 > NetWorkError.STUB_NETWORK_ERROR ? AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY : i3 > 160 ? AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY : SpdyProtocol.SLIGHTSSLV2;
            str6 = i3 + "M";
        }
        i3 = 0;
        try {
            i3 = (int) Utils.getCPUFrequency(false);
            i2 = i3;
            cPUFrequency = (int) Utils.getCPUFrequency(true);
        } catch (Exception e3) {
            i2 = i3;
            cPUFrequency = 0;
        }
        String str8 = BuildConfig.FLAVOR;
        String str9 = BuildConfig.FLAVOR;
        str5 = BuildConfig.FLAVOR;
        this.f4594e = BuildConfig.FLAVOR;
        str5 = BuildConfig.FLAVOR;
        String str10 = BuildConfig.FLAVOR;
        String str11 = BuildConfig.FLAVOR;
        String str12 = BuildConfig.FLAVOR;
        String str13 = BuildConfig.FLAVOR;
        String str14 = BuildConfig.FLAVOR;
        String str15 = BuildConfig.FLAVOR;
        str4 = BuildConfig.FLAVOR;
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str16 = str4;
        str4 = str15;
        str15 = str14;
        str14 = str13;
        str13 = str12;
        str12 = str11;
        str5 = str10;
        int i6 = 1;
        while (i6 < 200) {
            String readLine = lineNumberReader.readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.contains("Hardware")) {
                this.f4594e = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                break;
            }
            str11 = readLine.contains("vendor_id") ? readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim() : str12;
            if (str11.equals("GenuineIntel")) {
                if (readLine.contains("model name")) {
                    this.f4594e = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    break;
                }
            }
            str12 = readLine.contains("processor") ? readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim() : str5;
            if (readLine.contains("CPU implementer")) {
                str13 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
            }
            if (readLine.contains("CPU architecture")) {
                str14 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
            }
            if (readLine.contains("CPU variant")) {
                str15 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
            }
            if (readLine.contains("CPU part")) {
                str4 = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
            }
            str5 = readLine.contains("CPU revision") ? readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim() : str16;
            if (!(str13.isEmpty() || str14.isEmpty() || str15.isEmpty() || str4.isEmpty() || str5.isEmpty())) {
                str4 = str13 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str14 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str15 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str4 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str5;
                i3 = -1;
                try {
                    if (str12.length() > 0) {
                        i3 = Integer.parseInt(str12);
                    }
                } catch (Exception e4) {
                }
                try {
                    arrayList.add(str4);
                    arrayList2.add(Integer.valueOf(i3));
                    str13 = BuildConfig.FLAVOR;
                    str14 = BuildConfig.FLAVOR;
                    str15 = BuildConfig.FLAVOR;
                    str4 = BuildConfig.FLAVOR;
                    str5 = BuildConfig.FLAVOR;
                } catch (Exception e5) {
                    str5 = str9;
                    str4 = str8;
                }
            }
            i6++;
            str16 = str5;
            str5 = str12;
            str12 = str11;
        }
        str14 = arrayList.size() > 0 ? (String) arrayList.get(0) : str8;
        try {
            if (arrayList.size() > 1) {
                int size = arrayList.size();
                Collection hashSet = new HashSet(arrayList);
                List arrayList3 = new ArrayList();
                arrayList3.addAll(hashSet);
                int i7 = 0;
                str4 = str9;
                while (i7 < arrayList3.size()) {
                    try {
                        str15 = str4 + ((String) arrayList3.get(i7)) + ":";
                        int i8 = 0;
                        while (i8 < size) {
                            try {
                                str5 = ((String) arrayList3.get(i7)).equalsIgnoreCase((String) arrayList.get(i8)) ? str15 + "#" + arrayList2.get(i8) : str15;
                                i8++;
                                str15 = str5;
                            } catch (Exception e6) {
                                str5 = str15;
                                str4 = str14;
                            }
                        }
                        str4 = str15 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                        i7++;
                    } catch (Exception e7) {
                        str5 = str4;
                        str4 = str14;
                    }
                }
                str5 = str4.length() > 1 ? str4.substring(0, str4.length() - 1) : str4;
            } else {
                str5 = str9;
            }
            str4 = str5;
            str15 = str14;
        } catch (Exception e8) {
            str5 = str9;
            str4 = str14;
            str15 = str4;
            str4 = str5;
            str5 = BuildConfig.FLAVOR;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            str5 = defaultAdapter.getAddress();
            str14 = str5;
            str13 = BuildConfig.FLAVOR;
            str13 = ((WifiManager) this.f4592c.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress();
            str8 = BuildConfig.FLAVOR;
            str9 = BuildConfig.FLAVOR;
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f4592c.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            str8 = activeNetworkInfo.getTypeName();
            networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null) {
            }
            str9 = str5;
            str12 = BuildConfig.FLAVOR;
            TelephonyManager telephonyManager = (TelephonyManager) this.f4592c.getSystemService("phone");
            str12 = telephonyManager.getSimState() != 5 ? str12 : telephonyManager.getSimOperatorName();
            str11 = BuildConfig.FLAVOR;
            sensorList = ((SensorManager) this.f4592c.getSystemService("sensor")).getSensorList(-1);
            i6 = 0;
            while (i6 < sensorList.size()) {
                str5 = str11 + ((Sensor) sensorList.get(i6)).getName();
                try {
                    if (i6 < sensorList.size() - 1) {
                        str5 = str5 + "||";
                    }
                    i6++;
                    str11 = str5;
                } catch (Exception e9) {
                }
            }
            str5 = str11;
            stringBuilder.append("{");
            stringBuilder.append("\"brand\":\"" + Build.BRAND + "\",");
            stringBuilder.append("\"model\":\"" + Build.MODEL.trim() + "\",");
            stringBuilder.append("\"device\":\"" + Build.DEVICE + "\",");
            stringBuilder.append("\"board\":\"" + Build.BOARD + "\",");
            stringBuilder.append("\"hardware\":\"" + Build.HARDWARE + "\",");
            stringBuilder.append("\"cpuinfo\":\"" + jni.getCpuInfo() + "\",");
            stringBuilder.append("\"cpuid\":\"" + str15 + "\",");
            stringBuilder.append("\"cpucore\":\"" + jni.getCpuCount() + "\",");
            stringBuilder.append("\"cpuMore\":\"" + str4 + "\",");
            stringBuilder.append("\"cpuabi\":\"" + m5376a("ro.product.cpu.abi") + "\",");
            stringBuilder.append("\"glVendor\":\"" + C1516b.m6035i() + "\",");
            stringBuilder.append("\"glRenderer\":\"" + C1516b.m6036j() + "\",");
            stringBuilder.append("\"scrWidth\":\"" + C1516b.m6023d() + "\",");
            stringBuilder.append("\"scrHeight\":\"" + C1516b.m6026e() + "\",");
            stringBuilder.append("\"dpi\":\"" + C1516b.m6029f() + "\",");
            stringBuilder.append("\"ram\":\"" + str6 + "\",");
            stringBuilder.append("\"storage\":\"" + str3 + "\",");
            stringBuilder.append("\"ril-impl\":\"" + m5376a("gsm.version.ril-impl") + "\",");
            stringBuilder.append("\"platform\":\"" + m5376a("ro.board.platform") + "\",");
            stringBuilder.append("\"product\":\"" + Build.PRODUCT + "\",");
            stringBuilder.append("\"manufacturer\":\"" + Build.MANUFACTURER + "\",");
            stringBuilder.append("\"backcamera\":\"" + str2 + "\",");
            stringBuilder.append("\"frontcamera\":\"" + str + "\",");
            stringBuilder.append("\"cpuHW\":\"" + this.f4594e + "\",");
            stringBuilder.append("\"sdk\":\"" + VERSION.SDK_INT + "\",");
            stringBuilder.append("\"sim_num\":\"" + m5376a("persist.gemini.sim_num") + "\",");
            stringBuilder.append("\"miui_ver\":\"" + m5376a("ro.miui.ui.version.code") + "\",");
            stringBuilder.append("\"miui_name\":\"" + m5376a("ro.miui.ui.version.name") + "\",");
            stringBuilder.append("\"bt_chip\":\"" + m5376a("ro.bt.chipset") + "\",");
            stringBuilder.append("\"mtk_wifi\":\"" + m5376a("mediatek.wlan.chip") + "\",");
            stringBuilder.append("\"mtk_ver\":\"" + m5376a("ro.mediatek.chip_ver") + "\",");
            stringBuilder.append("\"mtk_platform\":\"" + m5376a("ro.mediatek.platform") + "\",");
            stringBuilder.append("\"mtk_branch\":\"" + m5376a("ro.mediatek.version.branch") + "\",");
            stringBuilder.append("\"mtk_sdk\":\"" + m5376a("ro.mediatek.version.sdk") + "\",");
            stringBuilder.append("\"YunOS\":\"" + m5376a("ro.yunos.version") + "\",");
            stringBuilder.append("\"sensors\":\"" + str5 + "\",");
            str5 = Utils.SHA1(str5);
            str4 = Utils.SHA1(stringBuilder.toString());
            stringBuilder.append("\"sensorsHash\":\"" + str5 + "\",");
            stringBuilder.append("\"deviceHash\":\"" + str4 + "\",");
            stringBuilder.append("\"apiver\":\"2\",");
            stringBuilder.append("\"source\":\"2\",");
            stringBuilder.append("\"cpuMin\":\"" + i2 + "\",");
            stringBuilder.append("\"cpuMax\":\"" + cPUFrequency + "\",");
            stringBuilder.append("\"androidver\":\"" + VERSION.RELEASE + "\",");
            stringBuilder.append("\"memory\":\"" + a + "\",");
            stringBuilder.append("\"romSize\":\"" + i4 + "\",");
            stringBuilder.append("\"phonememory\":\"" + i + "\",");
            stringBuilder.append("\"insdcard\":\"" + d + "\",");
            stringBuilder.append("\"imei\":\"" + DeviceInfoUtil.getIMEI(this.f4592c) + "\",");
            stringBuilder.append("\"sp\":\"" + str12 + "\",");
            stringBuilder.append("\"mode\":\"" + str9 + "\",");
            stringBuilder.append("\"network\":\"" + str8 + "\",");
            stringBuilder.append("\"wlanmac\":\"" + str13 + "\",");
            stringBuilder.append("\"bluetoothmac\":\"" + str14 + "\",");
            stringBuilder.append("\"rom\":\"" + Build.DISPLAY + "\",");
            stringBuilder.append("\"softversion\":\"" + Utils.getVersionCode() + "\"");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
        str5 = BuildConfig.FLAVOR;
        try {
            BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter2 != null && defaultAdapter2.isEnabled()) {
                str5 = defaultAdapter2.getAddress();
            }
            str14 = str5;
        } catch (Exception e10) {
            str14 = str5;
        }
        str13 = BuildConfig.FLAVOR;
        try {
            str13 = ((WifiManager) this.f4592c.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress();
        } catch (Exception e11) {
        }
        str8 = BuildConfig.FLAVOR;
        str9 = BuildConfig.FLAVOR;
        try {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) this.f4592c.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo2 = connectivityManager2.getActiveNetworkInfo();
            if (activeNetworkInfo2 != null && activeNetworkInfo2.isAvailable()) {
                str8 = activeNetworkInfo2.getTypeName();
            }
            networkInfo = connectivityManager2.getNetworkInfo(0);
            str5 = (networkInfo == null && networkInfo.isAvailable()) ? networkInfo.getSubtypeName() : str9;
            str9 = str5;
        } catch (Exception e12) {
            str8 = str8;
        }
        str12 = BuildConfig.FLAVOR;
        try {
            TelephonyManager telephonyManager2 = (TelephonyManager) this.f4592c.getSystemService("phone");
            if (telephonyManager2.getSimState() != 5) {
            }
            str12 = telephonyManager2.getSimState() != 5 ? str12 : telephonyManager2.getSimOperatorName();
        } catch (Exception e13) {
        }
        str11 = BuildConfig.FLAVOR;
        try {
            sensorList = ((SensorManager) this.f4592c.getSystemService("sensor")).getSensorList(-1);
            i6 = 0;
            while (i6 < sensorList.size()) {
                str5 = str11 + ((Sensor) sensorList.get(i6)).getName();
                if (i6 < sensorList.size() - 1) {
                    str5 = str5 + "||";
                }
                i6++;
                str11 = str5;
            }
            str5 = str11;
        } catch (Exception e14) {
            str5 = str11;
        }
        stringBuilder.append("{");
        stringBuilder.append("\"brand\":\"" + Build.BRAND + "\",");
        stringBuilder.append("\"model\":\"" + Build.MODEL.trim() + "\",");
        stringBuilder.append("\"device\":\"" + Build.DEVICE + "\",");
        stringBuilder.append("\"board\":\"" + Build.BOARD + "\",");
        stringBuilder.append("\"hardware\":\"" + Build.HARDWARE + "\",");
        stringBuilder.append("\"cpuinfo\":\"" + jni.getCpuInfo() + "\",");
        stringBuilder.append("\"cpuid\":\"" + str15 + "\",");
        stringBuilder.append("\"cpucore\":\"" + jni.getCpuCount() + "\",");
        stringBuilder.append("\"cpuMore\":\"" + str4 + "\",");
        stringBuilder.append("\"cpuabi\":\"" + m5376a("ro.product.cpu.abi") + "\",");
        stringBuilder.append("\"glVendor\":\"" + C1516b.m6035i() + "\",");
        stringBuilder.append("\"glRenderer\":\"" + C1516b.m6036j() + "\",");
        stringBuilder.append("\"scrWidth\":\"" + C1516b.m6023d() + "\",");
        stringBuilder.append("\"scrHeight\":\"" + C1516b.m6026e() + "\",");
        stringBuilder.append("\"dpi\":\"" + C1516b.m6029f() + "\",");
        stringBuilder.append("\"ram\":\"" + str6 + "\",");
        stringBuilder.append("\"storage\":\"" + str3 + "\",");
        stringBuilder.append("\"ril-impl\":\"" + m5376a("gsm.version.ril-impl") + "\",");
        stringBuilder.append("\"platform\":\"" + m5376a("ro.board.platform") + "\",");
        stringBuilder.append("\"product\":\"" + Build.PRODUCT + "\",");
        stringBuilder.append("\"manufacturer\":\"" + Build.MANUFACTURER + "\",");
        stringBuilder.append("\"backcamera\":\"" + str2 + "\",");
        stringBuilder.append("\"frontcamera\":\"" + str + "\",");
        stringBuilder.append("\"cpuHW\":\"" + this.f4594e + "\",");
        stringBuilder.append("\"sdk\":\"" + VERSION.SDK_INT + "\",");
        stringBuilder.append("\"sim_num\":\"" + m5376a("persist.gemini.sim_num") + "\",");
        stringBuilder.append("\"miui_ver\":\"" + m5376a("ro.miui.ui.version.code") + "\",");
        stringBuilder.append("\"miui_name\":\"" + m5376a("ro.miui.ui.version.name") + "\",");
        stringBuilder.append("\"bt_chip\":\"" + m5376a("ro.bt.chipset") + "\",");
        stringBuilder.append("\"mtk_wifi\":\"" + m5376a("mediatek.wlan.chip") + "\",");
        stringBuilder.append("\"mtk_ver\":\"" + m5376a("ro.mediatek.chip_ver") + "\",");
        stringBuilder.append("\"mtk_platform\":\"" + m5376a("ro.mediatek.platform") + "\",");
        stringBuilder.append("\"mtk_branch\":\"" + m5376a("ro.mediatek.version.branch") + "\",");
        stringBuilder.append("\"mtk_sdk\":\"" + m5376a("ro.mediatek.version.sdk") + "\",");
        stringBuilder.append("\"YunOS\":\"" + m5376a("ro.yunos.version") + "\",");
        stringBuilder.append("\"sensors\":\"" + str5 + "\",");
        str5 = Utils.SHA1(str5);
        str4 = Utils.SHA1(stringBuilder.toString());
        stringBuilder.append("\"sensorsHash\":\"" + str5 + "\",");
        stringBuilder.append("\"deviceHash\":\"" + str4 + "\",");
        stringBuilder.append("\"apiver\":\"2\",");
        stringBuilder.append("\"source\":\"2\",");
        stringBuilder.append("\"cpuMin\":\"" + i2 + "\",");
        stringBuilder.append("\"cpuMax\":\"" + cPUFrequency + "\",");
        stringBuilder.append("\"androidver\":\"" + VERSION.RELEASE + "\",");
        stringBuilder.append("\"memory\":\"" + a + "\",");
        stringBuilder.append("\"romSize\":\"" + i4 + "\",");
        stringBuilder.append("\"phonememory\":\"" + i + "\",");
        stringBuilder.append("\"insdcard\":\"" + d + "\",");
        stringBuilder.append("\"imei\":\"" + DeviceInfoUtil.getIMEI(this.f4592c) + "\",");
        stringBuilder.append("\"sp\":\"" + str12 + "\",");
        stringBuilder.append("\"mode\":\"" + str9 + "\",");
        stringBuilder.append("\"network\":\"" + str8 + "\",");
        stringBuilder.append("\"wlanmac\":\"" + str13 + "\",");
        stringBuilder.append("\"bluetoothmac\":\"" + str14 + "\",");
        stringBuilder.append("\"rom\":\"" + Build.DISPLAY + "\",");
        stringBuilder.append("\"softversion\":\"" + Utils.getVersionCode() + "\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String m5382a() {
        StringBuilder stringBuilder = new StringBuilder();
        String language = this.f4592c.getResources().getConfiguration().locale.getLanguage();
        String country = this.f4592c.getResources().getConfiguration().locale.getCountry();
        if (language != null && language.contains("zh")) {
            language = (country == null || country.contains("CN")) ? "cn" : "tw";
        }
        int maxSet = jni.getMaxSet();
        if (maxSet == 0) {
            maxSet = jni.getMaxDef();
        }
        stringBuilder.append("format=json").append("&brand=").append(Build.BRAND).append("&model=").append(Build.MODEL).append("&lan=").append(language).append("&resolution=").append(C1516b.m6034h()).append("&glVendor=").append(C1516b.m6035i()).append("&glRenderer=").append(C1516b.m6036j()).append("&device=").append(Build.DEVICE).append("&manufacturer=").append(Build.MANUFACTURER).append("&cpuinfo=").append(C1503b.m5915c().m5952j()).append("&cupid=").append(Utils.getCPUSerial()).append("&softversion=").append(Utils.getVersionCode()).append("&cpuMax=").append(maxSet + BuildConfig.FLAVOR).append("&ramsize=").append(String.valueOf(IO.getRamTotalSize())).append("&str10=").append(Utils.getLocalMacAddressFromIp(this.f4592c)).append("&str2=").append(this.f4594e + IO.getCPURev());
        language = C1516b.m6031g();
        if (language != null) {
            stringBuilder.append("&gpufrequency=").append(language);
        }
        return jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
    }

    public String m5383a(String str, String str2) {
        try {
            return new C0134u().m620a(new C0138a().m656a(str + "&gpv=" + str2 + "&timestamp=" + System.currentTimeMillis()).m659a()).m480a().m700e().m131d();
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public VerifiedResult m5384b() {
        VerifiedResult verifiedResult = new VerifiedResult();
        String d = m5380d();
        if (d == null) {
            return verifiedResult;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(m5385b("http://yanjiapi.antutu.net/index.php?r=/yanji/verify", "{\"data\":\"" + m5378a(m5381e(), true) + "\", \"key\":\"" + d + "\", \"nocompressed\":\"" + 0 + "\"}")).nextValue();
            d = m5377a(jSONObject.getString(com.taobao.accs.common.Constants.KEY_DATA), jSONObject.getString(com.taobao.accs.common.Constants.KEY_SECURITY_SIGN), false);
            if (d != null) {
                verifiedResult.m5361a(d);
                if (verifiedResult.m5362b() == 1) {
                    verifiedResult.m5367d(C1516b.m6036j());
                    verifiedResult.m5369e(C1516b.m6023d() + " x " + C1516b.m6026e());
                    String a = m5382a();
                    d = m5383a("http://autovote.antutu.net/proMoudule/index.php?action=rvAntuModelUrlnew&data=1", a);
                    if (TextUtils.isEmpty(d)) {
                        Thread.sleep(100);
                        d = m5383a("http://autovote.antutu.net/proMoudule/index.php?action=rvAntuModelUrlnew&data=1", a);
                    }
                    C1528h c1528h = new C1528h();
                    c1528h.m6072a(d);
                    if (TextUtils.isEmpty(c1528h.f5296a.f5265H)) {
                        verifiedResult.m5363b(this.f4594e);
                    } else if (TextUtils.isEmpty(c1528h.f5296a.f5265H.trim())) {
                        verifiedResult.m5363b(this.f4594e);
                    } else {
                        verifiedResult.m5363b(c1528h.f5296a.f5265H);
                    }
                    verifiedResult.m5365c(c1528h.f5296a.f5272c);
                    if ("null".equalsIgnoreCase(c1528h.f5296a.f5272c) || TextUtils.isEmpty(c1528h.f5296a.f5272c)) {
                        verifiedResult.m5365c(String.valueOf(jni.getCpuCount()));
                    } else {
                        verifiedResult.m5365c(c1528h.f5296a.f5272c);
                    }
                }
            }
            return verifiedResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String m5385b(String str, String str2) {
        try {
            return new C0134u().m620a(new C0138a().m656a(str).m655a(C0140y.m669a(f4590a, str2)).m659a()).m480a().m700e().m131d();
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }
}
