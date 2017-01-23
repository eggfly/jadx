package com.facebook.ads.internal.p121f.p132b;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0493h;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.facebook.ads.internal.f.b.e */
public class C2428e extends RecyclerView implements OnTouchListener {
    protected int f8381a;
    protected int f8382b;
    private int f8383c;
    private boolean f8384d;
    private boolean f8385e;
    private LinearLayoutManager f8386f;
    private C2429a f8387g;

    /* renamed from: com.facebook.ads.internal.f.b.e.a */
    public interface C2429a {
        int m9291a(int i);
    }

    public C2428e(Context context) {
        super(context);
        this.f8381a = 0;
        this.f8383c = 0;
        this.f8384d = true;
        this.f8385e = false;
        m9288a(context);
    }

    private int m9286a(int i) {
        int i2 = this.f8383c - i;
        int a = this.f8387g.m9291a(i2);
        return i2 > this.f8382b ? m9287a(this.f8381a, a) : i2 < (-this.f8382b) ? m9289b(this.f8381a, a) : this.f8381a;
    }

    private int m9287a(int i, int i2) {
        return Math.min(i + i2, getItemCount() - 1);
    }

    private void m9288a(Context context) {
        setOnTouchListener(this);
        this.f8382b = ((int) context.getResources().getDisplayMetrics().density) * 10;
    }

    private int m9289b(int i, int i2) {
        return Math.max(i - i2, 0);
    }

    private int getItemCount() {
        return getAdapter() == null ? 0 : getAdapter().getItemCount();
    }

    protected void m9290a(int i, boolean z) {
        if (getAdapter() != null) {
            this.f8381a = i;
            if (z) {
                smoothScrollToPosition(i);
            } else {
                scrollToPosition(i);
            }
        }
    }

    public int getCurrentPosition() {
        return this.f8381a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.f8385e) {
                m9290a(m9286a(rawX), true);
            }
            this.f8384d = true;
            this.f8385e = false;
            return true;
        } else if (actionMasked != 0 && actionMasked != 5 && (!this.f8384d || actionMasked != 2)) {
            return false;
        } else {
            this.f8383c = rawX;
            if (this.f8384d) {
                this.f8384d = false;
            }
            this.f8385e = true;
            return false;
        }
    }

    public void setLayoutManager(C0493h c0493h) {
        if (c0493h instanceof LinearLayoutManager) {
            super.setLayoutManager(c0493h);
            this.f8386f = (LinearLayoutManager) c0493h;
            return;
        }
        throw new IllegalArgumentException("SnapRecyclerView only supports LinearLayoutManager");
    }

    public void setSnapDelegate(C2429a c2429a) {
        this.f8387g = c2429a;
    }
}
