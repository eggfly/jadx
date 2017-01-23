package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.PushMessageHandler.C4341a;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.android.spdy.SpdyProtocol;

public class MessageHandleService extends IntentService {
    private static ConcurrentLinkedQueue<C4340a> f14788a;

    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService.a */
    public static class C4340a {
        private PushMessageReceiver f14786a;
        private Intent f14787b;

        public C4340a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f14786a = pushMessageReceiver;
            this.f14787b = intent;
        }

        public PushMessageReceiver m17778a() {
            return this.f14786a;
        }

        public Intent m17779b() {
            return this.f14787b;
        }
    }

    static {
        f14788a = new ConcurrentLinkedQueue();
    }

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    public static void addJob(C4340a c4340a) {
        if (c4340a != null) {
            f14788a.add(c4340a);
        }
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            C4340a c4340a = (C4340a) f14788a.poll();
            if (c4340a != null) {
                try {
                    PushMessageReceiver a = c4340a.m17778a();
                    Intent b = c4340a.m17779b();
                    MiPushCommandMessage miPushCommandMessage;
                    switch (b.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1)) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                            C4341a a2 = C4357m.m17844a((Context) this).m17850a(b);
                            if (a2 == null) {
                                return;
                            }
                            if (a2 instanceof MiPushMessage) {
                                MiPushMessage miPushMessage = (MiPushMessage) a2;
                                if (!miPushMessage.isArrivedMessage()) {
                                    a.onReceiveMessage(this, miPushMessage);
                                }
                                if (miPushMessage.getPassThrough() == 1) {
                                    a.onReceivePassThroughMessage(this, miPushMessage);
                                    return;
                                } else if (miPushMessage.isNotified()) {
                                    a.onNotificationMessageClicked(this, miPushMessage);
                                    return;
                                } else {
                                    a.onNotificationMessageArrived(this, miPushMessage);
                                    return;
                                }
                            } else if (a2 instanceof MiPushCommandMessage) {
                                miPushCommandMessage = (MiPushCommandMessage) a2;
                                a.onCommandResult(this, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                                    a.onReceiveRegisterResult(this, miPushCommandMessage);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                            miPushCommandMessage = (MiPushCommandMessage) b.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                            a.onCommandResult(this, miPushCommandMessage);
                            if (TextUtils.equals(miPushCommandMessage.getCommand(), MiPushClient.COMMAND_REGISTER)) {
                                a.onReceiveRegisterResult(this, miPushCommandMessage);
                                return;
                            }
                            return;
                        case SpdyProtocol.QUIC /*4*/:
                            return;
                        default:
                            return;
                    }
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                }
                C4302b.m17651a(e);
            }
        }
    }
}
