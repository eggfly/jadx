package anet.channel.statist;

import anet.channel.entity.C0666a;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;

@Monitor(module = "networkPrefer", monitorPoint = "session")
public class SessionStatistic extends StatObject {
    public static int maxRetryTime;
    @Measure
    public long ackTime;
    @Measure(max = 15000.0d)
    public long authTime;
    @Measure
    public long cfRCount;
    @Dimension
    public String closeReason;
    @Measure(max = 15000.0d)
    public long connectionTime;
    @Dimension
    public String conntype;
    @Dimension
    public long errorCode;
    @Dimension
    public String host;
    @Measure
    public long inceptCount;
    @Dimension
    public String ip;
    @Dimension
    public boolean isBackground;
    public boolean isCommitted;
    @Dimension
    public long isKL;
    @Dimension
    public String isProxy;
    @Dimension
    public String isTunnel;
    @Measure
    public int lastPingInterval;
    @Measure(max = 86400.0d)
    public long liveTime;
    @Dimension
    public String netType;
    @Measure
    public long pRate;
    @Dimension
    public int port;
    @Measure
    public long ppkgCount;
    @Measure
    public long recvSizeCount;
    @Measure(constantValue = 1.0d)
    public long requestCount;
    @Dimension
    public int ret;
    @Dimension
    public long retryTimes;
    @Dimension
    public int sdkv;
    @Measure
    public long sendSizeCount;
    @Measure(max = 15000.0d)
    public long sslCalTime;
    @Measure(max = 15000.0d)
    public long sslTime;
    @Measure(constantValue = 0.0d)
    public long stdRCount;

    public SessionStatistic(C0666a c0666a) {
        this.isProxy = "false";
        this.liveTime = 0;
        this.requestCount = 1;
        this.stdRCount = 1;
        this.isCommitted = false;
        this.host = c0666a.m2803g();
        this.ip = c0666a.m2797a();
        this.port = c0666a.m2798b();
        this.pRate = (long) c0666a.m2804h();
        this.retryTimes = 0;
        this.conntype = c0666a.m2799c() + BuildConfig.FLAVOR;
    }

    public boolean beforeCommit() {
        if (this.ret == 0 && (this.retryTimes != ((long) maxRetryTime) || this.errorCode == -2613 || this.errorCode == -2601)) {
            if (!ALog.isPrintLog(1)) {
                return false;
            }
            ALog.m2960d("SessionStat no need commit", null, "retry:", Long.valueOf(this.retryTimes), "maxRetryTime", Integer.valueOf(maxRetryTime), Constants.KEY_ERROR_CODE, Long.valueOf(this.errorCode));
            return false;
        } else if (this.isCommitted) {
            return false;
        } else {
            this.isCommitted = true;
            return true;
        }
    }

    public AlarmObject getAlarmObject() {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "connect_succ_rate";
        alarmObject.isSuccess = this.ret != 0;
        if (alarmObject.isSuccess) {
            alarmObject.arg = this.closeReason;
        } else {
            alarmObject.errorCode = String.valueOf(this.errorCode);
        }
        return alarmObject;
    }
}
