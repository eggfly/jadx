package com.baidu.mobads.production.p101c;

import android.os.CountDownTimer;

/* renamed from: com.baidu.mobads.production.c.e */
class C2041e extends CountDownTimer {
    final /* synthetic */ C2038b f7137a;

    C2041e(C2038b c2038b, long j, long j2) {
        this.f7137a = c2038b;
        super(j, j2);
    }

    public void onFinish() {
        this.f7137a.f7132x.m7392d("CountDownTimer finished");
        this.f7137a.m7687p();
        this.f7137a.h.stop();
    }

    public void onTick(long j) {
        int i = 5;
        int i2 = (int) (j / 1000);
        if (i2 <= 5) {
            i = i2;
        }
        this.f7137a.f7134z.setText(String.valueOf(i));
    }
}
