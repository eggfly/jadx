package anet.channel.strategy;

import anet.channel.entity.C0667d;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;

public interface IConnStrategy {
    ConnType getConnType();

    int getConnectionTimeout();

    int getHeartbeat();

    String getIp();

    int getPort();

    int getReadTimeout();

    int getRetryTimes();

    boolean isAvailable();

    boolean isNeedAuth();

    void notifyEvent(EventType eventType, C0667d c0667d);
}
