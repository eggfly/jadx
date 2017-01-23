package com.miui.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.util.SimpleNumberFormatter;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPicker extends LinearLayout {
    static final Formatter f4254a;
    private static final int[] af;
    private static final char[] au;
    private static final int f4255b;
    private int f4256A;
    private final Scroller f4257B;
    private final Scroller f4258C;
    private int f4259D;
    private SetSelectionCommand f4260E;
    private ChangeCurrentByOneFromLongPressCommand f4261F;
    private BeginSoftInputOnLongPressCommand f4262G;
    private float f4263H;
    private long f4264I;
    private float f4265J;
    private VelocityTracker f4266K;
    private int f4267L;
    private int f4268M;
    private int f4269N;
    private boolean f4270O;
    private final boolean f4271P;
    private final int f4272Q;
    private int f4273R;
    private boolean f4274S;
    private boolean f4275T;
    private int f4276U;
    private int f4277V;
    private int f4278W;
    private boolean aa;
    private boolean ab;
    private AccessibilityNodeProviderImpl ac;
    private final PressedStateHelper ad;
    private int ae;
    private Paint ag;
    private int ah;
    private float ai;
    private int aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private float ao;
    private int ap;
    private CharSequence aq;
    private SoundPool ar;
    private int as;
    private float at;
    private int f4279c;
    private int f4280d;
    private final EditText f4281e;
    private final int f4282f;
    private final int f4283g;
    private final int f4284h;
    private final int f4285i;
    private int f4286j;
    private final boolean f4287k;
    private final int f4288l;
    private int f4289m;
    private String[] f4290n;
    private int f4291o;
    private int f4292p;
    private int f4293q;
    private OnValueChangeListener f4294r;
    private OnScrollListener f4295s;
    private Formatter f4296t;
    private long f4297u;
    private final SparseArray<String> f4298v;
    private final int[] f4299w;
    private final Paint f4300x;
    private int f4301y;
    private int f4302z;

    public interface OnValueChangeListener {
        void m3082a(NumberPicker numberPicker, int i, int i2);
    }

    /* renamed from: com.miui.support.widget.NumberPicker.1 */
    class C04961 implements OnFocusChangeListener {
        final /* synthetic */ NumberPicker f4236a;

        C04961(NumberPicker numberPicker) {
            this.f4236a = numberPicker;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f4236a.f4281e.selectAll();
                return;
            }
            this.f4236a.f4281e.setSelection(0, 0);
            this.f4236a.m5948a(view);
        }
    }

    class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        final /* synthetic */ NumberPicker f4237a;
        private final Rect f4238b;
        private final int[] f4239c;
        private int f4240d;

        AccessibilityNodeProviderImpl(NumberPicker numberPicker) {
            this.f4237a = numberPicker;
            this.f4238b = new Rect();
            this.f4239c = new int[2];
            this.f4240d = Integer.MIN_VALUE;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            switch (i) {
                case -1:
                    return m5923b(this.f4237a.getScrollX(), this.f4237a.getScrollY(), this.f4237a.getScrollX() + (this.f4237a.getRight() - this.f4237a.getLeft()), this.f4237a.getScrollY() + (this.f4237a.getBottom() - this.f4237a.getTop()));
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    return m5918a(1, m5926d(), this.f4237a.getScrollX(), this.f4237a.f4277V - this.f4237a.f4272Q, (this.f4237a.getRight() - this.f4237a.getLeft()) + this.f4237a.getScrollX(), (this.f4237a.getBottom() - this.f4237a.getTop()) + this.f4237a.getScrollY());
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    return m5917a(this.f4237a.getScrollX(), this.f4237a.f4276U + this.f4237a.f4272Q, this.f4237a.getScrollX() + (this.f4237a.getRight() - this.f4237a.getLeft()), this.f4237a.f4277V - this.f4237a.f4272Q);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    return m5918a(3, m5925c(), this.f4237a.getScrollX(), this.f4237a.getScrollY(), (this.f4237a.getRight() - this.f4237a.getLeft()) + this.f4237a.getScrollX(), this.f4237a.f4272Q + this.f4237a.f4276U);
                default:
                    return super.createAccessibilityNodeInfo(i);
            }
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String toLowerCase = str.toLowerCase();
            List arrayList = new ArrayList();
            switch (i) {
                case -1:
                    m5921a(toLowerCase, 3, arrayList);
                    m5921a(toLowerCase, 2, arrayList);
                    m5921a(toLowerCase, 1, arrayList);
                    return arrayList;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    m5921a(toLowerCase, i, arrayList);
                    return arrayList;
                default:
                    return super.findAccessibilityNodeInfosByText(str, i);
            }
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            boolean z = false;
            switch (i) {
                case -1:
                    switch (i2) {
                        case 64:
                            if (this.f4240d == i) {
                                return false;
                            }
                            this.f4240d = i;
                            return true;
                        case 128:
                            if (this.f4240d != i) {
                                return false;
                            }
                            this.f4240d = Integer.MIN_VALUE;
                            return true;
                        case 4096:
                            if (!this.f4237a.isEnabled()) {
                                return false;
                            }
                            if (!this.f4237a.getWrapSelectorWheel() && this.f4237a.getValue() >= this.f4237a.getMaxValue()) {
                                return false;
                            }
                            this.f4237a.m5951a(true);
                            return true;
                        case 8192:
                            if (!this.f4237a.isEnabled()) {
                                return false;
                            }
                            if (!this.f4237a.getWrapSelectorWheel() && this.f4237a.getValue() <= this.f4237a.getMinValue()) {
                                return false;
                            }
                            this.f4237a.m5951a(false);
                            return true;
                        default:
                            break;
                    }
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    switch (i2) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            if (!this.f4237a.isEnabled()) {
                                return false;
                            }
                            this.f4237a.m5951a(true);
                            m5927a(i, 1);
                            return true;
                        case 64:
                            if (this.f4240d == i) {
                                return false;
                            }
                            this.f4240d = i;
                            m5927a(i, 32768);
                            this.f4237a.invalidate(0, this.f4237a.f4277V, this.f4237a.getRight(), this.f4237a.getBottom());
                            return true;
                        case 128:
                            if (this.f4240d != i) {
                                return false;
                            }
                            this.f4240d = Integer.MIN_VALUE;
                            m5927a(i, 65536);
                            this.f4237a.invalidate(0, this.f4237a.f4277V, this.f4237a.getRight(), this.f4237a.getBottom());
                            return true;
                        default:
                            return false;
                    }
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    switch (i2) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            if (!this.f4237a.isEnabled() || this.f4237a.f4281e.isFocused()) {
                                return false;
                            }
                            return this.f4237a.f4281e.requestFocus();
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            if (!this.f4237a.isEnabled() || !this.f4237a.f4281e.isFocused()) {
                                return false;
                            }
                            this.f4237a.f4281e.clearFocus();
                            return true;
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            if (this.f4237a.isEnabled()) {
                                return true;
                            }
                            return false;
                        case 64:
                            if (this.f4240d == i) {
                                return false;
                            }
                            this.f4240d = i;
                            m5927a(i, 32768);
                            this.f4237a.f4281e.invalidate();
                            return true;
                        case 128:
                            if (this.f4240d != i) {
                                return false;
                            }
                            this.f4240d = Integer.MIN_VALUE;
                            m5927a(i, 65536);
                            this.f4237a.f4281e.invalidate();
                            return true;
                        default:
                            return this.f4237a.f4281e.performAccessibilityAction(i2, bundle);
                    }
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    switch (i2) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            if (!this.f4237a.isEnabled()) {
                                return false;
                            }
                            if (i == 1) {
                                z = true;
                            }
                            this.f4237a.m5951a(z);
                            m5927a(i, 1);
                            return true;
                        case 64:
                            if (this.f4240d == i) {
                                return false;
                            }
                            this.f4240d = i;
                            m5927a(i, 32768);
                            this.f4237a.invalidate(0, 0, this.f4237a.getRight(), this.f4237a.f4276U);
                            return true;
                        case 128:
                            if (this.f4240d != i) {
                                return false;
                            }
                            this.f4240d = Integer.MIN_VALUE;
                            m5927a(i, 65536);
                            this.f4237a.invalidate(0, 0, this.f4237a.getRight(), this.f4237a.f4276U);
                            return true;
                        default:
                            return false;
                    }
            }
            return super.performAction(i, i2, bundle);
        }

        public void m5927a(int i, int i2) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (m5924b()) {
                        m5920a(i, i2, m5926d());
                    }
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    m5919a(i2);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    if (m5922a()) {
                        m5920a(i, i2, m5925c());
                    }
                default:
            }
        }

        private void m5919a(int i) {
            if (((AccessibilityManager) this.f4237a.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
                this.f4237a.f4281e.onInitializeAccessibilityEvent(obtain);
                this.f4237a.f4281e.onPopulateAccessibilityEvent(obtain);
                obtain.setSource(this.f4237a, 2);
                this.f4237a.requestSendAccessibilityEvent(this.f4237a, obtain);
            }
        }

        private void m5920a(int i, int i2, String str) {
            if (((AccessibilityManager) this.f4237a.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(this.f4237a.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(this.f4237a.isEnabled());
                obtain.setSource(this.f4237a, i);
                this.f4237a.requestSendAccessibilityEvent(this.f4237a, obtain);
            }
        }

        private void m5921a(String str, int i, List<AccessibilityNodeInfo> list) {
            Object d;
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    d = m5926d();
                    if (!TextUtils.isEmpty(d) && d.toString().toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(1));
                    }
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    CharSequence text = this.f4237a.f4281e.getText();
                    if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
                        text = this.f4237a.f4281e.getText();
                        if (!TextUtils.isEmpty(text) && text.toString().toLowerCase().contains(str)) {
                            list.add(createAccessibilityNodeInfo(2));
                            return;
                        }
                        return;
                    }
                    list.add(createAccessibilityNodeInfo(2));
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    d = m5925c();
                    if (!TextUtils.isEmpty(d) && d.toString().toLowerCase().contains(str)) {
                        list.add(createAccessibilityNodeInfo(3));
                    }
                default:
            }
        }

        private AccessibilityNodeInfo m5917a(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo createAccessibilityNodeInfo = this.f4237a.f4281e.createAccessibilityNodeInfo();
            createAccessibilityNodeInfo.setSource(this.f4237a, 2);
            if (this.f4240d != 2) {
                createAccessibilityNodeInfo.addAction(64);
            }
            if (this.f4240d == 2) {
                createAccessibilityNodeInfo.addAction(128);
            }
            Rect rect = this.f4238b;
            rect.set(i, i2, i3, i4);
            createAccessibilityNodeInfo.setVisibleToUser(this.f4237a.getVisibility() == 0);
            createAccessibilityNodeInfo.setBoundsInParent(rect);
            int[] iArr = this.f4239c;
            this.f4237a.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            createAccessibilityNodeInfo.setBoundsInScreen(rect);
            return createAccessibilityNodeInfo;
        }

        private AccessibilityNodeInfo m5918a(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(this.f4237a.getContext().getPackageName());
            obtain.setSource(this.f4237a, i);
            obtain.setParent(this.f4237a);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(this.f4237a.isEnabled());
            Rect rect = this.f4238b;
            rect.set(i2, i3, i4, i5);
            obtain.setVisibleToUser(this.f4237a.getVisibility() == 0);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.f4239c;
            this.f4237a.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.f4240d != i) {
                obtain.addAction(64);
            }
            if (this.f4240d == i) {
                obtain.addAction(128);
            }
            if (this.f4237a.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        private AccessibilityNodeInfo m5923b(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(NumberPicker.class.getName());
            obtain.setPackageName(this.f4237a.getContext().getPackageName());
            obtain.setSource(this.f4237a);
            if (m5922a()) {
                obtain.addChild(this.f4237a, 3);
            }
            obtain.addChild(this.f4237a, 2);
            if (m5924b()) {
                obtain.addChild(this.f4237a, 1);
            }
            obtain.setParent((View) this.f4237a.getParentForAccessibility());
            obtain.setEnabled(this.f4237a.isEnabled());
            obtain.setScrollable(true);
            Rect rect = this.f4238b;
            rect.set(i, i2, i3, i4);
            obtain.setBoundsInParent(rect);
            obtain.setVisibleToUser(this.f4237a.getVisibility() == 0);
            int[] iArr = this.f4239c;
            this.f4237a.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.f4240d != -1) {
                obtain.addAction(64);
            }
            if (this.f4240d == -1) {
                obtain.addAction(128);
            }
            if (this.f4237a.isEnabled()) {
                if (this.f4237a.getWrapSelectorWheel() || this.f4237a.getValue() < this.f4237a.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (this.f4237a.getWrapSelectorWheel() || this.f4237a.getValue() > this.f4237a.getMinValue()) {
                    obtain.addAction(8192);
                }
            }
            return obtain;
        }

        private boolean m5922a() {
            return this.f4237a.getWrapSelectorWheel() || this.f4237a.getValue() > this.f4237a.getMinValue();
        }

        private boolean m5924b() {
            return this.f4237a.getWrapSelectorWheel() || this.f4237a.getValue() < this.f4237a.getMaxValue();
        }

        private String m5925c() {
            int j = this.f4237a.f4293q - 1;
            if (this.f4237a.f4270O) {
                j = this.f4237a.m5965c(j);
            }
            if (j < this.f4237a.f4291o) {
                return null;
            }
            if (this.f4237a.f4290n == null) {
                return this.f4237a.m5975e(j);
            }
            return this.f4237a.f4290n[j - this.f4237a.f4291o];
        }

        private String m5926d() {
            int j = this.f4237a.f4293q + 1;
            if (this.f4237a.f4270O) {
                j = this.f4237a.m5965c(j);
            }
            if (j > this.f4237a.f4292p) {
                return null;
            }
            if (this.f4237a.f4290n == null) {
                return this.f4237a.m5975e(j);
            }
            return this.f4237a.f4290n[j - this.f4237a.f4291o];
        }
    }

    class BeginSoftInputOnLongPressCommand implements Runnable {
        final /* synthetic */ NumberPicker f4241a;

        BeginSoftInputOnLongPressCommand(NumberPicker numberPicker) {
            this.f4241a = numberPicker;
        }

        public void run() {
            this.f4241a.f4274S = true;
        }
    }

    class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        final /* synthetic */ NumberPicker f4242a;
        private boolean f4243b;

        ChangeCurrentByOneFromLongPressCommand(NumberPicker numberPicker) {
            this.f4242a = numberPicker;
        }

        private void m5929a(boolean z) {
            this.f4243b = z;
        }

        public void run() {
            this.f4242a.m5951a(this.f4243b);
            this.f4242a.postDelayed(this, this.f4242a.f4297u);
        }
    }

    public static class CustomEditText extends EditText {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }
    }

    public interface Formatter {
        String m5930a(int i);
    }

    class InputTextFilter extends NumberKeyListener {
        final /* synthetic */ NumberPicker f4244a;

        InputTextFilter(NumberPicker numberPicker) {
            this.f4244a = numberPicker;
        }

        public int getInputType() {
            return 1;
        }

        protected char[] getAcceptedChars() {
            return NumberPicker.au;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            CharSequence filter;
            String str;
            if (this.f4244a.f4290n == null) {
                filter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (filter == null) {
                    filter = charSequence.subSequence(i, i2);
                }
                str = String.valueOf(spanned.subSequence(0, i3)) + filter + spanned.subSequence(i4, spanned.length());
                if ("".equals(str)) {
                    return str;
                }
                if (this.f4244a.m5944a(str) > this.f4244a.f4292p || str.length() > String.valueOf(this.f4244a.f4292p).length()) {
                    return "";
                }
                return filter;
            }
            filter = String.valueOf(charSequence.subSequence(i, i2));
            if (TextUtils.isEmpty(filter)) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i3)) + filter + spanned.subSequence(i4, spanned.length());
            String toLowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : this.f4244a.f4290n) {
                if (str3.toLowerCase().startsWith(toLowerCase)) {
                    this.f4244a.m5968c(str2.length(), str3.length());
                    return str3.subSequence(i3, str3.length());
                }
            }
            return "";
        }
    }

    static class NumberFormatter implements Formatter {
        private final int f4245a;

        public NumberFormatter() {
            this.f4245a = -1;
        }

        public NumberFormatter(int i) {
            this.f4245a = i;
        }

        public String m5931a(int i) {
            return SimpleNumberFormatter.m4246a(this.f4245a, i);
        }
    }

    public interface OnScrollListener {
        void m5932a(NumberPicker numberPicker, int i);
    }

    class PressedStateHelper implements Runnable {
        final /* synthetic */ NumberPicker f4246a;
        private final int f4247b;
        private final int f4248c;
        private int f4249d;
        private int f4250e;

        PressedStateHelper(NumberPicker numberPicker) {
            this.f4246a = numberPicker;
            this.f4247b = 1;
            this.f4248c = 2;
        }

        public void m5933a() {
            this.f4250e = 0;
            this.f4249d = 0;
            this.f4246a.removeCallbacks(this);
            if (this.f4246a.aa) {
                this.f4246a.aa = false;
                this.f4246a.invalidate(0, this.f4246a.f4277V, this.f4246a.getRight(), this.f4246a.getBottom());
            }
            if (this.f4246a.ab) {
                this.f4246a.ab = false;
                this.f4246a.invalidate(0, 0, this.f4246a.getRight(), this.f4246a.f4276U);
            }
        }

        public void m5934a(int i) {
            m5933a();
            this.f4250e = 1;
            this.f4249d = i;
            this.f4246a.postDelayed(this, (long) ViewConfiguration.getTapTimeout());
        }

        public void m5935b(int i) {
            m5933a();
            this.f4250e = 2;
            this.f4249d = i;
            this.f4246a.post(this);
        }

        public void run() {
            switch (this.f4250e) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    switch (this.f4249d) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            this.f4246a.aa = true;
                            this.f4246a.invalidate(0, this.f4246a.f4277V, this.f4246a.getRight(), this.f4246a.getBottom());
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            this.f4246a.ab = true;
                            this.f4246a.invalidate(0, 0, this.f4246a.getRight(), this.f4246a.f4276U);
                        default:
                    }
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    switch (this.f4249d) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            if (!this.f4246a.aa) {
                                this.f4246a.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                            }
                            this.f4246a.aa = this.f4246a.aa ^ 1;
                            this.f4246a.invalidate(0, this.f4246a.f4277V, this.f4246a.getRight(), this.f4246a.getBottom());
                        case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                            if (!this.f4246a.ab) {
                                this.f4246a.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                            }
                            this.f4246a.ab = this.f4246a.ab ^ 1;
                            this.f4246a.invalidate(0, 0, this.f4246a.getRight(), this.f4246a.f4276U);
                        default:
                    }
                default:
            }
        }
    }

    class SetSelectionCommand implements Runnable {
        final /* synthetic */ NumberPicker f4251a;
        private int f4252b;
        private int f4253c;

        SetSelectionCommand(NumberPicker numberPicker) {
            this.f4251a = numberPicker;
        }

        public void run() {
            this.f4251a.f4281e.setSelection(this.f4252b, this.f4253c);
        }
    }

    static {
        f4255b = C0264R.layout.numberpicker_layout;
        f4254a = new NumberFormatter(2);
        af = new int[]{16842919};
        au = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.numberPickerStyle);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4279c = 1;
        this.f4280d = 2;
        this.f4286j = 400;
        this.f4297u = 300;
        this.f4298v = new SparseArray();
        this.f4299w = new int[5];
        this.f4302z = Integer.MIN_VALUE;
        this.f4273R = 0;
        this.ae = -1;
        this.ah = 30;
        this.aj = 25;
        this.ak = 14;
        this.al = 10;
        this.am = -303101;
        this.an = 2130706432;
        this.ap = -303101;
        this.at = 1.0f;
        float f = getResources().getDisplayMetrics().density;
        if (f != 1.0f) {
            this.ak = (int) (((float) this.ak) * f);
            this.aj = (int) (((float) this.aj) * f);
            this.al = (int) (((float) this.al) * f);
            this.f4279c = (int) (((float) this.f4279c) * f);
            this.f4280d = (int) (((float) this.f4280d) * f);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0264R.styleable.NumberPicker, i, 0);
        this.aq = obtainStyledAttributes.getText(C0264R.styleable.NumberPicker_android_text);
        this.aj = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.NumberPicker_textSizeHighlight, this.aj);
        this.ak = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.NumberPicker_textSizeHint, this.ak);
        this.al = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.NumberPicker_android_labelTextSize, this.al);
        this.am = obtainStyledAttributes.getColor(C0264R.styleable.NumberPicker_android_textColorHighlight, this.am);
        this.an = obtainStyledAttributes.getColor(C0264R.styleable.NumberPicker_android_textColorHint, this.an);
        this.ap = obtainStyledAttributes.getColor(C0264R.styleable.NumberPicker_labelTextColor, this.ap);
        this.ah = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.NumberPicker_labelPadding, this.ah);
        obtainStyledAttributes.recycle();
        this.ar = new SoundPool(1, 1, 0);
        this.as = this.ar.load(getContext(), C0264R.raw.numberpicker_value_change, 1);
        int i2 = C0264R.layout.numberpicker_layout;
        this.f4271P = true;
        this.f4272Q = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.f4282f = (int) (45.0f * f);
        this.f4283g = -1;
        this.f4284h = (int) (f * 202.0f);
        if (this.f4283g == -1 || this.f4284h == -1 || this.f4283g <= this.f4284h) {
            this.f4285i = -1;
            this.f4286j = -1;
            if (this.f4285i == -1 || this.f4286j == -1 || this.f4285i <= this.f4286j) {
                boolean z;
                this.f4287k = this.f4286j == -1;
                this.ad = new PressedStateHelper(this);
                if (this.f4271P) {
                    z = false;
                } else {
                    z = true;
                }
                setWillNotDraw(z);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i2, this, true);
                this.f4281e = (EditText) findViewById(C0264R.id.numberpicker_input);
                this.f4281e.setOnFocusChangeListener(new C04961(this));
                this.f4281e.setFilters(new InputFilter[]{new InputTextFilter(this)});
                this.f4281e.setRawInputType(2);
                this.f4281e.setImeOptions(6);
                this.f4281e.setVisibility(4);
                this.f4281e.setGravity(8388611);
                this.f4281e.setScaleX(0.0f);
                this.f4281e.setSaveEnabled(false);
                this.f4281e.setPadding(this.ah, this.f4281e.getPaddingTop(), this.ah, this.f4281e.getPaddingRight());
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.f4267L = viewConfiguration.getScaledTouchSlop();
                this.f4268M = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f4269N = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                this.f4288l = (int) this.f4281e.getTextSize();
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextAlign(Align.CENTER);
                paint.setTextSize((float) this.aj);
                paint.setTypeface(this.f4281e.getTypeface());
                paint.setColor(this.f4281e.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
                this.f4300x = paint;
                this.ao = paint.ascent();
                this.ag = new Paint();
                this.ag.setAntiAlias(true);
                this.ag.setFakeBoldText(true);
                this.ag.setColor(this.ap);
                this.ag.setTextSize((float) this.al);
                this.f4257B = new Scroller(getContext(), null, true);
                this.f4258C = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                m5977f();
                if (getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m5958b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f4271P) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int measuredWidth2 = this.f4281e.getMeasuredWidth();
            int measuredHeight2 = this.f4281e.getMeasuredHeight();
            measuredWidth = (measuredWidth - measuredWidth2) / 2;
            measuredHeight = (measuredHeight - measuredHeight2) / 2;
            this.f4281e.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            if (z) {
                m5970d();
                m5976e();
                this.f4276U = ((getHeight() - this.f4282f) / 2) - this.f4272Q;
                this.f4277V = (this.f4276U + (this.f4272Q * 2)) + this.f4282f;
                return;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f4271P) {
            super.onMeasure(m5940a(i, this.f4286j), m5940a(i2, this.f4284h));
            setMeasuredDimension(m5941a(this.f4285i, getMeasuredWidth(), i), m5941a(this.f4283g, getMeasuredHeight(), i2));
            return;
        }
        super.onMeasure(i, i2);
    }

    private boolean m5954a(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i = this.f4302z - ((this.f4256A + finalY) % this.f4301y);
        if (i == 0) {
            return false;
        }
        if (Math.abs(i) > this.f4301y / 2) {
            if (i > 0) {
                i -= this.f4301y;
            } else {
                i += this.f4301y;
            }
        }
        scrollBy(0, i + finalY);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f4271P || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                m5986j();
                this.f4281e.setVisibility(4);
                float y = motionEvent.getY();
                this.f4263H = y;
                this.f4265J = y;
                this.f4264I = motionEvent.getEventTime();
                this.f4274S = false;
                this.f4275T = false;
                if (this.f4263H < ((float) this.f4276U)) {
                    if (this.f4273R == 0) {
                        this.ad.m5934a(2);
                    }
                } else if (this.f4263H > ((float) this.f4277V) && this.f4273R == 0) {
                    this.ad.m5934a(1);
                }
                if (!this.f4257B.isFinished()) {
                    this.f4257B.forceFinished(true);
                    this.f4258C.forceFinished(true);
                    m5946a(0);
                    return true;
                } else if (!this.f4258C.isFinished()) {
                    this.f4257B.forceFinished(true);
                    this.f4258C.forceFinished(true);
                    return true;
                } else if (this.f4263H < ((float) this.f4276U)) {
                    m5952a(false, (long) ViewConfiguration.getLongPressTimeout());
                    return true;
                } else if (this.f4263H > ((float) this.f4277V)) {
                    m5952a(true, (long) ViewConfiguration.getLongPressTimeout());
                    return true;
                } else {
                    this.f4275T = true;
                    m5982h();
                    return true;
                }
            default:
                return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.f4271P) {
            return false;
        }
        if (this.f4266K == null) {
            this.f4266K = VelocityTracker.obtain();
        }
        this.f4266K.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                m5984i();
                m5980g();
                this.ad.m5933a();
                VelocityTracker velocityTracker = this.f4266K;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f4269N);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) >= Math.abs(this.f4269N)) {
                    yVelocity = (int) (((float) yVelocity) * this.at);
                }
                if (Math.abs(yVelocity) > this.f4268M) {
                    m5959b(yVelocity);
                    m5946a(2);
                } else {
                    yVelocity = (int) motionEvent.getY();
                    long eventTime = motionEvent.getEventTime() - this.f4264I;
                    if (((int) Math.abs(((float) yVelocity) - this.f4263H)) > this.f4267L || eventTime >= ((long) ViewConfiguration.getTapTimeout())) {
                        m5987k();
                    } else if (this.f4275T) {
                        this.f4275T = false;
                    } else {
                        yVelocity = (yVelocity / this.f4301y) - 2;
                        if (yVelocity > 0) {
                            m5951a(true);
                            this.ad.m5935b(1);
                        } else if (yVelocity < 0) {
                            m5951a(false);
                            this.ad.m5935b(2);
                        }
                    }
                    m5946a(0);
                }
                this.f4266K.recycle();
                this.f4266K = null;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (!this.f4274S) {
                    float y = motionEvent.getY();
                    if (this.f4273R == 1) {
                        scrollBy(0, (int) (y - this.f4265J));
                        invalidate();
                    } else if (((int) Math.abs(y - this.f4263H)) > this.f4267L) {
                        m5986j();
                        m5946a(1);
                    }
                    this.f4265J = y;
                    break;
                }
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m5986j();
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
        r5 = this;
        r4 = 20;
        r1 = 1;
        r0 = r6.getKeyCode();
        switch(r0) {
            case 19: goto L_0x0013;
            case 20: goto L_0x0013;
            case 23: goto L_0x000f;
            case 66: goto L_0x000f;
            default: goto L_0x000a;
        };
    L_0x000a:
        r1 = super.dispatchKeyEvent(r6);
    L_0x000e:
        return r1;
    L_0x000f:
        r5.m5986j();
        goto L_0x000a;
    L_0x0013:
        r2 = r5.f4271P;
        if (r2 == 0) goto L_0x000a;
    L_0x0017:
        r2 = r6.getAction();
        switch(r2) {
            case 0: goto L_0x001f;
            case 1: goto L_0x0053;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x000a;
    L_0x001f:
        r2 = r5.f4270O;
        if (r2 != 0) goto L_0x0025;
    L_0x0023:
        if (r0 != r4) goto L_0x0046;
    L_0x0025:
        r2 = r5.getValue();
        r3 = r5.getMaxValue();
        if (r2 >= r3) goto L_0x000a;
    L_0x002f:
        r5.requestFocus();
        r5.ae = r0;
        r5.m5986j();
        r2 = r5.f4257B;
        r2 = r2.isFinished();
        if (r2 == 0) goto L_0x000e;
    L_0x003f:
        if (r0 != r4) goto L_0x0051;
    L_0x0041:
        r0 = r1;
    L_0x0042:
        r5.m5951a(r0);
        goto L_0x000e;
    L_0x0046:
        r2 = r5.getValue();
        r3 = r5.getMinValue();
        if (r2 <= r3) goto L_0x000a;
    L_0x0050:
        goto L_0x002f;
    L_0x0051:
        r0 = 0;
        goto L_0x0042;
    L_0x0053:
        r2 = r5.ae;
        if (r2 != r0) goto L_0x000a;
    L_0x0057:
        r0 = -1;
        r5.ae = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.widget.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m5986j();
                break;
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.f4271P) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            int i;
            int y = (int) motionEvent.getY();
            if (y < this.f4276U) {
                i = 3;
            } else if (y > this.f4277V) {
                i = 1;
            } else {
                i = 2;
            }
            AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = (AccessibilityNodeProviderImpl) getAccessibilityNodeProvider();
            switch (motionEvent.getActionMasked()) {
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    if (!(this.f4278W == i || this.f4278W == -1)) {
                        accessibilityNodeProviderImpl.m5927a(this.f4278W, 256);
                        accessibilityNodeProviderImpl.m5927a(i, 128);
                        this.f4278W = i;
                        accessibilityNodeProviderImpl.performAction(i, 64, null);
                        break;
                    }
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    accessibilityNodeProviderImpl.m5927a(i, 128);
                    this.f4278W = i;
                    accessibilityNodeProviderImpl.performAction(i, 64, null);
                    break;
                case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                    accessibilityNodeProviderImpl.m5927a(i, 256);
                    this.f4278W = -1;
                    break;
            }
        }
        return false;
    }

    public void computeScroll() {
        Scroller scroller = this.f4257B;
        if (scroller.isFinished()) {
            scroller = this.f4258C;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.f4259D == 0) {
            this.f4259D = scroller.getStartY();
        }
        scrollBy(0, currY - this.f4259D);
        this.f4259D = currY;
        if (scroller.isFinished()) {
            m5961b(scroller);
        } else {
            invalidate();
        }
    }

    public void scrollBy(int i, int i2) {
        int[] iArr = this.f4299w;
        if (!this.f4270O && i2 > 0 && iArr[2] <= this.f4291o) {
            this.f4256A = this.f4302z;
        } else if (this.f4270O || i2 >= 0 || iArr[2] < this.f4292p) {
            this.f4256A += i2;
            while (this.f4256A - this.f4302z > this.f4289m) {
                this.f4256A -= this.f4301y;
                m5962b(iArr);
                m5947a(iArr[2], true);
                if (!this.f4270O && iArr[2] <= this.f4291o) {
                    this.f4256A = this.f4302z;
                }
            }
            while (this.f4256A - this.f4302z < (-this.f4289m)) {
                this.f4256A += this.f4301y;
                m5953a(iArr);
                m5947a(iArr[2], true);
                if (!this.f4270O && iArr[2] >= this.f4292p) {
                    this.f4256A = this.f4302z;
                }
            }
        } else {
            this.f4256A = this.f4302z;
        }
    }

    public void setLabel(String str) {
        if ((this.aq == null && str != null) || (this.aq != null && !this.aq.equals(str))) {
            this.aq = str;
            invalidate();
        }
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.f4294r = onValueChangeListener;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f4295s = onScrollListener;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter != this.f4296t) {
            this.f4296t = formatter;
            m5967c();
            m5977f();
        }
    }

    public void setValue(int i) {
        m5947a(i, false);
    }

    private void m5958b() {
        if (this.f4287k) {
            float measureText;
            float f = -1.0f;
            this.f4300x.setTextSize((float) this.aj);
            int i;
            if (this.f4290n == null) {
                f = 0.0f;
                i = 0;
                while (i < 9) {
                    measureText = this.f4300x.measureText(String.valueOf(i));
                    if (measureText <= f) {
                        measureText = f;
                    }
                    i++;
                    f = measureText;
                }
                f = (float) ((int) (((float) m5975e(this.f4292p).length()) * f));
            } else {
                int length = this.f4290n.length;
                i = 0;
                while (i < length) {
                    measureText = this.f4300x.measureText(this.f4290n[i]);
                    if (measureText <= f) {
                        measureText = f;
                    }
                    i++;
                    f = measureText;
                }
            }
            this.ai = f;
            measureText = ((((float) (this.f4281e.getPaddingLeft() + this.f4281e.getPaddingRight())) + f) + ((float) getPaddingLeft())) + ((float) getPaddingRight());
            if (((float) this.f4286j) == measureText) {
                return;
            }
            if (measureText > ((float) this.f4285i)) {
                this.f4286j = (int) measureText;
            } else {
                this.f4286j = this.f4285i;
            }
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.f4270O;
    }

    public void setWrapSelectorWheel(boolean z) {
        Object obj = this.f4292p - this.f4291o >= this.f4299w.length ? 1 : null;
        if (!((z && obj == null) || z == this.f4270O)) {
            this.f4270O = z;
        }
        m5990l();
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.f4297u = j;
    }

    public int getValue() {
        return this.f4293q;
    }

    public int getMinValue() {
        return this.f4291o;
    }

    public void setMinValue(int i) {
        if (this.f4291o != i) {
            if (i < 0) {
                throw new IllegalArgumentException("minValue must be >= 0");
            }
            this.f4291o = i;
            if (this.f4291o > this.f4293q) {
                this.f4293q = this.f4291o;
            }
            setWrapSelectorWheel(this.f4292p - this.f4291o > this.f4299w.length);
            m5967c();
            m5977f();
            m5958b();
            invalidate();
        }
    }

    public int getMaxValue() {
        return this.f4292p;
    }

    public void setMaxValue(int i) {
        if (this.f4292p != i) {
            if (i < 0) {
                throw new IllegalArgumentException("maxValue must be >= 0");
            }
            this.f4292p = i;
            if (this.f4292p < this.f4293q) {
                this.f4293q = this.f4292p;
            }
            setWrapSelectorWheel(this.f4292p - this.f4291o > this.f4299w.length);
            m5967c();
            m5977f();
            m5958b();
            invalidate();
        }
    }

    public String[] getDisplayedValues() {
        return this.f4290n;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f4290n != strArr) {
            this.f4290n = strArr;
            if (this.f4290n != null) {
                this.f4281e.setRawInputType(524289);
            } else {
                this.f4281e.setRawInputType(2);
            }
            m5977f();
            m5967c();
            m5958b();
        }
    }

    public void setMaxFlingSpeedFactor(float f) {
        if (f >= 0.0f) {
            this.at = f;
        }
    }

    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5986j();
        this.ar.release();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4271P) {
            getWidth();
            float paddingLeft = (float) (((getPaddingLeft() + (getRight() - getLeft())) - getPaddingRight()) / 2);
            float f = (float) this.f4256A;
            float f2 = (float) (this.f4302z + (this.f4301y * 2));
            SparseArray sparseArray = this.f4298v;
            int[] iArr = this.f4299w;
            float f3 = f;
            for (int i : iArr) {
                String str = (String) sparseArray.get(i);
                float abs = Math.abs(f2 - f3) / ((float) this.f4301y);
                float a = m5938a(abs, this.aj, this.ak);
                this.f4300x.setTextSize(a);
                this.f4300x.setColor(m5939a(abs, this.an, false));
                canvas.drawText(str, paddingLeft, ((a - ((float) this.ak)) / 2.0f) + f3, this.f4300x);
                if (abs < 1.0f) {
                    this.f4300x.setColor(m5939a(abs, this.am, true));
                    canvas.drawText(str, paddingLeft, ((a - ((float) this.ak)) / 2.0f) + f3, this.f4300x);
                }
                f3 += (float) this.f4301y;
            }
            if (!TextUtils.isEmpty(this.aq) && !DeviceHelper.f2554f) {
                canvas.drawText(this.aq.toString(), ViewUtils.m5452a((View) this) ? ((paddingLeft - (this.ai / 2.0f)) - ((float) this.f4279c)) - this.ag.measureText(this.aq.toString()) : ((this.ai / 2.0f) + paddingLeft) + ((float) this.f4279c), ((f2 - ((float) (this.aj / 2))) + ((float) (this.al / 2))) + ((float) this.f4280d), this.ag);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    private int m5939a(float f, int i, boolean z) {
        if (f >= 1.0f) {
            return i;
        }
        int alpha;
        if (z) {
            alpha = (int) (((-f) * ((float) Color.alpha(i))) + ((float) Color.alpha(i)));
        } else {
            alpha = (int) (((float) Color.alpha(i)) * f);
        }
        return (16777215 & i) | (alpha << 24);
    }

    private float m5938a(float f, int i, int i2) {
        if (f >= 1.0f) {
            return (float) i2;
        }
        return (((float) (i2 - i)) * f) + ((float) i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.f4291o + this.f4293q) * this.f4301y);
        accessibilityEvent.setMaxScrollY((this.f4292p - this.f4291o) * this.f4301y);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.f4271P) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.ac == null) {
            this.ac = new AccessibilityNodeProviderImpl(this);
        }
        return this.ac;
    }

    private int m5940a(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                return MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return MeasureSpec.makeMeasureSpec(i2, 1073741824);
            case 1073741824:
                return i;
            default:
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
    }

    private int m5941a(int i, int i2, int i3) {
        if (i != -1) {
            return resolveSizeAndState(Math.max(i, i2), i3, 0);
        }
        return i2;
    }

    private void m5967c() {
        this.f4298v.clear();
        int[] iArr = this.f4299w;
        int value = getValue();
        for (int i = 0; i < this.f4299w.length; i++) {
            int i2 = (i - 2) + value;
            if (this.f4270O) {
                i2 = m5965c(i2);
            }
            iArr[i] = i2;
            m5971d(iArr[i]);
        }
    }

    private void m5947a(int i, boolean z) {
        if (this.f4293q != i) {
            int c;
            if (this.f4270O) {
                c = m5965c(i);
            } else {
                c = Math.min(Math.max(i, this.f4291o), this.f4292p);
            }
            int i2 = this.f4293q;
            this.f4293q = c;
            m5977f();
            if (z) {
                m5960b(i2, c);
            }
            m5967c();
            invalidate();
        }
    }

    private void m5951a(boolean z) {
        if (this.f4271P) {
            this.f4281e.setVisibility(4);
            if (!m5954a(this.f4257B)) {
                m5954a(this.f4258C);
            }
            this.f4259D = 0;
            if (z) {
                this.f4257B.startScroll(0, 0, 0, -this.f4301y, 300);
            } else {
                this.f4257B.startScroll(0, 0, 0, this.f4301y, 300);
            }
            invalidate();
        } else if (z) {
            m5947a(this.f4293q + 1, true);
        } else {
            m5947a(this.f4293q - 1, true);
        }
    }

    private void m5970d() {
        m5967c();
        int[] iArr = this.f4299w;
        this.f4289m = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.f4288l))) / ((float) iArr.length)) + 0.5f);
        this.f4301y = this.f4288l + this.f4289m;
        this.f4302z = (this.f4281e.getBaseline() + this.f4281e.getTop()) - (this.f4301y * 2);
        this.f4256A = this.f4302z;
        m5977f();
    }

    private void m5976e() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.f4288l) / 2);
    }

    private void m5961b(Scroller scroller) {
        if (scroller == this.f4257B) {
            if (!m5987k()) {
                m5977f();
            }
            m5946a(0);
        } else if (this.f4273R != 1) {
            m5977f();
        }
    }

    private void m5946a(int i) {
        if (this.f4273R != i) {
            this.f4273R = i;
            if (this.f4295s != null) {
                this.f4295s.m5932a(this, i);
            }
        }
    }

    private void m5959b(int i) {
        this.f4259D = 0;
        if (i > 0) {
            this.f4257B.fling(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.f4257B.fling(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    private int m5965c(int i) {
        if (i > this.f4292p) {
            return (this.f4291o + ((i - this.f4292p) % (this.f4292p - this.f4291o))) - 1;
        }
        if (i < this.f4291o) {
            return (this.f4292p - ((this.f4291o - i) % (this.f4292p - this.f4291o))) + 1;
        }
        return i;
    }

    private void m5953a(int[] iArr) {
        int i;
        for (i = 0; i < iArr.length - 1; i++) {
            iArr[i] = iArr[i + 1];
        }
        i = iArr[iArr.length - 2] + 1;
        if (this.f4270O && i > this.f4292p) {
            i = this.f4291o;
        }
        iArr[iArr.length - 1] = i;
        m5971d(i);
    }

    private void m5962b(int[] iArr) {
        int length;
        for (length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        length = iArr[1] - 1;
        if (this.f4270O && length < this.f4291o) {
            length = this.f4292p;
        }
        iArr[0] = length;
        m5971d(length);
    }

    private void m5971d(int i) {
        SparseArray sparseArray = this.f4298v;
        if (((String) sparseArray.get(i)) == null) {
            Object obj;
            if (i < this.f4291o || i > this.f4292p) {
                obj = "";
            } else if (this.f4290n != null) {
                obj = this.f4290n[i - this.f4291o];
            } else {
                obj = m5975e(i);
            }
            sparseArray.put(i, obj);
        }
    }

    private String m5975e(int i) {
        return this.f4296t != null ? this.f4296t.m5930a(i) : SimpleNumberFormatter.m4245a(i);
    }

    private void m5948a(View view) {
        Object valueOf = String.valueOf(((TextView) view).getText());
        if (TextUtils.isEmpty(valueOf)) {
            m5977f();
        } else {
            m5947a(m5944a(valueOf.toString()), true);
        }
    }

    private boolean m5977f() {
        CharSequence e = this.f4290n == null ? m5975e(this.f4293q) : this.f4290n[this.f4293q - this.f4291o];
        if (TextUtils.isEmpty(e) || e.equals(this.f4281e.getText().toString())) {
            return false;
        }
        this.f4281e.setText(e);
        return true;
    }

    private void m5960b(int i, int i2) {
        this.ar.play(this.as, 1.0f, 1.0f, 0, 0, 1.0f);
        if (this.f4294r != null) {
            this.f4294r.m3082a(this, i, this.f4293q);
        }
    }

    private void m5952a(boolean z, long j) {
        if (this.f4261F == null) {
            this.f4261F = new ChangeCurrentByOneFromLongPressCommand(this);
        } else {
            removeCallbacks(this.f4261F);
        }
        this.f4261F.m5929a(z);
        postDelayed(this.f4261F, j);
    }

    private void m5980g() {
        if (this.f4261F != null) {
            removeCallbacks(this.f4261F);
        }
    }

    private void m5982h() {
        if (this.f4262G == null) {
            this.f4262G = new BeginSoftInputOnLongPressCommand(this);
        } else {
            removeCallbacks(this.f4262G);
        }
        postDelayed(this.f4262G, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void m5984i() {
        if (this.f4262G != null) {
            removeCallbacks(this.f4262G);
        }
    }

    private void m5986j() {
        if (this.f4261F != null) {
            removeCallbacks(this.f4261F);
        }
        if (this.f4260E != null) {
            removeCallbacks(this.f4260E);
        }
        if (this.f4262G != null) {
            removeCallbacks(this.f4262G);
        }
        this.ad.m5933a();
    }

    private int m5944a(String str) {
        if (this.f4290n == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return this.f4291o;
            }
        }
        for (int i = 0; i < this.f4290n.length; i++) {
            str = str.toLowerCase();
            if (this.f4290n[i].toLowerCase().startsWith(str)) {
                return i + this.f4291o;
            }
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            return this.f4291o;
        }
    }

    private void m5968c(int i, int i2) {
        if (this.f4260E == null) {
            this.f4260E = new SetSelectionCommand(this);
        } else {
            removeCallbacks(this.f4260E);
        }
        this.f4260E.f4252b = i;
        this.f4260E.f4253c = i2;
        post(this.f4260E);
    }

    private boolean m5987k() {
        int i = this.f4302z - this.f4256A;
        if (i == 0) {
            return false;
        }
        this.f4259D = 0;
        if (Math.abs(i) > this.f4301y / 2) {
            i += i > 0 ? -this.f4301y : this.f4301y;
        }
        this.f4258C.startScroll(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    private void m5990l() {
        m5967c();
        invalidate();
    }
}
