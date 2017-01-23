package com.xiaomi.xmpush.thrift;

import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.xmpush.thrift.a */
public enum C4513a {
    Registration(1),
    UnRegistration(2),
    Subscription(3),
    UnSubscription(4),
    SendMessage(5),
    AckMessage(6),
    SetConfig(7),
    ReportFeedback(8),
    Notification(9),
    Command(10),
    MultiConnectionBroadcast(11),
    MultiConnectionResult(12);
    
    private final int f15523m;

    private C4513a(int i) {
        this.f15523m = i;
    }

    public static C4513a m18716a(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return Registration;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return UnRegistration;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return Subscription;
            case SpdyProtocol.QUIC /*4*/:
                return UnSubscription;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return SendMessage;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return AckMessage;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return SetConfig;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return ReportFeedback;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return Notification;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return Command;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return MultiConnectionBroadcast;
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return MultiConnectionResult;
            default:
                return null;
        }
    }

    public int m18717a() {
        return this.f15523m;
    }
}
