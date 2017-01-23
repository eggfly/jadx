package com.facebook.ads.internal.p121f.p132b;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.C0510a;
import android.view.View.MeasureSpec;
import com.facebook.ads.internal.p121f.p132b.C2428e.C2429a;

/* renamed from: com.facebook.ads.internal.f.b.c */
public class C2430c extends C2428e implements C2429a {
    private C2426b f8388c;
    private C2427a f8389d;
    private int f8390e;
    private int f8391f;
    private int f8392g;
    private int f8393h;

    /* renamed from: com.facebook.ads.internal.f.b.c.a */
    public interface C2427a {
        void m9285a(int i, int i2);
    }

    public C2430c(Context context) {
        super(context);
        this.f8390e = -1;
        this.f8391f = -1;
        this.f8392g = 0;
        this.f8393h = 0;
        m9292a();
    }

    private void m9292a() {
        this.f8388c = new C2426b(getContext(), new C2431d(), new C2424a());
        this.f8388c.setOrientation(0);
        setLayoutManager(this.f8388c);
        setSnapDelegate(this);
    }

    private void m9293a(int i, int i2) {
        if (i != this.f8390e || i2 != this.f8391f) {
            this.f8390e = i;
            this.f8391f = i2;
            if (this.f8389d != null) {
                this.f8389d.m9285a(this.f8390e, this.f8391f);
            }
        }
    }

    private int m9294b(int i) {
        int i2 = this.f8393h * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i2;
        int itemCount = getAdapter().getItemCount();
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i4 > i) {
            i3++;
            if (i3 >= itemCount) {
                return i;
            }
            i4 = (int) (((float) (measuredWidth - (i3 * i2))) / (((float) i3) + 0.333f));
        }
        return i4;
    }

    public int m9295a(int i) {
        int abs = Math.abs(i);
        return abs <= this.b ? 0 : this.f8392g == 0 ? 1 : (abs / this.f8392g) + 1;
    }

    protected void m9296a(int i, boolean z) {
        super.m9290a(i, z);
        m9293a(i, 0);
    }

    public int getChildSpacing() {
        return this.f8393h;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int round = Math.round(((float) getMeasuredWidth()) / 1.91f);
        switch (MeasureSpec.getMode(i2)) {
            case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
                round = Math.min(MeasureSpec.getSize(i2), round);
                break;
            case 1073741824:
                round = MeasureSpec.getSize(i2);
                break;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        round = m9294b(round - paddingTop);
        setMeasuredDimension(getMeasuredWidth(), paddingTop + round);
        setChildWidth(round + (this.f8393h * 2));
    }

    public void setAdapter(C0510a c0510a) {
        this.f8388c.m9283a(c0510a == null ? -1 : c0510a.hashCode());
        super.setAdapter(c0510a);
    }

    public void setChildSpacing(int i) {
        this.f8393h = i;
    }

    public void setChildWidth(int i) {
        this.f8392g = i;
        int measuredWidth = getMeasuredWidth();
        this.f8388c.m9284b((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.f8392g) / 2);
        this.f8388c.m9282a(((double) this.f8392g) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i) {
        m9296a(i, false);
    }

    public void setOnPageChangedListener(C2427a c2427a) {
        this.f8389d = c2427a;
    }
}
