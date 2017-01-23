package com.antutu.benchmark.p036a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView.C0510a;
import android.view.View;

/* renamed from: com.antutu.benchmark.a.a */
public class C1091a extends C1090b {
    private final float f3672a;

    public C1091a(C0510a c0510a) {
        this(c0510a, 0.0f);
    }

    public C1091a(C0510a c0510a, float f) {
        super(c0510a);
        this.f3672a = f;
    }

    protected Animator[] m4841a(View view) {
        Animator[] animatorArr = new Animator[1];
        animatorArr[0] = ObjectAnimator.ofFloat(view, "alpha", new float[]{this.f3672a, 1.0f});
        return animatorArr;
    }
}
