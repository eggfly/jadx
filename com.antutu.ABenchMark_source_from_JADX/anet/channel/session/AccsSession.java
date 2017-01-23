package anet.channel.session;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.AccsFrameCb;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.Session.Status;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0666a;
import anet.channel.entity.ENV;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.heartbeat.IHeartbeatFactory;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.C0739d;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.android.spdy.RequestPriority;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

public class AccsSession extends C0687k {
    public static final int CONN_TYPE_INAPP = 1;
    private static final String TAG = "awcn.AccsSession";
    private IHeartbeat heartbeat;
    private String mAppKey;
    private AccsFrameCb mFrameCb;

    /* renamed from: anet.channel.session.AccsSession.a */
    class C0686a extends C0685b {
        final /* synthetic */ AccsSession f2268a;

        C0686a(AccsSession accsSession) {
            this.f2268a = accsSession;
        }

        public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(C0739d.m2973b(map, HttpConstant.STATUS));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            try {
                ALog.m2962e(AccsSession.TAG, "AUTH httpStatusCode: " + parseInt, this.f2268a.mSeq, new Object[0]);
                if (parseInt == Constants.COMMAND_HANDSHAKE) {
                    this.f2268a.notifyStatus(Status.AUTH_SUCC, null);
                    if (this.f2268a.heartbeat != null) {
                        this.f2268a.mLastPingTime = System.currentTimeMillis();
                        this.f2268a.heartbeat.start();
                    }
                    this.f2268a.mSessionStat.ret = AccsSession.CONN_TYPE_INAPP;
                    ALog.m2960d(AccsSession.TAG, "spdyOnStreamResponse", this.f2268a.mSeq, "authTime", Long.valueOf(this.f2268a.mSessionStat.authTime));
                } else {
                    this.f2268a.onAuthFail(parseInt);
                }
                if (this.f2268a.mConnectedTime > 0) {
                    this.f2268a.mSessionStat.authTime = System.currentTimeMillis() - this.f2268a.mConnectedTime;
                }
                Object b = C0739d.m2973b(map, "x-at");
                if (!TextUtils.isEmpty(b)) {
                    GlobalAppRuntimeInfo.mConnToken = b;
                }
            } catch (Throwable e2) {
                ALog.m2961e(AccsSession.TAG, "spdyOnStreamResponse", this.f2268a.mSeq, e2, new Object[0]);
                this.f2268a.close();
            }
        }

        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
            if (i != 0) {
                ALog.m2962e(AccsSession.TAG, "AUTH spdyStreamCloseCallback: " + i, this.f2268a.mSeq, new Object[0]);
                this.f2268a.onAuthFail(i);
            }
        }
    }

    public AccsSession(Context context, C0666a c0666a) {
        super(context, c0666a, c0666a.m2799c());
        this.heartbeat = null;
        this.mAppKey = GlobalAppRuntimeInfo.getAppKey();
        this.mFrameCb = SessionCenter.getInstance().getDataChannelCb();
        this.mSessionStat.isKL = 1;
        this.autoReCreate = AwcnConfig.isAccsSessionAutoRecreate();
        IHeartbeatFactory heartbeatFactory = HeartbeatManager.getHeartbeatFactory();
        if (heartbeatFactory != null) {
            this.heartbeat = heartbeatFactory.createHeartbeat(this);
        }
    }

    private String buildAuthUrl() {
        String deviceId = Utils.getDeviceId(this.mContext);
        try {
            deviceId = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
        }
        String appSign = Utils.getAppSign(this.mContext, this.mAppKey, Utils.getDeviceId(this.mContext), GlobalAppRuntimeInfo.mConnToken, String.valueOf(CONN_TYPE_INAPP));
        StringBuilder stringBuilder = new StringBuilder(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        stringBuilder.append("https://").append(this.mIp).append(":").append(this.mPort).append("/accs/");
        stringBuilder.append("auth?1=").append(deviceId).append("&2=").append(appSign).append("&3=").append(this.mAppKey);
        if (GlobalAppRuntimeInfo.mConnToken != null) {
            stringBuilder.append("&4=").append(GlobalAppRuntimeInfo.mConnToken);
        }
        stringBuilder.append("&5=").append(CONN_TYPE_INAPP).append("&6=").append(NetworkStatusHelper.m2843b()).append("&7=").append(Utils.getOperator(this.mContext)).append("&8=").append("1.1.2").append("&9=").append(System.currentTimeMillis()).append("&10=").append(CONN_TYPE_INAPP).append("&11=").append(VERSION.SDK_INT).append("&12=").append(this.mContext.getPackageName()).append("&13=").append(Utils.getAppVersion(this.mContext)).append("&14=").append(GlobalAppRuntimeInfo.getTtid()).append("&15=").append(Build.MODEL).append("&16=").append(Build.BRAND).append("&17=").append(Utils.getAccsVersion());
        if (this.isHorseRide) {
            stringBuilder.append("&18=").append("ign-loc");
        }
        stringBuilder.append("&19=").append(SessionCenter.SECURITYGUARD_OFF ? 0 : CONN_TYPE_INAPP);
        ALog.m2962e(TAG, BaseMonitor.ALARM_POINT_AUTH, this.mSeq, "auth url", stringBuilder.toString());
        if (checkParam(deviceId, this.mAppKey, appSign)) {
            return r1;
        }
        ALog.m2962e(TAG, "connect param error!", this.mSeq, new Object[0]);
        onAuthFail(ErrorConstant.ERROR_ACCS_AUTH_PARAM_INVALID);
        return null;
    }

    private boolean checkParam(String str, String str2, String str3) {
        int i = CONN_TYPE_INAPP;
        if (GlobalAppRuntimeInfo.getEnv() == ENV.TEST) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                i = 2;
            } else if (TextUtils.isEmpty(str3)) {
                i = 3;
            }
        }
        AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_ACCS_AUTH_PARAM_INVALID, ErrorConstant.formatMsg(ErrorConstant.ERROR_ACCS_AUTH_PARAM_INVALID, "1.1.2 errorCode=" + i), "rt"));
        return false;
    }

    private void onAuthFail(int i) {
        notifyStatus(Status.AUTH_FAIL, null);
        if (this.mSessionStat != null) {
            this.mSessionStat.closeReason = "Accs_Auth_Fail";
            this.mSessionStat.errorCode = (long) i;
        }
        close();
    }

    private void onException(int i, int i2, boolean z, String str) {
        if (this.mFrameCb != null) {
            this.mFrameCb.onException(i, i2, z, str);
        }
    }

    protected void auth() {
        if (this.mSession == null) {
            notifyStatus(Status.CONNETFAIL, null);
            return;
        }
        String buildAuthUrl = buildAuthUrl();
        if (buildAuthUrl != null) {
            try {
                URL url = new URL(buildAuthUrl);
                SpdyRequest spdyRequest = (TextUtils.isEmpty(this.mProxyIp) || this.mProxyPort <= 0) ? new SpdyRequest(url, SpdyRequest.GET_METHOD, RequestPriority.DEFAULT_PRIORITY, this.mReqTimeout, this.mConnTimeout) : new SpdyRequest(url, url.getHost(), url.getPort(), this.mProxyIp, this.mProxyPort, SpdyRequest.GET_METHOD, RequestPriority.DEFAULT_PRIORITY, this.mReqTimeout, this.mConnTimeout, 0);
                spdyRequest.setDomain(this.mHost);
                this.mSession.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), this.mHost, new C0686a(this));
            } catch (Throwable th) {
                ALog.m2961e(TAG, "auth exception ", this.mSeq, th, new Object[0]);
                onAuthFail(ErrorConstant.ERROR_AUTH_EXCEPTION);
            }
        }
    }

    public void close() {
        if (this.heartbeat != null) {
            this.heartbeat.stop();
            this.heartbeat = null;
        }
        super.close();
    }

    protected Runnable getRecvTimeOutRunnable() {
        return new C0688a(this);
    }

    public Cancelable request(Request request, RequestCb requestCb) {
        if (this.heartbeat != null) {
            this.mLastPingTime = System.currentTimeMillis();
            this.heartbeat.setNextHeartbeat(this.mLastPingTime + this.heartbeat.getInterval());
        }
        return super.request(request, requestCb);
    }

    public void sendCustomFrame(int i, byte[] bArr, int i2) {
        try {
            ALog.m2960d(TAG, "sendCustomFrame", this.mSeq, Constants.KEY_DATA_ID, Integer.valueOf(i), C4233j.f14402y, Integer.valueOf(i2));
            if (this.mStatus != Status.AUTH_SUCC || this.mSession == null) {
                String str = this.mSeq;
                Object[] objArr = new Object[CONN_TYPE_INAPP];
                objArr[0] = "sendCustomFrame con invalid mStatus:" + this.mStatus;
                ALog.m2962e(TAG, "sendCustomFrame", str, objArr);
                onException(i, ErrorConstant.ERROR_SESSION_INVALID, false, "session invalid");
            } else if (bArr == null || bArr.length <= SpdyProtocol.SLIGHTSSL_L7E) {
                this.mSession.sendCustomControlFrame(i, i2, 0, bArr == null ? 0 : bArr.length, bArr);
                SessionStatistic sessionStatistic = this.mSessionStat;
                sessionStatistic.requestCount++;
                sessionStatistic = this.mSessionStat;
                sessionStatistic.cfRCount++;
                this.mLastPingTime = System.currentTimeMillis();
                if (this.heartbeat != null) {
                    this.heartbeat.setNextHeartbeat(this.mLastPingTime + this.heartbeat.getInterval());
                }
            } else {
                onException(i, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
            }
        } catch (Throwable e) {
            ALog.m2961e(TAG, "sendCustomFrame error", this.mSeq, e, new Object[0]);
            onException(i, ErrorConstant.ERROR_TNET_EXCEPTION, false, "SpdyErrorException: " + e.toString());
        } catch (Throwable e2) {
            ALog.m2961e(TAG, "sendCustomFrame error", this.mSeq, e2, new Object[0]);
            onException(i, ErrorConstant.ERROR_EXCEPTION, false, e2.toString());
        }
    }

    public void setFrameCb(AccsFrameCb accsFrameCb) {
        ALog.m2963i(TAG, "setFrameCb", this.mSeq, "AccsFrameCb", accsFrameCb);
        this.mFrameCb = accsFrameCb;
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        ALog.m2962e(TAG, "spdyCustomControlFrameFailCallback", this.mSeq, Constants.KEY_DATA_ID, Integer.valueOf(i));
        onException(i, i2, true, "tnet error");
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        ALog.m2963i(TAG, "[spdyCustomControlFrameRecvCallback]", this.mSeq, "len", Integer.valueOf(i4), "frameCb", this.mFrameCb);
        if (ALog.isPrintLog(CONN_TYPE_INAPP)) {
            String str = BuildConfig.FLAVOR;
            if (i4 < AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
                for (int i5 = 0; i5 < bArr.length; i5 += CONN_TYPE_INAPP) {
                    str = str + Integer.toHexString(bArr[i5] & MotionEventCompat.ACTION_MASK) + " ";
                }
                ALog.m2960d(TAG, null, this.mSeq, "str", str);
            }
        }
        if (this.mFrameCb != null) {
            this.mFrameCb.onDataReceive(this, bArr, i, i2);
        } else {
            ALog.m2962e(TAG, "AccsFrameCb is null", this.mSeq, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL, null, "rt"));
        }
        SessionStatistic sessionStatistic = this.mSessionStat;
        sessionStatistic.inceptCount++;
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        if (this.heartbeat != null) {
            this.heartbeat.stop();
        }
        super.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
    }
}
