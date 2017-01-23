package com.mob.tools.utils;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.support.v4.widget.AutoScrollHelper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.handmark.pulltorefresh.library.C3628R;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.MobLog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;

public class DeviceHelper {
    private static DeviceHelper deviceHelper;
    private Context context;

    private class GSConnection implements ServiceConnection {
        boolean got;
        private final BlockingQueue<IBinder> iBinders;

        private GSConnection() {
            this.got = false;
            this.iBinders = new LinkedBlockingQueue();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.iBinders.put(iBinder);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder takeBinder() {
            if (this.got) {
                throw new IllegalStateException();
            }
            this.got = true;
            return (IBinder) this.iBinders.poll(1500, TimeUnit.MILLISECONDS);
        }
    }

    private DeviceHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    private String getCurrentNetworkHardwareAddress() {
        Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
            Enumeration inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses != null) {
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                            }
                            if (stringBuilder.length() > 0) {
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            }
                            return stringBuilder.toString();
                        }
                    }
                }
                continue;
            }
        }
        return null;
    }

    private String getHardwareAddressFromShell(String str) {
        BufferedReader bufferedReader;
        CharSequence readLine;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ca");
            stringBuilder.append("t ");
            stringBuilder.append("/s");
            stringBuilder.append("ys");
            stringBuilder.append("/c");
            stringBuilder.append("la");
            stringBuilder.append("ss");
            stringBuilder.append("/n");
            stringBuilder.append("et");
            stringBuilder.append("/");
            stringBuilder.append(str);
            stringBuilder.append("/a");
            stringBuilder.append("dd");
            stringBuilder.append("re");
            stringBuilder.append("ss");
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(stringBuilder.toString()).getInputStream()));
            try {
                readLine = bufferedReader.readLine();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    MobLog.getInstance().m4376d(th);
                    if (bufferedReader == null) {
                        readLine = null;
                    } else {
                        try {
                            bufferedReader.close();
                            readLine = null;
                        } catch (Throwable th4) {
                            readLine = null;
                        }
                    }
                    return TextUtils.isEmpty(readLine) ? null : readLine;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable th6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        if (TextUtils.isEmpty(readLine)) {
        }
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        DeviceHelper deviceHelper;
        synchronized (DeviceHelper.class) {
            if (deviceHelper == null && context != null) {
                deviceHelper = new DeviceHelper(context);
            }
            deviceHelper = deviceHelper;
        }
        return deviceHelper;
    }

    private String getLocalDeviceKey() {
        if (!getSdcardState()) {
            return null;
        }
        File file;
        File file2 = new File(getSdcardPath(), "ShareSDK");
        if (file2.exists()) {
            file = new File(file2, ".dk");
            if (file.exists() && file.renameTo(new File(C4021R.getCacheRoot(this.context), ".dk"))) {
                file.delete();
            }
        }
        file = new File(C4021R.getCacheRoot(this.context), ".dk");
        if (!file.exists()) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object readObject = objectInputStream.readObject();
        String valueOf = (readObject == null || !(readObject instanceof char[])) ? null : String.valueOf((char[]) readObject);
        objectInputStream.close();
        return valueOf;
    }

    private Object getSystemService(String str) {
        try {
            return this.context.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    private boolean is4GMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tN");
            stringBuilder.append("et");
            stringBuilder.append("wo");
            stringBuilder.append("rk");
            stringBuilder.append("Ty");
            stringBuilder.append("pe");
            return ((Integer) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0])).intValue() == 13;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return false;
        }
    }

    private boolean isFastMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tN");
            stringBuilder.append("et");
            stringBuilder.append("wo");
            stringBuilder.append("rk");
            stringBuilder.append("Ty");
            stringBuilder.append("pe");
            switch (((Integer) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0])).intValue()) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return false;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return false;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return false;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    return false;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    return false;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    return false;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    return true;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    return true;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    return true;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    return true;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        return false;
    }

    private boolean isSystemApp(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & 1) == 1) || ((packageInfo.applicationInfo.flags & SpdyProtocol.SLIGHTSSLV2) == 1);
    }

    private String[] listNetworkHardwareAddress() {
        int i = 0;
        Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        List<NetworkInterface> list = Collections.list(networkInterfaces);
        HashMap hashMap = new HashMap();
        for (NetworkInterface networkInterface : list) {
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress != null) {
                StringBuilder stringBuilder = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i2 = 0; i2 < length; i2++) {
                    stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i2])}));
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                hashMap.put(networkInterface.getName(), stringBuilder.toString());
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        Collection arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        Collection arrayList4 = new ArrayList();
        Collection arrayList5 = new ArrayList();
        Collection arrayList6 = new ArrayList();
        Collection arrayList7 = new ArrayList();
        Collection arrayList8 = new ArrayList();
        while (arrayList.size() > 0) {
            String str = (String) arrayList.remove(0);
            if (str.startsWith("wlan")) {
                arrayList2.add(str);
            } else if (str.startsWith("eth")) {
                arrayList3.add(str);
            } else if (str.startsWith("rev_rmnet")) {
                arrayList4.add(str);
            } else if (str.startsWith("dummy")) {
                arrayList5.add(str);
            } else if (str.startsWith("usbnet")) {
                arrayList6.add(str);
            } else if (str.startsWith("rmnet_usb")) {
                arrayList7.add(str);
            } else {
                arrayList8.add(str);
            }
        }
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        Collections.sort(arrayList4);
        Collections.sort(arrayList5);
        Collections.sort(arrayList6);
        Collections.sort(arrayList7);
        Collections.sort(arrayList8);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        arrayList.addAll(arrayList5);
        arrayList.addAll(arrayList6);
        arrayList.addAll(arrayList7);
        arrayList.addAll(arrayList8);
        String[] strArr = new String[arrayList.size()];
        while (i < strArr.length) {
            strArr[i] = (String) hashMap.get(arrayList.get(i));
            i++;
        }
        return strArr;
    }

    private void saveLocalDeviceKey(String str) {
        if (getSdcardState()) {
            File file = new File(C4021R.getCacheRoot(this.context), ".dk");
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(str.toCharArray());
            objectOutputStream.flush();
            objectOutputStream.close();
        }
    }

    public String Base64AES(String str, String str2) {
        String encodeToString;
        Throwable th;
        try {
            encodeToString = Base64.encodeToString(Data.AES128Encode(str2, str), 0);
            try {
                if (encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", BuildConfig.FLAVOR);
                }
            } catch (Throwable th2) {
                th = th2;
                MobLog.getInstance().m4388w(th);
                return encodeToString;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            encodeToString = null;
            th = th4;
            MobLog.getInstance().m4388w(th);
            return encodeToString;
        }
        return encodeToString;
    }

    public boolean checkPermission(String str) {
        int intValue;
        if (VERSION.SDK_INT >= 23) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("an");
                stringBuilder.append("dr");
                stringBuilder.append("oi");
                stringBuilder.append("d.");
                stringBuilder.append("co");
                stringBuilder.append("nt");
                stringBuilder.append("en");
                stringBuilder.append("t.");
                stringBuilder.append("Co");
                stringBuilder.append("nt");
                stringBuilder.append("ex");
                stringBuilder.append(C0714a.TIMESTAMP);
                ReflectHelper.importClass(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("ch");
                stringBuilder.append("ec");
                stringBuilder.append("kS");
                stringBuilder.append("el");
                stringBuilder.append("fP");
                stringBuilder.append("er");
                stringBuilder.append("mi");
                stringBuilder.append("ss");
                stringBuilder.append("io");
                stringBuilder.append(IXAdRequestInfo.AD_COUNT);
                Integer num = (Integer) ReflectHelper.invokeInstanceMethod(this.context, stringBuilder.toString(), str);
                intValue = num == null ? -1 : num.intValue();
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
                intValue = -1;
            }
        } else {
            this.context.checkPermission(str, Process.myPid(), Process.myUid());
            intValue = this.context.getPackageManager().checkPermission(str, getPackageName());
        }
        return intValue == 0;
    }

    public String getAdvertisingID() {
        String readString;
        Throwable th;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Throwable("Do not call this function from the main thread !");
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        ServiceConnection gSConnection = new GSConnection();
        try {
            this.context.bindService(intent, gSConnection, 1);
            IBinder takeBinder = gSConnection.takeBinder();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            takeBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                this.context.unbindService(gSConnection);
            } catch (Throwable th2) {
                th = th2;
                try {
                    MobLog.getInstance().m4376d(th);
                    return readString;
                } finally {
                    this.context.unbindService(gSConnection);
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            readString = null;
            th = th4;
            MobLog.getInstance().m4376d(th);
            return readString;
        }
        return readString;
    }

    public String getAndroidID() {
        String string = Secure.getString(this.context.getContentResolver(), "android_id");
        MobLog.getInstance().m4381i("getAndroidID === " + string, new Object[0]);
        return string;
    }

    public String getAppLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    public String getAppName() {
        String str = this.context.getApplicationInfo().name;
        if (str != null) {
            return str;
        }
        int i = this.context.getApplicationInfo().labelRes;
        return i > 0 ? this.context.getString(i) : String.valueOf(this.context.getApplicationInfo().nonLocalizedLabel);
    }

    public int getAppVersion() {
        int i = 0;
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
            return i;
        }
    }

    public String getAppVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
            return BuildConfig.VERSION_NAME;
        }
    }

    public String getBluetoothName() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("an");
            stringBuilder.append("dr");
            stringBuilder.append("oi");
            stringBuilder.append("d.");
            stringBuilder.append("bl");
            stringBuilder.append("ue");
            stringBuilder.append("to");
            stringBuilder.append("ot");
            stringBuilder.append("h.");
            stringBuilder.append("Bl");
            stringBuilder.append("ue");
            stringBuilder.append("to");
            stringBuilder.append("ot");
            stringBuilder.append("hA");
            stringBuilder.append("da");
            stringBuilder.append("pt");
            stringBuilder.append("er");
            ReflectHelper.importClass(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tD");
            stringBuilder.append("ef");
            stringBuilder.append("au");
            stringBuilder.append("lt");
            stringBuilder.append("Ad");
            stringBuilder.append("ap");
            stringBuilder.append("te");
            stringBuilder.append("r");
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod("BluetoothAdapter", stringBuilder.toString(), new Object[0]);
            if (invokeStaticMethod != null && checkPermission("android.permission.BLUETOOTH")) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("ge");
                stringBuilder2.append("tN");
                stringBuilder2.append("am");
                stringBuilder2.append("e");
                return (String) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, stringBuilder2.toString(), new Object[0]);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
        return null;
    }

    public String getBssid() {
        try {
            if (!checkPermission(MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return null;
            }
            Object systemService = getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (systemService == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tC");
            stringBuilder.append("on");
            stringBuilder.append("ne");
            stringBuilder.append("ct");
            stringBuilder.append("io");
            stringBuilder.append("nI");
            stringBuilder.append("nf");
            stringBuilder.append("o");
            systemService = ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (systemService == null) {
                return null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tB");
            stringBuilder.append("SS");
            stringBuilder.append("ID");
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (str == null) {
                str = null;
            }
            return str;
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
            return null;
        }
    }

    public String getCarrier() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tS");
            stringBuilder.append(IXAdRequestInfo.IMSI);
            stringBuilder.append("Op");
            stringBuilder.append("er");
            stringBuilder.append(IXAdRequestInfo.AD_TYPE);
            stringBuilder.append("or");
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            return TextUtils.isEmpty(str) ? "-1" : str;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return "-1";
        }
    }

    public String getCarrierName() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            if (!checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tS");
            stringBuilder.append(IXAdRequestInfo.IMSI);
            stringBuilder.append("Op");
            stringBuilder.append("er");
            stringBuilder.append(IXAdRequestInfo.AD_TYPE);
            stringBuilder.append("or");
            stringBuilder.append("Na");
            stringBuilder.append("me");
            CharSequence charSequence = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = null;
            }
            return charSequence;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    public int getCellId() {
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION")) {
                Object systemService = getSystemService("phone");
                if (systemService != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ge");
                    stringBuilder.append("tC");
                    stringBuilder.append("el");
                    stringBuilder.append("lL");
                    stringBuilder.append("oc");
                    stringBuilder.append(IXAdRequestInfo.AD_TYPE);
                    stringBuilder.append("io");
                    stringBuilder.append(IXAdRequestInfo.AD_COUNT);
                    systemService = ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                    if (systemService != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("ge");
                        stringBuilder.append("tC");
                        stringBuilder.append(AgooConstants.MESSAGE_ID);
                        return ((Integer) C4021R.forceCast(ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]), Integer.valueOf(-1))).intValue();
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
        return -1;
    }

    public int getCellLac() {
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION")) {
                Object systemService = getSystemService("phone");
                if (systemService != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ge");
                    stringBuilder.append("tC");
                    stringBuilder.append("el");
                    stringBuilder.append("lL");
                    stringBuilder.append("oc");
                    stringBuilder.append(IXAdRequestInfo.AD_TYPE);
                    stringBuilder.append("io");
                    stringBuilder.append(IXAdRequestInfo.AD_COUNT);
                    systemService = ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                    if (systemService != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("ge");
                        stringBuilder.append("tL");
                        stringBuilder.append("ac");
                        return ((Integer) C4021R.forceCast(ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]), Integer.valueOf(-1))).intValue();
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
        return -1;
    }

    public String getCharAndNumr(int i) {
        long currentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(currentTimeMillis);
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            if ("char".equalsIgnoreCase(random.nextInt(2) % 2 == 0 ? "char" : "num")) {
                stringBuffer.insert(i2 + 1, (char) (random.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), random.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public String getDetailNetworkTypeForStatic() {
        String toLowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(toLowerCase) || PushBuildConfig.sdk_conf_debug_level.equals(toLowerCase)) ? PushBuildConfig.sdk_conf_debug_level : toLowerCase.startsWith(UtilityImpl.NET_TYPE_WIFI) ? UtilityImpl.NET_TYPE_WIFI : toLowerCase.startsWith(UtilityImpl.NET_TYPE_4G) ? UtilityImpl.NET_TYPE_4G : toLowerCase.startsWith(UtilityImpl.NET_TYPE_3G) ? UtilityImpl.NET_TYPE_3G : toLowerCase.startsWith(UtilityImpl.NET_TYPE_2G) ? UtilityImpl.NET_TYPE_2G : toLowerCase.startsWith("bluetooth") ? "bluetooth" : toLowerCase;
    }

    public String getDeviceData() {
        return Base64AES(getModel() + "|" + getOSVersionInt() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize(), getDeviceKey().substring(0, 16));
    }

    public String getDeviceDataNotAES() {
        return getModel() + "|" + getOSVersion() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize();
    }

    public String getDeviceId() {
        String imei = getIMEI();
        return (!TextUtils.isEmpty(imei) || VERSION.SDK_INT < 9) ? imei : getSerialno();
    }

    public String getDeviceKey() {
        String localDeviceKey;
        String str = null;
        try {
            localDeviceKey = getLocalDeviceKey();
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            localDeviceKey = str;
        }
        if (TextUtils.isEmpty(localDeviceKey) || localDeviceKey.length() < 40) {
            try {
                localDeviceKey = getMacAddress();
                str = Data.byteToHex(Data.SHA1(localDeviceKey + ":" + getDeviceId() + ":" + getModel()));
            } catch (Throwable th2) {
                MobLog.getInstance().m4376d(th2);
            }
            localDeviceKey = (TextUtils.isEmpty(str) || str.length() < 40) ? getCharAndNumr(40) : str;
            if (localDeviceKey != null) {
                try {
                    saveLocalDeviceKey(localDeviceKey);
                } catch (Throwable th3) {
                    MobLog.getInstance().m4388w(th3);
                }
            }
        }
        return localDeviceKey;
    }

    public String getDeviceType() {
        UiModeManager uiModeManager = (UiModeManager) getSystemService("uimode");
        if (uiModeManager != null) {
            switch (uiModeManager.getCurrentModeType()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return "NO_UI";
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return "DESK";
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return "CAR";
                case SpdyProtocol.QUIC /*4*/:
                    return "TELEVISION";
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    return "APPLIANCE";
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    return "WATCH";
            }
        }
        return "UNDEFINED";
    }

    public String getIMEI() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        CharSequence charSequence;
        try {
            if (checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ge");
                stringBuilder.append("tD");
                stringBuilder.append("ev");
                stringBuilder.append("ic");
                stringBuilder.append("eI");
                stringBuilder.append("d");
                charSequence = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                return TextUtils.isEmpty(charSequence) ? charSequence : null;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        charSequence = null;
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public String getIMSI() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        CharSequence charSequence;
        try {
            if (checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ge");
                stringBuilder.append("tS");
                stringBuilder.append("ub");
                stringBuilder.append("sc");
                stringBuilder.append("ri");
                stringBuilder.append("be");
                stringBuilder.append("rI");
                stringBuilder.append("d");
                charSequence = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                return TextUtils.isEmpty(charSequence) ? charSequence : null;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        charSequence = null;
        if (TextUtils.isEmpty(charSequence)) {
        }
    }

    public String getIPAddress() {
        try {
            if (checkPermission(MsgConstant.PERMISSION_INTERNET)) {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        return "0.0.0.0";
    }

    public ArrayList<HashMap<String, String>> getInstalledApp(boolean z) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pm");
            stringBuilder.append(" l");
            stringBuilder.append("is");
            stringBuilder.append("t ");
            stringBuilder.append("pa");
            stringBuilder.append("ck");
            stringBuilder.append("ag");
            stringBuilder.append("es");
            Process exec = Runtime.getRuntime().exec(stringBuilder.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "utf-8"));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                readLine = readLine.toLowerCase().trim();
                if (readLine.startsWith("package:")) {
                    arrayList.add(readLine.substring("package:".length()).trim());
                }
            }
            bufferedReader.close();
            exec.destroy();
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return new ArrayList();
        }
        ArrayList<HashMap<String, String>> arrayList2 = new ArrayList();
        PackageManager packageManager = this.context.getPackageManager();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo((String) it.next(), 0);
            } catch (Throwable th2) {
                MobLog.getInstance().m4376d(th2);
            }
            if (packageInfo != null) {
                if (!z) {
                    if (isSystemApp(packageInfo)) {
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put(com.taobao.accs.common.Constants.KEY_ELECTION_PKG, packageInfo.packageName);
                Object obj = packageInfo.applicationInfo.name;
                if (obj == null) {
                    int i = packageInfo.applicationInfo.labelRes;
                    if (i > 0) {
                        CharSequence text = packageManager.getText(packageInfo.packageName, i, packageInfo.applicationInfo);
                        if (text != null) {
                            obj = text.toString().trim();
                        }
                    }
                    if (obj == null) {
                        obj = String.valueOf(packageInfo.applicationInfo.nonLocalizedLabel);
                    }
                }
                hashMap.put("name", obj);
                hashMap.put(com.taobao.accs.common.Constants.SP_KEY_VERSION, packageInfo.versionName);
                arrayList2.add(hashMap);
            }
        }
        return arrayList2;
    }

    public String getLine1Number() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tL");
            stringBuilder.append("in");
            stringBuilder.append("e1");
            stringBuilder.append("Nu");
            stringBuilder.append("mb");
            stringBuilder.append("er");
            return (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return "-1";
        }
    }

    public Location getLocation(int i, int i2, boolean z) {
        try {
            if (checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
                return new LocationHelper().getLocation(this.context, i, i2, z);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
        }
        return null;
    }

    public float[] getLocation(int i, int i2) {
        if (getLocation(i, i2, true) == null) {
            return null;
        }
        return new float[]{(float) getLocation(i, i2, true).getLatitude(), (float) getLocation(i, i2, true).getLongitude()};
    }

    public String getMCC() {
        String imsi = getIMSI();
        return (imsi == null || imsi.length() < 3) ? null : imsi.substring(0, 3);
    }

    public String getMNC() {
        String imsi = getIMSI();
        return (imsi == null || imsi.length() < 5) ? null : imsi.substring(3, 5);
    }

    public String getMacAddress() {
        String hardwareAddressFromShell;
        if (VERSION.SDK_INT >= 23) {
            try {
                hardwareAddressFromShell = getHardwareAddressFromShell("wlan0");
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
                hardwareAddressFromShell = null;
            }
            if (hardwareAddressFromShell == null) {
                try {
                    hardwareAddressFromShell = getCurrentNetworkHardwareAddress();
                } catch (Throwable th2) {
                    MobLog.getInstance().m4376d(th2);
                    hardwareAddressFromShell = null;
                }
            }
            if (hardwareAddressFromShell == null) {
                try {
                    String[] listNetworkHardwareAddress = listNetworkHardwareAddress();
                    if (listNetworkHardwareAddress.length > 0) {
                        hardwareAddressFromShell = listNetworkHardwareAddress[0];
                    }
                } catch (Throwable th22) {
                    MobLog.getInstance().m4376d(th22);
                    hardwareAddressFromShell = null;
                }
            }
            if (hardwareAddressFromShell != null) {
                return hardwareAddressFromShell;
            }
        }
        try {
            Object systemService = getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (systemService == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tC");
            stringBuilder.append("on");
            stringBuilder.append("ne");
            stringBuilder.append("ct");
            stringBuilder.append("io");
            stringBuilder.append("nI");
            stringBuilder.append("nf");
            stringBuilder.append("o");
            systemService = ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (systemService == null) {
                return null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tM");
            stringBuilder.append("ac");
            stringBuilder.append("Ad");
            stringBuilder.append("dr");
            stringBuilder.append("es");
            stringBuilder.append("s");
            hardwareAddressFromShell = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (hardwareAddressFromShell == null) {
                hardwareAddressFromShell = null;
            }
            return hardwareAddressFromShell;
        } catch (Throwable th222) {
            MobLog.getInstance().m4388w(th222);
            return null;
        }
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getMime() {
        return getIMEI();
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getNetworkOperator() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tN");
            stringBuilder.append("et");
            stringBuilder.append("wo");
            stringBuilder.append("rk");
            stringBuilder.append("Op");
            stringBuilder.append("er");
            stringBuilder.append(IXAdRequestInfo.AD_TYPE);
            stringBuilder.append("or");
            return (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    public String getNetworkType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (connectivityManager == null) {
            return PushBuildConfig.sdk_conf_debug_level;
        }
        try {
            if (!checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                return PushBuildConfig.sdk_conf_debug_level;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return PushBuildConfig.sdk_conf_debug_level;
            }
            int type = activeNetworkInfo.getType();
            switch (type) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return is4GMobileNetwork() ? "4G" : isFastMobileNetwork() ? "3G" : "2G";
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return UtilityImpl.NET_TYPE_WIFI;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    return "wimax";
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    return "bluetooth";
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    return "dummy";
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    return "ethernet";
                default:
                    return String.valueOf(type);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return PushBuildConfig.sdk_conf_debug_level;
        }
    }

    public String getNetworkTypeForStatic() {
        String toLowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(toLowerCase) || PushBuildConfig.sdk_conf_debug_level.equals(toLowerCase)) ? PushBuildConfig.sdk_conf_debug_level : (toLowerCase.startsWith(UtilityImpl.NET_TYPE_4G) || toLowerCase.startsWith(UtilityImpl.NET_TYPE_3G) || toLowerCase.startsWith(UtilityImpl.NET_TYPE_2G)) ? "cell" : toLowerCase.startsWith(UtilityImpl.NET_TYPE_WIFI) ? UtilityImpl.NET_TYPE_WIFI : "other";
    }

    public String getOSCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getOSLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public String getOSVersion() {
        return String.valueOf(getOSVersionInt());
    }

    public int getOSVersionInt() {
        return VERSION.SDK_INT;
    }

    public String getOSVersionName() {
        return VERSION.RELEASE;
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public int getPlatformCode() {
        return 1;
    }

    public JSONArray getRunningApp() {
        JSONArray jSONArray = new JSONArray();
        Object systemService = getSystemService("activity");
        if (systemService == null) {
            return jSONArray;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tR");
            stringBuilder.append("un");
            stringBuilder.append("ni");
            stringBuilder.append("ng");
            stringBuilder.append("Ap");
            stringBuilder.append("pP");
            stringBuilder.append("ro");
            stringBuilder.append("ce");
            stringBuilder.append("ss");
            stringBuilder.append("es");
            List list = (List) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (list == null) {
                return jSONArray;
            }
            for (Object next : list) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("pr");
                stringBuilder2.append("oc");
                stringBuilder2.append("es");
                stringBuilder2.append("sN");
                stringBuilder2.append("am");
                stringBuilder2.append("e");
                jSONArray.put(ReflectHelper.getInstanceField(next, stringBuilder2.toString()));
            }
            return jSONArray;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public String getRunningAppStr() {
        JSONArray runningApp = getRunningApp();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < runningApp.length(); i++) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(String.valueOf(runningApp.get(i)));
        }
        return stringBuilder.toString();
    }

    public String getSSID() {
        try {
            if (!checkPermission(MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return null;
            }
            Object systemService = getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (systemService == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tC");
            stringBuilder.append("on");
            stringBuilder.append("ne");
            stringBuilder.append("ct");
            stringBuilder.append("io");
            stringBuilder.append("nI");
            stringBuilder.append("nf");
            stringBuilder.append("o");
            systemService = ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (systemService == null) {
                return null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tS");
            stringBuilder.append("SI");
            stringBuilder.append("D");
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            return str == null ? null : str.replace("\"", BuildConfig.FLAVOR);
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
            return null;
        }
    }

    public String getScreenSize() {
        int[] screenSize = C4021R.getScreenSize(this.context);
        return this.context.getResources().getConfiguration().orientation == 1 ? screenSize[0] + "x" + screenSize[1] : screenSize[1] + "x" + screenSize[0];
    }

    public String getSdcardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public boolean getSdcardState() {
        try {
            return checkPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) && "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return false;
        }
    }

    public String getSerialno() {
        if (VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("an");
            stringBuilder.append("dr");
            stringBuilder.append("oi");
            stringBuilder.append("d.");
            stringBuilder.append(com.taobao.accs.common.Constants.KEY_OS_VERSION);
            stringBuilder.append(".S");
            stringBuilder.append("ys");
            stringBuilder.append("te");
            stringBuilder.append("mP");
            stringBuilder.append("ro");
            stringBuilder.append("pe");
            stringBuilder.append("rt");
            stringBuilder.append("ie");
            stringBuilder.append("s");
            ReflectHelper.importClass(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append(C0714a.TIMESTAMP);
            return (String) ReflectHelper.invokeStaticMethod("SystemProperties", stringBuilder.toString(), "ro.serialno", UtilityImpl.NET_TYPE_UNKNOWN);
        } catch (Throwable th) {
            MobLog.getInstance().m4376d(th);
            return null;
        }
    }

    public String getSignMD5() {
        try {
            return Data.MD5(this.context.getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (Throwable e) {
            MobLog.getInstance().m4388w(e);
            return null;
        }
    }

    public String getSimSerialNumber() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tS");
            stringBuilder.append(IXAdRequestInfo.IMSI);
            stringBuilder.append("Se");
            stringBuilder.append("ri");
            stringBuilder.append("al");
            stringBuilder.append("Nu");
            stringBuilder.append("mb");
            stringBuilder.append("er");
            return (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return "-1";
        }
    }

    public String getTopTaskPackageName() {
        boolean checkPermission;
        try {
            checkPermission = checkPermission(MsgConstant.PERMISSION_GET_TASKS);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            checkPermission = false;
        }
        if (checkPermission) {
            try {
                Object systemService = getSystemService("activity");
                if (systemService == null) {
                    return null;
                }
                StringBuilder stringBuilder;
                List list;
                if (VERSION.SDK_INT <= 20) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ge");
                    stringBuilder.append("tR");
                    stringBuilder.append("un");
                    stringBuilder.append("ni");
                    stringBuilder.append("ng");
                    stringBuilder.append("Ta");
                    stringBuilder.append("sk");
                    stringBuilder.append("s");
                    list = (List) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), Integer.valueOf(1));
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("to");
                    stringBuilder.append("pA");
                    stringBuilder.append("ct");
                    stringBuilder.append("iv");
                    stringBuilder.append("it");
                    stringBuilder.append("y");
                    systemService = ReflectHelper.getInstanceField(list.get(0), stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ge");
                    stringBuilder.append("tP");
                    stringBuilder.append("ac");
                    stringBuilder.append("ka");
                    stringBuilder.append("ge");
                    stringBuilder.append("Na");
                    stringBuilder.append("me");
                    return (String) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("ge");
                stringBuilder.append("tR");
                stringBuilder.append("un");
                stringBuilder.append("ni");
                stringBuilder.append("ng");
                stringBuilder.append("Ap");
                stringBuilder.append("pP");
                stringBuilder.append("ro");
                stringBuilder.append("ce");
                stringBuilder.append("ss");
                stringBuilder.append("es");
                list = (List) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
                stringBuilder = new StringBuilder();
                stringBuilder.append("pr");
                stringBuilder.append("oc");
                stringBuilder.append("es");
                stringBuilder.append("sN");
                stringBuilder.append("am");
                stringBuilder.append("e");
                return ((String) ReflectHelper.getInstanceField(list.get(0), stringBuilder.toString())).split(":")[0];
            } catch (Throwable th2) {
                MobLog.getInstance().m4388w(th2);
            }
        }
        return null;
    }

    public void hideSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public boolean isMainProcess(int i) {
        try {
            Object systemService = getSystemService("activity");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ge");
            stringBuilder.append("tR");
            stringBuilder.append("un");
            stringBuilder.append("ni");
            stringBuilder.append("ng");
            stringBuilder.append("Ap");
            stringBuilder.append("pP");
            stringBuilder.append("ro");
            stringBuilder.append("ce");
            stringBuilder.append("ss");
            stringBuilder.append("es");
            List list = (List) ReflectHelper.invokeInstanceMethod(systemService, stringBuilder.toString(), new Object[0]);
            if (list == null) {
                return i <= 0;
            } else {
                if (i <= 0) {
                    i = Process.myPid();
                }
                for (Object next : list) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("pi");
                    stringBuilder2.append("d");
                    if (((Integer) ReflectHelper.getInstanceField(next, stringBuilder2.toString())).intValue() == i) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("pr");
                        stringBuilder2.append("oc");
                        stringBuilder2.append("es");
                        stringBuilder2.append("sN");
                        stringBuilder2.append("am");
                        stringBuilder2.append("e");
                        systemService = (String) ReflectHelper.getInstanceField(next, stringBuilder2.toString());
                        break;
                    }
                }
                systemService = null;
                return getPackageName().equals(systemService);
            }
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return false;
        }
    }

    public boolean isRooted() {
        return false;
    }

    public HashMap<String, String> ping(String str, int i, int i2) {
        int indexOf;
        float f;
        float floatValue;
        float f2 = 0.0f;
        ArrayList arrayList = new ArrayList();
        int i3 = i2 + 8;
        Process exec = Runtime.getRuntime().exec("ping -c " + i + " -s " + i2 + " " + str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            if (readLine.startsWith(i3 + " bytes from")) {
                if (readLine.endsWith("ms")) {
                    readLine = readLine.substring(0, readLine.length() - 2).trim();
                } else if (readLine.endsWith("s")) {
                    readLine = readLine.substring(0, readLine.length() - 1).trim() + "000";
                }
                indexOf = readLine.indexOf("time=");
                if (indexOf > 0) {
                    try {
                        arrayList.add(Float.valueOf(Float.parseFloat(readLine.substring(indexOf + 5).trim())));
                    } catch (Throwable th) {
                        MobLog.getInstance().m4376d(th);
                    }
                }
            }
            readLine = bufferedReader.readLine();
        }
        exec.waitFor();
        indexOf = arrayList.size();
        int size = i - arrayList.size();
        if (indexOf > 0) {
            float f3 = AutoScrollHelper.NO_MAX;
            int i4 = 0;
            float f4 = 0.0f;
            f = 0.0f;
            while (i4 < indexOf) {
                floatValue = ((Float) arrayList.get(i4)).floatValue();
                if (floatValue < f3) {
                    f3 = floatValue;
                }
                i4++;
                f4 += floatValue;
                f = floatValue > f ? floatValue : f;
            }
            f2 = f4 / ((float) indexOf);
            floatValue = f3;
        } else {
            f = 0.0f;
            floatValue = 0.0f;
        }
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("address", str);
        hashMap.put("transmitted", String.valueOf(i));
        hashMap.put("received", String.valueOf(indexOf));
        hashMap.put("loss", String.valueOf(size));
        hashMap.put("min", String.valueOf(floatValue));
        hashMap.put("max", String.valueOf(f));
        hashMap.put("avg", String.valueOf(f2));
        return hashMap;
    }

    public void showSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
        }
    }
}
