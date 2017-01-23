package com.antutu.benchmark.p037f;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0523l;
import android.support.v7.widget.StaggeredGridLayoutManager;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.f.b */
public class C1244b extends C0523l {
    private String f4220a;
    protected C1499a f4221b;
    private int[] f4222c;
    private int f4223d;
    private boolean f4224e;
    private int f4225f;

    /* renamed from: com.antutu.benchmark.f.b.1 */
    static /* synthetic */ class C14981 {
        static final /* synthetic */ int[] f5107a;

        static {
            f5107a = new int[C1499a.values().length];
            try {
                f5107a[C1499a.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5107a[C1499a.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5107a[C1499a.STAGGERED_GRID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.antutu.benchmark.f.b.a */
    public enum C1499a {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    public C1244b() {
        this.f4220a = getClass().getSimpleName();
        this.f4224e = false;
        this.f4225f = 0;
    }

    private int m5082a(int[] iArr) {
        int i = iArr[0];
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            if (i3 <= i) {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    public void m5083a() {
    }

    public void m5084a(RecyclerView recyclerView, int i) {
        super.m1846a(recyclerView, i);
        this.f4225f = i;
        C0493h layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        if (childCount > 0 && this.f4225f == 0 && this.f4223d >= itemCount - 1) {
            m5083a();
        }
    }

    public void m5085a(RecyclerView recyclerView, int i, int i2) {
        super.m1847a(recyclerView, i, i2);
        C0493h layoutManager = recyclerView.getLayoutManager();
        if (this.f4221b == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.f4221b = C1499a.LINEAR;
            } else if (layoutManager instanceof GridLayoutManager) {
                this.f4221b = C1499a.GRID;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                this.f4221b = C1499a.STAGGERED_GRID;
            } else {
                throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
            }
        }
        switch (C14981.f5107a[this.f4221b.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f4223d = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f4223d = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (this.f4222c == null) {
                    this.f4222c = new int[staggeredGridLayoutManager.m2077b()];
                }
                staggeredGridLayoutManager.m2076a(this.f4222c);
                this.f4223d = m5082a(this.f4222c);
            default:
        }
    }
}
