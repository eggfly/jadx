package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4316c;
import com.xiaomi.channel.commonutils.network.C4317a;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManager {
    private static HostManagerFactory factory;
    protected static boolean hostLoaded;
    protected static Map<String, ArrayList<String>> mReservedHosts;
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    private final long MAX_REQUEST_FAILURE_CNT;
    private String currentISP;
    private long lastRemoteRequestTimestamp;
    protected Map<String, Fallbacks> mHostsMapping;
    private long remoteRequestFailureCount;
    protected Context sAppContext;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId;

    public interface HostManagerFactory {
        HostManager m17918a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    public interface HttpGet {
        String m17919a(String str);
    }

    static {
        mReservedHosts = new HashMap();
        hostLoaded = false;
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.mHostsMapping = new HashMap();
        this.sUserId = MessageService.MSG_DB_READY_REPORT;
        this.remoteRequestFailureCount = 0;
        this.MAX_REQUEST_FAILURE_CNT = 15;
        this.lastRemoteRequestTimestamp = 0;
        this.currentISP = "isp_prov_city_country_ip";
        this.sAppContext = context.getApplicationContext();
        if (this.sAppContext == null) {
            this.sAppContext = context;
        }
        this.sHttpGetter = httpGet;
        if (hostFilter == null) {
            this.sHostFilter = new C4364a(this);
        } else {
            this.sHostFilter = hostFilter;
        }
        this.sUserId = str;
        if (str2 == null) {
            str2 = context.getPackageName();
        }
        sAppName = str2;
        if (str3 == null) {
            str3 = getVersionName();
        }
        sAppVersion = str3;
    }

    public static void addReservedHost(String str, String str2) {
        ArrayList arrayList = (ArrayList) mReservedHosts.get(str);
        synchronized (mReservedHosts) {
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayList.add(str2);
                mReservedHosts.put(str, arrayList);
            } else if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
    }

    public static synchronized HostManager getInstance() {
        HostManager hostManager;
        synchronized (HostManager.class) {
            if (sInstance == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            hostManager = sInstance;
        }
        return hostManager;
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = this.sAppContext.getPackageManager().getPackageInfo(this.sAppContext.getPackageName(), SpdyProtocol.SLIGHTSSL_L7E);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return MessageService.MSG_DB_READY_REPORT;
    }

    public static synchronized void init(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        synchronized (HostManager.class) {
            if (sInstance == null) {
                if (factory == null) {
                    sInstance = new HostManager(context, hostFilter, httpGet, str, str2, str3);
                } else {
                    sInstance = factory.m17918a(context, hostFilter, httpGet, str);
                }
            }
        }
    }

    public static <T> String join(Collection<T> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(str);
            stringBuilder.append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    private ArrayList<Fallback> requestRemoteFallbacks(ArrayList<String> arrayList) {
        int i;
        purge();
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            for (String str : this.mHostsMapping.keySet()) {
                String str2;
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        synchronized (mReservedHosts) {
            for (String str22 : mReservedHosts.keySet()) {
                if (!arrayList.contains(str22)) {
                    arrayList.add(str22);
                }
            }
        }
        if (!arrayList.contains(getHost())) {
            arrayList.add(getHost());
        }
        ArrayList<Fallback> arrayList2 = new ArrayList(arrayList.size());
        for (i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            str22 = C4321d.m17711f(this.sAppContext) ? UtilityImpl.NET_TYPE_WIFI : "wap";
            Object remoteFallbackJSON = getRemoteFallbackJSON(arrayList, str22, this.sUserId);
            if (!TextUtils.isEmpty(remoteFallbackJSON)) {
                JSONObject jSONObject = new JSONObject(remoteFallbackJSON);
                if ("OK".equalsIgnoreCase(jSONObject.getString("S"))) {
                    jSONObject = jSONObject.getJSONObject("R");
                    String string = jSONObject.getString("province");
                    String string2 = jSONObject.getString("city");
                    String string3 = jSONObject.getString("isp");
                    String string4 = jSONObject.getString("ip");
                    String string5 = jSONObject.getString("country");
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str22);
                    if (str22.equals("wap")) {
                        str22 = getActiveNetworkLabel();
                    }
                    C4302b.m17649a("get bucket: ip = " + string4 + " net = " + string3 + str22 + " hosts = " + jSONObject2.toString());
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        str22 = (String) arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject2.optJSONArray(str22);
                        if (optJSONArray == null) {
                            C4302b.m17649a("no bucket found for " + str22);
                        } else {
                            Fallback fallback = new Fallback(str22);
                            for (i = 0; i < optJSONArray.length(); i++) {
                                Object string6 = optJSONArray.getString(i);
                                if (!TextUtils.isEmpty(string6)) {
                                    fallback.m17897a(new C4366c(string6, optJSONArray.length() - i));
                                }
                            }
                            arrayList2.set(i2, fallback);
                            fallback.f14846g = string5;
                            fallback.f14842c = string;
                            fallback.f14844e = string3;
                            fallback.f14845f = string4;
                            fallback.f14843d = string2;
                            if (jSONObject.has("stat-percent")) {
                                fallback.m17895a(jSONObject.getDouble("stat-percent"));
                            }
                            if (jSONObject.has("stat-domain")) {
                                fallback.m17905b(jSONObject.getString("stat-domain"));
                            }
                            if (jSONObject.has("ttl")) {
                                fallback.m17896a(((long) jSONObject.getInt("ttl")) * 1000);
                            }
                            setCurrentISP(fallback.m17911e());
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4302b.m17649a("failed to get bucket " + e.getMessage());
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Fallback fallback2 = (Fallback) arrayList2.get(i3);
            if (fallback2 != null) {
                updateFallbacks((String) arrayList.get(i3), fallback2);
            }
        }
        persist();
        return arrayList2;
    }

    public static synchronized void setHostManagerFactory(HostManagerFactory hostManagerFactory) {
        synchronized (HostManager.class) {
            factory = hostManagerFactory;
            sInstance = null;
        }
    }

    protected boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                Object loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    fromJSON(loadHosts);
                    C4302b.m17649a("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                C4302b.m17649a("load host exception " + th.getMessage());
            }
            return false;
        }
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    protected void fromJSON(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(jSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    public String getActiveNetworkLabel() {
        if (this.sAppContext == null) {
            return UtilityImpl.NET_TYPE_UNKNOWN;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.sAppContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return UtilityImpl.NET_TYPE_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return UtilityImpl.NET_TYPE_UNKNOWN;
            }
            if (activeNetworkInfo.getType() != 1) {
                return activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
            }
            WifiManager wifiManager = (WifiManager) this.sAppContext.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
            }
            return UtilityImpl.NET_TYPE_UNKNOWN;
        } catch (Throwable th) {
        }
    }

    public Fallback getFallbacksByHost(String str) {
        return getFallbacksByHost(str, true);
    }

    public Fallback getFallbacksByHost(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.sHostFilter.m17917a(str)) {
            return null;
        } else {
            Fallback localFallback = getLocalFallback(str);
            if (localFallback != null && localFallback.m17908b()) {
                return localFallback;
            }
            if (z && C4321d.m17709d(this.sAppContext)) {
                Fallback requestRemoteFallback = requestRemoteFallback(str);
                if (requestRemoteFallback != null) {
                    return requestRemoteFallback;
                }
            }
            return new C4365b(this, str, localFallback);
        }
    }

    public Fallback getFallbacksByURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            return getFallbacksByHost(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    protected String getHost() {
        return "resolver.gslb.mi-idc.com";
    }

    protected Fallback getLocalFallback(String str) {
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            Fallbacks fallbacks = (Fallbacks) this.mHostsMapping.get(str);
        }
        if (fallbacks != null) {
            Fallback fallback = fallbacks.getFallback();
            if (fallback != null) {
                return fallback;
            }
        }
        return null;
    }

    protected String getProcessName() {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.sAppContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }

    protected String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList arrayList2 = new ArrayList();
        List<C4316c> arrayList3 = new ArrayList();
        arrayList3.add(new C4317a(C4233j.f14402y, str));
        arrayList3.add(new C4317a("uuid", str2));
        arrayList3.add(new C4317a("list", join((Collection) arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.gslb.mi-idc.com");
        String format = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[]{"resolver.gslb.mi-idc.com"});
        if (localFallback == null) {
            arrayList2.add(format);
        } else {
            arrayList2 = localFallback.m17893a(format);
        }
        Iterator it = arrayList2.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            Builder buildUpon = Uri.parse((String) it.next()).buildUpon();
            for (C4316c c4316c : arrayList3) {
                buildUpon.appendQueryParameter(c4316c.m17689a(), c4316c.m17690b());
            }
            try {
                return this.sHttpGetter == null ? C4321d.m17699a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.m17919a(buildUpon.toString());
            } catch (IOException e) {
                iOException = e;
                C4302b.m17649a("network ioErr: " + iOException.getMessage());
            }
        }
        if (iOException == null) {
            return null;
        }
        throw iOException;
    }

    protected String loadHosts() {
        String stringBuilder;
        Throwable th;
        Throwable th2;
        Reader reader = null;
        Reader bufferedReader;
        try {
            File file = new File(this.sAppContext.getFilesDir(), getProcessName());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder2.append(readLine);
                    }
                    stringBuilder = stringBuilder2.toString();
                    C4298a.m17634a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        C4302b.m17649a("load host exception " + th.getMessage());
                        C4298a.m17634a(bufferedReader);
                        return stringBuilder;
                    } catch (Throwable th4) {
                        th2 = th4;
                        C4298a.m17634a(bufferedReader);
                        throw th2;
                    }
                }
            }
            C4298a.m17634a(reader);
        } catch (Throwable th5) {
            bufferedReader = reader;
            th2 = th5;
            C4298a.m17634a(bufferedReader);
            throw th2;
        }
        return stringBuilder;
    }

    public void persist() {
        purge();
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                Object jSONArray = toJSON().toString();
                if (!TextUtils.isEmpty(jSONArray)) {
                    bufferedWriter.write(jSONArray);
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks purge : this.mHostsMapping.values()) {
                purge.purge(false);
            }
            Object obj = null;
            while (obj == null) {
                for (String str : this.mHostsMapping.keySet()) {
                    if (((Fallbacks) this.mHostsMapping.get(str)).getFallbacks().isEmpty()) {
                        this.mHostsMapping.remove(str);
                        obj = null;
                        break;
                    }
                }
                obj = 1;
            }
        }
    }

    public void refreshFallbacks() {
        ArrayList arrayList;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            arrayList = new ArrayList(this.mHostsMapping.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fallbacks fallbacks = (Fallbacks) this.mHostsMapping.get(arrayList.get(size));
                if (!(fallbacks == null || fallbacks.getFallback() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList requestRemoteFallbacks = requestRemoteFallbacks(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (requestRemoteFallbacks.get(i) != null) {
                updateFallbacks((String) arrayList.get(i), (Fallback) requestRemoteFallbacks.get(i));
            }
        }
    }

    protected Fallback requestRemoteFallback(String str) {
        if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp > (this.remoteRequestFailureCount * 60) * 1000) {
            this.lastRemoteRequestTimestamp = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            Fallback fallback = (Fallback) requestRemoteFallbacks(arrayList).get(0);
            if (fallback != null) {
                this.remoteRequestFailureCount = 0;
                return fallback;
            } else if (this.remoteRequestFailureCount < 15) {
                this.remoteRequestFailureCount++;
            }
        }
        return null;
    }

    public void setCurrentISP(String str) {
        this.currentISP = str;
    }

    protected JSONArray toJSON() {
        JSONArray jSONArray;
        synchronized (this.mHostsMapping) {
            jSONArray = new JSONArray();
            for (Fallbacks toJSON : this.mHostsMapping.values()) {
                jSONArray.put(toJSON.toJSON());
            }
        }
        return jSONArray;
    }

    public void updateFallbacks(String str, Fallback fallback) {
        if (TextUtils.isEmpty(str) || fallback == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + fallback);
        } else if (this.sHostFilter.m17917a(str)) {
            synchronized (this.mHostsMapping) {
                checkHostMapping();
                if (this.mHostsMapping.containsKey(str)) {
                    ((Fallbacks) this.mHostsMapping.get(str)).addFallback(fallback);
                } else {
                    Fallbacks fallbacks = new Fallbacks(str);
                    fallbacks.addFallback(fallback);
                    this.mHostsMapping.put(str, fallbacks);
                }
            }
        }
    }
}
