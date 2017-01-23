package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f1291a;
    Drawable f1292b;
    Drawable f1293c;
    boolean f1294d;
    boolean f1295e;
    private boolean f1296f;
    private View f1297g;
    private View f1298h;
    private View f1299i;
    private int f1300j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundDrawable(VERSION.SDK_INT >= 21 ? new C0596c(this) : new C0591b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ActionBar);
        this.f1291a = obtainStyledAttributes.getDrawable(C0417R.styleable.ActionBar_background);
        this.f1292b = obtainStyledAttributes.getDrawable(C0417R.styleable.ActionBar_backgroundStacked);
        this.f1300j = obtainStyledAttributes.getDimensionPixelSize(C0417R.styleable.ActionBar_height, -1);
        if (getId() == C0417R.id.split_action_bar) {
            this.f1294d = true;
            this.f1293c = obtainStyledAttributes.getDrawable(C0417R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1294d ? this.f1293c == null : this.f1291a == null && this.f1292b == null;
        setWillNotDraw(z);
    }

    private boolean m1502a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m1503b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1291a != null && this.f1291a.isStateful()) {
            this.f1291a.setState(getDrawableState());
        }
        if (this.f1292b != null && this.f1292b.isStateful()) {
            this.f1292b.setState(getDrawableState());
        }
        if (this.f1293c != null && this.f1293c.isStateful()) {
            this.f1293c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1297g;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1291a != null) {
                this.f1291a.jumpToCurrentState();
            }
            if (this.f1292b != null) {
                this.f1292b.jumpToCurrentState();
            }
            if (this.f1293c != null) {
                this.f1293c.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1298h = findViewById(C0417R.id.action_bar);
        this.f1299i = findViewById(C0417R.id.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1296f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1297g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1294d) {
            int i6;
            if (this.f1291a != null) {
                if (this.f1298h.getVisibility() == 0) {
                    this.f1291a.setBounds(this.f1298h.getLeft(), this.f1298h.getTop(), this.f1298h.getRight(), this.f1298h.getBottom());
                } else if (this.f1299i == null || this.f1299i.getVisibility() != 0) {
                    this.f1291a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1291a.setBounds(this.f1299i.getLeft(), this.f1299i.getTop(), this.f1299i.getRight(), this.f1299i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1295e = z2;
            if (!z2 || this.f1292b == null) {
                i5 = i6;
            } else {
                this.f1292b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1293c != null) {
            this.f1293c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1298h == null && MeasureSpec.getMode(i2) == LinearLayoutManager.INVALID_OFFSET && this.f1300j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1300j, MeasureSpec.getSize(i2)), LinearLayoutManager.INVALID_OFFSET);
        }
        super.onMeasure(i, i2);
        if (this.f1298h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1297g != null && this.f1297g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m1502a(this.f1298h) ? m1503b(this.f1298h) : !m1502a(this.f1299i) ? m1503b(this.f1299i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m1503b(this.f1297g), mode == LinearLayoutManager.INVALID_OFFSET ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1291a != null) {
            this.f1291a.setCallback(null);
            unscheduleDrawable(this.f1291a);
        }
        this.f1291a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1298h != null) {
                this.f1291a.setBounds(this.f1298h.getLeft(), this.f1298h.getTop(), this.f1298h.getRight(), this.f1298h.getBottom());
            }
        }
        if (this.f1294d) {
            if (this.f1293c != null) {
                z = false;
            }
        } else if (!(this.f1291a == null && this.f1292b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1293c != null) {
            this.f1293c.setCallback(null);
            unscheduleDrawable(this.f1293c);
        }
        this.f1293c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1294d && this.f1293c != null) {
                this.f1293c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1294d) {
            if (this.f1293c != null) {
                z = false;
            }
        } else if (!(this.f1291a == null && this.f1292b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1292b != null) {
            this.f1292b.setCallback(null);
            unscheduleDrawable(this.f1292b);
        }
        this.f1292b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1295e && this.f1292b != null) {
                this.f1292b.setBounds(this.f1297g.getLeft(), this.f1297g.getTop(), this.f1297g.getRight(), this.f1297g.getBottom());
            }
        }
        if (this.f1294d) {
            if (this.f1293c != null) {
                z = false;
            }
        } else if (!(this.f1291a == null && this.f1292b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(az azVar) {
        if (this.f1297g != null) {
            removeView(this.f1297g);
        }
        this.f1297g = azVar;
        if (azVar != null) {
            addView(azVar);
            ViewGroup.LayoutParams layoutParams = azVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            azVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1296f = z;
        setDescendantFocusability(z ? 393216 : AccessibilityNodeInfoCompat.ACTION_EXPAND);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1291a != null) {
            this.f1291a.setVisible(z, false);
        }
        if (this.f1292b != null) {
            this.f1292b.setVisible(z, false);
        }
        if (this.f1293c != null) {
            this.f1293c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1291a && !this.f1294d) || ((drawable == this.f1292b && this.f1295e) || ((drawable == this.f1293c && this.f1294d) || super.verifyDrawable(drawable)));
    }
}
