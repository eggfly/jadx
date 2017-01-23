package com.antutu.benchmark.p036a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView.C0510a;
import android.view.View;

/* renamed from: com.antutu.benchmark.a.s */
public class C1172s extends C1090b {
    public C1172s(C0510a c0510a) {
        super(c0510a);
    }

    protected Animator[] m4935a(View view) {
        Animator[] animatorArr = new Animator[1];
        animatorArr[0] = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) view.getMeasuredHeight(), 0.0f});
        return animatorArr;
    }
}
