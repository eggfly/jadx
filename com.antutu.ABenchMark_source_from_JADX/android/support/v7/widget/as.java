package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.view.View;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public abstract class as {
    protected final C0493h f1886a;
    private int f1887b;

    /* renamed from: android.support.v7.widget.as.1 */
    static class C05841 extends as {
        C05841(C0493h c0493h) {
            super(null);
        }

        public int m2400a(View view) {
            return this.a.getDecoratedLeft(view) - ((C0491i) view.getLayoutParams()).leftMargin;
        }

        public void m2401a(int i) {
            this.a.offsetChildrenHorizontal(i);
        }

        public int m2402b(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.rightMargin + this.a.getDecoratedRight(view);
        }

        public int m2403c() {
            return this.a.getPaddingLeft();
        }

        public int m2404c(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.rightMargin + (this.a.getDecoratedMeasuredWidth(view) + c0491i.leftMargin);
        }

        public int m2405d() {
            return this.a.getWidth() - this.a.getPaddingRight();
        }

        public int m2406d(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.bottomMargin + (this.a.getDecoratedMeasuredHeight(view) + c0491i.topMargin);
        }

        public int m2407e() {
            return this.a.getWidth();
        }

        public int m2408f() {
            return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        }

        public int m2409g() {
            return this.a.getPaddingRight();
        }

        public int m2410h() {
            return this.a.getWidthMode();
        }

        public int m2411i() {
            return this.a.getHeightMode();
        }
    }

    /* renamed from: android.support.v7.widget.as.2 */
    static class C05852 extends as {
        C05852(C0493h c0493h) {
            super(null);
        }

        public int m2412a(View view) {
            return this.a.getDecoratedTop(view) - ((C0491i) view.getLayoutParams()).topMargin;
        }

        public void m2413a(int i) {
            this.a.offsetChildrenVertical(i);
        }

        public int m2414b(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.bottomMargin + this.a.getDecoratedBottom(view);
        }

        public int m2415c() {
            return this.a.getPaddingTop();
        }

        public int m2416c(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.bottomMargin + (this.a.getDecoratedMeasuredHeight(view) + c0491i.topMargin);
        }

        public int m2417d() {
            return this.a.getHeight() - this.a.getPaddingBottom();
        }

        public int m2418d(View view) {
            C0491i c0491i = (C0491i) view.getLayoutParams();
            return c0491i.rightMargin + (this.a.getDecoratedMeasuredWidth(view) + c0491i.leftMargin);
        }

        public int m2419e() {
            return this.a.getHeight();
        }

        public int m2420f() {
            return (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
        }

        public int m2421g() {
            return this.a.getPaddingBottom();
        }

        public int m2422h() {
            return this.a.getHeightMode();
        }

        public int m2423i() {
            return this.a.getWidthMode();
        }
    }

    private as(C0493h c0493h) {
        this.f1887b = LinearLayoutManager.INVALID_OFFSET;
        this.f1886a = c0493h;
    }

    public static as m2383a(C0493h c0493h) {
        return new C05841(c0493h);
    }

    public static as m2384a(C0493h c0493h, int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return m2383a(c0493h);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return m2385b(c0493h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static as m2385b(C0493h c0493h) {
        return new C05852(c0493h);
    }

    public abstract int m2386a(View view);

    public void m2387a() {
        this.f1887b = m2396f();
    }

    public abstract void m2388a(int i);

    public int m2389b() {
        return LinearLayoutManager.INVALID_OFFSET == this.f1887b ? 0 : m2396f() - this.f1887b;
    }

    public abstract int m2390b(View view);

    public abstract int m2391c();

    public abstract int m2392c(View view);

    public abstract int m2393d();

    public abstract int m2394d(View view);

    public abstract int m2395e();

    public abstract int m2396f();

    public abstract int m2397g();

    public abstract int m2398h();

    public abstract int m2399i();
}
