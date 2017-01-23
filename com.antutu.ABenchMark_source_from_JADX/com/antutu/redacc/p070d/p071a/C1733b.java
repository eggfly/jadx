package com.antutu.redacc.p070d.p071a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.taobao.accs.ErrorCode;

/* renamed from: com.antutu.redacc.d.a.b */
public class C1733b {
    private final RecyclerView f6140a;
    private final SparseArray<Animator> f6141b;
    private int f6142c;
    private int f6143d;
    private int f6144e;
    private long f6145f;
    private int f6146g;
    private int f6147h;
    private boolean f6148i;

    public C1733b(RecyclerView recyclerView) {
        this.f6141b = new SparseArray();
        this.f6142c = 150;
        this.f6143d = 100;
        this.f6144e = ErrorCode.APP_NOT_BIND;
        this.f6148i = true;
        this.f6140a = recyclerView;
        this.f6145f = -1;
        this.f6146g = -1;
        this.f6147h = -1;
    }

    @SuppressLint({"NewApi"})
    private int m6695a(int i) {
        int a;
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) this.f6140a.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) this.f6140a.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        if (this.f6147h > findLastCompletelyVisibleItemPosition) {
            findLastCompletelyVisibleItemPosition = this.f6147h;
        }
        if ((findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1 < (i - 1) - this.f6146g) {
            int i2 = this.f6143d;
            if (this.f6140a.getLayoutManager() instanceof GridLayoutManager) {
                a = ((i % ((GridLayoutManager) this.f6140a.getLayoutManager()).m1724a()) * this.f6143d) + i2;
                Log.d("GAB", "Delay[" + i + "]=*" + findLastCompletelyVisibleItemPosition + "|" + findFirstCompletelyVisibleItemPosition + "|");
            } else {
                a = i2;
            }
        } else {
            a = Math.max(0, (int) ((((-SystemClock.uptimeMillis()) + this.f6145f) + ((long) this.f6142c)) + ((long) ((i - this.f6146g) * this.f6143d))));
        }
        Log.d("GAB", "Delay[" + i + "]=" + a + "|" + findLastCompletelyVisibleItemPosition + "|" + findFirstCompletelyVisibleItemPosition + "|");
        return a;
    }

    private void m6696b(int i, View view, Animator[] animatorArr) {
        if (this.f6145f == -1) {
            this.f6145f = SystemClock.uptimeMillis();
        }
        ViewCompat.setAlpha(view, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorArr);
        animatorSet.setStartDelay((long) m6695a(i));
        animatorSet.setDuration((long) this.f6144e);
        animatorSet.start();
        this.f6141b.put(view.hashCode(), animatorSet);
    }

    public void m6697a(int i, View view, Animator[] animatorArr) {
        if (this.f6148i && i > this.f6147h) {
            if (this.f6146g == -1) {
                this.f6146g = i;
            }
            m6696b(i, view, animatorArr);
            this.f6147h = i;
        }
    }

    public void m6698a(View view) {
        int hashCode = view.hashCode();
        Animator animator = (Animator) this.f6141b.get(hashCode);
        if (animator != null) {
            animator.end();
            this.f6141b.remove(hashCode);
        }
    }
}
