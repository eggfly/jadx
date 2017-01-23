package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0424d;
import android.support.v7.widget.ap.C0433b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* renamed from: android.support.v7.widget.x */
public class C0634x extends Spinner implements TintableBackgroundView {
    private static final boolean f2131a;
    private static final boolean f2132b;
    private static final int[] f2133c;
    private C0616l f2134d;
    private C0606g f2135e;
    private Context f2136f;
    private C0433b f2137g;
    private SpinnerAdapter f2138h;
    private boolean f2139i;
    private C0633b f2140j;
    private int f2141k;
    private final Rect f2142l;

    /* renamed from: android.support.v7.widget.x.1 */
    class C06281 extends C0433b {
        final /* synthetic */ C0633b f2118a;
        final /* synthetic */ C0634x f2119b;

        C06281(C0634x c0634x, View view, C0633b c0633b) {
            this.f2119b = c0634x;
            this.f2118a = c0633b;
            super(view);
        }

        public ap m2709a() {
            return this.f2118a;
        }

        public boolean m2710b() {
            if (!this.f2119b.f2140j.m2371k()) {
                this.f2119b.f2140j.m2719c();
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.x.a */
    private static class C0629a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f2120a;
        private ListAdapter f2121b;

        public C0629a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2120a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2121b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (C0634x.f2131a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof bd) {
                bd bdVar = (bd) spinnerAdapter;
                if (bdVar.m2496a() == null) {
                    bdVar.m2497a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2121b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.f2120a == null ? 0 : this.f2120a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f2120a == null ? null : this.f2120a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.f2120a == null ? null : this.f2120a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2120a == null ? -1 : this.f2120a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.f2120a != null && this.f2120a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2121b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2120a != null) {
                this.f2120a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2120a != null) {
                this.f2120a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: android.support.v7.widget.x.b */
    private class C0633b extends ap {
        final /* synthetic */ C0634x f2127a;
        private CharSequence f2128c;
        private ListAdapter f2129d;
        private final Rect f2130e;

        /* renamed from: android.support.v7.widget.x.b.1 */
        class C06301 implements OnItemClickListener {
            final /* synthetic */ C0634x f2122a;
            final /* synthetic */ C0633b f2123b;

            C06301(C0633b c0633b, C0634x c0634x) {
                this.f2123b = c0633b;
                this.f2122a = c0634x;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f2123b.f2127a.setSelection(i);
                if (this.f2123b.f2127a.getOnItemClickListener() != null) {
                    this.f2123b.f2127a.performItemClick(view, i, this.f2123b.f2129d.getItemId(i));
                }
                this.f2123b.m2369i();
            }
        }

        /* renamed from: android.support.v7.widget.x.b.2 */
        class C06312 implements OnGlobalLayoutListener {
            final /* synthetic */ C0633b f2124a;

            C06312(C0633b c0633b) {
                this.f2124a = c0633b;
            }

            public void onGlobalLayout() {
                if (this.f2124a.m2714b(this.f2124a.f2127a)) {
                    this.f2124a.m2718b();
                    super.m2357c();
                    return;
                }
                this.f2124a.m2369i();
            }
        }

        /* renamed from: android.support.v7.widget.x.b.3 */
        class C06323 implements OnDismissListener {
            final /* synthetic */ OnGlobalLayoutListener f2125a;
            final /* synthetic */ C0633b f2126b;

            C06323(C0633b c0633b, OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2126b = c0633b;
                this.f2125a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = this.f2126b.f2127a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2125a);
                }
            }
        }

        public C0633b(C0634x c0634x, Context context, AttributeSet attributeSet, int i) {
            this.f2127a = c0634x;
            super(context, attributeSet, i);
            this.f2130e = new Rect();
            m2351a((View) c0634x);
            m2355a(true);
            m2349a(0);
            m2352a(new C06301(this, c0634x));
        }

        private boolean m2714b(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.f2130e);
        }

        public CharSequence m2715a() {
            return this.f2128c;
        }

        public void m2716a(ListAdapter listAdapter) {
            super.m2353a(listAdapter);
            this.f2129d = listAdapter;
        }

        public void m2717a(CharSequence charSequence) {
            this.f2128c = charSequence;
        }

        void m2718b() {
            int i;
            Drawable d = m2359d();
            if (d != null) {
                d.getPadding(this.f2127a.f2142l);
                i = bl.m2591a(this.f2127a) ? this.f2127a.f2142l.right : -this.f2127a.f2142l.left;
            } else {
                Rect b = this.f2127a.f2142l;
                this.f2127a.f2142l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f2127a.getPaddingLeft();
            int paddingRight = this.f2127a.getPaddingRight();
            int width = this.f2127a.getWidth();
            if (this.f2127a.f2141k == -2) {
                int a = this.f2127a.m2721a((SpinnerAdapter) this.f2129d, m2359d());
                int i2 = (this.f2127a.getContext().getResources().getDisplayMetrics().widthPixels - this.f2127a.f2142l.left) - this.f2127a.f2142l.right;
                if (a <= i2) {
                    i2 = a;
                }
                m2364f(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f2127a.f2141k == -1) {
                m2364f((width - paddingLeft) - paddingRight);
            } else {
                m2364f(this.f2127a.f2141k);
            }
            m2356b(bl.m2591a(this.f2127a) ? ((width - paddingRight) - m2367h()) + i : i + paddingLeft);
        }

        public void m2719c() {
            boolean k = m2371k();
            m2718b();
            m2366g(2);
            super.m2357c();
            m2373m().setChoiceMode(1);
            m2368h(this.f2127a.getSelectedItemPosition());
            if (!k) {
                ViewTreeObserver viewTreeObserver = this.f2127a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    OnGlobalLayoutListener c06312 = new C06312(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c06312);
                    m2354a(new C06323(this, c06312));
                }
            }
        }
    }

    static {
        f2131a = VERSION.SDK_INT >= 23;
        f2132b = VERSION.SDK_INT >= 16;
        f2133c = new int[]{16843505};
    }

    public C0634x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.spinnerStyle);
    }

    public C0634x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0634x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public C0634x(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        CharSequence[] e2;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f2142l = new Rect();
        bh a = bh.m2502a(context, attributeSet, C0417R.styleable.Spinner, i, 0);
        this.f2134d = C0616l.m2672a();
        this.f2135e = new C0606g(this, this.f2134d);
        if (theme != null) {
            this.f2136f = new C0424d(context, theme);
        } else {
            int g = a.m2518g(C0417R.styleable.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f2136f = new C0424d(context, g);
            } else {
                this.f2136f = !f2131a ? context : null;
            }
        }
        if (this.f2136f != null) {
            C0633b c0633b;
            bh a2;
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2133c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0633b = new C0633b(this, this.f2136f, attributeSet, i);
                                    a2 = bh.m2502a(this.f2136f, attributeSet, C0417R.styleable.Spinner, i, 0);
                                    this.f2141k = a2.m2516f(C0417R.styleable.Spinner_android_dropDownWidth, -2);
                                    c0633b.m2350a(a2.m2505a(C0417R.styleable.Spinner_android_popupBackground));
                                    c0633b.m2717a(a.m2513d(C0417R.styleable.Spinner_android_prompt));
                                    a2.m2506a();
                                    this.f2140j = c0633b;
                                    this.f2137g = new C06281(this, this, c0633b);
                                }
                                e2 = a.m2515e(C0417R.styleable.Spinner_android_entries);
                                if (e2 != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                                    arrayAdapter.setDropDownViewResource(C0417R.layout.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a.m2506a();
                                this.f2139i = true;
                                if (this.f2138h != null) {
                                    setAdapter(this.f2138h);
                                    this.f2138h = null;
                                }
                                this.f2135e.m2648a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0633b = new C0633b(this, this.f2136f, attributeSet, i);
                            a2 = bh.m2502a(this.f2136f, attributeSet, C0417R.styleable.Spinner, i, 0);
                            this.f2141k = a2.m2516f(C0417R.styleable.Spinner_android_dropDownWidth, -2);
                            c0633b.m2350a(a2.m2505a(C0417R.styleable.Spinner_android_popupBackground));
                            c0633b.m2717a(a.m2513d(C0417R.styleable.Spinner_android_prompt));
                            a2.m2506a();
                            this.f2140j = c0633b;
                            this.f2137g = new C06281(this, this, c0633b);
                        }
                        e2 = a.m2515e(C0417R.styleable.Spinner_android_entries);
                        if (e2 != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
                            arrayAdapter.setDropDownViewResource(C0417R.layout.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a.m2506a();
                        this.f2139i = true;
                        if (this.f2138h != null) {
                            setAdapter(this.f2138h);
                            this.f2138h = null;
                        }
                        this.f2135e.m2648a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0633b = new C0633b(this, this.f2136f, attributeSet, i);
                a2 = bh.m2502a(this.f2136f, attributeSet, C0417R.styleable.Spinner, i, 0);
                this.f2141k = a2.m2516f(C0417R.styleable.Spinner_android_dropDownWidth, -2);
                c0633b.m2350a(a2.m2505a(C0417R.styleable.Spinner_android_popupBackground));
                c0633b.m2717a(a.m2513d(C0417R.styleable.Spinner_android_prompt));
                a2.m2506a();
                this.f2140j = c0633b;
                this.f2137g = new C06281(this, this, c0633b);
            }
        }
        e2 = a.m2515e(C0417R.styleable.Spinner_android_entries);
        if (e2 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, e2);
            arrayAdapter.setDropDownViewResource(C0417R.layout.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a.m2506a();
        this.f2139i = true;
        if (this.f2138h != null) {
            setAdapter(this.f2138h);
            this.f2138h = null;
        }
        this.f2135e.m2648a(attributeSet, i);
    }

    private int m2721a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2142l);
        return (this.f2142l.left + this.f2142l.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2135e != null) {
            this.f2135e.m2651c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.f2140j != null ? this.f2140j.m2363f() : f2132b ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.f2140j != null ? this.f2140j.m2365g() : f2132b ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.f2140j != null ? this.f2141k : f2132b ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.f2140j != null ? this.f2140j.m2359d() : f2132b ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.f2140j != null ? this.f2136f : f2131a ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.f2140j != null ? this.f2140j.m2715a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2135e != null ? this.f2135e.m2643a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2135e != null ? this.f2135e.m2649b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2140j != null && this.f2140j.m2371k()) {
            this.f2140j.m2369i();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2140j != null && MeasureSpec.getMode(i) == LinearLayoutManager.INVALID_OFFSET) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2721a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f2137g == null || !this.f2137g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.f2140j == null) {
            return super.performClick();
        }
        if (!this.f2140j.m2371k()) {
            this.f2140j.m2719c();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f2139i) {
            super.setAdapter(spinnerAdapter);
            if (this.f2140j != null) {
                this.f2140j.m2716a(new C0629a(spinnerAdapter, (this.f2136f == null ? getContext() : this.f2136f).getTheme()));
                return;
            }
            return;
        }
        this.f2138h = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2135e != null) {
            this.f2135e.m2647a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2135e != null) {
            this.f2135e.m2644a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2140j != null) {
            this.f2140j.m2356b(i);
        } else if (f2132b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2140j != null) {
            this.f2140j.m2358c(i);
        } else if (f2132b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f2140j != null) {
            this.f2141k = i;
        } else if (f2132b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2140j != null) {
            this.f2140j.m2350a(drawable);
        } else if (f2132b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(ContextCompat.getDrawable(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2140j != null) {
            this.f2140j.m2717a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2135e != null) {
            this.f2135e.m2645a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2135e != null) {
            this.f2135e.m2646a(mode);
        }
    }
}
