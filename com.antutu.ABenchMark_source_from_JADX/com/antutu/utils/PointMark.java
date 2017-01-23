package com.antutu.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.support.v4.view.MotionEventCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1534l;
import com.antutu.benchmark.model.C1536n;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

public class PointMark {
    public static final String E_ABOUT = "event_about";
    public static final String E_BATTERYTEST = "event_batterytest";
    public static final String E_CUSTOMTEST = "event_customtest";
    public static final String E_EXIST_APP_DOWNLOAD_CM = "event_exist_app_download_cm";
    public static final String E_FEEDBACK = "event_feedback";
    public static final String E_HOME_DOWNLOAD_CM = "event_home_download_cm";
    public static final String E_HTML5TEST = "event_html5test";
    public static final String E_MULTI = "event_multitouch";
    public static final String E_SCREEN_COLORLINE = "event_screen_colorline";
    public static final String E_SCREEN_HUIJIE = "event_screen_huijie";
    public static final String E_SCREEN_MONITOR = "event_screent_monitor";
    public static final String E_SEARCH = "event_search";
    public static final String E_START_CLEAN_GARBAGE = "event_start_clean_garbage";
    public static final String E_START_DOWNLOAD_CM = "event_start_download_cm";
    public static final String E_START_DOWNLOAD_CM_SINGLE = "event_start_download_cm_single";
    public static final String E_START_VERIFYMOBILE = "event_start_verifymobile_y";
    public static final String E_VIDEOTEST = "event_videotest";
    private static final int KEY_SUC = 1;
    private static final int KEY_SUC_SINGLE_VALUE = 2;
    public static final String K_CLEAN_GARBAGE = "_cleanGarbagePage";
    public static final String K_COMPARE = "_comparePage";
    public static final String K_DETAIL_SCORES_CLEAN_GARBAGE = "_detail_scores_cleanGarbagePage";
    public static final String K_DEVICEINO = "_devPage";
    public static final String K_FEATURE_CLEAN_GARBAGE = "_feature_cleanGarbagePage";
    public static final String K_FEEDBACK = "_feedbackPage";
    public static final String K_Localization = "_localizationPage";
    public static final String K_MAIN_UI = "_mainPage";
    public static final String K_RANK_UI = "_rankpage";
    public static final String K_SCREEN = "_screenPage";
    public static final String K_SEARCHRESULT = "_searchresultPage";
    public static final String K_SETTING = "_settingPage";
    public static final String K_STABILITY_CLEAN_GARBAGE = "_stability_cleanGarbagePage";
    public static final String PARAMS_VALUE = "params_value";
    public static final String PREFS_NAME = "point_file";
    private static final long TIME_TANCE = 28800000;
    public static final String TOTAL_TAG = "trak_tag";
    public static final String T_BRAND = "brand";
    public static final String T_IME = "imei";
    public static final String T_LANG = "lang";
    public static final String T_MAC = "mac";
    public static final String T_MODEL = "model";
    public static final String T_MODELID = "model_id";
    public static final String T_SIZE = "hard_size";
    public static final String T_TOKEN = "token";
    public static final String T_VER = "version";
    private static Context mContext;
    private static PointMark mPointMark;
    private DownloadJob job;
    private Editor keyEditor;
    private SharedPreferences keyTool;
    private String keyURL;
    private Handler mHandler;
    private ArrayList<String> mSingleList;
    private ArrayList<String> mTagArr;
    private TrackListener mTrackListener;
    private Object[] obj;
    private Editor pointEditor;
    private SharedPreferences pointTool;
    private String requestURL;
    private String str;

    /* renamed from: com.antutu.utils.PointMark.1 */
    class C18021 extends Handler {
        C18021() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case PointMark.KEY_SUC /*1*/:
                    PointMark.this.trackData(message.obj);
                case PointMark.KEY_SUC_SINGLE_VALUE /*2*/:
                    PointMark.this.trackSingleValue(message.obj);
                default:
            }
        }
    }

    /* renamed from: com.antutu.utils.PointMark.2 */
    class C18032 implements DownloadJobListener {
        C18032() {
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k == null) {
                PointMark.this.trackDataResult(false);
                return;
            }
            boolean access$200 = PointMark.this.trackDataResult(true);
            if (((C1536n) c1519k).m6080a() == 0) {
                PointMark.this.str = null;
                PointMark.this.obj = null;
            }
            if (access$200) {
                PointMark.this.cleanFileData();
            }
            PointMark.this.trackFunctionExcute();
        }
    }

    /* renamed from: com.antutu.utils.PointMark.3 */
    class C18043 implements DownloadJobListener {
        C18043() {
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k == null) {
                try {
                    PointMark.this.trackKeyResult(false);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            PointMark.this.trackKeyResult(true);
            if (PointMark.this.keyTool == null || PointMark.this.keyEditor == null) {
                PointMark.this.reCreate();
            }
            C1534l c1534l = (C1534l) c1519k;
            PointMark.this.keyEditor.putString("SESSION_ID", c1534l.f5341a);
            PointMark.this.keyEditor.putString("SESSION_STRING", c1534l.f5342b);
            PointMark.this.keyEditor.putString("SESSION_TIME", String.valueOf(System.currentTimeMillis()));
            PointMark.this.keyEditor.commit();
            Message message = new Message();
            message.what = PointMark.KEY_SUC;
            message.obj = c1534l;
            PointMark.this.mHandler.sendMessage(message);
        }
    }

    /* renamed from: com.antutu.utils.PointMark.4 */
    class C18054 implements DownloadJobListener {
        final /* synthetic */ String val$tag;

        C18054(String str) {
            this.val$tag = str;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k == null) {
                try {
                    PointMark.this.trackKeyResult(false);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            PointMark.this.trackKeyResult(true);
            if (PointMark.this.keyTool == null || PointMark.this.keyEditor == null) {
                PointMark.this.reCreate();
            }
            C1534l c1534l = (C1534l) c1519k;
            c1534l.f5343c = this.val$tag;
            PointMark.this.keyEditor.putString("SESSION_ID", c1534l.f5341a);
            PointMark.this.keyEditor.putString("SESSION_STRING", c1534l.f5342b);
            PointMark.this.keyEditor.putString("SESSION_TIME", String.valueOf(System.currentTimeMillis()));
            PointMark.this.keyEditor.commit();
            Message message = new Message();
            message.what = PointMark.KEY_SUC_SINGLE_VALUE;
            message.obj = c1534l;
            PointMark.this.mHandler.sendMessage(message);
        }
    }

    /* renamed from: com.antutu.utils.PointMark.5 */
    class C18065 implements DownloadJobListener {
        C18065() {
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k == null) {
                PointMark.this.trackDataResult(false);
            } else if (((C1536n) c1519k).m6080a() == 0) {
                PointMark.this.str = null;
                PointMark.this.obj = null;
            }
        }
    }

    private PointMark() {
        this.mTagArr = new ArrayList();
        this.mSingleList = new ArrayList();
        this.requestURL = null;
        this.keyURL = null;
        this.mHandler = new C18021();
        this.pointTool = mContext.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        this.pointEditor = this.pointTool.edit();
        this.mTagArr.clear();
        this.mTagArr.add(T_IME);
        this.mTagArr.add(T_MAC);
        this.mTagArr.add(T_TOKEN);
        this.mTagArr.add(T_MODELID);
        this.mTagArr.add(T_BRAND);
        this.mTagArr.add(T_MODEL);
        this.mTagArr.add(T_LANG);
        this.mTagArr.add(T_VER);
        this.mTagArr.add(T_SIZE);
        this.mSingleList.clear();
        this.mSingleList.add(T_IME);
        this.mSingleList.add(T_MAC);
        this.mSingleList.add(T_TOKEN);
        this.mSingleList.add(T_MODELID);
        this.mSingleList.add(T_BRAND);
        this.mSingleList.add(T_MODEL);
        this.mSingleList.add(T_LANG);
        this.mSingleList.add(T_VER);
        this.mSingleList.add(T_SIZE);
        setHeadData();
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        String str = BuildConfig.FLAVOR;
        int length = bArr.length;
        StringBuffer stringBuffer2 = stringBuffer;
        for (int i = 0; i < length; i += KEY_SUC) {
            String toHexString = Integer.toHexString(bArr[i] & MotionEventCompat.ACTION_MASK);
            stringBuffer2 = toHexString.length() == KEY_SUC ? stringBuffer2.append(MessageService.MSG_DB_READY_REPORT).append(toHexString) : stringBuffer2.append(toHexString);
        }
        return String.valueOf(stringBuffer2);
    }

    private boolean checkIn(String str) {
        int size = this.mTagArr.size();
        for (int i = 0; i < size; i += KEY_SUC) {
            if (((String) this.mTagArr.get(i)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static PointMark getInstance(Context context) {
        mContext = context;
        if (mPointMark == null) {
            synchronized (PointMark.class) {
                if (mPointMark == null) {
                    mPointMark = new PointMark();
                }
            }
        }
        return mPointMark;
    }

    private C1534l getKey() {
        this.keyTool = mContext.getApplicationContext().getSharedPreferences("key_txt", 0);
        String string = this.keyTool.getString("SESSION_ID", BuildConfig.FLAVOR);
        String string2 = this.keyTool.getString("SESSION_STRING", BuildConfig.FLAVOR);
        if (System.currentTimeMillis() - Long.parseLong(this.keyTool.getString("SESSION_TIME", MessageService.MSG_DB_READY_REPORT)) > TIME_TANCE || BuildConfig.FLAVOR.equals(string) || BuildConfig.FLAVOR.equals(string2)) {
            return null;
        }
        C1534l c1534l = new C1534l();
        c1534l.f5341a = string;
        c1534l.f5342b = string2;
        return c1534l;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            MLog.m6868e("WifiPreference IpAddress", e.toString());
        }
        return null;
    }

    public static String getLocalLanguage(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        return (language == null || !language.contains("zh")) ? language : (country == null || country.contains("CN")) ? "CN" : "TW";
    }

    private String getSGID() {
        String str;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            Class[] clsArr = new Class[KEY_SUC];
            clsArr[0] = String.class;
            Method method = cls.getMethod("get", clsArr);
            Object[] objArr = new Object[KEY_SUC];
            objArr[0] = "ro.serialno";
            str = (String) method.invoke(cls, objArr);
        } catch (Exception e) {
            str = null;
        }
        return (str == null || str.length() <= 10) ? System.getString(mContext.getApplicationContext().getContentResolver(), "android_id") : str;
    }

    public static String getVersionCode() {
        try {
            return mContext.getApplicationContext().getPackageManager().getPackageInfo(mContext.getApplicationContext().getPackageName(), 0).versionCode + BuildConfig.FLAVOR;
        } catch (NameNotFoundException e) {
            return MessageService.MSG_DB_READY_REPORT;
        }
    }

    private void reCreate() {
        this.keyTool = mContext.getApplicationContext().getSharedPreferences("key_txt", 0);
        this.keyEditor = this.keyTool.edit();
    }

    private void requestForKey() {
        HashMap hashMap = new HashMap();
        hashMap.put(T_IME, getImei(mContext.getApplicationContext(), false));
        this.job = new DownloadJob(mContext, this.keyURL, new C1534l(), hashMap);
        this.job.setDownloadJobListener(new C18043());
        this.job.start();
    }

    private void requestKeyForLimitValue(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(T_IME, getImei(mContext.getApplicationContext(), false));
        this.job = new DownloadJob(mContext, this.keyURL, new C1534l(), hashMap);
        this.job.setDownloadJobListener(new C18054(str));
        this.job.start();
    }

    private String setPerferenceDataBack() {
        int size = this.mTagArr.size();
        this.obj = new Object[size];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i += KEY_SUC) {
            int i2;
            String str = (String) this.mTagArr.get(i);
            if (i != size - 1) {
                stringBuilder.append(str).append("=%s&");
            } else {
                stringBuilder.append(str).append("=%s");
            }
            String str2 = BuildConfig.FLAVOR;
            if (i < 9) {
                this.obj[i] = this.pointTool.getString((String) this.mTagArr.get(i), BuildConfig.FLAVOR);
                i2 = 0;
            } else {
                i2 = this.pointTool.getInt((String) this.mTagArr.get(i), 0);
                this.obj[i] = Integer.valueOf(i2);
            }
            MLog.m6865d("dataTag", "tag:" + str + "--value:" + i2);
        }
        this.str = stringBuilder.toString();
        return String.format(this.str, this.obj);
    }

    private String setPerferenceSingleDataBack(String str) {
        this.mSingleList.add(str);
        int size = this.mSingleList.size();
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i += KEY_SUC) {
            String str2 = (String) this.mSingleList.get(i);
            if (i != size - 1) {
                stringBuilder.append(str2).append("=%s&");
            } else {
                stringBuilder.append(str2).append("=%s");
            }
            if (i < 9) {
                objArr[i] = this.pointTool.getString((String) this.mTagArr.get(i), BuildConfig.FLAVOR);
            } else {
                objArr[i] = Integer.valueOf(KEY_SUC);
            }
        }
        return String.format(stringBuilder.toString(), objArr);
    }

    private void trackData(Object obj) {
        C1534l c1534l = (C1534l) obj;
        if (this.str == null) {
            setPerferenceDataBack();
        }
        String eightKey = getEightKey();
        eightKey = jni.getDataSafe(this.str, getScretKey(eightKey, c1534l)) + eightKey;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_DATA, eightKey);
        hashMap.put("SESSION-ID", c1534l.f5341a);
        hashMap.put(T_LANG, getLocalLanguage(mContext.getApplicationContext()));
        this.job = new DownloadJob(mContext.getApplicationContext(), this.requestURL, new C1536n(c1534l.f5342b), hashMap);
        this.job.setDownloadJobListener(new C18032());
        this.job.start();
    }

    private boolean trackDataResult(boolean z) {
        return this.mTrackListener == null ? false : this.mTrackListener.trackDataListener(z);
    }

    private void trackFunctionExcute() {
        if (this.mTrackListener != null) {
            this.mTrackListener.exeFunction();
        }
    }

    private void trackKey() {
        if (isNetworkConnected(mContext.getApplicationContext())) {
            requestForKey();
        }
    }

    private void trackKeyResult(boolean z) {
        if (this.mTrackListener != null) {
            this.mTrackListener.trackKeyListener(z);
        }
    }

    private void trackSingleValue(Object obj) {
        C1534l c1534l = (C1534l) obj;
        String perferenceSingleDataBack = setPerferenceSingleDataBack(c1534l.f5343c);
        String eightKey = getEightKey();
        perferenceSingleDataBack = jni.getDataSafe(perferenceSingleDataBack, getScretKey(eightKey, c1534l)) + eightKey;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_DATA, perferenceSingleDataBack);
        hashMap.put("SESSION-ID", c1534l.f5341a);
        hashMap.put(T_LANG, getLocalLanguage(mContext.getApplicationContext()));
        this.job = new DownloadJob(mContext.getApplicationContext(), this.requestURL, new C1536n(c1534l.f5342b), hashMap);
        this.job.setDownloadJobListener(new C18065());
        this.job.start();
    }

    public void cleanFileData() {
        setHeadData();
    }

    public ArrayList<String> getArrayList() {
        return this.mTagArr;
    }

    public String getDataParams() {
        return setPerferenceDataBack();
    }

    public String getDevHardSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return String.valueOf(new BigDecimal(Math.sqrt(Math.pow((double) displayMetrics.widthPixels, 2.0d) + Math.pow((double) displayMetrics.heightPixels, 2.0d)) / ((double) displayMetrics.ydpi)).setScale(KEY_SUC_SINGLE_VALUE, 4).doubleValue());
    }

    public final String getEightKey() {
        char[] cArr = new char[8];
        for (int i = 0; i < 8; i += KEY_SUC) {
            cArr[i] = (char) (((int) (Math.random() * 26.0d)) + 97);
        }
        return String.valueOf(cArr);
    }

    public String getImei(Context context, boolean z) {
        String deviceId;
        int i = 0;
        String str = BuildConfig.FLAVOR;
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            deviceId = str;
        }
        if (deviceId == null) {
            deviceId = BuildConfig.FLAVOR;
        }
        if (z) {
            return deviceId;
        }
        try {
            if (deviceId.startsWith("000000") || deviceId.startsWith("123456")) {
                deviceId = BuildConfig.FLAVOR;
            }
            if (deviceId.length() >= 14) {
                return deviceId;
            }
            str = Build.MODEL + Build.DEVICE + Build.MANUFACTURER + getSGID();
            try {
                MessageDigest instance = MessageDigest.getInstance("sha-1");
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                deviceId = BuildConfig.FLAVOR;
                while (i < digest.length) {
                    StringBuilder append = new StringBuilder().append(deviceId);
                    Object[] objArr = new Object[KEY_SUC];
                    objArr[0] = Integer.valueOf(digest[i] & MotionEventCompat.ACTION_MASK);
                    i += KEY_SUC;
                    deviceId = append.append(String.format("%02X", objArr)).toString();
                }
                return deviceId.length() <= 30 ? str : deviceId;
            } catch (Exception e2) {
                return str;
            }
        } catch (Exception e3) {
            return deviceId;
        }
    }

    public String getScretKey(String str, C1534l c1534l) {
        return (str + c1534l.f5342b).substring(4, 12);
    }

    public boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null ? false : activeNetworkInfo.isConnected();
    }

    public void pointThis(String str) {
        if (!checkIn(str)) {
            this.mTagArr.add(str);
        }
        int i = this.pointTool.getInt(str, 0) + KEY_SUC;
        this.pointEditor.putInt(str, i);
        this.pointEditor.commit();
        MLog.m6864d("tag:" + str + "==count:" + i);
    }

    public void pointThis(String str, int i) {
        if (!checkIn(str)) {
            this.mTagArr.add(str);
        }
        int i2 = this.pointTool.getInt(str, 0) + i;
        this.pointEditor.putInt(str, i2);
        this.pointEditor.commit();
        MLog.m6864d("tag:" + str + "==count:" + i2);
    }

    public void setHeadData() {
        String imei = getImei(mContext.getApplicationContext(), false);
        String localMacAddressFromIp = Utils.getLocalMacAddressFromIp(mContext.getApplicationContext());
        String localLanguage = getLocalLanguage(mContext.getApplicationContext());
        String str = BuildConfig.FLAVOR;
        this.pointEditor.clear().apply();
        this.pointEditor.putString(T_IME, imei);
        this.pointEditor.putString(T_MAC, localMacAddressFromIp);
        this.pointEditor.putString(T_TOKEN, str);
        this.pointEditor.putString(T_MODELID, MessageService.MSG_DB_READY_REPORT);
        this.pointEditor.putString(T_BRAND, Build.BRAND);
        this.pointEditor.putString(T_MODEL, Build.MODEL);
        this.pointEditor.putString(T_LANG, localLanguage);
        this.pointEditor.putString(T_VER, getVersionCode());
        this.pointEditor.putString(T_SIZE, getDevHardSize());
        for (int i = 9; i < this.mTagArr.size(); i += KEY_SUC) {
            this.pointEditor.putInt((String) this.mTagArr.get(i), 0);
        }
        this.pointEditor.apply();
        this.keyTool = mContext.getApplicationContext().getSharedPreferences("key_txt", 0);
        this.keyEditor = this.keyTool.edit();
    }

    public void setKeyUrl(String str) {
        this.keyURL = str;
    }

    public void setOtherContext(Context context) {
        mContext = context;
    }

    public void setParamsStr(String str) {
        this.str = str;
    }

    public void setTotalTag(ArrayList<String> arrayList) {
        this.mTagArr.clear();
        int size = arrayList.size();
        reCreate();
        for (int i = 0; i < size; i += KEY_SUC) {
            this.mTagArr.add(arrayList.get(i));
        }
    }

    public void setTrackListener(TrackListener trackListener) {
        if (trackListener != null) {
            this.mTrackListener = trackListener;
        }
    }

    public void setUrl(String str) {
        this.requestURL = str;
    }

    public void track() {
        trackKey();
    }

    public void trackLimitValue(String str) {
        C1534l key = getKey();
        if (key == null) {
            requestKeyForLimitValue(str);
            return;
        }
        key.f5343c = str;
        trackSingleValue(key);
    }
}
