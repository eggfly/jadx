package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.facebook.ads.AdError;
import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.SECURITY_TYPE;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.statistics.C4132c;
import com.taobao.accs.ut.statistics.C4133d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.C4140e;
import com.taobao.accs.utl.C4144h;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* renamed from: com.taobao.accs.net.l */
public class C4124l extends C4112a implements SessionCb, Spdycb {
    private SessionMonitor f13793A;
    private C4132c f13794B;
    private boolean f13795C;
    private String f13796D;
    private boolean f13797E;
    private C4117f f13798F;
    private String f13799G;
    protected ScheduledFuture<?> f13800f;
    protected String f13801g;
    protected int f13802h;
    protected String f13803i;
    protected int f13804j;
    private int f13805k;
    private LinkedList<Message> f13806l;
    private C4123a f13807m;
    private boolean f13808n;
    private String f13809o;
    private String f13810p;
    private String f13811q;
    private SpdyAgent f13812r;
    private SpdySession f13813s;
    private Object f13814t;
    private long f13815u;
    private long f13816v;
    private long f13817w;
    private long f13818x;
    private int f13819y;
    private String f13820z;

    /* renamed from: com.taobao.accs.net.l.a */
    private class C4123a extends Thread {
        public int f13790a;
        long f13791b;
        final /* synthetic */ C4124l f13792c;

        private C4123a(C4124l c4124l) {
            this.f13792c = c4124l;
            this.f13790a = 0;
        }

        private void m16848a(boolean z) {
            if (this.f13792c.f13805k != 1) {
                if (UtilityImpl.isNetworkConnected(this.f13792c.b)) {
                    if (z) {
                        this.f13790a = 0;
                    }
                    ALog.m16903e("NetworkThread", this.f13792c.a + " try connect, force = " + z + " failTimes = " + this.f13790a, new Object[0]);
                    if (this.f13792c.f13805k != 1 && this.f13790a >= 4) {
                        this.f13792c.f13795C = true;
                        ALog.m16903e("NetworkThread", this.f13792c.a + " try connect fail " + 4 + " times", new Object[0]);
                        return;
                    } else if (this.f13792c.f13805k != 1) {
                        if (this.f13792c.a == 1 && this.f13790a == 0) {
                            ALog.m16904i("NetworkThread", this.f13792c.a + " try connect in app, no sleep", new Object[0]);
                        } else {
                            ALog.m16904i("NetworkThread", this.f13792c.a + " try connect, need sleep", new Object[0]);
                            try {
                                C4123a.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        this.f13792c.f13796D = BuildConfig.FLAVOR;
                        if (this.f13790a == 3) {
                            this.f13792c.f13798F.m16835b(this.f13792c.m16876m());
                        }
                        String[] strArr = AccsConfig.ACCS_CHANNEL_IPS[UtilityImpl.getMode(this.f13792c.b)];
                        if (strArr == null || strArr.length <= 0 || this.f13790a != 3) {
                            this.f13792c.m16861b(null);
                        } else {
                            this.f13792c.m16861b(strArr[0]);
                        }
                        this.f13792c.f13793A.setRetryTimes(this.f13790a);
                        if (this.f13792c.f13805k != 1) {
                            this.f13790a++;
                            ALog.m16903e("NetworkThread", this.f13792c.a + " try connect fail, ready for reconnect", new Object[0]);
                            m16848a(false);
                            return;
                        }
                        this.f13791b = System.currentTimeMillis();
                        return;
                    } else {
                        return;
                    }
                }
                ALog.m16903e("NetworkThread", this.f13792c.a + " Network not available", new Object[0]);
            } else if (this.f13792c.f13805k == 1 && System.currentTimeMillis() - this.f13791b > 5000) {
                this.f13790a = 0;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r13 = this;
            r12 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
            r11 = 100;
            r7 = 1;
            r8 = 0;
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = r13.f13792c;
            r2 = r2.a;
            r1 = r1.append(r2);
            r2 = " NetworkThread run";
            r1 = r1.append(r2);
            r1 = r1.toString();
            r2 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16904i(r0, r1, r2);
            r0 = 0;
            r13.f13790a = r8;
        L_0x0027:
            r1 = r13.f13792c;
            r1 = r1.f13808n;
            if (r1 == 0) goto L_0x0097;
        L_0x002f:
            r1 = "NetworkThread";
            r2 = "ready to get message";
            r3 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16901d(r1, r2, r3);
            r1 = r13.f13792c;
            r1 = r1.f13806l;
            monitor-enter(r1);
            r2 = r13.f13792c;	 Catch:{ all -> 0x00a3 }
            r2 = r2.f13806l;	 Catch:{ all -> 0x00a3 }
            r2 = r2.size();	 Catch:{ all -> 0x00a3 }
            if (r2 != 0) goto L_0x005e;
        L_0x004b:
            r2 = "NetworkThread";
            r3 = "no message, wait";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ InterruptedException -> 0x009d }
            com.taobao.accs.utl.ALog.m16901d(r2, r3, r4);	 Catch:{ InterruptedException -> 0x009d }
            r2 = r13.f13792c;	 Catch:{ InterruptedException -> 0x009d }
            r2 = r2.f13806l;	 Catch:{ InterruptedException -> 0x009d }
            r2.wait();	 Catch:{ InterruptedException -> 0x009d }
        L_0x005e:
            r2 = "NetworkThread";
            r3 = "try get message";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00a3 }
            com.taobao.accs.utl.ALog.m16901d(r2, r3, r4);	 Catch:{ all -> 0x00a3 }
            r2 = r13.f13792c;	 Catch:{ all -> 0x00a3 }
            r2 = r2.f13806l;	 Catch:{ all -> 0x00a3 }
            r2 = r2.size();	 Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x008d;
        L_0x0074:
            r0 = r13.f13792c;	 Catch:{ all -> 0x00a3 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x00a3 }
            r0 = r0.getFirst();	 Catch:{ all -> 0x00a3 }
            r0 = (com.taobao.accs.data.Message) r0;	 Catch:{ all -> 0x00a3 }
            r2 = r0.getNetPermanceMonitor();	 Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x008d;
        L_0x0086:
            r2 = r0.getNetPermanceMonitor();	 Catch:{ all -> 0x00a3 }
            r2.onTakeFromQueue();	 Catch:{ all -> 0x00a3 }
        L_0x008d:
            r6 = r0;
            monitor-exit(r1);	 Catch:{ all -> 0x00a3 }
            r0 = r13.f13792c;
            r0 = r0.f13808n;
            if (r0 != 0) goto L_0x00a6;
        L_0x0097:
            r0 = r13.f13792c;
            r0.m16889i();
            return;
        L_0x009d:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
            monitor-exit(r1);	 Catch:{ all -> 0x00a3 }
            goto L_0x0097;
        L_0x00a3:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
        L_0x00a6:
            if (r6 == 0) goto L_0x05c9;
        L_0x00a8:
            r0 = "NetworkThread";
            r1 = "send message not null";
            r2 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);
            r0 = r6.getType();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = "NetworkThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r3.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = " send:";
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = com.taobao.accs.data.Message.C4094b.m16700b(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = " status:";
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r3.f13805k;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16904i(r1, r2, r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = 2;
            if (r0 != r1) goto L_0x027b;
        L_0x00ef:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 != r7) goto L_0x012d;
        L_0x00f5:
            r0 = "NetworkThread";
            r1 = "INAPP ping, skip";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = "NetworkThread";
            r1 = "send succ, remove it";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0120 }
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);	 Catch:{ Throwable -> 0x0120 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0120 }
            r1 = r0.f13806l;	 Catch:{ Throwable -> 0x0120 }
            monitor-enter(r1);	 Catch:{ Throwable -> 0x0120 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x011d }
            r0 = r0.f13806l;	 Catch:{ all -> 0x011d }
            r0.remove(r6);	 Catch:{ all -> 0x011d }
            monitor-exit(r1);	 Catch:{ all -> 0x011d }
            r0 = r6;
            goto L_0x0027;
        L_0x011d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ Throwable -> 0x0120 }
            throw r0;	 Catch:{ Throwable -> 0x0120 }
        L_0x0120:
            r0 = move-exception;
            r1 = "NetworkThread";
            r2 = " run finally error";
            r3 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16902e(r1, r2, r0, r3);
            r0 = r6;
            goto L_0x0027;
        L_0x012d:
            r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.f13815u;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0 - r2;
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.b;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = com.taobao.accs.net.C4116e.m16824a(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.m16826b();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2 + -1;
            r2 = r2 * 1000;
            r2 = (long) r2;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x0151;
        L_0x014d:
            r0 = r6.force;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 == 0) goto L_0x0275;
        L_0x0151:
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = "ms:";
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r4 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r4 = r4.f13815u;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2 - r4;
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = " force:";
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r6.force;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = 1;
            r13.m16848a(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13813s;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 == 0) goto L_0x0273;
        L_0x018f:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13805k;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 != r7) goto L_0x0273;
        L_0x0197:
            r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.f13815u;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0 - r2;
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.b;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = com.taobao.accs.net.C4116e.m16824a(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.m16826b();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2 + -1;
            r2 = r2 * 1000;
            r2 = (long) r2;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x044d;
        L_0x01b7:
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = " onSendPing";
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16904i(r0, r1, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.m16757b();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13813s;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.submitPing();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.onSendPing();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.f13815u = r2;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = java.lang.System.nanoTime();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.f13816v = r2;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.m16822g();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r7;
        L_0x0207:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x05c6 }
            r0.m16875l();	 Catch:{ Throwable -> 0x05c6 }
            if (r1 != 0) goto L_0x048a;
        L_0x020e:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x047f }
            r0.m16889i();	 Catch:{ Throwable -> 0x047f }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x047f }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x047f }
            if (r0 == 0) goto L_0x0226;
        L_0x021b:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x047f }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x047f }
            r1 = "send fail";
            r0.setCloseReason(r1);	 Catch:{ Throwable -> 0x047f }
        L_0x0226:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x047f }
            r2 = r0.f13806l;	 Catch:{ Throwable -> 0x047f }
            monitor-enter(r2);	 Catch:{ Throwable -> 0x047f }
            r0 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r0 = r0.f13806l;	 Catch:{ all -> 0x047c }
            r0 = r0.size();	 Catch:{ all -> 0x047c }
            r0 = r0 + -1;
            r1 = r0;
        L_0x023a:
            if (r1 < 0) goto L_0x0450;
        L_0x023c:
            r0 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r0 = r0.f13806l;	 Catch:{ all -> 0x047c }
            r0 = r0.get(r1);	 Catch:{ all -> 0x047c }
            r0 = (com.taobao.accs.data.Message) r0;	 Catch:{ all -> 0x047c }
            if (r0 == 0) goto L_0x026f;
        L_0x024a:
            r3 = r0.command;	 Catch:{ all -> 0x047c }
            if (r3 == 0) goto L_0x026f;
        L_0x024e:
            r3 = r0.command;	 Catch:{ all -> 0x047c }
            r3 = r3.intValue();	 Catch:{ all -> 0x047c }
            if (r3 == r11) goto L_0x025e;
        L_0x0256:
            r3 = r0.command;	 Catch:{ all -> 0x047c }
            r3 = r3.intValue();	 Catch:{ all -> 0x047c }
            if (r3 != r12) goto L_0x026f;
        L_0x025e:
            r3 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r3 = r3.c;	 Catch:{ all -> 0x047c }
            r4 = -1;
            r3.m16750a(r0, r4);	 Catch:{ all -> 0x047c }
            r0 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r0 = r0.f13806l;	 Catch:{ all -> 0x047c }
            r0.remove(r1);	 Catch:{ all -> 0x047c }
        L_0x026f:
            r0 = r1 + -1;
            r1 = r0;
            goto L_0x023a;
        L_0x0273:
            r1 = r8;
            goto L_0x0207;
        L_0x0275:
            r0 = 0;
            r13.m16848a(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r7;
            goto L_0x0207;
        L_0x027b:
            if (r0 != r7) goto L_0x0426;
        L_0x027d:
            r0 = 1;
            r13.m16848a(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13805k;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 != r7) goto L_0x0423;
        L_0x0289:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13813s;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 == 0) goto L_0x0423;
        L_0x0291:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.b;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r5 = r6.build(r0, r1);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r6.setSendTime(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r5.length;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            if (r0 <= r1) goto L_0x02be;
        L_0x02a9:
            r0 = r6.command;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.intValue();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
            if (r0 == r1) goto L_0x02be;
        L_0x02b3:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = -4;
            r0.m16750a(r6, r1);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
        L_0x02bb:
            r1 = r7;
            goto L_0x0207;
        L_0x02be:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.f13813s;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r6.getIntDataId();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            r3 = 0;
            if (r5 != 0) goto L_0x041d;
        L_0x02cd:
            r4 = r8;
        L_0x02ce:
            r0.sendCustomControlFrame(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = "NetworkThread";
            r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = " send data len:";
            r2 = r0.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r5 != 0) goto L_0x0420;
        L_0x02e8:
            r0 = r8;
        L_0x02e9:
            r0 = r2.append(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = " dataId:";
            r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r6.getDataId();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16903e(r1, r0, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.m16749a(r6);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r6.isAck;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 == 0) goto L_0x034e;
        L_0x0310:
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = " sendCFrame end ack";
            r1 = r1.append(r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r1.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 2;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = 0;
            r4 = "dataId";
            r2[r3] = r4;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = 1;
            r4 = r6.getIntDataId();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2[r3] = r4;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16903e(r0, r1, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.e;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r6.getIntDataId();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.put(r1, r6);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
        L_0x034e:
            r0 = r6.getNetPermanceMonitor();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            if (r0 == 0) goto L_0x035b;
        L_0x0354:
            r0 = r6.getNetPermanceMonitor();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.onSendData();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
        L_0x035b:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r6.getDataId();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r6.timeout;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = (long) r2;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.m16810a(r1, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r9 = r0.c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = r6.serviceId;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r3.m16876m();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r4 = r5.length;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r4 = (long) r4;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0.<init>(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r9.m16753a(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            goto L_0x02bb;
        L_0x0383:
            r0 = move-exception;
            r1 = r7;
        L_0x0385:
            r2 = "accs";
            r3 = "send_fail";
            r4 = r6.serviceId;	 Catch:{ all -> 0x05c1 }
            r5 = "1";
            r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x05c1 }
            r9.<init>();	 Catch:{ all -> 0x05c1 }
            r10 = r13.f13792c;	 Catch:{ all -> 0x05c1 }
            r10 = r10.a;	 Catch:{ all -> 0x05c1 }
            r9 = r9.append(r10);	 Catch:{ all -> 0x05c1 }
            r10 = r0.toString();	 Catch:{ all -> 0x05c1 }
            r9 = r9.append(r10);	 Catch:{ all -> 0x05c1 }
            r9 = r9.toString();	 Catch:{ all -> 0x05c1 }
            com.taobao.accs.utl.C4136b.m16917a(r2, r3, r4, r5, r9);	 Catch:{ all -> 0x05c1 }
            r0.printStackTrace();	 Catch:{ all -> 0x05c1 }
            r2 = "NetworkThread";
            r3 = "service connection run";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x05c1 }
            com.taobao.accs.utl.ALog.m16902e(r2, r3, r0, r4);	 Catch:{ all -> 0x05c1 }
            if (r1 != 0) goto L_0x04e1;
        L_0x03b8:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x04d6 }
            r0.m16889i();	 Catch:{ Throwable -> 0x04d6 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x04d6 }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x04d6 }
            if (r0 == 0) goto L_0x03d0;
        L_0x03c5:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x04d6 }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x04d6 }
            r1 = "send fail";
            r0.setCloseReason(r1);	 Catch:{ Throwable -> 0x04d6 }
        L_0x03d0:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x04d6 }
            r2 = r0.f13806l;	 Catch:{ Throwable -> 0x04d6 }
            monitor-enter(r2);	 Catch:{ Throwable -> 0x04d6 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04d3 }
            r0 = r0.size();	 Catch:{ all -> 0x04d3 }
            r0 = r0 + -1;
            r1 = r0;
        L_0x03e4:
            if (r1 < 0) goto L_0x04a9;
        L_0x03e6:
            r0 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04d3 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x04d3 }
            r0 = (com.taobao.accs.data.Message) r0;	 Catch:{ all -> 0x04d3 }
            if (r0 == 0) goto L_0x0419;
        L_0x03f4:
            r3 = r0.command;	 Catch:{ all -> 0x04d3 }
            if (r3 == 0) goto L_0x0419;
        L_0x03f8:
            r3 = r0.command;	 Catch:{ all -> 0x04d3 }
            r3 = r3.intValue();	 Catch:{ all -> 0x04d3 }
            if (r3 == r11) goto L_0x0408;
        L_0x0400:
            r3 = r0.command;	 Catch:{ all -> 0x04d3 }
            r3 = r3.intValue();	 Catch:{ all -> 0x04d3 }
            if (r3 != r12) goto L_0x0419;
        L_0x0408:
            r3 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r3 = r3.c;	 Catch:{ all -> 0x04d3 }
            r4 = -1;
            r3.m16750a(r0, r4);	 Catch:{ all -> 0x04d3 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04d3 }
            r0.remove(r1);	 Catch:{ all -> 0x04d3 }
        L_0x0419:
            r0 = r1 + -1;
            r1 = r0;
            goto L_0x03e4;
        L_0x041d:
            r4 = r5.length;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            goto L_0x02ce;
        L_0x0420:
            r0 = r5.length;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            goto L_0x02e9;
        L_0x0423:
            r1 = r8;
            goto L_0x0207;
        L_0x0426:
            r1 = 0;
            r13.m16848a(r1);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r1 = "NetworkThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2.<init>();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r13.f13792c;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = r3.a;	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r3 = " skip msg ";
            r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r2.append(r0);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r0 = r0.toString();	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
            com.taobao.accs.utl.ALog.m16903e(r1, r0, r2);	 Catch:{ Throwable -> 0x0383, all -> 0x0501 }
        L_0x044d:
            r1 = r7;
            goto L_0x0207;
        L_0x0450:
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x047c }
            r1.<init>();	 Catch:{ all -> 0x047c }
            r3 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r3 = r3.a;	 Catch:{ all -> 0x047c }
            r1 = r1.append(r3);	 Catch:{ all -> 0x047c }
            r3 = " network disconnected, wait";
            r1 = r1.append(r3);	 Catch:{ all -> 0x047c }
            r1 = r1.toString();	 Catch:{ all -> 0x047c }
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x047c }
            com.taobao.accs.utl.ALog.m16903e(r0, r1, r3);	 Catch:{ all -> 0x047c }
            r0 = r13.f13792c;	 Catch:{ all -> 0x047c }
            r0 = r0.f13806l;	 Catch:{ all -> 0x047c }
            r0.wait();	 Catch:{ all -> 0x047c }
            monitor-exit(r2);	 Catch:{ all -> 0x047c }
        L_0x0479:
            r0 = r6;
            goto L_0x0027;
        L_0x047c:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ Throwable -> 0x047f }
            throw r0;	 Catch:{ Throwable -> 0x047f }
        L_0x047f:
            r0 = move-exception;
            r1 = "NetworkThread";
            r2 = " run finally error";
            r3 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16902e(r1, r2, r0, r3);
            goto L_0x0479;
        L_0x048a:
            r0 = "NetworkThread";
            r1 = "send succ, remove it";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x047f }
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);	 Catch:{ Throwable -> 0x047f }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x047f }
            r1 = r0.f13806l;	 Catch:{ Throwable -> 0x047f }
            monitor-enter(r1);	 Catch:{ Throwable -> 0x047f }
            r0 = r13.f13792c;	 Catch:{ all -> 0x04a6 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04a6 }
            r0.remove(r6);	 Catch:{ all -> 0x04a6 }
            monitor-exit(r1);	 Catch:{ all -> 0x04a6 }
            goto L_0x0479;
        L_0x04a6:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ Throwable -> 0x047f }
            throw r0;	 Catch:{ Throwable -> 0x047f }
        L_0x04a9:
            r0 = "NetworkThread";
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x04d3 }
            r1.<init>();	 Catch:{ all -> 0x04d3 }
            r3 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r3 = r3.a;	 Catch:{ all -> 0x04d3 }
            r1 = r1.append(r3);	 Catch:{ all -> 0x04d3 }
            r3 = " network disconnected, wait";
            r1 = r1.append(r3);	 Catch:{ all -> 0x04d3 }
            r1 = r1.toString();	 Catch:{ all -> 0x04d3 }
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x04d3 }
            com.taobao.accs.utl.ALog.m16903e(r0, r1, r3);	 Catch:{ all -> 0x04d3 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x04d3 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04d3 }
            r0.wait();	 Catch:{ all -> 0x04d3 }
            monitor-exit(r2);	 Catch:{ all -> 0x04d3 }
            goto L_0x0479;
        L_0x04d3:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ Throwable -> 0x04d6 }
            throw r0;	 Catch:{ Throwable -> 0x04d6 }
        L_0x04d6:
            r0 = move-exception;
            r1 = "NetworkThread";
            r2 = " run finally error";
            r3 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16902e(r1, r2, r0, r3);
            goto L_0x0479;
        L_0x04e1:
            r0 = "NetworkThread";
            r1 = "send succ, remove it";
            r2 = 0;
            r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x04d6 }
            com.taobao.accs.utl.ALog.m16901d(r0, r1, r2);	 Catch:{ Throwable -> 0x04d6 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x04d6 }
            r1 = r0.f13806l;	 Catch:{ Throwable -> 0x04d6 }
            monitor-enter(r1);	 Catch:{ Throwable -> 0x04d6 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x04fe }
            r0 = r0.f13806l;	 Catch:{ all -> 0x04fe }
            r0.remove(r6);	 Catch:{ all -> 0x04fe }
            monitor-exit(r1);	 Catch:{ all -> 0x04fe }
            goto L_0x0479;
        L_0x04fe:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ Throwable -> 0x04d6 }
            throw r0;	 Catch:{ Throwable -> 0x04d6 }
        L_0x0501:
            r0 = move-exception;
            r1 = r0;
        L_0x0503:
            if (r7 != 0) goto L_0x05a2;
        L_0x0505:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0597 }
            r0.m16889i();	 Catch:{ Throwable -> 0x0597 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0597 }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x0597 }
            if (r0 == 0) goto L_0x051d;
        L_0x0512:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0597 }
            r0 = r0.f13793A;	 Catch:{ Throwable -> 0x0597 }
            r2 = "send fail";
            r0.setCloseReason(r2);	 Catch:{ Throwable -> 0x0597 }
        L_0x051d:
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0597 }
            r3 = r0.f13806l;	 Catch:{ Throwable -> 0x0597 }
            monitor-enter(r3);	 Catch:{ Throwable -> 0x0597 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x0594 }
            r0 = r0.size();	 Catch:{ all -> 0x0594 }
            r0 = r0 + -1;
            r2 = r0;
        L_0x0531:
            if (r2 < 0) goto L_0x056a;
        L_0x0533:
            r0 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x0594 }
            r0 = r0.get(r2);	 Catch:{ all -> 0x0594 }
            r0 = (com.taobao.accs.data.Message) r0;	 Catch:{ all -> 0x0594 }
            if (r0 == 0) goto L_0x0566;
        L_0x0541:
            r4 = r0.command;	 Catch:{ all -> 0x0594 }
            if (r4 == 0) goto L_0x0566;
        L_0x0545:
            r4 = r0.command;	 Catch:{ all -> 0x0594 }
            r4 = r4.intValue();	 Catch:{ all -> 0x0594 }
            if (r4 == r11) goto L_0x0555;
        L_0x054d:
            r4 = r0.command;	 Catch:{ all -> 0x0594 }
            r4 = r4.intValue();	 Catch:{ all -> 0x0594 }
            if (r4 != r12) goto L_0x0566;
        L_0x0555:
            r4 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r4 = r4.c;	 Catch:{ all -> 0x0594 }
            r5 = -1;
            r4.m16750a(r0, r5);	 Catch:{ all -> 0x0594 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x0594 }
            r0.remove(r2);	 Catch:{ all -> 0x0594 }
        L_0x0566:
            r0 = r2 + -1;
            r2 = r0;
            goto L_0x0531;
        L_0x056a:
            r0 = "NetworkThread";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0594 }
            r2.<init>();	 Catch:{ all -> 0x0594 }
            r4 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r4 = r4.a;	 Catch:{ all -> 0x0594 }
            r2 = r2.append(r4);	 Catch:{ all -> 0x0594 }
            r4 = " network disconnected, wait";
            r2 = r2.append(r4);	 Catch:{ all -> 0x0594 }
            r2 = r2.toString();	 Catch:{ all -> 0x0594 }
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0594 }
            com.taobao.accs.utl.ALog.m16903e(r0, r2, r4);	 Catch:{ all -> 0x0594 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x0594 }
            r0 = r0.f13806l;	 Catch:{ all -> 0x0594 }
            r0.wait();	 Catch:{ all -> 0x0594 }
            monitor-exit(r3);	 Catch:{ all -> 0x0594 }
        L_0x0593:
            throw r1;
        L_0x0594:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ Throwable -> 0x0597 }
            throw r0;	 Catch:{ Throwable -> 0x0597 }
        L_0x0597:
            r0 = move-exception;
            r2 = "NetworkThread";
            r3 = " run finally error";
            r4 = new java.lang.Object[r8];
            com.taobao.accs.utl.ALog.m16902e(r2, r3, r0, r4);
            goto L_0x0593;
        L_0x05a2:
            r0 = "NetworkThread";
            r2 = "send succ, remove it";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0597 }
            com.taobao.accs.utl.ALog.m16901d(r0, r2, r3);	 Catch:{ Throwable -> 0x0597 }
            r0 = r13.f13792c;	 Catch:{ Throwable -> 0x0597 }
            r2 = r0.f13806l;	 Catch:{ Throwable -> 0x0597 }
            monitor-enter(r2);	 Catch:{ Throwable -> 0x0597 }
            r0 = r13.f13792c;	 Catch:{ all -> 0x05be }
            r0 = r0.f13806l;	 Catch:{ all -> 0x05be }
            r0.remove(r6);	 Catch:{ all -> 0x05be }
            monitor-exit(r2);	 Catch:{ all -> 0x05be }
            goto L_0x0593;
        L_0x05be:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ Throwable -> 0x0597 }
            throw r0;	 Catch:{ Throwable -> 0x0597 }
        L_0x05c1:
            r0 = move-exception;
            r7 = r1;
            r1 = r0;
            goto L_0x0503;
        L_0x05c6:
            r0 = move-exception;
            goto L_0x0385;
        L_0x05c9:
            r0 = r6;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.l.a.run():void");
        }
    }

    protected C4124l(Context context, int i) {
        super(context, i);
        this.f13805k = 3;
        this.f13806l = new LinkedList();
        this.f13808n = true;
        this.f13811q = null;
        this.f13812r = null;
        this.f13813s = null;
        this.f13814t = new Object();
        this.f13819y = -1;
        this.f13820z = null;
        this.f13795C = false;
        this.f13796D = BuildConfig.FLAVOR;
        this.f13797E = false;
        if (AccsConfig.mSecurityType == SECURITY_TYPE.SECURITY_TAOBAO) {
            this.f13798F = new C4117f(m16876m());
        }
        m16877n();
    }

    private final String m16851a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append((String) list.get(i));
            if (i < size - 1) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return stringBuffer.toString();
    }

    private final Map<String, String> m16853a(Map<String, List<String>> map) {
        Map<String, String> hashMap = new HashMap();
        try {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (!TextUtils.isEmpty(str)) {
                    Object a = m16851a((List) entry.getValue());
                    if (!TextUtils.isEmpty(a)) {
                        if (!str.startsWith(":")) {
                            str = str.toLowerCase(Locale.US);
                        }
                        hashMap.put(str, a);
                        ALog.m16904i("SpdyConnection", "\theader:" + str + " value:" + a, new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
        }
        return hashMap;
    }

    private void m16854a(Message message) {
        if (message.command != null && this.f13806l.size() != 0) {
            for (int size = this.f13806l.size() - 1; size >= 0; size--) {
                Message message2 = (Message) this.f13806l.get(size);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                this.f13806l.remove(size);
                                break;
                            }
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        case SpdyProtocol.QUIC /*4*/:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                this.f13806l.remove(size);
                                break;
                            }
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                this.f13806l.remove(size);
                                break;
                            }
                    }
                    ALog.m16901d("SpdyConnection", "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
                }
            }
            if (this.c != null) {
                this.c.m16758b(message);
            }
        }
    }

    private boolean m16857a(String str, String str2, String str3) {
        if (UtilityImpl.isDebugMode(this.b)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        m16864c(3);
        int i = TextUtils.isEmpty(str) ? 1 : TextUtils.isEmpty(str2) ? 2 : TextUtils.isEmpty(str3) ? 3 : 1;
        this.f13793A.setFailReason(i);
        this.f13793A.onConnectStop();
        String str4 = this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp";
        int i2 = this.f13807m != null ? this.f13807m.f13790a : 0;
        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "DISCONNECT " + str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), this.f13810p, this.f13796D);
        C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i2, i + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        return false;
    }

    private void m16861b(String str) {
        int i = com.taobao.accs.common.Constants.PORT;
        if (this.f13805k != 2 && this.f13805k != 1) {
            if (UtilityImpl.isReleaseMode(this.b) || UtilityImpl.isPreviewMode(this.b)) {
                if (this.f13798F == null) {
                    this.f13798F = new C4117f(m16876m());
                }
                List<IConnStrategy> a = this.f13798F.m16833a(m16876m());
                if (a == null || a.size() <= 0) {
                    if (str != null) {
                        this.f13801g = str;
                    } else {
                        this.f13801g = m16876m();
                    }
                    if (System.currentTimeMillis() % 2 == 0) {
                        i = 80;
                    }
                    this.f13802h = i;
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
                    ALog.m16904i("SpdyConnection", this.a + " get ip from amdc fail!!", new Object[0]);
                } else {
                    for (IConnStrategy iConnStrategy : a) {
                        if (iConnStrategy != null) {
                            ALog.m16903e("SpdyConnection", this.a + " connect strategys ip:" + iConnStrategy.getIp() + " port:" + iConnStrategy.getPort(), new Object[0]);
                        }
                    }
                    if (this.f13797E) {
                        this.f13798F.m16834b();
                        this.f13797E = false;
                    }
                    IConnStrategy a2 = this.f13798F.m16831a();
                    this.f13801g = a2 == null ? m16876m() : a2.getIp();
                    this.f13802h = a2 == null ? com.taobao.accs.common.Constants.PORT : a2.getPort();
                    C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
                    ALog.m16903e("SpdyConnection", this.a + " get ip from amdc succ:" + this.f13801g + ":" + this.f13802h + " originPos:" + this.f13798F.m16836c(), new Object[0]);
                }
                this.f13809o = "https://" + this.f13801g + ":" + this.f13802h + "/accs/";
            } else {
                String[] strArr = AccsConfig.ACCS_CHANNEL_IPS[UtilityImpl.getMode(this.b)];
                String m = (strArr == null || strArr.length <= 0) ? m16876m() : strArr[0];
                this.f13801g = m;
                this.f13802h = com.taobao.accs.common.Constants.PORT;
                this.f13809o = "https://" + this.f13801g + ":" + this.f13802h + "/accs/";
            }
            ALog.m16903e("SpdyConnection", this.a + " connect URL:" + this.f13809o, new Object[0]);
            this.f13799G = String.valueOf(System.currentTimeMillis());
            if (this.f13793A != null) {
                AppMonitor.getInstance().commitStat(this.f13793A);
            }
            this.f13793A = new SessionMonitor();
            this.f13793A.setConnectType(this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp");
            if (this.f13812r != null) {
                try {
                    this.f13817w = System.currentTimeMillis();
                    this.f13818x = System.nanoTime();
                    this.f13803i = UtilityImpl.getProxyHost(this.b);
                    this.f13804j = UtilityImpl.getProxyPort(this.b);
                    this.f13815u = System.currentTimeMillis();
                    this.f13793A.onStartConnect();
                    synchronized (this.f13814t) {
                        try {
                            SessionInfo sessionInfo;
                            if (TextUtils.isEmpty(this.f13803i) || this.f13804j < 0 || !this.f13795C) {
                                ALog.m16903e("SpdyConnection", this.a + " connect normal", new Object[0]);
                                sessionInfo = new SessionInfo(this.f13801g, this.f13802h, m16876m(), null, 0, this.f13799G, this, SpdyProtocol.SSSL_0RTT_SPDY);
                                this.f13796D = BuildConfig.FLAVOR;
                            } else {
                                ALog.m16903e("SpdyConnection", this.a + " connect with proxy:" + this.f13803i + ":" + this.f13804j, new Object[0]);
                                sessionInfo = new SessionInfo(this.f13801g, this.f13802h, m16876m(), this.f13803i, this.f13804j, this.f13799G, this, SpdyProtocol.SSSL_0RTT_SPDY);
                                this.f13796D = this.f13803i + ":" + this.f13804j;
                            }
                            sessionInfo.setPubKeySeqNum(m16872j());
                            sessionInfo.setConnectionTimeoutMs(C4112a.ACCS_RECEIVE_TIMEOUT);
                            this.f13813s = this.f13812r.createSession(sessionInfo);
                            m16864c(2);
                            this.f13793A.connection_stop_date = 0;
                            this.f13814t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            this.f13795C = false;
                        }
                    }
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m16864c(int r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = "SpdyConnection";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r1.<init>();	 Catch:{ all -> 0x007a }
        r2 = r6.a;	 Catch:{ all -> 0x007a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = " notifyStatus:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = r6.m16806a(r7);	 Catch:{ all -> 0x007a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r1 = r1.toString();	 Catch:{ all -> 0x007a }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x007a }
        com.taobao.accs.utl.ALog.m16903e(r0, r1, r2);	 Catch:{ all -> 0x007a }
        r0 = r6.f13805k;	 Catch:{ all -> 0x007a }
        if (r7 != r0) goto L_0x0049;
    L_0x002a:
        r0 = "SpdyConnection";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r1.<init>();	 Catch:{ all -> 0x007a }
        r2 = r6.a;	 Catch:{ all -> 0x007a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = " ignore notifyStatus";
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r1 = r1.toString();	 Catch:{ all -> 0x007a }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x007a }
        com.taobao.accs.utl.ALog.m16904i(r0, r1, r2);	 Catch:{ all -> 0x007a }
    L_0x0047:
        monitor-exit(r6);
        return;
    L_0x0049:
        r6.f13805k = r7;	 Catch:{ all -> 0x007a }
        switch(r7) {
            case 1: goto L_0x009b;
            case 2: goto L_0x007d;
            case 3: goto L_0x00ca;
            case 4: goto L_0x004e;
            default: goto L_0x004e;
        };	 Catch:{ all -> 0x007a }
    L_0x004e:
        r0 = "SpdyConnection";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r1.<init>();	 Catch:{ all -> 0x007a }
        r2 = r6.a;	 Catch:{ all -> 0x007a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = " notifyStatus:";
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = r6.m16806a(r7);	 Catch:{ all -> 0x007a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r2 = " handled";
        r1 = r1.append(r2);	 Catch:{ all -> 0x007a }
        r1 = r1.toString();	 Catch:{ all -> 0x007a }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x007a }
        com.taobao.accs.utl.ALog.m16904i(r0, r1, r2);	 Catch:{ all -> 0x007a }
        goto L_0x0047;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x007d:
        r0 = r6.f13800f;	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x0087;
    L_0x0081:
        r0 = r6.f13800f;	 Catch:{ all -> 0x007a }
        r1 = 1;
        r0.cancel(r1);	 Catch:{ all -> 0x007a }
    L_0x0087:
        r0 = r6.f13799G;	 Catch:{ all -> 0x007a }
        r1 = com.taobao.accs.common.C4089a.m16688a();	 Catch:{ all -> 0x007a }
        r2 = new com.taobao.accs.net.n;	 Catch:{ all -> 0x007a }
        r2.<init>(r6, r0);	 Catch:{ all -> 0x007a }
        r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x007a }
        r1.schedule(r2, r4, r0);	 Catch:{ all -> 0x007a }
        goto L_0x004e;
    L_0x009b:
        r0 = r6.b;	 Catch:{ all -> 0x007a }
        r0 = com.taobao.accs.net.C4116e.m16824a(r0);	 Catch:{ all -> 0x007a }
        r0.m16830f();	 Catch:{ all -> 0x007a }
        r6.m16875l();	 Catch:{ all -> 0x007a }
        r0 = r6.f13800f;	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x00b1;
    L_0x00ab:
        r0 = r6.f13800f;	 Catch:{ all -> 0x007a }
        r1 = 1;
        r0.cancel(r1);	 Catch:{ all -> 0x007a }
    L_0x00b1:
        r1 = r6.f13814t;	 Catch:{ all -> 0x007a }
        monitor-enter(r1);	 Catch:{ all -> 0x007a }
        r0 = r6.f13814t;	 Catch:{ Exception -> 0x00f4 }
        r0.notifyAll();	 Catch:{ Exception -> 0x00f4 }
    L_0x00b9:
        monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
        r1 = r6.f13806l;	 Catch:{ all -> 0x007a }
        monitor-enter(r1);	 Catch:{ all -> 0x007a }
        r0 = r6.f13806l;	 Catch:{ Exception -> 0x00f2 }
        r0.notifyAll();	 Catch:{ Exception -> 0x00f2 }
    L_0x00c2:
        monitor-exit(r1);	 Catch:{ all -> 0x00c4 }
        goto L_0x004e;
    L_0x00c4:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007a }
        throw r0;	 Catch:{ all -> 0x007a }
    L_0x00c7:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007a }
        throw r0;	 Catch:{ all -> 0x007a }
    L_0x00ca:
        r6.m16875l();	 Catch:{ all -> 0x007a }
        r0 = r6.b;	 Catch:{ all -> 0x007a }
        r0 = com.taobao.accs.net.C4116e.m16824a(r0);	 Catch:{ all -> 0x007a }
        r0.m16828d();	 Catch:{ all -> 0x007a }
        r1 = r6.f13814t;	 Catch:{ all -> 0x007a }
        monitor-enter(r1);	 Catch:{ all -> 0x007a }
        r0 = r6.f13814t;	 Catch:{ Exception -> 0x00f0 }
        r0.notifyAll();	 Catch:{ Exception -> 0x00f0 }
    L_0x00de:
        monitor-exit(r1);	 Catch:{ all -> 0x00ed }
        r0 = r6.c;	 Catch:{ all -> 0x007a }
        r1 = -10;
        r0.m16748a(r1);	 Catch:{ all -> 0x007a }
        r0 = 0;
        r1 = 1;
        r6.m16882a(r0, r1);	 Catch:{ all -> 0x007a }
        goto L_0x004e;
    L_0x00ed:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007a }
        throw r0;	 Catch:{ all -> 0x007a }
    L_0x00f0:
        r0 = move-exception;
        goto L_0x00de;
    L_0x00f2:
        r0 = move-exception;
        goto L_0x00c2;
    L_0x00f4:
        r0 = move-exception;
        goto L_0x00b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.l.c(int):void");
    }

    private void m16866d(int i) {
        this.f13811q = null;
        m16889i();
        int i2 = this.f13807m != null ? this.f13807m.f13790a : 0;
        this.f13793A.setCloseReason("code not 200 is" + i);
        this.f13797E = true;
        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "CONNECTED NO 200 " + (this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp"), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), this.f13810p, this.f13796D);
        C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_AUTH, BuildConfig.FLAVOR, i + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    private int m16872j() {
        int i = AccsConfig.mSecurityType == SECURITY_TYPE.SECURITY_OFF ? 1 : 0;
        return UtilityImpl.isDebugMode(this.b) ? i != 0 ? 0 : 0 : GlobalClientInfo.f13607b > 0 ? GlobalClientInfo.f13607b : i != 0 ? 4 : 3;
    }

    private void m16874k() {
        int i = 1;
        if (this.f13813s == null) {
            m16864c(3);
            return;
        }
        try {
            String imsi = UtilityImpl.getImsi(this.b);
            imsi = (imsi == null || imsi.length() <= 5) ? "null" : imsi.substring(0, 5);
            String encode = URLEncoder.encode(UtilityImpl.getDeviceId(this.b));
            String appkey = UtilityImpl.getAppkey(this.b);
            String appsign = UtilityImpl.getAppsign(this.b, appkey, UtilityImpl.getDeviceId(this.b), this.f13811q, this.a + BuildConfig.FLAVOR);
            StringBuilder append = new StringBuilder().append(this.f13809o + "auth?1=" + encode + "&2=" + appsign + "&3=" + UtilityImpl.getAppkey(this.b) + (this.f13811q == null ? BuildConfig.FLAVOR : "&4=" + this.f13811q) + "&5=" + this.a + "&6=" + UtilityImpl.getNetworkType(this.b) + "&7=" + imsi + "&8=" + com.taobao.accs.common.Constants.SDK_VERSION_CODE + "&9=" + System.currentTimeMillis() + "&10=" + 1 + "&11=" + VERSION.SDK_INT + "&12=" + this.b.getPackageName() + "&13=" + UtilityImpl.getAppVersion(this.b) + "&14=" + UtilityImpl.getTtId(this.b) + "&15=" + Build.MODEL + "&16=" + Build.BRAND + "&17=" + com.taobao.accs.common.Constants.SDK_VERSION_CODE).append("&19=");
            if (AccsConfig.mSecurityType == SECURITY_TYPE.SECURITY_OFF) {
                i = 0;
            }
            imsi = append.append(i).toString();
            ALog.m16903e("SpdyConnection", this.a + " auth URL:" + imsi, new Object[0]);
            this.f13810p = imsi;
            if (m16857a(encode, appkey, appsign)) {
                URL url = new URL(imsi);
                SpdyRequest spdyRequest = new SpdyRequest(new URL(imsi), SpdyRequest.GET_METHOD, RequestPriority.DEFAULT_PRIORITY, 80000, (int) C4112a.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(m16876m());
                this.f13813s.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), m16876m(), this);
                return;
            }
            ALog.m16903e("SpdyConnection", this.a + " auth param error!", new Object[0]);
            m16866d(-6);
        } catch (Throwable th) {
            ALog.m16902e("SpdyConnection", this.a + " auth exception ", th, new Object[0]);
            m16866d(-7);
        }
    }

    private synchronized void m16875l() {
        if (this.a != 1) {
            this.f13815u = System.currentTimeMillis();
            this.f13816v = System.nanoTime();
            C4116e.m16824a(this.b).m16825a();
        }
    }

    private String m16876m() {
        String str = AccsConfig.ACCS_CHANNEL_HOSTS[UtilityImpl.getMode(this.b)];
        ALog.m16904i("SpdyConnection", this.a + " getDefaultHost:" + str, new Object[0]);
        return str == null ? BuildConfig.FLAVOR : str;
    }

    private void m16877n() {
        try {
            SpdyAgent.enableDebug = true;
            this.f13812r = SpdyAgent.getInstance(this.b, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                C4140e.m16926a();
                this.f13812r.setAccsSslCallback(new C4127o(this));
                if (!C4144h.m16941a(false)) {
                    String str = this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp";
                    ALog.m16901d("SpdyConnection", "into--[setTnetLogPath]", new Object[0]);
                    Object tnetLogFilePath = UtilityImpl.getTnetLogFilePath(this.b, str);
                    ALog.m16901d("SpdyConnection", "config tnet log path:" + tnetLogFilePath, new Object[0]);
                    if (!TextUtils.isEmpty(tnetLogFilePath)) {
                        this.f13812r.configLogFile(tnetLogFilePath, UtilityImpl.TNET_FILE_SIZE, 5);
                        return;
                    }
                    return;
                }
                return;
            }
            ALog.m16903e("SpdyConnection", "loadSoFail", new Object[0]);
            C4140e.m16927b();
        } catch (Throwable th) {
            ALog.m16902e("SpdyConnection", "loadSoFail", th, new Object[0]);
        }
    }

    public synchronized void m16878a() {
        this.f13808n = true;
        m16879a(this.b);
        if (this.f13807m == null) {
            ALog.m16904i("SpdyConnection", this.a + " start thread", new Object[0]);
            this.f13807m = new C4123a();
            this.f13807m.start();
        }
        m16882a(false, false);
    }

    protected void m16879a(Context context) {
        super.m16808a(context);
        AccsConfig.disableInappKeepAlive();
        GlobalAppRuntimeInfo.setBackground(false);
    }

    protected void m16880a(Message message, boolean z) {
        if (!this.f13808n || message == null) {
            ALog.m16903e("SpdyConnection", "not running or msg null! " + this.f13808n, new Object[0]);
            return;
        }
        try {
            if (C4089a.m16688a().getQueue().size() > AdError.NETWORK_ERROR_CODE) {
                throw new RejectedExecutionException(AgooConstants.MESSAGE_SOURCE_ACCS);
            }
            ScheduledFuture schedule = C4089a.m16688a().schedule(new C4125m(this, message, z), message.delyTime, TimeUnit.MILLISECONDS);
            if (message.getType() == 1 && message.cunstomDataId != null) {
                if (message.isControlFrame()) {
                    m16883a(message.cunstomDataId);
                }
                this.c.f13691a.put(message.cunstomDataId, schedule);
            }
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setDeviceId(UtilityImpl.getDeviceId(this.b));
                message.getNetPermanceMonitor().setConnType(this.a);
                message.getNetPermanceMonitor().onEnterQueueData();
            }
        } catch (RejectedExecutionException e) {
            this.c.m16750a(message, (int) ErrorCode.MESSAGE_QUEUE_FULL);
            ALog.m16903e("SpdyConnection", this.a + "send queue full count:" + C4089a.m16688a().getQueue().size(), new Object[0]);
        } catch (Throwable th) {
            this.c.m16750a(message, -8);
            ALog.m16902e("SpdyConnection", this.a + "send error", th, new Object[0]);
        }
    }

    protected void m16881a(String str, String str2) {
        try {
            m16864c(4);
            m16889i();
            this.f13793A.setCloseReason(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m16882a(boolean z, boolean z2) {
        ALog.m16901d("SpdyConnection", "try ping, force:" + z, new Object[0]);
        if (this.a == 1) {
            ALog.m16901d("SpdyConnection", "INAPP, skip", new Object[0]);
        } else {
            m16816b(Message.BuildPing(z, (int) (z2 ? (Math.random() * 10.0d) * 1000.0d : 0.0d)), z);
        }
    }

    public boolean m16883a(String str) {
        boolean z;
        synchronized (this.f13806l) {
            for (int size = this.f13806l.size() - 1; size >= 0; size--) {
                Message message = (Message) this.f13806l.get(size);
                if (message != null && message.getType() == 1 && message.cunstomDataId != null && message.cunstomDataId.equals(str)) {
                    this.f13806l.remove(size);
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public boolean m16884b() {
        return this.f13808n;
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        ALog.m16906w("SpdyConnection", "bioPingRecvCallback uniId:" + i, new Object[0]);
    }

    public void m16885c() {
        this.f13795C = false;
        this.d = 0;
    }

    public C4132c m16886d() {
        int i = 0;
        if (this.f13794B == null) {
            this.f13794B = new C4132c();
        }
        this.f13794B.f13860b = this.a;
        this.f13794B.f13862d = this.f13806l.size();
        this.f13794B.f13867i = UtilityImpl.isNetworkConnected(this.b);
        this.f13794B.f13864f = this.f13796D;
        this.f13794B.f13859a = this.f13805k;
        this.f13794B.f13861c = this.f13793A == null ? false : this.f13793A.getRet();
        this.f13794B.f13868j = m16884b();
        C4132c c4132c = this.f13794B;
        if (this.c != null) {
            i = this.c.m16761e();
        }
        c4132c.f13863e = i;
        this.f13794B.f13865g = this.f13810p;
        return this.f13794B;
    }

    protected String m16887e() {
        return "SpdyConnection";
    }

    public void m16888f() {
        super.m16821f();
        this.f13808n = false;
        m16889i();
        if (this.f13793A != null) {
            this.f13793A.setCloseReason("shut down");
        }
        synchronized (this.f13806l) {
            try {
                this.f13806l.notifyAll();
            } catch (Exception e) {
            }
        }
        ALog.m16903e("SpdyConnection", this.a + "shut down", new Object[0]);
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        return Utils.SecurityGuardGetSslTicket2(this.b, spdySession.getDomain());
    }

    public void m16889i() {
        ALog.m16903e("SpdyConnection", this.a + " force close!", new Object[0]);
        try {
            this.f13813s.closeSession();
            this.f13793A.setCloseType(1);
        } catch (Exception e) {
        }
        m16864c(3);
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return Utils.SecurityGuardPutSslTicket2(this.b, spdySession.getDomain(), bArr);
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        m16815b(i);
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        m16875l();
        ALog.m16903e("SpdyConnection", this.a + " onFrame, type:" + i2 + " len:" + bArr.length, new Object[0]);
        String str = BuildConfig.FLAVOR;
        if (ALog.isPrintLog(Level.D) && bArr.length < AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = str;
            for (byte b : bArr) {
                str2 = str2 + Integer.toHexString(b & MotionEventCompat.ACTION_MASK) + " ";
            }
            ALog.m16901d("SpdyConnection", str2 + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i2 == com.taobao.accs.common.Constants.COMMAND_HANDSHAKE) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.c.m16754a(bArr);
                C4133d g = this.c.m16763g();
                if (g != null) {
                    g.f13872c = String.valueOf(currentTimeMillis2);
                    g.f13876g = this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp";
                    g.commitUT();
                }
            } catch (Throwable th) {
                ALog.m16902e("SpdyConnection", "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(UT.EVENT_ID, "SERVICE_DATA_RECEIVE", UtilityImpl.getStackMsg(th));
            }
            ALog.m16901d("SpdyConnection", "try handle msg", new Object[0]);
            m16823h();
        } else {
            ALog.m16903e("SpdyConnection", this.a + " drop frame" + " len:" + bArr.length, new Object[0]);
        }
        ALog.m16901d("SpdyConnection", "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.m16901d("SpdyConnection", "spdyDataChunkRecvCB", new Object[0]);
    }

    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.m16901d("SpdyConnection", "spdyDataRecvCallback", new Object[0]);
    }

    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.m16901d("SpdyConnection", "spdyDataSendCallback", new Object[0]);
    }

    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        this.f13815u = System.currentTimeMillis();
        this.f13816v = System.nanoTime();
        try {
            Map a = m16853a((Map) map);
            int parseInt = Integer.parseInt((String) a.get(HttpConstant.STATUS));
            ALog.m16903e("SpdyConnection", this.a + " spdyOnStreamResponse httpStatusCode: " + parseInt, new Object[0]);
            if (parseInt == com.taobao.accs.common.Constants.COMMAND_HANDSHAKE) {
                m16864c(1);
                if (!TextUtils.isEmpty((String) a.get("x-at"))) {
                    this.f13811q = (String) a.get("x-at");
                }
                this.f13793A.auth_time = this.f13793A.connection_stop_date > 0 ? System.currentTimeMillis() - this.f13793A.connection_stop_date : 0;
                UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "CONNECTED 200 " + (this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp"), this.f13810p, this.f13796D, Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), MessageService.MSG_DB_READY_REPORT);
                C4136b.m16915a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_AUTH, BuildConfig.FLAVOR);
            } else {
                m16866d(parseInt);
            }
        } catch (Exception e) {
            ALog.m16903e("SpdyConnection", "SpdyConnection" + e.toString(), new Object[0]);
            m16889i();
            this.f13793A.setCloseReason(ModelFields.EXCEPTION);
        }
        ALog.m16901d("SpdyConnection", "spdyOnStreamResponse", new Object[0]);
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.m16901d("SpdyConnection", "spdyPingRecvCallback uniId:" + j, new Object[0]);
        if (j >= 0) {
            this.c.m16759c();
            C4116e.m16824a(this.b).m16829e();
            C4116e.m16824a(this.b).m16825a();
            this.f13793A.onPingCBReceive();
            if (this.f13793A.ping_rec_times % 2 == 0) {
                UtilityImpl.setServiceTime(this.b, com.taobao.accs.common.Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
            }
        }
    }

    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.m16901d("SpdyConnection", "spdyRequestRecvCallback", new Object[0]);
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.m16903e("SpdyConnection", this.a + " spdySessionCloseCallback, errorCode:" + i, new Object[0]);
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.m16903e("SpdyConnection", "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        m16864c(3);
        this.f13793A.onCloseConnect();
        if (this.f13793A.getConCloseDate() > 0 && this.f13793A.getConStopDate() > 0) {
            this.f13793A.getConCloseDate();
            this.f13793A.getConStopDate();
        }
        this.f13793A.setCloseReason(this.f13793A.getCloseReason() + "tnet error:" + i);
        if (superviseConnectInfo != null) {
            this.f13793A.live_time = (long) superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.f13793A);
        for (Message message : this.c.m16762f()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp";
        ALog.m16901d("SpdyConnection", "spdySessionCloseCallback, conKeepTime:" + this.f13793A.live_time + " connectType:" + str, new Object[0]);
        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "DISCONNECT CLOSE " + str, Integer.valueOf(i), Long.valueOf(this.f13793A.live_time), Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), this.f13810p, this.f13796D);
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.f13819y = superviseConnectInfo.connectTime;
        int i = superviseConnectInfo.handshakeTime;
        ALog.m16903e("SpdyConnection", this.a + " spdySessionConnectCB sessionConnectInterval:" + this.f13819y + " sslTime:" + i + " reuse:" + superviseConnectInfo.sessionTicketReused, new Object[0]);
        m16874k();
        if (this.f13807m != null) {
            int i2 = this.f13807m.f13790a;
        }
        this.f13793A.setRet(true);
        this.f13793A.onConnectStop();
        this.f13793A.tcp_time = (long) this.f13819y;
        this.f13793A.ssl_time = (long) i;
        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "CONNECTED " + (this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp") + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.f13819y), String.valueOf(i), Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.f13810p, this.f13796D);
        C4136b.m16915a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_CONNECT, BuildConfig.FLAVOR);
    }

    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.m16903e("SpdyConnection", "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        int i2 = this.f13807m != null ? this.f13807m.f13790a : 0;
        ALog.m16903e("SpdyConnection", this.a + " spdySessionFailedError, retryTimes:" + i2 + " errorId:" + i, new Object[0]);
        this.f13795C = false;
        this.f13797E = true;
        m16864c(3);
        this.f13793A.setFailReason(i);
        this.f13793A.onConnectStop();
        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "DISCONNECT " + (this.a == 0 ? NotificationCompatApi21.CATEGORY_SERVICE : "inapp"), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.taobao.accs.common.Constants.SDK_VERSION_CODE), this.f13810p, this.f13796D);
        C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i2, i + BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
        ALog.m16901d("SpdyConnection", "spdyStreamCloseCallback", new Object[0]);
        if (i != 0) {
            ALog.m16903e("SpdyConnection", "spdyStreamCloseCallback", "statusCode", Integer.valueOf(i));
            m16866d(i);
        }
    }
}
