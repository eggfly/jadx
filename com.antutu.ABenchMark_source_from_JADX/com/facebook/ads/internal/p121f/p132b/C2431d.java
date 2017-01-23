package com.facebook.ads.internal.p121f.p132b;

import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0525n;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.facebook.ads.internal.f.b.d */
public class C2431d {
    public int[] m9297a(C0525n c0525n, int i, int i2, int i3) {
        View c = c0525n.m1877c(i);
        int[] a = m9298a(c, i2, i3);
        c0525n.m1868a(c);
        return a;
    }

    public int[] m9298a(View view, int i, int i2) {
        C0491i c0491i = (C0491i) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), c0491i.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), c0491i.height));
        int[] iArr = new int[2];
        iArr[0] = (view.getMeasuredWidth() + c0491i.leftMargin) + c0491i.rightMargin;
        iArr[1] = c0491i.topMargin + (view.getMeasuredHeight() + c0491i.bottomMargin);
        return iArr;
    }
}
