package com.qq.p035e.comm.services;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.managers.plugin.PM;
import com.qq.p035e.comm.managers.setting.SM;
import com.qq.p035e.comm.managers.status.APPStatus;
import com.qq.p035e.comm.managers.status.DeviceStatus;
import com.qq.p035e.comm.net.NetworkCallBack;
import com.qq.p035e.comm.net.NetworkClient.Priority;
import com.qq.p035e.comm.net.NetworkClientImpl;
import com.qq.p035e.comm.net.rr.Request;
import com.qq.p035e.comm.net.rr.Response;
import com.qq.p035e.comm.net.rr.S2SSRequest;
import com.qq.p035e.comm.services.RetCodeService.RetCodeInfo;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.services.a */
public final class C4066a {
    private static final C4066a f13554a;
    private volatile Boolean f13555b;

    /* renamed from: com.qq.e.comm.services.a.1 */
    class C40651 implements NetworkCallBack {
        private /* synthetic */ SM f13551a;
        private /* synthetic */ PM f13552b;
        private /* synthetic */ long f13553c;

        C40651(C4066a c4066a, SM sm, PM pm, long j) {
            this.f13551a = sm;
            this.f13552b = pm;
            this.f13553c = j;
        }

        public final void onException(Exception exception) {
            GDTLogger.m16601e("ActivateError", exception);
            RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, -1, (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
        }

        public final void onResponse(Request request, Response response) {
            try {
                if (response.getStatusCode() == Constants.COMMAND_HANDSHAKE) {
                    String stringContent = response.getStringContent();
                    GDTLogger.m16599d("ACTIVERESPONSE:" + stringContent);
                    if (StringUtil.isEmpty(stringContent)) {
                        GDTLogger.report("SDK Server response empty string,maybe zip or tea format error");
                        RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, response.getStatusCode(), (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(stringContent);
                    int i = -1;
                    if (jSONObject.has(KEYS.RET)) {
                        i = jSONObject.getInt(KEYS.RET);
                    }
                    if (i != 0) {
                        GDTLogger.m16600e("Response Error,retCode=" + i);
                    } else {
                        if (jSONObject.has("suid")) {
                            stringContent = jSONObject.getString("suid");
                            if (!StringUtil.isEmpty(stringContent)) {
                                this.f13551a.updateSUID(stringContent);
                            }
                        }
                        if (jSONObject.has(Constants.KEY_SID)) {
                            stringContent = jSONObject.getString(Constants.KEY_SID);
                            if (!StringUtil.isEmpty(stringContent)) {
                                this.f13551a.updateSID(stringContent);
                            }
                        }
                        if (jSONObject.has("sig")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("sig");
                            if (jSONObject.has("setting")) {
                                String string;
                                jSONObject = jSONObject.getJSONObject("setting");
                                if (jSONObject.has("app") && jSONObject2.has("app")) {
                                    string = jSONObject.getString("app");
                                    this.f13551a.updateDEVCloudSetting(jSONObject2.getString("app"), string);
                                }
                                if (jSONObject.has("sdk") && jSONObject2.has("sdk")) {
                                    string = jSONObject.getString("sdk");
                                    this.f13551a.updateSDKCloudSetting(jSONObject2.getString("sdk"), string);
                                }
                                if (jSONObject.has("c")) {
                                    this.f13551a.updateContextSetting(jSONObject.getString("c"));
                                } else {
                                    this.f13551a.updateContextSetting(null);
                                }
                            }
                            if (jSONObject2.has("jar") && jSONObject2.has("url")) {
                                this.f13552b.update(jSONObject2.getString("jar"), jSONObject2.getString("url"));
                            }
                        }
                    }
                } else {
                    GDTLogger.m16600e("SDK server response code error while launch or activate,code:" + response.getStatusCode());
                }
                RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, response.getStatusCode(), (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
            } catch (Throwable e) {
                GDTLogger.m16601e("ActivateError", e);
                RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, response.getStatusCode(), (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
            } catch (Throwable e2) {
                GDTLogger.m16601e("Parse Active or launch response exception", e2);
                RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, response.getStatusCode(), (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
            } catch (Throwable e22) {
                Throwable th = e22;
                RetCodeService.getInstance().send(new RetCodeInfo("sdk.e.qq.com", "launch", BuildConfig.FLAVOR, response.getStatusCode(), (int) (System.currentTimeMillis() - this.f13553c), 0, 0, 1));
            }
        }
    }

    static {
        f13554a = new C4066a();
    }

    public C4066a() {
        this.f13555b = Boolean.valueOf(false);
    }

    public static C4066a m16594a() {
        return f13554a;
    }

    private static String m16595a(Context context) {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static String m16596a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, long j) {
        JSONObject a;
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            a = C4048a.m16535a(sm);
            try {
                String str = "sig";
                JSONObject jSONObject2 = new JSONObject();
                if (sm != null) {
                    jSONObject2.putOpt("app", sm.getDevCloudSettingSig());
                    jSONObject2.putOpt("sdk", sm.getSdkCloudSettingSig());
                }
                if (pm != null) {
                    jSONObject2.putOpt("jar", pm.getLocalSig());
                    jSONObject2.putOpt(KEYS.PLUGIN_VERSION, Integer.valueOf(pm.getPluginVersion()));
                }
                a.put(str, jSONObject2);
                str = "dev";
                jSONObject2 = new JSONObject();
                if (deviceStatus != null) {
                    jSONObject2.putOpt("did", deviceStatus.getDid());
                    jSONObject2.putOpt(IXAdRequestInfo.TEST_MODE, deviceStatus.model);
                    jSONObject2.putOpt("lg", deviceStatus.getLanguage());
                    jSONObject2.putOpt(IXAdRequestInfo.WIDTH, Integer.valueOf(deviceStatus.getDeviceWidth()));
                    jSONObject2.putOpt(IXAdRequestInfo.HEIGHT, Integer.valueOf(deviceStatus.getDeviceHeight()));
                    jSONObject2.putOpt("dd", Integer.valueOf(deviceStatus.getDeviceDensity()));
                    jSONObject2.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                    jSONObject2.putOpt(Constants.KEY_OS_VERSION, C0714a.ANDROID);
                    jSONObject2.putOpt("op", deviceStatus.getOperator());
                    jSONObject2.putOpt("mf", Build.MANUFACTURER);
                }
                a.put(str, jSONObject2);
                a.put("app", C4048a.m16536a(aPPStatus));
                jSONObject = C4048a.m16537a(deviceStatus);
                jSONObject.putOpt("process", C4066a.m16595a(context));
                a.put("c", jSONObject);
                a.put("sdk", C4048a.m16534a(pm));
                jSONObject = new JSONObject();
                jSONObject2 = new JSONObject();
                jSONObject2.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
                jSONObject.put("performance", jSONObject2);
                a.put(KEYS.BIZ, jSONObject);
            } catch (JSONException e2) {
                e = e2;
                GDTLogger.m16601e("JSONException while build init req", e);
                return a.toString();
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            a = jSONObject;
            e = th;
            GDTLogger.m16601e("JSONException while build init req", e);
            return a.toString();
        }
        return a.toString();
    }

    public static void m16597a(String str, Throwable th) {
        if (GDTADManager.getInstance() == null || !GDTADManager.getInstance().isInitialized()) {
            GDTLogger.m16603w("Report Not Work while  ADManager  not Inited");
            return;
        }
        try {
            JSONObject a = C4048a.m16535a(GDTADManager.getInstance().getSM());
            a.put("c", C4048a.m16537a(GDTADManager.getInstance().getDeviceStatus()));
            a.put("app", C4048a.m16536a(GDTADManager.getInstance().getAppStatus()));
            Map hashMap = new HashMap();
            a.put(KEYS.BIZ, hashMap);
            if (th != null) {
                hashMap.put("extype", th.getClass().getName());
                hashMap.put("ext", str + "\r" + th.getMessage() + "\r" + Arrays.toString(th.getStackTrace()));
            } else {
                hashMap.put("extype", BuildConfig.FLAVOR);
                hashMap.put("ex", str);
            }
            NetworkClientImpl.getInstance().submit(new S2SSRequest("http://sdk.e.qq.com/err", a.toString().getBytes()));
        } catch (Throwable th2) {
            GDTLogger.m16604w("Exception While build s2ss error report req", th2);
        }
    }

    public final void m16598a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        if (!this.f13555b.booleanValue()) {
            synchronized (this.f13555b) {
                if (this.f13555b.booleanValue()) {
                    return;
                }
                String a = C4066a.m16596a(sm, pm, deviceStatus, aPPStatus, context, j);
                String str = !StringUtil.isEmpty(sm.getSuid()) ? "http://sdk.e.qq.com/launch" : "http://sdk.e.qq.com/activate";
                NetworkClientImpl.getInstance().submit(new S2SSRequest(str, a.getBytes()), Priority.High, new C40651(this, sm, pm, System.currentTimeMillis()));
                this.f13555b = Boolean.valueOf(true);
            }
        }
    }
}
