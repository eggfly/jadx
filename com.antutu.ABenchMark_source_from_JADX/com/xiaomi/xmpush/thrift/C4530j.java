package com.xiaomi.xmpush.thrift;

import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.xiaomi.xmpush.thrift.j */
public enum C4530j {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    
    private final int f15855d;

    private C4530j(int i) {
        this.f15855d = i;
    }

    public static C4530j m18898a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return RegIdExpired;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return PackageUnregistered;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return Init;
            default:
                return null;
        }
    }

    public int m18899a() {
        return this.f15855d;
    }
}
