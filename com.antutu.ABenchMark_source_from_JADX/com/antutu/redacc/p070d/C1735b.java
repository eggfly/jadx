package com.antutu.redacc.p070d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;

/* renamed from: com.antutu.redacc.d.b */
public class C1735b<T extends C0532u> extends C1734a<T> {
    public C1735b(C0510a<T> c0510a, RecyclerView recyclerView) {
        super(c0510a, recyclerView);
    }

    public Animator[] m6701a(View view) {
        Animator[] animatorArr = new Animator[1];
        animatorArr[0] = ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) this.a.getLayoutManager().getWidth(), 0.0f});
        return animatorArr;
    }
}
