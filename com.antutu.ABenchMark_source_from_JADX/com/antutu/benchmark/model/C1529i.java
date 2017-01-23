package com.antutu.benchmark.model;

import com.antutu.utils.MLog;

/* renamed from: com.antutu.benchmark.model.i */
public class C1529i extends C1520b implements C1519k {
    private int f5297b;

    public C1529i() {
        this.f5297b = -1;
    }

    public int m6073a() {
        return this.f5297b;
    }

    public C1519k m6074a(String str) {
        MLog.m6865d("FeedbackModel", "hzd, " + str);
        try {
            this.f5297b = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return this;
    }
}
