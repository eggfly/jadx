package com.umeng.message;

import android.annotation.TargetApi;
import com.umeng.message.entity.UNotificationItem;
import java.util.LinkedList;

public class MessageNotificationQueue {
    private static MessageNotificationQueue f14081b;
    private LinkedList<UNotificationItem> f14082a;

    private MessageNotificationQueue() {
        this.f14082a = new LinkedList();
    }

    public static synchronized MessageNotificationQueue getInstance() {
        MessageNotificationQueue messageNotificationQueue;
        synchronized (MessageNotificationQueue.class) {
            if (f14081b == null) {
                f14081b = new MessageNotificationQueue();
            }
            messageNotificationQueue = f14081b;
        }
        return messageNotificationQueue;
    }

    public void addLast(UNotificationItem uNotificationItem) {
        this.f14082a.addLast(uNotificationItem);
    }

    @TargetApi(9)
    public UNotificationItem pollFirst() {
        return (UNotificationItem) this.f14082a.pollFirst();
    }

    public void remove(UNotificationItem uNotificationItem) {
        this.f14082a.remove(uNotificationItem);
    }

    public int size() {
        return this.f14082a.size();
    }
}
