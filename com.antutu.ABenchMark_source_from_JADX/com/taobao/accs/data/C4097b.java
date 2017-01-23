package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message.C4093a;
import com.taobao.accs.data.Message.C4094b;
import com.taobao.accs.data.Message.ReqType;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.net.C4112a;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor.C4129a;
import com.taobao.accs.ut.statistics.C4130a;
import com.taobao.accs.ut.statistics.C4131b;
import com.taobao.accs.ut.statistics.C4133d;
import com.taobao.accs.ut.statistics.C4134e;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4142g;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: com.taobao.accs.data.b */
public class C4097b {
    private static C4097b f13690f;
    public ConcurrentHashMap<String, ScheduledFuture<?>> f13691a;
    public int f13692b;
    protected TrafficsMonitor f13693c;
    public FlowControl f13694d;
    public AntiBrush f13695e;
    private ConcurrentHashMap<String, Message> f13696g;
    private boolean f13697h;
    private Context f13698i;
    private C4133d f13699j;
    private Message f13700k;
    private LinkedHashMap<String, String> f13701l;
    private Runnable f13702m;

    static {
        f13690f = null;
    }

    private C4097b(Context context) {
        this.f13696g = new ConcurrentHashMap();
        this.f13691a = new ConcurrentHashMap();
        this.f13697h = false;
        this.f13701l = new MessageHandler$1(this);
        this.f13702m = new C4099d(this);
        this.f13698i = context;
        this.f13693c = new TrafficsMonitor(this.f13698i);
        this.f13694d = new FlowControl(this.f13698i);
        this.f13695e = new AntiBrush(this.f13698i);
        m16745i();
        m16764h();
    }

    public static synchronized C4097b m16732a(Context context) {
        C4097b c4097b;
        synchronized (C4097b.class) {
            if (f13690f == null) {
                f13690f = new C4097b(context);
            }
            c4097b = f13690f;
        }
        return c4097b;
    }

    private Map<ExtHeaderType, String> m16733a(C4142g c4142g) {
        Throwable th;
        Map<ExtHeaderType, String> map = null;
        if (c4142g != null) {
            try {
                int b = c4142g.m16933b();
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("MessageHandler", "extHeaderLen:" + b, new Object[0]);
                }
                int i = 0;
                while (i < b) {
                    Map<ExtHeaderType, String> hashMap;
                    int b2 = c4142g.m16933b();
                    i += 2;
                    b2 &= Message.EXT_HEADER_VALUE_MAX_LEN;
                    ExtHeaderType valueOf = ExtHeaderType.valueOf((64512 & b2) >> 10);
                    String a = c4142g.m16932a(b2);
                    b2 += i;
                    if (valueOf != null) {
                        hashMap = map == null ? new HashMap() : map;
                        try {
                            hashMap.put(valueOf, a);
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            map = hashMap;
                            th = th2;
                        }
                    } else {
                        hashMap = map;
                    }
                    if (ALog.isPrintLog(Level.D)) {
                        ALog.m16901d("MessageHandler", BuildConfig.FLAVOR, "extHeaderType", valueOf, "value", a);
                    }
                    map = hashMap;
                    i = b2;
                }
            } catch (Exception e2) {
                th = e2;
                ALog.m16902e("MessageHandler", "parseExtHeader", th, new Object[0]);
                return map;
            }
        }
        return map;
    }

    public static void m16734a() {
        f13690f = null;
    }

    private void m16735a(int i, byte[] bArr, String str, int i2) {
        C4142g c4142g = new C4142g(bArr);
        long b = (long) c4142g.m16933b();
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MessageHandler", "flag:" + Integer.toHexString((int) b), new Object[0]);
        }
        String a = c4142g.m16932a(c4142g.m16931a());
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MessageHandler", "target:" + a, new Object[0]);
        }
        String a2 = c4142g.m16932a(c4142g.m16931a());
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MessageHandler", "source:" + a2, new Object[0]);
        }
        try {
            int read;
            Message message;
            String a3 = c4142g.m16932a(c4142g.m16931a());
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MessageHandler", "dataId:" + a3, new Object[0]);
            }
            String str2 = a2 + a3;
            byte[] bArr2 = null;
            Map map = null;
            if (c4142g.available() > 0) {
                if (i2 == 2) {
                    map = m16733a(c4142g);
                }
                if (i == 0) {
                    bArr2 = c4142g.m16934c();
                } else if (i == 1) {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(c4142g);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr3 = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
                        while (true) {
                            read = gZIPInputStream.read(bArr3);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                        bArr2 = byteArrayOutputStream.toByteArray();
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (Exception e2) {
                        ALog.m16903e("MessageHandler", "uncompress data error " + e2.toString(), new Object[0]);
                        C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, this.f13692b + " uncompress data error " + e2.toString());
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (Throwable th) {
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
            c4142g.close();
            if (bArr2 == null) {
                try {
                    ALog.m16901d("MessageHandler", "oriData is null", new Object[0]);
                } catch (Exception e22) {
                    ALog.m16903e("MessageHandler", e22.toString(), new Object[0]);
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, this.f13692b + e22.toString());
                    e22.printStackTrace();
                    return;
                }
            } else if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MessageHandler", "oriData:" + String.valueOf(bArr2), new Object[0]);
            }
            int a4 = C4094b.m16699a((int) ((b >> 15) & 1));
            ReqType valueOf = ReqType.valueOf((int) ((b >> 13) & 3));
            read = (int) ((b >> 12) & 1);
            int a5 = C4093a.m16697a((int) ((b >> 11) & 1));
            boolean z = ((int) ((b >> 6) & 1)) == 1;
            ALog.m16904i("MessageHandler", this.f13692b + " dataId:" + a3 + " type:" + C4094b.m16700b(a4) + " reqType:" + valueOf.name() + " resType:" + C4093a.m16698b(a5), new Object[0]);
            if (a4 == 1 && (valueOf == ReqType.ACK || valueOf == ReqType.RES)) {
                Message message2 = (Message) this.f13696g.remove(a3);
                if (message2 != null) {
                    ALog.m16901d("MessageHandler", "reqMessage not null", new Object[0]);
                    int i3 = Constants.COMMAND_HANDSHAKE;
                    if (read == 1) {
                        try {
                            i3 = new JSONObject(new String(bArr2)).getInt(Constants.KEY_HTTP_CODE);
                        } catch (Exception e5) {
                            i3 = -3;
                        }
                    }
                    if (message2.getNetPermanceMonitor() != null) {
                        message2.getNetPermanceMonitor().onRecAck();
                    }
                    if (valueOf == ReqType.RES) {
                        m16751a(message2, i3, valueOf, bArr2, map);
                    } else {
                        m16752a(message2, i3, map);
                    }
                    m16753a(new C4129a(message2.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr.length));
                } else {
                    ALog.m16903e("MessageHandler", this.f13692b + " data ack/res reqMessage is null," + a3, new Object[0]);
                }
            }
            if (a4 == 0 && valueOf == ReqType.RES) {
                message = (Message) this.f13696g.remove(a3);
                if (message != null) {
                    m16737a(message, bArr2, bArr, str);
                    return;
                }
                ALog.m16903e("MessageHandler", this.f13692b + " contorl ACK reqMessage is null" + a3, new Object[0]);
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("MessageHandler", "Message not handled, body:" + new String(bArr2), new Object[0]);
                }
            }
            if (a4 == 1 && valueOf == ReqType.DATA && a != null) {
                String[] split = a.split("\\|");
                if (split != null && split.length >= 2) {
                    ALog.m16901d("MessageHandler", "onPush", new Object[0]);
                    if (this.f13699j != null) {
                        this.f13699j.commitUT();
                    }
                    this.f13699j = new C4133d();
                    this.f13699j.f13872c = String.valueOf(System.currentTimeMillis());
                    if (UtilityImpl.packageExist(this.f13698i, split[1])) {
                        String str3 = split.length >= 3 ? split[2] : null;
                        this.f13699j.f13874e = str3;
                        if (m16743c(str2)) {
                            ALog.m16903e("MessageHandler", this.f13692b + " msg duplicate" + a3, new Object[0]);
                            this.f13699j.f13877h = true;
                        } else {
                            m16744d(str2);
                            ALog.m16904i("MessageHandler", this.f13692b + " try deliver msg to " + split[1] + "/" + str3, new Object[0]);
                            Intent intent = new Intent(Constants.ACTION_RECEIVE);
                            intent.setPackage(split[1]);
                            intent.putExtra(IntentUtil.AGOO_COMMAND, Constants.COMMAND_RECEIVE_DATA);
                            if (split.length >= 3) {
                                intent.putExtra(Constants.KEY_SERVICE_ID, split[2]);
                            }
                            String str4 = BuildConfig.FLAVOR;
                            if (split.length >= 4) {
                                str4 = split[3];
                                intent.putExtra(Constants.KEY_USER_ID, str4);
                            }
                            intent.putExtra(Constants.KEY_DATA, bArr2);
                            intent.putExtra(Constants.KEY_DATA_ID, a3);
                            intent.putExtra(Constants.KEY_PACKAGE_NAME, this.f13698i.getPackageName());
                            intent.putExtra(C4103b.ELECTION_KEY_HOST, str);
                            intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z);
                            m16739a(map, intent);
                            if (z) {
                                m16736a(intent, a2, a, str, (short) ((int) b));
                            }
                            C4095e.m16711a(this.f13698i, intent);
                            UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBussPush", "commandId=101", "serviceId=" + str3 + " dataId=" + a3, Integer.valueOf(Constants.SDK_VERSION_CODE));
                            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_TO_BUSS, "1commandId=101serviceId=" + str3, 0.0d);
                            this.f13699j.f13871b = a3;
                            this.f13699j.f13878i = str4;
                            this.f13699j.f13875f = (bArr2 == null ? 0 : bArr2.length) + BuildConfig.FLAVOR;
                            this.f13699j.f13870a = UtilityImpl.getDeviceId(this.f13698i);
                            this.f13699j.f13873d = String.valueOf(System.currentTimeMillis());
                            m16753a(new C4129a(str3, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr.length));
                        }
                        if (a5 == 1) {
                            ALog.m16903e("MessageHandler", this.f13692b + " try to send ack dataId " + a3, new Object[0]);
                            message = Message.buildPushAck(a, a2, a3, false, (short) ((int) b), str, map);
                            C4112a.m16803a(this.f13698i, this.f13692b).m16816b(message, true);
                            m16738a(message.dataId, str3);
                            if (z) {
                                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_ACK, BuildConfig.FLAVOR, 0.0d);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ALog.m16903e("MessageHandler", "package " + split[1] + " not exist, unbind it", new Object[0]);
                    C4112a.m16803a(this.f13698i, this.f13692b).m16816b(Message.buildUnbindApp(this.f13698i, split[1], null, null, null), true);
                }
            }
        } catch (Exception e222) {
            ALog.m16903e("MessageHandler", "dataId read error " + e222.toString(), new Object[0]);
            c4142g.close();
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, this.f13692b + "data id read error" + e222.toString());
        }
    }

    private void m16736a(Intent intent, String str, String str2, String str3, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(AgooConstants.MESSAGE_FROM_PKG, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(Constants.KEY_TARGET, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                intent.putExtra(C4103b.ELECTION_KEY_HOST, str3);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16737a(com.taobao.accs.data.Message r12, byte[] r13, byte[] r14, java.lang.String r15) {
        /*
        r11 = this;
        r1 = 0;
        r3 = 0;
        r2 = -8;
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00cc }
        r4 = new java.lang.String;	 Catch:{ Throwable -> 0x00cc }
        r4.<init>(r13);	 Catch:{ Throwable -> 0x00cc }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00cc }
        r4 = com.taobao.accs.utl.ALog.Level.D;	 Catch:{ Throwable -> 0x00cc }
        r4 = com.taobao.accs.utl.ALog.isPrintLog(r4);	 Catch:{ Throwable -> 0x00cc }
        if (r4 == 0) goto L_0x0034;
    L_0x0015:
        r4 = "MessageHandler";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cc }
        r5.<init>();	 Catch:{ Throwable -> 0x00cc }
        r6 = "parse Json:";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x00cc }
        r6 = r0.toString();	 Catch:{ Throwable -> 0x00cc }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x00cc }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00cc }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00cc }
        com.taobao.accs.utl.ALog.m16901d(r4, r5, r6);	 Catch:{ Throwable -> 0x00cc }
    L_0x0034:
        r4 = "code";
        r2 = r0.getInt(r4);	 Catch:{ Throwable -> 0x00cc }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x0125;
    L_0x003e:
        r4 = r12.command;	 Catch:{ Throwable -> 0x00cc }
        r4 = r4.intValue();	 Catch:{ Throwable -> 0x00cc }
        switch(r4) {
            case 1: goto L_0x0060;
            case 2: goto L_0x00fa;
            case 3: goto L_0x0107;
            case 4: goto L_0x0116;
            default: goto L_0x0047;
        };
    L_0x0047:
        r0 = r11;
        r1 = r12;
        r4 = r13;
        r5 = r3;
        r0.m16751a(r1, r2, r3, r4, r5);
        r0 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;
        r1 = r12.serviceId;
        r2 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();
        r3 = r14.length;
        r4 = (long) r3;
        r3 = r15;
        r0.<init>(r1, r2, r3, r4);
        r11.m16753a(r0);
        return;
    L_0x0060:
        r4 = "data";
        r0 = r0.getJSONObject(r4);	 Catch:{ Throwable -> 0x00cc }
        r4 = "accsToken";
        r5 = 0;
        r4 = com.taobao.accs.utl.C4139d.m16925a(r0, r4, r5);	 Catch:{ Throwable -> 0x00cc }
        r5 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        com.taobao.accs.utl.UtilityImpl.setDeviceToken(r5, r4);	 Catch:{ Throwable -> 0x00cc }
        com.taobao.accs.utl.UtilityImpl.utdidChanged();	 Catch:{ Throwable -> 0x00cc }
        r4 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        com.taobao.accs.utl.UtilityImpl.saveUtdid(r4);	 Catch:{ Throwable -> 0x00cc }
        if (r0 == 0) goto L_0x0047;
    L_0x007c:
        r4 = "packageNames";
        r4 = r0.getJSONArray(r4);	 Catch:{ Throwable -> 0x00cc }
        if (r4 == 0) goto L_0x0047;
    L_0x0084:
        r0 = r1;
    L_0x0085:
        r5 = r4.length();	 Catch:{ Throwable -> 0x00cc }
        if (r0 >= r5) goto L_0x0047;
    L_0x008b:
        r5 = r4.getString(r0);	 Catch:{ Throwable -> 0x00cc }
        r6 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r6 = com.taobao.accs.utl.UtilityImpl.packageExist(r6, r5);	 Catch:{ Throwable -> 0x00cc }
        if (r6 == 0) goto L_0x00a5;
    L_0x0097:
        r5 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r5 = com.taobao.accs.client.C4086b.m16670a(r5);	 Catch:{ Throwable -> 0x00cc }
        r6 = r12.f13671m;	 Catch:{ Throwable -> 0x00cc }
        r5.m16675a(r6);	 Catch:{ Throwable -> 0x00cc }
    L_0x00a2:
        r0 = r0 + 1;
        goto L_0x0085;
    L_0x00a5:
        r6 = "MessageHandler";
        r7 = "unbind app";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x00cc }
        r9 = 0;
        r10 = "pkg";
        r8[r9] = r10;	 Catch:{ Throwable -> 0x00cc }
        r9 = 1;
        r8[r9] = r5;	 Catch:{ Throwable -> 0x00cc }
        com.taobao.accs.utl.ALog.m16903e(r6, r7, r8);	 Catch:{ Throwable -> 0x00cc }
        r6 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r7 = 0;
        r6 = com.taobao.accs.net.C4112a.m16803a(r6, r7);	 Catch:{ Throwable -> 0x00cc }
        r7 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r5 = com.taobao.accs.data.Message.buildUnbindApp(r7, r5, r8, r9, r10);	 Catch:{ Throwable -> 0x00cc }
        r7 = 1;
        r6.m16816b(r5, r7);	 Catch:{ Throwable -> 0x00cc }
        goto L_0x00a2;
    L_0x00cc:
        r0 = move-exception;
        r4 = "MessageHandler";
        r5 = "handleControlMessage";
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.m16902e(r4, r5, r0, r1);
        r1 = "accs";
        r4 = "send_fail";
        r5 = "handleControlMessage";
        r6 = "";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r11.f13692b;
        r7 = r7.append(r8);
        r0 = r0.toString();
        r0 = r7.append(r0);
        r0 = r0.toString();
        com.taobao.accs.utl.C4136b.m16917a(r1, r4, r5, r6, r0);
        goto L_0x0047;
    L_0x00fa:
        r0 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r0 = com.taobao.accs.client.C4086b.m16670a(r0);	 Catch:{ Throwable -> 0x00cc }
        r4 = r12.f13671m;	 Catch:{ Throwable -> 0x00cc }
        r0.m16677b(r4);	 Catch:{ Throwable -> 0x00cc }
        goto L_0x0047;
    L_0x0107:
        r0 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r0 = com.taobao.accs.client.C4086b.m16670a(r0);	 Catch:{ Throwable -> 0x00cc }
        r4 = r12.f13671m;	 Catch:{ Throwable -> 0x00cc }
        r5 = r12.userinfo;	 Catch:{ Throwable -> 0x00cc }
        r0.m16676a(r4, r5);	 Catch:{ Throwable -> 0x00cc }
        goto L_0x0047;
    L_0x0116:
        r0 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r0 = com.taobao.accs.client.C4086b.m16670a(r0);	 Catch:{ Throwable -> 0x00cc }
        r4 = r12.f13671m;	 Catch:{ Throwable -> 0x00cc }
        r5 = r12.userinfo;	 Catch:{ Throwable -> 0x00cc }
        r0.m16681e(r4);	 Catch:{ Throwable -> 0x00cc }
        goto L_0x0047;
    L_0x0125:
        r0 = r12.command;	 Catch:{ Throwable -> 0x00cc }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x00cc }
        r4 = 3;
        if (r0 != r4) goto L_0x0047;
    L_0x012e:
        r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r2 != r0) goto L_0x0047;
    L_0x0132:
        r0 = r11.f13698i;	 Catch:{ Throwable -> 0x00cc }
        r0 = com.taobao.accs.client.C4086b.m16670a(r0);	 Catch:{ Throwable -> 0x00cc }
        r4 = r12.f13671m;	 Catch:{ Throwable -> 0x00cc }
        r0.m16677b(r4);	 Catch:{ Throwable -> 0x00cc }
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.b.a(com.taobao.accs.data.Message, byte[], byte[], java.lang.String):void");
    }

    private void m16738a(String str, String str2) {
        C4134e c4134e = new C4134e();
        c4134e.f13881a = UtilityImpl.getDeviceId(this.f13698i);
        c4134e.f13883c = str;
        c4134e.f13884d = BuildConfig.FLAVOR + System.currentTimeMillis();
        c4134e.f13886f = BuildConfig.FLAVOR;
        c4134e.f13885e = str2;
        c4134e.f13882b = BuildConfig.FLAVOR;
        c4134e.commitUT();
    }

    private void m16739a(Map<ExtHeaderType, String> map, Intent intent) {
        if (map != null && intent != null) {
            for (ExtHeaderType extHeaderType : ExtHeaderType.values()) {
                String str = (String) map.get(extHeaderType);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra(extHeaderType.toString(), str);
                }
            }
        }
    }

    private void m16740b(Message message, int i) {
        if (message != null) {
            String deviceId = UtilityImpl.getDeviceId(this.f13698i);
            String str = System.currentTimeMillis() + BuildConfig.FLAVOR;
            boolean z = true;
            if (i != Constants.COMMAND_HANDSHAKE) {
                z = false;
            }
            switch (message.command.intValue()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    C4130a c4130a = new C4130a();
                    c4130a.f13846a = deviceId;
                    c4130a.f13847b = str;
                    c4130a.f13848c = z;
                    c4130a.m16896a(i);
                    c4130a.commitUT();
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    C4131b c4131b = new C4131b();
                    c4131b.f13852a = deviceId;
                    c4131b.f13853b = str;
                    c4131b.f13854c = z;
                    c4131b.f13856e = message.userinfo;
                    c4131b.m16899a(i);
                    c4131b.commitUT();
                default:
            }
        }
    }

    private boolean m16741b(int i) {
        return i == -1 || i == -9 || i == -10 || i == -11;
    }

    private Intent m16742c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f13671m);
        intent.putExtra(IntentUtil.AGOO_COMMAND, message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        if (message.command != null && message.command.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        return intent;
    }

    private boolean m16743c(String str) {
        return !TextUtils.isEmpty(str) && this.f13701l.containsKey(str);
    }

    private void m16744d(String str) {
        if (!TextUtils.isEmpty(str) && !this.f13701l.containsKey(str)) {
            this.f13701l.put(str, str);
            m16746j();
        }
    }

    private void m16745i() {
        try {
            File file = new File(this.f13698i.getDir(AgooConstants.MESSAGE_SOURCE_ACCS, 0), C4233j.f14376C);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.f13701l.put(readLine, readLine);
                    } else {
                        bufferedReader.close();
                        return;
                    }
                }
            }
            ALog.m16901d("MessageHandler", "message file not exist", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m16746j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f13698i.getDir(AgooConstants.MESSAGE_SOURCE_ACCS, 0), C4233j.f14376C));
            fileWriter.write(BuildConfig.FLAVOR);
            for (String str : this.f13701l.keySet()) {
                fileWriter.append(str + "\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message m16747a(String str) {
        return (Message) this.f13696g.get(str);
    }

    public void m16748a(int i) {
        this.f13697h = false;
        String[] strArr = (String[]) this.f13696g.keySet().toArray(new String[0]);
        if (strArr != null && strArr.length > 0) {
            ALog.m16901d("MessageHandler", "onNetworkFail", new Object[0]);
            for (Object remove : strArr) {
                Message message = (Message) this.f13696g.remove(remove);
                if (message != null) {
                    m16750a(message, i);
                }
            }
        }
    }

    public void m16749a(Message message) {
        if (!(this.f13700k == null || message.cunstomDataId == null || message.serviceId == null || this.f13700k.cunstomDataId != message.cunstomDataId || this.f13700k.serviceId != message.serviceId)) {
            UTMini.getInstance().commitEvent(UT.EVENT_ID, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() != -1 && message.getType() != 2 && !message.isAck) {
            this.f13696g.put(message.getDataId(), message);
        }
    }

    public void m16750a(Message message, int i) {
        m16751a(message, i, null, null, null);
    }

    public void m16751a(Message message, int i, ReqType reqType, byte[] bArr, Map<ExtHeaderType, String> map) {
        if (message.command == null || message.getType() < 0 || message.getType() == 2) {
            ALog.m16901d("MessageHandler", "onError, skip ping/ack", new Object[0]);
            return;
        }
        Map map2;
        byte[] bArr2;
        int i2;
        if (message.cunstomDataId != null) {
            this.f13691a.remove(message.cunstomDataId);
        }
        if (this.f13695e.checkAntiBrush(message.host, map)) {
            i = ErrorCode.SERVIER_ANTI_BRUSH;
            bArr = null;
            map2 = null;
            reqType = null;
        }
        int a = this.f13694d.m16767a(map2, message.serviceId);
        if (a != 0) {
            a = a == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : a == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
            bArr2 = null;
            map2 = null;
            reqType = null;
            i2 = a;
        } else {
            bArr2 = bArr;
            i2 = i;
        }
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MessageHandler", "onResult command:" + message.command + " erorcode:" + i2, new Object[0]);
        }
        if (message.command.intValue() == Constants.COMMAND_SEND_STATIST) {
            return;
        }
        if (message.command.intValue() == Constants.COMMAND_ELECTION) {
            AccsAbstractDataListener listener = GlobalClientInfo.getInstance(this.f13698i).getListener(C4103b.ELECTION_SERVICE_ID);
            if (listener != null) {
                listener.onResponse(C4103b.ELECTION_SERVICE_ID, message.cunstomDataId, i2, bArr2, null);
                return;
            } else {
                ALog.m16903e("MessageHandler", "onResult election listener null", new Object[0]);
                return;
            }
        }
        if (message.isCancel) {
            ALog.m16903e("MessageHandler", this.f13692b + " message is cancel! command:" + message.command, new Object[0]);
        } else if (!m16741b(i2) || message.command.intValue() == 100 || message.retryTimes > Message.CONTROL_MAX_RETRY_TIMES) {
            ALog.m16901d("MessageHandler", "prepare send broadcast", new Object[0]);
            Intent c = m16742c(message);
            c.putExtra(Constants.KEY_ERROR_CODE, i2);
            ReqType valueOf = ReqType.valueOf((message.f13664f >> 13) & 3);
            if (reqType == ReqType.RES || valueOf == ReqType.REQ) {
                c.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
            }
            if (i2 == Constants.COMMAND_HANDSHAKE) {
                c.putExtra(Constants.KEY_DATA, bArr2);
            }
            m16739a(map2, c);
            C4095e.m16711a(this.f13698i, c);
            if (!TextUtils.isEmpty(message.serviceId)) {
                UTMini.getInstance().commitEvent(UT.EVENT_ID, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i2 + " dataId=" + message.dataId, Integer.valueOf(Constants.SDK_VERSION_CODE));
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_TO_BUSS, "1commandId=" + message.command + "serviceId=" + message.serviceId, 0.0d);
            }
        } else {
            message.startSendTime = System.currentTimeMillis();
            message.retryTimes++;
            C4112a.m16803a(this.f13698i, 0).m16816b(message, true);
        }
        NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
        if (netPermanceMonitor != null) {
            netPermanceMonitor.onToBizDate();
            String url = message.host == null ? null : message.host.toString();
            if (i2 == Constants.COMMAND_HANDSHAKE) {
                netPermanceMonitor.setRet(true);
                if (message.retryTimes > 0) {
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    C4136b.m16915a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQUEST, url);
                }
            } else {
                if (message.retryTimes > 0) {
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "fail\uff3f" + i2, 0.0d);
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, ITagManager.FAIL, 0.0d);
                } else if (i2 != -13) {
                    C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQUEST, url, UtilityImpl.int2String(i2), this.f13692b + message.serviceId + message.timeout);
                }
                netPermanceMonitor.setRet(false);
                netPermanceMonitor.setFailReason(i2);
            }
            AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
        }
        m16740b(message, i2);
    }

    public void m16752a(Message message, int i, Map<ExtHeaderType, String> map) {
        m16751a(message, i, null, null, (Map) map);
    }

    public void m16753a(C4129a c4129a) {
        try {
            C4089a.m16688a().execute(new C4098c(this, c4129a));
        } catch (Throwable th) {
            ALog.m16902e("MessageHandler", "addTrafficsInfo", th, new Object[0]);
        }
    }

    public void m16754a(byte[] bArr) {
        m16755a(bArr, null);
    }

    public void m16755a(byte[] bArr, String str) {
        int i = 0;
        C4142g c4142g = new C4142g(bArr);
        try {
            int a = c4142g.m16931a();
            int i2 = (a & 240) >> 4;
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MessageHandler", "version:" + i2, new Object[0]);
            }
            a &= 15;
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MessageHandler", "compress:" + a, new Object[0]);
            }
            c4142g.m16931a();
            int b = c4142g.m16933b();
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("MessageHandler", "totalLen:" + b, new Object[0]);
            }
            while (i < b) {
                int b2 = c4142g.m16933b();
                i += 2;
                if (b2 > 0) {
                    byte[] bArr2 = new byte[b2];
                    c4142g.read(bArr2);
                    if (ALog.isPrintLog(Level.D)) {
                        ALog.m16901d("MessageHandler", "buf len:" + bArr2.length, new Object[0]);
                    }
                    i += bArr2.length;
                    m16735a(a, bArr2, str, i2);
                } else {
                    throw new IOException("data format error");
                }
            }
        } catch (Throwable th) {
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_REQ_ERROR, BuildConfig.FLAVOR, MessageService.MSG_DB_NOTIFY_REACHED, this.f13692b + th.toString());
            ALog.m16902e("MessageHandler", BuildConfig.FLAVOR, th, new Object[0]);
        } finally {
            c4142g.close();
        }
    }

    public Message m16756b(String str) {
        return !TextUtils.isEmpty(str) ? (Message) this.f13696g.remove(str) : null;
    }

    public void m16757b() {
        ALog.m16901d("MessageHandler", "onSendPing", new Object[0]);
        synchronized (C4097b.class) {
            this.f13697h = true;
        }
    }

    public void m16758b(Message message) {
        if (this.f13696g.keySet() != null && this.f13696g.keySet().size() > 0) {
            for (String str : this.f13696g.keySet()) {
                Message message2 = (Message) this.f13696g.get(str);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        case SpdyProtocol.QUIC /*4*/:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.m16903e("MessageHandler", "cancelControlMessage", IntentUtil.AGOO_COMMAND, message2.command);
                }
            }
        }
    }

    public void m16759c() {
        ALog.m16901d("MessageHandler", "onRcvPing", new Object[0]);
        synchronized (C4097b.class) {
            this.f13697h = false;
        }
    }

    public boolean m16760d() {
        return this.f13697h;
    }

    public int m16761e() {
        return this.f13696g.size();
    }

    public Collection<Message> m16762f() {
        return this.f13696g.values();
    }

    public C4133d m16763g() {
        return this.f13699j;
    }

    public void m16764h() {
        try {
            C4089a.m16688a().execute(this.f13702m);
        } catch (Throwable th) {
            ALog.m16902e("MessageHandler", "restoreTraffics", th, new Object[0]);
        }
    }
}
