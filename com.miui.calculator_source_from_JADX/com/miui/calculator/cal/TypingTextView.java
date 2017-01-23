package com.miui.calculator.cal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.calculator.common.utils.Calculator;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;

public class TypingTextView extends HorizontalScrollView {
    private static int[] f1503a;
    private LinearLayout f1504b;
    private ArrayList<String> f1505c;
    private StringBuilder f1506d;
    private float f1507e;
    private int f1508f;
    private OnEditModeListener f1509g;
    private int f1510h;
    private Typeface f1511i;
    private int f1512j;
    private OnClickListener f1513k;

    public interface OnEditModeListener {
        void m2617a(TextView textView, boolean z);
    }

    /* renamed from: com.miui.calculator.cal.TypingTextView.1 */
    class C01691 implements OnClickListener {
        final /* synthetic */ TypingTextView f1502a;

        C01691(TypingTextView typingTextView) {
            this.f1502a = typingTextView;
        }

        public void onClick(View view) {
            boolean z = false;
            this.f1502a.m2791a();
            for (int i = 0; i < this.f1502a.f1504b.getChildCount(); i++) {
                if (view == this.f1502a.f1504b.getChildAt(i)) {
                    this.f1502a.f1510h = i;
                }
            }
            if (this.f1502a.f1510h != -1) {
                view.setBackgroundResource(C0264R.drawable.cal_equation_edit_bg);
                if (this.f1502a.f1510h != 0) {
                    String charSequence = ((TextView) this.f1502a.f1504b.getChildAt(this.f1502a.f1510h - 1)).getText().toString();
                    if (!(charSequence.length() == 1 && Calculator.m2803a(charSequence.charAt(0)))) {
                        z = true;
                    }
                }
                if (this.f1502a.f1509g != null) {
                    this.f1502a.f1509g.m2617a((TextView) view, z);
                }
            } else {
                Log.e("Calculator:TypingTextView", "Could not find the clicked view");
            }
            this.f1502a.m2793a(true);
        }
    }

    static {
        f1503a = new int[]{16842904};
    }

    public TypingTextView(Context context) {
        this(context, null);
    }

    public TypingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1505c = new ArrayList();
        this.f1506d = new StringBuilder();
        this.f1513k = new C01691(this);
        this.f1504b = new LinearLayout(context);
        this.f1504b.setOrientation(0);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        addView(this.f1504b, layoutParams);
        this.f1510h = -1;
        this.f1508f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1503a);
        this.f1512j = obtainStyledAttributes.getInt(0, getResources().getColor(C0264R.color.cal_equation));
        obtainStyledAttributes.recycle();
    }

    public void setTextSize(float f) {
        if (f != this.f1507e) {
            this.f1507e = f;
            for (int i = 0; i < this.f1504b.getChildCount(); i++) {
                ((TextView) this.f1504b.getChildAt(i)).setTextSize(0, this.f1507e);
            }
        }
    }

    public void setText(String str) {
        this.f1505c.clear();
        if (TextUtils.isEmpty(str)) {
            this.f1504b.removeAllViews();
            return;
        }
        this.f1506d.delete(0, this.f1506d.length());
        int i = 0;
        char c = '\u0000';
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!Calculator.m2803a(charAt)) {
                this.f1506d.append(charAt);
            } else if (c == '\u0000' || Calculator.m2803a(c)) {
                this.f1506d.append(charAt);
            } else if (c == 'e' && charAt == '\u2212') {
                this.f1506d.append(charAt);
            } else {
                this.f1505c.add(this.f1506d.toString());
                this.f1506d.delete(0, this.f1506d.length());
                this.f1505c.add(String.valueOf(charAt));
            }
            i++;
            c = charAt;
        }
        if (!TextUtils.isEmpty(this.f1506d.toString())) {
            this.f1505c.add(this.f1506d.toString());
        }
        this.f1506d.delete(0, this.f1506d.length());
        int i2 = 0;
        while (i2 < this.f1504b.getChildCount() && i2 < this.f1505c.size()) {
            ((TextView) this.f1504b.getChildAt(i2)).setText((CharSequence) this.f1505c.get(i2));
            i2++;
        }
        while (i2 < this.f1505c.size()) {
            View textView = new TextView(getContext());
            if (this.f1511i != null) {
                textView.setTypeface(this.f1511i);
            }
            textView.setTextColor(this.f1512j);
            this.f1504b.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            textView.setOnClickListener(this.f1513k);
            textView.setText((CharSequence) this.f1505c.get(i2));
            textView.setTextSize(0, this.f1507e);
            i2++;
        }
        for (i = this.f1504b.getChildCount() - 1; i >= i2; i--) {
            this.f1504b.removeViewAt(i);
        }
        this.f1505c.clear();
        this.f1508f = 3;
    }

    public String getText() {
        this.f1506d.delete(0, this.f1506d.length());
        for (int i = 0; i < this.f1504b.getChildCount(); i++) {
            this.f1506d.append(((TextView) this.f1504b.getChildAt(i)).getText());
        }
        return this.f1506d.toString();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        switch (this.f1508f) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                m2793a(true);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                m2793a(false);
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                scrollTo(this.f1504b.getWidth() - getWidth(), 0);
                break;
        }
        this.f1508f = 0;
    }

    public void m2793a(boolean z) {
        TextView editingView = getEditingView();
        if (editingView != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int left = editingView.getLeft();
            int width2 = editingView.getWidth() + left;
            if (z) {
                if (scrollX > width2 || scrollX + width < width2) {
                    scrollTo(width2 - width, 0);
                }
            } else if (scrollX > left || scrollX + width < left) {
                scrollTo(left, 0);
            }
        }
    }

    public void setOnEditModeListener(OnEditModeListener onEditModeListener) {
        this.f1509g = onEditModeListener;
    }

    public void m2791a() {
        TextView editingView = getEditingView();
        if (editingView != null) {
            editingView.setBackground(null);
        }
        this.f1510h = -1;
    }

    private TextView getEditingView() {
        if (this.f1510h >= 0 && this.f1510h < this.f1504b.getChildCount()) {
            return (TextView) this.f1504b.getChildAt(this.f1510h);
        }
        Log.e("Calculator:TypingTextView", "index = " + this.f1510h + " may not in edit mode");
        return null;
    }

    public String getEditingString() {
        return getEditingView().getText().toString();
    }

    public void m2792a(String str, boolean z) {
        getEditingView().setText(str);
        if (z) {
            this.f1508f = 1;
        } else {
            this.f1508f = 2;
        }
    }

    public boolean isInEditMode() {
        return this.f1510h != -1;
    }

    public void setTypeFace(Typeface typeface) {
        for (int i = 0; i < getChildCount(); i++) {
            this.f1511i = typeface;
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTypeface(typeface);
            }
        }
    }
}
