package com.igexin.push.core.p176a;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p161b.p162a.p163a.C3671d;
import com.igexin.p158b.p159a.p161b.p162a.p163a.C3678k;
import com.igexin.p158b.p159a.p165d.C3666d;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3794a;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.C3857i;
import com.igexin.push.core.C3859k;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3821a;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.bean.C3827g;
import com.igexin.push.core.bean.C3830j;
import com.igexin.push.core.bean.C3834n;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p175b.C3796c;
import com.igexin.push.core.p175b.C3799f;
import com.igexin.push.core.p175b.C3819z;
import com.igexin.push.core.p176a.p177a.C3759a;
import com.igexin.push.core.p176a.p177a.C3760b;
import com.igexin.push.core.p176a.p177a.C3761c;
import com.igexin.push.core.p176a.p177a.C3762d;
import com.igexin.push.core.p176a.p177a.C3763e;
import com.igexin.push.core.p176a.p177a.C3764f;
import com.igexin.push.core.p176a.p177a.C3765g;
import com.igexin.push.core.p176a.p177a.C3766h;
import com.igexin.push.core.p176a.p177a.C3767i;
import com.igexin.push.core.p176a.p177a.C3768j;
import com.igexin.push.core.p176a.p177a.C3769k;
import com.igexin.push.core.p176a.p177a.C3770l;
import com.igexin.push.core.p180c.C3837a;
import com.igexin.push.core.p180c.C3838b;
import com.igexin.push.core.p180c.C3839c;
import com.igexin.push.core.p180c.C3845i;
import com.igexin.push.core.p180c.C3846j;
import com.igexin.push.extension.C3910a;
import com.igexin.push.extension.stub.IPushExtension;
import com.igexin.push.p169f.p170b.C3917b;
import com.igexin.push.p169f.p170b.C3918c;
import com.igexin.push.p169f.p170b.C3921g;
import com.igexin.push.p169f.p179a.C3912a;
import com.igexin.push.p169f.p179a.C3913c;
import com.igexin.push.p169f.p179a.C3915e;
import com.igexin.push.p171a.p172a.C3714c;
import com.igexin.push.p174c.C3722a;
import com.igexin.push.p174c.C3730i;
import com.igexin.push.p178e.C3776k;
import com.igexin.push.p178e.C3909j;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.p182d.p183a.C3869c;
import com.igexin.push.p182d.p184b.C3871a;
import com.igexin.push.p182d.p184b.C3872b;
import com.igexin.push.p182d.p184b.C3873c;
import com.igexin.push.p182d.p184b.C3874d;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3877a;
import com.igexin.push.p182d.p185c.C3879c;
import com.igexin.push.p182d.p185c.C3880d;
import com.igexin.push.p182d.p185c.C3881f;
import com.igexin.push.p182d.p185c.C3883h;
import com.igexin.push.p182d.p185c.C3884i;
import com.igexin.push.p182d.p185c.C3885j;
import com.igexin.push.p182d.p185c.C3886k;
import com.igexin.push.p182d.p185c.C3887l;
import com.igexin.push.p182d.p185c.C3888m;
import com.igexin.push.p182d.p185c.C3890o;
import com.igexin.push.p182d.p185c.C3892q;
import com.igexin.push.util.C3922a;
import com.igexin.push.util.C3926e;
import com.igexin.push.util.C3929h;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.e */
public class C3777e extends C3772a implements C3776k {
    private static Map f12699a;
    private static Map f12700b;
    private static C3777e f12701c;
    private long f12702d;

    private C3777e() {
        f12699a = new HashMap();
        f12699a.put(Integer.valueOf(0), new C3782j());
        f12699a.put(Integer.valueOf(5), new C3784l());
        f12699a.put(Integer.valueOf(37), new C3786n());
        f12699a.put(Integer.valueOf(9), new C3790r());
        f12699a.put(Integer.valueOf(26), new C3781i());
        f12699a.put(Integer.valueOf(28), new C3775d());
        f12699a.put(Integer.valueOf(97), new C3783k());
        f12700b = new HashMap();
        f12700b.put("goto", new C3765g());
        f12700b.put(UMessage.DISPLAY_TYPE_NOTIFICATION, new C3766h());
        f12700b.put("startapp", new C3769k());
        f12700b.put("null", new C3764f());
        f12700b.put("wakeupsdk", new C3770l());
        f12700b.put("startweb", new C3768j());
        f12700b.put("checkapp", new C3760b());
        f12700b.put("cleanext", new C3761c());
        f12700b.put("enablelog", new C3763e());
        f12700b.put("disablelog", new C3762d());
        f12700b.put("reportext", new C3767i());
    }

    private void m15488D() {
        C3722a e = C3730i.m15273a().m15277e();
        C3857i.m15894a().m15899a(C3859k.NETWORK_ERROR);
        e.m15267i();
        if (m15507C()) {
            C3688a.m15097b("CoreAction|sdkOn = false or pushOn = false, disconect|user");
            if (C3855g.f12976n) {
                C3855g.f12976n = false;
                C3688a.m15097b("CoreAction|broadcast online state = offline");
                m15564m();
            }
        } else {
            C3688a.m15097b("CoreAction|disconnect|network");
            if (C3855g.f12976n) {
                C3855g.f12976n = false;
                C3688a.m15097b("CoreAction|broadcast online state = offline");
                m15564m();
            }
        }
        C3685c.m15060b().m15054a(C3678k.class);
    }

    private void m15489E() {
        boolean z = false;
        C3857i.m15894a().m15899a(C3859k.NETWORK_SWITCH);
        ConnectivityManager j = C3854f.m15859a().m15880j();
        if (j != null) {
            NetworkInfo activeNetworkInfo = j.getActiveNetworkInfo();
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            C3855g.f12971i = z2;
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                StringBuilder append = new StringBuilder().append("CoreAction|type = ");
                String str = type == 0 ? "mobile" : type == 1 ? UtilityImpl.NET_TYPE_WIFI : PushBuildConfig.sdk_conf_debug_level;
                C3688a.m15097b(append.append(str).toString());
            }
        } else {
            C3855g.f12971i = false;
        }
        C3688a.m15097b("CoreAction|network changed, available = " + C3855g.f12971i);
        if (C3855g.f12976n && C3855g.f12971i) {
            C3688a.m15097b("CoreAction|network changed, online = true, networkAvailable = true");
            if (System.currentTimeMillis() - C3855g.f12953Q > 5000) {
                C3688a.m15097b("CoreAction|network changed, online = true, networkAvailable = true, send heart beat ....");
                C3855g.f12953Q = System.currentTimeMillis();
                if (m15558g() == -2) {
                    C3855g.f12976n = false;
                    m15564m();
                }
            }
        } else {
            C3875b.m15932a().m15938b();
            C3688a.m15097b("CoreAction|network changed, disconnect +++");
            C3854f.m15859a().m15879i().m15557f();
            if (C3855g.f12971i) {
                if (C3730i.m15273a().m15277e().m15268j()) {
                    z = C3730i.m15273a().m15278f();
                } else {
                    C3688a.m15097b("CoreAction|network changed, domain = backup or trynormal");
                }
            }
            if (z) {
                C3688a.m15097b("CoreAction|detect result  = true, reconnect will run after detect");
            } else {
                C3671d.m14981a().m15010a(true);
            }
        }
        if (m15572u()) {
            C3688a.m15097b("CoreAction|network changed check condition status");
            m15571t();
        }
    }

    private boolean m15490F() {
        Throwable th;
        if (C3855g.ah.isEmpty() && C3855g.f12978p) {
            Cursor a;
            try {
                a = C3854f.m15859a().m15881k().m15242a(C4233j.f14376C, new String[]{MsgConstant.KEY_STATUS}, new String[]{MessageService.MSG_DB_READY_REPORT}, null, null);
                if (a != null) {
                    while (a.moveToNext()) {
                        try {
                            byte[] blob = a.getBlob(a.getColumnIndex("msgextra"));
                            try {
                                JSONObject jSONObject = new JSONObject(new String(C3700a.m15136c(a.getBlob(a.getColumnIndex("info")))));
                                String string = jSONObject.getString(AgooConstants.MESSAGE_ID);
                                String string2 = jSONObject.getString(ACTD.APPID_KEY);
                                String string3 = jSONObject.getString("messageid");
                                String string4 = jSONObject.getString("taskid");
                                String string5 = jSONObject.getString(C4209a.f14204g);
                                JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                                String c = C3777e.m15491a().m15545c(string4, string3);
                                PushTaskBean pushTaskBean = new PushTaskBean();
                                pushTaskBean.setAppid(string2);
                                pushTaskBean.setMessageId(string3);
                                pushTaskBean.setTaskId(string4);
                                pushTaskBean.setId(string);
                                pushTaskBean.setAppKey(string5);
                                pushTaskBean.setCurrentActionid(1);
                                pushTaskBean.setStatus(a.getInt(a.getColumnIndex(MsgConstant.KEY_STATUS)));
                                if (blob != null) {
                                    pushTaskBean.setMsgExtra(blob);
                                }
                                if (jSONObject.has("cdnType")) {
                                    pushTaskBean.setCDNType(jSONObject.getBoolean("cdnType"));
                                }
                                if (jSONObject.has("condition")) {
                                    m15496b(jSONObject, pushTaskBean);
                                }
                                if (!(jSONArray == null || jSONArray.length() <= 0 || C3777e.m15491a().m15533a(jSONObject, pushTaskBean))) {
                                    C3688a.m15097b("CoreAction|load task from db parseActionChains result = false ####### " + jSONObject.toString());
                                }
                                C3855g.ah.put(c, pushTaskBean);
                            } catch (JSONException e) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                C3855g.f12978p = false;
                if (a != null) {
                    a.close();
                }
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return C3855g.ah.isEmpty();
    }

    public static C3777e m15491a() {
        if (f12701c == null) {
            f12701c = new C3777e();
        }
        return f12701c;
    }

    private void m15492a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(i));
        C3854f.m15859a().m15881k().m15244a(C4233j.f14376C, contentValues, new String[]{"taskid"}, new String[]{str});
    }

    private void m15494a(C3879c c3879c, PushTaskBean pushTaskBean, String str, String str2) {
        c3879c.m15959a(new C3917b(pushTaskBean, str, m15562k()));
        C3855g.ak.put(str2, c3879c);
    }

    private void m15495a(List list) {
        Comparator c3779g = new C3779g(this);
        PackageManager packageManager = C3855g.f12969g.getPackageManager();
        List installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            try {
                PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    C3834n c3834n = new C3834n();
                    c3834n.m15782b(applicationInfo.loadLabel(packageManager).toString());
                    c3834n.m15786d(applicationInfo.packageName);
                    c3834n.m15784c(String.valueOf(packageInfo.versionCode));
                    c3834n.m15780a(packageInfo.versionName);
                    list.add(c3834n);
                }
            } catch (Exception e) {
            }
        }
        Collections.sort(list, c3779g);
    }

    private void m15496b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            Map hashMap = new HashMap();
            if (jSONObject2.has(UtilityImpl.NET_TYPE_WIFI)) {
                hashMap.put(UtilityImpl.NET_TYPE_WIFI, jSONObject2.getString(UtilityImpl.NET_TYPE_WIFI));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                hashMap.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has(C0714a.BSSID)) {
                    hashMap.put(C0714a.BSSID, jSONObject2.getString(C0714a.BSSID));
                }
            }
            if (jSONObject2.has("duration")) {
                String string = jSONObject2.getString("duration");
                if (string.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    int indexOf = string.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String substring = string.substring(0, indexOf);
                    string = string.substring(indexOf + 1, string.length());
                    hashMap.put("startTime", substring);
                    hashMap.put("endTime", string);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (Exception e) {
        }
    }

    private void m15497b(byte[] bArr) {
        try {
            C3926e.m16159a(bArr, C3855g.f12969g.getFilesDir().getPath() + "/" + "conf_n.pid", false);
        } catch (Exception e) {
        }
    }

    private void m15498e(String str) {
        if (str != null && str.startsWith("package:")) {
            String substring = str.substring(8);
            if (C3799f.m15623a().m15658d().containsKey(substring)) {
                C3799f.m15623a().m15658d().remove(substring);
            }
        }
    }

    private void m15499e(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setPackage(str);
            intent.setAction("com.igexin.sdk.action.service.message");
            if (C3922a.m16140a(intent, C3855g.f12969g)) {
                C3855g.f12969g.startService(intent);
                C3688a.m15097b("CoreAction|startService by action");
                return;
            }
            intent = new Intent();
            intent.setClassName(str, str2);
            C3855g.f12969g.startService(intent);
            C3688a.m15097b("CoreAction|startService by service name");
        } catch (Throwable th) {
            C3688a.m15097b("CoreAction|startService pkgName = " + str + " srvName = " + str2 + ", exception : " + th.toString());
        }
    }

    private void m15500f(Intent intent) {
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra("actionid");
        String stringExtra4 = intent.getStringExtra("accesstoken");
        int intExtra = intent.getIntExtra("notifID", 0);
        NotificationManager notificationManager = (NotificationManager) C3855g.f12969g.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        if (intExtra != 0) {
            notificationManager.cancel(intExtra);
        } else if (C3855g.ai.get(stringExtra) != null) {
            notificationManager.cancel(((Integer) C3855g.ai.get(stringExtra)).intValue());
        }
        if (stringExtra4.equals(C3855g.at)) {
            m15542b(stringExtra, stringExtra2, stringExtra3);
        }
    }

    private void m15501f(String str) {
        if (str != null && str.startsWith("package:")) {
            String substring = str.substring(8);
            try {
                PackageInfo packageInfo = C3855g.f12969g.getPackageManager().getPackageInfo(substring, 4);
                if (packageInfo != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    if (serviceInfoArr != null) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            if (C3794a.f12735o.equals(serviceInfo.name) || C3794a.f12734n.equals(serviceInfo.name) || C3794a.f12736p.equals(serviceInfo.name)) {
                                C3799f.m15623a().m15658d().put(substring, serviceInfo.name);
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void m15502f(boolean z) {
        C3869c.f13019b = -1;
        if (!EncryptUtils.isLoadSuccess()) {
            C3688a.m15097b("CoreAction|so error ++++++++");
        } else if (C3855g.aA) {
            C3854f.m15859a().m15877g().m16065c(z);
        } else {
            C3688a.m15097b("CoreAction|autoReconnect CoreRuntimeInfo.initSuccess = false");
        }
    }

    private void m15503g(Intent intent) {
        Throwable th;
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra(ACTD.APPID_KEY);
        String stringExtra4 = intent.getStringExtra("pkgname");
        ContentValues contentValues = new ContentValues();
        String str = "EXEC_" + stringExtra;
        contentValues.put("taskid", stringExtra);
        contentValues.put(ACTD.APPID_KEY, stringExtra3);
        contentValues.put("key", str);
        contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
        Cursor a;
        try {
            a = C3854f.m15859a().m15881k().m15242a(C4233j.f14376C, new String[]{"key"}, new String[]{str}, null, null);
            if (a != null) {
                try {
                    if (a.getCount() == 0) {
                        C3854f.m15859a().m15881k().m15243a(C4233j.f14376C, contentValues);
                        if (stringExtra4.equals(C3855g.f12967e)) {
                            if (stringExtra2 == null || stringExtra == null) {
                                if (a != null) {
                                    a.close();
                                    return;
                                }
                                return;
                            } else if (C3854f.m15859a() != null && m15550d(stringExtra, stringExtra2) == C3820b.success) {
                                m15532a(stringExtra, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C3688a.m15097b("CoreAction|" + th.toString());
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private void m15504g(String str) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            File file = new File(C3855g.f12962Z);
            if (file.exists() || file.createNewFile()) {
                fileOutputStream2 = new FileOutputStream(C3855g.f12962Z);
                try {
                    fileOutputStream2.write(C3700a.m15132a(str).getBytes());
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            C3688a.m15097b("create file " + file.toString() + " failed######");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream2 = fileOutputStream;
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public void m15505A() {
        if (C3855g.f12952P < System.currentTimeMillis()) {
            C3799f.m15623a().m15647a(false);
        }
    }

    public void m15506B() {
        if (!C3855g.ae) {
            C3855g.ae = C3685c.m15060b().m15053a(C3918c.m16117g(), false, true);
        }
        if (!C3855g.af) {
            C3855g.af = C3685c.m15060b().m15053a(C3921g.m16131g(), true, true);
        }
        if (!C3855g.ag) {
            C3854f.m15859a().m15873c();
        }
    }

    public boolean m15507C() {
        return (C3855g.f12972j && C3855g.f12973k) ? false : true;
    }

    public C3827g m15508a(JSONObject jSONObject) {
        C3827g c3827g = new C3827g();
        c3827g.m15732a(jSONObject.getString(com.taobao.accs.common.Constants.SP_KEY_VERSION));
        JSONArray jSONArray = jSONObject.getJSONArray("extensions");
        if (jSONArray == null || jSONArray.length() <= 0) {
            c3827g.m15733a(new HashMap());
        } else {
            Map hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                C3826f c3826f = new C3826f();
                c3826f.m15712a(jSONObject2.getInt(AgooConstants.MESSAGE_ID));
                c3826f.m15714a(jSONObject2.getString(com.taobao.accs.common.Constants.SP_KEY_VERSION));
                c3826f.m15718b(jSONObject2.getString("name"));
                c3826f.m15720c(jSONObject2.getString("cls_name"));
                c3826f.m15722d(jSONObject2.getString("url"));
                c3826f.m15724e(jSONObject2.getString("checksum"));
                c3826f.m15726f(jSONObject2.getString("key"));
                if (jSONObject2.has("isdestroy")) {
                    c3826f.m15715a(jSONObject2.getBoolean("isdestroy"));
                }
                if (jSONObject2.has("effective")) {
                    String string = jSONObject2.getString("effective");
                    long j = 0;
                    if (string != null && string.length() <= 13) {
                        j = Long.parseLong(string);
                    }
                    c3826f.m15713a(j);
                }
                if (jSONObject2.has("loadTime")) {
                    c3826f.m15717b(jSONObject2.getLong("loadTime"));
                }
                hashMap.put(Integer.valueOf(c3826f.m15711a()), c3826f);
            }
            c3827g.m15733a(hashMap);
        }
        return c3827g;
    }

    public String m15509a(C3827g c3827g) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a = c3827g.m15731a();
            Map b = c3827g.m15734b();
            String str = "[]";
            if (a != null) {
                jSONObject.put(com.taobao.accs.common.Constants.SP_KEY_VERSION, a);
            }
            if (b != null && b.size() > 0) {
                a = "[";
                for (Entry value : b.entrySet()) {
                    C3826f c3826f = (C3826f) value.getValue();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(AgooConstants.MESSAGE_ID, c3826f.m15711a());
                    jSONObject2.put(com.taobao.accs.common.Constants.SP_KEY_VERSION, c3826f.m15716b());
                    jSONObject2.put("name", c3826f.m15719c());
                    jSONObject2.put("cls_name", c3826f.m15721d());
                    jSONObject2.put("url", c3826f.m15723e());
                    jSONObject2.put("checksum", c3826f.m15725f());
                    jSONObject2.put("isdestroy", c3826f.m15727g());
                    jSONObject2.put("effective", c3826f.m15728h());
                    jSONObject2.put("loadTime", c3826f.m15729i());
                    jSONObject2.put("key", c3826f.m15730j());
                    a = (a + jSONObject2.toString()) + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
                str = (a.endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP) ? a.substring(0, a.length() - 1) : a) + "]";
            }
            jSONObject.put("extensions", new JSONArray(str));
            return jSONObject.toString();
        } catch (Exception e) {
            C3688a.m15097b(e.toString());
            return null;
        }
    }

    public String m15510a(boolean z, int i) {
        String str;
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        if (i == -1) {
            try {
                str = format + "|" + C3855g.f12938B + "|" + MiPushClient.COMMAND_REGISTER + "|" + C3855g.f12983u;
            } catch (Exception e) {
                str = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else if (i == 0) {
            cursor = z ? C3854f.m15859a().m15881k().m15242a("bi", new String[]{C4233j.f14402y}, new String[]{MessageService.MSG_DB_NOTIFY_REACHED, MessageService.MSG_DB_NOTIFY_CLICK}, null, null) : C3854f.m15859a().m15881k().m15242a("bi", new String[]{C4233j.f14402y}, new String[]{MessageService.MSG_DB_NOTIFY_CLICK}, null, null);
            if (cursor != null) {
                str = null;
                while (cursor.moveToNext()) {
                    try {
                        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("start_service_count"));
                        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("login_count"));
                        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("loginerror_nonetwork_count"));
                        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("loginerror_connecterror_count"));
                        int i6 = cursor.getInt(cursor.getColumnIndexOrThrow("online_time"));
                        int i7 = cursor.getInt(cursor.getColumnIndexOrThrow("network_time"));
                        int i8 = cursor.getInt(cursor.getColumnIndexOrThrow("running_time"));
                        String str2 = cursor.getString(cursor.getColumnIndexOrThrow("create_time")) + " 00:00:00";
                        str = str == null ? str2 + "|" + C3855g.f12938B + "|" + "startservice" + "|" + i2 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "login" + "|" + i3 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "loginerror-nonetwork" + "|" + i4 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "loginerror-connecterror" + "|" + i5 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "online" + "|" + i6 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "network" + "|" + i7 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "running" + "|" + i8 : str + "\n" + str2 + "|" + C3855g.f12938B + "|" + "startservice" + "|" + i2 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "login" + "|" + i3 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "loginerror-nonetwork" + "|" + i4 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "loginerror-connecterror" + "|" + i5 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "online" + "|" + i6 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "network" + "|" + i7 + "\n" + str2 + "|" + C3855g.f12938B + "|" + "running" + "|" + i8;
                    } catch (Exception e2) {
                        cursor2 = cursor;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } else {
                str = null;
            }
            cursor2 = cursor;
        } else if (i == 1) {
            long j = C3857i.m15894a().f12990a;
            if (C3754m.f12660d > 0) {
                j = (long) (C3754m.f12660d * AdError.NETWORK_ERROR_CODE);
            }
            str = format + "|" + C3855g.f12982t + "|" + C3855g.f12963a + "|" + C3855g.f12972j + "|" + (C3754m.f12657a + Constants.ACCEPT_TIME_SEPARATOR_SP + C3754m.f12658b) + "|" + j + "|";
        } else {
            str = i == 4 ? format + "|" + C3855g.f12982t + "|" + C3855g.f12963a + "|" : i == 5 ? format + "|" + C3855g.f12982t + "|" + C3855g.f12963a : null;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        return str;
    }

    @TargetApi(12)
    public void m15511a(int i) {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C3855g.f12963a);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKSERVICEPID);
        bundle.putInt("pid", i);
        intent.putExtras(bundle);
        C3854f.m15859a().m15864a(intent);
    }

    public void m15512a(int i, int i2, String str) {
        C3754m.f12657a = i;
        C3754m.f12658b = i2;
        C3742a.m15382a().m15391b();
        C3714c.m15218c().m15222d();
    }

    public void m15513a(int i, String str) {
        C3754m.f12660d = i;
        C3742a.m15382a().m15394c();
        if (C3855g.f12976n) {
            C3688a.m15097b("setHeartbeatInterval heartbeatReq");
            if (System.currentTimeMillis() - C3855g.f12953Q > 5000) {
                C3855g.f12953Q = System.currentTimeMillis();
                m15558g();
            }
        }
    }

    public void m15514a(Intent intent) {
        if (intent != null) {
            C3854f.m15859a().m15870a(false);
            if (intent.hasExtra("op_app")) {
                C3855g.f12940D = intent.getStringExtra("op_app");
            } else {
                C3855g.f12940D = BuildConfig.FLAVOR;
            }
            C3855g.f12977o = false;
            if (C3855g.f12976n) {
                m15563l();
                C3855g.f12977o = true;
            }
        }
    }

    public void m15515a(Bundle bundle) {
        String string = bundle.getString(PushConsts.CMD_ACTION);
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("setTag")) {
                if (C3754m.f12666j) {
                    m15521a(bundle.getString(MsgConstant.KEY_TAGS), bundle.getString(IXAdRequestInfo.SN));
                }
            } else if (string.equals("setSilentTime")) {
                if (C3754m.f12667k) {
                    m15512a(bundle.getInt("beginHour", 0), bundle.getInt("duration", 0), C3855g.f12969g.getPackageName());
                }
            } else if (string.equals("sendMessage")) {
                C3688a.m15097b("CoreAction onPushManagerMessage recevie action : sendMessage");
                if (C3754m.f12665i) {
                    string = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    C3688a.m15097b("CoreAction receive broadcast msg data , task id : " + string + " ######@##@@@#");
                    m15525a(string, byteArray);
                }
            } else if (string.equals("stopService")) {
                C3854f.m15859a().m15869a(C3855g.f12969g.getPackageName());
            } else if (string.equals("setHeartbeatInterval")) {
                if (C3754m.f12668l) {
                    m15513a(bundle.getInt(MsgConstant.KEY_LOCATION_INTERVAL, 0), C3855g.f12969g.getPackageName());
                }
            } else if (string.equals("setSocketTimeout")) {
                if (C3754m.f12669m) {
                    m15536b(bundle.getInt("timeout", 0), C3855g.f12969g.getPackageName());
                }
            } else if (string.equals("sendFeedbackMessage")) {
                if (C3754m.f12674r && C3855g.am <= com.taobao.accs.common.Constants.COMMAND_HANDSHAKE) {
                    string = bundle.getString("taskid");
                    String string2 = bundle.getString("messageid");
                    String string3 = bundle.getString("actionid");
                    String str = string + ":" + string2 + ":" + string3;
                    if (C3855g.al.get(str) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string);
                        pushTaskBean.setMessageId(string2);
                        pushTaskBean.setAppid(C3855g.f12963a);
                        pushTaskBean.setAppKey(C3855g.f12964b);
                        m15517a(pushTaskBean, string3);
                        C3855g.am++;
                        C3855g.al.put(str, Long.valueOf(currentTimeMillis));
                    }
                }
            } else if (string.equals("turnOffPush")) {
                C3854f.m15859a().m15872b(C3855g.f12969g.getPackageName());
            } else if (string.equals("bindAlias")) {
                string = bundle.getString(C4233j.f14403z);
                C3688a.m15097b("CoreAction|onPushManagerMessage bindAlias...");
                m15539b(string);
            } else if (string.equals("unbindAlias")) {
                string = bundle.getString(C4233j.f14403z);
                boolean z = bundle.getBoolean("isSeft");
                C3688a.m15097b("CoreAction|onPushManagerMessage unbindAlias...");
                m15524a(string, z);
            }
        }
    }

    public void m15516a(PushTaskBean pushTaskBean) {
        C3876e c3879c = new C3879c();
        c3879c.m15957a();
        c3879c.f13053c = "RCV" + pushTaskBean.getMessageId();
        c3879c.f13054d = C3855g.f12982t;
        c3879c.f13051a = (int) System.currentTimeMillis();
        C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3879c);
        C3688a.m15097b("CoreAction|cdnreceive " + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId());
    }

    public void m15517a(PushTaskBean pushTaskBean, String str) {
        if (pushTaskBean.isCDNType()) {
            m15538b(pushTaskBean, str);
        } else {
            m15518a(pushTaskBean, str, ITagManager.SUCCESS);
        }
    }

    public void m15518a(PushTaskBean pushTaskBean, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "pushmessage_feedback");
            jSONObject.put(ACTD.APPID_KEY, pushTaskBean.getAppid());
            jSONObject.put(AgooConstants.MESSAGE_ID, String.valueOf(currentTimeMillis));
            jSONObject.put(C4209a.f14204g, pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put("result", str2);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
        }
        String jSONObject2 = jSONObject.toString();
        C3876e c3880d = new C3880d();
        c3880d.m15964a();
        c3880d.f13058a = (int) currentTimeMillis;
        c3880d.f13061d = "17258000";
        c3880d.f13062e = jSONObject2;
        c3880d.f13064g = C3855g.f12982t;
        C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
        C3796c a = C3796c.m15612a();
        if (a != null) {
            a.m15616a(new C3830j(currentTimeMillis, jSONObject2, (byte) 3, currentTimeMillis));
        }
        C3688a.m15097b("feedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str);
    }

    public void m15519a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "received");
            jSONObject.put(AgooConstants.MESSAGE_ID, str);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        C3876e c3880d = new C3880d();
        c3880d.m15964a();
        c3880d.f13058a = (int) System.currentTimeMillis();
        c3880d.f13061d = "17258000";
        c3880d.f13062e = jSONObject2;
        c3880d.f13064g = C3855g.f12982t;
        C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
    }

    public void m15520a(String str, C3877a c3877a, PushTaskBean pushTaskBean) {
        C3685c.m15060b().m15053a(new C3912a(new C3839c(str, c3877a, pushTaskBean)), false, true);
    }

    public void m15521a(String str, String str2) {
        if (!TextUtils.isEmpty(C3855g.f12982t)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PushConsts.CMD_ACTION, "set_tag");
                    jSONObject.put(AgooConstants.MESSAGE_ID, String.valueOf(currentTimeMillis));
                    jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
                    jSONObject.put(ACTD.APPID_KEY, C3855g.f12963a);
                    jSONObject.put(MsgConstant.KEY_TAGS, URLEncoder.encode(str, "utf-8"));
                    jSONObject.put(IXAdRequestInfo.SN, str2);
                } catch (Exception e) {
                }
                String jSONObject2 = jSONObject.toString();
                C3796c a = C3796c.m15612a();
                if (a != null) {
                    a.m15616a(new C3830j(currentTimeMillis, jSONObject2, (byte) 2, currentTimeMillis));
                }
                C3880d c3880d = new C3880d();
                c3880d.m15964a();
                c3880d.f13061d = "17258000";
                c3880d.f13062e = jSONObject2;
                C3685c.m15060b().m15062a(SDKUrlConfig.getCmAddress(), 3, C3854f.m15859a().m15876f(), c3880d, false);
                C3688a.m15097b("settag");
            } catch (Exception e2) {
            }
        }
    }

    public void m15522a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("com.igexin.sdk.action.execute");
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra(ACTD.APPID_KEY, C3855g.f12963a);
        intent.putExtra("pkgname", C3855g.f12967e);
        C3854f.m15859a().m15864a(intent);
    }

    @TargetApi(12)
    public void m15523a(String str, String str2, String str3, String str4, long j) {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C3855g.f12963a);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.THIRDPART_FEEDBACK);
        bundle.putString(ACTD.APPID_KEY, str);
        bundle.putString("taskid", str2);
        bundle.putString("actionid", str3);
        bundle.putString("result", str4);
        bundle.putLong("timestamp", j);
        intent.putExtras(bundle);
        C3854f.m15859a().m15864a(intent);
    }

    public void m15524a(String str, boolean z) {
        if (!z || !TextUtils.isEmpty(C3855g.f12982t)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - C3855g.f12955S > 5000) {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
                if (!format.equals(C3855g.f12954R)) {
                    C3799f.m15623a().m15661d(format);
                    C3799f.m15623a().m15642a(0);
                }
                if (C3855g.f12956T < 100) {
                    C3855g.f12955S = currentTimeMillis;
                    C3799f.m15623a().m15642a(C3855g.f12956T + 1);
                    C3685c.m15060b().m15053a(new C3915e(new C3845i(SDKUrlConfig.getAmpServiceUrl(), str, z)), false, true);
                }
            }
        }
    }

    public void m15525a(String str, byte[] bArr) {
        if (C3855g.f12982t != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "sendmessage");
                jSONObject.put(AgooConstants.MESSAGE_ID, String.valueOf(currentTimeMillis));
                jSONObject.put(IXAdRequestInfo.CELL_ID, C3855g.f12982t);
                jSONObject.put(ACTD.APPID_KEY, C3855g.f12963a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", C3929h.m16178b(bArr, 0));
                String jSONObject2 = jSONObject.toString();
                C3796c.m15612a().m15616a(new C3830j(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                C3876e c3880d = new C3880d();
                c3880d.m15964a();
                c3880d.f13058a = (int) currentTimeMillis;
                c3880d.f13061d = C3855g.f12982t;
                c3880d.f13062e = jSONObject2;
                c3880d.f13063f = bArr;
                c3880d.f13064g = C3855g.f12982t;
                C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
                if (str != null && str.startsWith("4T5@S_")) {
                    C3688a.m15097b("CoreAction sending lbs report message : " + jSONObject2);
                }
            } catch (Exception e) {
                C3688a.m15097b("CoreAction" + e.toString());
            }
        }
    }

    public void m15526a(boolean z) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15527a(byte[] r9) {
        /*
        r8 = this;
        r0 = 0;
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.<init>(r9);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.<init>();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r3 = "CoreAction parse sdk config from server resp : ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "result";
        r1 = r2.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0403;
    L_0x0029:
        r1 = "result";
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r3 = "ok";
        r1 = r3.equals(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0403;
    L_0x0037:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = com.igexin.push.core.p175b.C3799f.m15623a();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.m15660d(r4);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "tag";
        r1 = r2.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0052;
    L_0x004a:
        r1 = "tag";
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12652F = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0052:
        r1 = "config";
        r1 = r2.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0403;
    L_0x005a:
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "config";
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "sdk.uploadapplist.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x008d;
    L_0x006d:
        r1 = "sdk.uploadapplist.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0083;
    L_0x007b:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x008d;
    L_0x0083:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12664h = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x008d:
        r1 = "sdk.feature.sendmessage.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x00b5;
    L_0x0095:
        r1 = "sdk.feature.sendmessage.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x00ab;
    L_0x00a3:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x00b5;
    L_0x00ab:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12665i = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x00b5:
        r1 = "sdk.readlocalcell.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x00dd;
    L_0x00bd:
        r1 = "sdk.readlocalcell.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x00d3;
    L_0x00cb:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x00dd;
    L_0x00d3:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12663g = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x00dd:
        r1 = "sdk.snl.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0105;
    L_0x00e5:
        r1 = "sdk.snl.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x00fb;
    L_0x00f3:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0105;
    L_0x00fb:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12670n = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0105:
        r1 = "sdk.domainbackup.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x012d;
    L_0x010d:
        r1 = "sdk.domainbackup.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0123;
    L_0x011b:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x012d;
    L_0x0123:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12662f = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x012d:
        r1 = "sdk.feature.setsilenttime.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0165;
    L_0x0135:
        r1 = "sdk.feature.setsilenttime.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x014b;
    L_0x0143:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0165;
    L_0x014b:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12667k = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = com.igexin.push.config.C3754m.f12667k;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 != 0) goto L_0x0165;
    L_0x0159:
        r1 = com.igexin.push.config.C3754m.f12658b;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0165;
    L_0x015d:
        r1 = 12;
        r2 = 0;
        r4 = "server";
        r8.m15512a(r1, r2, r4);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0165:
        r1 = "sdk.snl.maxactiveflow";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0179;
    L_0x016d:
        r1 = "sdk.snl.maxactiveflow";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r4 = java.lang.Long.parseLong(r1);	 Catch:{ Exception -> 0x0415, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12671o = r4;	 Catch:{ Exception -> 0x0415, Throwable -> 0x040d }
    L_0x0179:
        r1 = "sdk.feature.settag.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x01a1;
    L_0x0181:
        r1 = "sdk.feature.settag.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0197;
    L_0x018f:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x01a1;
    L_0x0197:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12666j = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x01a1:
        r1 = "sdk.feature.setheartbeatinterval.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x01c9;
    L_0x01a9:
        r1 = "sdk.feature.setheartbeatinterval.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x01bf;
    L_0x01b7:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x01c9;
    L_0x01bf:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12668l = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x01c9:
        r1 = "sdk.feature.setsockettimeout.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x01f1;
    L_0x01d1:
        r1 = "sdk.feature.setsockettimeout.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x01e7;
    L_0x01df:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x01f1;
    L_0x01e7:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12669m = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x01f1:
        r1 = "sdk.guard.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0219;
    L_0x01f9:
        r1 = "sdk.guard.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x020f;
    L_0x0207:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0219;
    L_0x020f:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12672p = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0219:
        r1 = "sdk.needlook.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0248;
    L_0x0221:
        r1 = "sdk.needlook.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0237;
    L_0x022f:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0248;
    L_0x0237:
        r2 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12679w = r2;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r8.m15497b(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0248:
        r1 = "sdk.report.initialize.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0270;
    L_0x0250:
        r1 = "sdk.report.initialize.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0266;
    L_0x025e:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0270;
    L_0x0266:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12680x = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0270:
        r1 = "sdk.wakeupsdk.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0298;
    L_0x0278:
        r1 = "sdk.wakeupsdk.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x028e;
    L_0x0286:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0298;
    L_0x028e:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12673q = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0298:
        r1 = "sdk.feature.feedback.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x02c0;
    L_0x02a0:
        r1 = "sdk.feature.feedback.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x02b6;
    L_0x02ae:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x02c0;
    L_0x02b6:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12674r = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x02c0:
        r1 = "sdk.watchout.app";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x02d0;
    L_0x02c8:
        r1 = "sdk.watchout.app";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12676t = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x02d0:
        r1 = "sdk.watchout.service";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x02e0;
    L_0x02d8:
        r1 = "sdk.watchout.service";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12677u = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x02e0:
        r1 = "sdk.daemon.enable";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0308;
    L_0x02e8:
        r1 = "sdk.daemon.enable";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = "true";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x02fe;
    L_0x02f6:
        r2 = "false";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 == 0) goto L_0x0308;
    L_0x02fe:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12678v = r1;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0308:
        r1 = "sdk.reset.reconnect.delay";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x031f;
    L_0x0310:
        r1 = "sdk.reset.reconnect.delay";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r4 = java.lang.Long.parseLong(r1);	 Catch:{ Exception -> 0x0412, Throwable -> 0x040d }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        com.igexin.push.config.C3754m.f12681y = r4;	 Catch:{ Exception -> 0x0412, Throwable -> 0x040d }
    L_0x031f:
        r1 = "sdk.guard.maxcnt";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0333;
    L_0x0327:
        r1 = "sdk.guard.maxcnt";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x040f, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12651E = r1;	 Catch:{ Exception -> 0x040f, Throwable -> 0x040d }
    L_0x0333:
        r1 = "ext_infos";
        r1 = r3.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0389;
    L_0x033b:
        r1 = "ext_infos";
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0389;
    L_0x0343:
        r2 = "";
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r2 != 0) goto L_0x0389;
    L_0x034b:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "version";
        r1 = r2.has(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x0389;
    L_0x0358:
        r1 = "version";
        r4 = r2.getString(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = 1;
        r5 = com.igexin.push.config.C3754m.f12675s;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r5 == 0) goto L_0x0418;
    L_0x0363:
        r5 = com.igexin.push.config.C3754m.f12675s;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r5 = r5.m15731a();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r4 == 0) goto L_0x0418;
    L_0x036f:
        if (r0 == 0) goto L_0x0389;
    L_0x0371:
        r0 = r8.m15508a(r2);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r0 == 0) goto L_0x0389;
    L_0x0377:
        r1 = new android.os.Message;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.<init>();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r2 = com.igexin.push.core.C3794a.f12728h;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.what = r2;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1.obj = r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = com.igexin.push.core.C3854f.m15859a();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0.m15865a(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0389:
        r0 = "sdk.guardactivity.first";
        r0 = r3.has(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r0 == 0) goto L_0x03b1;
    L_0x0391:
        r0 = "sdk.guardactivity.first";
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r1 = "true";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 != 0) goto L_0x03a7;
    L_0x039f:
        r1 = "false";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r1 == 0) goto L_0x03b1;
    L_0x03a7:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12653G = r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x03b1:
        r0 = "sdk.polling.dis.cnt";
        r0 = r3.has(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r0 == 0) goto L_0x03c9;
    L_0x03b9:
        r0 = "sdk.polling.dis.cnt";
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12654H = r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x03c9:
        r0 = "sdk.polling.login.interval";
        r0 = r3.has(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r0 == 0) goto L_0x03e4;
    L_0x03d1:
        r0 = "sdk.polling.login.interval";
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = r0 * 1000;
        r0 = (long) r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12655I = r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x03e4:
        r0 = "sdk.polling.exit.heartbeat.cnt";
        r0 = r3.has(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        if (r0 == 0) goto L_0x03fc;
    L_0x03ec:
        r0 = "sdk.polling.exit.heartbeat.cnt";
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        com.igexin.push.config.C3754m.f12656J = r0;	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x03fc:
        r0 = com.igexin.push.config.C3742a.m15382a();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
        r0.m15398f();	 Catch:{ Exception -> 0x0404, Throwable -> 0x040d }
    L_0x0403:
        return;
    L_0x0404:
        r0 = move-exception;
        r0 = r0.toString();
        r8.m15547c(r0);
        goto L_0x0403;
    L_0x040d:
        r0 = move-exception;
        goto L_0x0403;
    L_0x040f:
        r1 = move-exception;
        goto L_0x0333;
    L_0x0412:
        r1 = move-exception;
        goto L_0x031f;
    L_0x0415:
        r1 = move-exception;
        goto L_0x0179;
    L_0x0418:
        r0 = r1;
        goto L_0x036f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.e.a(byte[]):void");
    }

    public boolean m15528a(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = C3754m.f12657a + C3754m.f12658b;
        if (i2 >= 24) {
            i2 -= 24;
        }
        if (C3754m.f12658b == 0) {
            return false;
        }
        if (C3754m.f12657a < i2) {
            if (i >= C3754m.f12657a && i < i2) {
                return true;
            }
        } else if (C3754m.f12657a > i2) {
            if (i >= 0 && i < i2) {
                return true;
            }
            if (i >= C3754m.f12657a && i < 24) {
                return true;
            }
        }
        return false;
    }

    public boolean m15529a(C3666d c3666d) {
        return false;
    }

    public boolean m15530a(C3876e c3876e) {
        if (c3876e == null) {
            return false;
        }
        C3772a c3772a = (C3772a) f12699a.get(Integer.valueOf(c3876e.f13034i));
        if ((c3876e instanceof C3885j) || (c3876e instanceof C3888m) || (c3876e instanceof C3890o) || (c3876e instanceof C3892q) || (c3876e instanceof C3883h)) {
            C3688a.m15097b("CoreAction|receive : " + c3876e.getClass().getName() + " resp ~~~~");
            C3671d.m14981a().m15009a(c3876e.getClass().getName());
        }
        if ((c3876e instanceof C3888m) || (c3876e instanceof C3890o) || (c3876e instanceof C3892q)) {
            C3855g.f12941E = 0;
            C3730i.m15273a().m15277e().m15259b();
        }
        if (c3772a != null) {
            c3772a.m15479a((Object) c3876e);
        }
        C3918c.m16117g().m16122h();
        return true;
    }

    public boolean m15531a(Object obj) {
        C3909j g = C3854f.m15859a().m15877g();
        if ((obj instanceof C3876e) && g != null) {
            g.m16060a((C3876e) obj);
        } else if (obj instanceof C3871a) {
            C3671d.m14981a().m15010a(false);
        } else if (obj instanceof C3872b) {
            C3671d.m14981a().m15010a(((C3872b) obj).m15927a());
        } else if (obj instanceof C3874d) {
            m15488D();
        } else if (obj instanceof C3873c) {
            m15502f(((C3873c) obj).m15929a());
        }
        return false;
    }

    public boolean m15532a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message message = new Message();
        message.what = C3794a.f12727g;
        message.obj = bundle;
        return C3854f.m15859a().m15865a(message);
    }

    public boolean m15533a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        List arrayList = new ArrayList();
        try {
            Object obj;
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = ((JSONObject) jSONArray.get(i)).getString(C4233j.f14402y);
                if (string != null) {
                    for (IPushExtension isActionSupported : C3910a.m16066a().m16072c()) {
                        if (isActionSupported.isActionSupported(string)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        C3688a.m15097b("CoreAction|extension not suport type = " + string);
                        if (f12700b.get(string) == null) {
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String string2 = jSONObject2.getString(C4233j.f14402y);
                if (string2 != null) {
                    BaseAction baseAction = null;
                    for (IPushExtension parseAction : C3910a.m16066a().m16072c()) {
                        baseAction = parseAction.parseAction(jSONObject2);
                        if (baseAction != null) {
                            break;
                        }
                    }
                    if (baseAction == null) {
                        C3759a c3759a = (C3759a) f12700b.get(string2);
                        if (c3759a != null) {
                            obj = c3759a.m15421a(jSONObject2);
                            if (obj != null) {
                                obj.setSupportExt(false);
                            }
                            if (obj != null) {
                                C3688a.m15097b("CoreAction|action chains can't parse, throw whole ++++++");
                                return false;
                            }
                            arrayList.add(obj);
                        }
                    }
                    BaseAction baseAction2 = baseAction;
                    if (obj != null) {
                        arrayList.add(obj);
                    } else {
                        C3688a.m15097b("CoreAction|action chains can't parse, throw whole ++++++");
                        return false;
                    }
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b("CoreAction|" + th.toString());
        }
        pushTaskBean.setActionChains(arrayList);
        return true;
    }

    public boolean m15534a(JSONObject jSONObject, byte[] bArr, boolean z) {
        Cursor cursor;
        Throwable th;
        try {
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("pushmessage")) {
                String string = jSONObject.getString(AgooConstants.MESSAGE_ID);
                String string2 = jSONObject.getString(ACTD.APPID_KEY);
                String string3 = jSONObject.getString("messageid");
                String string4 = jSONObject.getString("taskid");
                String string5 = jSONObject.getString(C4209a.f14204g);
                JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                C3688a.m15097b("pushmessage|" + string4 + "|" + string3 + "|" + string2 + "|" + z);
                if (string2 == null || string == null || string3 == null || string4 == null || jSONArray == null || !string2.equals(C3855g.f12963a)) {
                    C3688a.m15097b("CoreAction receieve error pushmessage +++++++++++++++++++");
                } else {
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.setAppid(string2);
                    pushTaskBean.setMessageId(string3);
                    pushTaskBean.setTaskId(string4);
                    pushTaskBean.setId(string);
                    pushTaskBean.setAppKey(string5);
                    pushTaskBean.setCurrentActionid(1);
                    if (jSONObject.has("cdnType")) {
                        pushTaskBean.setCDNType(jSONObject.getBoolean("cdnType"));
                    }
                    String c = C3777e.m15491a().m15545c(string4, string3);
                    if (z) {
                        C3777e.m15491a().m15517a(pushTaskBean, MessageService.MSG_DB_READY_REPORT);
                        if (C3777e.m15491a().m15528a(System.currentTimeMillis())) {
                            return true;
                        }
                        if (C3922a.m16144a(jSONObject)) {
                            C3688a.m15097b("CoreAction|message have loop");
                            return true;
                        }
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("messageid", string3);
                    contentValues.put("taskid", string4);
                    contentValues.put(ACTD.APPID_KEY, string2);
                    contentValues.put("key", "CACHE_" + c);
                    contentValues.put("info", C3700a.m15135b(jSONObject.toString().getBytes()));
                    contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                    if (bArr != null) {
                        contentValues.put("msgextra", bArr);
                        pushTaskBean.setMsgExtra(bArr);
                    }
                    if (jSONArray.length() > 0 && !C3777e.m15491a().m15533a(jSONObject, pushTaskBean)) {
                        C3688a.m15097b("CoreAction parseActionChains result = false #######");
                        return true;
                    } else if (z) {
                        Cursor a;
                        try {
                            a = C3854f.m15859a().m15881k().m15242a(C4233j.f14376C, new String[]{"taskid"}, new String[]{string4}, null, null);
                            if (a != null) {
                                try {
                                    C3688a.m15097b("CoreAction|taskid = " + string4 + ", db cnt = " + a.getCount());
                                    if (a.getCount() == 0) {
                                        if (jSONObject.has("condition")) {
                                            m15496b(jSONObject, pushTaskBean);
                                            pushTaskBean.setStatus(C3794a.f12731k);
                                            contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(C3794a.f12731k));
                                        } else {
                                            pushTaskBean.setStatus(C3794a.f12732l);
                                            contentValues.put(MsgConstant.KEY_STATUS, Integer.valueOf(C3794a.f12732l));
                                        }
                                        C3854f.m15859a().m15881k().m15243a(C4233j.f14376C, contentValues);
                                        C3855g.ah.put(c, pushTaskBean);
                                        if (jSONObject.has("condition")) {
                                            m15571t();
                                        } else {
                                            C3777e.m15491a().m15522a(string4, string3, C3855g.f12963a, C3855g.f12967e);
                                        }
                                    } else if (a == null) {
                                        return true;
                                    } else {
                                        a.close();
                                        return true;
                                    }
                                } catch (Exception e) {
                                    cursor = a;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                        a.close();
                                    }
                                    throw th;
                                }
                            }
                            if (a != null) {
                                a.close();
                            }
                        } catch (Exception e2) {
                            cursor = null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            a = null;
                            if (a != null) {
                                a.close();
                            }
                            throw th;
                        }
                    } else {
                        if (jSONObject.has("condition")) {
                            m15496b(jSONObject, pushTaskBean);
                        }
                        pushTaskBean.setStatus(C3794a.f12732l);
                        C3855g.ah.put(c, pushTaskBean);
                    }
                }
            }
        } catch (Exception e3) {
            C3688a.m15097b("CoreAction " + e3.toString());
        }
        return true;
    }

    public void m15535b() {
        m15549d();
    }

    public void m15536b(int i, String str) {
        C3754m.f12661e = i;
        C3742a.m15382a().m15396d();
    }

    public void m15537b(Intent intent) {
        if (intent != null && intent.hasExtra("isSlave") && intent.getBooleanExtra("isSlave", false)) {
            C3854f.m15859a().m15870a(true);
            if (intent.hasExtra("op_app")) {
                C3855g.f12940D = intent.getStringExtra("op_app");
            } else {
                C3855g.f12940D = BuildConfig.FLAVOR;
            }
            if (C3855g.f12976n) {
                m15563l();
            }
        }
    }

    public void m15538b(PushTaskBean pushTaskBean, String str) {
        String str2 = pushTaskBean.getMessageId() + "|" + str;
        C3879c c3879c;
        if (C3855g.ak.containsKey(str2)) {
            c3879c = (C3879c) C3855g.ak.get(str2);
            if (c3879c.m15961c() < 2) {
                C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3879c);
                c3879c.m15958a(c3879c.m15961c() + 1);
                m15494a(c3879c, pushTaskBean, str, str2);
            }
        } else {
            c3879c = new C3879c();
            String str3 = ITagManager.SUCCESS;
            long currentTimeMillis = System.currentTimeMillis();
            c3879c.m15957a();
            c3879c.f13053c = "FDB" + pushTaskBean.getMessageId() + "|" + pushTaskBean.getTaskId() + "|" + str + "|" + str3 + "|" + currentTimeMillis;
            c3879c.f13054d = C3855g.f12982t;
            c3879c.f13051a = (int) currentTimeMillis;
            C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3879c);
            m15494a(c3879c, pushTaskBean, str, str2);
        }
        C3688a.m15097b("cdnfeedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str);
    }

    public void m15539b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C3855g.f12955S > 5000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(C3855g.f12954R)) {
                C3799f.m15623a().m15661d(format);
                C3799f.m15623a().m15642a(0);
            }
            C3688a.m15097b("-> CoreRuntimeInfo.opAliasTimes:" + C3855g.f12956T);
            if (C3855g.f12956T < 100) {
                C3688a.m15097b("requestService bindAlias HttpTask url : " + SDKUrlConfig.getAmpServiceUrl());
                C3855g.f12955S = currentTimeMillis;
                C3799f.m15623a().m15642a(C3855g.f12956T + 1);
                C3685c.m15060b().m15053a(new C3915e(new C3838b(SDKUrlConfig.getAmpServiceUrl(), str)), false, true);
            }
        }
    }

    public void m15540b(String str, String str2) {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C3855g.f12963a);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.SET_TAG_RESULT);
        bundle.putString(IXAdRequestInfo.SN, str);
        bundle.putString(com.taobao.accs.common.Constants.KEY_HTTP_CODE, str2);
        intent.putExtras(bundle);
        C3854f.m15859a().m15864a(intent);
    }

    public void m15541b(boolean z) {
        C3685c.m15060b().m15055a((Object) new C3874d());
        C3685c.m15060b().m15070c();
        m15556e(z);
    }

    public boolean m15542b(String str, String str2, String str3) {
        Cursor a;
        Throwable th;
        int executeTimes;
        BaseAction baseAction;
        C3759a c3759a;
        String str4 = str + ":" + str2;
        PushTaskBean pushTaskBean = (PushTaskBean) C3855g.ah.get(str4);
        if (pushTaskBean == null) {
            try {
                a = C3854f.m15859a().m15881k().m15242a(C4233j.f14376C, new String[]{"taskid", "messageid"}, new String[]{str, str2}, null, null);
                if (a != null) {
                    try {
                        if (a.getCount() > 0) {
                            while (a.moveToNext()) {
                                m15534a(new JSONObject(new String(C3700a.m15136c(a.getBlob(a.getColumnIndexOrThrow("info"))))), a.getBlob(a.getColumnIndexOrThrow("msgextra")), false);
                                PushTaskBean pushTaskBean2 = (PushTaskBean) C3855g.ah.get(str + ":" + str2);
                                if (pushTaskBean2 == null) {
                                    if (a != null) {
                                        a.close();
                                    }
                                    return false;
                                }
                                pushTaskBean = pushTaskBean2;
                            }
                            if (a != null) {
                                a.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (a != null) {
                    a.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        executeTimes = pushTaskBean.getExecuteTimes();
        if (executeTimes < 50) {
            C3855g.ah.remove(str4);
            return true;
        }
        pushTaskBean.setExecuteTimes(executeTimes + 1);
        C3777e.m15491a().m15517a(pushTaskBean, str3);
        baseAction = pushTaskBean.getBaseAction(str3);
        if (baseAction == null) {
            return false;
        }
        if (baseAction.isSupportExt()) {
            while (r2.hasNext()) {
                if (r0.executeAction(pushTaskBean, baseAction)) {
                    return true;
                }
            }
        }
        c3759a = (C3759a) f12700b.get(baseAction.getType());
        return (c3759a != null || pushTaskBean.isStop()) ? false : c3759a.m15422b(pushTaskBean, baseAction);
    }

    @TargetApi(12)
    public boolean m15543b(String str, String str2, String str3, String str4) {
        byte[] bytes;
        C3688a.m15097b("startapp|broadcastPayload");
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString(ACTD.APPID_KEY, str3);
        bundle.putString("payloadid", str2 + ":" + str);
        bundle.putString("packagename", C3855g.f12967e);
        intent.setAction("com.igexin.sdk.action." + str3);
        if (str4 != null) {
            bytes = str4.getBytes();
        } else {
            PushTaskBean pushTaskBean = (PushTaskBean) C3855g.ah.get(m15545c(str, str2));
            bytes = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (bytes != null) {
            C3688a.m15097b("startapp|broadcast|payload is " + new String(bytes));
        } else {
            C3688a.m15097b("startapp|broadcast|payload is empty!");
        }
        bundle.putByteArray("payload", bytes);
        intent.putExtras(bundle);
        if (bytes != null) {
            try {
                C3688a.m15097b("startapp|broadcast|" + str3 + "|" + new String(bytes, "utf-8"));
            } catch (Exception e) {
                C3688a.m15097b("startapp|broadcast|error|" + e.toString());
                return false;
            }
        }
        C3855g.f12969g.sendBroadcast(intent);
        return true;
    }

    public C3886k m15544c() {
        C3886k c3886k = new C3886k();
        c3886k.f13093a = C3855g.f12981s;
        c3886k.f13094b = (byte) 0;
        c3886k.f13095c = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        c3886k.f13096d = C3855g.f12963a;
        try {
            if (C3922a.m16139a()) {
                int type;
                C3887l c3887l;
                WifiInfo connectionInfo;
                String ssid;
                String bssid;
                C3887l c3887l2;
                List arrayList = new ArrayList();
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) C3855g.f12969g.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null) {
                            type = activeNetworkInfo.getType();
                            try {
                                c3887l = new C3887l();
                                c3887l.f13098a = (byte) 2;
                                c3887l.f13099b = String.valueOf(type);
                                arrayList.add(c3887l);
                            } catch (Throwable th) {
                            }
                            if (type == 1) {
                                try {
                                    connectionInfo = ((WifiManager) C3855g.f12969g.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
                                    if (connectionInfo != null) {
                                        ssid = connectionInfo.getSSID();
                                        bssid = connectionInfo.getBSSID();
                                        if (ssid != null) {
                                            c3887l2 = new C3887l();
                                            c3887l2.f13098a = (byte) 1;
                                            c3887l2.f13099b = ssid;
                                            arrayList.add(c3887l2);
                                        }
                                        if (bssid != null) {
                                            c3887l = new C3887l();
                                            c3887l.f13098a = (byte) 4;
                                            c3887l.f13099b = bssid;
                                            arrayList.add(c3887l);
                                        }
                                    }
                                } catch (Throwable th2) {
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                c3886k.f13097e = arrayList;
                            }
                        }
                    }
                    type = -1;
                } catch (Throwable th3) {
                    type = -1;
                }
                if (type == 1) {
                    connectionInfo = ((WifiManager) C3855g.f12969g.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
                    if (connectionInfo != null) {
                        ssid = connectionInfo.getSSID();
                        bssid = connectionInfo.getBSSID();
                        if (ssid != null) {
                            c3887l2 = new C3887l();
                            c3887l2.f13098a = (byte) 1;
                            c3887l2.f13099b = ssid;
                            arrayList.add(c3887l2);
                        }
                        if (bssid != null) {
                            c3887l = new C3887l();
                            c3887l.f13098a = (byte) 4;
                            c3887l.f13099b = bssid;
                            arrayList.add(c3887l);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    c3886k.f13097e = arrayList;
                }
            }
        } catch (Throwable th4) {
        }
        return c3886k;
    }

    public String m15545c(String str, String str2) {
        return str + ":" + str2;
    }

    public void m15546c(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String action = intent.getAction();
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                    if (C3685c.m15060b() != null) {
                        m15489E();
                    }
                } else if ("com.igexin.sdk.action.snlrefresh".equals(action) || C3855g.f12958V.equals(action) || "com.igexin.sdk.action.snlretire".equals(action)) {
                    C3854f.m15859a().m15878h().m16037a(intent);
                } else if ("com.igexin.sdk.action.execute".equals(action)) {
                    m15503g(intent);
                } else if ("com.igexin.sdk.action.doaction".equals(action)) {
                    m15500f(intent);
                } else if ("android.intent.action.TIME_SET".equals(action)) {
                    if (C3754m.f12658b != 0) {
                        C3714c.m15218c().m15222d();
                    }
                } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                    C3855g.f12980r = 1;
                    if (m15572u()) {
                        m15571t();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C3855g.f12980r = 0;
                } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    m15501f(intent.getDataString());
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    m15498e(intent.getDataString());
                } else if ("com.igexin.sdk.action.core.clearmsg".equals(action)) {
                    C3854f.m15859a().m15881k().m15245a(C4233j.f14376C, null);
                } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && intent.getIntExtra("wifi_state", 0) == 3) {
                    C3854f.m15859a().m15874d();
                }
            } catch (Throwable th) {
                C3688a.m15097b("CoreAction" + th.toString());
            }
        }
    }

    public void m15547c(String str) {
        C3685c.m15060b().m15053a(new C3913c(new C3846j(SDKUrlConfig.getBiUploadServiceUrl(), ((m15510a(true, 4) + "2.9.3.0|sdkconfig-error|") + str).getBytes(), 0, true)), false, true);
    }

    public void m15548c(boolean z) {
        m15557f();
        m15553d(z);
    }

    public int m15549d() {
        if (C3855g.f12972j && C3855g.f12973k && !m15528a(System.currentTimeMillis()) && C3922a.m16145b()) {
            C3876e c3884i = new C3884i();
            c3884i.f13087a = C3855g.f12963a;
            return !(C3854f.m15859a().m15877g().m16058a("K-", c3884i, true) >= 0) ? 0 : 1;
        } else {
            C3688a.m15097b("CoreAction|keyNegotiate stop ++++++++++");
            return -1;
        }
    }

    public C3820b m15550d(String str, String str2) {
        C3820b c3820b = C3820b.success;
        PushTaskBean pushTaskBean = (PushTaskBean) C3855g.ah.get(str + ":" + str2);
        if (pushTaskBean == null) {
            return C3820b.stop;
        }
        int i = 0;
        C3820b c3820b2 = c3820b;
        for (BaseAction baseAction : pushTaskBean.getActionChains()) {
            c3820b = C3820b.stop;
            if (baseAction == null) {
                return c3820b;
            }
            C3820b c3820b3;
            for (IPushExtension prepareExecuteAction : C3910a.m16066a().m16072c()) {
                c3820b = prepareExecuteAction.prepareExecuteAction(pushTaskBean, baseAction);
                if (c3820b != C3820b.stop) {
                    c3820b3 = c3820b;
                    break;
                }
            }
            c3820b3 = c3820b;
            if (c3820b3 == C3820b.stop) {
                C3759a c3759a = (C3759a) f12700b.get(baseAction.getType());
                if (c3759a == null) {
                    return c3820b3;
                }
                c3820b3 = c3759a.m15420a(pushTaskBean, baseAction);
                if (c3820b3 == C3820b.stop) {
                    return c3820b3;
                }
            }
            i = c3820b3 == C3820b.wait ? i + 1 : i;
            c3820b2 = c3820b2 == C3820b.success ? c3820b3 : c3820b2;
        }
        if (!(i == 0 || C3855g.m15891a(str, Integer.valueOf(i), true))) {
            c3820b2 = C3820b.success;
        }
        return c3820b2;
    }

    public String m15551d(String str) {
        return C3855g.m15893c() == null ? null : (String) C3855g.m15893c().get(str);
    }

    public void m15552d(Intent intent) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(AgooConstants.MESSAGE_ID, -1);
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                if (intExtra != -1) {
                    C3855g.aq++;
                    if (booleanExtra) {
                        if (intent.getBooleanExtra("isReload", false)) {
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        C3855g.ap++;
                        Map b = C3855g.ar != null ? C3855g.ar.m15734b() : null;
                        if (b != null) {
                            Object obj;
                            Map map;
                            if (C3754m.f12675s != null) {
                                Map b2 = C3754m.f12675s.m15734b();
                                if (b2 == null) {
                                    return;
                                }
                                if (b2.containsKey(Integer.valueOf(intExtra))) {
                                    obj = 1;
                                    C3826f c3826f = (C3826f) b2.get(Integer.valueOf(intExtra));
                                    if (c3826f != null) {
                                        C3926e.m16166b(c3826f.m15719c());
                                    }
                                    b2.remove(Integer.valueOf(intExtra));
                                    map = b2;
                                } else {
                                    obj = null;
                                    map = b2;
                                }
                            } else {
                                Map hashMap = new HashMap();
                                C3827g c3827g = new C3827g();
                                c3827g.m15732a(MessageService.MSG_DB_READY_REPORT);
                                c3827g.m15733a(hashMap);
                                C3754m.f12675s = c3827g;
                                map = hashMap;
                                obj = null;
                            }
                            C3826f c3826f2 = (C3826f) b.get(Integer.valueOf(intExtra));
                            if (c3826f2 != null) {
                                String str = C3855g.ac + "/" + c3826f2.m15719c();
                                if (new File(str).exists()) {
                                    map.put(Integer.valueOf(intExtra), c3826f2);
                                    if (C3855g.ap == C3855g.ao) {
                                        C3754m.f12675s.m15732a(C3855g.ar.m15731a());
                                    }
                                    if (obj == null && C3910a.m16066a().m16070a(C3855g.f12969g, str, c3826f2.m15721d(), c3826f2.m15730j(), c3826f2.m15719c())) {
                                        C3688a.m15097b("CoreAction load " + c3826f2.m15721d() + " success");
                                        c3826f2.m15717b(System.currentTimeMillis());
                                        if (c3826f2.m15727g()) {
                                            C3926e.m16166b(c3826f2.m15719c());
                                            map.remove(Integer.valueOf(intExtra));
                                        }
                                    }
                                    C3742a.m15382a().m15399g();
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (C3855g.aq == C3855g.ao && C3855g.as) {
                        C3688a.m15097b("CoreActiondownload ext success, restart service ###");
                        Process.killProcess(Process.myPid());
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void m15553d(boolean z) {
        C3685c.m15060b().m15055a((Object) new C3872b(z));
        C3685c.m15060b().m15070c();
    }

    public void m15554e() {
        boolean z = false;
        if (C3855g.f12974l) {
            C3855g.f12974l = !C3855g.f12974l;
            C3855g.f12948L = (((long) Math.abs(new Random().nextInt() % 24)) * C4156a.f13949k) + System.currentTimeMillis();
        }
        C3730i.m15273a().m15277e().m15265g();
        if (C3855g.f12981s == 0) {
            C3688a.m15097b("registerReq #####");
            if (C3854f.m15859a().m15877g().m16058a("R-" + C3855g.f12938B, new C3881f(C3855g.f12984v, C3855g.f12985w, C3855g.f12938B, C3855g.f12963a), true) >= 0) {
                z = true;
            }
            C3688a.m15097b("registerReq|" + z + "|" + C3855g.f12938B);
            return;
        }
        C3876e c = m15544c();
        C3688a.m15097b("loginReqBefore|" + c.f13093a);
        if (C3854f.m15859a().m15877g().m16058a("S-" + String.valueOf(C3855g.f12981s), c, true) >= 0) {
            z = true;
        }
        if (z) {
            C3688a.m15097b("CoreAction|loginReq|" + C3855g.f12982t);
        }
    }

    public void m15555e(Intent intent) {
        try {
            Object stringExtra = intent.getStringExtra("from");
            Object stringExtra2 = intent.getStringExtra("did");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                C3688a.m15097b("CoreAction|doThirdGuardSt from or did is empty");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stringExtra).append("|").append(C3855g.f12969g.getPackageName()).append("|").append(stringExtra2).append("|").append(C3855g.f12937A).append("|").append(C3855g.f12963a).append("|").append(C3855g.f12982t).append("|").append(System.currentTimeMillis());
            C3819z.m15684a().m15687a(AgooConstants.REPORT_MESSAGE_NULL, stringBuilder.toString());
        } catch (Throwable th) {
            C3688a.m15097b("CoreAction|doThirdGuardSt exception: " + th.toString());
        }
    }

    public void m15556e(boolean z) {
        C3685c.m15060b().m15055a((Object) new C3873c(z));
        C3685c.m15060b().m15070c();
    }

    public void m15557f() {
        C3671d.m14981a().m15011b();
    }

    public int m15558g() {
        C3688a.m15095a("CoreAction|send heart beat data ........");
        return C3854f.m15859a().m15877g().m16058a("H-" + C3855g.f12982t, new C3883h(), true);
    }

    public void m15559h() {
        try {
            for (C3830j c3830j : C3796c.m15612a().m15618b()) {
                if (c3830j.m15757d() + 10000 <= System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(c3830j.m15755b());
                    C3876e c3880d = new C3880d();
                    c3880d.m15964a();
                    c3880d.f13058a = (int) currentTimeMillis;
                    c3880d.f13061d = "17258000";
                    if (jSONObject.has("extraData")) {
                        c3880d.f13063f = C3929h.m16176a(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    c3880d.f13062e = c3830j.m15755b();
                    c3880d.f13064g = C3855g.f12982t;
                    C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
                    C3688a.m15097b("freshral|" + c3830j.m15755b());
                    C3796c.m15612a().m15617a(c3830j.m15753a());
                    c3830j.m15754a(c3830j.m15757d() + 10000);
                    C3796c.m15612a().m15616a(c3830j);
                    return;
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b("CoreActionfreshRAL error :" + th.toString());
        }
    }

    public void m15560i() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "request_deviceid");
            jSONObject.put(AgooConstants.MESSAGE_ID, String.valueOf(currentTimeMillis));
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        C3876e c3880d = new C3880d();
        c3880d.m15964a();
        c3880d.f13058a = (int) currentTimeMillis;
        c3880d.f13061d = "17258000";
        c3880d.f13062e = jSONObject2;
        c3880d.f13064g = C3855g.f12982t;
        C3854f.m15859a().m15877g().m16057a("C-" + C3855g.f12982t, c3880d);
        C3688a.m15097b("CoreAction|deviceidReq");
    }

    public void m15561j() {
        C3821a c3821a = new C3821a();
        try {
            C3685c.m15060b().m15053a(new C3778f(this, null, c3821a, c3821a.f12818l), false, true);
        } catch (Throwable th) {
        }
    }

    public long m15562k() {
        return ((long) (new Random().nextInt(6) + 2)) * 60000;
    }

    @TargetApi(12)
    public void m15563l() {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C3855g.f12963a);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_CLIENTID);
        bundle.putString("clientid", C3855g.f12982t);
        intent.putExtras(bundle);
        C3688a.m15097b("broadcastClientid|" + C3855g.f12982t);
        C3854f.m15859a().m15864a(intent);
        Log.d("PushService", "clientid is " + C3855g.f12982t);
    }

    @TargetApi(12)
    public void m15564m() {
        Intent intent = new Intent();
        if (VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C3855g.f12963a);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKONLINESTATE);
        bundle.putBoolean("onlineState", C3855g.f12976n);
        intent.putExtras(bundle);
        C3854f.m15859a().m15864a(intent);
    }

    public String m15565n() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        FileInputStream fileInputStream2;
        Throwable th;
        if (new File(C3855g.f12962Z).exists()) {
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            try {
                fileInputStream = new FileInputStream(C3855g.f12962Z);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Exception e) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            fileInputStream2 = fileInputStream;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        return str;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                } catch (Exception e4) {
                    byteArrayOutputStream2 = null;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (Exception e6) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e8) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                byteArrayOutputStream2 = null;
                fileInputStream2 = null;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                    return null;
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return null;
    }

    public void m15566o() {
        List arrayList = new ArrayList();
        m15495a(arrayList);
        if (!arrayList.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "reportapplist");
                jSONObject.put("session_last", C3855g.f12981s);
                JSONArray jSONArray = new JSONArray();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ACTD.APPID_KEY, ((C3834n) arrayList.get(i)).m15785d());
                    jSONObject2.put("name", ((C3834n) arrayList.get(i)).m15781b());
                    jSONObject2.put(com.taobao.accs.common.Constants.SP_KEY_VERSION, ((C3834n) arrayList.get(i)).m15783c());
                    jSONObject2.put("versionName", ((C3834n) arrayList.get(i)).m15779a());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("applist", jSONArray);
            } catch (Exception e) {
            }
            C3685c.m15060b().m15053a(new C3913c(new C3837a(SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
            m15504g(m15567p());
            C3688a.m15097b("reportapplist");
        }
    }

    public String m15567p() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        m15495a(arrayList2);
        int size = arrayList2.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                arrayList.add(((C3834n) arrayList2.get(i)).m15785d());
            }
        }
        return arrayList.toString();
    }

    public boolean m15568q() {
        String packageName;
        boolean z;
        boolean z2;
        boolean z3;
        if (C3855g.f12969g == null) {
            packageName = C3855g.f12969g.getApplicationContext().getPackageName();
        } else {
            packageName = C3855g.f12969g.getApplicationContext().getPackageName();
        }
        try {
            ServiceInfo[] serviceInfoArr = C3855g.f12969g.getPackageManager().getPackageInfo(packageName, 4).services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.name.contains("DownloadService")) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            try {
                ProviderInfo[] providerInfoArr = C3855g.f12969g.getPackageManager().getPackageInfo(packageName, 8).providers;
                if (providerInfoArr != null) {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (providerInfo.name.contains("DownloadProvider")) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                try {
                    ActivityInfo[] activityInfoArr = C3855g.f12969g.getPackageManager().getPackageInfo(packageName, 2).receivers;
                    if (activityInfoArr != null) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (activityInfo.name.contains("DownloadReceiver")) {
                                z3 = true;
                                break;
                            }
                        }
                    }
                    z3 = false;
                } catch (Exception e) {
                    z3 = z2;
                    z2 = z;
                    z = z2;
                    z2 = z3;
                    z3 = false;
                    if (!z) {
                    }
                }
            } catch (Exception e2) {
                z3 = false;
                z2 = z;
                z = z2;
                z2 = z3;
                z3 = false;
                if (z) {
                }
            }
        } catch (Exception e3) {
            z3 = false;
            z2 = false;
            z = z2;
            z2 = z3;
            z3 = false;
            if (z) {
            }
        }
        return z && z2 && z3;
    }

    public void m15569r() {
        C3854f.m15859a().m15881k().m15245a(C4233j.f14376C, "createtime <= " + (System.currentTimeMillis() - 604800000));
    }

    public void m15570s() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = simpleDateFormat.format(new Date());
        String str = "/sdcard/libs/";
        File file = new File(str);
        String str2 = C3855g.f12967e;
        if (str2 == null) {
            str2 = "unknowPacageName";
        }
        if (file.exists()) {
            String[] list = file.list();
            int length = list.length;
            int i = 0;
            while (i < length) {
                int length2 = list[i].length();
                if (list[i].startsWith(str2) && list[i].endsWith(MsgConstant.CACHE_LOG_FILE_EXT) && length2 > str2.length() + 14 && str2.equals(list[i].substring(0, length2 - 15))) {
                    try {
                        if (Math.abs((simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(list[i].substring(str2.length() + 1, length2 - 4)).getTime()) / C4156a.f13948j) > 6) {
                            File file2 = new File(str + list[i]);
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                i++;
            }
        }
    }

    public void m15571t() {
        try {
            if (!m15490F()) {
                for (Entry entry : C3855g.ah.entrySet()) {
                    String str = (String) entry.getKey();
                    PushTaskBean pushTaskBean = (PushTaskBean) entry.getValue();
                    Object obj = BuildConfig.FLAVOR;
                    if (pushTaskBean != null && pushTaskBean.getStatus() == C3794a.f12731k) {
                        String taskId = pushTaskBean.getTaskId();
                        Map conditionMap = pushTaskBean.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (!conditionMap.containsKey("endTime") || Long.valueOf((String) conditionMap.get("endTime")).longValue() >= System.currentTimeMillis()) {
                            int intValue;
                            String str2;
                            if (conditionMap.containsKey(UtilityImpl.NET_TYPE_WIFI)) {
                                intValue = Integer.valueOf((String) conditionMap.get(UtilityImpl.NET_TYPE_WIFI)).intValue();
                                m15574w();
                                if (intValue != C3855g.f12979q) {
                                }
                            }
                            if (conditionMap.containsKey("screenOn")) {
                                intValue = Integer.valueOf((String) conditionMap.get("screenOn")).intValue();
                                m15573v();
                                if (intValue != C3855g.f12980r) {
                                }
                            }
                            if (conditionMap.containsKey("ssid")) {
                                str2 = (String) conditionMap.get("ssid");
                                m15575x();
                                if (C3855g.an.containsValue(str2)) {
                                    obj = str2;
                                }
                            }
                            if (conditionMap.containsKey(C0714a.BSSID)) {
                                str2 = (String) conditionMap.get(C0714a.BSSID);
                                if (C3855g.an.containsKey(str2)) {
                                    if (!((String) C3855g.an.get(str2)).equals(obj)) {
                                    }
                                }
                            }
                            if (!conditionMap.containsKey("startTime") || Long.valueOf((String) conditionMap.get("startTime")).longValue() <= System.currentTimeMillis()) {
                                C3777e.m15491a().m15522a(taskId, pushTaskBean.getMessageId(), C3855g.f12963a, C3855g.f12967e);
                                m15492a(C3794a.f12732l, taskId, str);
                                pushTaskBean.setStatus(C3794a.f12732l);
                            }
                        } else {
                            m15492a(C3794a.f12733m, taskId, str);
                            pushTaskBean.setStatus(C3794a.f12732l);
                        }
                    }
                }
            }
        } catch (Exception e) {
            C3688a.m15097b("CoreAction|" + e.toString());
        }
    }

    public boolean m15572u() {
        long currentTimeMillis = System.currentTimeMillis();
        if (C3855g.f12945I <= 0) {
            C3855g.f12945I = currentTimeMillis - 60000;
            return true;
        } else if (currentTimeMillis - C3855g.f12945I <= 60000) {
            return false;
        } else {
            C3855g.f12945I = currentTimeMillis;
            return true;
        }
    }

    public void m15573v() {
        if (((PowerManager) C3855g.f12969g.getSystemService("power")).isScreenOn()) {
            C3855g.f12980r = 1;
        } else {
            C3855g.f12980r = 0;
        }
    }

    public void m15574w() {
        State state = ((ConnectivityManager) C3855g.f12969g.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == State.CONNECTED || state == State.CONNECTING) {
            C3855g.f12979q = 1;
        } else {
            C3855g.f12979q = 0;
        }
    }

    public void m15575x() {
        try {
            List scanResults = ((WifiManager) C3855g.f12969g.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getScanResults();
            C3855g.an.clear();
            if (scanResults != null && !scanResults.isEmpty()) {
                for (int i = 0; i < scanResults.size(); i++) {
                    C3855g.an.put(((ScanResult) scanResults.get(i)).BSSID, ((ScanResult) scanResults.get(i)).SSID);
                }
            }
        } catch (Throwable th) {
            C3688a.m15097b("CoreAction|" + th.toString());
        }
    }

    public void m15576y() {
        if (C3754m.f12672p && System.currentTimeMillis() - this.f12702d >= 300000) {
            this.f12702d = System.currentTimeMillis();
            String str = "com.igexin.sdk.GActivity";
            Map d = C3799f.m15623a().m15658d();
            if (!d.isEmpty() && C3754m.f12651E > 0) {
                int i = 0;
                for (Entry entry : d.entrySet()) {
                    if (i < C3754m.f12651E) {
                        String str2 = (String) entry.getKey();
                        String str3 = (String) entry.getValue();
                        if (C3754m.f12653G && C3922a.m16143a(str2, "com.igexin.sdk.GActivity")) {
                            try {
                                C3854f.m15859a().m15868a(new C3780h(this, (long) ((new Random().nextInt(6) + 1) * AdError.NETWORK_ERROR_CODE), str2, str3));
                            } catch (Exception e) {
                            }
                        } else {
                            m15499e(str2, str3);
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void m15577z() {
        int i = C3855g.am - 100;
        if (i < 0) {
            C3855g.am = 0;
        } else {
            C3855g.am = i;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = C3855g.al.entrySet().iterator();
        while (it.hasNext()) {
            if (currentTimeMillis - ((Long) ((Entry) it.next()).getValue()).longValue() > C4156a.f13949k) {
                it.remove();
            }
        }
    }
}
