package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f798a;
    private TypedValue f799b;
    private TypedValue f800c;
    private TypedValue f801d;
    private TypedValue f802e;
    private TypedValue f803f;
    private final Rect f804g;
    private C0336a f805h;

    /* renamed from: android.support.v7.widget.ContentFrameLayout.a */
    public interface C0336a {
        void m835a();

        void m836b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f804g = new Rect();
    }

    public void m859a(int i, int i2, int i3, int i4) {
        this.f804g.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    public void m860a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f802e == null) {
            this.f802e = new TypedValue();
        }
        return this.f802e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f803f == null) {
            this.f803f = new TypedValue();
        }
        return this.f803f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f800c == null) {
            this.f800c = new TypedValue();
        }
        return this.f800c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f801d == null) {
            this.f801d = new TypedValue();
        }
        return this.f801d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f798a == null) {
            this.f798a = new TypedValue();
        }
        return this.f798a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f799b == null) {
            this.f799b = new TypedValue();
        }
        return this.f799b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f805h != null) {
            this.f805h.m835a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f805h != null) {
            this.f805h.m836b();
        }
    }

    protected void onMeasure(int i, int i2) {
        TypedValue typedValue;
        int dimension;
        Object obj;
        TypedValue typedValue2;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            typedValue = obj3 != null ? this.f801d : this.f800c;
            if (!(typedValue == null || typedValue.type == 0)) {
                dimension = typedValue.type == 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type == 6 ? (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f804g.left + this.f804g.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == LinearLayoutManager.INVALID_OFFSET) {
                        typedValue = obj3 == null ? this.f802e : this.f803f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            dimension = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type != 6 ? (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels) : 0;
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f804g.top + this.f804g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == LinearLayoutManager.INVALID_OFFSET) {
                        typedValue2 = obj3 == null ? this.f799b : this.f798a;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            dimension2 = typedValue2.type != 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type != 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.f804g.left + this.f804g.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == LinearLayoutManager.INVALID_OFFSET) {
            if (obj3 == null) {
            }
            if (typedValue.type != 5) {
                if (typedValue.type != 6) {
                }
            }
            if (dimension > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f804g.top + this.f804g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue2.type != 5) {
            if (typedValue2.type != 6) {
            }
        }
        if (dimension2 > 0) {
            dimension2 -= this.f804g.left + this.f804g.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public void setAttachListener(C0336a c0336a) {
        this.f805h = c0336a;
    }
}
