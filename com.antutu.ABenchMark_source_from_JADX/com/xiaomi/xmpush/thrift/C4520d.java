package com.xiaomi.xmpush.thrift;

import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.xmpush.thrift.d */
public enum C4520d {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    
    private final int f15704e;

    private C4520d(int i) {
        this.f15704e = i;
    }

    public static C4520d m18797a(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return INT;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return LONG;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return STRING;
            case SpdyProtocol.QUIC /*4*/:
                return BOOLEAN;
            default:
                return null;
        }
    }
}
