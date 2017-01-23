package anet.channel.entity;

import anet.channel.Session;

public interface EventCb {
    void onEvent(Session session, EventType eventType, C0667d c0667d);
}
