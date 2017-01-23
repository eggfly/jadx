package com.qq.p035e.comm.managers.status;

/* renamed from: com.qq.e.comm.managers.status.Carrier */
public enum Carrier {
    UNKNOWN(0),
    CMCC(1),
    UNICOM(2),
    TELECOM(3);
    
    private int f13490a;

    private Carrier(int i) {
        this.f13490a = i;
    }

    public final int getValue() {
        return this.f13490a;
    }
}
