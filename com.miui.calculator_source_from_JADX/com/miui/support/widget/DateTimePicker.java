package com.miui.support.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.miui.support.date.Calendar;
import com.miui.support.date.DateUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AppConstants;
import com.miui.support.widget.NumberPicker.OnValueChangeListener;
import java.util.Locale;

public class DateTimePicker extends LinearLayout {
    private static final DayFormatter f4047g;
    private static final ThreadLocal<Calendar> f4048j;
    private static ThreadLocal<Calendar> f4049p;
    String[] f4050a;
    private NumberPicker f4051b;
    private NumberPicker f4052c;
    private NumberPicker f4053d;
    private String[] f4054e;
    private DayFormatter f4055f;
    private DayFormatter f4056h;
    private OnDateTimeChangedListener f4057i;
    private Calendar f4058k;
    private int f4059l;
    private int f4060m;
    private Calendar f4061n;
    private Calendar f4062o;
    private boolean f4063q;

    public static class DayFormatter {
        public String m5747a(int i, int i2, int i3) {
            Calendar calendar = (Calendar) DateTimePicker.f4049p.get();
            if (calendar == null) {
                calendar = new Calendar();
                DateTimePicker.f4049p.set(calendar);
            }
            calendar.m3383a(1, i);
            calendar.m3383a(5, i2);
            calendar.m3383a(9, i3);
            if (!Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
                return DateUtils.m3428a(calendar.m3382a(), 13696);
            }
            String a = DateUtils.m3428a(calendar.m3382a(), 4480);
            return a.replace(" ", "") + " " + DateUtils.m3428a(calendar.m3382a(), 9216);
        }
    }

    public static class LunarFormatter extends DayFormatter {
        public String m5748a(int i, int i2, int i3) {
            Calendar calendar = (Calendar) DateTimePicker.f4049p.get();
            if (calendar == null) {
                calendar = new Calendar();
                DateTimePicker.f4049p.set(calendar);
            }
            calendar.m3383a(1, i);
            calendar.m3383a(5, i2);
            calendar.m3383a(9, i3);
            return calendar.m3387a(AppConstants.m4227a().getString(C0264R.string.fmt_chinese_date));
        }
    }

    public interface OnDateTimeChangedListener {
        void m5749a(DateTimePicker dateTimePicker, long j);
    }

    private class PickerValueChangeListener implements OnValueChangeListener {
        final /* synthetic */ DateTimePicker f4045a;

        private PickerValueChangeListener(DateTimePicker dateTimePicker) {
            this.f4045a = dateTimePicker;
        }

        public void m5751a(NumberPicker numberPicker, int i, int i2) {
            int i3 = 1;
            if (numberPicker == this.f4045a.f4051b) {
                if (((numberPicker.getValue() - this.f4045a.f4060m) + 7) % 7 != 1) {
                    i3 = -1;
                }
                this.f4045a.f4058k.m3392b(12, i3);
                this.f4045a.f4060m = numberPicker.getValue();
            } else if (numberPicker == this.f4045a.f4052c) {
                this.f4045a.f4058k.m3383a(18, this.f4045a.f4052c.getValue());
            } else if (numberPicker == this.f4045a.f4053d) {
                this.f4045a.f4058k.m3383a(20, this.f4045a.f4059l * this.f4045a.f4053d.getValue());
            }
            this.f4045a.m5765c();
            this.f4045a.m5771f();
            this.f4045a.m5769e();
            this.f4045a.m5767d();
            m5750a(this.f4045a);
        }

        private void m5750a(DateTimePicker dateTimePicker) {
            if (this.f4045a.f4057i != null) {
                this.f4045a.f4057i.m5749a(dateTimePicker, this.f4045a.getTimeInMillis());
            }
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        private long f4046a;

        /* renamed from: com.miui.support.widget.DateTimePicker.SavedState.1 */
        final class C04611 implements Creator<SavedState> {
            C04611() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5752a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5753a(i);
            }

            public SavedState m5752a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m5753a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable, long j) {
            super(parcelable);
            this.f4046a = j;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4046a = parcel.readLong();
        }

        public long m5754a() {
            return this.f4046a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f4046a);
        }

        static {
            CREATOR = new C04611();
        }
    }

    static {
        f4047g = new DayFormatter();
        f4048j = new ThreadLocal();
        f4049p = new ThreadLocal();
    }

    public DateTimePicker(Context context) {
        this(context, null);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.dateTimePickerStyle);
    }

    public DateTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4059l = 1;
        this.f4061n = null;
        this.f4062o = null;
        this.f4050a = null;
        this.f4063q = false;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0264R.layout.datetime_picker, this, true);
        OnValueChangeListener pickerValueChangeListener = new PickerValueChangeListener();
        this.f4058k = new Calendar();
        m5760a(this.f4058k, true);
        Calendar calendar = (Calendar) f4048j.get();
        if (calendar == null) {
            calendar = new Calendar();
            f4048j.set(calendar);
        }
        calendar.m3385a(0);
        this.f4051b = (NumberPicker) findViewById(C0264R.id.day);
        this.f4052c = (NumberPicker) findViewById(C0264R.id.hour);
        this.f4053d = (NumberPicker) findViewById(C0264R.id.minute);
        this.f4051b.setOnValueChangedListener(pickerValueChangeListener);
        this.f4051b.setMaxFlingSpeedFactor(3.0f);
        this.f4052c.setOnValueChangedListener(pickerValueChangeListener);
        this.f4053d.setOnValueChangedListener(pickerValueChangeListener);
        this.f4053d.setMinValue(0);
        this.f4053d.setMaxValue(59);
        this.f4052c.setFormatter(NumberPicker.f4254a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.DateTimePicker, i, 0);
        this.f4063q = obtainStyledAttributes.getBoolean(C0264R.styleable.DateTimePicker_lunarCalendar, false);
        obtainStyledAttributes.recycle();
        m5763b();
        m5765c();
        m5771f();
        m5769e();
        m5767d();
    }

    private void m5760a(Calendar calendar, boolean z) {
        calendar.m3383a(22, 0);
        calendar.m3383a(21, 0);
        int a = calendar.m3380a(20) % this.f4059l;
        if (a == 0) {
            return;
        }
        if (z) {
            calendar.m3392b(20, this.f4059l - a);
        } else {
            calendar.m3392b(20, -a);
        }
    }

    private void m5763b() {
        Object obj = 1;
        Resources resources = getResources();
        Object obj2 = resources.getConfiguration().getLayoutDirection() == 1 ? 1 : null;
        boolean startsWith = resources.getString(C0264R.string.fmt_time_12hour_minute).startsWith("h");
        if ((!startsWith || obj2 == null) && (startsWith || obj2 != null)) {
            obj = null;
        }
        if (obj != null) {
            ViewGroup viewGroup = (ViewGroup) this.f4052c.getParent();
            viewGroup.removeView(this.f4052c);
            viewGroup.addView(this.f4052c, viewGroup.getChildCount());
        }
    }

    private void m5765c() {
        if (this.f4061n != null && this.f4061n.m3382a() > this.f4058k.m3382a()) {
            this.f4058k.m3385a(this.f4061n.m3382a());
        }
        if (this.f4062o != null && this.f4062o.m3382a() < this.f4058k.m3382a()) {
            this.f4058k.m3385a(this.f4062o.m3382a());
        }
    }

    private void m5767d() {
        int a;
        boolean z;
        int i = 0;
        if (this.f4062o != null && m5755a(this.f4058k, this.f4062o) == 0 && this.f4058k.m3380a(18) == this.f4062o.m3380a(18)) {
            a = this.f4062o.m3380a(20);
            this.f4053d.setMinValue(0);
            this.f4053d.setMaxValue(a / this.f4059l);
            this.f4053d.setWrapSelectorWheel(false);
            z = true;
        } else {
            z = false;
        }
        if (this.f4061n != null && m5755a(this.f4058k, this.f4061n) == 0 && this.f4058k.m3380a(18) == this.f4061n.m3380a(18)) {
            this.f4053d.setMinValue(this.f4061n.m3380a(20) / this.f4059l);
            this.f4053d.setWrapSelectorWheel(false);
            z = true;
        }
        if (!z) {
            m5761a(this.f4053d, 0, (60 / this.f4059l) - 1);
            this.f4053d.setMinValue(0);
            this.f4053d.setMaxValue((60 / this.f4059l) - 1);
            this.f4053d.setWrapSelectorWheel(true);
        }
        a = (this.f4053d.getMaxValue() - this.f4053d.getMinValue()) + 1;
        if (this.f4054e == null || this.f4054e.length != a) {
            this.f4054e = new String[a];
            while (i < a) {
                this.f4054e[i] = NumberPicker.f4254a.m5930a((this.f4053d.getMinValue() + i) * this.f4059l);
                i++;
            }
            this.f4053d.setDisplayedValues(this.f4054e);
        }
        this.f4053d.setValue(this.f4058k.m3380a(20) / this.f4059l);
    }

    private void m5769e() {
        boolean z;
        if (this.f4062o == null || m5755a(this.f4058k, this.f4062o) != 0) {
            z = false;
        } else {
            this.f4052c.setMaxValue(this.f4062o.m3380a(18));
            this.f4052c.setWrapSelectorWheel(false);
            z = true;
        }
        if (this.f4061n != null && m5755a(this.f4058k, this.f4061n) == 0) {
            this.f4052c.setMinValue(this.f4061n.m3380a(18));
            this.f4052c.setWrapSelectorWheel(false);
            z = true;
        }
        if (!z) {
            this.f4052c.setMinValue(0);
            this.f4052c.setMaxValue(23);
            this.f4052c.setWrapSelectorWheel(true);
        }
        this.f4052c.setValue(this.f4058k.m3380a(18));
    }

    private int m5755a(Calendar calendar, Calendar calendar2) {
        Calendar calendar3 = (Calendar) calendar.clone();
        Calendar calendar4 = (Calendar) calendar2.clone();
        calendar3.m3383a(18, 0);
        calendar3.m3383a(20, 0);
        calendar3.m3383a(21, 0);
        calendar3.m3383a(22, 0);
        calendar4.m3383a(18, 0);
        calendar4.m3383a(20, 0);
        calendar4.m3383a(21, 0);
        calendar4.m3383a(22, 0);
        return (int) (((((calendar3.m3382a() / 1000) / 60) / 60) / 24) - ((((calendar4.m3382a() / 1000) / 60) / 60) / 24));
    }

    private void m5771f() {
        int a = this.f4061n == null ? Integer.MAX_VALUE : m5755a(this.f4058k, this.f4061n);
        int a2 = this.f4062o == null ? Integer.MAX_VALUE : m5755a(this.f4062o, this.f4058k);
        if (a > 2 || a2 > 2) {
            m5761a(this.f4051b, 0, 6);
            this.f4051b.setMinValue(0);
            this.f4051b.setMaxValue(6);
            if (a <= 2) {
                this.f4051b.setValue(a);
                this.f4060m = a;
                this.f4051b.setWrapSelectorWheel(false);
            }
            if (a2 <= 2) {
                this.f4060m = 6 - a2;
                this.f4051b.setValue(this.f4060m);
                this.f4051b.setWrapSelectorWheel(false);
            }
            if (a > 2 && a2 > 2) {
                this.f4051b.setWrapSelectorWheel(true);
            }
        } else {
            a2 = m5755a(this.f4062o, this.f4061n);
            m5761a(this.f4051b, 0, a2);
            this.f4051b.setMinValue(0);
            this.f4051b.setMaxValue(a2);
            this.f4051b.setValue(a);
            this.f4060m = a;
            this.f4051b.setWrapSelectorWheel(false);
        }
        a = (this.f4051b.getMaxValue() - this.f4051b.getMinValue()) + 1;
        if (this.f4050a == null || this.f4050a.length != a) {
            this.f4050a = new String[a];
        }
        int value = this.f4051b.getValue();
        Calendar calendar = (Calendar) f4048j.get();
        if (calendar == null) {
            calendar = new Calendar();
            f4048j.set(calendar);
        }
        calendar.m3385a(this.f4058k.m3382a());
        this.f4050a[value] = m5758a(calendar.m3380a(1), calendar.m3380a(5), calendar.m3380a(9));
        for (a2 = 1; a2 <= 3; a2++) {
            calendar.m3392b(12, 1);
            int i = (value + a2) % 7;
            if (i >= this.f4050a.length) {
                break;
            }
            this.f4050a[i] = m5758a(calendar.m3380a(1), calendar.m3380a(5), calendar.m3380a(9));
        }
        calendar.m3385a(this.f4058k.m3382a());
        for (a2 = 1; a2 <= 3; a2++) {
            calendar.m3392b(12, -1);
            i = ((value - a2) + 7) % 7;
            if (i >= this.f4050a.length) {
                break;
            }
            this.f4050a[i] = m5758a(calendar.m3380a(1), calendar.m3380a(5), calendar.m3380a(9));
        }
        this.f4051b.setDisplayedValues(this.f4050a);
    }

    private void m5761a(NumberPicker numberPicker, int i, int i2) {
        String[] displayedValues = numberPicker.getDisplayedValues();
        if (displayedValues != null && displayedValues.length < (i2 - i) + 1) {
            numberPicker.setDisplayedValues(null);
        }
    }

    public void setOnTimeChangedListener(OnDateTimeChangedListener onDateTimeChangedListener) {
        this.f4057i = onDateTimeChangedListener;
    }

    public void setMinuteInterval(int i) {
        if (this.f4059l != i) {
            this.f4059l = i;
            m5760a(this.f4058k, true);
            m5765c();
            m5767d();
        }
    }

    public void m5777a(long j) {
        this.f4058k.m3385a(j);
        m5760a(this.f4058k, true);
        m5765c();
        m5771f();
        m5769e();
        m5767d();
    }

    public long getTimeInMillis() {
        return this.f4058k.m3382a();
    }

    public void setMinDateTime(long j) {
        if (j <= 0) {
            this.f4061n = null;
        } else {
            this.f4061n = new Calendar();
            this.f4061n.m3385a(j);
            if (!(this.f4061n.m3380a(21) == 0 && this.f4061n.m3380a(22) == 0)) {
                this.f4061n.m3392b(20, 1);
            }
            m5760a(this.f4061n, true);
            if (this.f4062o != null && this.f4062o.m3382a() < this.f4061n.m3382a()) {
                this.f4061n.m3385a(this.f4062o.m3382a());
            }
        }
        m5765c();
        m5771f();
        m5769e();
        m5767d();
    }

    public void setMaxDateTime(long j) {
        if (j <= 0) {
            this.f4062o = null;
        } else {
            this.f4062o = new Calendar();
            this.f4062o.m3385a(j);
            m5760a(this.f4062o, false);
            if (this.f4061n != null && this.f4061n.m3382a() > this.f4062o.m3382a()) {
                this.f4062o.m3385a(this.f4061n.m3382a());
            }
        }
        m5765c();
        m5771f();
        m5769e();
        m5767d();
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getTimeInMillis());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m5777a(savedState.m5754a());
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        this.f4055f = dayFormatter;
        m5771f();
    }

    public void setLunarMode(boolean z) {
        this.f4063q = z;
        m5771f();
    }

    private String m5758a(int i, int i2, int i3) {
        DayFormatter dayFormatter = f4047g;
        if (this.f4063q) {
            if (this.f4056h == null) {
                this.f4056h = new LunarFormatter();
            }
            dayFormatter = this.f4056h;
        }
        if (this.f4055f != null) {
            dayFormatter = this.f4055f;
        }
        return dayFormatter.m5747a(i, i2, i3);
    }
}
