package com.miui.calculator.cal;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.miui.calculator.cal.CalElementView.OnItemClickListener;
import com.miui.calculator.cal.CalElementView.PopupMenuCallback;
import com.miui.calculator.cal.CalculateStoreLayout.CalculatorResult;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;

public class CalVerticalView extends FrameLayout {
    public ResultMenuCallback f1424a;
    private final ViewConfiguration f1425b;
    private boolean f1426c;
    private boolean f1427d;
    private CalculateStoreLayout f1428e;
    private float f1429f;
    private float f1430g;
    private boolean f1431h;
    private int f1432i;
    private int f1433j;
    private int f1434k;
    private int f1435l;
    private int f1436m;
    private int f1437n;
    private int f1438o;
    private int f1439p;
    private EditModeListener f1440q;
    private OnItemClickListener f1441r;
    private PopupMenuCallback f1442s;

    /* renamed from: com.miui.calculator.cal.CalVerticalView.1 */
    class C01561 implements OnItemClickListener {
        final /* synthetic */ CalVerticalView f1422a;

        C01561(CalVerticalView calVerticalView) {
            this.f1422a = calVerticalView;
        }

        public void m2697a(CalElementView calElementView, boolean z) {
            this.f1422a.m2701a(calElementView, z);
        }
    }

    /* renamed from: com.miui.calculator.cal.CalVerticalView.2 */
    class C01572 implements PopupMenuCallback {
        final /* synthetic */ CalVerticalView f1423a;

        C01572(CalVerticalView calVerticalView) {
            this.f1423a = calVerticalView;
        }

        public void m2699a(ArrayList<Pair<Integer, String>> arrayList, CalElementView calElementView) {
            if (this.f1423a.f1424a != null) {
                this.f1423a.f1424a.m2675a((ArrayList) arrayList, calElementView);
            }
        }

        public void m2698a(int i, CalElementView calElementView) {
            if (this.f1423a.f1424a != null) {
                this.f1423a.f1424a.m2674a(i, calElementView);
            }
        }
    }

    public interface EditModeListener {
        void m2700a(boolean z);
    }

    public interface ResultMenuCallback extends PopupMenuCallback {
    }

    public CalVerticalView(Context context) {
        this(context, null);
    }

    public CalVerticalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalVerticalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1439p = 0;
        this.f1441r = new C01561(this);
        this.f1442s = new C01572(this);
        this.f1434k = -1;
        this.f1425b = ViewConfiguration.get(context);
        this.f1428e = new CalculateStoreLayout(context);
        this.f1428e.setOrientation(1);
        this.f1428e.setLayoutTransition(new LayoutTransition());
        addView(this.f1428e, new LayoutParams(-1, -2));
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        switch (this.f1439p) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                scrollTo(getScrollX(), Integer.MAX_VALUE);
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m2705l();
                break;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                m2707n();
                break;
        }
        this.f1439p = 0;
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3), 0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r6.getX();
        r3 = r6.getY();
        r4 = r5.f1426c;
        if (r4 != 0) goto L_0x0015;
    L_0x000e:
        r4 = r6.getAction();
        switch(r4) {
            case 0: goto L_0x0020;
            case 1: goto L_0x0015;
            case 2: goto L_0x0026;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 != 0) goto L_0x001e;
    L_0x0018:
        r2 = super.onInterceptTouchEvent(r6);
        if (r2 == 0) goto L_0x001f;
    L_0x001e:
        r0 = r1;
    L_0x001f:
        return r0;
    L_0x0020:
        r5.f1429f = r2;
        r5.f1430g = r3;
        r2 = r0;
        goto L_0x0016;
    L_0x0026:
        r2 = r5.f1430g;
        r2 = r3 - r2;
        r2 = java.lang.Math.abs(r2);
        r3 = r5.f1425b;
        r3 = r3.getScaledTouchSlop();
        r3 = (float) r3;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x0015;
    L_0x0039:
        r2 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.calculator.cal.CalVerticalView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (!this.f1426c) {
            switch (motionEvent.getAction()) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f1431h = false;
                    this.f1429f = x;
                    this.f1430g = y;
                    z = true;
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f1431h = false;
                    z = true;
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (this.f1431h || Math.abs(y - this.f1430g) > ((float) this.f1425b.getScaledTouchSlop())) {
                        scrollBy(0, (int) (this.f1430g - y));
                        this.f1430g = y;
                        this.f1429f = x;
                        this.f1431h = true;
                    }
                    z = true;
                    break;
            }
        }
        z = false;
        if (z || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void scrollTo(int i, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f1428e.getHeight() - this.f1436m) {
            i2 = this.f1428e.getHeight() - this.f1436m;
        }
        super.scrollTo(i, i2);
    }

    private void m2704k() {
        this.f1439p = 1;
        requestLayout();
    }

    private void m2705l() {
        if (this.f1434k >= 0) {
            scrollTo(getScrollX(), this.f1428e.getChildAt(this.f1434k).getTop() - this.f1435l);
        }
    }

    private void m2706m() {
        this.f1439p = 3;
        requestLayout();
    }

    private void m2707n() {
        scrollTo(getScrollX(), this.f1428e.getChildAt(this.f1433j).getTop() - this.f1435l);
    }

    private void m2708o() {
        this.f1439p = 4;
        requestLayout();
    }

    public void m2715a() {
        this.f1426c = false;
        if (this.f1434k >= 0) {
            CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1434k);
            calElementView.m2683a(0, 0);
            if (m2710q()) {
                setElementCanPopupMenu(calElementView);
            }
            this.f1434k = -1;
            m2713t();
            setResultPopupMenuEnable(true);
        }
    }

    public boolean isInEditMode() {
        return this.f1426c;
    }

    public boolean m2719b() {
        return this.f1427d;
    }

    public void setEditModeListener(EditModeListener editModeListener) {
        this.f1440q = editModeListener;
    }

    public void m2717a(int i, int i2) {
        this.f1435l = i;
        this.f1436m = i2;
    }

    public int m2720c() {
        this.f1428e.removeAllViews();
        if (this.f1428e.m2735a()) {
            return m2709p();
        }
        m2712s();
        m2704k();
        return 2;
    }

    private int m2709p() {
        CalculatorResult restoreResult = this.f1428e.getRestoreResult();
        this.f1432i = restoreResult.f1444b;
        this.f1433j = restoreResult.f1445c;
        this.f1434k = restoreResult.f1446d;
        this.f1426c = restoreResult.f1448f;
        this.f1427d = restoreResult.f1449g;
        this.f1438o = restoreResult.f1450h;
        this.f1437n = restoreResult.f1451i;
        for (int i = this.f1432i; i < this.f1428e.getChildCount() - 1; i++) {
            View childAt = this.f1428e.getChildAt(i);
            if (childAt instanceof CalElementView) {
                if (i == this.f1432i && m2710q()) {
                    setElementCanPopupMenu((CalElementView) childAt);
                } else {
                    setElementEditable((CalElementView) childAt);
                }
            }
        }
        if (restoreResult.f1447e == 0) {
            m2726i();
        } else if (restoreResult.f1447e == 2) {
            m2725h();
        } else {
            m2703b(this.f1438o);
        }
        this.f1437n = restoreResult.f1451i;
        m2704k();
        return restoreResult.f1447e;
    }

    public void m2721d() {
        this.f1428e.removeAllViews();
        m2712s();
        m2704k();
    }

    public void m2722e() {
        m2714u();
        m2712s();
        m2704k();
    }

    private boolean m2710q() {
        return this.f1432i == this.f1433j && this.f1428e.getChildCount() > 0 && this.f1428e.getChildCount() - this.f1432i <= 2;
    }

    private void setElementEditable(CalElementView calElementView) {
        calElementView.setPopupMenuCallback(null);
        calElementView.setOnItemClickListener(this.f1441r);
    }

    private void setElementCanPopupMenu(CalElementView calElementView) {
        calElementView.setOnItemClickListener(null);
        calElementView.setPopupMenuCallback(this.f1442s);
    }

    private void setResultPopupMenuEnable(boolean z) {
        PopupMenuCallback popupMenuCallback = null;
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        if (calElementView != null) {
            calElementView.setOnItemClickListener(null);
            if (z) {
                popupMenuCallback = this.f1442s;
            }
            calElementView.setPopupMenuCallback(popupMenuCallback);
        }
    }

    public void m2723f() {
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j);
        setElementEditable(calElementView);
        View calElementView2 = new CalElementView(getContext());
        calElementView2.setText(calElementView.getText());
        calElementView2.setTypeFace(CalculatorUtils.m2817a(getContext()));
        setSecondaryText(calElementView2);
        setElementEditable(calElementView2);
        CalculateStoreLayout calculateStoreLayout = this.f1428e;
        int i = this.f1433j;
        this.f1433j = i + 1;
        calculateStoreLayout.addView(calElementView2, i);
        if (this.f1438o >= this.f1433j) {
            this.f1438o++;
        }
        m2704k();
    }

    public boolean m2724g() {
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j);
        if (this.f1433j > 0) {
            View childAt = this.f1428e.getChildAt(this.f1433j - 1);
            if (childAt instanceof CalElementView) {
                calElementView.setText(((CalElementView) childAt).getText());
                CalculateStoreLayout calculateStoreLayout = this.f1428e;
                int i = this.f1433j - 1;
                this.f1433j = i;
                calculateStoreLayout.removeViewAt(i);
                m2703b(this.f1433j);
                m2704k();
                return true;
            }
        }
        return false;
    }

    public void setTypingText(String str) {
        this.f1428e.m2734a(this.f1433j, str);
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j);
        if (this.f1434k >= 0 && this.f1434k != this.f1433j) {
            calElementView = (CalElementView) this.f1428e.getChildAt(this.f1434k);
        }
        m2703b(this.f1433j);
        calElementView.m2684b();
        m2708o();
    }

    public String getTypingText() {
        return ((CalElementView) this.f1428e.getChildAt(this.f1433j)).getText();
    }

    public String getEditOperator() {
        return ((CalElementView) this.f1428e.getChildAt(this.f1434k)).getOperator();
    }

    public void setEditOperator(String str) {
        this.f1428e.m2737c(this.f1434k, str);
    }

    public String getEditElement() {
        return ((CalElementView) this.f1428e.getChildAt(this.f1434k)).getElement();
    }

    public String getEditingText() {
        View childAt = this.f1428e.getChildAt(this.f1434k);
        if (childAt instanceof CalElementView) {
            return ((CalElementView) childAt).getText();
        }
        return "";
    }

    public void setEditElement(String str) {
        this.f1428e.m2736b(this.f1434k, str);
        ((CalElementView) this.f1428e.getChildAt(this.f1434k)).m2684b();
    }

    public void setResult(String str) {
        this.f1428e.m2734a(this.f1433j + 1, str);
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        calElementView.setTextSize(getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        calElementView.setTextColor(getResources().getColor(C0264R.color.cal_result_realtime));
    }

    public void m2725h() {
        if (!this.f1426c || this.f1434k < 0) {
            m2703b(this.f1433j);
        } else {
            m2701a((CalElementView) this.f1428e.getChildAt(this.f1434k), this.f1427d);
        }
        m2704k();
    }

    public void m2726i() {
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j);
        calElementView.setTextColor(getResources().getColor(C0264R.color.cal_history));
        setElementEditable(calElementView);
        if (this.f1434k >= 0) {
            ((CalElementView) this.f1428e.getChildAt(this.f1434k)).setTextColor(getResources().getColor(C0264R.color.cal_history));
        }
        calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        m2703b(this.f1433j + 1);
        calElementView.setTextColor(getResources().getColor(C0264R.color.cal_result));
        calElementView.m2682a();
        setElementCanPopupMenu(calElementView);
        m2704k();
    }

    public void m2718a(String str) {
        if (this.f1433j == this.f1432i) {
            setElementEditable((CalElementView) this.f1428e.getChildAt(this.f1433j));
        }
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        calElementView.setTextSize(getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        calElementView.setTextColor(getResources().getColor(C0264R.color.cal_history));
        View calElementView2 = new CalElementView(getContext());
        calElementView2.setTypeFace(CalculatorUtils.m2817a(getContext()));
        calElementView2.setTextColor(getResources().getColor(C0264R.color.cal_equation));
        calElementView2.setText(str);
        setElementCanPopupMenu(calElementView2);
        this.f1428e.addView(calElementView2);
        m2704k();
        m2703b(this.f1433j + 2);
    }

    public String getLastResult() {
        CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        if (calElementView == null) {
            return null;
        }
        String text = calElementView.getText();
        int indexOf = text.indexOf(61);
        if (indexOf >= 0) {
            return text.substring(indexOf + 1);
        }
        return text;
    }

    public String getEquationText() {
        String str = "";
        int i = this.f1432i;
        while (i <= this.f1433j) {
            String str2;
            View childAt = this.f1428e.getChildAt(i);
            if (childAt instanceof CalElementView) {
                str2 = str + ((CalElementView) childAt).getText();
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }

    public void m2727j() {
        m2711r();
        m2712s();
        m2704k();
    }

    public void setResultMenuCallback(ResultMenuCallback resultMenuCallback) {
        this.f1424a = resultMenuCallback;
        ((CalElementView) this.f1428e.getChildAt(this.f1433j + 1)).setPopupMenuCallback(resultMenuCallback == null ? null : this.f1442s);
    }

    private void m2711r() {
        if (this.f1428e.getChildCount() > 0) {
            for (int i = this.f1432i; i < this.f1428e.getChildCount(); i++) {
                View childAt = this.f1428e.getChildAt(i);
                if (childAt instanceof CalElementView) {
                    ((CalElementView) childAt).setOnItemClickListener(null);
                    ((CalElementView) childAt).setPopupMenuCallback(null);
                }
            }
            View imageView = new ImageView(getContext());
            imageView.setBackgroundResource(C0264R.drawable.img_cal_divider);
            imageView.setLayerType(1, null);
            this.f1428e.addView(imageView, new LinearLayout.LayoutParams(-1, 100));
        }
    }

    private void m2712s() {
        this.f1432i = this.f1428e.getChildCount();
        View calElementView = new CalElementView(getContext());
        calElementView.setText(NormalCalculatorActivity.f1477a);
        calElementView.setTypeFace(CalculatorUtils.m2817a(getContext()));
        setElementCanPopupMenu(calElementView);
        this.f1428e.addView(calElementView);
        this.f1433j = this.f1432i;
        m2703b(this.f1433j);
        calElementView = new CalElementView(getContext());
        calElementView.setText("");
        calElementView.setTypeFace(CalculatorUtils.m2817a(getContext()));
        this.f1428e.addView(calElementView);
        this.f1434k = -1;
    }

    public void setEquationClickable(boolean z) {
        OnItemClickListener onItemClickListener = z ? this.f1441r : null;
        for (int i = this.f1432i; i < this.f1428e.getChildCount(); i++) {
            ((CalElementView) this.f1428e.getChildAt(i)).setOnItemClickListener(onItemClickListener);
        }
    }

    private void m2703b(int i) {
        if (this.f1438o >= 0) {
            this.f1437n = this.f1438o;
            setSecondaryText((CalElementView) this.f1428e.getChildAt(this.f1438o));
        }
        this.f1438o = i;
        setPrimaryText((CalElementView) this.f1428e.getChildAt(this.f1438o));
    }

    private void m2713t() {
        if (this.f1437n >= 0) {
            setPrimaryText((CalElementView) this.f1428e.getChildAt(this.f1437n));
        }
        if (this.f1438o != this.f1437n) {
            CalElementView calElementView = (CalElementView) this.f1428e.getChildAt(this.f1438o);
            if (calElementView != null) {
                setSecondaryText(calElementView);
                this.f1438o = this.f1437n;
            }
        }
    }

    private void setPrimaryText(CalElementView calElementView) {
        if (calElementView != null) {
            calElementView.setTextColor(getResources().getColor(C0264R.color.cal_equation));
            calElementView.m2684b();
        }
    }

    private void setSecondaryText(CalElementView calElementView) {
        if (calElementView != null) {
            calElementView.setTextColor(getResources().getColor(C0264R.color.cal_history));
            calElementView.setTextSize(getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        }
    }

    private void m2714u() {
        int childCount = this.f1428e.getChildCount();
        if (childCount > this.f1432i) {
            this.f1428e.removeViews(this.f1432i, childCount - this.f1432i);
        }
    }

    public void m2716a(int i) {
        this.f1428e.m2733a(this.f1432i, this.f1433j, this.f1434k, i, this.f1426c, this.f1427d, this.f1438o, this.f1437n);
    }

    private void m2701a(CalElementView calElementView, boolean z) {
        CalElementView calElementView2 = (CalElementView) this.f1428e.getChildAt(this.f1433j + 1);
        calElementView2.setTextColor(getResources().getColor(C0264R.color.cal_result_realtime));
        calElementView2.setTextSize(getResources().getDimensionPixelOffset(C0264R.dimen.cal_secondary));
        if (this.f1434k >= 0) {
            ((CalElementView) this.f1428e.getChildAt(this.f1434k)).m2683a(0, 0);
        }
        this.f1434k = -1;
        for (int i = this.f1432i; i < this.f1428e.getChildCount(); i++) {
            if (calElementView == this.f1428e.getChildAt(i)) {
                this.f1434k = i;
            }
        }
        if (this.f1434k == -1) {
            Log.e("Calculator:CalVerticalView", "Did not find the editing view ?");
        }
        m2703b(this.f1434k);
        setResultPopupMenuEnable(false);
        this.f1427d = z;
        if (z) {
            calElementView.m2683a(C0264R.drawable.cal_equation_edit_bg, 0);
        } else {
            calElementView.m2683a(0, C0264R.drawable.cal_equation_edit_bg);
        }
        m2706m();
        if (this.f1428e.getChildCount() > this.f1433j + 2) {
            this.f1428e.removeViewAt(this.f1433j + 2);
            this.f1437n = this.f1433j;
        }
        this.f1426c = true;
        if (this.f1440q != null) {
            this.f1440q.m2700a(z);
        }
    }
}
