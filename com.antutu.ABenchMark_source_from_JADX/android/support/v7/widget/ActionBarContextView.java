package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0413b;
import android.support.v7.view.menu.C0447f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0465a {
    private CharSequence f1311g;
    private CharSequence f1312h;
    private View f1313i;
    private View f1314j;
    private LinearLayout f1315k;
    private TextView f1316l;
    private TextView f1317m;
    private int f1318n;
    private int f1319o;
    private boolean f1320p;
    private int f1321q;

    /* renamed from: android.support.v7.widget.ActionBarContextView.1 */
    class C04641 implements OnClickListener {
        final /* synthetic */ C0413b f1301a;
        final /* synthetic */ ActionBarContextView f1302b;

        C04641(ActionBarContextView actionBarContextView, C0413b c0413b) {
            this.f1302b = actionBarContextView;
            this.f1301a = c0413b;
        }

        public void onClick(View view) {
            this.f1301a.m1150c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bh a = bh.m2502a(context, attributeSet, C0417R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(a.m2505a(C0417R.styleable.ActionMode_background));
        this.f1318n = a.m2518g(C0417R.styleable.ActionMode_titleTextStyle, 0);
        this.f1319o = a.m2518g(C0417R.styleable.ActionMode_subtitleTextStyle, 0);
        this.e = a.m2516f(C0417R.styleable.ActionMode_height, 0);
        this.f1321q = a.m2518g(C0417R.styleable.ActionMode_closeItemLayout, C0417R.layout.abc_action_mode_close_item_material);
        a.m2506a();
    }

    private void m1511e() {
        int i = 8;
        Object obj = 1;
        if (this.f1315k == null) {
            LayoutInflater.from(getContext()).inflate(C0417R.layout.abc_action_bar_title_item, this);
            this.f1315k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1316l = (TextView) this.f1315k.findViewById(C0417R.id.action_bar_title);
            this.f1317m = (TextView) this.f1315k.findViewById(C0417R.id.action_bar_subtitle);
            if (this.f1318n != 0) {
                this.f1316l.setTextAppearance(getContext(), this.f1318n);
            }
            if (this.f1319o != 0) {
                this.f1317m.setTextAppearance(getContext(), this.f1319o);
            }
        }
        this.f1316l.setText(this.f1311g);
        this.f1317m.setText(this.f1312h);
        Object obj2 = !TextUtils.isEmpty(this.f1311g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1312h)) {
            obj = null;
        }
        this.f1317m.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f1315k;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1315k.getParent() == null) {
            addView(this.f1315k);
        }
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat m1512a(int i, long j) {
        return super.m1509a(i, j);
    }

    public void m1513a(C0413b c0413b) {
        if (this.f1313i == null) {
            this.f1313i = LayoutInflater.from(getContext()).inflate(this.f1321q, this, false);
            addView(this.f1313i);
        } else if (this.f1313i.getParent() == null) {
            addView(this.f1313i);
        }
        this.f1313i.findViewById(C0417R.id.action_mode_close_button).setOnClickListener(new C04641(this, c0413b));
        C0447f c0447f = (C0447f) c0413b.m1147b();
        if (this.d != null) {
            this.d.m1595f();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.m1589b(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0447f.m1398a(this.d, this.b);
        this.c = (ActionMenuView) this.d.m1577a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public boolean m1514a() {
        return this.d != null ? this.d.m1593d() : false;
    }

    public void m1515b() {
        if (this.f1313i == null) {
            m1516c();
        }
    }

    public void m1516c() {
        removeAllViews();
        this.f1314j = null;
        this.c = null;
    }

    public boolean m1517d() {
        return this.f1320p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1312h;
    }

    public CharSequence getTitle() {
        return this.f1311g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m1594e();
            this.d.m1596g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1311g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bl.m2591a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1313i == null || this.f1313i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1313i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0465a.m1504a(paddingRight, i5, a);
            i5 = C0465a.m1504a(m1508a(this.f1313i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1315k == null || this.f1314j != null || this.f1315k.getVisibility() == 8)) {
            i5 += m1508a(this.f1315k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1314j != null) {
            int a2 = m1508a(this.f1314j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m1508a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, LinearLayoutManager.INVALID_OFFSET);
            if (this.f1313i != null) {
                a = m1507a(this.f1313i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1313i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m1507a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1315k != null && this.f1314j == null) {
                if (this.f1320p) {
                    this.f1315k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1315k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1315k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m1507a(this.f1315k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1314j != null) {
                LayoutParams layoutParams = this.f1314j.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : LinearLayoutManager.INVALID_OFFSET;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = LinearLayoutManager.INVALID_OFFSET;
                }
                this.f1314j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1314j != null) {
            removeView(this.f1314j);
        }
        this.f1314j = view;
        if (!(view == null || this.f1315k == null)) {
            removeView(this.f1315k);
            this.f1315k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1312h = charSequence;
        m1511e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1311g = charSequence;
        m1511e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1320p) {
            requestLayout();
        }
        this.f1320p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
