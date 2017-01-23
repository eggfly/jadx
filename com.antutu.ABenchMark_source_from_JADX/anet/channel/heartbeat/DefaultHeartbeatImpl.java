package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.p019c.C0660c;
import anet.channel.session.AccsSession;
import anet.channel.util.ALog;
import java.util.concurrent.TimeUnit;

public class DefaultHeartbeatImpl implements IHeartbeat, Runnable {
    private static final String TAG = "awcn.DefaultHeartbeatImpl";
    private int bgHeartbeatCount;
    private volatile long executeTime;
    protected long interval;
    private volatile boolean isCancelled;
    private final Session session;

    public DefaultHeartbeatImpl(Session session) {
        this.interval = 0;
        this.executeTime = 0;
        this.isCancelled = false;
        this.bgHeartbeatCount = 0;
        this.session = session;
        if (session instanceof AccsSession) {
            ((AccsSession) session).setFrameCb(SessionCenter.getInstance().getDataChannelCb());
        }
        this.interval = (long) session.getConnStrategy().getHeartbeat();
    }

    private void submit(long j) {
        try {
            C0660c.m2786a(this, 50 + j, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            ALog.m2961e(TAG, "Submit heartbeat task to thread pool failed.", null, e, new Object[0]);
        }
    }

    public long getInterval() {
        return this.interval;
    }

    public void run() {
        int i = 0;
        if (!this.isCancelled) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.executeTime) {
                submit(this.executeTime - currentTimeMillis);
                return;
            }
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            if (!isAppBackground || this.bgHeartbeatCount < 1) {
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d(TAG, "heartbeat", null, "session", this.session);
                }
                this.session.ping(true);
                if (isAppBackground) {
                    i = this.bgHeartbeatCount + 1;
                }
                this.bgHeartbeatCount = i;
                this.executeTime = getInterval() + currentTimeMillis;
                submit(this.interval);
                return;
            }
            ALog.m2962e(TAG, "close session in background", null, new Object[0]);
            this.session.close(false);
        }
    }

    public void setNextHeartbeat(long j) {
        if (this.executeTime + 1000 < j) {
            if (ALog.isPrintLog(1)) {
                ALog.m2960d(TAG, "setNextHeartbeat", null, "session", this.session, "offset", Long.valueOf(j - this.executeTime));
            }
            this.executeTime = j;
        }
    }

    public void start() {
        ALog.m2963i(TAG, "heartbeat start", null, "session", this.session);
        long interval = getInterval();
        this.executeTime = System.currentTimeMillis() + interval;
        submit(interval);
    }

    public void stop() {
        ALog.m2963i(TAG, "heartbeat stop", null, "session", this.session);
        this.isCancelled = true;
    }
}
