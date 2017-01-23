package anet.channel.strategy;

import anet.channel.entity.C0667d;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.strategy.C0731k.C0728a;
import anet.channel.strategy.RawConnStrategy.C0708a;
import java.io.Serializable;

class IPConnStrategy implements IConnStrategy, Serializable, Comparable<IPConnStrategy> {
    public final String ip;
    public transient boolean isToRemove;
    public final RawConnStrategy rawConnStrategy;

    /* renamed from: anet.channel.strategy.IPConnStrategy.a */
    static class C0706a {
        C0706a() {
        }

        static IPConnStrategy m2866a(String str, RawConnStrategy rawConnStrategy) {
            return rawConnStrategy == null ? null : new IPConnStrategy(rawConnStrategy, null);
        }

        static IPConnStrategy m2867a(String str, C0728a c0728a) {
            return C0706a.m2866a(str, C0708a.m2870a(c0728a));
        }
    }

    private IPConnStrategy(String str, RawConnStrategy rawConnStrategy) {
        this.rawConnStrategy = rawConnStrategy;
        this.ip = str;
    }

    public int compareTo(IPConnStrategy iPConnStrategy) {
        return this.rawConnStrategy.compareTo(iPConnStrategy.rawConnStrategy);
    }

    public ConnType getConnType() {
        return this.rawConnStrategy.connType;
    }

    public int getConnectionTimeout() {
        return this.rawConnStrategy.cto;
    }

    public int getHeartbeat() {
        return this.rawConnStrategy.heartbeat;
    }

    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return this.rawConnStrategy.port;
    }

    public int getReadTimeout() {
        return this.rawConnStrategy.rto;
    }

    public int getRetryTimes() {
        return this.rawConnStrategy.retry;
    }

    public boolean isAvailable() {
        return this.rawConnStrategy.isAvailable();
    }

    public boolean isNeedAuth() {
        return this.rawConnStrategy.isAuth;
    }

    public void notifyEvent(EventType eventType, C0667d c0667d) {
        this.rawConnStrategy.notifyEvent(eventType, c0667d);
    }

    public void resetConnStatus() {
        this.rawConnStrategy.resetConnStatus();
    }

    public String toString() {
        return String.format("{%s:%s}", new Object[]{this.ip, this.rawConnStrategy.toString()});
    }
}
