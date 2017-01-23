package com.github.mikephil.charting.p136a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
/* renamed from: com.github.mikephil.charting.a.a */
public class C2522a {
    protected float f8688a;
    protected float f8689b;
    private AnimatorUpdateListener f8690c;

    public C2522a() {
        this.f8688a = 1.0f;
        this.f8689b = 1.0f;
    }

    public C2522a(AnimatorUpdateListener animatorUpdateListener) {
        this.f8688a = 1.0f;
        this.f8689b = 1.0f;
        this.f8690c = animatorUpdateListener;
    }

    public float m9540a() {
        return this.f8688a;
    }

    public void m9541a(int i) {
        if (VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
            ofFloat.setDuration((long) i);
            ofFloat.addUpdateListener(this.f8690c);
            ofFloat.start();
        }
    }

    public float m9542b() {
        return this.f8689b;
    }
}
