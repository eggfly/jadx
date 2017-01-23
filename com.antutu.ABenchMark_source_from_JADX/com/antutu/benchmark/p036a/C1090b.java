package com.antutu.benchmark.p036a;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0512c;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.antutu.utils.ViewHelper;
import com.taobao.accs.ErrorCode;

/* renamed from: com.antutu.benchmark.a.b */
public abstract class C1090b extends C0510a<C0532u> {
    private C0510a<C0532u> f3667a;
    private int f3668b;
    private Interpolator f3669c;
    private int f3670d;
    private boolean f3671e;

    public C1090b(C0510a<C0532u> c0510a) {
        this.f3668b = ErrorCode.APP_NOT_BIND;
        this.f3669c = new LinearInterpolator();
        this.f3670d = -1;
        this.f3671e = true;
        this.f3667a = c0510a;
    }

    protected abstract Animator[] m4840a(View view);

    public int getItemCount() {
        return this.f3667a.getItemCount();
    }

    public long getItemId(int i) {
        return this.f3667a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f3667a.getItemViewType(i);
    }

    public void onBindViewHolder(C0532u c0532u, int i) {
        this.f3667a.onBindViewHolder(c0532u, i);
        int adapterPosition = c0532u.getAdapterPosition();
        if (!this.f3671e || adapterPosition > this.f3670d) {
            for (Animator animator : m4840a(c0532u.itemView)) {
                animator.setDuration((long) this.f3668b).start();
                animator.setInterpolator(this.f3669c);
            }
            this.f3670d = adapterPosition;
            return;
        }
        ViewHelper.clear(c0532u.itemView);
    }

    public C0532u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f3667a.onCreateViewHolder(viewGroup, i);
    }

    public void onViewRecycled(C0532u c0532u) {
        this.f3667a.onViewRecycled(c0532u);
        super.onViewRecycled(c0532u);
    }

    public void registerAdapterDataObserver(C0512c c0512c) {
        super.registerAdapterDataObserver(c0512c);
        this.f3667a.registerAdapterDataObserver(c0512c);
    }

    public void unregisterAdapterDataObserver(C0512c c0512c) {
        super.unregisterAdapterDataObserver(c0512c);
        this.f3667a.unregisterAdapterDataObserver(c0512c);
    }
}
