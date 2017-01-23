package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AccsFrameCb;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.session.AccsSession;
import com.facebook.ads.AdError;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.statistics.C4132c;
import com.taobao.accs.ut.statistics.C4133d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.taobao.accs.net.i */
public class C4120i extends C4112a implements AccsFrameCb {
    private boolean f13784f;
    private ScheduledFuture<?> f13785g;
    private Runnable f13786h;

    protected C4120i(Context context, int i) {
        super(context, i);
        this.f13784f = true;
        this.f13785g = null;
        this.f13786h = new C4122k(this);
        if (!C4144h.m16941a(true)) {
            Object tnetLogFilePath = UtilityImpl.getTnetLogFilePath(this.b, "inapp");
            ALog.m16901d("InAppConnection", "config tnet log path:" + tnetLogFilePath, new Object[0]);
            if (!TextUtils.isEmpty(tnetLogFilePath)) {
                Session.configTnetALog(context, tnetLogFilePath, UtilityImpl.TNET_FILE_SIZE, 5);
            }
        }
        this.f13785g = C4089a.m16688a().schedule(this.f13786h, 120000, TimeUnit.MILLISECONDS);
    }

    public synchronized void m16837a() {
        this.f13784f = true;
        m16838a(this.b);
        ALog.m16901d("InAppConnection", this.a + " start", new Object[0]);
    }

    protected void m16838a(Context context) {
        super.m16808a(context);
        SessionCenter.getInstance().setDataReceiveCb(this);
    }

    protected void m16839a(Message message, boolean z) {
        if (!this.f13784f || message == null) {
            ALog.m16903e("InAppConnection", "not running or msg null! " + this.f13784f, new Object[0]);
            return;
        }
        try {
            if (C4089a.m16690b().getQueue().size() > AdError.NETWORK_ERROR_CODE) {
                throw new RejectedExecutionException(AgooConstants.MESSAGE_SOURCE_ACCS);
            }
            ScheduledFuture schedule = C4089a.m16690b().schedule(new C4121j(this, message), message.delyTime, TimeUnit.MILLISECONDS);
            if (message.getType() == 1 && message.cunstomDataId != null) {
                if (message.isControlFrame() && m16842a(message.cunstomDataId)) {
                    this.c.m16758b(message);
                }
                this.c.f13691a.put(message.cunstomDataId, schedule);
            }
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor != null) {
                netPermanceMonitor.setDeviceId(UtilityImpl.getDeviceId(this.b));
                netPermanceMonitor.setConnType(this.a);
                netPermanceMonitor.onEnterQueueData();
            }
        } catch (RejectedExecutionException e) {
            this.c.m16750a(message, (int) ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.m16903e("InAppConnection", "send queue full count:" + C4089a.m16690b().getQueue().size(), new Object[0]);
        } catch (Throwable th) {
            this.c.m16750a(message, -8);
            ALog.m16902e("InAppConnection", "send error", th, new Object[0]);
        }
    }

    protected void m16840a(String str, String str2) {
        try {
            Message a = this.c.m16747a(str);
            if (a != null && a.host != null) {
                Session session = SessionCenter.getInstance().get(a.host.toString(), 0);
                if (session != null) {
                    session.checkAvailable();
                }
            }
        } catch (Throwable e) {
            ALog.m16902e("InAppConnection", "onTimeOut", e, new Object[0]);
        }
    }

    public void m16841a(boolean z, boolean z2) {
    }

    public boolean m16842a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.c.f13691a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (!cancel) {
            return cancel;
        }
        ALog.m16903e(m16846e(), "cancel", "customDataId", str);
        return cancel;
    }

    public boolean m16843b() {
        return this.f13784f;
    }

    public void m16844c() {
        this.d = 0;
    }

    public C4132c m16845d() {
        return null;
    }

    protected String m16846e() {
        return "InAppConnection";
    }

    public void m16847f() {
        ALog.m16903e("InAppConnection", this.a + "shut down", new Object[0]);
        this.f13784f = false;
    }

    public void onDataReceive(AccsSession accsSession, byte[] bArr, int i, int i2) {
        if (ALog.isPrintLog(Level.I)) {
            ALog.m16904i("InAppConnection", "onDataReceive, type:" + i2 + " len:" + bArr.length, new Object[0]);
        }
        if (i2 == Constants.COMMAND_HANDSHAKE) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.c.m16755a(bArr, accsSession.getHost());
                C4133d g = this.c.m16763g();
                if (g != null) {
                    g.f13872c = String.valueOf(currentTimeMillis);
                    g.f13876g = this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp";
                    g.commitUT();
                }
            } catch (Throwable th) {
                ALog.m16902e("InAppConnection", "onDataReceive ", th, new Object[0]);
                th.printStackTrace();
                UTMini.getInstance().commitEvent(UT.EVENT_ID, "DATA_RECEIVE", UtilityImpl.getStackMsg(th));
            }
            ALog.m16901d("InAppConnection", "try handle msg", new Object[0]);
            return;
        }
        ALog.m16903e("InAppConnection", "drop frame len:" + bArr.length + " frameType" + i2, new Object[0]);
    }

    public void onException(int i, int i2, boolean z, String str) {
        ALog.m16903e("InAppConnection", "errorId:" + i2 + "detail:" + str + " dataId:" + i + " needRetry:" + z, new Object[0]);
        if (i > 0) {
            Message b = this.c.m16756b(UtilityImpl.int2String(i));
            if (b != null) {
                if (z) {
                    if (!m16813a(b, (int) AdError.SERVER_ERROR_CODE)) {
                        this.c.m16750a(b, i2);
                    }
                    if (b.getNetPermanceMonitor() != null) {
                        C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.c.m16750a(b, i2);
                }
            }
        }
        if (i < 0 && z) {
            m16815b(i);
        }
    }
}
