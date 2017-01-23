package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.antutu.redacc.C1692R;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

public class an extends ViewGroup {
    private boolean f1398a;
    private int f1399b;
    private int f1400c;
    private int f1401d;
    private int f1402e;
    private int f1403f;
    private float f1404g;
    private boolean f1405h;
    private int[] f1406i;
    private int[] f1407j;
    private Drawable f1408k;
    private int f1409l;
    private int f1410m;
    private int f1411n;
    private int f1412o;

    /* renamed from: android.support.v7.widget.an.a */
    public static class C0482a extends MarginLayoutParams {
        public float f1389g;
        public int f1390h;

        public C0482a(int i, int i2) {
            super(i, i2);
            this.f1390h = -1;
            this.f1389g = 0.0f;
        }

        public C0482a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1390h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.LinearLayoutCompat_Layout);
            this.f1389g = obtainStyledAttributes.getFloat(C0417R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1390h = obtainStyledAttributes.getInt(C0417R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0482a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1390h = -1;
        }
    }

    public an(Context context) {
        this(context, null);
    }

    public an(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1398a = true;
        this.f1399b = -1;
        this.f1400c = 0;
        this.f1402e = 8388659;
        bh a = bh.m2502a(context, attributeSet, C0417R.styleable.LinearLayoutCompat, i, 0);
        int a2 = a.m2504a(C0417R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m2504a(C0417R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m2507a(C0417R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f1404g = a.m2503a(C0417R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1399b = a.m2504a(C0417R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1405h = a.m2507a(C0417R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m2505a(C0417R.styleable.LinearLayoutCompat_divider));
        this.f1411n = a.m2504a(C0417R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f1412o = a.m2514e(C0417R.styleable.LinearLayoutCompat_dividerPadding, 0);
        a.m2506a();
    }

    private void m1604a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void m1605c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1617b(i3);
            if (b.getVisibility() != 8) {
                C0482a c0482a = (C0482a) b.getLayoutParams();
                if (c0482a.width == -1) {
                    int i4 = c0482a.height;
                    c0482a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0482a.height = i4;
                }
            }
        }
    }

    private void m1606d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m1617b(i3);
            if (b.getVisibility() != 8) {
                C0482a c0482a = (C0482a) b.getLayoutParams();
                if (c0482a.height == -1) {
                    int i4 = c0482a.width;
                    c0482a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0482a.width = i4;
                }
            }
        }
    }

    int m1607a(View view) {
        return 0;
    }

    int m1608a(View view, int i) {
        return 0;
    }

    void m1609a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        View b;
        this.f1403f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i9 = this.f1399b;
        boolean z = this.f1405h;
        int i10 = LinearLayoutManager.INVALID_OFFSET;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            int i12;
            int i13;
            View b2 = m1617b(i11);
            if (b2 == null) {
                this.f1403f += m1623d(i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += m1608a(b2, i11);
                i3 = i10;
                obj5 = obj4;
                obj = obj2;
                i12 = i6;
                i13 = i5;
            } else {
                if (m1622c(i11)) {
                    this.f1403f += this.f1410m;
                }
                C0482a c0482a = (C0482a) b2.getLayoutParams();
                float f2 = f + c0482a.f1389g;
                if (mode2 == 1073741824 && c0482a.height == 0 && c0482a.f1389g > 0.0f) {
                    i3 = this.f1403f;
                    this.f1403f = Math.max(i3, (c0482a.topMargin + i3) + c0482a.bottomMargin);
                    obj4 = 1;
                } else {
                    i3 = LinearLayoutManager.INVALID_OFFSET;
                    if (c0482a.height == 0 && c0482a.f1389g > 0.0f) {
                        i3 = 0;
                        c0482a.height = -2;
                    }
                    int i14 = i3;
                    m1613a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f1403f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0482a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f1403f;
                    this.f1403f = Math.max(i15, (((i15 + i3) + c0482a.topMargin) + c0482a.bottomMargin) + m1614b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.f1400c = this.f1403f;
                }
                if (i11 >= i9 || c0482a.f1389g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0482a.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = c0482a.rightMargin + c0482a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = bl.m2589a(i6, ViewCompat.getMeasuredState(b2));
                    obj = (obj2 == null || c0482a.width != -1) ? null : 1;
                    if (c0482a.f1389g > 0.0f) {
                        i3 = Math.max(i8, obj7 != null ? i12 : i13);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += m1608a(b2, i11);
                    obj5 = obj4;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj4 = obj5;
            obj2 = obj;
            i6 = i12;
            i5 = i13;
        }
        if (this.f1403f > 0 && m1622c(virtualChildCount)) {
            this.f1403f += this.f1410m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1403f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = m1617b(i4);
                if (b == null) {
                    this.f1403f += m1623d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = m1608a(b, i4) + i4;
                } else {
                    C0482a c0482a2 = (C0482a) b.getLayoutParams();
                    int i16 = this.f1403f;
                    this.f1403f = Math.max(i16, (c0482a2.bottomMargin + ((i16 + i10) + c0482a2.topMargin)) + m1614b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f1403f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f1403f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (ViewCompat.MEASURED_SIZE_MASK & resolveSizeAndState) - this.f1403f;
        int i17;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1404g > 0.0f) {
                f = this.f1404g;
            }
            this.f1403f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = m1617b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    c0482a2 = (C0482a) b3.getLayoutParams();
                    float f6 = c0482a2.f1389g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0482a2.leftMargin) + c0482a2.rightMargin, c0482a2.width);
                        if (c0482a2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = bl.m2589a(i16, ViewCompat.getMeasuredState(b3) & InputDeviceCompat.SOURCE_ANY);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = c0482a2.leftMargin + c0482a2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || c0482a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj = (obj8 == null || c0482a2.width != -1) ? null : 1;
                    i13 = this.f1403f;
                    this.f1403f = Math.max(i13, (c0482a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0482a2.topMargin)) + m1614b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj;
                i16 = i4;
            }
            this.f1403f += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = m1617b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((C0482a) b.getLayoutParams()).f1389g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), resolveSizeAndState);
        if (obj3 != null) {
            m1605c(virtualChildCount, i2);
        }
    }

    void m1610a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f1402e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (this.f1402e & 112) {
            case SpdyProtocol.CUSTOM /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.f1403f) / 2);
                break;
            case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f1403f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m1617b(i7);
            if (b == null) {
                i8 += m1623d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0482a c0482a = (C0482a) b.getLayoutParams();
                i5 = c0482a.f1390h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (GravityCompat.getAbsoluteGravity(i5, ViewCompat.getLayoutDirection(this)) & 7) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0482a.leftMargin) - c0482a.rightMargin;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        i9 = (paddingRight - measuredWidth) - c0482a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0482a.leftMargin;
                        break;
                }
                int i10 = (m1622c(i7) ? this.f1410m + i8 : i8) + c0482a.topMargin;
                m1604a(b, i9, i10 + m1607a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0482a.bottomMargin + measuredHeight) + m1614b(b));
                i5 = m1608a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m1611a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m1617b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1622c(i))) {
                m1612a(canvas, (b.getTop() - ((C0482a) b.getLayoutParams()).topMargin) - this.f1410m);
            }
            i++;
        }
        if (m1622c(virtualChildCount)) {
            int height;
            View b2 = m1617b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f1410m;
            } else {
                C0482a c0482a = (C0482a) b2.getLayoutParams();
                height = c0482a.bottomMargin + b2.getBottom();
            }
            m1612a(canvas, height);
        }
    }

    void m1612a(Canvas canvas, int i) {
        this.f1408k.setBounds(getPaddingLeft() + this.f1412o, i, (getWidth() - getPaddingRight()) - this.f1412o, this.f1410m + i);
        this.f1408k.draw(canvas);
    }

    void m1613a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m1614b(View view) {
        return 0;
    }

    public C0482a m1615b(AttributeSet attributeSet) {
        return new C0482a(getContext(), attributeSet);
    }

    protected C0482a m1616b(LayoutParams layoutParams) {
        return new C0482a(layoutParams);
    }

    View m1617b(int i) {
        return getChildAt(i);
    }

    void m1618b(int i, int i2) {
        int i3;
        int i4;
        C0482a c0482a;
        this.f1403f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.f1406i == null || this.f1407j == null) {
            this.f1406i = new int[4];
            this.f1407j = new int[4];
        }
        int[] iArr = this.f1406i;
        int[] iArr2 = this.f1407j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f1398a;
        boolean z2 = this.f1405h;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i9 = LinearLayoutManager.INVALID_OFFSET;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i11;
            int i12;
            View b = m1617b(i10);
            if (b == null) {
                this.f1403f += m1623d(i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m1608a(b, i10);
                i3 = i9;
                obj5 = obj3;
                obj6 = obj;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m1622c(i10)) {
                    this.f1403f += this.f1409l;
                }
                C0482a c0482a2 = (C0482a) b.getLayoutParams();
                float f2 = f + c0482a2.f1389g;
                if (mode == 1073741824 && c0482a2.width == 0 && c0482a2.f1389g > 0.0f) {
                    if (obj4 != null) {
                        this.f1403f += c0482a2.leftMargin + c0482a2.rightMargin;
                    } else {
                        i3 = this.f1403f;
                        this.f1403f = Math.max(i3, (c0482a2.leftMargin + i3) + c0482a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj3 = 1;
                    }
                } else {
                    i3 = LinearLayoutManager.INVALID_OFFSET;
                    if (c0482a2.width == 0 && c0482a2.f1389g > 0.0f) {
                        i3 = 0;
                        c0482a2.width = -2;
                    }
                    int i13 = i3;
                    m1613a(b, i10, i, f2 == 0.0f ? this.f1403f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0482a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj4 != null) {
                        this.f1403f += ((c0482a2.leftMargin + i3) + c0482a2.rightMargin) + m1614b(b);
                    } else {
                        int i14 = this.f1403f;
                        this.f1403f = Math.max(i14, (((i14 + i3) + c0482a2.leftMargin) + c0482a2.rightMargin) + m1614b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0482a2.height != -1) {
                    obj7 = obj2;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = c0482a2.bottomMargin + c0482a2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = bl.m2589a(i6, ViewCompat.getMeasuredState(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((c0482a2.f1390h < 0 ? this.f1402e : c0482a2.f1390h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj == null || c0482a2.height != -1) ? null : 1;
                if (c0482a2.f1389g > 0.0f) {
                    i3 = Math.max(i8, obj8 != null ? i11 : i12);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m1608a(b, i10);
                obj5 = obj3;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj2 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj3 = obj5;
            obj = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f1403f > 0 && m1622c(virtualChildCount)) {
            this.f1403f += this.f1409l;
        }
        i10 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i5 : Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1403f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m1617b(i4);
                if (b2 == null) {
                    this.f1403f += m1623d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m1608a(b2, i4) + i4;
                } else {
                    c0482a = (C0482a) b2.getLayoutParams();
                    if (obj4 != null) {
                        this.f1403f = ((c0482a.rightMargin + (c0482a.leftMargin + i9)) + m1614b(b2)) + this.f1403f;
                        i3 = i4;
                    } else {
                        i11 = this.f1403f;
                        this.f1403f = Math.max(i11, (c0482a.rightMargin + ((i11 + i9) + c0482a.leftMargin)) + m1614b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f1403f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = ViewCompat.resolveSizeAndState(Math.max(this.f1403f, getSuggestedMinimumWidth()), i, 0);
        i4 = (ViewCompat.MEASURED_SIZE_MASK & resolveSizeAndState) - this.f1403f;
        int i16;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1404g > 0.0f) {
                f = this.f1404g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1403f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m1617b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0482a = (C0482a) b3.getLayoutParams();
                    float f6 = c0482a.f1389g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0482a.topMargin) + c0482a.bottomMargin, c0482a.height);
                        if (c0482a.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = bl.m2589a(i15, ViewCompat.getMeasuredState(b3) & SystemBarTintManager.DEFAULT_TINT_COLOR);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj4 != null) {
                        this.f1403f += ((b3.getMeasuredWidth() + c0482a.leftMargin) + c0482a.rightMargin) + m1614b(b3);
                    } else {
                        i4 = this.f1403f;
                        this.f1403f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + c0482a.leftMargin) + c0482a.rightMargin) + m1614b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || c0482a.height != -1) ? null : 1;
                    i10 = c0482a.topMargin + c0482a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    i10 = Math.max(i16, obj5 != null ? i10 : i14);
                    obj5 = (obj9 == null || c0482a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0482a.f1390h < 0 ? this.f1402e : c0482a.f1390h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj5;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f1403f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m1617b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0482a) b4.getLayoutParams()).f1389g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((SystemBarTintManager.DEFAULT_TINT_COLOR & i6) | resolveSizeAndState, ViewCompat.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj2 != null) {
            m1606d(virtualChildCount, i);
        }
    }

    void m1619b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bl.m2591a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f1402e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i8 = this.f1402e & 112;
        boolean z = this.f1398a;
        int[] iArr = this.f1406i;
        int[] iArr2 = this.f1407j;
        switch (GravityCompat.getAbsoluteGravity(i7, ViewCompat.getLayoutDirection(this))) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1403f) / 2);
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1403f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m1617b(i10);
            if (b == null) {
                paddingLeft += m1623d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0482a c0482a = (C0482a) b.getLayoutParams();
                i7 = (!z || c0482a.height == -1) ? -1 : b.getBaseline();
                int i12 = c0482a.f1390h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case SpdyProtocol.CUSTOM /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0482a.topMargin) - c0482a.bottomMargin;
                        break;
                    case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        i11 = paddingTop + c0482a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                        i11 = (paddingBottom - measuredHeight) - c0482a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (m1622c(i10) ? this.f1409l + paddingLeft : paddingLeft) + c0482a.leftMargin;
                m1604a(b, paddingLeft + m1607a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0482a.rightMargin + measuredWidth) + m1614b(b);
                i7 = m1608a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void m1620b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bl.m2591a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m1617b(i);
            if (!(b == null || b.getVisibility() == 8 || !m1622c(i))) {
                C0482a c0482a = (C0482a) b.getLayoutParams();
                m1621b(canvas, a ? c0482a.rightMargin + b.getRight() : (b.getLeft() - c0482a.leftMargin) - this.f1409l);
            }
            i++;
        }
        if (m1622c(virtualChildCount)) {
            int paddingLeft;
            View b2 = m1617b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f1409l;
            } else {
                c0482a = (C0482a) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - c0482a.leftMargin) - this.f1409l : c0482a.rightMargin + b2.getRight();
            }
            m1621b(canvas, paddingLeft);
        }
    }

    void m1621b(Canvas canvas, int i) {
        this.f1408k.setBounds(i, getPaddingTop() + this.f1412o, this.f1409l + i, (getHeight() - getPaddingBottom()) - this.f1412o);
        this.f1408k.draw(canvas);
    }

    protected boolean m1622c(int i) {
        if (i == 0) {
            return (this.f1411n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f1411n & 4) != 0;
            } else {
                if ((this.f1411n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0482a;
    }

    int m1623d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1624j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1615b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1616b(layoutParams);
    }

    public int getBaseline() {
        if (this.f1399b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1399b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1399b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f1400c;
            if (this.f1401d == 1) {
                i = this.f1402e & 112;
                if (i != 48) {
                    switch (i) {
                        case SpdyProtocol.CUSTOM /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1403f) / 2);
                            break;
                        case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1403f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0482a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f1399b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1399b;
    }

    public Drawable getDividerDrawable() {
        return this.f1408k;
    }

    public int getDividerPadding() {
        return this.f1412o;
    }

    public int getDividerWidth() {
        return this.f1409l;
    }

    public int getOrientation() {
        return this.f1401d;
    }

    public int getShowDividers() {
        return this.f1411n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1404g;
    }

    protected C0482a m1624j() {
        return this.f1401d == 0 ? new C0482a(-2, -2) : this.f1401d == 1 ? new C0482a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1408k != null) {
            if (this.f1401d == 1) {
                m1611a(canvas);
            } else {
                m1620b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(an.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(an.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1401d == 1) {
            m1610a(i, i2, i3, i4);
        } else {
            m1619b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1401d == 1) {
            m1609a(i, i2);
        } else {
            m1618b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f1398a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + C4233j.f14397t);
        }
        this.f1399b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1408k) {
            this.f1408k = drawable;
            if (drawable != null) {
                this.f1409l = drawable.getIntrinsicWidth();
                this.f1410m = drawable.getIntrinsicHeight();
            } else {
                this.f1409l = 0;
                this.f1410m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1412o = i;
    }

    public void setGravity(int i) {
        if (this.f1402e != i) {
            int i2 = (GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & i) == 0 ? GravityCompat.START | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1402e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((this.f1402e & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != i2) {
            this.f1402e = i2 | (this.f1402e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1405h = z;
    }

    public void setOrientation(int i) {
        if (this.f1401d != i) {
            this.f1401d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1411n) {
            requestLayout();
        }
        this.f1411n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1402e & 112) != i2) {
            this.f1402e = i2 | (this.f1402e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f1404g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
