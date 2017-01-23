package com.taobao.accs.p190a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.ACCS_GROUP;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4137c;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.C4156a;
import com.umeng.message.common.C4209a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.taobao.accs.a.a */
public class C4073a {
    public static final String ACTION_ACCS_CUSTOM_ELECTION;
    public static final String ACTION_ACCS_ELECTION = "com.taobao.accs.intent.action.ELECTION";
    public static final String TAG = "ElectionServiceUtil";
    public static String f13563a;
    private static File f13564b;
    private static File f13565c;
    private static long f13566d;
    private static final Random f13567e;

    /* renamed from: com.taobao.accs.a.a.a */
    public static class C4072a {
        public String f13561a;
        public int f13562b;

        public C4072a() {
            this.f13561a = BuildConfig.FLAVOR;
            this.f13562b = 0;
        }
    }

    static {
        f13563a = null;
        f13564b = null;
        f13565c = null;
        f13566d = 0;
        f13567e = new Random();
        ACTION_ACCS_CUSTOM_ELECTION = "com.taobao.accs.intent.action." + AccsConfig.mGroup + "ELECTION";
    }

    public static final C4072a m16610a(Context context) {
        if (!C4144h.m16946c()) {
            return new C4072a();
        }
        C4072a electionResult = GlobalClientInfo.getInstance(context).getElectionResult();
        if (electionResult == null) {
            return C4073a.m16618b(context);
        }
        ALog.m16904i(TAG, "getElectionResult from mem", C4103b.ELECTION_KEY_HOST, electionResult.f13561a, "retry", Integer.valueOf(electionResult.f13562b));
        return electionResult;
    }

    public static String m16612a(Context context, Map<String, Integer> map) {
        if (map == null || map.size() <= 0) {
            ALog.m16903e(TAG, "localElection failed, packMap null", new Object[0]);
            return null;
        }
        List arrayList = new ArrayList();
        long j = -1;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            long intValue = (long) ((Integer) entry.getValue()).intValue();
            if (intValue > j) {
                arrayList.clear();
                j = intValue;
            }
            if (intValue == j) {
                arrayList.add(str);
            }
        }
        String str2 = (String) arrayList.get(f13567e.nextInt(10000) % arrayList.size());
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        ALog.m16904i(TAG, "localElection localResult null, user curr app", Constants.KEY_ELECTION_PKG, context.getPackageName());
        return context.getPackageName();
    }

    private static Map<String, Set<Integer>> m16613a(byte[] bArr) {
        Throwable th;
        Map<String, Set<Integer>> map = null;
        if (bArr != null) {
            try {
                JSONArray jSONArray = new JSONObject(new String(bArr)).getJSONArray(C4103b.ELECTION_KEY_BLACKLIST);
                if (jSONArray != null && jSONArray.length() > 0) {
                    Map<String, Set<Integer>> hashMap = new HashMap();
                    int i = 0;
                    while (i < jSONArray.length()) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            JSONArray jSONArray2 = jSONObject.getJSONArray(C4103b.ELECTION_KEY_SDKVS);
                            String string = jSONObject.getString(Constants.KEY_ELECTION_PKG);
                            if (jSONArray2 != null && jSONArray2.length() > 0) {
                                Set hashSet = new HashSet();
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    hashSet.add(Integer.valueOf(jSONArray2.getInt(i)));
                                }
                                hashMap.put(string, hashSet);
                            }
                            i++;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            map = hashMap;
                            th = th3;
                        }
                    }
                    map = hashMap;
                }
                String str = TAG;
                String str2 = "praseBlackList";
                Object[] objArr = new Object[2];
                objArr[0] = C4103b.ELECTION_KEY_BLACKLIST;
                objArr[1] = map == null ? "null" : map.toString();
                ALog.m16904i(str, str2, objArr);
            } catch (Throwable th4) {
                th = th4;
                ALog.m16902e(TAG, "praseBlackList", th, new Object[0]);
                return map;
            }
        }
        return map;
    }

    public static void m16614a() {
        try {
            f13564b = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + C4073a.m16621c());
            ALog.m16904i(TAG, "path=" + f13564b, new Object[0]);
            f13565c = new File(f13564b, C4103b.ELECTION_SERVICE_ID);
            f13563a = f13565c.getPath();
        } catch (Throwable th) {
            ALog.m16902e(TAG, TAG, th, new Object[0]);
        }
    }

    public static final void m16615a(Context context, C4072a c4072a) {
        if (c4072a != null) {
            GlobalClientInfo.getInstance(context).setElectionReslt(c4072a);
            C4089a.m16689a(new C4074b(context, c4072a));
        }
    }

    public static final void m16616a(Context context, byte[] bArr) {
        if (bArr == null || f13564b == null) {
            ALog.m16903e(TAG, "saveBlackList null", Constants.KEY_DATA, bArr, "path", f13564b);
            return;
        }
        ALog.m16904i(TAG, "saveBlackList", "path", f13564b + "/accs_blacklist");
        GlobalClientInfo.getInstance(context).setElectionBlackList(C4073a.m16613a(bArr));
        C4089a.m16689a(new C4075c(context, bArr, r0));
    }

    public static final boolean m16617a(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z;
        if (i != 1) {
            try {
                ALog.m16906w(TAG, "checkApp election version not match", C4209a.f14200c, str, "require", Integer.valueOf(i), "self ver", Integer.valueOf(1));
                return false;
            } catch (Throwable th) {
                ALog.m16902e(TAG, "checkApp error", th, new Object[0]);
                z = false;
            }
        } else if (C4086b.m16670a(context).m16679c(str)) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                ALog.m16906w(TAG, "checkApp applicaton info null", C4209a.f14200c, str);
                return false;
            } else if (applicationInfo.enabled) {
                Map d = C4073a.m16624d(context);
                if (d != null) {
                    ALog.m16904i(TAG, "checkApp", "blackList", d.toString());
                    Set set = (Set) d.get(str);
                    if (set == null || !(set.contains(Integer.valueOf(Constants.SDK_VERSION_CODE)) || set.contains(Integer.valueOf(-1)))) {
                        set = (Set) d.get("*");
                        if (set != null && (set.contains(Integer.valueOf(Constants.SDK_VERSION_CODE)) || set.contains(Integer.valueOf(-1)))) {
                            ALog.m16906w(TAG, "checkApp in blacklist *", C4209a.f14200c, str, Constants.KEY_ELECTION_SDKV, Integer.valueOf(Constants.SDK_VERSION_CODE));
                            return false;
                        }
                    }
                    ALog.m16906w(TAG, "checkApp in blacklist", C4209a.f14200c, str, Constants.KEY_ELECTION_SDKV, Integer.valueOf(Constants.SDK_VERSION_CODE));
                    return false;
                }
                z = true;
                return z;
            } else {
                ALog.m16904i(TAG, "checkApp is disabled", C4209a.f14200c, str);
                return false;
            }
        } else {
            ALog.m16906w(TAG, "checkApp is unbinded", C4209a.f14200c, str);
            return false;
        }
    }

    public static final C4072a m16618b(Context context) {
        Throwable th;
        C4072a c4072a = new C4072a();
        FileInputStream fileInputStream = null;
        try {
            if (f13564b == null) {
                C4073a.m16614a();
            }
            File file = new File(f13563a);
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    JSONObject jSONObject = new JSONObject(new String(bArr, HttpRequest.f14548a));
                    if (jSONObject != null) {
                        String string = jSONObject.getString(C4209a.f14200c);
                        if (UtilityImpl.packageExist(context, string)) {
                            c4072a.f13561a = string;
                            f13566d = jSONObject.getLong("lastFlushTime");
                        }
                        if (System.currentTimeMillis() < f13566d + C4156a.f13948j) {
                            c4072a.f13562b = jSONObject.getInt("retry");
                            fileInputStream = fileInputStream2;
                        } else {
                            f13566d = 0;
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
            ALog.m16904i(TAG, "getElectionResult", C4103b.ELECTION_KEY_HOST, c4072a.f13561a, "retry", Integer.valueOf(c4072a.f13562b));
            GlobalClientInfo.getInstance(context).setElectionReslt(c4072a);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            ALog.m16902e(TAG, "readFile is error", th, new Object[0]);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return c4072a;
        }
        return c4072a;
    }

    public static String m16620b() {
        return AccsConfig.mGroup == ACCS_GROUP.TAOBAO ? ACTION_ACCS_ELECTION : ACTION_ACCS_CUSTOM_ELECTION;
    }

    public static String m16621c() {
        return AccsConfig.mGroup == ACCS_GROUP.TAOBAO ? "/accs/accs_main/1" : "/accs/" + AccsConfig.mGroup + "/" + 1;
    }

    public static final void m16622c(Context context) {
        ALog.m16904i(TAG, "clearBlackList", new Object[0]);
        GlobalClientInfo.getInstance(context).setElectionBlackList(null);
        if (f13564b == null) {
            ALog.m16903e(TAG, "clearBlackList path null", new Object[0]);
            return;
        }
        try {
            File file = new File(f13564b + "accs_blacklist");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            ALog.m16902e(TAG, "clearBlackList", th, new Object[0]);
        }
    }

    public static final Map<String, Set<Integer>> m16624d(Context context) {
        Map<String, Set<Integer>> electionBlackList = GlobalClientInfo.getInstance(context).getElectionBlackList();
        if (electionBlackList != null) {
            ALog.m16904i(TAG, "getBlackList from mem", electionBlackList.toString());
            return electionBlackList;
        } else if (f13564b == null) {
            ALog.m16903e(TAG, "getBlackList path null", new Object[0]);
            return null;
        } else {
            try {
                byte[] a = C4137c.m16919a(new File(f13564b + "accs_blacklist"));
                if (a != null) {
                    electionBlackList = C4073a.m16613a(a);
                }
            } catch (Throwable th) {
                ALog.m16902e(TAG, "getBlackList", th, new Object[0]);
            }
            GlobalClientInfo.getInstance(context).setElectionBlackList(electionBlackList);
            return electionBlackList;
        }
    }

    public static final String m16626e(Context context) {
        String str;
        Throwable th;
        try {
            ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent(C4073a.m16620b()), 0);
            if (resolveService == null) {
                ALog.m16903e(TAG, "getResolveService resolveInfo null", new Object[0]);
                return null;
            }
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (serviceInfo == null || !serviceInfo.isEnabled()) {
                ALog.m16903e(TAG, "getResolveService serviceinfo null or disabled", new Object[0]);
                return null;
            }
            str = serviceInfo.packageName;
            if (TextUtils.isEmpty(str)) {
                ALog.m16903e(TAG, "getResolveService clientPack null", new Object[0]);
                return null;
            }
            try {
                ALog.m16904i(TAG, "getResolveService", C4209a.f14200c, str);
                return str;
            } catch (Throwable th2) {
                th = th2;
                ALog.m16902e(TAG, "getResolveService error", th, new Object[0]);
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = null;
            th = th4;
            ALog.m16902e(TAG, "getResolveService error", th, new Object[0]);
            return str;
        }
    }
}
