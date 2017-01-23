package com.qq.p035e.ads.cfg;

/* renamed from: com.qq.e.ads.cfg.DownAPPConfirmPolicy */
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);
    
    private final int f13408a;

    private DownAPPConfirmPolicy(int i) {
        this.f13408a = i;
    }

    public final int value() {
        return this.f13408a;
    }
}
