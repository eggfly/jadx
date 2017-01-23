package com.taobao.accs.net;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import com.facebook.ads.AdError;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.Message.C4094b;
import com.taobao.accs.ut.monitor.TrafficsMonitor.C4129a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.intent.IntentUtil;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.taobao.accs.net.j */
class C4121j implements Runnable {
    final /* synthetic */ Message f13787a;
    final /* synthetic */ C4120i f13788b;

    C4121j(C4120i c4120i, Message message) {
        this.f13788b = c4120i;
        this.f13787a = message;
    }

    public void run() {
        if (this.f13787a != null) {
            if (this.f13787a.getNetPermanceMonitor() != null) {
                this.f13787a.getNetPermanceMonitor().onTakeFromQueue();
            }
            int type = this.f13787a.getType();
            try {
                boolean z;
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("InAppConnection", "send:" + C4094b.m16700b(type) + " dataId:" + this.f13787a.dataId, new Object[0]);
                }
                if (type != 1) {
                    ALog.m16903e("InAppConnection", "skip msg type" + C4094b.m16700b(type), new Object[0]);
                    z = true;
                } else if (this.f13787a.host == null) {
                    this.f13788b.c.m16750a(this.f13787a, -5);
                    z = true;
                } else {
                    Session session = SessionCenter.getInstance().get(this.f13787a.host.toString(), 60000);
                    SessionCenter.getInstance().setDataReceiveCb(this.f13788b);
                    if (session != null) {
                        byte[] build = this.f13787a.build(this.f13788b.b, this.f13788b.a);
                        if (ALog.isPrintLog(Level.I)) {
                            String str = "InAppConnection";
                            String str2 = "send data ";
                            Object[] objArr = new Object[8];
                            objArr[0] = "len";
                            objArr[1] = Integer.valueOf(build == null ? 0 : build.length);
                            objArr[2] = Constants.KEY_DATA_ID;
                            objArr[3] = this.f13787a.getDataId();
                            objArr[4] = IntentUtil.AGOO_COMMAND;
                            objArr[5] = this.f13787a.command;
                            objArr[6] = " host";
                            objArr[7] = this.f13787a.host;
                            ALog.m16904i(str, str2, objArr);
                        }
                        this.f13787a.setSendTime(System.currentTimeMillis());
                        if (build.length <= SpdyProtocol.SLIGHTSSL_L7E || this.f13787a.command.intValue() == Constants.COMMAND_SEND_STATIST) {
                            this.f13788b.c.m16749a(this.f13787a);
                            if (this.f13787a.isAck) {
                                this.f13788b.e.put(Integer.valueOf(this.f13787a.getIntDataId()), this.f13787a);
                            }
                            session.sendCustomFrame(this.f13787a.getIntDataId(), build, Constants.COMMAND_HANDSHAKE);
                            if (this.f13787a.getNetPermanceMonitor() != null) {
                                this.f13787a.getNetPermanceMonitor().onSendData();
                            }
                            this.f13788b.m16810a(this.f13787a.getDataId(), (long) this.f13787a.timeout);
                            this.f13788b.c.m16753a(new C4129a(this.f13787a.serviceId, GlobalAppRuntimeInfo.isAppBackground(), this.f13787a.host.toString(), (long) build.length));
                        } else {
                            this.f13788b.c.m16750a(this.f13787a, -4);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    if (type == 1) {
                        if (this.f13787a.isTimeOut() || !this.f13788b.m16813a(this.f13787a, (int) AdError.SERVER_ERROR_CODE)) {
                            this.f13788b.c.m16750a(this.f13787a, -11);
                        }
                        if (this.f13787a.retryTimes == 1 && this.f13787a.getNetPermanceMonitor() != null) {
                            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                        }
                    } else {
                        this.f13788b.c.m16750a(this.f13787a, -11);
                    }
                }
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("InAppConnection", "sendSucc" + z + " dataId:" + this.f13787a.getDataId(), new Object[0]);
                }
            } catch (Throwable th) {
                if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d("InAppConnection", "sendSucc" + true + " dataId:" + this.f13787a.getDataId(), new Object[0]);
                }
            }
        }
    }
}
