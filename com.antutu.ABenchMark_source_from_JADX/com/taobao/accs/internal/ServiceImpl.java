package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.client.C4086b;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.C4095e;
import com.taobao.accs.data.C4097b;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.Message.ReqType;
import com.taobao.accs.net.C4112a;
import com.taobao.accs.p191b.C4078a;
import com.taobao.accs.ut.statistics.C4132c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4140e;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.IMessageService.Stub;

public class ServiceImpl extends C4103b {
    private static C4078a f13732i;
    private Service f13733a;
    private Context f13734b;
    private C4112a f13735c;
    private C4097b f13736d;
    private C4086b f13737e;
    private HandlerThread f13738f;
    private long f13739g;
    private long f13740h;
    private String f13741j;
    private ScheduledThreadPoolExecutor f13742k;
    private final Stub f13743l;

    /* renamed from: com.taobao.accs.internal.ServiceImpl.2 */
    class C41022 extends Stub {
        C41022() {
        }

        public boolean ping() {
            return true;
        }

        public void probe() {
            ALog.m16901d("ServiceImpl", "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
            ServiceImpl.this.f13742k.execute(new C4111h(this));
        }
    }

    public ServiceImpl(Service service) {
        super(service);
        this.f13733a = null;
        this.f13735c = null;
        this.f13741j = UtilityImpl.NET_TYPE_UNKNOWN;
        this.f13743l = new C41022();
        this.f13733a = service;
        this.f13734b = service.getApplicationContext();
    }

    private final void m16793a(Context context) {
        try {
            ALog.m16901d("ServiceImpl", "ippConnection [bind]", new Object[0]);
            Intent intent = new Intent();
            intent.setAction("org.rome.android.IPP_CALL");
            intent.setClassName("com.eg.android.AlipayGphone", "org.rome.android.ipp.binder.IppService");
            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            intent.setPackage("com.eg.android.AlipayGphone");
            context.startService(intent);
        } catch (Throwable th) {
            ALog.m16902e("ServiceImpl", "ippConnection", th, new Object[0]);
        }
    }

    private void m16796b(Intent intent) {
        int intExtra = intent.getIntExtra(IntentUtil.AGOO_COMMAND, -1);
        ALog.m16904i("ServiceImpl", "command:" + intExtra, new Object[0]);
        String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
        String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra5 = intent.getStringExtra(Constants.KEY_TTID);
        String stringExtra6 = intent.getStringExtra(Constants.KEY_SID);
        String stringExtra7 = intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            this.f13735c.m16816b(Message.BuildPing(true, 0), true);
            C4132c d = this.f13735c.m16819d();
            if (d != null) {
                d.f13866h = this.f13739g;
                d.commitUT();
            }
        }
        if (intExtra > 0 && !TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra)) {
            Message buildBindApp;
            if (intExtra == 1) {
                buildBindApp = Message.buildBindApp(this.f13734b, stringExtra4, stringExtra, stringExtra5, intent.getStringExtra(Constants.KEY_APP_VERSION), stringExtra6, stringExtra3, stringExtra7);
                if (stringExtra.equals(this.f13734b.getPackageName())) {
                    UtilityImpl.setAppInfo(this.f13734b, stringExtra4, null, stringExtra5);
                }
                if (this.f13737e.m16679c(stringExtra)) {
                    if (!intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                        ALog.m16904i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                        this.f13736d.m16750a(buildBindApp, (int) Constants.COMMAND_HANDSHAKE);
                        return;
                    }
                }
            } else if (intExtra == 2) {
                ALog.m16903e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
                buildBindApp = Message.buildUnbindApp(this.f13734b, stringExtra, stringExtra6, stringExtra3, stringExtra7);
                if (this.f13737e.m16680d(stringExtra)) {
                    ALog.m16904i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                    this.f13736d.m16750a(buildBindApp, (int) Constants.COMMAND_HANDSHAKE);
                    return;
                }
            } else if (intExtra == 5) {
                buildBindApp = Message.buildBindService(this.f13734b, stringExtra, stringExtra4, stringExtra2, stringExtra6, stringExtra3, stringExtra7);
            } else if (intExtra == 6) {
                buildBindApp = Message.buildUnbindService(this.f13734b, stringExtra, stringExtra4, stringExtra2, stringExtra6, stringExtra3, stringExtra7);
            } else if (intExtra == 3) {
                buildBindApp = Message.buildBindUser(this.f13734b, stringExtra, stringExtra4, stringExtra6, stringExtra3, stringExtra7);
                if (this.f13737e.m16678b(stringExtra, stringExtra3)) {
                    if (!intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                        ALog.m16904i("ServiceImpl", stringExtra + "/" + stringExtra3 + " isUserBinded", new Object[0]);
                        if (buildBindApp != null) {
                            this.f13736d.m16750a(buildBindApp, (int) Constants.COMMAND_HANDSHAKE);
                            return;
                        }
                        return;
                    }
                }
            } else if (intExtra == 4) {
                buildBindApp = Message.buildUnbindUser(this.f13734b, stringExtra, stringExtra4, stringExtra6, stringExtra3, stringExtra7);
            } else {
                if (intExtra == 100) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(Constants.KEY_DATA);
                    String stringExtra8 = intent.getStringExtra(Constants.KEY_DATA_ID);
                    String stringExtra9 = intent.getStringExtra(Constants.KEY_TARGET);
                    String stringExtra10 = intent.getStringExtra(Constants.KEY_BUSINESSID);
                    stringExtra6 = intent.getStringExtra(Constants.KEY_EXT_TAG);
                    ReqType reqType = null;
                    try {
                        reqType = (ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
                    } catch (Exception e) {
                    }
                    if (byteArrayExtra != null) {
                        URL url;
                        try {
                            URL url2 = new URL("https://" + C4112a.m16805b(this.f13734b));
                        } catch (Exception e2) {
                            url = null;
                        }
                        AccsRequest accsRequest = new AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra8, stringExtra9, url, stringExtra10);
                        accsRequest.setTag(stringExtra6);
                        if (reqType == null) {
                            buildBindApp = Message.buildSendData(this.f13734b, stringExtra, stringExtra4, accsRequest, false);
                        } else if (reqType == ReqType.REQ) {
                            buildBindApp = Message.buildRequest(this.f13734b, stringExtra, stringExtra4, accsRequest, false);
                        }
                    }
                } else if (intExtra == 105) {
                    buildBindApp = Message.buildElection(stringExtra, (Map) intent.getSerializableExtra(Constants.KEY_ELECTION_PACKS));
                } else if (intExtra == 106) {
                    intent.setAction(Constants.ACTION_RECEIVE);
                    intent.putExtra(IntentUtil.AGOO_COMMAND, -1);
                    C4095e.m16711a(this.f13734b, intent);
                    return;
                }
                buildBindApp = null;
            }
            if (buildBindApp != null) {
                ALog.m16901d("ServiceImpl", "try send message", new Object[0]);
                if (buildBindApp.getNetPermanceMonitor() != null) {
                    buildBindApp.getNetPermanceMonitor().onSend();
                }
                this.f13735c.m16816b(buildBindApp, true);
                return;
            }
            ALog.m16903e("ServiceImpl", "message is null", new Object[0]);
            this.f13736d.m16750a(Message.buildParameterError(stringExtra, intExtra), -2);
        }
    }

    private void m16797b(boolean z) {
        ALog.m16903e("ServiceImpl", "shouldStopSelf, kill:" + z, new Object[0]);
        if (this.f13733a != null) {
            this.f13733a.stopSelf();
        }
        if (z) {
            Process.killProcess(Process.myPid());
        }
    }

    static /* synthetic */ void m16798d() {
    }

    private synchronized void m16799e() {
        if (this.f13735c == null) {
            this.f13735c = C4112a.m16803a(this.f13734b, 0);
        }
        this.f13735c.m16807a();
    }

    public int m16800a(Intent intent) {
        Throwable th;
        int i = 2;
        if (UtilityImpl.getServiceEnabled(this.f13734b)) {
            if (ALog.isPrintLog(Level.I)) {
                ALog.m16904i("ServiceImpl", "onHostStartCommand:" + intent, new Object[0]);
            }
            int c;
            try {
                if (ALog.isPrintLog(Level.D) && intent != null) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        for (String str : extras.keySet()) {
                            ALog.m16901d("ServiceImpl", "key", str, " value", extras.get(str));
                        }
                    }
                }
                c = C4140e.m16928c();
                if (c > 3) {
                    try {
                        ALog.m16903e("ServiceImpl", "load SO fail 4 times, don't auto restart", new Object[0]);
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.int2String(c), 0.0d);
                    } catch (Throwable th2) {
                        th = th2;
                        c = i;
                        try {
                            ALog.m16902e("ServiceImpl", "onHostStartCommand", th, new Object[0]);
                            th.printStackTrace();
                            return c;
                        } finally {
                            C4085a.f13626g.incrementAndGet();
                        }
                    }
                } else {
                    i = 1;
                }
                String str2 = intent == null ? null : intent.getAction();
                if (!TextUtils.isEmpty(str2) && AgooConstants.INTENT_FROM_AGOO_PING.equals(str2)) {
                    String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_FROM_PKG);
                    ALog.m16904i("ServiceImpl", "org.agoo.android.intent.action.PING_V4,start channel by brothers", "serviceStart", Integer.valueOf(C4085a.f13626g.intValue()), AgooConstants.MESSAGE_FROM_PKG + stringExtra);
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, "startChannel", stringExtra, 0.0d);
                    if (C4085a.m16664d()) {
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, "createChannel", stringExtra, 0.0d);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    m16799e();
                    this.f13735c.m16812a(false, false);
                    C4085a.f13626g.incrementAndGet();
                    return i;
                }
                m16799e();
                if (!TextUtils.equals(str2, "android.intent.action.PACKAGE_REMOVED")) {
                    if (TextUtils.equals(str2, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                        String networkTypeExt = UtilityImpl.getNetworkTypeExt(this.f13734b);
                        boolean isNetworkConnected = UtilityImpl.isNetworkConnected(this.f13734b);
                        ALog.m16904i("ServiceImpl", "network change:" + this.f13741j + " to " + networkTypeExt, new Object[0]);
                        if (isNetworkConnected) {
                            this.f13741j = networkTypeExt;
                            this.f13735c.m16818c();
                            this.f13735c.m16812a(true, false);
                            UTMini.getInstance().commitEvent(UT.EVENT_ID, "CONNECTIVITY_CHANGE", networkTypeExt, UtilityImpl.getProxy(), MessageService.MSG_DB_READY_REPORT);
                        }
                        if (networkTypeExt.equals(UtilityImpl.NET_TYPE_UNKNOWN)) {
                            this.f13735c.m16818c();
                            this.f13741j = networkTypeExt;
                        }
                    } else if (TextUtils.equals(str2, PushConsts.ACTION_BROADCAST_TO_BOOT)) {
                        this.f13735c.m16812a(true, false);
                    } else if (TextUtils.equals(str2, PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                        ALog.m16901d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                        this.f13735c.m16812a(true, false);
                    } else if (str2.equals(Constants.ACTION_COMMAND)) {
                        m16796b(intent);
                    } else if (str2.equals(Constants.ACTION_START_FROM_AGOO)) {
                        ALog.m16904i("ServiceImpl", "ACTION_START_FROM_AGOO", new Object[0]);
                    }
                }
                C4085a.f13626g.incrementAndGet();
                c = i;
                return c;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                c = 1;
                th = th3;
                ALog.m16902e("ServiceImpl", "onHostStartCommand", th, new Object[0]);
                th.printStackTrace();
                return c;
            }
        }
        ALog.m16903e("ServiceImpl", "service disabled!", new Object[0]);
        m16797b(false);
        return 2;
    }

    public void m16801a() {
        m16802c();
    }

    public void m16802c() {
        ALog.m16904i("ServiceImpl", "startConnect", new Object[0]);
        try {
            m16799e();
            this.f13735c.m16812a(false, false);
        } catch (Throwable th) {
            ALog.m16903e("ServiceImpl", "tryConnect is error,e=" + th, new Object[0]);
        }
    }

    public IBinder onBind(Intent intent) {
        CharSequence action = intent.getAction();
        ALog.m16901d("ServiceImpl", "accs probeTaoBao begin......action=" + action, new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, AgooConstants.INTENT_FROM_AGOO_PING)) {
            return null;
        }
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "probeChannelService", UtilityImpl.getDeviceId(this.f13734b), intent.getStringExtra(AgooConstants.MESSAGE_FROM_PKG));
        return this.f13743l;
    }

    public void onCreate() {
        super.onCreate();
        GlobalClientInfo.getInstance(this.f13734b);
        C4085a.f13626g.incrementAndGet();
        this.f13736d = C4097b.m16732a(this.f13734b);
        this.f13736d.f13692b = 0;
        this.f13737e = C4086b.m16670a(this.f13734b);
        this.f13739g = System.currentTimeMillis();
        this.f13740h = this.f13739g;
        this.f13741j = UtilityImpl.getNetworkTypeExt(this.f13734b);
        this.f13742k = new ScheduledThreadPoolExecutor(2);
        if (C4575b.m19249d(this.f13734b)) {
            C4078a.m16645c(this.f13734b);
            f13732i = C4078a.m16634a(this.f13734b, (int) OtherError.CONTAINER_INVISIBLE_ERROR, false);
            if (f13732i != null) {
                f13732i.m16653a();
            }
        }
        try {
            this.f13742k.execute(new C4110g(this));
        } catch (Throwable th) {
            ALog.m16903e("ServiceImpl", "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i("ServiceImpl", "ServiceImpl onCreate", "ClassLoader", ServiceImpl.class.getClassLoader().toString(), Constants.KEY_ELECTION_SDKV, Integer.valueOf(Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(C4085a.f13626g.intValue()));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ALog.m16903e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.setServiceTime(this.f13734b, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.f13733a = null;
        this.f13734b = null;
        C4097b.m16734a();
        if (this.f13735c != null) {
            this.f13735c.m16821f();
        }
        if (this.f13738f != null) {
            this.f13738f.quit();
        }
        Process.killProcess(Process.myPid());
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }
}
