package com.xiaomi.xmpush.thrift;

import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.xmpush.thrift.c */
public enum C4519c {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    
    private final int f15698c;

    private C4519c(int i) {
        this.f15698c = i;
    }

    public static C4519c m18795a(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return MISC_CONFIG;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return PLUGIN_CONFIG;
            default:
                return null;
        }
    }

    public int m18796a() {
        return this.f15698c;
    }
}
