package com.miui.calculator.cal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.miui.calculator.common.utils.Calculator;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.ArrayList;
import java.util.Iterator;

public class CalElementView extends HorizontalScrollView {
    private TextView f1406a;
    private TextView f1407b;
    private LinearLayout f1408c;
    private int f1409d;
    private OnItemClickListener f1410e;
    private PopupMenuCallback f1411f;
    private PopupMenu f1412g;
    private OnClickListener f1413h;
    private OnClickListener f1414i;
    private OnLongClickListener f1415j;

    /* renamed from: com.miui.calculator.cal.CalElementView.1 */
    class C01481 implements OnClickListener {
        final /* synthetic */ CalElementView f1396a;

        C01481(CalElementView calElementView) {
            this.f1396a = calElementView;
        }

        public void onClick(View view) {
            if (this.f1396a.f1410e != null) {
                this.f1396a.f1410e.m2665a(this.f1396a, view == this.f1396a.f1406a);
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.CalElementView.2 */
    class C01492 implements OnClickListener {
        final /* synthetic */ CalElementView f1397a;

        C01492(CalElementView calElementView) {
            this.f1397a = calElementView;
        }

        public void onClick(View view) {
            this.f1397a.m2686c();
        }
    }

    /* renamed from: com.miui.calculator.cal.CalElementView.3 */
    class C01503 implements OnLongClickListener {
        final /* synthetic */ CalElementView f1398a;

        C01503(CalElementView calElementView) {
            this.f1398a = calElementView;
        }

        public boolean onLongClick(View view) {
            return this.f1398a.m2686c();
        }
    }

    public interface OnItemClickListener {
        void m2665a(CalElementView calElementView, boolean z);
    }

    private class PopupMenu {
        final /* synthetic */ CalElementView f1402a;
        private PopupWindow f1403b;
        private LinearLayout f1404c;
        private OnClickListener f1405d;

        /* renamed from: com.miui.calculator.cal.CalElementView.PopupMenu.1 */
        class C01511 implements OnLayoutChangeListener {
            final /* synthetic */ PopupMenu f1399a;

            C01511(PopupMenu popupMenu) {
                this.f1399a = popupMenu;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                float f = 0.0f;
                if (this.f1399a.f1403b.isShowing()) {
                    float left = ((((float) (this.f1399a.f1402a.f1407b.getLeft() + this.f1399a.f1402a.getWidth())) + (this.f1399a.f1402a.f1407b.getPaint().measureText("0") * 1.5f)) - this.f1399a.f1402a.f1407b.getPaint().measureText(this.f1399a.f1402a.getText().toString())) - ((float) this.f1399a.f1404c.getWidth());
                    if (left < 0.0f) {
                        left = 0.0f;
                    }
                    ViewParent parent = this.f1399a.f1402a.getParent();
                    if (!(parent == null || parent.getParent() == null)) {
                        f = ((float) (-((View) parent.getParent()).getScrollY())) + this.f1399a.f1402a.getY();
                    }
                    this.f1399a.f1403b.update((int) left, (int) f, this.f1399a.f1404c.getWidth(), this.f1399a.f1404c.getHeight());
                }
            }
        }

        /* renamed from: com.miui.calculator.cal.CalElementView.PopupMenu.2 */
        class C01522 implements OnDismissListener {
            final /* synthetic */ PopupMenu f1400a;

            C01522(PopupMenu popupMenu) {
                this.f1400a = popupMenu;
            }

            public void onDismiss() {
                this.f1400a.m2671c();
            }
        }

        /* renamed from: com.miui.calculator.cal.CalElementView.PopupMenu.3 */
        class C01533 implements OnClickListener {
            final /* synthetic */ PopupMenu f1401a;

            C01533(PopupMenu popupMenu) {
                this.f1401a = popupMenu;
            }

            public void onClick(View view) {
                this.f1401a.f1402a.f1411f.m2674a(view.getId(), this.f1401a.f1402a);
                this.f1401a.m2671c();
            }
        }

        public PopupMenu(CalElementView calElementView) {
            this.f1402a = calElementView;
            this.f1405d = new C01533(this);
            this.f1404c = new LinearLayout(calElementView.getContext());
        }

        private void m2666a() {
            this.f1404c.setBackgroundResource(C0264R.drawable.text_select_bg);
            this.f1404c.addOnLayoutChangeListener(new C01511(this));
        }

        private void m2669b() {
            this.f1403b = new PopupWindow(this.f1402a.getContext());
            this.f1403b.setWidth(-2);
            this.f1403b.setHeight(-2);
            this.f1403b.setOutsideTouchable(true);
            this.f1403b.setContentView(this.f1404c);
            this.f1403b.setOnDismissListener(new C01522(this));
            m2666a();
            ArrayList arrayList = new ArrayList();
            this.f1402a.f1411f.m2675a(arrayList, this.f1402a);
            this.f1404c.removeAllViews();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                View d = m2672d();
                d.setId(((Integer) pair.first).intValue());
                d.setText((CharSequence) pair.second);
                this.f1404c.addView(d);
            }
            this.f1403b.showAsDropDown(this.f1402a.f1407b);
            this.f1403b.setFocusable(true);
            this.f1402a.f1407b.setBackgroundResource(C0264R.drawable.selection_bg);
        }

        private void m2671c() {
            this.f1403b.dismiss();
            this.f1402a.f1407b.setBackgroundResource(0);
        }

        private TextView m2672d() {
            TextView textView = (TextView) ((LayoutInflater) this.f1402a.getContext().getSystemService("layout_inflater")).inflate(C0264R.layout.text_edit_action_popup_text, null);
            textView.setOnClickListener(this.f1405d);
            return textView;
        }
    }

    public interface PopupMenuCallback {
        void m2674a(int i, CalElementView calElementView);

        void m2675a(ArrayList<Pair<Integer, String>> arrayList, CalElementView calElementView);
    }

    public CalElementView(Context context) {
        this(context, null);
    }

    public CalElementView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalElementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1409d = 0;
        this.f1413h = new C01481(this);
        this.f1414i = new C01492(this);
        this.f1415j = new C01503(this);
        this.f1408c = new LinearLayout(context);
        this.f1408c.setOrientation(0);
        this.f1408c.setGravity(8388629);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams) layoutParams).gravity = 8388613;
        addView(this.f1408c, layoutParams);
        this.f1406a = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelOffset(C0264R.dimen.cal_opt_margin_right);
        this.f1408c.addView(this.f1406a, layoutParams);
        this.f1407b = new TextView(context);
        this.f1408c.addView(this.f1407b);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1408c.getWidth() < getWidth()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        switch (this.f1409d) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                m2681e();
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                m2680d();
                break;
        }
        this.f1409d = 0;
    }

    private void m2680d() {
        scrollTo(0, getScrollY());
    }

    private void m2681e() {
        scrollTo(this.f1408c.getWidth() - getWidth(), getScrollY());
    }

    public void m2682a() {
        this.f1409d = 1;
        requestLayout();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.f1410e = onItemClickListener;
            this.f1406a.setOnClickListener(this.f1413h);
            this.f1407b.setOnClickListener(this.f1413h);
            return;
        }
        this.f1410e = null;
        this.f1406a.setOnClickListener(null);
        this.f1407b.setOnClickListener(null);
    }

    public void m2683a(int i, int i2) {
        this.f1406a.setBackgroundResource(i);
        this.f1407b.setBackgroundResource(i2);
    }

    public void setTypeFace(Typeface typeface) {
        this.f1406a.setTypeface(typeface);
        this.f1407b.setTypeface(typeface);
    }

    public void setTextSize(int i) {
        m2685b(i, i);
    }

    public void setTextColor(int i) {
        this.f1406a.setTextColor(i);
        this.f1407b.setTextColor(i);
    }

    public void m2685b(int i, int i2) {
        this.f1406a.setTextSize(0, (float) i);
        this.f1407b.setTextSize(0, (float) i2);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f1407b.setVisibility(4);
            this.f1406a.setVisibility(4);
        } else {
            CharSequence charSequence = "";
            String str2 = "";
            if (Calculator.m2804b(str.charAt(0)) || '=' == str.charAt(0)) {
                charSequence = str.substring(0, 1);
                str = str.substring(1);
            }
            this.f1406a.setText(charSequence);
            if (TextUtils.isEmpty(charSequence)) {
                this.f1406a.setVisibility(8);
            } else {
                this.f1406a.setVisibility(0);
            }
            this.f1407b.setText(str);
            if (TextUtils.isEmpty(str)) {
                this.f1407b.setVisibility(8);
            } else {
                this.f1407b.setVisibility(0);
            }
        }
        this.f1409d = 1;
    }

    public void m2684b() {
        CalculatorUtils.m2815a(((View) getParent()).getWidth(), 0.0f, this.f1407b, this.f1406a);
    }

    public String getText() {
        return this.f1406a.getText().toString() + this.f1407b.getText().toString();
    }

    public void setOperator(String str) {
        this.f1406a.setText(str);
        this.f1409d = 2;
    }

    public String getOperator() {
        return this.f1406a.getText().toString();
    }

    public void setElement(String str) {
        this.f1407b.setText(str);
        this.f1409d = 1;
    }

    public String getElement() {
        return this.f1407b.getText().toString();
    }

    public void setPopupMenuCallback(PopupMenuCallback popupMenuCallback) {
        OnLongClickListener onLongClickListener = null;
        this.f1411f = popupMenuCallback;
        this.f1407b.setOnClickListener(popupMenuCallback == null ? null : this.f1414i);
        TextView textView = this.f1407b;
        if (popupMenuCallback != null) {
            onLongClickListener = this.f1415j;
        }
        textView.setOnLongClickListener(onLongClickListener);
    }

    public boolean m2686c() {
        if (this.f1411f == null) {
            return false;
        }
        if (this.f1412g == null) {
            this.f1412g = new PopupMenu(this);
        }
        this.f1412g.m2669b();
        return true;
    }
}
