package com.miui.support.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class ListPopupWindow {
    private boolean f2760A;
    int f2761a;
    private final ResizePopupRunnable f2762b;
    private final PopupTouchInterceptor f2763c;
    private final PopupScrollListener f2764d;
    private final ListSelectorHider f2765e;
    private Context f2766f;
    private ArrowPopupWindow f2767g;
    private ListAdapter f2768h;
    private DropDownListView f2769i;
    private int f2770j;
    private int f2771k;
    private int f2772l;
    private int f2773m;
    private boolean f2774n;
    private boolean f2775o;
    private boolean f2776p;
    private View f2777q;
    private int f2778r;
    private DataSetObserver f2779s;
    private View f2780t;
    private Drawable f2781u;
    private OnItemClickListener f2782v;
    private OnItemSelectedListener f2783w;
    private Runnable f2784x;
    private Handler f2785y;
    private Rect f2786z;

    /* renamed from: com.miui.support.widget.ListPopupWindow.1 */
    class C04901 implements Runnable {
        final /* synthetic */ ListPopupWindow f4190a;

        C04901(ListPopupWindow listPopupWindow) {
            this.f4190a = listPopupWindow;
        }

        public void run() {
            View a = this.f4190a.m4514a();
            if (a != null && a.getWindowToken() != null) {
                this.f4190a.m4524c();
            }
        }
    }

    /* renamed from: com.miui.support.widget.ListPopupWindow.2 */
    class C04912 implements OnItemSelectedListener {
        final /* synthetic */ ListPopupWindow f4191a;

        C04912(ListPopupWindow listPopupWindow) {
            this.f4191a = listPopupWindow;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                DropDownListView a = this.f4191a.f2769i;
                if (a != null) {
                    a.f4192a = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class DropDownListView extends ListView {
        private boolean f4192a;
        private boolean f4193b;

        public DropDownListView(Context context, boolean z) {
            super(context, null, 16842861);
            this.f4193b = z;
            setCacheColorHint(0);
        }

        public boolean isInTouchMode() {
            return (this.f4193b && this.f4192a) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f4193b || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f4193b || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f4193b || super.hasFocus();
        }

        final int m5876a(int i, int i2, int i3, int i4, int i5) {
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
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
                listPaddingTop = view.getLayoutParams().height;
                if (listPaddingTop > 0) {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
                } else {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i, listPaddingTop);
                if (i8 > 0) {
                    listPaddingTop = listPaddingBottom + dividerHeight;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                listPaddingTop += view.getMeasuredHeight();
                if (listPaddingTop < i4) {
                    if (i5 >= 0 && i8 >= i5) {
                        i6 = listPaddingTop;
                    }
                    i8++;
                    listPaddingBottom = listPaddingTop;
                } else if (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) {
                    return i4;
                } else {
                    return i6;
                }
            }
            return listPaddingBottom;
        }
    }

    private class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow f4194a;

        private ListSelectorHider(ListPopupWindow listPopupWindow) {
            this.f4194a = listPopupWindow;
        }

        public void run() {
            this.f4194a.m4526d();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow f4195a;

        private PopupDataSetObserver(ListPopupWindow listPopupWindow) {
            this.f4195a = listPopupWindow;
        }

        public void onChanged() {
            if (this.f4195a.isShowing()) {
                this.f4195a.m4524c();
            }
        }

        public void onInvalidated() {
            this.f4195a.m4520a(true);
        }
    }

    private class PopupScrollListener implements OnScrollListener {
        final /* synthetic */ ListPopupWindow f4196a;

        private PopupScrollListener(ListPopupWindow listPopupWindow) {
            this.f4196a = listPopupWindow;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f4196a.m4528e() && this.f4196a.f2767g.getContentView() != null) {
                this.f4196a.f2785y.removeCallbacks(this.f4196a.f2762b);
                this.f4196a.f2762b.run();
            }
        }
    }

    private class PopupTouchInterceptor implements OnTouchListener {
        final /* synthetic */ ListPopupWindow f4197a;

        private PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
            this.f4197a = listPopupWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f4197a.f2767g != null && this.f4197a.f2767g.isShowing() && x >= 0 && x < this.f4197a.f2767g.getWidth() && y >= 0 && y < this.f4197a.f2767g.getHeight()) {
                this.f4197a.f2785y.postDelayed(this.f4197a.f2762b, 250);
            } else if (action == 1) {
                this.f4197a.f2785y.removeCallbacks(this.f4197a.f2762b);
            }
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow f4198a;

        private ResizePopupRunnable(ListPopupWindow listPopupWindow) {
            this.f4198a = listPopupWindow;
        }

        public void run() {
            if (this.f4198a.f2769i != null && this.f4198a.f2769i.getCount() > this.f4198a.f2769i.getChildCount() && this.f4198a.f2769i.getChildCount() <= this.f4198a.f2761a) {
                this.f4198a.f2767g.setInputMethodMode(2);
                this.f4198a.m4524c();
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, 16843519);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.f2762b = new ResizePopupRunnable();
        this.f2763c = new PopupTouchInterceptor();
        this.f2764d = new PopupScrollListener();
        this.f2765e = new ListSelectorHider();
        this.f2761a = Integer.MAX_VALUE;
        this.f2770j = -2;
        this.f2771k = -2;
        this.f2775o = false;
        this.f2776p = false;
        this.f2778r = 0;
        this.f2785y = new Handler();
        this.f2786z = new Rect();
        this.f2766f = context;
        this.f2767g = new ArrowPopupWindow(context, attributeSet, i);
    }

    public void m4518a(ListAdapter listAdapter) {
        if (this.f2779s == null) {
            this.f2779s = new PopupDataSetObserver();
        } else if (this.f2768h != null) {
            this.f2768h.unregisterDataSetObserver(this.f2779s);
        }
        this.f2768h = listAdapter;
        if (this.f2768h != null) {
            listAdapter.registerDataSetObserver(this.f2779s);
        }
        if (this.f2769i != null) {
            this.f2769i.setAdapter(this.f2768h);
        }
    }

    public void m4523b(boolean z) {
        this.f2760A = true;
        this.f2767g.setFocusable(z);
    }

    public View m4514a() {
        return this.f2780t;
    }

    public void m4516a(View view) {
        this.f2780t = view;
    }

    public void m4515a(int i) {
        this.f2773m = i;
        this.f2774n = true;
    }

    public void m4522b(int i) {
        this.f2771k = i;
    }

    public void m4525c(int i) {
        Drawable background = this.f2767g.getBackground();
        if (background != null) {
            background.getPadding(this.f2786z);
            this.f2771k = (this.f2786z.left + this.f2786z.right) + i;
            return;
        }
        m4522b(i);
    }

    public void m4517a(OnItemClickListener onItemClickListener) {
        this.f2782v = onItemClickListener;
    }

    public void m4521b() {
        this.f2785y.post(this.f2784x);
    }

    public void m4524c() {
        int i;
        int i2;
        boolean z = true;
        boolean z2 = false;
        int h = m4512h();
        if (this.f2771k == -1) {
            i = -1;
        } else if (this.f2771k == -2) {
            this.f2767g.setWidth(m4514a().getWidth());
            i = 0;
        } else {
            this.f2767g.setWidth(this.f2771k);
            i = 0;
        }
        if (this.f2770j == -1) {
            i2 = -1;
        } else if (this.f2770j == -2) {
            this.f2767g.setHeight(h);
            i2 = 0;
        } else {
            this.f2767g.setHeight(this.f2770j);
            i2 = 0;
        }
        this.f2767g.setFocusable(true);
        if (this.f2767g.isShowing()) {
            ArrowPopupWindow arrowPopupWindow = this.f2767g;
            if (!(this.f2776p || this.f2775o)) {
                z2 = true;
            }
            arrowPopupWindow.setOutsideTouchable(z2);
            this.f2767g.update(m4514a(), this.f2772l, this.f2773m, i, i2);
            return;
        }
        this.f2767g.setWindowLayoutMode(i, i2);
        ArrowPopupWindow arrowPopupWindow2 = this.f2767g;
        if (this.f2776p || this.f2775o) {
            z = false;
        }
        arrowPopupWindow2.setOutsideTouchable(z);
        this.f2767g.setTouchInterceptor(this.f2763c);
        this.f2767g.m5689a(m4514a(), this.f2772l, this.f2773m);
        this.f2769i.setSelection(-1);
        if (!this.f2760A || this.f2769i.isInTouchMode()) {
            m4526d();
        }
        if (!this.f2760A) {
            this.f2785y.post(this.f2765e);
        }
    }

    public void m4520a(boolean z) {
        this.f2767g.m5691a(z);
        m4511g();
        this.f2769i = null;
        this.f2785y.removeCallbacks(this.f2762b);
    }

    public void m4519a(OnDismissListener onDismissListener) {
        this.f2767g.setOnDismissListener(onDismissListener);
    }

    private void m4511g() {
        if (this.f2777q != null) {
            ViewParent parent = this.f2777q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2777q);
            }
        }
    }

    public void m4527d(int i) {
        this.f2767g.setInputMethodMode(i);
    }

    public void m4526d() {
        DropDownListView dropDownListView = this.f2769i;
        if (dropDownListView != null) {
            dropDownListView.f4192a = true;
            dropDownListView.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.f2767g.isShowing();
    }

    public boolean m4528e() {
        return this.f2767g.getInputMethodMode() == 2;
    }

    public ListView m4529f() {
        return this.f2769i;
    }

    private int m4512h() {
        int measuredHeight;
        int i;
        int i2;
        int i3;
        boolean z = true;
        View linearLayout;
        LayoutParams layoutParams;
        if (this.f2769i == null) {
            Context context = this.f2766f;
            this.f2784x = new C04901(this);
            this.f2769i = new DropDownListView(context, !this.f2760A);
            if (this.f2781u != null) {
                this.f2769i.setSelector(this.f2781u);
            }
            this.f2769i.setAdapter(this.f2768h);
            this.f2769i.setOnItemClickListener(this.f2782v);
            this.f2769i.setFocusable(true);
            this.f2769i.setFocusableInTouchMode(true);
            this.f2769i.setOnItemSelectedListener(new C04912(this));
            this.f2769i.setOnScrollListener(this.f2764d);
            if (this.f2783w != null) {
                this.f2769i.setOnItemSelectedListener(this.f2783w);
            }
            View view = this.f2769i;
            View view2 = this.f2777q;
            if (view2 != null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2778r) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2778r);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.f2771k, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                View view3 = linearLayout;
                measuredHeight = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
                view = view3;
            } else {
                measuredHeight = 0;
            }
            this.f2767g.setContentView(view);
            i = measuredHeight;
        } else {
            linearLayout = this.f2777q;
            if (linearLayout != null) {
                layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                i = (linearLayout.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f2767g.getBackground();
        if (background != null) {
            background.getPadding(this.f2786z);
            i2 = this.f2786z.top + this.f2786z.bottom;
            if (this.f2774n) {
                i3 = i2;
            } else {
                this.f2773m = -this.f2786z.top;
                i3 = i2;
            }
        } else {
            this.f2786z.setEmpty();
            i3 = 0;
        }
        if (this.f2767g.getInputMethodMode() != 2) {
            z = false;
        }
        measuredHeight = m4513a(m4514a(), this.f2773m, z);
        if (this.f2775o || this.f2770j == -1) {
            return measuredHeight + i3;
        }
        int makeMeasureSpec;
        switch (this.f2771k) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2766f.getResources().getDisplayMetrics().widthPixels - (this.f2786z.left + this.f2786z.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2766f.getResources().getDisplayMetrics().widthPixels - (this.f2786z.left + this.f2786z.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2771k, 1073741824);
                break;
        }
        i2 = this.f2769i.m5876a(makeMeasureSpec, 0, -1, measuredHeight - i, -1);
        if (i2 > 0) {
            i += i3;
        }
        return i2 + i;
    }

    public int m4513a(View view, int i, boolean z) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        i2 = Math.max((i2 - (iArr[1] + view.getHeight())) - i, (iArr[1] - rect.top) + i);
        if (this.f2767g.getBackground() == null) {
            return i2;
        }
        this.f2767g.getBackground().getPadding(this.f2786z);
        return i2 - (this.f2786z.top + this.f2786z.bottom);
    }
}
