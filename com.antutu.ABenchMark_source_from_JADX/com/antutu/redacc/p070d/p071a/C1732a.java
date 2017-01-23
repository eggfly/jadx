package com.antutu.redacc.p070d.p071a;

import android.animation.Animator;

/* renamed from: com.antutu.redacc.d.a.a */
public class C1732a {
    public static Animator[] m6694a(Animator[] animatorArr, Animator animator) {
        int i = 0;
        Animator[] animatorArr2 = new Animator[(animatorArr.length + 1)];
        int length = animatorArr.length;
        int i2 = 0;
        while (i < length) {
            animatorArr2[i2] = animatorArr[i];
            i2++;
            i++;
        }
        animatorArr2[animatorArr2.length - 1] = animator;
        return animatorArr2;
    }
}
