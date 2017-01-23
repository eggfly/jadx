package com.miui.support.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.date.Calendar;
import com.miui.support.date.CalendarFormatSymbols;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AppConstants;
import com.miui.support.widget.NumberPicker.OnValueChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

public class DatePicker extends FrameLayout {
    private static final String f4024a;
    private static final String[] f4025j;
    private static final String[] f4026k;
    private static final String[] f4027l;
    private static final String f4028m;
    private final LinearLayout f4029b;
    private final NumberPicker f4030c;
    private final NumberPicker f4031d;
    private final NumberPicker f4032e;
    private Locale f4033f;
    private OnDateChangedListener f4034g;
    private String[] f4035h;
    private char[] f4036i;
    private final DateFormat f4037n;
    private int f4038o;
    private Calendar f4039p;
    private Calendar f4040q;
    private Calendar f4041r;
    private Calendar f4042s;
    private boolean f4043t;
    private boolean f4044u;

    public interface OnDateChangedListener {
        void m3273a(DatePicker datePicker, int i, int i2, int i3, boolean z);
    }

    /* renamed from: com.miui.support.widget.DatePicker.1 */
    class C04581 implements OnValueChangeListener {
        final /* synthetic */ DatePicker f4019a;

        C04581(DatePicker datePicker) {
            this.f4019a = datePicker;
        }

        public void m5721a(NumberPicker numberPicker, int i, int i2) {
            this.f4019a.f4039p.m3385a(this.f4019a.f4042s.m3382a());
            if (numberPicker == this.f4019a.f4030c) {
                this.f4019a.f4039p.m3392b(this.f4019a.f4044u ? 10 : 9, i2 - i);
            } else if (numberPicker == this.f4019a.f4031d) {
                this.f4019a.f4039p.m3392b(this.f4019a.f4044u ? 6 : 5, i2 - i);
            } else if (numberPicker == this.f4019a.f4032e) {
                this.f4019a.f4039p.m3383a(this.f4019a.f4044u ? 2 : 1, i2);
            } else {
                throw new IllegalArgumentException();
            }
            this.f4019a.m5730a(this.f4019a.f4039p.m3380a(1), this.f4019a.f4039p.m3380a(5), this.f4019a.f4039p.m3380a(9));
            if (numberPicker == this.f4019a.f4032e) {
                this.f4019a.m5735b();
            }
            this.f4019a.m5738d();
            this.f4019a.m5741e();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        private final int f4020a;
        private final int f4021b;
        private final int f4022c;
        private final boolean f4023d;

        /* renamed from: com.miui.support.widget.DatePicker.SavedState.1 */
        final class C04591 implements Creator<SavedState> {
            C04591() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5722a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5723a(i);
            }

            public SavedState m5722a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m5723a(int i) {
                return new SavedState[i];
            }
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3, boolean z) {
            super(parcelable);
            this.f4020a = i;
            this.f4021b = i2;
            this.f4022c = i3;
            this.f4023d = z;
        }

        private SavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            this.f4020a = parcel.readInt();
            this.f4021b = parcel.readInt();
            this.f4022c = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f4023d = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4020a);
            parcel.writeInt(this.f4021b);
            parcel.writeInt(this.f4022c);
            parcel.writeInt(this.f4023d ? 1 : 0);
        }

        static {
            CREATOR = new C04591();
        }
    }

    static {
        f4024a = DatePicker.class.getSimpleName();
        f4025j = CalendarFormatSymbols.m3401a().m3404d();
        f4026k = CalendarFormatSymbols.m3401a().m3409i();
        Resources resources = AppConstants.m4227a().getResources();
        for (int i = 0; i < f4026k.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] strArr = f4026k;
            strArr[i] = stringBuilder.append(strArr[i]).append(resources.getString(C0264R.string.chinese_month)).toString();
        }
        f4027l = new String[(f4026k.length + 1)];
        f4028m = CalendarFormatSymbols.m3401a().m3408h()[1];
    }

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.datePickerStyle);
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4037n = new SimpleDateFormat("MM/dd/yyyy");
        this.f4043t = true;
        this.f4044u = false;
        this.f4039p = new Calendar();
        this.f4040q = new Calendar();
        this.f4041r = new Calendar();
        this.f4042s = new Calendar();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.DatePicker, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(C0264R.styleable.DatePicker_spinnersShown, true);
        int i2 = obtainStyledAttributes.getInt(C0264R.styleable.DatePicker_startYear, 1900);
        int i3 = obtainStyledAttributes.getInt(C0264R.styleable.DatePicker_endYear, 2100);
        Object string = obtainStyledAttributes.getString(C0264R.styleable.DatePicker_minDate);
        Object string2 = obtainStyledAttributes.getString(C0264R.styleable.DatePicker_maxDate);
        int i4 = C0264R.layout.date_picker;
        this.f4044u = obtainStyledAttributes.getBoolean(C0264R.styleable.DatePicker_lunarCalendar, false);
        boolean z2 = obtainStyledAttributes.getBoolean(C0264R.styleable.DatePicker_showYear, true);
        boolean z3 = obtainStyledAttributes.getBoolean(C0264R.styleable.DatePicker_showMonth, true);
        boolean z4 = obtainStyledAttributes.getBoolean(C0264R.styleable.DatePicker_showDay, true);
        obtainStyledAttributes.recycle();
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i4, this, true);
        OnValueChangeListener c04581 = new C04581(this);
        this.f4029b = (LinearLayout) findViewById(C0264R.id.pickers);
        this.f4030c = (NumberPicker) findViewById(C0264R.id.day);
        this.f4030c.setOnLongPressUpdateInterval(100);
        this.f4030c.setOnValueChangedListener(c04581);
        if (!z4) {
            this.f4030c.setVisibility(8);
        }
        this.f4031d = (NumberPicker) findViewById(C0264R.id.month);
        this.f4031d.setMinValue(0);
        this.f4031d.setMaxValue(this.f4038o - 1);
        this.f4031d.setDisplayedValues(this.f4035h);
        this.f4031d.setOnLongPressUpdateInterval(200);
        this.f4031d.setOnValueChangedListener(c04581);
        if (!z3) {
            this.f4031d.setVisibility(8);
        }
        this.f4032e = (NumberPicker) findViewById(C0264R.id.year);
        this.f4032e.setOnLongPressUpdateInterval(100);
        this.f4032e.setOnValueChangedListener(c04581);
        if (!z2) {
            this.f4032e.setVisibility(8);
        }
        m5729a();
        if (z) {
            setSpinnersShown(z);
        } else {
            setSpinnersShown(true);
        }
        this.f4039p.m3385a(0);
        if (TextUtils.isEmpty(string)) {
            this.f4039p.m3384a(i2, 0, 1, 0, 0, 0, 0);
        } else if (!m5733a(string, this.f4039p)) {
            this.f4039p.m3384a(i2, 0, 1, 0, 0, 0, 0);
        }
        setMinDate(this.f4039p.m3382a());
        this.f4039p.m3385a(0);
        if (TextUtils.isEmpty(string2)) {
            this.f4039p.m3384a(i3, 11, 31, 0, 0, 0, 0);
        } else if (!m5733a(string2, this.f4039p)) {
            this.f4039p.m3384a(i3, 11, 31, 0, 0, 0, 0);
        }
        setMaxDate(this.f4039p.m3382a());
        this.f4042s.m3385a(System.currentTimeMillis());
        m5746a(this.f4042s.m3380a(1), this.f4042s.m3380a(5), this.f4042s.m3380a(9), null);
        m5737c();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void m5729a() {
        if (this.f4030c != null && this.f4032e != null) {
            this.f4030c.setFormatter(NumberPicker.f4254a);
            this.f4032e.setFormatter(new NumberFormatter());
        }
    }

    public long getMinDate() {
        return this.f4040q.m3382a();
    }

    public void setMinDate(long j) {
        this.f4039p.m3385a(j);
        if (this.f4039p.m3380a(1) != this.f4040q.m3380a(1) || this.f4039p.m3380a(12) == this.f4040q.m3380a(12)) {
            this.f4040q.m3385a(j);
            if (this.f4042s.m3397c(this.f4040q)) {
                this.f4042s.m3385a(this.f4040q.m3382a());
            }
            m5738d();
        }
    }

    public long getMaxDate() {
        return this.f4041r.m3382a();
    }

    public void setMaxDate(long j) {
        this.f4039p.m3385a(j);
        if (this.f4039p.m3380a(1) != this.f4041r.m3380a(1) || this.f4039p.m3380a(12) == this.f4041r.m3380a(12)) {
            this.f4041r.m3385a(j);
            if (this.f4042s.m3394b(this.f4041r)) {
                this.f4042s.m3385a(this.f4041r.m3382a());
            }
            m5738d();
        }
    }

    public void setEnabled(boolean z) {
        if (this.f4043t != z) {
            super.setEnabled(z);
            this.f4030c.setEnabled(z);
            this.f4031d.setEnabled(z);
            this.f4032e.setEnabled(z);
            this.f4043t = z;
        }
    }

    public boolean isEnabled() {
        return this.f4043t;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.m3428a(this.f4042s.m3382a(), 896));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(DatePicker.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.f4029b.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.f4029b.setVisibility(z ? 0 : 8);
    }

    public void setLunarMode(boolean z) {
        if (z != this.f4044u) {
            this.f4044u = z;
            m5735b();
            m5738d();
        }
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.f4033f)) {
            this.f4033f = locale;
            this.f4038o = this.f4039p.m3391b(5) + 1;
            m5735b();
            m5729a();
        }
    }

    private void m5735b() {
        int i = 0;
        if (this.f4044u) {
            int d = this.f4042s.m3398d();
            if (d < 0) {
                this.f4035h = f4026k;
                return;
            }
            this.f4035h = f4027l;
            System.arraycopy(f4026k, 0, this.f4035h, 0, d + 1);
            System.arraycopy(f4026k, d, this.f4035h, d + 1, f4026k.length - d);
            this.f4035h[d + 1] = f4028m + this.f4035h[d + 1];
        } else if ("en".equals(this.f4033f.getLanguage().toLowerCase())) {
            this.f4035h = CalendarFormatSymbols.m3401a().m3411k();
        } else {
            this.f4035h = new String[12];
            while (i < this.f4035h.length) {
                this.f4035h[i] = NumberPicker.f4254a.m5930a(i + 1);
                i++;
            }
        }
    }

    private void m5737c() {
        char[] dateFormatOrder;
        this.f4029b.removeAllViews();
        if (this.f4036i == null) {
            dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(getContext());
        } else {
            dateFormatOrder = this.f4036i;
        }
        int length = dateFormatOrder.length;
        for (int i = 0; i < length; i++) {
            switch (dateFormatOrder[i]) {
                case 'M':
                    this.f4029b.addView(this.f4031d);
                    m5732a(this.f4031d, length, i);
                    break;
                case 'd':
                    this.f4029b.addView(this.f4030c);
                    m5732a(this.f4030c, length, i);
                    break;
                case 'y':
                    this.f4029b.addView(this.f4032e);
                    m5732a(this.f4032e, length, i);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(this.f4042s.m3380a(1), this.f4042s.m3380a(5), this.f4042s.m3380a(9), this.f4044u, null);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m5730a(savedState.f4020a, savedState.f4021b, savedState.f4022c);
        this.f4044u = savedState.f4023d;
        m5738d();
    }

    public void m5746a(int i, int i2, int i3, OnDateChangedListener onDateChangedListener) {
        m5730a(i, i2, i3);
        m5738d();
        this.f4034g = onDateChangedListener;
    }

    private boolean m5733a(String str, Calendar calendar) {
        try {
            calendar.m3385a(this.f4037n.parse(str).getTime());
            return true;
        } catch (ParseException e) {
            Log.w(f4024a, "Date: " + str + " not in format: " + "MM/dd/yyyy");
            return false;
        }
    }

    private void m5730a(int i, int i2, int i3) {
        this.f4042s.m3384a(i, i2, i3, 0, 0, 0, 0);
        if (this.f4042s.m3397c(this.f4040q)) {
            this.f4042s.m3385a(this.f4040q.m3382a());
        } else if (this.f4042s.m3394b(this.f4041r)) {
            this.f4042s.m3385a(this.f4041r.m3382a());
        }
    }

    private void m5738d() {
        int b;
        if (this.f4044u) {
            this.f4030c.setLabel(null);
            this.f4031d.setLabel(null);
            this.f4032e.setLabel(null);
        } else {
            this.f4030c.setLabel(getContext().getString(C0264R.string.date_picker_label_day));
            this.f4031d.setLabel(getContext().getString(C0264R.string.date_picker_label_month));
            this.f4032e.setLabel(getContext().getString(C0264R.string.date_picker_label_year));
        }
        this.f4030c.setDisplayedValues(null);
        this.f4030c.setMinValue(1);
        NumberPicker numberPicker = this.f4030c;
        if (this.f4044u) {
            b = this.f4042s.m3391b(10);
        } else {
            b = this.f4042s.m3391b(9);
        }
        numberPicker.setMaxValue(b);
        this.f4030c.setWrapSelectorWheel(true);
        this.f4031d.setDisplayedValues(null);
        this.f4031d.setMinValue(0);
        numberPicker = this.f4031d;
        b = this.f4044u ? this.f4042s.m3398d() >= 0 ? 12 : 11 : 11;
        numberPicker.setMaxValue(b);
        this.f4031d.setWrapSelectorWheel(true);
        if (this.f4044u) {
            b = 2;
        } else {
            b = 1;
        }
        if (this.f4042s.m3380a(b) == this.f4040q.m3380a(b)) {
            int i;
            this.f4031d.setMinValue(this.f4044u ? this.f4040q.m3380a(6) : this.f4040q.m3380a(5));
            this.f4031d.setWrapSelectorWheel(false);
            if (this.f4044u) {
                i = 6;
            } else {
                i = 5;
            }
            if (this.f4042s.m3380a(i) == this.f4040q.m3380a(i)) {
                NumberPicker numberPicker2 = this.f4030c;
                if (this.f4044u) {
                    i = this.f4040q.m3380a(10);
                } else {
                    i = this.f4040q.m3380a(9);
                }
                numberPicker2.setMinValue(i);
                this.f4030c.setWrapSelectorWheel(false);
            }
        }
        if (this.f4042s.m3380a(b) == this.f4041r.m3380a(b)) {
            this.f4031d.setMaxValue(this.f4044u ? this.f4040q.m3380a(6) : this.f4041r.m3380a(5));
            this.f4031d.setWrapSelectorWheel(false);
            this.f4031d.setDisplayedValues(null);
            if (this.f4044u) {
                b = 6;
            } else {
                b = 5;
            }
            if (this.f4042s.m3380a(b) == this.f4041r.m3380a(b)) {
                numberPicker = this.f4030c;
                if (this.f4044u) {
                    b = this.f4041r.m3380a(10);
                } else {
                    b = this.f4041r.m3380a(9);
                }
                numberPicker.setMaxValue(b);
                this.f4030c.setWrapSelectorWheel(false);
            }
        }
        this.f4031d.setDisplayedValues((String[]) Arrays.copyOfRange(this.f4035h, this.f4031d.getMinValue(), this.f4035h.length));
        if (this.f4044u) {
            this.f4030c.setDisplayedValues((String[]) Arrays.copyOfRange(f4025j, this.f4030c.getMinValue() - 1, f4025j.length));
        }
        this.f4032e.setMinValue(this.f4040q.m3380a(1));
        this.f4032e.setMaxValue(this.f4041r.m3380a(1));
        this.f4032e.setWrapSelectorWheel(false);
        b = this.f4042s.m3398d();
        boolean z = b >= 0 && (this.f4042s.m3396c() || this.f4042s.m3380a(6) > b);
        this.f4032e.setValue(this.f4044u ? this.f4042s.m3380a(2) : this.f4042s.m3380a(1));
        NumberPicker numberPicker3 = this.f4031d;
        b = this.f4044u ? z ? this.f4042s.m3380a(6) + 1 : this.f4042s.m3380a(6) : this.f4042s.m3380a(5);
        numberPicker3.setValue(b);
        numberPicker3 = this.f4030c;
        if (this.f4044u) {
            b = this.f4042s.m3380a(10);
        } else {
            b = this.f4042s.m3380a(9);
        }
        numberPicker3.setValue(b);
    }

    public int getYear() {
        return this.f4042s.m3380a(this.f4044u ? 2 : 1);
    }

    public int getMonth() {
        return this.f4042s.m3380a(this.f4044u ? 6 : 5);
    }

    public int getDayOfMonth() {
        return this.f4042s.m3380a(this.f4044u ? 10 : 9);
    }

    private void m5741e() {
        sendAccessibilityEvent(4);
        if (this.f4034g != null) {
            this.f4034g.m3273a(this, getYear(), getMonth(), getDayOfMonth(), this.f4044u);
        }
    }

    private void m5732a(NumberPicker numberPicker, int i, int i2) {
        int i3;
        if (i2 < i - 1) {
            i3 = 5;
        } else {
            i3 = 6;
        }
        ((TextView) numberPicker.findViewById(C0264R.id.numberpicker_input)).setImeOptions(i3);
    }

    public void setDateFormatOrder(char[] cArr) {
        this.f4036i = cArr;
        m5737c();
    }
}
