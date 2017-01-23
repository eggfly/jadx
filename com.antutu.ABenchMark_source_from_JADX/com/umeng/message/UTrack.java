package com.umeng.message;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.message.common.C4209a;
import com.umeng.message.common.C4210b;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.impl.json.JUtrack;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.IUtrack;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.C4215b;
import com.umeng.message.proguard.C4230g;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.proguard.C4239k;
import com.umeng.message.proguard.C4239k.C4235a;
import com.umeng.message.proguard.C4239k.C4236b;
import com.umeng.message.util.HttpRequest.C4263a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UTrack {
    private static final String f14146a;
    private static UTrack f14147d;
    private static IUtrack f14148e;
    private static boolean f14149j;
    private static boolean f14150k;
    private static boolean f14151l;
    private static boolean f14152m;
    private JSONObject f14153b;
    private JSONObject f14154c;
    private ScheduledThreadPoolExecutor f14155f;
    private Context f14156g;
    private boolean f14157h;
    private final String f14158i;

    /* renamed from: com.umeng.message.UTrack.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String f14114a;
        final /* synthetic */ String f14115b;
        final /* synthetic */ ICallBack f14116c;
        final /* synthetic */ UTrack f14117d;

        AnonymousClass11(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
            this.f14117d = uTrack;
            this.f14114a = str;
            this.f14115b = str2;
            this.f14116c = iCallBack;
        }

        public void run() {
            SuccessState successState;
            Exception exception;
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            str = str + "utdid:" + UmengMessageDeviceConfig.getUtdid(this.f14117d.f14156g) + ",deviceToken:" + MessageSharedPrefs.getInstance(this.f14117d.f14156g).getDeviceToken() + ";";
            if (TextUtils.isEmpty(this.f14114a) || TextUtils.isEmpty(this.f14115b)) {
                UmLog.m17138e(UTrack.f14146a, "addAlias: empty type or alias");
                Object obj = str + "addAlias: empty type or alias;";
                successState = SuccessState.FAIL_PARAM;
            } else {
                String str3 = str;
                successState = null;
            }
            if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.f14117d.f14156g))) {
                UmLog.m17138e(UTrack.f14146a, "UTDID is empty");
                obj = obj + "UTDID is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14117d.f14156g).getDeviceToken())) {
                UmLog.m17138e(UTrack.f14146a, "RegistrationId is empty");
                obj = obj + "RegistrationId is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            if (MessageSharedPrefs.getInstance(this.f14117d.f14156g).isAliasSet(0, this.f14115b, this.f14114a)) {
                UmLog.m17136d(UTrack.f14146a, String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[]{this.f14115b, this.f14114a}));
                str2 = str2 + String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request;", new Object[]{this.f14115b, this.f14114a});
                successState = SuccessState.SUCCESS_CACHE;
                Object obj2 = str2;
            } else {
                String str4 = str2;
            }
            JSONObject b;
            try {
                b = this.f14117d.m17121g();
                if (successState == null) {
                    try {
                        b.put(C4233j.f14403z, this.f14115b);
                        b.put(C4233j.f14402y, this.f14114a);
                        b.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(this.f14117d.f14156g).getLastAlias(0, this.f14114a));
                        b.put(MsgConstant.KEY_TS, System.currentTimeMillis());
                    } catch (Exception e) {
                        exception = e;
                        if (exception == null) {
                            if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                                this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                            } else {
                                try {
                                    UTrack.f14148e.addAlias(this.f14115b, this.f14114a, b, this.f14116c, false);
                                } catch (Exception e2) {
                                    if (e2 == null) {
                                        this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25");
                                    } else {
                                        this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                                    }
                                }
                            }
                            MessageSharedPrefs.getInstance(this.f14117d.f14156g).addAlias(this.f14115b, this.f14114a, 0, 1, exception.getMessage());
                        }
                        this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25");
                        MessageSharedPrefs.getInstance(this.f14117d.f14156g).addAlias(this.f14115b, this.f14114a, 0, 1, "\u6dfb\u52a0\u5931\u8d25");
                        return;
                    }
                } else if (successState == SuccessState.FAIL_PARAM) {
                    b.put(ITagManager.FAIL, obj);
                } else if (successState == SuccessState.SUCCESS_CACHE) {
                    b.put(MsgConstant.KEY_SUCCESS, obj2);
                }
                UTrack.f14148e.addAlias(this.f14115b, this.f14114a, b, this.f14116c, true);
            } catch (Exception e22) {
                exception = e22;
                b = null;
                if (exception == null) {
                    this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25");
                    MessageSharedPrefs.getInstance(this.f14117d.f14156g).addAlias(this.f14115b, this.f14114a, 0, 1, "\u6dfb\u52a0\u5931\u8d25");
                    return;
                }
                if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    this.f14116c.onMessage(false, "alias:" + this.f14115b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                } else {
                    UTrack.f14148e.addAlias(this.f14115b, this.f14114a, b, this.f14116c, false);
                }
                MessageSharedPrefs.getInstance(this.f14117d.f14156g).addAlias(this.f14115b, this.f14114a, 0, 1, exception.getMessage());
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.1 */
    class C41951 implements Runnable {
        final /* synthetic */ String f14118a;
        final /* synthetic */ int f14119b;
        final /* synthetic */ long f14120c;
        final /* synthetic */ UTrack f14121d;

        C41951(UTrack uTrack, String str, int i, long j) {
            this.f14121d = uTrack;
            this.f14118a = str;
            this.f14119b = i;
            this.f14120c = j;
        }

        public void run() {
            this.f14121d.m17110b(this.f14118a, this.f14119b, this.f14120c);
        }
    }

    /* renamed from: com.umeng.message.UTrack.2 */
    class C41962 implements Runnable {
        final /* synthetic */ String f14122a;
        final /* synthetic */ String f14123b;
        final /* synthetic */ ICallBack f14124c;
        final /* synthetic */ UTrack f14125d;

        C41962(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
            this.f14125d = uTrack;
            this.f14122a = str;
            this.f14123b = str2;
            this.f14124c = iCallBack;
        }

        public void run() {
            SuccessState successState;
            Exception exception;
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            if (TextUtils.isEmpty(this.f14122a)) {
                UmLog.m17138e(UTrack.f14146a, "addExclusiveAlias: empty type");
                Object obj = str + "addExclusiveAlias: empty type";
                successState = SuccessState.FAIL_PARAM;
            } else {
                String str3 = str;
                successState = null;
            }
            if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.f14125d.f14156g))) {
                UmLog.m17138e(UTrack.f14146a, "UTDID is empty");
                obj = obj + "UTDID is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14125d.f14156g).getDeviceToken())) {
                UmLog.m17138e(UTrack.f14146a, "RegistrationId is empty");
                obj = obj + "RegistrationId is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            if (MessageSharedPrefs.getInstance(this.f14125d.f14156g).isAliasSet(1, this.f14123b, this.f14122a)) {
                UmLog.m17136d(UTrack.f14146a, String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[]{this.f14123b, this.f14122a}));
                str2 = str2 + String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[]{this.f14123b, this.f14122a});
                successState = SuccessState.SUCCESS_CACHE;
                Object obj2 = str2;
            } else {
                String str4 = str2;
            }
            JSONObject b;
            try {
                b = this.f14125d.m17121g();
                if (successState == null) {
                    try {
                        b.put(C4233j.f14403z, this.f14123b);
                        b.put(C4233j.f14402y, this.f14122a);
                        b.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(this.f14125d.f14156g).getLastAlias(1, this.f14122a));
                        b.put(MsgConstant.KEY_TS, System.currentTimeMillis());
                    } catch (Exception e) {
                        exception = e;
                        if (exception == null) {
                            if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                                this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                            } else {
                                try {
                                    UTrack.f14148e.addExclusiveAlias(this.f14123b, this.f14122a, b, this.f14124c, false);
                                } catch (Exception e2) {
                                    if (e2 == null) {
                                        this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25");
                                    } else {
                                        this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                                    }
                                }
                            }
                            MessageSharedPrefs.getInstance(this.f14125d.f14156g).addAlias(this.f14123b, this.f14122a, 1, 1, exception.getMessage());
                        }
                        this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25");
                        MessageSharedPrefs.getInstance(this.f14125d.f14156g).addAlias(this.f14123b, this.f14122a, 1, 1, "\u6dfb\u52a0\u5931\u8d25");
                        return;
                    }
                } else if (successState == SuccessState.FAIL_PARAM) {
                    b.put(ITagManager.FAIL, obj);
                } else if (successState == SuccessState.SUCCESS_CACHE) {
                    b.put(MsgConstant.KEY_SUCCESS, obj2);
                }
                UTrack.f14148e.addExclusiveAlias(this.f14123b, this.f14122a, b, this.f14124c, true);
            } catch (Exception e22) {
                exception = e22;
                b = null;
                if (exception == null) {
                    this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25");
                    MessageSharedPrefs.getInstance(this.f14125d.f14156g).addAlias(this.f14123b, this.f14122a, 1, 1, "\u6dfb\u52a0\u5931\u8d25");
                    return;
                }
                if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    this.f14124c.onMessage(false, "alias:" + this.f14123b + "\u6dfb\u52a0\u5931\u8d25:" + exception.getMessage());
                } else {
                    UTrack.f14148e.addExclusiveAlias(this.f14123b, this.f14122a, b, this.f14124c, false);
                }
                MessageSharedPrefs.getInstance(this.f14125d.f14156g).addAlias(this.f14123b, this.f14122a, 1, 1, exception.getMessage());
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.3 */
    class C41973 implements Runnable {
        final /* synthetic */ String f14126a;
        final /* synthetic */ String f14127b;
        final /* synthetic */ ICallBack f14128c;
        final /* synthetic */ UTrack f14129d;

        C41973(UTrack uTrack, String str, String str2, ICallBack iCallBack) {
            this.f14129d = uTrack;
            this.f14126a = str;
            this.f14127b = str2;
            this.f14128c = iCallBack;
        }

        public void run() {
            SuccessState successState;
            JSONObject b;
            Exception exception;
            String str = BuildConfig.FLAVOR;
            String str2 = BuildConfig.FLAVOR;
            if (TextUtils.isEmpty(this.f14126a)) {
                UmLog.m17138e(UTrack.f14146a, "removeAlias: empty type");
                Object obj = str + "removeAlias: empty type";
                successState = SuccessState.FAIL_PARAM;
            } else {
                String str3 = str;
                successState = null;
            }
            if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.f14129d.f14156g))) {
                UmLog.m17138e(UTrack.f14146a, "UTDID is empty");
                obj = obj + "UTDID is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14129d.f14156g).getDeviceToken())) {
                UmLog.m17138e(UTrack.f14146a, "RegistrationId is empty");
                obj = obj + "RegistrationId is empty;";
                successState = SuccessState.FAIL_PARAM;
            }
            try {
                b = this.f14129d.m17121g();
                if (successState == null) {
                    try {
                        b.put(C4233j.f14403z, this.f14127b);
                        b.put(C4233j.f14402y, this.f14126a);
                        b.put(MsgConstant.KEY_TS, System.currentTimeMillis());
                    } catch (Exception e) {
                        exception = e;
                        if (exception != null) {
                            this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25");
                        } else if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                            try {
                                UTrack.f14148e.removeAlias(this.f14127b, this.f14126a, b, this.f14128c, false);
                            } catch (Exception e2) {
                                if (e2 == null) {
                                    this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25");
                                    return;
                                } else {
                                    this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25:" + exception.getMessage());
                                    return;
                                }
                            }
                        } else {
                            this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25:" + exception.getMessage());
                        }
                    }
                } else if (successState == SuccessState.FAIL_PARAM) {
                    b.put(ITagManager.FAIL, obj);
                } else if (successState == SuccessState.SUCCESS_CACHE) {
                    b.put(MsgConstant.KEY_SUCCESS, str2);
                }
                UTrack.f14148e.removeAlias(this.f14127b, this.f14126a, b, this.f14128c, true);
            } catch (Exception e22) {
                exception = e22;
                b = null;
                if (exception != null) {
                    this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25");
                } else if (exception.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    UTrack.f14148e.removeAlias(this.f14127b, this.f14126a, b, this.f14128c, false);
                } else {
                    this.f14128c.onMessage(false, "alias:" + this.f14127b + "\u79fb\u9664\u5931\u8d25:" + exception.getMessage());
                }
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.4 */
    class C41984 implements Runnable {
        final /* synthetic */ String f14130a;
        final /* synthetic */ String f14131b;
        final /* synthetic */ String f14132c;
        final /* synthetic */ long f14133d;
        final /* synthetic */ UTrack f14134e;

        C41984(UTrack uTrack, String str, String str2, String str3, long j) {
            this.f14134e = uTrack;
            this.f14130a = str;
            this.f14131b = str2;
            this.f14132c = str3;
            this.f14133d = j;
        }

        public void run() {
            this.f14134e.sendMsgLogForAgoo(this.f14130a, this.f14131b, this.f14132c, this.f14133d);
        }
    }

    /* renamed from: com.umeng.message.UTrack.5 */
    class C41995 implements Runnable {
        final /* synthetic */ UTrack f14135a;

        C41995(UTrack uTrack) {
            this.f14135a = uTrack;
        }

        public void run() {
            try {
                ArrayList a = C4239k.m17301a(this.f14135a.f14156g).m17306a();
                for (int i = 0; i < a.size(); i++) {
                    C4235a c4235a = (C4235a) a.get(i);
                    this.f14135a.m17110b(c4235a.f14406a, c4235a.f14408c, c4235a.f14407b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                UmLog.m17136d(UTrack.f14146a, th.toString());
            } finally {
                UmLog.m17136d(UTrack.f14146a, "sendCachedMsgLog finished, clear cacheLogSending flag");
                UTrack.f14149j = false;
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.6 */
    class C42006 implements Runnable {
        final /* synthetic */ UTrack f14136a;

        C42006(UTrack uTrack) {
            this.f14136a = uTrack;
        }

        public void run() {
            try {
                ArrayList c = C4239k.m17301a(this.f14136a.f14156g).m17320c();
                for (int i = 0; i < c.size(); i++) {
                    C4236b c4236b = (C4236b) c.get(i);
                    this.f14136a.sendMsgLogForAgoo(c4236b.f14410a, c4236b.f14411b, c4236b.f14412c, c4236b.f14413d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                UmLog.m17136d(UTrack.f14146a, th.toString());
            } finally {
                UTrack.f14150k = false;
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.7 */
    class C42017 implements Runnable {
        final /* synthetic */ UTrack f14137a;

        C42017(UTrack uTrack) {
            this.f14137a = uTrack;
        }

        public void run() {
            try {
                JSONObject b = this.f14137a.m17121g();
                JSONArray c = this.f14137a.m17112c();
                if (c != null) {
                    b.put("ucode", C4215b.m17207a(c.toString()));
                }
                UTrack.f14148e.trackAppLaunch(b, true);
            } catch (Exception e) {
                e.printStackTrace();
                if (e != null && e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    try {
                        UTrack.f14148e.trackAppLaunch(null, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                UmLog.m17136d(UTrack.f14146a, e.toString());
            } finally {
                UTrack.f14151l = false;
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.8 */
    class C42028 implements Runnable {
        final /* synthetic */ UTrack f14138a;

        C42028(UTrack uTrack) {
            this.f14138a = uTrack;
        }

        public void run() {
            try {
                JSONObject b = this.f14138a.m17121g();
                UmLog.m17140i(UTrack.f14146a, "trackRegister-->request:" + b.toString());
                String d = this.f14138a.m17120f();
                if (!C4230g.m17282d(d)) {
                    UmLog.m17136d(UTrack.f14146a, "TestDevice sign =" + d);
                    b.put("TD", d);
                }
                UTrack.f14148e.trackRegister(b, true);
                UTrack.f14152m = false;
            } catch (Exception e) {
                e.printStackTrace();
                if (e != null && e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    try {
                        UTrack.f14148e.trackRegister(null, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                UTrack.f14152m = false;
            } catch (Throwable th) {
                UTrack.f14152m = false;
            }
        }
    }

    /* renamed from: com.umeng.message.UTrack.9 */
    class C42039 implements Runnable {
        final /* synthetic */ byte[] f14139a;
        final /* synthetic */ UTrack f14140b;

        C42039(UTrack uTrack, byte[] bArr) {
            this.f14140b = uTrack;
            this.f14139a = bArr;
        }

        public void run() {
            JSONObject jSONObject = null;
            try {
                jSONObject = this.f14140b.m17123i();
                jSONObject.put(MsgConstant.KEY_LOCATION_PARAMS, C4263a.m17368a(this.f14139a));
                jSONObject.put(MsgConstant.KEY_LOCATION_INTERVAL, PushAgent.getInstance(this.f14140b.f14156g).getLocationInterval());
                UmLog.m17136d(UTrack.f14146a, jSONObject.toString());
                UTrack.f14148e.trackLocation(jSONObject, true);
            } catch (Exception e) {
                if (e != null && e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    UTrack.f14148e.trackLocation(jSONObject, false);
                }
            }
        }
    }

    public interface ICallBack {
        void onMessage(boolean z, String str);
    }

    enum SuccessState {
        SUCCESS_CACHE,
        SUCCESS,
        FAIL_REQUEST,
        FAIL_PARAM
    }

    static {
        f14146a = UTrack.class.getName();
        f14149j = false;
        f14150k = false;
        f14151l = false;
        f14152m = false;
    }

    private UTrack(Context context) {
        this.f14158i = C4209a.f14204g;
        this.f14156g = context.getApplicationContext();
        m17116d();
        this.f14155f = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
    }

    private void m17103a(long j) {
        if (f14151l) {
            UmLog.m17136d(f14146a, "trackAppLaunch already in queue, abort this request.");
            return;
        }
        UmLog.m17136d(f14146a, "trackAppLaunch start, set appLaunchSending flag");
        f14151l = true;
        Runnable c42017 = new C42017(this);
        UmLog.m17136d(f14146a, String.format("trackAppLaunch(delay=%d)", new Object[]{Long.valueOf(j)}));
        this.f14155f.schedule(c42017, j, TimeUnit.MILLISECONDS);
    }

    private void m17105a(String str, int i, long j) {
        if (!m17119e()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UmLog.m17138e(f14146a, "trackMsgLog: empty msgId");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C4239k.m17301a(this.f14156g).m17311a(str, i, currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            UmLog.m17136d(f14146a, "trackMsgLog: " + e.toString());
        }
        Runnable c41951 = new C41951(this, str, i, currentTimeMillis);
        long abs = (j <= 0 || i == 1 || i == 21) ? 0 : Math.abs(new Random().nextLong() % j);
        UmLog.m17136d(f14146a, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(abs)}));
        this.f14155f.schedule(c41951, abs, TimeUnit.MILLISECONDS);
    }

    private void m17106a(String str, String str2, String str3) {
        if (!m17119e()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UmLog.m17138e(f14146a, "trackMsgLogForAgoo: empty msgId");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C4239k.m17301a(this.f14156g).m17314a(str, str2, str3, currentTimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            UmLog.m17136d(f14146a, "trackMsgLog: " + e.toString());
        }
        this.f14155f.submit(new C41984(this, str, str2, str3, currentTimeMillis));
    }

    private synchronized void m17110b(String str, int i, long j) {
        JSONObject jSONObject = null;
        try {
            jSONObject = m17122h();
            jSONObject.put(MsgConstant.KEY_MSG_ID, str);
            jSONObject.put(MsgConstant.KEY_ACTION_TYPE, i);
            jSONObject.put(MsgConstant.KEY_TS, j);
            f14148e.sendMsgLog(jSONObject, str, i, j, true);
        } catch (Exception e) {
            e.printStackTrace();
            if (e != null) {
                UmLog.m17136d(f14146a, e.toString());
                if (e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                    try {
                        f14148e.sendMsgLog(jSONObject, str, i, j, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private JSONArray m17112c() {
        List g;
        int i;
        JSONArray jSONArray;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String tempValue = MessageSharedPrefs.getInstance(this.f14156g).getTempValue("ucode", BuildConfig.FLAVOR);
        if (!(tempValue == null || tempValue.equals(BuildConfig.FLAVOR))) {
            try {
                g = C4230g.m17285g(tempValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (g == null) {
                return null;
            }
            for (i = 0; i < g.size(); i++) {
                stringBuilder.append("{");
                stringBuilder.append("\"p\":");
                stringBuilder.append("\"");
                stringBuilder.append(((Ucode) g.get(i)).f14302p);
                stringBuilder.append("\"");
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append("\"t\":");
                stringBuilder.append(((Ucode) g.get(i)).f14300b);
                stringBuilder.append("}");
                if (i != g.size() - 1) {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            stringBuilder.append("]");
            try {
                jSONArray = new JSONArray(stringBuilder.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                jSONArray = null;
            }
            return jSONArray;
        }
        g = null;
        if (g == null) {
            return null;
        }
        for (i = 0; i < g.size(); i++) {
            stringBuilder.append("{");
            stringBuilder.append("\"p\":");
            stringBuilder.append("\"");
            stringBuilder.append(((Ucode) g.get(i)).f14302p);
            stringBuilder.append("\"");
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append("\"t\":");
            stringBuilder.append(((Ucode) g.get(i)).f14300b);
            stringBuilder.append("}");
            if (i != g.size() - 1) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuilder.append("]");
        jSONArray = new JSONArray(stringBuilder.toString());
        return jSONArray;
    }

    private void m17116d() {
        C4210b c4210b;
        if (this.f14153b == null) {
            c4210b = new C4210b();
            c4210b.m17170b(this.f14156g, new String[0]);
            c4210b.m17166a(this.f14156g, PushAgent.getInstance(this.f14156g).getMessageAppkey(), PushAgent.getInstance(this.f14156g).getMessageChannel());
            this.f14153b = new JSONObject();
            try {
                c4210b.m17171b(this.f14153b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f14154c == null) {
            c4210b = new C4210b();
            c4210b.m17174c(this.f14156g, new String[0]);
            c4210b.m17166a(this.f14156g, PushAgent.getInstance(this.f14156g).getMessageAppkey(), PushAgent.getInstance(this.f14156g).getMessageChannel());
            this.f14154c = new JSONObject();
            try {
                c4210b.m17175c(this.f14154c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean m17119e() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.f14156g))) {
            UmLog.m17138e(f14146a, "UTDID is empty");
            return false;
        } else if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14156g).getDeviceToken())) {
            return true;
        } else {
            UmLog.m17138e(f14146a, "RegistrationId is empty");
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private String m17120f() {
        BufferedReader bufferedReader;
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            String str = Environment.getExternalStorageDirectory().getPath() + "/data/" + this.f14156g.getPackageName() + "/";
            UmLog.m17136d(f14146a, "path=" + str);
            File file = new File(str, "umeng-message.config");
            if (!file.exists()) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                do {
                    try {
                        str = bufferedReader.readLine();
                        if (str == null) {
                            if (bufferedReader == null) {
                                return null;
                            }
                            try {
                                bufferedReader.close();
                                return null;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                    } catch (IOException e5) {
                        e3 = e5;
                    }
                } while (!str.startsWith("sign="));
                str = str.substring("sign=".length());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return str;
            } catch (FileNotFoundException e7) {
                e2 = e7;
                bufferedReader = null;
                try {
                    e2.printStackTrace();
                    if (bufferedReader == null) {
                        return null;
                    }
                    try {
                        bufferedReader.close();
                        return null;
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e62) {
                            e62.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e32 = e8;
                bufferedReader = null;
                e32.printStackTrace();
                if (bufferedReader == null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e322) {
                    e322.printStackTrace();
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    private JSONObject m17121g() {
        String deviceToken = MessageSharedPrefs.getInstance(this.f14156g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.f14156g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, this.f14153b);
        jSONObject.put(MsgConstant.KEY_UTDID, utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    public static synchronized UTrack getInstance(Context context) {
        UTrack uTrack;
        synchronized (UTrack.class) {
            if (f14147d == null) {
                f14147d = new UTrack(context);
                f14148e = new JUtrack(context);
            }
            uTrack = f14147d;
        }
        return uTrack;
    }

    private JSONObject m17122h() {
        String deviceToken = MessageSharedPrefs.getInstance(this.f14156g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.f14156g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, this.f14154c);
        jSONObject.put(MsgConstant.KEY_UTDID, utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    private JSONObject m17123i() {
        String deviceToken = MessageSharedPrefs.getInstance(this.f14156g).getDeviceToken();
        String utdid = UmengMessageDeviceConfig.getUtdid(this.f14156g);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(C4209a.f14204g, PushAgent.getInstance(this.f14156g).getMessageAppkey());
        jSONObject.put(MsgConstant.KEY_UTDID, utdid);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    public boolean addAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new AnonymousClass11(this, str2, str, iCallBack)).start();
        return false;
    }

    public void addExclusiveAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new C41962(this, str2, str, iCallBack)).start();
    }

    public JSONObject getHeader() {
        return this.f14153b;
    }

    public void removeAlias(String str, String str2, ICallBack iCallBack) {
        new Thread(new C41973(this, str2, str, iCallBack)).start();
    }

    public void sendAliasFailLog() {
        new Thread(new Runnable() {
            final /* synthetic */ UTrack f14113a;

            {
                this.f14113a = r1;
            }

            public void run() {
                try {
                    UTrack.f14148e.sendAliasFailLog(this.f14113a.m17121g());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendCachedMsgLog(long j) {
        if (!m17119e()) {
            return;
        }
        if (f14149j || f14150k) {
            UmLog.m17136d(f14146a, "sendCachedMsgLog already in queue, abort this request.");
            return;
        }
        UmLog.m17136d(f14146a, "sendCachedMsgLog start, set cacheLogSending flag");
        f14149j = true;
        f14150k = true;
        Runnable c41995 = new C41995(this);
        UmLog.m17136d(f14146a, String.format("sendCachedMsgLog(delay=%d)", new Object[]{Long.valueOf(j)}));
        this.f14155f.schedule(c41995, j, TimeUnit.MILLISECONDS);
        this.f14155f.submit(new C42006(this));
    }

    public synchronized void sendMsgLogForAgoo(String str, String str2, String str3, long j) {
        if (str3.equalsIgnoreCase(MessageService.MSG_ACCS_NOTIFY_CLICK)) {
            TaobaoRegister.clickMessage(this.f14156g, str, str2);
        } else {
            TaobaoRegister.dismissMessage(this.f14156g, str, str2);
        }
        C4239k.m17301a(this.f14156g).m17318b(str, str3);
        if (!str3.equals(MsgConstant.MESSAGE_NOTIFY_ARRIVAL)) {
            C4239k.m17301a(this.f14156g).m17324d(str);
        }
    }

    public void setClearPrevMessage(boolean z) {
        this.f14157h = z;
    }

    public void trackAppLaunch(long j) {
        if (!m17119e()) {
            return;
        }
        if (MessageSharedPrefs.getInstance(this.f14156g).getAppLaunchLogSendPolicy() == 1) {
            UmLog.m17136d(f14146a, "launch_policy=1, skip sending app launch info.");
        } else if (!MessageSharedPrefs.getInstance(this.f14156g).hasAppLaunchLogSentToday()) {
            m17103a(j);
        }
    }

    public void trackLocation(byte[] bArr) {
        if (m17119e()) {
            this.f14155f.schedule(new C42039(this, bArr), 0, TimeUnit.MILLISECONDS);
        }
    }

    public void trackMiPushMsgClick(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            m17105a(uMessage.msg_id, 21, uMessage.random_min * 60000);
        }
        if (this.f14157h) {
            ((UmengMessageHandler) PushAgent.getInstance(this.f14156g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgArrival(UMessage uMessage) {
        if (uMessage != null && uMessage.msg_id != null) {
            m17105a(uMessage.msg_id, 0, uMessage.random_min * 60000);
        }
    }

    public void trackMsgClick(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            m17105a(uMessage.msg_id, 1, uMessage.random_min * 60000);
        }
        if (!(uMessage == null || uMessage.message_id == null)) {
            m17106a(uMessage.message_id, uMessage.task_id, MessageService.MSG_ACCS_NOTIFY_CLICK);
        }
        if (this.f14157h) {
            ((UmengMessageHandler) PushAgent.getInstance(this.f14156g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgDismissed(UMessage uMessage) {
        if (!(uMessage == null || uMessage.msg_id == null)) {
            m17105a(uMessage.msg_id, 2, uMessage.random_min * 60000);
        }
        if (!(uMessage == null || uMessage.message_id == null)) {
            m17106a(uMessage.message_id, uMessage.task_id, MessageService.MSG_ACCS_NOTIFY_DISMISS);
        }
        if (this.f14157h) {
            ((UmengMessageHandler) PushAgent.getInstance(this.f14156g).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgPulled(UMessage uMessage, int i) {
        if (uMessage != null && uMessage.msg_id != null) {
            m17105a(uMessage.msg_id, i, uMessage.random_min * 60000);
        }
    }

    public void trackRegister() {
        if (!m17119e() || MessageSharedPrefs.getInstance(this.f14156g).getHasRegister()) {
            return;
        }
        if (f14152m) {
            UmLog.m17136d(f14146a, "sendRegisterLog already in queue, abort this request.");
            return;
        }
        UmLog.m17136d(f14146a, "trackRegisterLog start, set registerSending flag");
        f14152m = true;
        Runnable c42028 = new C42028(this);
        UmLog.m17136d(f14146a, String.format("trackRegister(delay=%d)", new Object[]{Integer.valueOf(0)}));
        this.f14155f.schedule(c42028, 0, TimeUnit.MILLISECONDS);
    }

    public void updateHeader() {
        C4210b c4210b = new C4210b();
        c4210b.m17170b(this.f14156g, new String[0]);
        c4210b.m17166a(this.f14156g, PushAgent.getInstance(this.f14156g).getMessageAppkey(), PushAgent.getInstance(this.f14156g).getMessageChannel());
        this.f14153b = new JSONObject();
        try {
            c4210b.m17171b(this.f14153b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c4210b = new C4210b();
        c4210b.m17174c(this.f14156g, new String[0]);
        c4210b.m17166a(this.f14156g, PushAgent.getInstance(this.f14156g).getMessageAppkey(), PushAgent.getInstance(this.f14156g).getMessageChannel());
        this.f14154c = new JSONObject();
        try {
            c4210b.m17175c(this.f14154c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
