package com.qq.p035e.comm.managers.status;

/* renamed from: com.qq.e.comm.managers.status.NetworkType */
public enum NetworkType {
    UNKNOWN(0, 1),
    WIFI(1, 2),
    NET_2G(2, 4),
    NET_3G(3, 8),
    NET_4G(4, 16);
    
    private int f13508a;
    private int f13509b;

    private NetworkType(int i, int i2) {
        this.f13508a = i;
        this.f13509b = i2;
    }

    public final int getConnValue() {
        return this.f13508a;
    }

    public final int getPermValue() {
        return this.f13509b;
    }
}
