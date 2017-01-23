package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.p013a.p014a.C0331a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
import org.android.spdy.TnetStatusCode;

public class aq extends ListView {
    private static final int[] f1831g;
    final Rect f1832a;
    int f1833b;
    int f1834c;
    int f1835d;
    int f1836e;
    protected int f1837f;
    private Field f1838h;
    private C0582a f1839i;

    /* renamed from: android.support.v7.widget.aq.a */
    private static class C0582a extends C0331a {
        private boolean f1884a;

        public C0582a(Drawable drawable) {
            super(drawable);
            this.f1884a = true;
        }

        void m2374a(boolean z) {
            this.f1884a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f1884a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1884a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1884a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.f1884a ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f1884a ? super.setVisible(z, z2) : false;
        }
    }

    static {
        f1831g = new int[]{0};
    }

    public aq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1832a = new Rect();
        this.f1833b = 0;
        this.f1834c = 0;
        this.f1835d = 0;
        this.f1836e = 0;
        try {
            this.f1838h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1838h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m2327a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m2328a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m2333b(i, view);
        if (z2) {
            Rect rect = this.f1832a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m2329a(int i, View view, float f, float f2) {
        m2328a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            DrawableCompat.setHotspot(selector, f, f2);
        }
    }

    protected void m2330a(Canvas canvas) {
        if (!this.f1832a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1832a);
                selector.draw(canvas);
            }
        }
    }

    protected boolean m2331a() {
        return false;
    }

    protected void m2332b() {
        Drawable selector = getSelector();
        if (selector != null && m2334c()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m2333b(int i, View view) {
        Rect rect = this.f1832a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1833b;
        rect.top -= this.f1834c;
        rect.right += this.f1835d;
        rect.bottom += this.f1836e;
        try {
            boolean z = this.f1838h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1838h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m2334c() {
        return m2331a() && isPressed();
    }

    protected void dispatchDraw(Canvas canvas) {
        m2330a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m2332b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f1837f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f1839i = drawable != null ? new C0582a(drawable) : null;
        super.setSelector(this.f1839i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1833b = rect.left;
        this.f1834c = rect.top;
        this.f1835d = rect.right;
        this.f1836e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f1839i != null) {
            this.f1839i.m2374a(z);
        }
    }
}
