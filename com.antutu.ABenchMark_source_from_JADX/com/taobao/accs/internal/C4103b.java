package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.Constants.Operate;
import com.taobao.accs.p190a.C4073a;
import com.taobao.accs.p190a.C4073a.C4072a;
import com.taobao.accs.ut.monitor.ElectionRateMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.common.C4209a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.taobao.accs.internal.b */
public abstract class C4103b implements IBaseService {
    public static final String ELECTION_KEY_BLACKLIST = "blacklist";
    public static final String ELECTION_KEY_HOST = "host";
    public static final String ELECTION_KEY_SDKVS = "sdkvs";
    public static final String ELECTION_KEY_VERSION = "elversion";
    public static final String ELECTION_SERVICE_ID = "accs_election";
    public static final int ELE_ERROR_EXCEPTION = -901;
    public static final int ELE_ERROR_SERVER = -900;
    public static final int ELE_LIST_NULL = -902;
    private static int f13717e;
    private static boolean f13718f;
    private Context f13719a;
    private boolean f13720b;
    private Map<String, Integer> f13721c;
    private ScheduledThreadPoolExecutor f13722d;
    private Service f13723g;
    private ElectionRateMonitor f13724h;
    private ElectionRateMonitor f13725i;
    private ScheduledFuture<?> f13726j;
    private AccsAbstractDataListener f13727k;
    private C4072a f13728l;
    private boolean f13729m;
    private boolean f13730n;
    private ScheduledFuture<?> f13731o;

    /* renamed from: com.taobao.accs.internal.b.1 */
    static /* synthetic */ class C41051 {
        static final /* synthetic */ int[] f13746a;

        static {
            f13746a = new int[Operate.values().length];
            try {
                f13746a[Operate.TRY_ELECTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13746a[Operate.START_ELECTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13746a[Operate.ASK_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13746a[Operate.REPORT_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13746a[Operate.RESULT_ELECTION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f13746a[Operate.PING_ELECTION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        f13717e = 0;
        f13718f = false;
    }

    public C4103b(Service service) {
        this.f13720b = false;
        this.f13721c = null;
        this.f13723g = null;
        this.f13727k = new C4106c(this);
        this.f13729m = false;
        this.f13730n = false;
        this.f13723g = service;
        this.f13719a = service.getApplicationContext();
        this.f13721c = new HashMap();
        this.f13722d = C4089a.m16688a();
        AppMonitor.getInstance().register(ElectionRateMonitor.class);
    }

    private void m16777a(String str) {
        try {
            if (this.f13728l == null) {
                this.f13728l = C4073a.m16610a(this.f13719a);
            }
            this.f13728l.f13561a = str;
            C4072a c4072a = this.f13728l;
            c4072a.f13562b++;
            C4073a.m16615a(this.f13719a, this.f13728l);
            ALog.m16904i("ElectionServiceImpl", "handleResult notify result", ELECTION_KEY_HOST, str, "packMap", this.f13721c);
            for (String str2 : this.f13721c.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent(C4073a.m16620b());
                    intent.setPackage(str2);
                    intent.putExtra("operate", Operate.RESULT_ELECTION);
                    intent.putExtra("sudoPack", str);
                    intent.setClassName(str2, C4135a.channelService);
                    this.f13719a.startService(intent);
                }
            }
        } catch (Throwable th) {
            ALog.m16902e("ElectionServiceImpl", "handleResult", th, new Object[0]);
        }
    }

    private void m16778a(Map<String, Integer> map) {
        ALog.m16904i("ElectionServiceImpl", "serverElection start", Constants.KEY_ELECTION_PACKS, map.toString());
        this.f13724h = new ElectionRateMonitor();
        try {
            this.f13724h.type = "server";
            if (this.f13725i != null) {
                this.f13724h.reason = this.f13725i.reason;
            }
            GlobalClientInfo.getInstance(this.f13719a).registerListener(ELECTION_SERVICE_ID, this.f13727k);
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, this.f13719a.getPackageName());
            intent.putExtra(IntentUtil.AGOO_COMMAND, Constants.COMMAND_ELECTION);
            intent.putExtra(Constants.KEY_ELECTION_PACKS, (HashMap) map);
            m16788a(intent);
        } catch (Throwable th) {
            this.f13724h.errorCode = ELE_ERROR_EXCEPTION;
            this.f13724h.errorMsg = th.toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16779a(byte[] r11, int r12) {
        /*
        r10 = this;
        r1 = 0;
        r2 = 1;
        r0 = r10.f13730n;
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = "ElectionServiceImpl";
        r2 = "server election handled, return";
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.m16904i(r0, r2, r1);
    L_0x000f:
        return;
    L_0x0010:
        r10.f13730n = r2;
        r3 = 0;
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r12 != r0) goto L_0x0019;
    L_0x0017:
        if (r11 != 0) goto L_0x0061;
    L_0x0019:
        r0 = "ElectionServiceImpl";
        r4 = "handleServerElectionResult fail, start local election";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r6 = 0;
        r7 = "error";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        com.taobao.accs.utl.ALog.m16903e(r0, r4, r5);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r0 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        if (r12 == r0) goto L_0x0124;
    L_0x0033:
        r4 = r2;
    L_0x0034:
        r0 = r10.f13724h;	 Catch:{ Throwable -> 0x00a8, all -> 0x0106 }
        if (r0 == 0) goto L_0x0121;
    L_0x0038:
        r0 = r10.f13724h;	 Catch:{ Throwable -> 0x00a8, all -> 0x0106 }
        r0.errorCode = r12;	 Catch:{ Throwable -> 0x00a8, all -> 0x0106 }
        r0 = r10.f13724h;	 Catch:{ Throwable -> 0x00a8, all -> 0x0106 }
        r5 = "server status error";
        r0.errorMsg = r5;	 Catch:{ Throwable -> 0x00a8, all -> 0x0106 }
        r0 = r3;
    L_0x0043:
        if (r4 == 0) goto L_0x0049;
    L_0x0045:
        r0 = r10.m16783c();
    L_0x0049:
        r10.m16777a(r0);
        r0 = r10.f13724h;
        if (r0 == 0) goto L_0x000f;
    L_0x0050:
        r3 = r10.f13724h;
        if (r4 == 0) goto L_0x00a6;
    L_0x0054:
        r0 = r1;
    L_0x0055:
        r3.ret = r0;
        r0 = anet.channel.appmonitor.AppMonitor.getInstance();
        r1 = r10.f13724h;
        r0.commitStat(r1);
        goto L_0x000f;
    L_0x0061:
        r0 = new java.lang.String;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r0.<init>(r11);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r4 = "ElectionServiceImpl";
        r5 = "handleServerElectionResult";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r7 = 0;
        r8 = "json";
        r6[r7] = r8;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r7 = 1;
        r6[r7] = r0;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        com.taobao.accs.utl.ALog.m16904i(r4, r5, r6);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r5 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r0 = "host";
        r3 = r5.getString(r0);	 Catch:{ Throwable -> 0x00a8, all -> 0x00e2 }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0119, all -> 0x010b }
        if (r0 == 0) goto L_0x011e;
    L_0x0089:
        r4 = r2;
    L_0x008a:
        r0 = "blacklist";
        r0 = r5.getJSONArray(r0);	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        if (r0 == 0) goto L_0x009f;
    L_0x0092:
        r0 = r0.length();	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        if (r0 <= 0) goto L_0x009f;
    L_0x0098:
        r0 = r10.f13719a;	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        com.taobao.accs.p190a.C4073a.m16616a(r0, r11);	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        r0 = r3;
        goto L_0x0043;
    L_0x009f:
        r0 = r10.f13719a;	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        com.taobao.accs.p190a.C4073a.m16622c(r0);	 Catch:{ Throwable -> 0x0119, all -> 0x0111 }
        r0 = r3;
        goto L_0x0043;
    L_0x00a6:
        r0 = r2;
        goto L_0x0055;
    L_0x00a8:
        r0 = move-exception;
        r9 = r0;
        r0 = r3;
        r3 = r9;
    L_0x00ac:
        r4 = "ElectionServiceImpl";
        r5 = "handleServerElectionResult";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0116 }
        com.taobao.accs.utl.ALog.m16902e(r4, r5, r3, r6);	 Catch:{ all -> 0x0116 }
        r4 = r10.f13724h;	 Catch:{ all -> 0x0116 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00ba:
        r4 = r10.f13724h;	 Catch:{ all -> 0x0116 }
        r5 = -901; // 0xfffffffffffffc7b float:NaN double:NaN;
        r4.errorCode = r5;	 Catch:{ all -> 0x0116 }
        r4 = r10.f13724h;	 Catch:{ all -> 0x0116 }
        r3 = r3.toString();	 Catch:{ all -> 0x0116 }
        r4.errorMsg = r3;	 Catch:{ all -> 0x0116 }
    L_0x00c8:
        r0 = r10.m16783c();
        r10.m16777a(r0);
        r0 = r10.f13724h;
        if (r0 == 0) goto L_0x000f;
    L_0x00d3:
        r0 = r10.f13724h;
        r0.ret = r1;
        r0 = anet.channel.appmonitor.AppMonitor.getInstance();
        r1 = r10.f13724h;
        r0.commitStat(r1);
        goto L_0x000f;
    L_0x00e2:
        r0 = move-exception;
        r4 = r1;
        r9 = r0;
        r0 = r3;
        r3 = r9;
    L_0x00e7:
        if (r4 == 0) goto L_0x00ed;
    L_0x00e9:
        r0 = r10.m16783c();
    L_0x00ed:
        r10.m16777a(r0);
        r0 = r10.f13724h;
        if (r0 == 0) goto L_0x0103;
    L_0x00f4:
        r0 = r10.f13724h;
        if (r4 == 0) goto L_0x0104;
    L_0x00f8:
        r0.ret = r1;
        r0 = anet.channel.appmonitor.AppMonitor.getInstance();
        r1 = r10.f13724h;
        r0.commitStat(r1);
    L_0x0103:
        throw r3;
    L_0x0104:
        r1 = r2;
        goto L_0x00f8;
    L_0x0106:
        r0 = move-exception;
        r9 = r0;
        r0 = r3;
        r3 = r9;
        goto L_0x00e7;
    L_0x010b:
        r0 = move-exception;
        r4 = r1;
        r9 = r0;
        r0 = r3;
        r3 = r9;
        goto L_0x00e7;
    L_0x0111:
        r0 = move-exception;
        r9 = r0;
        r0 = r3;
        r3 = r9;
        goto L_0x00e7;
    L_0x0116:
        r3 = move-exception;
        r4 = r2;
        goto L_0x00e7;
    L_0x0119:
        r0 = move-exception;
        r9 = r0;
        r0 = r3;
        r3 = r9;
        goto L_0x00ac;
    L_0x011e:
        r4 = r1;
        goto L_0x008a;
    L_0x0121:
        r0 = r3;
        goto L_0x0043;
    L_0x0124:
        r4 = r1;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.b.a(byte[], int):void");
    }

    private void m16781b(Context context, String str) {
        String e = C4073a.m16626e(context);
        ALog.m16904i("ElectionServiceImpl", "selectAppToElection", Constants.KEY_ELECTION_PKG, e);
        if (TextUtils.isEmpty(e)) {
            Intent intent = new Intent(C4073a.m16620b());
            intent.putExtra("operate", Operate.START_ELECTION);
            intent.putExtra("reason", str);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), C4135a.channelService);
            context.startService(intent);
            return;
        }
        Intent intent2 = new Intent(C4073a.m16620b());
        intent2.putExtra("operate", Operate.START_ELECTION);
        intent2.putExtra("reason", str);
        intent2.setPackage(e);
        intent2.setClassName(e, C4135a.channelService);
        context.startService(intent2);
    }

    private String m16783c() {
        int i;
        CharSequence charSequence;
        Object obj;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Object th4;
        ElectionRateMonitor electionRateMonitor;
        CharSequence charSequence2 = null;
        int i2 = 0;
        ElectionRateMonitor electionRateMonitor2;
        try {
            if (this.f13721c == null || this.f13721c.size() <= 0) {
                try {
                    i = ELE_LIST_NULL;
                    String str = "apps is null";
                    charSequence = null;
                } catch (Throwable th5) {
                    th2 = th5;
                    i = ELE_LIST_NULL;
                    obj = null;
                    if (this.f13725i != null) {
                        if (TextUtils.isEmpty(obj)) {
                            this.f13725i.errorCode = i;
                            this.f13725i.errorMsg = obj;
                        }
                        electionRateMonitor = this.f13725i;
                        if (TextUtils.isEmpty(charSequence2)) {
                            i2 = 1;
                        }
                        electionRateMonitor.ret = i2;
                        AppMonitor.getInstance().commitStat(this.f13725i);
                    }
                    throw th2;
                }
            }
            charSequence = C4073a.m16612a(this.f13719a, this.f13721c);
            obj = null;
            i = 0;
            try {
                ALog.m16904i("ElectionServiceImpl", "localElection", ELECTION_KEY_HOST, charSequence);
                if (this.f13725i != null) {
                    if (!TextUtils.isEmpty(obj)) {
                        this.f13725i.errorCode = i;
                        this.f13725i.errorMsg = obj;
                    }
                    electionRateMonitor2 = this.f13725i;
                    if (!TextUtils.isEmpty(charSequence)) {
                        i2 = 1;
                    }
                    electionRateMonitor2.ret = i2;
                    AppMonitor.getInstance().commitStat(this.f13725i);
                    return charSequence;
                }
            } catch (Throwable th6) {
                th3 = th6;
                ALog.m16902e("ElectionServiceImpl", "localElection error", th3, new Object[0]);
                i = ELE_ERROR_EXCEPTION;
                th4 = th3.toString();
                if (this.f13725i != null) {
                    if (TextUtils.isEmpty(th4)) {
                        this.f13725i.errorCode = ELE_ERROR_EXCEPTION;
                        this.f13725i.errorMsg = th4;
                    }
                    electionRateMonitor2 = this.f13725i;
                    if (TextUtils.isEmpty(charSequence)) {
                        i2 = 1;
                    }
                    electionRateMonitor2.ret = i2;
                    AppMonitor.getInstance().commitStat(this.f13725i);
                    return charSequence;
                }
                return charSequence;
            }
        } catch (Throwable th7) {
            th2 = th7;
            obj = null;
            i = 0;
            if (this.f13725i != null) {
                if (TextUtils.isEmpty(obj)) {
                    this.f13725i.errorCode = i;
                    this.f13725i.errorMsg = obj;
                }
                electionRateMonitor = this.f13725i;
                if (TextUtils.isEmpty(charSequence2)) {
                    i2 = 1;
                }
                electionRateMonitor.ret = i2;
                AppMonitor.getInstance().commitStat(this.f13725i);
            }
            throw th2;
        }
        return charSequence;
    }

    private void m16785d() {
        String str;
        try {
            if (UtilityImpl.isFirstStart(this.f13719a)) {
                m16781b(this.f13719a, "first start");
                UtilityImpl.setSdkStart(this.f13719a);
                return;
            }
            str = C4073a.m16610a(this.f13719a).f13561a;
            Object packageName = this.f13719a.getPackageName();
            ALog.m16904i("ElectionServiceImpl", "tryElection begin", "isFirstStart", Boolean.valueOf(UtilityImpl.isFirstStart(this.f13719a)), "currentPack", packageName, "currentElectionPack", str);
            if (TextUtils.isEmpty(str)) {
                ALog.m16904i("ElectionServiceImpl", "host is empty, try selectAppToElection", new Object[0]);
                m16781b(this.f13719a, "host null");
            } else if (TextUtils.equals(str, packageName)) {
                ALog.m16904i("ElectionServiceImpl", "curr is host, no need election", new Object[0]);
                m16789a();
            } else {
                Intent intent = new Intent(C4073a.m16620b());
                intent.setPackage(str);
                intent.putExtra("operate", Operate.PING_ELECTION);
                intent.setClassName(str, C4135a.channelService);
                intent.putExtra("pingPack", packageName);
                this.f13719a.startService(intent);
                ALog.m16904i("ElectionServiceImpl", "tryElection send PING_ELECTION", "to pkg", str);
                this.f13722d.schedule(new C4107d(this, str), 5, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            ALog.m16902e("ElectionServiceImpl", "tryElection error", th, new Object[0]);
        }
    }

    private void m16787e() {
        try {
            if (this.f13726j != null) {
                this.f13726j.cancel(true);
                this.f13726j = null;
            }
            if (this.f13729m) {
                ALog.m16904i("ElectionServiceImpl", "reportcompleted, return", new Object[0]);
                return;
            }
            this.f13729m = true;
            ALog.m16904i("ElectionServiceImpl", "onReportComplete", new Object[0]);
            if (this.f13721c == null) {
                this.f13721c = new HashMap();
            }
            this.f13721c.put(this.f13719a.getPackageName(), Integer.valueOf(Constants.SDK_VERSION_CODE));
            if (this.f13721c.size() == 1) {
                String str = ((String[]) this.f13721c.keySet().toArray(new String[0]))[0];
                if (this.f13725i != null) {
                    this.f13725i.ret = TextUtils.isEmpty(str) ? 0 : 1;
                    AppMonitor.getInstance().commitStat(this.f13725i);
                }
                m16777a(str);
            } else {
                m16778a(this.f13721c);
                this.f13730n = false;
                this.f13731o = this.f13722d.schedule(new C4109f(this), 20, TimeUnit.SECONDS);
            }
            this.f13720b = false;
        } catch (Throwable th) {
            if (this.f13725i != null) {
                this.f13725i.errorCode = ELE_ERROR_EXCEPTION;
                this.f13725i.errorMsg = th.toString();
            }
            ALog.m16902e("ElectionServiceImpl", "onReportComplete", th, new Object[0]);
        } finally {
            this.f13720b = false;
        }
    }

    public abstract int m16788a(Intent intent);

    public abstract void m16789a();

    public void m16790a(Context context, String str) {
        try {
            if (this.f13720b) {
                ALog.m16906w("ElectionServiceImpl", "isElectioning return", new Object[0]);
                return;
            }
            this.f13728l = C4073a.m16610a(context);
            if (this.f13728l.f13562b > 20) {
                ALog.m16906w("ElectionServiceImpl", "startElection too many times, return", "times", Integer.valueOf(this.f13728l.f13562b));
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_ELECTION_OVER_MAX, str + UtilityImpl.getDeviceId(context), 0.0d);
                return;
            }
            this.f13725i = new ElectionRateMonitor();
            this.f13725i.type = AgooConstants.MESSAGE_LOCAL;
            this.f13725i.reason = str;
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_ELECTION_START_TIMES, str, 0.0d);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(C4073a.m16620b()), 32);
            this.f13720b = true;
            if (queryIntentServices == null || queryIntentServices.size() < 2) {
                String str2 = "ElectionServiceImpl";
                String str3 = "startElection apps < 2";
                Object[] objArr = new Object[2];
                objArr[0] = "services";
                objArr[1] = queryIntentServices == null ? "null" : queryIntentServices.toString();
                ALog.m16904i(str2, str3, objArr);
                m16787e();
                return;
            }
            f13717e = 0;
            ALog.m16904i("ElectionServiceImpl", "startElection begin", "locallist", queryIntentServices.toString(), "size", Integer.valueOf(queryIntentServices.size()));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (!(resolveInfo == null || resolveInfo.serviceInfo == null)) {
                    String str4 = resolveInfo.serviceInfo.packageName;
                    if (TextUtils.isEmpty(str4)) {
                        ALog.m16904i("ElectionServiceImpl", "startElection unvailable app", Constants.KEY_ELECTION_PKG, str4);
                    } else {
                        Intent intent = new Intent(C4073a.m16620b());
                        intent.putExtra("operate", Operate.ASK_VERSION);
                        intent.setPackage(str4);
                        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                        intent.putExtra(ELECTION_KEY_VERSION, 1);
                        intent.setClassName(str4, C4135a.channelService);
                        ALog.m16904i("ElectionServiceImpl", "startElection askversion", "receive pkg", str4);
                        context.startService(intent);
                        f13717e++;
                    }
                }
            }
            this.f13729m = false;
            this.f13726j = this.f13722d.schedule(new C4108e(this), 3, TimeUnit.SECONDS);
        } catch (Throwable th) {
            ALog.m16902e("ElectionServiceImpl", "startElection error", th, new Object[0]);
            this.f13720b = false;
            if (this.f13725i != null) {
                this.f13725i.errorCode = ELE_ERROR_EXCEPTION;
                this.f13725i.errorMsg = th.toString();
            }
        }
    }

    public void m16791a(boolean z) {
        ALog.m16903e("ElectionServiceImpl", "shouldStopSelf, kill:" + z, new Object[0]);
        if (this.f13723g != null) {
            this.f13723g.stopSelf();
        }
        if (z) {
            Process.killProcess(Process.myPid());
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        ALog.m16904i("ElectionServiceImpl", "onCreate,", Constants.KEY_ELECTION_SDKV, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    public void onDestroy() {
        ALog.m16903e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f13719a = null;
        this.f13723g = null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        CharSequence schemeSpecificPart;
        CharSequence action = intent.getAction();
        CharSequence packageName = this.f13719a.getPackageName();
        ALog.m16904i("ElectionServiceImpl", "onStartCommand begin", PushConsts.CMD_ACTION, action);
        if (C4144h.m16946c()) {
            try {
                if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED")) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    C4072a a = C4073a.m16610a(this.f13719a);
                    CharSequence charSequence = a.f13561a;
                    ALog.m16906w("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED", Constants.KEY_ELECTION_PKG, schemeSpecificPart, ELECTION_KEY_HOST, charSequence, "replaced", Boolean.valueOf(booleanExtra));
                    if (TextUtils.isEmpty(charSequence) || !TextUtils.equals(charSequence, schemeSpecificPart)) {
                        ALog.m16904i("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED no need election", new Object[0]);
                    } else if (this.f13719a.getPackageName().equals(C4073a.m16626e(this.f13719a))) {
                        a.f13562b = 0;
                        C4073a.m16615a(this.f13719a, a);
                        m16790a(this.f13719a, "host removed");
                    } else {
                        ALog.m16904i("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED no need election", new Object[0]);
                    }
                } else if (TextUtils.equals(action, C4073a.m16620b())) {
                    ALog.m16904i("ElectionServiceImpl", "operate is receive", "operate", (Operate) intent.getSerializableExtra("operate"));
                    Intent intent2;
                    switch (C41051.f13746a[((Operate) intent.getSerializableExtra("operate")).ordinal()]) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                            m16785d();
                            break;
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            m16790a(this.f13719a, intent.getStringExtra("reason"));
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                            int intExtra = intent.getIntExtra(ELECTION_KEY_VERSION, 0);
                            intent2 = new Intent(C4073a.m16620b());
                            intent2.putExtra("operate", Operate.REPORT_VERSION);
                            intent2.putExtra(Constants.KEY_PACKAGE_NAME, this.f13719a.getPackageName());
                            intent2.setPackage(stringExtra);
                            intent2.setClassName(stringExtra, C4135a.channelService);
                            int i3 = Constants.SDK_VERSION_CODE;
                            if (C4073a.m16617a(this.f13719a, this.f13719a.getPackageName(), intExtra)) {
                                intent2.putExtra(Constants.KEY_SDK_VERSION, Constants.SDK_VERSION_CODE);
                            } else {
                                i3 = 0;
                            }
                            this.f13719a.startService(intent2);
                            ALog.m16904i("ElectionServiceImpl", AgooConstants.MESSAGE_REPORT, Constants.KEY_ELECTION_SDKV, Integer.valueOf(i3), "from pkg", this.f13719a.getPackageName(), "to pkg", stringExtra);
                            break;
                        case SpdyProtocol.QUIC /*4*/:
                            if (!this.f13720b) {
                                ALog.m16903e("ElectionServiceImpl", "not electioning, but receive report", new Object[0]);
                                break;
                            }
                            String stringExtra2 = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                            int intExtra2 = intent.getIntExtra(Constants.KEY_SDK_VERSION, 0);
                            f13717e--;
                            if (intExtra2 != 0) {
                                this.f13721c.put(stringExtra2, Integer.valueOf(intExtra2));
                            }
                            ALog.m16904i("ElectionServiceImpl", "collect info", Constants.KEY_ELECTION_SDKV, Integer.valueOf(intExtra2), "election pkg", stringExtra2, "electionPackCount", Integer.valueOf(f13717e));
                            if (f13717e == 0) {
                                m16787e();
                                break;
                            }
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                            schemeSpecificPart = intent.getStringExtra("sudoPack");
                            ALog.m16904i("ElectionServiceImpl", "election result", ELECTION_KEY_HOST, schemeSpecificPart, "curr pkg", packageName);
                            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_ELECTION_PKG_TIMES, schemeSpecificPart, 0.0d);
                            C4073a.m16618b(this.f13719a);
                            if (!TextUtils.isEmpty(schemeSpecificPart)) {
                                if (!TextUtils.equals(schemeSpecificPart, packageName)) {
                                    m16791a(true);
                                    break;
                                }
                                m16789a();
                                break;
                            }
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                            schemeSpecificPart = C4073a.m16610a(this.f13719a).f13561a;
                            CharSequence stringExtra3 = intent.getStringExtra("pingPack");
                            if (!(TextUtils.isEmpty(schemeSpecificPart) || TextUtils.isEmpty(stringExtra3) || !TextUtils.equals(schemeSpecificPart, packageName))) {
                                ALog.m16904i("ElectionServiceImpl", "host receive ping, and report ping", "to pkg", stringExtra3, ELECTION_KEY_HOST, schemeSpecificPart);
                                intent2 = new Intent(C4073a.m16620b());
                                intent2.setPackage(stringExtra3);
                                intent2.setClassName(stringExtra3, C4135a.channelService);
                                intent2.putExtra("operate", Operate.PING_ELECTION);
                                intent2.putExtra("isPing", true);
                                intent2.putExtra("pingPack", stringExtra3);
                                intent2.putExtra(Constants.KEY_SDK_VERSION, Constants.SDK_VERSION_CODE);
                                this.f13719a.startService(intent2);
                                m16789a();
                            }
                            if (TextUtils.equals(stringExtra3, packageName)) {
                                ALog.m16904i("ElectionServiceImpl", "receive host's ping back", ELECTION_KEY_HOST, schemeSpecificPart);
                                f13718f = intent.getBooleanExtra("isPing", false);
                                break;
                            }
                            break;
                    }
                    return 2;
                }
            } catch (Throwable th) {
                ALog.m16902e("ElectionServiceImpl", "onStartCommand", th, new Object[0]);
            }
        } else if (TextUtils.equals(action, C4073a.m16620b())) {
            ALog.m16903e("ElectionServiceImpl", "election disabled", new Object[0]);
            return 2;
        }
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            Object stringExtra4 = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            Object stringExtra5 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra6 = intent.getStringExtra(Constants.KEY_TTID);
            GlobalClientInfo.getInstance(this.f13719a).setAppSecret(intent.getStringExtra(Constants.SP_APP_SECRET));
            ALog.m16904i("ElectionServiceImpl", "try to setAppInfo", C4209a.f14204g, stringExtra5, "appSecret", r5, Constants.KEY_TTID, stringExtra6, Constants.KEY_ELECTION_PKG, stringExtra4);
            if (!(TextUtils.isEmpty(stringExtra4) || TextUtils.isEmpty(stringExtra5) || !stringExtra4.equals(this.f13719a.getPackageName()))) {
                UtilityImpl.setAppInfo(this.f13719a, stringExtra5, null, stringExtra6);
            }
            if (C4144h.m16946c()) {
                return 2;
            }
        }
        schemeSpecificPart = C4073a.m16610a(this.f13719a).f13561a;
        if (TextUtils.isEmpty(schemeSpecificPart) || TextUtils.equals(schemeSpecificPart, this.f13719a.getPackageName()) || !C4144h.m16946c()) {
            ALog.m16904i("ElectionServiceImpl", "deliver to channelservice", "host pkg", schemeSpecificPart);
            return m16788a(intent);
        }
        if (!(this.f13720b || TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED"))) {
            ALog.m16904i("ElectionServiceImpl", "not electioning and not host, stop", new Object[0]);
            m16791a(true);
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }
}
