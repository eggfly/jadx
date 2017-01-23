package com.antutu.redacc.p070d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0512c;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.View;
import android.view.ViewGroup;
import com.antutu.redacc.p070d.p071a.C1732a;
import com.antutu.redacc.p070d.p071a.C1733b;

/* renamed from: com.antutu.redacc.d.a */
public abstract class C1734a<T extends C0532u> extends C0510a<T> {
    static final /* synthetic */ boolean f6149b;
    protected RecyclerView f6150a;
    private C0510a<T> f6151c;
    private C1733b f6152d;

    static {
        f6149b = !C1734a.class.desiredAssertionStatus();
    }

    public C1734a(C0510a<T> c0510a, RecyclerView recyclerView) {
        this.f6151c = c0510a;
        this.f6152d = new C1733b(recyclerView);
        this.f6150a = recyclerView;
    }

    private void m6699a(View view, int i) {
        if (!f6149b && this.f6152d == null) {
            throw new AssertionError();
        } else if (f6149b || this.f6150a != null) {
            this.f6152d.m6697a(i, view, C1732a.m6694a(m6700a(view), ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f})));
        } else {
            throw new AssertionError();
        }
    }

    public abstract Animator[] m6700a(View view);

    public int getItemCount() {
        return this.f6151c.getItemCount();
    }

    public long getItemId(int i) {
        return this.f6151c.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f6151c.getItemViewType(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f6151c.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(T t, int i) {
        this.f6151c.onBindViewHolder(t, i);
        this.f6152d.m6698a(t.itemView);
        m6699a(t.itemView, i);
    }

    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f6151c.onCreateViewHolder(viewGroup, i);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f6151c.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(T t) {
        return this.f6151c.onFailedToRecycleView(t);
    }

    public void onViewAttachedToWindow(T t) {
        this.f6151c.onViewAttachedToWindow(t);
    }

    public void onViewDetachedFromWindow(T t) {
        this.f6151c.onViewDetachedFromWindow(t);
    }

    public void onViewRecycled(T t) {
        this.f6151c.onViewRecycled(t);
    }

    public void registerAdapterDataObserver(C0512c c0512c) {
        super.registerAdapterDataObserver(c0512c);
        this.f6151c.registerAdapterDataObserver(c0512c);
    }

    public void setHasStableIds(boolean z) {
        this.f6151c.setHasStableIds(z);
    }

    public void unregisterAdapterDataObserver(C0512c c0512c) {
        super.unregisterAdapterDataObserver(c0512c);
        this.f6151c.unregisterAdapterDataObserver(c0512c);
    }
}
